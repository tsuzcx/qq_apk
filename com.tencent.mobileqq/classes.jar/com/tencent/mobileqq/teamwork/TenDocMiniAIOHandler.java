package com.tencent.mobileqq.teamwork;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftMiniAIOHandler;

public class TenDocMiniAIOHandler
  extends SwiftMiniAIOHandler
{
  private INonMainProcAvatarLoader c;
  
  private void a(int paramInt, String paramString, ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (paramInt != 0) {
        if (paramInt != 1)
        {
          if ((paramInt != 1000) && (paramInt != 1004)) {
            if (paramInt != 3000)
            {
              if (paramInt != 10008)
              {
                paramInt = -1;
                break label67;
              }
            }
            else
            {
              paramInt = 101;
              break label67;
            }
          }
        }
        else
        {
          paramInt = 4;
          break label67;
        }
      }
      paramInt = 1;
      label67:
      if (paramInt != -1) {
        this.c = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.b.b(), paramInt);
      }
      INonMainProcAvatarLoader localINonMainProcAvatarLoader = this.c;
      if (localINonMainProcAvatarLoader != null)
      {
        localINonMainProcAvatarLoader.a();
        this.c.a(new TenDocMiniAIOHandler.1(this, paramImageView));
        this.c.a(paramString, true);
      }
    }
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    if (paramInt == 3)
    {
      paramBundle = this.c;
      if (paramBundle != null) {
        paramBundle.c();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = (SwiftBrowserUIStyleHandler)this.b.d().a(2);
    if (localSwiftBrowserUIStyleHandler != null)
    {
      if (localSwiftBrowserUIStyleHandler.g == null) {
        return;
      }
      Intent localIntent = this.b.c().getIntent();
      if ((localSwiftBrowserUIStyleHandler.g.p() != null) && (localIntent != null))
      {
        paramBoolean = localIntent.getBooleanExtra("doc_from_aio", false);
        String str = localIntent.getStringExtra("doc_from_aio_uin");
        int i = localIntent.getIntExtra("doc_from_aio_peertype", -1);
        if ((paramBoolean) && (!TextUtils.isEmpty(str)) && (i != -1))
        {
          localSwiftBrowserUIStyleHandler.g.p().setVisibility(0);
          b();
          a(i, str, (ImageView)localSwiftBrowserUIStyleHandler.g.p().findViewById(2131438587));
          return;
        }
      }
      localSwiftBrowserUIStyleHandler.g.p().setVisibility(8);
    }
  }
  
  public void b()
  {
    Object localObject = this.b.c().getIntent();
    boolean bool = ((Intent)localObject).getBooleanExtra("doc_from_aio", false);
    String str = ((Intent)localObject).getStringExtra("doc_from_aio_uin");
    int i = ((Intent)localObject).getIntExtra("doc_from_aio_peertype", -1);
    localObject = ((Intent)localObject).getStringExtra("doc_from_aio_nickname");
    SwiftBrowserUIStyleHandler localSwiftBrowserUIStyleHandler = (SwiftBrowserUIStyleHandler)this.b.d().a(2);
    if (localSwiftBrowserUIStyleHandler != null)
    {
      if (localSwiftBrowserUIStyleHandler.g == null) {
        return;
      }
      if ((bool) && (!TextUtils.isEmpty(str)) && (i != -1))
      {
        if (this.a == null)
        {
          this.a = new TeamWorkMiniMsgUser(this.b.b(), d(), str, i, (String)localObject);
          this.a.onForeground();
        }
        localSwiftBrowserUIStyleHandler.g.p().setVisibility(0);
        return;
      }
      localSwiftBrowserUIStyleHandler.g.p().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TenDocMiniAIOHandler
 * JD-Core Version:    0.7.0.1
 */