package com.tencent.mobileqq.troop.filemanager.thumbnail;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloader;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.util.List;

public class TroopFileThumbnailDownloader
  extends TroopFileDownloader
{
  protected boolean c;
  protected boolean d;
  protected long g = 2000L;
  
  protected TroopFileThumbnailDownloader(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List paramList, String paramString2, String paramString3, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3);
    this.c = paramBoolean;
  }
  
  public static TroopFileThumbnailDownloader a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List paramList, String paramString2, String paramString3, boolean paramBoolean)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strSavePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      TroopFileTransferUtil.Log.a("TroopFileThumbDownloader", TroopFileTransferUtil.Log.a, "getFileDownloader " + str);
      return null;
      if (paramString1.length() == 0) {
        str = "strSavePath is empty";
      } else if (paramList == null) {
        str = "lstUrl is null";
      } else if (paramList.size() == 0) {
        str = "lstUrl is empty";
      } else if (paramString2 == null) {
        str = "urlParams is null";
      } else if (paramString2.length() == 0) {
        str = "urlParams is empty";
      }
    }
    return new TroopFileThumbnailDownloader(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean);
  }
  
  public long a()
  {
    if (this.g <= 6000L)
    {
      long l = this.g;
      this.g = (2000L + this.g);
      return l;
    }
    return 2000L;
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    int k = 0;
    if (!this.c) {
      break label10;
    }
    label10:
    while (this.d) {
      return;
    }
    paramHttpMsg = paramHttpMsg.a("Set-Cookie");
    i = k;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramHttpMsg))
        {
          i = k;
          if (paramHttpMsg.contains("duration"))
          {
            paramHttpMsg = paramHttpMsg.trim().split(";");
            i = k;
            if (paramHttpMsg != null)
            {
              i = k;
              if (paramHttpMsg.length > 0)
              {
                j = 0;
                i = k;
                if (j < paramHttpMsg.length)
                {
                  String[] arrayOfString = paramHttpMsg[j].split("=");
                  if ((arrayOfString == null) || (arrayOfString.length != 2) || (!"duration".equals(arrayOfString[0]))) {
                    continue;
                  }
                  i = Integer.parseInt(arrayOfString[1]);
                }
              }
            }
          }
        }
      }
      catch (Exception paramHttpMsg)
      {
        int j;
        i = 0;
        continue;
      }
      if ((i == 0) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloader$ITroopFileDownloaderSink == null) || (!(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloader$ITroopFileDownloaderSink instanceof TroopFileThumbnailDownloader.IFileThumbDownloaderSink))) {
        break;
      }
      ((TroopFileThumbnailDownloader.IFileThumbDownloaderSink)this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadTroopFileDownloader$ITroopFileDownloaderSink).a(i);
      return;
      j += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileTransferRetryController.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailDownloader
 * JD-Core Version:    0.7.0.1
 */