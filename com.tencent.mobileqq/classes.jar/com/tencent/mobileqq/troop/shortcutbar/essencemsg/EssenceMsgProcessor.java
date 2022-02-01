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
  private final long a = 86400L;
  private QQAppInterface b;
  private AIOShortcutBarContext c;
  private IShortcutBarDataProvider d;
  private long e;
  private TroopEssenceMsgObserver f;
  private TroopShortcutBarObserver g;
  private Context h;
  private SessionInfo i;
  
  public EssenceMsgProcessor(AIOShortcutBarContext paramAIOShortcutBarContext, IShortcutBarDataProvider paramIShortcutBarDataProvider)
  {
    if (paramAIOShortcutBarContext == null) {
      return;
    }
    this.c = paramAIOShortcutBarContext;
    this.b = ((QQAppInterface)paramAIOShortcutBarContext.c());
    this.d = paramIShortcutBarDataProvider;
    this.h = paramAIOShortcutBarContext.e();
    this.i = paramAIOShortcutBarContext.d();
    try
    {
      this.e = Long.valueOf(this.i.b).longValue();
    }
    catch (Exception paramAIOShortcutBarContext)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EssenceMsgProcessor", 0, "mTroopUin init error: ", paramAIOShortcutBarContext);
      }
    }
    this.f = new EssenceMsgProcessor.1(this);
    this.g = new EssenceMsgProcessor.2(this);
  }
  
  private void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    IShortcutBarDataProvider localIShortcutBarDataProvider = this.d;
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
    localEssenceMsgShortcurBarInfo.b(this.b.getApplication().getResources().getString(2131917453));
    localEssenceMsgShortcurBarInfo.a(this.b.getApplication().getResources().getString(2131917454));
    localEssenceMsgShortcurBarInfo.a(0);
    localEssenceMsgShortcurBarInfo.a(false);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localEssenceMsgShortcurBarInfo);
    a(localArrayList);
    TroopEssenceReportUtil.c(this.b, this.e, false);
    TroopEssenceReportUtil.d(this.b, this.e, false);
  }
  
  private void c(long paramLong)
  {
    a(d(paramLong));
  }
  
  private boolean d(long paramLong)
  {
    TroopShortcutBarInfo localTroopShortcutBarInfo = ((TroopShortcutBarManager)this.b.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(this.e));
    boolean bool2 = false;
    if (localTroopShortcutBarInfo == null) {
      return false;
    }
    if ((localTroopShortcutBarInfo.a() != 1) && (localTroopShortcutBarInfo.b() != 1)) {
      return false;
    }
    long l = ((TroopEssenceMsgManager)this.b.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(this.e);
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
  
  public void a()
  {
    this.b.removeObserver(this.f);
    this.b.removeObserver(this.g);
  }
  
  public void a(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    ((TroopEssenceMsgManager)this.b.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(paramLong, new EssenceMsgProcessor.3(this));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof EssenceMsgProcessor.EssenceMsgShortcurBarInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EssenceMsgProcessor", 0, "onClick");
      }
      paramObject = (TroopEssenceMsgManager)this.b.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
      long l = NetConnInfoCenter.getServerTime();
      paramObject.a(this.e, l);
      TroopEssenceUtil.a(this.b, String.valueOf(this.e), 0L, 0, this.h, 2);
      a(false);
    }
  }
  
  public void b()
  {
    this.b.addObserver(this.f);
    this.b.addObserver(this.g);
  }
  
  public void b(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    c(((TroopEssenceMsgManager)this.b.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).b(paramLong));
  }
  
  public void b(Object paramObject) {}
  
  public void c() {}
  
  public void d()
  {
    a(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.essencemsg.EssenceMsgProcessor
 * JD-Core Version:    0.7.0.1
 */