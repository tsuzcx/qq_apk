package rx.exceptions;

final class CompositeException$CompositeExceptionCausalChain
  extends RuntimeException
{
  static String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
  private static final long serialVersionUID = 3875212506787802066L;
  
  public String getMessage()
  {
    return MESSAGE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.exceptions.CompositeException.CompositeExceptionCausalChain
 * JD-Core Version:    0.7.0.1
 */