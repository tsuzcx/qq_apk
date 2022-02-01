package com.tencent.mobileqq.tts.stream;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class ChunkedInputStream
  extends InputStream
{
  private int jdField_a_of_type_Int;
  private final InputStream jdField_a_of_type_JavaIoInputStream;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public ChunkedInputStream(InputStream paramInputStream)
  {
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
  }
  
  private static int a(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInputStream == null) {
      return -1;
    }
    int i = 0;
    while (i != -1)
    {
      int j = paramInputStream.read();
      if (j == 123)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChunkedInputStream", 1, "Server did not return any chunk");
        }
        localStringBuilder = new StringBuilder("{");
        for (;;)
        {
          i = paramInputStream.read();
          if (-1 == i) {
            break;
          }
          localStringBuilder.append((char)i);
        }
        paramInputStream = new StringBuilder();
        paramInputStream.append("[getChunkSize] error: ");
        paramInputStream.append(localStringBuilder);
        QLog.d("ChunkedInputStream", 1, paramInputStream.toString());
        return -1;
      }
      if (i != 0)
      {
        if (i == 1) {
          if (j == 10) {
            i = -1;
          } else {
            throw new IOException("Read CRLF invalid!");
          }
        }
      }
      else if (j == 13) {
        i = 1;
      } else {
        localStringBuilder.append((char)j);
      }
    }
    return Integer.parseInt(localStringBuilder.toString(), 16);
  }
  
  private boolean a()
  {
    boolean bool1 = this.jdField_a_of_type_Boolean;
    boolean bool3 = false;
    if (!bool1) {
      bool1 = b();
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Int = a(this.jdField_a_of_type_JavaIoInputStream);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_b_of_type_Boolean = true;
    }
    boolean bool2 = bool3;
    if (this.jdField_a_of_type_Int >= 0)
    {
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_JavaIoInputStream.read();
    int j = this.jdField_a_of_type_JavaIoInputStream.read();
    return (i == 13) && (j == 10);
  }
  
  public byte[] a()
  {
    boolean bool;
    if (!this.jdField_a_of_type_Boolean) {
      bool = b();
    } else {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_JavaIoInputStream;
    if (localObject == null) {
      return new byte[0];
    }
    this.jdField_a_of_type_Int = a((InputStream)localObject);
    if (4 == this.jdField_a_of_type_Int) {
      read(new byte[4], 0, 4);
    }
    int i = this.jdField_a_of_type_Int;
    if ((i > 0) && (bool))
    {
      localObject = new byte[i];
      int j;
      do
      {
        j = read((byte[])localObject, this.jdField_b_of_type_Int, i);
        if (j < 0) {
          return new byte[0];
        }
        j = i - j;
        i = j;
      } while (j > 0);
      return localObject;
    }
    return new byte[0];
  }
  
  public int read()
  {
    if (!this.c)
    {
      if (this.jdField_b_of_type_Boolean) {
        return -1;
      }
      if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int)
      {
        a();
        if (this.jdField_b_of_type_Boolean) {
          return -1;
        }
      }
      this.jdField_b_of_type_Int += 1;
      return this.jdField_a_of_type_JavaIoInputStream.read();
    }
    throw new IOException("Attempted read from closed stream.");
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.c)
    {
      if (this.jdField_b_of_type_Boolean) {
        return -1;
      }
      if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int)
      {
        boolean bool = a();
        if ((this.jdField_b_of_type_Boolean) || (!bool)) {
          return -1;
        }
      }
      paramInt2 = Math.min(paramInt2, this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
      paramInt1 = this.jdField_a_of_type_JavaIoInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      this.jdField_b_of_type_Int += paramInt1;
      if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Int) {
        this.jdField_b_of_type_Int = 0;
      }
      return paramInt1;
    }
    throw new IOException("Attempted read from closed stream.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.stream.ChunkedInputStream
 * JD-Core Version:    0.7.0.1
 */