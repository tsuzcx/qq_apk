package cooperation.qqcircle.picload.avatar;

import com.tencent.mobileqq.qcircle.api.data.Option;

public class AvatarOption
  extends Option
{
  private long mTimeStamp;
  private String mUin;
  
  public long getTimeStamp()
  {
    return this.mTimeStamp;
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public AvatarOption setTimeStamp(long paramLong)
  {
    this.mTimeStamp = paramLong;
    return this;
  }
  
  public AvatarOption setUin(String paramString)
  {
    this.mUin = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.AvatarOption
 * JD-Core Version:    0.7.0.1
 */