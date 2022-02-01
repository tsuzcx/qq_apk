package com.tencent.mobileqq.transfile.quic.report;

public class QuicNetReport$Stats
{
  public int mByteRecv;
  public int mEstimatedBandwidth;
  public int mLostRate;
  public int mRttMean;
  public int mSrttUs;
  public byte[] mSrvMessage;
  
  public boolean isValid()
  {
    return (this.mSrttUs != 0) || (this.mEstimatedBandwidth != 0) || (this.mRttMean != 0) || (this.mLostRate != 0) || (this.mByteRecv != 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Stats{mSrttUs=").append(this.mSrttUs).append(", mEstimatedBandwidth=").append(this.mEstimatedBandwidth).append(", mRttMean=").append(this.mRttMean).append(", mLostRate=").append(this.mLostRate).append(", mByteRecv=").append(this.mByteRecv).append(", mSrvMessage.length='");
    if (this.mSrvMessage != null) {}
    for (int i = this.mSrvMessage.length;; i = 0) {
      return i + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.report.QuicNetReport.Stats
 * JD-Core Version:    0.7.0.1
 */