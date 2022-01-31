import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class oek
  implements AladdinConfigHandler
{
  private static final Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private static boolean jdField_a_of_type_Boolean = ((Boolean)bgmq.a("readinjjoy_feeds_card_whitelist", Boolean.valueOf(false))).booleanValue();
  
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
    a(2001, 2006);
  }
  
  private static void a(int paramInt1, int paramInt2)
  {
    while (paramInt1 <= paramInt2)
    {
      jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt1));
      paramInt1 += 1;
    }
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (!jdField_a_of_type_Boolean) {
      QLog.d("WhiteListBidConfigHandler", 1, "isWhiteListCardAndShow: close");
    }
    int i;
    do
    {
      do
      {
        do
        {
          return true;
          if (paramArticleInfo == null) {
            return false;
          }
        } while (((paramArticleInfo.mChannelID != 0L) && (paramArticleInfo.mChannelID != 70L) && (!odm.c((int)paramArticleInfo.mChannelID))) || ((paramArticleInfo instanceof AdvertisementInfo)) || (paramArticleInfo.mFeedType == 29));
        i = obz.a(paramArticleInfo);
        if (!jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i))) {
          break;
        }
      } while (!obz.s(paramArticleInfo));
      i = ovn.a(paramArticleInfo);
    } while ((i == 1) || (i == 2));
    return false;
    QLog.d("WhiteListBidConfigHandler", 1, "isWhiteListCardAndShow: " + i + " is not white list card: " + paramArticleInfo);
    return false;
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("WhiteListBidConfigHandler", 1, "[onReceiveConfig] " + paramString);
    paramString = ocx.a(paramString);
    Iterator localIterator = paramString.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramString.get(str1);
      QLog.d("WhiteListBidConfigHandler", 2, "[onReceiveConfig] key=" + str1 + ", value=" + str2);
      if (TextUtils.equals(str1, "kandian_feeds_card_whitelist"))
      {
        if (Integer.valueOf(str2).intValue() == 1) {}
        for (boolean bool = true;; bool = false)
        {
          jdField_a_of_type_Boolean = bool;
          bgmq.a("readinjjoy_feeds_card_whitelist", Boolean.valueOf(bool));
          break;
        }
      }
      if (TextUtils.equals(str1, "kandian_feeds_card_whitelist_bid"))
      {
        bgmq.a("default_feeds_proteus_offline_bid", str2);
        new rdj().a("default_feeds");
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    QLog.d("WhiteListBidConfigHandler", 1, "[onWipeConfig]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oek
 * JD-Core Version:    0.7.0.1
 */