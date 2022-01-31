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
    this.mBackGroundImage = ((ImageView)paramView.findViewById(2131370240));
    this.mTitleIcon = ((ImageView)paramView.findViewById(2131370245));
    this.mTitle = ((TextView)paramView.findViewById(2131370244));
    this.mRecommendNumber = ((TextView)paramView.findViewById(2131370243));
    this.mRecommendDesc = ((TextView)paramView.findViewById(2131370241));
    this.mApps.add(paramView.findViewById(2131370234));
    this.mApps.add(paramView.findViewById(2131370235));
    this.mApps.add(paramView.findViewById(2131370236));
    this.mApps.add(paramView.findViewById(2131370237));
    this.mApps.add(paramView.findViewById(2131370238));
  }
  
  public void bindView(Activity paramActivity, DesktopRecommendModuleInfo paramDesktopRecommendModuleInfo)
  {
    INTERFACE.StModuleInfo localStModuleInfo = paramDesktopRecommendModuleInfo.moduleInfo;
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      Drawable localDrawable = this.itemView.getContext().getResources().getDrawable(2130847457);
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      this.mBackGroundImage.setImageDrawable(MiniAppUtils.getDrawable(localStModuleInfo.backgroundPic.get(), localURLDrawableOptions));
      label62:
      MiniAppUtils.setImage(this.mTitleIcon, localStModuleInfo.titleIcon.get());
      this.mTitle.setText(localStModuleInfo.title.get());
      this.mRecommendNumber.setText(localStModuleInfo.appTotalNum.get() + "");
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
        ((MiniAppExposureManager)paramActivity.getManager(322)).putReportDataToMap("featured", new MiniAppExposureManager.CardModuleExposureData("desktop", "featured", "expo", null));
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.RecommendModuleViewHolder
 * JD-Core Version:    0.7.0.1
 */