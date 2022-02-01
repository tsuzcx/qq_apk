package com.tencent.mobileqq.flashshow.constants;

import android.app.Application;
import com.tencent.mobileqq.flashshow.application.FSApplication;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;
import java.io.File;

public class FSDownloadConstants
{
  public static final String a = FSApplication.APP.getFilesDir().getPath();
  public static final String b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  private static final String i;
  private static final String j;
  private static final String k;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("flashshow");
    localStringBuilder.append(File.separator);
    b = localStringBuilder.toString();
    i = ((IVFSAssistantApi)QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("cache/");
    j = ((IVFSAssistantApi)QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("file/");
    k = ((IVFSAssistantApi)QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("flashshow/");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("file/");
    c = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(k);
    localStringBuilder.append("cache/");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("download/");
    e = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(e);
    localStringBuilder.append("base/");
    f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("test/");
    g = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("animation/");
    h = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.constants.FSDownloadConstants
 * JD-Core Version:    0.7.0.1
 */