package com.tencent.mobileqq.profilecard.bussiness.medalwall;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;

public class ProfileMediaWallComponent
  extends AbsQQProfileComponent<View>
{
  private static final int MSG_CHECK_MEDAL_GUIDE = 100;
  private static final String TAG = "ProfileMediaWallComponent";
  private View mMedalTargetView;
  private boolean mNeedCheckMedalGuide;
  private Handler.Callback mUICallback = new ProfileMediaWallComponent.1(this);
  private Handler mUIHandler;
  
  public ProfileMediaWallComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private void checkShowMedalGuide(Message paramMessage)
  {
    boolean bool1;
    try
    {
      if ((this.mMedalTargetView != null) && (this.mMedalTargetView.getWidth() > 0) && (this.mMedalTargetView.getHeight() > 0))
      {
        ((MedalWallMng)this.mApp.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(this.mActivity, this.mMedalTargetView, 2, ((ProfileCardInfo)this.mData).card);
        bool1 = false;
      }
      else
      {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1) {
        break label151;
      }
      bool2 = bool1;
      try
      {
        if (paramMessage.arg1 >= 2) {
          break label151;
        }
        Message localMessage = this.mUIHandler.obtainMessage();
        localMessage.what = paramMessage.what;
        paramMessage.arg1 += 1;
        this.mUIHandler.sendMessageDelayed(localMessage, 1000L);
        bool2 = bool1;
      }
      catch (Exception paramMessage) {}
      QLog.e("ProfileMediaWallComponent", 1, "checkMedalGuide fail.", paramMessage);
    }
    catch (Exception paramMessage)
    {
      bool1 = true;
    }
    boolean bool2 = bool1;
    label151:
    if (QLog.isColorLevel())
    {
      QLog.d("ProfileMediaWallComponent", 2, String.format("checkMedalGuide needResendMsg=%s", new Object[] { Boolean.valueOf(bool2) }));
      if (((ProfileCardInfo)this.mData).card != null)
      {
        paramMessage = ((ProfileCardInfo)this.mData).card;
        QLog.d("ProfileMediaWallComponent", 2, String.format("checkMedalGuide medalSwitchDisable=%s iMedalCount=%s iNewCount=%s iUpgradeCount=%s", new Object[] { Boolean.valueOf(paramMessage.medalSwitchDisable), Integer.valueOf(paramMessage.iMedalCount), Integer.valueOf(paramMessage.iNewCount), Integer.valueOf(paramMessage.iUpgradeCount) }));
      }
    }
  }
  
  private void initViews()
  {
    if (this.mViewContainer != null)
    {
      this.mActivity.getLayoutInflater().inflate(2131627673, (ViewGroup)this.mViewContainer);
      this.mMedalTargetView = ((View)this.mViewContainer).findViewById(2131438159);
    }
  }
  
  public String getComponentName()
  {
    return "ProfileMediaWallComponent";
  }
  
  public int getComponentType()
  {
    return 1025;
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    this.mUIHandler = new Handler(Looper.getMainLooper(), this.mUICallback);
    initViews();
    int i;
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      this.mNeedCheckMedalGuide = true;
    }
  }
  
  public void onDestroy()
  {
    MedalGuideView.a();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    this.mUIHandler.removeMessages(100);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mNeedCheckMedalGuide)
    {
      this.mNeedCheckMedalGuide = false;
      this.mUIHandler.removeMessages(100);
      this.mUIHandler.sendEmptyMessageDelayed(100, 2000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.medalwall.ProfileMediaWallComponent
 * JD-Core Version:    0.7.0.1
 */