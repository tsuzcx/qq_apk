package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tkd.comment.publisher.qq.bridge.QQPublishCommentBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;

public class QQPublishCommentBridgeImpl
  implements QQPublishCommentBridge
{
  private final CommentArgumentModel a;
  
  public QQPublishCommentBridgeImpl(CommentArgumentModel paramCommentArgumentModel)
  {
    this.a = paramCommentArgumentModel;
  }
  
  public TkdQQArgument getArgument()
  {
    return this.a.c;
  }
  
  public boolean isNetworkAvailable()
  {
    return NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication());
  }
  
  public void showToast(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.makeText(BaseApplicationImpl.getApplication(), paramInt2, paramString, paramInt1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQPublishCommentBridgeImpl
 * JD-Core Version:    0.7.0.1
 */