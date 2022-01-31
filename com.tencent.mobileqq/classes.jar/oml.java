import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

class oml
  implements bhuk
{
  oml(omg paramomg, bhuf parambhuf, int[] paramArrayOfInt, Context paramContext, olz paramolz) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhuf.dismiss();
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    bdjz localbdjz = new bdjz(this.jdField_a_of_type_AndroidContentContext, 2131755801);
    localbdjz.setContentView(2131558919);
    localbdjz.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131718782), new Object[] { paramView }));
    localbdjz.setTitle(2131718783);
    ViewGroup.LayoutParams localLayoutParams = localbdjz.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = bdoo.a(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = bdoo.a(12.0F);
      localbdjz.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localbdjz.setTag(paramView);
    localbdjz.setPositiveButton(2131718785, new omm(this, paramView, paramInt + 1));
    localbdjz.setNegativeButton(2131718784, new omn(this));
    localbdjz.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oml
 * JD-Core Version:    0.7.0.1
 */