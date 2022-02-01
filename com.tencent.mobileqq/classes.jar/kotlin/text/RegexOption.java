package kotlin.text;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/RegexOption;", "", "Lkotlin/text/FlagEnum;", "value", "", "mask", "(Ljava/lang/String;III)V", "getMask", "()I", "getValue", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public enum RegexOption
  implements FlagEnum
{
  private final int mask;
  private final int value;
  
  static
  {
    RegexOption localRegexOption1 = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
    IGNORE_CASE = localRegexOption1;
    RegexOption localRegexOption2 = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
    MULTILINE = localRegexOption2;
    RegexOption localRegexOption3 = new RegexOption("LITERAL", 2, 16, 0, 2, null);
    LITERAL = localRegexOption3;
    RegexOption localRegexOption4 = new RegexOption("UNIX_LINES", 3, 1, 0, 2, null);
    UNIX_LINES = localRegexOption4;
    RegexOption localRegexOption5 = new RegexOption("COMMENTS", 4, 4, 0, 2, null);
    COMMENTS = localRegexOption5;
    RegexOption localRegexOption6 = new RegexOption("DOT_MATCHES_ALL", 5, 32, 0, 2, null);
    DOT_MATCHES_ALL = localRegexOption6;
    RegexOption localRegexOption7 = new RegexOption("CANON_EQ", 6, 128, 0, 2, null);
    CANON_EQ = localRegexOption7;
    $VALUES = new RegexOption[] { localRegexOption1, localRegexOption2, localRegexOption3, localRegexOption4, localRegexOption5, localRegexOption6, localRegexOption7 };
  }
  
  private RegexOption(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
    this.mask = paramInt2;
  }
  
  public int getMask()
  {
    return this.mask;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.text.RegexOption
 * JD-Core Version:    0.7.0.1
 */