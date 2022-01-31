import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class svb
  extends QQUIEventReceiver<suo, sxr>
{
  public svb(@NonNull suo paramsuo)
  {
    super(paramsuo);
  }
  
  public void a(@NonNull suo paramsuo, @NonNull sxr paramsxr)
  {
    if ((paramsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramsxr.jdField_a_of_type_JavaUtilList != null) && (!paramsxr.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramsuo.a.b(paramsxr);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(this.TAG, 2, "MsgTabStoryNodeDelegate#UpdateUserInfoEventReceiver errorInfo: " + paramsxr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramsxr.jdField_a_of_type_JavaUtilList);
  }
  
  public Class acceptEventClass()
  {
    return sxr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svb
 * JD-Core Version:    0.7.0.1
 */