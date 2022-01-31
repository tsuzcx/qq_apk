package com.tencent.smtt.sdk;

import android.content.Intent;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;

class SmttWebChromeClient$4
  extends WebChromeClient.FileChooserParams
{
  SmttWebChromeClient$4(SmttWebChromeClient paramSmttWebChromeClient, IX5WebChromeClient.FileChooserParams paramFileChooserParams) {}
  
  public Intent createIntent()
  {
    return this.val$SmttfileChooserParams.createIntent();
  }
  
  public String[] getAcceptTypes()
  {
    return this.val$SmttfileChooserParams.getAcceptTypes();
  }
  
  public String getFilenameHint()
  {
    return this.val$SmttfileChooserParams.getFilenameHint();
  }
  
  public int getMode()
  {
    return this.val$SmttfileChooserParams.getMode();
  }
  
  public CharSequence getTitle()
  {
    return this.val$SmttfileChooserParams.getTitle();
  }
  
  public boolean isCaptureEnabled()
  {
    return this.val$SmttfileChooserParams.isCaptureEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.SmttWebChromeClient.4
 * JD-Core Version:    0.7.0.1
 */