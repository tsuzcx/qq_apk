package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.MD5;
import java.io.Serializable;

public class RockDownloadInfo
  extends Entity
  implements Serializable
{
  public static final int CHECK_LEVEL_DELETE = 3;
  public static final int CHECK_LEVEL_DOWNLOAD = 1;
  public static final int CHECK_LEVEL_INSTALL = 4;
  public static final int CHECK_LEVEL_QUERY = 2;
  private static final String TAG = "RockDownloadInfo";
  public String applicationName;
  public String businessName;
  public String businessScene;
  public String downloadURL;
  public long endTime;
  public String localPath;
  public String md5;
  public String packageName;
  public int realVersionCode;
  public long startTime;
  public String ticket;
  public int versionCode;
  
  public RockDownloadInfo() {}
  
  public RockDownloadInfo(String paramString1, String paramString2)
  {
    this.businessName = paramString1;
    this.packageName = paramString2;
  }
  
  public RockDownloadInfo(String paramString1, String paramString2, String paramString3)
  {
    this.businessName = paramString1;
    this.businessScene = paramString2;
    this.packageName = paramString3;
  }
  
  public RockDownloadInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    this.businessName = paramString1;
    this.businessScene = paramString2;
    this.packageName = paramString3;
    this.downloadURL = paramString4;
    this.versionCode = paramInt;
  }
  
  public String getApplicationName()
  {
    return this.applicationName;
  }
  
  public String getBusinessName()
  {
    return this.businessName;
  }
  
  public String getBusinessScene()
  {
    return this.businessScene;
  }
  
  public String getDownloadFileNameMD5()
  {
    if (this.realVersionCode == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.businessName);
      localStringBuilder.append(this.businessScene);
      localStringBuilder.append(this.packageName);
      localStringBuilder.append(this.versionCode);
      return MD5.toMD5(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.businessName);
    localStringBuilder.append(this.businessScene);
    localStringBuilder.append(this.packageName);
    localStringBuilder.append(this.realVersionCode);
    return MD5.toMD5(localStringBuilder.toString());
  }
  
  public String getDownloadURL()
  {
    return this.downloadURL;
  }
  
  public String getLocalPath()
  {
    return this.localPath;
  }
  
  public String getMd5()
  {
    return this.md5;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public int getRealVersionCode()
  {
    return this.realVersionCode;
  }
  
  public int getVersionCode()
  {
    return this.versionCode;
  }
  
  public void setApplicationName(String paramString)
  {
    this.applicationName = paramString;
  }
  
  public void setBusinessName(String paramString)
  {
    this.businessName = paramString;
  }
  
  public void setBusinessScene(String paramString)
  {
    this.businessScene = paramString;
  }
  
  public void setDownloadURL(String paramString)
  {
    this.downloadURL = paramString;
  }
  
  public void setLocalPath(String paramString)
  {
    this.localPath = paramString;
  }
  
  public void setMd5(String paramString)
  {
    this.md5 = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setRealVersionCode(int paramInt)
  {
    this.realVersionCode = paramInt;
  }
  
  public void setVersionCode(int paramInt)
  {
    this.versionCode = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RockDownloadInfo{businessName='");
    localStringBuilder.append(this.businessName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", businessScene='");
    localStringBuilder.append(this.businessScene);
    localStringBuilder.append('\'');
    localStringBuilder.append(", packageName='");
    localStringBuilder.append(this.packageName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", downloadURL='");
    localStringBuilder.append(this.downloadURL);
    localStringBuilder.append('\'');
    localStringBuilder.append(", versionCode=");
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append(", startTime=");
    localStringBuilder.append(this.startTime);
    localStringBuilder.append(", endTime=");
    localStringBuilder.append(this.endTime);
    localStringBuilder.append(", applicationName='");
    localStringBuilder.append(this.applicationName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", realVersionCode=");
    localStringBuilder.append(this.realVersionCode);
    localStringBuilder.append(", localPath='");
    localStringBuilder.append(this.localPath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ticket='");
    localStringBuilder.append(this.ticket);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public boolean verifyDate(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if ((paramInt != 4) || (TextUtils.isEmpty(this.businessName)) || (TextUtils.isEmpty(this.localPath))) {
            break label138;
          }
          return true;
        }
      }
      else if ((!TextUtils.isEmpty(this.businessName)) && (!TextUtils.isEmpty(this.packageName))) {
        return true;
      }
      if ((!TextUtils.isEmpty(this.businessName)) && (!TextUtils.isEmpty(this.localPath))) {
        return true;
      }
    }
    else if ((!TextUtils.isEmpty(this.businessName)) && (!TextUtils.isEmpty(this.businessScene)) && (!TextUtils.isEmpty(this.packageName)) && (!TextUtils.isEmpty(this.downloadURL)) && (this.versionCode > 0))
    {
      return true;
    }
    label138:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.RockDownloadInfo
 * JD-Core Version:    0.7.0.1
 */