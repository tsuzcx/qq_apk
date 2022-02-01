package com.tencent.mobileqq.profilecard.bussiness.favor;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.favor.view.ProfileCardFavorItemDetailView;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileColor;
import com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesItem;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class ProfileFavorComponent
  extends AbsProfileContentComponent
  implements View.OnClickListener
{
  private static final String TAG = "ProfileFavorComponent";
  private boolean hasReportedBuluo = false;
  private boolean hasReportedMusic = false;
  
  public ProfileFavorComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void addFavorItem(ProfileSummaryHobbiesEntry paramProfileSummaryHobbiesEntry, LinearLayout paramLinearLayout, Resources paramResources)
  {
    ProfileContentTitleView localProfileContentTitleView = new ProfileContentTitleView(this.mActivity);
    localProfileContentTitleView.setTitle(paramProfileSummaryHobbiesEntry.strName);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileFavorComponent", 2, String.format("addFavorItem title=%s", new Object[] { paramProfileSummaryHobbiesEntry.strName }));
    }
    int i = 0;
    while (i < paramProfileSummaryHobbiesEntry.sProfileSummaryHobbiesItem.size())
    {
      ProfileSummaryHobbiesItem localProfileSummaryHobbiesItem = (ProfileSummaryHobbiesItem)paramProfileSummaryHobbiesEntry.sProfileSummaryHobbiesItem.get(i);
      ProfileCardFavorItemDetailView localProfileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.mActivity);
      localProfileCardFavorItemDetailView.setTitle(localProfileSummaryHobbiesItem.strTitle);
      localProfileCardFavorItemDetailView.setContent(localProfileSummaryHobbiesItem.strSubInfo);
      localProfileCardFavorItemDetailView.setDesc(localProfileSummaryHobbiesItem.strDesc);
      Drawable localDrawable = paramResources.getDrawable(2131167228);
      Object localObject = localDrawable;
      if (!TextUtils.isEmpty(localProfileSummaryHobbiesItem.strCoverUrl))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = Utils.a(70.0F, paramResources);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = Utils.a(70.0F, paramResources);
        localObject = URLDrawable.getDrawable(localProfileSummaryHobbiesItem.strCoverUrl, (URLDrawable.URLDrawableOptions)localObject);
      }
      localProfileCardFavorItemDetailView.setIcon((Drawable)localObject);
      if (!TextUtils.isEmpty(localProfileSummaryHobbiesItem.strTitleIconUrl)) {
        localProfileCardFavorItemDetailView.addLabel(localProfileSummaryHobbiesItem.strTitleIconUrl, 2);
      }
      localObject = localProfileSummaryHobbiesItem;
      if (localProfileSummaryHobbiesItem.labels != null)
      {
        localObject = localProfileSummaryHobbiesItem;
        if (localProfileSummaryHobbiesItem.labels.size() > 0)
        {
          int j = 0;
          for (;;)
          {
            localObject = localProfileSummaryHobbiesItem;
            if (j >= localProfileSummaryHobbiesItem.labels.size()) {
              break;
            }
            localObject = (ProfileGroupLabel)localProfileSummaryHobbiesItem.labels.get(j);
            int k = Color.rgb((int)((ProfileGroupLabel)localObject).edgingColor.red, (int)((ProfileGroupLabel)localObject).edgingColor.green, (int)((ProfileGroupLabel)localObject).edgingColor.blue);
            localProfileCardFavorItemDetailView.addLabel(null, ((ProfileGroupLabel)localObject).strWording, k, 3);
            j += 1;
          }
        }
      }
      localProfileCardFavorItemDetailView.setBackgroundResource(2130839624);
      localProfileContentTitleView.addContentView(localProfileCardFavorItemDetailView);
      localProfileCardFavorItemDetailView.setTag(new DataTag(62, localObject));
      localProfileCardFavorItemDetailView.setOnClickListener(this);
      boolean bool;
      if (i != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localProfileCardFavorItemDetailView.setNeedTopMargin(bool);
      favorHobbyItemExposureReport((ProfileSummaryHobbiesItem)localObject);
      updateItemTheme(localProfileCardFavorItemDetailView.row1Content, localProfileCardFavorItemDetailView.row2Content);
      updateItemTheme(null, localProfileCardFavorItemDetailView.row3Content);
      i += 1;
    }
    paramProfileSummaryHobbiesEntry = new DataTag(61, paramProfileSummaryHobbiesEntry);
    localProfileContentTitleView.mTitleContainer.setTag(paramProfileSummaryHobbiesEntry);
    localProfileContentTitleView.mTitleContainer.setOnClickListener(this);
    paramLinearLayout.addView(localProfileContentTitleView);
    updateItemTheme(localProfileContentTitleView, true);
  }
  
  private void favorHobbyClickReport(int paramInt)
  {
    ReportController.b(this.mApp, "dc00898", "", "", "0X80093BF", "0X80093BF", paramInt, 0, "", "", "", "");
  }
  
  private void favorHobbyItemClickReport(ProfileSummaryHobbiesItem paramProfileSummaryHobbiesItem)
  {
    int i = paramProfileSummaryHobbiesItem.serviceType;
    if (i != 2)
    {
      if (i != 4) {
        return;
      }
      ReportController.b(this.mApp, "dc00898", "", "", "0X80070AE", "0X80070AE", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.mApp, "dc00898", "", "", "0X80070AA", "0X80070AA", 0, 0, "", "", "", "");
  }
  
  private void favorHobbyItemExposureReport(ProfileSummaryHobbiesItem paramProfileSummaryHobbiesItem)
  {
    int i = paramProfileSummaryHobbiesItem.serviceType;
    if (i != 2)
    {
      if (i != 4) {
        return;
      }
      if (!this.hasReportedBuluo)
      {
        ReportController.b(this.mApp, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
        this.hasReportedBuluo = true;
      }
    }
    else if (!this.hasReportedMusic)
    {
      ReportController.b(this.mApp, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
      this.hasReportedMusic = true;
    }
  }
  
  private int fillUpFavorItem(LinearLayout paramLinearLayout, Card paramCard)
  {
    paramCard = paramCard.getBigOrderEntrys();
    int i = 0;
    int j = 0;
    if (paramCard != null)
    {
      paramLinearLayout.removeAllViews();
      int k;
      for (i = 0; j < paramCard.size(); i = k)
      {
        ProfileSummaryHobbiesEntry localProfileSummaryHobbiesEntry = (ProfileSummaryHobbiesEntry)paramCard.get(j);
        k = i;
        if (!TextUtils.isEmpty(localProfileSummaryHobbiesEntry.strName))
        {
          k = i;
          if (localProfileSummaryHobbiesEntry.sProfileSummaryHobbiesItem != null) {
            if (localProfileSummaryHobbiesEntry.serviceType == 5)
            {
              k = i;
            }
            else if ((localProfileSummaryHobbiesEntry.serviceType == 4) && (this.mConfigHelper != null) && (!this.mConfigHelper.isSwitchEnable(5)))
            {
              k = i;
            }
            else if ((localProfileSummaryHobbiesEntry.serviceType == 2) && (this.mConfigHelper != null) && (!this.mConfigHelper.isSwitchEnable(4)))
            {
              k = i;
            }
            else
            {
              addFavorItem(localProfileSummaryHobbiesEntry, paramLinearLayout, this.mActivity.getResources());
              k = i + 1;
            }
          }
        }
        j += 1;
      }
    }
    return i;
  }
  
  private void handleHobbyClick(DataTag paramDataTag)
  {
    if ((paramDataTag.b instanceof ProfileSummaryHobbiesEntry))
    {
      paramDataTag = (ProfileSummaryHobbiesEntry)paramDataTag.b;
      Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramDataTag.strServiceUrl);
      if (paramDataTag.serviceType == 2) {
        localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
      } else if (paramDataTag.serviceType == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
      this.mActivity.startActivity(localIntent);
      favorHobbyClickReport(paramDataTag.serviceType);
    }
  }
  
  private void handleHobbyItemClick(DataTag paramDataTag)
  {
    if ((paramDataTag.b instanceof ProfileSummaryHobbiesItem))
    {
      paramDataTag = (ProfileSummaryHobbiesItem)paramDataTag.b;
      Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramDataTag.strJmpUrl);
      if (paramDataTag.serviceType == 2) {
        localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
      } else if (paramDataTag.serviceType == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
      this.mActivity.startActivity(localIntent);
      favorHobbyItemClickReport(paramDataTag);
    }
  }
  
  private boolean makeOrRefreshFavor(Card paramCard, boolean paramBoolean)
  {
    boolean bool = ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo)this.mData).allInOne);
    paramBoolean = false;
    if ((paramCard != null) && (!bool))
    {
      LinearLayout localLinearLayout;
      if (this.mViewContainer == null)
      {
        localLinearLayout = (LinearLayout)LayoutInflater.from(this.mActivity).inflate(2131627666, null, false);
        localLinearLayout.setTag(2131433814, Boolean.TRUE);
        this.mViewContainer = localLinearLayout;
        paramBoolean = true;
      }
      else
      {
        localLinearLayout = (LinearLayout)this.mViewContainer;
      }
      if (fillUpFavorItem(localLinearLayout, paramCard) > 0) {
        return true;
      }
      if (this.mViewContainer != null)
      {
        this.mViewContainer = null;
        return true;
      }
      return paramBoolean;
    }
    if (this.mViewContainer != null)
    {
      this.mViewContainer = null;
      return true;
    }
    return false;
  }
  
  public String getComponentName()
  {
    return "ProfileFavorComponent";
  }
  
  public int getComponentType()
  {
    return 1006;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_favor";
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof DataTag))
    {
      DataTag localDataTag = (DataTag)paramView.getTag();
      int i = localDataTag.a;
      if (i != 61)
      {
        if (i == 62) {
          handleHobbyItemClick(localDataTag);
        }
      }
      else {
        handleHobbyClick(localDataTag);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshFavor(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.favor.ProfileFavorComponent
 * JD-Core Version:    0.7.0.1
 */