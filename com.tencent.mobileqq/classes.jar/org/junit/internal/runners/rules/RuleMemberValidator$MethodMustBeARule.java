package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

final class RuleMemberValidator$MethodMustBeARule
  implements RuleMemberValidator.RuleValidator
{
  public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
  {
    if (!RuleMemberValidator.access$1300(paramFrameworkMember)) {
      paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must return an implementation of MethodRule or TestRule."));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.rules.RuleMemberValidator.MethodMustBeARule
 * JD-Core Version:    0.7.0.1
 */