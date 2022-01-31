package com.tencent.mobileqq.webview.swift;

import com.tencent.biz.webviewplugin.PtloginPlugin;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import java.util.HashMap;

public class WebViewPluginSchemeConfig
{
  public static final HashMap a = new HashMap();
  
  static
  {
    a.put(WebViewJumpPlugin.a, Long.valueOf(4294967295L));
    a.put("Qzone", Long.valueOf(4294967295L));
    a.put("qzDynamicAlbum", Long.valueOf(4294967295L));
    a.put("QZImagePicker", Long.valueOf(4294967295L));
    a.put("qzlive", Long.valueOf(4294967295L));
    a.put("PublicAccountJs", Long.valueOf(4L));
    a.put("offline", Long.valueOf(3L));
    a.put(PtloginPlugin.class.getSimpleName(), Long.valueOf(3L));
    a.put(QzonePlugin.a, Long.valueOf(11L));
    a.put("UrlSaveVerify", Long.valueOf(3L));
    a.put("qqmusic", Long.valueOf(3L));
    a.put("emoji", Long.valueOf(32L));
    a.put("msgRoam", Long.valueOf(1L));
    a.put("qw.pay", Long.valueOf(32L));
    a.put("common", Long.valueOf(32L));
    a.put("readinjoy", Long.valueOf(16777216L));
  }
  
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
    } while (paramLong != 16777216L);
    return "readinjoy";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewPluginSchemeConfig
 * JD-Core Version:    0.7.0.1
 */