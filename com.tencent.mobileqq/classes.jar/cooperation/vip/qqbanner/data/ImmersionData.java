package cooperation.vip.qqbanner.data;

public final class ImmersionData
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public static ImmersionData a()
  {
    return new ImmersionData();
  }
  
  public ImmersionData a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public ImmersionData b()
  {
    ImmersionData localImmersionData = new ImmersionData();
    localImmersionData.a = this.a;
    localImmersionData.c = this.c;
    localImmersionData.b = this.b;
    localImmersionData.e = this.e;
    localImmersionData.d = this.d;
    localImmersionData.f = this.f;
    return localImmersionData;
  }
  
  public ImmersionData b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public ImmersionData c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public ImmersionData d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public ImmersionData e(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public ImmersionData f(String paramString)
  {
    this.f = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.data.ImmersionData
 * JD-Core Version:    0.7.0.1
 */