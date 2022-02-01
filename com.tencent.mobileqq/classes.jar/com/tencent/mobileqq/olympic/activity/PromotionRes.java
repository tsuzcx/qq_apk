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
  static final String jdField_a_of_type_JavaLangString;
  long jdField_a_of_type_Long = 0L;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private PromotionConfigInfo.PromotionItem jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem = null;
  private PromotionResDownload.DownloadListener jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload$DownloadListener = null;
  private PromotionRes.ARTransferPromotionResStatusCallBack jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack;
  private ScanTorchActivity jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity;
  private GestureMgr.GestureStatusListener jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr$GestureStatusListener = null;
  private boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = { 100, 100, 100, 100, 100 };
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PromotionUtil.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_Res");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public PromotionRes(ScanTorchActivity paramScanTorchActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity = paramScanTorchActivity;
  }
  
  private void a(AppInterface paramAppInterface, PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    if ((paramPromotionItem != null) && ((!paramPromotionItem.jdField_a_of_type_Boolean) || (paramPromotionItem.a() != null)))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem = paramPromotionItem;
      d(paramAppInterface);
      PromotionUtil.a(paramAppInterface).a(paramAppInterface, paramPromotionItem.jdField_a_of_type_JavaLangString);
      a(paramAppInterface, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack.d());
      return;
    }
    a("onGetTransferDoorConfig", paramAppInterface, true);
  }
  
  private void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    boolean bool = a(paramAppInterface);
    if (this.jdField_a_of_type_ArrayOfInt[0] == 100) {
      a("tryDownload", paramAppInterface);
    }
    if (bool)
    {
      a("tryDownload", paramAppInterface, false);
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    a("tryDownload", true);
  }
  
  private void a(String paramString, AppInterface paramAppInterface)
  {
    if (d())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkEntryRes, scanTorchActivity为空");
      return;
    }
    paramAppInterface = a();
    if (paramAppInterface == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkEntryRes, promotion为空");
      return;
    }
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack.c();
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    boolean bool1 = false;
    if (localObject[0] == 100) {
      bool1 = true;
    }
    localObject = jdField_a_of_type_JavaLangString;
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
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack.a(paramAppInterface);
    }
  }
  
  private void a(String paramString, AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (d())
    {
      paramAppInterface = jdField_a_of_type_JavaLangString;
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
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAllRes, promotionItem为空, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], notify[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack.a(paramAppInterface, false);
      }
      return;
    }
    a("checkAllRes", true);
    if (a())
    {
      paramAppInterface = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAllRes, 还在下载中, from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], notify[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramAppInterface, 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (b())
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAllRes, 下载失败, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], notify[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack.a(paramAppInterface, false);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack.b())
    {
      paramAppInterface = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAllRes, ArEngine未准备好, from[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], notify[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("]");
      QLog.w(paramAppInterface, 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkAllRes, all ready, from[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], notify[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    a();
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack.a(paramAppInterface, true);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (d()) {
      return;
    }
    long l = this.jdField_a_of_type_Long;
    Object localObject;
    StringBuilder localStringBuilder;
    if (l == 0L)
    {
      this.jdField_a_of_type_Long = (System.currentTimeMillis() + 1500L);
      localObject = jdField_a_of_type_JavaLangString;
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
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDownloadProgress, 忽略2, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], progress[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    if ((paramBoolean) && (c()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("PromotionRes_");
      localStringBuilder.append(paramString);
      ((PromotionRes.ARTransferPromotionResStatusCallBack)localObject).a(localStringBuilder.toString(), 0);
    }
  }
  
  private boolean d()
  {
    ScanTorchActivity localScanTorchActivity = this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity;
    return (localScanTorchActivity == null) || (localScanTorchActivity.isDestroyed);
  }
  
  public int a()
  {
    int i = 0;
    int j = 0;
    int[] arrayOfInt;
    for (;;)
    {
      arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      if (i >= arrayOfInt.length) {
        break;
      }
      j += arrayOfInt[i];
      i += 1;
    }
    return j / arrayOfInt.length;
  }
  
  public PromotionConfigInfo.PromotionItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem;
  }
  
  void a()
  {
    if (QQAudioHelper.a(5) != 1) {
      return;
    }
    Button localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.findViewById(2131365440);
    localButton.setVisibility(0);
    if (localButton.getTag() != null) {
      return;
    }
    localButton.setTag(new Object());
    localButton.setOnClickListener(new PromotionRes.4(this));
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(AppInterface paramAppInterface, PopupMenu paramPopupMenu) {}
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack.d())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "getRes,  需要显示穿越门进度条");
      this.jdField_a_of_type_Boolean = true;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRes, activityID[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], TotalProgress[");
    localStringBuilder.append(a());
    localStringBuilder.append("]");
    QLog.d(str, 1, localStringBuilder.toString());
    PromotionUtil.a(paramAppInterface).a(paramAppInterface, new PromotionRes.1(this, paramString, paramAppInterface));
  }
  
  public void a(PromotionRes.ARTransferPromotionResStatusCallBack paramARTransferPromotionResStatusCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack = paramARTransferPromotionResStatusCallBack;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfInt;
      if (i >= localObject.length) {
        break;
      }
      if ((localObject[i] >= 0) && (localObject[i] <= 99))
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isDownloading, index[");
        localStringBuilder.append(i);
        localStringBuilder.append("], Progress[");
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfInt[i]);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean a(AppInterface paramAppInterface)
  {
    Object localObject1 = a();
    if (localObject1 == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isResReady no promotion Item so reay");
      return true;
    }
    localObject1 = ((PromotionConfigInfo.PromotionItem)localObject1).a();
    int i = ((TreeMap)localObject1).size();
    Object localObject2;
    if (i + 1 > this.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkRes, zip数目不对, itemCount[");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("]");
      localObject2 = ((StringBuilder)localObject2).toString();
      QLog.w(jdField_a_of_type_JavaLangString, 1, (String)localObject2);
      if (QQAudioHelper.b()) {
        throw new IllegalStateException((String)localObject2);
      }
    }
    localObject1 = ((TreeMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PromotionConfigInfo.ZipItem)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if (PromotionResDownload.a(paramAppInterface.getCurrentAccountUin(), (PromotionConfigInfo.ZipItem)localObject2)) {
        this.jdField_a_of_type_ArrayOfInt[localObject2.a] = 100;
      } else {
        this.jdField_a_of_type_ArrayOfInt[localObject2.a] = 0;
      }
    }
    if (GestureRecognitionUtils.a()) {
      this.jdField_a_of_type_ArrayOfInt[3] = 100;
    } else {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
    }
    int j = a();
    paramAppInterface = jdField_a_of_type_JavaLangString;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("checkRes, itemCount[");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append("], Progress0[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfInt[0]);
    ((StringBuilder)localObject1).append("], Progress1[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfInt[1]);
    ((StringBuilder)localObject1).append("], Progress2[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfInt[2]);
    ((StringBuilder)localObject1).append("], Progress3[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfInt[3]);
    ((StringBuilder)localObject1).append("], TotalProgress[");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append("]");
    QLog.w(paramAppInterface, 1, ((StringBuilder)localObject1).toString());
    return j == 100;
  }
  
  public void b(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity = null;
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload$DownloadListener != null)
    {
      PromotionUtil.a(paramAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload$DownloadListener);
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload$DownloadListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr$GestureStatusListener != null) {
      GestureMgr.a().a(false, this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr$GestureStatusListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo$PromotionItem = null;
  }
  
  public boolean b()
  {
    if (a()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfInt;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i] < 0)
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isDownloadError, index[");
        localStringBuilder.append(i);
        localStringBuilder.append("], errCode[");
        localStringBuilder.append(this.jdField_a_of_type_ArrayOfInt[i]);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void c(AppInterface paramAppInterface)
  {
    PromotionConfigInfo.PromotionItem localPromotionItem = a();
    boolean bool2 = a();
    boolean bool1;
    if (!bool2) {
      bool1 = b();
    } else {
      bool1 = false;
    }
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reTry, promotionItem[");
    localStringBuilder.append(localPromotionItem);
    localStringBuilder.append("], isDownloading[");
    localStringBuilder.append(bool2);
    localStringBuilder.append("], isDownloadError[");
    localStringBuilder.append(bool1);
    localStringBuilder.append("], needShowDownloadProgress[");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("], TotalProgress[");
    localStringBuilder.append(a());
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = true;
    if (localPromotionItem == null) {
      return;
    }
    if (bool2) {
      return;
    }
    PromotionUtil.a(paramAppInterface).a(paramAppInterface, localPromotionItem.jdField_a_of_type_JavaLangString);
    a(paramAppInterface, this.jdField_a_of_type_ComTencentMobileqqOlympicActivityPromotionRes$ARTransferPromotionResStatusCallBack.d());
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void d(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload$DownloadListener != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr$GestureStatusListener = new PromotionRes.2(this, paramAppInterface);
    GestureMgr.a().a(true, this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr$GestureStatusListener);
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload$DownloadListener = new PromotionRes.3(this, paramAppInterface);
    PromotionUtil.a(paramAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload$DownloadListener);
  }
  
  public void e(AppInterface paramAppInterface)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onAREngineReady");
    a("onAREngineReady", paramAppInterface, false);
  }
  
  public void f(AppInterface paramAppInterface)
  {
    a("onAREngineReady", paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.PromotionRes
 * JD-Core Version:    0.7.0.1
 */