package com.tencent.open.filedownload;

import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public class CommonUtils
{
  public static String a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("genExistedAPKFileNameByUrl url = ");
    ((StringBuilder)localObject1).append(paramString);
    LogUtility.b("CommonUtils_", ((StringBuilder)localObject1).toString());
    Object localObject2;
    if (paramString.contains(".apk"))
    {
      localObject2 = paramString.trim().substring(paramString.lastIndexOf("/") + 1).trim();
      localObject1 = localObject2;
      if (((String)localObject2).contains("?")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("?"));
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramString = c(b((String)localObject1));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("genExistedAPKFileNameByUrl  fileName = ");
        ((StringBuilder)localObject1).append(paramString);
        LogUtility.b("CommonUtils_", ((StringBuilder)localObject1).toString());
        return paramString;
      }
    }
    else
    {
      localObject2 = null;
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = GlobalUtil.calcMD5AsString(paramString);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = Integer.toString(Math.abs(paramString.hashCode()));
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject1);
      paramString.append(".apk");
      localObject1 = paramString.toString();
    }
    paramString = new StringBuilder();
    paramString.append("genExistedAPKFileNameByUrl fileName == null, return fileName = ");
    paramString.append((String)localObject1);
    LogUtility.b("CommonUtils_", paramString.toString());
    return localObject1;
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    try
    {
      paramString = new URL(paramString);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = 234;
      localURLDrawableOptions.mRequestWidth = 234;
      localURLDrawableOptions.mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(2130842839);
      localURLDrawableOptions.mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(2130842839);
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setAutoDownload(true);
      paramString.setURLDrawableListener(new CommonUtils.1(paramImageView));
      paramString.startDownload();
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramImageView)
    {
      paramImageView.printStackTrace();
    }
  }
  
  public static boolean a()
  {
    MyAppApi.l();
    return MyAppApi.m();
  }
  
  private static String b(String paramString)
  {
    if (paramString != null) {
      return URLDecoder.decode(paramString);
    }
    return "";
  }
  
  private static String c(String paramString)
  {
    return paramString.replace("?", "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace("&", "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.filedownload.CommonUtils
 * JD-Core Version:    0.7.0.1
 */