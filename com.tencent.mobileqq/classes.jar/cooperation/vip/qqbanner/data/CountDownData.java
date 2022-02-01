package cooperation.vip.qqbanner.data;

public final class CountDownData
{
  public int a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public static CountDownData a()
  {
    return new CountDownData();
  }
  
  public CountDownData a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public CountDownData a(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public CountDownData b()
  {
    CountDownData localCountDownData = new CountDownData();
    localCountDownData.a = this.a;
    localCountDownData.d = this.d;
    localCountDownData.b = this.b;
    localCountDownData.c = this.c;
    localCountDownData.h = this.h;
    localCountDownData.f = this.f;
    localCountDownData.g = this.g;
    localCountDownData.i = this.i;
    localCountDownData.e = this.e;
    return localCountDownData;
  }
  
  public CountDownData b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public CountDownData b(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public CountDownData c(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public CountDownData c(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public CountDownData d(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public CountDownData e(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public CountDownData f(String paramString)
  {
    this.i = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.data.CountDownData
 * JD-Core Version:    0.7.0.1
 */