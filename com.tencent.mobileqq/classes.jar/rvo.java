import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class rvo
  extends Dialog
  implements View.OnClickListener
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public rvo(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public rvo(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, 2131755169);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    requestWindowFeature(1);
    setContentView(2131559922);
    getWindow().setLayout(-1, -1);
    setCancelable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378668));
    this.b = ((TextView)findViewById(2131378667));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369890));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369894));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.b.setOnClickListener(this);
    syo.a(this.b, aekt.a(3.0F, paramContext.getResources()), Color.parseColor("#00CAFC"));
    syo.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, aekt.a(3.0F, paramContext.getResources()), Color.parseColor("#ffffff"));
    getWindow().setWindowAnimations(2131755318);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.b.setText(paramString2);
    }
    show();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rvo
 * JD-Core Version:    0.7.0.1
 */