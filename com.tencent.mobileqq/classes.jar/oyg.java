import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class oyg
{
  private int jdField_a_of_type_Int;
  private ArrayList<oyf> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  private void i()
  {
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      oyf localoyf = (oyf)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Boolean)
      {
        localoyf.h();
        return;
      }
      localoyf.g();
      return;
    }
    QLog.d("RIJPopupAutomator", 2, "startNext currentIndex out of bound");
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((oyf)localIterator.next()).a();
    }
  }
  
  void a(oyf paramoyf, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJPopupAutomator", 2, "finishStep(" + paramoyf.toString() + "): isShown = " + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Int += 1;
      i();
    }
  }
  
  public void a(oyf... paramVarArgs)
  {
    this.jdField_a_of_type_JavaUtilArrayList.addAll(Arrays.asList(paramVarArgs));
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((oyf)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((oyf)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((oyf)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((oyf)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((oyf)localIterator.next()).f();
    }
  }
  
  public void g()
  {
    QLog.d("RIJPopupAutomator", 1, "startStepFromOnResume");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    i();
  }
  
  public void h()
  {
    QLog.d("RIJPopupAutomator", 1, "startStepFromOnShowSelf");
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = true;
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oyg
 * JD-Core Version:    0.7.0.1
 */