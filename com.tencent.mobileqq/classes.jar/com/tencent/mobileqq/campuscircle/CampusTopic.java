package com.tencent.mobileqq.campuscircle;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import tencent.im.campus_common.Counter;
import tencent.im.campus_common.Topic;

public class CampusTopic
  implements Serializable
{
  public static final String[] TOPIC_COLORS = { "#BABFD3", "#5ACCF8", "#5EDCC0", "#96DC5A", "#FBD04F", "#FEB577", "#F58D8D", "#FFA5BD", "#BB9FF3" };
  private static final long serialVersionUID = -3450064362986273896L;
  public int color;
  public String extra;
  public int flag;
  public String grayIconUrl;
  public String iconUrl;
  public int id;
  public String title;
  public int topicType;
  
  public static List convert2CampusTopicList(List paramList, int paramInt)
  {
    Iterator localIterator = null;
    Object localObject = localIterator;
    if (paramList != null)
    {
      localObject = localIterator;
      if (paramList.size() > 0)
      {
        localObject = new ArrayList();
        localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          campus_common.Topic localTopic = (campus_common.Topic)localIterator.next();
          if (localTopic != null)
          {
            CampusTopic localCampusTopic = new CampusTopic();
            int i;
            label97:
            label123:
            long l;
            if (localTopic.uint32_id.has())
            {
              i = localTopic.uint32_id.get();
              localCampusTopic.id = i;
              if (!localTopic.str_name.has()) {
                break label266;
              }
              paramList = localTopic.str_name.get();
              localCampusTopic.title = paramList;
              if (!localTopic.uint32_type.has()) {
                break label272;
              }
              i = localTopic.uint32_type.get();
              label149:
              localCampusTopic.topicType = i;
              localCampusTopic.flag = paramInt;
              if (!localTopic.msg_counter.has()) {
                break label282;
              }
              if (!localTopic.msg_counter.uint64_uv.has()) {
                break label277;
              }
              l = localTopic.msg_counter.uint64_uv.get();
              label198:
              localCampusTopic.extra = String.format(Locale.getDefault(), "%d人", new Object[] { Long.valueOf(l) });
              label222:
              if (!localTopic.str_ext.has()) {
                break label292;
              }
            }
            label266:
            label272:
            label277:
            label282:
            label292:
            for (paramList = localTopic.str_ext.get();; paramList = "")
            {
              parseTopicInfo(paramList, localCampusTopic);
              ((List)localObject).add(localCampusTopic);
              break;
              i = -1;
              break label97;
              paramList = "";
              break label123;
              i = -1;
              break label149;
              l = 0L;
              break label198;
              localCampusTopic.extra = "";
              break label222;
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public static CampusTopic convertFromJSONString(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      CampusTopic localCampusTopic = new CampusTopic();
      if (paramString.has("id")) {
        localCampusTopic.id = paramString.getInt("id");
      }
      if (paramString.has("topicType")) {
        localCampusTopic.topicType = paramString.getInt("topicType");
      }
      if (paramString.has("color")) {
        localCampusTopic.color = paramString.getInt("color");
      }
      if (paramString.has("title")) {
        localCampusTopic.title = paramString.getString("title");
      }
      if (paramString.has("iconUrl")) {
        localCampusTopic.iconUrl = paramString.getString("iconUrl");
      }
      if (paramString.has("grayIconUrl")) {
        localCampusTopic.grayIconUrl = paramString.getString("grayIconUrl");
      }
      if (paramString.has("flag")) {
        localCampusTopic.flag = paramString.getInt("flag");
      }
      if (paramString.has("extra")) {
        localCampusTopic.extra = paramString.getString("extra");
      }
      return localCampusTopic;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void parseTopicInfo(String paramString, CampusTopic paramCampusTopic)
  {
    if (paramCampusTopic == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      setDefaultTopicInfo(paramCampusTopic);
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("bg-color");
      paramCampusTopic.iconUrl = paramString.optString("icon-url");
      paramCampusTopic.grayIconUrl = paramString.optString("gray-icon-url");
      paramCampusTopic.color = Color.parseColor(str);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CampusTopic", 2, "convertToTopicInfo ", paramString);
      }
      setDefaultTopicInfo(paramCampusTopic);
    }
  }
  
  public static void setDefaultTopicInfo(CampusTopic paramCampusTopic)
  {
    if (paramCampusTopic == null) {
      return;
    }
    try
    {
      int j = paramCampusTopic.id % TOPIC_COLORS.length;
      if (j < 0) {
        break label80;
      }
      i = j;
      if (j < TOPIC_COLORS.length) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CampusTopic", 2, "convertToTopicInfo ", localException);
        }
        paramCampusTopic.color = -16776961;
        continue;
        int i = 0;
      }
    }
    paramCampusTopic.color = Color.parseColor(TOPIC_COLORS[i]);
    paramCampusTopic.grayIconUrl = null;
    paramCampusTopic.iconUrl = null;
  }
  
  public String convert2JSONString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.id);
      localJSONObject.put("topicType", this.topicType);
      localJSONObject.put("color", this.color);
      localJSONObject.put("title", this.title);
      localJSONObject.put("iconUrl", this.iconUrl);
      localJSONObject.put("grayIconUrl", this.grayIconUrl);
      localJSONObject.put("flag", this.flag);
      localJSONObject.put("extra", this.extra);
      return localJSONObject.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusTopic
 * JD-Core Version:    0.7.0.1
 */