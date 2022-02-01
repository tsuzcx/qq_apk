package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

class MiniAppDesktopAdapter$4
  implements View.OnClickListener
{
  MiniAppDesktopAdapter$4(MiniAppDesktopAdapter paramMiniAppDesktopAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (!(localObject1 instanceof Integer))
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("onClick. obj = ");
        paramView.append(localObject1);
        QLog.i("MiniAppDesktopAdapter", 2, paramView.toString());
      }
      return;
    }
    localObject1 = (MiniAppDesktopAdapter.MicroAppViewHolder)((RecyclerView)paramView.getParent()).getChildViewHolder(paramView);
    paramView = ((MiniAppDesktopAdapter.MicroAppViewHolder)localObject1).miniAppInfo;
    boolean bool = MiniAppDesktopAdapter.access$2400(this.this$0, paramView.appId);
    int i = 9999;
    if (((MiniAppDesktopAdapter.MicroAppViewHolder)localObject1).moduleType == 1)
    {
      if (bool) {
        i = 3020;
      } else {
        i = 3001;
      }
    }
    else if (((MiniAppDesktopAdapter.MicroAppViewHolder)localObject1).moduleType == 2) {
      i = 3002;
    } else if (((MiniAppDesktopAdapter.MicroAppViewHolder)localObject1).moduleType == 3) {
      if (bool) {
        i = 3021;
      } else {
        i = 3003;
      }
    }
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("--- click appid:");
      ((StringBuilder)localObject2).append(paramView.appId);
      ((StringBuilder)localObject2).append(", moduleType = ");
      ((StringBuilder)localObject2).append(((MiniAppDesktopAdapter.MicroAppViewHolder)localObject1).moduleType);
      QLog.d("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject2).toString());
      if ((((MiniAppDesktopAdapter.MicroAppViewHolder)localObject1).moduleType == 2) && (((MiniAppDesktopAdapter.MicroAppViewHolder)localObject1).desktopAppInfo != null) && (((MiniAppDesktopAdapter.MicroAppViewHolder)localObject1).desktopAppInfo.fromBackup == 1))
      {
        localObject2 = new LaunchParam();
        ((LaunchParam)localObject2).scene = i;
        MiniAppController.startAppByAppid((Context)MiniAppDesktopAdapter.access$2500(this.this$0).get(), paramView.appId, null, null, (LaunchParam)localObject2, null);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("--- click appid:");
        ((StringBuilder)localObject2).append(paramView.appId);
        ((StringBuilder)localObject2).append(", moduleType = ");
        ((StringBuilder)localObject2).append(((MiniAppDesktopAdapter.MicroAppViewHolder)localObject1).moduleType);
        ((StringBuilder)localObject2).append(", fromBackup: ");
        ((StringBuilder)localObject2).append(((MiniAppDesktopAdapter.MicroAppViewHolder)localObject1).desktopAppInfo.fromBackup);
        QLog.w("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject2).toString());
      }
      else
      {
        MiniAppDesktopAdapter.startMiniApp((Activity)MiniAppDesktopAdapter.access$2500(this.this$0).get(), paramView, i);
      }
      int j = MiniAppDesktopAdapter.access$2600(this.this$0, paramView.appId);
      localObject1 = new MiniAppConfig(paramView);
      ((MiniAppConfig)localObject1).launchParam.scene = i;
      MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject1, "page_view", "click_scene", null, String.valueOf(j));
      bool = TextUtils.isEmpty(paramView.amsAdInfo);
      if (!bool) {
        try
        {
          localObject1 = new JSONObject(paramView.amsAdInfo);
          localObject1 = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), localObject1))).report_info.click_url.get();
          MiniAppUtils.reportMiniAppAd((String)localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("--- click : ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject2).toString());
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("click ad exception: ");
          ((StringBuilder)localObject2).append(Log.getStackTraceString(localException));
          QLog.e("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject2).toString());
        }
      }
      if (paramView.tianshuAdId > 0)
      {
        MiniAppUtils.miniAppTianShuReport("tianshu.78", "tianshu.78", String.valueOf(paramView.tianshuAdId), 102);
        return;
      }
    }
    catch (Exception paramView)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick exception: ");
      localStringBuilder.append(Log.getStackTraceString(paramView));
      QLog.e("MiniAppDesktopAdapter", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.4
 * JD-Core Version:    0.7.0.1
 */