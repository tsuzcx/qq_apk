package com.tencent.mobileqq.nearby.profilecard;

import android.widget.ImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class NearbyAuthVideoPlayerFragment$2$1
  implements Runnable
{
  NearbyAuthVideoPlayerFragment$2$1(NearbyAuthVideoPlayerFragment.2 param2, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a)
    {
      NearbyAuthVideoPlayerFragment.a(this.b.a, NearbyAuthVideoPlayerFragment.b(this.b.a), false, false);
      return;
    }
    QQToast.makeText(this.b.a.getBaseActivity(), 1, HardCodeUtil.a(2131904981), 0).show(this.b.a.getBaseActivity().getTitleBarHeight());
    NearbyAuthVideoPlayerFragment.c(this.b.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.d(this.b.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.e(this.b.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.2.1
 * JD-Core Version:    0.7.0.1
 */