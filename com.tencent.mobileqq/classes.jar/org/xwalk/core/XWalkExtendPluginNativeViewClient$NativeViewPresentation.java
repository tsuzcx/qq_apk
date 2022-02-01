package org.xwalk.core;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.Keep;

@TargetApi(17)
@Keep
class XWalkExtendPluginNativeViewClient$NativeViewPresentation
  extends Presentation
{
  private XWalkExtendPluginNativeViewClient mClient;
  private FrameLayout mContentView;
  private boolean mStartFocused = false;
  
  public XWalkExtendPluginNativeViewClient$NativeViewPresentation(XWalkExtendPluginNativeViewClient paramXWalkExtendPluginNativeViewClient1, Context paramContext, Display paramDisplay, boolean paramBoolean, XWalkExtendPluginNativeViewClient paramXWalkExtendPluginNativeViewClient2)
  {
    super(paramContext, paramDisplay);
    getWindow().setFlags(8, 8);
    this.mStartFocused = paramBoolean;
    this.mClient = paramXWalkExtendPluginNativeViewClient2;
  }
  
  public void detach()
  {
    if (XWalkExtendPluginNativeViewClient.access$000(this.this$0) != null) {
      XWalkExtendPluginNativeViewClient.access$000(this.this$0).removeAllViews();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    XWalkExtendPluginNativeViewClient.access$002(this.this$0, new FrameLayout(getContext()));
    paramBundle = this.mContentView;
    if (paramBundle != null)
    {
      if (this.mStartFocused) {
        paramBundle.requestFocus();
      }
      XWalkExtendPluginNativeViewClient.access$000(this.this$0).addView(this.mContentView);
    }
    setContentView(XWalkExtendPluginNativeViewClient.access$000(this.this$0));
    if (XWalkExtendPluginNativeViewClient.access$100(this.this$0) != null) {
      XWalkExtendPluginNativeViewClient.access$100(this.this$0).onCreate(XWalkExtendPluginNativeViewClient.access$200(this.mClient), XWalkExtendPluginNativeViewClient.access$300(this.mClient));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkExtendPluginNativeViewClient.NativeViewPresentation
 * JD-Core Version:    0.7.0.1
 */