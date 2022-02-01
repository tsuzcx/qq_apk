package com.tencent.mobileqq.kandian.repo.common.constant;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyConstants
{
  public static final Pair<Integer, Integer>[] A;
  public static String B = "https://post.mp.qq.com/mkandian/follow?_wv=7";
  public static String C = "https://post.mp.qq.com/mkandian/fan?_wv=7";
  public static final char[] a = { '…' };
  public static final String b = new String(a);
  public static final String c = HardCodeUtil.a(2131910630);
  public static String d = "https://kandian.qq.com/mqq/html/homepage.html?_wv=16778243&_bid=2378&uin=";
  public static String e = "https://kandian.qq.com/mqq/html/messagebox3.html?_wv=3&_bid=2378&x5PreFetch=1&adtag=1&privateLetters=";
  public static String f = "https://kandian.qq.com/mqq/vue/comment?_wv=3&_bid=2378&x5PreFetch=1&feedstype=&uin=&feeds_id=";
  public static String g = "https://kandian.qq.com/mqq/html/recommend_friends.html?_wv=3&_bid=2378&x5PreFetch=1&feeds_id=";
  public static String h = "https://kandian.qq.com/mqq/vue/main?_wv=10145&_bid=3302&adfrom=qqshare&x5PreFetch=1&accountId=";
  public static String i = "https://kandian.qq.com/mqq/html/messagebox3.html?_wv=3&_bid=2378&x5PreFetch=1&adtag=2&privateLetters=";
  public static String j = "https://kandian.qq.com/mqq/html/allfrdbiu.html?_wv=3&_bid=2378&x5PreFetch=1";
  public static String k = "https://kandian.qq.com/mqq/vue/wendafeeds?_wv=67&_bid=2378&source=1";
  public static String l = "https://kandian.qq.com/mqq/vue/main?_wv=10145&_bid=3302&adfrom=qqshare&x5PreFetch=1&accountId=";
  public static boolean m = false;
  public static String n = HardCodeUtil.a(2131910284);
  public static String o = "https://kandian.qq.com/mqq/html/feedback.html?_wv=3&_bid=2378&x5PreFetch=1";
  public static String p = "https://post.mp.qq.com/mkandian/history";
  public static String q = "https://post.mp.qq.com/mkandian/topic?_wv=3";
  public static String r = "https://kandian.qq.com/mqq/html/collectBox.html?_wv=3&_bid=2378&x5PreFetch=1";
  public static String s = "https://post.mp.qq.com/mkandian/notify?_wv=3";
  public static int t = 819200;
  public static int u = 3000;
  public static int v = 500;
  public static int w = 200;
  public static final Pair<Integer, Integer>[] x;
  public static final Pair<Integer, Integer>[] y;
  public static final Pair<Integer, Integer>[] z;
  
  static
  {
    Object localObject1 = Integer.valueOf(95);
    Object localObject3 = new Pair(Integer.valueOf(159), localObject1);
    Object localObject4 = new Pair(Integer.valueOf(179), localObject1);
    Object localObject2 = Integer.valueOf(143);
    Pair localPair1 = new Pair(Integer.valueOf(158), localObject2);
    Pair localPair2 = new Pair(Integer.valueOf(178), localObject2);
    Pair localPair3 = new Pair(Integer.valueOf(238), localObject2);
    Pair localPair4 = new Pair(Integer.valueOf(358), localObject2);
    Pair localPair5 = new Pair(Integer.valueOf(119), localObject1);
    Pair localPair6 = new Pair(Integer.valueOf(239), localObject1);
    Pair localPair7 = new Pair(Integer.valueOf(79), localObject1);
    Pair localPair8 = new Pair(Integer.valueOf(59), localObject1);
    Pair localPair9 = new Pair(Integer.valueOf(89), localObject1);
    Integer localInteger1 = Integer.valueOf(280);
    x = new Pair[] { localObject3, localObject4, localPair1, localPair2, localPair3, localPair4, localPair5, localPair6, localPair7, localPair8, localPair9, new Pair(localInteger1, localInteger1) };
    localObject3 = Integer.valueOf(160);
    localObject4 = Integer.valueOf(90);
    y = new Pair[] { new Pair(localObject3, localObject4), new Pair(localInteger1, localInteger1), new Pair(Integer.valueOf(30), Integer.valueOf(40)), new Pair(localObject4, localObject3), new Pair(Integer.valueOf(440), Integer.valueOf(246)) };
    localPair1 = new Pair(Integer.valueOf(159), localObject1);
    localPair2 = new Pair(Integer.valueOf(179), localObject1);
    localPair3 = new Pair(Integer.valueOf(158), localObject2);
    localPair4 = new Pair(Integer.valueOf(178), localObject2);
    localPair5 = new Pair(Integer.valueOf(238), localObject2);
    localObject2 = new Pair(Integer.valueOf(358), localObject2);
    localPair6 = new Pair(Integer.valueOf(119), localObject1);
    localPair7 = new Pair(Integer.valueOf(239), localObject1);
    localPair8 = new Pair(Integer.valueOf(79), localObject1);
    localPair9 = new Pair(Integer.valueOf(59), localObject1);
    localObject1 = new Pair(Integer.valueOf(89), localObject1);
    Pair localPair10 = new Pair(localInteger1, localInteger1);
    Integer localInteger2 = Integer.valueOf(372);
    z = new Pair[] { localPair1, localPair2, localPair3, localPair4, localPair5, localObject2, localPair6, localPair7, localPair8, localPair9, localObject1, localPair10, new Pair(localInteger2, Integer.valueOf(224)), new Pair(localInteger2, Integer.valueOf(272)), new Pair(localInteger2, Integer.valueOf(520)), new Pair(localInteger2, Integer.valueOf(424)) };
    A = new Pair[] { new Pair(localObject3, localObject4), new Pair(localInteger1, localInteger1), new Pair(Integer.valueOf(30), Integer.valueOf(40)), new Pair(localObject4, localObject3), new Pair(Integer.valueOf(440), Integer.valueOf(246)), new Pair(localInteger2, Integer.valueOf(224)), new Pair(localInteger2, Integer.valueOf(272)), new Pair(localInteger2, Integer.valueOf(520)), new Pair(localInteger2, Integer.valueOf(424)) };
  }
  
  public static Pair<Integer, Integer>[] a(String paramString, int paramInt)
  {
    boolean bool;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        bool = TextUtils.equals(Uri.parse(paramString).getQueryParameter("new_crop_size"), "1");
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("[getImageScales] e = ");
        localStringBuilder2.append(localException);
        QLog.e("ReadInJoyConstants", 1, localStringBuilder2.toString());
      }
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[getImageScales] url = ");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append(", useNewCropSize = ");
      localStringBuilder1.append(bool);
      QLog.i("ReadInJoyConstants", 1, localStringBuilder1.toString());
    }
    if (paramInt == 0)
    {
      if (bool) {
        return z;
      }
      return x;
    }
    if (bool) {
      return A;
    }
    return y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants
 * JD-Core Version:    0.7.0.1
 */