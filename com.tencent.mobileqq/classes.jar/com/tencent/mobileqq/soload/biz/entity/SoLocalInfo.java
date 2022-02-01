package com.tencent.mobileqq.soload.biz.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.qphone.base.util.QLog;

public class SoLocalInfo
{
  private static final String TAG = "SoLoadWidget.SoLocalInfo";
  public String mRFileFolder;
  public String mRFileUrl;
  public long mSoCRC = -1L;
  public String mSoName;
  public String mSoPath;
  public String mSoVer;
  public String mUrl;
  
  public SoLocalInfo() {}
  
  public SoLocalInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6)
  {
    this.mSoVer = paramString1;
    this.mSoName = paramString2;
    this.mSoPath = paramString3;
    this.mSoCRC = paramLong;
    this.mUrl = paramString4;
    this.mRFileUrl = paramString5;
    this.mRFileFolder = paramString6;
  }
  
  public static SoLocalInfo createSoLocalInfo(String paramString)
  {
    SoLocalInfo localSoLocalInfo = new SoLocalInfo();
    try
    {
      paramString = Uri.parse(paramString);
      localSoLocalInfo.mSoVer = paramString.getQueryParameter("ver");
      localSoLocalInfo.mSoName = paramString.getQueryParameter("name");
      localSoLocalInfo.mSoPath = paramString.getQueryParameter("path");
      localSoLocalInfo.mSoCRC = parseCRC(paramString.getQueryParameter("crc"));
      localSoLocalInfo.mUrl = paramString.getQueryParameter("url");
      localSoLocalInfo.mRFileUrl = paramString.getQueryParameter("rUrl");
      localSoLocalInfo.mRFileFolder = paramString.getQueryParameter("rPath");
      return localSoLocalInfo;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return localSoLocalInfo;
  }
  
  private static long parseCRC(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return -1L;
  }
  
  public String encode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?");
    localStringBuilder.append("ver=");
    localStringBuilder.append(this.mSoVer);
    localStringBuilder.append("&name=");
    localStringBuilder.append(this.mSoName);
    localStringBuilder.append("&path=");
    localStringBuilder.append(SoDataUtil.b(this.mSoPath));
    localStringBuilder.append("&crc=");
    localStringBuilder.append(this.mSoCRC);
    localStringBuilder.append("&url=");
    localStringBuilder.append(SoDataUtil.b(this.mUrl));
    localStringBuilder.append("&rUrl=");
    localStringBuilder.append(SoDataUtil.b(this.mRFileUrl));
    localStringBuilder.append("&rPath=");
    localStringBuilder.append(SoDataUtil.b(this.mRFileFolder));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.SoLocalInfo
 * JD-Core Version:    0.7.0.1
 */