package com.tencent.mobileqq.troop.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.LinkedList;

public class RollangleImageView$ImageCache
{
  private static ImageCache b;
  public boolean a = false;
  private LinkedList<RollangleImageView.ImageCache.QueueItem> c;
  private Handler d = new RollangleImageView.ImageCache.2(this, BaseApplication.getContext().getMainLooper());
  
  public static ImageCache a()
  {
    if (b == null) {
      b = new ImageCache();
    }
    return b;
  }
  
  public Bitmap a(String paramString, RollangleImageView paramRollangleImageView)
  {
    try
    {
      paramRollangleImageView = RollangleImageView.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troopfileimage://");
      localStringBuilder.append(paramString);
      paramString = (Bitmap)paramRollangleImageView.get(localStringBuilder.toString());
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (this.c != null) {
        this.c.clear();
      }
      this.a = paramBoolean;
      return;
    }
    finally {}
  }
  
  public Bitmap b(String paramString, RollangleImageView paramRollangleImageView)
  {
    try
    {
      Object localObject = RollangleImageView.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troopfileimage://");
      localStringBuilder.append(paramString);
      localObject = (Bitmap)((MQLruCache)localObject).get(localStringBuilder.toString());
      if (localObject != null) {
        return localObject;
      }
      if (this.c == null) {
        this.c = new LinkedList();
      }
      if (this.c.isEmpty()) {
        ThreadManager.post(new RollangleImageView.ImageCache.1(this), 5, null, true);
      }
      localObject = new RollangleImageView.ImageCache.QueueItem();
      ((RollangleImageView.ImageCache.QueueItem)localObject).b = paramRollangleImageView;
      ((RollangleImageView.ImageCache.QueueItem)localObject).a = paramString;
      this.c.add(localObject);
      return null;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      LinkedList localLinkedList = this.c;
      if (localLinkedList == null) {
        return;
      }
      this.c.clear();
      this.c = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView.ImageCache
 * JD-Core Version:    0.7.0.1
 */