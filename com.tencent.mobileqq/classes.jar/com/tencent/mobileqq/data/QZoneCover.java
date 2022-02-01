package com.tencent.mobileqq.data;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Parcel;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class QZoneCover
  extends Entity
{
  public int jigsaw;
  public String type;
  @unique
  public String uin;
  public byte[] vCoverInfo;
  public byte[] vPhotoInfo;
  
  public HashMap<String, String> parseCoverInfo()
  {
    Object localObject1 = this.vCoverInfo;
    Object localObject2 = null;
    HashMap localHashMap = null;
    if (localObject1 != null) {
      localObject1 = localObject2;
    }
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject1 = localObject2;
      localParcel.unmarshall(this.vCoverInfo, 0, this.vCoverInfo.length);
      localObject1 = localObject2;
      localParcel.setDataPosition(0);
      localObject1 = localObject2;
      localHashMap = localParcel.readHashMap(getClass().getClassLoader());
      localObject1 = localHashMap;
      localParcel.recycle();
      return localHashMap;
    }
    catch (Exception localException) {}
    return localObject1;
  }
  
  public ArrayList<Map<Integer, String>> parsePhotoInfo()
  {
    Object localObject1 = this.vPhotoInfo;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    if (localObject1 != null)
    {
      localObject1 = localObject4;
      Object localObject2 = localObject5;
      try
      {
        Parcel localParcel = Parcel.obtain();
        localObject1 = localObject4;
        localObject2 = localObject5;
        localParcel.unmarshall(this.vPhotoInfo, 0, this.vPhotoInfo.length);
        localObject1 = localObject4;
        localObject2 = localObject5;
        localParcel.setDataPosition(0);
        localObject1 = localObject4;
        localObject2 = localObject5;
        localObject3 = localParcel.readArrayList(getClass().getClassLoader());
        localObject1 = localObject3;
        localObject2 = localObject3;
        localParcel.recycle();
        return localObject3;
      }
      catch (Error localError)
      {
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.", 2, localError.toString());
          return localObject1;
        }
      }
      catch (Exception localException)
      {
        localObject3 = localError;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.", 2, localException.toString());
          localObject3 = localError;
        }
      }
    }
    return localObject3;
  }
  
  protected void printInfo(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, ArrayList<Map<Integer, String>> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", cover = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", type = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("\r\n");
      if (paramMap != null)
      {
        paramString1 = paramMap.entrySet().iterator();
        localStringBuilder.append("MulRelsotionUrl: ");
        localStringBuilder.append("\r\n");
        while (paramString1.hasNext())
        {
          paramString2 = (Map.Entry)paramString1.next();
          localStringBuilder.append("[");
          localStringBuilder.append((String)paramString2.getKey());
          localStringBuilder.append(",");
          localStringBuilder.append((String)paramString2.getValue());
          localStringBuilder.append(']');
        }
      }
      if (paramArrayList != null)
      {
        localStringBuilder.append("vecUrls:");
        localStringBuilder.append("\r\n");
        int i = 0;
        while (i < paramArrayList.size())
        {
          localStringBuilder.append("i = ");
          localStringBuilder.append(i);
          localStringBuilder.append("[");
          paramString1 = (Map)paramArrayList.get(i);
          if (paramString1 != null)
          {
            paramString1 = paramString1.entrySet().iterator();
            while (paramString1.hasNext())
            {
              paramString2 = (Map.Entry)paramString1.next();
              localStringBuilder.append(paramString2.getKey());
              localStringBuilder.append(":");
              localStringBuilder.append((String)paramString2.getValue());
            }
          }
          localStringBuilder.append("]");
          i += 1;
        }
      }
    }
  }
  
  public void updateQzoneCover(mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if (parammobile_sub_get_cover_rsp == null) {
      return;
    }
    printInfo("updateQzoneCover|mobile_sub_get_cover_rsp", "null", parammobile_sub_get_cover_rsp.type, parammobile_sub_get_cover_rsp.MulRelsotionUrl, parammobile_sub_get_cover_rsp.vecUrls);
    this.type = parammobile_sub_get_cover_rsp.type;
    this.jigsaw = parammobile_sub_get_cover_rsp.photoWallCombinePic;
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeMap(parammobile_sub_get_cover_rsp.MulRelsotionUrl);
    this.vCoverInfo = localParcel.marshall();
    localParcel.recycle();
    localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeList(parammobile_sub_get_cover_rsp.vecUrls);
    this.vPhotoInfo = localParcel.marshall();
    localParcel.recycle();
  }
  
  public void updateQzoneCover(CoverCacheData paramCoverCacheData)
  {
    if (paramCoverCacheData == null) {
      return;
    }
    printInfo("updateQzoneCover|CoverCacheData", "null", paramCoverCacheData.type, paramCoverCacheData.urls, paramCoverCacheData.photoWall);
    this.type = paramCoverCacheData.type;
    this.jigsaw = paramCoverCacheData.isJigsawOpen;
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeMap(paramCoverCacheData.urls);
    this.vCoverInfo = localParcel.marshall();
    localParcel.recycle();
    localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    localParcel.writeList(paramCoverCacheData.photoWall);
    this.vPhotoInfo = localParcel.marshall();
    localParcel.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.QZoneCover
 * JD-Core Version:    0.7.0.1
 */