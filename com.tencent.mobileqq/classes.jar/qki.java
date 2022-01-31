import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.AwesomeCommentInfo;

public class qki
{
  public static int c;
  public static String h = "ReadInJoy_Awesome_comment_plan";
  public static String i = "ReadInJoy_Awesome_comment_max_lines";
  public int a;
  public long a;
  public BaseArticleInfo a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  static
  {
    jdField_c_of_type_Int = ((Integer)bkbq.a(h, Integer.valueOf(0))).intValue();
  }
  
  private static int a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo.mResolvedFeedType == 5) || (paramBaseArticleInfo.mResolvedFeedType == 19) || (paramBaseArticleInfo.mResolvedFeedType == 14) || (paramBaseArticleInfo.mResolvedFeedType == 4) || (paramBaseArticleInfo.mResolvedFeedType == 66) || (paramBaseArticleInfo.mResolvedFeedType == 115) || (paramBaseArticleInfo.mResolvedFeedType == 6)) {
      return 2;
    }
    if ((paramBaseArticleInfo.mResolvedFeedType == 60) || (paramBaseArticleInfo.mResolvedFeedType == 61)) {
      return 3;
    }
    if (paramBaseArticleInfo.mResolvedFeedType == 0) {
      return 1;
    }
    return 0;
  }
  
  public static void a()
  {
    jdField_c_of_type_Int = ((Integer)bkbq.a(h, Integer.valueOf(0))).intValue();
    NativeAwesomeCommentView.jdField_a_of_type_Int = ((Integer)bkbq.a(i, Integer.valueOf(1))).intValue();
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo != null) {}
    try
    {
      if ((paramBaseArticleInfo.mResolvedFeedType == 0) && ((paramBaseArticleInfo instanceof ArticleInfo))) {
        paramBaseArticleInfo.mResolvedFeedType = rqj.a((ArticleInfo)paramBaseArticleInfo, 0);
      }
      localJSONObject.put("entry", a(paramBaseArticleInfo));
      localJSONObject.put("comment_id", paramBaseArticleInfo.comment_id);
      localJSONObject.put("limit", NativeAwesomeCommentView.jdField_a_of_type_Int);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    if (paramBaseArticleInfo != null) {
      nrt.a(null, "", paramString, paramString, 0, 0, paramBaseArticleInfo.mArticleID + "", paramBaseArticleInfo.mStrategyId + "", paramBaseArticleInfo.rawkey, localJSONObject.toString(), false);
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, articlesummary.AwesomeCommentInfo paramAwesomeCommentInfo)
  {
    if (paramBaseArticleInfo == null) {
      QLog.d("AwesomeCommentInfo", 2, "articleinfo == null");
    }
    do
    {
      return;
      if (paramAwesomeCommentInfo.rowkey.has()) {
        paramBaseArticleInfo.rawkey = paramAwesomeCommentInfo.rowkey.get().toStringUtf8();
      }
      if (paramAwesomeCommentInfo.icon_url.has()) {
        paramBaseArticleInfo.icon_url = paramAwesomeCommentInfo.icon_url.get().toStringUtf8();
      }
      if (paramAwesomeCommentInfo.icon_with.has()) {
        paramBaseArticleInfo.icon_with = paramAwesomeCommentInfo.icon_with.get();
      }
      if (paramAwesomeCommentInfo.icon_height.has()) {
        paramBaseArticleInfo.icon_height = paramAwesomeCommentInfo.icon_height.get();
      }
      if (paramAwesomeCommentInfo.jump_url.has()) {
        paramBaseArticleInfo.jump_url = paramAwesomeCommentInfo.jump_url.get().toStringUtf8();
      }
      if (paramAwesomeCommentInfo.uin.has()) {
        paramBaseArticleInfo.uin = paramAwesomeCommentInfo.uin.get();
      }
      if (paramAwesomeCommentInfo.nick_name.has()) {
        paramBaseArticleInfo.nick_name = paramAwesomeCommentInfo.nick_name.get().toStringUtf8();
      }
      if (paramAwesomeCommentInfo.avatar.has()) {
        paramBaseArticleInfo.avatar = paramAwesomeCommentInfo.avatar.get().toStringUtf8();
      }
      if (paramAwesomeCommentInfo.comment_id.has()) {
        paramBaseArticleInfo.comment_id = paramAwesomeCommentInfo.comment_id.get().toStringUtf8();
      }
    } while (!paramAwesomeCommentInfo.content.has());
    paramBaseArticleInfo.content = paramAwesomeCommentInfo.content.get().toStringUtf8();
  }
  
  public String toString()
  {
    return "AwesomeCommentInfo{rawkey='" + this.jdField_a_of_type_JavaLangString + '\'' + ", icon_url='" + this.jdField_b_of_type_JavaLangString + '\'' + ", icon_with=" + this.jdField_a_of_type_Int + ", icon_height=" + this.jdField_b_of_type_Int + ", jump_url='" + this.jdField_c_of_type_JavaLangString + '\'' + ", uin=" + this.jdField_a_of_type_Long + ", nick_name='" + this.d + '\'' + ", avatar='" + this.e + '\'' + ", comment_id='" + this.f + '\'' + ", content='" + this.g + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qki
 * JD-Core Version:    0.7.0.1
 */