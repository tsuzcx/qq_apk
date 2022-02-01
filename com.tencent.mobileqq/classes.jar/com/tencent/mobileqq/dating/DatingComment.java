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
  public String a;
  public String b;
  public String c;
  public long d;
  public String e;
  public DatingStranger f;
  public DatingStranger g;
  public String h;
  public int i;
  @notColumn
  public String j;
  
  public static DatingComment a(appoint_define.DateComment paramDateComment)
  {
    Object localObject2 = null;
    if (paramDateComment != null)
    {
      if (TextUtils.isEmpty(paramDateComment.str_comment_id.get())) {
        return null;
      }
      DatingComment localDatingComment = new DatingComment();
      localDatingComment.a = paramDateComment.str_comment_id.get();
      localDatingComment.b = DatingUtil.a((appoint_define.AppointID)paramDateComment.msg_appoint_id.get());
      localDatingComment.d = paramDateComment.uint32_time.get();
      if (paramDateComment.msg_content.has()) {
        localObject1 = (appoint_define.RichText)paramDateComment.msg_content.get();
      } else {
        localObject1 = null;
      }
      localDatingComment.c = a((appoint_define.RichText)localObject1);
      localDatingComment.f = DatingStranger.a((appoint_define.StrangerInfo)paramDateComment.msg_publisher_info.get());
      int k;
      if (paramDateComment.uint32_flag.has()) {
        k = paramDateComment.uint32_flag.get();
      } else {
        k = 0;
      }
      localDatingComment.i = k;
      Object localObject1 = localObject2;
      if (paramDateComment.msg_reply_info.has()) {
        localObject1 = (appoint_define.ReplyInfo)paramDateComment.msg_reply_info.get();
      }
      if (localObject1 != null)
      {
        localDatingComment.e = ((appoint_define.ReplyInfo)localObject1).str_comment_id.get();
        localDatingComment.g = DatingStranger.a((appoint_define.StrangerInfo)((appoint_define.ReplyInfo)localObject1).msg_stranger_info.get());
      }
      localDatingComment.j = DatingUtil.a(localDatingComment.d, true);
      localDatingComment.h = DatingUtil.a(localDatingComment.d, false);
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
      localDatingComment.a = paramJSONObject.getString("commentId");
      localDatingComment.b = paramJSONObject.getString("datingId");
      localDatingComment.c = paramJSONObject.getString("content");
      localDatingComment.d = paramJSONObject.getLong("time");
      localDatingComment.f = DatingStranger.a(paramJSONObject.getJSONObject("puber"));
      localDatingComment.i = paramJSONObject.getInt("flag");
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
    }
    try
    {
      localDatingComment.e = paramJSONObject.getString("replyId");
    }
    catch (JSONException localJSONException2)
    {
      localJSONException2.printStackTrace();
    }
    try
    {
      localDatingComment.g = DatingStranger.a(paramJSONObject.getJSONObject("replyer"));
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
            int k;
            if (paramRichText.uint32_index.has()) {
              k = paramRichText.uint32_index.get();
            } else {
              k = -1;
            }
            if (k >= 0)
            {
              localStringBuilder.append('\024');
              localStringBuilder.append((char)QQSysFaceUtil.convertToLocal(k));
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
      int k = 0;
      paramList = paramList.iterator();
      int m;
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        JSONObject localJSONObject = a((DatingComment)paramList.next());
        m = k;
        if (localJSONObject != null)
        {
          localJSONArray.put(localJSONObject);
          m = k + 1;
        }
        k = m;
      } while (m < 20);
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
      localJSONObject.put("commentId", paramDatingComment.a);
      localJSONObject.put("datingId", paramDatingComment.b);
      localJSONObject.put("content", paramDatingComment.c);
      localJSONObject.put("time", paramDatingComment.d);
      localJSONObject.put("replyId", paramDatingComment.e);
      localJSONObject.put("puber", DatingStranger.a(paramDatingComment.f));
      localJSONObject.put("replyer", DatingStranger.a(paramDatingComment.g));
      localJSONObject.put("flag", paramDatingComment.i);
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
        int m = paramString.length();
        int k = 0;
        while (k < m)
        {
          DatingComment localDatingComment = a(paramString.getJSONObject(k));
          if (localDatingComment != null) {
            paramList.add(localDatingComment);
          }
          k += 1;
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
    if ((this.a != null) || (paramObject.a != null))
    {
      String str = this.a;
      bool1 = bool2;
      if (str != null)
      {
        bool1 = bool2;
        if (!str.equals(paramObject.a)) {}
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
    if (TextUtils.isEmpty(this.a)) {
      return "".hashCode();
    }
    return this.a.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingComment
 * JD-Core Version:    0.7.0.1
 */