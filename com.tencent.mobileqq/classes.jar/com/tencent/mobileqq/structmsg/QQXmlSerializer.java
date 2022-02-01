package com.tencent.mobileqq.structmsg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

public class QQXmlSerializer
  implements XmlSerializer
{
  private BufferedWriter a;
  private boolean b;
  private int c;
  private int d;
  private String[] e = new String[12];
  private int[] f = new int[4];
  private String[] g = new String[8];
  private boolean[] h = new boolean[4];
  private boolean i;
  private String j;
  
  private final String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = this.f[(this.d + 1)] * 2 - 2;
    Object localObject;
    String str;
    for (;;)
    {
      localObject = null;
      if (k < 0) {
        break;
      }
      if ((this.g[(k + 1)].equals(paramString)) && ((paramBoolean1) || (this.g[k].length() != 0)))
      {
        str = this.g[k];
        int m = k + 2;
        while (m < this.f[(this.d + 1)] * 2)
        {
          if (this.g[m].equals(str)) {
            break label122;
          }
          m += 1;
        }
        localObject = str;
        label122:
        if (localObject != null) {
          return localObject;
        }
      }
      k -= 2;
    }
    if (!paramBoolean2) {
      return null;
    }
    if (paramString.length() == 0) {
      localObject = "";
    } else {
      do
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("n");
        k = this.c;
        this.c = (k + 1);
        ((StringBuilder)localObject).append(k);
        str = ((StringBuilder)localObject).toString();
        k = this.f[(this.d + 1)] * 2 - 2;
        for (;;)
        {
          localObject = str;
          if (k < 0) {
            break;
          }
          if (str.equals(this.g[k]))
          {
            localObject = null;
            break;
          }
          k -= 2;
        }
      } while (localObject == null);
    }
    paramBoolean1 = this.b;
    this.b = false;
    setPrefix((String)localObject, paramString);
    this.b = paramBoolean1;
    return localObject;
  }
  
  private static void a(char paramChar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Illegal character (");
    localStringBuilder.append(Integer.toHexString(paramChar));
    localStringBuilder.append(")");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private final void a(String paramString, int paramInt)
  {
    int k = 0;
    while (k < paramString.length())
    {
      int m = paramString.charAt(k);
      Object localObject2;
      Object localObject1;
      if ((m != 9) && (m != 10) && (m != 13))
      {
        if (m != 38)
        {
          if (m != 60)
          {
            if (m != 62)
            {
              if (m == paramInt)
              {
                localObject2 = this.a;
                if (m == 34) {
                  localObject1 = "&quot;";
                } else {
                  localObject1 = "&apos;";
                }
                ((BufferedWriter)localObject2).write((String)localObject1);
              }
              else if (((m >= 32) && (m <= 55295)) || (m < 57344) || ((!this.i) && (m >= 127)))
              {
                localObject1 = this.a;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("&#");
                ((StringBuilder)localObject2).append(m);
                ((StringBuilder)localObject2).append(";");
                ((BufferedWriter)localObject1).write(((StringBuilder)localObject2).toString());
              }
              else
              {
                this.a.write(m);
              }
            }
            else {
              this.a.write("&gt;");
            }
          }
          else {
            this.a.write("&lt;");
          }
        }
        else {
          this.a.write("&amp;");
        }
      }
      else if (paramInt == -1)
      {
        this.a.write(m);
      }
      else
      {
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("&#");
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(';');
        ((BufferedWriter)localObject1).write(((StringBuilder)localObject2).toString());
      }
      k += 1;
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (!this.b) {
      return;
    }
    this.d += 1;
    this.b = false;
    Object localObject1 = this.h;
    int k = localObject1.length;
    int m = this.d;
    if (k <= m)
    {
      localObject2 = new boolean[m + 4];
      System.arraycopy(localObject1, 0, localObject2, 0, m);
      this.h = ((boolean[])localObject2);
    }
    localObject1 = this.h;
    k = this.d;
    localObject1[k] = localObject1[(k - 1)];
    k = this.f[(k - 1)];
    for (;;)
    {
      localObject1 = this.f;
      m = this.d;
      if (k >= localObject1[m]) {
        break;
      }
      this.a.write(32);
      this.a.write("xmlns");
      localObject1 = this.g;
      m = k * 2;
      if (localObject1[m].length() != 0)
      {
        this.a.write(58);
        this.a.write(this.g[m]);
      }
      else if ((getNamespace() != null) && (getNamespace().length() == 0) && (this.g[(m + 1)].length() != 0))
      {
        throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
      }
      this.a.write("=\"");
      a(this.g[(m + 1)], 34);
      this.a.write(34);
      k += 1;
    }
    if (localObject1.length <= m + 1)
    {
      localObject2 = new int[m + 8];
      System.arraycopy(localObject1, 0, localObject2, 0, m + 1);
      this.f = ((int[])localObject2);
    }
    localObject1 = this.f;
    k = this.d;
    localObject1[(k + 1)] = localObject1[k];
    Object localObject2 = this.a;
    if (paramBoolean) {
      localObject1 = " />";
    } else {
      localObject1 = ">";
    }
    ((BufferedWriter)localObject2).write((String)localObject1);
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
  {
    if (this.b)
    {
      String str2 = "";
      String str1 = paramString1;
      if (paramString1 == null) {
        str1 = "";
      }
      if (str1.length() == 0) {
        paramString1 = str2;
      } else {
        paramString1 = a(str1, false, true);
      }
      this.a.write(32);
      if (paramString1.length() != 0)
      {
        this.a.write(paramString1);
        this.a.write(58);
      }
      this.a.write(paramString2);
      this.a.write(61);
      int k = 34;
      if (paramString3.indexOf('"') != -1) {
        k = 39;
      }
      this.a.write(k);
      a(paramString3, k);
      this.a.write(k);
      return this;
    }
    throw new IllegalStateException("illegal position for attribute");
  }
  
  public void cdsect(String paramString)
  {
    a(false);
    paramString = paramString.replace("]]>", "]]]]><![CDATA[>").toCharArray();
    int i1 = paramString.length;
    int m = 0;
    while (m < i1)
    {
      int k = paramString[m];
      int n;
      if (((k < 32) || (k > 55295)) && (k != 9) && (k != 10) && (k != 13) && ((k < 57344) || (k > 65533))) {
        n = 0;
      } else {
        n = 1;
      }
      if (n == 0) {
        a(k);
      }
      m += 1;
    }
    this.a.write("<![CDATA[");
    this.a.write(paramString, 0, paramString.length);
    this.a.write("]]>");
  }
  
  public void comment(String paramString)
  {
    a(false);
    this.a.write("<!--");
    this.a.write(paramString);
    this.a.write("-->");
  }
  
  public void docdecl(String paramString)
  {
    this.a.write("<!DOCTYPE");
    this.a.write(paramString);
    this.a.write(">");
  }
  
  public void endDocument()
  {
    for (;;)
    {
      int k = this.d;
      if (k <= 0) {
        break;
      }
      String[] arrayOfString = this.e;
      endTag(arrayOfString[(k * 3 - 3)], arrayOfString[(k * 3 - 1)]);
    }
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
  {
    if (!this.b) {
      this.d -= 1;
    }
    if (((paramString1 != null) || (this.e[(this.d * 3)] == null)) && ((paramString1 == null) || (paramString1.equals(this.e[(this.d * 3)]))) && (this.e[(this.d * 3 + 2)].equals(paramString2)))
    {
      if (this.b)
      {
        a(true);
        this.d -= 1;
      }
      else
      {
        if (this.h[(this.d + 1)] != 0)
        {
          this.a.write("\r\n");
          k = 0;
          while (k < this.d)
          {
            this.a.write("  ");
            k += 1;
          }
        }
        this.a.write("</");
        paramString1 = this.e[(this.d * 3 + 1)];
        if (paramString1.length() != 0)
        {
          this.a.write(paramString1);
          this.a.write(58);
        }
        this.a.write(paramString2);
        this.a.write(62);
      }
      paramString1 = this.f;
      int k = this.d;
      paramString1[(k + 1)] = paramString1[k];
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("</{");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("}");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("> does not match start");
    paramString1 = new IllegalArgumentException(localStringBuilder.toString());
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void entityRef(String paramString)
  {
    a(false);
    this.a.write(38);
    this.a.write(paramString);
    this.a.write(59);
  }
  
  public void flush()
  {
    a(false);
    this.a.flush();
  }
  
  public int getDepth()
  {
    if (this.b) {
      return this.d + 1;
    }
    return this.d;
  }
  
  public boolean getFeature(String paramString)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString)) {
      return this.h[this.d];
    }
    return false;
  }
  
  public String getName()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.e[(getDepth() * 3 - 1)];
  }
  
  public String getNamespace()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.e[(getDepth() * 3 - 3)];
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = a(paramString, false, paramBoolean);
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString.toString());
    }
  }
  
  public Object getProperty(String paramString)
  {
    throw new RuntimeException("Unsupported property");
  }
  
  public void ignorableWhitespace(String paramString)
  {
    text(paramString);
  }
  
  public void processingInstruction(String paramString)
  {
    a(false);
    this.a.write("<?");
    this.a.write(paramString);
    this.a.write("?>");
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString))
    {
      this.h[this.d] = paramBoolean;
      return;
    }
    throw new RuntimeException("Unsupported Feature");
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
  {
    if (paramOutputStream != null)
    {
      if (paramString == null) {
        paramOutputStream = new OutputStreamWriter(paramOutputStream);
      } else {
        paramOutputStream = new OutputStreamWriter(paramOutputStream, paramString);
      }
      setOutput(paramOutputStream);
      this.j = paramString;
      if ((paramString != null) && (paramString.toLowerCase(Locale.US).startsWith("utf"))) {
        this.i = true;
      }
      return;
    }
    throw new IllegalArgumentException("os == null");
  }
  
  public void setOutput(Writer paramWriter)
  {
    if ((paramWriter instanceof BufferedWriter)) {
      this.a = ((BufferedWriter)paramWriter);
    } else {
      this.a = new BufferedWriter(paramWriter, 500);
    }
    paramWriter = this.f;
    paramWriter[0] = 2;
    paramWriter[1] = 2;
    paramWriter = this.g;
    paramWriter[0] = "";
    paramWriter[1] = "";
    paramWriter[2] = "xml";
    paramWriter[3] = "https://www.w3.org/XML/1998/namespace";
    this.b = false;
    this.c = 0;
    this.d = 0;
    this.i = false;
  }
  
  public void setPrefix(String paramString1, String paramString2)
  {
    a(false);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (str.equals(a(paramString1, true, false))) {
      return;
    }
    paramString2 = this.f;
    int k = this.d + 1;
    int m = paramString2[k];
    paramString2[k] = (m + 1);
    k = m << 1;
    paramString2 = this.g;
    m = paramString2.length;
    int n = k + 1;
    if (m < n)
    {
      String[] arrayOfString = new String[paramString2.length + 16];
      System.arraycopy(paramString2, 0, arrayOfString, 0, k);
      this.g = arrayOfString;
    }
    paramString2 = this.g;
    paramString2[k] = str;
    paramString2[n] = paramString1;
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    paramString = new StringBuilder();
    paramString.append("Unsupported Property:");
    paramString.append(paramObject);
    throw new RuntimeException(paramString.toString());
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
  {
    this.a.write("<?xml version='1.0' ");
    if (paramString != null)
    {
      this.j = paramString;
      if (paramString.toLowerCase(Locale.US).startsWith("utf")) {
        this.i = true;
      }
    }
    if (this.j != null)
    {
      this.a.write("encoding='");
      this.a.write(this.j);
      this.a.write("' ");
    }
    if (paramBoolean != null)
    {
      this.a.write("standalone='");
      BufferedWriter localBufferedWriter = this.a;
      if (paramBoolean.booleanValue()) {
        paramString = "yes";
      } else {
        paramString = "no";
      }
      localBufferedWriter.write(paramString);
      this.a.write("' ");
    }
    this.a.write("?>");
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
  {
    a(false);
    if (this.h[this.d] != 0)
    {
      this.a.write("\r\n");
      k = 0;
      while (k < this.d)
      {
        this.a.write("  ");
        k += 1;
      }
    }
    int m = this.d * 3;
    Object localObject = this.e;
    if (localObject.length < m + 3)
    {
      arrayOfString = new String[localObject.length + 12];
      System.arraycopy(localObject, 0, arrayOfString, 0, m);
      this.e = arrayOfString;
    }
    if (paramString1 == null) {
      localObject = "";
    } else {
      localObject = a(paramString1, true, true);
    }
    if ((paramString1 != null) && (paramString1.length() == 0))
    {
      k = this.f[this.d];
      while (k < this.f[(this.d + 1)])
      {
        arrayOfString = this.g;
        int n = k * 2;
        if ((arrayOfString[n].length() == 0) && (this.g[(n + 1)].length() != 0)) {
          throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
        }
        k += 1;
      }
    }
    String[] arrayOfString = this.e;
    int k = m + 1;
    arrayOfString[m] = paramString1;
    arrayOfString[k] = localObject;
    arrayOfString[(k + 1)] = paramString2;
    this.a.write(60);
    if (((String)localObject).length() != 0)
    {
      this.a.write((String)localObject);
      this.a.write(58);
    }
    this.a.write(paramString2);
    this.b = true;
    return this;
  }
  
  public XmlSerializer text(String paramString)
  {
    a(false);
    this.h[this.d] = false;
    a(paramString, -1);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    text(new String(paramArrayOfChar, paramInt1, paramInt2));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.QQXmlSerializer
 * JD-Core Version:    0.7.0.1
 */