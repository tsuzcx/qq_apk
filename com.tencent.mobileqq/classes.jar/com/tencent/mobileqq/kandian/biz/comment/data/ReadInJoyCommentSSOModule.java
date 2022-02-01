package com.tencent.mobileqq.kandian.biz.comment.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentHelper;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentObserver;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class ReadInJoyCommentSSOModule
{
  private static final AtomicLong a = new AtomicLong(0L);
  private ReadInJoyCommentObserver b = null;
  private String c = "";
  
  public ReadInJoyCommentSSOModule()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("");
    this.c = localStringBuilder.toString();
  }
  
  private QQAppInterface b()
  {
    if (BaseActivity.sTopActivity != null) {
      return (QQAppInterface)BaseActivity.sTopActivity.getAppInterface();
    }
    return RIJQQAppInterfaceUtil.a();
  }
  
  public void a()
  {
    this.b = null;
  }
  
  public void a(ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    this.b = paramReadInJoyCommentObserver;
  }
  
  public void a(BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    Object localObject1 = b();
    if ((paramBaseCommentData != null) && (localObject1 != null)) {
      if (this.b == null) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject();
        boolean bool = paramBaseCommentData instanceof CommentData;
        if (bool)
        {
          ((JSONObject)localObject2).put("type", 1);
          ((JSONObject)localObject2).put("comment_id", paramBaseCommentData.commentId);
        }
        else if ((paramBaseCommentData instanceof SubCommentData))
        {
          ((JSONObject)localObject2).put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
          ((JSONObject)localObject2).put("sub_id", paramBaseCommentData.commentId);
          ((JSONObject)localObject2).put("type", 2);
        }
        ((JSONObject)localObject2).put("article_id", paramString);
        ((JSONObject)localObject2).put("like", paramInt2);
        ((JSONObject)localObject2).put("oper_type", paramInt1);
        ((JSONObject)localObject2).put("native_version", DeviceInfoUtil.a(BaseApplicationImpl.getContext()));
        if (!paramBaseCommentData.isActivity()) {
          break label430;
        }
        i = 400;
        ((JSONObject)localObject2).put("src", i);
        ((JSONObject)localObject2).put("uuid", this.c);
        ((JSONObject)localObject2).put("to_uin", Long.parseLong(paramBaseCommentData.uin));
        ((JSONObject)localObject2).put("content_src", ReadInJoyCommentHelper.a(paramInt3));
        paramString = ((JSONObject)localObject2).toString();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("commentLike cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like info:");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("ReadInJoyCommentSSOModule", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new WebSsoBody.WebSsoRequestBody();
        ((WebSsoBody.WebSsoRequestBody)localObject2).data.set(paramString);
        paramString = new NewIntent(((AppInterface)localObject1).getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
        paramString.putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like");
        paramString.putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject2).toByteArray());
        paramString.setObserver(new ReadInJoyCommentSSOModule.2(this, paramBaseCommentData, paramInt1, paramInt2));
        ((AppInterface)localObject1).startServlet(paramString);
        return;
      }
      catch (Exception paramString)
      {
        localObject1 = this.b;
        if (localObject1 != null) {
          ((ReadInJoyCommentObserver)localObject1).a(false, paramBaseCommentData, paramInt1, paramInt2);
        }
        paramString.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramBaseCommentData = new StringBuilder();
          paramBaseCommentData.append("commentLike error info:");
          paramBaseCommentData.append(paramString.getLocalizedMessage());
          QLog.d("ReadInJoyCommentSSOModule", 2, paramBaseCommentData.toString());
        }
      }
      return;
      label430:
      int i = 20;
    }
  }
  
  public void a(BaseCommentData paramBaseCommentData, String paramString, int paramInt)
  {
    try
    {
      localObject1 = b();
      if (localObject1 != null)
      {
        if (this.b == null) {
          return;
        }
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("type", paramBaseCommentData.getCommentLevel());
        boolean bool = paramBaseCommentData instanceof CommentData;
        if (bool)
        {
          ((JSONObject)localObject2).put("comment_id", paramBaseCommentData.commentId);
        }
        else if ((paramBaseCommentData instanceof SubCommentData))
        {
          ((JSONObject)localObject2).put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
          ((JSONObject)localObject2).put("sub_id", paramBaseCommentData.commentId);
        }
        ((JSONObject)localObject2).put("article_id", paramString);
        ((JSONObject)localObject2).put("native_version", DeviceInfoUtil.a(BaseApplicationImpl.getContext()));
        ((JSONObject)localObject2).put("src", 20);
        ((JSONObject)localObject2).put("uuid", this.c);
        ((JSONObject)localObject2).put("content_src", ReadInJoyCommentHelper.a(paramInt));
        paramString = ((JSONObject)localObject2).toString();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("deleteComment cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete info:");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("ReadInJoyCommentSSOModule", 2, ((StringBuilder)localObject2).toString());
        }
        if (!TextUtils.isEmpty(paramString))
        {
          localObject2 = new WebSsoBody.WebSsoRequestBody();
          ((WebSsoBody.WebSsoRequestBody)localObject2).data.set(paramString);
          paramString = new NewIntent(((AppInterface)localObject1).getApplication(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
          paramString.putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete");
          paramString.putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject2).toByteArray());
          paramString.setObserver(new ReadInJoyCommentSSOModule.1(this, paramBaseCommentData));
          ((AppInterface)localObject1).startServlet(paramString);
        }
      }
      else {}
    }
    catch (Exception paramString)
    {
      Object localObject1 = this.b;
      if (localObject1 != null) {
        ((ReadInJoyCommentObserver)localObject1).a(false, paramBaseCommentData, "");
      }
      paramString.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramBaseCommentData = new StringBuilder();
        paramBaseCommentData.append("createComment error info:");
        paramBaseCommentData.append(paramString.getLocalizedMessage());
        QLog.d("ReadInJoyCommentSSOModule", 2, paramBaseCommentData.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentSSOModule
 * JD-Core Version:    0.7.0.1
 */