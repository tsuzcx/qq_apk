import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;

public class syo
{
  public static volatile syo a;
  
  public static syo a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        syo localsyo2 = a;
        localObject = localsyo2;
        if (localsyo2 == null)
        {
          localObject = new syo();
          a = (syo)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localsyo1;
  }
  
  public <Request extends sys, Respond extends syn> void a(Request paramRequest, syq<Request, Respond> paramsyq)
  {
    paramRequest = new syp(paramRequest);
    paramRequest.jdField_a_of_type_Syq = paramsyq;
    paramRequest.jdField_a_of_type_Sys.a(paramRequest);
    QQStoryContext.a().a().a(paramRequest.jdField_a_of_type_Sys);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syo
 * JD-Core Version:    0.7.0.1
 */