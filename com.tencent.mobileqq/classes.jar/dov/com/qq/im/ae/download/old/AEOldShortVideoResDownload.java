package dov.com.qq.im.ae.download.old;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AEOldShortVideoResDownload
  implements AEOldShortVideoResStatus.ISVConfig
{
  private static AtomicInteger c = new AtomicInteger(0);
  private static String d = "AEOldShortVideoResDownload_";
  private static ConcurrentHashMap<Integer, AEOldShortVideoResDownload> g = new ConcurrentHashMap(5);
  boolean a;
  public int b;
  private QQAppInterface e;
  private AEOldShortVideoResDownload.ResDownloadCallBack f;
  
  private AEOldShortVideoResDownload(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.e = paramQQAppInterface;
    this.b = c.getAndIncrement();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(d);
    paramQQAppInterface.append(this.b);
    d = paramQQAppInterface.toString();
    this.f = new AEOldShortVideoResDownload.ResDownloadCallBack(d, this);
    this.a = paramBoolean;
  }
  
  public static void a()
  {
    ConcurrentHashMap localConcurrentHashMap = g;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, @Nullable AEOldShortVideoResStatus.ISVConfig_V2 paramISVConfig_V2)
  {
    AEQLog.b(d, "[startDownload215ConfigWithoutLogin] - BEGIN -");
    boolean bool = VideoEnvironment.supportShortVideoRecordAndPlay();
    if (!bool)
    {
      g.clear();
      if (paramISVConfig_V2 != null) {
        paramISVConfig_V2.b(-1, -6);
      }
      paramQQAppInterface = d;
      paramISVConfig_V2 = new StringBuilder();
      paramISVConfig_V2.append("[startDownload215ConfigWithoutLogin] - END -, supportShortVideo=");
      paramISVConfig_V2.append(bool);
      AEQLog.b(paramQQAppInterface, paramISVConfig_V2.toString());
      return;
    }
    if (g.size() >= 3)
    {
      if (paramISVConfig_V2 != null) {
        paramISVConfig_V2.b(-1, -1);
      }
      paramQQAppInterface = d;
      paramISVConfig_V2 = new StringBuilder();
      paramISVConfig_V2.append("[startDownload215ConfigWithoutLogin] - END -, reach to max session size=");
      paramISVConfig_V2.append(g.size());
      AEQLog.b(paramQQAppInterface, paramISVConfig_V2.toString());
      return;
    }
    paramQQAppInterface = new AEOldShortVideoResDownload(paramQQAppInterface, true);
    g.put(Integer.valueOf(paramQQAppInterface.b), paramQQAppInterface);
    paramQQAppInterface.a(paramISVConfig_V2);
    AEQLog.b(d, "[startDownload215ConfigWithoutLogin] - END -");
  }
  
  private void a(@Nullable AEOldShortVideoResStatus.ISVConfig_V2 paramISVConfig_V2)
  {
    AEQLog.b(d, "[startDownload215ConfigWithoutLoginInternal] - BEGIN -");
    AEOldShortVideoResManager.b(this.e, new AEOldShortVideoResDownload.2(this, paramISVConfig_V2));
    AEQLog.b(d, "[startDownload215ConfigWithoutLoginInternal] - END -");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    try
    {
      if (!VideoEnvironment.supportShortVideoRecordAndPlay())
      {
        g.clear();
        return false;
      }
      if (g.size() >= 3)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("reach to max session size=");
        paramQQAppInterface.append(g.size());
        VideoEnvironment.LogDownLoad("ShortVideoResDownload", paramQQAppInterface.toString(), null);
        return false;
      }
      paramQQAppInterface = new AEOldShortVideoResDownload(paramQQAppInterface, paramBoolean);
      g.put(Integer.valueOf(paramQQAppInterface.b), paramQQAppInterface);
      paramBoolean = paramQQAppInterface.c();
      if (!paramBoolean) {
        g.remove(Integer.valueOf(paramQQAppInterface.b));
      }
      return paramBoolean;
    }
    finally {}
  }
  
  private boolean c()
  {
    boolean bool = NetworkUtil.isNetworkAvailable(null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad(d, HardCodeUtil.a(2131911501), null);
      AEOldShortVideoResManager.b(this.e, this);
      return bool;
    }
    VideoEnvironment.LogDownLoad(d, HardCodeUtil.a(2131911440), null);
    return bool;
  }
  
  private static void d(AEOldShortVideoResDownload paramAEOldShortVideoResDownload)
  {
    if (paramAEOldShortVideoResDownload != null) {
      g.remove(Integer.valueOf(paramAEOldShortVideoResDownload.b));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onConfigResult | result=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(",serverError=");
    ((StringBuilder)localObject2).append(paramInt2);
    VideoEnvironment.LogDownLoad((String)localObject1, ((StringBuilder)localObject2).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject1 = d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onConfigResult| result= RESULT_FAILED error=");
      ((StringBuilder)localObject2).append(paramInt2);
      VideoEnvironment.LogDownLoad((String)localObject1, ((StringBuilder)localObject2).toString(), null);
      d(this);
      return;
    }
    if (paramInt2 != 0)
    {
      localObject1 = d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onConfigResult| uncompress config error=");
      ((StringBuilder)localObject2).append(paramInt2);
      VideoEnvironment.LogDownLoad((String)localObject1, ((StringBuilder)localObject2).toString(), null);
      d(this);
      return;
    }
    localObject1 = new ArrayList(1);
    paramInt1 = AEOldShortVideoResManager.a(this.e, (List)localObject1);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad(d, "onConfigResult| check config success...", null);
      localObject2 = this.f;
      ((AEOldShortVideoResDownload.ResDownloadCallBack)localObject2).a = false;
      AEOldShortVideoResManager.a(this.e, (List)localObject1, (AEOldShortVideoResManager.INet_ShortVideoResource)localObject2);
      VideoEnvironment.LogDownLoad(d, "onConfigResult| mDownloadFilterSo=false", null);
      if ((this.a) && (PtvFilterSoLoad.e()))
      {
        localObject2 = this.f;
        ((AEOldShortVideoResDownload.ResDownloadCallBack)localObject2).b = false;
        AEOldShortVideoResManager.b(this.e, (List)localObject1, (AEOldShortVideoResManager.INet_ShortVideoResource)localObject2);
      }
      this.f.a();
      return;
    }
    localObject1 = d;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onConfigResult| check config error=");
    ((StringBuilder)localObject2).append(paramInt1);
    VideoEnvironment.LogDownLoad((String)localObject1, ((StringBuilder)localObject2).toString(), null);
    d(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResDownload
 * JD-Core Version:    0.7.0.1
 */