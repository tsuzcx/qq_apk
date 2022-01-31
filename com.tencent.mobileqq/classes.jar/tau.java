import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.HashMap;

public class tau
{
  private static LruCache<String, CharSequence> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private static tau jdField_a_of_type_Tau;
  public String a;
  
  public tau()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static tau a()
  {
    if (jdField_a_of_type_Tau == null)
    {
      jdField_a_of_type_Tau = new tau();
      jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(150);
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    return jdField_a_of_type_Tau;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_AndroidSupportV4UtilLruCache != null) {
      jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
    }
  }
  
  public CharSequence a(String paramString)
  {
    return (CharSequence)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
  }
  
  public void a(CommentEntry paramCommentEntry)
  {
    if (paramCommentEntry == null) {
      return;
    }
    paramCommentEntry = paramCommentEntry.feedId + paramCommentEntry.replyTime;
    if (jdField_a_of_type_JavaUtilHashMap.get(paramCommentEntry) == null)
    {
      jdField_a_of_type_JavaUtilHashMap.put(paramCommentEntry, Integer.valueOf(1));
      return;
    }
    int i = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramCommentEntry)).intValue();
    jdField_a_of_type_JavaUtilHashMap.put(paramCommentEntry, Integer.valueOf(i + 1));
  }
  
  public void a(String paramString, CharSequence paramCharSequence)
  {
    if (a(paramString) == null) {
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tau
 * JD-Core Version:    0.7.0.1
 */