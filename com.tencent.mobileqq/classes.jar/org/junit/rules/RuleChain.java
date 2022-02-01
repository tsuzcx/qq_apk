package org.junit.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RuleChain
  implements TestRule
{
  private static final RuleChain EMPTY_CHAIN = new RuleChain(Collections.emptyList());
  private List<TestRule> rulesStartingWithInnerMost;
  
  private RuleChain(List<TestRule> paramList)
  {
    this.rulesStartingWithInnerMost = paramList;
  }
  
  public static RuleChain emptyRuleChain()
  {
    return EMPTY_CHAIN;
  }
  
  public static RuleChain outerRule(TestRule paramTestRule)
  {
    return emptyRuleChain().around(paramTestRule);
  }
  
  public Statement apply(Statement paramStatement, Description paramDescription)
  {
    Iterator localIterator = this.rulesStartingWithInnerMost.iterator();
    while (localIterator.hasNext()) {
      paramStatement = ((TestRule)localIterator.next()).apply(paramStatement, paramDescription);
    }
    return paramStatement;
  }
  
  public RuleChain around(TestRule paramTestRule)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramTestRule);
    localArrayList.addAll(this.rulesStartingWithInnerMost);
    return new RuleChain(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.rules.RuleChain
 * JD-Core Version:    0.7.0.1
 */