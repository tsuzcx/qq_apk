package dov.com.qq.im.capture.view;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.FilterProviderPagerAdapter;

class QIMFilterProviderView$1
  implements Runnable
{
  QIMFilterProviderView$1(QIMFilterProviderView paramQIMFilterProviderView, int paramInt) {}
  
  public void run()
  {
    GridView localGridView = (GridView)this.this$0.a.a.get(this.this$0.b());
    if (localGridView != null)
    {
      localGridView.setSelection(this.a);
      localGridView.smoothScrollToPosition(this.a / localGridView.getNumColumns());
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("FilterProviderView", 2, "gridView is null ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMFilterProviderView.1
 * JD-Core Version:    0.7.0.1
 */