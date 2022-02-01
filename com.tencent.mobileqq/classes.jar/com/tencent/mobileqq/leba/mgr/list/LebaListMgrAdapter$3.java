package com.tencent.mobileqq.leba.mgr.list;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.widget.Switch;

class LebaListMgrAdapter$3
  extends View.AccessibilityDelegate
{
  LebaListMgrAdapter$3(LebaListMgrAdapter paramLebaListMgrAdapter) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
    if (paramView != null)
    {
      paramView = (Switch)paramView.findViewById(2131364157);
      if ((paramView != null) && (paramView.getVisibility() != 8))
      {
        paramAccessibilityNodeInfo.setCheckable(true);
        paramAccessibilityNodeInfo.setChecked(paramView.isChecked());
        paramAccessibilityNodeInfo.setClassName(Switch.class.getName());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.list.LebaListMgrAdapter.3
 * JD-Core Version:    0.7.0.1
 */