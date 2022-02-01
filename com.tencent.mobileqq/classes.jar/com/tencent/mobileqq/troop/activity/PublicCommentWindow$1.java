package com.tencent.mobileqq.troop.activity;

import android.widget.ImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

class PublicCommentWindow$1
  implements Runnable
{
  PublicCommentWindow$1(PublicCommentWindow paramPublicCommentWindow) {}
  
  public void run()
  {
    PublicCommentWindow localPublicCommentWindow = this.this$0;
    localPublicCommentWindow.o = false;
    if ((localPublicCommentWindow.isShowing()) && (this.this$0.e != null))
    {
      this.this$0.e.setVisibility(0);
      this.this$0.a.setImageResource(2130849799);
      this.this$0.a.setContentDescription(this.this$0.r.getString(2131894013));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PublicCommentWindow.1
 * JD-Core Version:    0.7.0.1
 */