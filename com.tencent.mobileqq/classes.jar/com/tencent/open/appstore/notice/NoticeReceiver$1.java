package com.tencent.open.appstore.notice;

import android.content.Context;
import bhyo;
import bhzd;
import bhzm;
import biam;
import bido;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = bhyo.a().b(this.jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      bhzm.b("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((bido.b + "." + this.b).equals(this.c))
      {
        bhyo.a().a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((bido.jdField_a_of_type_JavaLangString + "." + this.b).equals(this.c))
      {
        bhyo.a().b(localDownloadInfo);
        return;
      }
      if ((bido.c + "." + this.b).equals(this.c))
      {
        bhyo.a().b(localDownloadInfo);
        return;
      }
    } while (!(bido.d + "." + this.b).equals(this.c));
    biam.a(this.jdField_a_of_type_AndroidContentContext, bhyo.a().a(localDownloadInfo.b), localDownloadInfo.m, localDownloadInfo.a("big_brother_ref_source_key"), localDownloadInfo.a("hideInstallSuccessPage"));
    localDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    bhyo.a().a(localDownloadInfo, true);
    bhzd.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */