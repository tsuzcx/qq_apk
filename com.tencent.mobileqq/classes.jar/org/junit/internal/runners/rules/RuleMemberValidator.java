package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.TestClass;

public class RuleMemberValidator
{
  public static final RuleMemberValidator CLASS_RULE_METHOD_VALIDATOR = classRuleValidatorBuilder().forMethods().withValidator(new RuleMemberValidator.DeclaringClassMustBePublic(null)).withValidator(new RuleMemberValidator.MemberMustBeStatic(null)).withValidator(new RuleMemberValidator.MemberMustBePublic(null)).withValidator(new RuleMemberValidator.MethodMustBeATestRule(null)).build();
  public static final RuleMemberValidator CLASS_RULE_VALIDATOR = classRuleValidatorBuilder().withValidator(new RuleMemberValidator.DeclaringClassMustBePublic(null)).withValidator(new RuleMemberValidator.MemberMustBeStatic(null)).withValidator(new RuleMemberValidator.MemberMustBePublic(null)).withValidator(new RuleMemberValidator.FieldMustBeATestRule(null)).build();
  public static final RuleMemberValidator RULE_METHOD_VALIDATOR = testRuleValidatorBuilder().forMethods().withValidator(new RuleMemberValidator.MemberMustBeNonStaticOrAlsoClassRule(null)).withValidator(new RuleMemberValidator.MemberMustBePublic(null)).withValidator(new RuleMemberValidator.MethodMustBeARule(null)).build();
  public static final RuleMemberValidator RULE_VALIDATOR = testRuleValidatorBuilder().withValidator(new RuleMemberValidator.MemberMustBeNonStaticOrAlsoClassRule(null)).withValidator(new RuleMemberValidator.MemberMustBePublic(null)).withValidator(new RuleMemberValidator.FieldMustBeARule(null)).build();
  private final Class<? extends Annotation> annotation;
  private final boolean methods;
  private final List<RuleMemberValidator.RuleValidator> validatorStrategies;
  
  RuleMemberValidator(RuleMemberValidator.Builder paramBuilder)
  {
    this.annotation = RuleMemberValidator.Builder.access$800(paramBuilder);
    this.methods = RuleMemberValidator.Builder.access$900(paramBuilder);
    this.validatorStrategies = RuleMemberValidator.Builder.access$1000(paramBuilder);
  }
  
  private static RuleMemberValidator.Builder classRuleValidatorBuilder()
  {
    return new RuleMemberValidator.Builder(ClassRule.class, null);
  }
  
  private static boolean isMethodRule(FrameworkMember<?> paramFrameworkMember)
  {
    return MethodRule.class.isAssignableFrom(paramFrameworkMember.getType());
  }
  
  private static boolean isRuleType(FrameworkMember<?> paramFrameworkMember)
  {
    return (isMethodRule(paramFrameworkMember)) || (isTestRule(paramFrameworkMember));
  }
  
  private static boolean isTestRule(FrameworkMember<?> paramFrameworkMember)
  {
    return TestRule.class.isAssignableFrom(paramFrameworkMember.getType());
  }
  
  private static RuleMemberValidator.Builder testRuleValidatorBuilder()
  {
    return new RuleMemberValidator.Builder(Rule.class, null);
  }
  
  private void validateMember(FrameworkMember<?> paramFrameworkMember, List<Throwable> paramList)
  {
    Iterator localIterator = this.validatorStrategies.iterator();
    while (localIterator.hasNext()) {
      ((RuleMemberValidator.RuleValidator)localIterator.next()).validate(paramFrameworkMember, this.annotation, paramList);
    }
  }
  
  public void validate(TestClass paramTestClass, List<Throwable> paramList)
  {
    if (this.methods) {}
    for (paramTestClass = paramTestClass.getAnnotatedMethods(this.annotation);; paramTestClass = paramTestClass.getAnnotatedFields(this.annotation))
    {
      paramTestClass = paramTestClass.iterator();
      while (paramTestClass.hasNext()) {
        validateMember((FrameworkMember)paramTestClass.next(), paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.runners.rules.RuleMemberValidator
 * JD-Core Version:    0.7.0.1
 */