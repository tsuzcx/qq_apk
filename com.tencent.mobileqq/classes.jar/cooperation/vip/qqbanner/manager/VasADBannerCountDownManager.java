package cooperation.vip.qqbanner.manager;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.vip.qqbanner.data.CountDownData;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerCountDownInfo;
import java.util.Timer;
import java.util.TimerTask;

public class VasADBannerCountDownManager
  extends VasADBannerManager
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VasADBannerCountDownInfo jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerCountDownInfo;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private TextView b;
  private TextView c;
  
  private Drawable a(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.b(20.0F));
    localGradientDrawable.setColor(a(paramString));
    return localGradientDrawable;
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_CooperationVipQqbannerInfoVasADBannerCountDownInfo;
    if (localObject == null) {
      return "";
    }
    localObject = ((VasADBannerCountDownInfo)localObject).a();
    if (localObject == null) {
      return "";
    }
    if (((CountDownData)localObject).a != 1) {
      return ((CountDownData)localObject).f;
    }
    return a(((CountDownData)localObject).b, ((CountDownData)localObject).c);
  }
  
  private String a(int paramInt1, int paramInt2)
  {
    Object localObject3 = "00";
    Object localObject1;
    if (paramInt1 > 99)
    {
      localObject1 = "99";
    }
    else if ((paramInt1 >= 10) && (paramInt1 <= 99))
    {
      localObject1 = String.valueOf(paramInt1);
    }
    else if ((paramInt1 >= 0) && (paramInt1 < 10))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(String.valueOf(paramInt1));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "00";
    }
    Object localObject2;
    if (paramInt2 > 59)
    {
      localObject2 = "59";
    }
    else if ((paramInt2 >= 10) && (paramInt2 <= 59))
    {
      localObject2 = String.valueOf(paramInt2);
    }
    else
    {
      localObject2 = localObject3;
      if (paramInt2 >= 0)
      {
        localObject2 = localObject3;
        if (paramInt2 < 10)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("0");
          ((StringBuilder)localObject2).append(String.valueOf(paramInt2));
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append((String)localObject2);
    return ((StringBuilder)localObject3).toString();
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    this.c.setText(paramString);
  }
  
  private void h()
  {
    i();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimerTask = new VasADBannerCountDownManager.2(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_JavaUtilTimerTask, 0L, 1000L);
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilTimerTask;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_JavaUtilTimerTask = null;
  }
  
  protected int a()
  {
    return 2131561931;
  }
  
  public View a()
  {
    View localView = super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379767));
    this.b = ((TextView)localView.findViewById(2131379870));
    this.c = ((TextView)localView.findViewById(2131379541));
    return localView;
  }
  
  public void a()
  {
    super.a();
    i();
  }
  
  protected void a(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    super.a(paramVasADBannerConfigInfo);
    ThreadManagerV2.getUIHandlerV2().post(new VasADBannerCountDownManager.1(this, paramVasADBannerConfigInfo));
  }
  
  public void b()
  {
    super.b();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerCountDownManager
 * JD-Core Version:    0.7.0.1
 */