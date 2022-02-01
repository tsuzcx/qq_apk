package dov.com.qq.im.capture.data;

import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
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
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext())
    {
      CaptureComboBase localCaptureComboBase = (CaptureComboBase)((Iterator)localObject).next();
      if ((localCaptureComboBase instanceof CaptureComboFilter)) {
        localArrayList.add(((CaptureComboFilter)localCaptureComboBase).a);
      }
    }
    ((CaptureComboManager)dov.com.qq.im.capture.QIMManager.a(5)).a[paramInt].a(this);
    localObject = (QIMFilterCategoryItem)this.a;
    VideoFilterTools.a().a((QIMFilterCategoryItem)localObject, paramInt);
    if ((QLog.isColorLevel()) && (localObject != null)) {
      QLog.i("QCombo", 2, "setApplyedFilterGroup" + ((QIMFilterCategoryItem)localObject).b);
    }
    CaptureComboFilter.a(paramActivity, localArrayList, this, paramInt);
    return 0;
  }
  
  public boolean a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (CaptureComboBase)localIterator.next();
      if ((localObject instanceof CaptureComboFilter))
      {
        localObject = ((CaptureComboFilter)localObject).a;
        if ((localObject != null) && (((FilterDesc)localObject).predownload == 0)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "select " + toString());
    }
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a;
    VideoFilterTools.a().b(localQIMFilterCategoryItem, paramActivity, paramInt);
  }
  
  public int d()
  {
    int k = 0;
    Iterator localIterator = this.b.iterator();
    int i = 0;
    int j = k;
    if (localIterator.hasNext())
    {
      j = ((CaptureComboBase)localIterator.next()).a;
      if (j == 2) {
        j = 1;
      }
    }
    else
    {
      if (j == 0) {
        break label67;
      }
      b(2);
      return 2;
    }
    if (j == 1) {
      i = 1;
    }
    for (;;)
    {
      break;
      label67:
      if (i != 0)
      {
        b(2);
        return 1;
      }
      b(3);
      return 3;
    }
  }
  
  public String toString()
  {
    return "Filter" + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.FilterSet
 * JD-Core Version:    0.7.0.1
 */