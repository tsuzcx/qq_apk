package com.tencent.mobileqq.troop.avatar.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopAvatarService
  extends IRuntimeService
{
  public abstract Bitmap getGroupFaceIcon(String paramString, boolean paramBoolean);
  
  public abstract GroupIconHelper getGroupIconHelper();
  
  public abstract void updateGroupIcon(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.api.ITroopAvatarService
 * JD-Core Version:    0.7.0.1
 */