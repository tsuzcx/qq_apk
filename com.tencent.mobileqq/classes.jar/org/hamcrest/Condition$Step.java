package org.hamcrest;

public abstract interface Condition$Step<I, O>
{
  public abstract Condition<O> apply(I paramI, Description paramDescription);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.Condition.Step
 * JD-Core Version:    0.7.0.1
 */