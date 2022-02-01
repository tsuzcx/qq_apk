package com.tencent.mobileqq.shortvideo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.BaseShortVideoResourceStatus;

public class ShortVideoResourceStatus
  extends BaseShortVideoResourceStatus
{
  static ShortVideoResourceStatus.ResStatus a(String paramString)
  {
    Object localObject = paramString;
    if (VideoEnvironment64BitUtils.checkIs64bit())
    {
      localObject = paramString;
      if (!paramString.endsWith("64bit"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("64bit");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramString = new ShortVideoResourceStatus.ResStatus();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_version_k");
    paramString.a = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_status_k");
    paramString.b = localSharedPreferences.getInt(localStringBuilder.toString(), -1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_last_error_k");
    paramString.c = localSharedPreferences.getInt(localStringBuilder.toString(), -1);
    return paramString;
  }
  
  static boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = paramString;
    if (VideoEnvironment64BitUtils.checkIs64bit())
    {
      localObject = paramString;
      if (!paramString.endsWith("64bit"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("64bit");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_resource_status_sp", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_version_k");
    paramString.putInt(localStringBuilder.toString(), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_status_k");
    paramString.putInt(localStringBuilder.toString(), paramInt2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_last_error_k");
    paramString.putInt(localStringBuilder.toString(), paramInt3);
    return paramString.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus
 * JD-Core Version:    0.7.0.1
 */