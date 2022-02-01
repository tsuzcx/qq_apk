package com.tencent.mobileqq.profile;

import android.os.Handler;
import com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;

class VipProfileCardPreviewActivity$8
  extends VipBaseUpsImageUploadTask
{
  VipProfileCardPreviewActivity$8(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    super(paramLong, paramString1, paramArrayOfByte, paramString2);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1001)
    {
      if (paramInt != 1002) {
        return;
      }
      this.b.q();
      paramVarArgs = this.b.y.obtainMessage(24, b());
      this.b.y.sendMessage(paramVarArgs);
      return;
    }
    this.b.q();
    if (a() != null) {
      this.b.a(this.a, (UpsImageUploadResult)a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */