package dov.com.qq.im.capture.view;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.adapter.ComboProviderPagerAdapter;

class ComboProviderView$2
  implements Runnable
{
  ComboProviderView$2(ComboProviderView paramComboProviderView, int paramInt) {}
  
  public void run()
  {
    GridView localGridView = (GridView)this.this$0.a.a.get(this.this$0.b());
    if (localGridView != null)
    {
      localGridView.setSelection(this.a);
      localGridView.smoothScrollToPosition(this.a / localGridView.getNumColumns());
      if (QLog.isColorLevel()) {
        QLog.d("ComboProviderView", 2, "positon= " + this.a);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ComboProviderView", 2, "gridView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.ComboProviderView.2
 * JD-Core Version:    0.7.0.1
 */