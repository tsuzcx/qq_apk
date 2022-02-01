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
    return "RaftAnnotationConfigArg{configClassName='" + this.configClassName + '\'' + ", configMethodName='" + this.configMethodName + '\'' + ", argMethod='" + this.argMethod + '\'' + ", argName='" + this.argName + '\'' + ", modifier=" + this.modifier + ", returnType='" + this.returnType + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.codegenmeta.annotation.RaftAnnotationConfigArg
 * JD-Core Version:    0.7.0.1
 */