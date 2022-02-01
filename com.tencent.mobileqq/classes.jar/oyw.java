import android.text.Editable;
import android.text.Editable.Factory;

public final class oyw
  extends Editable.Factory
{
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof oui)) {
      return (Editable)paramCharSequence;
    }
    return new oui(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyw
 * JD-Core Version:    0.7.0.1
 */