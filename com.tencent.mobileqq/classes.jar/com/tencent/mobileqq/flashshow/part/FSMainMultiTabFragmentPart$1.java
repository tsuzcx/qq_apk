package com.tencent.mobileqq.flashshow.part;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.Tab;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.ViewPagerTabEventListener;
import com.tencent.mobileqq.flashshow.view.FSMultiTabView;
import java.util.ArrayList;

class FSMainMultiTabFragmentPart$1
  implements TabLayoutCompat.ViewPagerTabEventListener
{
  FSMainMultiTabFragmentPart$1(FSMainMultiTabFragmentPart paramFSMainMultiTabFragmentPart) {}
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new FSMultiTabView(paramViewGroup);
    FSMainMultiTabFragmentPart.a(this.a).add(paramViewGroup);
    return paramViewGroup.a();
  }
  
  public void a(TabLayoutCompat.Tab paramTab1, @Nullable TabLayoutCompat.Tab paramTab2, int paramInt)
  {
    if ((paramTab1 != null) && (paramTab1.j() != null)) {
      paramTab1.j().setTypeface(Typeface.defaultFromStyle(1));
    }
    if ((paramTab2 != null) && (paramTab2.j() != null)) {
      paramTab2.j().setTypeface(Typeface.defaultFromStyle(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSMainMultiTabFragmentPart.1
 * JD-Core Version:    0.7.0.1
 */