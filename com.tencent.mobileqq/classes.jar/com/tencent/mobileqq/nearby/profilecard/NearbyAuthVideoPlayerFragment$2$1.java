package com.tencent.mobileqq.nearby.profilecard;

import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import anvx;
import aydm;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.QQToast;

public class NearbyAuthVideoPlayerFragment$2$1
  implements Runnable
{
  public NearbyAuthVideoPlayerFragment$2$1(aydm paramaydm, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Aydm.a, NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Aydm.a), false, false);
      return;
    }
    QQToast.a(this.jdField_a_of_type_Aydm.a.getActivity(), 1, anvx.a(2131706582), 0).b(this.jdField_a_of_type_Aydm.a.getActivity().getTitleBarHeight());
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Aydm.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Aydm.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.b(this.jdField_a_of_type_Aydm.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.2.1
 * JD-Core Version:    0.7.0.1
 */