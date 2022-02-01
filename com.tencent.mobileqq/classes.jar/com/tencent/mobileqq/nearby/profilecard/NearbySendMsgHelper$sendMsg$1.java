package com.tencent.mobileqq.nearby.profilecard;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.GetMiniCardRsp;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.MiniCard;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/nearby/profilecard/NearbySendMsgHelper$sendMsg$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onError", "", "errorMsg", "", "onResult", "errorCode", "", "data", "", "bundle", "Landroid/os/Bundle;", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbySendMsgHelper$sendMsg$1
  extends ProtoUtils.TroopProtocolObserver
{
  NearbySendMsgHelper$sendMsg$1(Function1 paramFunction1, long paramLong, String paramString1, QQAppInterface paramQQAppInterface, int paramInt, String paramString2) {}
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get mini card info: ");
    localStringBuilder.append(paramString);
    QLog.e("NearbySendMsgHelper", 1, localStringBuilder.toString());
    paramString = this.a;
    if (paramString != null) {
      paramString = (Unit)paramString.invoke(Boolean.valueOf(false));
    }
  }
  
  public void onResult(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("code=");
      paramArrayOfByte.append(paramInt);
      a(paramArrayOfByte.toString());
      return;
    }
    paramBundle = new nearbyProfile.GetMiniCardRsp();
    try
    {
      MessageMicro.mergeFrom((MessageMicro)paramBundle, paramArrayOfByte);
      paramInt = paramBundle.ret_code.get();
      if (paramInt != 0)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("rsp.code=");
        paramArrayOfByte.append(paramInt);
        a(paramArrayOfByte.toString());
        return;
      }
      if (!paramBundle.is_show.get())
      {
        a("rsp no need to show");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      label222:
      paramBundle = new StringBuilder();
      paramBundle.append("parse error, ");
      paramBundle.append(paramArrayOfByte);
      a(paramBundle.toString());
      return;
    }
    try
    {
      paramArrayOfByte = (nearbyProfile.MiniCard)paramBundle.mini_card.get(0);
      paramBundle = NearbySendMsgHelper.a;
      Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "miniCard");
      paramArrayOfByte = NearbySendMsgHelper.a(paramBundle, paramArrayOfByte, this.b);
      if (paramArrayOfByte != null)
      {
        NearbySendMsgHelper.a(NearbySendMsgHelper.a).put(this.c, NearbySendMsgHelper.a);
        NearbySendMsgHelper.a(NearbySendMsgHelper.a, this.d, this.c, this.e, paramArrayOfByte, this.f);
        paramArrayOfByte = this.a;
        if (paramArrayOfByte != null) {
          paramArrayOfByte = (Unit)paramArrayOfByte.invoke(Boolean.valueOf(true));
        }
        return;
      }
      paramArrayOfByte = (1)this;
      a("create json error");
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      break label222;
    }
    a("no card");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbySendMsgHelper.sendMsg.1
 * JD-Core Version:    0.7.0.1
 */