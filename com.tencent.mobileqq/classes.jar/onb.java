import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.qphone.base.util.QLog;

public class onb
  extends nmf
{
  private boolean b;
  
  onb(ReadInJoySettingActivity paramReadInJoySettingActivity, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {
      bkwm.a(bkwm.a(), this.b);
    }
    for (;;)
    {
      ReadInJoySettingActivity.a(this.a);
      return;
      QLog.d("ReadInJoySettingActivity", 1, "troopProtocolObserver fail!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onb
 * JD-Core Version:    0.7.0.1
 */