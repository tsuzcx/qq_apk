package cooperation.qqreader.net;

public class HttpResponseException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private int stateCode = 200;
  
  public HttpResponseException(int paramInt)
  {
    this.stateCode = paramInt;
  }
  
  public int getStateCode()
  {
    return this.stateCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.net.HttpResponseException
 * JD-Core Version:    0.7.0.1
 */