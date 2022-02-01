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
  private static final String a = "StandardGifDecoder";
  @ColorInt
  private final int[] b = new int[256];
  private final GifDecoder.BitmapProvider c;
  @ColorInt
  private int[] d;
  private ByteBuffer e;
  private byte[] f;
  private short[] g;
  private byte[] h;
  private byte[] i;
  private byte[] j;
  @ColorInt
  private int[] k;
  private int l;
  private GifHeader m;
  private Bitmap n;
  private boolean o;
  private int p;
  private int q;
  private int r;
  private int s;
  @Nullable
  private Boolean t;
  @NotNull
  private Bitmap.Config u = Bitmap.Config.ARGB_8888;
  
  public StandardGifDecoder(@NotNull GifDecoder.BitmapProvider paramBitmapProvider)
  {
    this.c = paramBitmapProvider;
    this.m = new GifHeader();
  }
  
  @ColorInt
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i6 = paramInt1;
    int i5 = 0;
    int i4 = 0;
    int i3 = 0;
    int i2 = 0;
    byte[] arrayOfByte;
    int i11;
    int i9;
    int i8;
    for (int i1 = 0; i6 < this.q + paramInt1; i1 = i7)
    {
      arrayOfByte = this.j;
      if ((i6 >= arrayOfByte.length) || (i6 >= paramInt2)) {
        break;
      }
      i7 = arrayOfByte[i6];
      int i12 = this.d[(i7 & 0xFF)];
      i11 = i5;
      i10 = i4;
      i9 = i3;
      i8 = i2;
      i7 = i1;
      if (i12 != 0)
      {
        i11 = i5 + (i12 >> 24 & 0xFF);
        i10 = i4 + (i12 >> 16 & 0xFF);
        i9 = i3 + (i12 >> 8 & 0xFF);
        i8 = i2 + (i12 & 0xFF);
        i7 = i1 + 1;
      }
      i6 += 1;
      i5 = i11;
      i4 = i10;
      i3 = i9;
      i2 = i8;
    }
    int i10 = paramInt1 + paramInt3;
    paramInt1 = i10;
    int i7 = i5;
    while (paramInt1 < this.q + i10)
    {
      arrayOfByte = this.j;
      if ((paramInt1 >= arrayOfByte.length) || (paramInt1 >= paramInt2)) {
        break;
      }
      paramInt3 = arrayOfByte[paramInt1];
      i11 = this.d[(paramInt3 & 0xFF)];
      i9 = i7;
      i8 = i4;
      i6 = i3;
      i5 = i2;
      paramInt3 = i1;
      if (i11 != 0)
      {
        i9 = i7 + (i11 >> 24 & 0xFF);
        i8 = i4 + (i11 >> 16 & 0xFF);
        i6 = i3 + (i11 >> 8 & 0xFF);
        i5 = i2 + (i11 & 0xFF);
        paramInt3 = i1 + 1;
      }
      paramInt1 += 1;
      i7 = i9;
      i4 = i8;
      i3 = i6;
      i2 = i5;
      i1 = paramInt3;
    }
    if (i1 == 0) {
      return 0;
    }
    return i7 / i1 << 24 | i4 / i1 << 16 | i3 / i1 << 8 | i2 / i1;
  }
  
  private Bitmap a(GifFrame paramGifFrame1, GifFrame paramGifFrame2)
  {
    int[] arrayOfInt = this.k;
    int i1 = 0;
    if (paramGifFrame2 == null)
    {
      paramGifFrame2 = this.n;
      if (paramGifFrame2 != null) {
        this.c.a(paramGifFrame2);
      }
      this.n = null;
      Arrays.fill(arrayOfInt, 0);
    }
    else if (paramGifFrame2.g > 0)
    {
      if (paramGifFrame2.g == 2)
      {
        int i2 = i1;
        if (!paramGifFrame1.f)
        {
          i2 = this.m.l;
          if ((paramGifFrame1.k != null) && (this.m.j == paramGifFrame1.h)) {
            i2 = i1;
          }
        }
        int i5 = paramGifFrame2.d / this.q;
        i1 = paramGifFrame2.b / this.q;
        int i6 = paramGifFrame2.c / this.q;
        int i3 = paramGifFrame2.a / this.q;
        int i7 = this.s;
        int i4 = i1 * i7 + i3;
        i1 = i4;
        while (i1 < i5 * i7 + i4)
        {
          i3 = i1;
          while (i3 < i1 + i6)
          {
            arrayOfInt[i3] = i2;
            i3 += 1;
          }
          i1 += this.s;
        }
      }
      if (paramGifFrame2.g == 3)
      {
        paramGifFrame2 = this.n;
        if (paramGifFrame2 == null)
        {
          Arrays.fill(arrayOfInt, 0);
        }
        else
        {
          i1 = this.s;
          paramGifFrame2.getPixels(arrayOfInt, 0, i1, 0, 0, i1, this.r);
        }
      }
    }
    d(paramGifFrame1);
    if ((!paramGifFrame1.e) && (this.q == 1)) {
      a(paramGifFrame1);
    } else {
      b(paramGifFrame1);
    }
    if ((this.o) && ((paramGifFrame1.g == 0) || (paramGifFrame1.g == 1)))
    {
      if (this.n == null) {
        this.n = f();
      }
      paramGifFrame1 = this.n;
      i1 = this.s;
      paramGifFrame1.setPixels(arrayOfInt, 0, i1, 0, 0, i1, this.r);
    }
    paramGifFrame1 = f();
    i1 = this.s;
    paramGifFrame1.setPixels(arrayOfInt, 0, i1, 0, 0, i1, this.r);
    return paramGifFrame1;
  }
  
  private void a(GifFrame paramGifFrame)
  {
    Object localObject = paramGifFrame;
    int[] arrayOfInt1 = this.k;
    int i9 = ((GifFrame)localObject).d;
    int i10 = ((GifFrame)localObject).b;
    int i11 = ((GifFrame)localObject).c;
    int i12 = ((GifFrame)localObject).a;
    int i1;
    if (this.l == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i13 = this.s;
    localObject = this.j;
    int[] arrayOfInt2 = this.d;
    int i2 = 0;
    int i4 = -1;
    while (i2 < i9)
    {
      int i3 = (i2 + i10) * i13;
      int i6 = i3 + i12;
      int i5 = i6 + i11;
      int i7 = i3 + i13;
      i3 = i5;
      if (i7 < i5) {
        i3 = i7;
      }
      i5 = paramGifFrame.c * i2;
      while (i6 < i3)
      {
        int i8 = localObject[i5];
        int i14 = i8 & 0xFF;
        i7 = i4;
        if (i14 != i4)
        {
          i7 = arrayOfInt2[i14];
          if (i7 != 0)
          {
            arrayOfInt1[i6] = i7;
            i7 = i4;
          }
          else
          {
            i7 = i8;
          }
        }
        i5 += 1;
        i6 += 1;
        i4 = i7;
      }
      i2 += 1;
    }
    paramGifFrame = this.t;
    boolean bool;
    if (((paramGifFrame != null) && (paramGifFrame.booleanValue())) || ((this.t == null) && (i1 != 0) && (i4 != -1))) {
      bool = true;
    } else {
      bool = false;
    }
    this.t = Boolean.valueOf(bool);
  }
  
  private void b(GifFrame paramGifFrame)
  {
    int[] arrayOfInt1 = this.k;
    int i8 = paramGifFrame.d / this.q;
    int i7 = paramGifFrame.b / this.q;
    int i1 = paramGifFrame.c / this.q;
    int i16 = paramGifFrame.a / this.q;
    int i2 = this.l;
    Boolean localBoolean = Boolean.valueOf(true);
    int i6;
    if (i2 == 0) {
      i6 = 1;
    } else {
      i6 = 0;
    }
    int i17 = this.q;
    int i18 = this.s;
    int i19 = this.r;
    byte[] arrayOfByte = this.j;
    int[] arrayOfInt2 = this.d;
    Object localObject1 = this.t;
    int i4 = 0;
    i2 = 0;
    int i5 = 1;
    int i10;
    for (int i3 = 8; i4 < i8; i3 = i10)
    {
      int i9;
      int i11;
      if (paramGifFrame.e)
      {
        if (i2 >= i8)
        {
          i5 += 1;
          if (i5 != 2)
          {
            if (i5 != 3)
            {
              if (i5 == 4)
              {
                i2 = 1;
                i3 = 2;
              }
            }
            else
            {
              i2 = 2;
              i3 = 4;
            }
          }
          else {
            i2 = 4;
          }
        }
        i9 = i2 + i3;
        i11 = i2;
        i2 = i9;
        i9 = i5;
        i10 = i3;
      }
      else
      {
        i11 = i4;
        i10 = i3;
        i9 = i5;
      }
      i3 = i11 + i7;
      if (i17 == 1) {
        i5 = 1;
      } else {
        i5 = 0;
      }
      if (i3 < i19)
      {
        i3 *= i18;
        i11 = i3 + i16;
        int i12 = i11 + i1;
        int i13 = i3 + i18;
        i3 = i12;
        if (i13 < i12) {
          i3 = i13;
        }
        i12 = i4 * i17 * paramGifFrame.c;
        if (i5 != 0) {
          for (;;)
          {
            i5 = i1;
            localObject2 = localObject1;
            if (i11 >= i3) {
              break;
            }
            i5 = arrayOfInt2[(arrayOfByte[i12] & 0xFF)];
            if (i5 != 0)
            {
              arrayOfInt1[i11] = i5;
              localObject2 = localObject1;
            }
            else
            {
              localObject2 = localObject1;
              if (i6 != 0)
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = localBoolean;
                }
              }
            }
            i12 += i17;
            i11 += 1;
            localObject1 = localObject2;
          }
        }
        i13 = i1;
        int i14 = i11;
        i5 = i12;
        i1 = i3;
        for (;;)
        {
          int i15 = i5;
          i5 = i1;
          localObject2 = localObject1;
          i1 = i13;
          if (i14 >= i5) {
            break;
          }
          i1 = a(i15, (i3 - i11) * i17 + i12, paramGifFrame.c);
          if (i1 != 0)
          {
            arrayOfInt1[i14] = i1;
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if (i6 != 0)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = localBoolean;
              }
            }
          }
          i15 += i17;
          i14 += 1;
          i1 = i5;
          i5 = i15;
          localObject1 = localObject2;
        }
      }
      Object localObject2 = localObject1;
      i5 = i1;
      i1 = i5;
      i4 += 1;
      localObject1 = localObject2;
      i5 = i9;
    }
    if (this.t == null)
    {
      boolean bool;
      if (localObject1 == null) {
        bool = false;
      } else {
        bool = ((Boolean)localObject1).booleanValue();
      }
      this.t = Boolean.valueOf(bool);
    }
  }
  
  private int c(GifFrame paramGifFrame)
  {
    int i1;
    if (paramGifFrame != null)
    {
      this.e.position(paramGifFrame.j);
      i1 = paramGifFrame.c * paramGifFrame.d;
    }
    else
    {
      i1 = this.m.f;
      i1 = this.m.g * i1;
    }
    paramGifFrame = this.j;
    if ((paramGifFrame == null) || (paramGifFrame.length < i1)) {
      this.j = this.c.a(i1);
    }
    if (this.g == null) {
      this.g = new short[4096];
    }
    if (this.h == null) {
      this.h = new byte[4096];
    }
    if (this.i == null) {
      this.i = new byte[4097];
    }
    return i1;
  }
  
  private int d()
  {
    return this.e.get() & 0xFF;
  }
  
  private void d(GifFrame paramGifFrame)
  {
    Object localObject1 = this;
    int i23 = c(paramGifFrame);
    byte[] arrayOfByte1 = ((StandardGifDecoder)localObject1).j;
    short[] arrayOfShort = ((StandardGifDecoder)localObject1).g;
    byte[] arrayOfByte2 = ((StandardGifDecoder)localObject1).h;
    Object localObject2 = ((StandardGifDecoder)localObject1).i;
    int i2 = d();
    int i20 = 1 << i2;
    int i16 = i20 + 2;
    int i8 = i2 + 1;
    int i17 = (1 << i8) - 1;
    int i14 = 0;
    i2 = 0;
    while (i2 < i20)
    {
      arrayOfShort[i2] = 0;
      arrayOfByte2[i2] = ((byte)i2);
      i2 += 1;
    }
    byte[] arrayOfByte3 = ((StandardGifDecoder)localObject1).f;
    int i4 = i8;
    int i5 = i16;
    int i9 = i17;
    int i3 = 0;
    int i13 = 0;
    int i15 = 0;
    int i12 = 0;
    int i10 = 0;
    int i6 = -1;
    int i7 = 0;
    int i11 = 0;
    i2 = i14;
    i14 = i20;
    paramGifFrame = (GifFrame)localObject1;
    for (;;)
    {
      int i18 = i14;
      if (i3 >= i23) {
        break;
      }
      i14 = i13;
      if (i13 == 0)
      {
        i14 = e();
        if (i14 <= 0)
        {
          paramGifFrame.p = 3;
          break;
        }
        i15 = 0;
      }
      i12 += ((arrayOfByte3[i15] & 0xFF) << i10);
      int i21 = i15 + 1;
      int i22 = i14 - 1;
      i13 = i6;
      i14 = i10 + 8;
      i6 = i4;
      i4 = i2;
      i10 = i18;
      i2 = i13;
      localObject1 = localObject2;
      for (;;)
      {
        label249:
        if (i14 < i6) {
          break label651;
        }
        i13 = i12 & i9;
        i12 >>= i6;
        i14 -= i6;
        if (i13 == i10)
        {
          i6 = i8;
          i5 = i16;
          i9 = i17;
          i2 = -1;
        }
        for (;;)
        {
          break label249;
          if (i13 == i20 + 1)
          {
            i19 = i14;
            i18 = i6;
            i6 = i2;
            localObject2 = localObject1;
            i14 = i10;
            i2 = i4;
            i13 = i22;
            i15 = i21;
            i10 = i19;
            i4 = i18;
            break;
          }
          if (i2 != -1) {
            break label389;
          }
          arrayOfByte1[i4] = arrayOfByte2[i13];
          i4 += 1;
          i3 += 1;
          paramGifFrame = this;
          i2 = i13;
          i7 = i2;
        }
        label389:
        i15 = i5;
        if (i13 >= i15)
        {
          localObject1[i11] = ((byte)i7);
          i5 = i11 + 1;
          i7 = i2;
        }
        else
        {
          i7 = i13;
          i5 = i11;
        }
        while (i7 >= i10)
        {
          localObject1[i5] = arrayOfByte2[i7];
          i5 += 1;
          i7 = arrayOfShort[i7];
        }
        i19 = arrayOfByte2[i7] & 0xFF;
        int i1 = (byte)i19;
        arrayOfByte1[i4] = i1;
        for (;;)
        {
          i4 += 1;
          i7 = i3 + 1;
          if (i5 <= 0) {
            break;
          }
          i5 -= 1;
          arrayOfByte1[i4] = localObject1[i5];
          i3 = i7;
        }
        i3 = i15;
        i18 = i6;
        i11 = i9;
        if (i15 < 4096)
        {
          arrayOfShort[i15] = ((short)i2);
          arrayOfByte2[i15] = i1;
          i2 = i15 + 1;
          i3 = i2;
          i18 = i6;
          i11 = i9;
          if ((i2 & i9) == 0)
          {
            i3 = i2;
            i18 = i6;
            i11 = i9;
            if (i2 < 4096)
            {
              i18 = i6 + 1;
              i11 = i9 + i2;
              i3 = i2;
            }
          }
        }
        i15 = i19;
        i2 = i13;
        i13 = i3;
        paramGifFrame = this;
        i6 = i18;
        i3 = i7;
        i9 = i11;
        i11 = i5;
        i5 = i13;
        i7 = i15;
      }
      label651:
      i18 = i14;
      i13 = i4;
      i4 = i2;
      int i19 = i6;
      paramGifFrame = this;
      localObject2 = localObject1;
      i14 = i10;
      i2 = i13;
      i13 = i22;
      i15 = i21;
      i10 = i18;
      i6 = i4;
      i4 = i19;
    }
    Arrays.fill(arrayOfByte1, i2, i23, (byte)0);
  }
  
  private int e()
  {
    int i1 = d();
    if (i1 <= 0) {
      return i1;
    }
    ByteBuffer localByteBuffer = this.e;
    localByteBuffer.get(this.f, 0, Math.min(i1, localByteBuffer.remaining()));
    return i1;
  }
  
  private Bitmap f()
  {
    Object localObject = this.t;
    if ((localObject != null) && (!((Boolean)localObject).booleanValue())) {
      localObject = this.u;
    } else {
      localObject = Bitmap.Config.ARGB_8888;
    }
    localObject = this.c.a(this.s, this.r, (Bitmap.Config)localObject);
    ((Bitmap)localObject).setHasAlpha(true);
    return localObject;
  }
  
  public int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.m.d)) {
      return ((GifFrame)this.m.a.get(paramInt)).i;
    }
    return -1;
  }
  
  public void a()
  {
    this.l = ((this.l + 1) % this.m.d);
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
        this.p = 0;
        this.m = paramGifHeader;
        this.l = -1;
        this.e = paramByteBuffer.asReadOnlyBuffer();
        this.e.position(0);
        this.e.order(ByteOrder.LITTLE_ENDIAN);
        this.o = false;
        paramByteBuffer = paramGifHeader.a.iterator();
        while (paramByteBuffer.hasNext()) {
          if (((GifFrame)paramByteBuffer.next()).g == 3) {
            this.o = true;
          }
        }
        this.q = paramInt;
        this.s = (paramGifHeader.f / paramInt);
        this.r = (paramGifHeader.g / paramInt);
        this.j = this.c.a(paramGifHeader.f * paramGifHeader.g);
        this.k = this.c.b(this.s * this.r);
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
  
  public int b()
  {
    return this.m.d;
  }
  
  @Nullable
  public Bitmap c()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        Object localObject4;
        if ((this.m.d <= 0) || (this.l < 0))
        {
          if (Log.isLoggable(a, 3))
          {
            localObject1 = a;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Unable to decode frame, frameCount=");
            ((StringBuilder)localObject4).append(this.m.d);
            ((StringBuilder)localObject4).append(", framePointer=");
            ((StringBuilder)localObject4).append(this.l);
            Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
          }
          this.p = 1;
        }
        if ((this.p != 1) && (this.p != 2))
        {
          this.p = 0;
          if (this.f == null) {
            this.f = this.c.a(255);
          }
          GifFrame localGifFrame = (GifFrame)this.m.a.get(this.l);
          int i1 = this.l - 1;
          if (i1 >= 0)
          {
            localObject1 = (GifFrame)this.m.a.get(i1);
            if (localGifFrame.k != null) {
              localObject4 = localGifFrame.k;
            } else {
              localObject4 = this.m.b;
            }
            this.d = ((int[])localObject4);
            if (this.d == null)
            {
              if (Log.isLoggable(a, 3))
              {
                localObject1 = a;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("No valid color table found for frame #");
                ((StringBuilder)localObject4).append(this.l);
                Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
              }
              this.p = 1;
              return null;
            }
            if (localGifFrame.f)
            {
              System.arraycopy(this.d, 0, this.b, 0, this.d.length);
              this.d = this.b;
              this.d[localGifFrame.h] = 0;
              if ((localGifFrame.g == 2) && (this.l == 0)) {
                this.t = Boolean.valueOf(true);
              }
            }
            localObject1 = a(localGifFrame, (GifFrame)localObject1);
            return localObject1;
          }
        }
        else
        {
          if (Log.isLoggable(a, 3))
          {
            localObject1 = a;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Unable to decode frame, status=");
            ((StringBuilder)localObject4).append(this.p);
            Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
          }
          return null;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.StandardGifDecoder
 * JD-Core Version:    0.7.0.1
 */