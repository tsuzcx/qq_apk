package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

final class RuleMemberValidator$MemberMustBeStatic
  implements RuleMemberValidator.RuleValidator
{
  public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
  {
    if (!paramFrameworkMember.isStatic()) {
      paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must be static."));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBeStatic
 * JD-Core Version:    0.7.0.1
 */