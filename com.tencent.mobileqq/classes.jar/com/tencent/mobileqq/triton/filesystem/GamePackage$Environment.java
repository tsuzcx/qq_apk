package com.tencent.mobileqq.triton.filesystem;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "", "environment", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEnvironment", "()Ljava/lang/String;", "DEVELOP", "TRIAL", "RELEASE", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public enum GamePackage$Environment
{
  @NotNull
  private final String environment;
  
  static
  {
    Environment localEnvironment1 = new Environment("DEVELOP", 0, "develop");
    DEVELOP = localEnvironment1;
    Environment localEnvironment2 = new Environment("TRIAL", 1, "trial");
    TRIAL = localEnvironment2;
    Environment localEnvironment3 = new Environment("RELEASE", 2, "release");
    RELEASE = localEnvironment3;
    $VALUES = new Environment[] { localEnvironment1, localEnvironment2, localEnvironment3 };
  }
  
  private GamePackage$Environment(String paramString)
  {
    this.environment = paramString;
  }
  
  @NotNull
  public final String getEnvironment()
  {
    return this.environment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.GamePackage.Environment
 * JD-Core Version:    0.7.0.1
 */