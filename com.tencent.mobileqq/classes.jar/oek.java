import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class oek
{
  private oem jdField_a_of_type_Oem;
  private swc jdField_a_of_type_Swc = new swc();
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Oem != null) {
      this.jdField_a_of_type_Oem.a(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (this.jdField_a_of_type_Oem != null) {
      this.jdField_a_of_type_Oem.a(paramPublishVideoEntry, paramString);
    }
  }
  
  public void a(String paramString)
  {
    swc.a(swc.a(paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = swc.a(paramString1);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Swc.a(paramString1, paramString2 + ".tmp.mp4", false, true, new oel(this, l, paramString1));
  }
  
  public void a(oem paramoem)
  {
    this.jdField_a_of_type_Oem = paramoem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oek
 * JD-Core Version:    0.7.0.1
 */