package com.tencent.mobileqq.matchchat;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;

class MatchChatMsgListFragment$3
  implements DecodeTaskCompletionListener
{
  MatchChatMsgListFragment$3(MatchChatMsgListFragment paramMatchChatMsgListFragment, String paramString, ImageView paramImageView) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (TextUtils.equals(this.a, paramString))
    {
      paramString = new BitmapDrawable(this.c.getResources(), paramBitmap);
      this.b.setImageDrawable(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatMsgListFragment.3
 * JD-Core Version:    0.7.0.1
 */