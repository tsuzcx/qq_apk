package com.tencent.mobileqq.kandian.biz.comment;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPicData;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

class ReadInJoyCommentComponentFragment$10
  implements Runnable
{
  ReadInJoyCommentComponentFragment$10(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, ZhituPicData paramZhituPicData) {}
  
  public void run()
  {
    Object localObject = ReadInJoyCommentComponentFragment.i(this.this$0);
    if ((localObject != null) && (ReadInJoyCommentComponentFragment.j(this.this$0)))
    {
      ((ZhituManager)localObject).o();
      ReadInJoyCommentComponentFragment.c(this.this$0, false);
    }
    localObject = null;
    try
    {
      try
      {
        URL localURL = new File(this.a.b).toURI().toURL();
        if (localURL != null) {
          localObject = URLDrawable.getDrawable(localURL, true);
        }
      }
      finally {}
    }
    catch (MalformedURLException localMalformedURLException)
    {
      label74:
      break label74;
    }
    if (localDrawable != null)
    {
      this.this$0.c.setImageDrawable(localDrawable);
      this.this$0.a.setVisibility(0);
    }
    this.this$0.f.setText("");
    ReadInJoyCommentComponentFragment.g(this.this$0);
    if (this.this$0.D)
    {
      ReadInJoyCommentComponentFragment.b(this.this$0, true);
      this.this$0.n.setImageResource(2130843903);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.10
 * JD-Core Version:    0.7.0.1
 */