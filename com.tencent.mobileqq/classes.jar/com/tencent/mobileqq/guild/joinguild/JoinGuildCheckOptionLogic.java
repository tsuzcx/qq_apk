package com.tencent.mobileqq.guild.joinguild;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelDialogFragment;
import com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewModel.JoinChannelParams;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class JoinGuildCheckOptionLogic
{
  private AppRuntime a;
  private Context b;
  private JoinChannelViewModel.JoinChannelParams c;
  private String d;
  private Bundle e;
  private AddGuildOption f;
  private int g = -1;
  private boolean h = false;
  
  public JoinGuildCheckOptionLogic(@NonNull AppRuntime paramAppRuntime, @NonNull Context paramContext, @NonNull JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, @Nullable String paramString, Bundle paramBundle)
  {
    this.a = paramAppRuntime;
    this.b = paramContext;
    this.c = paramJoinChannelParams;
    this.d = paramString;
    this.e = paramBundle;
    this.h = false;
  }
  
  private void a(JoinGuildCheckOptionLogic.INextStepAction paramINextStepAction, JoinChannelViewModel.JoinChannelParams paramJoinChannelParams, String paramString, Bundle paramBundle, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if (!this.h)
    {
      this.h = true;
      paramINextStepAction.a(paramJoinChannelParams, paramString, paramBundle, paramIResultWithSecurityCallback);
      QLog.d("JoinGuildLogic", 1, new Object[] { "handleDoAddGuild guildId=", paramJoinChannelParams.a, " channelId=", paramString });
    }
  }
  
  private void a(IResultWithSecurityCallback paramIResultWithSecurityCallback, int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (!this.h)
    {
      this.h = true;
      paramIResultWithSecurityCallback.a(paramInt, paramString, paramIGProSecurityResult);
      QLog.d("JoinGuildLogic", 1, new Object[] { "handleCallback code=", Integer.valueOf(paramInt), " errMsg=", paramString });
    }
  }
  
  private void b(JoinGuildCheckOptionLogic.INextStepAction paramINextStepAction, IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    if (this.g != -1)
    {
      Object localObject = this.f;
      if (localObject == null) {
        return;
      }
      if (this.h) {
        return;
      }
      int i = ((AddGuildOption)localObject).a;
      if (i != 2) {
        if (i != 3)
        {
          if ((i != 4) && (i != 5)) {
            a(paramINextStepAction, this.c, this.d, this.e, paramIResultWithSecurityCallback);
          }
        }
        else
        {
          a(paramIResultWithSecurityCallback, -1, BaseApplication.getContext().getString(2131890393), null);
          return;
        }
      }
      localObject = this.b;
      if ((localObject instanceof QBaseActivity))
      {
        JoinChannelDialogFragment.a((QBaseActivity)localObject, this.c, this.f, new JoinGuildCheckOptionLogic.3(this, paramINextStepAction));
        return;
      }
      paramINextStepAction = new StringBuilder();
      paramINextStepAction.append("show join channel dialog failed ");
      paramINextStepAction.append(this.b.getClass().getSimpleName());
      QLog.e("JoinGuildLogic", 1, paramINextStepAction.toString());
      a(paramIResultWithSecurityCallback, -1, "error activity", null);
    }
  }
  
  public void a(@NonNull JoinGuildCheckOptionLogic.INextStepAction paramINextStepAction, @NonNull IResultWithSecurityCallback paramIResultWithSecurityCallback)
  {
    int i = 0;
    this.h = false;
    if ((TextUtils.isEmpty(this.c.a)) || (TextUtils.isEmpty(this.c.b))) {
      i = 1;
    }
    if (i != 0)
    {
      QLog.e("JoinGuildLogic", 1, "addGuild, error params");
      a(paramIResultWithSecurityCallback, -1, "addGuild, error params", null);
      return;
    }
    IGPSService localIGPSService = (IGPSService)this.a.getRuntimeService(IGPSService.class, "");
    localIGPSService.queryApplyAddGuildStatus(this.c.a, new JoinGuildCheckOptionLogic.1(this, paramINextStepAction, paramIResultWithSecurityCallback));
    localIGPSService.getAddGuildOption(this.c.a, new JoinGuildCheckOptionLogic.2(this, paramIResultWithSecurityCallback, paramINextStepAction));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.joinguild.JoinGuildCheckOptionLogic
 * JD-Core Version:    0.7.0.1
 */