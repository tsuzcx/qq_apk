package com.tencent.mobileqq.comment.danmaku.view;

import android.graphics.Bitmap;
import com.tencent.mobileqq.armap.FaceObserver;
import com.tencent.mobileqq.danmaku.data.ViewDanmaku;
import com.tencent.mobileqq.widget.RoundImageView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class CommentDanmakuRender$1
  implements FaceObserver
{
  CommentDanmakuRender$1(CommentDanmakuRender paramCommentDanmakuRender) {}
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString2 = (List)CommentDanmakuRender.a(this.a).get(paramString1);
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      paramString2 = paramString2.iterator();
      while (paramString2.hasNext())
      {
        CommentDanmakuRender.HeadRequestInfo localHeadRequestInfo = (CommentDanmakuRender.HeadRequestInfo)paramString2.next();
        if ((localHeadRequestInfo != null) && (localHeadRequestInfo.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView != null) && (localHeadRequestInfo.jdField_a_of_type_ComTencentMobileqqDanmakuDataViewDanmaku != null))
        {
          localHeadRequestInfo.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageBitmap(paramBitmap);
          localHeadRequestInfo.jdField_a_of_type_ComTencentMobileqqDanmakuDataViewDanmaku.c(true);
        }
      }
    }
    CommentDanmakuRender.a(this.a).remove(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.danmaku.view.CommentDanmakuRender.1
 * JD-Core Version:    0.7.0.1
 */