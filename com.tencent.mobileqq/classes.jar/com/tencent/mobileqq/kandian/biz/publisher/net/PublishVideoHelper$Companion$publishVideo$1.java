package com.tencent.mobileqq.kandian.biz.publisher.net;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.AddVideoRsp;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.RspBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/net/PublishVideoHelper$Companion$publishVideo$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onResult", "", "errorCode", "", "data", "", "bundle", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublishVideoHelper$Companion$publishVideo$1
  extends ProtoUtils.TroopProtocolObserver
{
  PublishVideoHelper$Companion$publishVideo$1(PublishVideoHelper.IPublishVideoCallback paramIPublishVideoCallback) {}
  
  public void onResult(int paramInt, @NotNull byte[] paramArrayOfByte, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    paramBundle = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("publishVideo, errorCode=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("PublishHelper", 1, ((StringBuilder)localObject).toString());
    if (paramInt == 0) {
      localObject = new oidb_0xe2a.RspBody();
    }
    for (;;)
    {
      try
      {
        ((oidb_0xe2a.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if ((((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.has()) && (((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.rpt_rowkey_list.has()))
        {
          paramArrayOfByte = ((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.rpt_rowkey_list.get().iterator();
          if (paramArrayOfByte.hasNext())
          {
            localObject = (ByteStringMicro)paramArrayOfByte.next();
            String str = ((ByteStringMicro)localObject).toStringUtf8();
            Intrinsics.checkExpressionValueIsNotNull(str, "rowKey.toStringUtf8()");
            if (((CharSequence)str).length() <= 0) {
              break label273;
            }
            i = 1;
            if (i != 0)
            {
              paramBundle.add(((ByteStringMicro)localObject).toStringUtf8());
              continue;
            }
            QLog.i("PublishHelper", 1, "publishVideo, rowKey isEmpty");
            continue;
          }
        }
        else
        {
          QLog.i("PublishHelper", 1, "publishVideo, not has rpt_rowkey_list");
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("publishVideo");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          QLog.d("PublishHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
      paramArrayOfByte = this.a;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(paramInt, (List)paramBundle);
      }
      return;
      label273:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.net.PublishVideoHelper.Companion.publishVideo.1
 * JD-Core Version:    0.7.0.1
 */