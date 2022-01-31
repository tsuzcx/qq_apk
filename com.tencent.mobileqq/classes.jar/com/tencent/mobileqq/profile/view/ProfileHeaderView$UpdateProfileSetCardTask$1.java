package com.tencent.mobileqq.profile.view;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import awki;
import awmk;
import azmj;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

class ProfileHeaderView$UpdateProfileSetCardTask$1
  implements Runnable
{
  ProfileHeaderView$UpdateProfileSetCardTask$1(ProfileHeaderView.UpdateProfileSetCardTask paramUpdateProfileSetCardTask, ProfileHeaderView paramProfileHeaderView) {}
  
  public void run()
  {
    try
    {
      if (this.a.jdField_a_of_type_JavaUtilHashMap != null)
      {
        azmj.b(null, "CliOper", "", "", "card_mall", "0X80066D3", 0, 0, "", "", "", "");
        View localView = (View)this.a.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
        TextView localTextView = (TextView)localView.findViewById(2131367409);
        ImageView localImageView = (ImageView)localView.findViewById(2131367395);
        Resources localResources = localView.getResources();
        localTextView.setText(localResources.getString(2131720869));
        localImageView.setContentDescription(localResources.getString(2131720869));
        localView.setTag(new awki(29, "CLICK_BANNER"));
        localView.setOnClickListener(this.a.jdField_a_of_type_Awmk.a);
        this.a.b.set(true);
        ProfileHeaderView.a(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.UpdateProfileSetCardTask.1
 * JD-Core Version:    0.7.0.1
 */