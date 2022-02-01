package com.tencent.mobileqq.soload.biz.entity;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;

public class SoDetailInfo
  implements Serializable
{
  public static final int TEST_FLAG_NOT_EXIST_CHECK_EXIST_IPC = 8;
  public static final int TEST_FLAG_NOT_EXIST_IS_FILE = 1;
  public static final int TEST_FLAG_NOT_EXIST_LOAD_ANYWAY = 4;
  public static final int TEST_FLAG_NOT_EXIST_OPEN = 15;
  public static final int TEST_FLAG_NOT_EXIST_WAIT_AND_CHECK_EXIST = 2;
  public long crc = -1L;
  public boolean isFlowControl;
  public String md5;
  public RelatedFileInfo relatedFileInfo;
  public int testFlag;
  public String url;
  public String ver;
  
  public static SoDetailInfo create(JSONObject paramJSONObject, String paramString, RelatedFileInfo paramRelatedFileInfo, int paramInt, boolean paramBoolean)
  {
    if (paramJSONObject == null) {}
    String str1;
    String str2;
    do
    {
      return null;
      str1 = paramJSONObject.optString("url");
      str2 = paramJSONObject.optString("md5");
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
    long l = paramJSONObject.optLong("so_crc", -1L);
    paramJSONObject = new SoDetailInfo();
    paramJSONObject.md5 = str2;
    paramJSONObject.url = str1;
    paramJSONObject.ver = paramString;
    paramJSONObject.crc = l;
    paramJSONObject.relatedFileInfo = paramRelatedFileInfo;
    paramJSONObject.testFlag = paramInt;
    paramJSONObject.isFlowControl = paramBoolean;
    return paramJSONObject;
  }
  
  public String toString()
  {
    return "SDInfo{url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", v='" + this.ver + '\'' + ", c='" + this.crc + ", r='" + this.relatedFileInfo + ",f=" + this.isFlowControl + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.SoDetailInfo
 * JD-Core Version:    0.7.0.1
 */