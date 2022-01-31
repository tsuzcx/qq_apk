import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;

public class njz
  extends Editable.Factory
{
  public njz(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof nsi)) {
      return (Editable)paramCharSequence;
    }
    return new nsi(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njz
 * JD-Core Version:    0.7.0.1
 */