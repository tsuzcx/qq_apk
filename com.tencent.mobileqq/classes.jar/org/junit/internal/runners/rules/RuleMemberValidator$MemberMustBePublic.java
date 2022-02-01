package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

final class RuleMemberValidator$MemberMustBePublic
  implements RuleMemberValidator.RuleValidator
{
  public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
  {
    if (!paramFrameworkMember.isPublic()) {
      paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must be public."));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBePublic
 * JD-Core Version:    0.7.0.1
 */