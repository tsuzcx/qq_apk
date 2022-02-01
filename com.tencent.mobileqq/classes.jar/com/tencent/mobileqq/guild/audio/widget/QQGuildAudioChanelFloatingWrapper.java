package com.tencent.mobileqq.guild.audio.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.guild.window.IGuildFloatWindowWrapper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingBaseProxyWrapper;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QQGuildAudioChanelFloatingWrapper
  extends FloatingBaseProxyWrapper
  implements IGuildFloatWindowWrapper
{
  public static final String CLASS_NAME = "com.tencent.mobileqq.guild.audio.widget.QQGuildAudioChanelFloatingWrapper";
  public static final float DIP_FLOAT_WINDOW_SIZE = 94.0F;
  public static final float DIP_ICON_SIZE = 64.0F;
  public static final String TAG = "QQGuildAudioChanelFloatingWrapper";
  private AudioSmallScreen a;
  private boolean b = false;
  private IGProGuildInfo c;
  private IGProChannelInfo d;
  
  public QQGuildAudioChanelFloatingWrapper(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveFloatCenter: x[");
    ((StringBuilder)localObject).append(q());
    ((StringBuilder)localObject).append("] y[");
    ((StringBuilder)localObject).append(r());
    ((StringBuilder)localObject).append("]");
    QLog.i("QQGuildAudioChanelFloatingWrapper", 1, ((StringBuilder)localObject).toString());
    localObject = MobileQQ.getContext().getSharedPreferences("qqfs_floating_sp", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("qq_guild_audio_small_screen_center_x", q());
    ((SharedPreferences.Editor)localObject).putInt("qq_guild_audio_small_screen_center_y", r());
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("qqfs_floating_sp", 4);
    int i = localSharedPreferences.getInt("qq_guild_audio_small_screen_center_x", -2147483648);
    int j = localSharedPreferences.getInt("qq_guild_audio_small_screen_center_y", -2147483648);
    if ((i != -2147483648) && (j != -2147483648))
    {
      paramFloatingScreenParams.setFloatingCenterX(i);
      paramFloatingScreenParams.setFloatingCenterY(j);
    }
    if ((paramView instanceof AudioSmallScreen))
    {
      this.a = ((AudioSmallScreen)paramView);
      this.a.a(this.c, this.d);
    }
    this.b = true;
    i = super.a(paramFloatingScreenParams, paramView);
    f();
    return i;
  }
  
  public void a(int paramInt)
  {
    c();
    AudioSmallScreen localAudioSmallScreen = this.a;
    if (localAudioSmallScreen != null) {
      localAudioSmallScreen.a();
    }
    this.b = false;
    super.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(View paramView)
  {
    u();
    b(paramView);
    a(paramView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void a(IGProGuildInfo paramIGProGuildInfo, IGProChannelInfo paramIGProChannelInfo)
  {
    this.c = paramIGProGuildInfo;
    this.d = paramIGProChannelInfo;
  }
  
  public IGProChannelInfo b()
  {
    return this.d;
  }
  
  public void dz_()
  {
    a(true);
    a(0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.QQGuildAudioChanelFloatingWrapper
 * JD-Core Version:    0.7.0.1
 */