package com.tencent.mobileqq.emoticonview.anisticker;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rlottie.AXrLottie;
import com.tencent.rlottie.AXrLottieCacheManager;
import mqq.app.MobileQQ;

public class AniStickerLottie
{
  public static final String CACHE_CLEAR_TAG = "AniStickerCache";
  public static final String CACHE_SIGNATURE = "qq_emoticon_res";
  private static boolean LOTTIE_CACHE_ENABLE = false;
  public static final String LOTTIE_CACHE_MD5 = "lottie_cache_md5";
  private static boolean LOTTIE_SO_READY = false;
  public static final String TAG = "AniStickerLottie";
  
  public static boolean cacheEnabled()
  {
    return LOTTIE_CACHE_ENABLE;
  }
  
  public static void clearCache()
  {
    try
    {
      setCacheEnabled(false);
      AXrLottie.a(MobileQQ.getContext());
      QLog.d("AniStickerLottie", 1, new Object[] { "clear cache, setting,  isSuccess:", Boolean.valueOf(AXrLottie.c(MobileQQ.getContext()).a()) });
      setCacheEnabled(true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static SharedPreferences getSp()
  {
    return BaseApplication.getContext().getSharedPreferences("qq_emoticon_sp", 4);
  }
  
  public static void init()
  {
    LOTTIE_SO_READY = AXrLottie.a(MobileQQ.getContext());
    if (!LOTTIE_SO_READY) {
      return;
    }
    AXrLottie.c(null).b("qq_emoticon_res");
    AXrLottie.c(null).a(new AniStickerLottie.1());
  }
  
  public static boolean lottieEnabled()
  {
    return LOTTIE_SO_READY;
  }
  
  public static boolean needClearEmoticonLottieCache()
  {
    SharedPreferences localSharedPreferences = getSp();
    String str1 = localSharedPreferences.getString("md5_type_5", "");
    String str2 = localSharedPreferences.getString("lottie_cache_md5", "");
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.d("AniStickerLottie", 2, new Object[] { "cacheMd5:", str2, " newMd5:", str1 });
    }
    if ((TextUtils.isEmpty(str2)) || (str2.equals(str1))) {
      bool1 = false;
    }
    if ((TextUtils.isEmpty(str2)) || (bool1)) {
      localSharedPreferences.edit().putString("lottie_cache_md5", str1).apply();
    }
    return bool1;
  }
  
  public static void refreshCache()
  {
    try
    {
      setCacheEnabled(false);
      AXrLottieCacheManager localAXrLottieCacheManager = AXrLottie.c(MobileQQ.getContext());
      boolean bool1 = needClearEmoticonLottieCache();
      boolean bool2 = localAXrLottieCacheManager.c();
      if ((!bool1) && (bool2)) {
        setCacheEnabled(true);
      } else {
        ThreadManager.excute(new AniStickerLottie.2(bool1, bool2), 64, null, false);
      }
      return;
    }
    finally {}
  }
  
  public static void refreshCacheSync(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      AXrLottie.a(MobileQQ.getContext());
      AXrLottieCacheManager localAXrLottieCacheManager = AXrLottie.c(MobileQQ.getContext());
      if (paramBoolean1) {
        QLog.d("AniStickerLottie", 1, new Object[] { "clear cache, emoticon,  isSuccess:", Boolean.valueOf(localAXrLottieCacheManager.a("qq_emoticon_res")) });
      }
      if (!paramBoolean2)
      {
        localAXrLottieCacheManager.d();
        QLog.d("AniStickerLottie", 1, "clear cache, over Limit");
      }
      setCacheEnabled(true);
      return;
    }
    finally {}
  }
  
  public static boolean setCacheEnabled(boolean paramBoolean)
  {
    LOTTIE_CACHE_ENABLE = paramBoolean;
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie
 * JD-Core Version:    0.7.0.1
 */