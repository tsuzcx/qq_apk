package com.tencent.tavkit.component;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.decoder.logger.Logger;

class TAVExporter$1
  implements AssetExportSession.ExportCallbackHandler
{
  TAVExporter$1(TAVExporter paramTAVExporter, String paramString) {}
  
  public void handlerCallback(AssetExportSession paramAssetExportSession)
  {
    int i = TAVExporter.2.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[paramAssetExportSession.getStatus().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          if (i != 5) {
            return;
          }
          Logger.i(TAVExporter.access$100(this.this$0), "export cancel");
          if ((TAVExporter.access$000(this.this$0) != null) && (TAVExporter.access$300(this.this$0)))
          {
            TAVExporter.access$302(this.this$0, false);
            TAVExporter.access$000(this.this$0).onExportCancel();
          }
          TAVExporter.access$202(this.this$0, false);
          return;
        }
        Logger.i(TAVExporter.access$100(this.this$0), "export error");
        if (TAVExporter.access$000(this.this$0) != null) {
          TAVExporter.access$000(this.this$0).onExportError(paramAssetExportSession);
        }
        TAVExporter.access$202(this.this$0, false);
        return;
      }
      Logger.i(TAVExporter.access$100(this.this$0), "export progress finished");
      if (TAVExporter.access$000(this.this$0) != null) {
        TAVExporter.access$000(this.this$0).onExportCompleted(this.val$outputPath);
      }
      TAVExporter.access$202(this.this$0, false);
      return;
    }
    if (TAVExporter.access$000(this.this$0) != null)
    {
      String str = TAVExporter.access$100(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("export progress: ");
      localStringBuilder.append(paramAssetExportSession.getProgress());
      Logger.i(str, localStringBuilder.toString());
      if (!TAVExporter.access$200(this.this$0)) {
        TAVExporter.access$000(this.this$0).onExportStart();
      }
      TAVExporter.access$000(this.this$0).onExporting(paramAssetExportSession.getProgress());
    }
    TAVExporter.access$202(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVExporter.1
 * JD-Core Version:    0.7.0.1
 */