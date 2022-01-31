import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class ojx
{
  private static final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private ohe jdField_a_of_type_Ohe;
  
  public ojx()
  {
    if (BaseActivity.sTopActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseActivity.sTopActivity.getAppInterface());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = onk.a();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (ohi.a(BaseApplicationImpl.getContext(), paramString1))
    {
      QLog.d("ReadInJoyCommentSSOModule", 1, "the comment copy  is start request");
      paramString1 = onk.a();
      if (paramString1 != null)
      {
        paramString1 = (oso)paramString1.getManager(163);
        if (paramString1 != null)
        {
          paramString1 = paramString1.a().a();
          if (paramString1 != null) {
            paramString1.a(paramString2, paramString3, paramString4, paramString5);
          }
        }
      }
    }
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3)
  {
    return a(paramString1, paramString2, paramInt1, paramInt2, paramString3, false, paramString4, paramInt3);
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, boolean paramBoolean, String paramString4, int paramInt3)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Ohe == null)) {
      return -1L;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString1);
      String str1 = new String(bbca.decode(localJSONObject.getString("comment"), 0));
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("article_id", paramString2);
      ((JSONObject)localObject1).put("comment_val", str1);
      ((JSONObject)localObject1).put("type", paramInt2);
      ((JSONObject)localObject1).put("native_version", bbct.a(BaseApplicationImpl.getContext()));
      ((JSONObject)localObject1).put("os", 1);
      if (paramInt2 == 2)
      {
        ((JSONObject)localObject1).put("comment_id", paramString3);
        localObject2 = localJSONObject.optString("commentUin");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((JSONObject)localObject1).put("to_uin", Long.parseLong((String)localObject2));
        }
        if (localJSONObject.optBoolean("isSecondReply", false))
        {
          localObject2 = localJSONObject.optString("replyUin");
          String str2 = localJSONObject.optString("commentId");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            ((JSONObject)localObject1).put("to", localObject2);
          }
          if (!TextUtils.isEmpty(str2)) {
            ((JSONObject)localObject1).put("to_sub_id", str2);
          }
        }
      }
      ((JSONObject)localObject1).put("src", 20);
      ((JSONObject)localObject1).put("uuid", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject1).put("content_src", paramInt1);
      Object localObject2 = ((JSONObject)localObject1).toString();
      long l = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
      QLog.d("ReadInJoyCommentSSOModule", 2, "createComment cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_create seq : " + l + " info:" + (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new WebSsoBody.WebSsoRequestBody();
        ((WebSsoBody.WebSsoRequestBody)localObject1).data.set((String)localObject2);
        localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), nou.class);
        ((NewIntent)localObject2).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_create");
        ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
        ((NewIntent)localObject2).setObserver(new oka(this, paramBoolean, l, paramInt2, paramString1, paramInt3, System.currentTimeMillis(), str1, paramString4, paramString2, paramString3, localJSONObject.optString("commentId")));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
        return l;
      }
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      return -1L;
    }
    return -1L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ohe = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramBaseCommentData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Ohe == null)) {
      return;
    }
    label400:
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = new JSONObject();
        if (!(paramBaseCommentData instanceof CommentData)) {
          break label353;
        }
        ((JSONObject)localObject).put("type", 1);
        ((JSONObject)localObject).put("comment_id", paramBaseCommentData.commentId);
        ((JSONObject)localObject).put("article_id", paramString);
        ((JSONObject)localObject).put("like", paramInt2);
        ((JSONObject)localObject).put("oper_type", paramInt1);
        ((JSONObject)localObject).put("native_version", bbct.a(BaseApplicationImpl.getContext()));
        if (!paramBaseCommentData.isActivity()) {
          break label400;
        }
        i = 400;
        ((JSONObject)localObject).put("src", i);
        ((JSONObject)localObject).put("uuid", this.jdField_a_of_type_JavaLangString);
        ((JSONObject)localObject).put("to_uin", Long.parseLong(paramBaseCommentData.uin));
        ((JSONObject)localObject).put("content_src", paramInt3);
        localObject = ((JSONObject)localObject).toString();
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like info:" + (String)localObject);
        }
        paramString = new WebSsoBody.WebSsoRequestBody();
        paramString.data.set((String)localObject);
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), nou.class);
        ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like");
        ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
        ((NewIntent)localObject).setObserver(new ojz(this, paramBaseCommentData, paramInt1, paramInt2));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
        return;
      }
      catch (Exception paramString)
      {
        if (this.jdField_a_of_type_Ohe != null) {
          this.jdField_a_of_type_Ohe.a(false, paramBaseCommentData.commentId, paramInt1, paramInt2);
        }
        paramString.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike error info:" + paramString.getLocalizedMessage());
      return;
      label353:
      if ((paramBaseCommentData instanceof SubCommentData))
      {
        ((JSONObject)localObject).put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
        ((JSONObject)localObject).put("sub_id", paramBaseCommentData.commentId);
        ((JSONObject)localObject).put("type", 2);
        continue;
        i = 20;
      }
    }
  }
  
  public void a(BaseCommentData paramBaseCommentData, String paramString, int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      if (this.jdField_a_of_type_Ohe == null) {
        return;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", paramBaseCommentData.getCommentLevel());
      if (!(paramBaseCommentData instanceof CommentData)) {
        break label298;
      }
      ((JSONObject)localObject).put("comment_id", paramBaseCommentData.commentId);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        if (this.jdField_a_of_type_Ohe != null) {
          this.jdField_a_of_type_Ohe.a(false, paramBaseCommentData);
        }
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyCommentSSOModule", 2, "createComment error info:" + paramString.getLocalizedMessage());
        return;
        label298:
        if ((paramBaseCommentData instanceof SubCommentData))
        {
          ((JSONObject)localObject).put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
          ((JSONObject)localObject).put("sub_id", paramBaseCommentData.commentId);
        }
      }
    }
    ((JSONObject)localObject).put("article_id", paramString);
    ((JSONObject)localObject).put("native_version", bbct.a(BaseApplicationImpl.getContext()));
    ((JSONObject)localObject).put("src", 20);
    ((JSONObject)localObject).put("uuid", this.jdField_a_of_type_JavaLangString);
    ((JSONObject)localObject).put("content_src", paramInt);
    localObject = ((JSONObject)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyCommentSSOModule", 2, "deleteComment cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete info:" + (String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString = new WebSsoBody.WebSsoRequestBody();
      paramString.data.set((String)localObject);
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), nou.class);
      ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete");
      ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
      ((NewIntent)localObject).setObserver(new ojy(this, paramBaseCommentData));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
  }
  
  public void a(BaseCommentData paramBaseCommentData, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramBaseCommentData == null) || (this.jdField_a_of_type_Ohe == null))
    {
      QLog.d("ReadInJoyCommentSSOModule", 2, "commentReport failed, something is null.");
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("article_id", paramString1);
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "";
        }
        localJSONObject.put("reason", paramString1);
        localJSONObject.put("content_type", paramInt2);
        localJSONObject.put("report_type", paramInt1);
        if ((paramBaseCommentData instanceof CommentData))
        {
          paramInt1 = 1;
          localJSONObject.put("comment_type", paramInt1);
          if (paramInt1 != 2) {
            break label312;
          }
          localJSONObject.put("sub_id", paramBaseCommentData.commentId);
          localJSONObject.put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
          localJSONObject.put("reported_uin", paramBaseCommentData.uin);
          localJSONObject.put("report_uin", onk.a());
          localJSONObject.put("content", paramBaseCommentData.commentContent);
          paramString2 = localJSONObject.toString();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyCommentSSOModule", 2, new Object[] { "commentReport cmd:MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_report info: ", paramString2 });
          }
          if (TextUtils.isEmpty(paramString2)) {
            break;
          }
          paramString1 = new WebSsoBody.WebSsoRequestBody();
          paramString1.data.set(paramString2);
          paramString2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), nou.class);
          paramString2.putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_report");
          paramString2.putExtra("data", paramString1.toByteArray());
          paramString2.setObserver(new okb(this, paramBaseCommentData));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
          return;
        }
      }
      catch (JSONException paramBaseCommentData)
      {
        QLog.d("ReadInJoyCommentSSOModule", 2, "commentReport error.");
        paramBaseCommentData.printStackTrace();
        return;
      }
      paramInt1 = 2;
      continue;
      label312:
      if (paramInt1 == 1) {
        localJSONObject.put("comment_id", paramBaseCommentData.commentId);
      }
    }
  }
  
  public void a(ohe paramohe)
  {
    this.jdField_a_of_type_Ohe = paramohe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ojx
 * JD-Core Version:    0.7.0.1
 */