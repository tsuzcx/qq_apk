package com.tencent.mobileqq.troop.shortcutbar.essencemsg;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceUtil;
import com.tencent.mobileqq.troop.observer.TroopEssenceMsgObserver;
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
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AIOShortcutBarContext jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopEssenceMsgObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver;
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  private TroopShortcutBarObserver jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver;
  private long b;
  
  public EssenceMsgProcessor(AIOShortcutBarContext paramAIOShortcutBarContext, IShortcutBarDataProvider paramIShortcutBarDataProvider)
  {
    if (paramAIOShortcutBarContext == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = paramAIOShortcutBarContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAIOShortcutBarContext.a());
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = paramIShortcutBarDataProvider;
    this.jdField_a_of_type_AndroidContentContext = paramAIOShortcutBarContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramAIOShortcutBarContext.a();
    try
    {
      this.b = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).longValue();
    }
    catch (Exception paramAIOShortcutBarContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EssenceMsgProcessor", 0, "mTroopUin init error: ", paramAIOShortcutBarContext);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver = new EssenceMsgProcessor.1(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver = new EssenceMsgProcessor.2(this);
  }
  
  private void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    IShortcutBarDataProvider localIShortcutBarDataProvider = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
    if (localIShortcutBarDataProvider != null) {
      localIShortcutBarDataProvider.a(5, paramArrayList);
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
    localEssenceMsgShortcurBarInfo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131719848));
    localEssenceMsgShortcurBarInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131719849));
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
    TroopShortcutBarInfo localTroopShortcutBarInfo = ((TroopShortcutBarManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(this.b));
    boolean bool2 = false;
    if (localTroopShortcutBarInfo == null) {
      return false;
    }
    if ((localTroopShortcutBarInfo.a() != 1) && (localTroopShortcutBarInfo.b() != 1)) {
      return false;
    }
    long l = ((TroopEssenceMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(this.b);
    boolean bool1 = bool2;
    if (paramLong != 0L)
    {
      if (l > paramLong) {
        return false;
      }
      bool1 = bool2;
      if ((NetConnInfoCenter.getServerTime() - paramLong) / 86400L == 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void c(long paramLong)
  {
    a(a(paramLong));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver);
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
      TroopEssenceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.b), 0L, 0, this.jdField_a_of_type_AndroidContentContext, 2);
      a(false);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.essencemsg.EssenceMsgProcessor
 * JD-Core Version:    0.7.0.1
 */