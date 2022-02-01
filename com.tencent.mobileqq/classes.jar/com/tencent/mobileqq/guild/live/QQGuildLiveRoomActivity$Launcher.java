package com.tencent.mobileqq.guild.live;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;

public class QQGuildLiveRoomActivity$Launcher
{
  public static void a(Intent paramIntent, Class<? extends QQGuildLiveRoomActivity> paramClass, Class<? extends QPublicBaseFragment> paramClass1)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(BaseApplicationImpl.getApplication(), paramClass);
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    BaseApplicationImpl.getApplication().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.QQGuildLiveRoomActivity.Launcher
 * JD-Core Version:    0.7.0.1
 */