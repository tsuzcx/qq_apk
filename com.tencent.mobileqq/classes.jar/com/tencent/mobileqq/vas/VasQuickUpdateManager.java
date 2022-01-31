package com.tencent.mobileqq.vas;

import alof;
import android.text.TextUtils;
import bdhb;
import bdtn;
import bdug;
import bdul;
import bdwi;
import bdws;
import bdzf;
import com.google.gson.stream.JsonReader;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileReader;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class VasQuickUpdateManager
  implements Manager
{
  public static final long BID_BUBBLE = 2L;
  public static final long BID_CHATBG = 8L;
  public static final long BID_COLOR_NICK = 27L;
  public static final long BID_COLOR_SCREEN = 22L;
  public static final long BID_COMIC = 100L;
  public static final long BID_DEFAULT_CARD = 33L;
  public static final long BID_EMOTICON = 1L;
  public static final long BID_FACE = 23L;
  public static final long BID_FLASH_CHAT = 1002L;
  public static final long BID_FONT = 5L;
  public static final long BID_JSON = 1000L;
  public static final long BID_PENDANT = 4L;
  public static final long BID_POKE = 21L;
  public static final long BID_PRAISE = 20L;
  public static final long BID_PROFILE_CARD = 15L;
  public static final long BID_QUICKUPDATE_TEST = 1999L;
  public static final long BID_REDPACKET = 16L;
  public static final long BID_SIGNATURE_STICKER = 9L;
  public static final long BID_SINGLE_PIC = 1003L;
  public static final long BID_SONIC_TEMPLATE_UPDATE = 1001L;
  public static final long BID_STICKER_GUIDE_MATERIAL = 1004L;
  public static final long BID_TROOP_ENTER_EFFECT = 25L;
  public static final String QUICKUPDATE_TEST_DIR = bdzf.a(alof.aX + ".vas_quickupdate_test/");
  public static final String SCID_APNG_SO = "libAPNG_813";
  public static final String SCID_AVATARIN_PENDANT_JSON = "avatarInPendant_json";
  public static final String SCID_BLESS_VOICECHANGE = "blessVoiceList.json";
  public static final String SCID_BUBBLE_PASTER_PREFIX = "bubble.paster.";
  public static final String SCID_BUBBLE_PREFIX = "bubble.android.";
  public static final String SCID_CARD_PREFIX = "card.";
  public static final String SCID_CHANGEVOICE = "changeVoice_json";
  public static final String SCID_CHATBG_PREFIX = "chatbg.";
  public static final String SCID_COLORFONT_SO = "libColorFont_818";
  public static final String SCID_COLOR_NICK_PREFIX = "groupnickitem.";
  public static final String SCID_COLOR_SCREEN_PREFIX = "colorScreen.android.";
  public static final String SCID_COMIC_CONFIG = "vipComic_config_v2.json";
  public static final String SCID_COMIC_NAV_CONFIG = "vipComic_nav_config.json";
  public static final String SCID_COMIC_NAV_ICON = "vipComic_nav_tabIcon.zip";
  public static final String SCID_COMIC_PLAYER_SO = "libqgplayer_765";
  public static final String SCID_DEFAULT_CARD_CFG_PREFIX = "profileitem.";
  public static final String SCID_DEFAULT_FONT = "defaultFont_775";
  public static final String SCID_DIY_CARD_CONFIG = "card.diyFontConfig.json";
  public static final String SCID_DIY_CARD_FONT_PREFIX = "font.diycard.android.";
  public static final String SCID_EMOJI_KEYWORD = "keywordList_2.json";
  public static final String SCID_EMOTICON_RECOMMEND_EFFECT = "emotionRecommendEffect";
  public static final String SCID_ENTER_EFFECT_CONFIG = "groupeffect_config.json";
  public static final String SCID_ENTER_EFFECT_VIP_ICONS = "enterEffectVipIcons";
  public static final String SCID_FACE_PREFIX = "face.";
  public static final String SCID_FLASH_CHAT_PREFIX = "flashchat.";
  public static final String SCID_FLATBUFFERS = "libFlatBuffersParser";
  public static final String SCID_FONT_EFFECT = "magicFontConfig.json";
  public static final String SCID_FONT_FZ_PREFIX = "font.fzfont.android.";
  public static final String SCID_FONT_PREFIX = "font.main.android.";
  public static final String SCID_FUNCDEV_WEBVIEW = "VASBiz_FuncDev_webview.json";
  public static final String SCID_H5_MAGIC_ZIP = "bqmall.android.h5magic.";
  public static final String SCID_HIBOOM_CONFIG_PREFIX = "font.hiFontQQ.json.";
  public static final String SCID_HIBOOM_FONT_PREFIX = "font.hifont.android.";
  public static final String SCID_HIBOOM_TAG = "font.hiFontQQ.tags";
  public static final String SCID_HYFONT_SO = "libVipFont_808";
  public static final String SCID_KANDIAN_RECOMMENT_EMOTICON = "watch_focus.json";
  public static final String SCID_MAGIC_FACE_ENTRY_CONFIG = "emoji_app_vip_emoji_aio_android_config.json";
  public static final String SCID_PENDANT_FONT_PREFIX = "faceAddon.stickerFont.android.";
  public static final String SCID_PENDANT_MARKET_CONFIG = "pendant_market_json.android.v2";
  public static final String SCID_PENDANT_PASTER_PREFIX = "faceAddon.sticker.";
  public static final String SCID_PENDANT_PREFIX = "pendant.";
  public static final String SCID_PERSONAL_CONFIG = "vip_personal_card.json";
  public static final String SCID_POKE_EFFECT_LIST = "poke.effectList";
  public static final String SCID_POKE_EFFECT_PREFIX = "poke.item.res.";
  public static final String SCID_POKE_PANEL_PREFIX = "poke.item.effect.";
  public static final String SCID_PRAISE_CONFIG = "praise.config.json";
  public static final String SCID_PRAISE_PREFIX = "praise.android.";
  public static final String SCID_QUICKUPDATE_TEST_JSON = "scupdate.test.signgle.json";
  public static final String SCID_QUICKUPDATE_TEST_MULTI = "scupdate.test.multi.zip";
  public static final String SCID_QUICKUPDATE_TEST_PRECONFIG = "scupdate.test.2087.cfg";
  public static final String SCID_QUICKUPDATE_TEST_PREFIX = "scupdate.test.";
  public static final String SCID_QUICKUPDATE_TEST_SINGLE = "scupdate.test.single.zip";
  public static final String SCID_REDPACKET_300CHAR = "iRedPacket_v3.char300.json";
  public static final String SCID_REDPACKET_CONFIG = "iRedPacket_v3.json";
  public static final String SCID_REDPACKET_FONT_ZIP = "iRedPacket_v3.font.zip";
  public static final String SCID_REDPACKET_PACKETS_ZIP = "luckyMoney.item.";
  public static final String SCID_REDPACKET_SPECIAL_ZIP = "iRedPacket_v3.specialChar.zip";
  public static final String SCID_SIGNATURE_STICKER_PREFIX = "signature.sticker.";
  public static final String SCID_SIGNATURE_TEMPLATE_CONFIG_PREFIX = "signature.item.";
  public static final String SCID_SONIC_FILE_DISCARD = "sonicTemplateUpdate.json";
  public static final String SCID_STICKER_MATERIAL = "emojiStickerGuideZip_v2";
  public static final String SCID_SYSTEM_EMOJI_WHITE_LIST = "emoji.systemEmojiWhiteList.json";
  public static final String SCID_THEME_DIY_BG = "diytheme.json";
  public static final String SCID_THEME_DIY_STYLE = "diytheme.style.json";
  public static final String SCID_TROOP_ENTER_EFFECT_PREFIX = "groupeffect_item_";
  public static final String SCID_URL_CONFIGURABLE = "vipData_individuation_url.android.json";
  public static final String SCID_VAS_MONITOR_BLACKLIST = "monitorAppid";
  public static final String SCID_WEBVIEW_TITLE_CONFIG = "vipData_app_webviewNavStyle.json";
  public static final String SCID_WZRY_TEMPLATE = "cardWZ.zip";
  public static final String SP_QUICK_UPDATE_PREFIX = "quick_update_";
  private static final String TAG = "VasQuickUpdateManager";
  public QQAppInterface app;
  ConcurrentHashMap<Integer, VasQuickUpdateManager.CallBacker> callBackers = new ConcurrentHashMap();
  private bdwi defaultCallback = new VasQuickUpdateManager.2(this);
  VasQuickUpdateEngine mEngine;
  AtomicInteger mKey = new AtomicInteger(0);
  bdul mQuickUpdateObserver = new VasQuickUpdateManager.1(this);
  
  public VasQuickUpdateManager(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    initEngine();
    paramQQAppInterface.addObserver(this.mQuickUpdateObserver);
  }
  
  /* Error */
  public static void cleanCache()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 376	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: ldc 165
    //   13: invokestatic 380	com/tencent/mobileqq/vas/VasQuickUpdateManager:deleteJSON	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokestatic 385	com/tencent/mobileqq/theme/ThemeCleaner:a	(Landroid/content/Context;)V
    //   20: aload_0
    //   21: invokestatic 388	bdws:a	(Landroid/content/Context;)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: ldc_w 288
    //   31: iconst_1
    //   32: ldc_w 390
    //   35: invokestatic 396	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: goto -14 -> 24
    //   41: astore_0
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	15	0	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    //   41	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	41	finally
    //   11	24	41	finally
    //   28	38	41	finally
  }
  
  public static void deleteJSON(String paramString)
  {
    try
    {
      paramString = new File(BaseApplicationImpl.getApplication().getFilesDir() + File.separator + paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static File getFileFromLocal(AppRuntime paramAppRuntime, long paramLong, String paramString1, String paramString2, boolean paramBoolean, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (paramAppRuntime != null) {
        str = paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString1;
      }
    }
    if (TextUtils.isEmpty(str))
    {
      QLog.e("VasQuickUpdateManager", 1, "getFileFromLocal err filePath, bid=" + paramLong + ",scid:" + paramString1 + ", app=" + paramAppRuntime + ", filePaht=" + str);
      return null;
    }
    File localFile = new File(str);
    paramString2 = localFile;
    if (!localFile.exists())
    {
      if (!paramBoolean) {
        break label379;
      }
      if (paramAppRuntime == null) {
        break label249;
      }
      paramString2 = paramAppRuntime.getManager(184);
      if ((paramString2 != null) && ((paramString2 instanceof VasQuickUpdateManager))) {
        break label255;
      }
      QLog.e("VasQuickUpdateManager", 1, "getFileFromLocal, Err0, bid=" + paramLong + ",scid:" + paramString1 + ", mgr:" + paramString2 + ", app=" + paramAppRuntime + ", filePaht=" + str);
      paramString2 = null;
    }
    for (;;)
    {
      return paramString2;
      label249:
      paramString2 = null;
      break;
      label255:
      paramString2 = (VasQuickUpdateManager)paramString2;
      paramString2.addCallBacker(paramCallBacker);
      if (16L == paramLong)
      {
        paramAppRuntime = "getFileFromLocal_redPacket";
        if (("iRedPacket_v3.json".equals(paramString1)) || ("iRedPacket_v3.char300.json".equals(paramString1)) || ("iRedPacket_v3.font.zip".equals(paramString1)) || ("iRedPacket_v3.specialChar.zip".equals(paramString1))) {
          paramAppRuntime = "silent_download.redbag" + paramString1;
        }
        paramString2.downloadItem(paramLong, paramString1, paramAppRuntime);
        paramString2 = null;
      }
      else
      {
        paramString2.downloadItem(paramLong, paramString1, "getFileFromLocal_" + paramLong);
        label379:
        paramString2 = null;
      }
    }
  }
  
  public static JSONObject getJSONFromLocal(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("VasQuickUpdateManager", 1, "getJSONFromLocal, app == null; scid:" + paramString + ", app=" + paramAppRuntime);
      return null;
    }
    Object localObject = new File(paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString);
    if (((File)localObject).exists()) {
      try
      {
        JSONObject localJSONObject = new JSONObject(bdhb.a((File)localObject));
        return localJSONObject;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasQuickUpdateManager", 2, "getJsonOOM,json_name:" + paramString, localThrowable);
        }
        ((File)localObject).delete();
      }
    }
    if (paramBoolean)
    {
      localObject = paramAppRuntime.getManager(184);
      if ((localObject == null) || (!(localObject instanceof VasQuickUpdateManager)))
      {
        QLog.e("VasQuickUpdateManager", 1, "getJSONFromLocal, manager == null; scid:" + paramString + ", mgr:" + localObject + ", app=" + paramAppRuntime);
        return null;
      }
      paramAppRuntime = (VasQuickUpdateManager)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "getJSONFromLocal addCallBacker:" + paramString);
      }
      paramAppRuntime.addCallBacker(paramCallBacker);
      paramAppRuntime.downloadItem(1000L, paramString, "getJSONFromLocal");
    }
    return null;
  }
  
  public static JsonReader getJSONFromLocalByStreamRead(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("VasQuickUpdateManager", 1, "getJSONFromLocalByStreamRead, app == null; scid:" + paramString + ", app=" + paramAppRuntime);
      return null;
    }
    Object localObject = new File(paramAppRuntime.getApplication().getFilesDir() + File.separator + paramString);
    if (((File)localObject).exists()) {
      try
      {
        JsonReader localJsonReader = new JsonReader(new FileReader((File)localObject));
        return localJsonReader;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasQuickUpdateManager", 2, "getJSONFromLocalByStreamRead error,json_name:" + paramString, localThrowable);
        }
        ((File)localObject).delete();
      }
    }
    if (paramBoolean)
    {
      localObject = paramAppRuntime.getManager(184);
      if ((localObject == null) || (!(localObject instanceof VasQuickUpdateManager)))
      {
        QLog.e("VasQuickUpdateManager", 1, "getJSONFromLocalByStreamRead, manager == null; scid:" + paramString + ", mgr:" + localObject + ", app=" + paramAppRuntime);
        return null;
      }
      paramAppRuntime = (VasQuickUpdateManager)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateManager", 2, "getJSONFromLocalByStreamRead addCallBacker:" + paramString);
      }
      paramAppRuntime.addCallBacker(paramCallBacker);
      paramAppRuntime.downloadItem(1000L, paramString, "getJSONFromLocal");
    }
    return null;
  }
  
  private void initEngine()
  {
    if (FlatBuffersParser.c()) {}
    do
    {
      return;
      QLog.e("VasQuickUpdateManager", 1, "initEngine: " + this);
      this.mEngine = VasQuickUpdateEngine.getInstance();
      bdws.a(this.defaultCallback);
      this.mEngine.mWeakHandler = new WeakReference((bdug)this.app.a(71));
    } while ((this.mEngine.mUpdateManagerInstance == 0L) || (!this.mEngine.engineReady.get()));
    this.mEngine.nativeupdateAllItem(this.mEngine.mUpdateManagerInstance);
  }
  
  public void addCallBacker(VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    if (paramCallBacker == null) {}
    while (this.callBackers.containsValue(paramCallBacker)) {
      return;
    }
    int i = this.mKey.addAndGet(1);
    this.callBackers.put(Integer.valueOf(i), paramCallBacker);
    paramCallBacker.key = i;
  }
  
  public void addWeakCallback(VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    Object localObject = this.callBackers.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      VasQuickUpdateManager.CallBacker localCallBacker = (VasQuickUpdateManager.CallBacker)((Iterator)localObject).next();
      if (((localCallBacker instanceof VasQuickUpdateManager.WeakCallbacker)) && (((VasQuickUpdateManager.WeakCallbacker)localCallBacker).isWrapOf(paramCallBacker))) {
        return;
      }
    }
    localObject = new VasQuickUpdateManager.WeakCallbacker(paramCallBacker);
    addCallBacker((VasQuickUpdateManager.CallBacker)localObject);
    paramCallBacker.key = ((VasQuickUpdateManager.WeakCallbacker)localObject).key;
  }
  
  public void callBackToAll(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("VasQuickUpdateManager", 2, "callBackToAll Error bid = " + paramLong + ", cfgScid=" + paramString2 + ",scid = " + paramString1 + ", from = " + paramString3 + ", errorCode = " + paramInt1);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.callBackers.values().iterator();
      while (localIterator.hasNext()) {
        ((VasQuickUpdateManager.CallBacker)localIterator.next()).callback(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2, this);
      }
    }
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "cancelDwonloadItem bid = " + paramLong + " scid = " + paramString);
    }
    if (this.mEngine != null) {
      this.mEngine.cancelDwonloadItem(paramLong, paramString);
    }
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "downloadGatherItem bid = " + paramLong + " scid = " + paramString1 + " scidList = " + TextUtils.join(",", paramArrayOfString) + " from = " + paramString2);
    }
    if (this.mEngine != null) {
      this.mEngine.downloadGatherItem(paramLong, paramString1, paramArrayOfString, paramString2);
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateManager", 2, "downloadItem bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString2);
    }
    if (this.mEngine != null) {
      this.mEngine.downloadItem(paramLong, paramString1, paramString2);
    }
  }
  
  public void onDestroy()
  {
    QLog.e("VasQuickUpdateManager", 1, "onDestroy: " + this);
    this.app.removeObserver(this.mQuickUpdateObserver);
    if (this.mEngine != null) {
      bdws.b(this.defaultCallback);
    }
    this.callBackers.clear();
  }
  
  public void onProgressToAll(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      QLog.e("VasQuickUpdateManager", 2, "callBackToAll Error bid = " + paramLong1 + ", cfgScid=" + paramString2 + ",scid = " + paramString1);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.callBackers.values().iterator();
      while (localIterator.hasNext()) {
        ((VasQuickUpdateManager.CallBacker)localIterator.next()).onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
      }
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, bdtn parambdtn)
  {
    if (this.mEngine != null)
    {
      parambdtn = new VasQuickUpdateManager.TimeoutWrapper(parambdtn, paramBoolean2, null);
      if (paramLong > 0L) {
        ThreadManager.getSubThreadHandler().postDelayed(parambdtn, paramLong);
      }
      this.mEngine.queryItemVersion(paramInt, paramString, paramBoolean1, parambdtn);
      return;
    }
    parambdtn.a(2, "", "");
  }
  
  public void removeCallBacker(VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    if (paramCallBacker == null) {
      return;
    }
    this.callBackers.remove(Integer.valueOf(paramCallBacker.key));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager
 * JD-Core Version:    0.7.0.1
 */