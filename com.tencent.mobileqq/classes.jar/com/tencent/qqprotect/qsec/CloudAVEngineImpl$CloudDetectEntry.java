package com.tencent.qqprotect.qsec;

final class CloudAVEngineImpl$CloudDetectEntry
{
  int a;
  boolean b;
  boolean c;
  int d;
  int e;
  String f = "";
  ICloudAVEngine.DetectBundle g;
  ICloudAVEngine.IAVEngineEventListener h;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[EntryId:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",UseCache:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",rightnow:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",Retry:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",localKey:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",content:");
    localStringBuilder.append(this.g.toString());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.CloudDetectEntry
 * JD-Core Version:    0.7.0.1
 */