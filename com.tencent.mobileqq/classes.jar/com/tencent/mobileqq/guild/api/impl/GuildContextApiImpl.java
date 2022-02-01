package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.guild.api.IGuildContextApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.IGuildMainFrame;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class GuildContextApiImpl
  implements IGuildContextApi
{
  public static final String TAG = "GuildContextApiImpl";
  
  public FragmentManager getChildFragmentManager(Context paramContext)
  {
    Frame localFrame = ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).obtainGuildMainFrame(paramContext);
    if ((localFrame instanceof IGuildMainFrame)) {
      return ((IGuildMainFrame)localFrame).cw_().g();
    }
    QLog.e("GuildContextApiImpl", 1, new Object[] { "GuildContextApi not find GuildFrame.. return null! context: ", paramContext });
    return new GuildContextApiImpl.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildContextApiImpl
 * JD-Core Version:    0.7.0.1
 */