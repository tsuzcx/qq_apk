package com.tencent.mobileqq.profile;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class VipProfileCardPreviewActivity$4
  implements Runnable
{
  VipProfileCardPreviewActivity$4(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = new VipProfileCardPreviewActivity.4.1(this);
    int i = this.this$0.a(this.b, (DownloadListener)localObject);
    if ((i != 19) && (i != 0))
    {
      localObject = this.this$0.y.obtainMessage(21);
      ((Message)localObject).arg1 = this.a;
      this.this$0.y.sendMessage((Message)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("styles download fail , url : %s, position : %d ", new Object[] { this.b, Integer.valueOf(this.a) }));
      }
    }
    else
    {
      localObject = this.this$0.y.obtainMessage(20);
      ((Message)localObject).arg1 = this.a;
      this.this$0.y.sendMessage((Message)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("style download success , url : %s, position : %d ", new Object[] { this.b, Integer.valueOf(this.a) }));
      }
      this.this$0.ai.remove(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */