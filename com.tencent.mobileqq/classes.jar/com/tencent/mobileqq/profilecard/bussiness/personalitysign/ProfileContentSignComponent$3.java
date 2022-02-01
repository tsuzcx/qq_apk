package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.widget.TextView;
import anzj;
import azyk;
import bahb;
import bdll;
import bhkx;
import bhuk;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.util.Pair;
import java.util.List;

public class ProfileContentSignComponent$3
  implements Runnable
{
  public ProfileContentSignComponent$3(bahb parambahb, TextView paramTextView, RichStatus paramRichStatus) {}
  
  public void run()
  {
    int i;
    if ((bahb.c(this.this$0) != null) && (!bahb.d(this.this$0).isFinishing()))
    {
      i = azyk.a().a(this.jdField_a_of_type_AndroidWidgetTextView, (String)((Pair)this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.topics.get(0)).second, this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionText, bahb.a(this.this$0), bahb.c(this.this$0), bahb.b(this.this$0));
      if (i != -2147483648) {}
    }
    else
    {
      return;
    }
    bhuk localbhuk = new bhuk();
    localbhuk.a(0, anzj.a(2131707351), 0);
    bhkx.a(this.jdField_a_of_type_AndroidWidgetTextView, -i, 0, localbhuk);
    azyk.a().a(bahb.h(this.this$0));
    bdll.b(null, "dc00898", "", "", "0X800A4D1", "0X800A4D1", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.3
 * JD-Core Version:    0.7.0.1
 */