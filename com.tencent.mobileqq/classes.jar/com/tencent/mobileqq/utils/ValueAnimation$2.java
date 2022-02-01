package com.tencent.mobileqq.utils;

final class ValueAnimation$2
  implements ValueAnimation.TypeEvaluator<Number>
{
  public Float a(float paramFloat, Number paramNumber1, Number paramNumber2)
  {
    float f = paramNumber1.floatValue();
    return Float.valueOf(f + paramFloat * (paramNumber2.floatValue() - f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ValueAnimation.2
 * JD-Core Version:    0.7.0.1
 */