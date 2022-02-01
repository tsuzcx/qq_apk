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
  
  public void a(int paramInt, @NotNull byte[] paramArrayOfByte, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    paramBundle = new ArrayList();
    QLog.i("PublishHelper", 1, "publishVideo, errorCode=" + paramInt);
    int i;
    if (paramInt == 0)
    {
      Object localObject = new oidb_0xe2a.RspBody();
      try
      {
        ((oidb_0xe2a.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if ((((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.has()) && (((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.rpt_rowkey_list.has()))
        {
          paramArrayOfByte = ((oidb_0xe2a.RspBody)localObject).msg_add_video_rsp.rpt_rowkey_list.get().iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject = (ByteStringMicro)paramArrayOfByte.next();
            String str = ((ByteStringMicro)localObject).toStringUtf8();
            Intrinsics.checkExpressionValueIsNotNull(str, "rowKey.toStringUtf8()");
            if (((CharSequence)str).length() <= 0) {
              break label228;
            }
            i = 1;
            label157:
            if (i == 0) {
              break label234;
            }
            paramBundle.add(((ByteStringMicro)localObject).toStringUtf8());
          }
          paramArrayOfByte = this.a;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PublishHelper", 2, "publishVideo" + paramArrayOfByte);
        }
      }
    }
    for (;;)
    {
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(paramInt, (List)paramBundle);
      }
      return;
      label228:
      i = 0;
      break label157;
      label234:
      QLog.i("PublishHelper", 1, "publishVideo, rowKey isEmpty");
      break;
      QLog.i("PublishHelper", 1, "publishVideo, not has rpt_rowkey_list");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.net.PublishVideoHelper.Companion.publishVideo.1
 * JD-Core Version:    0.7.0.1
 */