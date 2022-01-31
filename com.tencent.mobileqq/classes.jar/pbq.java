import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.biz.troop.VideoCombineHelper.Callback;
import com.tencent.biz.troop.VideoCombineHelper.CombineParams;
import com.tencent.biz.troop.VideoCombineHelper.Task;
import com.tencent.biz.troop.VideoCombineHelper.TaskListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class pbq
  extends VideoCombineHelper.TaskListener
{
  pbq(pbp parampbp)
  {
    super(parampbp.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper);
  }
  
  public void a(VideoCombineHelper.Task paramTask)
  {
    do
    {
      synchronized (this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.jdField_a_of_type_JavaLangObject)
      {
        this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.jdField_a_of_type_JavaUtilHashMap.remove(paramTask.c);
        if ((paramTask instanceof pce))
        {
          this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "download failed! msg = " + paramTask.d);
          return;
        }
      }
      if ((paramTask instanceof pbw))
      {
        this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "combine failed! msg = " + paramTask.d);
        return;
      }
    } while (!(paramTask instanceof pch));
    this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "sending failed! msg = " + paramTask.d);
  }
  
  public void b(VideoCombineHelper.Task paramTask)
  {
    VideoCombineHelper.CombineParams localCombineParams = paramTask.a();
    if (((paramTask instanceof pbw)) || (localCombineParams.b)) {}
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
 * Qualified Name:     pbq
 * JD-Core Version:    0.7.0.1
 */