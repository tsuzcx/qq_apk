import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class ntd
{
  private ntf jdField_a_of_type_Ntf;
  private sjj jdField_a_of_type_Sjj = new sjj();
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Ntf != null) {
      this.jdField_a_of_type_Ntf.a(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (this.jdField_a_of_type_Ntf != null) {
      this.jdField_a_of_type_Ntf.a(paramPublishVideoEntry, paramString);
    }
  }
  
  public void a(String paramString)
  {
    sjj.a(sjj.a(paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = sjj.a(paramString1);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Sjj.a(paramString1, paramString2 + ".tmp.mp4", false, true, new nte(this, l, paramString1));
  }
  
  public void a(ntf paramntf)
  {
    this.jdField_a_of_type_Ntf = paramntf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ntd
 * JD-Core Version:    0.7.0.1
 */