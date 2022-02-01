package cooperation.weiyun;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.WeiyunCallback;
import mqq.os.MqqHandler;

class WeiyunAIOUtils$WeiyunCallbackImpl
  implements WeiYunLogicCenter.WeiyunCallback
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public MqqHandler a;
  
  public WeiyunAIOUtils$WeiyunCallbackImpl(MqqHandler paramMqqHandler, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(101, paramInt, 0, paramString), 1500L);
      return;
    }
    ThreadManager.getUIHandler().post(new WeiyunAIOUtils.WeiyunCallbackImpl.2(this, paramString));
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(100, 1500L);
      return;
    }
    ThreadManager.getUIHandler().post(new WeiyunAIOUtils.WeiyunCallbackImpl.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils.WeiyunCallbackImpl
 * JD-Core Version:    0.7.0.1
 */