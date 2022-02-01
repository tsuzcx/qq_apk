package com.tencent.mobileqq.troop.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopHandlerService
  extends IRuntimeService
{
  public abstract Bitmap getGroupFaceIcon(String paramString, boolean paramBoolean);
  
  public abstract void handleMemberExit(String paramString1, String paramString2);
  
  public abstract void updateGroupIcon(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopHandlerService
 * JD-Core Version:    0.7.0.1
 */