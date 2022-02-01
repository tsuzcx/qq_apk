package cooperation.qzone.util;

import android.text.TextUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecentPhotoManger
{
  public static final String KEY_BANNER_RECENT_PHOTO_BLACKLIST = "key_banner_recent_photo_blacklist";
  public static final String KEY_BUBBLE_RECENT_PHOTO_BLACKLIST = "key_bubble_recent_photo_blacklist";
  public static final String KEY_PERSONAL_ALBUM_RECENT_PHOTO_BLACKLIST = "key_personal_album_recent_photo_blacklist";
  public static final String KEY_SHUOSHUO_RECENT_PHOTO_BLACKLIST = "key_shuoshuo_recent_photo_blacklist";
  public static final int MAX_COUNT = 500;
  public static final long OFFSET_TIME = 86400000L;
  public static final int RECENT_PHOTO_SOURCE_BUBBLE = 3;
  public static final int RECENT_PHOTO_SOURCE_LOCAL = 0;
  public static final int RECENT_PHOTO_SOURCE_PERSONAL_ALBUM = 1;
  public static final int RECENT_PHOTO_SOURCE_SHUOSHUO = 2;
  public static final int RECENT_PHOTO_SOURCE_SHUOSHUO_EXT = 3;
  
  public static void addToRecentPhotoBlacklist(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    List localList;
    do
    {
      return;
      localList = getRecentPhotoBlackListPath(paramString1, 500);
    } while (localList.contains(paramString2));
    localList.add(0, paramString2);
    if (localList.size() > 500) {
      localList.remove(500);
    }
    LocalMultiProcConfig.putString(paramString1, encodeBlackList(localList));
  }
  
  public static void addToRecentPhotoBlacklist(String paramString, List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    List localList = getRecentPhotoBlackListPath(paramString, 500 - paramList.size());
    localLinkedList.addAll(paramList);
    localLinkedList.addAll(localList);
    LocalMultiProcConfig.putString(paramString, encodeBlackList(localLinkedList));
  }
  
  private static String encodeBlackList(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append((String)paramList.next());
      localStringBuilder.append(";");
    }
    return localStringBuilder.toString();
  }
  
  public static List<String> getRecentPhotoBlackListPath(String paramString)
  {
    return getRecentPhotoBlackListPath(paramString, 500);
  }
  
  public static List<String> getRecentPhotoBlackListPath(String paramString, int paramInt)
  {
    int i = 0;
    paramString = LocalMultiProcConfig.getString(paramString, "").split(";");
    LinkedList localLinkedList = new LinkedList();
    if ((paramString.length == 0) || (paramInt <= 0)) {
      return localLinkedList;
    }
    int k;
    for (int j = 0;; j = k)
    {
      if (i < paramString.length)
      {
        CharSequence localCharSequence = paramString[i];
        k = j;
        if (!TextUtils.isEmpty(localCharSequence))
        {
          localLinkedList.add(localCharSequence);
          k = j + 1;
        }
        if (k != paramInt) {}
      }
      else
      {
        return localLinkedList;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.util.RecentPhotoManger
 * JD-Core Version:    0.7.0.1
 */