package com.tencent.mobileqq.nearby.profilecard;

import ajya;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import atom;
import bcql;
import com.tencent.image.URLImageView;

public class NearbyAuthVideoPlayerFragment$2$1
  implements Runnable
{
  public NearbyAuthVideoPlayerFragment$2$1(atom paramatom, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Atom.a, NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Atom.a), false, false);
      return;
    }
    bcql.a(this.jdField_a_of_type_Atom.a.getActivity(), 1, ajya.a(2131707118), 0).b(this.jdField_a_of_type_Atom.a.getActivity().getTitleBarHeight());
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Atom.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.a(this.jdField_a_of_type_Atom.a).setVisibility(0);
    NearbyAuthVideoPlayerFragment.b(this.jdField_a_of_type_Atom.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment.2.1
 * JD-Core Version:    0.7.0.1
 */