import com.tencent.biz.qqstory.base.ErrorMessage;

class slw<Request extends slz, Respond extends slu>
  implements sma<Respond>
{
  protected final long a;
  protected slx<Request, Respond> a;
  public Request a;
  
  public slw(Request paramRequest)
  {
    this.jdField_a_of_type_Slz = paramRequest;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  private void b(int paramInt, String paramString, Respond paramRespond)
  {
    slx localslx = this.jdField_a_of_type_Slx;
    if (localslx != null)
    {
      localslx.a(this.jdField_a_of_type_Slz, paramRespond, new ErrorMessage(paramInt, paramString));
      return;
    }
    urk.d("Q.qqstory.net:CmdTaskManager", "cmd callback is null");
  }
  
  public void a(int paramInt, String paramString, Respond paramRespond)
  {
    b(paramInt, paramString, paramRespond);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     slw
 * JD-Core Version:    0.7.0.1
 */