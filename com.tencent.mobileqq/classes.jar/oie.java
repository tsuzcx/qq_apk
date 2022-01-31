import com.tencent.biz.qqstory.takevideo.EditPicSave;

public class oie
  implements Runnable
{
  public oie(EditPicSave paramEditPicSave) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    EditPicSave localEditPicSave = this.a;
    localEditPicSave.jdField_a_of_type_Int += this.a.b;
    if (this.a.jdField_a_of_type_Int > 99)
    {
      this.a.jdField_a_of_type_Int = 99;
      this.a.a(this.a.jdField_a_of_type_Int);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_Int);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oie
 * JD-Core Version:    0.7.0.1
 */