package com.tencent.theme;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.xmlpull.v1.XmlPullParserException;

public class AndroidXmlResourceParser
  implements XmlResourceParser
{
  private static final int A = 1048834;
  private static final int B = 1048835;
  private static final int C = 1048836;
  private static final int D = 1048836;
  private static final String o = "Method is not supported.";
  private static final int p = 0;
  private static final int q = 1;
  private static final int r = 2;
  private static final int s = 3;
  private static final int t = 4;
  private static final int u = 5;
  private static final int v = 524291;
  private static final int w = 524672;
  private static final int x = 1048832;
  private static final int y = 1048832;
  private static final int z = 1048833;
  private ByteBuffer a;
  private boolean b = false;
  private i c;
  private int[] d;
  private AndroidXmlResourceParser.a e = new AndroidXmlResourceParser.a();
  private boolean f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int[] k;
  private int l;
  private int m;
  private int n;
  
  public AndroidXmlResourceParser()
  {
    b();
  }
  
  private final int a(int paramInt)
  {
    if (this.g == 2)
    {
      int i1 = paramInt * 5;
      if (i1 < this.k.length) {
        return i1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid attribute index (");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(").");
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    throw new IndexOutOfBoundsException("Current event is not START_TAG.");
  }
  
  private final int a(String paramString1, String paramString2)
  {
    i locali = this.c;
    if (locali != null)
    {
      if (paramString2 == null) {
        return -1;
      }
      int i4 = locali.a(paramString2);
      if (i4 == -1) {
        return -1;
      }
      int i1;
      if (paramString1 != null) {
        i1 = this.c.a(paramString1);
      } else {
        i1 = -1;
      }
      int i3;
      for (int i2 = 0;; i2 = i3)
      {
        paramString1 = this.k;
        if (i2 == paramString1.length) {
          break;
        }
        i3 = i2 + 1;
        if ((i4 == paramString1[i3]) && ((i1 == -1) || (i1 == paramString1[(i2 + 0)]))) {
          return i2 / 5;
        }
      }
    }
    return -1;
  }
  
  private final void b()
  {
    this.g = -1;
    this.h = -1;
    this.i = -1;
    this.j = -1;
    this.k = null;
    this.l = -1;
    this.m = -1;
    this.n = -1;
  }
  
  private final void c()
  {
    if (this.c == null)
    {
      a.a(this.a, 524291);
      a.b(this.a, 4);
      this.c = i.a(this.a);
      this.e.f();
      this.b = true;
    }
    int i3 = this.g;
    if (i3 == 1) {
      return;
    }
    b();
    int i1;
    for (;;)
    {
      if (this.f)
      {
        this.f = false;
        this.e.g();
      }
      int i2 = 3;
      if ((i3 == 3) && (this.e.e() == 1) && (this.e.c() == 0))
      {
        this.g = 1;
        return;
      }
      if (i3 == 0) {
        i1 = 1048834;
      } else {
        i1 = this.a.getInt();
      }
      if (i1 == 524672)
      {
        i1 = this.a.getInt();
        if ((i1 >= 8) && (i1 % 4 == 0))
        {
          this.d = a.c(this.a, i1 / 4 - 2);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Invalid resource ids size (");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(").");
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        if ((i1 < 1048832) || (i1 > 1048836)) {
          break;
        }
        if ((i1 == 1048834) && (i3 == -1))
        {
          this.g = 0;
          return;
        }
        a.b(this.a, 4);
        int i4 = this.a.getInt();
        a.b(this.a, 4);
        if ((i1 != 1048832) && (i1 != 1048833))
        {
          this.h = i4;
          if (i1 == 1048834)
          {
            this.j = this.a.getInt();
            this.i = this.a.getInt();
            a.b(this.a, 4);
            i1 = this.a.getInt();
            this.l = ((i1 >>> 16) - 1);
            this.m = this.a.getInt();
            i3 = this.m;
            this.n = ((i3 >>> 16) - 1);
            this.m = ((0xFFFF & i3) - 1);
            this.k = a.c(this.a, (i1 & 0xFFFF) * 5);
            i1 = i2;
            for (;;)
            {
              localObject = this.k;
              if (i1 >= localObject.length) {
                break;
              }
              localObject[i1] >>>= 24;
              i1 += 5;
            }
            this.e.f();
            this.g = 2;
            return;
          }
          if (i1 == 1048835)
          {
            this.j = this.a.getInt();
            this.i = this.a.getInt();
            this.g = 3;
            this.f = true;
            return;
          }
          if (i1 == 1048836)
          {
            this.i = this.a.getInt();
            a.b(this.a, 4);
            a.b(this.a, 4);
            this.g = 4;
          }
        }
        else if (i1 == 1048832)
        {
          i1 = this.a.getInt();
          i2 = this.a.getInt();
          this.e.a(i1, i2);
        }
        else
        {
          a.b(this.a, 4);
          a.b(this.a, 4);
          this.e.d();
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Invalid chunk type (");
    ((StringBuilder)localObject).append(i1);
    ((StringBuilder)localObject).append(").");
    localObject = new IOException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  final i a()
  {
    return this.c;
  }
  
  public void close()
  {
    if (!this.b) {
      return;
    }
    this.b = false;
    this.a = null;
    this.c = null;
    this.d = null;
    this.e.a();
    b();
  }
  
  public void defineEntityReplacementText(String paramString1, String paramString2)
  {
    throw new XmlPullParserException("Method is not supported.");
  }
  
  public boolean getAttributeBooleanValue(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean getAttributeBooleanValue(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i1 = a(paramString1, paramString2);
    if (i1 == -1) {
      return paramBoolean;
    }
    return getAttributeBooleanValue(i1, paramBoolean);
  }
  
  public int getAttributeCount()
  {
    if (this.g != 2) {
      return -1;
    }
    return this.k.length / 5;
  }
  
  public float getAttributeFloatValue(int paramInt, float paramFloat)
  {
    paramInt = a(paramInt);
    int[] arrayOfInt = this.k;
    if (arrayOfInt[(paramInt + 3)] == 4) {
      return Float.intBitsToFloat(arrayOfInt[(paramInt + 4)]);
    }
    return paramFloat;
  }
  
  public float getAttributeFloatValue(String paramString1, String paramString2, float paramFloat)
  {
    int i1 = a(paramString1, paramString2);
    if (i1 == -1) {
      return paramFloat;
    }
    return getAttributeFloatValue(i1, paramFloat);
  }
  
  public int getAttributeIntValue(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1);
    int[] arrayOfInt = this.k;
    int i1 = arrayOfInt[(paramInt1 + 3)];
    if ((i1 >= 16) && (i1 <= 31)) {
      return arrayOfInt[(paramInt1 + 4)];
    }
    return paramInt2;
  }
  
  public int getAttributeIntValue(String paramString1, String paramString2, int paramInt)
  {
    int i1 = a(paramString1, paramString2);
    if (i1 == -1) {
      return paramInt;
    }
    return getAttributeIntValue(i1, paramInt);
  }
  
  public int getAttributeListValue(int paramInt1, String[] paramArrayOfString, int paramInt2)
  {
    return 0;
  }
  
  public int getAttributeListValue(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    return 0;
  }
  
  public String getAttributeName(int paramInt)
  {
    paramInt = a(paramInt);
    paramInt = this.k[(paramInt + 1)];
    if (paramInt == -1) {
      return "";
    }
    return this.c.a(paramInt);
  }
  
  public int getAttributeNameResource(int paramInt)
  {
    paramInt = a(paramInt);
    paramInt = this.k[(paramInt + 1)];
    int[] arrayOfInt = this.d;
    if ((arrayOfInt != null) && (paramInt >= 0) && (paramInt < arrayOfInt.length)) {
      return arrayOfInt[paramInt];
    }
    return 0;
  }
  
  public String getAttributeNamespace(int paramInt)
  {
    paramInt = a(paramInt);
    paramInt = this.k[(paramInt + 0)];
    if (paramInt == -1) {
      return "";
    }
    return this.c.a(paramInt);
  }
  
  public String getAttributePrefix(int paramInt)
  {
    paramInt = a(paramInt);
    paramInt = this.k[(paramInt + 0)];
    paramInt = this.e.d(paramInt);
    if (paramInt == -1) {
      return "";
    }
    return this.c.a(paramInt);
  }
  
  public int getAttributeResourceValue(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1);
    int[] arrayOfInt = this.k;
    if (arrayOfInt[(paramInt1 + 3)] == 1) {
      return arrayOfInt[(paramInt1 + 4)];
    }
    return paramInt2;
  }
  
  public int getAttributeResourceValue(String paramString1, String paramString2, int paramInt)
  {
    int i1 = a(paramString1, paramString2);
    if (i1 == -1) {
      return paramInt;
    }
    return getAttributeResourceValue(i1, paramInt);
  }
  
  public String getAttributeType(int paramInt)
  {
    return "CDATA";
  }
  
  public int getAttributeUnsignedIntValue(int paramInt1, int paramInt2)
  {
    return getAttributeIntValue(paramInt1, paramInt2);
  }
  
  public int getAttributeUnsignedIntValue(String paramString1, String paramString2, int paramInt)
  {
    int i1 = a(paramString1, paramString2);
    if (i1 == -1) {
      return paramInt;
    }
    return getAttributeUnsignedIntValue(i1, paramInt);
  }
  
  public String getAttributeValue(int paramInt)
  {
    paramInt = a(paramInt);
    int[] arrayOfInt = this.k;
    if (arrayOfInt[(paramInt + 3)] == 3)
    {
      paramInt = arrayOfInt[(paramInt + 2)];
      return this.c.a(paramInt);
    }
    paramInt = arrayOfInt[(paramInt + 4)];
    return "";
  }
  
  public String getAttributeValue(String paramString1, String paramString2)
  {
    int i1 = a(paramString1, paramString2);
    if (i1 == -1) {
      return null;
    }
    return getAttributeValue(i1);
  }
  
  public int getAttributeValueData(int paramInt)
  {
    paramInt = a(paramInt);
    return this.k[(paramInt + 4)];
  }
  
  public int getAttributeValueType(int paramInt)
  {
    paramInt = a(paramInt);
    return this.k[(paramInt + 3)];
  }
  
  public String getClassAttribute()
  {
    int i1 = this.m;
    if (i1 == -1) {
      return null;
    }
    i1 = a(i1);
    i1 = this.k[(i1 + 2)];
    return this.c.a(i1);
  }
  
  public int getColumnNumber()
  {
    return -1;
  }
  
  public int getDepth()
  {
    return this.e.e() - 1;
  }
  
  public int getEventType()
  {
    return this.g;
  }
  
  public boolean getFeature(String paramString)
  {
    return false;
  }
  
  public String getIdAttribute()
  {
    int i1 = this.l;
    if (i1 == -1) {
      return null;
    }
    i1 = a(i1);
    i1 = this.k[(i1 + 2)];
    return this.c.a(i1);
  }
  
  public int getIdAttributeResourceValue(int paramInt)
  {
    int i1 = this.l;
    if (i1 == -1) {
      return paramInt;
    }
    i1 = a(i1);
    int[] arrayOfInt = this.k;
    if (arrayOfInt[(i1 + 3)] != 1) {
      return paramInt;
    }
    return arrayOfInt[(i1 + 4)];
  }
  
  public String getInputEncoding()
  {
    return null;
  }
  
  public int getLineNumber()
  {
    return this.h;
  }
  
  public String getName()
  {
    if (this.i != -1)
    {
      int i1 = this.g;
      if ((i1 == 2) || (i1 == 3)) {
        return this.c.a(this.i);
      }
    }
    return null;
  }
  
  public String getNamespace()
  {
    return this.c.a(this.j);
  }
  
  public String getNamespace(String paramString)
  {
    throw new RuntimeException("Method is not supported.");
  }
  
  public int getNamespaceCount(int paramInt)
  {
    return this.e.a(paramInt);
  }
  
  public String getNamespacePrefix(int paramInt)
  {
    paramInt = this.e.b(paramInt);
    return this.c.a(paramInt);
  }
  
  public String getNamespaceUri(int paramInt)
  {
    paramInt = this.e.c(paramInt);
    return this.c.a(paramInt);
  }
  
  public String getPositionDescription()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XML line #");
    localStringBuilder.append(getLineNumber());
    return localStringBuilder.toString();
  }
  
  public String getPrefix()
  {
    int i1 = this.e.d(this.j);
    return this.c.a(i1);
  }
  
  public Object getProperty(String paramString)
  {
    return null;
  }
  
  public int getStyleAttribute()
  {
    int i1 = this.n;
    if (i1 == -1) {
      return 0;
    }
    i1 = a(i1);
    return this.k[(i1 + 4)];
  }
  
  public String getText()
  {
    int i1 = this.i;
    if ((i1 != -1) && (this.g == 4)) {
      return this.c.a(i1);
    }
    return null;
  }
  
  public char[] getTextCharacters(int[] paramArrayOfInt)
  {
    String str = getText();
    if (str == null) {
      return null;
    }
    paramArrayOfInt[0] = 0;
    paramArrayOfInt[1] = str.length();
    paramArrayOfInt = new char[str.length()];
    str.getChars(0, str.length(), paramArrayOfInt, 0);
    return paramArrayOfInt;
  }
  
  public boolean isAttributeDefault(int paramInt)
  {
    return false;
  }
  
  public boolean isEmptyElementTag()
  {
    return false;
  }
  
  public boolean isWhitespace()
  {
    return false;
  }
  
  public int next()
  {
    if (this.a != null) {
      try
      {
        c();
        int i1 = this.g;
        return i1;
      }
      catch (IOException localIOException)
      {
        close();
        throw localIOException;
      }
    }
    throw new XmlPullParserException("Parser is not opened.", this, null);
  }
  
  public int nextTag()
  {
    int i2 = next();
    int i1 = i2;
    if (i2 == 4)
    {
      i1 = i2;
      if (isWhitespace()) {
        i1 = next();
      }
    }
    if (i1 != 2)
    {
      if (i1 == 3) {
        return i1;
      }
      throw new XmlPullParserException("Expected start or end tag.", this, null);
    }
    return i1;
  }
  
  public String nextText()
  {
    if (getEventType() == 2)
    {
      int i1 = next();
      if (i1 == 4)
      {
        String str = getText();
        if (next() == 3) {
          return str;
        }
        throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
      }
      if (i1 == 3) {
        return "";
      }
      throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
    }
    throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
  }
  
  public int nextToken()
  {
    return next();
  }
  
  public void require(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt == getEventType()) && ((paramString1 == null) || (paramString1.equals(getNamespace()))) && ((paramString2 == null) || (paramString2.equals(getName())))) {
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append(TYPES[paramInt]);
    paramString1.append(" is expected.");
    throw new XmlPullParserException(paramString1.toString(), this, null);
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    throw new XmlPullParserException("Method is not supported.");
  }
  
  public void setInput(InputStream paramInputStream, String paramString)
  {
    try
    {
      close();
      if (paramInputStream != null)
      {
        paramString = new byte[paramInputStream.available()];
        paramInputStream.read(paramString);
        paramInputStream.close();
        this.a = ByteBuffer.wrap(paramString);
        this.a.order(ByteOrder.LITTLE_ENDIAN);
        return;
      }
    }
    catch (IOException paramInputStream)
    {
      new XmlPullParserException("error load stream").initCause(paramInputStream);
    }
  }
  
  public void setInput(Reader paramReader)
  {
    throw new XmlPullParserException("Method is not supported.");
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    throw new XmlPullParserException("Method is not supported.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.theme.AndroidXmlResourceParser
 * JD-Core Version:    0.7.0.1
 */