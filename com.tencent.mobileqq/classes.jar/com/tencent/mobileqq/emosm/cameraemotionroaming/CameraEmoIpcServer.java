package com.tencent.mobileqq.emosm.cameraemotionroaming;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class CameraEmoIpcServer
  extends QIPCModule
{
  public CameraEmoIpcServer()
  {
    super("CameraEmoIpcServer");
  }
  
  public static CameraEmoIpcServer a()
  {
    return CameraEmoIpcServer.Holder.a();
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", params = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("CameraEmoIpcServer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    if ("qipc_action_camera_emo_create_gif_and_upload".equals(paramString))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      ArrayList localArrayList1 = paramBundle.getStringArrayList("qipc_param_camera_emo_png_dirs");
      ArrayList localArrayList2 = paramBundle.getStringArrayList("qipc_param_camera_emo_texts");
      ArrayList localArrayList3 = paramBundle.getStringArrayList("qipc_param_camera_emo_snapshots");
      paramBundle = paramBundle.getStringArrayList("qipc_param_emo_widget_infos");
      if ((localArrayList1 != null) && (localArrayList2 != null))
      {
        if ((MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof BaseQQAppInterface)) {
          paramString = (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
        } else {
          paramString = null;
        }
        if (paramString == null)
        {
          QLog.d("CameraEmoIpcServer", 2, "CameraEmoIpcServer.onCall get app failed");
          ((Bundle)localObject).putInt("qipc_param_camera_emo_upload_result", 16);
          callbackResult(paramInt, EIPCResult.createExceptionResult(new Exception("app == null")));
          paramString = new HashMap();
          paramString.put("sucFlag", "0");
          paramString.put("retCode", String.valueOf(16));
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoUpload", false, 0L, 0L, paramString, null);
          return null;
        }
        ThreadManager.excute(new CameraEmoIpcServer.1(this, localArrayList3, localArrayList1, localArrayList2, paramBundle), 64, null, false);
        callbackResult(paramInt, EIPCResult.createSuccessResult((Bundle)localObject));
        return null;
      }
      QLog.d("CameraEmoIpcServer", 2, "CameraEmoIpcServer.onCall params error");
      ((Bundle)localObject).putInt("qipc_param_camera_emo_upload_result", 16);
      callbackResult(paramInt, EIPCResult.createExceptionResult(new Exception("pngDirs == null || texts == null")));
      paramString = new HashMap();
      paramString.put("sucFlag", "0");
      paramString.put("retCode", String.valueOf(16));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoUpload", false, 0L, 0L, paramString, null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoIpcServer
 * JD-Core Version:    0.7.0.1
 */