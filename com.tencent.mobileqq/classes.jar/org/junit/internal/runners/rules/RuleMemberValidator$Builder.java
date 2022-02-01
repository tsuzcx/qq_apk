package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

class RuleMemberValidator$Builder
{
  private final Class<? extends Annotation> annotation;
  private boolean methods;
  private final List<RuleMemberValidator.RuleValidator> validators;
  
  private RuleMemberValidator$Builder(Class<? extends Annotation> paramClass)
  {
    this.annotation = paramClass;
    this.methods = false;
    this.validators = new ArrayList();
  }
  
  RuleMemberValidator build()
  {
    return new RuleMemberValidator(this);
  }
  
  Builder forMethods()
  {
    this.methods = true;
    return this;
  }
  
  Builder withValidator(RuleMemberValidator.RuleValidator paramRuleValidator)
  {
    this.validators.add(paramRuleValidator);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.rules.RuleMemberValidator.Builder
 * JD-Core Version:    0.7.0.1
 */