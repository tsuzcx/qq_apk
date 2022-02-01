package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ScreenFloatValueRegEx
{
  public static final ScreenFloatValueRegEx INSTANCE = new ScreenFloatValueRegEx();
  @JvmField
  @NotNull
  public static final Regex value;
  
  static
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[eE][+-]?");
    ((StringBuilder)localObject1).append("(\\p{Digit}+)");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("(0[xX]");
    ((StringBuilder)localObject2).append("(\\p{XDigit}+)");
    ((StringBuilder)localObject2).append("(\\.)?)|");
    ((StringBuilder)localObject2).append("(0[xX]");
    ((StringBuilder)localObject2).append("(\\p{XDigit}+)");
    ((StringBuilder)localObject2).append("?(\\.)");
    ((StringBuilder)localObject2).append("(\\p{XDigit}+)");
    ((StringBuilder)localObject2).append(')');
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    localStringBuilder.append("(\\p{Digit}+)");
    localStringBuilder.append("(\\.)?(");
    localStringBuilder.append("(\\p{Digit}+)");
    localStringBuilder.append("?)(");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(")?)|");
    localStringBuilder.append("(\\.(");
    localStringBuilder.append("(\\p{Digit}+)");
    localStringBuilder.append(")(");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(")?)|");
    localStringBuilder.append("((");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(")[pP][+-]?");
    localStringBuilder.append("(\\p{Digit}+)");
    localStringBuilder.append(')');
    localObject1 = localStringBuilder.toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")[fFdD]?))[\\x00-\\x20]*");
    value = new Regex(((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.text.ScreenFloatValueRegEx
 * JD-Core Version:    0.7.0.1
 */