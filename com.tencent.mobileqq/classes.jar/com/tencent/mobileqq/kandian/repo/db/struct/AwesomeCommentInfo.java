package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.AwesomeCommentInfo;

public class AwesomeCommentInfo
{
  public static int c = 0;
  public static String h = "ReadInJoy_Awesome_comment_plan";
  public static String i = "ReadInJoy_Awesome_comment_max_lines";
  public int a;
  public long a;
  public AbsBaseArticleInfo a;
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
    jdField_c_of_type_Int = ((Integer)RIJSPUtils.a(h, Integer.valueOf(0))).intValue();
  }
  
  private static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mResolvedFeedType != 5) && (paramAbsBaseArticleInfo.mResolvedFeedType != 19) && (paramAbsBaseArticleInfo.mResolvedFeedType != 14) && (paramAbsBaseArticleInfo.mResolvedFeedType != 4) && (paramAbsBaseArticleInfo.mResolvedFeedType != 66) && (paramAbsBaseArticleInfo.mResolvedFeedType != 115) && (paramAbsBaseArticleInfo.mResolvedFeedType != 6))
    {
      if ((paramAbsBaseArticleInfo.mResolvedFeedType != 60) && (paramAbsBaseArticleInfo.mResolvedFeedType != 61))
      {
        if (paramAbsBaseArticleInfo.mResolvedFeedType == 0) {
          return 1;
        }
        return 0;
      }
      return 3;
    }
    return 2;
  }
  
  public static void a()
  {
    jdField_c_of_type_Int = ((Integer)RIJSPUtils.a(h, Integer.valueOf(0))).intValue();
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAbsBaseArticleInfo != null) {
      try
      {
        if ((paramAbsBaseArticleInfo.mResolvedFeedType == 0) && ((paramAbsBaseArticleInfo instanceof BaseArticleInfo))) {
          paramAbsBaseArticleInfo.mResolvedFeedType = paramInt1;
        }
        localJSONObject.put("entry", a(paramAbsBaseArticleInfo));
        localJSONObject.put("comment_id", paramAbsBaseArticleInfo.oldCommentId);
        localJSONObject.put("limit", paramInt2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    if (paramAbsBaseArticleInfo != null)
    {
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleID);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.mStrategyId);
      localStringBuilder.append("");
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", paramString, paramString, 0, 0, (String)localObject, localStringBuilder.toString(), paramAbsBaseArticleInfo.rawkey, localJSONObject.toString(), false);
    }
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, articlesummary.AwesomeCommentInfo paramAwesomeCommentInfo)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("AwesomeCommentInfo", 2, "articleinfo == null");
      return;
    }
    if (paramAwesomeCommentInfo.rowkey.has()) {
      paramAbsBaseArticleInfo.rawkey = paramAwesomeCommentInfo.rowkey.get().toStringUtf8();
    }
    if (paramAwesomeCommentInfo.icon_url.has()) {
      paramAbsBaseArticleInfo.iconUrl = paramAwesomeCommentInfo.icon_url.get().toStringUtf8();
    }
    if (paramAwesomeCommentInfo.icon_with.has()) {
      paramAbsBaseArticleInfo.iconWith = paramAwesomeCommentInfo.icon_with.get();
    }
    if (paramAwesomeCommentInfo.icon_height.has()) {
      paramAbsBaseArticleInfo.iconHeight = paramAwesomeCommentInfo.icon_height.get();
    }
    if (paramAwesomeCommentInfo.jump_url.has()) {
      paramAbsBaseArticleInfo.jumpUrl = paramAwesomeCommentInfo.jump_url.get().toStringUtf8();
    }
    if (paramAwesomeCommentInfo.uin.has()) {
      paramAbsBaseArticleInfo.uin = paramAwesomeCommentInfo.uin.get();
    }
    if (paramAwesomeCommentInfo.nick_name.has()) {
      paramAbsBaseArticleInfo.nickName = paramAwesomeCommentInfo.nick_name.get().toStringUtf8();
    }
    if (paramAwesomeCommentInfo.avatar.has()) {
      paramAbsBaseArticleInfo.avatar = paramAwesomeCommentInfo.avatar.get().toStringUtf8();
    }
    if (paramAwesomeCommentInfo.comment_id.has()) {
      paramAbsBaseArticleInfo.oldCommentId = paramAwesomeCommentInfo.comment_id.get().toStringUtf8();
    }
    if (paramAwesomeCommentInfo.content.has()) {
      paramAbsBaseArticleInfo.content = paramAwesomeCommentInfo.content.get().toStringUtf8();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AwesomeCommentInfo{rawkey='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", icon_url='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", icon_with=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", icon_height=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", jump_url='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", nick_name='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", avatar='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comment_id='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.AwesomeCommentInfo
 * JD-Core Version:    0.7.0.1
 */