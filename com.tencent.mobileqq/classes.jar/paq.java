import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

class paq
  implements bkhw
{
  paq(pan parampan, bkho parambkho, int[] paramArrayOfInt, Context paramContext, pag parampag) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkho.dismiss();
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    bgpa localbgpa = new bgpa(this.jdField_a_of_type_AndroidContentContext, 2131755823);
    localbgpa.setContentView(2131558985);
    localbgpa.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131716924), new Object[] { paramView }));
    localbgpa.setTitle(2131716925);
    ViewGroup.LayoutParams localLayoutParams = localbgpa.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = bgtn.a(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = bgtn.a(12.0F);
      localbgpa.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localbgpa.setTag(paramView);
    localbgpa.setPositiveButton(2131716927, new par(this, paramView, paramInt + 1));
    localbgpa.setNegativeButton(2131716926, new pas(this));
    localbgpa.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     paq
 * JD-Core Version:    0.7.0.1
 */