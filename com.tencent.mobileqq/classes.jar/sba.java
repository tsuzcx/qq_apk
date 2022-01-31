import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;

class sba
  extends akwt
{
  sba(sax paramsax, saw paramsaw) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "unfollow success");
    }
    sax.b(this.jdField_a_of_type_Sax, this.jdField_a_of_type_Saw);
    StructLongMessageDownloadProcessor.a(sax.a(this.jdField_a_of_type_Sax), this.jdField_a_of_type_Saw.a);
    ((baja)sax.a(this.jdField_a_of_type_Sax).getManager(132)).a(this.jdField_a_of_type_Saw.a);
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeedAdapter", 2, "do unfollow->uin:" + this.jdField_a_of_type_Saw.a + ", success:" + String.valueOf(paramBoolean));
    }
    if ((sax.a(this.jdField_a_of_type_Sax) != null) && (sax.a(this.jdField_a_of_type_Sax).isResume())) {
      sax.a(this.jdField_a_of_type_Sax).b(false);
    }
  }
  
  public void b(Object paramObject)
  {
    sax.a(this.jdField_a_of_type_Sax);
  }
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sba
 * JD-Core Version:    0.7.0.1
 */