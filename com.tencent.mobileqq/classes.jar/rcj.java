import com.tencent.mobileqq.Doraemon.APIParam;

public final class rcj
{
  public String a;
  public String b;
  
  public APIParam a()
  {
    APIParam localAPIParam = new APIParam();
    localAPIParam.put("openid", this.a);
    return localAPIParam;
  }
  
  public String toString()
  {
    return "LoginInfo{, openid='" + this.a + '\'' + ", access_token='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rcj
 * JD-Core Version:    0.7.0.1
 */