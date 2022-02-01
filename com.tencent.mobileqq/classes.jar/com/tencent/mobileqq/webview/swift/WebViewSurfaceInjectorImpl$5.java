package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.opengroup.AppUrlOpenGroup.RspBody;

class WebViewSurfaceInjectorImpl$5
  implements BusinessObserver
{
  WebViewSurfaceInjectorImpl$5(WebViewSurfaceInjectorImpl paramWebViewSurfaceInjectorImpl, WebViewProvider paramWebViewProvider, SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" checkAppUrl,onReceive:isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("WebViewSurfaceInjectorImpl", 2, ((StringBuilder)localObject).toString());
    }
    AppUrlOpenGroup.RspBody localRspBody;
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity() != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getHostActivity().isFinishing()) {
        return;
      }
      if (paramBoolean)
      {
        localObject = (SwiftBrowserShareMenuHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(4);
        ((SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider.getComponentProvider().a(-2)).l = true;
        paramBundle = paramBundle.getByteArray("data");
        localRspBody = new AppUrlOpenGroup.RspBody();
      }
    }
    try
    {
      localRspBody.mergeFrom(paramBundle);
      ((SwiftBrowserShareMenuHandler)localObject).e = localRspBody.bytes_company.get().toStringUtf8();
      ((SwiftBrowserShareMenuHandler)localObject).g = localRspBody.bytes_info_url.get().toStringUtf8();
      ((SwiftBrowserShareMenuHandler)localObject).f = localRspBody.bytes_share_url.get().toStringUtf8();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      }
      paramBundle = (TextView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131378880);
      localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131378814);
      paramBundle.setText(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_b_of_type_AndroidWidgetTextView.getText());
      ((TextView)localObject).setText(2131719767);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a.setImageResource(2130840347);
      return;
    }
    catch (InvalidProtocolBufferMicroException|Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl.5
 * JD-Core Version:    0.7.0.1
 */