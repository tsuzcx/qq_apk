package com.tencent.mobileqq.webview.swift;

import java.util.HashMap;

public class WebViewPluginSchemeConfig
{
  public static final HashMap<Long, String> a = new HashMap(50, 0.75F);
  
  static
  {
    a.put(Long.valueOf(1L), "http");
    a.put(Long.valueOf(2L), "https");
    a.put(Long.valueOf(4L), "publicaccount");
    a.put(Long.valueOf(8L), "pay");
    a.put(Long.valueOf(16L), "qqvip");
    a.put(Long.valueOf(32L), "qqjsbridge");
    a.put(Long.valueOf(64L), "tel");
    a.put(Long.valueOf(128L), "sms");
    a.put(Long.valueOf(256L), "mqqapi");
    a.put(Long.valueOf(512L), "mqqopensdkapi");
    a.put(Long.valueOf(1024L), "mqqmdpass");
    a.put(Long.valueOf(2048L), "mqq");
    a.put(Long.valueOf(4096L), "qapp");
    a.put(Long.valueOf(8192L), "mqqflyticket");
    a.put(Long.valueOf(16384L), "mqqwpa");
    a.put(Long.valueOf(32768L), "wtloginmqq");
    a.put(Long.valueOf(65536L), "qqwifi");
    a.put(Long.valueOf(131072L), "apollo");
    a.put(Long.valueOf(262144L), "mqqverifycode");
    a.put(Long.valueOf(524288L), "mqqconnect");
    a.put(Long.valueOf(1048576L), "mqqvoipivr");
    a.put(Long.valueOf(2097152L), "mqqdevlock");
    a.put(Long.valueOf(4194304L), "qqfav");
    a.put(Long.valueOf(16777216L), "readinjoy");
    a.put(Long.valueOf(33554432L), "nowmqqapi");
    a.put(Long.valueOf(67108864L), "auth");
  }
  
  static String a(long paramLong)
  {
    if (a.containsKey(Long.valueOf(paramLong))) {
      return (String)a.get(Long.valueOf(paramLong));
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginSchemeConfig
 * JD-Core Version:    0.7.0.1
 */