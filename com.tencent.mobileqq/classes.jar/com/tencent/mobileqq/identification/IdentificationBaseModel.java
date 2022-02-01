package com.tencent.mobileqq.identification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import com.tencent.youtufacetrack.YoutuFaceTracker;

public class IdentificationBaseModel
{
  static String[] a;
  static String[] b = { "YTCommon" };
  protected BaseRequestHelper a;
  protected RequestHelper.RequestListener a;
  public YoutuFaceTracker a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libopencv_tinyworld.so", "libYTFaceTracker.so", "libYTAGReflectLiveCheck.so", "libYTPoseDetect.so" };
  }
  
  @RequiresApi(api=18)
  public static IdentificationBaseModel a(int paramInt, Intent paramIntent, RequestHelper.RequestListener paramRequestListener)
  {
    return new IdentificationPoseReflect(paramIntent, paramRequestListener);
  }
  
  public int a(Context paramContext, String paramString)
  {
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIdentificationBaseRequestHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqIdentificationBaseRequestHelper.a();
    }
    if (this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker != null)
    {
      this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker.destroy();
      this.jdField_a_of_type_ComTencentYoutufacetrackYoutuFaceTracker = null;
      YoutuFaceTracker.GlobalRelease();
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity) {}
  
  public boolean a(String paramString, String[] paramArrayOfString)
  {
    return false;
  }
  
  public boolean a(String[] paramArrayOfString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationBaseModel
 * JD-Core Version:    0.7.0.1
 */