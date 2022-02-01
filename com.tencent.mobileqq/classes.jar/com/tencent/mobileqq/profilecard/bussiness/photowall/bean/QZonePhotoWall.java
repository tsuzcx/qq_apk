package com.tencent.mobileqq.profilecard.bussiness.photowall.bean;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QZonePhotoWall
  extends Entity
{
  public String attachInfo;
  @notColumn
  public int curListSize;
  public int hasMore;
  public int totalPic;
  @unique
  public String uin;
  public byte[] vPhotoIds;
  public byte[] vPhotoTimes;
  public byte[] vPhotoUrls;
  
  private void packPhotoWallData(String paramString, ArrayList<PhotoWall> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {
      localArrayList = unpackPhotoWallData();
    }
    localArrayList.addAll(paramArrayList);
    Object localObject1 = new ArrayList();
    paramArrayList = new ArrayList();
    paramString = new ArrayList();
    Object localObject2 = localArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      PhotoWall localPhotoWall = (PhotoWall)((Iterator)localObject2).next();
      ((ArrayList)localObject1).add(localPhotoWall.photoId);
      paramArrayList.add(Long.valueOf(localPhotoWall.ctime));
      paramString.add(localPhotoWall.photoUrls);
    }
    localObject2 = Parcel.obtain();
    ((Parcel)localObject2).setDataPosition(0);
    ((Parcel)localObject2).writeList((List)localObject1);
    this.vPhotoIds = ((Parcel)localObject2).marshall();
    ((Parcel)localObject2).recycle();
    localObject1 = Parcel.obtain();
    ((Parcel)localObject1).setDataPosition(0);
    ((Parcel)localObject1).writeList(paramArrayList);
    this.vPhotoTimes = ((Parcel)localObject1).marshall();
    ((Parcel)localObject1).recycle();
    paramArrayList = Parcel.obtain();
    paramArrayList.setDataPosition(0);
    paramArrayList.writeList(paramString);
    this.vPhotoUrls = paramArrayList.marshall();
    paramArrayList.recycle();
    this.curListSize = localArrayList.size();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("QZonePhotoWall totalPic:");
    localStringBuilder.append(this.totalPic);
    localStringBuilder.append(" hasMore:");
    localStringBuilder.append(this.hasMore);
    localStringBuilder.append(" photoWallSize:");
    localStringBuilder.append(this.curListSize);
    return localStringBuilder.toString();
  }
  
  public ArrayList<PhotoWall> unpackPhotoWallData()
  {
    localArrayList = new ArrayList();
    Object localObject1 = this.vPhotoIds;
    Object localObject7 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    int i = 0;
    Object localObject2;
    if (localObject1 != null)
    {
      try
      {
        localObject2 = Parcel.obtain();
        ((Parcel)localObject2).unmarshall(this.vPhotoIds, 0, this.vPhotoIds.length);
        ((Parcel)localObject2).setDataPosition(0);
        localObject1 = ((Parcel)localObject2).readArrayList(getClass().getClassLoader());
        try
        {
          ((Parcel)localObject2).recycle();
        }
        catch (Error localError1)
        {
          localObject2 = localObject1;
        }
        catch (Exception localException2)
        {
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
      }
      catch (Error localError2)
      {
        localObject2 = null;
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break label143;
        }
        QLog.i("Q.profilecard.", 2, localError2.toString());
        localObject1 = localObject2;
      }
      catch (Exception localException3)
      {
        localObject2 = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("Q.profilecard.", 2, localException3.toString());
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    label143:
    if (this.vPhotoTimes != null)
    {
      try
      {
        localObject3 = Parcel.obtain();
        ((Parcel)localObject3).unmarshall(this.vPhotoTimes, 0, this.vPhotoTimes.length);
        ((Parcel)localObject3).setDataPosition(0);
        localObject2 = ((Parcel)localObject3).readArrayList(getClass().getClassLoader());
        try
        {
          ((Parcel)localObject3).recycle();
        }
        catch (Error localError3)
        {
          localObject3 = localObject2;
        }
        catch (Exception localException4)
        {
          localObject3 = localObject2;
        }
        localObject2 = localObject3;
      }
      catch (Error localError4)
      {
        localObject3 = null;
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          break label277;
        }
        QLog.i("Q.profilecard.", 2, localError4.toString());
        localObject2 = localObject3;
      }
      catch (Exception localException5)
      {
        localObject3 = null;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("Q.profilecard.", 2, localException5.toString());
        localObject2 = localObject3;
      }
    }
    else
    {
      localObject2 = null;
    }
    label277:
    Object localObject3 = localObject5;
    if (this.vPhotoUrls != null)
    {
      Object localObject4 = localObject6;
      localObject5 = localObject7;
      try
      {
        Parcel localParcel = Parcel.obtain();
        localObject4 = localObject6;
        localObject5 = localObject7;
        localParcel.unmarshall(this.vPhotoUrls, 0, this.vPhotoUrls.length);
        localObject4 = localObject6;
        localObject5 = localObject7;
        localParcel.setDataPosition(0);
        localObject4 = localObject6;
        localObject5 = localObject7;
        localObject3 = localParcel.readArrayList(getClass().getClassLoader());
        localObject4 = localObject3;
        localObject5 = localObject3;
        localParcel.recycle();
      }
      catch (Error localError5)
      {
        localObject3 = localObject4;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.", 2, localError5.toString());
          localObject3 = localObject4;
        }
      }
      catch (Exception localException6)
      {
        localObject3 = localError5;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.", 2, localException6.toString());
          localObject3 = localError5;
        }
      }
    }
    if ((localObject1 != null) && (localObject2 != null) && (localObject3 != null)) {
      try
      {
        while (i < ((ArrayList)localObject1).size())
        {
          PhotoWall localPhotoWall = new PhotoWall();
          localPhotoWall.ctime = ((Long)((ArrayList)localObject2).get(i)).longValue();
          localPhotoWall.photoId = ((String)((ArrayList)localObject1).get(i));
          localPhotoWall.photoUrls = ((Map)((ArrayList)localObject3).get(i));
          localArrayList.add(localPhotoWall);
          i += 1;
        }
        return localArrayList;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("unpackPhotoWallData e:");
          ((StringBuilder)localObject2).append(localException1.toString());
          QLog.e("Q.qzonephotowall", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  public void updateQzonePhotoWall(String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    if (parammobile_sub_get_photo_wall_rsp == null) {
      return;
    }
    this.totalPic = parammobile_sub_get_photo_wall_rsp.total_pic;
    this.hasMore = parammobile_sub_get_photo_wall_rsp.iHasMore;
    packPhotoWallData(paramString, parammobile_sub_get_photo_wall_rsp.vecUrls);
    this.attachInfo = parammobile_sub_get_photo_wall_rsp.attachInfo;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("updateQzonePhotoWall ");
      paramString.append(toString());
      QLog.d("Q.qzonephotowall", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoWall
 * JD-Core Version:    0.7.0.1
 */