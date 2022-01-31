import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.network.request.GetLocationRequest;
import com.tencent.biz.qqstory.network.response.GetLocationResponse;
import com.tencent.biz.qqstory.support.logging.SLog;

public class ncr
  implements CmdTaskManger.CommandCallback
{
  public ncr(AddressDataProvider paramAddressDataProvider) {}
  
  public void a(@NonNull GetLocationRequest paramGetLocationRequest, @Nullable GetLocationResponse paramGetLocationResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    SLog.b("AddressDataProvider", "requestAddress Cmd Respond.");
    if ((paramErrorMessage.isSuccess()) && (paramGetLocationResponse != null))
    {
      SLog.a("AddressDataProvider", "requestAddress onCmdRespond success : %s .", paramGetLocationResponse.toString());
      this.a.jdField_a_of_type_JavaLangObject = new AddressDataProvider.AddressInfo(paramGetLocationResponse.a, paramGetLocationResponse.c, paramGetLocationResponse.d, paramGetLocationResponse.e, paramGetLocationResponse.f, paramGetLocationRequest.d, paramGetLocationRequest.e);
      this.a.a("country", paramGetLocationResponse.a);
      this.a.a("province", paramGetLocationResponse.c);
      this.a.a("city", paramGetLocationResponse.d);
      this.a.a("district", paramGetLocationResponse.e);
      this.a.a("street", paramGetLocationResponse.f);
      this.a.a("longitude", paramGetLocationRequest.d);
      this.a.a("latitude", paramGetLocationRequest.e);
      this.a.a("time", System.currentTimeMillis());
      this.a.a(true, this.a.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Boolean = false;
      return;
      SLog.d("AddressDataProvider", "requestAddress onCmdRespond : failed. errorMsg:%s , request:%s .", new Object[] { paramErrorMessage, paramGetLocationRequest });
      this.a.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncr
 * JD-Core Version:    0.7.0.1
 */