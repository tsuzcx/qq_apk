package com.tencent.mobileqq.comment.danmaku.view;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku;
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
      paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("CommentDanmakuRender", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadFailed : ");
      paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("CommentDanmakuRender", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageDrawable(paramURLDrawable);
      this.jdField_a_of_type_ComTencentMobileqqDanmakuDataViewDanmaku.c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.view.CommentDanmakuRender.2
 * JD-Core Version:    0.7.0.1
 */