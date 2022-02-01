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
    SoDetailInfo localSoDetailInfo = null;
    if (paramJSONObject == null) {
      return null;
    }
    String str1 = paramJSONObject.optString("url");
    String str2 = paramJSONObject.optString("md5");
    if (!TextUtils.isEmpty(str1))
    {
      if (TextUtils.isEmpty(str2)) {
        return null;
      }
      localSoDetailInfo = new SoDetailInfo();
      localSoDetailInfo.md5 = str2;
      localSoDetailInfo.url = str1;
      localSoDetailInfo.ver = paramString;
      localSoDetailInfo.crc = paramJSONObject.optLong("so_crc", -1L);
      localSoDetailInfo.relatedFileInfo = paramRelatedFileInfo;
      localSoDetailInfo.testFlag = paramInt;
      localSoDetailInfo.isFlowControl = paramBoolean;
    }
    return localSoDetailInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SDInfo{url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", v='");
    localStringBuilder.append(this.ver);
    localStringBuilder.append('\'');
    localStringBuilder.append(", c='");
    localStringBuilder.append(this.crc);
    localStringBuilder.append(", r='");
    localStringBuilder.append(this.relatedFileInfo);
    localStringBuilder.append(",f=");
    localStringBuilder.append(this.isFlowControl);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.SoDetailInfo
 * JD-Core Version:    0.7.0.1
 */