package com.tencent.open.appstore.dl;

import bjsz;
import bjtx;
import bjwy;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadManagerV2$21
  implements Runnable
{
  public DownloadManagerV2$21(bjsz parambjsz, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bjtx.b("DownloadManagerV2", "[getApkCodeAsync]" + this.a.e + " begin getApkCode ......");
      bjsz.a(this.this$0).a(this.a.jdField_b_of_type_JavaLangString, this.a.e, this.a.jdField_b_of_type_Int, bjsz.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bjtx.c("DownloadManagerV2", "[getApkCodeAsync] >>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.21
 * JD-Core Version:    0.7.0.1
 */