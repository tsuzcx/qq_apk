package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.res.Resources;
import com.tencent.mobileqq.utils.NetworkUtil;

class PersonalityLabelGalleryActivity$1
  implements Runnable
{
  PersonalityLabelGalleryActivity$1(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo) {}
  
  public void run()
  {
    if (!this.this$0.isFinishing())
    {
      this.this$0.a(this.a, false);
      if (!NetworkUtil.isNetSupport(this.this$0))
      {
        Object localObject = this.this$0;
        PersonalityLabelGalleryActivity.a((PersonalityLabelGalleryActivity)localObject, ((PersonalityLabelGalleryActivity)localObject).getResources().getString(2131694422));
        localObject = this.a;
        int i;
        if ((localObject != null) && (((ProfilePersonalityLabelInfo)localObject).getSize() > 0)) {
          i = 1;
        } else {
          i = 0;
        }
        localObject = this.this$0;
        if (i != 0) {
          i = 8;
        } else {
          i = 0;
        }
        ((PersonalityLabelGalleryActivity)localObject).a(i, "加载失败", false);
        return;
      }
      PersonalityLabelGalleryActivity.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.1
 * JD-Core Version:    0.7.0.1
 */