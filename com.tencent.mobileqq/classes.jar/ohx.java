import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity.13.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ohx
  extends altm
{
  public ohx(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverBiuActivity", 2, "current uin = " + paramString + " is success " + paramBoolean);
    }
    if (paramBoolean) {
      ThreadManager.getUIHandler().post(new ReadInJoyDeliverBiuActivity.13.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ohx
 * JD-Core Version:    0.7.0.1
 */