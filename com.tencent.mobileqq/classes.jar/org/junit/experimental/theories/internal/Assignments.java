package org.junit.experimental.theories.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.TestClass;

public class Assignments
{
  private final List<PotentialAssignment> assigned;
  private final TestClass clazz;
  private final List<ParameterSignature> unassigned;
  
  private Assignments(List<PotentialAssignment> paramList, List<ParameterSignature> paramList1, TestClass paramTestClass)
  {
    this.unassigned = paramList1;
    this.assigned = paramList;
    this.clazz = paramTestClass;
  }
  
  public static Assignments allUnassigned(Method paramMethod, TestClass paramTestClass)
  {
    List localList = ParameterSignature.signatures(paramTestClass.getOnlyConstructor());
    localList.addAll(ParameterSignature.signatures(paramMethod));
    return new Assignments(new ArrayList(), localList, paramTestClass);
  }
  
  private ParameterSupplier buildParameterSupplierFromClass(Class<? extends ParameterSupplier> paramClass)
  {
    Constructor[] arrayOfConstructor = paramClass.getConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    while (i < j)
    {
      Constructor localConstructor = arrayOfConstructor[i];
      Class[] arrayOfClass = localConstructor.getParameterTypes();
      if ((arrayOfClass.length == 1) && (arrayOfClass[0].equals(TestClass.class))) {
        return (ParameterSupplier)localConstructor.newInstance(new Object[] { this.clazz });
      }
      i += 1;
    }
    return (ParameterSupplier)paramClass.newInstance();
  }
  
  private List<PotentialAssignment> generateAssignmentsFromTypeAlone(ParameterSignature paramParameterSignature)
  {
    Class localClass = paramParameterSignature.getType();
    if (localClass.isEnum()) {
      return new EnumSupplier(localClass).getValueSources(paramParameterSignature);
    }
    if ((!localClass.equals(Boolean.class)) && (!localClass.equals(Boolean.TYPE))) {
      return Collections.emptyList();
    }
    return new BooleanSupplier().getValueSources(paramParameterSignature);
  }
  
  private int getConstructorParameterCount()
  {
    return ParameterSignature.signatures(this.clazz.getOnlyConstructor()).size();
  }
  
  private ParameterSupplier getSupplier(ParameterSignature paramParameterSignature)
  {
    paramParameterSignature = (ParametersSuppliedBy)paramParameterSignature.findDeepAnnotation(ParametersSuppliedBy.class);
    if (paramParameterSignature != null) {
      return buildParameterSupplierFromClass(paramParameterSignature.value());
    }
    return new AllMembersSupplier(this.clazz);
  }
  
  public Assignments assignNext(PotentialAssignment paramPotentialAssignment)
  {
    ArrayList localArrayList = new ArrayList(this.assigned);
    localArrayList.add(paramPotentialAssignment);
    paramPotentialAssignment = this.unassigned;
    return new Assignments(localArrayList, paramPotentialAssignment.subList(1, paramPotentialAssignment.size()), this.clazz);
  }
  
  public Object[] getActualValues(int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject = new Object[paramInt2 - paramInt1];
    int i = paramInt1;
    while (i < paramInt2)
    {
      arrayOfObject[(i - paramInt1)] = ((PotentialAssignment)this.assigned.get(i)).getValue();
      i += 1;
    }
    return arrayOfObject;
  }
  
  public Object[] getAllArguments()
  {
    return getActualValues(0, this.assigned.size());
  }
  
  public Object[] getArgumentStrings(boolean paramBoolean)
  {
    Object[] arrayOfObject = new Object[this.assigned.size()];
    int i = 0;
    while (i < arrayOfObject.length)
    {
      arrayOfObject[i] = ((PotentialAssignment)this.assigned.get(i)).getDescription();
      i += 1;
    }
    return arrayOfObject;
  }
  
  public Object[] getConstructorArguments()
  {
    return getActualValues(0, getConstructorParameterCount());
  }
  
  public Object[] getMethodArguments()
  {
    return getActualValues(getConstructorParameterCount(), this.assigned.size());
  }
  
  public boolean isComplete()
  {
    return this.unassigned.size() == 0;
  }
  
  public ParameterSignature nextUnassigned()
  {
    return (ParameterSignature)this.unassigned.get(0);
  }
  
  public List<PotentialAssignment> potentialsForNextUnassigned()
  {
    ParameterSignature localParameterSignature = nextUnassigned();
    List localList2 = getSupplier(localParameterSignature).getValueSources(localParameterSignature);
    List localList1 = localList2;
    if (localList2.size() == 0) {
      localList1 = generateAssignmentsFromTypeAlone(localParameterSignature);
    }
    return localList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.experimental.theories.internal.Assignments
 * JD-Core Version:    0.7.0.1
 */