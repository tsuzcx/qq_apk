package com.tencent.mobileqq.listentogether.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class TroopListenTogetherPanel
  extends BaseListenTogetherPanel
{
  public TroopListenTogetherPanel(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public static TroopListenTogetherPanel a(BaseChatPie paramBaseChatPie)
  {
    return (TroopListenTogetherPanel)paramBaseChatPie.q(33);
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowTroopType hasAnythingDiglog2Show:");
      localStringBuilder.append(paramBoolean);
      QLog.i("BaseListenTogetherPanel_Troop", 2, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.b.app.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.e.b);
    if (localTroopInfo != null) {
      return localTroopInfo.isAdmin();
    }
    return false;
  }
  
  public boolean c()
  {
    if (this.b.app.getCurrentAccountUin().equalsIgnoreCase(this.e.m)) {
      return true;
    }
    return b();
  }
  
  public void d()
  {
    if ((this.a instanceof TroopChatPie)) {
      ((TroopChatPie)this.a).cc();
    }
  }
  
  public String getTag()
  {
    return "BaseListenTogetherPanel_Troop";
  }
  
  public void k()
  {
    super.k();
    this.e.a = 1;
    this.e.b = this.a.ae();
    if (this.e.b == null) {
      this.e.b = "";
    }
    String str = this.a.d.getCurrentUin();
    this.m = new BaseListenTogetherPanel.ReportInfo();
    this.m.a = "Grp_AIO";
    int i = ListenTogetherUtils.a(str, this.e.b);
    this.m.b = i;
    this.m.c = this.e.b;
  }
  
  public void q()
  {
    super.q();
    this.j = true;
  }
  
  protected void r()
  {
    if (!this.i) {
      return;
    }
    if ((this.e.a == 1) && (!TextUtils.isEmpty(this.e.b)) && (this.e.q != null) && (this.e.q.h) && (this.e.c != 3)) {
      if (this.e.e) {
        try
        {
          if (ListenTogetherUtils.a(this.a.d, "listen_together_allow_start_admin_guide", false, false)) {
            return;
          }
          ListenTogetherUtils.b(this.a.d, "listen_together_allow_start_admin_guide", true, false);
          QQCustomDialog localQQCustomDialog = DialogUtil.a(this.b, 230);
          localQQCustomDialog.setMessage("一起听歌允许群成员开启，你可以在一起听歌-设置 中关闭此权限。").setTitle("一起听歌功能更新").setPositiveButton("知道了", new TroopListenTogetherPanel.1(this, localQQCustomDialog));
          localQQCustomDialog.show();
          return;
        }
        catch (Exception localException1)
        {
          ListenTogetherUtils.b(this.a.d, "listen_together_allow_start_admin_guide", true, false);
          QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide, admin exception:", localException1);
          return;
        }
      } else {
        try
        {
          Object localObject = ListenTogetherUtils.a(this.e.a, this.e.b);
          if (!ListenTogetherUtils.a(this.a.d, (String)localObject, false, false))
          {
            ListenTogetherUtils.b(this.a.d, (String)localObject, true, false);
            localObject = DialogUtil.a(this.b, 230);
            ((QQCustomDialog)localObject).setMessage("本群支持群成员开启一起听歌功能").setTitle("一起听歌功能更新").setPositiveButton("知道了", new TroopListenTogetherPanel.2(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).show();
            return;
          }
        }
        catch (Exception localException2)
        {
          String str = ListenTogetherUtils.a(this.e.a, this.e.b);
          ListenTogetherUtils.b(this.a.d, str, true, false);
          QLog.e("BaseListenTogetherPanel_Troop", 1, "showAllowMemStartGuide mem exception:", localException2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel
 * JD-Core Version:    0.7.0.1
 */