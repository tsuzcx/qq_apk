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
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.troop.fans.api.ITroopFansHandler;
import com.tencent.mobileqq.troop.fans.api.TroopFansObserver;
import com.tencent.mobileqq.troop.fans.data.TroopFansInfo;
import com.tencent.mobileqq.troop.fans.data.TroopFansInfo.IdolItem;
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
  extends AbsQQProfileContentComponent
  implements IdolAdapter.IdolAdapterCallBack, AbsListView.OnScrollListener
{
  private static final String TAG = "ProfileTroopFansInfoComponent";
  protected boolean bEnterWeb = false;
  private boolean hasReportExposure = false;
  private Handler mHandler;
  private boolean mHasScrollToTroopFans;
  protected IdolAdapter mIdolAdapter;
  private boolean mScrollToTroopFans;
  private TroopFansInfo mTroopFansInfo;
  protected TroopFansObserver mTroopFansObserver = new ProfileTroopFansInfoComponent.1(this);
  
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
          localIdolItem.jdField_a_of_type_Int = localIdolInfo.idol_id.get();
        }
        if (localIdolInfo.avatar.has()) {
          localIdolItem.jdField_b_of_type_JavaLangString = localIdolInfo.avatar.get();
        }
        if (localIdolInfo.pic.has()) {
          localIdolItem.c = localIdolInfo.pic.get();
        }
        if (localIdolInfo.name.has()) {
          localIdolItem.jdField_a_of_type_JavaLangString = localIdolInfo.name.get();
        }
        if (localIdolInfo.rank.has()) {
          localIdolItem.jdField_a_of_type_Long = localIdolInfo.rank.get();
        }
        if (localIdolInfo.score.has()) {
          localIdolItem.jdField_b_of_type_Long = localIdolInfo.score.get();
        }
        localArrayList.add(localIdolItem);
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("convSvrRsp idolItems:");
      paramRspBody.append(localArrayList.toString());
      QLog.i("ProfileTroopFansInfoComponent", 2, paramRspBody.toString());
    }
    return localArrayList;
  }
  
  private void handleGetIdolInfoOfCard(boolean paramBoolean, long paramLong, Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetIdolInfoOfCard isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" memberUin:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" errCode:");
      localStringBuilder.append(paramInt);
      QLog.i("ProfileTroopFansInfoComponent", 2, localStringBuilder.toString());
    }
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).allInOne != null) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).allInOne.uin)))
    {
      if (!String.valueOf(paramLong).equals(((ProfileCardInfo)this.mData).allInOne.uin)) {
        return;
      }
      if ((paramBoolean) && (paramObject != null))
      {
        if (!(paramObject instanceof oidb_0xef6.RspBody)) {
          return;
        }
        paramObject = convSvrRsp((oidb_0xef6.RspBody)paramObject);
        this.mTroopFansInfo = new TroopFansInfo();
        this.mTroopFansInfo.a = paramObject;
        notifyUpdateUI();
      }
    }
  }
  
  private boolean makeOrRefreshIdolList(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool3 = FansTroopUtils.a();
    boolean bool1 = true;
    boolean bool2 = true;
    if ((bool3) && (paramProfileCardInfo != null))
    {
      Object localObject1 = this.mTroopFansInfo;
      if ((localObject1 != null) && (((TroopFansInfo)localObject1).a.size() != 0))
      {
        Object localObject2;
        if (this.mViewContainer == null)
        {
          this.mViewContainer = this.mActivity.getLayoutInflater().inflate(2131559576, null);
          localObject1 = (RecyclerView)((View)this.mViewContainer).findViewById(2131368321);
          if (localObject1 != null)
          {
            localObject2 = new LinearLayoutManager(this.mActivity, 0, false);
            ((LinearLayoutManager)localObject2).setAutoMeasureEnabled(true);
            ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)localObject2);
            ((RecyclerView)localObject1).addItemDecoration(new ProfileTroopFansInfoComponent.SpacesItemDecoration(ViewUtils.b(8.0F)));
            if (this.mIdolAdapter == null) {
              this.mIdolAdapter = new IdolAdapter(this.mActivity, paramProfileCardInfo.troopUin, this);
            }
            ((RecyclerView)localObject1).setAdapter(this.mIdolAdapter);
            recyclerViewEventListener((RecyclerView)localObject1);
            reportExposure();
          }
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.i("ProfileTroopFansInfoComponent", 2, "makeOrRefreshIdolList show panel!");
            bool1 = bool2;
          }
        }
        else
        {
          bool1 = false;
        }
        localObject1 = this.mIdolAdapter;
        if (localObject1 != null) {
          ((IdolAdapter)localObject1).setList(this.mTroopFansInfo.a);
        }
        if (this.mViewContainer != null)
        {
          localObject1 = ((View)this.mViewContainer).findViewById(2131365027);
          localObject2 = (TextView)((View)localObject1).findViewById(2131378609);
          ((View)localObject1).findViewById(2131368343);
          ((TextView)localObject2).setText(getTitleText(paramProfileCardInfo));
          ((View)localObject1).setContentDescription(getTitleText(paramProfileCardInfo));
          updateItemTheme(null, (TextView)localObject2, null, null);
        }
        return bool1;
      }
    }
    if (this.mViewContainer != null) {
      this.mViewContainer = null;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ProfileTroopFansInfoComponent", 2, "makeOrRefreshIdolList remove panel!");
    }
    return bool1;
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
    if (!FansTroopUtils.a()) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.mActivity)) {
      return;
    }
    if (this.mData != null) {
      if (((ProfileCardInfo)this.mData).allInOne == null) {
        return;
      }
    }
    try
    {
      ((ITroopFansHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.TROOP_FANS_HANDLER)).a(Long.parseLong(((ProfileCardInfo)this.mData).allInOne.uin));
      return;
    }
    catch (Exception localException) {}
  }
  
  private void scrollToTroopFans()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.postDelayed(new ProfileTroopFansInfoComponent.4(this), 1000L);
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
    String str = this.mActivity.getString(2131699479);
    Object localObject = str;
    if (paramProfileCardInfo != null)
    {
      localObject = str;
      if (paramProfileCardInfo.card != null)
      {
        if (paramProfileCardInfo.card.shGender == 1) {
          paramProfileCardInfo = this.mActivity.getString(2131699478);
        } else {
          paramProfileCardInfo = this.mActivity.getString(2131699479);
        }
        localObject = paramProfileCardInfo;
      }
    }
    return localObject;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_fans_info";
  }
  
  protected String getTitleText(ProfileCardInfo paramProfileCardInfo)
  {
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).allInOne != null) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).allInOne.uin)) && (((ProfileCardInfo)this.mData).allInOne.uin.equals(this.mApp.getCurrentUin()))) {
      return this.mActivity.getString(2131699482);
    }
    return String.format(this.mActivity.getString(2131699483), new Object[] { getGenderName(paramProfileCardInfo) });
  }
  
  public void gotoWeb()
  {
    if ((this.mData != null) && (((ProfileCardInfo)this.mData).allInOne != null) && (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).allInOne.uin)) && (((ProfileCardInfo)this.mData).allInOne.uin.equals(this.mApp.getCurrentUin()))) {
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
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mActivity.addObserver(this.mTroopFansObserver);
    if (this.mDelegate != null) {
      this.mDelegate.addProfileScrollListener(this);
    }
    paramQBaseActivity = this.mActivity.getIntent();
    if (paramQBaseActivity != null) {
      this.mScrollToTroopFans = paramQBaseActivity.getBooleanExtra("profile_scroll_to_troop_fans", false);
    }
    this.mHandler = new Handler(Looper.getMainLooper());
    reqFansInfo();
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshIdolList((ProfileCardInfo)this.mData);
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
    if (this.mActivity != null) {
      this.mActivity.removeObserver(this.mTroopFansObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.ProfileTroopFansInfoComponent
 * JD-Core Version:    0.7.0.1
 */