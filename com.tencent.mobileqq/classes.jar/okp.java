import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;

public class okp
  extends Editable.Factory
{
  public okp(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof ohr)) {
      return (Editable)paramCharSequence;
    }
    return new ohr(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okp
 * JD-Core Version:    0.7.0.1
 */