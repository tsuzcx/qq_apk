import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class ssn
  extends amni
{
  ssn(ssk paramssk, ssj paramssj) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
    }
    ssk.b(this.jdField_a_of_type_Ssk, this.jdField_a_of_type_Ssj);
    StructLongMessageDownloadProcessor.a(ssk.a(this.jdField_a_of_type_Ssk), this.jdField_a_of_type_Ssj.a);
    ((bcic)ssk.a(this.jdField_a_of_type_Ssk).getManager(132)).a(this.jdField_a_of_type_Ssj.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Ssj.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((ssk.a(this.jdField_a_of_type_Ssk) != null) && (ssk.a(this.jdField_a_of_type_Ssk).isResume())) {
      ssk.a(this.jdField_a_of_type_Ssk).b(false);
    }
  }
  
  public void b(Object paramObject)
  {
    ssk.a(this.jdField_a_of_type_Ssk);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ssn
 * JD-Core Version:    0.7.0.1
 */