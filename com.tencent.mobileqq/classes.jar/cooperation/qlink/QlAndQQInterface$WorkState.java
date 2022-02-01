package cooperation.qlink;

import java.io.Serializable;

public class QlAndQQInterface$WorkState
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean mForIphone;
  public int mMode;
  public String mPeerNick;
  public String mPeerUin;
  public int mState;
  public int mTransferingCount;
  public boolean mWorking;
  
  public QlAndQQInterface$WorkState()
  {
    this.mWorking = false;
    this.mState = 0;
    this.mPeerUin = "0";
    this.mPeerNick = "";
    this.mMode = 0;
    this.mTransferingCount = 0;
    this.mForIphone = false;
  }
  
  public QlAndQQInterface$WorkState(boolean paramBoolean1, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    this.mWorking = paramBoolean1;
    this.mState = paramInt1;
    this.mPeerUin = paramString1;
    this.mPeerNick = paramString2;
    this.mMode = paramInt2;
    this.mTransferingCount = paramInt3;
    this.mForIphone = paramBoolean2;
  }
  
  public WorkState clone()
  {
    try
    {
      WorkState localWorkState1 = (WorkState)super.clone();
      return localWorkState1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      WorkState localWorkState2 = new WorkState();
      localCloneNotSupportedException.printStackTrace();
      return localWorkState2;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" mWorking:");
    localStringBuilder.append(this.mWorking);
    localStringBuilder.append(" mState:");
    localStringBuilder.append(this.mState);
    localStringBuilder.append(" mPeerUin:");
    localStringBuilder.append(this.mPeerUin);
    localStringBuilder.append(" mPeerNick:");
    localStringBuilder.append(this.mPeerNick);
    localStringBuilder.append(" mMode:");
    localStringBuilder.append(this.mMode);
    localStringBuilder.append(" mTransferingCount:");
    localStringBuilder.append(this.mTransferingCount);
    localStringBuilder.append(" mForIphone:");
    localStringBuilder.append(this.mForIphone);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QlAndQQInterface.WorkState
 * JD-Core Version:    0.7.0.1
 */