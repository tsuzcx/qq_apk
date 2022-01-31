import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class sxq
  implements EIPCResultCallback
{
  sxq(sxe paramsxe, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.data != null)
    {
      paramEIPCResult = paramEIPCResult.data.getString("action_update_biu_and_comment_request_string");
      this.jdField_a_of_type_Sxe.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramEIPCResult });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sxq
 * JD-Core Version:    0.7.0.1
 */