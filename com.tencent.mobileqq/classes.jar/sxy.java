import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class sxy
  extends QQUIEventReceiver<sxw, sxv>
{
  public sxy(sxw paramsxw)
  {
    super(paramsxw);
  }
  
  public void a(@NonNull sxw paramsxw, @NonNull sxv paramsxv)
  {
    if (paramsxw.a()) {}
    do
    {
      return;
      if (paramsxv.jdField_a_of_type_Boolean)
      {
        sxw.a(paramsxw);
        return;
      }
      if ((paramsxv.a() != null) && (!paramsxv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("HaloResponseReceiver", 2, "onEvent: failed. Message: exception: " + paramsxv.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    return;
    sxw.a(paramsxw);
  }
  
  public Class acceptEventClass()
  {
    return sxv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sxy
 * JD-Core Version:    0.7.0.1
 */