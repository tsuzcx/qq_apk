package javax.annotation;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class RegEx$Checker
  implements TypeQualifierValidator<RegEx>
{
  public When forConstantValue(RegEx paramRegEx, Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return When.NEVER;
    }
    try
    {
      Pattern.compile((String)paramObject);
      return When.ALWAYS;
    }
    catch (PatternSyntaxException paramRegEx) {}
    return When.NEVER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     javax.annotation.RegEx.Checker
 * JD-Core Version:    0.7.0.1
 */