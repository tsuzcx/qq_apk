package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.util.Pair;
import java.util.Comparator;

class TagUtil$TextLengthComparator
  implements Comparator<Pair<Long, String>>
{
  public int a(Pair<Long, String> paramPair1, Pair<Long, String> paramPair2)
  {
    return TagUtil.b((CharSequence)paramPair1.second) - TagUtil.b((CharSequence)paramPair2.second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagUtil.TextLengthComparator
 * JD-Core Version:    0.7.0.1
 */