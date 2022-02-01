package com.tencent.open.appstore.notice;

import android.content.Context;
import bisa;
import bisp;
import bisy;
import biub;
import bixh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = bisa.a().b(this.jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      bisy.b("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((bixh.b + "." + this.b).equals(this.c))
      {
        bisa.a().a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((bixh.jdField_a_of_type_JavaLangString + "." + this.b).equals(this.c))
      {
        bisa.a().b(localDownloadInfo);
        return;
      }
      if ((bixh.c + "." + this.b).equals(this.c))
      {
        bisa.a().b(localDownloadInfo);
        return;
      }
    } while (!(bixh.d + "." + this.b).equals(this.c));
    biub.a(this.jdField_a_of_type_AndroidContentContext, bisa.a().a(localDownloadInfo.b), localDownloadInfo.m, localDownloadInfo.a("big_brother_ref_source_key"));
    localDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    bisa.a().a(localDownloadInfo, true);
    bisp.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */