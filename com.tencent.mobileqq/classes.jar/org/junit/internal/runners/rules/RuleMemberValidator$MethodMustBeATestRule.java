package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

final class RuleMemberValidator$MethodMustBeATestRule
  implements RuleMemberValidator.RuleValidator
{
  public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
  {
    if (!RuleMemberValidator.access$1400(paramFrameworkMember)) {
      paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must return an implementation of TestRule."));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.rules.RuleMemberValidator.MethodMustBeATestRule
 * JD-Core Version:    0.7.0.1
 */