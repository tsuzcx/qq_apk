package org.junit.experimental.theories.internal;

import java.util.ArrayList;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class EnumSupplier
  extends ParameterSupplier
{
  private Class<?> enumType;
  
  public EnumSupplier(Class<?> paramClass)
  {
    this.enumType = paramClass;
  }
  
  public List<PotentialAssignment> getValueSources(ParameterSignature paramParameterSignature)
  {
    paramParameterSignature = this.enumType.getEnumConstants();
    ArrayList localArrayList = new ArrayList();
    int j = paramParameterSignature.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramParameterSignature[i];
      localArrayList.add(PotentialAssignment.forValue(localObject.toString(), localObject));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.experimental.theories.internal.EnumSupplier
 * JD-Core Version:    0.7.0.1
 */