package org.junit.experimental.theories;

class PotentialAssignment$1
  extends PotentialAssignment
{
  PotentialAssignment$1(Object paramObject, String paramString) {}
  
  public String getDescription()
  {
    Object localObject = this.val$value;
    String str;
    if (localObject == null) {
      localObject = "null";
    } else {
      try
      {
        localObject = String.format("\"%s\"", new Object[] { localObject });
      }
      catch (Throwable localThrowable)
      {
        str = String.format("[toString() threw %s: %s]", new Object[] { localThrowable.getClass().getSimpleName(), localThrowable.getMessage() });
      }
    }
    return String.format("%s <from %s>", new Object[] { str, this.val$name });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.theories.PotentialAssignment.1
 * JD-Core Version:    0.7.0.1
 */