import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.anonymous.QQAnonymousDialog.2;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;

public class nba
  extends Dialog
{
  public int a;
  public Context a;
  public Handler a;
  public LayoutInflater a;
  public View a;
  public ImageView a;
  public TextView a;
  
  public nba(Context paramContext)
  {
    super(paramContext, 2131755801);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new nbb(this));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560405, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369756));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369767));
  }
  
  public void a()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = ((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 44.0F));
    localLayoutParams.height = ((int)bdcq.a(this.jdField_a_of_type_AndroidContentContext, 44.0F));
    super.show();
    this.jdField_a_of_type_AndroidViewView.postDelayed(new QQAnonymousDialog.2(this), 1000L);
  }
  
  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
    case 1: 
    case 3: 
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843236);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
        } while (!AppSetting.c);
        QQAppInterface.f(paramString);
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843230);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      } while (!AppSetting.c);
      QQAppInterface.f(paramString);
      return;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843235);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696531));
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.gravity = 17;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nba
 * JD-Core Version:    0.7.0.1
 */