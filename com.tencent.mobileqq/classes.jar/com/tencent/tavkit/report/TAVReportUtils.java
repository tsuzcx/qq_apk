package com.tencent.tavkit.report;

import android.support.annotation.Nullable;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.coremedia.CGSize;
import org.jetbrains.annotations.NotNull;

public class TAVReportUtils
{
  @NotNull
  public static String buildExportErrorMsg(String paramString, @Nullable AssetExportSession paramAssetExportSession)
  {
    Object localObject = paramString;
    if (paramAssetExportSession != null)
    {
      localObject = paramAssetExportSession.getExportErrorStatus();
      if (localObject == null) {
        return paramString;
      }
      paramString = new StringBuilder();
      paramString.append("errorCode:");
      paramString.append(((ExportErrorStatus)localObject).code);
      paramString.append("\n");
      CGSize localCGSize = paramAssetExportSession.getExportConfig().getOutputSize();
      if (localCGSize != null)
      {
        paramString.append("size:");
        paramString.append(localCGSize);
        paramString.append(";");
      }
      paramString.append("progress:");
      paramString.append(paramAssetExportSession.getProgress());
      paramString.append(";\n");
      paramString.append("extraInfo:");
      paramString.append(((ExportErrorStatus)localObject).msg);
      paramString.append(";\n");
      paramString.append("retryIndex:");
      paramString.append(paramAssetExportSession.getRetryIndex());
      paramString.append(";\n");
      if (((ExportErrorStatus)localObject).throwable != null)
      {
        paramString.append(((ExportErrorStatus)localObject).throwable.getClass().getSimpleName());
        paramString.append(":");
        paramString.append(((ExportErrorStatus)localObject).throwable.getMessage());
        paramString.append(";\n");
        paramAssetExportSession = ((ExportErrorStatus)localObject).throwable.getStackTrace();
        int j = paramAssetExportSession.length;
        int i = 0;
        while (i < j)
        {
          paramString.append(paramAssetExportSession[i].toString());
          paramString.append("\n");
          i += 1;
        }
      }
      localObject = paramString.toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.report.TAVReportUtils
 * JD-Core Version:    0.7.0.1
 */