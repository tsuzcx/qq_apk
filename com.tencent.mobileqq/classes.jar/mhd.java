import android.app.Notification;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class mhd
{
  float jdField_a_of_type_Float = 14.0F;
  Context jdField_a_of_type_AndroidContentContext;
  DisplayMetrics jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
  Integer jdField_a_of_type_JavaLangInteger = null;
  String jdField_a_of_type_JavaLangString = "NotificationStyleDiscover";
  float jdField_b_of_type_Float = 16.0F;
  Integer jdField_b_of_type_JavaLangInteger = null;
  final String jdField_b_of_type_JavaLangString = "SearchForText";
  final String c = "SearchForTitle";
  
  public mhd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    if ((this.jdField_a_of_type_JavaLangInteger != null) && (this.jdField_b_of_type_JavaLangInteger != null)) {
      return;
    }
    try
    {
      Object localObject = new Notification();
      ((Notification)localObject).setLatestEventInfo(this.jdField_a_of_type_AndroidContentContext, "SearchForTitle", "SearchForText", null);
      paramContext = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject = (ViewGroup)((Notification)localObject).contentView.apply(this.jdField_a_of_type_AndroidContentContext, paramContext);
      a((ViewGroup)localObject);
      b((ViewGroup)localObject);
      paramContext.removeAllViews();
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "erro");
    }
  }
  
  boolean a(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForTitle".equals(localTextView.getText().toString()))
        {
          this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.jdField_b_of_type_Float = localTextView.getTextSize();
          this.jdField_b_of_type_Float /= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (a((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean b(ViewGroup paramViewGroup)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      if ((paramViewGroup.getChildAt(i) instanceof TextView))
      {
        TextView localTextView = (TextView)paramViewGroup.getChildAt(i);
        if ("SearchForText".equals(localTextView.getText().toString()))
        {
          this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(localTextView.getTextColors().getDefaultColor());
          this.jdField_a_of_type_Float = localTextView.getTextSize();
          this.jdField_a_of_type_Float /= this.jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
          return true;
        }
      }
      else if (((paramViewGroup.getChildAt(i) instanceof ViewGroup)) && (b((ViewGroup)paramViewGroup.getChildAt(i))))
      {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mhd
 * JD-Core Version:    0.7.0.1
 */