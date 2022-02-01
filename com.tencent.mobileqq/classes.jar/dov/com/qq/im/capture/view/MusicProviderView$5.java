package dov.com.qq.im.capture.view;

import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter;

class MusicProviderView$5
  implements Runnable
{
  MusicProviderView$5(MusicProviderView paramMusicProviderView, int paramInt) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetBounceBounceViewPager.getCurrentItem();
    GridView localGridView = this.this$0.jdField_a_of_type_DovComQqImCaptureAdapterMusicProviderPagerAdapter.b(i);
    if (localGridView != null)
    {
      localGridView.setSelection(this.a);
      this.this$0.c = i;
      this.this$0.d = this.a;
      if (QLog.isColorLevel()) {
        QLog.d("MusicProviderView", 2, "selectCategoryAndItem setSelection= " + i + " position=" + this.a);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MusicProviderView", 2, "gridView is null item= " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.MusicProviderView.5
 * JD-Core Version:    0.7.0.1
 */