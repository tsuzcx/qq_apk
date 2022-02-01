package org.apache.commons.io.serialization;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class FullClassNameMatcher
  implements ClassNameMatcher
{
  private final Set<String> classesSet;
  
  public FullClassNameMatcher(String... paramVarArgs)
  {
    this.classesSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(paramVarArgs)));
  }
  
  public boolean matches(String paramString)
  {
    return this.classesSet.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.serialization.FullClassNameMatcher
 * JD-Core Version:    0.7.0.1
 */