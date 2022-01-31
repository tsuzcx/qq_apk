import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class roj
  extends akih
{
  roj(rog paramrog, rof paramrof) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
    }
    rog.b(this.jdField_a_of_type_Rog, this.jdField_a_of_type_Rof);
    StructLongMessageDownloadProcessor.a(rog.a(this.jdField_a_of_type_Rog), this.jdField_a_of_type_Rof.a);
    ((azhx)rog.a(this.jdField_a_of_type_Rog).getManager(132)).a(this.jdField_a_of_type_Rof.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Rof.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((rog.a(this.jdField_a_of_type_Rog) != null) && (rog.a(this.jdField_a_of_type_Rog).isResume())) {
      rog.a(this.jdField_a_of_type_Rog).b(false);
    }
  }
  
  public void b(Object paramObject)
  {
    rog.a(this.jdField_a_of_type_Rog);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     roj
 * JD-Core Version:    0.7.0.1
 */