package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.widget.TextView;

class DrawRedpacketPannelPreviewFragment$9
  implements DialogInterface.OnClickListener
{
  DrawRedpacketPannelPreviewFragment$9(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DrawRedpacketPannelPreviewFragment.a(this.a, false);
    DrawRedpacketPannelPreviewFragment.i(this.a).a(false, false);
    DrawRedpacketPannelPreviewFragment.k(this.a);
    DrawRedpacketPannelPreviewFragment.m(this.a).setTextColor(Color.parseColor("#878B99"));
    DrawRedpacketPannelPreviewFragment.m(this.a).setText("......");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawRedpacketPannelPreviewFragment.9
 * JD-Core Version:    0.7.0.1
 */