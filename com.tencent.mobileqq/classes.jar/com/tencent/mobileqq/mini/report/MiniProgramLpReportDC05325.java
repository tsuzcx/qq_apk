package com.tencent.mobileqq.mini.report;

import android.os.Handler;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.report.ImageDownloadReporter;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class MiniProgramLpReportDC05325
{
  public static final int RESOURCE_TYPE_APKG_MAIN = 1;
  public static final int RESOURCE_TYPE_APKG_SUB = 2;
  public static final int RESOURCE_TYPE_BASELIB = 4;
  public static final int RESOURCE_TYPE_IMAGE_MAIN = 3;
  public static final int RESOURCE_TYPE_OTHER = 10;
  public static final int RESOURCE_TYPE_PLUGIN = 5;
  private static ImageDownloadReporter downloadReporter;
  private static Map<Long, Boolean> reportedList = new HashMap();
  
  public static String getHeader(DownloadResult paramDownloadResult, String paramString)
  {
    HttpResponse localHttpResponse = paramDownloadResult.getReport().response;
    paramDownloadResult = paramDownloadResult.getReport().okResponse;
    int j = 0;
    int i = 0;
    if (paramDownloadResult != null)
    {
      paramDownloadResult = paramDownloadResult.headers();
      if (paramDownloadResult != null)
      {
        j = paramDownloadResult.size();
        while (i < j)
        {
          if (paramString.equalsIgnoreCase(paramDownloadResult.name(i))) {
            return paramDownloadResult.value(i);
          }
          i += 1;
        }
      }
    }
    else if (localHttpResponse != null)
    {
      paramDownloadResult = localHttpResponse.getAllHeaders();
      if (paramDownloadResult != null)
      {
        int k = paramDownloadResult.length;
        i = j;
        while (i < k)
        {
          if (paramString.equalsIgnoreCase(paramDownloadResult[i].getName())) {
            return paramDownloadResult[i].getValue();
          }
          i += 1;
        }
      }
    }
    return "";
  }
  
  public static String getNetworkType()
  {
    String str = HttpUtil.getNetWorkTypeByStr();
    if (str == null) {
      return "unknown";
    }
    return str.toLowerCase();
  }
  
  public static String getProtocol(DownloadResult paramDownloadResult)
  {
    if (paramDownloadResult.getReport() == null) {
      return "";
    }
    if (paramDownloadResult.getReport().isHttp2) {
      return "http2.0";
    }
    if (paramDownloadResult.getReport().isHttps) {
      return "https";
    }
    return "http1.1";
  }
  
  public static int getRetCode(DownloadResult paramDownloadResult)
  {
    if (paramDownloadResult.getReport() == null) {
      return -9999;
    }
    if (downloadReporter == null) {
      downloadReporter = new ImageDownloadReporter();
    }
    paramDownloadResult = downloadReporter.obtainReportObj(paramDownloadResult, paramDownloadResult.getReport());
    if (paramDownloadResult != null) {
      return paramDownloadResult.retCode;
    }
    return -9999;
  }
  
  public static void reportApiReport(DownloadResult paramDownloadResult)
  {
    reportApiReport(paramDownloadResult, 10, null);
  }
  
  public static void reportApiReport(DownloadResult paramDownloadResult, int paramInt)
  {
    reportApiReport(paramDownloadResult, paramInt, null);
  }
  
  public static void reportApiReport(DownloadResult paramDownloadResult, int paramInt, MiniAppConfig paramMiniAppConfig)
  {
    if (paramDownloadResult == null) {
      return;
    }
    if (10 == paramInt) {
      return;
    }
    MiniProgramReporter.getInstance().getReportHandler().post(new MiniProgramLpReportDC05325.1(paramDownloadResult, paramMiniAppConfig, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05325
 * JD-Core Version:    0.7.0.1
 */