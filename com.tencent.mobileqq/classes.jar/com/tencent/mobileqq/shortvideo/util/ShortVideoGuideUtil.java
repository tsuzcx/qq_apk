package com.tencent.mobileqq.shortvideo.util;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMWebEffectCameraCaptureUnit;
import dov.com.qq.im.ae.download.AEResUtil;

public class ShortVideoGuideUtil
{
  public static String a = "ShortVideoGuideUtil";
  private static String b = null;
  private static String c = "";
  
  public static void a(Activity paramActivity)
  {
    if (!TextUtils.isEmpty(c))
    {
      Intent localIntent = new Intent();
      localIntent.setClassName("com.tencent.mobileqq", SendWebPicActivity.class.getName());
      localIntent.putExtra("edit_video_call_back", b);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", c);
      localIntent.setFlags(536870912);
      paramActivity.startActivity(localIntent);
    }
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, int paramInt)
  {
    paramAppInterface = new Intent(paramActivity, StoryTransitionActivity.class);
    paramAppInterface.putExtra("jump_action", 6);
    paramAppInterface.putExtra("web_target_type", paramInt);
    paramActivity.startActivity(paramAppInterface);
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "startPTVActivity , supportVideo:" + paramString1 + ", supportPhoto:" + paramString2 + ", cameraMode:" + paramString3 + ", beauty:" + paramString4 + ", unfoldDDStr:" + paramString6 + ", dDCategoryName:" + paramString7 + ", dDItemID:" + paramString8 + ", dealType:" + paramString10 + ", callback:" + paramString11 + ", topicId:" + paramString12 + ", topicName:" + paramString13 + ", adTag=" + paramString14);
    }
    boolean bool1 = "1".equals(paramString1);
    boolean bool2 = "1".equals(paramString2);
    int i;
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    if ("1".equals(paramString3))
    {
      i = 2;
      bool3 = "1".equals(paramString4);
      bool4 = "1".equals(paramString5);
      bool5 = "1".equals(paramString9);
      bool6 = "1".equals(paramString6);
      if (!"1".equals(paramString10)) {
        break label246;
      }
    }
    label246:
    for (int j = 1;; j = 0)
    {
      if (CaptureUtil.a()) {
        break label252;
      }
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "supportMediaCodec = false");
      }
      return false;
      i = 1;
      break;
    }
    label252:
    paramString1 = QIMWebEffectCameraCaptureUnit.a(bool1, bool2, i, bool3, bool4, bool6, paramString7, paramString8, bool5, j, paramString11, paramString12, paramString13, paramString14, paramInt);
    paramString2 = new Intent(paramActivity, StoryTransitionActivity.class);
    paramString2.putExtras(paramString1);
    paramString2.putExtra("jump_action", 7);
    paramActivity.startActivity(paramString2);
    return true;
  }
  
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
    } while (!CaptureUtil.a());
    return VideoEnvironment.checkAndLoadAVCodec();
  }
  
  public static boolean d(AppInterface paramAppInterface)
  {
    boolean bool = VideoEnvironment.supportShortVideoRecordAndPlay();
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(a, 2, "isMobileSupportPTV false");
    }
    return bool;
  }
  
  public static boolean e(AppInterface paramAppInterface)
  {
    boolean bool = PtvFilterSoLoad.a();
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(a, 2, "issupportFilterSo false");
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil
 * JD-Core Version:    0.7.0.1
 */