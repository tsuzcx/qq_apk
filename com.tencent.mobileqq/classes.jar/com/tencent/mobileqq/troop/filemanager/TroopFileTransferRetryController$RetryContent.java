package com.tencent.mobileqq.troop.filemanager;

class TroopFileTransferRetryController$RetryContent
{
  int a = 0;
  int b = 0;
  int c = 0;
  
  public TroopFileTransferRetryController$RetryContent(TroopFileTransferRetryController paramTroopFileTransferRetryController)
  {
    a();
  }
  
  public void a()
  {
    this.a = 0;
    this.b = 0;
    this.c = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" retryInfo[AutoR-");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" EofR-");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" SvrErrR-");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileTransferRetryController.RetryContent
 * JD-Core Version:    0.7.0.1
 */