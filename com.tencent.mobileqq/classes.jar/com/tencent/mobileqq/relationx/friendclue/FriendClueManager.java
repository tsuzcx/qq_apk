package com.tencent.mobileqq.relationx.friendclue;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class FriendClueManager
  implements Handler.Callback, Manager
{
  ProfileCardObserver a = new FriendClueManager.2(this);
  private FriendClueCommonGroupHelper b;
  private BusinessCard c;
  private CardHandler d;
  private Context e;
  private Handler f;
  private QQAppInterface g;
  private AllInOne h;
  private boolean i = false;
  
  public FriendClueManager(QQAppInterface paramQQAppInterface)
  {
    this.g = paramQQAppInterface;
    this.e = BaseApplicationImpl.getContext();
    this.f = new Handler(Looper.getMainLooper(), this);
  }
  
  private void c(String paramString)
  {
    if (NetworkUtil.isNetworkAvailable(this.e))
    {
      if (this.d == null) {
        this.d = ((CardHandler)this.g.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
      }
      BusinessCardManager localBusinessCardManager = (BusinessCardManager)this.g.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
      if (localBusinessCardManager != null) {
        this.i = localBusinessCardManager.b(1);
      }
      this.h = new AllInOne(paramString, 1);
      long l = ProfileUtils.getControl(this.h, this.i);
      this.d.a(this.g.getCurrentAccountUin(), paramString, 1, 0L, (byte)1, 0L, 0L, null, "", l, 10004, null, (byte)0);
      paramString = this.f.obtainMessage();
      paramString.what = 1;
      this.f.sendMessageDelayed(paramString, 10000L);
      return;
    }
    this.f.post(new FriendClueManager.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueManager", 2, String.format("network is not available, uin: %s", new Object[] { paramString }));
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendClueManager", 2, String.format("jumpToRemarkEdit, uin: %s", new Object[] { paramString }));
    }
    if (this.c == null) {
      this.c = new BusinessCard();
    }
    this.g.addObserver(this.a);
    c(paramString);
  }
  
  public void b(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.b == null) {
      this.b = new FriendClueCommonGroupHelper(this.g, localBaseApplication);
    }
    this.b.a(paramString);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if (j != 1)
    {
      if (j != 2) {
        return true;
      }
      Card localCard = null;
      if ((paramMessage.obj instanceof Card)) {
        localCard = (Card)paramMessage.obj;
      }
      if (localCard != null)
      {
        this.c = BusinessCardUtils.a(localCard.bCardInfo);
        this.c.bindUin = this.h.uin;
        paramMessage = new Intent(this.e, BusinessCardEditActivity.class);
        paramMessage.addFlags(268435456);
        paramMessage.putExtra("mode_type", 2);
        paramMessage.putExtra("source_activity", 1);
        paramMessage.putExtra("cur_card_body", this.c);
        paramMessage.putExtra("is_edit_mode", true);
        paramMessage.putExtra("finish_immedia", true);
        this.e.startActivity(paramMessage);
        return true;
      }
      QLog.e("FriendClueManager", 1, "card get failed ");
      return true;
    }
    this.g.removeObserver(this.a);
    QQToast.makeText(this.e, 1, 2131890981, 1).show();
    return true;
  }
  
  public void onDestroy()
  {
    this.g.removeObserver(this.a);
    FriendClueCommonGroupHelper localFriendClueCommonGroupHelper = this.b;
    if (localFriendClueCommonGroupHelper != null) {
      localFriendClueCommonGroupHelper.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.friendclue.FriendClueManager
 * JD-Core Version:    0.7.0.1
 */