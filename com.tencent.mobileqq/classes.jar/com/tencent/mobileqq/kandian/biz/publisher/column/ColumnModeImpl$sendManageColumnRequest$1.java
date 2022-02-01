package com.tencent.mobileqq.kandian.biz.publisher.column;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.RspBody;
import tencent.im.oidb.cmd0xe33.oidb_0xe33.TopicInfoSetRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/column/ColumnModeImpl$sendManageColumnRequest$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onResult", "", "errorCode", "", "data", "", "bundle", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ColumnModeImpl$sendManageColumnRequest$1
  extends ProtoUtils.TroopProtocolObserver
{
  public void onResult(int paramInt, @Nullable byte[] paramArrayOfByte, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    if (paramArrayOfByte != null) {
      try
      {
        paramBundle = new oidb_0xe33.RspBody();
        paramBundle.mergeFrom(paramArrayOfByte);
        if (paramBundle.topic_info_set_rsp.has())
        {
          paramArrayOfByte = paramBundle.topic_info_set_rsp;
          paramBundle = this.a;
          if (paramBundle != null)
          {
            String str = paramArrayOfByte.err_msg.get();
            Intrinsics.checkExpressionValueIsNotNull(str, "topicInfoSetRsp.err_msg.get()");
            paramBundle.a(paramInt, str, paramArrayOfByte.ret_code.get(), paramArrayOfByte.topic_id.get());
          }
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          int i = this.b;
          if (i == 1)
          {
            paramBundle = new StringBuilder();
            paramBundle.append("ManageColumnModel createColumn failed.");
            paramBundle.append(paramArrayOfByte);
            QLog.d("ColumnModuleImpl", 1, paramBundle.toString());
          }
          else if (i == 2)
          {
            paramBundle = new StringBuilder();
            paramBundle.append("ManageColumnModel editColumn failed.");
            paramBundle.append(paramArrayOfByte);
            QLog.d("ColumnModuleImpl", 1, paramBundle.toString());
          }
        }
      }
    }
    paramArrayOfByte = this.a;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(paramInt, "", -1, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.column.ColumnModeImpl.sendManageColumnRequest.1
 * JD-Core Version:    0.7.0.1
 */