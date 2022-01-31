package com.tencent.open.appstore.dl;

import bfgi;
import bfhg;
import bfkj;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadManagerV2$21
  implements Runnable
{
  public DownloadManagerV2$21(bfgi parambfgi, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bfhg.b("DownloadManagerV2", "[getApkCodeAsync]" + this.a.e + " begin getApkCode ......");
      bfgi.a(this.this$0).a(this.a.jdField_b_of_type_JavaLangString, this.a.e, this.a.jdField_b_of_type_Int, bfgi.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bfhg.c("DownloadManagerV2", "[getApkCodeAsync] >>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.21
 * JD-Core Version:    0.7.0.1
 */