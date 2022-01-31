import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;

public class ogc
  extends Editable.Factory
{
  public ogc(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof odp)) {
      return (Editable)paramCharSequence;
    }
    return new odp(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ogc
 * JD-Core Version:    0.7.0.1
 */