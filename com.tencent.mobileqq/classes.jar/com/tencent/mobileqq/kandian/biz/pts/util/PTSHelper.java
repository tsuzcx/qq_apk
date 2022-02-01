package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.pts.PTSFragment;
import com.tencent.mobileqq.kandian.biz.pts.loaders.PTSAppLoader;
import com.tencent.mobileqq.kandian.biz.pts.loaders.PTSEngineLoader;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeGif.Builder;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeImage.Builder;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeRIJAvatar.Builder;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeRichText.Builder;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeVideo.Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSConfig;
import com.tencent.pts.utils.PTSConfig.PTSConfigBuilder;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo;
import com.tencent.qphone.base.util.QLog;

public class PTSHelper
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      int i = Color.parseColor(paramString);
      paramString = new StringBuilder();
      paramString.append(i << 8 & 0xFFFFFF00 | i >> 24 & 0xFF);
      paramString.append("");
      paramString = paramString.toString();
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getRgbaColor] e = ");
      localStringBuilder.append(paramString);
      QLog.e("PTSHelper", 1, localStringBuilder.toString());
    }
    return "";
  }
  
  public static void a()
  {
    PTSSwitchManager.a.a();
    PTSLiteSwitchManager.a().d();
  }
  
  public static boolean a(Context paramContext)
  {
    if (!PTSSwitchManager.a.c()) {
      return false;
    }
    int i = DailyModeConfigHandler.j();
    if (!DailyModeConfigHandler.a(i))
    {
      paramContext = new StringBuilder();
      paramContext.append("[isAbleToJumpNewPTSDailyPage], it is not normal daily channel, channelID = ");
      paramContext.append(i);
      QLog.i("PTSHelper", 1, paramContext.toString());
      return false;
    }
    if ((PTSEngineLoader.a().d()) && (PTSAppLoader.a().a("daily_feeds")))
    {
      b(paramContext);
      return true;
    }
    return false;
  }
  
  static void b()
  {
    if (SystemUtil.d())
    {
      PTSDeviceUtil.setTextHeightOffsetPerLine(0.1176471F);
      PTSDeviceUtil.setTextWidthOffsetPerLength(0.02941177F);
    }
    PTSNodeFactory.registerNodeVirtual("img", new PTSNodeImage.Builder());
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-video", new PTSNodeVideo.Builder());
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-gif", new PTSNodeGif.Builder());
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "rij-avatar-view", new PTSNodeRIJAvatar.Builder());
    PTSNodeFactory.registerNodeVirtual("rich-text", new PTSNodeRichText.Builder());
    d();
  }
  
  private static void b(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = PTSAppLoader.a().b("3978");
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName", "daily_feeds");
    PTSEngineLoader.a().getClass();
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PagePath", str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[jumpToPTSDailyPage], dailyAppPath = ");
    localStringBuilder.append(str);
    QLog.i("PTSHelper", 1, localStringBuilder.toString());
    PublicFragmentActivity.a(paramContext, localIntent, PTSFragment.class);
  }
  
  static void c() {}
  
  private static void d()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
    localHandlerThread.start();
    PTSHelper.1 local1 = new PTSHelper.1();
    PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo localINodeVirtualOnBindNodeInfo = e();
    PTSHelper.2 local2 = new PTSHelper.2();
    PTSConfig.init(new PTSConfig.PTSConfigBuilder().withHandlerThread(localHandlerThread).withLogger(new PTSLogQQ()).withPtsReport(local1).withOnBindNodeInfo(localINodeVirtualOnBindNodeInfo).withOnViewClick(local2).build());
  }
  
  private static PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo e()
  {
    return new PTSHelper.3();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSHelper
 * JD-Core Version:    0.7.0.1
 */