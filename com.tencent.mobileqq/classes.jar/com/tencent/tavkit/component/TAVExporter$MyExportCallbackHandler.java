package com.tencent.tavkit.component;

import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExportSession.ExportCallbackHandler;
import com.tencent.tav.decoder.logger.Logger;

class TAVExporter$MyExportCallbackHandler
  implements AssetExportSession.ExportCallbackHandler
{
  private final String outputPath;
  
  public TAVExporter$MyExportCallbackHandler(TAVExporter paramTAVExporter, String paramString)
  {
    this.outputPath = paramString;
  }
  
  public void handlerCallback(AssetExportSession paramAssetExportSession)
  {
    if (TAVExporter.access$000(this.this$0) == null) {
      return;
    }
    int i = TAVExporter.1.$SwitchMap$com$tencent$tav$core$AssetExportSession$AssetExportSessionStatus[paramAssetExportSession.getStatus().ordinal()];
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
          if (TAVExporter.access$300(this.this$0))
          {
            TAVExporter.access$302(this.this$0, false);
            TAVExporter.access$000(this.this$0).onExportCancel();
          }
          TAVExporter.access$202(this.this$0, false);
          return;
        }
        Logger.i(TAVExporter.access$100(this.this$0), "export error");
        TAVExporter.access$000(this.this$0).onExportError(paramAssetExportSession);
        TAVExporter.access$202(this.this$0, false);
        return;
      }
      Logger.i(TAVExporter.access$100(this.this$0), "export progress finished");
      TAVExporter.access$000(this.this$0).onExportCompleted(this.outputPath);
      TAVExporter.access$202(this.this$0, false);
      return;
    }
    String str = TAVExporter.access$100(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("export progress: ");
    localStringBuilder.append(paramAssetExportSession.getProgress());
    Logger.i(str, localStringBuilder.toString());
    if (!TAVExporter.access$200(this.this$0)) {
      TAVExporter.access$000(this.this$0).onExportStart();
    }
    TAVExporter.access$000(this.this$0).onExporting(paramAssetExportSession.getProgress());
    TAVExporter.access$202(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVExporter.MyExportCallbackHandler
 * JD-Core Version:    0.7.0.1
 */