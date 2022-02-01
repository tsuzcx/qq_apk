package com.tencent.qflutter;

import io.flutter.plugin.common.BinaryMessenger;
import java.util.Map;

public abstract interface QFlutterEngine$EventListener
{
  public abstract void onEvent(String paramString, Map paramMap);
  
  public abstract void onInited(BinaryMessenger paramBinaryMessenger);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qflutter.QFlutterEngine.EventListener
 * JD-Core Version:    0.7.0.1
 */