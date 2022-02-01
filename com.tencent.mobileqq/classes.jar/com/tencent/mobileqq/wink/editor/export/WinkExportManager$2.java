package com.tencent.mobileqq.wink.editor.export;

import android.content.Context;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.render.exporter.IExporter.ExportListener;
import com.tencent.tavcut.session.ICutSession;
import java.io.File;
import org.jetbrains.annotations.Nullable;

class WinkExportManager$2
  implements IExporter.ExportListener
{
  WinkExportManager$2(WinkExportManager paramWinkExportManager, WinkEditorVideoInfo paramWinkEditorVideoInfo, Context paramContext, ICutSession paramICutSession) {}
  
  public void a()
  {
    this.a.k = System.currentTimeMillis();
    this.a.g = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    AEQLog.d("WinkExportManager", "onGoNext... exportVideo onExportStart");
  }
  
  public void a(float paramFloat)
  {
    this.a.k = System.currentTimeMillis();
    Object localObject = this.a;
    ((WinkEditorVideoInfo)localObject).e = paramFloat;
    ((WinkEditorVideoInfo)localObject).g = "AEEDITOR_GENERATE_STATUS_DOWNLOADING";
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.a.f) > 1000L)
    {
      localObject = this.a;
      ((WinkEditorVideoInfo)localObject).f = l;
      WinkExportManager.a(this.d, this.b, (WinkEditorVideoInfo)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGoNext... exportVideo onExporting, progress:");
    ((StringBuilder)localObject).append(paramFloat);
    AEQLog.a("WinkExportManager", ((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt, @Nullable Throwable paramThrowable)
  {
    Object localObject = this.a;
    ((WinkEditorVideoInfo)localObject).g = "AEEDITOR_GENERATE_STATUS_ERROR";
    ((WinkEditorVideoInfo)localObject).j = "";
    ((WinkEditorVideoInfo)localObject).e = 0.0F;
    ((WinkEditorVideoInfo)localObject).i = paramInt;
    WinkExportManager.a(this.d, this.b, (WinkEditorVideoInfo)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGoNext... exportVideo onExportError, errorCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errorMsg:");
    ((StringBuilder)localObject).append(paramThrowable.getMessage());
    AEQLog.d("WinkExportManager", ((StringBuilder)localObject).toString());
    this.d.a(false);
    this.c.g();
  }
  
  public void a(@Nullable String paramString)
  {
    Object localObject = this.a;
    ((WinkEditorVideoInfo)localObject).g = "AEEDITOR_GENERATE_STATUS_READY";
    ((WinkEditorVideoInfo)localObject).a = paramString;
    ((WinkEditorVideoInfo)localObject).e = 1.0F;
    if (QLog.isColorLevel())
    {
      localObject = new File(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGoNext... exportVideo onExportCompleted, file.exists:");
      localStringBuilder.append(((File)localObject).exists());
      AEQLog.d("WinkExportManager", localStringBuilder.toString());
    }
    WinkExportManager.a(this.d, this.b, this.a);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGoNext... exportVideo onExportCompleted:");
    ((StringBuilder)localObject).append(paramString);
    AEQLog.d("WinkExportManager", ((StringBuilder)localObject).toString());
    this.d.a(false);
    this.c.g();
  }
  
  public void b()
  {
    AEQLog.d("WinkExportManager", "onGoNext... exportVideo onExportCancel");
    this.d.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.export.WinkExportManager.2
 * JD-Core Version:    0.7.0.1
 */