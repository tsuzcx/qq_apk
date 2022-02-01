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

public class ooz
  implements opc
{
  private opa jdField_a_of_type_Opa;
  private opb jdField_a_of_type_Opb;
  
  public ooz()
  {
    Object localObject = pay.a();
    if (localObject != null)
    {
      localObject = (pks)((QQAppInterface)localObject).getManager(163);
      if (localObject != null)
      {
        this.jdField_a_of_type_Opb = ((pks)localObject).a().a();
        if (this.jdField_a_of_type_Opb != null) {
          this.jdField_a_of_type_Opb.a(this);
        }
        QLog.d("RIJBiuAndCommentMixDataManager", 1, "RIJBiuAndCommentMixDataManager init");
      }
    }
  }
  
  private opd a(oidb_cmd0xe16.RspBody paramRspBody, int paramInt, ToServiceMsg paramToServiceMsg)
  {
    opd localopd = new opd();
    localopd.a(paramInt);
    if (paramRspBody.msg_key_info.has())
    {
      if (paramRspBody.msg_key_info.uint64_feeds_id.has()) {
        localopd.b(String.valueOf(paramRspBody.msg_key_info.uint64_feeds_id.get()));
      }
      if (paramRspBody.msg_key_info.uint32_feeds_type.has()) {
        localopd.b(paramRspBody.msg_key_info.uint32_feeds_type.get());
      }
      if ((!paramRspBody.msg_key_info.str_sub_comment_id.has()) || (TextUtils.isEmpty(paramRspBody.msg_key_info.str_sub_comment_id.get()))) {
        break label455;
      }
      localopd.a(paramRspBody.msg_key_info.str_sub_comment_id.get());
    }
    for (;;)
    {
      if (paramRspBody.msg_card_jump_info.has())
      {
        if ((paramRspBody.msg_card_jump_info.bytes_card_jump_url.has()) && (!TextUtils.isEmpty(paramRspBody.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8()))) {
          localopd.h(paramRspBody.msg_card_jump_info.bytes_card_jump_url.get().toStringUtf8());
        }
        if ((paramRspBody.msg_card_jump_info.bytes_comment_btn_url.has()) && (!TextUtils.isEmpty(paramRspBody.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8()))) {
          localopd.i(paramRspBody.msg_card_jump_info.bytes_comment_btn_url.get().toStringUtf8());
        }
        if (paramRspBody.msg_card_jump_info.uint32_available.has()) {
          localopd.e(paramRspBody.msg_card_jump_info.uint32_available.get());
        }
        if (paramRspBody.msg_card_jump_info.bytes_share_url.has()) {
          localopd.c(paramRspBody.msg_card_jump_info.bytes_share_url.get().toStringUtf8());
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttributes() != null))
      {
        paramRspBody = (RIJBiuAndCommentRequestData)paramToServiceMsg.getAttributes().get("request_data_entry");
        if (paramRspBody != null)
        {
          localopd.d(paramRspBody.getContentString());
          localopd.d(paramRspBody.getListShowType());
          localopd.c(paramRspBody.getCommentType());
          localopd.e(paramRspBody.getReplyCommentId());
          localopd.f(paramRspBody.getReplyParentCommentId());
          localopd.g(paramRspBody.getReplyUin());
          localopd.a(paramRspBody.isIsSecondReply());
          localopd.f(paramRspBody.getContentSrc());
        }
        paramRspBody = paramToServiceMsg.getAttributes().get("article_attributes");
        if ((paramRspBody instanceof ArticleInfo)) {
          localopd.a((ArticleInfo)paramRspBody);
        }
      }
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "onBiuAndCommentMixSend RIJBiuAndCommentRespData info is" + localopd.toString());
      return localopd;
      label455:
      if ((paramRspBody.msg_key_info.str_comment_id.has()) && (!TextUtils.isEmpty(paramRspBody.msg_key_info.str_comment_id.get()))) {
        localopd.a(paramRspBody.msg_key_info.str_comment_id.get());
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
      paramString1 = ouu.a(paramArticleInfo);
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
  
  private void a(opd paramopd)
  {
    if ((paramopd == null) || (paramopd.a() == null))
    {
      QLog.d("RIJBiuAndCommentMixDataManager", 2, "reportMixCommentBiuResult | respData or mArticleInfo is null");
      return;
    }
    ArticleInfo localArticleInfo = paramopd.a();
    paramopd = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("rowkey", localArticleInfo.innerUniqueID);
      ((JSONObject)localObject).put("article_id", localArticleInfo.mArticleID);
      ((JSONObject)localObject).put("content_type", 1);
      ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
      localObject = ((JSONObject)localObject).toString();
      paramopd = (opd)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("RIJBiuAndCommentMixDataManager", 2, localJSONException.getMessage());
      }
    }
    odq.a(null, oto.a(localArticleInfo), "0X800AC6A", "0X800AC6A", 0, 0, String.valueOf(localArticleInfo.mArticleID), "", localArticleInfo.innerUniqueID, paramopd, false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Opb.a();
    this.jdField_a_of_type_Opb = null;
    this.jdField_a_of_type_Opa = null;
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "onDestroy clear info");
  }
  
  public void a(ArticleInfo paramArticleInfo, RIJBiuAndCommentRequestData paramRIJBiuAndCommentRequestData)
  {
    if ((paramArticleInfo == null) || (paramRIJBiuAndCommentRequestData == null)) {
      QLog.d("RIJBiuAndCommentMixDataManager", 1, "requestCreateBiuAndCommentMixComment someThing is null");
    }
    while (this.jdField_a_of_type_Opb == null) {
      return;
    }
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "requestCreateBiuAndCommentMixComment goTo pbRequest");
    this.jdField_a_of_type_Opb.a(paramArticleInfo, paramRIJBiuAndCommentRequestData);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xe16.RspBody localRspBody = new oidb_cmd0xe16.RspBody();
    int i = qlk.a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = a(localRspBody, i, paramToServiceMsg);
    ThreadManager.getUIHandler().post(new RIJBiuAndCommentMixDataManager.1(this, paramToServiceMsg, i));
    if (i == 0) {
      a(paramToServiceMsg);
    }
  }
  
  public void a(opa paramopa)
  {
    this.jdField_a_of_type_Opa = paramopa;
    QLog.d("RIJBiuAndCommentMixDataManager", 1, "setBiuAndCommentListener");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ooz
 * JD-Core Version:    0.7.0.1
 */