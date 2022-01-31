import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;

public class nuu
  extends Editable.Factory
{
  public nuu(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof nsi)) {
      return (Editable)paramCharSequence;
    }
    return new nsi(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nuu
 * JD-Core Version:    0.7.0.1
 */