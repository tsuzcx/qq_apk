package org.jbox2d.callbacks;

import org.jbox2d.dynamics.Filter;
import org.jbox2d.dynamics.Fixture;

public class ContactFilter
{
  public boolean shouldCollide(Fixture paramFixture1, Fixture paramFixture2)
  {
    paramFixture1 = paramFixture1.getFilterData();
    paramFixture2 = paramFixture2.getFilterData();
    if ((paramFixture1.groupIndex == paramFixture2.groupIndex) && (paramFixture1.groupIndex != 0)) {
      return paramFixture1.groupIndex > 0;
    }
    return ((paramFixture1.maskBits & paramFixture2.categoryBits) != 0) && ((paramFixture1.categoryBits & paramFixture2.maskBits) != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.callbacks.ContactFilter
 * JD-Core Version:    0.7.0.1
 */