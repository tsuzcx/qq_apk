import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.VideoCombineHelper;
import com.tencent.biz.troop.VideoCombineHelper.CombineParams;
import com.tencent.biz.troop.VideoCombineHelper.Task;
import com.tencent.biz.troop.VideoCombineHelper.TaskListener;

public class pch
  extends VideoCombineHelper.Task
{
  public pch(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.TaskListener paramTaskListener, String paramString)
  {
    super(paramVideoCombineHelper, paramTaskListener, paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a.a();
    VideoCombineHelper.CombineParams localCombineParams = a();
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a.a(localCombineParams.e, localCombineParams.jdField_a_of_type_JavaLangString, localCombineParams.jdField_a_of_type_Int, new pci(this));
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this);
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Task = new pbv(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener, this.c);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pch
 * JD-Core Version:    0.7.0.1
 */