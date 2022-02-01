import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.smallscreen.BaseSmallScreenService;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;

public class lyk
  extends lyn
{
  protected int a;
  protected View a;
  public ImageView a;
  protected TextView a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  
  public lyk(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "SmallScreenAudio";
    paramContext = paramContext.getResources();
    this.i = 2131559767;
    this.j = paramContext.getDimensionPixelSize(2131297832);
    this.k = paramContext.getDimensionPixelSize(2131297826);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(2131297833);
    this.b = paramContext.getDimensionPixelSize(2131297827);
    this.c = paramContext.getDimensionPixelSize(2131297828);
    this.d = paramContext.getDimensionPixelSize(2131297830);
    this.e = paramContext.getDimensionPixelSize(2131297829);
    this.f = paramContext.getDimensionPixelSize(2131297831);
    this.g = paramContext.getDimensionPixelSize(2131297824);
    this.h = paramContext.getDimensionPixelSize(2131297825);
  }
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, lyo paramlyo)
  {
    super.a(paramContext, paramLayoutInflater, paramlyo);
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setTitleHeight(paramContext.getDimensionPixelSize(2131298998) * 5 / 2);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131373513));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131373488));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130772165);
    paramContext = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((paramContext instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramContext).start();
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131373233);
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    Object localObject1;
    Object localObject2;
    if ((paramBaseSmallScreenService instanceof SmallScreenService))
    {
      localObject1 = ((SmallScreenService)paramBaseSmallScreenService).a;
      localObject2 = lbu.a().a();
      if ((localObject1 == null) || (!((VideoController)localObject1).l()) || (((ley)localObject2).a == null) || (((ley)localObject2).a.jdField_a_of_type_JavaLangString == null) || (!((ley)localObject2).a.jdField_a_of_type_JavaLangString.equals("1"))) {}
    }
    for (int i = 1;; i = 0)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      if (paramBaseSmallScreenService.f)
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, this.k);
        if (i != 0) {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842229);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.c;
          ((RelativeLayout.LayoutParams)localObject1).topMargin = this.d;
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.g;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
          return;
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842226);
        }
      }
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.jdField_a_of_type_Int, this.b);
      if (i != 0) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842230);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.e;
        ((RelativeLayout.LayoutParams)localObject1).topMargin = this.f;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.h;
        break;
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setBackgroundResource(2130842228);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lyk
 * JD-Core Version:    0.7.0.1
 */