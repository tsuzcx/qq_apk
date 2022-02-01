package com.tencent.mobileqq.profilecard.base.view;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import azpb;
import bdla;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class AbsProfileHeaderView$UpdateProfileSetCardTask$1
  implements Runnable
{
  AbsProfileHeaderView$UpdateProfileSetCardTask$1(AbsProfileHeaderView.UpdateProfileSetCardTask paramUpdateProfileSetCardTask, AbsProfileHeaderView paramAbsProfileHeaderView) {}
  
  public void run()
  {
    try
    {
      if (this.a.jdField_a_of_type_JavaUtilHashMap != null)
      {
        bdla.b(null, "CliOper", "", "", "card_mall", "0X80066D3", 0, 0, "", "", "", "");
        View localView = (View)this.a.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
        TextView localTextView = (TextView)localView.findViewById(2131367965);
        ImageView localImageView = (ImageView)localView.findViewById(2131367950);
        Resources localResources = localView.getResources();
        localTextView.setText(localResources.getString(2131719410));
        localImageView.setContentDescription(localResources.getString(2131719410));
        localView.setTag(new azpb(29, "CLICK_BANNER"));
        localView.setOnClickListener(this.a.jdField_a_of_type_AndroidViewView$OnClickListener);
        AbsProfileHeaderView.a(this.a).set(true);
        AbsProfileHeaderView.a(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.UpdateProfileSetCardTask.1
 * JD-Core Version:    0.7.0.1
 */