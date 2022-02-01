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
      label14:
      break label14;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 1;
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
    while ((i == 0) && (!a()) && (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_b_of_type_Int <= paramInt))
    {
      int j = a();
      if (j != 33)
      {
        if (j != 44)
        {
          if (j != 59) {
            this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 1;
          } else {
            i = 1;
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame == null) {
            this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame = new GifFrame();
          }
          d();
        }
      }
      else
      {
        j = a();
        if (j != 1)
        {
          if (j != 249)
          {
            if (j != 254)
            {
              if (j != 255)
              {
                i();
              }
              else
              {
                j();
                StringBuilder localStringBuilder = new StringBuilder();
                j = 0;
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
              }
            }
            else {
              i();
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame = new GifFrame();
            c();
          }
        }
        else {
          i();
        }
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
    byte[] arrayOfByte = new byte[paramInt * 3];
    localObject = null;
    try
    {
      this.jdField_a_of_type_JavaNioByteBuffer.get(arrayOfByte);
      int[] arrayOfInt = new int[256];
      int i = 0;
      int j = 0;
      for (;;)
      {
        localObject = arrayOfInt;
        if (i >= paramInt) {
          break;
        }
        int k = j + 1;
        j = arrayOfByte[j];
        int m = k + 1;
        arrayOfInt[i] = ((j & 0xFF) << 16 | 0xFF000000 | (arrayOfByte[k] & 0xFF) << 8 | arrayOfByte[m] & 0xFF);
        j = m + 1;
        i += 1;
      }
      return localObject;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
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
    a();
    int i = a();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.e = ((jdField_a_of_type_Int & i) >> 2);
    int j = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.e;
    boolean bool = true;
    if (j == 0) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.e = 1;
    }
    GifFrame localGifFrame = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame;
    if ((i & jdField_b_of_type_Int) == 0) {
      bool = false;
    }
    localGifFrame.jdField_b_of_type_Boolean = bool;
    j = b();
    i = j;
    if (j < 2) {
      i = 10;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.g = (i * 10);
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.f = a();
    a();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.jdField_a_of_type_Int = b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.jdField_b_of_type_Int = b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.c = b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.d = b();
    int j = a();
    int i = c;
    boolean bool = false;
    if ((i & j) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int k = (int)Math.pow(2.0D, (e & j) + 1);
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame;
    if ((j & d) != 0) {
      bool = true;
    }
    ((GifFrame)localObject).jdField_a_of_type_Boolean = bool;
    if (i != 0) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.jdField_a_of_type_ArrayOfInt = a(k);
    } else {
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.jdField_a_of_type_ArrayOfInt = null;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame.h = this.jdField_a_of_type_JavaNioByteBuffer.position();
    h();
    if (a()) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader;
    ((GifHeader)localObject).jdField_b_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifFrame);
  }
  
  private void e()
  {
    do
    {
      j();
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if (arrayOfByte[0] == 1)
      {
        int i = arrayOfByte[1];
        int j = arrayOfByte[2];
        this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.i = ((j & 0xFF) << 8 | i & 0xFF);
      }
    } while ((this.h > 0) && (!a()));
  }
  
  private void f()
  {
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < 6)
    {
      ((StringBuilder)localObject).append((char)a());
      i += 1;
    }
    if (!((StringBuilder)localObject).toString().startsWith("GIF"))
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 1;
      return;
    }
    g();
    if ((this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Boolean) && (!a()))
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader;
      ((GifHeader)localObject).jdField_a_of_type_ArrayOfInt = a(((GifHeader)localObject).e);
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader;
      ((GifHeader)localObject).h = localObject.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.f];
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.c = b();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.d = b();
    int i = a();
    GifHeader localGifHeader = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader;
    boolean bool;
    if ((f & i) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localGifHeader.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.e = ((int)Math.pow(2.0D, (i & g) + 1));
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.f = a();
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.g = a();
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
    this.h = a();
    if (this.h > 0)
    {
      int j = 0;
      int i = 0;
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
          if (Log.isLoggable("GifHeaderParser", 3))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Error Reading Block n: ");
            localStringBuilder.append(j);
            localStringBuilder.append(" count: ");
            localStringBuilder.append(k);
            localStringBuilder.append(" blockSize: ");
            localStringBuilder.append(this.h);
            Log.d("GifHeaderParser", localStringBuilder.toString(), localException);
          }
          this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressEncodedecodeGifHeader.jdField_a_of_type_Int = 1;
        }
      }
    }
  }
  
  @NotNull
  public GifHeader a()
  {
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
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
    throw new IllegalStateException("You must call setData() before parseHeader()");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.encodedecode.GifHeaderParser
 * JD-Core Version:    0.7.0.1
 */