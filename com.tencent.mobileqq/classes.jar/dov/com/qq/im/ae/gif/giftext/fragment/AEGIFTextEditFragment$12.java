package dov.com.qq.im.ae.gif.giftext.fragment;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class AEGIFTextEditFragment$12
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AEGIFTextEditFragment$12(AEGIFTextEditFragment paramAEGIFTextEditFragment, View paramView1, View paramView2, View paramView3) {}
  
  public void onGlobalLayout()
  {
    Log.d("AEGIFTextEditFragment", "onGlobalLayout");
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidViewView.getWindowVisibleDisplayFrame(localRect);
    if (this.jdField_a_of_type_AndroidViewView.getRootView().getHeight() - localRect.bottom > 150)
    {
      int[] arrayOfInt = new int[2];
      this.b.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1];
      int j = this.b.getHeight();
      int k = localRect.bottom;
      int m = localRect.top;
      if (!AEGIFTextEditFragment.b(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment))
      {
        this.b.scrollBy(0, i + j - (k - m));
        AEGIFTextEditFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment, this.c, localRect.bottom / 2);
      }
      AEGIFTextEditFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment, true);
      return;
    }
    this.b.scrollTo(0, 0);
    if (AEGIFTextEditFragment.b(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment)) {
      AEGIFTextEditFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment, this.c, localRect.bottom / 2);
    }
    AEGIFTextEditFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.12
 * JD-Core Version:    0.7.0.1
 */