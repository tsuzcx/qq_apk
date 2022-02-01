package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.List;

public class PicBrowserModel
  implements AbstractImageListModel
{
  private ArrayList<PicBrowserImage> a = new ArrayList();
  private int b;
  private Context c;
  
  public PicBrowserModel(Context paramContext, List<PicInfo> paramList)
  {
    this.c = paramContext;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        paramContext = (PicInfo)paramList.get(i);
        if ((ShortVideoUtils.isVideoSoLibLoaded()) && ((!TextUtils.isEmpty(paramContext.e)) || (!TextUtils.isEmpty(paramContext.f)))) {
          paramContext = new GalleryItemVideo(this.c, paramContext);
        } else {
          paramContext = new GalleryItemImage(this.c, paramContext);
        }
        this.a.add(paramContext);
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public PicBrowserImage a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return (PicBrowserImage)this.a.get(paramInt);
    }
    return null;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
    int i = 0;
    while (i < this.a.size())
    {
      PicBrowserImage localPicBrowserImage = (PicBrowserImage)this.a.get(i);
      boolean bool;
      if (paramInt == i) {
        bool = true;
      } else {
        bool = false;
      }
      localPicBrowserImage.a(bool);
      i += 1;
    }
  }
  
  public PicBrowserImage c()
  {
    int i = this.b;
    if ((i >= 0) && (i < this.a.size())) {
      return (PicBrowserImage)this.a.get(this.b);
    }
    return null;
  }
  
  public PicBrowserImage d(int paramInt)
  {
    ArrayList localArrayList = this.a;
    if ((localArrayList != null) && (paramInt >= 0) && (paramInt < localArrayList.size())) {
      return (PicBrowserImage)this.a.remove(paramInt);
    }
    return null;
  }
  
  public void e()
  {
    int i = this.b;
    if ((i >= 0) && (i < this.a.size())) {
      ((PicBrowserImage)this.a.get(this.b)).c();
    }
  }
  
  public ArrayList<PicInfo> f()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.size())
    {
      localArrayList.add(((PicBrowserImage)this.a.get(i)).k);
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserModel
 * JD-Core Version:    0.7.0.1
 */