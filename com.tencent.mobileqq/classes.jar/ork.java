import android.text.Editable;
import android.text.Editable.Factory;

public final class ork
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof omv)) {
      return (Editable)paramCharSequence;
    }
    return new omv(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ork
 * JD-Core Version:    0.7.0.1
 */