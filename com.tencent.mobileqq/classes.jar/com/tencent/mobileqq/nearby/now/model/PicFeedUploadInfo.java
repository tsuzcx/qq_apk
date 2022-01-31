package com.tencent.mobileqq.nearby.now.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PicFeedUploadInfo
  implements Serializable
{
  public long anchorUin;
  public String city = "";
  public String desc = "";
  public String feedId = "";
  public String lat = "";
  public String lng = "";
  public LocationInfo locationInfo;
  public List photoInfo = new ArrayList();
  public List topic = new ArrayList();
  public int uploadStatus = 1;
  
  public PicFeedUploadInfo() {}
  
  public PicFeedUploadInfo(PicFeedUploadInfo paramPicFeedUploadInfo)
  {
    this.anchorUin = paramPicFeedUploadInfo.anchorUin;
    this.feedId = paramPicFeedUploadInfo.feedId;
    this.desc = paramPicFeedUploadInfo.desc;
    this.lng = paramPicFeedUploadInfo.lng;
    this.lat = paramPicFeedUploadInfo.lat;
    this.city = paramPicFeedUploadInfo.city;
    Iterator localIterator;
    Object localObject;
    if (paramPicFeedUploadInfo.topic != null)
    {
      localIterator = paramPicFeedUploadInfo.topic.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        this.topic.add(localObject);
      }
    }
    if (paramPicFeedUploadInfo.photoInfo != null)
    {
      localIterator = paramPicFeedUploadInfo.photoInfo.iterator();
      while (localIterator.hasNext())
      {
        localObject = (LocalMediaInfo)localIterator.next();
        LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
        localLocalMediaInfo.jdField_d_of_type_JavaLangString = ((LocalMediaInfo)localObject).jdField_d_of_type_JavaLangString;
        localLocalMediaInfo.jdField_b_of_type_Long = ((LocalMediaInfo)localObject).jdField_b_of_type_Long;
        localLocalMediaInfo.jdField_b_of_type_JavaLangString = ((LocalMediaInfo)localObject).jdField_b_of_type_JavaLangString;
        localLocalMediaInfo.jdField_d_of_type_JavaLangString = ((LocalMediaInfo)localObject).jdField_d_of_type_JavaLangString;
        localLocalMediaInfo.c = ((LocalMediaInfo)localObject).c;
        localLocalMediaInfo.jdField_d_of_type_Int = ((LocalMediaInfo)localObject).jdField_d_of_type_Int;
        localLocalMediaInfo.e = ((LocalMediaInfo)localObject).e;
        localLocalMediaInfo.f = ((LocalMediaInfo)localObject).f;
        this.photoInfo.add(localLocalMediaInfo);
      }
    }
    this.uploadStatus = paramPicFeedUploadInfo.uploadStatus;
    if (paramPicFeedUploadInfo.locationInfo != null) {
      this.locationInfo = new LocationInfo(paramPicFeedUploadInfo.locationInfo);
    }
  }
  
  public void reset()
  {
    this.feedId = "";
    this.desc = "";
    this.lng = "";
    this.lat = "";
    this.city = "";
    if (this.topic != null) {
      this.topic.clear();
    }
    if (this.photoInfo != null) {
      this.photoInfo.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.PicFeedUploadInfo
 * JD-Core Version:    0.7.0.1
 */