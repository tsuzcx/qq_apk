package dov.com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.content.Intent;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.statistics.ReportController;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class FlowCameraMqqAction
{
  public static int a;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public static String a(FlowActivity paramFlowActivity)
  {
    return paramFlowActivity.getAppRuntime().getAccount();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, HashMap paramHashMap)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    String str1 = paramString2;
    String str2;
    String str3;
    if (paramHashMap != null)
    {
      str2 = (String)paramHashMap.get("cameraType");
      str3 = (String)paramHashMap.get("isTemplateMode");
      paramHashMap = (String)paramHashMap.get("templateId");
      if ((!String.valueOf(2).equals(str2)) || ((!String.valueOf(false).equals(str3)) && (paramHashMap != null))) {
        break label99;
      }
      str1 = "0X8007819";
    }
    for (;;)
    {
      b(paramString1, str1);
      return;
      label99:
      if ((String.valueOf(2).equals(str2)) && (String.valueOf(true).equals(str3)) && (paramHashMap != null))
      {
        str1 = "0X800781A";
      }
      else if ((String.valueOf(1).equals(str2)) && ((String.valueOf(false).equals(str3)) || (paramHashMap == null)))
      {
        str1 = "0X800781B";
      }
      else
      {
        str1 = paramString2;
        if (String.valueOf(1).equals(str2))
        {
          str1 = paramString2;
          if (String.valueOf(true).equals(str3))
          {
            str1 = paramString2;
            if (paramHashMap != null) {
              str1 = "0X800781C";
            }
          }
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, float paramFloat, boolean paramBoolean, double paramDouble1, double paramDouble2, FlowComponentInterface paramFlowComponentInterface, int paramInt)
  {
    a(paramActivity, paramRMVideoStateMgr, paramFloat, paramBoolean, paramDouble1, paramDouble2, paramFlowComponentInterface, false, paramInt, 0);
  }
  
  public static void a(Activity paramActivity, RMVideoStateMgr paramRMVideoStateMgr, float paramFloat, boolean paramBoolean1, double paramDouble1, double paramDouble2, FlowComponentInterface paramFlowComponentInterface, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    String str1 = "";
    int i = 0;
    String str2 = "";
    try
    {
      SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo != null)
      {
        str1 = localSessionInfo.jdField_a_of_type_JavaLangString;
        i = localSessionInfo.jdField_a_of_type_Int;
        str2 = localSessionInfo.b;
      }
      paramActivity = new FlowSendTask(paramActivity, paramRMVideoStateMgr, str1, i, str2, paramFloat, paramBoolean1, paramDouble1, paramDouble2, paramFlowComponentInterface, paramInt1, paramInt2, false);
      paramActivity.a(paramBoolean2);
      paramActivity.execute(new Void[0]);
      if (paramBoolean1) {
        a("", "0X8005E94");
      }
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public static void a(Activity paramActivity, ArrayList paramArrayList)
  {
    SessionInfo localSessionInfo = (SessionInfo)paramActivity.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    Intent localIntent = new Intent(paramActivity, SendPhotoActivity.class);
    if (localSessionInfo != null)
    {
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1008);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      localIntent.putExtra("uin", localSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", localSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("troop_uin", localSessionInfo.b);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2, "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(null, "dc00898", paramString1, "", paramString2, paramString2, jdField_a_of_type_Int, 0, paramString3, "", "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "dc00898", paramString1, "", paramString2, paramString2, jdField_a_of_type_Int, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static boolean a()
  {
    return QavCameraUsage.a(BaseApplicationImpl.getContext(), false);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "");
  }
  
  public static void b(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(null, "CliOper", paramString1, "", paramString2, paramString2, jdField_a_of_type_Int, 0, paramString3, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction
 * JD-Core Version:    0.7.0.1
 */