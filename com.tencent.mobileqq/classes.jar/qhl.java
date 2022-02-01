import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;

public abstract interface qhl
{
  public abstract void onLoadUserInfoFailed(String paramString1, String paramString2);
  
  public abstract void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhl
 * JD-Core Version:    0.7.0.1
 */