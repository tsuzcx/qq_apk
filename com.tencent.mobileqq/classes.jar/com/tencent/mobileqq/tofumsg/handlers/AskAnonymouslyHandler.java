package com.tencent.mobileqq.tofumsg.handlers;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.base.config.ProfileConfig;
import com.tencent.mobileqq.tofumsg.TofuDataBaseHandler;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.Quest;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.ReqBody;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/tofumsg/handlers/AskAnonymouslyHandler;", "Lcom/tencent/mobileqq/tofumsg/TofuDataBaseHandler;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "canPullFrom", "", "pullFrom", "", "constructAskAnonymousJSONObj", "Lorg/json/JSONObject;", "rspBody", "Ltencent/im/oidb/cmd0xec4/oidb_0xec4$RspBody;", "getBusDataForReq", "", "reqItem", "Lcom/tencent/mobileqq/tofumsg/TofuItem;", "getBusDataFromRsp", "", "oldItem", "getQuestId", "jsonStr", "getTofuMsgBusId", "handleEmptyMsg", "", "tofuItem", "parsePbToStr", "tofuMsgPreferUpdateThanInsert", "msg", "Lcom/tencent/mobileqq/activity/aio/BeancurdMsg;", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class AskAnonymouslyHandler
  extends TofuDataBaseHandler
{
  public static final AskAnonymouslyHandler.Companion a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTofumsgHandlersAskAnonymouslyHandler$Companion = new AskAnonymouslyHandler.Companion(null);
  }
  
  public AskAnonymouslyHandler(@NotNull QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private final String a(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return "";
    }
    try
    {
      paramString = new JSONObject(paramString).optString("key_question_id", "");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getQuestId result: ");
        localStringBuilder.append(paramString);
        QLog.i("MessageForTofuAskAnonymously", 2, localStringBuilder.toString());
      }
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("MessageForTofuAskAnonymously", 1, "getQuestId exception: ", (Throwable)paramString);
    }
    return "";
  }
  
  private final String a(oidb_0xec4.RspBody paramRspBody)
  {
    paramRspBody = a(paramRspBody);
    if (paramRspBody != null) {
      return paramRspBody.toString();
    }
    return null;
  }
  
  private final JSONObject a(oidb_0xec4.RspBody paramRspBody)
  {
    if (!paramRspBody.has())
    {
      QLog.e("AskAnonymouslyHandler", 1, "constructAskAnonymousJSONObj error: rspBody.has() = false");
      return null;
    }
    boolean bool = paramRspBody.uint32_ret.has();
    Object localObject = "";
    if ((bool) && (paramRspBody.uint32_ret.get() == 0))
    {
      if ((paramRspBody.msg_quest.has()) && (paramRspBody.msg_quest.get().size() > 0))
      {
        localObject = new JSONObject();
        paramRspBody = (oidb_0xec4.Quest)paramRspBody.msg_quest.get().get(0);
        if (paramRspBody.has())
        {
          if (paramRspBody.str_id.has()) {
            ((JSONObject)localObject).put("key_question_id", paramRspBody.str_id.get());
          }
          if (paramRspBody.str_quest.has()) {
            ((JSONObject)localObject).put("key_question_str", paramRspBody.str_quest.get());
          }
          if (paramRspBody.uint64_quest_uin.has()) {
            ((JSONObject)localObject).put("key_question_uin", paramRspBody.uint64_quest_uin.get());
          }
          if (paramRspBody.uint64_time.has()) {
            ((JSONObject)localObject).put("key_question_time", paramRspBody.uint64_time.get());
          }
          if (paramRspBody.str_ans.has()) {
            ((JSONObject)localObject).put("key_answer_str", paramRspBody.str_ans.get());
          }
          if (paramRspBody.uint64_ans_time.has()) {
            ((JSONObject)localObject).put("key_answer_time", paramRspBody.uint64_ans_time.get());
          }
          if (paramRspBody.str_like_key.has()) {
            ((JSONObject)localObject).put("key_praise_key", paramRspBody.str_like_key.get());
          }
          if (paramRspBody.uint64_been_praised.has()) {
            ((JSONObject)localObject).put("key_been_praise", paramRspBody.uint64_been_praised.get());
          }
          if (paramRspBody.uint64_praise_num.has()) {
            ((JSONObject)localObject).put("key_praise_num", paramRspBody.uint64_praise_num.get());
          }
          if (paramRspBody.uint64_comment_num.has()) {
            ((JSONObject)localObject).put("key_comment_num", paramRspBody.uint64_comment_num.get());
          }
          if (paramRspBody.uint64_show_times.has()) {
            ((JSONObject)localObject).put("key_show_times", paramRspBody.uint64_show_times.get());
          }
          if (QLog.isColorLevel())
          {
            paramRspBody = StringCompanionObject.INSTANCE;
            paramRspBody = new Object[1];
            paramRspBody[0] = localObject;
            paramRspBody = String.format("constructAskAnonymousJSONObj json = %s", Arrays.copyOf(paramRspBody, paramRspBody.length));
            Intrinsics.checkExpressionValueIsNotNull(paramRspBody, "java.lang.String.format(format, *args)");
            QLog.i("AskAnonymouslyHandler", 2, paramRspBody);
          }
          return localObject;
        }
        QLog.e("AskAnonymouslyHandler", 1, "constructAskAnonymousJSONObj error: quest.has() = false");
        return null;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("constructAskAnonymousJSONObj error: rspBody.msg_quest.has() = ");
      localStringBuilder.append(paramRspBody.msg_quest.has());
      if (paramRspBody.msg_quest.has())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("{rspBody.msg_quest.get().size + ");
        ((StringBuilder)localObject).append(paramRspBody.msg_quest.get().size());
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      QLog.e("AskAnonymouslyHandler", 1, localStringBuilder.toString());
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("constructAskAnonymousJSONObj error: rspBody.uint32_ret.has() = ");
    localStringBuilder.append(paramRspBody.uint32_ret.has());
    if (paramRspBody.uint32_ret.has())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{rspBody.uint32_ret + ");
      ((StringBuilder)localObject).append(paramRspBody.uint32_ret.get());
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    QLog.e("AskAnonymouslyHandler", 1, localStringBuilder.toString());
    return null;
  }
  
  public int a()
  {
    return 13;
  }
  
  @Nullable
  public String a(@Nullable TofuItem paramTofuItem)
  {
    Object localObject = (AppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = null;
    if (!new ProfileConfig((AppInterface)localObject, null).isSwitchEnable(13)) {
      return null;
    }
    if (paramTofuItem != null)
    {
      str = (String)null;
      int i;
      if (paramTofuItem.bytesFromServer != null)
      {
        localObject = paramTofuItem.bytesFromServer;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "oldItem.bytesFromServer");
        if (localObject.length == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i ^ 0x1) != 0)
        {
          localObject = new oidb_0xec4.RspBody();
          try
          {
            ((oidb_0xec4.RspBody)localObject).mergeFrom(paramTofuItem.bytesFromServer);
            paramTofuItem = a((oidb_0xec4.RspBody)localObject);
            return paramTofuItem;
          }
          catch (InvalidProtocolBufferMicroException paramTofuItem)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getBusDataFromRspBytes exception=");
            ((StringBuilder)localObject).append(paramTofuItem.getMessage());
            QLog.e("AskAnonymouslyHandler", 1, ((StringBuilder)localObject).toString(), (Throwable)paramTofuItem);
            return str;
          }
        }
      }
      if (paramTofuItem.bytesFromServer == null) {
        i = -1;
      } else {
        i = paramTofuItem.bytesFromServer.length;
      }
      QLog.d("AskAnonymouslyHandler", 1, new Object[] { "getBusDataFromRsp bytesFromServer size=", Integer.valueOf(i) });
    }
    return str;
  }
  
  protected void a(@Nullable TofuItem paramTofuItem)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleEmptyMsg tofuItem = ");
      ((StringBuilder)localObject).append(paramTofuItem);
      QLog.i("AskAnonymouslyHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramTofuItem != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
      if (localObject != null)
      {
        ((BeancurdManager)localObject).a(String.valueOf(paramTofuItem.frdUin), 0, a());
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.BeancurdManager");
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 3);
  }
  
  public boolean a(@NotNull BeancurdMsg paramBeancurdMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramBeancurdMsg, "msg");
    int i = BeancurdManager.a(13);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app");
    localObject = ((QQAppInterface)localObject).getMessageFacade().a(paramBeancurdMsg.frienduin, 0, new int[] { i });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
      String str = a(((MessageRecord)localObject).msg);
      paramBeancurdMsg = a(paramBeancurdMsg.buffer);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isRepeat oldMsgQuestId = ");
        localStringBuilder.append(str);
        localStringBuilder.append(" and newMsgQuestId = ");
        localStringBuilder.append(paramBeancurdMsg);
        QLog.i("AskAnonymouslyHandler", 2, localStringBuilder.toString());
      }
      if ((localObject != null) && (StringsKt.equals$default(str, paramBeancurdMsg, false, 2, null))) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public byte[] a(@Nullable TofuItem paramTofuItem)
  {
    if (paramTofuItem != null)
    {
      oidb_0xec4.ReqBody localReqBody = new oidb_0xec4.ReqBody();
      localReqBody.uint64_uin.set(paramTofuItem.frdUin);
      localReqBody.uint64_quest_num.set(1L);
      localReqBody.uint32_fetch_type.set(1);
      paramTofuItem = localReqBody.toByteArray();
      Intrinsics.checkExpressionValueIsNotNull(paramTofuItem, "busReqBody.toByteArray()");
      return paramTofuItem;
    }
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.handlers.AskAnonymouslyHandler
 * JD-Core Version:    0.7.0.1
 */