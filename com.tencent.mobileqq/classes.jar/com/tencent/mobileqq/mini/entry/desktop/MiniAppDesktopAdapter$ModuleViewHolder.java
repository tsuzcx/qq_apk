package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppModuleInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
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
    this.mModuleText = ((TextView)paramView.findViewById(2131371237));
    this.mMoreMiniApp = ((ImageView)paramView.findViewById(2131371236));
  }
  
  public void update(DesktopAppModuleInfo paramDesktopAppModuleInfo)
  {
    this.mModuleText.setText(paramDesktopAppModuleInfo.moduleTitle);
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    int j = paramDesktopAppModuleInfo.getModuleType();
    if ((j == 1) || (j == 2))
    {
      int i;
      if (paramDesktopAppModuleInfo.appStoreInfo != null)
      {
        this.mAppStoreInfo = paramDesktopAppModuleInfo.appStoreInfo;
        this.mMoreMiniApp.setVisibility(0);
        paramDesktopAppModuleInfo = new MiniAppConfig(paramDesktopAppModuleInfo.appStoreInfo);
        Object localObject = paramDesktopAppModuleInfo.launchParam;
        if (j == 1)
        {
          i = 3005;
          ((LaunchParam)localObject).scene = i;
          localObject = new MiniAppExposureManager.MiniAppModuleExposureData(paramDesktopAppModuleInfo, "page_view", "expo");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.mAppStoreInfo.appId).append("_").append(this.mAppStoreInfo.verType).append("_").append(j).append("_").append(paramDesktopAppModuleInfo.launchParam.scene);
          paramDesktopAppModuleInfo = localStringBuilder.toString();
          ((MiniAppExposureManager)localAppInterface.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).putReportDataToMap(paramDesktopAppModuleInfo, (MiniAppExposureManager.BaseExposureReport)localObject);
        }
      }
      for (;;)
      {
        this.mMoreMiniApp.setOnClickListener(new MiniAppDesktopAdapter.ModuleViewHolder.1(this, j));
        return;
        i = 3004;
        break;
        this.mMoreMiniApp.setVisibility(8);
      }
    }
    this.mMoreMiniApp.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.ModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */