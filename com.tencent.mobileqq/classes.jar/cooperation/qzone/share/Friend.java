package cooperation.qzone.share;

public class Friend
{
  public String mName = "";
  public String mNickName = "";
  public String mRemark = "";
  public long mUin = -1L;
  public String uinKey = "";
  public int vipLevel = -1;
  public int who = 0;
  
  public Friend() {}
  
  public Friend(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.mUin = paramLong;
    this.mName = paramString1;
    this.mNickName = paramString2;
    this.mRemark = paramString3;
    this.who = paramInt;
    this.uinKey = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.share.Friend
 * JD-Core Version:    0.7.0.1
 */