package rx.exceptions;

public final class UnsubscribeFailedException
  extends RuntimeException
{
  private static final long serialVersionUID = 4594672310593167598L;
  
  public UnsubscribeFailedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public UnsubscribeFailedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.exceptions.UnsubscribeFailedException
 * JD-Core Version:    0.7.0.1
 */