package cooperation.weiyun;

import android.os.Bundle;
import android.os.Process;
import aspy;
import aspz;
import ayzl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

public final class ResponseHandler$1
  implements Runnable
{
  public ResponseHandler$1(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    aspy localaspy = new aspy(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.jdField_a_of_type_Int, -5023, 2424833, ayzl.a());
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 1);
    ((Bundle)localObject).putString("key_action_DATA", this.d);
    localaspy.a(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int + this.e.length(), (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaspy);
    aspz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.ResponseHandler.1
 * JD-Core Version:    0.7.0.1
 */