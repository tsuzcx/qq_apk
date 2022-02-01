import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class pgq
{
  private int jdField_a_of_type_Int;
  private ArrayList<pgp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_a_of_type_Boolean;
  
  private void i()
  {
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      pgp localpgp = (pgp)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Boolean)
      {
        localpgp.h();
        return;
      }
      localpgp.g();
      return;
    }
    QLog.d("RIJPopupAutomator", 2, "startNext currentIndex out of bound");
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((pgp)localIterator.next()).a();
    }
  }
  
  void a(pgp parampgp, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJPopupAutomator", 2, "finishStep(" + parampgp.toString() + "): isShown = " + paramBoolean);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(paramBoolean);
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Int += 1;
      i();
    }
  }
  
  public void a(pgp... paramVarArgs)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(Arrays.asList(paramVarArgs));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((pgp)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((pgp)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((pgp)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((pgp)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((pgp)localIterator.next()).f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgq
 * JD-Core Version:    0.7.0.1
 */