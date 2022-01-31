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
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.qphone.base.util.QLog;
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
    this.rootView = paramView.findViewById(2131370225);
    this.titleIconImg = ((ImageView)paramView.findViewById(2131370233));
    this.titleTv = ((TextView)paramView.findViewById(2131370232));
    this.moreAppImg = ((ImageView)paramView.findViewById(2131370224));
    this.firstAppIconImg = ((ImageView)paramView.findViewById(2131370221));
    this.secondAppIconImg = ((ImageView)paramView.findViewById(2131370226));
    this.thirdAppIconImg = ((ImageView)paramView.findViewById(2131370229));
    this.firstAppTitleTv = ((TextView)paramView.findViewById(2131370223));
    this.secondAppTitleTv = ((TextView)paramView.findViewById(2131370228));
    this.thirdAppTitleTv = ((TextView)paramView.findViewById(2131370231));
    this.firstAppOpenImg = ((ImageView)paramView.findViewById(2131370222));
    this.secondAppOpenImg = ((ImageView)paramView.findViewById(2131370227));
    this.thirdAppOpenImg = ((ImageView)paramView.findViewById(2131370230));
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
      return;
      Object localObject;
      Activity localActivity;
      try
      {
        if (this.popularModuleInfo.popularAppList.size() > 2)
        {
          paramView = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(0);
          localObject = new LaunchParam();
          ((LaunchParam)localObject).scene = 3010;
          localActivity = (Activity)this.activityWeakRef.get();
          if ((localActivity == null) || (paramView == null)) {
            continue;
          }
          MiniAppController.launchMiniAppByAppInfo(localActivity, paramView, (LaunchParam)localObject);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, exception:" + Log.getStackTraceString(paramView));
        return;
      }
      QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, size : " + this.popularModuleInfo.popularAppList.size());
      return;
      try
      {
        if (this.popularModuleInfo.popularAppList.size() > 2)
        {
          paramView = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(1);
          localObject = new LaunchParam();
          ((LaunchParam)localObject).scene = 3010;
          localActivity = (Activity)this.activityWeakRef.get();
          if (localActivity == null) {
            continue;
          }
          MiniAppController.launchMiniAppByAppInfo(localActivity, paramView, (LaunchParam)localObject);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, exception:" + Log.getStackTraceString(paramView));
        return;
      }
      QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, size : " + this.popularModuleInfo.popularAppList.size());
      return;
      try
      {
        if (this.popularModuleInfo.popularAppList.size() > 2)
        {
          paramView = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(2);
          localObject = new LaunchParam();
          ((LaunchParam)localObject).scene = 3010;
          localActivity = (Activity)this.activityWeakRef.get();
          if (localActivity == null) {
            continue;
          }
          MiniAppController.launchMiniAppByAppInfo(localActivity, paramView, (LaunchParam)localObject);
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, exception:" + Log.getStackTraceString(paramView));
        return;
      }
      QLog.e("MiniAppDesktopAdapter", 1, "PopularityListModuleViewHolder, size : " + this.popularModuleInfo.popularAppList.size());
      return;
      paramView = new LaunchParam();
      paramView.scene = 3010;
      try
      {
        localObject = (Activity)this.activityWeakRef.get();
        if ((localObject != null) && (this.moreAppInfo != null))
        {
          MiniAppController.launchMiniAppByAppInfo((Activity)localObject, this.moreAppInfo, paramView);
          return;
        }
      }
      catch (MiniAppException paramView)
      {
        paramView.printStackTrace();
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
    Object localObject = this.itemView.getContext().getResources().getDrawable(2130847457);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.PopularityListModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */