package com.tencent.mobileqq.intervideo.now.dynamic;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqinterface.MiniAioInterface;
import com.tencent.widget.immersive.ImmersiveUtils;

public class MiniAioInterfaceImpl
  implements MiniAioInterface
{
  private MiniMsgUser a;
  private long b = 0L;
  private int c = 0;
  private int d = 0;
  private int e = -1;
  private int f = -1;
  
  protected MiniMsgUserParam a(Activity paramActivity)
  {
    int i = paramActivity.getApplication().getResources().getDisplayMetrics().widthPixels;
    int k = ImmersiveUtils.getStatusBarHeight(paramActivity);
    int j = i - paramActivity.getApplication().getResources().getDimensionPixelSize(2131297818) * 4;
    i = j - ViewUtils.dpToPx(47.0F);
    int m = this.e;
    if (m != -1) {
      i = j - m;
    }
    j = ViewUtils.dip2px(7.0F) + k;
    m = this.f;
    if (m != -1) {
      j = k + m;
    }
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 11;
    localMiniMsgUserParam.accessType = 0;
    localMiniMsgUserParam.entryType = 1;
    localMiniMsgUserParam.positionX = i;
    localMiniMsgUserParam.positionY = j;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.backConversationIntent = b(paramActivity);
    if (this.d == 10026)
    {
      localMiniMsgUserParam.contentIconResId = 2130853483;
      localMiniMsgUserParam.colorType = 2;
      return localMiniMsgUserParam;
    }
    localMiniMsgUserParam.colorType = 1;
    return localMiniMsgUserParam;
  }
  
  public void a()
  {
    MiniMsgUser localMiniMsgUser = this.a;
    if (localMiniMsgUser != null) {
      localMiniMsgUser.onClick(null);
    }
  }
  
  public void a(Context paramContext, Bundle paramBundle, IMiniMsgUnreadCallback paramIMiniMsgUnreadCallback)
  {
    paramContext = (Activity)paramContext;
    this.b = paramBundle.getLong("roomid");
    this.c = paramBundle.getInt("roomType");
    this.d = paramBundle.getInt("fromid", 10001);
    this.e = paramBundle.getInt("offsetX", -1);
    this.f = paramBundle.getInt("offsetY", -1);
    paramBundle = a(paramContext);
    paramBundle.accessType = 1;
    paramBundle.unreadCallback = paramIMiniMsgUnreadCallback;
    this.a = new MiniMsgUser(paramContext, paramBundle);
    this.a.showEntry();
  }
  
  Intent b(Activity paramActivity)
  {
    Intent localIntent1 = new Intent();
    localIntent1.setFlags(67108864);
    localIntent1.putExtra("tab_index", FrameControllerUtil.a);
    localIntent1.putExtra("fragment_id", 1);
    if (this.d == 10026)
    {
      localIntent1.putExtra("banner_wording", "正在浏览语音房");
      localIntent1.putExtra("banner_iconIdx", 13);
    }
    else if (this.c == 10001)
    {
      localIntent1.putExtra("banner_wording", "正在浏览NOW交友");
      localIntent1.putExtra("banner_iconIdx", 13);
    }
    else
    {
      localIntent1.putExtra("banner_wording", "正在浏览NOW直播");
      localIntent1.putExtra("banner_iconIdx", 14);
    }
    localIntent1.putExtra("banner_businessCategory", "NOW");
    localIntent1.putExtra("banner_activityName", JumpActivity.class);
    localIntent1.putExtra("banner_plguinType", 1);
    localIntent1.putExtra("banner_pluginProxyActivityName", paramActivity.getClass().getName());
    Intent localIntent2 = new Intent(paramActivity, JumpActivity.class);
    localIntent2.setData(Uri.parse(String.format("nowmqqapi://now/openroom?src_type=app&version=1&bid=88&roomid=%d&fromid=%d&roomtype=%d", new Object[] { Long.valueOf(this.b), Integer.valueOf(this.d), Integer.valueOf(this.c) })));
    localIntent2.addFlags(268435456);
    localIntent1.putExtra("banner_pendingIntent", PendingIntent.getActivities(paramActivity, 0, new Intent[] { localIntent2 }, 134217728));
    return localIntent1;
  }
  
  public void onBackground()
  {
    this.a.onBackground();
  }
  
  public void onCreate(Context paramContext, Bundle paramBundle)
  {
    paramContext = (Activity)((ContextWrapper)paramContext).getBaseContext();
    this.b = paramBundle.getLong("roomid");
    this.c = paramBundle.getInt("roomType");
    this.d = paramBundle.getInt("fromid", 10001);
    this.e = paramBundle.getInt("offsetX", -1);
    this.f = paramBundle.getInt("offsetY", -1);
    this.a = new MiniMsgUser(paramContext, a(paramContext));
    this.a.showEntry();
  }
  
  public void onDestroy()
  {
    this.a.destroy();
  }
  
  public void onForeground()
  {
    this.a.onForeground();
  }
  
  public void showEntry(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.showEntry();
      return;
    }
    this.a.hideEntry();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.MiniAioInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */