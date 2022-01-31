import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.mobileqq.widget.QQToast;

class tdl
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  tdl(tdf paramtdf) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    tdf.a(this.jdField_a_of_type_Tdf).removeTextChangedListener(this);
    if (paramEditable.length() > tdf.b(this.jdField_a_of_type_Tdf))
    {
      QQToast.a(this.jdField_a_of_type_Tdf.getContext(), alud.a(2131702567) + tdf.b(this.jdField_a_of_type_Tdf) + alud.a(2131702568), 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
      tdf.a(this.jdField_a_of_type_Tdf).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      yhf.a(tdf.a(this.jdField_a_of_type_Tdf).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = tdf.a(this.jdField_a_of_type_Tdf).getSelectionEnd();
        }
        try
        {
          tdf.a(this.jdField_a_of_type_Tdf).setText((CharSequence)localObject1);
          tdf.a(this.jdField_a_of_type_Tdf).setSelection(i);
          this.b = 0;
          this.jdField_a_of_type_Int = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            tdf.a(this.jdField_a_of_type_Tdf).setText(paramEditable.toString());
            i = paramEditable.toString().length();
          }
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tdl
 * JD-Core Version:    0.7.0.1
 */