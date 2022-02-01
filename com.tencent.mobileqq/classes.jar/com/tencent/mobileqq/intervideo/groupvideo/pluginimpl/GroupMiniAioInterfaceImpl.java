package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.AIOUnreadQIPCClient;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherMiniAioHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqinterface.NewMiniAioInterface;
import com.tencent.widget.immersive.ImmersiveUtils;

public class GroupMiniAioInterfaceImpl
  implements NewMiniAioInterface
{
  private Activity mActivity;
  private WatchTogetherMiniAioHelper mMiniMsgUser;
  private long roomId = 0L;
  private int roomType = 0;
  private int xPoint = 0;
  private int yPoint = 0;
  
  Intent getBackIntent()
  {
    Intent localIntent1 = new Intent();
    localIntent1.setFlags(67108864);
    localIntent1.putExtra("tab_index", FrameControllerUtil.a);
    localIntent1.putExtra("fragment_id", 1);
    localIntent1.putExtra("banner_wording", HardCodeUtil.a(2131903328));
    localIntent1.putExtra("banner_iconIdx", 13);
    localIntent1.putExtra("banner_iconIdx", 14);
    localIntent1.putExtra("banner_businessCategory", "GroupVideo");
    localIntent1.putExtra("banner_activityName", JumpActivity.class);
    localIntent1.putExtra("banner_plguinType", 1);
    localIntent1.putExtra("banner_pluginProxyActivityName", this.mActivity.getClass().getName());
    Intent localIntent2 = new Intent(this.mActivity, JumpActivity.class);
    localIntent2.setData(Uri.parse(String.format("nowmqqapi://now/openroom?src_type=app&version=1&bid=88&roomid=%d&fromid=10001&roomtype=%d", new Object[] { Long.valueOf(this.roomId), Integer.valueOf(this.roomType) })));
    localIntent2.addFlags(268435456);
    localIntent1.putExtra("banner_pendingIntent", PendingIntent.getActivities(this.mActivity, 0, new Intent[] { localIntent2 }, 134217728));
    return localIntent1;
  }
  
  protected MiniMsgUserParam getMiniMsgUserParam()
  {
    int k = this.mActivity.getApplication().getResources().getDisplayMetrics().widthPixels;
    int m = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    int n = this.mActivity.getApplication().getResources().getDimensionPixelSize(2131297818);
    int j = this.xPoint;
    int i = j;
    if (j == 0) {
      i = k - n * 4 - ViewUtils.dpToPx(35.0F);
    }
    k = this.yPoint;
    j = k;
    if (k == 0) {
      j = ViewUtils.dip2px(7.0F);
    }
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 26;
    localMiniMsgUserParam.accessType = 0;
    localMiniMsgUserParam.entryType = 1;
    localMiniMsgUserParam.positionX = i;
    localMiniMsgUserParam.positionY = (m + j);
    localMiniMsgUserParam.colorType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.backConversationIntent = getBackIntent();
    return localMiniMsgUserParam;
  }
  
  public void onBackground()
  {
    this.mMiniMsgUser.c();
  }
  
  public void onCreate(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    AIOUnreadQIPCClient.b();
    TextUtils.isEmpty(paramString1);
    this.mActivity = ((Activity)((ContextWrapper)paramContext).getBaseContext());
    this.roomId = paramLong;
    this.roomType = paramInt;
    this.mMiniMsgUser = new WatchTogetherMiniAioHelper(this.mActivity, paramString1, paramString2, getMiniMsgUserParam());
    ThreadManagerV2.getUIHandlerV2().post(new GroupMiniAioInterfaceImpl.1(this));
  }
  
  public void onDestroy()
  {
    this.mMiniMsgUser.d();
  }
  
  public void onForeground()
  {
    this.mMiniMsgUser.b();
  }
  
  public void setPoint(int paramInt1, int paramInt2)
  {
    this.xPoint = paramInt1;
    this.yPoint = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.GroupMiniAioInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */