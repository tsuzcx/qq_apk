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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class skm
  extends ReportDialog
  implements View.OnClickListener
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public skm(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public skm(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, 2131755171);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    requestWindowFeature(1);
    setContentView(2131560081);
    getWindow().setLayout(-1, -1);
    setCancelable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379761));
    this.b = ((TextView)findViewById(2131379759));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370453));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370457));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.b.setOnClickListener(this);
    uad.a(this.b, agej.a(3.0F, paramContext.getResources()), Color.parseColor("#00CAFC"));
    uad.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, agej.a(3.0F, paramContext.getResources()), Color.parseColor("#ffffff"));
    getWindow().setWindowAnimations(2131755325);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skm
 * JD-Core Version:    0.7.0.1
 */