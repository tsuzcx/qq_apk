package com.tencent.open.appstore.notice;

import android.content.Context;
import bdhk;
import bdhz;
import bdii;
import bdjl;
import bdmu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = bdhk.a().b(this.jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      bdii.b("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((bdmu.b + "." + this.b).equals(this.c))
      {
        bdhk.a().a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((bdmu.jdField_a_of_type_JavaLangString + "." + this.b).equals(this.c))
      {
        bdhk.a().b(localDownloadInfo);
        return;
      }
      if ((bdmu.c + "." + this.b).equals(this.c))
      {
        bdhk.a().b(localDownloadInfo);
        return;
      }
    } while (!(bdmu.d + "." + this.b).equals(this.c));
    bdjl.a(this.jdField_a_of_type_AndroidContentContext, bdhk.a().a(localDownloadInfo.b), localDownloadInfo.m, localDownloadInfo.a("big_brother_ref_source_key"));
    localDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    bdhk.a().a(localDownloadInfo, true);
    bdhz.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */