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
  private static final String jdField_a_of_type_JavaLangString = "StandardGifDecoder";
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
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    byte[] arrayOfByte;
    int i6;
    int i4;
    int i3;
    for (int i = 0; i1 < this.jdField_c_of_type_Int + paramInt1; i = i2)
    {
      arrayOfByte = this.jdField_d_of_type_ArrayOfByte;
      if ((i1 >= arrayOfByte.length) || (i1 >= paramInt2)) {
        break;
      }
      i2 = arrayOfByte[i1];
      int i7 = this.jdField_b_of_type_ArrayOfInt[(i2 & 0xFF)];
      i6 = n;
      i5 = m;
      i4 = k;
      i3 = j;
      i2 = i;
      if (i7 != 0)
      {
        i6 = n + (i7 >> 24 & 0xFF);
        i5 = m + (i7 >> 16 & 0xFF);
        i4 = k + (i7 >> 8 & 0xFF);
        i3 = j + (i7 & 0xFF);
        i2 = i + 1;
      }
      i1 += 1;
      n = i6;
      m = i5;
      k = i4;
      j = i3;
    }
    int i5 = paramInt1 + paramInt3;
    paramInt1 = i5;
    int i2 = n;
    while (paramInt1 < this.jdField_c_of_type_Int + i5)
    {
      arrayOfByte = this.jdField_d_of_type_ArrayOfByte;
      if ((paramInt1 >= arrayOfByte.length) || (paramInt1 >= paramInt2)) {
        break;
      }
      paramInt3 = arrayOfByte[paramInt1];
      i6 = this.jdField_b_of_type_ArrayOfInt[(paramInt3 & 0xFF)];
      i4 = i2;
      i3 = m;
      i1 = k;
      n = j;
      paramInt3 = i;
      if (i6 != 0)
      {
        i4 = i2 + (i6 >> 24 & 0xFF);
        i3 = m + (i6 >> 16 & 0xFF);
        i1 = k + (i6 >> 8 & 0xFF);
        n = j + (i6 & 0xFF);
        paramInt3 = i + 1;
      }
      paramInt1 += 1;
      i2 = i4;
      m = i3;
      k = i1;
      j = n;
      i = paramInt3;
    }
    if (i == 0) {
      return 0;
    }
    return i2 / i << 24 | m / i << 16 | k / i << 8 | j / i;
  }
  
  private int a(GifFrame paramGifFrame)
  {
    int i;
    if (paramGifFrame != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.position(paramGifFrame.h);
      i = paramGifFrame.jdField_c_of_type_Int * paramGifFrame.jdField_d_of_type_Int;
    }
    else
    {
      i = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_c_of_type_Int;
      i = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_d_of_type_Int * i;
    }
    paramGifFrame = this.jdField_d_of_type_ArrayOfByte;
    if ((paramGifFrame == null) || (paramGifFrame.length < i)) {
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
  
  private Bitmap a(GifFrame paramGifFrame1, GifFrame paramGifFrame2)
  {
    int[] arrayOfInt = this.jdField_c_of_type_ArrayOfInt;
    int i = 0;
    if (paramGifFrame2 == null)
    {
      paramGifFrame2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (paramGifFrame2 != null) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider.a(paramGifFrame2);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      Arrays.fill(arrayOfInt, 0);
    }
    else if (paramGifFrame2.e > 0)
    {
      if (paramGifFrame2.e == 2)
      {
        int j = i;
        if (!paramGifFrame1.jdField_b_of_type_Boolean)
        {
          j = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.h;
          if ((paramGifFrame1.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.f == paramGifFrame1.f)) {
            j = i;
          }
        }
        int n = paramGifFrame2.jdField_d_of_type_Int / this.jdField_c_of_type_Int;
        i = paramGifFrame2.jdField_b_of_type_Int / this.jdField_c_of_type_Int;
        int i1 = paramGifFrame2.jdField_c_of_type_Int / this.jdField_c_of_type_Int;
        int k = paramGifFrame2.jdField_a_of_type_Int / this.jdField_c_of_type_Int;
        int i2 = this.e;
        int m = i * i2 + k;
        i = m;
        while (i < n * i2 + m)
        {
          k = i;
          while (k < i + i1)
          {
            arrayOfInt[k] = j;
            k += 1;
          }
          i += this.e;
        }
      }
      if (paramGifFrame2.e == 3)
      {
        paramGifFrame2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if (paramGifFrame2 == null)
        {
          Arrays.fill(arrayOfInt, 0);
        }
        else
        {
          i = this.e;
          paramGifFrame2.getPixels(arrayOfInt, 0, i, 0, 0, i, this.jdField_d_of_type_Int);
        }
      }
    }
    c(paramGifFrame1);
    if ((!paramGifFrame1.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Int == 1)) {
      a(paramGifFrame1);
    } else {
      b(paramGifFrame1);
    }
    if ((this.jdField_a_of_type_Boolean) && ((paramGifFrame1.e == 0) || (paramGifFrame1.e == 1)))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = b();
      }
      paramGifFrame1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      i = this.e;
      paramGifFrame1.setPixels(arrayOfInt, 0, i, 0, 0, i, this.jdField_d_of_type_Int);
    }
    paramGifFrame1 = b();
    i = this.e;
    paramGifFrame1.setPixels(arrayOfInt, 0, i, 0, 0, i, this.jdField_d_of_type_Int);
    return paramGifFrame1;
  }
  
  private void a(GifFrame paramGifFrame)
  {
    Object localObject = paramGifFrame;
    int[] arrayOfInt1 = this.jdField_c_of_type_ArrayOfInt;
    int i4 = ((GifFrame)localObject).jdField_d_of_type_Int;
    int i5 = ((GifFrame)localObject).jdField_b_of_type_Int;
    int i6 = ((GifFrame)localObject).jdField_c_of_type_Int;
    int i7 = ((GifFrame)localObject).jdField_a_of_type_Int;
    int i;
    if (this.jdField_a_of_type_Int == 0) {
      i = 1;
    } else {
      i = 0;
    }
    int i8 = this.e;
    localObject = this.jdField_d_of_type_ArrayOfByte;
    int[] arrayOfInt2 = this.jdField_b_of_type_ArrayOfInt;
    int j = 0;
    int m = -1;
    while (j < i4)
    {
      int k = (j + i5) * i8;
      int i1 = k + i7;
      int n = i1 + i6;
      int i2 = k + i8;
      k = n;
      if (i2 < n) {
        k = i2;
      }
      n = paramGifFrame.jdField_c_of_type_Int * j;
      while (i1 < k)
      {
        int i3 = localObject[n];
        int i9 = i3 & 0xFF;
        i2 = m;
        if (i9 != m)
        {
          i2 = arrayOfInt2[i9];
          if (i2 != 0)
          {
            arrayOfInt1[i1] = i2;
            i2 = m;
          }
          else
          {
            i2 = i3;
          }
        }
        n += 1;
        i1 += 1;
        m = i2;
      }
      j += 1;
    }
    paramGifFrame = this.jdField_a_of_type_JavaLangBoolean;
    boolean bool;
    if (((paramGifFrame != null) && (paramGifFrame.booleanValue())) || ((this.jdField_a_of_type_JavaLangBoolean == null) && (i != 0) && (m != -1))) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
  }
  
  private int b()
  {
    return this.jdField_a_of_type_JavaNioByteBuffer.get() & 0xFF;
  }
  
  private Bitmap b()
  {
    Object localObject = this.jdField_a_of_type_JavaLangBoolean;
    if ((localObject != null) && (!((Boolean)localObject).booleanValue())) {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap$Config;
    } else {
      localObject = Bitmap.Config.ARGB_8888;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider.a(this.e, this.jdField_d_of_type_Int, (Bitmap.Config)localObject);
    ((Bitmap)localObject).setHasAlpha(true);
    return localObject;
  }
  
  private void b(GifFrame paramGifFrame)
  {
    int[] arrayOfInt1 = this.jdField_c_of_type_ArrayOfInt;
    int i3 = paramGifFrame.jdField_d_of_type_Int / this.jdField_c_of_type_Int;
    int i2 = paramGifFrame.jdField_b_of_type_Int / this.jdField_c_of_type_Int;
    int i = paramGifFrame.jdField_c_of_type_Int / this.jdField_c_of_type_Int;
    int i11 = paramGifFrame.jdField_a_of_type_Int / this.jdField_c_of_type_Int;
    int j = this.jdField_a_of_type_Int;
    Boolean localBoolean = Boolean.valueOf(true);
    int i1;
    if (j == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i12 = this.jdField_c_of_type_Int;
    int i13 = this.e;
    int i14 = this.jdField_d_of_type_Int;
    byte[] arrayOfByte = this.jdField_d_of_type_ArrayOfByte;
    int[] arrayOfInt2 = this.jdField_b_of_type_ArrayOfInt;
    Object localObject1 = this.jdField_a_of_type_JavaLangBoolean;
    int m = 0;
    j = 0;
    int n = 1;
    int i5;
    for (int k = 8; m < i3; k = i5)
    {
      int i4;
      int i6;
      if (paramGifFrame.jdField_a_of_type_Boolean)
      {
        if (j >= i3)
        {
          n += 1;
          if (n != 2)
          {
            if (n != 3)
            {
              if (n == 4)
              {
                j = 1;
                k = 2;
              }
            }
            else
            {
              j = 2;
              k = 4;
            }
          }
          else {
            j = 4;
          }
        }
        i4 = j + k;
        i6 = j;
        j = i4;
        i4 = n;
        i5 = k;
      }
      else
      {
        i6 = m;
        i5 = k;
        i4 = n;
      }
      k = i6 + i2;
      if (i12 == 1) {
        n = 1;
      } else {
        n = 0;
      }
      if (k < i14)
      {
        k *= i13;
        i6 = k + i11;
        int i7 = i6 + i;
        int i8 = k + i13;
        k = i7;
        if (i8 < i7) {
          k = i8;
        }
        i7 = m * i12 * paramGifFrame.jdField_c_of_type_Int;
        if (n != 0) {
          for (;;)
          {
            n = i;
            localObject2 = localObject1;
            if (i6 >= k) {
              break;
            }
            n = arrayOfInt2[(arrayOfByte[i7] & 0xFF)];
            if (n != 0)
            {
              arrayOfInt1[i6] = n;
              localObject2 = localObject1;
            }
            else
            {
              localObject2 = localObject1;
              if (i1 != 0)
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = localBoolean;
                }
              }
            }
            i7 += i12;
            i6 += 1;
            localObject1 = localObject2;
          }
        }
        i8 = i;
        int i9 = i6;
        n = i7;
        i = k;
        for (;;)
        {
          int i10 = n;
          n = i;
          localObject2 = localObject1;
          i = i8;
          if (i9 >= n) {
            break;
          }
          i = a(i10, (k - i6) * i12 + i7, paramGifFrame.jdField_c_of_type_Int);
          if (i != 0)
          {
            arrayOfInt1[i9] = i;
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if (i1 != 0)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = localBoolean;
              }
            }
          }
          i10 += i12;
          i9 += 1;
          i = n;
          n = i10;
          localObject1 = localObject2;
        }
      }
      Object localObject2 = localObject1;
      n = i;
      i = n;
      m += 1;
      localObject1 = localObject2;
      n = i4;
    }
    if (this.jdField_a_of_type_JavaLangBoolean == null)
    {
      boolean bool;
      if (localObject1 == null) {
        bool = false;
      } else {
        bool = ((Boolean)localObject1).booleanValue();
      }
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
    }
  }
  
  private int c()
  {
    int i = b();
    if (i <= 0) {
      return i;
    }
    ByteBuffer localByteBuffer = this.jdField_a_of_type_JavaNioByteBuffer;
    localByteBuffer.get(this.jdField_a_of_type_ArrayOfByte, 0, Math.min(i, localByteBuffer.remaining()));
    return i;
  }
  
  private void c(GifFrame paramGifFrame)
  {
    Object localObject1 = this;
    int i18 = a(paramGifFrame);
    byte[] arrayOfByte1 = ((StandardGifDecoder)localObject1).jdField_d_of_type_ArrayOfByte;
    short[] arrayOfShort = ((StandardGifDecoder)localObject1).jdField_a_of_type_ArrayOfShort;
    byte[] arrayOfByte2 = ((StandardGifDecoder)localObject1).jdField_b_of_type_ArrayOfByte;
    Object localObject2 = ((StandardGifDecoder)localObject1).jdField_c_of_type_ArrayOfByte;
    int j = b();
    int i15 = 1 << j;
    int i11 = i15 + 2;
    int i3 = j + 1;
    int i12 = (1 << i3) - 1;
    int i9 = 0;
    j = 0;
    while (j < i15)
    {
      arrayOfShort[j] = 0;
      arrayOfByte2[j] = ((byte)j);
      j += 1;
    }
    byte[] arrayOfByte3 = ((StandardGifDecoder)localObject1).jdField_a_of_type_ArrayOfByte;
    int m = i3;
    int n = i11;
    int i4 = i12;
    int k = 0;
    int i8 = 0;
    int i10 = 0;
    int i7 = 0;
    int i5 = 0;
    int i1 = -1;
    int i2 = 0;
    int i6 = 0;
    j = i9;
    i9 = i15;
    paramGifFrame = (GifFrame)localObject1;
    for (;;)
    {
      int i13 = i9;
      if (k >= i18) {
        break;
      }
      i9 = i8;
      if (i8 == 0)
      {
        i9 = c();
        if (i9 <= 0)
        {
          paramGifFrame.jdField_b_of_type_Int = 3;
          break;
        }
        i10 = 0;
      }
      i7 += ((arrayOfByte3[i10] & 0xFF) << i5);
      int i16 = i10 + 1;
      int i17 = i9 - 1;
      i8 = i1;
      i9 = i5 + 8;
      i1 = m;
      m = j;
      i5 = i13;
      j = i8;
      localObject1 = localObject2;
      for (;;)
      {
        label249:
        if (i9 < i1) {
          break label651;
        }
        i8 = i7 & i4;
        i7 >>= i1;
        i9 -= i1;
        if (i8 == i5)
        {
          i1 = i3;
          n = i11;
          i4 = i12;
          j = -1;
        }
        for (;;)
        {
          break label249;
          if (i8 == i15 + 1)
          {
            i14 = i9;
            i13 = i1;
            i1 = j;
            localObject2 = localObject1;
            i9 = i5;
            j = m;
            i8 = i17;
            i10 = i16;
            i5 = i14;
            m = i13;
            break;
          }
          if (j != -1) {
            break label389;
          }
          arrayOfByte1[m] = arrayOfByte2[i8];
          m += 1;
          k += 1;
          paramGifFrame = this;
          j = i8;
          i2 = j;
        }
        label389:
        i10 = n;
        if (i8 >= i10)
        {
          localObject1[i6] = ((byte)i2);
          n = i6 + 1;
          i2 = j;
        }
        else
        {
          i2 = i8;
          n = i6;
        }
        while (i2 >= i5)
        {
          localObject1[n] = arrayOfByte2[i2];
          n += 1;
          i2 = arrayOfShort[i2];
        }
        i14 = arrayOfByte2[i2] & 0xFF;
        int i = (byte)i14;
        arrayOfByte1[m] = i;
        for (;;)
        {
          m += 1;
          i2 = k + 1;
          if (n <= 0) {
            break;
          }
          n -= 1;
          arrayOfByte1[m] = localObject1[n];
          k = i2;
        }
        k = i10;
        i13 = i1;
        i6 = i4;
        if (i10 < 4096)
        {
          arrayOfShort[i10] = ((short)j);
          arrayOfByte2[i10] = i;
          j = i10 + 1;
          k = j;
          i13 = i1;
          i6 = i4;
          if ((j & i4) == 0)
          {
            k = j;
            i13 = i1;
            i6 = i4;
            if (j < 4096)
            {
              i13 = i1 + 1;
              i6 = i4 + j;
              k = j;
            }
          }
        }
        i10 = i14;
        j = i8;
        i8 = k;
        paramGifFrame = this;
        i1 = i13;
        k = i2;
        i4 = i6;
        i6 = n;
        n = i8;
        i2 = i10;
      }
      label651:
      i13 = i9;
      i8 = m;
      m = j;
      int i14 = i1;
      paramGifFrame = this;
      localObject2 = localObject1;
      i9 = i5;
      j = i8;
      i8 = i17;
      i10 = i16;
      i5 = i13;
      i1 = m;
      m = i14;
    }
    Arrays.fill(arrayOfByte1, j, i18, (byte)0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int)) {
      return ((GifFrame)this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_JavaUtilList.get(paramInt)).g;
    }
    return -1;
  }
  
  @Nullable
  public Bitmap a()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        Object localObject4;
        if ((this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int <= 0) || (this.jdField_a_of_type_Int < 0))
        {
          if (Log.isLoggable(jdField_a_of_type_JavaLangString, 3))
          {
            localObject1 = jdField_a_of_type_JavaLangString;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Unable to decode frame, frameCount=");
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int);
            ((StringBuilder)localObject4).append(", framePointer=");
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_Int);
            Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
          }
          this.jdField_b_of_type_Int = 1;
        }
        if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 2))
        {
          this.jdField_b_of_type_Int = 0;
          if (this.jdField_a_of_type_ArrayOfByte == null) {
            this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifDecoder$BitmapProvider.a(255);
          }
          GifFrame localGifFrame = (GifFrame)this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
          int i = this.jdField_a_of_type_Int - 1;
          if (i >= 0)
          {
            localObject1 = (GifFrame)this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_JavaUtilList.get(i);
            if (localGifFrame.jdField_a_of_type_ArrayOfInt != null) {
              localObject4 = localGifFrame.jdField_a_of_type_ArrayOfInt;
            } else {
              localObject4 = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ArrayOfInt;
            }
            this.jdField_b_of_type_ArrayOfInt = ((int[])localObject4);
            if (this.jdField_b_of_type_ArrayOfInt == null)
            {
              if (Log.isLoggable(jdField_a_of_type_JavaLangString, 3))
              {
                localObject1 = jdField_a_of_type_JavaLangString;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("No valid color table found for frame #");
                ((StringBuilder)localObject4).append(this.jdField_a_of_type_Int);
                Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
              }
              this.jdField_b_of_type_Int = 1;
              return null;
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
            return localObject1;
          }
        }
        else
        {
          if (Log.isLoggable(jdField_a_of_type_JavaLangString, 3))
          {
            localObject1 = jdField_a_of_type_JavaLangString;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Unable to decode frame, status=");
            ((StringBuilder)localObject4).append(this.jdField_b_of_type_Int);
            Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
          }
          return null;
        }
      }
      finally {}
      Object localObject3 = null;
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
    if (paramInt > 0) {
      try
      {
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
        return;
      }
      finally
      {
        break label209;
      }
    }
    paramGifHeader = new StringBuilder();
    paramGifHeader.append("Sample size must be >=0, not: ");
    paramGifHeader.append(paramInt);
    throw new IllegalArgumentException(paramGifHeader.toString());
    for (;;)
    {
      label209:
      throw paramGifHeader;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.StandardGifDecoder
 * JD-Core Version:    0.7.0.1
 */