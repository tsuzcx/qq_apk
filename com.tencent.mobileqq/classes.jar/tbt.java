import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class tbt
  implements syq<tmn, toh>
{
  tbt(tbr paramtbr) {}
  
  public void a(@NonNull tmn paramtmn, @Nullable toh paramtoh, @NonNull ErrorMessage paramErrorMessage)
  {
    ved.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramtoh != null))
    {
      ved.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramtoh.toString());
      this.a.jdField_a_of_type_JavaLangObject = new tbu(paramtoh.a, paramtoh.c, paramtoh.d, paramtoh.e, paramtoh.f, paramtmn.d, paramtmn.e);
      this.a.a("country", paramtoh.a);
      this.a.a("province", paramtoh.c);
      this.a.a("city", paramtoh.d);
      this.a.a("district", paramtoh.e);
      this.a.a("street", paramtoh.f);
      this.a.a("longitude", paramtmn.d);
      this.a.a("latitude", paramtmn.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      ved.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramtmn });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbt
 * JD-Core Version:    0.7.0.1
 */