package com.tencent.mobileqq.flutter.launch;

public class LaunchResult
{
  public int a;
  public LaunchTrace a;
  public boolean a;
  public boolean b;
  
  public LaunchResult(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  public void a(LaunchTrace paramLaunchTrace)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace = paramLaunchTrace;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LaunchResult{errorCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isFirstLaunch=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isDebugMode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", launchTrace=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFlutterLaunchLaunchTrace);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.launch.LaunchResult
 * JD-Core Version:    0.7.0.1
 */