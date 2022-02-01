package com.tencent.raft.codegenmeta.annotation;

import java.io.Serializable;
import java.util.Set;
import javax.lang.model.element.Modifier;

public class RaftAnnotationConfigArg
  implements Serializable
{
  private static final long serialVersionUID = 1001L;
  public String argMethod;
  public String argName;
  public String configClassName;
  public String configMethodName;
  public Set<Modifier> modifier;
  public String returnType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RaftAnnotationConfigArg{configClassName='");
    localStringBuilder.append(this.configClassName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", configMethodName='");
    localStringBuilder.append(this.configMethodName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", argMethod='");
    localStringBuilder.append(this.argMethod);
    localStringBuilder.append('\'');
    localStringBuilder.append(", argName='");
    localStringBuilder.append(this.argName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", modifier=");
    localStringBuilder.append(this.modifier);
    localStringBuilder.append(", returnType='");
    localStringBuilder.append(this.returnType);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.annotation.RaftAnnotationConfigArg
 * JD-Core Version:    0.7.0.1
 */