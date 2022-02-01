package com.tencent.mobileqq.mini.ui;

import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial.AppMaterialInfo;
import NS_MINI_FILE_MATERIAL.MiniAppFileMaterial.GetMaterialRelevantAppRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/mini/ui/FileMaterialAppListDialog$onReqSucceed$1$1", "Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListAdapter$OnItemClickListener;", "onItemClicked", "", "data", "LNS_MINI_FILE_MATERIAL/MiniAppFileMaterial$AppMaterialInfo;", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class FileMaterialAppListDialog$onReqSucceed$$inlined$run$lambda$1
  implements FileMaterialAppListAdapter.OnItemClickListener
{
  FileMaterialAppListDialog$onReqSucceed$$inlined$run$lambda$1(FileMaterialAppListDialog paramFileMaterialAppListDialog, MiniAppFileMaterial.GetMaterialRelevantAppRsp paramGetMaterialRelevantAppRsp) {}
  
  public void onItemClicked(@NotNull MiniAppFileMaterial.AppMaterialInfo paramAppMaterialInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAppMaterialInfo, "data");
    FileMaterialAppListDialog.access$handleItemClicked(this.this$0, paramAppMaterialInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.FileMaterialAppListDialog.onReqSucceed..inlined.run.lambda.1
 * JD-Core Version:    0.7.0.1
 */