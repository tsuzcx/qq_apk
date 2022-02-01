package com.tencent.mobileqq.filemanager.multisave;

public abstract class QFileControlReq
{
  private QFileControlCallback a;
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("-");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public abstract String a();
  
  public void a(QFileControlCallback paramQFileControlCallback)
  {
    this.a = paramQFileControlCallback;
  }
  
  public QFileControlCallback b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.QFileControlReq
 * JD-Core Version:    0.7.0.1
 */