package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.kandian.base.automator.BaseStep;
import com.tencent.mobileqq.kandian.biz.ugc.editvideo.PublishVideoHelper;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PublishTaskStep
  extends BaseStep
{
  @NotNull
  private PublishTaskAutomator a;
  @Nullable
  private IPublishTaskCallback b;
  
  public PublishTaskStep(@NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback)
  {
    super(paramPublishTaskAutomator, true, "PublishTaskStep");
    this.a = paramPublishTaskAutomator;
    this.b = paramIPublishTaskCallback;
  }
  
  private void a(UgcVideo paramUgcVideo)
  {
    if ((paramUgcVideo.rowkey != null) && (!paramUgcVideo.rowkey.isEmpty())) {
      paramUgcVideo.status = UgcVideo.STATUS_FINISH;
    } else {
      paramUgcVideo.status = UgcVideo.STATUS_FAILED;
    }
    IPublishTaskCallback localIPublishTaskCallback = this.b;
    if (localIPublishTaskCallback != null)
    {
      boolean bool;
      if (paramUgcVideo.status == UgcVideo.STATUS_FINISH) {
        bool = true;
      } else {
        bool = false;
      }
      localIPublishTaskCallback.a(4, bool, true, "");
    }
    g();
  }
  
  public boolean a()
  {
    return this.a.e().status == UgcVideo.STATUS_UPLOADING;
  }
  
  public boolean b()
  {
    UgcVideo localUgcVideo = this.a.e();
    Object localObject = localUgcVideo.title;
    String str = localUgcVideo.url;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStep: title=");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("; url=");
    localStringBuilder.append(str);
    localStringBuilder.append("; coverUrl=");
    localStringBuilder.append(localUgcVideo.coverUrl);
    str = localStringBuilder.toString();
    boolean bool = true;
    QLog.i("RIJUGC.PublishTaskStep", 1, str);
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      localObject = new ArrayList();
      ((List)localObject).add(localUgcVideo);
      if (localUgcVideo.columnId == 0L) {
        bool = false;
      }
      PublishVideoHelper.a(bool, (List)localObject, new PublishTaskStep.1(this, localUgcVideo), localUgcVideo.needShowPublishToast);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.PublishTaskStep
 * JD-Core Version:    0.7.0.1
 */