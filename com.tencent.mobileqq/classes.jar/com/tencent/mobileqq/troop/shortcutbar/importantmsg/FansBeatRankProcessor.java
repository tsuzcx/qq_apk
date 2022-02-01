package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarProcessor;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FansBeatRankProcessor
  extends IShortcutBarProcessor
{
  TroopPushObserver a;
  TroopObserver b;
  private QQAppInterface c;
  private IShortcutBarDataProvider d;
  private String e;
  private AIOShortcutBarContext f;
  
  public FansBeatRankProcessor(AIOShortcutBarContext paramAIOShortcutBarContext, IShortcutBarDataProvider paramIShortcutBarDataProvider)
  {
    this.f = paramAIOShortcutBarContext;
    this.c = ((QQAppInterface)paramAIOShortcutBarContext.c());
    this.d = paramIShortcutBarDataProvider;
    try
    {
      this.e = this.f.d().b;
    }
    catch (Exception paramAIOShortcutBarContext)
    {
      QLog.e("FansBeatRankProcessor", 2, "mTroopUin init error: ", paramAIOShortcutBarContext);
    }
    this.a = new FansBeatRankProcessor.1(this);
    this.b = new FansBeatRankProcessor.2(this);
  }
  
  private void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    IShortcutBarDataProvider localIShortcutBarDataProvider = this.d;
    if (localIShortcutBarDataProvider != null) {
      localIShortcutBarDataProvider.a(4, paramArrayList);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      a(null);
      return;
    }
    FansBeatRankProcessor.BeatRankShortcurBarInfo localBeatRankShortcurBarInfo = new FansBeatRankProcessor.BeatRankShortcurBarInfo();
    localBeatRankShortcurBarInfo.b("https://static-res.qq.com/static-res/clivia/heart_icon.png");
    localBeatRankShortcurBarInfo.a("打榜");
    localBeatRankShortcurBarInfo.a(0);
    localBeatRankShortcurBarInfo.a(false);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localBeatRankShortcurBarInfo);
    a(localArrayList);
    ReportController.b(this.c, "dc00898", "", "", "0X800B584", "0X800B584", 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.e);
    boolean bool = false;
    if ((localTroopInfo != null) && (localTroopInfo.isFansTroop()))
    {
      if (localTroopInfo.getFansTroopStarId() != 0) {
        bool = true;
      }
      a(bool);
      return;
    }
    a(false);
  }
  
  public void a()
  {
    this.c.removeObserver(this.a);
    this.c.removeObserver(this.b);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof FansBeatRankProcessor.BeatRankShortcurBarInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FansBeatRankProcessor", 2, "onClick");
      }
      if (StudyModeManager.h())
      {
        QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131897590), 0).show();
        return;
      }
      ReportController.b(this.c, "dc00898", "", "", "0X800B585", "0X800B585", 0, 0, "", "", "", "");
      paramObject = ((TroopManager)this.c.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.e);
      if (paramObject != null)
      {
        FansTroopUtils.a(this.f.e(), this.e, paramObject.getFansTroopStarId());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FansBeatRankProcessor", 2, "onClick: TroopInfo null");
      }
    }
  }
  
  public void b()
  {
    this.c.addObserver(this.a);
    this.c.addObserver(this.b);
  }
  
  public void b(Object paramObject) {}
  
  public void c() {}
  
  public void d()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.FansBeatRankProcessor
 * JD-Core Version:    0.7.0.1
 */