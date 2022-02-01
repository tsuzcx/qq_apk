package com.tencent.mobileqq.gamecenter.adapter;

import android.widget.TextView;
import avbk;
import avbn;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

public class QQGamePubFeedsAdapter$FeedsItemVH$2$1
  implements Runnable
{
  public QQGamePubFeedsAdapter$FeedsItemVH$2$1(avbn paramavbn, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 5))
    {
      avbk.a(this.jdField_a_of_type_Avbn.a).setVisibility(8);
      this.jdField_a_of_type_Avbn.a.a.setVisibility(4);
      this.jdField_a_of_type_Avbn.a.b.setVisibility(4);
      this.jdField_a_of_type_Avbn.a.c.setVisibility(4);
    }
    while (avbk.a(this.jdField_a_of_type_Avbn.a).type == 1) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.adapter.QQGamePubFeedsAdapter.FeedsItemVH.2.1
 * JD-Core Version:    0.7.0.1
 */