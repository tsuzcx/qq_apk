import android.text.Editable;
import android.text.Editable.Factory;

class pde
  extends Editable.Factory
{
  pde(pdd parampdd) {}
  
  public Editable newEditable(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof owe)) {
      return (Editable)paramCharSequence;
    }
    return new owe(paramCharSequence, 3, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pde
 * JD-Core Version:    0.7.0.1
 */