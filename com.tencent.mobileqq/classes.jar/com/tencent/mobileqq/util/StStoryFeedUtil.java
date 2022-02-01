package com.tencent.mobileqq.util;

import NS_QQ_STORY_META.META.StStoryFeed;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StStoryFeedUtil
{
  private static final String TAG = "StStoryFeedUtil";
  
  public static ArrayList<byte[]> getConvertDataList(ArrayList<META.StStoryFeed> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        META.StStoryFeed localStStoryFeed = (META.StStoryFeed)paramArrayList.next();
        if (localStStoryFeed != null) {
          localArrayList.add(localStStoryFeed.toByteArray());
        }
      }
    }
    return localArrayList;
  }
  
  public static META.StStoryFeed getOriginalData(byte[] paramArrayOfByte)
  {
    Object localObject = new META.StStoryFeed();
    try
    {
      ((META.StStoryFeed)localObject).mergeFrom(paramArrayOfByte);
      return localObject;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getOriginal data fail!");
      ((StringBuilder)localObject).append(paramArrayOfByte.toString());
      QLog.i("StStoryFeedUtil", 2, ((StringBuilder)localObject).toString());
      paramArrayOfByte.printStackTrace();
    }
    return new META.StStoryFeed();
  }
  
  public static ArrayList<META.StStoryFeed> getOriginalList(ArrayList<byte[]> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        if (paramArrayList.hasNext())
        {
          Object localObject = (byte[])paramArrayList.next();
          if (localObject == null) {
            continue;
          }
          META.StStoryFeed localStStoryFeed = new META.StStoryFeed();
          try
          {
            localStStoryFeed.mergeFrom((byte[])localObject);
            localArrayList.add(localStStoryFeed);
          }
          catch (InvalidProtocolBufferMicroException paramArrayList)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getOriginalList fail!");
            ((StringBuilder)localObject).append(paramArrayList.toString());
            QLog.i("StStoryFeedUtil", 2, ((StringBuilder)localObject).toString());
            paramArrayList.printStackTrace();
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.StStoryFeedUtil
 * JD-Core Version:    0.7.0.1
 */