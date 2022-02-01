import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJWatchWordJumpDialog;", "Landroid/view/View$OnClickListener;", "parent", "Landroid/view/ViewGroup;", "jumpAction", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "clickType", "", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "closeButton", "Landroid/widget/ImageView;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "dialogLayout", "Landroid/widget/RelativeLayout;", "isShowing", "", "getJumpAction", "()Lkotlin/jvm/functions/Function1;", "maskView", "moreButton", "Landroid/widget/TextView;", "getParent", "()Landroid/view/ViewGroup;", "createView", "dismiss", "needAnimation", "findViewById", "T", "id", "(I)Landroid/view/View;", "initOnClickListener", "onClick", "v", "show", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class raa
  implements View.OnClickListener
{
  public static final rab a;
  @Nullable
  private final View jdField_a_of_type_AndroidViewView;
  @NotNull
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private final Function1<Integer, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  private boolean jdField_a_of_type_Boolean;
  private final View b;
  
  static
  {
    jdField_a_of_type_Rab = new rab(null);
  }
  
  public raa(@NotNull ViewGroup paramViewGroup, @Nullable Function1<? super Integer, Unit> paramFunction1)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
    this.jdField_a_of_type_AndroidViewView = b();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364630));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371361));
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131370613);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365574));
    c();
  }
  
  private final void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setOnClickListener((View.OnClickListener)this);
    }
  }
  
  @Nullable
  protected final View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  @Nullable
  protected final <T extends View> T a(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      return localView.findViewById(paramInt);
    }
    return null;
  }
  
  @NotNull
  protected final ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  @Nullable
  protected final Function1<Integer, Unit> a()
  {
    return this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
  }
  
  public final void a()
  {
    a(true);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setFillAfter(true);
      View localView = this.b;
      if (localView != null) {
        localView.startAnimation((Animation)localAlphaAnimation);
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  @NotNull
  protected abstract View b();
  
  public final void b()
  {
    b(true);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(250L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener((Animation.AnimationListener)new rac(this));
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        localView.startAnimation((Animation)localAlphaAnimation);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public void onClick(@Nullable View paramView)
  {
    Object localObject;
    if (Intrinsics.areEqual(paramView, this.jdField_a_of_type_AndroidWidgetImageView))
    {
      localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (localObject != null) {
        localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(0));
      }
      b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (Intrinsics.areEqual(paramView, this.jdField_a_of_type_AndroidWidgetTextView))
      {
        localObject = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
        if (localObject != null) {
          localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(1));
        }
        b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     raa
 * JD-Core Version:    0.7.0.1
 */