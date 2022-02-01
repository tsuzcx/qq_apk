package com.tencent.mobileqq.troop.utils;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import java.lang.ref.WeakReference;

class RollangleImageView$MyUpdateImageAsyncTask
  extends AsyncTask<Boolean, Void, Bitmap>
{
  private WeakReference<RollangleImageView> a;
  
  public RollangleImageView$MyUpdateImageAsyncTask(RollangleImageView paramRollangleImageView)
  {
    this.a = new WeakReference(paramRollangleImageView);
  }
  
  protected Bitmap a(Boolean... paramVarArgs)
  {
    RollangleImageView localRollangleImageView = (RollangleImageView)this.a.get();
    if (localRollangleImageView != null) {
      return RollangleImageView.a(localRollangleImageView, paramVarArgs[0].booleanValue());
    }
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    RollangleImageView localRollangleImageView = (RollangleImageView)this.a.get();
    if (localRollangleImageView != null)
    {
      if (paramBitmap != null) {
        localRollangleImageView.setImageBitmap(paramBitmap);
      }
    }
    else {
      return;
    }
    localRollangleImageView.setImageResource(FileManagerUtil.b(localRollangleImageView.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView.MyUpdateImageAsyncTask
 * JD-Core Version:    0.7.0.1
 */