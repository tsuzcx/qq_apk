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
    EmojiFragment.TempListItem.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TempListItem).setImageDrawable(null);
    EmojiFragment.TempListItem.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TempListItem).setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TempListItem.getResources().getDrawable(R.drawable.x));
    EmojiFragment.TempListItem.b(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TempListItem).setVisibility(8);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    EmojiFragment.TempListItem.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TempListItem).setBackgroundDrawable(null);
    EmojiFragment.TempListItem.b(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TempListItem).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TempListItem.a.a(paramURLDrawable, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateInfo.a, this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TemplateInfo.b, EmojiFragment.TempListItem.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplEmojiFragment$TempListItem));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment.TempListItem.2
 * JD-Core Version:    0.7.0.1
 */