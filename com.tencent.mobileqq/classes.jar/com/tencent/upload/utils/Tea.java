package com.tencent.upload.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class Tea
{
  private int contextStart;
  private int crypt;
  private boolean header = true;
  private byte[] key;
  private byte[] out;
  private int padding;
  private byte[] plain;
  private int pos;
  private int preCrypt;
  private byte[] prePlain;
  private Random random = new Random();
  
  private byte[] decipher(byte[] paramArrayOfByte)
  {
    return decipher(paramArrayOfByte, 0);
  }
  
  private byte[] decipher(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 16;
    for (;;)
    {
      long l2;
      long l1;
      long l4;
      long l5;
      long l6;
      long l7;
      long l3;
      try
      {
        l2 = getUnsignedInt(paramArrayOfByte, paramInt, 4);
        l1 = getUnsignedInt(paramArrayOfByte, paramInt + 4, 4);
        l4 = getUnsignedInt(this.key, 0, 4);
        l5 = getUnsignedInt(this.key, 4, 4);
        l6 = getUnsignedInt(this.key, 8, 4);
        l7 = getUnsignedInt(this.key, 12, 4);
        l3 = 3816266640L;
        paramInt = i;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        continue;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.writeInt((int)l1);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      return new byte[50];
      while (paramInt > 0)
      {
        l1 = l1 - ((l2 << 4) + l6 ^ l2 + l3 ^ (l2 >>> 5) + l7) & 0xFFFFFFFF;
        l2 = l2 - ((l1 << 4) + l4 ^ l1 + l3 ^ (l1 >>> 5) + l5) & 0xFFFFFFFF;
        l3 = l3 - 2654435769L & 0xFFFFFFFF;
        paramInt -= 1;
      }
    }
  }
  
  private boolean decrypt8Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i;
    for (this.pos = 0;; this.pos = (i + 1))
    {
      i = this.pos;
      if (i >= 8) {
        break;
      }
      if (this.contextStart + i >= paramInt2) {
        return true;
      }
      byte[] arrayOfByte = this.prePlain;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[(this.crypt + paramInt1 + i)]));
    }
    this.prePlain = decipher(this.prePlain);
    if (this.prePlain == null) {
      return false;
    }
    this.contextStart += 8;
    this.crypt += 8;
    this.pos = 0;
    return true;
  }
  
  private byte[] encipher(byte[] paramArrayOfByte)
  {
    int i = 16;
    for (;;)
    {
      long l1;
      long l2;
      long l4;
      long l5;
      long l6;
      long l7;
      long l3;
      try
      {
        l1 = getUnsignedInt(paramArrayOfByte, 0, 4);
        l2 = getUnsignedInt(paramArrayOfByte, 4, 4);
        l4 = getUnsignedInt(this.key, 0, 4);
        l5 = getUnsignedInt(this.key, 4, 4);
        l6 = getUnsignedInt(this.key, 8, 4);
        l7 = getUnsignedInt(this.key, 12, 4);
        l3 = 0L;
      }
      catch (IOException paramArrayOfByte)
      {
        DataOutputStream localDataOutputStream;
        continue;
      }
      paramArrayOfByte = new ByteArrayOutputStream(8);
      localDataOutputStream = new DataOutputStream(paramArrayOfByte);
      localDataOutputStream.writeInt((int)l1);
      localDataOutputStream.writeInt((int)l2);
      localDataOutputStream.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      return paramArrayOfByte;
      return null;
      while (i > 0)
      {
        l3 = l3 + 2654435769L & 0xFFFFFFFF;
        l1 = l1 + ((l2 << 4) + l4 ^ l2 + l3 ^ (l2 >>> 5) + l5) & 0xFFFFFFFF;
        l2 = l2 + ((l1 << 4) + l6 ^ l1 + l3 ^ (l1 >>> 5) + l7) & 0xFFFFFFFF;
        i -= 1;
      }
    }
  }
  
  private byte[] encrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.plain = new byte[8];
    this.prePlain = new byte[8];
    this.pos = 1;
    this.padding = 0;
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfByte2;
    this.header = true;
    this.pos = ((paramInt2 + 10) % 8);
    int i = this.pos;
    if (i != 0) {
      this.pos = (8 - i);
    }
    this.out = new byte[this.pos + paramInt2 + 10];
    this.plain[0] = ((byte)(rand() & 0xF8 | this.pos));
    i = 1;
    int j;
    for (;;)
    {
      j = this.pos;
      if (i > j) {
        break;
      }
      this.plain[i] = ((byte)(rand() & 0xFF));
      i += 1;
    }
    this.pos = (j + 1);
    i = 0;
    while (i < 8)
    {
      this.prePlain[i] = 0;
      i += 1;
    }
    this.padding = 1;
    for (;;)
    {
      i = paramInt1;
      j = paramInt2;
      if (this.padding > 2) {
        break;
      }
      i = this.pos;
      if (i < 8)
      {
        paramArrayOfByte2 = this.plain;
        this.pos = (i + 1);
        paramArrayOfByte2[i] = ((byte)(rand() & 0xFF));
        this.padding += 1;
      }
      if (this.pos == 8) {
        encrypt8Bytes();
      }
    }
    while (j > 0)
    {
      int k = this.pos;
      paramInt2 = i;
      paramInt1 = j;
      if (k < 8)
      {
        paramArrayOfByte2 = this.plain;
        this.pos = (k + 1);
        paramArrayOfByte2[k] = paramArrayOfByte1[i];
        paramInt1 = j - 1;
        paramInt2 = i + 1;
      }
      i = paramInt2;
      j = paramInt1;
      if (this.pos == 8)
      {
        encrypt8Bytes();
        i = paramInt2;
        j = paramInt1;
      }
    }
    this.padding = 1;
    for (;;)
    {
      paramInt1 = this.padding;
      if (paramInt1 > 7) {
        break;
      }
      paramInt2 = this.pos;
      if (paramInt2 < 8)
      {
        paramArrayOfByte1 = this.plain;
        this.pos = (paramInt2 + 1);
        paramArrayOfByte1[paramInt2] = 0;
        this.padding = (paramInt1 + 1);
      }
      if (this.pos == 8) {
        encrypt8Bytes();
      }
    }
    return this.out;
  }
  
  private void encrypt8Bytes()
  {
    int j;
    for (this.pos = 0;; this.pos += 1)
    {
      i = this.pos;
      if (i >= 8) {
        break;
      }
      if (this.header)
      {
        arrayOfByte1 = this.plain;
        byte[] arrayOfByte2 = this.prePlain;
        if ((arrayOfByte2 != null) && (arrayOfByte2.length > i))
        {
          j = arrayOfByte1[i];
          arrayOfByte1[i] = ((byte)(arrayOfByte2[i] ^ j));
        }
      }
      else
      {
        arrayOfByte1 = this.plain;
        arrayOfByte1[i] = ((byte)(arrayOfByte1[i] ^ this.out[(this.preCrypt + i)]));
      }
    }
    System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
    byte[] arrayOfByte1 = this.prePlain;
    if ((arrayOfByte1 != null) && (arrayOfByte1.length >= 8)) {
      for (this.pos = 0;; this.pos = (i + 1))
      {
        i = this.pos;
        if (i >= 8) {
          break;
        }
        j = this.crypt + i;
        arrayOfByte1 = this.out;
        arrayOfByte1[j] = ((byte)(arrayOfByte1[j] ^ this.prePlain[i]));
      }
    }
    System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
    int i = this.crypt;
    this.preCrypt = i;
    this.crypt = (i + 8);
    this.pos = 0;
    this.header = false;
  }
  
  private static long getUnsignedInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > 8) {
      paramInt2 = paramInt1 + 8;
    } else {
      paramInt2 += paramInt1;
    }
    long l = 0L;
    while (paramInt1 < paramInt2)
    {
      l = l << 8 | paramArrayOfByte[paramInt1] & 0xFF;
      paramInt1 += 1;
    }
    return 0xFFFFFFFF & l | l >>> 32;
  }
  
  private int rand()
  {
    return this.random.nextInt();
  }
  
  protected byte[] decrypt(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    int k = 0;
    this.preCrypt = 0;
    this.crypt = 0;
    this.key = paramArrayOfByte2;
    byte[] arrayOfByte1 = new byte[paramInt1 + 8];
    if (paramInt2 % 8 == 0)
    {
      if (paramInt2 < 16) {
        return null;
      }
      this.prePlain = decipher(paramArrayOfByte1, paramInt1);
      paramArrayOfByte2 = this.prePlain;
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        this.pos = (paramArrayOfByte2[0] & 0x7);
      }
      int m = paramInt2 - this.pos - 10;
      if (m < 0) {
        return null;
      }
      int i = paramInt1;
      while (i < arrayOfByte1.length)
      {
        arrayOfByte1[i] = 0;
        i += 1;
      }
      this.out = new byte[m];
      this.preCrypt = 0;
      this.crypt = 8;
      this.contextStart = 8;
      this.pos += 1;
      this.padding = 1;
      int n;
      int j;
      for (;;)
      {
        n = this.padding;
        j = k;
        i = m;
        paramArrayOfByte2 = arrayOfByte1;
        if (n > 2) {
          break;
        }
        i = this.pos;
        if (i < 8)
        {
          this.pos = (i + 1);
          this.padding = (n + 1);
        }
        if (this.pos == 8)
        {
          if (!decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
            return null;
          }
          arrayOfByte1 = paramArrayOfByte1;
        }
      }
      while (i != 0)
      {
        n = this.pos;
        m = j;
        k = i;
        if (n < 8)
        {
          arrayOfByte1 = this.prePlain;
          m = j;
          k = i;
          if (arrayOfByte1 != null)
          {
            m = j;
            k = i;
            if (arrayOfByte1.length > n)
            {
              byte[] arrayOfByte2 = this.out;
              k = paramArrayOfByte2[(this.preCrypt + paramInt1 + n)];
              arrayOfByte2[j] = ((byte)(arrayOfByte1[n] ^ k));
              m = j + 1;
              k = i - 1;
              this.pos = (n + 1);
            }
          }
        }
        j = m;
        i = k;
        if (this.pos == 8)
        {
          this.preCrypt = (this.crypt - 8);
          if (!decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
            return null;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
          j = m;
          i = k;
        }
      }
      for (this.padding = 1; this.padding < 8; this.padding += 1)
      {
        i = this.pos;
        if (i < 8)
        {
          arrayOfByte1 = this.prePlain;
          if ((arrayOfByte1 != null) && (arrayOfByte1.length > i))
          {
            j = paramArrayOfByte2[(this.preCrypt + paramInt1 + i)];
            if ((arrayOfByte1[i] ^ j) != 0) {
              return null;
            }
            this.pos = (i + 1);
          }
        }
        if (this.pos == 8)
        {
          this.preCrypt = this.crypt;
          if (!decrypt8Bytes(paramArrayOfByte1, paramInt1, paramInt2)) {
            return null;
          }
          paramArrayOfByte2 = paramArrayOfByte1;
        }
      }
      return this.out;
    }
    return null;
  }
  
  protected byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return decrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
  }
  
  protected byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return encrypt(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.utils.Tea
 * JD-Core Version:    0.7.0.1
 */