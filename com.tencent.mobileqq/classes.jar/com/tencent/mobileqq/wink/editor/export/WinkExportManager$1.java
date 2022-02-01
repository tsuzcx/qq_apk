package com.tencent.mobileqq.wink.editor.export;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.render.exporter.IExporter.ExportListener;
import com.tencent.tavcut.session.ICutSession;
import java.io.File;
import org.jetbrains.annotations.Nullable;

class WinkExportManager$1
  implements IExporter.ExportListener
{
  WinkExportManager$1(WinkExportManager paramWinkExportManager, IExporter.ExportListener paramExportListener, ICutSession paramICutSession) {}
  
  public void a()
  {
    AEQLog.d("WinkExportManager", "onGoNext... exportVideo onExportStart");
    this.a.a();
  }
  
  public void a(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGoNext... exportVideo onExporting, progress:");
    localStringBuilder.append(paramFloat);
    AEQLog.a("WinkExportManager", localStringBuilder.toString());
    this.a.a(paramFloat);
  }
  
  public void a(int paramInt, @Nullable Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGoNext... exportVideo onExportError, errorCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errorMsg:");
    localStringBuilder.append(paramThrowable.getMessage());
    AEQLog.d("WinkExportManager", localStringBuilder.toString());
    this.c.a(false);
    this.b.g();
    this.a.a(paramInt, paramThrowable);
  }
  
  public void a(@Nullable String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new File(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGoNext... exportVideo onExportCompleted, file.exists:");
      localStringBuilder.append(((File)localObject).exists());
      AEQLog.d("WinkExportManager", localStringBuilder.toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGoNext... exportVideo onExportCompleted:");
    ((StringBuilder)localObject).append(paramString);
    AEQLog.d("WinkExportManager", ((StringBuilder)localObject).toString());
    this.c.a(false);
    this.b.g();
    this.a.a(paramString);
  }
  
  public void b()
  {
    AEQLog.d("WinkExportManager", "onGoNext... exportVideo onExportCancel");
    this.c.a(false);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.export.WinkExportManager.1
 * JD-Core Version:    0.7.0.1
 */