package junit.extensions;

import junit.framework.Protectable;
import junit.framework.TestResult;

class TestSetup$1
  implements Protectable
{
  TestSetup$1(TestSetup paramTestSetup, TestResult paramTestResult) {}
  
  public void protect()
  {
    this.this$0.setUp();
    this.this$0.basicRun(this.val$result);
    this.this$0.tearDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     junit.extensions.TestSetup.1
 * JD-Core Version:    0.7.0.1
 */