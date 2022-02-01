package org.junit.runners.model;

import java.lang.reflect.Field;
import java.util.Comparator;

class TestClass$FieldComparator
  implements Comparator<Field>
{
  public int compare(Field paramField1, Field paramField2)
  {
    return paramField1.getName().compareTo(paramField2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.runners.model.TestClass.FieldComparator
 * JD-Core Version:    0.7.0.1
 */