package com.tencent.tkd.topicsdk.imagecompress.encodedecode;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GifHeaderParser
{
  private static final int jdField_a_of_type_Int = (int)Long.parseLong("0b00011100", 2);
  private static final int b;
  private static final int c = (int)Long.parseLong("0b10000000", 2);
  private static final int d = (int)Long.parseLong("0b01000000", 2);
  private static final int e = (int)Long.parseLong("0b00000111", 2);
  private static final int f = (int)Long.parseLong("0b10000000", 2);
  private static final int g = (int)Long.parseLong("0b00000111", 2);
  private GifHeader jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[256];
  private int h = 0;
  
  static
  {
    jdField_b_of_type_Int = (int)Long.parseLong("0b00000001", 2);
  }
  
  private int a()
  {
    try
    {
      int i = this.jdField_a_of_type_JavaNioByteBuffer.get();
      return i & 0xFF;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 1;
    }
    return 0;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    Arrays.fill(this.jdField_a_of_type_ArrayOfByte, (byte)0);
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader = new GifHeader();
    this.h = 0;
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    while ((i == 0) && (!a()) && (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int <= paramInt)) {
      switch (a())
      {
      default: 
        this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 1;
        break;
      case 44: 
        if (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame == null) {
          this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame = new GifFrame();
        }
        d();
        break;
      case 33: 
        switch (a())
        {
        default: 
          i();
          break;
        case 249: 
          this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame = new GifFrame();
          c();
          break;
        case 255: 
          j();
          StringBuilder localStringBuilder = new StringBuilder();
          int j = 0;
          while (j < 11)
          {
            localStringBuilder.append((char)this.jdField_a_of_type_ArrayOfByte[j]);
            j += 1;
          }
          if (localStringBuilder.toString().equals("NETSCAPE2.0")) {
            e();
          } else {
            i();
          }
          break;
        case 254: 
          i();
          break;
        case 1: 
          i();
        }
        break;
      case 59: 
        i = 1;
      }
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int != 0;
  }
  
  @Nullable
  private int[] a(int paramInt)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt * 3];
    try
    {
      this.jdField_a_of_type_JavaNioByteBuffer.get(arrayOfByte);
      int[] arrayOfInt2 = new int[256];
      int j = 0;
      int[] arrayOfInt1;
      for (;;)
      {
        arrayOfInt1 = arrayOfInt2;
        if (i >= paramInt) {
          break;
        }
        int n = j + 1;
        int k = arrayOfByte[j];
        int m = n + 1;
        n = arrayOfByte[n];
        j = m + 1;
        arrayOfInt2[i] = ((k & 0xFF) << 16 | 0xFF000000 | (n & 0xFF) << 8 | arrayOfByte[m] & 0xFF);
        i += 1;
      }
      return arrayOfInt1;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      arrayOfInt1 = null;
      if (Log.isLoggable("GifHeaderParser", 3)) {
        Log.d("GifHeaderParser", "Format Error Reading Color Table", localBufferUnderflowException);
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 1;
    }
  }
  
  private int b()
  {
    return this.jdField_a_of_type_JavaNioByteBuffer.getShort();
  }
  
  private void b()
  {
    a(2147483647);
  }
  
  private void c()
  {
    boolean bool = true;
    a();
    int i = a();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.e = ((jdField_a_of_type_Int & i) >> 2);
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.e == 0) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.e = 1;
    }
    GifFrame localGifFrame = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame;
    if ((i & jdField_b_of_type_Int) != 0) {}
    for (;;)
    {
      localGifFrame.jdField_b_of_type_Boolean = bool;
      int j = b();
      i = j;
      if (j < 2) {
        i = 10;
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.g = (i * 10);
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.f = a();
      a();
      return;
      bool = false;
    }
  }
  
  private void d()
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.jdField_a_of_type_Int = b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.jdField_b_of_type_Int = b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.c = b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.d = b();
    int j = a();
    int i;
    int k;
    if ((c & j) != 0)
    {
      i = 1;
      k = (int)Math.pow(2.0D, (e & j) + 1);
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame;
      if ((j & d) == 0) {
        break label167;
      }
      label107:
      ((GifFrame)localObject).jdField_a_of_type_Boolean = bool;
      if (i == 0) {
        break label173;
      }
    }
    label167:
    label173:
    for (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.jdField_a_of_type_ArrayOfInt = a(k);; this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.jdField_a_of_type_ArrayOfInt = null)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.h = this.jdField_a_of_type_JavaNioByteBuffer.position();
      h();
      if (!a()) {
        break label187;
      }
      return;
      i = 0;
      break;
      bool = false;
      break label107;
    }
    label187:
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader;
    ((GifHeader)localObject).jdField_b_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame);
  }
  
  private void e()
  {
    do
    {
      j();
      if (this.jdField_a_of_type_ArrayOfByte[0] == 1)
      {
        int i = this.jdField_a_of_type_ArrayOfByte[1];
        int j = this.jdField_a_of_type_ArrayOfByte[2];
        this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.i = (i & 0xFF | (j & 0xFF) << 8);
      }
    } while ((this.h > 0) && (!a()));
  }
  
  private void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 6)
    {
      localStringBuilder.append((char)a());
      i += 1;
    }
    if (!localStringBuilder.toString().startsWith("GIF")) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 1;
    }
    do
    {
      return;
      g();
    } while ((!this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Boolean) || (a()));
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ArrayOfInt = a(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.e);
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.h = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.f];
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.c = b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.d = b();
    int i = a();
    GifHeader localGifHeader = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader;
    if ((f & i) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localGifHeader.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.e = ((int)Math.pow(2.0D, (i & g) + 1));
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.f = a();
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.g = a();
      return;
    }
  }
  
  private void h()
  {
    a();
    i();
  }
  
  private void i()
  {
    int i;
    do
    {
      i = a();
      int j = Math.min(this.jdField_a_of_type_JavaNioByteBuffer.position() + i, this.jdField_a_of_type_JavaNioByteBuffer.limit());
      this.jdField_a_of_type_JavaNioByteBuffer.position(j);
    } while (i > 0);
  }
  
  private void j()
  {
    int i = 0;
    this.h = a();
    if (this.h > 0)
    {
      int j = 0;
      for (;;)
      {
        int k = i;
        try
        {
          if (j < this.h)
          {
            k = i;
            i = this.h - j;
            k = i;
            this.jdField_a_of_type_JavaNioByteBuffer.get(this.jdField_a_of_type_ArrayOfByte, j, i);
            j += i;
          }
        }
        catch (Exception localException)
        {
          if (Log.isLoggable("GifHeaderParser", 3)) {
            Log.d("GifHeaderParser", "Error Reading Block n: " + j + " count: " + k + " blockSize: " + this.h, localException);
          }
          this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 1;
        }
      }
    }
  }
  
  @NotNull
  public GifHeader a()
  {
    if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
      throw new IllegalStateException("You must call setData() before parseHeader()");
    }
    if (a()) {
      return this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader;
    }
    f();
    if (!a())
    {
      b();
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int < 0) {
        this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 1;
      }
    }
    return this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader;
  }
  
  public GifHeaderParser a(@NotNull ByteBuffer paramByteBuffer)
  {
    a();
    this.jdField_a_of_type_JavaNioByteBuffer = paramByteBuffer.asReadOnlyBuffer();
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return this;
  }
  
  public GifHeaderParser a(@Nullable byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      a(ByteBuffer.wrap(paramArrayOfByte));
      return this;
    }
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.GifHeaderParser
 * JD-Core Version:    0.7.0.1
 */