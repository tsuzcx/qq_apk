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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopPopularModuleInfo;
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
    this.rootView = paramView.findViewById(2131438519);
    this.titleIconImg = ((ImageView)paramView.findViewById(2131438527));
    this.titleTv = ((TextView)paramView.findViewById(2131438526));
    this.moreAppImg = ((ImageView)paramView.findViewById(2131438518));
    this.firstAppIconImg = ((ImageView)paramView.findViewById(2131438515));
    this.secondAppIconImg = ((ImageView)paramView.findViewById(2131438520));
    this.thirdAppIconImg = ((ImageView)paramView.findViewById(2131438523));
    this.firstAppTitleTv = ((TextView)paramView.findViewById(2131438517));
    this.secondAppTitleTv = ((TextView)paramView.findViewById(2131438522));
    this.thirdAppTitleTv = ((TextView)paramView.findViewById(2131438525));
    this.firstAppOpenImg = ((ImageView)paramView.findViewById(2131438516));
    this.secondAppOpenImg = ((ImageView)paramView.findViewById(2131438521));
    this.thirdAppOpenImg = ((ImageView)paramView.findViewById(2131438524));
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
    Object localObject;
    switch (paramView.getId())
    {
    case 2131438517: 
    case 2131438519: 
    case 2131438522: 
    default: 
    case 2131438523: 
    case 2131438524: 
      try
      {
        if (this.popularModuleInfo.popularAppList.size() > 2)
        {
          paramView = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(2);
          localObject = (Activity)this.activityWeakRef.get();
          if (localObject != null) {
            MiniAppDesktopAdapter.startMiniApp((Activity)localObject, paramView, 3010);
          }
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append("PopularityListModuleViewHolder, size : ");
          paramView.append(this.popularModuleInfo.popularAppList.size());
          QLog.e("MiniAppDesktopAdapter", 1, paramView.toString());
          return;
        }
      }
      catch (Exception paramView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PopularityListModuleViewHolder, exception:");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramView));
        QLog.e("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject).toString());
        return;
      }
    case 2131438520: 
    case 2131438521: 
      try
      {
        if (this.popularModuleInfo.popularAppList.size() > 2)
        {
          paramView = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(1);
          localObject = (Activity)this.activityWeakRef.get();
          if (localObject != null) {
            MiniAppDesktopAdapter.startMiniApp((Activity)localObject, paramView, 3010);
          }
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append("PopularityListModuleViewHolder, size : ");
          paramView.append(this.popularModuleInfo.popularAppList.size());
          QLog.e("MiniAppDesktopAdapter", 1, paramView.toString());
          return;
        }
      }
      catch (Exception paramView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PopularityListModuleViewHolder, exception:");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramView));
        QLog.e("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject).toString());
        return;
      }
    case 2131438518: 
      paramView = (Activity)this.activityWeakRef.get();
      if (paramView != null)
      {
        localObject = this.moreAppInfo;
        if (localObject != null)
        {
          MiniAppDesktopAdapter.startMiniApp(paramView, (MiniAppInfo)localObject, 3010);
          return;
        }
      }
      break;
    case 2131438515: 
    case 2131438516: 
      try
      {
        if (this.popularModuleInfo.popularAppList.size() > 2)
        {
          paramView = (MiniAppInfo)this.popularModuleInfo.popularAppList.get(0);
          localObject = (Activity)this.activityWeakRef.get();
          if ((localObject != null) && (paramView != null)) {
            MiniAppDesktopAdapter.startMiniApp((Activity)localObject, paramView, 3010);
          }
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append("PopularityListModuleViewHolder, size : ");
          paramView.append(this.popularModuleInfo.popularAppList.size());
          QLog.e("MiniAppDesktopAdapter", 1, paramView.toString());
          return;
        }
      }
      catch (Exception paramView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PopularityListModuleViewHolder, exception:");
        ((StringBuilder)localObject).append(Log.getStackTraceString(paramView));
        QLog.e("MiniAppDesktopAdapter", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void update(DesktopPopularModuleInfo paramDesktopPopularModuleInfo, Activity paramActivity)
  {
    this.activityWeakRef = new WeakReference(paramActivity);
    List localList = paramDesktopPopularModuleInfo.popularAppList;
    if (!TextUtils.isEmpty(paramDesktopPopularModuleInfo.titleIconUrl)) {
      this.titleIconImg.setImageDrawable(MiniAppUtils.getDrawable(paramDesktopPopularModuleInfo.titleIconUrl, null));
    }
    if (!TextUtils.isEmpty(paramDesktopPopularModuleInfo.title)) {
      this.titleTv.setText(paramDesktopPopularModuleInfo.title);
    }
    paramActivity = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = this.itemView.getContext().getResources().getDrawable(2130850311);
    paramActivity.mFailedDrawable = ((Drawable)localObject);
    paramActivity.mLoadingDrawable = ((Drawable)localObject);
    int i = 0;
    paramActivity.mPlayGifImage = false;
    this.rootView.setBackgroundDrawable(MiniAppUtils.getDrawable(paramDesktopPopularModuleInfo.backgroundUrl, paramActivity));
    this.moreAppInfo = paramDesktopPopularModuleInfo.moreAppInfo;
    this.popularModuleInfo = paramDesktopPopularModuleInfo;
    if ((localList != null) && (localList.size() > 2))
    {
      paramActivity = this.firstAppIconImg;
      paramActivity.setImageDrawable(MiniAppUtils.getIcon(paramActivity.getContext(), ((MiniAppInfo)localList.get(0)).iconUrl, true));
      this.firstAppTitleTv.setText(((MiniAppInfo)localList.get(0)).name);
      this.secondAppIconImg.setImageDrawable(MiniAppUtils.getIcon(this.firstAppIconImg.getContext(), ((MiniAppInfo)localList.get(1)).iconUrl, true));
      this.secondAppTitleTv.setText(((MiniAppInfo)localList.get(1)).name);
      this.thirdAppIconImg.setImageDrawable(MiniAppUtils.getIcon(this.firstAppIconImg.getContext(), ((MiniAppInfo)localList.get(2)).iconUrl, true));
      this.thirdAppTitleTv.setText(((MiniAppInfo)localList.get(2)).name);
      paramActivity = MiniAppUtils.getAppInterface();
      if (paramActivity != null) {
        paramActivity = (MiniAppExposureManager)paramActivity.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
      } else {
        paramActivity = null;
      }
      if (paramActivity != null)
      {
        while ((i < localList.size()) && (i < 3))
        {
          localObject = new MiniAppConfig((MiniAppInfo)localList.get(i));
          ((MiniAppConfig)localObject).launchParam.scene = 3010;
          MiniAppExposureManager.MiniAppModuleExposureData localMiniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject, "page_view", "expo");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((MiniAppConfig)localObject).config.appId);
          localStringBuilder.append("_");
          localStringBuilder.append(((MiniAppConfig)localObject).config.verType);
          localStringBuilder.append("_");
          localStringBuilder.append(paramDesktopPopularModuleInfo.getModuleType());
          paramActivity.putReportDataToMap(localStringBuilder.toString(), localMiniAppModuleExposureData);
          i += 1;
        }
        paramActivity.putReportDataToMap("ranking", new MiniAppExposureManager.CardModuleExposureData("desktop", "ranking", "expo", null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.PopularityListModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */