package com.tencent.mobileqq.flutter.channel.zanranking;

import android.os.Bundle;
import android.text.TextUtils;
import anvk;
import aunu;
import aunv;
import azrc;
import azri;
import bhaa;
import bhou;
import bkxw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.flutter.channel.model.CardCoverData;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.Set;

public class ZanRankingIpcServer$GetCoverTask
  implements Runnable
{
  public Bundle a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new aunv(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public volatile Card a;
  volatile CardCoverData jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new aunu(this);
  
  public ZanRankingIpcServer$GetCoverTask(ZanRankingIpcServer paramZanRankingIpcServer, Bundle paramBundle)
  {
    paramZanRankingIpcServer.a.add(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqFlutterChannelModelCardCoverData = new CardCoverData(3, "");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
    }
  }
  
  private void a(Card paramCard)
  {
    if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L)) {}
    for (paramCard = bhaa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramCard.strDrawerCardUrl);; paramCard = azrc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId))
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
    if (bkxw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCard))
    {
      if (!bkxw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCard))
      {
        if ((paramCard.lCurrentBgId == 1600L) || (paramCard.lCurrentBgId == 160L) || (azri.a(paramCard.lCurrentStyleId)))
        {
          bkxw.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramCard);
          a(paramCard);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
        ((bhou)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "card." + paramCard.lCurrentBgId);
        return;
      }
      a(paramCard);
      return;
    }
    Object localObject = paramCard.getCoverData(0);
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
    a();
  }
  
  public void a()
  {
    this.this$0.a.remove(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ((VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    }
  }
  
  public void run()
  {
    boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("fromCache", true);
    Object localObject = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    if (bool)
    {
      localObject = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject);
      if (localObject != null) {
        a((Card)localObject, true);
      }
      return;
    }
    LikeRankingListActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcServer.GetCoverTask
 * JD-Core Version:    0.7.0.1
 */