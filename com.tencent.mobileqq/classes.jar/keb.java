import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.GetRedBag;
import com.tencent.qphone.base.util.QLog;

public class keb
  implements key
{
  public keb(AVRedBagMgr paramAVRedBagMgr) {}
  
  public void a(GetRedBag paramGetRedBag)
  {
    if (paramGetRedBag == this.a.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag)
    {
      this.a.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag = null;
      this.a.jdField_a_of_type_Key = null;
      this.a.a("onGetRedBagResult", AVRedBagMgr.d(this.a), paramGetRedBag.a);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + paramGetRedBag + "], src[" + this.a.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     keb
 * JD-Core Version:    0.7.0.1
 */