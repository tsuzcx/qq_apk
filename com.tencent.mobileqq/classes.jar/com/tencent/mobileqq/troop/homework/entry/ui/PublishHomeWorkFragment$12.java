package com.tencent.mobileqq.troop.homework.entry.ui;

import com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimeAdpater;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimePicker;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimePicker.OnConfirmBtnClickListener;
import com.tencent.mobileqq.widget.QFormSimpleItem;

class PublishHomeWorkFragment$12
  implements HwkTimePicker.OnConfirmBtnClickListener
{
  PublishHomeWorkFragment$12(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l = HwkTimeAdpater.a(this.a.M, paramInt1, paramInt2, paramInt3) / 1000L;
    if (!PublishHomeWorkFragment.a(this.a, l))
    {
      HwkTimeAdpater.a(this.a.M, (HwkTimeAdpater)this.a.M.a());
      return;
    }
    PublishHomeWorkFragment localPublishHomeWorkFragment = this.a;
    localPublishHomeWorkFragment.ao = l;
    localPublishHomeWorkFragment.M.c();
    this.a.D.setRightText(this.a.b(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.12
 * JD-Core Version:    0.7.0.1
 */