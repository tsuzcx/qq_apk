package com.tencent.mobileqq.winkpublish.task;

import android.os.Handler;
import android.os.Looper;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qcircle.api.db.util.SmartParcelable;
import com.tencent.mobileqq.winkpublish.common.AUploadBusinessLooper;
import com.tencent.mobileqq.winkpublish.common.AUploadProtocolService;
import com.tencent.mobileqq.winkpublish.common.IUploadProtocolListener;
import com.tencent.mobileqq.winkpublish.common.IUploadServiceListener;
import com.tencent.mobileqq.winkpublish.request.AUploadRequest;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class AUploadTask
  implements SmartParcelable, IUploadProtocolListener
{
  static final String ab = "com.tencent.mobileqq.winkpublish.task.AUploadTask";
  public static boolean ag = false;
  protected static final AUploadProtocolService ah = AUploadProtocolService.a();
  private static Handler b = new Handler(Looper.getMainLooper());
  private WeakReference<Handler> a;
  public transient UniAttribute ac;
  public transient IUploadServiceListener ad;
  @NeedParcel
  public transient String ae = "";
  @NeedParcel
  public int af;
  @NeedParcel
  public AUploadRequest ai;
  @NeedParcel
  public int aj;
  @NeedParcel
  public HashMap<Object, Object> ak = new HashMap();
  @NeedParcel
  public String al;
  @NeedParcel
  public int am;
  public long an;
  
  public AUploadTask()
  {
    this.an = System.currentTimeMillis();
  }
  
  public AUploadTask(AUploadRequest paramAUploadRequest, Handler paramHandler, IUploadServiceListener paramIUploadServiceListener, int paramInt)
  {
    this.ai = paramAUploadRequest;
    this.aj = paramInt;
    this.ad = paramIUploadServiceListener;
    this.an = System.currentTimeMillis();
    if (paramHandler != null) {
      this.a = new WeakReference(paramHandler);
    }
  }
  
  private String b(int paramInt)
  {
    switch (paramInt)
    {
    case 1000005: 
    default: 
      return "";
    case 1000006: 
      String str = ab;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ab);
      localStringBuilder.append("\t 网络无连接");
      QLog.i(str, 1, localStringBuilder.toString());
      return QCircleConfigHelper.a("QZoneTextSetting", "NetWorkNotConnect", "网络无连接");
    }
    return "";
  }
  
  public void a(UniAttribute paramUniAttribute, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    this.ac = paramUniAttribute;
    this.af = paramInt1;
    this.ae = paramString;
    if (1000006 == paramInt1) {
      this.ae = QCircleConfigHelper.a("QZoneTextSetting", "NetWorkNotConnect", "网络无连接");
    }
    if (paramBoolean)
    {
      n();
      return;
    }
    AUploadBusinessLooper.a().b(this);
  }
  
  public void n()
  {
    Object localObject = this.ai;
    if (localObject != null)
    {
      ((AUploadRequest)localObject).a(this.am);
      if (ag)
      {
        localObject = new StringBuilder();
        if (this.ai.q != null) {
          this.ai.q.display((StringBuilder)localObject, 0);
        }
      }
    }
    int i = ah.a(this.ai, this);
    if (i != 0) {
      a(null, i, i, b(i), false);
    }
  }
  
  public boolean o()
  {
    int i = this.af;
    return ((i == 0) || ((Math.abs(i) <= 19999) && (Math.abs(this.af) >= 19000))) && (this.ac != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.AUploadTask
 * JD-Core Version:    0.7.0.1
 */