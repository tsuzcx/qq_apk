package com.tencent.mobileqq.olympic.activity;

import android.widget.Button;
import android.widget.PopupMenu;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.PromotionItem;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo.ZipItem;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionResDownload.DownloadListener;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;
import com.tencent.mobileqq.ar.ARPromotionMgr.SubProcessPromotionMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr.GestureStatusListener;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class PromotionRes
{
  static final String a;
  int[] b = { 100, 100, 100, 100, 100 };
  long c = 0L;
  private ScanTorchActivity d;
  private PromotionRes.ARTransferPromotionResStatusCallBack e;
  private AppInterface f;
  private PromotionConfigInfo.PromotionItem g = null;
  private PromotionResDownload.DownloadListener h = null;
  private GestureMgr.GestureStatusListener i = null;
  private boolean j = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PromotionUtil.a);
    localStringBuilder.append("_Res");
    a = localStringBuilder.toString();
  }
  
  public PromotionRes(ScanTorchActivity paramScanTorchActivity)
  {
    this.d = paramScanTorchActivity;
  }
  
  private void a(AppInterface paramAppInterface, PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    if ((paramPromotionItem != null) && ((!paramPromotionItem.c) || (paramPromotionItem.a() != null)))
    {
      this.g = paramPromotionItem;
      d(paramAppInterface);
      PromotionUtil.a(paramAppInterface).a(paramAppInterface, paramPromotionItem.e);
      a(paramAppInterface, this.e.j());
      return;
    }
    a("onGetTransferDoorConfig", paramAppInterface, true);
  }
  
  private void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    boolean bool = e(paramAppInterface);
    if (this.b[0] == 100) {
      a("tryDownload", paramAppInterface);
    }
    if (bool)
    {
      a("tryDownload", paramAppInterface, false);
      return;
    }
    this.j = paramBoolean;
    a("tryDownload", true);
  }
  
  private void a(String paramString, AppInterface paramAppInterface)
  {
    if (g())
    {
      QLog.w(a, 1, "checkEntryRes, scanTorchActivity为空");
      return;
    }
    paramAppInterface = a();
    if (paramAppInterface == null)
    {
      QLog.w(a, 1, "checkEntryRes, promotion为空");
      return;
    }
    boolean bool2 = this.e.i();
    Object localObject = this.b;
    boolean bool1 = false;
    if (localObject[0] == 100) {
      bool1 = true;
    }
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkEntryRes, from[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], isReadyShowEntry[");
    localStringBuilder.append(bool2);
    localStringBuilder.append("], isEntryReady[");
    localStringBuilder.append(bool1);
    localStringBuilder.append("], promotionItem[");
    localStringBuilder.append(paramAppInterface);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if ((bool2) && (bool1)) {
      this.e.a(paramAppInterface);
    }
  }
  
  private void a(String paramString, AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (g())
    {
      paramAppInterface = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAllRes, scanTorchActivity为空, from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], notify[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramAppInterface, 1, ((StringBuilder)localObject).toString());
      return;
    }
    paramAppInterface = a();
    if (paramAppInterface == null)
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAllRes, promotionItem为空, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], notify[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      if (paramBoolean) {
        this.e.a(paramAppInterface, false);
      }
      return;
    }
    a("checkAllRes", true);
    if (d())
    {
      paramAppInterface = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAllRes, 还在下载中, from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], notify[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramAppInterface, 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (e())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAllRes, 下载失败, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], notify[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      this.e.a(paramAppInterface, false);
      return;
    }
    if (!this.e.h())
    {
      paramAppInterface = a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAllRes, ArEngine未准备好, from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], notify[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramAppInterface, 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkAllRes, all ready, from[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], notify[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    c();
    this.e.a(paramAppInterface, true);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (g()) {
      return;
    }
    long l = this.c;
    Object localObject;
    StringBuilder localStringBuilder;
    if (l == 0L)
    {
      this.c = (System.currentTimeMillis() + 1500L);
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDownloadProgress, 忽略1, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], progress[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    if (l > System.currentTimeMillis())
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDownloadProgress, 忽略2, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], progress[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    if ((paramBoolean) && (f()))
    {
      localObject = this.e;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PromotionRes_");
      localStringBuilder.append(paramString);
      ((PromotionRes.ARTransferPromotionResStatusCallBack)localObject).a(localStringBuilder.toString(), 0);
    }
  }
  
  private boolean g()
  {
    ScanTorchActivity localScanTorchActivity = this.d;
    return (localScanTorchActivity == null) || (localScanTorchActivity.isDestroyed);
  }
  
  public PromotionConfigInfo.PromotionItem a()
  {
    return this.g;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.f = paramAppInterface;
  }
  
  public void a(AppInterface paramAppInterface, PopupMenu paramPopupMenu) {}
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    if (this.e.j())
    {
      QLog.d(a, 1, "getRes,  需要显示穿越门进度条");
      this.j = true;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRes, activityID[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], TotalProgress[");
    localStringBuilder.append(b());
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
    PromotionUtil.a(paramAppInterface).a(paramAppInterface, new PromotionRes.1(this, paramString, paramAppInterface));
  }
  
  public void a(PromotionRes.ARTransferPromotionResStatusCallBack paramARTransferPromotionResStatusCallBack)
  {
    this.e = paramARTransferPromotionResStatusCallBack;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public int b()
  {
    int k = 0;
    int m = 0;
    int[] arrayOfInt;
    for (;;)
    {
      arrayOfInt = this.b;
      if (k >= arrayOfInt.length) {
        break;
      }
      m += arrayOfInt[k];
      k += 1;
    }
    return m / arrayOfInt.length;
  }
  
  public void b(AppInterface paramAppInterface)
  {
    this.d = null;
    if (this.h != null)
    {
      PromotionUtil.a(paramAppInterface).b(this.h);
      this.h = null;
    }
    if (this.i != null) {
      GestureMgr.e().a(false, this.i);
    }
    this.g = null;
  }
  
  void c()
  {
    if (QQAudioHelper.b(5) != 1) {
      return;
    }
    Button localButton = (Button)this.d.findViewById(2131431646);
    localButton.setVisibility(0);
    if (localButton.getTag() != null) {
      return;
    }
    localButton.setTag(new Object());
    localButton.setOnClickListener(new PromotionRes.4(this));
  }
  
  public void c(AppInterface paramAppInterface)
  {
    PromotionConfigInfo.PromotionItem localPromotionItem = a();
    boolean bool2 = d();
    boolean bool1;
    if (!bool2) {
      bool1 = e();
    } else {
      bool1 = false;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reTry, promotionItem[");
    localStringBuilder.append(localPromotionItem);
    localStringBuilder.append("], isDownloading[");
    localStringBuilder.append(bool2);
    localStringBuilder.append("], isDownloadError[");
    localStringBuilder.append(bool1);
    localStringBuilder.append("], needShowDownloadProgress[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("], TotalProgress[");
    localStringBuilder.append(b());
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.j = true;
    if (localPromotionItem == null) {
      return;
    }
    if (bool2) {
      return;
    }
    PromotionUtil.a(paramAppInterface).a(paramAppInterface, localPromotionItem.e);
    a(paramAppInterface, this.e.j());
  }
  
  void d(AppInterface paramAppInterface)
  {
    if (this.h != null) {
      return;
    }
    this.i = new PromotionRes.2(this, paramAppInterface);
    GestureMgr.e().a(true, this.i);
    this.h = new PromotionRes.3(this, paramAppInterface);
    PromotionUtil.a(paramAppInterface).a(this.h);
  }
  
  public boolean d()
  {
    int k = 0;
    for (;;)
    {
      Object localObject = this.b;
      if (k >= localObject.length) {
        break;
      }
      if ((localObject[k] >= 0) && (localObject[k] <= 99))
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isDownloading, index[");
        localStringBuilder.append(k);
        localStringBuilder.append("], Progress[");
        localStringBuilder.append(this.b[k]);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        return true;
      }
      k += 1;
    }
    return false;
  }
  
  public boolean e()
  {
    if (d()) {
      return false;
    }
    int k = 0;
    for (;;)
    {
      Object localObject = this.b;
      if (k >= localObject.length) {
        break;
      }
      if (localObject[k] < 0)
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isDownloadError, index[");
        localStringBuilder.append(k);
        localStringBuilder.append("], errCode[");
        localStringBuilder.append(this.b[k]);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        return true;
      }
      k += 1;
    }
    return false;
  }
  
  public boolean e(AppInterface paramAppInterface)
  {
    Object localObject1 = a();
    if (localObject1 == null)
    {
      QLog.w(a, 1, "isResReady no promotion Item so reay");
      return true;
    }
    localObject1 = ((PromotionConfigInfo.PromotionItem)localObject1).b();
    int k = ((TreeMap)localObject1).size();
    Object localObject2;
    if (k + 1 > this.b.length)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkRes, zip数目不对, itemCount[");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append("]");
      localObject2 = ((StringBuilder)localObject2).toString();
      QLog.w(a, 1, (String)localObject2);
      if (QQAudioHelper.b()) {
        throw new IllegalStateException((String)localObject2);
      }
    }
    localObject1 = ((TreeMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PromotionConfigInfo.ZipItem)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if (PromotionResDownload.a(paramAppInterface.getCurrentAccountUin(), (PromotionConfigInfo.ZipItem)localObject2)) {
        this.b[localObject2.a] = 100;
      } else {
        this.b[localObject2.a] = 0;
      }
    }
    if (GestureRecognitionUtils.a()) {
      this.b[3] = 100;
    } else {
      this.b[3] = 0;
    }
    int m = b();
    paramAppInterface = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkRes, itemCount[");
    ((StringBuilder)localObject1).append(k);
    ((StringBuilder)localObject1).append("], Progress0[");
    ((StringBuilder)localObject1).append(this.b[0]);
    ((StringBuilder)localObject1).append("], Progress1[");
    ((StringBuilder)localObject1).append(this.b[1]);
    ((StringBuilder)localObject1).append("], Progress2[");
    ((StringBuilder)localObject1).append(this.b[2]);
    ((StringBuilder)localObject1).append("], Progress3[");
    ((StringBuilder)localObject1).append(this.b[3]);
    ((StringBuilder)localObject1).append("], TotalProgress[");
    ((StringBuilder)localObject1).append(m);
    ((StringBuilder)localObject1).append("]");
    QLog.w(paramAppInterface, 1, ((StringBuilder)localObject1).toString());
    return m == 100;
  }
  
  public void f(AppInterface paramAppInterface)
  {
    QLog.w(a, 1, "onAREngineReady");
    a("onAREngineReady", paramAppInterface, false);
  }
  
  public boolean f()
  {
    return this.j;
  }
  
  public void g(AppInterface paramAppInterface)
  {
    a("onAREngineReady", paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionRes
 * JD-Core Version:    0.7.0.1
 */