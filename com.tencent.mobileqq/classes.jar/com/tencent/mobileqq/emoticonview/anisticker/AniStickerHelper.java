package com.tencent.mobileqq.emoticonview.anisticker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.download.AniStickerResReloaderMgr;
import com.tencent.mobileqq.emoticonview.download.BaseLottieResDownloader;
import com.tencent.mobileqq.emoticonview.download.LottieResDownloadFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class AniStickerHelper
{
  public static final int LOTTIE_ANIM_SIZE = Utils.a(171.0F, MobileQQ.getContext().getResources());
  private static final String TAG = "AniStickerHelper";
  
  public static void clearAniStickerCache()
  {
    AniStickerSvgHelper.clearCache();
    AniStickerLottieView.clearReloadCacheKey();
    AniStickerResReloaderMgr.getInstance().clearReloadList();
  }
  
  static boolean isChangeAniSticker(AniStickerLottieView paramAniStickerLottieView, AniStickerInfo paramAniStickerInfo)
  {
    if (paramAniStickerInfo.localId != paramAniStickerLottieView.localId)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerHelper", 2, "localId change. lottieView is used.");
      }
      return true;
    }
    if ((paramAniStickerInfo.randomKey != null) && (!paramAniStickerInfo.randomKey.equals(paramAniStickerLottieView.randomKey)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerHelper", 2, "randomKey change. lottieView is used.");
      }
      return true;
    }
    if ((paramAniStickerInfo.getSurpriseId() != null) && (!paramAniStickerInfo.getSurpriseId().equals(paramAniStickerLottieView.surpriseId)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerHelper", 2, "surpriseId change. lottieView is used.");
      }
      return true;
    }
    return false;
  }
  
  private static void loadSvgLoadingThumb(AniStickerLottieView paramAniStickerLottieView, String paramString, @DrawableRes int paramInt)
  {
    QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean localSystemAndEmojiConfBean = QQSysAndEmojiConfProcessor.a();
    if ((paramString != null) && (localSystemAndEmojiConfBean != null))
    {
      long l = System.currentTimeMillis();
      if (QQTheme.isNowThemeIsNight()) {
        localObject = "#1A1A1A";
      } else {
        localObject = "#D8DAE3";
      }
      int i = Color.parseColor((String)localObject);
      Object localObject = AniStickerSvgHelper.getAniStickerSvgThumbFromCache(paramString, localSystemAndEmojiConfBean.h, localSystemAndEmojiConfBean.i, i, 1.0F, 1.0F);
      if (localObject == null)
      {
        paramString = AniStickerSvgHelper.syncGetAniStickerSvgThumbFromFile(paramString, localSystemAndEmojiConfBean.h, localSystemAndEmojiConfBean.i, i, 1.0F, 1.0F);
      }
      else
      {
        paramString = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("AniStickerHelper", 2, "svgThumb load from cache.");
          paramString = (String)localObject;
        }
      }
      if (paramString != null)
      {
        paramString.setSupportGradientAnim(true);
        paramString.setCallback(paramAniStickerLottieView);
        paramAniStickerLottieView.stickerLoadingDrawable = paramString;
      }
      else
      {
        paramAniStickerLottieView.stickerLoadingDrawable = paramAniStickerLottieView.getContext().getResources().getDrawable(paramInt);
        QLog.e("AniStickerHelper", 2, "svgThumb is null.");
      }
      if (QLog.isColorLevel())
      {
        paramAniStickerLottieView = new StringBuilder();
        paramAniStickerLottieView.append("load svg path. cost: ");
        paramAniStickerLottieView.append(System.currentTimeMillis() - l);
        QLog.d("AniStickerHelper", 2, paramAniStickerLottieView.toString());
      }
    }
    else
    {
      paramAniStickerLottieView.stickerLoadingDrawable = paramAniStickerLottieView.getContext().getResources().getDrawable(paramInt);
    }
  }
  
  private static void runOnFileThread(boolean paramBoolean, Runnable paramRunnable)
  {
    if ((paramBoolean) && (Looper.myLooper() == Looper.getMainLooper()))
    {
      ThreadManagerV2.excute(new AniStickerHelper.2(paramRunnable), 64, null, false);
      return;
    }
    paramRunnable.run();
  }
  
  private static void scheduleSetAniStickerRes(@NotNull AniStickerHelper.Builder paramBuilder)
  {
    runOnFileThread(AniStickerSvgHelper.hasSvgResCommandCache(paramBuilder.svgLocalPath) ^ true, new AniStickerHelper.1(paramBuilder));
  }
  
  public static String setAniStickerRandomLastFrameResource(@NotNull AniStickerHelper.Builder paramBuilder)
  {
    if ((paramBuilder != null) && (paramBuilder.lottieView != null))
    {
      paramBuilder.showLoading(true).randomAniSticker(true).showLastFrame(true);
      setAniStickerResource(paramBuilder);
      return paramBuilder.lottieView.randomKey;
    }
    QLog.e("AniStickerHelper", 2, "set AniStickerRandomLastFrameResource lottieView is null. ");
    return null;
  }
  
  public static String setAniStickerRandomResource(@NotNull AniStickerHelper.Builder paramBuilder)
  {
    if ((paramBuilder != null) && (paramBuilder.lottieView != null))
    {
      paramBuilder.showLoading(true).randomAniSticker(true).resultId(null).surpriseId(null).showLastFrame(false);
      setAniStickerResource(paramBuilder);
      return paramBuilder.lottieView.randomKey;
    }
    QLog.e("AniStickerHelper", 2, "set AniStickerRandomResource lottieView is null. ");
    return null;
  }
  
  private static void setAniStickerRandomResourceSync(AniStickerHelper.Builder paramBuilder, AniStickerInfo paramAniStickerInfo)
  {
    BaseLottieResDownloader localBaseLottieResDownloader = (BaseLottieResDownloader)LottieResDownloadFactory.createLottieResDownloader(1);
    if (localBaseLottieResDownloader == null)
    {
      QLog.e("AniStickerHelper", 2, "sec lottieResDownloader is null.");
      return;
    }
    if (paramAniStickerInfo == null)
    {
      QLog.e("AniStickerHelper", 2, "sec stickerInfo is null.");
      return;
    }
    AniStickerLottieView localAniStickerLottieView = paramBuilder.lottieView;
    if (isChangeAniSticker(localAniStickerLottieView, paramAniStickerInfo))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerHelper", 2, "sec load svg after lottieView is used.");
      }
      return;
    }
    localAniStickerLottieView.resutId = paramAniStickerInfo.getResultId();
    localAniStickerLottieView.randomKey = paramAniStickerInfo.randomKey;
    localBaseLottieResDownloader.setOptions(paramAniStickerInfo);
    if (!AniStickerLottie.lottieEnabled()) {
      return;
    }
    localBaseLottieResDownloader.loadLottieRes(null, paramBuilder, new AniStickerHelper.4(localAniStickerLottieView, paramAniStickerInfo));
    if (QLog.isColorLevel()) {
      QLog.d("AniStickerHelper", 2, "sec set lottie res. ");
    }
  }
  
  public static void setAniStickerRandomResultResource(@NotNull AniStickerHelper.Builder paramBuilder)
  {
    if ((paramBuilder != null) && (paramBuilder.lottieView != null) && (!TextUtils.isEmpty(paramBuilder.lottieView.randomKey)) && (!TextUtils.isEmpty(paramBuilder.resultId)))
    {
      AniStickerLottieView.setAniStickerRandomResult(paramBuilder.lottieView, paramBuilder.resultId);
      paramBuilder.lottieView.secRandomResultPlayListener = paramBuilder.listener;
      paramBuilder.localId(paramBuilder.lottieView.localId).randomKey(paramBuilder.lottieView.randomKey).resultId(paramBuilder.resultId).build();
      AniStickerInfo localAniStickerInfo = QQSysFaceUtil.getAniStickerInfo(paramBuilder.localId, paramBuilder.resultId, null);
      if (localAniStickerInfo == null)
      {
        QLog.e("AniStickerHelper", 2, "sec randomResultResource aniStickerInfo is null.");
        return;
      }
      localAniStickerInfo.randomKey = paramBuilder.randomKey;
      setAniStickerRandomResourceSync(paramBuilder, localAniStickerInfo);
      return;
    }
    QLog.e("AniStickerHelper", 2, "randomKey or resultId is null.");
  }
  
  public static void setAniStickerRandomSurpriseResource(@NotNull AniStickerHelper.Builder paramBuilder)
  {
    if ((paramBuilder != null) && (paramBuilder.lottieView != null))
    {
      paramBuilder.showLoading(false).randomAniSticker(false).resultId(null).showLastFrame(false);
      setAniStickerResource(paramBuilder);
      return;
    }
    QLog.e("AniStickerHelper", 2, "setAniStickerRandomSurpriseResource lottieView is null. ");
  }
  
  public static void setAniStickerResource(@NotNull AniStickerHelper.Builder paramBuilder)
  {
    if (paramBuilder == null)
    {
      QLog.e("AniStickerHelper", 2, "setAniStickerResource builder is null. ");
      return;
    }
    AniStickerLottieView localAniStickerLottieView = paramBuilder.lottieView;
    int i = paramBuilder.localId;
    int j = paramBuilder.placeholderDrawable;
    boolean bool3 = paramBuilder.showLoading;
    boolean bool4 = paramBuilder.randomAniSticker;
    String str1 = paramBuilder.resultId;
    boolean bool5 = paramBuilder.showLastFrame;
    String str2 = paramBuilder.surpriseId;
    Object localObject = paramBuilder.listener;
    if (localAniStickerLottieView == null)
    {
      QLog.e("AniStickerHelper", 2, "setAniStickerResource lottieView is null. ");
      return;
    }
    localAniStickerLottieView.secRandomResultPlayListener = null;
    localAniStickerLottieView.defRandomResultPlayListener = ((AniStickerAnimationListener)localObject);
    if (((localAniStickerLottieView.isAnimating()) || (localAniStickerLottieView.getDrawable() != null)) && (localAniStickerLottieView.localId == i) && (i != -1) && (str2 == null) && (!bool4) && (localAniStickerLottieView.randomKey == null))
    {
      if ((localAniStickerLottieView.getIsEnable()) && (!localAniStickerLottieView.isAnimating())) {
        localAniStickerLottieView.reDraw();
      }
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerHelper", 2, "same lottieView is running.");
      }
      return;
    }
    if ((localAniStickerLottieView.getDrawable() != null) && (bool5) && (localAniStickerLottieView.localId == i) && (str1 != null) && (str1.equals(localAniStickerLottieView.resutId)))
    {
      if (QLog.isColorLevel())
      {
        paramBuilder = new StringBuilder();
        paramBuilder.append("resultId is same. reuse res. ");
        paramBuilder.append(i);
        QLog.d("AniStickerHelper", 2, paramBuilder.toString());
      }
      return;
    }
    localAniStickerLottieView.clearLottieDrawable();
    localAniStickerLottieView.clearSecondLottieDrawable();
    localObject = QQSysFaceUtil.getAniStickerInfo(i, str1, str2);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerHelper", 2, "stickerInfo is null, show default loading icon.");
      }
      localAniStickerLottieView.stickerLoadingDrawable = localAniStickerLottieView.getContext().getResources().getDrawable(j);
      localAniStickerLottieView.postInvalidate();
      return;
    }
    String str3 = QQSysAndEmojiResMgr.getSvgResSavePath(((AniStickerInfo)localObject).aniStickerPackId, ((AniStickerInfo)localObject).aniStickerId);
    boolean bool1 = TextUtils.isEmpty(str3);
    boolean bool2 = true;
    if (bool1)
    {
      QLog.e("AniStickerHelper", 1, "svgLocalPath is null.");
      return;
    }
    localAniStickerLottieView.defaultLoadingRes = j;
    if (localAniStickerLottieView.localId != i)
    {
      bool1 = bool2;
      if (bool3) {}
    }
    else if ((i == localAniStickerLottieView.localId) && (str1 != null) && (!str1.equals(localAniStickerLottieView.resutId)) && (bool3))
    {
      bool1 = bool2;
    }
    else
    {
      bool1 = false;
    }
    localAniStickerLottieView.localId = i;
    localAniStickerLottieView.resutId = str1;
    localAniStickerLottieView.surpriseId = str2;
    localAniStickerLottieView.showLastFrame = bool5;
    localAniStickerLottieView.playFrameFinish = false;
    ((AniStickerInfo)localObject).setResultId(str1);
    ((AniStickerInfo)localObject).setSurpriseId(str2);
    if (bool4) {
      localAniStickerLottieView.randomKey = UUID.randomUUID().toString();
    } else {
      localAniStickerLottieView.randomKey = null;
    }
    ((AniStickerInfo)localObject).randomKey = localAniStickerLottieView.randomKey;
    paramBuilder.localId(i).placeholderDrawable(j).showLoading(bool3).stickerInfo((AniStickerInfo)localObject).svgLocalPath(str3).showLoading(bool1);
    scheduleSetAniStickerRes(paramBuilder);
  }
  
  private static void setAxrLottieDrawableSync(AniStickerHelper.Builder paramBuilder)
  {
    AniStickerLottieView localAniStickerLottieView = paramBuilder.lottieView;
    String str = paramBuilder.svgLocalPath;
    AniStickerInfo localAniStickerInfo = paramBuilder.stickerInfo;
    int i = paramBuilder.placeholderDrawable;
    BaseLottieResDownloader localBaseLottieResDownloader = (BaseLottieResDownloader)LottieResDownloadFactory.createLottieResDownloader(1);
    if (localBaseLottieResDownloader == null)
    {
      QLog.e("AniStickerHelper", 2, "lottieResDownloader is null.");
      return;
    }
    if (localAniStickerInfo == null)
    {
      QLog.e("AniStickerHelper", 2, "stickerInfo is null.");
      return;
    }
    if (isChangeAniSticker(localAniStickerLottieView, localAniStickerInfo)) {
      return;
    }
    localBaseLottieResDownloader.setOptions(localAniStickerInfo);
    if (!AniStickerLottie.lottieEnabled()) {
      return;
    }
    if (!AniStickerLottieView.isAddPauseCache(localAniStickerLottieView, localBaseLottieResDownloader.getCacheKey()))
    {
      localBaseLottieResDownloader.loadLottieRes(str, paramBuilder, new AniStickerHelper.3(localAniStickerLottieView, localAniStickerInfo, i));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AniStickerHelper", 2, "addPauseCache no load res.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper
 * JD-Core Version:    0.7.0.1
 */