package org.junit.internal.runners.model;

import java.util.List;

@Deprecated
public class MultipleFailureException
  extends org.junit.runners.model.MultipleFailureException
{
  private static final long serialVersionUID = 1L;
  
  public MultipleFailureException(List<Throwable> paramList)
  {
    super(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.runners.model.MultipleFailureException
 * JD-Core Version:    0.7.0.1
 */