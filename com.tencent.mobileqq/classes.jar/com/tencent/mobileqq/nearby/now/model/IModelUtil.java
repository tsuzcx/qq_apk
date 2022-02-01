package com.tencent.mobileqq.nearby.now.model;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IModelUtil
  extends QRouteApi
{
  public abstract int getFeedsProtocolMediaInfoTextFeeds();
  
  public abstract VideoData parseImageData(int paramInt, List<Object> paramList, Object paramObject, ArrayList<VideoData> paramArrayList);
  
  public abstract VideoData parseShortVideoData(int paramInt, List<Object> paramList, Object paramObject, ArrayList<VideoData> paramArrayList);
  
  public abstract void parseTextFeeds(int paramInt, List<Object> paramList, Object paramObject, ArrayList<VideoData> paramArrayList);
  
  public abstract VideoData parseTopicInfoToVideoData(List<Object> paramList, VideoData paramVideoData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.IModelUtil
 * JD-Core Version:    0.7.0.1
 */