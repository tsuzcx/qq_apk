package org.junit.experimental.theories.internal;

import java.util.Arrays;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class BooleanSupplier
  extends ParameterSupplier
{
  public List<PotentialAssignment> getValueSources(ParameterSignature paramParameterSignature)
  {
    return Arrays.asList(new PotentialAssignment[] { PotentialAssignment.forValue("true", Boolean.valueOf(true)), PotentialAssignment.forValue("false", Boolean.valueOf(false)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.experimental.theories.internal.BooleanSupplier
 * JD-Core Version:    0.7.0.1
 */