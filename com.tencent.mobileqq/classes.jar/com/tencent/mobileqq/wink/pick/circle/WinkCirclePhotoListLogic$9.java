package com.tencent.mobileqq.wink.pick.circle;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.pick.circle.model.WinkAlbumModel;
import com.tencent.mobileqq.wink.pick.circle.widget.WinkCancelableProgressDialog;
import com.tencent.tavcut.render.exporter.IExporter.ExportListener;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

class WinkCirclePhotoListLogic$9
  implements IExporter.ExportListener
{
  WinkCirclePhotoListLogic$9(WinkCirclePhotoListLogic paramWinkCirclePhotoListLogic, int paramInt, WinkAlbumModel paramWinkAlbumModel) {}
  
  public void a()
  {
    WinkCirclePhotoListLogic.c(this.c).a(0);
  }
  
  public void a(float paramFloat)
  {
    ThreadManager.getUIHandler().post(new WinkCirclePhotoListLogic.9.1(this, paramFloat));
  }
  
  public void a(int paramInt, @Nullable Throwable paramThrowable)
  {
    paramThrowable = new StringBuilder();
    paramThrowable.append("batchCompress---error, index=");
    paramThrowable.append(this.a);
    paramThrowable.append(", path=");
    paramThrowable.append(this.b.getPath());
    AEQLog.b("WinkCirclePhotoListLogic", paramThrowable.toString());
    WinkCirclePhotoListLogic.a(this.c, true);
    ThreadManager.getUIHandler().post(new WinkCirclePhotoListLogic.9.2(this));
    if (WinkCirclePhotoListLogic.d(this.c) != null) {
      WinkCirclePhotoListLogic.d(this.c).countDown();
    }
  }
  
  public void a(@Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchCompress---finish, index=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", compressed path=");
    localStringBuilder.append(paramString);
    AEQLog.b("WinkCirclePhotoListLogic", localStringBuilder.toString());
    WinkCirclePhotoListLogic.e(this.c).put(this.b.getPath(), paramString);
    this.b.setPath(paramString);
    if (WinkCirclePhotoListLogic.d(this.c) != null) {
      WinkCirclePhotoListLogic.d(this.c).countDown();
    }
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchCompress---cancel, index=");
    localStringBuilder.append(this.a);
    AEQLog.b("WinkCirclePhotoListLogic", localStringBuilder.toString());
    if (WinkCirclePhotoListLogic.d(this.c) != null) {
      WinkCirclePhotoListLogic.d(this.c).countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCirclePhotoListLogic.9
 * JD-Core Version:    0.7.0.1
 */