package me.weishu.epic.art;

import me.weishu.epic.art.method.ArtMethod;

public class Epic$MethodInfo
{
  public boolean isStatic;
  public ArtMethod method;
  public int paramNumber;
  public Class<?>[] paramTypes;
  public Class<?> returnType;
  
  public String toString()
  {
    return this.method.toGenericString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.weishu.epic.art.Epic.MethodInfo
 * JD-Core Version:    0.7.0.1
 */