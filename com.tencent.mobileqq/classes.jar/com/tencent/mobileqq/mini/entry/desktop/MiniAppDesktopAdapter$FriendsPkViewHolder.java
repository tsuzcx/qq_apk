package com.tencent.mobileqq.mini.entry.desktop;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StFriendRanking;
import NS_MINI_INTERFACE.INTERFACE.StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE.StRankingList;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.CardModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopFriendsPkModuleInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.ArrayList;

class MiniAppDesktopAdapter$FriendsPkViewHolder
  extends RecyclerView.ViewHolder
{
  private final ImageView mBackground;
  private final ImageView mMoreIcon;
  private final ImageView mPkButton;
  private final ArrayList<MiniAppDesktopAdapter.FriendsPkViewHolder.Item> mRanking = new ArrayList();
  private final TextView mTitle;
  private final ImageView mTitleIcon;
  private final TextView mTopAppDesc;
  private final ImageView mTopAppIcon;
  private final TextView mTopAppName;
  
  public MiniAppDesktopAdapter$FriendsPkViewHolder(View paramView)
  {
    super(paramView);
    this.mBackground = ((ImageView)paramView.findViewById(2131371481));
    this.mTitleIcon = ((ImageView)paramView.findViewById(2131371490));
    this.mTitle = ((TextView)paramView.findViewById(2131371489));
    this.mMoreIcon = ((ImageView)paramView.findViewById(2131371491));
    this.mPkButton = ((ImageView)paramView.findViewById(2131371483));
    this.mTopAppIcon = ((ImageView)paramView.findViewById(2131371492));
    this.mTopAppName = ((TextView)paramView.findViewById(2131371495));
    this.mTopAppDesc = ((TextView)paramView.findViewById(2131371494));
    this.mRanking.add(new MiniAppDesktopAdapter.FriendsPkViewHolder.Item(this, paramView.findViewById(2131371485)));
    this.mRanking.add(new MiniAppDesktopAdapter.FriendsPkViewHolder.Item(this, paramView.findViewById(2131371486)));
    this.mRanking.add(new MiniAppDesktopAdapter.FriendsPkViewHolder.Item(this, paramView.findViewById(2131371487)));
    this.mRanking.add(new MiniAppDesktopAdapter.FriendsPkViewHolder.Item(this, paramView.findViewById(2131371488)));
    ((MiniAppDesktopAdapter.FriendsPkViewHolder.Item)this.mRanking.get(0)).mCrown.setVisibility(0);
    ((MiniAppDesktopAdapter.FriendsPkViewHolder.Item)this.mRanking.get(3)).setOutOfRankStyle();
  }
  
  public void bindView(Activity paramActivity, DesktopFriendsPkModuleInfo paramDesktopFriendsPkModuleInfo)
  {
    Object localObject1 = paramDesktopFriendsPkModuleInfo.moduleInfo;
    Object localObject2 = paramDesktopFriendsPkModuleInfo.ranking;
    Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = this.itemView.getContext().getResources().getDrawable(2130848766);
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = localDrawable;
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = localDrawable;
    ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
    try
    {
      this.mBackground.setImageDrawable(MiniAppUtils.getDrawable(((INTERFACE.StModuleInfo)localObject1).backgroundPic.get(), (URLDrawable.URLDrawableOptions)localObject3));
      MiniAppUtils.setImage(this.mTitleIcon, ((INTERFACE.StModuleInfo)localObject1).titleIcon.get());
      this.mTitle.setText(((INTERFACE.StModuleInfo)localObject1).title.get());
      MiniAppUtils.setImage(this.mPkButton, ((INTERFACE.StFriendRanking)localObject2).animationPic.get());
      this.mTopAppName.setText(((INTERFACE.StFriendRanking)localObject2).gameInfo.appInfo.appName.get());
      this.mTopAppIcon.setImageDrawable(MiniAppUtils.getIcon(this.itemView.getContext(), ((INTERFACE.StFriendRanking)localObject2).gameInfo.appInfo.icon.get(), true));
      this.mTopAppDesc.setText(((INTERFACE.StFriendRanking)localObject2).friendsNum.get() + HardCodeUtil.a(2131706808));
      int i = 0;
      int j;
      for (;;)
      {
        j = i;
        if (i >= ((INTERFACE.StFriendRanking)localObject2).rankingList.size()) {
          break;
        }
        j = i;
        if (i >= this.mRanking.size()) {
          break;
        }
        ((MiniAppDesktopAdapter.FriendsPkViewHolder.Item)this.mRanking.get(i)).setData((INTERFACE.StRankingList)((INTERFACE.StFriendRanking)localObject2).rankingList.get(i));
        i += 1;
      }
      while (j < this.mRanking.size())
      {
        ((MiniAppDesktopAdapter.FriendsPkViewHolder.Item)this.mRanking.get(j)).gone();
        j += 1;
      }
      MiniAppUtils.setJump(paramActivity, this.mMoreIcon, paramDesktopFriendsPkModuleInfo.jumpMoreInfo, 3009);
      MiniAppUtils.setJump(paramActivity, this.itemView, paramDesktopFriendsPkModuleInfo.appInfo, 3009);
      paramActivity = MiniAppUtils.getAppInterface();
      if (paramActivity != null)
      {
        paramActivity = (MiniAppExposureManager)paramActivity.getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER);
        if (paramActivity != null)
        {
          localObject1 = new MiniAppConfig(paramDesktopFriendsPkModuleInfo.appInfo);
          ((MiniAppConfig)localObject1).launchParam.scene = 3009;
          localObject1 = new MiniAppExposureManager.MiniAppModuleExposureData((MiniAppConfig)localObject1, "page_view", "expo");
          localObject2 = new MiniAppExposureManager.CardModuleExposureData("desktop", "pk", "expo", null);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramDesktopFriendsPkModuleInfo.appInfo.appId).append("_").append(paramDesktopFriendsPkModuleInfo.appInfo.verType).append("_").append(paramDesktopFriendsPkModuleInfo.getModuleType());
          paramActivity.putReportDataToMap(((StringBuilder)localObject3).toString(), (MiniAppExposureManager.BaseExposureReport)localObject1);
          paramActivity.putReportDataToMap("pk", (MiniAppExposureManager.BaseExposureReport)localObject2);
        }
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        continue;
        paramActivity = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.FriendsPkViewHolder
 * JD-Core Version:    0.7.0.1
 */