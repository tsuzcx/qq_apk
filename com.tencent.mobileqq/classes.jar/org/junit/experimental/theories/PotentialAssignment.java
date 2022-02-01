package org.junit.experimental.theories;

public abstract class PotentialAssignment
{
  public static PotentialAssignment forValue(String paramString, Object paramObject)
  {
    return new PotentialAssignment.1(paramObject, paramString);
  }
  
  public abstract String getDescription();
  
  public abstract Object getValue();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.experimental.theories.PotentialAssignment
 * JD-Core Version:    0.7.0.1
 */