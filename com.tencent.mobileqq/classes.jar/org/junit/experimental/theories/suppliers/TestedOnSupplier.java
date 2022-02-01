package org.junit.experimental.theories.suppliers;

import java.util.ArrayList;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class TestedOnSupplier
  extends ParameterSupplier
{
  public List<PotentialAssignment> getValueSources(ParameterSignature paramParameterSignature)
  {
    ArrayList localArrayList = new ArrayList();
    paramParameterSignature = ((TestedOn)paramParameterSignature.getAnnotation(TestedOn.class)).ints();
    int j = paramParameterSignature.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(PotentialAssignment.forValue("ints", Integer.valueOf(paramParameterSignature[i])));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.experimental.theories.suppliers.TestedOnSupplier
 * JD-Core Version:    0.7.0.1
 */