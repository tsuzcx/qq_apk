import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class oen
{
  private oep jdField_a_of_type_Oep;
  private swf jdField_a_of_type_Swf = new swf();
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Oep != null) {
      this.jdField_a_of_type_Oep.a(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (this.jdField_a_of_type_Oep != null) {
      this.jdField_a_of_type_Oep.a(paramPublishVideoEntry, paramString);
    }
  }
  
  public void a(String paramString)
  {
    swf.a(swf.a(paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = swf.a(paramString1);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Swf.a(paramString1, paramString2 + ".tmp.mp4", false, true, new oeo(this, l, paramString1));
  }
  
  public void a(oep paramoep)
  {
    this.jdField_a_of_type_Oep = paramoep;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oen
 * JD-Core Version:    0.7.0.1
 */