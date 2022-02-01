package dov.com.tencent.mobileqq.richmedia.capture.view;

import bqbq;
import bqdc;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import java.util.List;

public class CaptureVideoFilterViewPager$1
  implements Runnable
{
  CaptureVideoFilterViewPager$1(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager) {}
  
  public void run()
  {
    this.this$0.setVisibility(0);
    List localList = bqbq.a().a();
    this.this$0.a.clear();
    int i = 0;
    if (i < localList.size())
    {
      if (i != 0)
      {
        FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)localList.get(i);
        if (!localFilterCategoryItem.a()) {
          this.this$0.a.add(localFilterCategoryItem);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        this.this$0.a.add(localList.get(i));
      }
    }
    CaptureVideoFilterViewPager.a(this.this$0).a();
    if (bqbq.a().a() == null) {
      this.this$0.setCurrentItem(CaptureVideoFilterViewPager.a(this.this$0).a() * 50, false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "CaptureVideoFilterViewPager update size=" + this.this$0.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager.1
 * JD-Core Version:    0.7.0.1
 */