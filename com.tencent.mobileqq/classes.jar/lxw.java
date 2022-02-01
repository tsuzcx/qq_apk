import com.tencent.av.share.AVSchema;
import com.tencent.qphone.base.util.QLog;

public class lxw
  implements acxa
{
  public lxw(AVSchema paramAVSchema, long paramLong) {}
  
  public void onAfterStartActivity()
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema.a, 1, "joinVideoChat.onAfterStartActivity, isDetached[" + this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached() + "], seq[" + this.jdField_a_of_type_Long + "]");
    this.jdField_a_of_type_ComTencentAvShareAVSchema.b();
  }
  
  public void onBeforeStartActivity()
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema.a, 1, "joinVideoChat.onBeforeStartActivity, isDetached[" + this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached() + "], seq[" + this.jdField_a_of_type_Long + "]");
  }
  
  public void onCancel()
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvShareAVSchema.a, 1, "joinVideoChat.onCancel, isDetached[" + this.jdField_a_of_type_ComTencentAvShareAVSchema.isDetached() + "], seq[" + this.jdField_a_of_type_Long + "]");
    this.jdField_a_of_type_ComTencentAvShareAVSchema.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lxw
 * JD-Core Version:    0.7.0.1
 */