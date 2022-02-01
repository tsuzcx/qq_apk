package com.tencent.mobileqq.profile.upload.task;

import com.tencent.upload.uinterface.data.UpsImageUploadTask;

public class VipBaseUpsImageUploadTask
  extends VipBaseUploadTask
{
  public int A = 13;
  public String B;
  public long C;
  public int D;
  public int E;
  public int F;
  public int G = 3;
  public int H = 1;
  public String I;
  public byte[] J;
  protected String K;
  protected boolean L = false;
  
  public VipBaseUpsImageUploadTask() {}
  
  public VipBaseUpsImageUploadTask(long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    super(paramLong, paramString1, paramArrayOfByte);
    this.K = paramString2;
  }
  
  protected void a(int paramInt, Object... paramVarArgs) {}
  
  public VipBaseUploadTask h()
  {
    UpsImageUploadTask localUpsImageUploadTask = new UpsImageUploadTask(this.t);
    localUpsImageUploadTask.dataType = this.A;
    localUpsImageUploadTask.fileId = this.B;
    localUpsImageUploadTask.flowId = this.v;
    localUpsImageUploadTask.iBatchID = this.C;
    localUpsImageUploadTask.iBatchUploadCount = this.D;
    localUpsImageUploadTask.iBusiNessType = this.E;
    localUpsImageUploadTask.iCurrentUploadOrder = this.F;
    localUpsImageUploadTask.iSync = this.k;
    localUpsImageUploadTask.iUin = this.r;
    localUpsImageUploadTask.iUploadType = this.G;
    localUpsImageUploadTask.keepRaw = this.H;
    localUpsImageUploadTask.md5 = this.u;
    localUpsImageUploadTask.preupload = this.m;
    localUpsImageUploadTask.reportRefer = this.l;
    localUpsImageUploadTask.sBusinessId = this.K;
    localUpsImageUploadTask.sCommand = this.I;
    localUpsImageUploadTask.sRefer = this.n;
    localUpsImageUploadTask.transferData = this.o;
    localUpsImageUploadTask.uiRefer = this.p;
    localUpsImageUploadTask.uploadTaskCallback = this.w;
    localUpsImageUploadTask.vBusiNessData = this.J;
    localUpsImageUploadTask.vLoginData = this.q;
    this.y = localUpsImageUploadTask;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask
 * JD-Core Version:    0.7.0.1
 */