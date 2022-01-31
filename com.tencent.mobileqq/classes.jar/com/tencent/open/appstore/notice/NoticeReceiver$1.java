package com.tencent.open.appstore.notice;

import android.content.Context;
import bccu;
import bcdj;
import bcds;
import bcev;
import bcie;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;

class NoticeReceiver$1
  implements Runnable
{
  NoticeReceiver$1(NoticeReceiver paramNoticeReceiver, String paramString1, String paramString2, String paramString3, Context paramContext) {}
  
  public void run()
  {
    DownloadInfo localDownloadInfo = bccu.a().b(this.jdField_a_of_type_JavaLangString);
    if (localDownloadInfo == null) {
      bcds.b("NoticeReceiver", "downloadInfo is null.");
    }
    do
    {
      return;
      if ((bcie.b + "." + this.b).equals(this.c))
      {
        bccu.a().a(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((bcie.jdField_a_of_type_JavaLangString + "." + this.b).equals(this.c))
      {
        bccu.a().b(localDownloadInfo);
        return;
      }
      if ((bcie.c + "." + this.b).equals(this.c))
      {
        bccu.a().b(localDownloadInfo);
        return;
      }
    } while (!(bcie.d + "." + this.b).equals(this.c));
    bcev.a(this.jdField_a_of_type_AndroidContentContext, bccu.a().a(localDownloadInfo.b), localDownloadInfo.m, localDownloadInfo.a("big_brother_ref_source_key"));
    localDownloadInfo.w = BaseApplicationImpl.getApplication().getQQProcessName();
    bccu.a().b(localDownloadInfo, true);
    bcdj.c(localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.notice.NoticeReceiver.1
 * JD-Core Version:    0.7.0.1
 */