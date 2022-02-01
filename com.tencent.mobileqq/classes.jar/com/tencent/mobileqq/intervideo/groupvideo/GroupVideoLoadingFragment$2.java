package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;

class GroupVideoLoadingFragment$2
  implements PluginLoadListener
{
  GroupVideoLoadingFragment$2(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {}
    do
    {
      return;
      GroupVideoLoadingFragment.a(this.a, paramInt);
      switch (paramInt)
      {
      case 4: 
      case 8: 
      default: 
        return;
      }
    } while (!GroupVideoLoadingFragment.a(this.a));
    long l = paramBundle.getLong("key_totalSize", 0L);
    GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705418), HardCodeUtil.a(2131705433));
    GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705429) + GVideoLoadingUI.a(l) + ")", new GroupVideoLoadingFragment.VideoButtonListener(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705431), HardCodeUtil.a(2131705432));
    paramInt = paramBundle.getInt("key_progress", 0);
    l = paramBundle.getLong("key_totalSize", 0L);
    GroupVideoLoadingFragment.a(this.a).a(paramInt, l);
    GroupVideoLoadingFragment.a(this.a).b();
    return;
    GroupVideoLoadingFragment.a(this.a).a();
    GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705430), HardCodeUtil.a(2131705424));
    paramBundle = Message.obtain();
    paramBundle.arg1 = 10;
    GroupVideoLoadingFragment.a(this.a).sendMessage(paramBundle);
    return;
    GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705427), HardCodeUtil.a(2131705423));
    GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705428), new GroupVideoLoadingFragment.VideoButtonListener(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).b();
    GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705419), "");
    GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705420), new GroupVideoLoadingFragment.VideoButtonListener(this.a, null));
    return;
    GroupVideoLoadingFragment.b(this.a, 90);
    GroupVideoLoadingFragment.a(this.a).a(90, 0L);
    return;
    GroupVideoLoadingFragment.b(this.a, 100);
    GroupVideoLoadingFragment.a(this.a).a(100, 0L);
    GroupVideoLoadingFragment.a(this.a).postDelayed(new GroupVideoLoadingFragment.2.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment.2
 * JD-Core Version:    0.7.0.1
 */