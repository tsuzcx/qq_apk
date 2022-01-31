package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.util.List;
import org.junit.ClassRule;
import org.junit.runners.model.FrameworkMember;

final class RuleMemberValidator$MemberMustBeNonStaticOrAlsoClassRule
  implements RuleMemberValidator.RuleValidator
{
  public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
  {
    boolean bool = RuleMemberValidator.access$1200(paramFrameworkMember);
    int i;
    if (paramFrameworkMember.getAnnotation(ClassRule.class) != null)
    {
      i = 1;
      if ((paramFrameworkMember.isStatic()) && ((bool) || (i == 0))) {
        if (!RuleMemberValidator.access$1200(paramFrameworkMember)) {
          break label71;
        }
      }
    }
    label71:
    for (String str = "must not be static.";; str = "must not be static or it must be annotated with @ClassRule.")
    {
      paramList.add(new ValidationError(paramFrameworkMember, paramClass, str));
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.internal.runners.rules.RuleMemberValidator.MemberMustBeNonStaticOrAlsoClassRule
 * JD-Core Version:    0.7.0.1
 */