package com.tencent.mobileqq.utils;

final class ValueAnimation$1
  implements ValueAnimation.TypeEvaluator<Integer>
{
  public Integer a(float paramFloat, Integer paramInteger1, Integer paramInteger2)
  {
    int i = paramInteger1.intValue();
    float f = i;
    return Integer.valueOf((int)((paramInteger2.intValue() - i) * paramFloat + f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ValueAnimation.1
 * JD-Core Version:    0.7.0.1
 */