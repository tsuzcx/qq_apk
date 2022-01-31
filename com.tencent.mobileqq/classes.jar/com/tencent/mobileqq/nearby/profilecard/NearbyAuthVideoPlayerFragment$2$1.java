package com.tencent.mobileqq.nearby.profilecard;

import alud;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import avjv;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.QQToast;

public class NearbyAuthVideoPlayerFragment$2$1
  implements Runnable
{
  public NearbyAuthVideoPlayerFragment$2$1(avjv paramavjv, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Avjv.a, NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Avjv.a), false, false);
      return;
    }
    QQToast.a(this.jdField_a_of_type_Avjv.a.getActivity(), 1, alud.a(2131707502), 0).b(this.jdField_a_of_type_Avjv.a.getActivity().getTitleBarHeight());
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Avjv.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Avjv.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.b(this.jdField_a_of_type_Avjv.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.2.1
 * JD-Core Version:    0.7.0.1
 */