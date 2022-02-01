package com.tencent.mobileqq.qassistant.command.jump;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.qphone.base.util.QLog;

public class QAssistantConfigMainItem
  extends QAssistantConfigItem
{
  public boolean a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity == null)
    {
      QAssistantConfigUtils.a(this.g, this.f, 100);
      return false;
    }
    Intent localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    if (this.f.equals("contact")) {
      localIntent.putExtra("tab_index", FrameControllerUtil.c);
    }
    for (;;)
    {
      localIntent.putExtra("fragment_id", 1);
      localIntent.setFlags(67108864);
      QAssistantConfigUtils.a(this, paramBoolean, localIntent);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant QAssistantConfigItem.Jump item_server = " + this.c + "|" + paramBaseActivity.getClass().toString());
      paramBaseActivity.startActivity(localIntent);
      return true;
      if (this.f.equals("leba")) {
        localIntent.putExtra("tab_index", FrameControllerUtil.d);
      } else {
        localIntent.putExtra("tab_index", FrameControllerUtil.a);
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    AssistantUtils.a("HelloQQWake", "QAssistantConfigMainItem RealJump");
    if (FrameHelperActivity.b())
    {
      AssistantUtils.a("HelloQQWake", "QAssistantConfigMainItem isDrawerFrameOpenOrMoving");
      FrameHelperActivity.c(true);
      FrameHelperActivity.w();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.command.jump.QAssistantConfigMainItem
 * JD-Core Version:    0.7.0.1
 */