package dov.com.qq.im.capture.data;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterSet
  extends CaptureSet
{
  public FilterSet(Object paramObject)
  {
    super(paramObject);
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "apply " + toString());
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      CaptureComboBase localCaptureComboBase = (CaptureComboBase)localIterator.next();
      if ((localCaptureComboBase instanceof CaptureComboFilter)) {
        localArrayList.add(((CaptureComboFilter)localCaptureComboBase).a);
      }
    }
    CaptureComboFilter.a(paramActivity, localArrayList, this, paramInt);
    return 0;
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "select " + toString());
    }
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a;
    VideoFilterTools.a().b(localQIMFilterCategoryItem, paramActivity, paramInt);
    ((CaptureComboManager)dov.com.qq.im.capture.QIMManager.a(5)).a[paramInt].a(this);
  }
  
  public String toString()
  {
    return "Filter" + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.FilterSet
 * JD-Core Version:    0.7.0.1
 */