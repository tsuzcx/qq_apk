package junit.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;

public class JUnit4TestAdapterCache
  extends HashMap<Description, Test>
{
  private static final JUnit4TestAdapterCache fInstance = new JUnit4TestAdapterCache();
  private static final long serialVersionUID = 1L;
  
  public static JUnit4TestAdapterCache getDefault()
  {
    return fInstance;
  }
  
  public Test asTest(Description paramDescription)
  {
    if (paramDescription.isSuite()) {
      return createTest(paramDescription);
    }
    if (!containsKey(paramDescription)) {
      put(paramDescription, createTest(paramDescription));
    }
    return (Test)get(paramDescription);
  }
  
  public List<Test> asTestList(Description paramDescription)
  {
    if (paramDescription.isTest()) {
      return Arrays.asList(new Test[] { asTest(paramDescription) });
    }
    ArrayList localArrayList = new ArrayList();
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext()) {
      localArrayList.add(asTest((Description)paramDescription.next()));
    }
    return localArrayList;
  }
  
  Test createTest(Description paramDescription)
  {
    if (paramDescription.isTest()) {
      return new JUnit4TestCaseFacade(paramDescription);
    }
    TestSuite localTestSuite = new TestSuite(paramDescription.getDisplayName());
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext()) {
      localTestSuite.addTest(asTest((Description)paramDescription.next()));
    }
    return localTestSuite;
  }
  
  public RunNotifier getNotifier(TestResult paramTestResult, JUnit4TestAdapter paramJUnit4TestAdapter)
  {
    paramJUnit4TestAdapter = new RunNotifier();
    paramJUnit4TestAdapter.addListener(new JUnit4TestAdapterCache.1(this, paramTestResult));
    return paramJUnit4TestAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     junit.framework.JUnit4TestAdapterCache
 * JD-Core Version:    0.7.0.1
 */