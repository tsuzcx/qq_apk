package com.tencent.mobileqq.qwallet.red.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class QWRedConfig$RedInfo
  implements Serializable
{
  public static final int GONE_TYPE_ALWAYS = 1;
  public static final int GONE_TYPE_CLICK = 0;
  public static final int IMG_TYPE_DOWNLOAD_URL = 0;
  public static final int IS_SHOW_NO = 0;
  public static final int IS_SHOW_YES = 1;
  public static final int SHOW_POS_LEFT_BOTTOM = 3;
  public static final int SHOW_POS_LEFT_TOP = 2;
  public static final int SHOW_POS_RIGHT_BOTTOM = 1;
  public static final int SHOW_POS_RIGHT_TOP = 0;
  public static final int TASK_ID_DEFAULT = -1;
  public static final int TYPE_IMG = 3;
  public static final int TYPE_NUM = 1;
  public static final int TYPE_RED = 0;
  public static final int TYPE_UNKNOWN = -1;
  public static final int TYPE_WORD = 2;
  private static final long serialVersionUID = 1L;
  public long beginTime;
  public String buffer;
  public String content;
  public long endTime;
  public int goneType;
  public int imgType;
  public int isShow;
  public String path;
  public int showPos;
  public long taskId;
  public int type;
  
  private void a()
  {
    this.isShow = 0;
  }
  
  public static RedInfo parseToRedInfo(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      RedInfo localRedInfo = new RedInfo();
      localRedInfo.path = paramString;
      localRedInfo.taskId = paramJSONObject.optLong("taskId", -1L);
      localRedInfo.isShow = paramJSONObject.optInt("isShow", 0);
      localRedInfo.type = paramJSONObject.optInt("type", -1);
      localRedInfo.content = paramJSONObject.optString("content");
      localRedInfo.imgType = paramJSONObject.optInt("imgType", 0);
      localRedInfo.goneType = paramJSONObject.optInt("goneType", 0);
      localRedInfo.showPos = paramJSONObject.optInt("showPos", 0);
      localRedInfo.beginTime = QWalletTools.d(paramJSONObject.optString("beginTime"));
      localRedInfo.endTime = QWalletTools.d(paramJSONObject.optString("endTime"));
      long l;
      if (localRedInfo.endTime == -1L) {
        l = 9223372036854775807L;
      } else {
        l = localRedInfo.endTime;
      }
      localRedInfo.endTime = l;
      localRedInfo.buffer = paramJSONObject.optString("buf");
      return localRedInfo;
    }
    catch (Throwable paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public static String transToReportStr(List<RedInfo> paramList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RedInfo localRedInfo = (RedInfo)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("path", localRedInfo.path);
        localJSONObject.put("taskId", localRedInfo.taskId);
        localJSONObject.put("isShow", localRedInfo.isShow);
        localJSONArray.put(localJSONObject);
      }
      if (localJSONArray.length() > 0)
      {
        paramList = new JSONObject();
        paramList.put("list", localJSONArray);
        paramList = paramList.toString();
        return paramList;
      }
      return null;
    }
    catch (Throwable paramList)
    {
      paramList.printStackTrace();
    }
    return null;
  }
  
  public boolean doClick()
  {
    if (this.goneType == 0)
    {
      a();
      return true;
    }
    return false;
  }
  
  public boolean isShow()
  {
    if (this.isShow == 0) {
      return false;
    }
    int i = this.type;
    if ((i != 0) && (i != 3)) {
      return false;
    }
    if ((this.type == 0) && (this.showPos != 0)) {
      return false;
    }
    if ((this.type == 3) && (this.showPos != 2)) {
      return false;
    }
    if ((this.type == 3) && (this.imgType != 0)) {
      return false;
    }
    if ((this.type == 3) && (this.imgType == 0) && (TextUtils.isEmpty(this.content))) {
      return false;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (l >= this.beginTime) {
      return l <= this.endTime;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RedInfo{path='");
    localStringBuilder.append(this.path);
    localStringBuilder.append('\'');
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(this.taskId);
    localStringBuilder.append(", isShow=");
    localStringBuilder.append(this.isShow);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", content='");
    localStringBuilder.append(this.content);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imgType=");
    localStringBuilder.append(this.imgType);
    localStringBuilder.append(", goneType=");
    localStringBuilder.append(this.goneType);
    localStringBuilder.append(", showPos=");
    localStringBuilder.append(this.showPos);
    localStringBuilder.append(", beginTime=");
    localStringBuilder.append(this.beginTime);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(", buffer='");
    localStringBuilder.append(this.buffer);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.red.impl.QWRedConfig.RedInfo
 * JD-Core Version:    0.7.0.1
 */