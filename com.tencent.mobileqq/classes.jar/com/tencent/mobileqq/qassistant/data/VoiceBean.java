package com.tencent.mobileqq.qassistant.data;

public class VoiceBean
{
  public byte[] a;
  public int b;
  public int c;
  public int d;
  public long e;
  public long f;
  public boolean g;
  public String h = "";
  
  public VoiceBean(String paramString)
  {
    this.h = paramString;
    this.d = -1;
    this.c = 0;
  }
  
  private VoiceBean(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    this.a = paramArrayOfByte;
    this.g = paramBoolean;
    paramArrayOfByte = this.a;
    int i;
    if (paramArrayOfByte == null) {
      i = 0;
    } else {
      i = paramArrayOfByte.length;
    }
    this.b = i;
    this.d = paramInt;
    this.c = 0;
  }
  
  public VoiceBean(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte, -1, bool);
    this.h = paramString;
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return "";
          }
          return "Tailor";
        }
        return "Middle";
      }
      return "Header";
    }
    return "Invali";
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.a = paramArrayOfByte;
    paramArrayOfByte = this.a;
    int i;
    if (paramArrayOfByte == null) {
      i = 0;
    } else {
      i = paramArrayOfByte.length;
    }
    this.b = i;
    this.g = paramBoolean;
    this.e = paramLong1;
    this.f = paramLong2;
  }
  
  public boolean a()
  {
    return this.c == 1;
  }
  
  public boolean b()
  {
    return this.c == 3;
  }
  
  public String c()
  {
    String str2 = this.h;
    String str1;
    if (this.g) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    return String.format("VoiceBean[voiceId:%s, isMute:%s, position:%s, sequence:%s, arrLen:%s, len:%s, off:%s]", new Object[] { str2, str1, a(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Long.valueOf(this.f), Long.valueOf(this.e) });
  }
  
  public boolean d()
  {
    int i = this.c;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 2)
      {
        if (i == 3) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean e()
  {
    return (f()) && (d());
  }
  
  public boolean f()
  {
    return (this.a != null) && (this.b > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.data.VoiceBean
 * JD-Core Version:    0.7.0.1
 */