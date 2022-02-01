package com.tencent.mobileqq.utils;

final class ValueAnimation$1
  implements ValueAnimation.TypeEvaluator<Integer>
{
  public Integer a(float paramFloat, Integer paramInteger1, Integer paramInteger2)
  {
    int i = paramInteger1.intValue();
    return Integer.valueOf((int)(i + paramFloat * (paramInteger2.intValue() - i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ValueAnimation.1
 * JD-Core Version:    0.7.0.1
 */