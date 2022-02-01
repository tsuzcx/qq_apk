package com.tencent.mobileqq.kandian.biz.publisher.column;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/column/ColumnModeImpl$sendGetColumnListRequest$1", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "onResult", "", "errorCode", "", "data", "", "bundle", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ColumnModeImpl$sendGetColumnListRequest$1
  extends ProtoUtils.TroopProtocolObserver
{
  ColumnModeImpl$sendGetColumnListRequest$1(IColumnModel.IColumnListCallback paramIColumnListCallback) {}
  
  public void a(int paramInt, @Nullable byte[] paramArrayOfByte, @NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "bundle");
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColumnModuleImpl", 2, "loadColumnListFromNetwork failed.");
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherColumnIColumnModel$IColumnListCallback;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(-1, "", null, true, null);
      }
      return;
    }
    ColumnModeImpl.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherColumnColumnModeImpl, paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherColumnIColumnModel$IColumnListCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.column.ColumnModeImpl.sendGetColumnListRequest.1
 * JD-Core Version:    0.7.0.1
 */