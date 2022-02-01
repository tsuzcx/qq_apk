package cooperation.plugin;

public class InjectFailException
  extends Exception
{
  private int errCode;
  
  public InjectFailException(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.errCode = paramInt;
  }
  
  public int getErrCode()
  {
    return this.errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.plugin.InjectFailException
 * JD-Core Version:    0.7.0.1
 */