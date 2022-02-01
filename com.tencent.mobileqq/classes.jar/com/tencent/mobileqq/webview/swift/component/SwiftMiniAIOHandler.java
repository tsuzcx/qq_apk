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
  private int jdField_a_of_type_Int;
  protected MiniMsgUser a;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  private MiniMsgUser.IMiniMsgActionCallback a()
  {
    return new SwiftMiniAIOHandler.1(this);
  }
  
  protected MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = this.jdField_a_of_type_Int;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.requestCode = 200;
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
    if ((localSwiftBrowserUIStyleHandler != null) && (localSwiftBrowserUIStyleHandler.a != null) && (localSwiftBrowserUIStyleHandler.a.a() != null))
    {
      localMiniMsgUserParam.entryView = localSwiftBrowserUIStyleHandler.a.a();
      localMiniMsgUserParam.unreadView = ((TextView)localSwiftBrowserUIStyleHandler.a.a().findViewById(2131371244));
    }
    localMiniMsgUserParam.actionCallback = a();
    return localMiniMsgUserParam;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    Object localObject;
    if (2 == paramInt)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
      if (localObject != null) {
        ((MiniMsgUser)localObject).onForeground();
      }
    }
    else if (8 == paramInt)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
      if (localObject != null) {
        ((MiniMsgUser)localObject).onBackground();
      }
      localObject = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
      if ((localObject != null) && (((SwiftBrowserUIStyleHandler)localObject).a != null) && (((SwiftBrowserUIStyleHandler)localObject).a.a() != null) && (((SwiftBrowserUIStyleHandler)localObject).a.c())) {
        MiniMsgIPCClient.getInstance().clearBusiness(this.jdField_a_of_type_Int);
      }
    }
    super.a(paramInt, paramBundle);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
    if ((localObject != null) && (((SwiftBrowserUIStyleHandler)localObject).a.a() != null))
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      ((SwiftBrowserUIStyleHandler)localObject).a.a().setVisibility(i);
      localObject = ((SwiftBrowserUIStyleHandler)localObject).a.a().findViewById(2131371243);
      String str = this.jdField_b_of_type_JavaLangString;
      if (str != null) {
        if (str.equals("white")) {
          ((View)localObject).setBackgroundResource(2130841091);
        } else if (this.jdField_b_of_type_JavaLangString.equals("black")) {
          ((View)localObject).setBackgroundResource(2130841090);
        }
      }
      if (paramBoolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
        if (localObject != null) {
          ((MiniMsgUser)localObject).onForeground();
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), a());
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftMiniAIOHandler
 * JD-Core Version:    0.7.0.1
 */