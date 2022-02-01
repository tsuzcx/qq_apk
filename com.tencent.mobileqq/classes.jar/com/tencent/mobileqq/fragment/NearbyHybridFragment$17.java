package com.tencent.mobileqq.fragment;

import android.graphics.Bitmap;
import android.widget.LinearLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.NearbyFragmentEnterAdapter;
import com.tencent.mobileqq.nearby.ipc.NearbyProcObserver;

class NearbyHybridFragment$17
  extends NearbyProcObserver
{
  NearbyHybridFragment$17(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString, Bitmap paramBitmap)
  {
    if ((this.a.d != null) && (this.a.d.equals(paramString)) && (paramBitmap != null) && (this.a.b != null) && (this.a.b.getVisibility() == 0)) {
      this.a.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void b()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyFragmentEnterAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface);
    }
    this.a.l();
    this.a.m();
  }
  
  public void b(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.17
 * JD-Core Version:    0.7.0.1
 */