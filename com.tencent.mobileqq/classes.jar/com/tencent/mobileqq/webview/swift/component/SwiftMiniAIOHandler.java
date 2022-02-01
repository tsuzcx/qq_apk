package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.webview.swift.ISwiftMiniAIO;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;

public class SwiftMiniAIOHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements ISwiftMiniAIO
{
  protected MiniMsgUser a;
  private String c;
  private int d;
  private int e;
  private String f;
  
  private MiniMsgUser.IMiniMsgActionCallback e()
  {
    return new SwiftMiniAIOHandler.1(this);
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramString;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Object localObject;
    if (2 == paramInt)
    {
      localObject = this.a;
      if (localObject != null) {
        ((MiniMsgUser)localObject).onForeground();
      }
    }
    else if (8 == paramInt)
    {
      localObject = this.a;
      if (localObject != null) {
        ((MiniMsgUser)localObject).onBackground();
      }
      localObject = (SwiftBrowserUIStyleHandler)this.b.d().a(2);
      if ((localObject != null) && (((SwiftBrowserUIStyleHandler)localObject).g != null) && (((SwiftBrowserUIStyleHandler)localObject).g.p() != null) && (((SwiftBrowserUIStyleHandler)localObject).g.o())) {
        MiniMsgIPCClient.getInstance().clearBusiness(this.d);
      }
    }
    super.a(paramInt, paramBundle);
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (SwiftBrowserUIStyleHandler)this.b.d().a(2);
    if ((localObject != null) && (((SwiftBrowserUIStyleHandler)localObject).g.p() != null))
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      ((SwiftBrowserUIStyleHandler)localObject).g.p().setVisibility(i);
      localObject = ((SwiftBrowserUIStyleHandler)localObject).g.p().findViewById(2131438587);
      String str = this.f;
      if (str != null) {
        if (str.equals("white")) {
          ((View)localObject).setBackgroundResource(2130841882);
        } else if (this.f.equals("black")) {
          ((View)localObject).setBackgroundResource(2130841881);
        }
      }
      if (paramBoolean)
      {
        localObject = this.a;
        if (localObject != null) {
          ((MiniMsgUser)localObject).onForeground();
        }
      }
    }
  }
  
  public void b()
  {
    if (this.a == null)
    {
      this.a = new MiniMsgUser(this.b.b(), d());
      this.a.onForeground();
    }
  }
  
  public String c()
  {
    return this.c;
  }
  
  protected MiniMsgUserParam d()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = this.d;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.requestCode = 200;
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = (SwiftBrowserUIStyleHandler)this.b.d().a(2);
    if ((localSwiftBrowserUIStyleHandler != null) && (localSwiftBrowserUIStyleHandler.g != null) && (localSwiftBrowserUIStyleHandler.g.p() != null))
    {
      localMiniMsgUserParam.entryView = localSwiftBrowserUIStyleHandler.g.p();
      localMiniMsgUserParam.unreadView = ((TextView)localSwiftBrowserUIStyleHandler.g.p().findViewById(2131438588));
    }
    localMiniMsgUserParam.actionCallback = e();
    return localMiniMsgUserParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftMiniAIOHandler
 * JD-Core Version:    0.7.0.1
 */