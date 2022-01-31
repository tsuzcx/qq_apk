package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import yxo;

class MiniAppDesktopAdapter$3
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$3(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniAppDesktopAdapter", 2, "onClick. obj = " + localObject);
      }
      return;
    }
    localObject = (MiniAppDesktopAdapter.MicroAppViewHolder)((RecyclerView)paramView.getParent()).getChildViewHolder(paramView);
    paramView = ((MiniAppDesktopAdapter.MicroAppViewHolder)localObject).miniAppInfo;
    int i;
    if (((MiniAppDesktopAdapter.MicroAppViewHolder)localObject).moduleType == 1) {
      i = 3001;
    }
    for (;;)
    {
      try
      {
        QLog.d("MiniAppDesktopAdapter", 1, "--- click appid:" + paramView.appId + ", moduleType = " + ((MiniAppDesktopAdapter.MicroAppViewHolder)localObject).moduleType);
        if ((((MiniAppDesktopAdapter.MicroAppViewHolder)localObject).moduleType != 2) || (((MiniAppDesktopAdapter.MicroAppViewHolder)localObject).desktopAppInfo == null) || (((MiniAppDesktopAdapter.MicroAppViewHolder)localObject).desktopAppInfo.fromBackup != 1)) {
          break label447;
        }
        LaunchParam localLaunchParam = new LaunchParam();
        localLaunchParam.scene = i;
        MiniAppController.startAppByAppid((Context)MiniAppDesktopAdapter.access$2400(this.this$0).get(), paramView.appId, null, null, localLaunchParam, null);
        QLog.w("MiniAppDesktopAdapter", 1, "--- click appid:" + paramView.appId + ", moduleType = " + ((MiniAppDesktopAdapter.MicroAppViewHolder)localObject).moduleType + ", fromBackup: " + ((MiniAppDesktopAdapter.MicroAppViewHolder)localObject).desktopAppInfo.fromBackup);
        int j = MiniAppDesktopAdapter.access$2500(this.this$0, paramView.appId);
        localObject = new MiniAppConfig(paramView);
        ((MiniAppConfig)localObject).launchParam.scene = i;
        MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject, "page_view", "click_scene", null, String.valueOf(j));
        boolean bool = TextUtils.isEmpty(paramView.amsAdInfo);
        if (bool) {
          break;
        }
        try
        {
          paramView = new JSONObject(paramView.amsAdInfo);
          paramView = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxo.a(new qq_ad_get.QQAdGetRsp.AdInfo(), paramView))).report_info.click_url.get();
          MiniAppUtils.reportMiniAppAd(paramView);
          QLog.d("MiniAppDesktopAdapter", 1, "--- click : " + paramView);
          return;
        }
        catch (Exception paramView)
        {
          QLog.e("MiniAppDesktopAdapter", 1, "click ad exception: " + Log.getStackTraceString(paramView));
          return;
        }
        if (((MiniAppDesktopAdapter.MicroAppViewHolder)localObject).moduleType != 2) {
          break label431;
        }
      }
      catch (MiniAppException paramView)
      {
        paramView.printStackTrace();
        return;
      }
      i = 3002;
      continue;
      label431:
      if (((MiniAppDesktopAdapter.MicroAppViewHolder)localObject).moduleType == 3)
      {
        i = 3003;
        continue;
        label447:
        MiniAppController.launchMiniAppByAppInfo((Activity)MiniAppDesktopAdapter.access$2400(this.this$0).get(), paramView, i);
      }
      else
      {
        i = 9999;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.3
 * JD-Core Version:    0.7.0.1
 */