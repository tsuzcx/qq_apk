package com.tencent.mobileqq.profile.PersonalityLabel;

import com.tencent.mobileqq.widget.QQToast;

class PersonalityLabelGalleryActivity$4$2
  implements Runnable
{
  PersonalityLabelGalleryActivity$4$2(PersonalityLabelGalleryActivity.4 param4, int paramInt) {}
  
  public void run()
  {
    String str = String.format("上传图片失败", new Object[] { Integer.valueOf(this.a + 1) });
    QQToast.makeText(this.b.this$0.getApplicationContext(), 0, str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.4.2
 * JD-Core Version:    0.7.0.1
 */