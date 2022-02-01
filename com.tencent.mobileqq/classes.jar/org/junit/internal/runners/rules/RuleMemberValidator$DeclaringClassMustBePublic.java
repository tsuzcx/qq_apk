package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

final class RuleMemberValidator$DeclaringClassMustBePublic
  implements RuleMemberValidator.RuleValidator
{
  private boolean isDeclaringClassPublic(FrameworkMember<?> paramFrameworkMember)
  {
    return Modifier.isPublic(paramFrameworkMember.getDeclaringClass().getModifiers());
  }
  
  public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
  {
    if (!isDeclaringClassPublic(paramFrameworkMember)) {
      paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must be declared in a public class."));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.runners.rules.RuleMemberValidator.DeclaringClassMustBePublic
 * JD-Core Version:    0.7.0.1
 */