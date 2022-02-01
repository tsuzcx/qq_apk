package com.tencent.mobileqq.troop.shortcutbar.essencemsg;

import android.content.res.Resources;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarProcessor;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarObserver;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class EssenceMsgProcessor
  extends IShortcutBarProcessor
{
  private final long jdField_a_of_type_Long = 86400L;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver;
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  private TroopShortcutBarObserver jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver;
  private long b;
  
  public EssenceMsgProcessor(BaseChatPie paramBaseChatPie, IShortcutBarDataProvider paramIShortcutBarDataProvider)
  {
    if (paramBaseChatPie == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = paramIShortcutBarDataProvider;
    try
    {
      this.b = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).longValue();
      this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new EssenceMsgProcessor.1(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver = new EssenceMsgProcessor.2(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception paramBaseChatPie)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EssenceMsgProcessor", 0, "mTroopUin init error: ", paramBaseChatPie);
        }
      }
    }
  }
  
  private void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.a(5, paramArrayList);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      a(null);
      return;
    }
    EssenceMsgProcessor.EssenceMsgShortcurBarInfo localEssenceMsgShortcurBarInfo = new EssenceMsgProcessor.EssenceMsgShortcurBarInfo();
    localEssenceMsgShortcurBarInfo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131720116));
    localEssenceMsgShortcurBarInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131720117));
    localEssenceMsgShortcurBarInfo.a(0);
    localEssenceMsgShortcurBarInfo.a(false);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localEssenceMsgShortcurBarInfo);
    a(localArrayList);
    TroopEssenceReportUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, false);
    TroopEssenceReportUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.b, false);
  }
  
  private boolean a(long paramLong)
  {
    TroopShortcutBarInfo localTroopShortcutBarInfo = ((TroopShortcutBarManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(this.b));
    if (localTroopShortcutBarInfo == null) {}
    long l;
    do
    {
      do
      {
        return false;
      } while ((localTroopShortcutBarInfo.a() != 1) && (localTroopShortcutBarInfo.b() != 1));
      l = ((TroopEssenceMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(this.b);
    } while ((paramLong == 0L) || (l > paramLong));
    if ((NetConnInfoCenter.getServerTime() - paramLong) / 86400L == 0L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void c(long paramLong)
  {
    a(a(paramLong));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver);
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    ((TroopEssenceMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(paramLong, new EssenceMsgProcessor.3(this));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof EssenceMsgProcessor.EssenceMsgShortcurBarInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EssenceMsgProcessor", 0, "onClick");
      }
      paramObject = (TroopEssenceMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
      long l = NetConnInfoCenter.getServerTime();
      paramObject.a(this.b, l);
      TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.b), 0L, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, 2);
      a(false);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver);
  }
  
  public void b(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    c(((TroopEssenceMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).b(paramLong));
  }
  
  public void b(Object paramObject) {}
  
  public void c() {}
  
  public void d()
  {
    a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.essencemsg.EssenceMsgProcessor
 * JD-Core Version:    0.7.0.1
 */