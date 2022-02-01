package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.callback.upload.IQQLiveUploadBitmapCallback;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/qqlive/data/upload/QQLiveUploadBitmapResult;", "kotlin.jvm.PlatformType", "onUploadResult"}, k=3, mv={1, 1, 16})
final class ChooseCoverController$onPicPicked$1
  implements IQQLiveUploadBitmapCallback
{
  ChooseCoverController$onPicPicked$1(ChooseCoverController paramChooseCoverController) {}
  
  public final void a(QQLiveUploadBitmapResult paramQQLiveUploadBitmapResult)
  {
    QLog.d("ChooseCoverController", 4, new Object[] { "uploadBitmap res {}, errMsg {}", Boolean.valueOf(paramQQLiveUploadBitmapResult.isSuccess), paramQQLiveUploadBitmapResult.errorMsg });
    if ((paramQQLiveUploadBitmapResult != null) && (paramQQLiveUploadBitmapResult.isSuccess))
    {
      ChooseCoverController localChooseCoverController = this.a;
      paramQQLiveUploadBitmapResult = paramQQLiveUploadBitmapResult.url;
      Intrinsics.checkExpressionValueIsNotNull(paramQQLiveUploadBitmapResult, "it.url");
      localChooseCoverController.a(paramQQLiveUploadBitmapResult);
      return;
    }
    ThreadManager.getUIHandler().post((Runnable)ChooseCoverController.onPicPicked.1.1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.ChooseCoverController.onPicPicked.1
 * JD-Core Version:    0.7.0.1
 */