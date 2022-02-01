package com.tencent.mobileqq.comment.danmaku.view;

import com.tencent.common.danmaku.data.ViewDanmaku;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;

class CommentDanmakuRender$2
  implements URLDrawable.URLDrawableListener
{
  CommentDanmakuRender$2(CommentDanmakuRender paramCommentDanmakuRender, RoundImageView paramRoundImageView, ViewDanmaku paramViewDanmaku, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadCanceled : ");
      paramURLDrawable.append(this.c);
      QLog.d("CommentDanmakuRender", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadFailed : ");
      paramURLDrawable.append(this.c);
      QLog.d("CommentDanmakuRender", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      this.a.setImageDrawable(paramURLDrawable);
      this.b.c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.view.CommentDanmakuRender.2
 * JD-Core Version:    0.7.0.1
 */