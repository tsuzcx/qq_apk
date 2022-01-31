import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity;

class msy
  implements Runnable
{
  msy(msx parammsx, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_Msx.a.leftView.setText(2131433297);
      return;
    }
    if (this.jdField_a_of_type_Int > 99)
    {
      this.jdField_a_of_type_Msx.a.leftView.setText(String.format("%s(%d+)", new Object[] { this.jdField_a_of_type_Msx.a.getString(2131433297), Integer.valueOf(99) }));
      return;
    }
    this.jdField_a_of_type_Msx.a.leftView.setText(String.format("%s(%d)", new Object[] { this.jdField_a_of_type_Msx.a.getString(2131433297), Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     msy
 * JD-Core Version:    0.7.0.1
 */