import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager.1;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.CardJumpInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.KeyInfo;
import tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.RspBody;

public class ovb
  implements ove
{
  private ovc jdField_a_of_type_Ovc;
  private ovd jdField_a_of_type_Ovd;
  
  public ovb()
  {
    Object localObject = pha.a();
    if (localObject != null)
    {
      localObject = (pmm)((QQAppInterface)localObject).getManager(163);
      if (localObject != null)
      {
        this.jdField_a_of_type_Ovd = ((pmm)localObject).a().a();
        if (this.jdField_a_of_type_Ovd != null) {
          this.jdField_a_of_type_Ovd.a(this);
        }
        QLog.d("RIJBiuAndCommentMixDataManager", 1, "RIJBiuAndCommentMixDataManager init");
      }
    }
  }
  
  private ovf a(oidb_cmd0xe16.RspBody paramRspBody, int paramInt, ToServiceMsg paramToServiceMsg)
  {
    ovf localovf = new ovf();
    localovf.a(paramInt);
    if (paramRspBody.msg_key_info.has())
    {
      if (paramRspBody.msg_key_info.uint64_feeds_id.has()) {
        localovf.b(String.valueOf(paramRspBody.msg_key_info.uint64_feeds_id.get()));
      }
      if (paramRspBody.msg_key_info.uint32_feeds_type.has()) {
        localovf.b(paramRspBody.msg_key_info.uint32_feeds_type.get());
      }
      if ((!paramRspBody.msg_key_info.str_sub_comment_id.has()) || (TextUtils.isEmpty(paramRspBody.msg_key_info.str_sub_comment_id.get()))) {
        break label455;
      }
      localovf.a(paramRspBody.msg_key_info.str_sub_comment_id.get());
    }
    for (;;)
    {
      if (paramRspBody.msg_card_jump_info.has())
      {
        if ((paramRspBody.msg_card_jump_info.bytes_card_jump_url.has()) && (!TextUtils.isEmpty(paramRspBody.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8()))) {
          localovf.h(paramRspBody.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8());
        }
        if ((paramRspBody.msg_card_jump_info.bytes_comment_btn_url.has()) && (!TextUtils.isEmpty(paramRspBody.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8()))) {
          localovf.i(paramRspBody.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8());
        }
        if (paramRspBody.msg_card_jump_info.uint32_available.has()) {
          localovf.e(paramRspBody.msg_card_jump_info.uint32_available.get());
        }
        if (paramRspBody.msg_card_jump_info.bytes_share_url.has()) {
          localovf.c(paramRspBody.msg_card_jump_info.bytes_share_url.get().toStringUtf8());
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes() != null))
      {
        paramRspBody = (RIJBiuAndCommentRequestData)paramToServiceMsg.getAttributes().get("request_data_entry");
        if (paramRspBody != null)
        {
          localovf.d(paramRspBody.getContentString());
          localovf.d(paramRspBody.getListShowType());
          localovf.c(paramRspBody.getCommentType());
          localovf.e(paramRspBody.getReplyCommentId());
          localovf.f(paramRspBody.getReplyParentCommentId());
          localovf.g(paramRspBody.getReplyUin());
          localovf.a(paramRspBody.isIsSecondReply());
          localovf.f(paramRspBody.getContentSrc());
        }
        paramRspBody = paramToServiceMsg.getAttributes().get("article_attributes");
        if ((paramRspBody instanceof ArticleInfo)) {
          localovf.a((ArticleInfo)paramRspBody);
        }
      }
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend RIJBiuAndCommentRespData info is" + localovf.toString());
      return localovf;
      label455:
      if ((paramRspBody.msg_key_info.str_comment_id.has()) && (!TextUtils.isEmpty(paramRspBody.msg_key_info.str_comment_id.get()))) {
        localovf.a(paramRspBody.msg_key_info.str_comment_id.get());
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, String paramString3, String paramString4, ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "createLocalComment article info is null");
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("comment", paramString1);
      localJSONObject.put("commentId", paramString3);
      localJSONObject.put("isSecondReply", paramBoolean);
      localJSONObject.put("replyUin", paramString4);
      paramString1 = pbe.a(paramArticleInfo);
      if (paramString1 != null) {
        paramString1.a(paramString1.a(paramInt1, localJSONObject.toString()), paramString2, paramInt2);
      }
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private void a(ovf paramovf)
  {
    if ((paramovf == null) || (paramovf.a() == null))
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 2, "reportMixCommentBiuResult | respData or mArticleInfo is null");
      return;
    }
    ArticleInfo localArticleInfo = paramovf.a();
    paramovf = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject).put("article_id", localArticleInfo.mArticleID);
      ((JSONObject)localObject).put("content_type", 1);
      ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
      localObject = ((JSONObject)localObject).toString();
      paramovf = (ovf)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("RIJBiuAndCommentMixDataManager", 2, localJSONException.getMessage());
      }
    }
    oat.a(null, paa.a(localArticleInfo), "0X800AC6A", "0X800AC6A", 0, 0, String.valueOf(localArticleInfo.mArticleID), "", localArticleInfo.innerUniqueID, paramovf, false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ovd.a();
    this.jdField_a_of_type_Ovd = null;
    this.jdField_a_of_type_Ovc = null;
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "onDestroy clear info");
  }
  
  public void a(ArticleInfo paramArticleInfo, RIJBiuAndCommentRequestData paramRIJBiuAndCommentRequestData)
  {
    if ((paramArticleInfo == null) || (paramRIJBiuAndCommentRequestData == null)) {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "requestCreateBiuAndCommentMixComment someThing is null");
    }
    while (this.jdField_a_of_type_Ovd == null) {
      return;
    }
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "requestCreateBiuAndCommentMixComment goTo pbRequest");
    this.jdField_a_of_type_Ovd.a(paramArticleInfo, paramRIJBiuAndCommentRequestData);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xe16.RspBody localRspBody = new oidb_cmd0xe16.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = a(localRspBody, i, paramToServiceMsg);
    ThreadManager.getUIHandler().post(new RIJBiuAndCommentMixDataManager.1(this, paramToServiceMsg, i));
    if (i == 0) {
      a(paramToServiceMsg);
    }
  }
  
  public void a(ovc paramovc)
  {
    this.jdField_a_of_type_Ovc = paramovc;
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "setBiuAndCommentListener");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovb
 * JD-Core Version:    0.7.0.1
 */