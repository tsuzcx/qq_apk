package com.tencent.mobileqq.gamecenter.adapter;

import android.widget.TextView;
import atwj;
import atwm;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

public class QQGamePubFeedsAdapter$FeedsItemVH$2$1
  implements Runnable
{
  public QQGamePubFeedsAdapter$FeedsItemVH$2$1(atwm paramatwm, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 5))
    {
      atwj.a(this.jdField_a_of_type_Atwm.a).setVisibility(8);
      this.jdField_a_of_type_Atwm.a.a.setVisibility(4);
      this.jdField_a_of_type_Atwm.a.b.setVisibility(4);
      this.jdField_a_of_type_Atwm.a.c.setVisibility(4);
    }
    while (atwj.a(this.jdField_a_of_type_Atwm.a).type == 1) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.adapter.QQGamePubFeedsAdapter.FeedsItemVH.2.1
 * JD-Core Version:    0.7.0.1
 */