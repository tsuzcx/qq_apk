import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.common.app.BaseApplicationImpl;
import org.jetbrains.annotations.Nullable;

public abstract class qgf
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  protected ViewGroup a;
  protected ImageView a;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  qgf(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewView = a(paramViewGroup);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131380066);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380058));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380061));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public <T extends View> T a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  abstract View a(ViewGroup paramViewGroup);
  
  public void a()
  {
    a(true);
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    orz localorz1 = new orz();
    int i;
    orz localorz2;
    if (RIJRedPacketManager.a().b())
    {
      i = 1;
      localorz2 = localorz1.a("redpack_status", Integer.valueOf(i)).a("redpack_type", Integer.valueOf(paramInt2)).a("plat_source", Integer.valueOf(paramInt3)).a("action_position", Integer.valueOf(paramInt1));
      if (!bdee.h(BaseApplicationImpl.getContext())) {
        break label137;
      }
    }
    label137:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      localorz2.a("network_type", Integer.valueOf(paramInt1)).a("os", Integer.valueOf(1)).a("imei", ors.f());
      if (!TextUtils.isEmpty(paramString)) {
        localorz1.a("rowkey", paramString);
      }
      nrt.a("0X800ABB5", localorz1.a());
      return;
      i = 0;
      break;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    orz localorz1 = new orz();
    int i;
    orz localorz2;
    if (RIJRedPacketManager.a().b())
    {
      i = 1;
      localorz2 = localorz1.a("redpack_status", Integer.valueOf(i)).a("redpack_type", Integer.valueOf(paramInt1)).a("plat_source", Integer.valueOf(paramInt2));
      if (!bdee.h(BaseApplicationImpl.getContext())) {
        break label126;
      }
    }
    label126:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      localorz2.a("network_type", Integer.valueOf(paramInt1)).a("os", Integer.valueOf(1)).a("imei", ors.f());
      if (!TextUtils.isEmpty(paramString)) {
        localorz1.a("rowkey", paramString);
      }
      nrt.a("0X800ABB4", localorz1.a());
      return;
      i = 0;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    b(true);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new qgg(this));
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  protected void c() {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_b_of_type_AndroidWidgetImageView)
    {
      if ((this instanceof qgh)) {
        RIJRedPacketManager.a().b();
      }
      c();
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qgf
 * JD-Core Version:    0.7.0.1
 */