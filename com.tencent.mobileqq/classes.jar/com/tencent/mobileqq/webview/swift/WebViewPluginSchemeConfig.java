package com.tencent.mobileqq.webview.swift;

public class WebViewPluginSchemeConfig
{
  static String a(long paramLong)
  {
    String str = "";
    if (paramLong == 1L) {
      str = "http";
    }
    do
    {
      return str;
      if (paramLong == 2L) {
        return "https";
      }
      if (paramLong == 4L) {
        return "publicaccount";
      }
      if (paramLong == 8L) {
        return "pay";
      }
      if (paramLong == 16L) {
        return "qqvip";
      }
      if (paramLong == 32L) {
        return "qqjsbridge";
      }
      if (paramLong == 64L) {
        return "tel";
      }
      if (paramLong == 128L) {
        return "sms";
      }
      if (paramLong == 256L) {
        return "mqqapi";
      }
      if (paramLong == 512L) {
        return "mqqopensdkapi";
      }
      if (paramLong == 1024L) {
        return "mqqmdpass";
      }
      if (paramLong == 2048L) {
        return "mqq";
      }
      if (paramLong == 4096L) {
        return "qapp";
      }
      if (paramLong == 8192L) {
        return "mqqflyticket";
      }
      if (paramLong == 16384L) {
        return "mqqwpa";
      }
      if (paramLong == 32768L) {
        return "wtloginmqq";
      }
      if (paramLong == 65536L) {
        return "qqwifi";
      }
      if (paramLong == 131072L) {
        return "apollo";
      }
      if (paramLong == 262144L) {
        return "mqqverifycode";
      }
      if (paramLong == 524288L) {
        return "mqqconnect";
      }
      if (paramLong == 1048576L) {
        return "mqqvoipivr";
      }
      if (paramLong == 2097152L) {
        return "mqqdevlock";
      }
      if (paramLong == 4194304L) {
        return "qqfav";
      }
      if (paramLong == 16777216L) {
        return "readinjoy";
      }
      if (paramLong == 33554432L) {
        return "nowmqqapi";
      }
    } while (paramLong != 67108864L);
    return "auth";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginSchemeConfig
 * JD-Core Version:    0.7.0.1
 */