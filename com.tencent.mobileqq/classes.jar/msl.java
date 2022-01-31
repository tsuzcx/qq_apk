import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter;
import java.io.Serializable;
import java.util.ArrayList;

class msl
  implements Runnable
{
  msl(msi parammsi, Serializable paramSerializable) {}
  
  public void run()
  {
    SubscriptFeedsActivity localSubscriptFeedsActivity;
    if ((this.jdField_a_of_type_JavaIoSerializable != null) && (SubscriptFeedsActivity.a(this.jdField_a_of_type_Msi.a) != null))
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Msi.a, (ArrayList)this.jdField_a_of_type_JavaIoSerializable);
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Msi.a).b(SubscriptFeedsActivity.a(this.jdField_a_of_type_Msi.a));
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Msi.a).a = true;
      localSubscriptFeedsActivity = this.jdField_a_of_type_Msi.a;
      if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Msi.a).f != 1) {
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
 * Qualified Name:     msl
 * JD-Core Version:    0.7.0.1
 */