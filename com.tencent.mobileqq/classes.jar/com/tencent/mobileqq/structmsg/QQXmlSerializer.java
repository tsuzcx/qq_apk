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
  private int jdField_a_of_type_Int;
  private BufferedWriter jdField_a_of_type_JavaIoBufferedWriter;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[4];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[12];
  private boolean[] jdField_a_of_type_ArrayOfBoolean = new boolean[4];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private String[] jdField_b_of_type_ArrayOfJavaLangString = new String[8];
  
  private final String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int + 1)] * 2 - 2;
    Object localObject;
    String str;
    for (;;)
    {
      localObject = null;
      if (i < 0) {
        break;
      }
      if ((this.jdField_b_of_type_ArrayOfJavaLangString[(i + 1)].equals(paramString)) && ((paramBoolean1) || (this.jdField_b_of_type_ArrayOfJavaLangString[i].length() != 0)))
      {
        str = this.jdField_b_of_type_ArrayOfJavaLangString[i];
        int j = i + 2;
        while (j < this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int + 1)] * 2)
        {
          if (this.jdField_b_of_type_ArrayOfJavaLangString[j].equals(str)) {
            break label122;
          }
          j += 1;
        }
        localObject = str;
        label122:
        if (localObject != null) {
          return localObject;
        }
      }
      i -= 2;
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
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = (i + 1);
        ((StringBuilder)localObject).append(i);
        str = ((StringBuilder)localObject).toString();
        i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int + 1)] * 2 - 2;
        for (;;)
        {
          localObject = str;
          if (i < 0) {
            break;
          }
          if (str.equals(this.jdField_b_of_type_ArrayOfJavaLangString[i]))
          {
            localObject = null;
            break;
          }
          i -= 2;
        }
      } while (localObject == null);
    }
    paramBoolean1 = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Boolean = false;
    setPrefix((String)localObject, paramString);
    this.jdField_a_of_type_Boolean = paramBoolean1;
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
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      Object localObject2;
      Object localObject1;
      if ((j != 9) && (j != 10) && (j != 13))
      {
        if (j != 38)
        {
          if (j != 60)
          {
            if (j != 62)
            {
              if (j == paramInt)
              {
                localObject2 = this.jdField_a_of_type_JavaIoBufferedWriter;
                if (j == 34) {
                  localObject1 = "&quot;";
                } else {
                  localObject1 = "&apos;";
                }
                ((BufferedWriter)localObject2).write((String)localObject1);
              }
              else if (((j >= 32) && (j <= 55295)) || (j < 57344) || ((!this.jdField_b_of_type_Boolean) && (j >= 127)))
              {
                localObject1 = this.jdField_a_of_type_JavaIoBufferedWriter;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("&#");
                ((StringBuilder)localObject2).append(j);
                ((StringBuilder)localObject2).append(";");
                ((BufferedWriter)localObject1).write(((StringBuilder)localObject2).toString());
              }
              else
              {
                this.jdField_a_of_type_JavaIoBufferedWriter.write(j);
              }
            }
            else {
              this.jdField_a_of_type_JavaIoBufferedWriter.write("&gt;");
            }
          }
          else {
            this.jdField_a_of_type_JavaIoBufferedWriter.write("&lt;");
          }
        }
        else {
          this.jdField_a_of_type_JavaIoBufferedWriter.write("&amp;");
        }
      }
      else if (paramInt == -1)
      {
        this.jdField_a_of_type_JavaIoBufferedWriter.write(j);
      }
      else
      {
        localObject1 = this.jdField_a_of_type_JavaIoBufferedWriter;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("&#");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(';');
        ((BufferedWriter)localObject1).write(((StringBuilder)localObject2).toString());
      }
      i += 1;
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Int += 1;
    this.jdField_a_of_type_Boolean = false;
    Object localObject1 = this.jdField_a_of_type_ArrayOfBoolean;
    int i = localObject1.length;
    int j = this.jdField_b_of_type_Int;
    if (i <= j)
    {
      localObject2 = new boolean[j + 4];
      System.arraycopy(localObject1, 0, localObject2, 0, j);
      this.jdField_a_of_type_ArrayOfBoolean = ((boolean[])localObject2);
    }
    localObject1 = this.jdField_a_of_type_ArrayOfBoolean;
    i = this.jdField_b_of_type_Int;
    localObject1[i] = localObject1[(i - 1)];
    i = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfInt;
      j = this.jdField_b_of_type_Int;
      if (i >= localObject1[j]) {
        break;
      }
      this.jdField_a_of_type_JavaIoBufferedWriter.write(32);
      this.jdField_a_of_type_JavaIoBufferedWriter.write("xmlns");
      localObject1 = this.jdField_b_of_type_ArrayOfJavaLangString;
      j = i * 2;
      if (localObject1[j].length() != 0)
      {
        this.jdField_a_of_type_JavaIoBufferedWriter.write(58);
        this.jdField_a_of_type_JavaIoBufferedWriter.write(this.jdField_b_of_type_ArrayOfJavaLangString[j]);
      }
      else if ((getNamespace() != null) && (getNamespace().length() == 0) && (this.jdField_b_of_type_ArrayOfJavaLangString[(j + 1)].length() != 0))
      {
        throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
      }
      this.jdField_a_of_type_JavaIoBufferedWriter.write("=\"");
      a(this.jdField_b_of_type_ArrayOfJavaLangString[(j + 1)], 34);
      this.jdField_a_of_type_JavaIoBufferedWriter.write(34);
      i += 1;
    }
    if (localObject1.length <= j + 1)
    {
      localObject2 = new int[j + 8];
      System.arraycopy(localObject1, 0, localObject2, 0, j + 1);
      this.jdField_a_of_type_ArrayOfInt = ((int[])localObject2);
    }
    localObject1 = this.jdField_a_of_type_ArrayOfInt;
    i = this.jdField_b_of_type_Int;
    localObject1[(i + 1)] = localObject1[i];
    Object localObject2 = this.jdField_a_of_type_JavaIoBufferedWriter;
    if (paramBoolean) {
      localObject1 = " />";
    } else {
      localObject1 = ">";
    }
    ((BufferedWriter)localObject2).write((String)localObject1);
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_Boolean)
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
      this.jdField_a_of_type_JavaIoBufferedWriter.write(32);
      if (paramString1.length() != 0)
      {
        this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString1);
        this.jdField_a_of_type_JavaIoBufferedWriter.write(58);
      }
      this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString2);
      this.jdField_a_of_type_JavaIoBufferedWriter.write(61);
      int i = 34;
      if (paramString3.indexOf('"') != -1) {
        i = 39;
      }
      this.jdField_a_of_type_JavaIoBufferedWriter.write(i);
      a(paramString3, i);
      this.jdField_a_of_type_JavaIoBufferedWriter.write(i);
      return this;
    }
    throw new IllegalStateException("illegal position for attribute");
  }
  
  public void cdsect(String paramString)
  {
    a(false);
    paramString = paramString.replace("]]>", "]]]]><![CDATA[>").toCharArray();
    int m = paramString.length;
    int j = 0;
    while (j < m)
    {
      int i = paramString[j];
      int k;
      if (((i < 32) || (i > 55295)) && (i != 9) && (i != 10) && (i != 13) && ((i < 57344) || (i > 65533))) {
        k = 0;
      } else {
        k = 1;
      }
      if (k == 0) {
        a(i);
      }
      j += 1;
    }
    this.jdField_a_of_type_JavaIoBufferedWriter.write("<![CDATA[");
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString, 0, paramString.length);
    this.jdField_a_of_type_JavaIoBufferedWriter.write("]]>");
  }
  
  public void comment(String paramString)
  {
    a(false);
    this.jdField_a_of_type_JavaIoBufferedWriter.write("<!--");
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString);
    this.jdField_a_of_type_JavaIoBufferedWriter.write("-->");
  }
  
  public void docdecl(String paramString)
  {
    this.jdField_a_of_type_JavaIoBufferedWriter.write("<!DOCTYPE");
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString);
    this.jdField_a_of_type_JavaIoBufferedWriter.write(">");
  }
  
  public void endDocument()
  {
    for (;;)
    {
      int i = this.jdField_b_of_type_Int;
      if (i <= 0) {
        break;
      }
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      endTag(arrayOfString[(i * 3 - 3)], arrayOfString[(i * 3 - 1)]);
    }
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_Int -= 1;
    }
    if (((paramString1 != null) || (this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_b_of_type_Int * 3)] == null)) && ((paramString1 == null) || (paramString1.equals(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_b_of_type_Int * 3)]))) && (this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_b_of_type_Int * 3 + 2)].equals(paramString2)))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        a(true);
        this.jdField_b_of_type_Int -= 1;
      }
      else
      {
        if (this.jdField_a_of_type_ArrayOfBoolean[(this.jdField_b_of_type_Int + 1)] != 0)
        {
          this.jdField_a_of_type_JavaIoBufferedWriter.write("\r\n");
          i = 0;
          while (i < this.jdField_b_of_type_Int)
          {
            this.jdField_a_of_type_JavaIoBufferedWriter.write("  ");
            i += 1;
          }
        }
        this.jdField_a_of_type_JavaIoBufferedWriter.write("</");
        paramString1 = this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_b_of_type_Int * 3 + 1)];
        if (paramString1.length() != 0)
        {
          this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString1);
          this.jdField_a_of_type_JavaIoBufferedWriter.write(58);
        }
        this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString2);
        this.jdField_a_of_type_JavaIoBufferedWriter.write(62);
      }
      paramString1 = this.jdField_a_of_type_ArrayOfInt;
      int i = this.jdField_b_of_type_Int;
      paramString1[(i + 1)] = paramString1[i];
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
    this.jdField_a_of_type_JavaIoBufferedWriter.write(38);
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString);
    this.jdField_a_of_type_JavaIoBufferedWriter.write(59);
  }
  
  public void flush()
  {
    a(false);
    this.jdField_a_of_type_JavaIoBufferedWriter.flush();
  }
  
  public int getDepth()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_b_of_type_Int + 1;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public boolean getFeature(String paramString)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString)) {
      return this.jdField_a_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int];
    }
    return false;
  }
  
  public String getName()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfJavaLangString[(getDepth() * 3 - 1)];
  }
  
  public String getNamespace()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfJavaLangString[(getDepth() * 3 - 3)];
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
    this.jdField_a_of_type_JavaIoBufferedWriter.write("<?");
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString);
    this.jdField_a_of_type_JavaIoBufferedWriter.write("?>");
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString))
    {
      this.jdField_a_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int] = paramBoolean;
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
      this.jdField_a_of_type_JavaLangString = paramString;
      if ((paramString != null) && (paramString.toLowerCase(Locale.US).startsWith("utf"))) {
        this.jdField_b_of_type_Boolean = true;
      }
      return;
    }
    throw new IllegalArgumentException("os == null");
  }
  
  public void setOutput(Writer paramWriter)
  {
    if ((paramWriter instanceof BufferedWriter)) {
      this.jdField_a_of_type_JavaIoBufferedWriter = ((BufferedWriter)paramWriter);
    } else {
      this.jdField_a_of_type_JavaIoBufferedWriter = new BufferedWriter(paramWriter, 500);
    }
    paramWriter = this.jdField_a_of_type_ArrayOfInt;
    paramWriter[0] = 2;
    paramWriter[1] = 2;
    paramWriter = this.jdField_b_of_type_ArrayOfJavaLangString;
    paramWriter[0] = "";
    paramWriter[1] = "";
    paramWriter[2] = "xml";
    paramWriter[3] = "https://www.w3.org/XML/1998/namespace";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
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
    paramString2 = this.jdField_a_of_type_ArrayOfInt;
    int i = this.jdField_b_of_type_Int + 1;
    int j = paramString2[i];
    paramString2[i] = (j + 1);
    i = j << 1;
    paramString2 = this.jdField_b_of_type_ArrayOfJavaLangString;
    j = paramString2.length;
    int k = i + 1;
    if (j < k)
    {
      String[] arrayOfString = new String[paramString2.length + 16];
      System.arraycopy(paramString2, 0, arrayOfString, 0, i);
      this.jdField_b_of_type_ArrayOfJavaLangString = arrayOfString;
    }
    paramString2 = this.jdField_b_of_type_ArrayOfJavaLangString;
    paramString2[i] = str;
    paramString2[k] = paramString1;
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
    this.jdField_a_of_type_JavaIoBufferedWriter.write("<?xml version='1.0' ");
    if (paramString != null)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      if (paramString.toLowerCase(Locale.US).startsWith("utf")) {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      this.jdField_a_of_type_JavaIoBufferedWriter.write("encoding='");
      this.jdField_a_of_type_JavaIoBufferedWriter.write(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaIoBufferedWriter.write("' ");
    }
    if (paramBoolean != null)
    {
      this.jdField_a_of_type_JavaIoBufferedWriter.write("standalone='");
      BufferedWriter localBufferedWriter = this.jdField_a_of_type_JavaIoBufferedWriter;
      if (paramBoolean.booleanValue()) {
        paramString = "yes";
      } else {
        paramString = "no";
      }
      localBufferedWriter.write(paramString);
      this.jdField_a_of_type_JavaIoBufferedWriter.write("' ");
    }
    this.jdField_a_of_type_JavaIoBufferedWriter.write("?>");
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
  {
    a(false);
    if (this.jdField_a_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int] != 0)
    {
      this.jdField_a_of_type_JavaIoBufferedWriter.write("\r\n");
      i = 0;
      while (i < this.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_JavaIoBufferedWriter.write("  ");
        i += 1;
      }
    }
    int j = this.jdField_b_of_type_Int * 3;
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (localObject.length < j + 3)
    {
      arrayOfString = new String[localObject.length + 12];
      System.arraycopy(localObject, 0, arrayOfString, 0, j);
      this.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString;
    }
    if (paramString1 == null) {
      localObject = "";
    } else {
      localObject = a(paramString1, true, true);
    }
    if ((paramString1 != null) && (paramString1.length() == 0))
    {
      i = this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int];
      while (i < this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int + 1)])
      {
        arrayOfString = this.jdField_b_of_type_ArrayOfJavaLangString;
        int k = i * 2;
        if ((arrayOfString[k].length() == 0) && (this.jdField_b_of_type_ArrayOfJavaLangString[(k + 1)].length() != 0)) {
          throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
        }
        i += 1;
      }
    }
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int i = j + 1;
    arrayOfString[j] = paramString1;
    arrayOfString[i] = localObject;
    arrayOfString[(i + 1)] = paramString2;
    this.jdField_a_of_type_JavaIoBufferedWriter.write(60);
    if (((String)localObject).length() != 0)
    {
      this.jdField_a_of_type_JavaIoBufferedWriter.write((String)localObject);
      this.jdField_a_of_type_JavaIoBufferedWriter.write(58);
    }
    this.jdField_a_of_type_JavaIoBufferedWriter.write(paramString2);
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public XmlSerializer text(String paramString)
  {
    a(false);
    this.jdField_a_of_type_ArrayOfBoolean[this.jdField_b_of_type_Int] = false;
    a(paramString, -1);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    text(new String(paramArrayOfChar, paramInt1, paramInt2));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.QQXmlSerializer
 * JD-Core Version:    0.7.0.1
 */