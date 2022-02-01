import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

class otg
  implements bliz
{
  otg(otd paramotd, blir paramblir, int[] paramArrayOfInt, Context paramContext, osv paramosv) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Blir.dismiss();
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    bhpc localbhpc = new bhpc(this.jdField_a_of_type_AndroidContentContext, 2131755824);
    localbhpc.setContentView(2131558984);
    localbhpc.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131717040), new Object[] { paramView }));
    localbhpc.setTitle(2131717041);
    ViewGroup.LayoutParams localLayoutParams = localbhpc.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = bhtq.a(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = bhtq.a(12.0F);
      localbhpc.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localbhpc.setTag(paramView);
    localbhpc.setPositiveButton(2131717043, new oth(this, paramView, paramInt + 1));
    localbhpc.setNegativeButton(2131717042, new oti(this));
    localbhpc.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otg
 * JD-Core Version:    0.7.0.1
 */