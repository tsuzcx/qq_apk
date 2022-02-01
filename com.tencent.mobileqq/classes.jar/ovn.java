import com.tencent.biz.qqstory.database.PublishVideoEntry;

public class ovn
{
  private ovp jdField_a_of_type_Ovp;
  private wip jdField_a_of_type_Wip = new wip();
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Ovp != null) {
      this.jdField_a_of_type_Ovp.a(paramPublishVideoEntry, paramInt, paramString);
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (this.jdField_a_of_type_Ovp != null) {
      this.jdField_a_of_type_Ovp.a(paramPublishVideoEntry, paramString);
    }
  }
  
  public void a(String paramString)
  {
    wip.a(wip.a(paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = wip.a(paramString1);
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Wip.a(paramString1, paramString2 + ".tmp.mp4", false, true, new ovo(this, l, paramString1));
  }
  
  public void a(ovp paramovp)
  {
    this.jdField_a_of_type_Ovp = paramovp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovn
 * JD-Core Version:    0.7.0.1
 */