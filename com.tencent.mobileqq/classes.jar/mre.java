import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsAdapter;
import java.io.Serializable;
import java.util.ArrayList;

class mre
  implements Runnable
{
  mre(mrb parammrb, Serializable paramSerializable) {}
  
  public void run()
  {
    SubscriptFeedsActivity localSubscriptFeedsActivity;
    if ((this.jdField_a_of_type_JavaIoSerializable != null) && (SubscriptFeedsActivity.a(this.jdField_a_of_type_Mrb.a) != null))
    {
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Mrb.a, (ArrayList)this.jdField_a_of_type_JavaIoSerializable);
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Mrb.a).b(SubscriptFeedsActivity.a(this.jdField_a_of_type_Mrb.a));
      SubscriptFeedsActivity.a(this.jdField_a_of_type_Mrb.a).a = true;
      localSubscriptFeedsActivity = this.jdField_a_of_type_Mrb.a;
      if (SubscriptFeedsActivity.a(this.jdField_a_of_type_Mrb.a).f != 1) {
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
 * Qualified Name:     mre
 * JD-Core Version:    0.7.0.1
 */