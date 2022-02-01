package cooperation.ilive.group;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.OnHelperBusinessCallback;
import com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.activity.aio.tips.TipsBarTask;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.group.entity.IliveGroupTipsEntity;
import cooperation.ilive.share.IliveShareHelper;

public class IliveGroupTipsBarHelper
  implements ILifeCycleHelper, OnHelperBusinessCallback
{
  private long jdField_a_of_type_Long = 0L;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private IliveGroupObserver jdField_a_of_type_CooperationIliveGroupIliveGroupObserver = new IliveGroupTipsBarHelper.1(this);
  private IliveGroupTipsBar jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar;
  private IliveGroupTipsBarHelper.IliveHandler jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler;
  private IliveGroupTipsEntity jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity;
  private boolean jdField_a_of_type_Boolean;
  
  public IliveGroupTipsBarHelper(HelperProvider paramHelperProvider, TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar = new IliveGroupTipsBar(paramTroopChatPie, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler = new IliveGroupTipsBarHelper.IliveHandler(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a());
    paramHelperProvider.a(this);
  }
  
  private IliveGroupTipsBar a()
  {
    if (this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar == null)
    {
      this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar = new IliveGroupTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a(this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar);
      }
    }
    return this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar;
  }
  
  private void a(IliveGroupTipsManager paramIliveGroupTipsManager)
  {
    paramIliveGroupTipsManager.a(this.jdField_a_of_type_CooperationIliveGroupIliveGroupObserver);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
      return;
    }
    QLog.i("IliveGroupTipsBarHelper", 1, "helper saveGroupInfo isLive = " + paramBoolean);
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)).setIsTroopLive(paramBoolean);
  }
  
  private void b(IliveGroupTipsManager paramIliveGroupTipsManager)
  {
    e();
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject[0] == null) || (!(paramArrayOfObject[0] instanceof Integer))) {}
    do
    {
      do
      {
        return;
      } while (6 != ((Integer)paramArrayOfObject[0]).intValue());
      paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844120);
      paramArrayOfObject.setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext, 10.0F));
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().setImageDrawable(paramArrayOfObject);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "expose report");
      }
      IliveShareHelper.reportAction("qq_live", "live_group_page", "live_group", "group_bar", "4", 101, IliveShareHelper.getFollowInfo("", "", "", "", ""));
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  private void c(IliveGroupTipsManager paramIliveGroupTipsManager)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    localObject = ((TroopManager)localObject).b(str);
    if ((localObject != null) && (((TroopInfo)localObject).isTroopIlive())) {
      paramIliveGroupTipsManager.a(str, IliveGroupTipsManager.a);
    }
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject[0] == null) || (!(paramArrayOfObject[0] instanceof Integer))) {}
    do
    {
      do
      {
        return;
      } while (6 != ((Integer)paramArrayOfObject[0]).intValue());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b().setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c() == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c().setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.bB();
  }
  
  private void d(IliveGroupTipsManager paramIliveGroupTipsManager)
  {
    e();
    paramIliveGroupTipsManager.b(this.jdField_a_of_type_CooperationIliveGroupIliveGroupObserver);
    this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity = null;
  }
  
  private void e()
  {
    QLog.i("IliveGroupTipsBarHelper", 1, "removeGetGroupData");
    if (this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler != null) {
      this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void f()
  {
    if ((IliveGroupTipsManager.a()) && (this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity != null) && (this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity.jdField_a_of_type_Int >= 5))
    {
      QLog.i("IliveGroupTipsBarHelper", 1, "start delayGetGroupData time = " + this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler.hasMessages(1)) {
        this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler.removeMessages(1);
      }
      this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      Message localMessage = Message.obtain();
      localMessage.obj = this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity;
      localMessage.what = 1;
      this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler.sendMessageDelayed(localMessage, this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity.jdField_a_of_type_Int * 1000);
    }
  }
  
  public String a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131689960);
    if (paramBoolean) {
      str = HardCodeUtil.a(2131693732);
    }
    return str;
  }
  
  public void a()
  {
    a();
    this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  public void a(int paramInt, Object[] paramArrayOfObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramArrayOfObject);
      return;
    case 2: 
      c(paramArrayOfObject);
      return;
    }
    b(paramArrayOfObject);
  }
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "onOtherTipsHide tip=" + paramTipsBarTask);
    }
    if ((this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar != null) && (this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar != paramTipsBarTask))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "onOtherTipsHide tip not equal IliveGroupTipsBar");
      }
      b();
      d();
    }
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject[0] == null) || (!(paramArrayOfObject[0] instanceof Integer))) {}
    while ((6 != ((Integer)paramArrayOfObject[0]).intValue()) || (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L)) {
      return;
    }
    if (a()) {
      c();
    }
    for (;;)
    {
      d();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      b();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null) {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a() != this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "curTip is liveGroupTips");
    }
    return true;
  }
  
  public void b()
  {
    boolean bool1 = ((TroopListenTogetherPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(33)).c();
    boolean bool2 = ((TogetherControlHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(43)).c();
    boolean bool3 = ((StudyRoomTipBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(75)).d();
    boolean bool4 = d();
    QLog.i("IliveGroup", 1, "isListenTogetherTime = " + bool1 + " isTogetherTime = " + bool2 + " showStudyRoomTime = " + bool3 + " isLiveTime = " + bool4);
    if ((bool4) && ((bool1) || (bool2) || (bool3))) {
      c();
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "showTip");
    }
    if (!d()) {}
    do
    {
      do
      {
        return false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null");
      return false;
      TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
      if ((localTipsBarTask == null) || (localTipsBarTask == this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IliveGroupTipsBarHelper", 2, "currTip is other");
    return false;
    c();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a(this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar, new Object[0]);
    this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar.a(this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity);
    d();
    f();
    return true;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "dismiss liveGroupTips");
    }
    if ((this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null or liveGroupTips is null");
      }
    }
    TipsBarTask localTipsBarTask;
    do
    {
      return false;
      localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
    } while ((localTipsBarTask == null) || (localTipsBarTask != this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar));
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "currTip is liveGroupTips");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
    d();
    e();
    return true;
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity != null) && (this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity.jdField_a_of_type_Boolean);
  }
  
  public String getTag()
  {
    return "IliveGroupTipsBarHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 10, 6, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    QLog.e("IliveGroupTipsBarHelper", 1, "onMoveToState state = " + paramInt);
    IliveGroupTipsManager localIliveGroupTipsManager = (IliveGroupTipsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().getManager(QQManagerFactory.ILIVE_GROUP_TIPS_MANAGER);
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return;
    case 4: 
      a(localIliveGroupTipsManager);
      return;
    case 9: 
      a();
      return;
    case 6: 
      c(localIliveGroupTipsManager);
      return;
    case 10: 
      b(localIliveGroupTipsManager);
      return;
    }
    d(localIliveGroupTipsManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsBarHelper
 * JD-Core Version:    0.7.0.1
 */