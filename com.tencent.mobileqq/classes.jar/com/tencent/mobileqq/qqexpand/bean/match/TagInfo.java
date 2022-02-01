package com.tencent.mobileqq.qqexpand.bean.match;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TagInfo
{
  public int a = 0;
  public String b = "";
  public int c = 0;
  
  public static String a(ArrayList<TagInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        TagInfo localTagInfo = (TagInfo)paramArrayList.get(i);
        if (localTagInfo != null)
        {
          Object localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("tagId", localTagInfo.a);
            ((JSONObject)localObject).put("tagName", localTagInfo.b);
            ((JSONObject)localObject).put("isHotTag", localTagInfo.c);
            localJSONArray.put(localObject);
          }
          catch (Exception localException)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("convertToJson error");
            ((StringBuilder)localObject).append(localException.toString());
            QLog.e("TagInfo CLASS", 2, ((StringBuilder)localObject).toString());
          }
        }
        i += 1;
      }
      return localJSONArray.toString();
    }
    return "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{tagId: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    localStringBuilder.append("{tagName: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    localStringBuilder.append("{isHotTag: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.match.TagInfo
 * JD-Core Version:    0.7.0.1
 */