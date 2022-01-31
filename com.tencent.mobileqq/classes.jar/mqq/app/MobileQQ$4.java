package mqq.app;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;

class MobileQQ$4
  implements Comparator<SimpleAccount>
{
  MobileQQ$4(MobileQQ paramMobileQQ) {}
  
  public int compare(SimpleAccount paramSimpleAccount1, SimpleAccount paramSimpleAccount2)
  {
    long l1 = this.this$0.string2Long(this.this$0.getProperty(paramSimpleAccount1.getUin() + Constants.Key._logintime));
    long l2 = this.this$0.string2Long(this.this$0.getProperty(paramSimpleAccount2.getUin() + Constants.Key._logintime));
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(MsfSdkUtils.getShortUin(paramSimpleAccount1.getUin())).append(' ').append(paramSimpleAccount1.isLogined()).append(' ').append(l1).append(' ');
    localStringBuilder.append(MsfSdkUtils.getShortUin(paramSimpleAccount2.getUin())).append(' ').append(paramSimpleAccount2.isLogined()).append(' ').append(l2);
    QLog.d("mqq", 1, localStringBuilder.toString());
    if (l2 > l1) {
      return 1;
    }
    if (l2 < l1) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MobileQQ.4
 * JD-Core Version:    0.7.0.1
 */