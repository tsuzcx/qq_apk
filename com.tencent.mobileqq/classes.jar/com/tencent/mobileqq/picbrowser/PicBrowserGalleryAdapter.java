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
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private PicBrowserImage.OnLoadListener jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserImage$OnLoadListener;
  
  public PicBrowserGalleryAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
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
    this.jdField_a_of_type_AndroidOsHandler.post(new PicBrowserGalleryAdapter.1(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PicBrowserGalleryAdapter.3(this, paramInt, paramBoolean));
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
    this.jdField_a_of_type_ComTencentMobileqqPicbrowserPicBrowserImage$OnLoadListener = paramOnLoadListener;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new PicBrowserGalleryAdapter.2(this, paramInt1, paramInt2));
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
        PicInfo localPicInfo = ((PicBrowserImage)localObject).a;
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        if (((localContext instanceof PicBrowserActivity)) && (((PicBrowserActivity)localContext).mNeedReportVisitedPic)) {
          NearbyManagerHelper.a(((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).app).a(localPicInfo.a);
        }
        localObject = ((PicBrowserImage)localObject).a(paramInt, this.jdField_a_of_type_AndroidOsHandler, this);
        ((View)localObject).setTag(2131296390, Boolean.valueOf(true));
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */