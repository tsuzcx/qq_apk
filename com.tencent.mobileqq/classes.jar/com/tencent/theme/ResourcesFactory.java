package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ResourcesFactory
{
  public static final byte[] sBaseChunk = { 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 94, 0, 0, 0, 0, 0, 0, 0, 94, 0, 0, 0, 1, 0, 0, 0 };
  
  static Bitmap a(Resources paramResources, TypedValue paramTypedValue, InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if ((localOptions.inDensity == 0) && (paramTypedValue != null))
    {
      int i = paramTypedValue.density;
      if (i == 0) {
        localOptions.inDensity = 160;
      } else if (i != 65535) {
        localOptions.inDensity = i;
      }
    }
    if ((localOptions.inTargetDensity == 0) && (paramResources != null)) {
      localOptions.inTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    }
    return BitmapFactory.decodeStream(paramInputStream, paramRect, localOptions);
  }
  
  static BaseConstantState a(Resources paramResources, XmlPullParser paramXmlPullParser1, XmlPullParser paramXmlPullParser2, boolean paramBoolean)
  {
    AttributeSet localAttributeSet1 = Xml.asAttributeSet(paramXmlPullParser1);
    int i;
    do
    {
      i = paramXmlPullParser1.next();
    } while ((i != 2) && (i != 1));
    if (paramXmlPullParser2 == null)
    {
      if (i == 2) {
        paramResources = a(paramResources, paramXmlPullParser1, localAttributeSet1, null, paramBoolean);
      } else {
        throw new XmlPullParserException("No start tag found");
      }
    }
    else
    {
      AttributeSet localAttributeSet2 = Xml.asAttributeSet(paramXmlPullParser2);
      do
      {
        i = paramXmlPullParser2.next();
      } while ((i != 2) && (i != 1));
      if (i != 2) {
        break label152;
      }
      paramResources = a(paramResources, paramXmlPullParser1, localAttributeSet1, localAttributeSet2, paramBoolean);
    }
    if (paramResources != null) {
      return paramResources;
    }
    paramResources = new StringBuilder();
    paramResources.append("Unknown initial tag: ");
    paramResources.append(paramXmlPullParser1.getName());
    throw new RuntimeException(paramResources.toString());
    label152:
    paramResources = new XmlPullParserException("No start tag found");
    for (;;)
    {
      throw paramResources;
    }
  }
  
  static SkinnableBitmapDrawable.a a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet1, AttributeSet paramAttributeSet2, boolean paramBoolean)
  {
    String str = paramXmlPullParser.getName();
    if (str.equals("bitmap"))
    {
      paramResources = SkinnableBitmapDrawable.a(paramResources, paramXmlPullParser, paramAttributeSet1, paramAttributeSet2, paramBoolean);
      int k = 0;
      if (paramAttributeSet1 != null)
      {
        i = 0;
        while (i < paramAttributeSet1.getAttributeCount())
        {
          if ("isNeedScale".equals(paramAttributeSet1.getAttributeName(i)))
          {
            i = 1;
            break label83;
          }
          i += 1;
        }
      }
      int i = 0;
      label83:
      int j = i;
      if (i == 0)
      {
        j = i;
        if (paramAttributeSet2 != null) {
          for (;;)
          {
            j = i;
            if (k >= paramAttributeSet2.getAttributeCount()) {
              break;
            }
            if ("isNeedScale".equals(paramAttributeSet2.getAttributeName(k)))
            {
              j = 1;
              break;
            }
            k += 1;
          }
        }
      }
      if (j != 0) {
        paramResources.bitmapType = 1;
      }
      return paramResources;
    }
    paramResources = new StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": invalid drawable tag ");
    paramResources.append(str);
    paramResources = new XmlPullParserException(paramResources.toString());
    for (;;)
    {
      throw paramResources;
    }
  }
  
  static SkinnableColorStateList a(SkinEngine paramSkinEngine, Resources paramResources, File paramFile, boolean paramBoolean)
  {
    long l1 = SystemClock.uptimeMillis();
    Object localObject;
    if (paramBoolean) {
      localObject = new AndroidXmlResourceParser();
    } else {
      localObject = Xml.newPullParser();
    }
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    ((XmlPullParser)localObject).setInput(localFileInputStream, "UTF-8");
    paramSkinEngine = SkinnableColorStateList.createFromXml(paramSkinEngine, paramResources, (XmlPullParser)localObject, paramBoolean);
    localFileInputStream.close();
    if (SkinEngine.DEBUG)
    {
      long l2 = SystemClock.uptimeMillis();
      paramResources = new StringBuilder();
      paramResources.append("load colorList:");
      paramResources.append(paramFile.toString());
      paramResources.append(" , cost:");
      paramResources.append(l2 - l1);
      Log.d("SkinEngine", paramResources.toString());
    }
    return paramSkinEngine;
  }
  
  static byte[] a(Bitmap paramBitmap)
  {
    Object localObject = sBaseChunk;
    byte[] arrayOfByte = new byte[localObject.length];
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    localObject = ByteBuffer.wrap(arrayOfByte);
    ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
    ((ByteBuffer)localObject).position(36);
    ((ByteBuffer)localObject).putInt(paramBitmap.getWidth());
    ((ByteBuffer)localObject).position(44);
    ((ByteBuffer)localObject).putInt(paramBitmap.getHeight());
    return arrayOfByte;
  }
  
  static byte[] a(Bitmap paramBitmap, Rect paramRect)
  {
    int j = paramBitmap.getWidth();
    int i4 = paramBitmap.getHeight();
    if ((j > 2) && (i4 > 2))
    {
      Object localObject1 = new ByteArrayOutputStream(83);
      Object localObject2 = new DataOutputStream((OutputStream)localObject1);
      int i = 0;
      while (i < 32)
      {
        ((DataOutputStream)localObject2).write(0);
        i += 1;
      }
      i = j - 2;
      int[] arrayOfInt = new int[i];
      paramBitmap.getPixels(arrayOfInt, 0, j, 1, 0, i, 1);
      if (arrayOfInt[0] == -16777216) {
        k = 1;
      } else {
        k = 0;
      }
      if (arrayOfInt[(arrayOfInt.length - 1)] == -16777216) {
        m = 1;
      } else {
        m = 0;
      }
      int i5 = arrayOfInt.length;
      int n = 0;
      i = 0;
      int i3;
      for (int i1 = 0; n < i5; i1 = i2)
      {
        i2 = arrayOfInt[n];
        j = i2;
        if (i2 == -65536) {
          j = 0;
        }
        if ((j != -16777216) && (j != 0))
        {
          paramBitmap = new StringBuilder();
          paramBitmap.append("Ticks in transparent frame must be black or red. Fount at pixel #");
          paramBitmap.append(n + 1);
          paramBitmap.append(" along top edge");
          throw new IllegalArgumentException(paramBitmap.toString());
        }
        i3 = i;
        i2 = i1;
        if (i1 != j)
        {
          i3 = i + 1;
          ((DataOutputStream)localObject2).writeInt(Integer.reverseBytes(n));
          i2 = j;
        }
        n += 1;
        i = i3;
      }
      j = i;
      if (m != 0)
      {
        j = i + 1;
        ((DataOutputStream)localObject2).writeInt(Integer.reverseBytes(arrayOfInt.length));
      }
      n = j + 1;
      i = n;
      if (k != 0) {
        i = n - 1;
      }
      int k = i;
      if (m != 0) {
        k = i - 1;
      }
      i = i4 - 2;
      arrayOfInt = new int[i];
      paramBitmap.getPixels(arrayOfInt, 0, 1, 0, 1, 1, i);
      if (arrayOfInt[0] == -16777216) {
        m = 1;
      } else {
        m = 0;
      }
      if (arrayOfInt[(arrayOfInt.length - 1)] == -16777216) {
        n = 1;
      } else {
        n = 0;
      }
      i5 = arrayOfInt.length;
      i1 = 0;
      i = 0;
      for (int i2 = 0; i1 < i5; i2 = i3)
      {
        i4 = arrayOfInt[i1];
        i3 = i4;
        if (i4 == -65536) {
          i3 = 0;
        }
        if ((i3 != -16777216) && (i3 != 0))
        {
          paramBitmap = new StringBuilder();
          paramBitmap.append("Ticks in transparent frame must be black or red. Fount at pixel #");
          paramBitmap.append(i1 + 1);
          paramBitmap.append(" along left edge");
          throw new IllegalArgumentException(paramBitmap.toString());
        }
        i4 = i;
        i3 = i2;
        if (i2 != arrayOfInt[i1])
        {
          i4 = i + 1;
          ((DataOutputStream)localObject2).writeInt(Integer.reverseBytes(i1));
          i3 = arrayOfInt[i1];
        }
        i1 += 1;
        i = i4;
      }
      i1 = i;
      if (n != 0)
      {
        i1 = i + 1;
        ((DataOutputStream)localObject2).writeInt(Integer.reverseBytes(arrayOfInt.length));
      }
      i2 = i1 + 1;
      i = i2;
      if (m != 0) {
        i = i2 - 1;
      }
      int m = i;
      if (n != 0) {
        m = i - 1;
      }
      i = 0;
      for (;;)
      {
        n = k * m;
        if (i >= n) {
          break;
        }
        ((DataOutputStream)localObject2).writeInt(16777216);
        i += 1;
      }
      localObject1 = ((ByteArrayOutputStream)localObject1).toByteArray();
      localObject1[0] = 1;
      localObject1[1] = ((byte)j);
      localObject1[2] = ((byte)i1);
      localObject1[3] = ((byte)n);
      localObject2 = new int[paramBitmap.getWidth() - 2];
      paramBitmap.getPixels((int[])localObject2, 0, localObject2.length, 1, paramBitmap.getHeight() - 1, localObject2.length, 1);
      k = 0;
      i2 = 0;
      j = -1;
      for (i = -1; k < localObject2.length; i = i1)
      {
        n = localObject2[k];
        m = n;
        if (n == -65536) {
          m = 0;
        }
        if (m != -16777216)
        {
          i3 = i2;
          n = j;
          i1 = i;
          if (m != 0) {}
        }
        else
        {
          if ((-16777216 == m) && (m != i2))
          {
            if (j == -1)
            {
              n = k;
              i1 = i;
            }
            else
            {
              paramBitmap = new StringBuilder();
              paramBitmap.append("Can't have more than one marked region along edge.Found at pixel #");
              paramBitmap.append(k + 1);
              paramBitmap.append(" along bottom edge.");
              throw new IllegalArgumentException(paramBitmap.toString());
            }
          }
          else
          {
            n = j;
            i1 = i;
            if (m == 0)
            {
              n = j;
              i1 = i;
              if (m != i2) {
                if (i == -1)
                {
                  i1 = localObject2.length - k;
                  n = j;
                }
                else
                {
                  paramBitmap = new StringBuilder();
                  paramBitmap.append("Can't have more than one marked region along edge.Found at pixel #");
                  paramBitmap.append(k + 1);
                  paramBitmap.append(" along bottom edge.");
                  throw new IllegalArgumentException(paramBitmap.toString());
                }
              }
            }
          }
          i3 = m;
        }
        k += 1;
        i2 = i3;
        j = n;
      }
      localObject2 = new int[paramBitmap.getHeight() - 2];
      paramBitmap.getPixels((int[])localObject2, 0, 1, paramBitmap.getWidth() - 1, 0, 1, localObject2.length);
      k = 0;
      n = -1;
      m = -1;
      for (i4 = 0; k < localObject2.length; i4 = i5)
      {
        i2 = localObject2[k];
        i1 = i2;
        if (i2 == -65536) {
          i1 = 0;
        }
        if (i1 != -16777216)
        {
          i2 = n;
          i3 = m;
          i5 = i4;
          if (i1 != 0) {}
        }
        else
        {
          if ((-16777216 == i1) && (i1 != i4))
          {
            if (n == -1)
            {
              i2 = k;
              i3 = m;
            }
            else
            {
              paramBitmap = new StringBuilder();
              paramBitmap.append("Can't have more than one marked region along edge.Found at pixel #");
              paramBitmap.append(k + 1);
              paramBitmap.append(" along right edge.");
              throw new IllegalArgumentException(paramBitmap.toString());
            }
          }
          else
          {
            i2 = n;
            i3 = m;
            if (i1 == 0)
            {
              i2 = n;
              i3 = m;
              if (i1 != i4) {
                if (m == -1)
                {
                  i3 = localObject2.length - k;
                  i2 = n;
                }
                else
                {
                  paramBitmap = new StringBuilder();
                  paramBitmap.append("Can't have more than one marked region along edge.Found at pixel #");
                  paramBitmap.append(k + 1);
                  paramBitmap.append(" along bottom edge.");
                  throw new IllegalArgumentException(paramBitmap.toString());
                }
              }
            }
          }
          i5 = i1;
        }
        k += 1;
        n = i2;
        m = i3;
      }
      paramBitmap = ByteBuffer.wrap((byte[])localObject1);
      paramBitmap.order(ByteOrder.LITTLE_ENDIAN);
      paramBitmap.position(12);
      paramBitmap.putInt(j);
      paramBitmap.putInt(i);
      paramBitmap.putInt(n);
      paramBitmap.putInt(m);
      paramRect.set(j, n, i, m);
      return localObject1;
    }
    paramBitmap = new IllegalArgumentException("not a nine-path bitmap");
    for (;;)
    {
      throw paramBitmap;
    }
  }
  
  public static BaseConstantState createImageFromResourceStream(Resources paramResources, TypedValue paramTypedValue, InputStream paramInputStream, String paramString, BitmapFactory.Options paramOptions, Rect paramRect, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramInputStream == null) {
      return null;
    }
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    localOptions.inScreenDensity = paramResources.getDisplayMetrics().densityDpi;
    if ((paramInputStream instanceof FileInputStream))
    {
      localOptions.inScaled = paramBoolean;
      paramTypedValue = a(paramResources, paramTypedValue, paramInputStream, paramRect, localOptions);
    }
    try
    {
      paramTypedValue = BitmapFactory.decodeResourceStream(paramResources, paramTypedValue, paramInputStream, paramRect, localOptions);
    }
    catch (NullPointerException|OutOfMemoryError paramTypedValue)
    {
      label81:
      boolean bool3;
      boolean bool2;
      boolean bool1;
      int i;
      int j;
      int k;
      break label81;
    }
    paramTypedValue = null;
    bool3 = localOptions.inJustDecodeBounds;
    bool2 = true;
    bool1 = true;
    if (bool3)
    {
      i = localOptions.outWidth;
      j = localOptions.outHeight;
      k = localOptions.inDensity;
      paramTypedValue = new int[3];
      paramTypedValue[0] = i;
      paramTypedValue[1] = j;
      paramTypedValue[2] = k;
      if (paramString.endsWith(".9.png"))
      {
        paramInputStream = new SkinnableNinePatchDrawable.a(null, null, new Rect(0, 0, 0, 0));
        paramInputStream.mImageSizeWhenOOM = paramTypedValue;
        if (paramResources != null) {
          paramInputStream.f = paramResources.getDisplayMetrics().densityDpi;
        }
        return paramInputStream;
      }
      paramInputStream = new SkinnableBitmapDrawable.a((Bitmap)null);
      paramInputStream.mImageSizeWhenOOM = paramTypedValue;
      if (paramResources != null) {
        paramInputStream.g = paramResources.getDisplayMetrics().densityDpi;
      }
      return paramInputStream;
    }
    if (paramTypedValue != null)
    {
      if (paramString.endsWith(".9.png"))
      {
        if (paramBoolean)
        {
          paramInputStream = paramTypedValue.getNinePatchChunk();
          if ((paramInputStream != null) && (NinePatch.isNinePatchChunk(paramInputStream)))
          {
            paramBoolean = false;
          }
          else
          {
            paramInputStream = a(paramTypedValue);
            paramRect = new Rect();
            paramBoolean = bool1;
          }
          paramTypedValue = new SkinnableNinePatchDrawable.a(new NinePatch(paramTypedValue, paramInputStream, paramString), paramTypedValue, paramRect);
          if (paramResources != null) {
            paramTypedValue.f = paramResources.getDisplayMetrics().densityDpi;
          }
          paramTypedValue.hasProblem = paramBoolean;
          return paramTypedValue;
        }
        try
        {
          paramInputStream = a(paramTypedValue, paramRect);
        }
        catch (IllegalArgumentException paramOptions)
        {
          paramInputStream = localObject;
          if (SkinEngine.DEBUG)
          {
            Log.e("SkinEngine", "", paramOptions);
            paramInputStream = localObject;
          }
        }
        if ((paramInputStream != null) && (NinePatch.isNinePatchChunk(paramInputStream)))
        {
          paramOptions = Bitmap.createBitmap(paramTypedValue, 1, 1, paramTypedValue.getWidth() - 2, paramTypedValue.getHeight() - 2);
          paramTypedValue.recycle();
          paramTypedValue = paramOptions;
          paramBoolean = false;
        }
        else
        {
          paramInputStream = a(paramTypedValue);
          paramRect = new Rect();
          paramBoolean = bool2;
        }
        paramTypedValue = new SkinnableNinePatchDrawable.a(new NinePatch(paramTypedValue, paramInputStream, paramString), paramTypedValue, paramRect);
        paramTypedValue.hasProblem = paramBoolean;
        if (paramResources != null) {
          paramTypedValue.f = paramResources.getDisplayMetrics().densityDpi;
        }
        return paramTypedValue;
      }
      paramTypedValue = new SkinnableBitmapDrawable.a(paramTypedValue);
      if (paramResources != null) {
        paramTypedValue.g = paramResources.getDisplayMetrics().densityDpi;
      }
      return paramTypedValue;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.ResourcesFactory
 * JD-Core Version:    0.7.0.1
 */