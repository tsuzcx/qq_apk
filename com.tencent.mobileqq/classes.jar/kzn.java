import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.PublicAccountManager;
import mqq.os.MqqHandler;

public class kzn
  extends BroadcastReceiver
{
  public kzn(PublicAccountManager paramPublicAccountManager, boolean paramBoolean, MqqHandler paramMqqHandler) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("com.tencent.biz.pubaccount.scanResultData");
    int i = paramIntent.getIntExtra("com.tencent.biz.pubaccount.scanResultType", 0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(str, i, 12, -1, null);
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(19);
      }
    }
    try
    {
      for (;;)
      {
        paramContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a);
        label65:
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a = null;
        return;
        this.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.a(str, i, 11, -1, null);
      }
    }
    catch (Exception paramContext)
    {
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzn
 * JD-Core Version:    0.7.0.1
 */