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
    int i = this.this$0.a(this.jdField_a_of_type_JavaLangString, (DownloadListener)localObject);
    if ((i == 19) || (i == 0))
    {
      localObject = this.this$0.a.obtainMessage(20);
      ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
      this.this$0.a.sendMessage((Message)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("style download success , url : %s, position : %d ", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      this.this$0.b.remove(this.jdField_a_of_type_JavaLangString);
    }
    do
    {
      return;
      localObject = this.this$0.a.obtainMessage(21);
      ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
      this.this$0.a.sendMessage((Message)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("styles download fail , url : %s, position : %d ", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */