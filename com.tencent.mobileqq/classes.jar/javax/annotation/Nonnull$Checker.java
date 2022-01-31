package javax.annotation;

import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class Nonnull$Checker
  implements TypeQualifierValidator<Nonnull>
{
  public When forConstantValue(Nonnull paramNonnull, Object paramObject)
  {
    if (paramObject == null) {
      return When.NEVER;
    }
    return When.ALWAYS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     javax.annotation.Nonnull.Checker
 * JD-Core Version:    0.7.0.1
 */