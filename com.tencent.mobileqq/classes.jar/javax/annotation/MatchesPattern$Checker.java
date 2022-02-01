package javax.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class MatchesPattern$Checker
  implements TypeQualifierValidator<MatchesPattern>
{
  public When forConstantValue(MatchesPattern paramMatchesPattern, Object paramObject)
  {
    if (Pattern.compile(paramMatchesPattern.value(), paramMatchesPattern.flags()).matcher((String)paramObject).matches()) {
      return When.ALWAYS;
    }
    return When.NEVER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     javax.annotation.MatchesPattern.Checker
 * JD-Core Version:    0.7.0.1
 */