package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PicBrowserGalleryAdapter
  extends AbstractImageAdapter
  implements PicBrowserImage.OnLoadListener
{
  private Context a;
  private Handler b = new Handler();
  private PicBrowserImage.OnLoadListener c;
  
  public PicBrowserGalleryAdapter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(int paramInt)
  {
    int i = HttpUtil.getNetWorkType();
    if ((i != 1) && (i != 4)) {
      return;
    }
    PicBrowserImage localPicBrowserImage = (PicBrowserImage)getItem(paramInt + 1);
    if (localPicBrowserImage != null) {
      localPicBrowserImage.a();
    }
    localPicBrowserImage = (PicBrowserImage)getItem(paramInt - 1);
    if (localPicBrowserImage != null) {
      localPicBrowserImage.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b.post(new PicBrowserGalleryAdapter.1(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.b.post(new PicBrowserGalleryAdapter.3(this, paramInt, paramBoolean));
  }
  
  public void a(View paramView, int paramInt)
  {
    PicBrowserImage localPicBrowserImage = (PicBrowserImage)getItem(paramInt);
    if (localPicBrowserImage != null) {
      localPicBrowserImage.a(paramView, paramInt, this);
    }
  }
  
  public void a(PicBrowserImage.OnLoadListener paramOnLoadListener)
  {
    this.c = paramOnLoadListener;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.b.post(new PicBrowserGalleryAdapter.2(this, paramInt1, paramInt2));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
    }
    else
    {
      localObject = (PicBrowserImage)getItem(paramInt);
      if (localObject == null)
      {
        localObject = null;
      }
      else
      {
        PicInfo localPicInfo = ((PicBrowserImage)localObject).k;
        Context localContext = this.a;
        if (((localContext instanceof PicBrowserActivity)) && (((PicBrowserActivity)localContext).mNeedReportVisitedPic)) {
          NearbyManagerHelper.a(((PicBrowserActivity)this.a).app).b(localPicInfo.b);
        }
        localObject = ((PicBrowserImage)localObject).a(paramInt, this.b, this);
        ((View)localObject).setTag(2131296390, Boolean.valueOf(true));
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */