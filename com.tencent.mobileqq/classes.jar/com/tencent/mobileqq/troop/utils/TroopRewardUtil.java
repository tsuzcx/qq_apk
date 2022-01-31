package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.ApplyUploadRsp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class TroopRewardUtil
{
  public static TroopBarShortVideoUploadUtil.ApplyUploadRsp a(Bundle paramBundle, String paramString1, String paramString2)
  {
    localObject = null;
    HttpPost localHttpPost = null;
    int j = 0;
    long l = System.currentTimeMillis();
    String str2 = paramBundle.getString("title");
    String str1 = paramBundle.getString("file_path");
    paramBundle = paramBundle.getString("vid");
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "applyUpload title = " + str2 + ", filePath = " + str1 + ", size = " + FileUtils.a(str1));
    }
    if ((TextUtils.isEmpty(str1)) || (!FileUtils.a(str1)))
    {
      paramString1 = localHttpPost;
      if (QLog.isColorLevel())
      {
        QLog.e("TroopBar", 2, "!!!!!!!applyUpload filePath = " + str1);
        paramString1 = localHttpPost;
      }
      return paramString1;
    }
    localHttpPost = new HttpPost("http://pay.qun.qq.com/cgi-bin/group_pay/reward/video_up_ready");
    localHttpPost.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
    localHttpPost.setHeader("Accept-Charset", "utf-8;q=0.7,*;q=0.7");
    localHttpPost.setHeader("Accept-Encoding", "gzip, deflate");
    localHttpPost.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
    localHttpPost.setHeader("Connection", "keep-alive");
    localHttpPost.setHeader("Cookie", "skey=" + paramString2 + ";uin=" + paramString1);
    paramString1 = new ArrayList();
    paramString1.add(new BasicNameValuePair("title", str2));
    paramString1.add(new BasicNameValuePair("size", String.valueOf(FileUtils.a(str1))));
    paramString1.add(new BasicNameValuePair("sha", HexUtil.a(FileManagerUtil.a(str1)).toLowerCase()));
    paramString1.add(new BasicNameValuePair("md5", HexUtil.a(FileManagerUtil.c(str1)).toLowerCase()));
    paramString1.add(new BasicNameValuePair("bkn", "" + TroopUtils.b(paramString2)));
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "applyUpload() getMessageDigest time = " + (System.currentTimeMillis() - l));
    }
    paramString1.add(new BasicNameValuePair("platform", "android"));
    if (!TextUtils.isEmpty(paramBundle)) {
      paramString1.add(new BasicNameValuePair("vid", paramBundle));
    }
    try
    {
      localHttpPost.setEntity(new UrlEncodedFormEntity(paramString1, "UTF-8"));
      paramBundle = new DefaultHttpClient().execute(localHttpPost);
      if (paramBundle.getStatusLine().getStatusCode() != 200) {
        break label710;
      }
      paramString1 = paramBundle.getHeaders("Content-Encoding");
      k = paramString1.length;
      i = 0;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int k;
        int i;
        paramBundle = localObject;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopBar", 2, QLog.getStackTraceString(paramString1));
          paramBundle = localObject;
          continue;
          paramBundle = null;
          continue;
          i += 1;
        }
      }
    }
    if (i < k)
    {
      if (paramString1[i].getValue().equals("gzip")) {
        j = 1;
      }
    }
    else
    {
      paramBundle = paramBundle.getEntity();
      if (j != 0) {}
      for (paramBundle = HttpBaseUtil.a(new GZIPInputStream(paramBundle.getContent()));; paramBundle = EntityUtils.toString(paramBundle))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, "applyUpload result = " + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (paramBundle.optInt("ec", -1) != 0) {
          break label710;
        }
        paramBundle = new TroopBarShortVideoUploadUtil.ApplyUploadRsp(paramBundle);
        paramString1 = paramBundle;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopBar", 2, "applyUpload time: " + (System.currentTimeMillis() - l));
        return paramBundle;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopRewardUtil
 * JD-Core Version:    0.7.0.1
 */