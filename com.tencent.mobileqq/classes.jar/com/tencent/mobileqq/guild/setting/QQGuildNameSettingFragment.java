package com.tencent.mobileqq.guild.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.guild.base.QQGuildNameBaseFragment;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QQGuildNameSettingFragment
  extends QQGuildNameBaseFragment
{
  private IGProGuildInfo r;
  
  private void a(int paramInt, IGProGuildInfo paramIGProGuildInfo, IGProSecurityResult paramIGProSecurityResult)
  {
    if ((paramInt == 0) && (QQGuildUtil.a(paramIGProSecurityResult)))
    {
      paramIGProSecurityResult = new Intent();
      if (paramIGProGuildInfo != null) {
        paramIGProGuildInfo = paramIGProGuildInfo.getGuildName();
      } else {
        paramIGProGuildInfo = "";
      }
      paramIGProSecurityResult.putExtra("guild_name", paramIGProGuildInfo);
      getActivity().setResult(-1, paramIGProSecurityResult);
      getActivity().finish();
      QQToast.makeText(MobileQQ.getContext(), 2, "设置成功", 1).show();
      return;
    }
    QLog.e("QQGuildNameBaseFragment", 1, new Object[] { "handleModifyGuildInfoBack guildInfo:", paramIGProGuildInfo });
    QQGuildUtil.a(getContext(), paramInt, "提交失败，请稍后重试", paramIGProSecurityResult);
  }
  
  public static void a(Context paramContext, IGProGuildInfo paramIGProGuildInfo)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("extra_guild_guild_info", paramIGProGuildInfo);
    localIntent.putExtras(localBundle);
    QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, QQGuildNameSettingFragment.class, 255);
  }
  
  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.r = ((IGProGuildInfo)getActivity().getIntent().getExtras().getSerializable("extra_guild_guild_info"));
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a.setBackgroundResource(2130840740);
  }
  
  protected void a(String paramString)
  {
    if (this.r != null) {
      ((IGPSService)l().getRuntimeService(IGPSService.class, "")).setGuildName(this.r.getGuildID(), paramString, new QQGuildNameSettingFragment.1(this));
    }
  }
  
  protected String i()
  {
    return getResources().getString(2131916360);
  }
  
  protected String j()
  {
    return null;
  }
  
  protected String k()
  {
    IGProGuildInfo localIGProGuildInfo = this.r;
    if (localIGProGuildInfo != null) {
      return localIGProGuildInfo.getGuildName();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildNameSettingFragment
 * JD-Core Version:    0.7.0.1
 */