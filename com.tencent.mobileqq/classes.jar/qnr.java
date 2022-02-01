import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.pts.PTSFragment;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeGif;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeImage;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeRIJAvatar;
import com.tencent.biz.pubaccount.readinjoy.pts.ui.PTSNodeVideo;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
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

public class qnr
{
  private static PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo a()
  {
    return new qnu();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    try
    {
      int i = Color.parseColor(paramString);
      paramString = (i << 8 & 0xFFFFFF00 | i >> 24 & 0xFF) + "";
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.e("PTSHelper", 1, "[getRgbaColor] e = " + paramString);
    }
    return "";
  }
  
  public static void a()
  {
    qof.a.a();
    qny.a().a();
  }
  
  private static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    String str = qmt.a().a("3978");
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PageName", "daily_feeds");
    qmv.a().getClass();
    localIntent.putExtra("com.tencent.biz.pubaccount.readinjoy.pts.PagePath", str);
    QLog.i("PTSHelper", 1, "[jumpToPTSDailyPage], dailyAppPath = " + str);
    PublicFragmentActivity.a(paramContext, localIntent, PTSFragment.class);
  }
  
  public static boolean a(Context paramContext)
  {
    if (!qof.a.b()) {}
    do
    {
      return false;
      int i = pcl.b();
      if (!pcl.a(i))
      {
        QLog.i("PTSHelper", 1, "[isAbleToJumpNewPTSDailyPage], it is not normal daily channel, channelID = " + i);
        return false;
      }
    } while ((!qmv.a().a()) || (!qmt.a().a("daily_feeds")));
    a(paramContext);
    return true;
  }
  
  public static void b()
  {
    if (SystemUtil.isMIUI())
    {
      PTSDeviceUtil.setTextHeightOffsetPerLine(0.1176471F);
      PTSDeviceUtil.setTextWidthOffsetPerLength(0.02941177F);
    }
    PTSNodeFactory.registerNodeVirtual("img", PTSNodeImage.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-video", PTSNodeVideo.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "qq-rij-gif", PTSNodeGif.class);
    PTSNodeFactory.registerCustomViewNodeVirtual("view", "rij-avatar-view", PTSNodeRIJAvatar.class);
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
        localStringBuilder.append("[").append((String)localEntry.getKey()).append("] = ").append(localEntry.getValue()).append("\n");
      }
      QLog.i("PTSHelper", 2, localStringBuilder.toString());
    }
  }
  
  static void c() {}
  
  private static void d()
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
    localHandlerThread.start();
    qns localqns = new qns();
    PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo localINodeVirtualOnBindNodeInfo = a();
    qnt localqnt = new qnt();
    PTSConfig.init(new PTSConfig.PTSConfigBuilder().withHandlerThread(localHandlerThread).withLogger(new qnz()).withPtsReport(localqns).withOnBindNodeInfo(localINodeVirtualOnBindNodeInfo).withOnViewClick(localqnt).build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnr
 * JD-Core Version:    0.7.0.1
 */