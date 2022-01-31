package kotlin.text;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/text/CharDirectionality;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public enum CharDirectionality
{
  public static final CharDirectionality.Companion Companion = new CharDirectionality.Companion(null);
  private static final Lazy directionalityMap$delegate = LazyKt.lazy((Function0)CharDirectionality.Companion.directionalityMap.2.INSTANCE);
  private final int value;
  
  static
  {
    CharDirectionality localCharDirectionality1 = new CharDirectionality("UNDEFINED", 0, -1);
    UNDEFINED = localCharDirectionality1;
    CharDirectionality localCharDirectionality2 = new CharDirectionality("LEFT_TO_RIGHT", 1, 0);
    LEFT_TO_RIGHT = localCharDirectionality2;
    CharDirectionality localCharDirectionality3 = new CharDirectionality("RIGHT_TO_LEFT", 2, 1);
    RIGHT_TO_LEFT = localCharDirectionality3;
    CharDirectionality localCharDirectionality4 = new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2);
    RIGHT_TO_LEFT_ARABIC = localCharDirectionality4;
    CharDirectionality localCharDirectionality5 = new CharDirectionality("EUROPEAN_NUMBER", 4, 3);
    EUROPEAN_NUMBER = localCharDirectionality5;
    CharDirectionality localCharDirectionality6 = new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4);
    EUROPEAN_NUMBER_SEPARATOR = localCharDirectionality6;
    CharDirectionality localCharDirectionality7 = new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5);
    EUROPEAN_NUMBER_TERMINATOR = localCharDirectionality7;
    CharDirectionality localCharDirectionality8 = new CharDirectionality("ARABIC_NUMBER", 7, 6);
    ARABIC_NUMBER = localCharDirectionality8;
    CharDirectionality localCharDirectionality9 = new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7);
    COMMON_NUMBER_SEPARATOR = localCharDirectionality9;
    CharDirectionality localCharDirectionality10 = new CharDirectionality("NONSPACING_MARK", 9, 8);
    NONSPACING_MARK = localCharDirectionality10;
    CharDirectionality localCharDirectionality11 = new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9);
    BOUNDARY_NEUTRAL = localCharDirectionality11;
    CharDirectionality localCharDirectionality12 = new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10);
    PARAGRAPH_SEPARATOR = localCharDirectionality12;
    CharDirectionality localCharDirectionality13 = new CharDirectionality("SEGMENT_SEPARATOR", 12, 11);
    SEGMENT_SEPARATOR = localCharDirectionality13;
    CharDirectionality localCharDirectionality14 = new CharDirectionality("WHITESPACE", 13, 12);
    WHITESPACE = localCharDirectionality14;
    CharDirectionality localCharDirectionality15 = new CharDirectionality("OTHER_NEUTRALS", 14, 13);
    OTHER_NEUTRALS = localCharDirectionality15;
    CharDirectionality localCharDirectionality16 = new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14);
    LEFT_TO_RIGHT_EMBEDDING = localCharDirectionality16;
    CharDirectionality localCharDirectionality17 = new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15);
    LEFT_TO_RIGHT_OVERRIDE = localCharDirectionality17;
    CharDirectionality localCharDirectionality18 = new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16);
    RIGHT_TO_LEFT_EMBEDDING = localCharDirectionality18;
    CharDirectionality localCharDirectionality19 = new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17);
    RIGHT_TO_LEFT_OVERRIDE = localCharDirectionality19;
    CharDirectionality localCharDirectionality20 = new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18);
    POP_DIRECTIONAL_FORMAT = localCharDirectionality20;
    $VALUES = new CharDirectionality[] { localCharDirectionality1, localCharDirectionality2, localCharDirectionality3, localCharDirectionality4, localCharDirectionality5, localCharDirectionality6, localCharDirectionality7, localCharDirectionality8, localCharDirectionality9, localCharDirectionality10, localCharDirectionality11, localCharDirectionality12, localCharDirectionality13, localCharDirectionality14, localCharDirectionality15, localCharDirectionality16, localCharDirectionality17, localCharDirectionality18, localCharDirectionality19, localCharDirectionality20 };
  }
  
  private CharDirectionality(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.text.CharDirectionality
 * JD-Core Version:    0.7.0.1
 */