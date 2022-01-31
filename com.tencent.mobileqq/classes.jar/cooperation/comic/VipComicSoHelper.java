package cooperation.comic;

import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import java.io.File;

public class VipComicSoHelper
{
  public static long a;
  
  public static String a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return new File(localBaseApplicationImpl.getFilesDir(), "comic_so").getAbsolutePath() + File.separator;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipComicSoHelper", 2, "initComicPlayerSoWithSubProcess");
    }
    Bundle localBundle = new Bundle();
    QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "getPlayerSo", localBundle, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (!new File(a() + "libqgplayer-lib.so").exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicSoHelper", 2, "initComicPlayerSo start download");
      }
      ((VasQuickUpdateManager)paramQQAppInterface.getManager(183)).a(1004L, "libqgplayer_760", "comic");
    }
    while (!QLog.isColorLevel()) {
      try
      {
        a = SystemClock.elapsedRealtime();
        DcReportUtil.a(paramQQAppInterface, "sendtdbank|b_sng_qqvip_qqcomic|soDownload", "1|" + a + "|0", true);
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    QLog.d("VipComicSoHelper", 2, "initComicPlayerSo has exists");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipComicSoHelper", 2, "onSoDownloadCompleted");
    }
    if (VasUtils.a(a() + "libQGamePlayer.zip", a(), "libqgplayer-lib.so")) {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicSoHelper", 2, "comic player unCompressSo success");
      }
    }
    for (;;)
    {
      try
      {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = a;
        DcReportUtil.a(paramQQAppInterface, "sendtdbank|b_sng_qqvip_qqcomic|soDownload", "2|" + (l1 - l2) + "|" + paramInt, true);
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipComicSoHelper", 2, "comic player unCompressSo failure");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.VipComicSoHelper
 * JD-Core Version:    0.7.0.1
 */