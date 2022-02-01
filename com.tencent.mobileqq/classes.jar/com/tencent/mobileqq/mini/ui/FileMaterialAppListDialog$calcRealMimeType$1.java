package com.tencent.mobileqq.mini.ui;

import com.tencent.mobileqq.utils.BasePhotoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class FileMaterialAppListDialog$calcRealMimeType$1
  implements Runnable
{
  FileMaterialAppListDialog$calcRealMimeType$1(FileMaterialAppListDialog paramFileMaterialAppListDialog) {}
  
  public final void run()
  {
    Object localObject = BasePhotoUtils.getImageMimeType(FileMaterialAppListDialog.access$getMFile$p(this.this$0).getAbsolutePath());
    FileMaterialAppListDialog localFileMaterialAppListDialog = this.this$0;
    CharSequence localCharSequence = (CharSequence)localObject;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      localObject = FileMaterialAppListDialog.access$getMMimeType$p(this.this$0);
    }
    FileMaterialAppListDialog.access$setMRealMimeType$p(localFileMaterialAppListDialog, (String)localObject);
    FileMaterialAppListDialog.access$getMListAdapter$p(this.this$0).setMimeType(FileMaterialAppListDialog.access$getMRealMimeType$p(this.this$0));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("calcRealMimeType: ");
    ((StringBuilder)localObject).append(FileMaterialAppListDialog.access$getMRealMimeType$p(this.this$0));
    QLog.i("FileMaterialAppListDialog", 2, ((StringBuilder)localObject).toString());
    if (FileMaterialAppListDialog.access$getMHasPendingRequest$p(this.this$0)) {
      FileMaterialAppListDialog.access$requestData(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.FileMaterialAppListDialog.calcRealMimeType.1
 * JD-Core Version:    0.7.0.1
 */