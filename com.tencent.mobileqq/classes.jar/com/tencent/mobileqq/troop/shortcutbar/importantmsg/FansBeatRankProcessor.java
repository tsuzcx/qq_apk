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
  private AIOShortcutBarContext jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver;
  TroopPushObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver;
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  private String jdField_a_of_type_JavaLangString;
  
  public FansBeatRankProcessor(AIOShortcutBarContext paramAIOShortcutBarContext, IShortcutBarDataProvider paramIShortcutBarDataProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = paramAIOShortcutBarContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAIOShortcutBarContext.a());
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = paramIShortcutBarDataProvider;
    try
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a().jdField_a_of_type_JavaLangString;
    }
    catch (Exception paramAIOShortcutBarContext)
    {
      QLog.e("FansBeatRankProcessor", 2, "mTroopUin init error: ", paramAIOShortcutBarContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver = new FansBeatRankProcessor.1(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new FansBeatRankProcessor.2(this);
  }
  
  private void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    IShortcutBarDataProvider localIShortcutBarDataProvider = this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
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
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B584", "0X800B584", 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof FansBeatRankProcessor.BeatRankShortcurBarInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FansBeatRankProcessor", 2, "onClick");
      }
      if (StudyModeManager.a())
      {
        QQToast.a(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131699559), 0).a();
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B585", "0X800B585", 0, 0, "", "", "", "");
      paramObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
      if (paramObject != null)
      {
        FansTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(), this.jdField_a_of_type_JavaLangString, paramObject.getFansTroopStarId());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FansBeatRankProcessor", 2, "onClick: TroopInfo null");
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public void b(Object paramObject) {}
  
  public void c() {}
  
  public void d()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.FansBeatRankProcessor
 * JD-Core Version:    0.7.0.1
 */