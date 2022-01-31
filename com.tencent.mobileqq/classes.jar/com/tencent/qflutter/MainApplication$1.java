package com.tencent.qflutter;

import android.content.Intent;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.Map;

class MainApplication$1
  implements QFlutterEngine.EventListener
{
  MainApplication$1(MainApplication paramMainApplication) {}
  
  public void onEvent(String paramString, Map paramMap)
  {
    paramString = new Intent(this.this$0, MainActivity.class);
    paramString.addFlags(268435456);
    this.this$0.startActivity(paramString);
  }
  
  public void onInited(BinaryMessenger paramBinaryMessenger) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qflutter.MainApplication.1
 * JD-Core Version:    0.7.0.1
 */