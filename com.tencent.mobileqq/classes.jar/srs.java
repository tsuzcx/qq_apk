public class srs
{
  @vlq(a="oa_task_id")
  public int a;
  @vlq(a="bg_url")
  public String a;
  @vlq(a="is_comp_able")
  public boolean a;
  @vlq(a="comp_vid")
  public String b;
  @vlq(a="icon_url")
  public String c;
  
  public String toString()
  {
    return "CompInfoBase{, comparedVid='" + this.b + '\'' + ", isComparedAble=" + this.jdField_a_of_type_Boolean + ", iconUrl='" + this.c + '\'' + ", taskId=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srs
 * JD-Core Version:    0.7.0.1
 */