package com.tencent.mobileqq.vas;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
  private static final String H;
  private static final String I;
  private static final String J;
  private static final String K;
  private static final String L;
  private static final String M;
  public static IndividuationUrlHelper.UrlCallback a;
  private static final String jdField_a_of_type_JavaLangString;
  public static HashMap<String, IndividuationUrlHelper.MarketParams> a;
  private static List<SoftReference<IndividuationUrlHelper.IconExtendData>> jdField_a_of_type_JavaUtilList;
  private static Map<String, String> jdField_a_of_type_JavaUtilMap;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static boolean jdField_a_of_type_Boolean;
  private static final String jdField_b_of_type_JavaLangString;
  private static Map<String, String> jdField_b_of_type_JavaUtilMap;
  private static final String jdField_c_of_type_JavaLangString;
  private static Map<String, String> jdField_c_of_type_JavaUtilMap;
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
    ((StringBuilder)localObject).append("uin=[uin]").append("&client=androidQQ").append("&version=").append("8.5.5.5105").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]");
    I = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/theme");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=16782337").append("&asyncMode=3");
    jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/theme/detail");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=16782337").append("&id=[id]");
    jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/bubble");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=16778243&_wwv=64&_nav_txtclr=ffffff&_nav_titleclr=ffffff").append("&asyncMode=3");
    jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    d = "https://zb.vip.qq.com/collection/aio?_wv=1027&id=[id]&_preload=1&type=bubble";
    localObject = new StringBuilder("https://zb.vip.qq.com/bubble");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=1027").append("&asyncMode=3");
    e = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/emoji");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=16778243").append("&asyncMode=3");
    f = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/bq/html/detail.html");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=16778241").append("&_bid=102").append("&type=view").append("&id=[id]").append("&_lv=0");
    g = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/bq/html/author.html");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=3").append("&_bid=102").append("&type=view").append("&id=[id]");
    h = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/widget");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=3").append("&asyncMode=3");
    i = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://zb.vip.qq.com/sonic/widget/home?").append(I).append("&adtag=index.h5&_wv=16778243&sharefri=[sharefri]");
    j = ((StringBuilder)localObject).toString();
    ((StringBuilder)localObject).setLength(0);
    ((StringBuilder)localObject).append("https://zb.vip.qq.com/widget/diyEditor?_wv=16778243&sharefri=[sharefri]");
    k = ((StringBuilder)localObject).toString();
    H = "https://club.vip.qq.com/groupkeywords/group?_wv=7&_wwv=4&_wvx=10&_proxy=1&groupid=[groupid]";
    r = "https://zb.vip.qq.com/v2/mall/face?_wv=5123&_nav_titleclr=000000&_nav_txtclr=000000";
    m = "https://zb.vip.qq.com/widget/mine?_wv=16782339&_wvx=3";
    l = "https://zb.vip.qq.com/collection/aio?_wv=1027&id=[id]&_preload=1&type=widget";
    n = "https://gxh.vip.qq.com/xydata/font/item/[id]/180x150.png";
    p = "https://gxh.vip.qq.com/xydata/bubble/item/[id]/250x300_0.png";
    o = "https://zb.vip.qq.com/face/category?_wv=16778243&_wvx=3&id=14";
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/head_pendant/html/index.html");
    ((StringBuilder)localObject).append("?").append(I).append("&_bid=160").append("&_wv=3").append("&asyncMode=1");
    q = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/font");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=16778243").append("&asyncMode=3");
    s = ((StringBuilder)localObject).toString();
    t = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/font/index.html");
    ((StringBuilder)localObject).append("?").append(I).append("&_bid=182").append("&_wv=1027").append("&asyncMode=1");
    u = "&show_type=dialog&id=[id]";
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/suit/index.html");
    ((StringBuilder)localObject).append("?").append(I).append("&_bid=239").append("&_wv=5123");
    v = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/suit/detail.html");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=5123").append("&_bid=239").append("&suitid=[id]").append("&suittitle=[title]");
    w = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/funcall");
    ((StringBuilder)localObject).append("?").append(I).append("&asyncMode=3").append("&_wv=16778243");
    x = ((StringBuilder)localObject).toString();
    y = "&id=[id]";
    localObject = new StringBuilder("https://zb.vip.qq.com/redpack/index");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=16778243&_wwv=64&_nav_txtclr=ffffff&_nav_titleclr=ffffff&from=[from]");
    z = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/chatbg");
    ((StringBuilder)localObject).append("?").append(I).append("&asyncMode=3").append("&_wv=1027");
    A = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/chatbg/preview");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=16782337").append("&bgId=[id]");
    B = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/funcall");
    ((StringBuilder)localObject).append("?").append(I).append("&asyncMode=3").append("&_wv=16778243");
    C = ((StringBuilder)localObject).toString();
    D = "&id=[id]";
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/card");
    ((StringBuilder)localObject).append("?").append(I).append("&_wv=16782337").append("&asyncMode=3");
    E = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/card/html/detail.html");
    ((StringBuilder)localObject).append("?").append(I).append("&cardItemId=[id]").append("&_wv=16782337");
    F = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/bq/html/category.html?");
    ((StringBuilder)localObject).append("adtag=vip.gongneng.mobile.biaoqing.index").append("&_bid=102&_lv=0").append("&key=012").append("&name=%E5%B0%8F%E8%A1%A8%E6%83%85").append("&src=category_list&_wv=1027");
    J = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/like");
    ((StringBuilder)localObject).append("?").append("_wv=16778243");
    K = ((StringBuilder)localObject).toString();
    G = "https://zb.vip.qq.com/card/setting?_wv=16778243";
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/my_dress/index.html");
    ((StringBuilder)localObject).append("?uin=[uin]").append("&client=androidQQ").append("&version=").append("8.5.5.5105").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]").append("&_bid=182").append("&_wv=3");
    L = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/search/html/index.html");
    ((StringBuilder)localObject).append("?uin=[uin]").append("&client=androidQQ").append("&version=").append("8.5.5.5105").append("&platformId=2").append("&device=").append(Build.DEVICE).append("&system=").append(Build.VERSION.RELEASE).append("&density=[density]").append("&adtag=mvip.gxh.android.search").append("&_bid=2229").append("&_wv=1027");
    M = ((StringBuilder)localObject).toString();
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_c_of_type_JavaUtilMap = new HashMap();
    jdField_c_of_type_JavaUtilMap.put("bubble", jdField_c_of_type_JavaLangString);
    jdField_c_of_type_JavaUtilMap.put("theme", jdField_a_of_type_JavaLangString);
    jdField_c_of_type_JavaUtilMap.put("pendant", i);
    jdField_c_of_type_JavaUtilMap.put("FriendToPendant", j);
    jdField_c_of_type_JavaUtilMap.put("FriendToDIYPendant", k);
    jdField_c_of_type_JavaUtilMap.put("faceEntryUrl", r);
    jdField_c_of_type_JavaUtilMap.put("myPendantUrl", m);
    jdField_c_of_type_JavaUtilMap.put("emoji", f);
    jdField_c_of_type_JavaUtilMap.put("font", s);
    jdField_c_of_type_JavaUtilMap.put("suit", v);
    jdField_c_of_type_JavaUtilMap.put("background", A);
    jdField_c_of_type_JavaUtilMap.put("ring", x);
    jdField_c_of_type_JavaUtilMap.put("hongbao", z);
    jdField_c_of_type_JavaUtilMap.put("card", E);
    jdField_c_of_type_JavaUtilMap.put("call", C);
    jdField_c_of_type_JavaUtilMap.put("praise", K);
    jdField_c_of_type_JavaUtilMap.put("bubbleDetail", d);
    jdField_c_of_type_JavaUtilMap.put("bubbleDetailDialog", e);
    jdField_c_of_type_JavaUtilMap.put("themeDetail", jdField_b_of_type_JavaLangString);
    jdField_c_of_type_JavaUtilMap.put("pendantDetail", l);
    jdField_c_of_type_JavaUtilMap.put("pendantDetailDialog", q);
    jdField_c_of_type_JavaUtilMap.put("emojiDetail", g);
    jdField_c_of_type_JavaUtilMap.put("emojiAuthorDetail", h);
    jdField_c_of_type_JavaUtilMap.put("fontDetail", t);
    jdField_c_of_type_JavaUtilMap.put("fontDetailDialog", u);
    jdField_c_of_type_JavaUtilMap.put("suitDetail", w);
    jdField_c_of_type_JavaUtilMap.put("backgroundDetail", B);
    jdField_c_of_type_JavaUtilMap.put("ringDetail", y);
    jdField_c_of_type_JavaUtilMap.put("cardDetail", F);
    jdField_c_of_type_JavaUtilMap.put("callDetail", D);
    jdField_c_of_type_JavaUtilMap.put("personalIndex", "https://zb.vip.qq.com/v2/home?_wv=5123&_proxy=1&_wwv=128&_proxy=1&ADTAG=mobileqq.drawer");
    jdField_c_of_type_JavaUtilMap.put("cardWord", "https://imgcache.qq.com/club/mobile/profile/template/summary_card_word.json");
    jdField_c_of_type_JavaUtilMap.put("fontAioImg", "https://imgcache.qq.com/qqshow/admindata/comdata/vipfont_[id]/aio.png");
    jdField_c_of_type_JavaUtilMap.put("linkPendantSet", "https://gxh.vip.qq.com/club/themes/mobile/act/diy_tpl/widgetLink[id]/html/index.html?_wv=1025");
    jdField_c_of_type_JavaUtilMap.put("rarePendantActivity", "https://imgcache.qq.com/club/themes/mobile/act/2014/actTpl/html/home.html?app=gjjbzh&type=1&_wv=1025");
    jdField_c_of_type_JavaUtilMap.put("signatureTemplate", "https://imgcache.qq.com/qqshow/admindata/comdata/vipList_signature_data/xydata.v2.json");
    jdField_c_of_type_JavaUtilMap.put("magicPlus", "https://zb.vip.qq.com/emoji/category?key=011");
    jdField_c_of_type_JavaUtilMap.put("rareCard", "https://imgcache.qq.com/club/client/card/rel/active.html?_bid=238&bgId=%1$s&ADTAG=inside.myCardBackground&_wv=5123");
    jdField_c_of_type_JavaUtilMap.put("emoticonKeyword", "https://imgcache.qq.com/club/item/parcel/json/keywordList.json");
    jdField_c_of_type_JavaUtilMap.put("colorringAudio", "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/[id]_2.mp3");
    jdField_c_of_type_JavaUtilMap.put("colorringCover", "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/preview.jpg");
    jdField_c_of_type_JavaUtilMap.put("colorringConfig", "https://imgcache.qq.com/qqshow/admindata/comdata/vipRing_item_[id]/config.json");
    jdField_c_of_type_JavaUtilMap.put("myFont", "https://zb.vip.qq.com/font/myFont?_wv=16777219&_wwv=321&_wvx=3");
    jdField_c_of_type_JavaUtilMap.put("myIndividuation", L);
    jdField_c_of_type_JavaUtilMap.put("individuationSearch", M);
    jdField_c_of_type_JavaUtilMap.put("funnyPic", "https://imgcache.qq.com/club/themes/mobile/qutu/html/index.html?_wv=3&_bid=2196");
    jdField_c_of_type_JavaUtilMap.put("funCallMine", "https://imgcache.qq.com/club/themes/mobile/funcall/html/mine.html?_wv=5123&_bid=2382");
    jdField_c_of_type_JavaUtilMap.put("smallEmojiList", J);
    jdField_c_of_type_JavaUtilMap.put("diyPic", "https://gxh.vip.qq.com/club/themes/mobile/bq/html/category.html?_bid=102&_lv=0&key=014&name=DIY%E8%A1%A8%E6%83%85&src=category_list&_wv=1027");
    jdField_c_of_type_JavaUtilMap.put("aioEmojiStickerDetail", "https://gxh.vip.qq.com/club/themes/mobile/emoji/html/sticker.html?_wv=1027");
    jdField_c_of_type_JavaUtilMap.put("gameHonourAddHonour", G);
    jdField_c_of_type_JavaUtilMap.put("gameIconSetupH5Url", "https://mq.vip.qq.com/m/sgame/duanwei");
    jdField_c_of_type_JavaUtilMap.put("bubblePreview", p);
    jdField_c_of_type_JavaUtilMap.put("fontPreview", n);
    jdField_c_of_type_JavaUtilMap.put("vasClassProfileStoryUrl", o);
    jdField_c_of_type_JavaUtilMap.put("vipRoamChatBanner", "https://imgcache.qq.com/club/client/msgRoam/rel/html/index_v2.html?_wv=5123&ADTAG=xiaolantiao");
    jdField_c_of_type_JavaUtilMap.put("vipRoamChatCell", "https://imgcache.qq.com/club/client/msgRoam/rel/html/index_v2.html?_wv=5123");
    jdField_c_of_type_JavaUtilMap.put("vipPersonalCardCustom", "https://h5.vip.qq.com/p/mc/cardv2/other?_wv=1031&_wvx=10");
    jdField_c_of_type_JavaUtilMap.put("vipPersonalCardMaster", "https://club.vip.qq.com/card?_wvx=3&_nav_anim=true&_nav_alpha=0");
    jdField_c_of_type_JavaUtilMap.put("vipGameCenter", "");
    jdField_c_of_type_JavaUtilMap.put("vipPersonalCardMyGame", "https://gamecenter.qq.com/gamecenter/index/recent_play.html");
    jdField_c_of_type_JavaUtilMap.put("vipUpGroupLimit", "https://imgcache.qq.com/club/client/group/release/index.html?_bid=199&pvsrc=troopManage&_wv=5127");
    jdField_c_of_type_JavaUtilMap.put("troopEnterEffect", "https://zb.vip.qq.com/group/single?_wv=16777219");
    jdField_c_of_type_JavaUtilMap.put("specialCareRingUrl", "https://zb.vip.qq.com/v2/subMall?locationtype=[lType]&uid=[uid]");
    jdField_c_of_type_JavaUtilMap.put("signatureEntrance", "https://zb.vip.qq.com/v2/signList?_wvx=2&_wvxBclr=0xffffff&_wwv=4");
    jdField_c_of_type_JavaUtilMap.put("signatureDIYEntrance", "https://zb.vip.qq.com/sign_v2/diy");
    jdField_c_of_type_JavaUtilMap.put("groupkeywords", H);
    jdField_c_of_type_JavaUtilMap.put("NameplateClickDefault", "https://m.vip.qq.com/freedom/freedom_svipicon.html?_nav_alpha=0");
    jdField_c_of_type_JavaUtilMap.put("NameplateClickSvip", "https://h5.vip.qq.com/p/mc/cardv2/other?_wv=1031");
    jdField_c_of_type_JavaUtilMap.put("kuoliePersonalCardMaster", "https://club.vip.qq.com/card?_wvx=3&_nav_anim=true&_nav_alpha=0");
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
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilList = new ArrayList();
    jdField_a_of_type_ComTencentMobileqqVasIndividuationUrlHelper$UrlCallback = new IndividuationUrlHelper.1();
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
    return a(paramString, null);
  }
  
  public static String a(String paramString, ImageView paramImageView)
  {
    Object localObject = null;
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_JavaUtilList.add(new SoftReference(new IndividuationUrlHelper.IconExtendData(paramString, paramImageView)));
      paramImageView = localObject;
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        paramImageView = a(paramString, jdField_a_of_type_ComTencentMobileqqVasIndividuationUrlHelper$UrlCallback);
      }
      if (!TextUtils.isEmpty(paramImageView)) {
        jdField_a_of_type_JavaUtilList.clear();
      }
      return paramImageView;
    }
    return (String)jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public static String a(String paramString, IndividuationUrlHelper.UrlCallback paramUrlCallback)
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
      if (TextUtils.isEmpty(localObject2)) {
        if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          if (QLog.isColorLevel()) {
            QLog.d("IndividuationUrlHelper", 2, "getUrl start parseJson");
          }
          if (Looper.myLooper() != Looper.getMainLooper()) {
            break label279;
          }
          ThreadManager.post(new IndividuationUrlHelper.2(paramUrlCallback), 5, null, true);
        }
      }
      for (;;)
      {
        paramUrlCallback = (String)jdField_b_of_type_JavaUtilMap.get(paramString);
        localObject1 = paramUrlCallback;
        if (QLog.isColorLevel())
        {
          QLog.d("IndividuationUrlHelper", 2, "getUrl, from default, id=" + paramString + ", url=" + paramUrlCallback);
          localObject1 = paramUrlCallback;
        }
        paramUrlCallback = (IndividuationUrlHelper.UrlCallback)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = a(BaseApplicationImpl.sApplication.getRuntime(), (String)jdField_c_of_type_JavaUtilMap.get(paramString), paramString);
          paramUrlCallback = (IndividuationUrlHelper.UrlCallback)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("IndividuationUrlHelper", 2, "getUrl, from raw default, id=" + paramString + ", url=" + (String)localObject1);
            paramUrlCallback = (IndividuationUrlHelper.UrlCallback)localObject1;
          }
        }
        return paramUrlCallback;
        label279:
        a(BaseApplicationImpl.sApplication.getRuntime());
      }
    }
  }
  
  /* Error */
  public static String a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 633	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aload_1
    //   8: areturn
    //   9: aload_1
    //   10: astore_3
    //   11: aload_1
    //   12: ldc_w 704
    //   15: ldc_w 706
    //   18: invokevirtual 710	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   21: astore_1
    //   22: aload_1
    //   23: astore_3
    //   24: aload_1
    //   25: ldc_w 712
    //   28: ldc 79
    //   30: invokevirtual 710	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: astore_3
    //   36: aload_1
    //   37: ldc_w 714
    //   40: ldc_w 716
    //   43: invokevirtual 710	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: astore_3
    //   49: aload_1
    //   50: ldc_w 718
    //   53: getstatic 88	android/os/Build:DEVICE	Ljava/lang/String;
    //   56: ldc_w 720
    //   59: invokestatic 726	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 710	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_1
    //   67: astore_3
    //   68: aload_1
    //   69: ldc_w 728
    //   72: getstatic 95	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   75: ldc_w 720
    //   78: invokestatic 726	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: invokevirtual 710	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   84: astore_1
    //   85: aload_0
    //   86: astore 4
    //   88: aload_0
    //   89: ifnonnull +11 -> 100
    //   92: getstatic 688	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   95: invokevirtual 692	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   98: astore 4
    //   100: aload 4
    //   102: ifnull +36 -> 138
    //   105: aload_1
    //   106: ldc_w 730
    //   109: aload 4
    //   111: invokevirtual 735	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   114: invokevirtual 710	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   117: astore_0
    //   118: aload_0
    //   119: astore_3
    //   120: aload_0
    //   121: ldc_w 737
    //   124: aload 4
    //   126: invokevirtual 741	mqq/app/AppRuntime:getApplication	()Lmqq/app/MobileQQ;
    //   129: invokestatic 747	com/tencent/mobileqq/theme/ThemeUtil:getThemeDensity	(Landroid/content/Context;)Ljava/lang/String;
    //   132: invokevirtual 710	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   135: astore_1
    //   136: aload_1
    //   137: areturn
    //   138: ldc_w 651
    //   141: iconst_1
    //   142: ldc_w 749
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
    //   157: invokestatic 753	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: invokestatic 755	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: goto -27 -> 136
    //   166: astore_0
    //   167: ldc_w 651
    //   170: iconst_1
    //   171: ldc_w 757
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
    //   189: invokestatic 763	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 753	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokestatic 755	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public static Map<String, String> a()
  {
    return jdField_a_of_type_JavaUtilMap;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    long l1;
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
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          String str = (String)((Map.Entry)localObject2).getKey();
          localObject2 = a(paramAppRuntime, (String)((Map.Entry)localObject2).getValue(), str);
          jdField_b_of_type_JavaUtilMap.put(str, localObject2);
        }
      }
    }
    Object localObject1 = VasUpdateUtil.a(paramAppRuntime, 1000L, "vipData_individuation_url.android.json", paramAppRuntime.getApplication().getFilesDir() + File.separator + "vipData_individuation_url.android.json", true, null);
    if (localObject1 != null)
    {
      boolean bool = ((File)localObject1).exists();
      if (!bool) {}
    }
    for (;;)
    {
      int i1;
      try
      {
        localObject1 = FileUtils.a((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label404;
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
        i1 = VipUtils.a(paramAppRuntime, null);
        if ((i1 & 0x4) != 0)
        {
          i1 = 4;
          a(paramAppRuntime, (JSONArray)localObject1, i1);
          continue;
        }
      }
      catch (OutOfMemoryError paramAppRuntime)
      {
        QLog.e("IndividuationUrlHelper", 1, "parseJson, oom=" + MsfSdkUtils.getStackTraceString(paramAppRuntime));
        continue;
      }
      if ((i1 & 0x2) != 0)
      {
        i1 = 2;
        continue;
        label404:
        QLog.e("IndividuationUrlHelper", 1, "parseJson, jsonStr null");
        continue;
        QLog.e("IndividuationUrlHelper", 1, "parseJson, no json file");
      }
      else
      {
        i1 = 1;
      }
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, JSONArray paramJSONArray, int paramInt)
  {
    int i4 = paramJSONArray.length();
    int i2 = 0;
    if (i2 < i4) {}
    for (;;)
    {
      Object localObject;
      int i3;
      label115:
      int i5;
      try
      {
        localObject = paramJSONArray.getJSONObject(i2);
        str1 = ((JSONObject)localObject).optString("business");
        str2 = ((JSONObject)localObject).optString("url");
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
        {
          QLog.e("IndividuationUrlHelper", 1, "parseJson, config error, no business or url, config=" + localObject);
          break label473;
        }
        if (!((JSONObject)localObject).has("userType")) {
          break label388;
        }
        i3 = ((JSONObject)localObject).getInt("userType");
      }
      catch (Exception localException)
      {
        String str1;
        String str2;
        String str3;
        long l1;
        long l2;
        long l3;
        QLog.e("IndividuationUrlHelper", 1, "parseJson, exception", localException);
        break label473;
      }
      if (i1 != 0)
      {
        i3 = 1;
        i1 = i3;
        if (((JSONObject)localObject).has("minVersion"))
        {
          str3 = ((JSONObject)localObject).getString("minVersion");
          i1 = i3;
          if (!TextUtils.isEmpty(str3))
          {
            i1 = i3;
            if (!a(str3, "8.5.5")) {
              i1 = 0;
            }
          }
        }
        i3 = i1;
        if (i1 != 0)
        {
          i3 = i1;
          if (((JSONObject)localObject).has("maxVersion"))
          {
            str3 = ((JSONObject)localObject).getString("maxVersion");
            i3 = i1;
            if (!TextUtils.isEmpty(str3))
            {
              i3 = i1;
              if (!a("8.5.5", str3)) {
                i3 = 0;
              }
            }
          }
        }
        if (i3 != 0)
        {
          str3 = paramAppRuntime.getAccount();
          i1 = ((JSONObject)localObject).optInt("startIndex");
          i3 = ((JSONObject)localObject).optInt("endIndex");
          if (i1 >= i3)
          {
            i5 = str3.length();
            if ((i5 >= i1) && (i5 >= i3))
            {
              l1 = Long.parseLong(str3.substring(i5 - i1, i5 - i3 + 1));
              l2 = ((JSONObject)localObject).optLong("min");
              l3 = ((JSONObject)localObject).optLong("max");
              if ((l1 < l2) || (l1 > l3)) {
                break label473;
              }
              localObject = a(paramAppRuntime, str2, str1);
              jdField_a_of_type_JavaUtilMap.put(str1, localObject);
              break label473;
              label388:
              i3 = -1;
              break label482;
            }
          }
        }
      }
      label473:
      label482:
      do
      {
        i1 = 0;
        break label115;
        QLog.e("IndividuationUrlHelper", 1, "parseJson, index config error, uin length=" + i5 + ", config=" + localObject);
        break label473;
        QLog.e("IndividuationUrlHelper", 1, "parseJson, startIndex < endIndex, element=" + localObject);
        break label473;
        return;
        i2 += 1;
        break;
        i1 = 1;
        if (i3 == -1) {
          break label115;
        }
      } while ((paramInt & i3) != paramInt);
      int i1 = 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationUrlHelper
 * JD-Core Version:    0.7.0.1
 */