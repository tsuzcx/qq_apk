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
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqinterface.MiniAioInterface;
import com.tencent.widget.immersive.ImmersiveUtils;

public class MiniAioInterfaceImpl
  implements MiniAioInterface
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  private int b;
  private int c = -1;
  private int d = -1;
  
  Intent a(Activity paramActivity)
  {
    Intent localIntent1 = new Intent();
    localIntent1.setFlags(67108864);
    localIntent1.putExtra("tab_index", MainFragment.b);
    localIntent1.putExtra("fragment_id", 1);
    if (this.b == 10026)
    {
      localIntent1.putExtra("banner_wording", "正在浏览语音房");
      localIntent1.putExtra("banner_iconIdx", 13);
    }
    for (;;)
    {
      localIntent1.putExtra("banner_businessCategory", "NOW");
      localIntent1.putExtra("banner_activityName", JumpActivity.class);
      localIntent1.putExtra("banner_plguinType", 1);
      localIntent1.putExtra("banner_pluginProxyActivityName", paramActivity.getClass().getName());
      Intent localIntent2 = new Intent(paramActivity, JumpActivity.class);
      localIntent2.setData(Uri.parse(String.format("nowmqqapi://now/openroom?src_type=app&version=1&bid=88&roomid=%d&fromid=%d&roomtype=%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.b), Integer.valueOf(this.jdField_a_of_type_Int) })));
      localIntent2.addFlags(268435456);
      localIntent1.putExtra("banner_pendingIntent", PendingIntent.getActivities(paramActivity, 0, new Intent[] { localIntent2 }, 134217728));
      return localIntent1;
      if (this.jdField_a_of_type_Int == 10001)
      {
        localIntent1.putExtra("banner_wording", "正在浏览NOW交友");
        localIntent1.putExtra("banner_iconIdx", 13);
      }
      else
      {
        localIntent1.putExtra("banner_wording", "正在浏览NOW直播");
        localIntent1.putExtra("banner_iconIdx", 14);
      }
    }
  }
  
  protected MiniMsgUserParam a(Activity paramActivity)
  {
    int j = paramActivity.getApplication().getResources().getDisplayMetrics().widthPixels;
    int k = ImmersiveUtils.getStatusBarHeight(paramActivity);
    int m = paramActivity.getApplication().getResources().getDimensionPixelSize(2131297335);
    int i = j - m * 4 - ViewUtils.dpToPx(47.0F);
    if (this.c != -1) {
      i = j - m * 4 - this.c;
    }
    j = ViewUtils.dip2px(7.0F) + k;
    if (this.d != -1) {
      j = this.d + k;
    }
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 11;
    localMiniMsgUserParam.accessType = 0;
    localMiniMsgUserParam.entryType = 1;
    localMiniMsgUserParam.positionX = i;
    localMiniMsgUserParam.positionY = j;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.backConversationIntent = a(paramActivity);
    if (this.b == 10026)
    {
      localMiniMsgUserParam.contentIconResId = 2130850743;
      localMiniMsgUserParam.colorType = 2;
      return localMiniMsgUserParam;
    }
    localMiniMsgUserParam.colorType = 1;
    return localMiniMsgUserParam;
  }
  
  public void onBackground()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
  }
  
  public void onCreate(Context paramContext, Bundle paramBundle)
  {
    paramContext = (Activity)((ContextWrapper)paramContext).getBaseContext();
    this.jdField_a_of_type_Long = paramBundle.getLong("roomid");
    this.jdField_a_of_type_Int = paramBundle.getInt("roomType");
    this.b = paramBundle.getInt("fromid", 10001);
    this.c = paramBundle.getInt("offsetX", -1);
    this.d = paramBundle.getInt("offsetY", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(paramContext, a(paramContext));
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.showEntry();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.destroy();
  }
  
  public void onForeground()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
  }
  
  public void showEntry(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.showEntry();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.hideEntry();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.MiniAioInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */