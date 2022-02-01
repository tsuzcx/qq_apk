package com.tencent.mobileqq.flutter.launch;

public class LaunchResult
{
  public int a;
  public boolean b;
  public boolean c;
  public LaunchTrace d;
  
  public LaunchResult(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
  
  public void a(LaunchTrace paramLaunchTrace)
  {
    if (this.b) {
      this.d = paramLaunchTrace;
    }
  }
  
  public boolean a()
  {
    return this.a == 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LaunchResult{errorCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isFirstLaunch=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isDebugMode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", launchTrace=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.LaunchResult
 * JD-Core Version:    0.7.0.1
 */