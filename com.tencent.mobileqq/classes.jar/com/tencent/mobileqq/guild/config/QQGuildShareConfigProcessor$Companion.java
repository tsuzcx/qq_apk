package com.tencent.mobileqq.guild.config;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigProcessor$Companion;", "", "()V", "TAG", "", "TASK_ID", "", "fromQConfItem", "Lcom/tencent/mobileqq/guild/config/QQGuildShareConfigProcessor$ConfigBeanDTO;", "gson", "Lcom/google/gson/Gson;", "item", "Lcom/tencent/mobileqq/config/QConfItem;", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
public final class QQGuildShareConfigProcessor$Companion
{
  private final QQGuildShareConfigProcessor.ConfigBeanDTO a(Gson paramGson, QConfItem paramQConfItem)
  {
    try
    {
      paramGson = (QQGuildShareConfigProcessor.ConfigBeanDTO)paramGson.fromJson(paramQConfItem.b, QQGuildShareConfigProcessor.ConfigBeanDTO.class);
      return paramGson;
    }
    catch (JsonSyntaxException paramGson)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Parse TaskId: ");
      localStringBuilder.append(paramQConfItem.a);
      localStringBuilder.append(" Error!");
      QLog.e("QQGuildShareConfigProcessor", 1, localStringBuilder.toString(), (Throwable)paramGson);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.config.QQGuildShareConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */