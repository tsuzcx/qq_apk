package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
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
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver;
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  private String jdField_a_of_type_JavaLangString;
  
  public FansBeatRankProcessor(BaseChatPie paramBaseChatPie, IShortcutBarDataProvider paramIShortcutBarDataProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = paramIShortcutBarDataProvider;
    try
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new FansBeatRankProcessor.1(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new FansBeatRankProcessor.2(this);
      return;
    }
    catch (Exception paramBaseChatPie)
    {
      for (;;)
      {
        QLog.e("FansBeatRankProcessor", 2, "mTroopUin init error: ", paramBaseChatPie);
      }
    }
  }
  
  private void a(ArrayList<ShortcutBarInfo> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.a(4, paramArrayList);
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
    if ((localTroopInfo != null) && (localTroopInfo.isFansTroop()))
    {
      if (localTroopInfo.getFansTroopStarId() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        return;
      }
    }
    a(false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof FansBeatRankProcessor.BeatRankShortcurBarInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FansBeatRankProcessor", 2, "onClick");
      }
      if (!StudyModeManager.a()) {
        break label44;
      }
      QQToast.a(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131699454), 0).a();
    }
    label44:
    do
    {
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B585", "0X800B585", 0, 0, "", "", "", "");
      paramObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
      if (paramObject != null)
      {
        FansTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramObject.getFansTroopStarId());
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("FansBeatRankProcessor", 2, "onClick: TroopInfo null");
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public void b(Object paramObject) {}
  
  public void c() {}
  
  public void d()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.importantmsg.FansBeatRankProcessor
 * JD-Core Version:    0.7.0.1
 */