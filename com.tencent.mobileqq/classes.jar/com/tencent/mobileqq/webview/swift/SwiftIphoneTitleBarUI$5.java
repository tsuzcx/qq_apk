package com.tencent.mobileqq.webview.swift;

import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class SwiftIphoneTitleBarUI$5
  implements TouchWebView.OnScrollChangedListener
{
  int jdField_a_of_type_Int = 0;
  
  SwiftIphoneTitleBarUI$5(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("-->onScrollChanged:");
      paramView.append(paramInt1);
      paramView.append(",");
      paramView.append(paramInt2);
      paramView.append(",");
      paramView.append(paramInt3);
      paramView.append(",");
      paramView.append(paramInt4);
      QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, paramView.toString());
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      paramInt1 = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
    } else {
      paramInt1 = 0;
    }
    paramInt1 = 180 + (DisplayUtil.a(BaseApplication.getContext(), 50.0F) + paramInt1);
    if (Math.abs(paramInt2 - this.jdField_a_of_type_Int) > 20)
    {
      if (paramInt2 < paramInt1 / 3) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.v = true;
      } else if (paramInt2 >= paramInt1) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.v = false;
      }
      this.jdField_a_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.i();
      return;
    }
    if (paramInt2 < paramInt1 / 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.v = true;
      this.jdField_a_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.5
 * JD-Core Version:    0.7.0.1
 */