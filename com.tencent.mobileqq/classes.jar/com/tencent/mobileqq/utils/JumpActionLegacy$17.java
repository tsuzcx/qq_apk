package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.ForwardMiniAppThirdPartyHelper;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class JumpActionLegacy$17
  extends ProtoUtils.TroopProtocolObserver
{
  JumpActionLegacy$17(JumpActionLegacy paramJumpActionLegacy, String paramString1, String paramString2, String paramString3) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool1;
    if (paramInt == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_GO_TO_CHAT_D55", bool1);
    this.d.D();
    if (this.d.D)
    {
      ReportController.b(this.d.H, "dc01160", "", "", "0X800A40E", "0X800A40E", 0, 0, "", "", this.d.b.getString(2131897437), "");
      QQToast.makeText(this.d.b, 1, 2131897437, 1).show();
      paramArrayOfByte = new Intent(this.d.b, SplashActivity.class);
      paramArrayOfByte.addFlags(67108864);
      paramArrayOfByte.addFlags(268435456);
      this.d.b.startActivity(paramArrayOfByte);
      JumpActionLegacy.l(this.d);
      return;
    }
    if (this.d.C != null) {
      this.d.C.removeCallbacksAndMessages(null);
    }
    if (paramInt == 0) {
      paramInt = 0;
    } else if (paramInt == 25501) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    if (paramInt <= 1)
    {
      paramBundle = (String)this.d.f.get("uin");
      if ((paramBundle != null) && (paramBundle.length() >= 5) && (!SearchBaseActivity.D.matcher(paramBundle).matches()))
      {
        boolean bool2 = ((FriendsManager)this.d.H.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(paramBundle);
        paramArrayOfByte = ContactUtils.a(this.d.H, paramBundle);
        Object localObject;
        if ((bool2) && (paramInt == 0))
        {
          localObject = new Intent(this.d.b, SplashActivity.class);
          ((Intent)localObject).putExtra("uin", paramBundle);
          ((Intent)localObject).putExtra("uintype", 0);
          ((Intent)localObject).putExtra("openid", this.a);
          ((Intent)localObject).putExtra("appid", this.b);
          ((Intent)localObject).putExtra("thridparty_pull_aio", true);
          paramBundle = AIOUtils.a((Intent)localObject, new int[] { 2 });
          paramBundle.putExtra("pull_aio_audio", this.c.equals("audio_chat"));
          paramBundle.putExtra("pull_aio_video", this.c.equals("video_chat"));
          if (paramArrayOfByte != null) {
            paramBundle.putExtra("uinname", paramArrayOfByte);
          }
          this.d.b.startActivity(paramBundle);
        }
        else
        {
          if (paramInt == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("pull_show_open_id_diff_main", bool1);
          ((Bundle)localObject).putString("uin", paramBundle);
          ((Bundle)localObject).putInt("uintype", 0);
          if (paramArrayOfByte != null) {
            ((Bundle)localObject).putString("uinname", paramArrayOfByte);
          }
          ((Bundle)localObject).putString("openid", this.a);
          ((Bundle)localObject).putString("appid", this.b);
          ReportController.b(this.d.H, "dc01160", "", "", "0X800A40F", "0X800A40F", 0, 0, "", "", "", "");
          if (bool2)
          {
            ((Bundle)localObject).putBoolean("thridparty_pull_aio", true);
            ((Bundle)localObject).putBoolean("pull_aio_audio", this.c.equals("audio_chat"));
            ((Bundle)localObject).putBoolean("pull_aio_video", this.c.equals("video_chat"));
          }
          else
          {
            ((Bundle)localObject).putInt("fragment_id", 1);
            ((Bundle)localObject).putBoolean("pull_add_friend_tip", true);
          }
          JumpActionLegacy.a(this.d, (Bundle)localObject);
          JumpActionLegacy.l(this.d);
        }
      }
      else
      {
        QQToast.makeText(BaseApplicationImpl.getApplication(), 1, 2131897436, 1).show();
        ReportController.b(this.d.H, "dc01160", "", "", "0X800A40E", "0X800A40E", 0, 0, "", "", this.d.b.getString(2131897438), "");
        JumpActionLegacy.l(this.d);
      }
    }
    else
    {
      paramArrayOfByte = ForwardMiniAppThirdPartyHelper.a(paramArrayOfByte);
      ReportController.a(this.d.H, "inter", "skip", "inter_fail", "", 1, "", paramArrayOfByte, "", "", "", "", "", "", "");
      paramBundle = new Bundle();
      paramBundle.putBoolean("pull_app_not_privilege", true);
      paramBundle.putString("pull_app_not_privilege_string", paramArrayOfByte);
      JumpActionLegacy.a(this.d, paramBundle);
    }
    JumpActionLegacy.l(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.17
 * JD-Core Version:    0.7.0.1
 */