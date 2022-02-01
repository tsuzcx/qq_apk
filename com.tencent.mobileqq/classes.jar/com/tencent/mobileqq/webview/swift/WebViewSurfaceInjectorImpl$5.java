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
    if (this.a.getHostActivity() != null)
    {
      if (this.a.getHostActivity().isFinishing()) {
        return;
      }
      if (paramBoolean)
      {
        localObject = (SwiftBrowserShareMenuHandler)this.a.getComponentProvider().a(4);
        ((SwiftBrowserStatistics)this.a.getComponentProvider().a(-2)).ay = true;
        paramBundle = paramBundle.getByteArray("data");
        localRspBody = new AppUrlOpenGroup.RspBody();
      }
    }
    try
    {
      localRspBody.mergeFrom(paramBundle);
      ((SwiftBrowserShareMenuHandler)localObject).r = localRspBody.bytes_company.get().toStringUtf8();
      ((SwiftBrowserShareMenuHandler)localObject).t = localRspBody.bytes_info_url.get().toStringUtf8();
      ((SwiftBrowserShareMenuHandler)localObject).s = localRspBody.bytes_share_url.get().toStringUtf8();
      if (this.b.e.getVisibility() != 8) {
        this.b.e.setVisibility(8);
      }
      if (this.b.p.getVisibility() != 0) {
        this.b.p.setVisibility(0);
      }
      paramBundle = (TextView)this.b.p.findViewById(2131447581);
      localObject = (TextView)this.b.p.findViewById(2131447497);
      paramBundle.setText(this.b.e.getText());
      ((TextView)localObject).setText(2131917371);
      this.b.h.setVisibility(0);
      this.b.h.setImageResource(2130841087);
      return;
    }
    catch (InvalidProtocolBufferMicroException|Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewSurfaceInjectorImpl.5
 * JD-Core Version:    0.7.0.1
 */