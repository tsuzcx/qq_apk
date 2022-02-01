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
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeGif;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeImage;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeRIJAvatar;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeRichText;
import com.tencent.mobileqq.kandian.biz.pts.ui.PTSNodeVideo;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSConfig;
import com.tencent.pts.utils.PTSConfig.PTSConfigBuilder;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PTSHelper
{
  private static PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo a()
  {
    return new PTSHelper.3();
  }
  
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
    PTSLiteSwitchManager.a().a();
  }
  
  private static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = PTSAppLoader.a().a("3978");
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName", "daily_feeds");
    PTSEngineLoader.a().getClass();
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PagePath", str);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[jumpToPTSDailyPage], dailyAppPath = ");
    localStringBuilder.append(str);
    QLog.i("PTSHelper", 1, localStringBuilder.toString());
    PublicFragmentActivity.a(paramContext, localIntent, PTSFragment.class);
  }
  
  public static boolean a(Context paramContext)
  {
    if (!PTSSwitchManager.a.b()) {
      return false;
    }
    int i = DailyModeConfigHandler.b();
    if (!DailyModeConfigHandler.a(i))
    {
      paramContext = new StringBuilder();
      paramContext.append("[isAbleToJumpNewPTSDailyPage], it is not normal daily channel, channelID = ");
      paramContext.append(i);
      QLog.i("PTSHelper", 1, paramContext.toString());
      return false;
    }
    if ((PTSEngineLoader.a().a()) && (PTSAppLoader.a().a("daily_feeds")))
    {
      a(paramContext);
      return true;
    }
    return false;
  }
  
  static void b()
  {
    if (SystemUtil.b())
    {
      PTSDeviceUtil.setTextHeightOffsetPerLine(0.1176471F);
      PTSDeviceUtil.setTextWidthOffsetPerLength(0.02941177F);
    }
    PTSNodeFactory.registerNodeVirtual("img", PTSNodeImage.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-video", PTSNodeVideo.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-gif", PTSNodeGif.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "rij-avatar-view", PTSNodeRIJAvatar.class);
    PTSNodeFactory.registerNodeVirtual("rich-text", PTSNodeRichText.class);
    d();
  }
  
  private static void b(Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[onBindNodeInfoFinished] paramsMap : \n");
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localStringBuilder.append("[");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("] = ");
        localStringBuilder.append(localEntry.getValue());
        localStringBuilder.append("\n");
      }
      QLog.i("PTSHelper", 2, localStringBuilder.toString());
    }
  }
  
  static void c() {}
  
  private static void d()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
    localHandlerThread.start();
    PTSHelper.1 local1 = new PTSHelper.1();
    PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo localINodeVirtualOnBindNodeInfo = a();
    PTSHelper.2 local2 = new PTSHelper.2();
    PTSConfig.init(new PTSConfig.PTSConfigBuilder().withHandlerThread(localHandlerThread).withLogger(new PTSLogQQ()).withPtsReport(local1).withOnBindNodeInfo(localINodeVirtualOnBindNodeInfo).withOnViewClick(local2).build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSHelper
 * JD-Core Version:    0.7.0.1
 */