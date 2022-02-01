package com.tencent.mobileqq.cmshow.engine.script;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ScriptUtil
{
  public static String a(int paramInt, String paramString1, String paramString2)
  {
    String str;
    if (TextUtils.isEmpty(paramString1)) {
      str = ApolloUtilImpl.getApolloId(paramInt);
    } else {
      str = paramString1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getRemoveBubbleJs], apolloId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",bubbleName");
      localStringBuilder.append(paramString2);
      QLog.d("[cmshow][ScriptUtil]", 2, localStringBuilder.toString());
    }
    paramString1 = String.format("if(%s) {%s.removeAccessory('%s')};", new Object[] { str, str, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][ScriptUtil]", 2, new Object[] { "getRemoveBubbleJs", paramString1 });
    }
    return paramString1;
  }
  
  public static String a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopFrameRecord(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  public static StringBuilder a(MessageForApollo paramMessageForApollo, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("id", paramMessageForApollo.mApolloMessage.id);
    if (paramMessageForApollo.mApolloMessage.name != null) {
      localJSONObject.put("name", SpriteUtil.a(Base64Util.encodeToString(paramMessageForApollo.mApolloMessage.name, 0)));
    }
    if (paramMessageForApollo.mApolloMessage.text != null) {
      localJSONObject.put("atText", SpriteUtil.a(Base64Util.encodeToString(paramMessageForApollo.mApolloMessage.text, 0)));
    }
    localJSONObject.put("peerUin", paramMessageForApollo.mApolloMessage.peerUin);
    if (!TextUtils.isEmpty(paramMessageForApollo.mApolloMessage.extStr)) {
      localJSONObject.put("extraStr", new JSONObject(paramMessageForApollo.mApolloMessage.extStr));
    }
    Object localObject = paramMessageForApollo.mApolloMessage;
    ((ApolloMessage)localObject).flag |= 0x200;
    localJSONObject.put("model", ApolloActionData.getModelString(paramMessageForApollo.mApolloMessage.id));
    localJSONObject.put("flag", paramMessageForApollo.mApolloMessage.flag);
    localJSONObject.put("senderTS", paramMessageForApollo.mApolloMessage.senderTs);
    localJSONObject.put("peerTS", paramMessageForApollo.mApolloMessage.peerTs);
    localJSONObject.put("senderStatus", paramMessageForApollo.mApolloMessage.senderStatus);
    localJSONObject.put("peerStatus", paramMessageForApollo.mApolloMessage.peerStatus);
    localJSONObject.put("curUsedIdType", paramMessageForApollo.curUsedIdType);
    if (8 == paramMessageForApollo.actionType)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramMessageForApollo.mApolloMessage.id);
      localJSONObject.put("actionRootPath", ((StringBuilder)localObject).toString());
      localJSONObject.put("isSend", paramBoolean);
    }
    localObject = new JSONObject();
    ((JSONObject)localObject).put("type", paramMessageForApollo.actionType);
    ((JSONObject)localObject).put("basicMsg", localJSONObject);
    paramMessageForApollo = new StringBuilder();
    paramMessageForApollo.append("sendMsg");
    paramMessageForApollo.append("('");
    paramMessageForApollo.append(((JSONObject)localObject).toString());
    paramMessageForApollo.append("');");
    return paramMessageForApollo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.ScriptUtil
 * JD-Core Version:    0.7.0.1
 */