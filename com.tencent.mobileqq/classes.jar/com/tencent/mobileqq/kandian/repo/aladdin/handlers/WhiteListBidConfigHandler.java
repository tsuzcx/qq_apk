package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.glue.pts.StyleConfigHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusCDNSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WhiteListBidConfigHandler
  extends SimpleConfigHandler
{
  private static final Set<Integer> a = new HashSet();
  private static boolean b = ((Boolean)RIJSPUtils.b("readinjjoy_feeds_card_whitelist", Boolean.valueOf(false))).booleanValue();
  
  static
  {
    a();
  }
  
  private static void a()
  {
    a(1, 6);
    a(10, 11);
    a(19, 26);
    a(28, 32);
    a(28, 32);
    a(36, 40);
    a(43, 43);
    a(48, 48);
    a(51, 52);
    a(60, 60);
    a(67, 69);
    a(71, 72);
    a(78, 79);
    a(81, 81);
    a(84, 84);
    a(102, 102);
    a(1001, 1004);
    a(1001, 1004);
    a(1008, 1008);
    a(1019, 1020);
    a(1023, 1027);
    a(1029, 1037);
    a(1038, 1042);
    a(2001, 2006);
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    while (paramInt1 <= paramInt2)
    {
      a.add(Integer.valueOf(paramInt1));
      paramInt1 += 1;
    }
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!b)
    {
      QLog.d("WhiteListBidConfigHandler", 1, "isWhiteListCardAndShow: close");
      return true;
    }
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if ((paramAbsBaseArticleInfo.mChannelID != 0L) && (paramAbsBaseArticleInfo.mChannelID != 70L) && (!DailyModeConfigHandler.c((int)paramAbsBaseArticleInfo.mChannelID))) {
      return true;
    }
    if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
      return true;
    }
    if (paramAbsBaseArticleInfo.mFeedType == 29) {
      return true;
    }
    int i = RIJFeedsType.g(paramAbsBaseArticleInfo);
    if (a.contains(Integer.valueOf(i)))
    {
      if (RIJFeedsType.l(paramAbsBaseArticleInfo))
      {
        i = RIJItemViewTypeUtils.G(paramAbsBaseArticleInfo);
        if ((i == 1) || (i == 2)) {
          bool = true;
        }
        return bool;
      }
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isWhiteListCardAndShow: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" is not white list card: ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    QLog.d("WhiteListBidConfigHandler", 1, localStringBuilder.toString());
    return false;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceiveConfig] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("WhiteListBidConfigHandler", 1, ((StringBuilder)localObject).toString());
    Map localMap = AladdinParseUtils.a(paramString);
    Iterator localIterator = localMap.keySet().iterator();
    localObject = "";
    paramString = "";
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1 = (String)localMap.get(str2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveConfig] key=");
      localStringBuilder.append(str2);
      localStringBuilder.append(", value=");
      localStringBuilder.append(str1);
      QLog.d("WhiteListBidConfigHandler", 2, localStringBuilder.toString());
      if (TextUtils.equals(str2, "kandian_feeds_card_whitelist"))
      {
        boolean bool;
        if (Integer.valueOf(str1).intValue() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        b = bool;
        RIJSPUtils.a("readinjjoy_feeds_card_whitelist", Boolean.valueOf(bool));
      }
      else if (TextUtils.equals(str2, "kandian_feeds_card_whitelist_bid"))
      {
        RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid", str1);
        new StyleConfigHelper().a("default_feeds");
        localObject = str1;
      }
      else if (TextUtils.equals(str2, "kandian_feeds_card_cdn_url"))
      {
        paramString = str1;
      }
    }
    RIJProteusCDNSp.a((String)localObject, paramString);
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    QLog.d("WhiteListBidConfigHandler", 1, "[onWipeConfig]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.WhiteListBidConfigHandler
 * JD-Core Version:    0.7.0.1
 */