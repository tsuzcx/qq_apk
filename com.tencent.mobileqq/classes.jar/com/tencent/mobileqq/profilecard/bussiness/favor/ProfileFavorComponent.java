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
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.entity.ProfileColor;
import com.tencent.mobileqq.profilecard.entity.ProfileGroupLabel;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesEntry;
import com.tencent.mobileqq.profilecard.entity.ProfileSummaryHobbiesItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProfileCardFavorItemDetailView;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
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
      QLog.d("ProfileFavorComponent", 0, String.format("addFavorItem title=%s", new Object[] { paramProfileSummaryHobbiesEntry.strName }));
    }
    int i = 0;
    if (i < paramProfileSummaryHobbiesEntry.sProfileSummaryHobbiesItem.size())
    {
      ProfileSummaryHobbiesItem localProfileSummaryHobbiesItem = (ProfileSummaryHobbiesItem)paramProfileSummaryHobbiesEntry.sProfileSummaryHobbiesItem.get(i);
      ProfileCardFavorItemDetailView localProfileCardFavorItemDetailView = new ProfileCardFavorItemDetailView(this.mActivity);
      localProfileCardFavorItemDetailView.setTitle(localProfileSummaryHobbiesItem.strTitle);
      localProfileCardFavorItemDetailView.setContent(localProfileSummaryHobbiesItem.strSubInfo);
      localProfileCardFavorItemDetailView.setDesc(localProfileSummaryHobbiesItem.strDesc);
      Drawable localDrawable = paramResources.getDrawable(2131166381);
      Object localObject = localDrawable;
      if (!TextUtils.isEmpty(localProfileSummaryHobbiesItem.strCoverUrl))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = AIOUtils.a(70.0F, paramResources);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = AIOUtils.a(70.0F, paramResources);
        localObject = URLDrawable.getDrawable(localProfileSummaryHobbiesItem.strCoverUrl, (URLDrawable.URLDrawableOptions)localObject);
      }
      localProfileCardFavorItemDetailView.setIcon((Drawable)localObject);
      if (!TextUtils.isEmpty(localProfileSummaryHobbiesItem.strTitleIconUrl)) {
        localProfileCardFavorItemDetailView.a(localProfileSummaryHobbiesItem.strTitleIconUrl, 2);
      }
      if ((localProfileSummaryHobbiesItem.labels != null) && (localProfileSummaryHobbiesItem.labels.size() > 0))
      {
        int j = 0;
        while (j < localProfileSummaryHobbiesItem.labels.size())
        {
          localObject = (ProfileGroupLabel)localProfileSummaryHobbiesItem.labels.get(j);
          int k = Color.rgb((int)((ProfileGroupLabel)localObject).edgingColor.red, (int)((ProfileGroupLabel)localObject).edgingColor.green, (int)((ProfileGroupLabel)localObject).edgingColor.blue);
          localProfileCardFavorItemDetailView.a(null, ((ProfileGroupLabel)localObject).strWording, k, 3);
          j += 1;
        }
      }
      localProfileCardFavorItemDetailView.setBackgroundResource(2130839577);
      localProfileContentTitleView.addContentView(localProfileCardFavorItemDetailView);
      localProfileCardFavorItemDetailView.setTag(new DataTag(62, localProfileSummaryHobbiesItem));
      localProfileCardFavorItemDetailView.setOnClickListener(this);
      if (i != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localProfileCardFavorItemDetailView.setNeedTopMargin(bool);
        favorHobbyItemExposureReport(localProfileSummaryHobbiesItem);
        updateItemTheme(localProfileCardFavorItemDetailView.a, localProfileCardFavorItemDetailView.b);
        updateItemTheme(null, localProfileCardFavorItemDetailView.c);
        i += 1;
        break;
      }
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
    switch (paramProfileSummaryHobbiesItem.serviceType)
    {
    case 3: 
    default: 
      return;
    case 2: 
      ReportController.b(this.mApp, "dc00898", "", "", "0X80070AA", "0X80070AA", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.mApp, "dc00898", "", "", "0X80070AE", "0X80070AE", 0, 0, "", "", "", "");
  }
  
  private void favorHobbyItemExposureReport(ProfileSummaryHobbiesItem paramProfileSummaryHobbiesItem)
  {
    switch (paramProfileSummaryHobbiesItem.serviceType)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.hasReportedMusic);
      ReportController.b(this.mApp, "dc00898", "", "", "0X80070A9", "0X80070A9", 0, 0, "", "", "", "");
      this.hasReportedMusic = true;
      return;
    } while (this.hasReportedBuluo);
    ReportController.b(this.mApp, "dc00898", "", "", "0X80070AD", "0X80070AD", 0, 0, "", "", "", "");
    this.hasReportedBuluo = true;
  }
  
  private int fillUpFavorItem(LinearLayout paramLinearLayout, Card paramCard)
  {
    paramCard = paramCard.getBigOrderEntrys();
    int k;
    if (paramCard != null)
    {
      paramLinearLayout.removeAllViews();
      int j = 0;
      int i = 0;
      k = i;
      if (j < paramCard.size())
      {
        ProfileSummaryHobbiesEntry localProfileSummaryHobbiesEntry = (ProfileSummaryHobbiesEntry)paramCard.get(j);
        k = i;
        if (!TextUtils.isEmpty(localProfileSummaryHobbiesEntry.strName))
        {
          k = i;
          if (localProfileSummaryHobbiesEntry.sProfileSummaryHobbiesItem != null)
          {
            if (localProfileSummaryHobbiesEntry.serviceType != 5) {
              break label94;
            }
            k = i;
          }
        }
        for (;;)
        {
          j += 1;
          i = k;
          break;
          label94:
          if ((localProfileSummaryHobbiesEntry.serviceType == 4) && (this.mConfigHelper != null))
          {
            k = i;
            if (!this.mConfigHelper.a(5)) {}
          }
          else if ((localProfileSummaryHobbiesEntry.serviceType == 2) && (this.mConfigHelper != null))
          {
            k = i;
            if (!this.mConfigHelper.a(4)) {}
          }
          else
          {
            addFavorItem(localProfileSummaryHobbiesEntry, paramLinearLayout, this.mActivity.getResources());
            k = i + 1;
          }
        }
      }
    }
    else
    {
      k = 0;
    }
    return k;
  }
  
  private void handleHobbyClick(DataTag paramDataTag)
  {
    Intent localIntent;
    if ((paramDataTag.jdField_a_of_type_JavaLangObject instanceof ProfileSummaryHobbiesEntry))
    {
      paramDataTag = (ProfileSummaryHobbiesEntry)paramDataTag.jdField_a_of_type_JavaLangObject;
      localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramDataTag.strServiceUrl);
      if (paramDataTag.serviceType != 2) {
        break label81;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
    }
    for (;;)
    {
      this.mActivity.startActivity(localIntent);
      favorHobbyClickReport(paramDataTag.serviceType);
      return;
      label81:
      if (paramDataTag.serviceType == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
  }
  
  private void handleHobbyItemClick(DataTag paramDataTag)
  {
    Intent localIntent;
    if ((paramDataTag.jdField_a_of_type_JavaLangObject instanceof ProfileSummaryHobbiesItem))
    {
      paramDataTag = (ProfileSummaryHobbiesItem)paramDataTag.jdField_a_of_type_JavaLangObject;
      localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramDataTag.strJmpUrl);
      if (paramDataTag.serviceType != 2) {
        break label78;
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_qqmusic");
    }
    for (;;)
    {
      this.mActivity.startActivity(localIntent);
      favorHobbyItemClickReport(paramDataTag);
      return;
      label78:
      if (paramDataTag.serviceType == 4) {
        localIntent.putExtra("big_brother_source_key", "biz_src_feeds_buluo");
      }
    }
  }
  
  private boolean makeOrRefreshFavor(Card paramCard, boolean paramBoolean)
  {
    boolean bool1 = false;
    paramBoolean = false;
    boolean bool2 = ProfileActivity.AllInOne.i(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    if ((paramCard == null) || (bool2))
    {
      paramBoolean = bool1;
      if (this.mViewContainer != null) {
        this.mViewContainer = null;
      }
    }
    else
    {
      for (;;)
      {
        return true;
        LinearLayout localLinearLayout;
        if (this.mViewContainer == null)
        {
          localLinearLayout = (LinearLayout)LayoutInflater.from(this.mActivity).inflate(2131561466, null, false);
          localLinearLayout.setTag(2131367599, Boolean.TRUE);
          this.mViewContainer = localLinearLayout;
          paramBoolean = true;
        }
        while (fillUpFavorItem(localLinearLayout, paramCard) <= 0)
        {
          if (this.mViewContainer == null) {
            return paramBoolean;
          }
          this.mViewContainer = null;
          return true;
          localLinearLayout = (LinearLayout)this.mViewContainer;
        }
      }
    }
    return paramBoolean;
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
    DataTag localDataTag;
    if ((paramView.getTag() instanceof DataTag))
    {
      localDataTag = (DataTag)paramView.getTag();
      switch (localDataTag.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      handleHobbyClick(localDataTag);
      continue;
      handleHobbyItemClick(localDataTag);
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshFavor(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d) | bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.favor.ProfileFavorComponent
 * JD-Core Version:    0.7.0.1
 */