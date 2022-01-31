package com.tencent.mobileqq.gamecenter.adapter;

import android.widget.TextView;
import apwh;
import apwk;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

public class QQGamePubFeedsAdapter$FeedsItemVH$2$1
  implements Runnable
{
  public QQGamePubFeedsAdapter$FeedsItemVH$2$1(apwk paramapwk, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 5))
    {
      apwh.a(this.jdField_a_of_type_Apwk.a).setVisibility(8);
      this.jdField_a_of_type_Apwk.a.a.setVisibility(4);
      this.jdField_a_of_type_Apwk.a.b.setVisibility(4);
      this.jdField_a_of_type_Apwk.a.c.setVisibility(4);
    }
    while (apwh.a(this.jdField_a_of_type_Apwk.a).type == 1) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.adapter.QQGamePubFeedsAdapter.FeedsItemVH.2.1
 * JD-Core Version:    0.7.0.1
 */