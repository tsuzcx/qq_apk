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

public class ovm
{
  private static final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private osl jdField_a_of_type_Osl;
  
  public ovm()
  {
    if (BaseActivity.sTopActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseActivity.sTopActivity.getAppInterface());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ozs.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Osl = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramBaseCommentData == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Osl == null)) {
      return;
    }
    label394:
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = new JSONObject();
        if (!(paramBaseCommentData instanceof CommentData)) {
          break label348;
        }
        ((JSONObject)localObject).put("type", 1);
        ((JSONObject)localObject).put("comment_id", paramBaseCommentData.commentId);
        ((JSONObject)localObject).put("article_id", paramString);
        ((JSONObject)localObject).put("like", paramInt2);
        ((JSONObject)localObject).put("oper_type", paramInt1);
        ((JSONObject)localObject).put("native_version", bhlo.a(BaseApplicationImpl.getContext()));
        if (!paramBaseCommentData.isActivity()) {
          break label394;
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
        localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ocj.class);
        ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like");
        ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
        ((NewIntent)localObject).setObserver(new ovo(this, paramBaseCommentData, paramInt1, paramInt2));
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
        return;
      }
      catch (Exception paramString)
      {
        if (this.jdField_a_of_type_Osl != null) {
          this.jdField_a_of_type_Osl.a(false, paramBaseCommentData.commentId, paramInt1, paramInt2);
        }
        paramString.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInJoyCommentSSOModule", 2, "commentLike error info:" + paramString.getLocalizedMessage());
      return;
      label348:
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
      if (this.jdField_a_of_type_Osl == null) {
        return;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", paramBaseCommentData.getCommentLevel());
      if (!(paramBaseCommentData instanceof CommentData)) {
        break label297;
      }
      ((JSONObject)localObject).put("comment_id", paramBaseCommentData.commentId);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject;
        if (this.jdField_a_of_type_Osl != null) {
          this.jdField_a_of_type_Osl.a(false, paramBaseCommentData, "");
        }
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReadInJoyCommentSSOModule", 2, "createComment error info:" + paramString.getLocalizedMessage());
        return;
        label297:
        if ((paramBaseCommentData instanceof SubCommentData))
        {
          ((JSONObject)localObject).put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
          ((JSONObject)localObject).put("sub_id", paramBaseCommentData.commentId);
        }
      }
    }
    ((JSONObject)localObject).put("article_id", paramString);
    ((JSONObject)localObject).put("native_version", bhlo.a(BaseApplicationImpl.getContext()));
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
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ocj.class);
      ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete");
      ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
      ((NewIntent)localObject).setObserver(new ovn(this, paramBaseCommentData));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
  }
  
  public void a(BaseCommentData paramBaseCommentData, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramBaseCommentData == null)
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
            break label302;
          }
          localJSONObject.put("sub_id", paramBaseCommentData.commentId);
          localJSONObject.put("comment_id", ((SubCommentData)paramBaseCommentData).parentCommentId);
          localJSONObject.put("reported_uin", paramBaseCommentData.uin);
          localJSONObject.put("report_uin", ozs.a());
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
          paramString2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), ocj.class);
          paramString2.putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_report");
          paramString2.putExtra("data", paramString1.toByteArray());
          paramString2.setObserver(new ovp(this, paramBaseCommentData));
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
      label302:
      if (paramInt1 == 1) {
        localJSONObject.put("comment_id", paramBaseCommentData.commentId);
      }
    }
  }
  
  public void a(osl paramosl)
  {
    this.jdField_a_of_type_Osl = paramosl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovm
 * JD-Core Version:    0.7.0.1
 */