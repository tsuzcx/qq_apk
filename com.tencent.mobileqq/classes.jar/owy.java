import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.biz.troop.VideoCombineHelper.Callback;
import com.tencent.biz.troop.VideoCombineHelper.CombineParams;
import com.tencent.biz.troop.VideoCombineHelper.Task;
import com.tencent.biz.troop.VideoCombineHelper.TaskListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class owy
  extends VideoCombineHelper.TaskListener
{
  owy(owx paramowx)
  {
    super(paramowx.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper);
  }
  
  public void a(VideoCombineHelper.Task paramTask)
  {
    do
    {
      synchronized (this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.jdField_a_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.jdField_a_of_type_JavaUtilHashMap.remove(paramTask.c);
        if ((paramTask instanceof oxm))
        {
          this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "download failed! msg = " + paramTask.d);
          return;
        }
      }
      if ((paramTask instanceof oxe))
      {
        this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "combine failed! msg = " + paramTask.d);
        return;
      }
    } while (!(paramTask instanceof oxp));
    this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "sending failed! msg = " + paramTask.d);
  }
  
  public void b(VideoCombineHelper.Task paramTask)
  {
    VideoCombineHelper.CombineParams localCombineParams = paramTask.a();
    if (((paramTask instanceof oxe)) || (localCombineParams.b)) {}
    synchronized (this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.jdField_a_of_type_JavaLangObject)
    {
      this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.jdField_a_of_type_JavaUtilHashMap.remove(paramTask.c);
      this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(localCombineParams.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owy
 * JD-Core Version:    0.7.0.1
 */