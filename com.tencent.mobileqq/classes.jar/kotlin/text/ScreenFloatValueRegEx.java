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
    String str1 = "[eE][+-]?" + "(\\p{Digit}+)";
    String str2 = "(0[xX]" + "(\\p{XDigit}+)" + "(\\.)?)|" + "(0[xX]" + "(\\p{XDigit}+)" + "?(\\.)" + "(\\p{XDigit}+)" + ')';
    str1 = '(' + "(\\p{Digit}+)" + "(\\.)?(" + "(\\p{Digit}+)" + "?)(" + str1 + ")?)|" + "(\\.(" + "(\\p{Digit}+)" + ")(" + str1 + ")?)|" + "((" + str2 + ")[pP][+-]?" + "(\\p{Digit}+)" + ')';
    value = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + str1 + ")[fFdD]?))[\\x00-\\x20]*");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.ScreenFloatValueRegEx
 * JD-Core Version:    0.7.0.1
 */