import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJCommentInLikeFeedCommentSubmitHandler.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;

public class qik
  extends qil
{
  public qik(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, "requestSubmitComment | commentJsonStr or articleinfo is null ");
      return;
    }
    localObject1 = "";
    for (;;)
    {
      try
      {
        String str1 = new JSONObject(paramString).getString("comment");
        localObject1 = str1;
        str1 = new String(bhcu.decode(str1, 0));
        QLog.e("RIJCommentInLikeFeedCommentSubmitHandler", 2, "request0x83eSubmitComment: " + localJSONException1);
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, "requestSubmitComment | commentVal " + str1);
          localObject1 = str1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, "requestSubmitComment | commentVal is empty");
          return;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            long l;
            String str2;
            localObject1 = localObject2;
            Object localObject2 = localJSONException2;
          }
        }
        localJSONException1 = localJSONException1;
      }
    }
    localObject2 = new oidb_cmd0x83e.ReqBody();
    l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    ((oidb_cmd0x83e.ReqBody)localObject2).uint64_uin.set(l);
    ((oidb_cmd0x83e.ReqBody)localObject2).uint32_operation.set(0);
    ((oidb_cmd0x83e.ReqBody)localObject2).bytes_comment.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    ((oidb_cmd0x83e.ReqBody)localObject2).uint32_op_new_comment_system.set(1);
    ((oidb_cmd0x83e.ReqBody)localObject2).uint64_feeds_id.set(paramArticleInfo.mFeedId);
    ((oidb_cmd0x83e.ReqBody)localObject2).bool_is_master.set(true);
    str2 = String.valueOf(pkh.a()) + System.currentTimeMillis();
    ((oidb_cmd0x83e.ReqBody)localObject2).bytes_req_seq.set(ByteStringMicro.copyFromUtf8(str2));
    QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, "requestSubmitComment | reqSeq is " + str2 + " | comment_content : " + (String)localObject1);
    localObject1 = qxp.a("OidbSvc.0x83e", 2110, 0, ((oidb_cmd0x83e.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).addAttribute("submit_comment", Integer.valueOf(1));
    ((ToServiceMsg)localObject1).addAttribute("article_info", paramArticleInfo);
    ((ToServiceMsg)localObject1).addAttribute("comment_json_string", paramString);
    this.jdField_a_of_type_Qep.b((ToServiceMsg)localObject1);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, "handle0x83eSubmitComment | resp result code ： " + i);
    paramFromServiceMsg = BaseApplication.getContext().getString(2131717659);
    if (localRspBody.bytes_result_desc.has())
    {
      paramFromServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
      QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, "handle0x83eSubmitComment | resp errorMsg ： " + paramFromServiceMsg);
    }
    paramObject = (ArticleInfo)paramToServiceMsg.getAttribute("article_info");
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("comment_json_string");
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJCommentInLikeFeedCommentSubmitHandler.1(this, i, paramObject, paramToServiceMsg, paramFromServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qik
 * JD-Core Version:    0.7.0.1
 */