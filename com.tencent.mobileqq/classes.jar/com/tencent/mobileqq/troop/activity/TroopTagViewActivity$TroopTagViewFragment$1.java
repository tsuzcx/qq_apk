package com.tencent.mobileqq.troop.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

class TroopTagViewActivity$TroopTagViewFragment$1
  extends WebKernelCallBackProxy
{
  TroopTagViewActivity$TroopTagViewFragment$1(TroopTagViewActivity.TroopTagViewFragment paramTroopTagViewFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    if ((this.a.jdField_a_of_type_Int == 1) && (this.a.jdField_a_of_type_Boolean))
    {
      this.a.getSwiftTitleUI().c.setText(2131691859);
      this.a.getSwiftTitleUI().c.setVisibility(0);
      this.a.getSwiftTitleUI().a.setVisibility(8);
      this.a.getSwiftTitleUI().c.setOnClickListener(this.a);
      return;
    }
    this.a.getSwiftTitleUI().c.setVisibility(8);
    this.a.getSwiftTitleUI().a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopTagViewActivity.TroopTagViewFragment.1
 * JD-Core Version:    0.7.0.1
 */