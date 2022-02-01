package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.text.Editable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.comment.publisher.qq.bridge.QQPublishCommentBridge;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import org.json.JSONObject;

public class QQPublishCommentBridgeImpl
  implements QQPublishCommentBridge
{
  private final CommentArgumentModel a;
  
  public QQPublishCommentBridgeImpl(CommentArgumentModel paramCommentArgumentModel)
  {
    this.a = paramCommentArgumentModel;
  }
  
  public JSONObject buildArticleBiuCommentInfo(Editable paramEditable)
  {
    return new QQPublishCommentBridgeImpl.BiuCommentHelper(this, null).a(paramEditable);
  }
  
  public TkdQQArgument getArgument()
  {
    return this.a.a;
  }
  
  public String getCommentString(Editable paramEditable)
  {
    if ((paramEditable != null) && (paramEditable.length() > 0)) {
      paramEditable = ReadInJoyCommentUtils.a(paramEditable.toString(), true);
    } else {
      paramEditable = "";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCommentString result=");
      localStringBuilder.append(paramEditable);
      QLog.d("QQPublishBridgeImpl", 2, localStringBuilder.toString());
    }
    return paramEditable;
  }
  
  public boolean isNetworkAvailable()
  {
    return NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getApplication());
  }
  
  public void showToast(String paramString, int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getApplication(), paramInt2, paramString, paramInt1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQPublishCommentBridgeImpl
 * JD-Core Version:    0.7.0.1
 */