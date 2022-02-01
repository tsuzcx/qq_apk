import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class ooa
{
  private ooc jdField_a_of_type_Ooc;
  private wmk jdField_a_of_type_Wmk = new wmk();
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Ooc != null) {
      this.jdField_a_of_type_Ooc.a(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (this.jdField_a_of_type_Ooc != null) {
      this.jdField_a_of_type_Ooc.a(paramPublishVideoEntry, paramString);
    }
  }
  
  public void a(String paramString)
  {
    wmk.a(wmk.a(paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = wmk.a(paramString1);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Wmk.a(paramString1, paramString2 + ".tmp.mp4", false, true, new oob(this, l, paramString1));
  }
  
  public void a(ooc paramooc)
  {
    this.jdField_a_of_type_Ooc = paramooc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ooa
 * JD-Core Version:    0.7.0.1
 */