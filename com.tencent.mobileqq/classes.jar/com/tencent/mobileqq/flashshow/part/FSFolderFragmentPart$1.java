package com.tencent.mobileqq.flashshow.part;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.flashshow.fragment.FSBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class FSFolderFragmentPart$1
  implements ViewPager.OnPageChangeListener
{
  FSFolderFragmentPart$1(FSFolderFragmentPart paramFSFolderFragmentPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onPageSelected  mFolderViewPager pos = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , mLastPageSelectPosition = ");
    localStringBuilder.append(FSFolderFragmentPart.a(this.a));
    QLog.i("FSFolderFragmentPart", 1, localStringBuilder.toString());
    int i = 0;
    while (i < FSFolderFragmentPart.b(this.a).size())
    {
      if (i == paramInt) {
        ((FSBaseFragment)FSFolderFragmentPart.b(this.a).get(i)).onResume();
      } else if (i == FSFolderFragmentPart.a(this.a)) {
        ((FSBaseFragment)FSFolderFragmentPart.b(this.a).get(i)).onStop();
      }
      i += 1;
    }
    FSFolderFragmentPart.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSFolderFragmentPart.1
 * JD-Core Version:    0.7.0.1
 */