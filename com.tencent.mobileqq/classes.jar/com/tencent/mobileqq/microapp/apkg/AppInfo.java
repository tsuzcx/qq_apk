package com.tencent.mobileqq.microapp.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

public class AppInfo
  extends Entity
  implements Serializable
{
  public static final int TYPE_APP = 2;
  public static final int TYPE_GAME = 1;
  public static final int TYPE_QZONE_GAME = 3;
  public String iconUrl;
  @unique
  public String id;
  public String launchUrl;
  public String name;
  public long timestamp;
  public int type;
  
  public AppInfo() {}
  
  public AppInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this(paramInt, paramString1, paramString2, paramString3, 0L);
  }
  
  public AppInfo(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this(paramInt, paramString1, paramString2, paramString3, paramLong, null);
  }
  
  public AppInfo(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    this.type = paramInt;
    this.id = paramString1;
    this.iconUrl = paramString2;
    this.name = paramString3;
    this.timestamp = paramLong;
    this.launchUrl = paramString4;
  }
  
  public boolean isCollectionPage()
  {
    return (this.type == 2) && (LaunchParam.isCollectionPage(this.id));
  }
  
  public boolean isValid()
  {
    int i = this.type;
    if (i == 1)
    {
      if (!TextUtils.isEmpty(this.id)) {
        return true;
      }
    }
    else if (i == 2)
    {
      if ((!TextUtils.isEmpty(this.id)) && (!TextUtils.isEmpty(this.name)) && (isValidUrl(this.iconUrl))) {
        return true;
      }
    }
    else if ((i == 3) && (!TextUtils.isEmpty(this.id))) {
      return true;
    }
    return false;
  }
  
  public boolean isValidUrl(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      new URL(paramString);
      return true;
    }
    catch (MalformedURLException paramString)
    {
      label18:
      break label18;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{id:");
    localStringBuilder.append(this.id);
    localStringBuilder.append(",name:");
    localStringBuilder.append(this.name);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void updateTimeStamp()
  {
    this.timestamp = NetConnInfoCenter.getServerTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.AppInfo
 * JD-Core Version:    0.7.0.1
 */