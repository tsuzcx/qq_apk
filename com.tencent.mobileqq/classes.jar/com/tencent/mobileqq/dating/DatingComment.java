package com.tencent.mobileqq.dating;

import android.text.TextUtils;
import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.Elem;
import appoint.define.appoint_define.Face;
import appoint.define.appoint_define.ReplyInfo;
import appoint.define.appoint_define.RichText;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.notColumn;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DatingComment
{
  public int a;
  public long a;
  public DatingStranger a;
  public String a;
  public DatingStranger b;
  public String b;
  public String c;
  public String d;
  public String e;
  @notColumn
  public String f;
  
  public static DatingComment a(appoint_define.DateComment paramDateComment)
  {
    Object localObject2 = null;
    if (paramDateComment != null)
    {
      if (TextUtils.isEmpty(paramDateComment.str_comment_id.get())) {
        return null;
      }
      DatingComment localDatingComment = new DatingComment();
      localDatingComment.jdField_a_of_type_JavaLangString = paramDateComment.str_comment_id.get();
      localDatingComment.jdField_b_of_type_JavaLangString = DatingUtil.a((appoint_define.AppointID)paramDateComment.msg_appoint_id.get());
      localDatingComment.jdField_a_of_type_Long = paramDateComment.uint32_time.get();
      if (paramDateComment.msg_content.has()) {
        localObject1 = (appoint_define.RichText)paramDateComment.msg_content.get();
      } else {
        localObject1 = null;
      }
      localDatingComment.c = a((appoint_define.RichText)localObject1);
      localDatingComment.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger = DatingStranger.a((appoint_define.StrangerInfo)paramDateComment.msg_publisher_info.get());
      int i;
      if (paramDateComment.uint32_flag.has()) {
        i = paramDateComment.uint32_flag.get();
      } else {
        i = 0;
      }
      localDatingComment.jdField_a_of_type_Int = i;
      Object localObject1 = localObject2;
      if (paramDateComment.msg_reply_info.has()) {
        localObject1 = (appoint_define.ReplyInfo)paramDateComment.msg_reply_info.get();
      }
      if (localObject1 != null)
      {
        localDatingComment.d = ((appoint_define.ReplyInfo)localObject1).str_comment_id.get();
        localDatingComment.jdField_b_of_type_ComTencentMobileqqDatingDatingStranger = DatingStranger.a((appoint_define.StrangerInfo)((appoint_define.ReplyInfo)localObject1).msg_stranger_info.get());
      }
      localDatingComment.f = DatingUtil.a(localDatingComment.jdField_a_of_type_Long, true);
      localDatingComment.e = DatingUtil.a(localDatingComment.jdField_a_of_type_Long, false);
      return localDatingComment;
    }
    return null;
  }
  
  public static DatingComment a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    DatingComment localDatingComment = new DatingComment();
    try
    {
      localDatingComment.jdField_a_of_type_JavaLangString = paramJSONObject.getString("commentId");
      localDatingComment.jdField_b_of_type_JavaLangString = paramJSONObject.getString("datingId");
      localDatingComment.c = paramJSONObject.getString("content");
      localDatingComment.jdField_a_of_type_Long = paramJSONObject.getLong("time");
      localDatingComment.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger = DatingStranger.a(paramJSONObject.getJSONObject("puber"));
      localDatingComment.jdField_a_of_type_Int = paramJSONObject.getInt("flag");
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
    }
    try
    {
      localDatingComment.d = paramJSONObject.getString("replyId");
    }
    catch (JSONException localJSONException2)
    {
      localJSONException2.printStackTrace();
    }
    try
    {
      localDatingComment.jdField_b_of_type_ComTencentMobileqqDatingDatingStranger = DatingStranger.a(paramJSONObject.getJSONObject("replyer"));
      return localDatingComment;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localDatingComment;
  }
  
  public static String a(appoint_define.RichText paramRichText)
  {
    if (paramRichText == null) {
      return "";
    }
    if (paramRichText.rpt_msg_elems.has()) {
      paramRichText = paramRichText.rpt_msg_elems.get();
    } else {
      paramRichText = null;
    }
    if (paramRichText != null)
    {
      if (paramRichText.isEmpty()) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramRichText.iterator();
      while (localIterator.hasNext())
      {
        appoint_define.Elem localElem = (appoint_define.Elem)localIterator.next();
        if (localElem != null)
        {
          if (localElem.str_content.has()) {
            paramRichText = localElem.str_content.get();
          } else {
            paramRichText = "";
          }
          localStringBuilder.append(paramRichText);
          if (localElem.msg_face_info.has()) {
            paramRichText = (appoint_define.Face)localElem.msg_face_info.get();
          } else {
            paramRichText = null;
          }
          if (paramRichText != null)
          {
            int i;
            if (paramRichText.uint32_index.has()) {
              i = paramRichText.uint32_index.get();
            } else {
              i = -1;
            }
            if (i >= 0)
            {
              localStringBuilder.append('\024');
              localStringBuilder.append((char)QQSysFaceUtil.convertToLocal(i));
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String a(List<DatingComment> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      paramList = paramList.iterator();
      int j;
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        JSONObject localJSONObject = a((DatingComment)paramList.next());
        j = i;
        if (localJSONObject != null)
        {
          localJSONArray.put(localJSONObject);
          j = i + 1;
        }
        i = j;
      } while (j < 20);
      return localJSONArray.toString();
    }
    return "";
  }
  
  public static JSONObject a(DatingComment paramDatingComment)
  {
    if (paramDatingComment == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("commentId", paramDatingComment.jdField_a_of_type_JavaLangString);
      localJSONObject.put("datingId", paramDatingComment.jdField_b_of_type_JavaLangString);
      localJSONObject.put("content", paramDatingComment.c);
      localJSONObject.put("time", paramDatingComment.jdField_a_of_type_Long);
      localJSONObject.put("replyId", paramDatingComment.d);
      localJSONObject.put("puber", DatingStranger.a(paramDatingComment.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger));
      localJSONObject.put("replyer", DatingStranger.a(paramDatingComment.jdField_b_of_type_ComTencentMobileqqDatingDatingStranger));
      localJSONObject.put("flag", paramDatingComment.jdField_a_of_type_Int);
      return localJSONObject;
    }
    catch (JSONException paramDatingComment)
    {
      paramDatingComment.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(List<DatingComment> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        paramString = new JSONArray(paramString);
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          DatingComment localDatingComment = a(paramString.getJSONObject(i));
          if (localDatingComment != null) {
            paramList.add(localDatingComment);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (DatingComment)paramObject;
    boolean bool1;
    if ((this.jdField_a_of_type_JavaLangString != null) || (paramObject.jdField_a_of_type_JavaLangString != null))
    {
      String str = this.jdField_a_of_type_JavaLangString;
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (!str.equals(paramObject.jdField_a_of_type_JavaLangString)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public int hashCode()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "".hashCode();
    }
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDatingDatingStranger);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqDatingDatingStranger);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingComment
 * JD-Core Version:    0.7.0.1
 */