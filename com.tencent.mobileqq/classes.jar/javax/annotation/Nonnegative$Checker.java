package javax.annotation;

import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class Nonnegative$Checker
  implements TypeQualifierValidator<Nonnegative>
{
  public When forConstantValue(Nonnegative paramNonnegative, Object paramObject)
  {
    int i = 1;
    if (!(paramObject instanceof Number)) {
      return When.NEVER;
    }
    paramNonnegative = (Number)paramObject;
    if ((paramNonnegative instanceof Long)) {
      if (paramNonnegative.longValue() >= 0L) {}
    }
    while (i != 0)
    {
      return When.NEVER;
      i = 0;
      continue;
      if ((paramNonnegative instanceof Double))
      {
        if (paramNonnegative.doubleValue() >= 0.0D) {
          i = 0;
        }
      }
      else if ((paramNonnegative instanceof Float))
      {
        if (paramNonnegative.floatValue() >= 0.0F) {
          i = 0;
        }
      }
      else if (paramNonnegative.intValue() >= 0) {
        i = 0;
      }
    }
    return When.ALWAYS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     javax.annotation.Nonnegative.Checker
 * JD-Core Version:    0.7.0.1
 */