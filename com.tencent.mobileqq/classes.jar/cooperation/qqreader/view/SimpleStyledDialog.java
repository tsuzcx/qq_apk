package cooperation.qqreader.view;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qqreader.utils.Utility;

public final class SimpleStyledDialog
  extends ReportDialog
{
  private long jdField_a_of_type_Long = 0L;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final boolean jdField_a_of_type_Boolean;
  private final View.OnClickListener b;
  
  private SimpleStyledDialog(SimpleStyledDialog.Builder paramBuilder)
  {
    super(SimpleStyledDialog.Builder.a(paramBuilder), 2131755333);
    Object localObject3 = new LinearLayout(SimpleStyledDialog.Builder.a(paramBuilder));
    ((LinearLayout)localObject3).setOrientation(1);
    ((LinearLayout)localObject3).setBackgroundColor(-1);
    ((LinearLayout)localObject3).setBackgroundDrawable(Utility.a(-1, DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 4.0F)));
    int i = DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 25.0F);
    ((LinearLayout)localObject3).setPadding(i, i, i, i);
    Object localObject4 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject4).gravity = 17;
    ((LinearLayout.LayoutParams)localObject4).setMargins(DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 30.0F), 0, DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 30.0F), 0);
    TextView localTextView = new TextView(SimpleStyledDialog.Builder.a(paramBuilder));
    Object localObject1 = new LinearLayout.LayoutParams(-2, -2);
    localTextView.setTextColor(-16777216);
    localTextView.setTextSize(2, 16.0F);
    localTextView.setTypeface(Typeface.DEFAULT_BOLD);
    ((LinearLayout)localObject3).addView(localTextView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(SimpleStyledDialog.Builder.a(paramBuilder));
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).setMargins(DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 16.5F), 0, 0, DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 18.5F));
    ((TextView)localObject1).setTextColor(-16777216);
    ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    Object localObject5 = new LinearLayout(SimpleStyledDialog.Builder.a(paramBuilder));
    ((LinearLayout)localObject5).setOrientation(0);
    ((LinearLayout)localObject5).setGravity(17);
    Object localObject6 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject6).setMargins(DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), -5.0F), 0, DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), -5.0F), 0);
    localObject2 = new Button(SimpleStyledDialog.Builder.a(paramBuilder));
    ((Button)localObject2).setBackgroundDrawable(Utility.a(-13544, DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 3.0F)));
    i = DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 9.0F);
    ((Button)localObject2).setPadding(0, i, 0, i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
    localLayoutParams.setMargins(DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 5.0F), 0, DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 5.0F), 0);
    ((Button)localObject2).setGravity(17);
    ((Button)localObject2).setTextColor(-16777216);
    ((Button)localObject2).setTextSize(2, 14.0F);
    ((Button)localObject2).setTypeface(Typeface.DEFAULT_BOLD);
    ((LinearLayout)localObject5).addView((View)localObject2, localLayoutParams);
    Button localButton = new Button(SimpleStyledDialog.Builder.a(paramBuilder));
    localButton.setBackgroundDrawable(Utility.a(-1121584, DisplayUtil.a(SimpleStyledDialog.Builder.a(paramBuilder), 3.0F)));
    localButton.setPadding(0, i, 0, i);
    localButton.setGravity(17);
    localButton.setTextColor(-16777216);
    localButton.setTextSize(2, 14.0F);
    localButton.setTypeface(Typeface.DEFAULT_BOLD);
    ((LinearLayout)localObject5).addView(localButton, localLayoutParams);
    ((LinearLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
    addContentView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    this.jdField_a_of_type_Boolean = SimpleStyledDialog.Builder.a(paramBuilder);
    localObject3 = SimpleStyledDialog.Builder.a(paramBuilder);
    localObject4 = SimpleStyledDialog.Builder.b(paramBuilder);
    localObject5 = SimpleStyledDialog.Builder.c(paramBuilder);
    localObject6 = SimpleStyledDialog.Builder.d(paramBuilder);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = SimpleStyledDialog.Builder.a(paramBuilder);
    this.b = SimpleStyledDialog.Builder.b(paramBuilder);
    boolean bool1 = SimpleStyledDialog.Builder.b(paramBuilder);
    boolean bool2 = SimpleStyledDialog.Builder.c(paramBuilder);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)localObject3);
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label726;
      }
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText((CharSequence)localObject4);
      label636:
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        break label736;
      }
      ((Button)localObject2).setVisibility(0);
      ((Button)localObject2).setText((CharSequence)localObject5);
      ((Button)localObject2).setOnClickListener(new SimpleStyledDialog.1(this));
      label670:
      if (TextUtils.isEmpty((CharSequence)localObject6)) {
        break label746;
      }
      localButton.setVisibility(0);
      localButton.setText((CharSequence)localObject6);
      localButton.setOnClickListener(new SimpleStyledDialog.2(this));
    }
    for (;;)
    {
      setCancelable(bool1);
      setCanceledOnTouchOutside(bool2);
      return;
      localTextView.setVisibility(8);
      break;
      label726:
      ((TextView)localObject1).setVisibility(8);
      break label636;
      label736:
      ((Button)localObject2).setVisibility(8);
      break label670;
      label746:
      localButton.setVisibility(8);
    }
  }
  
  private boolean a()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 500L) {
      return false;
    }
    this.jdField_a_of_type_Long = l;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.view.SimpleStyledDialog
 * JD-Core Version:    0.7.0.1
 */