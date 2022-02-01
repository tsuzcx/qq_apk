package org.apache.commons.io.input;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.ByteOrderMark;

public class XmlStreamReader
  extends Reader
{
  private static final ByteOrderMark[] BOMS = { ByteOrderMark.UTF_8, ByteOrderMark.UTF_16BE, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_32BE, ByteOrderMark.UTF_32LE };
  private static final int BUFFER_SIZE = 4096;
  private static final Pattern CHARSET_PATTERN = Pattern.compile("charset=[\"']?([.[^; \"']]*)[\"']?");
  private static final String EBCDIC = "CP1047";
  public static final Pattern ENCODING_PATTERN = Pattern.compile("<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))", 8);
  private static final String HTTP_EX_1 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL";
  private static final String HTTP_EX_2 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";
  private static final String HTTP_EX_3 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME";
  private static final String RAW_EX_1 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";
  private static final String RAW_EX_2 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";
  private static final String US_ASCII = "US-ASCII";
  private static final String UTF_16 = "UTF-16";
  private static final String UTF_16BE = "UTF-16BE";
  private static final String UTF_16LE = "UTF-16LE";
  private static final String UTF_32 = "UTF-32";
  private static final String UTF_32BE = "UTF-32BE";
  private static final String UTF_32LE = "UTF-32LE";
  private static final String UTF_8 = "UTF-8";
  private static final ByteOrderMark[] XML_GUESS_BYTES = { new ByteOrderMark("UTF-8", new int[] { 60, 63, 120, 109 }), new ByteOrderMark("UTF-16BE", new int[] { 0, 60, 0, 63 }), new ByteOrderMark("UTF-16LE", new int[] { 60, 0, 63, 0 }), new ByteOrderMark("UTF-32BE", new int[] { 0, 0, 0, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109 }), new ByteOrderMark("UTF-32LE", new int[] { 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109, 0, 0, 0 }), new ByteOrderMark("CP1047", new int[] { 76, 111, 167, 148 }) };
  private final String defaultEncoding;
  private final String encoding;
  private final Reader reader;
  
  public XmlStreamReader(File paramFile)
  {
    this(new FileInputStream(paramFile));
  }
  
  public XmlStreamReader(InputStream paramInputStream)
  {
    this(paramInputStream, true);
  }
  
  public XmlStreamReader(InputStream paramInputStream, String paramString)
  {
    this(paramInputStream, paramString, true);
  }
  
  public XmlStreamReader(InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    this(paramInputStream, paramString, paramBoolean, null);
  }
  
  public XmlStreamReader(InputStream paramInputStream, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.defaultEncoding = paramString2;
    paramInputStream = new BOMInputStream(new BufferedInputStream(paramInputStream, 4096), false, BOMS);
    paramString2 = new BOMInputStream(paramInputStream, true, XML_GUESS_BYTES);
    this.encoding = doHttpStream(paramInputStream, paramString2, paramString1, paramBoolean);
    this.reader = new InputStreamReader(paramString2, this.encoding);
  }
  
  public XmlStreamReader(InputStream paramInputStream, boolean paramBoolean)
  {
    this(paramInputStream, paramBoolean, null);
  }
  
  public XmlStreamReader(InputStream paramInputStream, boolean paramBoolean, String paramString)
  {
    this.defaultEncoding = paramString;
    paramInputStream = new BOMInputStream(new BufferedInputStream(paramInputStream, 4096), false, BOMS);
    paramString = new BOMInputStream(paramInputStream, true, XML_GUESS_BYTES);
    this.encoding = doRawStream(paramInputStream, paramString, paramBoolean);
    this.reader = new InputStreamReader(paramString, this.encoding);
  }
  
  public XmlStreamReader(URL paramURL)
  {
    this(paramURL.openConnection(), null);
  }
  
  public XmlStreamReader(URLConnection paramURLConnection, String paramString)
  {
    this.defaultEncoding = paramString;
    paramString = paramURLConnection.getContentType();
    BOMInputStream localBOMInputStream1 = new BOMInputStream(new BufferedInputStream(paramURLConnection.getInputStream(), 4096), false, BOMS);
    BOMInputStream localBOMInputStream2 = new BOMInputStream(localBOMInputStream1, true, XML_GUESS_BYTES);
    if ((!(paramURLConnection instanceof HttpURLConnection)) && (paramString == null)) {
      this.encoding = doRawStream(localBOMInputStream1, localBOMInputStream2, true);
    } else {
      this.encoding = doHttpStream(localBOMInputStream1, localBOMInputStream2, paramString, true);
    }
    this.reader = new InputStreamReader(localBOMInputStream2, this.encoding);
  }
  
  private String doHttpStream(BOMInputStream paramBOMInputStream1, BOMInputStream paramBOMInputStream2, String paramString, boolean paramBoolean)
  {
    paramBOMInputStream1 = paramBOMInputStream1.getBOMCharsetName();
    String str = paramBOMInputStream2.getBOMCharsetName();
    paramBOMInputStream2 = getXmlProlog(paramBOMInputStream2, str);
    try
    {
      paramBOMInputStream1 = calculateHttpEncoding(paramString, paramBOMInputStream1, str, paramBOMInputStream2, paramBoolean);
      return paramBOMInputStream1;
    }
    catch (XmlStreamReaderException paramBOMInputStream1)
    {
      if (paramBoolean) {
        return doLenientDetection(paramString, paramBOMInputStream1);
      }
      throw paramBOMInputStream1;
    }
  }
  
  private String doLenientDetection(String paramString, XmlStreamReaderException paramXmlStreamReaderException)
  {
    Object localObject = paramXmlStreamReaderException;
    if (paramString != null)
    {
      localObject = paramXmlStreamReaderException;
      if (paramString.startsWith("text/html"))
      {
        paramString = paramString.substring(9);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("text/xml");
        ((StringBuilder)localObject).append(paramString);
        paramString = ((StringBuilder)localObject).toString();
        try
        {
          paramString = calculateHttpEncoding(paramString, paramXmlStreamReaderException.getBomEncoding(), paramXmlStreamReaderException.getXmlGuessEncoding(), paramXmlStreamReaderException.getXmlEncoding(), true);
          return paramString;
        }
        catch (XmlStreamReaderException localXmlStreamReaderException) {}
      }
    }
    paramXmlStreamReaderException = localXmlStreamReaderException.getXmlEncoding();
    paramString = paramXmlStreamReaderException;
    if (paramXmlStreamReaderException == null) {
      paramString = localXmlStreamReaderException.getContentTypeEncoding();
    }
    paramXmlStreamReaderException = paramString;
    if (paramString == null)
    {
      paramString = this.defaultEncoding;
      paramXmlStreamReaderException = paramString;
      if (paramString == null) {
        paramXmlStreamReaderException = "UTF-8";
      }
    }
    return paramXmlStreamReaderException;
  }
  
  private String doRawStream(BOMInputStream paramBOMInputStream1, BOMInputStream paramBOMInputStream2, boolean paramBoolean)
  {
    paramBOMInputStream1 = paramBOMInputStream1.getBOMCharsetName();
    String str = paramBOMInputStream2.getBOMCharsetName();
    paramBOMInputStream2 = getXmlProlog(paramBOMInputStream2, str);
    try
    {
      paramBOMInputStream1 = calculateRawEncoding(paramBOMInputStream1, str, paramBOMInputStream2);
      return paramBOMInputStream1;
    }
    catch (XmlStreamReaderException paramBOMInputStream1)
    {
      if (paramBoolean) {
        return doLenientDetection(null, paramBOMInputStream1);
      }
      throw paramBOMInputStream1;
    }
  }
  
  static String getContentTypeEncoding(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      int i = paramString.indexOf(";");
      localObject1 = localObject2;
      if (i > -1)
      {
        paramString = paramString.substring(i + 1);
        paramString = CHARSET_PATTERN.matcher(paramString);
        if (paramString.find()) {
          paramString = paramString.group(1);
        } else {
          paramString = null;
        }
        localObject1 = localObject2;
        if (paramString != null) {
          localObject1 = paramString.toUpperCase(Locale.US);
        }
      }
    }
    return localObject1;
  }
  
  static String getContentTypeMime(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.indexOf(";");
      String str = paramString;
      if (i >= 0) {
        str = paramString.substring(0, i);
      }
      return str.trim();
    }
    return null;
  }
  
  private static String getXmlProlog(InputStream paramInputStream, String paramString)
  {
    if (paramString != null)
    {
      byte[] arrayOfByte = new byte[4096];
      paramInputStream.mark(4096);
      int j = paramInputStream.read(arrayOfByte, 0, 4096);
      Object localObject = "";
      int k = -1;
      int m = 0;
      int i = 4096;
      while ((j != -1) && (k == -1) && (m < 4096))
      {
        m += j;
        i -= j;
        j = paramInputStream.read(arrayOfByte, m, i);
        localObject = new String(arrayOfByte, 0, m, paramString);
        k = ((String)localObject).indexOf('>');
      }
      if (k == -1)
      {
        if (j == -1) {
          throw new IOException("Unexpected end of XML stream");
        }
        paramInputStream = new StringBuilder();
        paramInputStream.append("XML prolog or ROOT element not found on first ");
        paramInputStream.append(m);
        paramInputStream.append(" bytes");
        throw new IOException(paramInputStream.toString());
      }
      if (m > 0)
      {
        paramInputStream.reset();
        paramString = new BufferedReader(new StringReader(((String)localObject).substring(0, k + 1)));
        localObject = new StringBuffer();
        for (paramInputStream = paramString.readLine(); paramInputStream != null; paramInputStream = paramString.readLine()) {
          ((StringBuffer)localObject).append(paramInputStream);
        }
        paramInputStream = ENCODING_PATTERN.matcher((CharSequence)localObject);
        if (paramInputStream.find())
        {
          paramInputStream = paramInputStream.group(1).toUpperCase();
          return paramInputStream.substring(1, paramInputStream.length() - 1);
        }
      }
    }
    return null;
  }
  
  static boolean isAppXml(String paramString)
  {
    return (paramString != null) && ((paramString.equals("application/xml")) || (paramString.equals("application/xml-dtd")) || (paramString.equals("application/xml-external-parsed-entity")) || ((paramString.startsWith("application/")) && (paramString.endsWith("+xml"))));
  }
  
  static boolean isTextXml(String paramString)
  {
    return (paramString != null) && ((paramString.equals("text/xml")) || (paramString.equals("text/xml-external-parsed-entity")) || ((paramString.startsWith("text/")) && (paramString.endsWith("+xml"))));
  }
  
  String calculateHttpEncoding(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramString4 != null)) {
      return paramString4;
    }
    String str = getContentTypeMime(paramString1);
    paramString1 = getContentTypeEncoding(paramString1);
    paramBoolean = isAppXml(str);
    boolean bool = isTextXml(str);
    if ((!paramBoolean) && (!bool)) {
      throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME", new Object[] { str, paramString1, paramString2, paramString3, paramString4 }), str, paramString1, paramString2, paramString3, paramString4);
    }
    if (paramString1 == null)
    {
      if (paramBoolean) {
        return calculateRawEncoding(paramString2, paramString3, paramString4);
      }
      paramString2 = this.defaultEncoding;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "US-ASCII";
      }
      return paramString1;
    }
    if ((!paramString1.equals("UTF-16BE")) && (!paramString1.equals("UTF-16LE")))
    {
      if (paramString1.equals("UTF-16"))
      {
        if ((paramString2 != null) && (paramString2.startsWith("UTF-16"))) {
          return paramString2;
        }
        throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch", new Object[] { str, paramString1, paramString2, paramString3, paramString4 }), str, paramString1, paramString2, paramString3, paramString4);
      }
      if ((!paramString1.equals("UTF-32BE")) && (!paramString1.equals("UTF-32LE")))
      {
        if (paramString1.equals("UTF-32"))
        {
          if ((paramString2 != null) && (paramString2.startsWith("UTF-32"))) {
            return paramString2;
          }
          throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch", new Object[] { str, paramString1, paramString2, paramString3, paramString4 }), str, paramString1, paramString2, paramString3, paramString4);
        }
        return paramString1;
      }
      if (paramString2 == null) {
        return paramString1;
      }
      throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL", new Object[] { str, paramString1, paramString2, paramString3, paramString4 }), str, paramString1, paramString2, paramString3, paramString4);
    }
    if (paramString2 == null) {
      return paramString1;
    }
    throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL", new Object[] { str, paramString1, paramString2, paramString3, paramString4 }), str, paramString1, paramString2, paramString3, paramString4);
  }
  
  String calculateRawEncoding(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null)
    {
      if ((paramString2 != null) && (paramString3 != null))
      {
        if ((paramString3.equals("UTF-16")) && ((paramString2.equals("UTF-16BE")) || (paramString2.equals("UTF-16LE")))) {
          return paramString2;
        }
        return paramString3;
      }
      paramString2 = this.defaultEncoding;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "UTF-8";
      }
      return paramString1;
    }
    if (paramString1.equals("UTF-8"))
    {
      if ((paramString2 != null) && (!paramString2.equals("UTF-8"))) {
        throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 }), paramString1, paramString2, paramString3);
      }
      if (paramString3 != null)
      {
        if (paramString3.equals("UTF-8")) {
          return paramString1;
        }
        throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 }), paramString1, paramString2, paramString3);
      }
      return paramString1;
    }
    if ((!paramString1.equals("UTF-16BE")) && (!paramString1.equals("UTF-16LE")))
    {
      if ((!paramString1.equals("UTF-32BE")) && (!paramString1.equals("UTF-32LE"))) {
        throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM", new Object[] { paramString1, paramString2, paramString3 }), paramString1, paramString2, paramString3);
      }
      if ((paramString2 != null) && (!paramString2.equals(paramString1))) {
        throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 }), paramString1, paramString2, paramString3);
      }
      if ((paramString3 != null) && (!paramString3.equals("UTF-32")))
      {
        if (paramString3.equals(paramString1)) {
          return paramString1;
        }
        throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 }), paramString1, paramString2, paramString3);
      }
      return paramString1;
    }
    if ((paramString2 != null) && (!paramString2.equals(paramString1))) {
      throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 }), paramString1, paramString2, paramString3);
    }
    if ((paramString3 != null) && (!paramString3.equals("UTF-16")))
    {
      if (paramString3.equals(paramString1)) {
        return paramString1;
      }
      throw new XmlStreamReaderException(MessageFormat.format("Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch", new Object[] { paramString1, paramString2, paramString3 }), paramString1, paramString2, paramString3);
    }
    return paramString1;
  }
  
  public void close()
  {
    this.reader.close();
  }
  
  public String getDefaultEncoding()
  {
    return this.defaultEncoding;
  }
  
  public String getEncoding()
  {
    return this.encoding;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return this.reader.read(paramArrayOfChar, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.XmlStreamReader
 * JD-Core Version:    0.7.0.1
 */