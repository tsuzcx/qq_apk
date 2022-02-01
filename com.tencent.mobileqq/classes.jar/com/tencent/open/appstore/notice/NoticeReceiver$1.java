package com.tencent.open.appstore.notice;

import android.content.Context;
import bjsz;
import bjto;
import bjtx;
import bjva;
import bjyg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = bjsz.a().b(this.jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      bjtx.b("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((bjyg.b + "." + this.b).equals(this.c))
      {
        bjsz.a().a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((bjyg.jdField_a_of_type_JavaLangString + "." + this.b).equals(this.c))
      {
        bjsz.a().b(localDownloadInfo);
        return;
      }
      if ((bjyg.c + "." + this.b).equals(this.c))
      {
        bjsz.a().b(localDownloadInfo);
        return;
      }
    } while (!(bjyg.d + "." + this.b).equals(this.c));
    bjva.a(this.jdField_a_of_type_AndroidContentContext, bjsz.a().a(localDownloadInfo.b), localDownloadInfo.m, localDownloadInfo.a("big_brother_ref_source_key"), localDownloadInfo.a("hideInstallSuccessPage"));
    localDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    bjsz.a().a(localDownloadInfo, true);
    bjto.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */