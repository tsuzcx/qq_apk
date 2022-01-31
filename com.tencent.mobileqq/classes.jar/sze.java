import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class sze
  extends taw
{
  public static final String a;
  public static final String b = sxm.a("StorySvc.del_feed_comment");
  public static final String c = sxm.a("StorySvc.get_comment_list");
  protected int a;
  protected szs a;
  protected boolean a;
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = sxm.a("StorySvc.add_feed_comment");
  }
  
  public sze(szs paramszs)
  {
    this.jdField_a_of_type_Szs = paramszs;
  }
  
  public static void a(CommentEntry paramCommentEntry, tbc paramtbc)
  {
    paramCommentEntry = new szi(paramCommentEntry, paramtbc);
    paramtbc = new szj(paramtbc);
    tay.a().a(paramCommentEntry, paramtbc);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = null;
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).putOpt("vid", paramString3);
      ((JSONObject)localObject2).putOpt("feedid", paramString4);
      ((JSONObject)localObject2).putOpt("pvid", paramString5);
      ((JSONObject)localObject2).putOpt("styles", new JSONArray(paramString6));
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.qqstory:FeedCommentDataProvider", 2, "addGamePKComment jsonException " + localJSONException);
      }
    }
    a(paramString1, null, paramString2, l, paramInt, localObject1, 4, new szf(paramString1, paramInt, l, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, tbc paramtbc)
  {
    paramString1 = new szg(paramString1, paramString2, paramString3, paramLong, paramInt1, paramString4, paramInt2, paramtbc);
    paramString2 = new szh(paramtbc);
    tay.a().a(paramString1, paramString2);
  }
  
  public static void b(CommentEntry paramCommentEntry, tbc paramtbc)
  {
    paramCommentEntry = new szg(paramCommentEntry, paramtbc);
    paramtbc = new szh(paramtbc);
    tay.a().a(paramCommentEntry, paramtbc);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Szs.a.feedId, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new szk(this, paramString, paramInt);
    szl localszl = new szl(this);
    tay.a().a(paramString, localszl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sze
 * JD-Core Version:    0.7.0.1
 */