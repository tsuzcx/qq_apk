package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

final class ContactSearchEngine$3
  implements Comparator<RecentUser>
{
  public int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    return Long.signum(paramRecentUser2.lastmsgtime - paramRecentUser1.lastmsgtime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.ContactSearchEngine.3
 * JD-Core Version:    0.7.0.1
 */