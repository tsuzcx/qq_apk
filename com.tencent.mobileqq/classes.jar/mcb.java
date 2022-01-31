import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.qphone.base.util.QLog;

public final class mcb
  extends PublicAccountObserver
{
  public mcb(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsHelper", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean + ", isUGC=" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcb
 * JD-Core Version:    0.7.0.1
 */