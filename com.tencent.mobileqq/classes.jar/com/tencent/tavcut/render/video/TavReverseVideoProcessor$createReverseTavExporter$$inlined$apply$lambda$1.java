package com.tencent.tavcut.render.video;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tavkit.component.TAVExporter.ExportListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/render/video/TavReverseVideoProcessor$createReverseTavExporter$1$1", "Lcom/tencent/tavkit/component/TAVExporter$ExportListener;", "onExportCancel", "", "onExportCompleted", "exportPath", "", "onExportError", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "onExportStart", "onExporting", "progress", "", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class TavReverseVideoProcessor$createReverseTavExporter$$inlined$apply$lambda$1
  implements TAVExporter.ExportListener
{
  public void onExportCancel()
  {
    this.a.a();
  }
  
  public void onExportCompleted(@Nullable String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      this.a.a(-1, "Reverse video failed");
      return;
    }
    this.a.a(100);
    this.a.a(paramString);
  }
  
  public void onExportError(@Nullable AssetExportSession paramAssetExportSession)
  {
    if (paramAssetExportSession != null) {
      paramAssetExportSession = paramAssetExportSession.getExportErrorStatus();
    } else {
      paramAssetExportSession = null;
    }
    int i;
    if (paramAssetExportSession != null) {
      i = paramAssetExportSession.code;
    } else {
      i = -1;
    }
    OnReverseVideoListener localOnReverseVideoListener = this.a;
    if (paramAssetExportSession != null)
    {
      paramAssetExportSession = paramAssetExportSession.msg;
      if (paramAssetExportSession != null) {}
    }
    else
    {
      paramAssetExportSession = "Reverse video failed";
    }
    localOnReverseVideoListener.a(i, paramAssetExportSession);
  }
  
  public void onExportStart() {}
  
  public void onExporting(float paramFloat)
  {
    this.a.a((int)(paramFloat * 100));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.video.TavReverseVideoProcessor.createReverseTavExporter..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */