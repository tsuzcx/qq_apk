package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import amtj;
import android.widget.TextView;
import aymz;
import ayws;
import bcef;
import bfue;
import bgaz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.util.Pair;
import java.util.List;

public class ProfileContentSignComponent$3
  implements Runnable
{
  public ProfileContentSignComponent$3(ayws paramayws, TextView paramTextView, RichStatus paramRichStatus) {}
  
  public void run()
  {
    int i;
    if ((ayws.c(this.this$0) != null) && (!ayws.d(this.this$0).isFinishing()))
    {
      i = aymz.a().a(this.jdField_a_of_type_AndroidWidgetTextView, (String)((Pair)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.get(0)).second, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText, ayws.a(this.this$0), ayws.c(this.this$0), ayws.b(this.this$0));
      if (i != -2147483648) {}
    }
    else
    {
      return;
    }
    bgaz localbgaz = new bgaz();
    localbgaz.a(0, amtj.a(2131707583), 0);
    bfue.a(this.jdField_a_of_type_AndroidWidgetTextView, -i, 0, localbgaz);
    aymz.a().a(ayws.h(this.this$0));
    bcef.b(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.3
 * JD-Core Version:    0.7.0.1
 */