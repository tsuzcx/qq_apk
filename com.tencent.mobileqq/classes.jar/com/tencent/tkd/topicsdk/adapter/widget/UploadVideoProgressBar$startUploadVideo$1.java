package com.tencent.tkd.topicsdk.adapter.widget;

import com.tencent.tkd.topicsdk.interfaces.IPublishManager.ICheckResultCallBack;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/adapter/widget/UploadVideoProgressBar$startUploadVideo$1", "Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$ICheckResultCallBack;", "callback", "", "allowed", "", "qq-adapter_release"}, k=1, mv={1, 1, 16})
public final class UploadVideoProgressBar$startUploadVideo$1
  implements IPublishManager.ICheckResultCallBack
{
  public void a(boolean paramBoolean)
  {
    UploadVideoProgressBar.a(this.a, paramBoolean);
    UploadVideoProgressBar.b(this.a, paramBoolean);
    if (paramBoolean)
    {
      this.a.a();
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.adapter.widget.UploadVideoProgressBar.startUploadVideo.1
 * JD-Core Version:    0.7.0.1
 */