import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;

public class qbo
  extends ViewBase
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public qbo(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramVafContext.getContext());
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramVafContext.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, Utils.dp2px(20.0D));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(Utils.dp2px(5.0D), 0, Utils.dp2px(5.0D), 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 12.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(paramVafContext.getContext().getResources().getDrawable(2130842672), null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(Utils.dp2px(2.0D));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842643));
    paramVafContext = new RelativeLayout.LayoutParams(-2, Utils.dp2px(20.0D));
    paramVafContext.addRule(11);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, Utils.dp2px(12.0D), 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramVafContext);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return (int)(float)bhlo.i();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.measure(paramInt1, paramInt2);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    return false;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = super.setAttribute(paramInt, paramString);
    }
    do
    {
      do
      {
        return bool;
      } while (TextUtils.isEmpty(paramString));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      return true;
      paramInt = nzv.a(paramString, 0);
    } while (paramInt <= 0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, Utils.dp2px(paramInt), 0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbo
 * JD-Core Version:    0.7.0.1
 */