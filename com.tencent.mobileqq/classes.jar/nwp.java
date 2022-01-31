import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

class nwp
  implements begw
{
  nwp(nwk paramnwk, begr parambegr, int[] paramArrayOfInt, Context paramContext, nwd paramnwd) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Begr.dismiss();
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext.getString(this.jdField_a_of_type_ArrayOfInt[paramInt]);
    bafb localbafb = new bafb(this.jdField_a_of_type_AndroidContentContext, 2131690181);
    localbafb.setContentView(2131493323);
    localbafb.setMessage(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131652533), new Object[] { paramView }));
    localbafb.setTitle(2131652534);
    ViewGroup.LayoutParams localLayoutParams = localbafb.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = bajq.a(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = bajq.a(12.0F);
      localbafb.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localbafb.setTag(paramView);
    localbafb.setPositiveButton(2131652536, new nwq(this, paramView, paramInt + 1));
    localbafb.setNegativeButton(2131652535, new nwr(this));
    localbafb.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nwp
 * JD-Core Version:    0.7.0.1
 */