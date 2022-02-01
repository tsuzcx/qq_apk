package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.qqpay.ui.R.drawable;

class EmojiFragment$TempListItem$2
  implements URLDrawable.URLDrawableListener
{
  EmojiFragment$TempListItem$2(EmojiFragment.TempListItem paramTempListItem, EmojiFragment.TemplateInfo paramTemplateInfo) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    EmojiFragment.TempListItem.a(this.b).setImageDrawable(null);
    EmojiFragment.TempListItem.b(this.b).setBackgroundDrawable(this.b.getResources().getDrawable(R.drawable.x));
    EmojiFragment.TempListItem.c(this.b).setVisibility(8);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    EmojiFragment.TempListItem.b(this.b).setBackgroundDrawable(null);
    EmojiFragment.TempListItem.c(this.b).setVisibility(0);
    this.b.a.a(paramURLDrawable, this.a.g, this.a.b, EmojiFragment.TempListItem.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment.TempListItem.2
 * JD-Core Version:    0.7.0.1
 */