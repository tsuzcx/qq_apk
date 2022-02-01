package org.junit.experimental.theories;

import java.lang.reflect.Constructor;
import java.util.List;
import org.junit.Assume;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

class Theories$TheoryAnchor$1
  extends BlockJUnit4ClassRunner
{
  Theories$TheoryAnchor$1(Theories.TheoryAnchor paramTheoryAnchor, Class paramClass, Assignments paramAssignments)
  {
    super(paramClass);
  }
  
  protected void collectInitializationErrors(List<Throwable> paramList) {}
  
  public Object createTest()
  {
    Object[] arrayOfObject = this.val$complete.getConstructorArguments();
    if (!Theories.TheoryAnchor.access$000(this.this$0)) {
      Assume.assumeNotNull(arrayOfObject);
    }
    return getTestClass().getOnlyConstructor().newInstance(arrayOfObject);
  }
  
  public Statement methodBlock(FrameworkMethod paramFrameworkMethod)
  {
    return new Theories.TheoryAnchor.1.1(this, super.methodBlock(paramFrameworkMethod));
  }
  
  protected Statement methodInvoker(FrameworkMethod paramFrameworkMethod, Object paramObject)
  {
    return Theories.TheoryAnchor.access$100(this.this$0, paramFrameworkMethod, this.val$complete, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.experimental.theories.Theories.TheoryAnchor.1
 * JD-Core Version:    0.7.0.1
 */