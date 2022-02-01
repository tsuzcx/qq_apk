package com.tencent.mobileqq.profilecard.bussiness.photowall.bean;

import android.text.TextUtils;
import java.util.Map;

public class QZonePhotoInfo
  extends ProfilePhotoWall
{
  public String photoId;
  public Map<Integer, String> photoUrls;
  
  public QZonePhotoInfo()
  {
    this.type = 1;
  }
  
  private String getOther(int paramInt)
  {
    int i = 1;
    Object localObject = null;
    while ((TextUtils.isEmpty((CharSequence)localObject)) && (i < 5))
    {
      localObject = (String)this.photoUrls.get(Integer.valueOf((paramInt + i) % 5));
      i += 1;
    }
    return localObject;
  }
  
  public String getOriginUrl()
  {
    Object localObject = this.photoUrls;
    if (localObject != null)
    {
      String str = (String)((Map)localObject).get(Integer.valueOf(1));
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        return getOther(1);
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public String getThumbUrl(int paramInt)
  {
    String str1;
    if (this.photoUrls != null)
    {
      int i = 2;
      if (paramInt <= 100) {
        i = 3;
      }
      String str2 = (String)this.photoUrls.get(Integer.valueOf(i));
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        return getOther(i);
      }
    }
    else
    {
      str1 = null;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoInfo
 * JD-Core Version:    0.7.0.1
 */