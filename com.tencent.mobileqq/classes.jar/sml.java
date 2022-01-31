import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class sml
  extends sod
{
  public static final String a;
  public static final String b = skt.a("StorySvc.del_feed_comment");
  public static final String c = skt.a("StorySvc.get_comment_list");
  protected int a;
  protected smz a;
  protected boolean a;
  private String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = skt.a("StorySvc.add_feed_comment");
  }
  
  public sml(smz paramsmz)
  {
    this.jdField_a_of_type_Smz = paramsmz;
  }
  
  public static void a(CommentEntry paramCommentEntry, soj paramsoj)
  {
    paramCommentEntry = new smp(paramCommentEntry, paramsoj);
    paramsoj = new smq(paramsoj);
    sof.a().a(paramCommentEntry, paramsoj);
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
    a(paramString1, null, paramString2, l, paramInt, localObject1, 4, new smm(paramString1, paramInt, l, paramString2, paramString3, paramString4, paramString5, paramString6));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, soj paramsoj)
  {
    paramString1 = new smn(paramString1, paramString2, paramString3, paramLong, paramInt1, paramString4, paramInt2, paramsoj);
    paramString2 = new smo(paramsoj);
    sof.a().a(paramString1, paramString2);
  }
  
  public static void b(CommentEntry paramCommentEntry, soj paramsoj)
  {
    paramCommentEntry = new smn(paramCommentEntry, paramsoj);
    paramsoj = new smo(paramsoj);
    sof.a().a(paramCommentEntry, paramsoj);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Smz.a.feedId, 0);
  }
  
  public void a(String paramString, int paramInt)
  {
    paramString = new smr(this, paramString, paramInt);
    sms localsms = new sms(this);
    sof.a().a(paramString, localsms);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sml
 * JD-Core Version:    0.7.0.1
 */