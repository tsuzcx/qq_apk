package com.tencent.mobileqq.troop.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IDiscussionHandlerService
  extends IRuntimeService
{
  public abstract void addDiscussMember(long paramLong, Object paramObject);
  
  public abstract void checkPstnIconInfoAndUpdate(String paramString);
  
  public abstract void collectDiscussion(long paramLong);
  
  public abstract void createDiscuss(String paramString, Object paramObject, int paramInt);
  
  public abstract void createDiscuss(String paramString, Object paramObject, int paramInt, long paramLong);
  
  public abstract void getAtAllRemainCountInfo(String paramString1, String paramString2);
  
  public abstract Bitmap getDiscussionFaceIcon(String paramString, boolean paramBoolean);
  
  public abstract void kickOutMemberFromDiscussion(long paramLong1, long paramLong2);
  
  public abstract void unCollectDiscussion(long paramLong);
  
  public abstract void updateDiscussionIcon(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.IDiscussionHandlerService
 * JD-Core Version:    0.7.0.1
 */