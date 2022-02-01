package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

abstract interface RuleMemberValidator$RuleValidator
{
  public abstract void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.runners.rules.RuleMemberValidator.RuleValidator
 * JD-Core Version:    0.7.0.1
 */