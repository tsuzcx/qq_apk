package com.tencent.mobileqq.mini.entry.desktop;

import ahfz;
import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.HongBaoResBuilder;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;

class MiniAppDesktopAdapter$ModuleViewHolder
  extends RecyclerView.ViewHolder
{
  private WeakReference<Activity> mActivityReference;
  private MiniAppInfo mAppStoreInfo;
  private TextView mModuleText;
  private ImageView mMoreMiniApp;
  
  public MiniAppDesktopAdapter$ModuleViewHolder(View paramView, Activity paramActivity)
  {
    super(paramView);
    this.mActivityReference = new WeakReference(paramActivity);
    this.mModuleText = ((TextView)paramView.findViewById(2131370217));
    this.mMoreMiniApp = ((ImageView)paramView.findViewById(2131370216));
  }
  
  public void update(DesktopAppModuleInfo paramDesktopAppModuleInfo)
  {
    this.mModuleText.setText(paramDesktopAppModuleInfo.moduleTitle);
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    Object localObject1;
    Object localObject2;
    if (localAppInterface != null)
    {
      localObject1 = (ahfz)localAppInterface.getManager(342);
      if ((localObject1 == null) || (!((ahfz)localObject1).h())) {
        break label343;
      }
      DesktopDataManager localDesktopDataManager = (DesktopDataManager)localAppInterface.getManager(336);
      localObject2 = ((ahfz)localObject1).a();
      localObject1 = localObject2;
      if (localDesktopDataManager != null)
      {
        localObject1 = localObject2;
        if (localDesktopDataManager.getHongBaoResBuilder() != null) {
          localObject1 = localDesktopDataManager.getHongBaoResBuilder();
        }
      }
      if (localObject1 != null)
      {
        if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getTextColor() != 2147483647) && (this.mModuleText != null)) {
          this.mModuleText.setTextColor(((DesktopDataManager.HongBaoResBuilder)localObject1).getTextColor());
        }
        if ((((DesktopDataManager.HongBaoResBuilder)localObject1).getModuleMoreIconResId() != -1) && (this.mMoreMiniApp != null)) {
          this.mMoreMiniApp.setImageResource(((DesktopDataManager.HongBaoResBuilder)localObject1).getModuleMoreIconResId());
        }
      }
    }
    int j = paramDesktopAppModuleInfo.getModuleType();
    if ((j == 1) || (j == 2))
    {
      int i;
      if (paramDesktopAppModuleInfo.appStoreInfo != null)
      {
        this.mAppStoreInfo = paramDesktopAppModuleInfo.appStoreInfo;
        this.mMoreMiniApp.setVisibility(0);
        paramDesktopAppModuleInfo = new MiniAppConfig(paramDesktopAppModuleInfo.appStoreInfo);
        localObject1 = paramDesktopAppModuleInfo.launchParam;
        if (j == 1)
        {
          i = 3005;
          label222:
          ((LaunchParam)localObject1).scene = i;
          localObject1 = new MiniAppExposureManager.MiniAppModuleExposureData(paramDesktopAppModuleInfo, "page_view", "expo");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.mAppStoreInfo.appId).append("_").append(this.mAppStoreInfo.verType).append("_").append(j).append("_").append(paramDesktopAppModuleInfo.launchParam.scene);
          paramDesktopAppModuleInfo = ((StringBuilder)localObject2).toString();
          ((MiniAppExposureManager)localAppInterface.getManager(322)).putReportDataToMap(paramDesktopAppModuleInfo, (MiniAppExposureManager.BaseExposureReport)localObject1);
        }
      }
      for (;;)
      {
        this.mMoreMiniApp.setOnClickListener(new MiniAppDesktopAdapter.ModuleViewHolder.1(this, j));
        return;
        label343:
        this.mModuleText.setTextColor(BaseApplicationImpl.getContext().getResources().getColor(2131166931));
        this.mMoreMiniApp.setImageResource(2130849076);
        break;
        i = 3004;
        break label222;
        this.mMoreMiniApp.setVisibility(8);
      }
    }
    this.mMoreMiniApp.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */