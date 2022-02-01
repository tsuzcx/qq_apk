package com.tencent.mobileqq.troop.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IDiscussionHandlerService
  extends IRuntimeService
{
  public abstract void checkPstnIconInfoAndUpdate(String paramString);
  
  public abstract Bitmap getDiscussionFaceIcon(String paramString, boolean paramBoolean);
  
  public abstract void updateDiscussionIcon(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.IDiscussionHandlerService
 * JD-Core Version:    0.7.0.1
 */