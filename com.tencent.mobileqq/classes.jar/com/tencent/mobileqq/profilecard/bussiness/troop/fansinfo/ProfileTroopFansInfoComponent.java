package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xef6.oidb_0xef6.IdolInfo;
import tencent.im.oidb.cmd0xef6.oidb_0xef6.RspBody;

public class ProfileTroopFansInfoComponent
  extends AbsProfileContentComponent
  implements IdolAdapter.IdolAdapterCallBack, AbsListView.OnScrollListener
{
  private static final String TAG = "ProfileTroopFansInfoComponent";
  protected boolean bEnterWeb = false;
  private boolean hasReportExposure = false;
  private Handler mHandler;
  private boolean mHasScrollToTroopFans;
  protected IdolAdapter mIdolAdapter;
  private boolean mScrollToTroopFans;
  protected BizTroopObserver mbizTroopObserver = new ProfileTroopFansInfoComponent.1(this);
  
  public ProfileTroopFansInfoComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private ArrayList<TroopFansInfo.IdolItem> convSvrRsp(oidb_0xef6.RspBody paramRspBody)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramRspBody == null) {
      return localArrayList;
    }
    if (paramRspBody.idol_list.has())
    {
      paramRspBody = paramRspBody.idol_list.get();
      int i = 0;
      while (i < paramRspBody.size())
      {
        oidb_0xef6.IdolInfo localIdolInfo = (oidb_0xef6.IdolInfo)paramRspBody.get(i);
        TroopFansInfo.IdolItem localIdolItem = new TroopFansInfo.IdolItem();
        if (localIdolInfo.idol_id.has()) {
          localIdolItem.idolid = localIdolInfo.idol_id.get();
        }
        if (localIdolInfo.avatar.has()) {
          localIdolItem.avatar = localIdolInfo.avatar.get();
        }
        if (localIdolInfo.pic.has()) {
          localIdolItem.pic = localIdolInfo.pic.get();
        }
        if (localIdolInfo.name.has()) {
          localIdolItem.name = localIdolInfo.name.get();
        }
        if (localIdolInfo.rank.has()) {
          localIdolItem.rank = localIdolInfo.rank.get();
        }
        if (localIdolInfo.score.has()) {
          localIdolItem.qScore = localIdolInfo.score.get();
        }
        localArrayList.add(localIdolItem);
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopFansInfoComponent", 2, "convSvrRsp idolItems:" + localArrayList.toString());
    }
    return localArrayList;
  }
  
  private void handleGetIdolInfoOfCard(boolean paramBoolean, long paramLong, Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopFansInfoComponent", 2, "handleGetIdolInfoOfCard isSuccess:" + paramBoolean + " memberUin:" + paramLong + " errCode:" + paramInt);
    }
    if ((this.mData == null) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (!String.valueOf(paramLong).equals(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof oidb_0xef6.RspBody)));
      paramObject = convSvrRsp((oidb_0xef6.RspBody)paramObject);
    } while (this.mData == null);
    ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessTroopFansinfoTroopFansInfo = new TroopFansInfo();
    ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqProfilecardBussinessTroopFansinfoTroopFansInfo.idolList = paramObject;
    notifyUpdateUI();
  }
  
  private boolean makeOrRefreshIdolList(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool2 = true;
    if ((!FansTroopUtils.a()) || (paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessTroopFansinfoTroopFansInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessTroopFansinfoTroopFansInfo.idolList.size() == 0))
    {
      if (this.mViewContainer == null) {
        break label354;
      }
      this.mViewContainer = null;
    }
    label354:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ProfileTroopFansInfoComponent", 2, "makeOrRefreshIdolList remove panel!");
      }
      bool2 = bool1;
      return bool2;
      Object localObject1;
      label108:
      Object localObject2;
      if (this.mViewContainer == null)
      {
        localObject1 = this.mDiyHelper.getDiyView(getProfileContentKey());
        if (localObject1 == null)
        {
          this.mViewContainer = this.mActivity.getLayoutInflater().inflate(2131559700, null);
          localObject1 = (RecyclerView)((View)this.mViewContainer).findViewById(2131368580);
          if (localObject1 != null)
          {
            localObject2 = new LinearLayoutManager(this.mActivity, 0, false);
            ((LinearLayoutManager)localObject2).setAutoMeasureEnabled(true);
            ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
            ((RecyclerView)localObject1).addItemDecoration(new ProfileTroopFansInfoComponent.SpacesItemDecoration(ViewUtils.b(8.0F)));
            if (this.mIdolAdapter == null) {
              this.mIdolAdapter = new IdolAdapter(this.mActivity, paramProfileCardInfo.jdField_a_of_type_JavaLangString, this);
            }
            ((RecyclerView)localObject1).setAdapter(this.mIdolAdapter);
            recyclerViewEventListener((RecyclerView)localObject1);
            reportExposure();
          }
          bool1 = bool2;
          if (QLog.isColorLevel()) {
            QLog.i("ProfileTroopFansInfoComponent", 2, "makeOrRefreshIdolList show panel!");
          }
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        if (this.mIdolAdapter != null) {
          this.mIdolAdapter.setList(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessTroopFansinfoTroopFansInfo.idolList);
        }
        bool2 = bool1;
        if (this.mViewContainer == null) {
          break;
        }
        localObject1 = ((View)this.mViewContainer).findViewById(2131365147);
        localObject2 = (TextView)((View)localObject1).findViewById(2131379248);
        ((View)localObject1).findViewById(2131368603);
        ((TextView)localObject2).setText(getTitleText(paramProfileCardInfo));
        ((View)localObject1).setContentDescription(getTitleText(paramProfileCardInfo));
        updateItemTheme(null, (TextView)localObject2, null, null);
        return bool1;
        this.mViewContainer = localObject1;
        break label108;
      }
    }
  }
  
  private void notifyUpdateUI()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopFansInfoComponent", 2, "notifyUpdateUI");
    }
    if (this.mDelegate != null) {
      this.mDelegate.notifyCardUpdate();
    }
  }
  
  private void recyclerViewEventListener(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null) {
      return;
    }
    paramRecyclerView.addOnItemTouchListener(new ProfileTroopFansInfoComponent.2(this));
  }
  
  private void reqFansInfo()
  {
    if (!FansTroopUtils.a()) {}
    while ((!NetworkUtil.g(this.mActivity)) || (this.mData == null) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {
      return;
    }
    try
    {
      ((BizTroopHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).b(Long.parseLong(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void scrollToTroopFans()
  {
    if (this.mHandler != null) {
      this.mHandler.postDelayed(new ProfileTroopFansInfoComponent.4(this), 1000L);
    }
  }
  
  public String getComponentName()
  {
    return "ProfileTroopFansInfoComponent";
  }
  
  public int getComponentType()
  {
    return 1027;
  }
  
  protected String getGenderName(ProfileCardInfo paramProfileCardInfo)
  {
    String str2 = this.mActivity.getString(2131699374);
    String str1 = str2;
    if (paramProfileCardInfo != null)
    {
      str1 = str2;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.shGender != 1) {
          break label50;
        }
        str1 = this.mActivity.getString(2131699373);
      }
    }
    return str1;
    label50:
    return this.mActivity.getString(2131699374);
  }
  
  public String getProfileContentKey()
  {
    return "map_key_fans_info";
  }
  
  protected String getTitleText(ProfileCardInfo paramProfileCardInfo)
  {
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.mApp.getCurrentUin()))) {
      return this.mActivity.getString(2131699377);
    }
    return String.format(this.mActivity.getString(2131699378), new Object[] { getGenderName(paramProfileCardInfo) });
  }
  
  public void gotoWeb()
  {
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.mApp.getCurrentUin()))) {
      this.bEnterWeb = true;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1012)) {
      reqFansInfo();
    }
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    this.mActivity.addObserver(this.mbizTroopObserver);
    if (this.mDelegate != null) {
      this.mDelegate.addProfileScrollListener(this);
    }
    paramBaseActivity = this.mActivity.getIntent();
    if (paramBaseActivity != null) {
      this.mScrollToTroopFans = paramBaseActivity.getBooleanExtra("profile_scroll_to_troop_fans", false);
    }
    this.mHandler = new Handler(Looper.getMainLooper());
    reqFansInfo();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshIdolList((ProfileCardInfo)this.mData) | bool;
  }
  
  public void onDestroy()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    if (this.mActivity != null) {
      this.mActivity.removeObserver(this.mbizTroopObserver);
    }
    if (this.mDelegate != null) {
      this.mDelegate.removeProfileScrollListener(this);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.bEnterWeb)
    {
      this.bEnterWeb = false;
      reqFansInfo();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      reportExposure();
    }
  }
  
  public void onUpdateItemTheme(TextView paramTextView)
  {
    updateItemTheme(paramTextView, null);
  }
  
  protected void reportExposure()
  {
    if ((!this.hasReportExposure) && (this.mViewContainer != null)) {
      ((View)this.mViewContainer).post(new ProfileTroopFansInfoComponent.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent
 * JD-Core Version:    0.7.0.1
 */