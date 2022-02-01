package com.tencent.mobileqq.mini.entry.desktop;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopPopularModuleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

class MiniAppDesktopAdapter$PopularityListModuleViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private WeakReference<Activity> activityWeakRef;
  private ImageView firstAppIconImg;
  private ImageView firstAppOpenImg;
  private TextView firstAppTitleTv;
  private ImageView moreAppImg;
  private MiniAppInfo moreAppInfo;
  private DesktopPopularModuleInfo popularModuleInfo;
  private View rootView;
  private ImageView secondAppIconImg;
  private ImageView secondAppOpenImg;
  private TextView secondAppTitleTv;
  private ImageView thirdAppIconImg;
  private ImageView thirdAppOpenImg;
  private TextView thirdAppTitleTv;
  private ImageView titleIconImg;
  private TextView titleTv;
  
  public MiniAppDesktopAdapter$PopularityListModuleViewHolder(View paramView)
  {
    super(paramView);
    this.rootView = paramView.findViewById(2131371085);
    this.titleIconImg = ((ImageView)paramView.findViewById(2131371093));
    this.titleTv = ((TextView)paramView.findViewById(2131371092));
    this.moreAppImg = ((ImageView)paramView.findViewById(2131371084));
    this.firstAppIconImg = ((ImageView)paramView.findViewById(2131371081));
    this.secondAppIconImg = ((ImageView)paramView.findViewById(2131371086));
    this.thirdAppIconImg = ((ImageView)paramView.findViewById(2131371089));
    this.firstAppTitleTv = ((TextView)paramView.findViewById(2131371083));
    this.secondAppTitleTv = ((TextView)paramView.findViewById(2131371088));
    this.thirdAppTitleTv = ((TextView)paramView.findViewById(2131371091));
    this.firstAppOpenImg = ((ImageView)paramView.findViewById(2131371082));
    this.secondAppOpenImg = ((ImageView)paramView.findViewById(2131371087));
    this.thirdAppOpenImg = ((ImageView)paramView.findViewById(2131371090));
    this.firstAppIconImg.setOnClickListener(this);
    this.secondAppIconImg.setOnClickListener(this);
    this.thirdAppIconImg.setOnClickListener(this);
    this.firstAppOpenImg.setOnClickListener(this);
    this.secondAppOpenImg.setOnClickListener(this);
    this.thirdAppOpenImg.setOnClickListener(this);
    this.moreAppImg.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Activity localActivity2;
      try
      {
        if (this.popularModuleInfo.popularAppList.size() <= 2) {
          break label163;
        }
        MiniAppInfo localMiniAppInfo1 = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(0);
        localActivity2 = (Activity)this.activityWeakRef.get();
        if ((localActivity2 == null) || (localMiniAppInfo1 == null)) {
          continue;
        }
        MiniAppDesktopAdapter.startMiniApp(localActivity2, localMiniAppInfo1, 3010);
      }
      catch (Exception localException1)
      {
        QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, exception:" + Log.getStackTraceString(localException1));
      }
      continue;
      label163:
      QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, size : " + this.popularModuleInfo.popularAppList.size());
      continue;
      try
      {
        if (this.popularModuleInfo.popularAppList.size() <= 2) {
          break label293;
        }
        MiniAppInfo localMiniAppInfo2 = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(1);
        localActivity2 = (Activity)this.activityWeakRef.get();
        if (localActivity2 == null) {
          continue;
        }
        MiniAppDesktopAdapter.startMiniApp(localActivity2, localMiniAppInfo2, 3010);
      }
      catch (Exception localException2)
      {
        QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, exception:" + Log.getStackTraceString(localException2));
      }
      continue;
      label293:
      QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, size : " + this.popularModuleInfo.popularAppList.size());
      continue;
      try
      {
        if (this.popularModuleInfo.popularAppList.size() <= 2) {
          break label423;
        }
        MiniAppInfo localMiniAppInfo3 = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(2);
        localActivity2 = (Activity)this.activityWeakRef.get();
        if (localActivity2 == null) {
          continue;
        }
        MiniAppDesktopAdapter.startMiniApp(localActivity2, localMiniAppInfo3, 3010);
      }
      catch (Exception localException3)
      {
        QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, exception:" + Log.getStackTraceString(localException3));
      }
      continue;
      label423:
      QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, size : " + this.popularModuleInfo.popularAppList.size());
      continue;
      Activity localActivity1 = (Activity)this.activityWeakRef.get();
      if ((localActivity1 != null) && (this.moreAppInfo != null)) {
        MiniAppDesktopAdapter.startMiniApp(localActivity1, this.moreAppInfo, 3010);
      }
    }
  }
  
  public void update(DesktopPopularModuleInfo paramDesktopPopularModuleInfo, Activity paramActivity)
  {
    int i = 0;
    this.activityWeakRef = new WeakReference(paramActivity);
    List localList = paramDesktopPopularModuleInfo.popularAppList;
    if (!TextUtils.isEmpty(paramDesktopPopularModuleInfo.titleIconUrl)) {
      this.titleIconImg.setImageDrawable(MiniAppUtils.getDrawable(paramDesktopPopularModuleInfo.titleIconUrl, null));
    }
    if (!TextUtils.isEmpty(paramDesktopPopularModuleInfo.title)) {
      this.titleTv.setText(paramDesktopPopularModuleInfo.title);
    }
    paramActivity = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = this.itemView.getContext().getResources().getDrawable(2130848318);
    paramActivity.mFailedDrawable = ((Drawable)localObject);
    paramActivity.mLoadingDrawable = ((Drawable)localObject);
    paramActivity.mPlayGifImage = false;
    this.rootView.setBackgroundDrawable(MiniAppUtils.getDrawable(paramDesktopPopularModuleInfo.backgroundUrl, paramActivity));
    this.moreAppInfo = paramDesktopPopularModuleInfo.moreAppInfo;
    this.popularModuleInfo = paramDesktopPopularModuleInfo;
    if ((localList != null) && (localList.size() > 2))
    {
      this.firstAppIconImg.setImageDrawable(MiniAppUtils.getIcon(this.firstAppIconImg.getContext(), ((MiniAppInfo)localList.get(0)).iconUrl, true));
      this.firstAppTitleTv.setText(((MiniAppInfo)localList.get(0)).name);
      this.secondAppIconImg.setImageDrawable(MiniAppUtils.getIcon(this.firstAppIconImg.getContext(), ((MiniAppInfo)localList.get(1)).iconUrl, true));
      this.secondAppTitleTv.setText(((MiniAppInfo)localList.get(1)).name);
      this.thirdAppIconImg.setImageDrawable(MiniAppUtils.getIcon(this.firstAppIconImg.getContext(), ((MiniAppInfo)localList.get(2)).iconUrl, true));
      this.thirdAppTitleTv.setText(((MiniAppInfo)localList.get(2)).name);
      paramActivity = MiniAppUtils.getAppInterface();
      if (paramActivity == null) {
        break label490;
      }
    }
    label490:
    for (paramActivity = (MiniAppExposureManager)paramActivity.getManager(322);; paramActivity = null)
    {
      if (paramActivity != null)
      {
        while ((i < localList.size()) && (i < 3))
        {
          localObject = new MiniAppConfig((MiniAppInfo)localList.get(i));
          ((MiniAppConfig)localObject).launchParam.scene = 3010;
          MiniAppExposureManager.MiniAppModuleExposureData localMiniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject, "page_view", "expo");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((MiniAppConfig)localObject).config.appId).append("_").append(((MiniAppConfig)localObject).config.verType).append("_").append(paramDesktopPopularModuleInfo.getModuleType());
          paramActivity.putReportDataToMap(localStringBuilder.toString(), localMiniAppModuleExposureData);
          i += 1;
        }
        paramActivity.putReportDataToMap("ranking", new MiniAppExposureManager.CardModuleExposureData("desktop", "ranking", "expo", null));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.PopularityListModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */