import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class tbw
  implements syt<tmq, tok>
{
  tbw(tbu paramtbu) {}
  
  public void a(@NonNull tmq paramtmq, @Nullable tok paramtok, @NonNull ErrorMessage paramErrorMessage)
  {
    veg.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramtok != null))
    {
      veg.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramtok.toString());
      this.a.jdField_a_of_type_JavaLangObject = new tbx(paramtok.a, paramtok.c, paramtok.d, paramtok.e, paramtok.f, paramtmq.d, paramtmq.e);
      this.a.a("country", paramtok.a);
      this.a.a("province", paramtok.c);
      this.a.a("city", paramtok.d);
      this.a.a("district", paramtok.e);
      this.a.a("street", paramtok.f);
      this.a.a("longitude", paramtmq.d);
      this.a.a("latitude", paramtmq.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      veg.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramtmq });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbw
 * JD-Core Version:    0.7.0.1
 */