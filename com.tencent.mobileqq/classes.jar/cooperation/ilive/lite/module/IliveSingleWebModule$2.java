package cooperation.ilive.lite.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class IliveSingleWebModule$2
  implements Runnable
{
  IliveSingleWebModule$2(IliveSingleWebModule paramIliveSingleWebModule, Bundle paramBundle) {}
  
  public void run()
  {
    String str = this.a.getString("reload_url");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reloadUrl = ");
      localStringBuilder.append(str);
      QLog.i("IliveSingleWebModule", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(str)) {
      IliveSingleWebModule.a(this.this$0, str);
    }
    IliveSingleWebModule.a(true);
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveSingleWebModule.2
 * JD-Core Version:    0.7.0.1
 */