package com.tencent.mobileqq.mini.entry.desktop;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopRecommendModuleInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;
import java.util.List;

class MiniAppDesktopAdapter$RecommendModuleViewHolder
  extends RecyclerView.ViewHolder
{
  private final List<ImageView> mApps = new ArrayList();
  private final ImageView mBackGroundImage;
  private final TextView mRecommendDesc;
  private final TextView mRecommendNumber;
  private final TextView mTitle;
  private final ImageView mTitleIcon;
  
  public MiniAppDesktopAdapter$RecommendModuleViewHolder(View paramView)
  {
    super(paramView);
    this.mBackGroundImage = ((ImageView)paramView.findViewById(2131438534));
    this.mTitleIcon = ((ImageView)paramView.findViewById(2131438539));
    this.mTitle = ((TextView)paramView.findViewById(2131438538));
    this.mRecommendNumber = ((TextView)paramView.findViewById(2131438537));
    this.mRecommendDesc = ((TextView)paramView.findViewById(2131438535));
    this.mApps.add(paramView.findViewById(2131438528));
    this.mApps.add(paramView.findViewById(2131438529));
    this.mApps.add(paramView.findViewById(2131438530));
    this.mApps.add(paramView.findViewById(2131438531));
    this.mApps.add(paramView.findViewById(2131438532));
  }
  
  public void bindView(Activity paramActivity, DesktopRecommendModuleInfo paramDesktopRecommendModuleInfo)
  {
    INTERFACE.StModuleInfo localStModuleInfo = paramDesktopRecommendModuleInfo.moduleInfo;
    try
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      Object localObject2 = this.itemView.getContext().getResources().getDrawable(2130850311);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      this.mBackGroundImage.setImageDrawable(MiniAppUtils.getDrawable(localStModuleInfo.backgroundPic.get(), (URLDrawable.URLDrawableOptions)localObject1));
      label62:
      MiniAppUtils.setImage(this.mTitleIcon, localStModuleInfo.titleIcon.get());
      this.mTitle.setText(localStModuleInfo.title.get());
      localObject1 = this.mRecommendNumber;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localStModuleInfo.appTotalNum.get());
      ((StringBuilder)localObject2).append("");
      ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      this.mRecommendDesc.setText(localStModuleInfo.desc.get());
      int i = 0;
      int j;
      for (;;)
      {
        j = i;
        if (i >= this.mApps.size()) {
          break;
        }
        j = i;
        if (i >= localStModuleInfo.userAppList.size()) {
          break;
        }
        ((ImageView)this.mApps.get(i)).setVisibility(0);
        ((ImageView)this.mApps.get(i)).setImageDrawable(MiniAppUtils.getIcon(this.itemView.getContext(), ((INTERFACE.StUserAppInfo)localStModuleInfo.userAppList.get(i)).appInfo.icon.get(), true));
        i += 1;
      }
      while (j < this.mApps.size())
      {
        ((ImageView)this.mApps.get(j)).setImageDrawable(null);
        ((ImageView)this.mApps.get(j)).setVisibility(4);
        j += 1;
      }
      MiniAppUtils.setJump(paramActivity, this.itemView, paramDesktopRecommendModuleInfo.jumpMoreInfo, 3008);
      paramActivity = MiniAppUtils.getAppInterface();
      if (paramActivity != null) {
        ((MiniAppExposureManager)paramActivity.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).putReportDataToMap("featured", new MiniAppExposureManager.CardModuleExposureData("desktop", "featured", "expo", null));
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.RecommendModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */