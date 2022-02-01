package com.tencent.mobileqq.flutter.channel.zanranking;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.flutter.channel.model.CardCoverData;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DrawerCoverUtil;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.Set;

class ZanRankingIpcServer$GetCoverTask
  implements Runnable
{
  Bundle jdField_a_of_type_AndroidOsBundle;
  volatile Card jdField_a_of_type_ComTencentMobileqqDataCard;
  volatile CardCoverData jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData;
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new ZanRankingIpcServer.GetCoverTask.2(this);
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new ZanRankingIpcServer.GetCoverTask.1(this);
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  volatile boolean jdField_a_of_type_Boolean = false;
  
  public ZanRankingIpcServer$GetCoverTask(ZanRankingIpcServer paramZanRankingIpcServer, Bundle paramBundle)
  {
    paramZanRankingIpcServer.a.add(this);
    paramZanRankingIpcServer = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramZanRankingIpcServer);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData = new CardCoverData(3, "");
    if (paramZanRankingIpcServer != null)
    {
      ((IVasQuickUpdateService)paramZanRankingIpcServer.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
      paramZanRankingIpcServer.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver, true);
    }
  }
  
  private void a(Card paramCard)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((this.jdField_a_of_type_Boolean) || (localQQAppInterface == null)) {
      return;
    }
    if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L)) {}
    for (paramCard = ProfileCardUtil.a(localQQAppInterface.getApp(), paramCard.strDrawerCardUrl);; paramCard = ProfileCardManager.b(localQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ZanRankingIpcServer", 2, "GetCoverTask updateCoverCard() type personal card, path" + paramCard);
      }
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData.type = Integer.valueOf(2);
      this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData.text = paramCard;
      a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData);
      return;
    }
  }
  
  private void a(Card paramCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ZanRankingIpcServer", 2, String.format("GetCoverTask onGetCard() uin=%s", new Object[] { paramCard.uin }));
    }
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((this.jdField_a_of_type_Boolean) || (localObject == null)) {
      return;
    }
    if (DrawerCoverUtil.a((QQAppInterface)localObject, paramCard))
    {
      if (!DrawerCoverUtil.b((QQAppInterface)localObject, paramCard))
      {
        if ((paramCard.lCurrentBgId == 1600L) || (paramCard.lCurrentBgId == 160L) || (ProfileCardTemplate.a(paramCard.lCurrentStyleId)))
        {
          DrawerCoverUtil.c((QQAppInterface)localObject, paramCard);
          a(paramCard);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
        ((VasExtensionManager)((QQAppInterface)localObject).getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a((QQAppInterface)localObject, "card." + paramCard.lCurrentBgId);
        return;
      }
      a(paramCard);
      return;
    }
    localObject = paramCard.getCoverData(0);
    paramCard = (String)localObject[0];
    localObject = (Integer)localObject[1];
    if (TextUtils.isEmpty(paramCard))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData.type = Integer.valueOf(1);
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData.text = paramCard;
    a(this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData);
  }
  
  private void a(CardCoverData paramCardCoverData)
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("callbackId");
    this.jdField_a_of_type_AndroidOsBundle.putInt("type", paramCardCoverData.type.intValue());
    this.jdField_a_of_type_AndroidOsBundle.putString("text", paramCardCoverData.text);
    paramCardCoverData = EIPCResult.createResult(0, this.jdField_a_of_type_AndroidOsBundle);
    if (i > 0) {
      this.this$0.callbackResult(i, paramCardCoverData);
    }
    b();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ZanRankingIpcServer", 2, "stop");
    }
    this.jdField_a_of_type_Boolean = true;
    b();
  }
  
  public void b()
  {
    this.this$0.a.remove(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface != null)
    {
      ((IVasQuickUpdateService)localQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    }
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((this.jdField_a_of_type_Boolean) || (localObject == null)) {}
    String str;
    do
    {
      return;
      boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("fromCache", true);
      str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (!bool) {
        break;
      }
      localObject = ((FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(str);
    } while (localObject == null);
    a((Card)localObject, true);
    return;
    LikeRankingListActivity.a((QQAppInterface)localObject, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcServer.GetCoverTask
 * JD-Core Version:    0.7.0.1
 */