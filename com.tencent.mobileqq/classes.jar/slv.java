import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;

public class slv
{
  public static volatile slv a;
  
  public static slv a()
  {
    Object localObject = a;
    if (localObject == null) {
      try
      {
        slv localslv2 = a;
        localObject = localslv2;
        if (localslv2 == null)
        {
          localObject = new slv();
          a = (slv)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localslv1;
  }
  
  public <Request extends slz, Respond extends slu> void a(Request paramRequest, slx<Request, Respond> paramslx)
  {
    paramRequest = new slw(paramRequest);
    paramRequest.jdField_a_of_type_Slx = paramslx;
    paramRequest.jdField_a_of_type_Slz.a(paramRequest);
    QQStoryContext.a().a().a(paramRequest.jdField_a_of_type_Slz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     slv
 * JD-Core Version:    0.7.0.1
 */