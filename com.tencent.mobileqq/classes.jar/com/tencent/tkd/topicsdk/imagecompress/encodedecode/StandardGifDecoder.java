package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import androidx.annotation.ColorInt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StandardGifDecoder
  implements GifDecoder
{
  private static final String jdField_a_of_type_JavaLangString = StandardGifDecoder.class.getSimpleName();
  private int jdField_a_of_type_Int;
  @NotNull
  private Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final GifDecoder.BitmapProvider jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider;
  private GifHeader jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader;
  @Nullable
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  @ColorInt
  private final int[] jdField_a_of_type_ArrayOfInt = new int[256];
  private short[] jdField_a_of_type_ArrayOfShort;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  @ColorInt
  private int[] jdField_b_of_type_ArrayOfInt;
  private int jdField_c_of_type_Int;
  private byte[] jdField_c_of_type_ArrayOfByte;
  @ColorInt
  private int[] jdField_c_of_type_ArrayOfInt;
  private int jdField_d_of_type_Int;
  private byte[] jdField_d_of_type_ArrayOfByte;
  private int e;
  
  public StandardGifDecoder(@NotNull GifDecoder.BitmapProvider paramBitmapProvider)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider = paramBitmapProvider;
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader = new GifHeader();
  }
  
  @ColorInt
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramInt1;
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int i7;
    int i6;
    int i5;
    int i4;
    int i3;
    for (int n = 0; (i1 < this.jdField_c_of_type_Int + paramInt1) && (i1 < this.jdField_d_of_type_ArrayOfByte.length) && (i1 < paramInt2); n = i2)
    {
      i2 = this.jdField_d_of_type_ArrayOfByte[i1];
      i7 = this.jdField_b_of_type_ArrayOfInt[(i2 & 0xFF)];
      i6 = i;
      i5 = j;
      i4 = k;
      i3 = m;
      i2 = n;
      if (i7 != 0)
      {
        i2 = n + (i7 >> 24 & 0xFF);
        i3 = m + (i7 >> 16 & 0xFF);
        i4 = k + (i7 >> 8 & 0xFF);
        i5 = j + (i7 & 0xFF);
        i6 = i + 1;
      }
      i1 += 1;
      i = i6;
      j = i5;
      k = i4;
      m = i3;
    }
    int i2 = paramInt1 + paramInt3;
    i1 = n;
    n = m;
    m = k;
    k = j;
    j = i;
    i = i2;
    while ((i < paramInt1 + paramInt3 + this.jdField_c_of_type_Int) && (i < this.jdField_d_of_type_ArrayOfByte.length) && (i < paramInt2))
    {
      i2 = this.jdField_d_of_type_ArrayOfByte[i];
      i7 = this.jdField_b_of_type_ArrayOfInt[(i2 & 0xFF)];
      i6 = j;
      i5 = k;
      i4 = m;
      i3 = n;
      i2 = i1;
      if (i7 != 0)
      {
        i2 = i1 + (i7 >> 24 & 0xFF);
        i3 = n + (i7 >> 16 & 0xFF);
        i4 = m + (i7 >> 8 & 0xFF);
        i5 = k + (i7 & 0xFF);
        i6 = j + 1;
      }
      i += 1;
      j = i6;
      k = i5;
      m = i4;
      n = i3;
      i1 = i2;
    }
    if (j == 0) {
      return 0;
    }
    return i1 / j << 24 | n / j << 16 | m / j << 8 | k / j;
  }
  
  private int a(GifFrame paramGifFrame)
  {
    if (paramGifFrame != null) {
      this.jdField_a_of_type_JavaNioByteBuffer.position(paramGifFrame.h);
    }
    for (int i = paramGifFrame.jdField_c_of_type_Int * paramGifFrame.jdField_d_of_type_Int;; i = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_c_of_type_Int * this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_d_of_type_Int)
    {
      if ((this.jdField_d_of_type_ArrayOfByte == null) || (this.jdField_d_of_type_ArrayOfByte.length < i)) {
        this.jdField_d_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider.a(i);
      }
      if (this.jdField_a_of_type_ArrayOfShort == null) {
        this.jdField_a_of_type_ArrayOfShort = new short[4096];
      }
      if (this.jdField_b_of_type_ArrayOfByte == null) {
        this.jdField_b_of_type_ArrayOfByte = new byte[4096];
      }
      if (this.jdField_c_of_type_ArrayOfByte == null) {
        this.jdField_c_of_type_ArrayOfByte = new byte[4097];
      }
      return i;
    }
  }
  
  private Bitmap a(GifFrame paramGifFrame1, GifFrame paramGifFrame2)
  {
    int[] arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
    if (paramGifFrame2 == null)
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      Arrays.fill(arrayOfInt, 0);
    }
    label66:
    while (paramGifFrame2.e <= 0)
    {
      c(paramGifFrame1);
      if ((!paramGifFrame1.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Int == 1)) {
        break;
      }
      b(paramGifFrame1);
      if ((this.jdField_a_of_type_Boolean) && ((paramGifFrame1.e == 0) || (paramGifFrame1.e == 1)))
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.jdField_a_of_type_AndroidGraphicsBitmap = b();
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap.setPixels(arrayOfInt, 0, this.e, 0, 0, this.e, this.jdField_d_of_type_Int);
      }
      paramGifFrame1 = b();
      paramGifFrame1.setPixels(arrayOfInt, 0, this.e, 0, 0, this.e, this.jdField_d_of_type_Int);
      return paramGifFrame1;
    }
    int j;
    if (paramGifFrame2.e == 2)
    {
      if (paramGifFrame1.jdField_b_of_type_Boolean) {
        break label394;
      }
      j = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.h;
      i = j;
      if (paramGifFrame1.jdField_a_of_type_ArrayOfInt != null)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.f != paramGifFrame1.f) {}
      }
    }
    label394:
    for (int i = 0;; i = 0)
    {
      int n = paramGifFrame2.jdField_d_of_type_Int / this.jdField_c_of_type_Int;
      j = paramGifFrame2.jdField_b_of_type_Int / this.jdField_c_of_type_Int;
      int i1 = paramGifFrame2.jdField_c_of_type_Int / this.jdField_c_of_type_Int;
      int k = paramGifFrame2.jdField_a_of_type_Int / this.jdField_c_of_type_Int;
      int m = j * this.e + k;
      int i2 = this.e;
      j = m;
      while (j < m + n * i2)
      {
        k = j;
        while (k < j + i1)
        {
          arrayOfInt[k] = i;
          k += 1;
        }
        j += this.e;
      }
      break;
      if (paramGifFrame2.e != 3) {
        break;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        Arrays.fill(arrayOfInt, 0);
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap.getPixels(arrayOfInt, 0, this.e, 0, 0, this.e, this.jdField_d_of_type_Int);
      break;
      a(paramGifFrame1);
      break label66;
    }
  }
  
  private void a(GifFrame paramGifFrame)
  {
    int[] arrayOfInt1 = this.jdField_c_of_type_ArrayOfInt;
    int i4 = paramGifFrame.jdField_d_of_type_Int;
    int i5 = paramGifFrame.jdField_b_of_type_Int;
    int i6 = paramGifFrame.jdField_c_of_type_Int;
    int i7 = paramGifFrame.jdField_a_of_type_Int;
    int j;
    int i8;
    byte[] arrayOfByte;
    int[] arrayOfInt2;
    int i;
    int k;
    if (this.jdField_a_of_type_Int == 0)
    {
      j = 1;
      i8 = this.e;
      arrayOfByte = this.jdField_d_of_type_ArrayOfByte;
      arrayOfInt2 = this.jdField_b_of_type_ArrayOfInt;
      i = -1;
      k = 0;
    }
    for (;;)
    {
      if (k >= i4) {
        break label219;
      }
      int i2 = (k + i5) * i8;
      int i1 = i2 + i7;
      int n = i1 + i6;
      int m = n;
      if (i2 + i8 < n) {
        m = i2 + i8;
      }
      n = paramGifFrame.jdField_c_of_type_Int;
      n *= k;
      label127:
      if (i1 < m)
      {
        int i3 = arrayOfByte[n];
        int i9 = i3 & 0xFF;
        i2 = i;
        if (i9 != i)
        {
          i2 = arrayOfInt2[i9];
          if (i2 == 0) {
            break label203;
          }
          arrayOfInt1[i1] = i2;
        }
        for (i2 = i;; i2 = i3)
        {
          i1 += 1;
          n += 1;
          i = i2;
          break label127;
          j = 0;
          break;
        }
      }
      label203:
      k += 1;
    }
    label219:
    if (((this.jdField_a_of_type_JavaLangBoolean != null) && (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) || ((this.jdField_a_of_type_JavaLangBoolean == null) && (j != 0) && (i != -1))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
      return;
    }
  }
  
  private int b()
  {
    return this.jdField_a_of_type_JavaNioByteBuffer.get() & 0xFF;
  }
  
  private Bitmap b()
  {
    if ((this.jdField_a_of_type_JavaLangBoolean == null) || (this.jdField_a_of_type_JavaLangBoolean.booleanValue())) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = this.jdField_a_of_type_AndroidGraphicsBitmap$Config)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider.a(this.e, this.jdField_d_of_type_Int, (Bitmap.Config)localObject);
      ((Bitmap)localObject).setHasAlpha(true);
      return localObject;
    }
  }
  
  private void b(GifFrame paramGifFrame)
  {
    int[] arrayOfInt1 = this.jdField_c_of_type_ArrayOfInt;
    int i6 = paramGifFrame.jdField_d_of_type_Int / this.jdField_c_of_type_Int;
    int i7 = paramGifFrame.jdField_b_of_type_Int / this.jdField_c_of_type_Int;
    int i8 = paramGifFrame.jdField_c_of_type_Int / this.jdField_c_of_type_Int;
    int i9 = paramGifFrame.jdField_a_of_type_Int / this.jdField_c_of_type_Int;
    int k = 1;
    int j = 8;
    int m = 0;
    int i3;
    int i10;
    int i11;
    int i12;
    byte[] arrayOfByte;
    int[] arrayOfInt2;
    Object localObject1;
    int i1;
    label108:
    int i;
    int n;
    int i2;
    if (this.jdField_a_of_type_Int == 0)
    {
      i3 = 1;
      i10 = this.jdField_c_of_type_Int;
      i11 = this.e;
      i12 = this.jdField_d_of_type_Int;
      arrayOfByte = this.jdField_d_of_type_ArrayOfByte;
      arrayOfInt2 = this.jdField_b_of_type_ArrayOfInt;
      localObject1 = this.jdField_a_of_type_JavaLangBoolean;
      i1 = 0;
      if (i1 >= i6) {
        break label510;
      }
      if (!paramGifFrame.jdField_a_of_type_Boolean) {
        break label545;
      }
      i = m;
      n = j;
      i2 = k;
      if (m >= i6) {
        i2 = k + 1;
      }
      switch (i2)
      {
      default: 
        n = j;
        i = m;
        label178:
        m = i + n;
        j = n;
        k = i2;
      }
    }
    for (;;)
    {
      i += i7;
      if (i10 == 1)
      {
        i4 = 1;
        label205:
        if (i >= i12) {
          break label501;
        }
        i5 = i * i11;
        n = i5 + i9;
        i2 = n + i8;
        i = i2;
        if (i5 + i11 < i2) {
          i = i5 + i11;
        }
        i2 = i1 * i10 * paramGifFrame.jdField_c_of_type_Int;
        if (i4 == 0) {
          break label394;
        }
        localObject2 = localObject1;
        label271:
        localObject1 = localObject2;
        if (n >= i) {
          break label501;
        }
        i4 = arrayOfInt2[(arrayOfByte[i2] & 0xFF)];
        if (i4 == 0) {
          break label367;
        }
        arrayOfInt1[n] = i4;
        localObject1 = localObject2;
      }
      for (;;)
      {
        i2 += i10;
        n += 1;
        localObject2 = localObject1;
        break label271;
        i3 = 0;
        break;
        i = 4;
        n = j;
        break label178;
        i = 2;
        n = 4;
        break label178;
        i = 1;
        n = 2;
        break label178;
        i4 = 0;
        break label205;
        label367:
        localObject1 = localObject2;
        if (i3 != 0)
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = Boolean.valueOf(true);
          }
        }
      }
      label394:
      int i4 = n;
      int i5 = i2;
      Object localObject2 = localObject1;
      localObject1 = localObject2;
      if (i4 < i)
      {
        int i13 = a(i5, (i - n) * i10 + i2, paramGifFrame.jdField_c_of_type_Int);
        if (i13 != 0)
        {
          arrayOfInt1[i4] = i13;
          localObject1 = localObject2;
        }
        for (;;)
        {
          i5 += i10;
          i4 += 1;
          localObject2 = localObject1;
          break;
          localObject1 = localObject2;
          if (i3 != 0)
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = Boolean.valueOf(true);
            }
          }
        }
      }
      label501:
      i1 += 1;
      break label108;
      label510:
      if (this.jdField_a_of_type_JavaLangBoolean == null) {
        if (localObject1 != null) {
          break label535;
        }
      }
      label535:
      for (boolean bool = false;; bool = ((Boolean)localObject1).booleanValue())
      {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        return;
      }
      label545:
      i = i1;
    }
  }
  
  private int c()
  {
    int i = b();
    if (i <= 0) {
      return i;
    }
    this.jdField_a_of_type_JavaNioByteBuffer.get(this.jdField_a_of_type_ArrayOfByte, 0, Math.min(i, this.jdField_a_of_type_JavaNioByteBuffer.remaining()));
    return i;
  }
  
  private void c(GifFrame paramGifFrame)
  {
    int i13 = a(paramGifFrame);
    paramGifFrame = this.jdField_d_of_type_ArrayOfByte;
    short[] arrayOfShort = this.jdField_a_of_type_ArrayOfShort;
    byte[] arrayOfByte1 = this.jdField_b_of_type_ArrayOfByte;
    byte[] arrayOfByte2 = this.jdField_c_of_type_ArrayOfByte;
    int i14 = b();
    int i15 = 1 << i14;
    int i4 = i14 + 1;
    int i3 = (1 << i4) - 1;
    int i = 0;
    while (i < i15)
    {
      arrayOfShort[i] = 0;
      arrayOfByte1[i] = ((byte)i);
      i += 1;
    }
    byte[] arrayOfByte3 = this.jdField_a_of_type_ArrayOfByte;
    int i7 = 0;
    int i1 = 0;
    int i2 = 0;
    int i6 = 0;
    int m = -1;
    i = 0;
    int n = i15 + 2;
    int k = 0;
    int j = 0;
    int i5 = 0;
    for (;;)
    {
      if (i < i13)
      {
        i8 = i2;
        i2 = i1;
        if (i1 != 0) {
          break label166;
        }
        i2 = c();
        if (i2 <= 0) {
          this.jdField_b_of_type_Int = 3;
        }
      }
      else
      {
        Arrays.fill(paramGifFrame, j, i13, (byte)0);
        return;
      }
      int i8 = 0;
      label166:
      i1 = arrayOfByte3[i8];
      int i9 = i8 + 1;
      i8 = i2 - 1;
      int i10 = i3;
      int i11 = i4;
      i3 = i5 + 8;
      i4 = i6 + ((i1 & 0xFF) << i5);
      i2 = j;
      j = n;
      i1 = i;
      i = m;
      n = i2;
      i6 = i7;
      i2 = k;
      m = j;
      j = i11;
      k = i10;
      for (;;)
      {
        if (i3 >= j)
        {
          i5 = i4 & k;
          i4 >>= j;
          i3 -= j;
          if (i5 == i15)
          {
            j = i14 + 1;
            k = (1 << j) - 1;
            m = i15 + 2;
            i = -1;
          }
          else
          {
            if (i5 == i15 + 1)
            {
              i10 = i2;
              i11 = k;
              i2 = i9;
              k = n;
              n = i;
              i = i1;
              i9 = m;
              m = j;
              i1 = i8;
              i5 = i3;
              j = k;
              i7 = i6;
              i6 = i4;
              k = i10;
              i3 = i11;
              i4 = m;
              m = n;
              n = i9;
              break;
            }
            if (i == -1)
            {
              paramGifFrame[n] = arrayOfByte1[i5];
              i1 += 1;
              i = i5;
              n += 1;
              i2 = i5;
            }
            else
            {
              if (i5 >= m)
              {
                arrayOfByte2[i6] = ((byte)i2);
                i2 = i6 + 1;
                i7 = i;
              }
              for (;;)
              {
                if (i7 >= i15)
                {
                  arrayOfByte2[i2] = arrayOfByte1[i7];
                  i2 += 1;
                  i7 = arrayOfShort[i7];
                }
                else
                {
                  i11 = arrayOfByte1[i7] & 0xFF;
                  paramGifFrame[n] = ((byte)i11);
                  n += 1;
                  i1 += 1;
                  i6 = i2;
                  while (i6 > 0)
                  {
                    i6 -= 1;
                    paramGifFrame[n] = arrayOfByte2[i6];
                    n += 1;
                    i1 += 1;
                  }
                  i10 = k;
                  i7 = j;
                  i2 = m;
                  if (m < 4096)
                  {
                    arrayOfShort[m] = ((short)i);
                    arrayOfByte1[m] = ((byte)i11);
                    i = m + 1;
                    i10 = k;
                    i7 = j;
                    i2 = i;
                    if ((i & k) == 0)
                    {
                      i10 = k;
                      i7 = j;
                      i2 = i;
                      if (i < 4096)
                      {
                        i7 = j + 1;
                        i10 = k + i;
                        i2 = i;
                      }
                    }
                  }
                  i = i5;
                  i5 = i11;
                  k = i10;
                  j = i7;
                  m = i2;
                  i2 = i5;
                  break;
                  i7 = i5;
                  i2 = i6;
                }
              }
            }
          }
        }
      }
      i11 = i2;
      i10 = i;
      i = i1;
      i7 = n;
      int i12 = i4;
      n = m;
      i4 = j;
      i5 = i3;
      i1 = i8;
      i3 = k;
      i2 = i9;
      j = i7;
      i7 = i6;
      i6 = i12;
      k = i11;
      m = i10;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int j = -1;
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int) {
        i = ((GifFrame)this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_JavaUtilList.get(paramInt)).g;
      }
    }
    return i;
  }
  
  @Nullable
  public Bitmap a()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int <= 0) || (this.jdField_a_of_type_Int < 0))
        {
          if (Log.isLoggable(jdField_a_of_type_JavaLangString, 3)) {
            Log.d(jdField_a_of_type_JavaLangString, "Unable to decode frame, frameCount=" + this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int + ", framePointer=" + this.jdField_a_of_type_Int);
          }
          this.jdField_b_of_type_Int = 1;
        }
        Object localObject1;
        if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2))
        {
          if (Log.isLoggable(jdField_a_of_type_JavaLangString, 3)) {
            Log.d(jdField_a_of_type_JavaLangString, "Unable to decode frame, status=" + this.jdField_b_of_type_Int);
          }
          localObject1 = null;
          return localObject1;
        }
        this.jdField_b_of_type_Int = 0;
        if (this.jdField_a_of_type_ArrayOfByte == null) {
          this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider.a(255);
        }
        GifFrame localGifFrame = (GifFrame)this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        int i = this.jdField_a_of_type_Int - 1;
        if (i >= 0)
        {
          localObject1 = (GifFrame)this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_JavaUtilList.get(i);
          int[] arrayOfInt;
          if (localGifFrame.jdField_a_of_type_ArrayOfInt != null)
          {
            arrayOfInt = localGifFrame.jdField_a_of_type_ArrayOfInt;
            this.jdField_b_of_type_ArrayOfInt = arrayOfInt;
            if (this.jdField_b_of_type_ArrayOfInt == null)
            {
              if (Log.isLoggable(jdField_a_of_type_JavaLangString, 3)) {
                Log.d(jdField_a_of_type_JavaLangString, "No valid color table found for frame #" + this.jdField_a_of_type_Int);
              }
              this.jdField_b_of_type_Int = 1;
              localObject1 = null;
            }
          }
          else
          {
            arrayOfInt = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ArrayOfInt;
            continue;
          }
          if (localGifFrame.jdField_b_of_type_Boolean)
          {
            System.arraycopy(this.jdField_b_of_type_ArrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt, 0, this.jdField_b_of_type_ArrayOfInt.length);
            this.jdField_b_of_type_ArrayOfInt = this.jdField_a_of_type_ArrayOfInt;
            this.jdField_b_of_type_ArrayOfInt[localGifFrame.f] = 0;
            if ((localGifFrame.e == 2) && (this.jdField_a_of_type_Int == 0)) {
              this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
            }
          }
          localObject1 = a(localGifFrame, (GifFrame)localObject1);
        }
        else
        {
          Object localObject3 = null;
        }
      }
      finally {}
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + 1) % this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int);
  }
  
  public void a(@NotNull GifHeader paramGifHeader, @NotNull ByteBuffer paramByteBuffer)
  {
    try
    {
      a(paramGifHeader, paramByteBuffer, 1);
      return;
    }
    finally
    {
      paramGifHeader = finally;
      throw paramGifHeader;
    }
  }
  
  public void a(@NotNull GifHeader paramGifHeader, @NotNull ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt <= 0) {
      try
      {
        throw new IllegalArgumentException("Sample size must be >=0, not: " + paramInt);
      }
      finally {}
    }
    paramInt = Integer.highestOneBit(paramInt);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader = paramGifHeader;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaNioByteBuffer = paramByteBuffer.asReadOnlyBuffer();
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    this.jdField_a_of_type_Boolean = false;
    paramByteBuffer = paramGifHeader.jdField_a_of_type_JavaUtilList.iterator();
    while (paramByteBuffer.hasNext()) {
      if (((GifFrame)paramByteBuffer.next()).e == 3) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    this.jdField_c_of_type_Int = paramInt;
    this.e = (paramGifHeader.jdField_c_of_type_Int / paramInt);
    this.jdField_d_of_type_Int = (paramGifHeader.jdField_d_of_type_Int / paramInt);
    this.jdField_d_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider.a(paramGifHeader.jdField_c_of_type_Int * paramGifHeader.jdField_d_of_type_Int);
    this.jdField_c_of_type_ArrayOfInt = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider.a(this.e * this.jdField_d_of_type_Int);
  }
  
  public void a(@NotNull GifHeader paramGifHeader, @NotNull byte[] paramArrayOfByte)
  {
    try
    {
      a(paramGifHeader, ByteBuffer.wrap(paramArrayOfByte));
      return;
    }
    finally
    {
      paramGifHeader = finally;
      throw paramGifHeader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.StandardGifDecoder
 * JD-Core Version:    0.7.0.1
 */