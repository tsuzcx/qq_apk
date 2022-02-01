package com.tencent.mobileqq.tofumsg.handlers;

import android.text.TextUtils;
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
import com.tencent.mobileqq.tofumsg.TofuDataBaseHandler;
import com.tencent.mobileqq.tofumsg.TofuItem;
import com.tencent.mobileqq.widget.ProfileConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import mqq.manager.Manager;
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
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      try
      {
        String str = new JSONObject(paramString).optString("key_question_id", "");
        paramString = str;
        if (QLog.isColorLevel())
        {
          QLog.i("MessageForTofuAskAnonymously", 2, "getQuestId result: " + str);
          return str;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("MessageForTofuAskAnonymously", 1, "getQuestId exception: ", (Throwable)paramString);
      }
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
    if ((!paramRspBody.uint32_ret.has()) || (paramRspBody.uint32_ret.get() != 0))
    {
      localObject = new StringBuilder().append("constructAskAnonymousJSONObj error: rspBody.uint32_ret.has() = ").append(paramRspBody.uint32_ret.has());
      if (paramRspBody.uint32_ret.has()) {}
      for (paramRspBody = "{rspBody.uint32_ret + " + paramRspBody.uint32_ret.get();; paramRspBody = "")
      {
        QLog.e("AskAnonymouslyHandler", 1, paramRspBody);
        return null;
      }
    }
    if ((!paramRspBody.msg_quest.has()) || (paramRspBody.msg_quest.get().size() <= 0))
    {
      localObject = new StringBuilder().append("constructAskAnonymousJSONObj error: rspBody.msg_quest.has() = ").append(paramRspBody.msg_quest.has());
      if (paramRspBody.msg_quest.has()) {}
      for (paramRspBody = "{rspBody.msg_quest.get().size + " + paramRspBody.msg_quest.get().size();; paramRspBody = "")
      {
        QLog.e("AskAnonymouslyHandler", 1, paramRspBody);
        return null;
      }
    }
    Object localObject = new JSONObject();
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
  
  public int a()
  {
    return 13;
  }
  
  @Nullable
  public String a(@Nullable TofuItem paramTofuItem)
  {
    if (!new ProfileConfigHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null).a(13)) {}
    while (paramTofuItem == null) {
      return null;
    }
    String str = (String)null;
    if (paramTofuItem.bytesFromServer != null)
    {
      Object localObject = paramTofuItem.bytesFromServer;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "oldItem.bytesFromServer");
      if (localObject.length == 0)
      {
        i = 1;
        if (i != 0) {
          break label103;
        }
      }
      label103:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label144;
        }
        localObject = new oidb_0xec4.RspBody();
        try
        {
          ((oidb_0xec4.RspBody)localObject).mergeFrom(paramTofuItem.bytesFromServer);
          paramTofuItem = a((oidb_0xec4.RspBody)localObject);
          return paramTofuItem;
        }
        catch (InvalidProtocolBufferMicroException paramTofuItem)
        {
          QLog.e("AskAnonymouslyHandler", 1, "getBusDataFromRspBytes exception=" + paramTofuItem.getMessage(), (Throwable)paramTofuItem);
          return str;
        }
        i = 0;
        break;
      }
    }
    label144:
    if (paramTofuItem.bytesFromServer == null) {}
    for (int i = -1;; i = paramTofuItem.bytesFromServer.length)
    {
      QLog.d("AskAnonymouslyHandler", 1, new Object[] { "getBusDataFromRsp bytesFromServer size=", Integer.valueOf(i) });
      return str;
    }
  }
  
  public void a(@Nullable TofuItem paramTofuItem)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AskAnonymouslyHandler", 2, "handleEmptyMsg tofuItem = " + paramTofuItem);
    }
    if (paramTofuItem != null)
    {
      Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
      if (localManager == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.BeancurdManager");
      }
      ((BeancurdManager)localManager).a(String.valueOf(paramTofuItem.frdUin), 0, a());
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 3);
  }
  
  public boolean a(@NotNull BeancurdMsg paramBeancurdMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramBeancurdMsg, "msg");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.BeancurdManager");
    }
    int i = ((BeancurdManager)localObject).a(13);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app");
    localObject = ((QQAppInterface)localObject).getMessageFacade().a(paramBeancurdMsg.frienduin, 0, new int[] { i });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
      String str = a(((MessageRecord)localObject).msg);
      paramBeancurdMsg = a(paramBeancurdMsg.buffer);
      if (QLog.isColorLevel()) {
        QLog.i("AskAnonymouslyHandler", 2, "isRepeat oldMsgQuestId = " + str + " and newMsgQuestId = " + paramBeancurdMsg);
      }
      return (localObject != null) && (StringsKt.equals$default(str, paramBeancurdMsg, false, 2, null));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.handlers.AskAnonymouslyHandler
 * JD-Core Version:    0.7.0.1
 */