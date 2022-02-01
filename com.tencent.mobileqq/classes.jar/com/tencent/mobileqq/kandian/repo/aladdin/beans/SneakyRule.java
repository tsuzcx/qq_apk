package com.tencent.mobileqq.kandian.repo.aladdin.beans;

import com.tencent.aladdin.config.parse.AladdinConfigBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SneakyRule
  implements AladdinConfigBean
{
  private boolean enable = false;
  private Set<String> fingerprintSet = new HashSet();
  private List<String> props = new ArrayList();
  
  public Set<String> getFingerprintSet()
  {
    return this.fingerprintSet;
  }
  
  public List<String> getProps()
  {
    return this.props;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SneakyRule{props=");
    localStringBuilder.append(this.props);
    localStringBuilder.append(", fingerprintSet=");
    localStringBuilder.append(this.fingerprintSet);
    localStringBuilder.append(", enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.beans.SneakyRule
 * JD-Core Version:    0.7.0.1
 */