package com.tencent.smtt.sdk;

import android.content.Intent;

class SystemWebChromeClient$5
  extends WebChromeClient.FileChooserParams
{
  SystemWebChromeClient$5(SystemWebChromeClient paramSystemWebChromeClient, android.webkit.WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
  public Intent createIntent()
  {
    return this.val$SystemfileChooserParams.createIntent();
  }
  
  public String[] getAcceptTypes()
  {
    return this.val$SystemfileChooserParams.getAcceptTypes();
  }
  
  public String getFilenameHint()
  {
    return this.val$SystemfileChooserParams.getFilenameHint();
  }
  
  public int getMode()
  {
    return this.val$SystemfileChooserParams.getMode();
  }
  
  public CharSequence getTitle()
  {
    return this.val$SystemfileChooserParams.getTitle();
  }
  
  public boolean isCaptureEnabled()
  {
    return this.val$SystemfileChooserParams.isCaptureEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SystemWebChromeClient.5
 * JD-Core Version:    0.7.0.1
 */