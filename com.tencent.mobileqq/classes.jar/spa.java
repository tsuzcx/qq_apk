import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;

class spa
  implements slx<szu, tbo>
{
  spa(soy paramsoy) {}
  
  public void a(@NonNull szu paramszu, @Nullable tbo paramtbo, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramtbo != null))
    {
      urk.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramtbo.toString());
      this.a.jdField_a_of_type_JavaLangObject = new spb(paramtbo.a, paramtbo.c, paramtbo.d, paramtbo.e, paramtbo.f, paramszu.d, paramszu.e);
      this.a.a("country", paramtbo.a);
      this.a.a("province", paramtbo.c);
      this.a.a("city", paramtbo.d);
      this.a.a("district", paramtbo.e);
      this.a.a("street", paramtbo.f);
      this.a.a("longitude", paramszu.d);
      this.a.a("latitude", paramszu.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      urk.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramszu });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spa
 * JD-Core Version:    0.7.0.1
 */