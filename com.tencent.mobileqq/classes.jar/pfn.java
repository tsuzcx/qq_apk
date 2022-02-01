import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class pfn
{
  private static final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private String jdField_a_of_type_JavaLangString = "";
  private pbm jdField_a_of_type_Pbm;
  
  private QQAppInterface a()
  {
    if (BaseActivity.sTopActivity != null) {
      return (QQAppInterface)BaseActivity.sTopActivity.getAppInterface();
    }
    return pnn.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pbm = null;
  }
  
  public void a(BaseCommentData paramBaseCommentData, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    QQAppInterface localQQAppInterface = a();
    if ((paramBaseCommentData == null) || (localQQAppInterface == null) || (this.jdField_a_of_type_Pbm == null)) {
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
        ((JSONObject)localObject).put("native_version", DeviceInfoUtil.getQQVersionWithCode(BaseApplicationImpl.getContext()));
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
        localObject = new NewIntent(localQQAppInterface.getApplication(), oln.class);
        ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like");
        ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
        ((NewIntent)localObject).setObserver(new pfp(this, paramBaseCommentData, paramInt1, paramInt2));
        localQQAppInterface.startServlet((NewIntent)localObject);
        return;
      }
      catch (Exception paramString)
      {
        if (this.jdField_a_of_type_Pbm != null) {
          this.jdField_a_of_type_Pbm.a(false, paramBaseCommentData.commentId, paramInt1, paramInt2);
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
      localQQAppInterface = a();
      if (localQQAppInterface == null) {
        return;
      }
      if (this.jdField_a_of_type_Pbm == null) {
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
        QQAppInterface localQQAppInterface;
        Object localObject;
        if (this.jdField_a_of_type_Pbm != null) {
          this.jdField_a_of_type_Pbm.a(false, paramBaseCommentData, "");
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
    ((JSONObject)localObject).put("native_version", DeviceInfoUtil.getQQVersionWithCode(BaseApplicationImpl.getContext()));
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
      localObject = new NewIntent(localQQAppInterface.getApplication(), oln.class);
      ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete");
      ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
      ((NewIntent)localObject).setObserver(new pfo(this, paramBaseCommentData));
      localQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
  }
  
  public void a(pbm parampbm)
  {
    this.jdField_a_of_type_Pbm = parampbm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfn
 * JD-Core Version:    0.7.0.1
 */