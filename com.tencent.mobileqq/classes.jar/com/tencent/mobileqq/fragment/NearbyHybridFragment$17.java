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
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(int paramInt, String paramString, Bitmap paramBitmap)
  {
    if ((this.a.aa != null) && (this.a.aa.equals(paramString)) && (paramBitmap != null) && (this.a.t != null) && (this.a.t.getVisibility() == 0)) {
      this.a.w.setImageBitmap(paramBitmap);
    }
  }
  
  protected void b()
  {
    if (this.a.s != null) {
      this.a.s.a(this.a.k);
    }
    this.a.t();
    this.a.u();
  }
  
  protected void b(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.17
 * JD-Core Version:    0.7.0.1
 */