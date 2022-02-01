package com.tencent.open.base;

import android.content.Context;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

public class ShareProcessorUtil
{
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reuseImageForAIO|oldCache=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",oldUrl=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",newUrl=");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("Q.share.ShareProcessorUtil", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool;
    if (paramString1 != null)
    {
      try
      {
        if ((paramString1.equals(paramString3)) || (GlobalImageCache.a == null)) {
          break label223;
        }
        paramString1 = GlobalImageCache.a.get(paramString1);
        if (paramString1 == null) {
          break label223;
        }
        bool = true;
        GlobalImageCache.a.put(paramString3, paramString1);
      }
      catch (Exception paramString1)
      {
        label121:
        break label201;
      }
      paramString1 = AbsDownloader.getFilePath(paramString2);
      localObject = AbsDownloader.getFilePath(paramString3);
      if ((paramString2 == null) || (paramString2.equals(paramString3))) {
        break label235;
      }
      paramBoolean = FileUtils.copyFile(paramString1, (String)localObject);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("reuseImageForAIO|cache=");
        paramString1.append(bool);
        paramString1.append(",file=");
        paramString1.append(paramBoolean);
        QLog.d("Q.share.ShareProcessorUtil", 2, paramString1.toString());
        return;
        label201:
        if (QLog.isColorLevel()) {
          QLog.d("Q.share.ShareProcessorUtil", 2, paramString1, new Object[0]);
        }
      }
      return;
      label223:
      bool = false;
      if (!paramBoolean) {
        break;
      }
      paramString1 = paramString2;
      break label121;
      label235:
      paramBoolean = false;
    }
  }
  
  public static Object[] a(Context paramContext, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRichInfo|targetUrl=");
      localStringBuilder.append(paramString1);
      QLog.d("Q.share.ShareProcessorUtil", 2, localStringBuilder.toString());
    }
    Object[] arrayOfObject = new Object[4];
    int i = -1;
    arrayOfObject[0] = Integer.valueOf(-1);
    StringBuilder localStringBuilder = null;
    arrayOfObject[1] = null;
    arrayOfObject[2] = null;
    arrayOfObject[3] = null;
    if (paramContext != null) {
      if (TextUtils.isEmpty(paramString1)) {
        return arrayOfObject;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = HttpUtil.openRequest(paramContext, String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s", new Object[] { paramString2, URLEncoder.encode(paramString1) }), null, "GET", null, null, 5000, 5000);
        if (paramContext != null)
        {
          int j = paramContext.getStatusLine().getStatusCode();
          if (j == 200)
          {
            paramContext = HttpUtil.readHttpResponse(paramContext);
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("getRichInfo|result=");
              paramString1.append(paramContext);
              QLog.d("Q.share.ShareProcessorUtil", 2, paramString1.toString());
            }
            if (!TextUtils.isEmpty(paramContext))
            {
              JSONObject localJSONObject = new JSONObject(paramContext);
              if (localJSONObject.has("ret")) {
                i = localJSONObject.getInt("ret");
              }
              if (!localJSONObject.has("title")) {
                break label412;
              }
              paramContext = localJSONObject.getString("title");
              if (!localJSONObject.has("abstract")) {
                break label417;
              }
              paramString1 = localJSONObject.getString("abstract");
              paramString2 = localStringBuilder;
              if (localJSONObject.has("thumbUrl")) {
                paramString2 = localJSONObject.getString("thumbUrl");
              }
              if (i != 0)
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("getRichInfo|ret=");
                localStringBuilder.append(i);
                QLog.w("Q.share.ShareProcessorUtil", 1, localStringBuilder.toString());
              }
              return new Object[] { Integer.valueOf(i), paramContext, paramString1, paramString2 };
            }
          }
          else
          {
            paramContext = new StringBuilder();
            paramContext.append("getRichInfo|httpCode=");
            paramContext.append(j);
            QLog.w("Q.share.ShareProcessorUtil", 1, paramContext.toString());
            return arrayOfObject;
          }
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.share.ShareProcessorUtil", 2, paramContext, new Object[0]);
        }
      }
      return arrayOfObject;
      label412:
      paramContext = null;
      continue;
      label417:
      paramString1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.base.ShareProcessorUtil
 * JD-Core Version:    0.7.0.1
 */