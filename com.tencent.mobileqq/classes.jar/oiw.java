import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class oiw
{
  private oiy jdField_a_of_type_Oiy;
  private upd jdField_a_of_type_Upd = new upd();
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Oiy != null) {
      this.jdField_a_of_type_Oiy.a(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (this.jdField_a_of_type_Oiy != null) {
      this.jdField_a_of_type_Oiy.a(paramPublishVideoEntry, paramString);
    }
  }
  
  public void a(String paramString)
  {
    upd.a(upd.a(paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = upd.a(paramString1);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Upd.a(paramString1, paramString2 + ".tmp.mp4", false, true, new oix(this, l, paramString1));
  }
  
  public void a(oiy paramoiy)
  {
    this.jdField_a_of_type_Oiy = paramoiy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oiw
 * JD-Core Version:    0.7.0.1
 */