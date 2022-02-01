package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity;

class DrawHbFragment$5
  implements View.OnClickListener
{
  DrawHbFragment$5(DrawHbFragment paramDrawHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      DrawHbFragment.a(this.a).setText(((TextView)paramView).getText().toString());
      DrawHbFragment.b(this.a).addHbUploadData("draw.wrappacket.choose");
      this.a.c.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawHbFragment.5
 * JD-Core Version:    0.7.0.1
 */