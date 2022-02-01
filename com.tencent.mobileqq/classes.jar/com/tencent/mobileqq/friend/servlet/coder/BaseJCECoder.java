package com.tencent.mobileqq.friend.servlet.coder;

import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/servlet/coder/BaseJCECoder;", "", "()V", "decode", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "decodePacket", "T", "wupBuf", "", "wupRetName", "", "tmp", "([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "encode", "", "client", "Lcom/qq/jce/wup/UniPacket;", "filterCmd", "cmd", "getCmdList", "", "()[Ljava/lang/String;", "IMCore_release"}, k=1, mv={1, 1, 16})
public abstract class BaseJCECoder
{
  @Nullable
  public Object a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "response");
    return null;
  }
  
  @Nullable
  public final <T> T a(@Nullable byte[] paramArrayOfByte, @Nullable String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public boolean a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull UniPacket paramUniPacket)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramUniPacket, "client");
    return false;
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    String[] arrayOfString = a();
    int i;
    label26:
    int j;
    if (arrayOfString.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label59;
      }
      i = 1;
      if (i == 0) {
        break label71;
      }
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label71;
      }
      if (Intrinsics.areEqual(paramString, arrayOfString[i]))
      {
        return true;
        i = 0;
        break;
        label59:
        i = 0;
        break label26;
      }
      i += 1;
    }
    label71:
    return false;
  }
  
  @NotNull
  public abstract String[] a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.servlet.coder.BaseJCECoder
 * JD-Core Version:    0.7.0.1
 */