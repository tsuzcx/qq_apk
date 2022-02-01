package com.tencent.mobileqq.vas;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;
import java.net.URLEncoder;
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
  public static Map<String, String> a;
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
    ((StringBuilder)localObject).append("uin=[uin]");
    ((StringBuilder)localObject).append("&client=androidQQ");
    ((StringBuilder)localObject).append("&version=");
    ((StringBuilder)localObject).append("8.7.0.5295");
    ((StringBuilder)localObject).append("&platformId=2");
    ((StringBuilder)localObject).append("&device=");
    ((StringBuilder)localObject).append(Build.DEVICE);
    ((StringBuilder)localObject).append("&system=");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("&density=[density]");
    I = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/theme");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=16782337");
    ((StringBuilder)localObject).append("&asyncMode=3");
    jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/theme/detail");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=16782337");
    ((StringBuilder)localObject).append("&id=[id]");
    jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/bubble");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=16778243&_wwv=64&_nav_txtclr=ffffff&_nav_titleclr=ffffff");
    ((StringBuilder)localObject).append("&asyncMode=3");
    jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    d = "https://zb.vip.qq.com/collection/aio?_wv=1027&id=[id]&_preload=1&type=bubble";
    localObject = new StringBuilder("https://zb.vip.qq.com/bubble");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=1027");
    ((StringBuilder)localObject).append("&asyncMode=3");
    ((StringBuilder)localObject).append("&show_type=dialog&id=[id]");
    e = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/emoji");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=16778243");
    ((StringBuilder)localObject).append("&asyncMode=3");
    f = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/bq/html/detail.html");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=16778241");
    ((StringBuilder)localObject).append("&_bid=102");
    ((StringBuilder)localObject).append("&type=view");
    ((StringBuilder)localObject).append("&id=[id]");
    ((StringBuilder)localObject).append("&_lv=0");
    g = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/bq/html/author.html");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=3");
    ((StringBuilder)localObject).append("&_bid=102");
    ((StringBuilder)localObject).append("&type=view");
    ((StringBuilder)localObject).append("&id=[id]");
    h = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/widget");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=3");
    ((StringBuilder)localObject).append("&asyncMode=3");
    i = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("https://zb.vip.qq.com/sonic/widget/home?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&adtag=index.h5&_wv=16778243&sharefri=[sharefri]");
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
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_bid=160");
    ((StringBuilder)localObject).append("&_wv=3");
    ((StringBuilder)localObject).append("&asyncMode=1");
    ((StringBuilder)localObject).append("&show_type=dialog&id=[id]");
    q = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/font");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=16778243");
    ((StringBuilder)localObject).append("&asyncMode=3");
    s = ((StringBuilder)localObject).toString();
    ((StringBuilder)localObject).append("&show_type=dialog&id=[id]");
    t = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/font/index.html");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_bid=182");
    ((StringBuilder)localObject).append("&_wv=1027");
    ((StringBuilder)localObject).append("&asyncMode=1");
    ((StringBuilder)localObject).append("&show_type=dialog&id=[id]");
    u = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/suit/index.html");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_bid=239");
    ((StringBuilder)localObject).append("&_wv=5123");
    v = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/suit/detail.html");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=5123");
    ((StringBuilder)localObject).append("&_bid=239");
    ((StringBuilder)localObject).append("&suitid=[id]");
    ((StringBuilder)localObject).append("&suittitle=[title]");
    w = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/funcall");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&asyncMode=3");
    ((StringBuilder)localObject).append("&_wv=16778243");
    x = ((StringBuilder)localObject).toString();
    ((StringBuilder)localObject).append("&id=[id]");
    y = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/redpack/index");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=16778243&_wwv=64&_nav_txtclr=ffffff&_nav_titleclr=ffffff&from=[from]");
    z = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/chatbg");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&asyncMode=3");
    ((StringBuilder)localObject).append("&_wv=1027");
    A = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/chatbg/preview");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=16782337");
    ((StringBuilder)localObject).append("&bgId=[id]");
    B = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/funcall");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&asyncMode=3");
    ((StringBuilder)localObject).append("&_wv=16778243");
    C = ((StringBuilder)localObject).toString();
    ((StringBuilder)localObject).append("&id=[id]");
    D = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/sonic/card");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&_wv=16782337");
    ((StringBuilder)localObject).append("&asyncMode=3");
    E = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/card/html/detail.html");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append(I);
    ((StringBuilder)localObject).append("&cardItemId=[id]");
    ((StringBuilder)localObject).append("&_wv=16782337");
    F = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://gxh.vip.qq.com/club/themes/mobile/bq/html/category.html?");
    ((StringBuilder)localObject).append("adtag=vip.gongneng.mobile.biaoqing.index");
    ((StringBuilder)localObject).append("&_bid=102&_lv=0");
    ((StringBuilder)localObject).append("&key=012");
    ((StringBuilder)localObject).append("&name=%E5%B0%8F%E8%A1%A8%E6%83%85");
    ((StringBuilder)localObject).append("&src=category_list&_wv=1027");
    J = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://zb.vip.qq.com/like");
    ((StringBuilder)localObject).append("?");
    ((StringBuilder)localObject).append("_wv=16778243");
    K = ((StringBuilder)localObject).toString();
    G = "https://zb.vip.qq.com/card/setting?_wv=16778243";
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/my_dress/index.html");
    ((StringBuilder)localObject).append("?uin=[uin]");
    ((StringBuilder)localObject).append("&client=androidQQ");
    ((StringBuilder)localObject).append("&version=");
    ((StringBuilder)localObject).append("8.7.0.5295");
    ((StringBuilder)localObject).append("&platformId=2");
    ((StringBuilder)localObject).append("&device=");
    ((StringBuilder)localObject).append(Build.DEVICE);
    ((StringBuilder)localObject).append("&system=");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("&density=[density]");
    ((StringBuilder)localObject).append("&_bid=182");
    ((StringBuilder)localObject).append("&_wv=3");
    L = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder("https://imgcache.qq.com/club/themes/mobile/search/html/index.html");
    ((StringBuilder)localObject).append("?uin=[uin]");
    ((StringBuilder)localObject).append("&client=androidQQ");
    ((StringBuilder)localObject).append("&version=");
    ((StringBuilder)localObject).append("8.7.0.5295");
    ((StringBuilder)localObject).append("&platformId=2");
    ((StringBuilder)localObject).append("&device=");
    ((StringBuilder)localObject).append(Build.DEVICE);
    ((StringBuilder)localObject).append("&system=");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append("&density=[density]");
    ((StringBuilder)localObject).append("&adtag=mvip.gxh.android.search");
    ((StringBuilder)localObject).append("&_bid=2229");
    ((StringBuilder)localObject).append("&_wv=1027");
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
    jdField_c_of_type_JavaUtilMap.put("themepatch", "https://gxh.material.qq.com/patch/little_world/android/[id].zip");
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
  
  public static String a(Context paramContext, String paramString1, String paramString2, IndividuationUrlHelper.UrlCallback paramUrlCallback)
  {
    return b(paramContext, a(paramString1, paramUrlCallback), paramString2);
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
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_JavaUtilList.add(new SoftReference(new IndividuationUrlHelper.IconExtendData(paramString, paramImageView)));
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        paramString = a(paramString, jdField_a_of_type_ComTencentMobileqqVasIndividuationUrlHelper$UrlCallback);
      } else {
        paramString = null;
      }
      paramImageView = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        jdField_a_of_type_JavaUtilList.clear();
        return paramString;
      }
    }
    else
    {
      paramImageView = (String)jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return paramImageView;
  }
  
  public static String a(String paramString, IndividuationUrlHelper.UrlCallback paramUrlCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject2;
    if (jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      localObject1 = (String)jdField_a_of_type_JavaUtilMap.get(paramString);
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getUrl, from config, id=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", url=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("IndividuationUrlHelper", 2, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject2 = null;
    }
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
          ThreadManager.post(new IndividuationUrlHelper.2(paramUrlCallback), 5, null, true);
        } else {
          a(MobileQQ.sMobileQQ.peekAppRuntime());
        }
      }
      paramUrlCallback = (String)jdField_b_of_type_JavaUtilMap.get(paramString);
      localObject1 = paramUrlCallback;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getUrl, from default, id=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", url=");
        ((StringBuilder)localObject1).append(paramUrlCallback);
        QLog.d("IndividuationUrlHelper", 2, ((StringBuilder)localObject1).toString());
        localObject1 = paramUrlCallback;
      }
    }
    paramUrlCallback = (IndividuationUrlHelper.UrlCallback)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = a(MobileQQ.sMobileQQ.peekAppRuntime(), (String)jdField_c_of_type_JavaUtilMap.get(paramString), paramString);
      paramUrlCallback = (IndividuationUrlHelper.UrlCallback)localObject1;
      if (QLog.isColorLevel())
      {
        paramUrlCallback = new StringBuilder();
        paramUrlCallback.append("getUrl, from raw default, id=");
        paramUrlCallback.append(paramString);
        paramUrlCallback.append(", url=");
        paramUrlCallback.append((String)localObject1);
        QLog.d("IndividuationUrlHelper", 2, paramUrlCallback.toString());
        paramUrlCallback = (IndividuationUrlHelper.UrlCallback)localObject1;
      }
    }
    return paramUrlCallback;
  }
  
  public static String a(String paramString, Map<String, String> paramMap)
  {
    paramString = a(paramString, null);
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.keySet().iterator();
        for (;;)
        {
          str = paramString;
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
          paramString = paramString.replace(str, (CharSequence)paramMap.get(str));
        }
      }
    }
    return str;
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    Object localObject = paramString1;
    try
    {
      paramString1 = paramString1.replace("[client]", "androidQQ");
      localObject = paramString1;
      paramString1 = paramString1.replace("[version]", "8.7.0.5295");
      localObject = paramString1;
      paramString1 = paramString1.replace("[platformId]", "2");
      localObject = paramString1;
      paramString1 = paramString1.replace("[device]", URLEncoder.encode(Build.DEVICE, "UTF-8"));
      localObject = paramString1;
      String str = paramString1.replace("[system]", URLEncoder.encode(Build.VERSION.RELEASE, "UTF-8"));
      paramString1 = paramAppRuntime;
      if (paramAppRuntime == null)
      {
        localObject = str;
        paramString1 = MobileQQ.sMobileQQ.peekAppRuntime();
      }
      if (paramString1 != null)
      {
        localObject = str;
        paramAppRuntime = str.replace("[uin]", paramString1.getAccount());
        localObject = paramAppRuntime;
        return paramAppRuntime.replace("[density]", ThemeUtil.getThemeDensity(paramString1.getApplication()));
      }
      localObject = str;
      QLog.e("IndividuationUrlHelper", 1, String.format("replaceCommonParams null == app, url=%s, urlId=%s", new Object[] { str, paramString2 }));
      return str;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("IndividuationUrlHelper", 1, String.format("replaceCommonParams, url=%s, urlId=%s, exception=%s", new Object[] { localObject, paramString2, MsfSdkUtils.getStackTraceString(paramAppRuntime) }));
    }
    return localObject;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {}
    try
    {
      QLog.e("IndividuationUrlHelper", 1, "parseJson, app null");
      return;
    }
    finally
    {
      boolean bool;
      long l1;
      Object localObject1;
      break label301;
    }
    bool = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true);
    if (!bool) {
      return;
    }
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
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramAppRuntime.getApplication().getFilesDir());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("vipData_individuation_url.android.json");
    localObject1 = VasUpdateUtil.a(paramAppRuntime, 1000L, "vipData_individuation_url.android.json", ((StringBuilder)localObject1).toString(), true, null);
    if ((localObject1 != null) && (((File)localObject1).exists()))
    {
      bool = a(paramAppRuntime, (File)localObject1);
      if (!bool) {}
    }
    else
    {
      QLog.e("IndividuationUrlHelper", 1, "parseJson, no json file");
    }
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("parseJson, duration=");
      paramAppRuntime.append(System.currentTimeMillis() - l1);
      QLog.d("IndividuationUrlHelper", 2, paramAppRuntime.toString());
    }
    return;
    label301:
    for (;;)
    {
      throw paramAppRuntime;
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, JSONArray paramJSONArray, int paramInt)
  {
    int i3 = paramJSONArray.length();
    int i1 = 0;
    if (i1 < i3) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i1);
        Object localObject = localJSONObject.optString("business");
        String str = localJSONObject.optString("url");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
        {
          if (!localJSONObject.has("userType")) {
            break label177;
          }
          i2 = localJSONObject.getInt("userType");
          break label180;
          if ((i2 != 0) && (a(localJSONObject))) {
            a(paramAppRuntime, localJSONObject, (String)localObject, str, paramAppRuntime.getAccount());
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseJson, config error, no business or url, config=");
          ((StringBuilder)localObject).append(localJSONObject);
          QLog.e("IndividuationUrlHelper", 1, ((StringBuilder)localObject).toString());
        }
      }
      catch (Exception localException)
      {
        QLog.e("IndividuationUrlHelper", 1, "parseJson, exception", localException);
      }
      i1 += 1;
      break;
      return;
      label177:
      int i2 = -1;
      label180:
      if ((i2 != -1) && ((i2 & paramInt) != paramInt)) {
        i2 = 0;
      } else {
        i2 = 1;
      }
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    int i1 = paramJSONObject.optInt("startIndex");
    int i2 = paramJSONObject.optInt("endIndex");
    if (i1 >= i2)
    {
      int i3 = paramString3.length();
      if ((i3 >= i1) && (i3 >= i2))
      {
        long l1 = Long.parseLong(paramString3.substring(i3 - i1, i3 - i2 + 1));
        long l2 = paramJSONObject.optLong("min");
        long l3 = paramJSONObject.optLong("max");
        if ((l1 >= l2) && (l1 <= l3))
        {
          paramAppRuntime = a(paramAppRuntime, paramString2, paramString1);
          jdField_a_of_type_JavaUtilMap.put(paramString1, paramAppRuntime);
        }
      }
      else
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("parseJson, index config error, uin length=");
        paramAppRuntime.append(i3);
        paramAppRuntime.append(", config=");
        paramAppRuntime.append(paramJSONObject);
        QLog.e("IndividuationUrlHelper", 1, paramAppRuntime.toString());
      }
    }
    else
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("parseJson, startIndex < endIndex, element=");
      paramAppRuntime.append(paramJSONObject);
      QLog.e("IndividuationUrlHelper", 1, paramAppRuntime.toString());
    }
  }
  
  private static boolean a(AppRuntime paramAppRuntime, File paramFile)
  {
    for (;;)
    {
      int i1;
      try
      {
        paramFile = FileUtils.readFileContent(paramFile);
        if (!TextUtils.isEmpty(paramFile))
        {
          paramFile = new JSONArray(paramFile);
          if (paramFile.length() < 1)
          {
            QLog.e("IndividuationUrlHelper", 1, "parseJson, no IndividuationAddress element");
            return true;
          }
          i1 = VasUtil.a(paramAppRuntime).getVipStatus().getPrivilegeFlags(null);
          if ((i1 & 0x4) == 0) {
            break label169;
          }
          i1 = 4;
          a(paramAppRuntime, paramFile, i1);
        }
        else
        {
          QLog.e("IndividuationUrlHelper", 1, "parseJson, jsonStr null");
        }
      }
      catch (OutOfMemoryError paramAppRuntime)
      {
        paramFile = new StringBuilder();
        paramFile.append("parseJson, oom=");
        paramFile.append(MsfSdkUtils.getStackTraceString(paramAppRuntime));
        QLog.e("IndividuationUrlHelper", 1, paramFile.toString());
      }
      catch (Exception paramAppRuntime)
      {
        paramFile = new StringBuilder();
        paramFile.append("parseJson, exception=");
        paramFile.append(MsfSdkUtils.getStackTraceString(paramAppRuntime));
        QLog.e("IndividuationUrlHelper", 1, paramFile.toString());
      }
      return false;
      label169:
      if ((i1 & 0x2) != 0) {
        i1 = 2;
      } else {
        i1 = 1;
      }
    }
  }
  
  private static boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("minVersion"))
    {
      String str = paramJSONObject.getString("minVersion");
      if ((!TextUtils.isEmpty(str)) && (!((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isLaterVersionByUrlConfig(str, "8.7.0")))
      {
        bool1 = false;
        break label53;
      }
    }
    boolean bool1 = true;
    label53:
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (paramJSONObject.has("maxVersion"))
      {
        paramJSONObject = paramJSONObject.getString("maxVersion");
        bool2 = bool1;
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          bool2 = bool1;
          if (!((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isLaterVersionByUrlConfig("8.7.0", paramJSONObject)) {
            bool2 = false;
          }
        }
      }
    }
    return bool2;
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("decodeMarketUrl:");
      paramContext.append(paramString1);
      QLog.i("IndividuationUrlHelper", 2, paramContext.toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramContext = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString1);
      paramContext.append("&adtag=");
      paramContext.append(paramString2);
      paramContext = paramContext.toString();
    }
    return paramContext;
  }
  
  private static String b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeMarketDetailUrl:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", id=");
        localStringBuilder.append(paramString2);
        QLog.i("IndividuationUrlHelper", 2, localStringBuilder.toString());
      }
      paramString1 = b(paramContext, paramString1, paramString3);
      paramContext = paramString1;
      if (!TextUtils.isEmpty(paramString1)) {
        paramContext = paramString1.replace("[id]", paramString2);
      }
      return paramContext;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividuationUrlHelper
 * JD-Core Version:    0.7.0.1
 */