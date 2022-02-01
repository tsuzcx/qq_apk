package cooperation.ilive.group;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
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
import com.tencent.mobileqq.app.BaseActivity;
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
    this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar = new IliveGroupTipsBar(paramTroopChatPie, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler = new IliveGroupTipsBarHelper.IliveHandler(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a());
    paramHelperProvider.a(this);
  }
  
  private IliveGroupTipsBar a()
  {
    if (this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar == null)
    {
      TroopChatPie localTroopChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
      this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar = new IliveGroupTipsBar(localTroopChatPie, localTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
    if ((localObject != null) && (((TroopChatPie)localObject).a() != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("helper saveGroupInfo isLive = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("IliveGroupTipsBarHelper", 1, ((StringBuilder)localObject).toString());
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)).setIsTroopLive(paramBoolean);
    }
  }
  
  private void b(IliveGroupTipsManager paramIliveGroupTipsManager)
  {
    e();
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject[0] != null))
    {
      if (!(paramArrayOfObject[0] instanceof Integer)) {
        return;
      }
      if (6 != ((Integer)paramArrayOfObject[0]).intValue()) {
        return;
      }
      paramArrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844024);
      paramArrayOfObject.setBounds(0, 0, UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext, 10.0F), UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_AndroidContentContext, 10.0F));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().setImageDrawable(paramArrayOfObject);
      }
    }
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
    if ((paramArrayOfObject != null) && (paramArrayOfObject[0] != null))
    {
      if (!(paramArrayOfObject[0] instanceof Integer)) {
        return;
      }
      if (6 != ((Integer)paramArrayOfObject[0]).intValue()) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().setVisibility(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.b().setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c() != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.c().setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.aF();
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
    IliveGroupTipsBarHelper.IliveHandler localIliveHandler = this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler;
    if (localIliveHandler != null) {
      localIliveHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void f()
  {
    if (IliveGroupTipsManager.a())
    {
      Object localObject = this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity;
      if ((localObject != null) && (((IliveGroupTipsEntity)localObject).jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity.jdField_a_of_type_Int >= 5))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start delayGetGroupData time = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity.jdField_a_of_type_Int);
        QLog.i("IliveGroupTipsBarHelper", 1, ((StringBuilder)localObject).toString());
        if (this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler.hasMessages(1)) {
          this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler.removeMessages(1);
        }
        this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity.e = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
        localObject = Message.obtain();
        IliveGroupTipsEntity localIliveGroupTipsEntity = this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity;
        ((Message)localObject).obj = localIliveGroupTipsEntity;
        ((Message)localObject).what = 1;
        this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBarHelper$IliveHandler.sendMessageDelayed((Message)localObject, localIliveGroupTipsEntity.jdField_a_of_type_Int * 1000);
      }
    }
  }
  
  public String a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131689875);
    if (paramBoolean) {
      str = HardCodeUtil.a(2131693685);
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
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        b(paramArrayOfObject);
        return;
      }
      c(paramArrayOfObject);
      return;
    }
    a(paramArrayOfObject);
  }
  
  public void a(TipsBarTask paramTipsBarTask)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onOtherTipsHide tip=");
      ((StringBuilder)localObject).append(paramTipsBarTask);
      QLog.d("IliveGroupTipsBarHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar;
    if ((localObject != null) && (localObject != paramTipsBarTask))
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
    if ((paramArrayOfObject != null) && (paramArrayOfObject[0] != null))
    {
      if (!(paramArrayOfObject[0] instanceof Integer)) {
        return;
      }
      if (6 != ((Integer)paramArrayOfObject[0]).intValue()) {
        return;
      }
      if (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) < 500L) {
        return;
      }
      if (a()) {
        c();
      } else {
        b();
      }
      d();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null or together is null");
      }
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a() == this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "curTip is liveGroupTips");
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    boolean bool1 = ((TroopListenTogetherPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(33)).c();
    boolean bool2 = ((TogetherControlHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(43)).c();
    boolean bool3 = ((StudyRoomTipBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(75)).d();
    boolean bool4 = d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isListenTogetherTime = ");
    localStringBuilder.append(bool1);
    localStringBuilder.append(" isTogetherTime = ");
    localStringBuilder.append(bool2);
    localStringBuilder.append(" showStudyRoomTime = ");
    localStringBuilder.append(bool3);
    localStringBuilder.append(" isLiveTime = ");
    localStringBuilder.append(bool4);
    QLog.i("IliveGroup", 1, localStringBuilder.toString());
    if ((bool4) && ((bool1) || (bool2) || (bool3))) {
      c();
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "showTip");
    }
    if (!d()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null");
      }
      return false;
    }
    TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
    if ((localTipsBarTask != null) && (localTipsBarTask != this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "currTip is other");
      }
      return false;
    }
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
    if ((this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a() != null))
    {
      TipsBarTask localTipsBarTask = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
      if ((localTipsBarTask != null) && (localTipsBarTask == this.jdField_a_of_type_CooperationIliveGroupIliveGroupTipsBar))
      {
        if (QLog.isColorLevel()) {
          QLog.d("IliveGroupTipsBarHelper", 2, "currTip is liveGroupTips");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().a();
        d();
        e();
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null or liveGroupTips is null");
    }
    return false;
  }
  
  public boolean d()
  {
    IliveGroupTipsEntity localIliveGroupTipsEntity = this.jdField_a_of_type_CooperationIliveGroupEntityIliveGroupTipsEntity;
    return (localIliveGroupTipsEntity != null) && (localIliveGroupTipsEntity.jdField_a_of_type_Boolean);
  }
  
  public String getTag()
  {
    return "IliveGroupTipsBarHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 10, 11, 7, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onMoveToState state = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("IliveGroupTipsBarHelper", 1, ((StringBuilder)localObject).toString());
    localObject = (IliveGroupTipsManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a().getManager(QQManagerFactory.ILIVE_GROUP_TIPS_MANAGER);
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 15)
        {
          if (paramInt != 10)
          {
            if (paramInt != 11) {
              return;
            }
            b((IliveGroupTipsManager)localObject);
            return;
          }
          a();
          return;
        }
        d((IliveGroupTipsManager)localObject);
        return;
      }
      c((IliveGroupTipsManager)localObject);
      return;
    }
    a((IliveGroupTipsManager)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsBarHelper
 * JD-Core Version:    0.7.0.1
 */