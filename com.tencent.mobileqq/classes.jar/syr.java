import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;

public class syr
{
  public static volatile syr a;
  
  public static syr a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        syr localsyr2 = a;
        localObject = localsyr2;
        if (localsyr2 == null)
        {
          localObject = new syr();
          a = (syr)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localsyr1;
  }
  
  public <Request extends syv, Respond extends syq> void a(Request paramRequest, syt<Request, Respond> paramsyt)
  {
    paramRequest = new sys(paramRequest);
    paramRequest.jdField_a_of_type_Syt = paramsyt;
    paramRequest.jdField_a_of_type_Syv.a(paramRequest);
    QQStoryContext.a().a().a(paramRequest.jdField_a_of_type_Syv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syr
 * JD-Core Version:    0.7.0.1
 */