package com.tencent.mobileqq.troop.homework.entry.ui;

import com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimeAdpater;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimePicker;
import com.tencent.mobileqq.troop.homework.entry.ui.utils.HwkTimePicker.OnConfirmBtnClickListener;
import com.tencent.mobileqq.widget.FormSimpleItem;

class PublishHomeWorkFragment$12
  implements HwkTimePicker.OnConfirmBtnClickListener
{
  PublishHomeWorkFragment$12(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    long l = HwkTimeAdpater.a(this.a.a, paramInt1, paramInt2, paramInt3) / 1000L;
    if (!PublishHomeWorkFragment.a(this.a, l))
    {
      HwkTimeAdpater.a(this.a.a, (HwkTimeAdpater)this.a.a.a());
      return;
    }
    this.a.c = l;
    this.a.a.b();
    this.a.b.setRightText(this.a.a(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.12
 * JD-Core Version:    0.7.0.1
 */