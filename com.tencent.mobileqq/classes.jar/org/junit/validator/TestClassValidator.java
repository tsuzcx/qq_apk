package org.junit.validator;

import java.util.List;
import org.junit.runners.model.TestClass;

public abstract interface TestClassValidator
{
  public abstract List<Exception> validateTestClass(TestClass paramTestClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.validator.TestClassValidator
 * JD-Core Version:    0.7.0.1
 */