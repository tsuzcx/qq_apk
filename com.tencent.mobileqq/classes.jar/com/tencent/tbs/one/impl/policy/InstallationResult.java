package com.tencent.tbs.one.impl.policy;

public class InstallationResult<T>
{
  public Object extra;
  public T result;
  public InstallationResult.Source source;
  
  public static <T> InstallationResult<T> make(InstallationResult.Source paramSource, T paramT)
  {
    InstallationResult localInstallationResult = new InstallationResult();
    localInstallationResult.source = paramSource;
    localInstallationResult.result = paramT;
    return localInstallationResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.InstallationResult
 * JD-Core Version:    0.7.0.1
 */