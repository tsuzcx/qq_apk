package com.tencent.mobileqq.mini.launch;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StBatchQueryAppInfoRsp;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class AppBrandLaunchManager$StartMiniAppReceiver$2
  implements MiniAppCmdInterface
{
  AppBrandLaunchManager$StartMiniAppReceiver$2(AppBrandLaunchManager.StartMiniAppReceiver paramStartMiniAppReceiver, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = paramJSONObject.opt("batch_query_app_info");
      if (paramJSONObject != null)
      {
        paramJSONObject = (INTERFACE.StBatchQueryAppInfoRsp)paramJSONObject;
        COMM.StCommonExt localStCommonExt = (COMM.StCommonExt)paramJSONObject.extInfo.get();
        paramJSONObject = paramJSONObject.appInfos.get().iterator();
        while (paramJSONObject.hasNext()) {
          AppBrandLaunchManager.access$500(MiniAppInfo.from((INTERFACE.StApiAppInfo)paramJSONObject.next()), this.val$scene, "");
        }
      }
    }
    else
    {
      QLog.e("miniapp-process_AppBrandLaunchManager", 2, "StartMiniAppReceiver onReceive, onCmdListener, isSuc = " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.StartMiniAppReceiver.2
 * JD-Core Version:    0.7.0.1
 */