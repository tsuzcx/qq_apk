package rx.exceptions;

public final class OnCompletedFailedException
  extends RuntimeException
{
  private static final long serialVersionUID = 8622579378868820554L;
  
  public OnCompletedFailedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public OnCompletedFailedException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.exceptions.OnCompletedFailedException
 * JD-Core Version:    0.7.0.1
 */