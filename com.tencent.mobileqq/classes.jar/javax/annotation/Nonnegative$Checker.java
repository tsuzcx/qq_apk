package javax.annotation;

import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class Nonnegative$Checker
  implements TypeQualifierValidator<Nonnegative>
{
  public When forConstantValue(Nonnegative paramNonnegative, Object paramObject)
  {
    if (!(paramObject instanceof Number)) {
      return When.NEVER;
    }
    paramNonnegative = (Number)paramObject;
    boolean bool = paramNonnegative instanceof Long;
    int i = 1;
    if (bool)
    {
      if (paramNonnegative.longValue() < 0L) {}
    }
    else {
      do
      {
        do
        {
          i = 0;
          break label91;
          if (!(paramNonnegative instanceof Double)) {
            break;
          }
        } while (paramNonnegative.doubleValue() >= 0.0D);
        break;
      } while ((paramNonnegative instanceof Float) ? paramNonnegative.floatValue() >= 0.0F : paramNonnegative.intValue() >= 0);
    }
    label91:
    if (i != 0) {
      return When.NEVER;
    }
    return When.ALWAYS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     javax.annotation.Nonnegative.Checker
 * JD-Core Version:    0.7.0.1
 */