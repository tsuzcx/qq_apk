import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

class oia
  implements bfoq
{
  oia(ohv paramohv, bfol parambfol, int[] paramArrayOfInt, Context paramContext, oho paramoho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfol.dismiss();
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    bbgg localbbgg = new bbgg(this.jdField_a_of_type_AndroidContentContext, 2131755791);
    localbbgg.setContentView(2131558883);
    localbbgg.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131718352), new Object[] { paramView }));
    localbbgg.setTitle(2131718353);
    ViewGroup.LayoutParams localLayoutParams = localbbgg.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = bbkx.a(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = bbkx.a(12.0F);
      localbbgg.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localbbgg.setTag(paramView);
    localbbgg.setPositiveButton(2131718355, new oib(this, paramView, paramInt + 1));
    localbbgg.setNegativeButton(2131718354, new oic(this));
    localbbgg.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     oia
 * JD-Core Version:    0.7.0.1
 */