package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.res.Resources;
import com.tencent.mobileqq.utils.NetworkUtil;

class PersonalityLabelGalleryActivity$1
  implements Runnable
{
  PersonalityLabelGalleryActivity$1(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity, ProfilePersonalityLabelInfo paramProfilePersonalityLabelInfo) {}
  
  public void run()
  {
    PersonalityLabelGalleryActivity localPersonalityLabelGalleryActivity;
    if (!this.this$0.isFinishing())
    {
      this.this$0.a(this.a, false);
      if (NetworkUtil.d(this.this$0)) {
        break label101;
      }
      PersonalityLabelGalleryActivity.a(this.this$0, this.this$0.getResources().getString(2131694457));
      if ((this.a == null) || (this.a.getSize() <= 0)) {
        break label91;
      }
      i = 1;
      localPersonalityLabelGalleryActivity = this.this$0;
      if (i == 0) {
        break label96;
      }
    }
    label91:
    label96:
    for (int i = 8;; i = 0)
    {
      localPersonalityLabelGalleryActivity.a(i, "加载失败", false);
      return;
      i = 0;
      break;
    }
    label101:
    PersonalityLabelGalleryActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.1
 * JD-Core Version:    0.7.0.1
 */