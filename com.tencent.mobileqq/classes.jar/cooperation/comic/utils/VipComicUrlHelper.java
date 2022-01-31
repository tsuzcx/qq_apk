package cooperation.comic.utils;

import java.util.HashMap;
import java.util.Map;

public class VipComicUrlHelper
{
  private static Map jdField_a_of_type_JavaUtilMap;
  private static boolean jdField_a_of_type_Boolean;
  private static Map b = new HashMap();
  
  static
  {
    b.put("comicIndex", "https://qc.vip.qq.com/pages/index.html?asyncMode=3");
    b.put("comicCategory", "https://cdn.vip.qq.com/club/client/comic/release/html/category.html");
    b.put("comicGroup", "https://cdn.vip.qq.com/club/client/comic/release/html/group.html");
    b.put("comicMore", "https://qc.vip.qq.com/pages/community/index.html?_wv=3&_cwv=4&origin=1");
    b.put("comicPayDownload", "https://cdn.vip.qq.com/club/client/comic/release/html/payDownload.html");
    b.put("comicPayRead", "https://cdn.vip.qq.com/club/client/comic/release/html/payRead.html");
    b.put("comicDetailComic", "https://cdn.vip.qq.com/club/client/comic/release/html/detail.html");
    b.put("comicDetailNovel", "https://cdn.vip.qq.com/club/client/comic/release/html/detail.html");
    b.put("comicDetailVideo", "https://cdn.vip.qq.com/club/client/comic/release/html/video.html");
    b.put("comicMyPic", "https://cdn.vip.qq.com/club/client/comic/release/html/my_pic.html");
    b.put("comicVideoSimple", "https://cdn.vip.qq.com/club/client/comic/release/html/video.html");
    b.put("comicReadShare", "https://cdn.vip.qq.com/club/client/comic/release/html/read_share.html");
    b.put("comicPicShare", "https://cdn.vip.qq.com/club/client/comic/release/html/pic_share.html");
    b.put("comicReport", "http://guanjia.qq.com/online_server/m_report.html");
    b.put("comicCdn", "http://imgcache.gtimg.cn/club/mobile/profile/comic_center/");
    b.put("comicFav", "https://cdn.vip.qq.com/club/client/comic/release/html/favorite.html");
    b.put("comicReaderContent", "https://cdn.vip.qq.com/club/client/comic/release/html/readerIndex.html");
    b.put("comicSearch", "https://cdn.vip.qq.com/club/client/comic/release/html/search.html?platId=109&_bid=354&pos=external&_wv=1027&from=6");
    b.put("comicBarrageList", "https://cdn.vip.qq.com/club/client/comic/release/html/bulletScreen.html");
    b.put("comicQRCode", "https://cdn.vip.qq.com/club/client/comic/release/html/redirect.html");
  }
  
  public static String a(String paramString)
  {
    String str1 = null;
    if (jdField_a_of_type_JavaUtilMap != null) {
      str1 = (String)jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = (String)b.get(paramString);
    }
    return str2;
  }
  
  /* Error */
  public static void a(android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 113	cooperation/comic/utils/VipComicUrlHelper:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: ifnull -5 -> 11
    //   19: aload_0
    //   20: ldc 115
    //   22: invokevirtual 121	android/content/Intent:getSerializableExtra	(Ljava/lang/String;)Ljava/io/Serializable;
    //   25: astore_0
    //   26: aload_0
    //   27: instanceof 12
    //   30: ifeq -19 -> 11
    //   33: aload_0
    //   34: checkcast 12	java/util/HashMap
    //   37: astore_0
    //   38: aload_0
    //   39: invokevirtual 125	java/util/HashMap:isEmpty	()Z
    //   42: ifne -31 -> 11
    //   45: getstatic 104	cooperation/comic/utils/VipComicUrlHelper:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   48: ifnonnull +13 -> 61
    //   51: new 12	java/util/HashMap
    //   54: dup
    //   55: invokespecial 15	java/util/HashMap:<init>	()V
    //   58: putstatic 104	cooperation/comic/utils/VipComicUrlHelper:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   61: getstatic 104	cooperation/comic/utils/VipComicUrlHelper:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   64: invokeinterface 128 1 0
    //   69: getstatic 104	cooperation/comic/utils/VipComicUrlHelper:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   72: aload_0
    //   73: invokeinterface 132 2 0
    //   78: iconst_1
    //   79: putstatic 113	cooperation/comic/utils/VipComicUrlHelper:jdField_a_of_type_Boolean	Z
    //   82: goto -71 -> 11
    //   85: astore_0
    //   86: ldc 2
    //   88: monitorexit
    //   89: aload_0
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramIntent	android.content.Intent
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	85	finally
    //   19	61	85	finally
    //   61	82	85	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.utils.VipComicUrlHelper
 * JD-Core Version:    0.7.0.1
 */