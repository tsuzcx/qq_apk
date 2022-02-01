package com.tencent.mobileqq.kandian.biz.message;

import android.view.View;
import android.view.View.OnClickListener;

class ReadinjoySocialMsgCard$1
  implements View.OnClickListener
{
  ReadinjoySocialMsgCard$1(ReadinjoySocialMsgCard paramReadinjoySocialMsgCard) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySocialMsgCard.a(true, -1, ReadinjoySocialMsgCard.a(this.a));
    if (ReadinjoySocialMsgCard.b(this.a) != null) {
      ReadinjoySocialMsgCard.b(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.ReadinjoySocialMsgCard.1
 * JD-Core Version:    0.7.0.1
 */