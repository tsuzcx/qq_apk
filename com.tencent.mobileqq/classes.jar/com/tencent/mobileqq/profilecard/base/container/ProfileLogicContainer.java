package com.tencent.mobileqq.profilecard.base.container;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ProfileLogicContainer
  extends AbsQQProfileContainer
{
  private static final String TAG = "ProfileLogicContainer";
  private final CardObserver cardObserver = new ProfileLogicContainer.3(this);
  private final FriendListObserver friendListObserver = new ProfileLogicContainer.1(this);
  private final FriendObserver mFriendObserver = new ProfileLogicContainer.2(this);
  
  public ProfileLogicContainer(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void handleUpdateAddFriend(String paramString, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("result_uin");
    if ((ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo)this.mData).allInOne)) && (ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo)this.mData).allInOne).equals(paramString)))
    {
      if (this.mDelegate != null) {
        this.mDelegate.checkAndSwitch2Friend(true, false, paramBundle);
      }
    }
    else if ((paramBundle != null) && (((ProfileCardInfo)this.mData).allInOne != null) && (paramBundle.equalsIgnoreCase(((ProfileCardInfo)this.mData).allInOne.uin)) && (this.mDelegate != null)) {
      this.mDelegate.checkAndSwitch2Friend(false, false, null);
    }
  }
  
  private void handleUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileLogicContainer", 2, String.format("handleUpdateFriendList isSuccess=%s isComplete=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) }));
    }
    if ((paramBoolean1) && (paramBoolean2) && (((ProfileCardInfo)this.mData).allInOne.uin != null))
    {
      Object localObject2 = (IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all");
      paramBoolean1 = ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo)this.mData).allInOne);
      Object localObject1 = "";
      if (paramBoolean1)
      {
        if (localObject2 != null)
        {
          localObject2 = ((IFriendDataService)localObject2).getFriend(((ProfileCardInfo)this.mData).allInOne.uin);
          if (localObject2 != null)
          {
            if (((Friends)localObject2).remark != null) {
              localObject1 = ((Friends)localObject2).remark;
            }
            if (this.mDelegate != null) {
              this.mDelegate.setRemark((String)localObject1);
            }
          }
        }
      }
      else
      {
        paramBoolean1 = ProfilePAUtils.isPaTypeStrangerInContact(((ProfileCardInfo)this.mData).allInOne);
        localObject1 = null;
        if (paramBoolean1)
        {
          if (((ProfileCardInfo)this.mData).allInOne.pa == 53)
          {
            if (this.mDelegate != null) {
              this.mDelegate.requestUpdateCard();
            }
          }
          else
          {
            IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.mApp.getRuntimeService(IPhoneContactService.class, "");
            if (localIPhoneContactService != null) {
              localObject1 = localIPhoneContactService.queryContactByCodeNumber(ProfileUtils.getMobileNumberWithNationCode(((ProfileCardInfo)this.mData).allInOne));
            }
            if ((localObject2 != null) && (localObject1 != null) && (((IFriendDataService)localObject2).isFriend(((PhoneContact)localObject1).uin)) && (this.mDelegate != null)) {
              this.mDelegate.checkAndSwitch2Friend(true, false, ((PhoneContact)localObject1).uin);
            }
          }
        }
        else if ((localObject2 != null) && (((IFriendDataService)localObject2).isFriend(((ProfileCardInfo)this.mData).allInOne.uin)) && (!((ProfileCardInfo)this.mData).allInOne.uin.equals(this.mApp.getCurrentAccountUin()))) {
          ThreadManager.excute(new ProfileLogicContainer.4(this), 16, null, false);
        }
      }
    }
  }
  
  protected List<Integer> getChildComponentTypeList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1034));
    return localArrayList;
  }
  
  public String getComponentName()
  {
    return "ProfileLogicContainer";
  }
  
  public int getComponentType()
  {
    return 108;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.hasExtra("result")))
    {
      paramIntent = paramIntent.getStringExtra("result");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult, resultStr : ");
        localStringBuilder.append(paramIntent);
        QLog.d("ProfileLogicContainer", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramIntent)) {
        try
        {
          paramIntent = new JSONObject(paramIntent).get("payState");
          if ((paramIntent != null) && ("0".equals(String.valueOf(paramIntent))) && (this.mDelegate != null))
          {
            this.mDelegate.requestUpdateCard();
            return;
          }
        }
        catch (Exception paramIntent)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onActivityResult, Exception : ");
          localStringBuilder.append(paramIntent.getMessage());
          QLog.e("ProfileLogicContainer", 1, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mApp.addObserver(this.friendListObserver);
    this.mApp.addObserver(this.mFriendObserver);
    this.mApp.addObserver(this.cardObserver);
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.friendListObserver);
    this.mApp.removeObserver(this.mFriendObserver);
    this.mApp.removeObserver(this.cardObserver);
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_back_from_add_friend", false)))
    {
      this.mActivity.setResult(-1);
      this.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer
 * JD-Core Version:    0.7.0.1
 */