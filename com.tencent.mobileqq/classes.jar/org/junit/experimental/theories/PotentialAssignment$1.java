package org.junit.experimental.theories;

class PotentialAssignment$1
  extends PotentialAssignment
{
  PotentialAssignment$1(Object paramObject, String paramString) {}
  
  public String getDescription()
  {
    String str1;
    if (this.val$value == null) {
      str1 = "null";
    }
    for (;;)
    {
      return String.format("%s <from %s>", new Object[] { str1, this.val$name });
      try
      {
        str1 = String.format("\"%s\"", new Object[] { this.val$value });
      }
      catch (Throwable localThrowable)
      {
        String str2 = String.format("[toString() threw %s: %s]", new Object[] { localThrowable.getClass().getSimpleName(), localThrowable.getMessage() });
      }
    }
  }
  
  public Object getValue()
  {
    return this.val$value;
  }
  
  public String toString()
  {
    return String.format("[%s]", new Object[] { this.val$value });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.experimental.theories.PotentialAssignment.1
 * JD-Core Version:    0.7.0.1
 */