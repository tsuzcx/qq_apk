import com.tencent.biz.troop.VideoCombineHelper.Callback;
import com.tencent.biz.troop.VideoCombineHelper.CombineParams;
import com.tencent.biz.troop.VideoCombineHelper.Task;
import com.tencent.biz.troop.VideoCombineHelper.TaskListener;
import com.tencent.qphone.base.util.QLog;

class oww
  extends VideoCombineHelper.TaskListener
{
  oww(owv paramowv)
  {
    super(paramowv.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper);
  }
  
  public void a(VideoCombineHelper.Task paramTask)
  {
    if ((paramTask instanceof oxm)) {
      this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a("", false, "download failed! msg = " + paramTask.d);
    }
    do
    {
      return;
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
    if ((paramTask instanceof oxp))
    {
      paramTask = paramTask.a();
      this.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(paramTask.e, true, "seding success");
      QLog.d(".troop.trace_video_combine", 2, "totalTime = " + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oww
 * JD-Core Version:    0.7.0.1
 */