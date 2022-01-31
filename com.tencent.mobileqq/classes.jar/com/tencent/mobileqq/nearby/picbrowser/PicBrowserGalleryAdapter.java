package com.tencent.mobileqq.nearby.picbrowser;

import aeoi;
import aeoj;
import aeok;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;

public class PicBrowserGalleryAdapter
  extends AbstractImageAdapter
  implements PicBrowserImage.OnLoadListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private PicBrowserImage.OnLoadListener jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener;
  
  public PicBrowserGalleryAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(int paramInt)
  {
    int i = HttpUtil.a();
    if ((i != 1) && (i != 4)) {}
    PicBrowserImage localPicBrowserImage;
    do
    {
      return;
      localPicBrowserImage = (PicBrowserImage)getItem(paramInt + 1);
      if (localPicBrowserImage != null) {
        localPicBrowserImage.a();
      }
      localPicBrowserImage = (PicBrowserImage)getItem(paramInt - 1);
    } while (localPicBrowserImage == null);
    localPicBrowserImage.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aeoi(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aeok(this, paramInt, paramBoolean));
  }
  
  public void a(View paramView, int paramInt)
  {
    ((PicBrowserImage)getItem(paramInt)).a(paramView, paramInt, this);
  }
  
  public void a(PicBrowserImage.OnLoadListener paramOnLoadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener = paramOnLoadListener;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aeoj(this, paramInt1, paramInt2));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {
      return paramView;
    }
    paramView = (PicBrowserImage)getItem(paramInt);
    paramViewGroup = paramView.a;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof PicBrowserActivity)) && (((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).b)) {
      ((PicBrowserActivity)this.jdField_a_of_type_AndroidContentContext).app.a().b(paramViewGroup.a);
    }
    paramView = paramView.a(paramInt, this.jdField_a_of_type_AndroidOsHandler, this);
    paramView.setTag(2131296390, Boolean.valueOf(true));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */