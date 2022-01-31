package com.tencent.mobileqq.vas;

import ajtl;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public final class IndividuationUrlHelper
{
  private static final String A;
  private static final String B;
  private static final String C;
  private static final String D;
  private static final String E;
  private static final String F;
  private static final String G;
  private static final String jdField_a_of_type_JavaLangString;
  public static HashMap a;
  private static Map jdField_a_of_type_JavaUtilMap;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static final String jdField_b_of_type_JavaLangString;
  private static Map jdField_b_of_type_JavaUtilMap;
  private static final String jdField_c_of_type_JavaLangString;
  private static Map jdField_c_of_type_JavaUtilMap;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final String g;
  private static final String h;
  private static final String i;
  private static final String j;
  private static final String k;
  private static final String l;
  private static final String m;
  private static final String n;
  private static final String o;
  private static final String p;
  private static final String q;
  private static final String r;
  private static final String s;
  private static final String t;
  private static final String u;
  private static final String v;
  private static final String w;
  private static final String x;
  private static final String y;
  private static final String z;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uin=[uin]").append("&client=androidQQ").append("&version=").append("7.6.0.3525").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]");
    C = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://zb.vip.qq.com/sonic/theme");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=16782337").append("&asyncMode=3");
    jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://zb.vip.qq.com/theme/detail");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=16782337").append("&id=[id]");
    jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://zb.vip.qq.com/sonic/bubble");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=16778243&_wwv=64&_nav_txtclr=ffffff&_nav_titleclr=ffffff").append("&asyncMode=3");
    jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    d = "http://zb.vip.qq.com/collection/aio?_wv=1027&id=[id]&_preload=1&type=bubble";
    localObject = new StringBuilder("http://zb.vip.qq.com/bubble");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=1027").append("&asyncMode=3");
    e = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/emoji");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=16778243").append("&asyncMode=3");
    f = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/bq/html/detail.html");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=16778241").append("&_bid=102").append("&type=view").append("&id=[id]").append("&_lv=0");
    g = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/bq/html/author.html");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=3").append("&_bid=102").append("&type=view").append("&id=[id]");
    h = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://zb.vip.qq.com/sonic/widget");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=3").append("&asyncMode=3");
    i = ((StringBuilder)localObject).toString();
    m = "https://zb.vip.qq.com/face/index?_wv=16778243&_wvx=3";
    k = "https://zb.vip.qq.com/widget/mine?_wv=16782339&_wvx=3";
    j = "http://zb.vip.qq.com/collection/aio?_wv=1027&id=[id]&_preload=1&type=widget";
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/head_pendant/html/index.html");
    ((StringBuilder)localObject).append("?").append(C).append("&_bid=160").append("&_wv=3").append("&asyncMode=1");
    l = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("http://zb.vip.qq.com/sonic/font");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=16778243").append("&asyncMode=3");
    n = ((StringBuilder)localObject).toString();
    o = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/font/index.html");
    ((StringBuilder)localObject).append("?").append(C).append("&_bid=182").append("&_wv=1027").append("&asyncMode=1");
    p = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("http://gxh.vip.qq.com/club/themes/mobile/suit/index.html");
    ((StringBuilder)localObject).append("?").append(C).append("&_bid=239").append("&_wv=5123");
    q = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://gxh.vip.qq.com/club/themes/mobile/suit/detail.html");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=5123").append("&_bid=239").append("&suitid=[id]").append("&suittitle=[title]");
    r = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://zb.vip.qq.com/sonic/funcall");
    ((StringBuilder)localObject).append("?").append(C).append("&asyncMode=3").append("&_wv=16778243");
    s = ((StringBuilder)localObject).toString();
    t = "&id=[id]";
    localObject = new StringBuilder("http://zb.vip.qq.com/redpack/index");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=16778243&_wwv=64&_nav_txtclr=ffffff&_nav_titleclr=ffffff&from=[from]");
    u = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://zb.vip.qq.com/sonic/chatbg");
    ((StringBuilder)localObject).append("?").append(C).append("&asyncMode=3").append("&_wv=1027");
    v = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://zb.vip.qq.com/chatbg/preview");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=16782337").append("&bgId=[id]");
    w = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://zb.vip.qq.com/sonic/funcall");
    ((StringBuilder)localObject).append("?").append(C).append("&asyncMode=3").append("&_wv=16778243");
    x = ((StringBuilder)localObject).toString();
    y = "&id=[id]";
    localObject = new StringBuilder("http://zb.vip.qq.com/sonic/card");
    ((StringBuilder)localObject).append("?").append(C).append("&_wv=16782337").append("&asyncMode=3");
    z = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://gxh.vip.qq.com/club/themes/mobile/card/html/detail.html");
    ((StringBuilder)localObject).append("?").append(C).append("&cardItemId=[id]").append("&_wv=16782337");
    A = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://gxh.vip.qq.com/club/themes/mobile/bq/html/category.html?");
    ((StringBuilder)localObject).append("adtag=vip.gongneng.mobile.biaoqing.index").append("&_bid=102&_lv=0").append("&key=012").append("&name=%E5%B0%8F%E8%A1%A8%E6%83%85").append("&src=category_list&_wv=1027");
    D = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://zb.vip.qq.com/like");
    ((StringBuilder)localObject).append("?").append("_wv=16778243");
    E = ((StringBuilder)localObject).toString();
    B = "http://zb.vip.qq.com/card/setting?_wv=16778243";
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/my_dress/index.html");
    ((StringBuilder)localObject).append("?uin=[uin]").append("&client=androidQQ").append("&version=").append("7.6.0.3525").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]").append("&_bid=182").append("&_wv=3");
    F = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("http://imgcache.qq.com/club/themes/mobile/search/html/index.html");
    ((StringBuilder)localObject).append("?uin=[uin]").append("&client=androidQQ").append("&version=").append("7.6.0.3525").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]").append("&adtag=mvip.gxh.android.search").append("&_bid=2229").append("&_wv=1027");
    G = ((StringBuilder)localObject).toString();
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_c_of_type_JavaUtilMap = new HashMap();
    jdField_c_of_type_JavaUtilMap.put("bubble", jdField_c_of_type_JavaLangString);
    jdField_c_of_type_JavaUtilMap.put("theme", jdField_a_of_type_JavaLangString);
    jdField_c_of_type_JavaUtilMap.put("pendant", i);
    jdField_c_of_type_JavaUtilMap.put("faceEntryUrl", m);
    jdField_c_of_type_JavaUtilMap.put("myPendantUrl", k);
    jdField_c_of_type_JavaUtilMap.put("emoji", f);
    jdField_c_of_type_JavaUtilMap.put("font", n);
    jdField_c_of_type_JavaUtilMap.put("suit", q);
    jdField_c_of_type_JavaUtilMap.put("background", v);
    jdField_c_of_type_JavaUtilMap.put("ring", s);
    jdField_c_of_type_JavaUtilMap.put("hongbao", u);
    jdField_c_of_type_JavaUtilMap.put("card", z);
    jdField_c_of_type_JavaUtilMap.put("call", x);
    jdField_c_of_type_JavaUtilMap.put("praise", E);
    jdField_c_of_type_JavaUtilMap.put("bubbleDetail", d);
    jdField_c_of_type_JavaUtilMap.put("bubbleDetailDialog", e);
    jdField_c_of_type_JavaUtilMap.put("themeDetail", jdField_b_of_type_JavaLangString);
    jdField_c_of_type_JavaUtilMap.put("pendantDetail", j);
    jdField_c_of_type_JavaUtilMap.put("pendantDetailDialog", l);
    jdField_c_of_type_JavaUtilMap.put("emojiDetail", g);
    jdField_c_of_type_JavaUtilMap.put("emojiAuthorDetail", h);
    jdField_c_of_type_JavaUtilMap.put("fontDetail", o);
    jdField_c_of_type_JavaUtilMap.put("fontDetailDialog", p);
    jdField_c_of_type_JavaUtilMap.put("suitDetail", r);
    jdField_c_of_type_JavaUtilMap.put("backgroundDetail", w);
    jdField_c_of_type_JavaUtilMap.put("ringDetail", t);
    jdField_c_of_type_JavaUtilMap.put("cardDetail", A);
    jdField_c_of_type_JavaUtilMap.put("callDetail", y);
    jdField_c_of_type_JavaUtilMap.put("personalIndex", "http://zb.vip.qq.com/sonic/index?_wv=16778243&asyncMode=3&_wwv=68&_nav_txtclr=ffffff&_nav_titleclr=ffffff&btest=1");
    jdField_c_of_type_JavaUtilMap.put("cardWord", "http://imgcache.qq.com/club/mobile/profile/template/summary_card_word.json");
    jdField_c_of_type_JavaUtilMap.put("fontAioImg", "http://imgcache.qq.com/qqshow/admindata/comdata/vipfont_[id]/aio.png");
    jdField_c_of_type_JavaUtilMap.put("linkPendantSet", "http://gxh.vip.qq.com/club/themes/mobile/act/diy_tpl/widgetLink[id]/html/index.html?_wv=1025");
    jdField_c_of_type_JavaUtilMap.put("rarePendantActivity", "http://imgcache.qq.com/club/themes/mobile/act/2014/actTpl/html/home.html?app=gjjbzh&type=1&_wv=1025");
    jdField_c_of_type_JavaUtilMap.put("signatureTemplate", "http://imgcache.qq.com/qqshow/admindata/comdata/vipList_signature_data/xydata.v2.json");
    jdField_c_of_type_JavaUtilMap.put("magicPlus", "http://imgcache.qq.com/club/themes/mobile/bq/html/category.html?uin=[uin]&platformId=[platformId]&client=[client]&_lv=0&name=魔法表情&system=[system]&systemInt=[systemInt]&device=[device]&adtag=[adtag]&version=[version]&_bid=102&key=011&_wv=3");
    jdField_c_of_type_JavaUtilMap.put("themeDiy", "http://imgcache.qq.com/qqshow/admindata/comdata/viptheme_DIY_theme/");
    jdField_c_of_type_JavaUtilMap.put("rareCard", "http://imgcache.qq.com/club/client/card/rel/active.html?_bid=238&bgId=%1$s&ADTAG=inside.myCardBackground&_wv=5123");
    jdField_c_of_type_JavaUtilMap.put("emoticonKeyword", "http://imgcache.qq.com/club/item/parcel/json/keywordList.json");
    jdField_c_of_type_JavaUtilMap.put("colorringAudio", "http://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/[id]_2.mp3");
    jdField_c_of_type_JavaUtilMap.put("colorringCover", "http://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/preview.jpg");
    jdField_c_of_type_JavaUtilMap.put("colorringConfig", "http://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/config.json");
    jdField_c_of_type_JavaUtilMap.put("myFont", "http://imgcache.qq.com/club/themes/mobile/font/myfont/html/myfont.html?_wv=3");
    jdField_c_of_type_JavaUtilMap.put("myIndividuation", F);
    jdField_c_of_type_JavaUtilMap.put("individuationSearch", G);
    jdField_c_of_type_JavaUtilMap.put("funnyPic", "http://imgcache.qq.com/club/themes/mobile/qutu/html/index.html?_wv=3&_bid=2196");
    jdField_c_of_type_JavaUtilMap.put("funCallMine", "http://imgcache.qq.com/club/themes/mobile/funcall/html/mine.html?_wv=5123&_bid=2382");
    jdField_c_of_type_JavaUtilMap.put("smallEmojiList", D);
    jdField_c_of_type_JavaUtilMap.put("diyPic", "http://gxh.vip.qq.com/club/themes/mobile/bq/html/category.html?_bid=102&_lv=0&key=014&name=DIY%E8%A1%A8%E6%83%85&src=category_list&_wv=1027");
    jdField_c_of_type_JavaUtilMap.put("aioEmojiStickerDetail", "http://gxh.vip.qq.com/club/themes/mobile/emoji/html/sticker.html?_wv=1027");
    jdField_c_of_type_JavaUtilMap.put("gameHonourAddHonour", B);
    jdField_c_of_type_JavaUtilMap.put("gameIconSetupH5Url", "http://mq.vip.qq.com/m/sgame/duanwei");
    jdField_c_of_type_JavaUtilMap.put("vipRoamChatBanner", "http://imgcache.qq.com/club/client/msgRoam/rel/html/index_v2.html?_wv=5123&ADTAG=xiaolantiao");
    jdField_c_of_type_JavaUtilMap.put("vipRoamChatCell", "http://imgcache.qq.com/club/client/msgRoam/rel/html/index_v2.html?_wv=5123");
    jdField_c_of_type_JavaUtilMap.put("vipPersonalCardCustom", "http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&_wv=5123");
    jdField_c_of_type_JavaUtilMap.put("vipPersonalCardMaster", "http://m.vip.qq.com/redirect/index.php?go=androidzhanghao&_wv=5123");
    jdField_c_of_type_JavaUtilMap.put("vipGameCenter", "");
    jdField_c_of_type_JavaUtilMap.put("vipPersonalCardMyGame", "http://gamecenter.qq.com/gamecenter/index/recent_play.html");
    jdField_c_of_type_JavaUtilMap.put("vipUpGroupLimit", "http://imgcache.qq.com/club/client/group/release/index.html?_bid=199&pvsrc=troopManage&_wv=5127");
    jdField_c_of_type_JavaUtilMap.put("troopEnterEffect", "https://zb.vip.qq.com/group/single?_wv=16777219");
    jdField_c_of_type_JavaUtilMap.put("specialCareRingUrl", "http://imgcache.qq.com/club/client/specialRing/rel/index.html?_wv=1027");
    jdField_c_of_type_JavaUtilMap.put("callDownloadUrl", "http://laidian.qq.com");
    jdField_c_of_type_JavaUtilMap.put("myCallUrl", "http://imgcache.qq.com/club/themes/mobile/funcall/html/mine.html?_wv=5123");
    jdField_c_of_type_JavaUtilMap.put("signatureH5Url", "https://zb.vip.qq.com/sign?_wv=16778243&_wvx=3");
    jdField_c_of_type_JavaUtilMap.put("signatureHistoryH5Url", "http://gxh.vip.qq.com/club/zb/sign/html/history.html?_wv=891");
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    localObject = new IndividuationUrlHelper.MarketParams("2034", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("theme", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("themeDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("122", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("bubble", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("bubbleDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("102", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("emoji", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("102", "16778241");
    jdField_a_of_type_JavaUtilHashMap.put("emojiDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("102", "3");
    jdField_a_of_type_JavaUtilHashMap.put("emojiAuthorDetail", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("magicPlus", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("160", "3");
    jdField_a_of_type_JavaUtilHashMap.put("pendant", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("pendantDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("182", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("font", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("fontDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("239", "5123");
    jdField_a_of_type_JavaUtilHashMap.put("suit", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("suitDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("293", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("ring", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("ringDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("", "16778247");
    jdField_a_of_type_JavaUtilHashMap.put("hongbao", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("310", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("background", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("backgroundDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("313", "5123");
    jdField_a_of_type_JavaUtilHashMap.put("call", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("callDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("238", "5123");
    jdField_a_of_type_JavaUtilHashMap.put("card", localObject);
    jdField_a_of_type_JavaUtilHashMap.put("cardDetail", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("2229", "1027");
    jdField_a_of_type_JavaUtilHashMap.put("individuationSearch", localObject);
    localObject = new IndividuationUrlHelper.MarketParams("182", "3");
    jdField_a_of_type_JavaUtilHashMap.put("myIndividuation", localObject);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return b(paramContext, a(paramString1), paramString2);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return b(paramContext, a(paramString1), paramString2, paramString3);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1;
    if (jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      localObject1 = (String)jdField_a_of_type_JavaUtilMap.get(paramString);
      localObject2 = localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("IndividuationUrlHelper", 2, "getUrl, from config, id=" + paramString + ", url=" + (String)localObject1);
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.d("IndividuationUrlHelper", 2, "getUrl start parseJson");
          }
          if (Looper.myLooper() != Looper.getMainLooper()) {
            break label278;
          }
          ThreadManager.post(new ajtl(), 5, null, true);
        }
      }
      for (;;)
      {
        localObject2 = (String)jdField_b_of_type_JavaUtilMap.get(paramString);
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("IndividuationUrlHelper", 2, "getUrl, from default, id=" + paramString + ", url=" + (String)localObject2);
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = a(BaseApplicationImpl.sApplication.getRuntime(), (String)jdField_c_of_type_JavaUtilMap.get(paramString), paramString);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("IndividuationUrlHelper", 2, "getUrl, from raw default, id=" + paramString + ", url=" + (String)localObject1);
            localObject2 = localObject1;
          }
        }
        return localObject2;
        label278:
        a(BaseApplicationImpl.sApplication.getRuntime());
      }
    }
  }
  
  /* Error */
  public static String a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 540	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: aload_1
    //   10: astore_3
    //   11: aload_1
    //   12: ldc_w 611
    //   15: ldc_w 613
    //   18: invokevirtual 617	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_3
    //   24: aload_1
    //   25: ldc_w 619
    //   28: ldc 67
    //   30: invokevirtual 617	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: astore_3
    //   36: aload_1
    //   37: ldc_w 621
    //   40: ldc_w 623
    //   43: invokevirtual 617	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: astore_3
    //   49: aload_1
    //   50: ldc_w 625
    //   53: getstatic 76	android/os/Build:DEVICE	Ljava/lang/String;
    //   56: ldc_w 627
    //   59: invokestatic 633	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 617	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_1
    //   67: astore_3
    //   68: aload_1
    //   69: ldc_w 635
    //   72: getstatic 83	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   75: ldc_w 627
    //   78: invokestatic 633	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: invokevirtual 617	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   84: astore_1
    //   85: aload_0
    //   86: astore 4
    //   88: aload_0
    //   89: ifnonnull +11 -> 100
    //   92: getstatic 595	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   95: invokevirtual 599	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   98: astore 4
    //   100: aload 4
    //   102: ifnull +36 -> 138
    //   105: aload_1
    //   106: ldc_w 637
    //   109: aload 4
    //   111: invokevirtual 642	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   114: invokevirtual 617	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   117: astore_0
    //   118: aload_0
    //   119: astore_3
    //   120: aload_0
    //   121: ldc_w 644
    //   124: aload 4
    //   126: invokevirtual 648	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   129: invokestatic 654	com/tencent/mobileqq/theme/ThemeUtil:getThemeDensity	(Landroid/content/Context;)Ljava/lang/String;
    //   132: invokevirtual 617	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   135: astore_1
    //   136: aload_1
    //   137: areturn
    //   138: ldc_w 558
    //   141: iconst_1
    //   142: ldc_w 656
    //   145: iconst_2
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_1
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: aload_2
    //   156: aastore
    //   157: invokestatic 660	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: goto -27 -> 136
    //   166: astore_0
    //   167: ldc_w 558
    //   170: iconst_1
    //   171: ldc_w 664
    //   174: iconst_3
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: aload_1
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_2
    //   185: aastore
    //   186: dup
    //   187: iconst_2
    //   188: aload_0
    //   189: invokestatic 670	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 660	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokestatic 662	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: goto -63 -> 136
    //   202: astore_0
    //   203: aload_3
    //   204: astore_1
    //   205: goto -38 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramAppRuntime	AppRuntime
    //   0	208	1	paramString1	String
    //   0	208	2	paramString2	String
    //   10	194	3	localObject	Object
    //   86	39	4	localAppRuntime	AppRuntime
    // Exception table:
    //   from	to	target	type
    //   92	100	166	java/lang/Exception
    //   105	118	166	java/lang/Exception
    //   138	163	166	java/lang/Exception
    //   11	22	202	java/lang/Exception
    //   24	34	202	java/lang/Exception
    //   36	47	202	java/lang/Exception
    //   49	66	202	java/lang/Exception
    //   68	85	202	java/lang/Exception
    //   120	136	202	java/lang/Exception
  }
  
  public static Map a()
  {
    return jdField_a_of_type_JavaUtilMap;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    long l1;
    Object localObject2;
    String str1;
    for (;;)
    {
      try
      {
        QLog.e("IndividuationUrlHelper", 1, "parseJson, app null");
        return;
      }
      finally {}
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
      {
        l1 = System.currentTimeMillis();
        jdField_a_of_type_JavaUtilMap.clear();
        jdField_b_of_type_JavaUtilMap.clear();
        localObject1 = jdField_c_of_type_JavaUtilMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          str1 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = a(paramAppRuntime, (String)((Map.Entry)localObject2).getValue(), str1);
          jdField_b_of_type_JavaUtilMap.put(str1, localObject2);
        }
      }
    }
    Object localObject1 = VasQuickUpdateManager.a(paramAppRuntime, 1000L, "vipData_individuation_url.android.json", paramAppRuntime.getApplication().getFilesDir() + File.separator + "vipData_individuation_url.android.json", true, null);
    if (localObject1 != null)
    {
      boolean bool = ((File)localObject1).exists();
      if (!bool) {}
    }
    for (;;)
    {
      int i4;
      int i2;
      label353:
      int i3;
      label457:
      int i6;
      try
      {
        localObject1 = FileUtils.a((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label828;
        }
        localObject1 = new JSONArray((String)localObject1);
        if ((localObject1 == null) || (((JSONArray)localObject1).length() < 1)) {
          QLog.e("IndividuationUrlHelper", 1, "parseJson, no IndividuationAddress element");
        }
      }
      catch (Exception paramAppRuntime)
      {
        QLog.e("IndividuationUrlHelper", 1, "parseJson, exception=" + MsfSdkUtils.getStackTraceString(paramAppRuntime));
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("IndividuationUrlHelper", 2, "parseJson, duration=" + (System.currentTimeMillis() - l1));
        break;
        i4 = VipUtils.a(paramAppRuntime, null);
        int i5 = ((JSONArray)localObject1).length();
        i2 = 0;
        if (i2 >= i5) {
          continue;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i2);
        str1 = ((JSONObject)localObject2).optString("business");
        String str2 = ((JSONObject)localObject2).optString("url");
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
        {
          QLog.e("IndividuationUrlHelper", 1, "parseJson, config error, no business or url, config=" + localObject2);
          break label854;
        }
        if (((JSONObject)localObject2).has("userType"))
        {
          i3 = ((JSONObject)localObject2).getInt("userType");
          break label861;
          if (i1 == 0) {
            break label854;
          }
          i3 = 1;
          i1 = i3;
          if (((JSONObject)localObject2).has("minVersion"))
          {
            str3 = ((JSONObject)localObject2).getString("minVersion");
            i1 = i3;
            if (!TextUtils.isEmpty(str3))
            {
              i1 = i3;
              if (!a(str3, "7.6.0")) {
                i1 = 0;
              }
            }
          }
          i3 = i1;
          if (i1 != 0)
          {
            i3 = i1;
            if (((JSONObject)localObject2).has("maxVersion"))
            {
              str3 = ((JSONObject)localObject2).getString("maxVersion");
              i3 = i1;
              if (!TextUtils.isEmpty(str3))
              {
                i3 = i1;
                if (!a("7.6.0", str3)) {
                  i3 = 0;
                }
              }
            }
          }
          if (i3 == 0) {
            break label854;
          }
          String str3 = paramAppRuntime.getAccount();
          i1 = ((JSONObject)localObject2).optInt("startIndex");
          i3 = ((JSONObject)localObject2).optInt("endIndex");
          if (i1 < i3) {
            break label797;
          }
          i6 = str3.length();
          if ((i6 < i1) || (i6 < i3)) {
            break label755;
          }
          long l2 = Long.parseLong(str3.substring(i6 - i1, i6 - i3 + 1));
          long l3 = ((JSONObject)localObject2).optLong("min");
          long l4 = ((JSONObject)localObject2).optLong("max");
          if ((l2 < l3) || (l2 > l4)) {
            break label854;
          }
          localObject2 = a(paramAppRuntime, str2, str1);
          jdField_a_of_type_JavaUtilMap.put(str1, localObject2);
          break label854;
        }
      }
      catch (OutOfMemoryError paramAppRuntime)
      {
        QLog.e("IndividuationUrlHelper", 1, "parseJson, oom=" + MsfSdkUtils.getStackTraceString(paramAppRuntime));
        continue;
        i3 = -1;
        break label861;
      }
      label738:
      if ((i4 & 0x2) != 0) {}
      for (int i1 = 2; (i3 & i1) != i1; i1 = 4)
      {
        i1 = 0;
        break label457;
        label755:
        QLog.e("IndividuationUrlHelper", 1, "parseJson, index config error, uin length=" + i6 + ", config=" + localObject2);
        break label854;
        label797:
        QLog.e("IndividuationUrlHelper", 1, "parseJson, startIndex < endIndex, element=" + localObject2);
        break label854;
        label828:
        QLog.e("IndividuationUrlHelper", 1, "parseJson, jsonStr null");
        break;
        QLog.e("IndividuationUrlHelper", 1, "parseJson, no json file");
        break;
        label854:
        i2 += 1;
        break label353;
        label861:
        i1 = 1;
        if (i3 == -1) {
          break label457;
        }
        i1 = 1;
        if ((i4 & 0x4) == 0) {
          break label738;
        }
      }
      i1 = 1;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i4 = Math.min(paramString1.length, paramString2.length);
    int i3 = 0;
    label44:
    if (i3 < i4) {
      if (i3 >= paramString1.length) {
        break label144;
      }
    }
    for (;;)
    {
      try
      {
        i1 = Integer.parseInt(paramString1[i3]);
        if (i3 >= paramString2.length) {
          break label139;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          i2 = Integer.parseInt(paramString2[i3]);
          if (i3 == i4 - 1) {
            break label125;
          }
          if (i2 > i1)
          {
            return true;
            localException1 = localException1;
            i1 = 0;
          }
        }
        catch (Exception localException2)
        {
          i2 = 0;
          continue;
        }
      }
      if (i2 < i1) {
        break;
      }
      label125:
      do
      {
        i3 += 1;
        break label44;
        break;
        if (i2 >= i1) {
          return true;
        }
      } while (i2 >= i1);
      return false;
      label139:
      int i2 = 0;
      continue;
      label144:
      int i1 = 0;
    }
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IndividuationUrlHelper", 2, "decodeMarketUrl:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramContext = paramString1;
    } while (TextUtils.isEmpty(paramString2));
    return paramString1 + "&adtag=" + paramString2;
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      if (QLog.isColorLevel()) {
        QLog.i("IndividuationUrlHelper", 2, "decodeMarketDetailUrl:" + paramString1 + ", id=" + paramString2);
      }
      paramString1 = b(paramContext, paramString1, paramString3);
      paramContext = paramString1;
    } while (TextUtils.isEmpty(paramString1));
    return paramString1.replace("[id]", paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationUrlHelper
 * JD-Core Version:    0.7.0.1
 */