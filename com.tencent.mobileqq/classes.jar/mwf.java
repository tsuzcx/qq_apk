import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter;
import java.io.Serializable;
import java.util.ArrayList;

class mwf
  implements Runnable
{
  mwf(mwc parammwc, Serializable paramSerializable) {}
  
  public void run()
  {
    SubscriptFeedsActivity localSubscriptFeedsActivity;
    if ((this.jdField_a_of_type_JavaIoSerializable != null) && (SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a) != null))
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a, (ArrayList)this.jdField_a_of_type_JavaIoSerializable);
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a).b(SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a));
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a).a = true;
      localSubscriptFeedsActivity = this.jdField_a_of_type_Mwc.a;
      if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Mwc.a).f != 1) {
        break label110;
      }
    }
    label110:
    for (boolean bool = true;; bool = false)
    {
      SubscriptFeedsActivity.a(localSubscriptFeedsActivity, false, false, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwf
 * JD-Core Version:    0.7.0.1
 */