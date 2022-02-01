package org.junit.experimental.max;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestSuite;
import org.junit.internal.requests.SortingRequest;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runners.Suite;

public class MaxCore
{
  private static final String MALFORMED_JUNIT_3_TEST_CLASS_PREFIX = "malformed JUnit 3 test class: ";
  private final MaxHistory history;
  
  private MaxCore(File paramFile)
  {
    this.history = MaxHistory.forFolder(paramFile);
  }
  
  private Runner buildRunner(Description paramDescription)
  {
    if (paramDescription.toString().equals("TestSuite with 0 tests")) {
      return Suite.emptySuite();
    }
    if (paramDescription.toString().startsWith("malformed JUnit 3 test class: ")) {
      return new JUnit38ClassRunner(new TestSuite(getMalformedTestClass(paramDescription)));
    }
    Class localClass = paramDescription.getTestClass();
    if (localClass == null) {
      throw new RuntimeException("Can't build a runner from description [" + paramDescription + "]");
    }
    paramDescription = paramDescription.getMethodName();
    if (paramDescription == null) {
      return Request.aClass(localClass).getRunner();
    }
    return Request.method(localClass, paramDescription).getRunner();
  }
  
  private Request constructLeafRequest(List<Description> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(buildRunner((Description)paramList.next()));
    }
    return new MaxCore.1(this, localArrayList);
  }
  
  private List<Description> findLeaves(Request paramRequest)
  {
    ArrayList localArrayList = new ArrayList();
    findLeaves(null, paramRequest.getRunner().getDescription(), localArrayList);
    return localArrayList;
  }
  
  private void findLeaves(Description paramDescription1, Description paramDescription2, List<Description> paramList)
  {
    if (paramDescription2.getChildren().isEmpty()) {
      if (paramDescription2.toString().equals("warning(junit.framework.TestSuite$1)")) {
        paramList.add(Description.createSuiteDescription("malformed JUnit 3 test class: " + paramDescription1, new Annotation[0]));
      }
    }
    for (;;)
    {
      return;
      paramList.add(paramDescription2);
      return;
      paramDescription1 = paramDescription2.getChildren().iterator();
      while (paramDescription1.hasNext()) {
        findLeaves(paramDescription2, (Description)paramDescription1.next(), paramList);
      }
    }
  }
  
  @Deprecated
  public static MaxCore forFolder(String paramString)
  {
    return storedLocally(new File(paramString));
  }
  
  private Class<?> getMalformedTestClass(Description paramDescription)
  {
    try
    {
      paramDescription = Class.forName(paramDescription.toString().replace("malformed JUnit 3 test class: ", ""));
      return paramDescription;
    }
    catch (ClassNotFoundException paramDescription) {}
    return null;
  }
  
  public static MaxCore storedLocally(File paramFile)
  {
    return new MaxCore(paramFile);
  }
  
  public Result run(Class<?> paramClass)
  {
    return run(Request.aClass(paramClass));
  }
  
  public Result run(Request paramRequest)
  {
    return run(paramRequest, new JUnitCore());
  }
  
  public Result run(Request paramRequest, JUnitCore paramJUnitCore)
  {
    paramJUnitCore.addListener(this.history.listener());
    return paramJUnitCore.run(sortRequest(paramRequest).getRunner());
  }
  
  public Request sortRequest(Request paramRequest)
  {
    if ((paramRequest instanceof SortingRequest)) {
      return paramRequest;
    }
    paramRequest = findLeaves(paramRequest);
    Collections.sort(paramRequest, this.history.testComparator());
    return constructLeafRequest(paramRequest);
  }
  
  public List<Description> sortedLeavesForTest(Request paramRequest)
  {
    return findLeaves(sortRequest(paramRequest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.experimental.max.MaxCore
 * JD-Core Version:    0.7.0.1
 */