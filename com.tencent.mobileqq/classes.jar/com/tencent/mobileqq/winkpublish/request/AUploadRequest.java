package com.tencent.mobileqq.winkpublish.request;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qcircle.api.db.util.NeedParcel;
import com.tencent.mobileqq.qcircle.api.db.util.SmartParcelable;
import com.tencent.mobileqq.winkpublish.common.IUploadProtocolListener;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.queue.IUploadQueueListener;
import java.util.HashMap;

public abstract class AUploadRequest
  implements SmartParcelable
{
  public static String n = "QzoneNewService.";
  private String a;
  @NeedParcel
  private String b;
  @NeedParcel
  private int c;
  @NeedParcel
  private boolean d;
  @NeedParcel
  private long e;
  private String f;
  protected String m;
  public transient IUploadProtocolListener o;
  @NeedParcel
  protected HashMap<Object, Object> p;
  @NeedParcel
  public JceStruct q;
  protected volatile boolean r;
  protected IUploadQueueListener s;
  
  public AUploadRequest()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("[upload2]AUploadRequest");
    this.m = localStringBuilder.toString();
    this.a = n;
    this.p = new HashMap();
    this.r = false;
  }
  
  public AUploadRequest(String paramString)
  {
    this(paramString, false);
    this.m = getClass().getSimpleName();
  }
  
  public AUploadRequest(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("[upload2]AUploadRequest");
    this.m = localStringBuilder.toString();
    this.a = n;
    this.p = new HashMap();
    this.r = false;
    this.b = paramString;
    this.d = paramBoolean;
    this.e = System.currentTimeMillis();
    this.m = getClass().getSimpleName();
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(IUploadProtocolListener paramIUploadProtocolListener)
  {
    this.o = paramIUploadProtocolListener;
  }
  
  public void a(IUploadQueueListener paramIUploadQueueListener)
  {
    this.s = paramIUploadQueueListener;
  }
  
  public void c(String paramString)
  {
    this.f = paramString;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public String e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.request.AUploadRequest
 * JD-Core Version:    0.7.0.1
 */