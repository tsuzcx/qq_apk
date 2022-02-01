package com.tencent.mobileqq.matchchat;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;

class MatchChatMsgListFragment$4
  implements DecodeTaskCompletionListener
{
  MatchChatMsgListFragment$4(MatchChatMsgListFragment paramMatchChatMsgListFragment, String paramString, ImageView paramImageView) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString))
    {
      paramString = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqMatchchatMatchChatMsgListFragment.getResources(), paramBitmap);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.4
 * JD-Core Version:    0.7.0.1
 */