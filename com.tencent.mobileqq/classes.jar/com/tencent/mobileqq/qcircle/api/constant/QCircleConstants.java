package com.tencent.mobileqq.qcircle.api.constant;

import android.content.Context;
import android.view.ViewConfiguration;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;

public class QCircleConstants
{
  public static String A = "network";
  public static String B = "AIPhotoConfig";
  public static String C = "AIVideoConfig";
  private static final String D;
  private static final String E;
  private static final String F;
  public static boolean a = false;
  public static int b = 3;
  public static int c = 300;
  public static int d = ;
  public static final String e = RFApplication.getApplication().getFilesDir().getPath();
  public static final String f;
  public static final String g;
  public static final String h;
  public static final String i;
  public static final String j;
  public static final String k;
  public static final String l;
  public static final String m;
  public static final String n;
  public static final HashMap<String, String> o;
  public static final HashMap<String, String> p;
  public static final HashMap<String, String> q;
  public static final String[] r;
  public static final int s;
  public static final String t;
  public static final String u;
  public static final String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(e);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("qcircle");
    ((StringBuilder)localObject).append(File.separator);
    f = ((StringBuilder)localObject).toString();
    D = ((IVFSAssistantApi)QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("cache/");
    E = ((IVFSAssistantApi)QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("file/");
    F = ((IVFSAssistantApi)QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("qcircle/");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(F);
    ((StringBuilder)localObject).append("file/");
    g = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(F);
    ((StringBuilder)localObject).append("cache/");
    h = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(g);
    ((StringBuilder)localObject).append("download/");
    i = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("base/");
    j = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(D);
    ((StringBuilder)localObject).append("qqcircle_video/");
    k = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(g);
    ((StringBuilder)localObject).append("test/");
    l = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(g);
    ((StringBuilder)localObject).append("animation/");
    m = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("qcircle_download_pics/");
    n = ((StringBuilder)localObject).toString();
    o = new HashMap();
    p = new HashMap();
    q = new HashMap();
    o.put("rockey1", "https://downv6.qq.com/video_story/qcircle/animation/rocket1.zip");
    o.put("rockey2", "https://downv6.qq.com/video_story/qcircle/animation/rocket2.zip");
    o.put("rockey3", "https://downv6.qq.com/video_story/qcircle/animation/rocket3.zip");
    localObject = p;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append("rockey1");
    localStringBuilder.append(File.separator);
    ((HashMap)localObject).put("rockey1", localStringBuilder.toString());
    localObject = p;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append("rockey2");
    localStringBuilder.append(File.separator);
    ((HashMap)localObject).put("rockey2", localStringBuilder.toString());
    localObject = p;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append("rockey3");
    localStringBuilder.append(File.separator);
    ((HashMap)localObject).put("rockey3", localStringBuilder.toString());
    r = new String[] { "rockey1", "rockey2", "rockey3" };
    s = ImmersiveUtils.dpToPx(80.0F);
    t = VFSAssistantUtils.getSDKPrivatePath("qzone");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(t);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("MaxVideo");
    u = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("qzone");
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("thumbs");
    ((StringBuilder)localObject).append(File.separator);
    v = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    w = "qcircle_client_traceid";
    x = "video";
    y = "pic";
    z = "cache";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.constant.QCircleConstants
 * JD-Core Version:    0.7.0.1
 */