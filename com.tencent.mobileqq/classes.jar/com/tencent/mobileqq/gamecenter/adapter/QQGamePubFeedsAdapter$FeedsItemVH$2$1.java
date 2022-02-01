package com.tencent.mobileqq.gamecenter.adapter;

import android.widget.TextView;
import avjd;
import avjg;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

public class QQGamePubFeedsAdapter$FeedsItemVH$2$1
  implements Runnable
{
  public QQGamePubFeedsAdapter$FeedsItemVH$2$1(avjg paramavjg, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 5))
    {
      avjd.a(this.jdField_a_of_type_Avjg.a).setVisibility(8);
      this.jdField_a_of_type_Avjg.a.a.setVisibility(4);
      this.jdField_a_of_type_Avjg.a.b.setVisibility(4);
      this.jdField_a_of_type_Avjg.a.c.setVisibility(4);
    }
    while (avjd.a(this.jdField_a_of_type_Avjg.a).type == 1) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.adapter.QQGamePubFeedsAdapter.FeedsItemVH.2.1
 * JD-Core Version:    0.7.0.1
 */