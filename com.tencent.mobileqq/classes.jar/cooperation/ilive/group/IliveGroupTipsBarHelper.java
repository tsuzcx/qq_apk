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
  private TroopChatPie a;
  private IliveGroupTipsBar b;
  private long c = 0L;
  private IliveGroupTipsEntity d;
  private IliveGroupTipsBarHelper.IliveHandler e;
  private boolean f;
  private IliveGroupObserver g = new IliveGroupTipsBarHelper.1(this);
  
  public IliveGroupTipsBarHelper(HelperProvider paramHelperProvider, TroopChatPie paramTroopChatPie)
  {
    this.a = paramTroopChatPie;
    this.b = new IliveGroupTipsBar(paramTroopChatPie, paramTroopChatPie.d, paramTroopChatPie.f);
    this.e = new IliveGroupTipsBarHelper.IliveHandler(this.a.i());
    paramHelperProvider.a(this);
  }
  
  private void a(IliveGroupTipsManager paramIliveGroupTipsManager)
  {
    paramIliveGroupTipsManager.a(this.g);
    this.f = true;
  }
  
  private void b(IliveGroupTipsManager paramIliveGroupTipsManager)
  {
    j();
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((TroopChatPie)localObject).i() != null))
    {
      if (this.a.ah == null) {
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("helper saveGroupInfo isLive = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("IliveGroupTipsBarHelper", 1, ((StringBuilder)localObject).toString());
      ((TroopManager)this.a.i().getManager(QQManagerFactory.TROOP_MANAGER)).f(String.valueOf(this.a.ah.b)).setIsTroopLive(paramBoolean);
    }
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
      paramArrayOfObject = this.a.e.getResources().getDrawable(2130844979);
      paramArrayOfObject.setBounds(0, 0, UIUtils.a(this.a.e, 10.0F), UIUtils.a(this.a.e, 10.0F));
      if (this.a.bJ() != null) {
        this.a.bJ().setImageDrawable(paramArrayOfObject);
      }
    }
  }
  
  private void c(IliveGroupTipsManager paramIliveGroupTipsManager)
  {
    Object localObject = (TroopManager)this.a.d.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = this.a.ah.b;
    localObject = ((TroopManager)localObject).f(str);
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
      if (this.a.bJ() != null) {
        this.a.bJ().setVisibility(0);
      }
      if (this.a.bK() != null) {
        this.a.bK().setOnClickListener(this.a);
      }
      if (this.a.bL() != null) {
        this.a.bL().setOnClickListener(this.a);
      }
    }
  }
  
  private void d(IliveGroupTipsManager paramIliveGroupTipsManager)
  {
    j();
    paramIliveGroupTipsManager.b(this.g);
    this.d = null;
  }
  
  private IliveGroupTipsBar g()
  {
    if (this.b == null)
    {
      TroopChatPie localTroopChatPie = this.a;
      this.b = new IliveGroupTipsBar(localTroopChatPie, localTroopChatPie.d, this.a.f);
      if (this.a.J() != null) {
        this.a.J().b(this.b);
      }
    }
    return this.b;
  }
  
  private void h()
  {
    if (this.f)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "expose report");
      }
      IliveShareHelper.reportAction("qq_live", "live_group_page", "live_group", "group_bar", "4", 101, IliveShareHelper.getFollowInfo("", "", "", "", ""));
      this.f = false;
    }
  }
  
  private void i()
  {
    this.a.cc();
  }
  
  private void j()
  {
    QLog.i("IliveGroupTipsBarHelper", 1, "removeGetGroupData");
    IliveGroupTipsBarHelper.IliveHandler localIliveHandler = this.e;
    if (localIliveHandler != null) {
      localIliveHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void k()
  {
    if (IliveGroupTipsManager.a())
    {
      Object localObject = this.d;
      if ((localObject != null) && (((IliveGroupTipsEntity)localObject).f) && (this.d.g >= 5))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start delayGetGroupData time = ");
        ((StringBuilder)localObject).append(this.d.g);
        QLog.i("IliveGroupTipsBarHelper", 1, ((StringBuilder)localObject).toString());
        if (this.e.hasMessages(1)) {
          this.e.removeMessages(1);
        }
        this.d.j = this.a.ah.b;
        localObject = Message.obtain();
        IliveGroupTipsEntity localIliveGroupTipsEntity = this.d;
        ((Message)localObject).obj = localIliveGroupTipsEntity;
        ((Message)localObject).what = 1;
        this.e.sendMessageDelayed((Message)localObject, localIliveGroupTipsEntity.g * 1000);
      }
    }
  }
  
  public String a(boolean paramBoolean)
  {
    String str = this.a.f.getResources().getString(2131886516);
    if (paramBoolean) {
      str = HardCodeUtil.a(2131891260);
    }
    return str;
  }
  
  public void a()
  {
    g();
    this.b.a(this.a.ah.b);
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
    Object localObject = this.b;
    if ((localObject != null) && (localObject != paramTipsBarTask))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "onOtherTipsHide tip not equal IliveGroupTipsBar");
      }
      c();
      i();
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
      if (Math.abs(System.currentTimeMillis() - this.c) < 500L) {
        return;
      }
      if (b()) {
        d();
      } else {
        c();
      }
      i();
      this.c = System.currentTimeMillis();
    }
  }
  
  public boolean b()
  {
    if (this.a.J() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null or together is null");
      }
      return false;
    }
    if (this.a.J().a() == this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "curTip is liveGroupTips");
      }
      return true;
    }
    return false;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "showTip");
    }
    if (!e()) {
      return false;
    }
    if (this.a.J() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null");
      }
      return false;
    }
    TipsBarTask localTipsBarTask = this.a.J().a();
    if ((localTipsBarTask != null) && (localTipsBarTask != this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IliveGroupTipsBarHelper", 2, "currTip is other");
      }
      return false;
    }
    h();
    this.a.J().a(this.b, new Object[0]);
    this.b.a(this.d);
    i();
    k();
    return true;
  }
  
  public boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "dismiss liveGroupTips");
    }
    if ((this.b != null) && (this.a.J() != null))
    {
      TipsBarTask localTipsBarTask = this.a.J().a();
      if ((localTipsBarTask != null) && (localTipsBarTask == this.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("IliveGroupTipsBarHelper", 2, "currTip is liveGroupTips");
        }
        this.a.J().c();
        i();
        j();
        return true;
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("IliveGroupTipsBarHelper", 2, "tipManager is null or liveGroupTips is null");
    }
    return false;
  }
  
  public boolean e()
  {
    IliveGroupTipsEntity localIliveGroupTipsEntity = this.d;
    return (localIliveGroupTipsEntity != null) && (localIliveGroupTipsEntity.f);
  }
  
  public void f()
  {
    boolean bool1 = ((TroopListenTogetherPanel)this.a.q(33)).e();
    boolean bool2 = ((TogetherControlHelper)this.a.q(43)).e();
    boolean bool3 = ((StudyRoomTipBarHelper)this.a.q(75)).e();
    boolean bool4 = e();
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
      d();
    }
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
    localObject = (IliveGroupTipsManager)this.a.i().getManager(QQManagerFactory.ILIVE_GROUP_TIPS_MANAGER);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsBarHelper
 * JD-Core Version:    0.7.0.1
 */