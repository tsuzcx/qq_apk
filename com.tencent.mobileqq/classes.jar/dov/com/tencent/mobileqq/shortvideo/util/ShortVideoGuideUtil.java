package dov.com.tencent.mobileqq.shortvideo.util;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResUtil;

public class ShortVideoGuideUtil
{
  public static String a = "ShortVideoGuideUtil";
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (!b(paramAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "isGuideReaded isPubicSo= false");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "isGuideReaded isPubicSo= true");
    }
    return true;
  }
  
  @Deprecated
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "startPTVActivity callback:" + paramString1 + ", supportVideo:" + paramString2 + ", supportPhoto:" + paramString3 + ", modeStr:" + paramString4 + ", beauty:" + paramString5 + ", unfoldStr:" + paramString6 + ", defaultStr:" + paramString7 + ", btnStr:" + paramString8 + ", dealStr:" + paramString9);
    }
    return true;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    boolean bool2 = PtvFilterSoLoad.a();
    boolean bool1;
    if (!bool2)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d(a, 2, "ispublicResReady iissupportFilterSo is false");
        bool1 = bool2;
      }
    }
    do
    {
      return bool1;
      if (VideoEnvironment.supportShortVideoRecordAndPlay()) {
        break;
      }
      bool1 = false;
    } while (!QLog.isColorLevel());
    QLog.d(a, 2, "ispublicResReady isVersion fasle");
    return false;
    return true;
  }
  
  public static boolean c(AppInterface paramAppInterface)
  {
    if (paramAppInterface.getCurrentAccountUin() == null) {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "isAccLoginSucdess false.");
      }
    }
    do
    {
      do
      {
        return false;
        if (a(paramAppInterface)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i(a, 2, "isGuideReaded false.");
      return false;
      if (!AEResUtil.c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(a, 2, "ispublicResReady iissupportFilterSo is false");
    return false;
    return VideoEnvironment.checkAndLoadAVCodec();
  }
  
  public static boolean d(AppInterface paramAppInterface)
  {
    if (VideoEnvironment.getShortVideoSoLibName() == null) {}
    do
    {
      do
      {
        return false;
        if (ShortVideoUtils.isVideoSoLibLoaded()) {
          break;
        }
      } while (!ShortVideoUtils.checkShortVideoSoReadyToLoad(paramAppInterface));
      ThreadManager.excute(new ShortVideoGuideUtil.1(), 64, null, false);
    } while ((AEResUtil.c()) || (!GestureMgr.a().a()) || (PtvFilterSoLoad.a() == 2));
    return true;
  }
  
  public static boolean e(AppInterface paramAppInterface)
  {
    if (VideoEnvironment.getShortVideoSoLibName() == null) {}
    do
    {
      return false;
      if (ShortVideoUtils.isVideoSoLibLoaded()) {
        break;
      }
      VideoEnvironment.loadAVCodecSo();
    } while (!ShortVideoUtils.isVideoSoLibLoaded());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil
 * JD-Core Version:    0.7.0.1
 */