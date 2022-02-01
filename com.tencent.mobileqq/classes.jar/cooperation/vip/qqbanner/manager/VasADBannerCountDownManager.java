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
  private TextView e;
  private TextView f;
  private TextView g;
  private Timer h;
  private TimerTask i;
  private VasADBannerCountDownInfo j;
  
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
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
    this.g.setText(paramString);
  }
  
  private Drawable d(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.dpToPx(20.0F));
    localGradientDrawable.setColor(a(paramString));
    return localGradientDrawable;
  }
  
  private void m()
  {
    n();
    this.h = new Timer();
    this.i = new VasADBannerCountDownManager.2(this);
    this.h.schedule(this.i, 0L, 1000L);
  }
  
  private void n()
  {
    Object localObject = this.i;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    localObject = this.h;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    this.h = null;
    this.i = null;
  }
  
  private String o()
  {
    Object localObject = this.j;
    if (localObject == null) {
      return "";
    }
    localObject = ((VasADBannerCountDownInfo)localObject).f();
    if (localObject == null) {
      return "";
    }
    if (((CountDownData)localObject).a != 1) {
      return ((CountDownData)localObject).i;
    }
    return a(((CountDownData)localObject).b, ((CountDownData)localObject).c);
  }
  
  public View a()
  {
    View localView = super.a();
    this.e = ((TextView)localView.findViewById(2131448576));
    this.f = ((TextView)localView.findViewById(2131448728));
    this.g = ((TextView)localView.findViewById(2131448293));
    return localView;
  }
  
  protected void a(VasADBannerConfigInfo paramVasADBannerConfigInfo)
  {
    super.a(paramVasADBannerConfigInfo);
    ThreadManagerV2.getUIHandlerV2().post(new VasADBannerCountDownManager.1(this, paramVasADBannerConfigInfo));
  }
  
  protected int b()
  {
    return 2131628355;
  }
  
  public void c()
  {
    super.c();
    n();
  }
  
  public void d()
  {
    super.d();
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerCountDownManager
 * JD-Core Version:    0.7.0.1
 */