import com.tencent.biz.qqstory.database.CommentEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class snv
{
  private static HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private static HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private static snv jdField_a_of_type_Snv;
  
  public static snv a()
  {
    if (jdField_a_of_type_Snv == null)
    {
      jdField_a_of_type_Snv = new snv();
      jdField_a_of_type_JavaUtilHashSet = new HashSet();
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      Iterator localIterator = ((spd)sqg.a(17)).a().iterator();
      while (localIterator.hasNext())
      {
        CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
        if (!jdField_a_of_type_JavaUtilHashSet.contains(localCommentEntry.feedId))
        {
          jdField_a_of_type_JavaUtilHashSet.add(localCommentEntry.feedId);
          jdField_a_of_type_JavaUtilHashMap.put(localCommentEntry.feedId, Integer.valueOf(localCommentEntry.commentId));
        }
      }
    }
    return jdField_a_of_type_Snv;
  }
  
  public int a(String paramString)
  {
    paramString = (Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return paramString.intValue();
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilHashSet.clear();
    jdField_a_of_type_JavaUtilHashMap.clear();
    Iterator localIterator = ((spd)sqg.a(17)).a().iterator();
    while (localIterator.hasNext())
    {
      CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
      if (!jdField_a_of_type_JavaUtilHashSet.contains(localCommentEntry.feedId))
      {
        jdField_a_of_type_JavaUtilHashSet.add(localCommentEntry.feedId);
        jdField_a_of_type_JavaUtilHashMap.put(localCommentEntry.feedId, Integer.valueOf(localCommentEntry.commentId));
      }
    }
    urk.d("StoryFailCommentCacher", "update failed comments. size = %d.", new Object[] { Integer.valueOf(jdField_a_of_type_JavaUtilHashSet.size()) });
  }
  
  public boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public void b()
  {
    jdField_a_of_type_JavaUtilHashSet.clear();
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_a_of_type_Snv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     snv
 * JD-Core Version:    0.7.0.1
 */