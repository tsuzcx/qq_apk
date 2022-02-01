package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class ForwardIMByThirdPartyHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private QQCustomDialog a = null;
  private QQAppInterface b;
  private BaseChatPie c;
  private Activity d;
  private boolean e;
  private boolean f;
  private boolean g;
  private String h;
  private String i;
  private SessionInfo j = new SessionInfo();
  private boolean k;
  
  public ForwardIMByThirdPartyHelper(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardIMByThirdPartyHelper", 2, " init ");
    }
    this.c = paramBaseChatPie;
    paramBaseChatPie = this.c;
    if (paramBaseChatPie != null)
    {
      this.d = paramBaseChatPie.f;
      paramBaseChatPie = this.d;
      if (paramBaseChatPie != null) {
        this.b = ((QQAppInterface)((BaseActivity)paramBaseChatPie).getAppInterface());
      }
    }
  }
  
  private QQCustomDialog a(String paramString)
  {
    return DialogUtil.a(this.d, 230).setTitle(null).setMessage(paramString).setPositiveButton(this.d.getString(2131887629), new ForwardIMByThirdPartyHelper.1(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.f)
      {
        if (this.b.getCurrentAccountUin().equals(this.j.b))
        {
          a(this.d.getString(2131897435)).show();
          return;
        }
        ReportController.b(this.b, "dc01160", "", "", "0X800A40C", "0X800A40C", 0, 0, "", "", "", "");
        ChatActivityUtils.a(this.b, this.d, this.j.a, this.j.b, this.j.e, this.j.f, true, "", true, true, null, "from_internal", null);
        return;
      }
      if (this.g)
      {
        if (this.b.getCurrentAccountUin().equals(this.j.b))
        {
          a(this.d.getString(2131897435)).show();
          return;
        }
        ReportController.b(this.b, "dc01160", "", "", "0X800A40D", "0X800A40D", 0, 0, "", "", "", "");
        ChatActivityUtils.a(this.b, this.d, this.j.a, this.j.b, this.j.e, this.j.f, false, "", true, true, null, "from_internal", null);
        return;
      }
      ReportController.b(this.b, "dc01160", "", "", "0X800A40B", "0X800A40B", 0, 0, "", "", "", "");
      return;
    }
    if (this.k) {
      a();
    }
  }
  
  private void b()
  {
    QQCustomDialog localQQCustomDialog = this.a;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
  }
  
  protected void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((QQCustomDialog)localObject).isShowing()) && (!this.d.isFinishing()))
    {
      this.a.show();
      return;
    }
    this.a = DialogUtil.a(this.d, 230);
    this.a.setMessage(2131892939);
    this.a.setTitle(2131917221);
    localObject = new ForwardIMByThirdPartyHelper.2(this);
    this.a.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
    this.a.setPositiveButton(2131892907, (DialogInterface.OnClickListener)localObject);
    if (!this.d.isFinishing()) {
      this.a.show();
    }
  }
  
  public void a(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardIMByThirdPartyHelper", 2, "handleForwordIM");
    }
    if (paramIntent == null) {
      return;
    }
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      this.e = paramIntent.getBoolean("thridparty_pull_aio", false);
      if (this.e)
      {
        this.k = paramBoolean;
        this.f = paramIntent.getBoolean("pull_aio_audio", false);
        this.g = paramIntent.getBoolean("pull_aio_video", false);
        this.h = paramIntent.getString("openid", "");
        this.i = paramIntent.getString("appid", "");
        this.j.b = paramIntent.getString("uin");
        this.j.a = paramIntent.getInt("uintype");
        this.j.f = paramIntent.getString("phonenum");
        this.j.e = paramIntent.getString("uinname", "");
        a(true);
      }
    }
  }
  
  public String getTag()
  {
    return "ForwardIMByThirdPartyHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 8)
    {
      if (paramInt != 15) {
        return;
      }
      b();
      if (QLog.isColorLevel()) {
        QLog.d("ForwardIMByThirdPartyHelper", 2, "onMoveToState DESTROY =");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ForwardIMByThirdPartyHelper", 2, "onMoveToState SHOW_FIRST_BEGIN ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper
 * JD-Core Version:    0.7.0.1
 */