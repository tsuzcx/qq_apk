package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.viewpager.widget.ViewPager.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterViewPagerAdapter.AdapterViewFactory;

class QzonePhotoView$2
  implements AdapterViewPagerAdapter.AdapterViewFactory
{
  QzonePhotoView$2(QzonePhotoView paramQzonePhotoView) {}
  
  public AdapterView a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = new GridView(paramContext);
      try
      {
        paramContext.setNumColumns(4);
        paramContext.setFadingEdgeLength(0);
        paramContext.setHorizontalSpacing(QzonePhotoView.a(this.a));
        paramContext.setVerticalSpacing(QzonePhotoView.a(this.a));
        paramContext.setStretchMode(2);
        paramContext.setScrollingCacheEnabled(false);
        paramContext.setSelector(2131167333);
        ViewPager.LayoutParams localLayoutParams = new ViewPager.LayoutParams();
        localLayoutParams.gravity = 17;
        localLayoutParams.height = -2;
        localLayoutParams.width = -1;
        paramContext.setLayoutParams(localLayoutParams);
        return paramContext;
      }
      catch (OutOfMemoryError localOutOfMemoryError1) {}
      if (!QLog.isColorLevel()) {
        return paramContext;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      paramContext = null;
    }
    QLog.e("ProfileCard.QzonePhotoView", 2, "new gridview error", localOutOfMemoryError2);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.QzonePhotoView.2
 * JD-Core Version:    0.7.0.1
 */