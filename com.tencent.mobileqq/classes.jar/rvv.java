import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.AppRuntime;

public class rvv
  extends Dialog
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = alud.a(2131713533);
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  
  public rvv(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public rvv(@NonNull Context paramContext, Runnable paramRunnable)
  {
    this(paramContext, 0);
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  private Drawable a()
  {
    float f = aepi.a(3.0F, getContext().getResources());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(Color.parseColor("#12B7F5"));
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    return localShapeDrawable;
  }
  
  private SpannableString a()
  {
    int i = jdField_a_of_type_JavaLangString.indexOf("《QQ看点用户行为规范》");
    SpannableString localSpannableString = new SpannableString(jdField_a_of_type_JavaLangString);
    localSpannableString.setSpan(new rvw(this, Color.parseColor("#12B7F5")), i, "《QQ看点用户行为规范》".length() + i, 33);
    return localSpannableString;
  }
  
  public static boolean a(BaseActivity paramBaseActivity, Runnable paramRunnable)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramBaseActivity);
    boolean bool1 = localSharedPreferences.getBoolean("qq_readinjoy_user_protocol_agreed_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), false);
    boolean bool2 = localSharedPreferences.getString("qq_readinjoy_user_protocol_92_switch_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0").equals("1");
    if ((bool1) || (!bool2))
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return true;
    }
    paramRunnable = new rvv(paramBaseActivity, paramRunnable);
    paramRunnable.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    paramRunnable.show();
    nrt.a(null, "", "0X800992C", "0X800992C", 0, 0, "", "", "", "");
    return false;
  }
  
  private Drawable b()
  {
    float f = aepi.a(3.0F, getContext().getResources());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(-1);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    return localShapeDrawable;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView) {
      dismiss();
    }
    do
    {
      do
      {
        return;
      } while (paramView != this.jdField_a_of_type_AndroidWidgetButton);
      PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putBoolean("qq_readinjoy_user_protocol_agreed_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), true).apply();
      dismiss();
    } while (this.jdField_a_of_type_JavaLangRunnable == null);
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    paramBundle = LayoutInflater.from(getContext()).inflate(2131560000, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131364799));
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramBundle.findViewById(2131362230));
    this.jdField_a_of_type_AndroidViewView = paramBundle.findViewById(2131364343);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a());
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(new rvx());
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(a());
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    Drawable localDrawable = b();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramBundle.findViewById(2131363194).setBackgroundDrawable(localDrawable);
    setContentView(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -2;
    paramBundle.width = aepi.a(320.0F, getContext().getResources());
    getWindow().setAttributes(paramBundle);
    setCancelable(false);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rvv
 * JD-Core Version:    0.7.0.1
 */