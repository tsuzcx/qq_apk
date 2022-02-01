package org.apache.commons.io.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.input.XmlStreamReader;

public class XmlStreamWriter
  extends Writer
{
  private static final int BUFFER_SIZE = 4096;
  static final Pattern ENCODING_PATTERN = XmlStreamReader.ENCODING_PATTERN;
  private final String defaultEncoding;
  private String encoding;
  private final OutputStream out;
  private Writer writer;
  private StringWriter xmlPrologWriter = new StringWriter(4096);
  
  public XmlStreamWriter(File paramFile)
  {
    this(paramFile, null);
  }
  
  public XmlStreamWriter(File paramFile, String paramString)
  {
    this(new FileOutputStream(paramFile), paramString);
  }
  
  public XmlStreamWriter(OutputStream paramOutputStream)
  {
    this(paramOutputStream, null);
  }
  
  public XmlStreamWriter(OutputStream paramOutputStream, String paramString)
  {
    this.out = paramOutputStream;
    if (paramString == null) {
      paramString = "UTF-8";
    }
    this.defaultEncoding = paramString;
  }
  
  private void detectEncoding(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = this.xmlPrologWriter.getBuffer();
    int i;
    if (localStringBuffer.length() + paramInt2 > 4096) {
      i = 4096 - localStringBuffer.length();
    } else {
      i = paramInt2;
    }
    this.xmlPrologWriter.write(paramArrayOfChar, paramInt1, i);
    if (localStringBuffer.length() >= 5)
    {
      if (localStringBuffer.substring(0, 5).equals("<?xml"))
      {
        int j = localStringBuffer.indexOf("?>");
        if (j > 0)
        {
          localObject = ENCODING_PATTERN.matcher(localStringBuffer.substring(0, j));
          if (((Matcher)localObject).find())
          {
            this.encoding = ((Matcher)localObject).group(1).toUpperCase();
            localObject = this.encoding;
            this.encoding = ((String)localObject).substring(1, ((String)localObject).length() - 1);
          }
          else
          {
            this.encoding = this.defaultEncoding;
          }
        }
        else if (localStringBuffer.length() >= 4096)
        {
          this.encoding = this.defaultEncoding;
        }
      }
      else
      {
        this.encoding = this.defaultEncoding;
      }
      Object localObject = this.encoding;
      if (localObject != null)
      {
        this.xmlPrologWriter = null;
        this.writer = new OutputStreamWriter(this.out, (String)localObject);
        this.writer.write(localStringBuffer.toString());
        if (paramInt2 > i) {
          this.writer.write(paramArrayOfChar, paramInt1 + i, paramInt2 - i);
        }
      }
    }
  }
  
  public void close()
  {
    if (this.writer == null)
    {
      this.encoding = this.defaultEncoding;
      this.writer = new OutputStreamWriter(this.out, this.encoding);
      this.writer.write(this.xmlPrologWriter.toString());
    }
    this.writer.close();
  }
  
  public void flush()
  {
    Writer localWriter = this.writer;
    if (localWriter != null) {
      localWriter.flush();
    }
  }
  
  public String getDefaultEncoding()
  {
    return this.defaultEncoding;
  }
  
  public String getEncoding()
  {
    return this.encoding;
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.xmlPrologWriter != null)
    {
      detectEncoding(paramArrayOfChar, paramInt1, paramInt2);
      return;
    }
    this.writer.write(paramArrayOfChar, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.output.XmlStreamWriter
 * JD-Core Version:    0.7.0.1
 */