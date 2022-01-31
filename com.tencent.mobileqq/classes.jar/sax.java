import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class sax
  extends akws
{
  sax(sau paramsau, sat paramsat) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
    }
    sau.b(this.jdField_a_of_type_Sau, this.jdField_a_of_type_Sat);
    StructLongMessageDownloadProcessor.a(sau.a(this.jdField_a_of_type_Sau), this.jdField_a_of_type_Sat.a);
    ((bajo)sau.a(this.jdField_a_of_type_Sau).getManager(132)).a(this.jdField_a_of_type_Sat.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Sat.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((sau.a(this.jdField_a_of_type_Sau) != null) && (sau.a(this.jdField_a_of_type_Sau).isResume())) {
      sau.a(this.jdField_a_of_type_Sau).b(false);
    }
  }
  
  public void b(Object paramObject)
  {
    sau.a(this.jdField_a_of_type_Sau);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sax
 * JD-Core Version:    0.7.0.1
 */