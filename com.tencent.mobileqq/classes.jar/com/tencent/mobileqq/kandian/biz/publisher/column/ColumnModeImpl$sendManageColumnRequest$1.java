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
  ColumnModeImpl$sendManageColumnRequest$1(IColumnModel.IColumnCallback paramIColumnCallback, int paramInt) {}
  
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte, @NotNull Bundle paramBundle)
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
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherColumnIColumnModel$IColumnCallback;
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
          if (this.jdField_a_of_type_Int != 1) {
            break label150;
          }
          QLog.d("ColumnModuleImpl", 1, "ManageColumnModel createColumn failed." + paramArrayOfByte);
        }
      }
    }
    for (;;)
    {
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherColumnIColumnModel$IColumnCallback;
      if (paramArrayOfByte == null) {
        break;
      }
      paramArrayOfByte.a(paramInt, "", -1, 0L);
      return;
      label150:
      if (this.jdField_a_of_type_Int == 2) {
        QLog.d("ColumnModuleImpl", 1, "ManageColumnModel editColumn failed." + paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.column.ColumnModeImpl.sendManageColumnRequest.1
 * JD-Core Version:    0.7.0.1
 */