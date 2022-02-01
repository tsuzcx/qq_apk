package com.tencent.mobileqq.troop.enterEffect;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.GrayTipsConfig;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.GrayTipsConfig.Link;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class TroopEnterEffectManager
  implements Manager
{
  protected QQAppInterface a;
  
  public TroopEnterEffectManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a(TroopEnterEffectConfig.GrayTipsConfig paramGrayTipsConfig, String paramString)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addGrayTips uin = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" wording = ");
      ((StringBuilder)localObject1).append(paramGrayTipsConfig.d);
      QLog.d("TroopEnterEffectManager", 2, ((StringBuilder)localObject1).toString());
    }
    paramString = new UniteGrayTipParam(paramString, this.a.getCurrentAccountUin(), paramGrayTipsConfig.d, 1, -5020, 131078, MessageCache.c());
    int i = 0;
    Object localObject2;
    while (i < paramGrayTipsConfig.e.size())
    {
      localObject1 = (TroopEnterEffectConfig.GrayTipsConfig.Link)paramGrayTipsConfig.e.get(i);
      localObject2 = new Bundle();
      if (paramGrayTipsConfig.g == 1)
      {
        ((Bundle)localObject2).putInt("key_action", 1);
        ((Bundle)localObject2).putString("key_action_DATA", ((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject1).c);
      }
      else if (paramGrayTipsConfig.g == 2)
      {
        ((Bundle)localObject2).putInt("key_action", 30);
        ((Bundle)localObject2).putString("key_action_DATA", VasH5PayUtil.a(paramGrayTipsConfig.h, paramGrayTipsConfig.i, paramGrayTipsConfig.j, paramGrayTipsConfig.k, paramGrayTipsConfig.l));
      }
      paramString.a(((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject1).a, ((TroopEnterEffectConfig.GrayTipsConfig.Link)localObject1).b, (Bundle)localObject2);
      i += 1;
    }
    if (paramGrayTipsConfig.f)
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_action", 29);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramGrayTipsConfig.a);
      ((StringBuilder)localObject2).append("");
      ((Bundle)localObject1).putString("key_action_DATA", ((StringBuilder)localObject2).toString());
      paramString.a(paramGrayTipsConfig.d.length() - 4, paramGrayTipsConfig.d.length(), (Bundle)localObject1);
    }
    paramGrayTipsConfig = new MessageForUniteGrayTip();
    paramGrayTipsConfig.initGrayTipMsg(this.a, paramString);
    UniteGrayTipMsgUtil.a(this.a, paramGrayTipsConfig);
    ((ITroopEnterEffectService)this.a.getRuntimeService(ITroopEnterEffectService.class, "")).getSharedPreferences().edit().putLong("show_gray_tips_time", System.currentTimeMillis()).commit();
    VasWebviewUtil.a(this.a.getCurrentUin(), "style", "0X8009132", "", 1, 0, 0, "", "", "");
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager
 * JD-Core Version:    0.7.0.1
 */