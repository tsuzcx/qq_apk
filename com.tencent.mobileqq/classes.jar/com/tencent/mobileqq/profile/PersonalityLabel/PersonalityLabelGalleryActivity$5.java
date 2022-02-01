package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class PersonalityLabelGalleryActivity$5
  extends BroadcastReceiver
{
  PersonalityLabelGalleryActivity$5(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.card.modify_personality_label")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PersonalityLabelGalleryActivity", 2, "receive broadcast modify pl info");
      }
      paramContext = paramIntent.getBundleExtra("key_bundle_data");
      if ((paramContext != null) && (paramContext.getBoolean("onTagChanged")))
      {
        this.a.a = true;
        PersonalityLabelGalleryActivity.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.5
 * JD-Core Version:    0.7.0.1
 */