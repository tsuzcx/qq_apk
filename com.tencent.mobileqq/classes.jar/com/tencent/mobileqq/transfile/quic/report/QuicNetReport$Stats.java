package com.tencent.mobileqq.transfile.quic.report;

public class QuicNetReport$Stats
{
  public int mByteRecv = 0;
  public int mEstimatedBandwidth = 0;
  public int mLostRate = 0;
  public int mRttMean = 0;
  public int mSrttUs = 0;
  public byte[] mSrvMessage;
  
  public boolean isValid()
  {
    return (this.mSrttUs != 0) || (this.mEstimatedBandwidth != 0) || (this.mRttMean != 0) || (this.mLostRate != 0) || (this.mByteRecv != 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Stats{mSrttUs=");
    localStringBuilder.append(this.mSrttUs);
    localStringBuilder.append(", mEstimatedBandwidth=");
    localStringBuilder.append(this.mEstimatedBandwidth);
    localStringBuilder.append(", mRttMean=");
    localStringBuilder.append(this.mRttMean);
    localStringBuilder.append(", mLostRate=");
    localStringBuilder.append(this.mLostRate);
    localStringBuilder.append(", mByteRecv=");
    localStringBuilder.append(this.mByteRecv);
    localStringBuilder.append(", mSrvMessage.length='");
    byte[] arrayOfByte = this.mSrvMessage;
    int i;
    if (arrayOfByte != null) {
      i = arrayOfByte.length;
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.report.QuicNetReport.Stats
 * JD-Core Version:    0.7.0.1
 */