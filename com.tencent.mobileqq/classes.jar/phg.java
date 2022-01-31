public class phg
  implements Comparable, Runnable
{
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  
  public phg(Runnable paramRunnable, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(phg paramphg)
  {
    boolean bool;
    if (paramphg != null)
    {
      bool = paramphg.jdField_a_of_type_Boolean;
      if ((!this.jdField_a_of_type_Boolean) || (!bool)) {
        break label27;
      }
    }
    label27:
    do
    {
      return 0;
      bool = false;
      break;
      if ((this.jdField_a_of_type_Boolean) && (!bool)) {
        return 1;
      }
    } while (!bool);
    return -1;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     phg
 * JD-Core Version:    0.7.0.1
 */