package org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CompositeFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  private static final Comparator<?>[] NO_COMPARATORS = new Comparator[0];
  private static final long serialVersionUID = -2224170307287243428L;
  private final Comparator<File>[] delegates;
  
  public CompositeFileComparator(Iterable<Comparator<File>> paramIterable)
  {
    if (paramIterable == null)
    {
      this.delegates = ((Comparator[])NO_COMPARATORS);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add((Comparator)paramIterable.next());
    }
    this.delegates = ((Comparator[])localArrayList.toArray(new Comparator[localArrayList.size()]));
  }
  
  public CompositeFileComparator(Comparator<File>... paramVarArgs)
  {
    if (paramVarArgs == null)
    {
      this.delegates = ((Comparator[])NO_COMPARATORS);
      return;
    }
    this.delegates = ((Comparator[])new Comparator[paramVarArgs.length]);
    System.arraycopy(paramVarArgs, 0, this.delegates, 0, paramVarArgs.length);
  }
  
  public int compare(File paramFile1, File paramFile2)
  {
    Comparator[] arrayOfComparator = this.delegates;
    int k = arrayOfComparator.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j = arrayOfComparator[i].compare(paramFile1, paramFile2);
      if (j != 0) {
        return j;
      }
      i += 1;
    }
    return j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.delegates.length)
    {
      if (i > 0) {
        localStringBuilder.append(',');
      }
      localStringBuilder.append(this.delegates[i]);
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.comparator.CompositeFileComparator
 * JD-Core Version:    0.7.0.1
 */