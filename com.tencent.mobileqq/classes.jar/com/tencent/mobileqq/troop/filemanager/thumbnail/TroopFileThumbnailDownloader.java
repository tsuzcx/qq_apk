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
  protected boolean s = false;
  protected boolean t = false;
  protected long u = 2000L;
  
  protected TroopFileThumbnailDownloader(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    super(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean2, paramString4);
    this.s = paramBoolean1;
  }
  
  public static TroopFileThumbnailDownloader a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    String str;
    if (paramString1 == null) {
      str = "strSavePath is null";
    } else if (paramString1.length() == 0) {
      str = "strSavePath is empty";
    } else if (paramList == null) {
      str = "lstUrl is null";
    } else if (paramList.size() == 0) {
      str = "lstUrl is empty";
    } else if (paramString2 == null) {
      str = "urlParams is null";
    } else if (paramString2.length() == 0) {
      str = "urlParams is empty";
    } else {
      str = "";
    }
    if (!TextUtils.isEmpty(str))
    {
      int i = TroopFileTransferUtil.Log.b;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("getFileDownloader ");
      paramQQAppInterface.append(str);
      TroopFileTransferUtil.Log.a("TroopFileThumbDownloader", i, paramQQAppInterface.toString());
      return null;
    }
    return new TroopFileThumbnailDownloader(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean1, paramBoolean2, paramString4);
  }
  
  public long a()
  {
    long l = this.u;
    if (l <= 6000L)
    {
      this.u = (2000L + l);
      return l;
    }
    return 2000L;
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    if (!this.s) {
      return;
    }
    if (this.t) {
      return;
    }
    paramHttpMsg = paramHttpMsg.getResponseProperty("Set-Cookie");
    k = 0;
    j = k;
    try
    {
      if (!TextUtils.isEmpty(paramHttpMsg))
      {
        j = k;
        if (paramHttpMsg.contains("duration"))
        {
          paramHttpMsg = paramHttpMsg.trim().split(";");
          j = k;
          if (paramHttpMsg != null)
          {
            j = k;
            if (paramHttpMsg.length > 0)
            {
              int i = 0;
              for (;;)
              {
                j = k;
                if (i >= paramHttpMsg.length) {
                  break;
                }
                String[] arrayOfString = paramHttpMsg[i].split("=");
                if ((arrayOfString != null) && (arrayOfString.length == 2) && ("duration".equals(arrayOfString[0])))
                {
                  j = Integer.parseInt(arrayOfString[1]);
                  break;
                }
                i += 1;
              }
            }
          }
        }
      }
    }
    catch (Exception paramHttpMsg)
    {
      for (;;)
      {
        j = k;
      }
    }
    if ((j != 0) && (this.n != null) && ((this.n instanceof TroopFileThumbnailDownloader.IFileThumbDownloaderSink))) {
      ((TroopFileThumbnailDownloader.IFileThumbDownloaderSink)this.n).a(j);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void j()
  {
    this.l.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailDownloader
 * JD-Core Version:    0.7.0.1
 */