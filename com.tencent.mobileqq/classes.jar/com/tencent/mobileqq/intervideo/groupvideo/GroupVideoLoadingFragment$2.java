package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;

class GroupVideoLoadingFragment$2
  implements PluginLoadListener
{
  GroupVideoLoadingFragment$2(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.a.getBaseActivity() != null)
    {
      if (this.a.getBaseActivity().isFinishing()) {
        return;
      }
      GroupVideoLoadingFragment.a(this.a, paramInt);
      long l;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 5) {
                if (paramInt != 6)
                {
                  if (paramInt != 7)
                  {
                    if (paramInt != 9) {
                      return;
                    }
                    GroupVideoLoadingFragment.b(this.a, 100);
                    GroupVideoLoadingFragment.a(this.a).a(100, 0L);
                    GroupVideoLoadingFragment.a(this.a).postDelayed(new GroupVideoLoadingFragment.2.1(this), 1500L);
                  }
                }
                else
                {
                  GroupVideoLoadingFragment.b(this.a, 90);
                  GroupVideoLoadingFragment.a(this.a).a(90, 0L);
                  return;
                }
              }
              GroupVideoLoadingFragment.a(this.a).b();
              GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705492), "");
              GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705493), new GroupVideoLoadingFragment.VideoButtonListener(this.a, null));
              return;
            }
            GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705500), HardCodeUtil.a(2131705496));
            GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705501), new GroupVideoLoadingFragment.VideoButtonListener(this.a, null));
            return;
          }
          GroupVideoLoadingFragment.a(this.a).a();
          GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705503), HardCodeUtil.a(2131705497));
          paramBundle = Message.obtain();
          paramBundle.arg1 = 10;
          GroupVideoLoadingFragment.a(this.a).sendMessage(paramBundle);
          return;
        }
        GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705504), HardCodeUtil.a(2131705505));
        paramInt = paramBundle.getInt("key_progress", 0);
        l = paramBundle.getLong("key_totalSize", 0L);
        GroupVideoLoadingFragment.a(this.a).a(paramInt, l);
        GroupVideoLoadingFragment.a(this.a).b();
        return;
      }
      if (GroupVideoLoadingFragment.a(this.a))
      {
        l = paramBundle.getLong("key_totalSize", 0L);
        GroupVideoLoadingFragment.a(this.a).a(HardCodeUtil.a(2131705491), HardCodeUtil.a(2131705506));
        paramBundle = GroupVideoLoadingFragment.a(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131705502));
        localStringBuilder.append(GVideoLoadingUI.a(l));
        localStringBuilder.append(")");
        paramBundle.a(localStringBuilder.toString(), new GroupVideoLoadingFragment.VideoButtonListener(this.a, null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment.2
 * JD-Core Version:    0.7.0.1
 */