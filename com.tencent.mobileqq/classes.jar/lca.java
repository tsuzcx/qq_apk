import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuTextBuilder;

public class lca
  extends Editable.Factory
{
  public lca(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof BiuTextBuilder)) {
      return (Editable)paramCharSequence;
    }
    return new BiuTextBuilder(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lca
 * JD-Core Version:    0.7.0.1
 */