import android.os.Handler;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.ProgressStatus.1;

public class sjf
{
  public int a;
  private Runnable a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  private boolean b;
  
  private sjf(sje paramsje)
  {
    this.jdField_a_of_type_JavaLangRunnable = new StoryVideoUploadProgressManager.ProgressStatus.1(this);
  }
  
  private void c()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          do
          {
            return;
            this.jdField_b_of_type_Int = 0;
            return;
            this.jdField_b_of_type_Int += 1;
          } while (this.jdField_b_of_type_Int < 60);
          this.jdField_b_of_type_Int = 59;
          return;
          this.jdField_b_of_type_Int += 1;
        } while (this.jdField_b_of_type_Int < 95);
        this.jdField_b_of_type_Int = 94;
        return;
        this.jdField_b_of_type_Int += 1;
      } while (this.jdField_b_of_type_Int < 100);
      this.jdField_b_of_type_Int = 99;
      return;
    }
    this.jdField_b_of_type_Int = 100;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    sje.a(this.jdField_a_of_type_Sje).postDelayed(this.jdField_a_of_type_JavaLangRunnable, 200L);
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = true;
    sje.a(this.jdField_a_of_type_Sje).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sjf
 * JD-Core Version:    0.7.0.1
 */