package com.tencent.mobileqq.location.pluspanel;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class LocationSheet
{
  private QQAppInterface a;
  private Context b;
  private BaseChatPie c;
  private SessionInfo d;
  
  public LocationSheet(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie)
  {
    this.a = paramQQAppInterface;
    this.c = paramBaseChatPie;
    b();
  }
  
  private void b()
  {
    BaseChatPie localBaseChatPie = this.c;
    if (localBaseChatPie != null)
    {
      this.b = localBaseChatPie.aX();
      this.d = this.c.aE();
    }
  }
  
  private void c()
  {
    LocationShareServiceHolder.a(this.a).launchShareUi(this.c.aX(), this.c.ah.a, this.c.ah.b, 1);
    ReportController.b(null, "CliOper", "", "", "0X800A763", "0X800A763", 0, 0, "", "0", "0", "");
  }
  
  private void d()
  {
    BaseChatPie localBaseChatPie = this.c;
    if (localBaseChatPie != null)
    {
      PlusPanelUtils.a(this.a, localBaseChatPie.aX());
      this.c.aX().setCanLock(false);
    }
    AIOPanelUtiles.a(this.a, "0X800407F", this.d.a);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationSheet", 2, new Object[] { "show: invoked. ", " sessionInfo: ", this.d });
    }
    if ((this.b != null) && (this.c != null))
    {
      if (this.d == null) {
        return;
      }
      Object localObject = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((!(this.c instanceof DiscussChatPie)) && (!this.d.b.equals(this.a.getCurrentUin())) && ((this.d.a != 0) || (((FriendsManager)localObject).n(this.d.b))))
      {
        localObject = ActionSheet.create(this.b);
        ((ActionSheet)localObject).addButton(2131916250, 0);
        ((ActionSheet)localObject).addButton(2131916557, 0);
        ((ActionSheet)localObject).addCancelButton(2131887648);
        ((ActionSheet)localObject).setOnButtonClickListener(new LocationSheet.1(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
        return;
      }
      d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.pluspanel.LocationSheet
 * JD-Core Version:    0.7.0.1
 */