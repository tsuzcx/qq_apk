package cooperation.qzone.sim;

import android.text.TextUtils;

public class SimInfo
{
  private String mIMSI = "";
  private boolean mIseDataTrafficSim = false;
  private String mPhoneNum = "";
  
  public String getIMSI()
  {
    return this.mIMSI;
  }
  
  public String getPhoneNum()
  {
    return this.mPhoneNum;
  }
  
  public boolean isIseDataTrafficSim()
  {
    return this.mIseDataTrafficSim;
  }
  
  public void setIMSI(String paramString)
  {
    this.mIMSI = paramString;
  }
  
  public void setIsDataTrafficSim(boolean paramBoolean)
  {
    this.mIseDataTrafficSim = paramBoolean;
  }
  
  public void setPhoneNum(String paramString)
  {
    this.mPhoneNum = paramString;
    if (!TextUtils.isEmpty(this.mPhoneNum))
    {
      this.mPhoneNum = this.mPhoneNum.replaceAll("\\+86", "");
      this.mPhoneNum = this.mPhoneNum.replaceAll("\\D", "");
    }
  }
  
  public String toString()
  {
    return "SimInfo mIseDataTrafficSim=" + this.mIseDataTrafficSim + ",mIMSI=" + this.mIMSI + ",mPhoneNum=" + this.mPhoneNum;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.sim.SimInfo
 * JD-Core Version:    0.7.0.1
 */