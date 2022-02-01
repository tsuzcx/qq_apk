package com.tencent.mobileqq.kandian.biz.privatechat.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/privatechat/api/IRIJPrivateChatReport$R5Builder;", "", "()V", "json", "Lorg/json/JSONObject;", "getJson", "()Lorg/json/JSONObject;", "addMsgFeedsType", "msgFeedsType", "", "addRedNum", "redNum", "addString", "key", "", "value", "addToUin", "toUin", "addUin", "uin", "build", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class IRIJPrivateChatReport$R5Builder
{
  @NotNull
  private final JSONObject a = new JSONObject();
  
  @NotNull
  public final R5Builder a(int paramInt)
  {
    this.a.put("msgfeedstype", 15);
    return this;
  }
  
  @NotNull
  public final R5Builder a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    this.a.put("uin", paramString);
    return this;
  }
  
  @NotNull
  public final R5Builder a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    this.a.put(paramString1, paramString2);
    return this;
  }
  
  @NotNull
  public final String a()
  {
    String str = this.a.toString();
    Intrinsics.checkExpressionValueIsNotNull(str, "json.toString()");
    return str;
  }
  
  @NotNull
  public final R5Builder b(int paramInt)
  {
    this.a.put("sub_reddot_num", paramInt);
    return this;
  }
  
  @NotNull
  public final R5Builder b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "toUin");
    this.a.put("touin", paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatReport.R5Builder
 * JD-Core Version:    0.7.0.1
 */