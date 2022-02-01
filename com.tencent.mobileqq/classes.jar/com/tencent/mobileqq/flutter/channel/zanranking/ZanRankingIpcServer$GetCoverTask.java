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
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
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
  WeakReference<QQAppInterface> a;
  Bundle b;
  volatile Card c;
  volatile CardCoverData d;
  volatile boolean e = false;
  CallBacker f = new ZanRankingIpcServer.GetCoverTask.1(this);
  ProfileCardObserver g = new ZanRankingIpcServer.GetCoverTask.2(this);
  
  public ZanRankingIpcServer$GetCoverTask(ZanRankingIpcServer paramZanRankingIpcServer, Bundle paramBundle)
  {
    paramZanRankingIpcServer.b.add(this);
    paramZanRankingIpcServer = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.a = new WeakReference(paramZanRankingIpcServer);
    this.b = paramBundle;
    this.d = new CardCoverData(3, "");
    if (paramZanRankingIpcServer != null)
    {
      ((IVasQuickUpdateService)paramZanRankingIpcServer.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.f);
      paramZanRankingIpcServer.addObserver(this.g, true);
    }
  }
  
  private void a(Card paramCard)
  {
    Object localObject = (QQAppInterface)this.a.get();
    if (!this.e)
    {
      if (localObject == null) {
        return;
      }
      if ((paramCard.lCurrentBgId != 160L) && (paramCard.lCurrentBgId != 1600L)) {
        paramCard = ProfileCardManager.b(((QQAppInterface)localObject).getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId);
      } else {
        paramCard = ProfileCardUtil.c(paramCard.strDrawerCardUrl);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetCoverTask updateCoverCard() type personal card, path");
        ((StringBuilder)localObject).append(paramCard);
        QLog.d("ZanRankingIpcServer", 2, ((StringBuilder)localObject).toString());
      }
      this.d.type = Integer.valueOf(2);
      this.d.text = paramCard;
      a(this.d);
    }
  }
  
  private void a(Card paramCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ZanRankingIpcServer", 2, String.format("GetCoverTask onGetCard() uin=%s", new Object[] { paramCard.uin }));
    }
    Object localObject = (QQAppInterface)this.a.get();
    if (!this.e)
    {
      if (localObject == null) {
        return;
      }
      if (DrawerCoverUtil.a((QQAppInterface)localObject, paramCard))
      {
        if (!DrawerCoverUtil.b((QQAppInterface)localObject, paramCard))
        {
          if ((paramCard.lCurrentBgId != 1600L) && (paramCard.lCurrentBgId != 160L) && (!ProfileTemplateApi.isDiyTemplateStyleID(paramCard.lCurrentStyleId)))
          {
            this.c = paramCard;
            ProfileCardManager localProfileCardManager = ((VasExtensionManager)((QQAppInterface)localObject).getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("card.");
            localStringBuilder.append(paramCard.lCurrentBgId);
            localProfileCardManager.a((QQAppInterface)localObject, localStringBuilder.toString());
            return;
          }
          DrawerCoverUtil.c((QQAppInterface)localObject, paramCard);
          a(paramCard);
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
        a(this.d);
        return;
      }
      this.d.type = Integer.valueOf(1);
      this.d.text = paramCard;
      a(this.d);
    }
  }
  
  private void a(CardCoverData paramCardCoverData)
  {
    int i = this.b.getInt("callbackId");
    this.b.putInt("type", paramCardCoverData.type.intValue());
    this.b.putString("text", paramCardCoverData.text);
    paramCardCoverData = EIPCResult.createResult(0, this.b);
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
    this.e = true;
    b();
  }
  
  public void b()
  {
    this.this$0.b.remove(this);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface != null)
    {
      ((IVasQuickUpdateService)localQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.f);
      localQQAppInterface.removeObserver(this.g);
    }
  }
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.a.get();
    if (!this.e)
    {
      if (localObject == null) {
        return;
      }
      boolean bool = this.b.getBoolean("fromCache", true);
      String str = this.b.getString("uin");
      if (bool)
      {
        localObject = ((FriendsManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER)).f(str);
        if (localObject != null) {
          a((Card)localObject, true);
        }
      }
      else
      {
        LikeRankingListActivity.a((QQAppInterface)localObject, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.zanranking.ZanRankingIpcServer.GetCoverTask
 * JD-Core Version:    0.7.0.1
 */