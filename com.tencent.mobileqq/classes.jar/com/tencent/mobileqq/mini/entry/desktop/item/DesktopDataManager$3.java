package com.tencent.mobileqq.mini.entry.desktop.item;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StSearchModuleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class DesktopDataManager$3
  implements MiniAppCmdInterface
{
  DesktopDataManager$3(DesktopDataManager paramDesktopDataManager) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      ??? = paramJSONObject.optString("errMsg");
      if (l != 0L)
      {
        this.this$0.useLocalDataIfRequestFailed();
        MiniAppUtils.resetMiniDesktopRequestRefreshTime();
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("sendUserAppListRequestV2, retCode = ");
        paramJSONObject.append(l);
        paramJSONObject.append(", errMsg = ");
        paramJSONObject.append((String)???);
        QLog.e("DesktopDataManager", 1, paramJSONObject.toString());
        return;
      }
      paramJSONObject = (INTERFACE.StGetDropdownAppListRsp)paramJSONObject.opt("response");
      if (paramJSONObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sendUserAppListRequestV2, retCode = ");
        localStringBuilder.append(l);
        localStringBuilder.append(", errMsg = ");
        localStringBuilder.append((String)???);
        localStringBuilder.append(", useOld = ");
        localStringBuilder.append(paramJSONObject.useOld.get());
        localStringBuilder.append(", response : ");
        localStringBuilder.append(paramJSONObject.toString());
        QLog.d("DesktopDataManager", 1, localStringBuilder.toString());
        if (paramJSONObject.useOld.get() == 1)
        {
          QLog.w("DesktopDataManager", 1, "sendUserAppListRequest, reuse old data.");
          return;
        }
        DesktopDataManager.access$300(this.this$0).clear();
        this.this$0.clearRecommendExposureList();
        DesktopDataManager.access$400(paramJSONObject.realRecommdInternal.get());
        this.this$0.updateData(paramJSONObject.fixApps.get(), paramJSONObject.modules.get(), (INTERFACE.StSearchModuleInfo)paramJSONObject.searchInfo.get());
        DesktopDataManager.access$502(this.this$0, (COMM.StCommonExt)paramJSONObject.extInfo.get());
        MiniAppUtils.saveGdtCookie(DesktopDataManager.access$500(this.this$0));
        DesktopDataManager.access$602(this.this$0, paramJSONObject.freshInternal.get());
        int i;
        if (paramJSONObject.isFinished.get() == 1) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          synchronized (DesktopDataManager.access$700())
          {
            DesktopDataManager.access$802(this.this$0, 0);
            this.this$0.loadMoreMyApp((COMM.StCommonExt)paramJSONObject.extInfo.get());
          }
        }
        ??? = MiniAppUtils.getAppInterface();
        if (??? != null) {
          MiniAppUtils.handlePreloadAppDataV2(((AppInterface)???).getApp(), paramJSONObject);
        } else {
          QLog.e("DesktopDataManager", 1, "sendUserAppListRequest, app is null.");
        }
        MiniAppUtils.updateDesktopRequestTime();
        return;
      }
      QLog.e("DesktopDataManager", 1, "sendUserAppListRequestV2 failed.");
      return;
    }
    if ((paramJSONObject != null) && (paramJSONObject.optLong("retCode") != 1000L)) {
      MiniAppUtils.resetMiniDesktopRequestRefreshTime();
    }
    this.this$0.useLocalDataIfRequestFailed();
    ??? = new StringBuilder();
    ((StringBuilder)???).append("sendUserAppListRequestV2, isSuccess = ");
    ((StringBuilder)???).append(paramBoolean);
    ((StringBuilder)???).append(", ret = ");
    ((StringBuilder)???).append(paramJSONObject);
    QLog.e("DesktopDataManager", 1, ((StringBuilder)???).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.3
 * JD-Core Version:    0.7.0.1
 */