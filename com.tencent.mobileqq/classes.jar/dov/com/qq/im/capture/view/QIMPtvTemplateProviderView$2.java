package dov.com.qq.im.capture.view;

import android.widget.ListAdapter;
import bjbe;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateViewPagerAdapter;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.HashMap;

class QIMPtvTemplateProviderView$2
  implements Runnable
{
  QIMPtvTemplateProviderView$2(QIMPtvTemplateProviderView paramQIMPtvTemplateProviderView, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void run()
  {
    GridView localGridView = (GridView)this.this$0.jdField_a_of_type_DovComQqImCaptureAdapterQIMPtvTemplateViewPagerAdapter.a.get(Integer.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem()));
    if (localGridView != null)
    {
      localListAdapter = localGridView.a();
      if ((localListAdapter instanceof bjbe))
      {
        i = ((bjbe)localListAdapter).a(this.a);
        ((bjbe)localListAdapter).a(this.a, i);
        localGridView.requestFocusFromTouch();
        localGridView.setFocusableInTouchMode(true);
        localGridView.setSelection(i);
        localGridView.smoothScrollToPosition(i / localGridView.c());
        ((bjbe)localListAdapter).notifyDataSetChanged();
      }
    }
    while (!QLog.isColorLevel())
    {
      ListAdapter localListAdapter;
      int i;
      return;
    }
    QLog.d("PtvTemplateProviderView", 2, "gridView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMPtvTemplateProviderView.2
 * JD-Core Version:    0.7.0.1
 */