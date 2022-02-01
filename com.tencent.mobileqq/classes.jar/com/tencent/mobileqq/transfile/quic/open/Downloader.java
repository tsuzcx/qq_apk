package com.tencent.mobileqq.transfile.quic.open;

import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import java.util.Map;

public abstract class Downloader
{
  public abstract boolean download(String paramString1, int paramInt1, String paramString2, String paramString3, boolean paramBoolean, int paramInt2, Map<String, String> paramMap, DownloadListener paramDownloadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.open.Downloader
 * JD-Core Version:    0.7.0.1
 */