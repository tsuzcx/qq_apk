package dov.com.qq.im.capture.data;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;

public class ComboSet
  extends CaptureSet
{
  public ComboSet(Object paramObject)
  {
    super(paramObject);
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    return super.a(paramActivity, paramInt);
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    super.a(paramActivity, paramInt);
    VideoFilterTools localVideoFilterTools = VideoFilterTools.a();
    ComboSet localComboSet = localVideoFilterTools.a[paramInt];
    if ((localComboSet != null) && (localComboSet.b().equals(b()))) {
      localVideoFilterTools.a(null, paramActivity, paramInt);
    }
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    super.b(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "select " + toString());
    }
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a;
    VideoFilterTools.a().a(localQIMFilterCategoryItem, paramActivity, paramInt);
    ((CaptureComboManager)dov.com.qq.im.capture.QIMManager.a(5)).a[paramInt].a(this);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject.hashCode() == hashCode();
  }
  
  public int hashCode()
  {
    return ((QIMFilterCategoryItem)this.a).a.hashCode();
  }
  
  public String toString()
  {
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a;
    return localQIMFilterCategoryItem.a + localQIMFilterCategoryItem.hashCode() + localQIMFilterCategoryItem.f + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.ComboSet
 * JD-Core Version:    0.7.0.1
 */