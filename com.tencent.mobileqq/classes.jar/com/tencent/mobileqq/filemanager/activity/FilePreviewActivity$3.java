package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.DocClickTypeRunnable;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;

class FilePreviewActivity$3
  implements ITencentDocConvertABTestUtil.DocClickTypeRunnable
{
  FilePreviewActivity$3(FilePreviewActivity paramFilePreviewActivity) {}
  
  public void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      localObject1 = this.a.app;
      localObject2 = this.a;
      TeamWorkConvertUtils.a((AppInterface)localObject1, (Context)localObject2, "<FileAssistant>FilePreviewActivity", FilePreviewActivity.b((FilePreviewActivity)localObject2));
      return;
    }
    Object localObject1 = this.a;
    Object localObject2 = ((FilePreviewActivity)localObject1).app;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = FilePreviewActivity.b(this.a);
    FilePreviewActivity localFilePreviewActivity = this.a;
    FilePreviewActivity.a((FilePreviewActivity)localObject1, TeamWorkConvertUtils.a((AppInterface)localObject2, localTeamWorkFileImportInfo, localFilePreviewActivity, "<FileAssistant>FilePreviewActivity", localFilePreviewActivity.getString(2131917106), false));
  }
  
  public void a(ImageView paramImageView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.3
 * JD-Core Version:    0.7.0.1
 */