import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

class oml
  implements bhqd
{
  oml(omg paramomg, bhpy parambhpy, int[] paramArrayOfInt, Context paramContext, olz paramolz) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bhpy.dismiss();
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    bdfq localbdfq = new bdfq(this.jdField_a_of_type_AndroidContentContext, 2131755801);
    localbdfq.setContentView(2131558920);
    localbdfq.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131718770), new Object[] { paramView }));
    localbdfq.setTitle(2131718771);
    ViewGroup.LayoutParams localLayoutParams = localbdfq.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = bdkf.a(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = bdkf.a(12.0F);
      localbdfq.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localbdfq.setTag(paramView);
    localbdfq.setPositiveButton(2131718773, new omm(this, paramView, paramInt + 1));
    localbdfq.setNegativeButton(2131718772, new omn(this));
    localbdfq.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oml
 * JD-Core Version:    0.7.0.1
 */