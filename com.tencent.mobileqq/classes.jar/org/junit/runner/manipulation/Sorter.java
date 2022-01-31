package org.junit.runner.manipulation;

import java.util.Comparator;
import org.junit.runner.Description;

public class Sorter
  implements Comparator<Description>
{
  public static final Sorter NULL = new Sorter(new Sorter.1());
  private final Comparator<Description> comparator;
  
  public Sorter(Comparator<Description> paramComparator)
  {
    this.comparator = paramComparator;
  }
  
  public void apply(Object paramObject)
  {
    if ((paramObject instanceof Sortable)) {
      ((Sortable)paramObject).sort(this);
    }
  }
  
  public int compare(Description paramDescription1, Description paramDescription2)
  {
    return this.comparator.compare(paramDescription1, paramDescription2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.runner.manipulation.Sorter
 * JD-Core Version:    0.7.0.1
 */