package com.tencent.mobileqq.profilecard.bussiness.contact;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUIUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;

public class ProfileContactComponent
  extends AbsProfileContentComponent
  implements View.OnClickListener
{
  private static final int MAX_MENU_ITEM_COUNT = 5;
  private static final String TAG = "ProfileContactComponent";
  private String[] mMenuItems;
  private int[] mMenuShowItemIndex;
  private ProfileContactInfo mSelectContactInfo;
  
  public ProfileContactComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private ViewGroup addAccountBaseInfoItem(ViewGroup paramViewGroup, int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    View localView = null;
    Object localObject = localView;
    if (paramViewGroup != null)
    {
      localObject = localView;
      if (paramInt > 0)
      {
        localObject = localView;
        if (!TextUtils.isEmpty(paramCharSequence))
        {
          localObject = (ViewGroup)this.mActivity.getLayoutInflater().inflate(2131561339, null);
          localView = ((ViewGroup)localObject).findViewById(2131368343);
          TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(2131368773);
          localView.setBackgroundResource(paramInt);
          if ((paramCharSequence instanceof String)) {
            localTextView.setText(((String)paramCharSequence).trim());
          } else {
            localTextView.setText(paramCharSequence);
          }
          paramViewGroup.addView((View)localObject);
          if (paramBoolean) {
            LongClickCopyAction.attachCopyAction(localTextView);
          }
          updateItemTheme((View)localObject, localTextView, null, null);
        }
      }
    }
    return localObject;
  }
  
  private ViewGroup addPhoneInfoViewPhoneItem(ViewGroup paramViewGroup, ProfileContactInfo paramProfileContactInfo)
  {
    if (paramViewGroup != null)
    {
      if (paramProfileContactInfo == null) {
        return null;
      }
      String str = paramProfileContactInfo.phoneNumber;
      ViewGroup localViewGroup = (ViewGroup)this.mActivity.getLayoutInflater().inflate(2131561343, null);
      View localView = localViewGroup.findViewById(2131369083);
      TextView localTextView = (TextView)localViewGroup.findViewById(2131368773);
      ImageView localImageView = (ImageView)localViewGroup.findViewById(2131362975);
      localView.setVisibility(0);
      localView.setBackgroundResource(2130845979);
      localTextView.setText(str);
      paramViewGroup.addView(localViewGroup);
      str = this.mActivity.getString(2131691294);
      if (((ProfileCardInfo)this.mData).allInOne.pa == 33)
      {
        paramViewGroup = paramProfileContactInfo.phoneNumber;
      }
      else
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(paramProfileContactInfo.phoneName);
        paramViewGroup.append(" ");
        paramViewGroup.append(paramProfileContactInfo.phoneNumber);
        paramViewGroup = paramViewGroup.toString();
      }
      LongClickCopyAction.attachCopyAction(localTextView, str, paramViewGroup);
      updateItemTheme(localViewGroup, localTextView, null, localImageView);
      return localViewGroup;
    }
    return null;
  }
  
  private void callContact(ProfileContactInfo paramProfileContactInfo)
  {
    if (paramProfileContactInfo != null) {
      paramProfileContactInfo = paramProfileContactInfo.phoneNumber;
    } else {
      paramProfileContactInfo = null;
    }
    if ((paramProfileContactInfo != null) && (paramProfileContactInfo.length() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tel:");
      localStringBuilder.append(paramProfileContactInfo);
      paramProfileContactInfo = new Intent("android.intent.action.DIAL", Uri.parse(localStringBuilder.toString()));
      try
      {
        this.mActivity.startActivity(paramProfileContactInfo);
        return;
      }
      catch (Exception paramProfileContactInfo)
      {
        QLog.e("ProfileContactComponent", 1, "callContact fail.", paramProfileContactInfo);
        return;
      }
    }
    ProfileUIUtils.notifyUser(1, 2131693335);
  }
  
  private void handlePhoneClick()
  {
    if (this.mMenuShowItemIndex == null) {
      this.mMenuShowItemIndex = new int[5];
    }
    int[] arrayOfInt = this.mMenuShowItemIndex;
    arrayOfInt[0] = 7;
    arrayOfInt[1] = 8;
    if (ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo)this.mData).allInOne))
    {
      arrayOfInt = this.mMenuShowItemIndex;
      arrayOfInt[2] = 9;
      arrayOfInt[3] = 16;
    }
    else
    {
      arrayOfInt = this.mMenuShowItemIndex;
      arrayOfInt[2] = 16;
      arrayOfInt[3] = -1;
    }
    int i = 4;
    while (i < 5)
    {
      this.mMenuShowItemIndex[i] = -1;
      i += 1;
    }
    showActionSheet(this.mMenuShowItemIndex);
  }
  
  private boolean makeOrRefreshPhoneInfoView(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = ((ProfileCardInfo)this.mData).contactCard;
    ArrayList localArrayList = ((ProfileCardInfo)this.mData).allInOne.contactArray;
    boolean bool2 = ProfilePAUtils.isPaTypeStrangerInContact(paramProfileCardInfo.allInOne);
    boolean bool1 = false;
    int j = 0;
    int i;
    if ((!bool2) && (paramProfileCardInfo.allInOne.pa != 80)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((localObject == null) || (localArrayList == null) || (localArrayList.isEmpty())) {
      i = 0;
    }
    if (i == 0)
    {
      if (this.mViewContainer != null)
      {
        this.mViewContainer = null;
        return true;
      }
    }
    else
    {
      ViewGroup localViewGroup = (ViewGroup)this.mViewContainer;
      if (localViewGroup == null)
      {
        localViewGroup = (ViewGroup)this.mActivity.getLayoutInflater().inflate(2131561353, null);
        this.mViewContainer = localViewGroup;
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      if (paramProfileCardInfo.profileName.a != null) {
        paramProfileCardInfo.profileName.a.clear();
      }
      localViewGroup.removeAllViews();
      addAccountBaseInfoItem(localViewGroup, 2130845955, ((ContactCard)localObject).nickName, true);
      paramProfileCardInfo = (IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class);
      QBaseActivity localQBaseActivity = this.mActivity;
      int k = ((ContactCard)localObject).bSex;
      if (((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).isEuropeAndAmerica()) {
        i = 0;
      } else {
        i = ((ContactCard)localObject).bAge;
      }
      addAccountBaseInfoItem(localViewGroup, 2130845966, paramProfileCardInfo.makeSexAgeArea(localQBaseActivity, k, i, ((ContactCard)localObject).strCountry, ((ContactCard)localObject).strProvince, ((ContactCard)localObject).strCity), true);
      k = localArrayList.size();
      i = j;
      while (i < k)
      {
        paramProfileCardInfo = (ProfileContactInfo)localArrayList.get(i);
        localObject = addPhoneInfoViewPhoneItem(localViewGroup, paramProfileCardInfo);
        if (localObject != null)
        {
          ((ViewGroup)localObject).setTag(new DataTag(4, paramProfileCardInfo));
          ((ViewGroup)localObject).setOnClickListener(this);
        }
        i += 1;
      }
    }
    return bool1;
  }
  
  private void sendMsg(ProfileContactInfo paramProfileContactInfo)
  {
    if (paramProfileContactInfo != null) {
      paramProfileContactInfo = paramProfileContactInfo.phoneNumber;
    } else {
      paramProfileContactInfo = null;
    }
    if ((paramProfileContactInfo != null) && (paramProfileContactInfo.length() > 0))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.SENDTO");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smsto:");
      localStringBuilder.append(paramProfileContactInfo);
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      try
      {
        this.mActivity.startActivity(localIntent);
        return;
      }
      catch (Exception paramProfileContactInfo)
      {
        QLog.e("ProfileContactComponent", 1, "callContact fail.", paramProfileContactInfo);
        return;
      }
    }
    ProfileUIUtils.notifyUser(1, 2131693335);
  }
  
  private void setRemarks(ProfileContactInfo paramProfileContactInfo)
  {
    if (paramProfileContactInfo == null) {
      paramProfileContactInfo = null;
    } else {
      paramProfileContactInfo = paramProfileContactInfo.phoneName;
    }
    if ((paramProfileContactInfo != null) && (paramProfileContactInfo.length() > 0)) {
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        if ((!"".equals(paramProfileContactInfo)) && (!paramProfileContactInfo.equals(((ProfileCardInfo)this.mData).allInOne.remark)))
        {
          IProfileCardBusinessApi localIProfileCardBusinessApi = (IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class);
          if (localIProfileCardBusinessApi != null)
          {
            localIProfileCardBusinessApi.setFriendComment(this.mApp, ((ProfileCardInfo)this.mData).allInOne.uin, paramProfileContactInfo, false);
            if (this.mDelegate != null) {
              this.mDelegate.setRemark(paramProfileContactInfo);
            }
          }
          else
          {
            ProfileUIUtils.notifyUser(1, 2131693362);
          }
        }
        else
        {
          ProfileUIUtils.notifyUser(1, 2131693348);
        }
      }
      else {
        ProfileUIUtils.notifyUser(1, 2131694473);
      }
    }
  }
  
  private void showActionSheet(int[] paramArrayOfInt)
  {
    if (this.mMenuItems == null) {
      this.mMenuItems = this.mActivity.getResources().getStringArray(2130968636);
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.mActivity, null);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (k == 16)
      {
        localActionSheet.addCancelButton(this.mMenuItems[k]);
      }
      else if (k >= 0)
      {
        String[] arrayOfString = this.mMenuItems;
        if (k < arrayOfString.length) {
          localActionSheet.addButton(arrayOfString[k], 1);
        }
      }
      i += 1;
    }
    localActionSheet.setOnButtonClickListener(new ProfileContactComponent.1(this));
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      QLog.e("ProfileContactComponent", 1, "showActionSheet fail.", paramArrayOfInt);
    }
  }
  
  public String getComponentName()
  {
    return "ProfileContactComponent";
  }
  
  public int getComponentType()
  {
    return 1030;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_phone";
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof DataTag))
    {
      localObject = (DataTag)localObject;
      if (((DataTag)localObject).jdField_a_of_type_Int == 4)
      {
        this.mSelectContactInfo = ((ProfileContactInfo)((DataTag)localObject).jdField_a_of_type_JavaLangObject);
        handlePhoneClick();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshPhoneInfoView(paramProfileCardInfo) | bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.contact.ProfileContactComponent
 * JD-Core Version:    0.7.0.1
 */