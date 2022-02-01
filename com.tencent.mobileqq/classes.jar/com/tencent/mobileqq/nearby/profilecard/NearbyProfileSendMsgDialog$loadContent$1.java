package com.tencent.mobileqq.nearby.profilecard;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.GetGreetRsp;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/nearby/profilecard/NearbyProfileSendMsgDialog$loadContent$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onResult", "", "errorCode", "", "data", "", "bundle", "Landroid/os/Bundle;", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyProfileSendMsgDialog$loadContent$1
  extends ProtoUtils.TroopProtocolObserver
{
  public void onResult(int paramInt, @Nullable byte[] paramArrayOfByte, @Nullable Bundle paramBundle)
  {
    NearbyProfileSendMsgDialog.a(this.a, false);
    if (paramInt != 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("loadContent error: code=");
      paramArrayOfByte.append(paramInt);
      QLog.e("NearbyProfileSendMsgDialog", 1, paramArrayOfByte.toString());
      return;
    }
    paramBundle = new nearbyProfile.GetGreetRsp();
    try
    {
      MessageMicro.mergeFrom((MessageMicro)paramBundle, paramArrayOfByte);
      paramInt = paramBundle.ret_code.get();
      if (paramInt != 0)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("loadContent error: code=");
        paramArrayOfByte.append(paramInt);
        paramArrayOfByte.append(", msg=");
        paramArrayOfByte.append(paramBundle.ret_msg.get());
        QLog.e("NearbyProfileSendMsgDialog", 1, paramArrayOfByte.toString());
        return;
      }
      NearbyProfileSendMsgDialog.a(this.a, paramBundle.left_cnt.get());
      paramArrayOfByte = NearbyProfileSendMsgDialog.a(this.a);
      paramArrayOfByte.clear();
      paramBundle = paramBundle.greet_msg.get();
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "rsp.greet_msg.get()");
      paramArrayOfByte.addAll((Collection)paramBundle);
      paramInt = NearbyProfileSendMsgDialog.b(this.a);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 3) {
            return;
          }
          NearbyProfileSendMsgDialog.c(this.a);
          return;
        }
        NearbyProfileSendMsgDialog.b(this.a, 3);
        NearbyProfileSendMsgDialog.c(this.a);
        return;
      }
      NearbyProfileSendMsgDialog.b(this.a, 2);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("loadContent parse error: ");
      paramBundle.append(paramArrayOfByte);
      QLog.e("NearbyProfileSendMsgDialog", 1, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileSendMsgDialog.loadContent.1
 * JD-Core Version:    0.7.0.1
 */