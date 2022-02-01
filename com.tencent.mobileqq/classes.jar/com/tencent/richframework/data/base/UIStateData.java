package com.tencent.richframework.data.base;

public class UIStateData<T>
{
  private int a;
  private T b;
  private UIStateData.ModifyListRecord c;
  private String d = null;
  private byte[] e = null;
  private boolean f = false;
  private boolean g = false;
  private int h;
  private int i;
  private long j;
  
  private UIStateData(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static <T> UIStateData<T> a()
  {
    return new UIStateData(0);
  }
  
  public static <T> UIStateData<T> a(int paramInt1, int paramInt2)
  {
    return new UIStateData(5).a(paramInt1).b(paramInt2);
  }
  
  public static <T> UIStateData<T> a(String paramString)
  {
    return new UIStateData(4).b(paramString);
  }
  
  public static <T> UIStateData<T> a(boolean paramBoolean)
  {
    int k;
    if (paramBoolean) {
      k = 2;
    } else {
      k = 3;
    }
    return new UIStateData(k);
  }
  
  public static <T> UIStateData<T> b()
  {
    return new UIStateData(1);
  }
  
  public UIStateData<T> a(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public UIStateData<T> a(long paramLong)
  {
    this.j = paramLong;
    return this;
  }
  
  public UIStateData<T> a(UIStateData.ModifyListRecord paramModifyListRecord)
  {
    this.c = paramModifyListRecord;
    return this;
  }
  
  public UIStateData<T> a(boolean paramBoolean, T paramT)
  {
    this.f = paramBoolean;
    this.b = paramT;
    return this;
  }
  
  public UIStateData<T> a(byte[] paramArrayOfByte)
  {
    this.e = paramArrayOfByte;
    return this;
  }
  
  public UIStateData<T> b(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public UIStateData<T> b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public UIStateData<T> b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public UIStateData<T> c(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public void c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void d()
  {
    this.a = 1;
  }
  
  public T e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.d;
  }
  
  public long g()
  {
    return this.j;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public boolean i()
  {
    return this.f;
  }
  
  public int j()
  {
    return this.h;
  }
  
  public int k()
  {
    return this.i;
  }
  
  public boolean l()
  {
    return this.a == 1;
  }
  
  public boolean m()
  {
    return this.a == 2;
  }
  
  public UIStateData.ModifyListRecord n()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.base.UIStateData
 * JD-Core Version:    0.7.0.1
 */