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
  private k c;
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
    if (this.g != 2) {
      throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }
    int i1 = paramInt * 5;
    if (i1 >= this.k.length) {
      throw new IndexOutOfBoundsException("Invalid attribute index (" + paramInt + ").");
    }
    return i1;
  }
  
  private final int a(String paramString1, String paramString2)
  {
    if ((this.c == null) || (paramString2 == null)) {}
    label104:
    for (;;)
    {
      return -1;
      int i3 = this.c.a(paramString2);
      if (i3 != -1)
      {
        int i1;
        int i2;
        if (paramString1 != null)
        {
          i1 = this.c.a(paramString1);
          i2 = 0;
        }
        for (;;)
        {
          if (i2 == this.k.length) {
            break label104;
          }
          if ((i3 == this.k[(i2 + 1)]) && ((i1 == -1) || (i1 == this.k[(i2 + 0)])))
          {
            return i2 / 5;
            i1 = -1;
            break;
          }
          i2 += 1;
        }
      }
    }
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
    int i2 = 3;
    if (this.c == null)
    {
      b.a(this.a, 524291);
      b.b(this.a, 4);
      this.c = k.a(this.a);
      this.e.f();
      this.b = true;
    }
    if (this.g == 1) {
      return;
    }
    int i3 = this.g;
    b();
    int i1;
    do
    {
      int i4;
      for (;;)
      {
        if (this.f)
        {
          this.f = false;
          this.e.g();
        }
        if ((i3 == 3) && (this.e.e() == 1) && (this.e.c() == 0))
        {
          this.g = 1;
          return;
        }
        if (i3 == 0) {
          i1 = 1048834;
        }
        for (;;)
        {
          if (i1 == 524672)
          {
            i1 = this.a.getInt();
            if ((i1 < 8) || (i1 % 4 != 0))
            {
              throw new IOException("Invalid resource ids size (" + i1 + ").");
              i1 = this.a.getInt();
            }
            else
            {
              this.d = b.c(this.a, i1 / 4 - 2);
              break;
            }
          }
        }
        if ((i1 < 1048832) || (i1 > 1048836)) {
          throw new IOException("Invalid chunk type (" + i1 + ").");
        }
        if ((i1 == 1048834) && (i3 == -1))
        {
          this.g = 0;
          return;
        }
        b.b(this.a, 4);
        i4 = this.a.getInt();
        b.b(this.a, 4);
        if ((i1 != 1048832) && (i1 != 1048833)) {
          break;
        }
        if (i1 == 1048832)
        {
          i1 = this.a.getInt();
          i4 = this.a.getInt();
          this.e.a(i1, i4);
        }
        else
        {
          b.b(this.a, 4);
          b.b(this.a, 4);
          this.e.d();
        }
      }
      this.h = i4;
      if (i1 == 1048834)
      {
        this.j = this.a.getInt();
        this.i = this.a.getInt();
        b.b(this.a, 4);
        i1 = this.a.getInt();
        this.l = ((i1 >>> 16) - 1);
        this.m = this.a.getInt();
        this.n = ((this.m >>> 16) - 1);
        this.m = ((this.m & 0xFFFF) - 1);
        this.k = b.c(this.a, (i1 & 0xFFFF) * 5);
        i1 = i2;
        while (i1 < this.k.length)
        {
          this.k[i1] >>>= 24;
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
    } while (i1 != 1048836);
    this.i = this.a.getInt();
    b.b(this.a, 4);
    b.b(this.a, 4);
    this.g = 4;
  }
  
  final k a()
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
    if (paramBoolean) {}
    for (int i1 = 1; getAttributeIntValue(paramInt, i1) != 0; i1 = 0) {
      return true;
    }
    return false;
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
    if (this.k[(paramInt + 3)] == 4) {
      paramFloat = Float.intBitsToFloat(this.k[(paramInt + 4)]);
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
    int i1 = a(paramInt1);
    int i2 = this.k[(i1 + 3)];
    paramInt1 = paramInt2;
    if (i2 >= 16)
    {
      paramInt1 = paramInt2;
      if (i2 <= 31) {
        paramInt1 = this.k[(i1 + 4)];
      }
    }
    return paramInt1;
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
    if ((this.d == null) || (paramInt < 0) || (paramInt >= this.d.length)) {
      return 0;
    }
    return this.d[paramInt];
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
    if (this.k[(paramInt1 + 3)] == 1) {
      paramInt2 = this.k[(paramInt1 + 4)];
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
    if (this.k[(paramInt + 3)] == 3)
    {
      paramInt = this.k[(paramInt + 2)];
      return this.c.a(paramInt);
    }
    paramInt = this.k[(paramInt + 4)];
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
    if (this.m == -1) {
      return null;
    }
    int i1 = a(this.m);
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
    if (this.l == -1) {
      return null;
    }
    int i1 = a(this.l);
    i1 = this.k[(i1 + 2)];
    return this.c.a(i1);
  }
  
  public int getIdAttributeResourceValue(int paramInt)
  {
    if (this.l == -1) {}
    int i1;
    do
    {
      return paramInt;
      i1 = a(this.l);
    } while (this.k[(i1 + 3)] != 1);
    return this.k[(i1 + 4)];
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
    if ((this.i == -1) || ((this.g != 2) && (this.g != 3))) {
      return null;
    }
    return this.c.a(this.i);
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
    return "XML line #" + getLineNumber();
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
    if (this.n == -1) {
      return 0;
    }
    int i1 = a(this.n);
    return this.k[(i1 + 4)];
  }
  
  public String getText()
  {
    if ((this.i == -1) || (this.g != 4)) {
      return null;
    }
    return this.c.a(this.i);
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
    if (this.a == null) {
      throw new XmlPullParserException("Parser is not opened.", this, null);
    }
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
    if ((i1 != 2) && (i1 != 3)) {
      throw new XmlPullParserException("Expected start or end tag.", this, null);
    }
    return i1;
  }
  
  public String nextText()
  {
    if (getEventType() != 2) {
      throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
    }
    int i1 = next();
    String str;
    if (i1 == 4)
    {
      str = getText();
      if (next() != 3) {
        throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
      }
    }
    else
    {
      if (i1 != 3) {
        break label67;
      }
      str = "";
    }
    return str;
    label67:
    throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
  }
  
  public int nextToken()
  {
    return next();
  }
  
  public void require(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != getEventType()) || ((paramString1 != null) && (!paramString1.equals(getNamespace()))) || ((paramString2 != null) && (!paramString2.equals(getName())))) {
      throw new XmlPullParserException(TYPES[paramInt] + " is expected.", this, null);
    }
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
      }
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.AndroidXmlResourceParser
 * JD-Core Version:    0.7.0.1
 */