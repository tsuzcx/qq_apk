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
import bgtn;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.qqinterface.MiniAioInterface;
import com.tencent.widget.immersive.ImmersiveUtils;

public class MiniAioInterfaceImpl
  implements MiniAioInterface
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  private int b;
  
  Intent a()
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
      localIntent1.putExtra("banner_pluginProxyActivityName", this.jdField_a_of_type_AndroidAppActivity.getClass().getName());
      Intent localIntent2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class);
      localIntent2.setData(Uri.parse(String.format("nowmqqapi://now/openroom?src_type=app&version=1&bid=88&roomid=%d&fromid=%d&roomtype=%d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.b), Integer.valueOf(this.jdField_a_of_type_Int) })));
      localIntent2.addFlags(268435456);
      localIntent1.putExtra("banner_pendingIntent", PendingIntent.getActivities(this.jdField_a_of_type_AndroidAppActivity, 0, new Intent[] { localIntent2 }, 134217728));
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
  
  protected MiniMsgUserParam a()
  {
    int i = this.jdField_a_of_type_AndroidAppActivity.getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
    int k = this.jdField_a_of_type_AndroidAppActivity.getApplication().getResources().getDimensionPixelSize(2131297268);
    int m = bgtn.b(47.0F);
    int n = bgtn.a(7.0F);
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 11;
    localMiniMsgUserParam.accessType = 0;
    localMiniMsgUserParam.entryType = 1;
    localMiniMsgUserParam.positionX = (i - k * 4 - m);
    localMiniMsgUserParam.positionY = (j + n);
    localMiniMsgUserParam.colorType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.backConversationIntent = a();
    return localMiniMsgUserParam;
  }
  
  public void onBackground()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
  }
  
  public void onCreate(Context paramContext, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)((ContextWrapper)paramContext).getBaseContext());
    this.jdField_a_of_type_Long = paramBundle.getLong("roomid");
    this.jdField_a_of_type_Int = paramBundle.getInt("roomType");
    this.b = paramBundle.getInt("fromid", 10001);
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(this.jdField_a_of_type_AndroidAppActivity, a());
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