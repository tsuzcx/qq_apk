package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.Base64Util;
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

public class RIJCommentInLikeFeedCommentSubmitHandler
  extends RIJCommentInLikeFeedHandler
{
  public RIJCommentInLikeFeedCommentSubmitHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject1 = "";
      try
      {
        localObject2 = new JSONObject(paramString).getString("comment");
        localObject1 = localObject2;
        localObject2 = new String(Base64Util.decode((String)localObject2, 0));
        try
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("requestSubmitComment | commentVal ");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException1)
        {
          localObject1 = localObject2;
        }
        localObject2 = new StringBuilder();
      }
      catch (JSONException localJSONException2) {}
      ((StringBuilder)localObject2).append("request0x83eSubmitComment: ");
      ((StringBuilder)localObject2).append(localJSONException2);
      QLog.e("RIJCommentInLikeFeedCommentSubmitHandler", 2, ((StringBuilder)localObject2).toString());
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, "requestSubmitComment | commentVal is empty");
        return;
      }
      Object localObject2 = new oidb_cmd0x83e.ReqBody();
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      ((oidb_cmd0x83e.ReqBody)localObject2).uint64_uin.set(l);
      ((oidb_cmd0x83e.ReqBody)localObject2).uint32_operation.set(0);
      ((oidb_cmd0x83e.ReqBody)localObject2).bytes_comment.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      ((oidb_cmd0x83e.ReqBody)localObject2).uint32_op_new_comment_system.set(1);
      ((oidb_cmd0x83e.ReqBody)localObject2).uint64_feeds_id.set(paramAbsBaseArticleInfo.mFeedId);
      ((oidb_cmd0x83e.ReqBody)localObject2).bool_is_master.set(true);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(String.valueOf(RIJQQAppInterfaceUtil.a()));
      ((StringBuilder)localObject3).append(System.currentTimeMillis());
      localObject3 = ((StringBuilder)localObject3).toString();
      ((oidb_cmd0x83e.ReqBody)localObject2).bytes_req_seq.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestSubmitComment | reqSeq is ");
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(" | comment_content : ");
      localStringBuilder.append((String)localObject1);
      QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, localStringBuilder.toString());
      localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, ((oidb_cmd0x83e.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).addAttribute("submit_comment", Integer.valueOf(1));
      ((ToServiceMsg)localObject1).addAttribute("article_info", paramAbsBaseArticleInfo);
      ((ToServiceMsg)localObject1).addAttribute("comment_json_string", paramString);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.sendPbReqWithAutoRetry((ToServiceMsg)localObject1);
      return;
    }
    QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, "requestSubmitComment | commentJsonStr or articleinfo is null ");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handle0x83eSubmitComment | resp result code ： ");
    paramFromServiceMsg.append(i);
    QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, paramFromServiceMsg.toString());
    paramFromServiceMsg = BaseApplication.getContext().getString(2131717821);
    if (localRspBody.bytes_result_desc.has())
    {
      paramFromServiceMsg = localRspBody.bytes_result_desc.get().toStringUtf8();
      paramObject = new StringBuilder();
      paramObject.append("handle0x83eSubmitComment | resp errorMsg ： ");
      paramObject.append(paramFromServiceMsg);
      QLog.d("RIJCommentInLikeFeedCommentSubmitHandler", 2, paramObject.toString());
    }
    paramObject = (AbsBaseArticleInfo)paramToServiceMsg.getAttribute("article_info");
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("comment_json_string");
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJCommentInLikeFeedCommentSubmitHandler.1(this, i, paramObject, paramToServiceMsg, paramFromServiceMsg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedCommentSubmitHandler
 * JD-Core Version:    0.7.0.1
 */