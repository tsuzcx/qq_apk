package com.tencent.mobileqq.hotchat.app;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.hotchat.api.IHotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatShare;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class HotChatShare
  implements IHotChatShare
{
  private static final int STATE_BOTH_READY = 3;
  private static final int STATE_HEAD_READY = 2;
  private static final int STATE_INIT = 0;
  private static final int STATE_NICK_READY = 1;
  public static final String TAG = "HotChatShare";
  QQAppInterface app;
  int currentState = 0;
  private AvatarObserver mAvatarObserver = new HotChatShare.1(this);
  BaseActivity mBaseActivity;
  private FriendListObserver mFriendListObserver = new HotChatShare.2(this);
  IHotChatInfo mInfo;
  QQProgressDialog mLoading;
  String ownerHeadUrl = null;
  String ownerNickname = null;
  
  public HotChatShare(BaseActivity paramBaseActivity, AppInterface paramAppInterface, IHotChatInfo paramIHotChatInfo)
  {
    this.mBaseActivity = paramBaseActivity;
    this.app = ((QQAppInterface)paramAppInterface);
    this.mInfo = paramIHotChatInfo;
    this.app.addObserver(this.mFriendListObserver);
    this.app.addObserver(this.mAvatarObserver);
    ThreadManager.post(new HotChatShare.3(this), 8, null, true);
  }
  
  private void switchToShare()
  {
    if (this.mInfo.getJoinUrl() != null)
    {
      int i = this.mInfo.getJoinUrl().indexOf("hotnamecode=");
      if (i != -1)
      {
        str1 = this.mInfo.getJoinUrl().substring(i + 12);
        break label54;
      }
    }
    String str1 = null;
    label54:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleHotChatShare.mTroop.joinUrl=");
      ((StringBuilder)localObject1).append(this.mInfo.getJoinUrl());
      ((StringBuilder)localObject1).append(",hotnamecode=");
      ((StringBuilder)localObject1).append(str1);
      QLog.i("HotChatShare", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    String str2 = HotChatHelper.a(str1, this.mInfo.getUserCreate());
    if (this.mInfo.getUserCreate() != 1)
    {
      localObject1 = this.app;
      localObject2 = this.mBaseActivity;
      localObject3 = this.mInfo.getName();
      localObject4 = this.mInfo.getTroopUin();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131705686));
      ((StringBuilder)localObject5).append(this.mInfo.getName());
      ((StringBuilder)localObject5).append(HardCodeUtil.a(2131705681));
      HotChatHelper.a(2, (QQAppInterface)localObject1, (BaseActivity)localObject2, (String)localObject3, (String)localObject4, str2, str1, ((StringBuilder)localObject5).toString(), HardCodeUtil.a(2131705683), null, null);
      return;
    }
    Object localObject1 = HardCodeUtil.a(2131705680);
    if (!TextUtils.isEmpty(this.ownerNickname))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131705684));
      ((StringBuilder)localObject1).append(this.ownerNickname);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131705685));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = this.app.getCustomFaceFilePath(32, this.mInfo.getOwnerUin(), 200);
    Object localObject3 = this.app;
    Object localObject4 = this.mBaseActivity;
    Object localObject5 = this.mInfo.getName();
    String str3 = this.mInfo.getTroopUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131705679));
    localStringBuilder.append(this.mInfo.getName());
    localStringBuilder.append(HardCodeUtil.a(2131705682));
    HotChatHelper.a(2, (QQAppInterface)localObject3, (BaseActivity)localObject4, (String)localObject5, str3, str2, str1, localStringBuilder.toString(), (String)localObject1, this.ownerHeadUrl, (String)localObject2);
  }
  
  public void handleShare(IHotChatInfo paramIHotChatInfo)
  {
    this.mInfo = paramIHotChatInfo;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleShare.info=");
      localStringBuilder.append(paramIHotChatInfo);
      QLog.i("HotChatShare", 2, localStringBuilder.toString());
    }
    if (this.mInfo.getUserCreate() != 1)
    {
      switchToShare();
      return;
    }
    this.currentState = 0;
    this.ownerNickname = ContactUtils.g(this.app, this.mInfo.getOwnerUin());
    if (!TextUtils.isEmpty(this.ownerNickname)) {
      this.currentState = 1;
    }
    if (QLog.isColorLevel())
    {
      paramIHotChatInfo = new StringBuilder();
      paramIHotChatInfo.append("handleShare.ownerNickname=");
      paramIHotChatInfo.append(this.ownerNickname);
      QLog.i("HotChatShare", 2, paramIHotChatInfo.toString());
    }
    if (!TextUtils.isEmpty(this.ownerHeadUrl))
    {
      int i = this.currentState;
      if (i == 0) {
        this.currentState = 2;
      } else if (i == 1) {
        this.currentState = 3;
      }
    }
    if (QLog.isColorLevel())
    {
      paramIHotChatInfo = new StringBuilder();
      paramIHotChatInfo.append("handleShare.ownerHeadUrl=");
      paramIHotChatInfo.append(this.ownerHeadUrl);
      QLog.i("HotChatShare", 2, paramIHotChatInfo.toString());
    }
    if (this.currentState == 3)
    {
      switchToShare();
      return;
    }
    showProgress();
    ThreadManager.post(new HotChatShare.4(this), 8, null, false);
    new Handler().postDelayed(new HotChatShare.5(this), 30000L);
  }
  
  public void hideProgress()
  {
    try
    {
      if ((this.mLoading != null) && (this.mLoading.isShowing()))
      {
        this.mLoading.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatShare", 2, localException.toString());
      }
    }
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = this.app;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.mFriendListObserver);
      this.app.removeObserver(this.mAvatarObserver);
    }
  }
  
  public void showProgress()
  {
    try
    {
      if (this.mLoading == null)
      {
        this.mLoading = new QQProgressDialog(this.mBaseActivity, this.mBaseActivity.getTitleBarHeight());
        this.mLoading.c(2131694668);
      }
      this.mLoading.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotChatShare", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatShare
 * JD-Core Version:    0.7.0.1
 */