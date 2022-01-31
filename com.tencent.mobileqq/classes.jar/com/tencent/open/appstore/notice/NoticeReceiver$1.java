package com.tencent.open.appstore.notice;

import android.content.Context;
import bfgi;
import bfgx;
import bfhg;
import bfij;
import bflr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = bfgi.a().b(this.jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      bfhg.b("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((bflr.b + "." + this.b).equals(this.c))
      {
        bfgi.a().a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((bflr.jdField_a_of_type_JavaLangString + "." + this.b).equals(this.c))
      {
        bfgi.a().b(localDownloadInfo);
        return;
      }
      if ((bflr.c + "." + this.b).equals(this.c))
      {
        bfgi.a().b(localDownloadInfo);
        return;
      }
    } while (!(bflr.d + "." + this.b).equals(this.c));
    bfij.a(this.jdField_a_of_type_AndroidContentContext, bfgi.a().a(localDownloadInfo.b), localDownloadInfo.m, localDownloadInfo.a("big_brother_ref_source_key"));
    localDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    bfgi.a().a(localDownloadInfo, true);
    bfgx.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */