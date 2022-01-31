import com.tencent.biz.qqstory.base.ErrorMessage;

class sys<Request extends syv, Respond extends syq>
  implements syw<Respond>
{
  protected final long a;
  protected syt<Request, Respond> a;
  public Request a;
  
  public sys(Request paramRequest)
  {
    this.jdField_a_of_type_Syv = paramRequest;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void b(int paramInt, String paramString, Respond paramRespond)
  {
    syt localsyt = this.jdField_a_of_type_Syt;
    if (localsyt != null)
    {
      localsyt.a(this.jdField_a_of_type_Syv, paramRespond, new ErrorMessage(paramInt, paramString));
      return;
    }
    veg.d("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
  }
  
  public void a(int paramInt, String paramString, Respond paramRespond)
  {
    b(paramInt, paramString, paramRespond);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sys
 * JD-Core Version:    0.7.0.1
 */