package com.tencent.mobileqq.emosm.cameraemotionroaming;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.ICameraEmoRoamingHandler;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService.ICameraEmoAddCallBack;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.control.EmoAsyncStep;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import mqq.app.MobileQQ;

public class CameraEmoSingleSend
  extends EmoAsyncStep
{
  public boolean a;
  private final Object b = new Object();
  private boolean k;
  private CameraEmotionData l;
  private ICameraEmotionRoamingDBManagerService m;
  private ICameraEmoRoamingHandler n;
  private ICameraEmoRoamingManagerService o;
  private Timer p;
  private boolean q;
  
  public CameraEmoSingleSend(CameraEmotionData paramCameraEmotionData, boolean paramBoolean)
  {
    this.k = paramBoolean;
    this.l = paramCameraEmotionData;
    c();
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = this.l;
    if (paramBoolean) {
      ??? = "normal";
    } else {
      ??? = "failed";
    }
    ((CameraEmotionData)localObject2).RomaingType = ((String)???);
    this.m.updateCustomEmotion(this.l);
    this.m.trimCache();
    this.n.notifyUI(5, paramBoolean, Integer.valueOf(14));
    localObject2 = new HashMap();
    if (paramBoolean) {
      ??? = "1";
    } else {
      ??? = "0";
    }
    ((HashMap)localObject2).put("sucFlag", ???);
    ((HashMap)localObject2).put("retCode", String.valueOf(paramInt));
    f().collectPerformance(null, "CamEmoUpload", paramBoolean, 0L, 0L, (HashMap)localObject2, null);
    synchronized (this.b)
    {
      this.b.notify();
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (this.q)
    {
      QLog.d("CameraEmoSingleSend", 1, new Object[] { "upload return, timer canceled, emoPath:", this.l.emoPath });
      return;
    }
    if (paramBoolean)
    {
      String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      CameraEmotionData localCameraEmotionData = this.l;
      localCameraEmotionData.emoPath = paramString;
      localCameraEmotionData.md5 = str;
      this.m.updateCustomEmotion(localCameraEmotionData);
      paramString = new CameraEmoSingleSend.3(this);
      if (!e())
      {
        QLog.d("CameraEmoSingleSend", 1, "uploadCameraEmo, net not support");
        paramString.a(12, this.l);
        return;
      }
      this.o.uploadCameraEmo(this.l, paramString);
      return;
    }
    a(false, 14);
  }
  
  public Object a(String paramString)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).getGIFCreator(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus(paramString, paramInt);
  }
  
  protected int b()
  {
    this.p = new Timer();
    this.p.schedule(new CameraEmoSingleSend.1(this), 90000L);
    boolean bool1;
    if (this.k)
    {
      boolean bool2;
      if ((this.l.emoOriginalPath != null) && (new File(this.l.emoOriginalPath).exists())) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((this.l.emoPath != null) && (new File(this.l.emoPath).exists())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QLog.d("CameraEmoSingleSend", 1, new Object[] { "resend, hasOriginalFile:", Boolean.valueOf(bool2), " hasMergedFile:", Boolean.valueOf(bool1) });
      if ((!bool2) && (!bool1))
      {
        QLog.d("CameraEmoSingleSend", 1, new Object[] { "resend, emoOriginalPath:", this.l.emoOriginalPath, " emoPath:", this.l.emoPath, " emoId:", Integer.valueOf(this.l.emoId) });
        ??? = this.l;
        ((CameraEmotionData)???).RomaingType = "failed";
        this.m.updateCustomEmotion((CameraEmotionData)???);
        this.n.notifyUI(4, true, null);
        return 7;
      }
      this.m.updateCustomEmotion(this.l);
    }
    else
    {
      bool1 = false;
    }
    if ((this.k) && (bool1))
    {
      a(true, this.l.emoPath);
    }
    else if (!TextUtils.isEmpty(this.l.emoPath))
    {
      if (new File(this.l.emoPath).exists())
      {
        a(true, this.l.emoPath);
      }
      else
      {
        QLog.d("CameraEmoSingleSend", 1, new Object[] { "GIF save AIO fail, emoPath not exist, emoPath:", this.l.emoPath });
        return 7;
      }
    }
    else
    {
      long l1 = System.currentTimeMillis();
      ??? = a(this.l.emoOriginalPath);
      CameraEmoSingleSend.2 local2 = new CameraEmoSingleSend.2(this, ???, l1);
      ((IEmosmService)QRoute.api(IEmosmService.class)).startGIFCreator(???, local2);
    }
    if ((!this.q) && (!this.a)) {}
    try
    {
      synchronized (this.b)
      {
        this.b.wait(120000L);
      }
    }
    catch (Exception localException)
    {
      label458:
      break label458;
    }
    this.p.cancel();
    return 7;
    throw localObject2;
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "upload no need wait, timer canceled, emoPath:", this.l.emoPath });
    return 7;
  }
  
  public void c()
  {
    BaseQQAppInterface localBaseQQAppInterface = d();
    if (localBaseQQAppInterface != null)
    {
      this.m = ((ICameraEmotionRoamingDBManagerService)localBaseQQAppInterface.getRuntimeService(ICameraEmotionRoamingDBManagerService.class));
      this.n = ((ICameraEmoRoamingHandler)localBaseQQAppInterface.getBusinessHandler(CameraEmoRoamingHandler.a));
      this.o = ((ICameraEmoRoamingManagerService)localBaseQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class));
    }
  }
  
  public BaseQQAppInterface d()
  {
    return (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public boolean e()
  {
    return NetworkUtil.isNetSupport(BaseApplication.getContext());
  }
  
  public StatisticCollector f()
  {
    return StatisticCollector.getInstance(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend
 * JD-Core Version:    0.7.0.1
 */