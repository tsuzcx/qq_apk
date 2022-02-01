import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.push.mvp.RIJPushNotifyDialog.dismiss.1;
import com.tencent.biz.pubaccount.readinjoy.push.mvp.RIJPushNotifyDialog.show.1;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/push/mvp/RIJPushNotifyDialog;", "", "parent", "Landroid/view/ViewGroup;", "param", "Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyParam;", "(Landroid/view/ViewGroup;Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyParam;)V", "avatarImageView", "Landroid/widget/ImageView;", "buttonLayout", "closeIcon", "closeTextView", "Landroid/widget/TextView;", "contentView", "Landroid/view/View;", "defaultOpenTextView", "handler", "Landroid/os/Handler;", "isSelected", "", "isShowing", "maskView", "observer", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadInJoyObserver;", "openTextView", "rejectTextView", "titleTextView", "dismiss", "", "needAnimation", "initCallback", "initListener", "initUI", "playAnimation", "isShow", "callback", "Lkotlin/Function0;", "show", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qor
{
  public static final qot a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final View jdField_a_of_type_AndroidViewView;
  private final ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final pkt jdField_a_of_type_Pkt;
  private final qop jdField_a_of_type_Qop;
  private boolean jdField_a_of_type_Boolean;
  private final View jdField_b_of_type_AndroidViewView;
  private final ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private final ImageView jdField_b_of_type_AndroidWidgetImageView;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private final TextView c;
  private final TextView d;
  private final TextView e;
  
  static
  {
    jdField_a_of_type_Qot = new qot(null);
  }
  
  public qor(@NotNull ViewGroup paramViewGroup, @NotNull qop paramqop)
  {
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Qop = paramqop;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_b_of_type_AndroidViewViewGroup.getContext()).inflate(2131562676, this.jdField_b_of_type_AndroidViewViewGroup, false);
    paramViewGroup = this.jdField_b_of_type_AndroidViewView;
    if (paramViewGroup != null)
    {
      paramViewGroup = paramViewGroup.findViewById(2131373195);
      this.jdField_a_of_type_AndroidViewView = paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      if (paramViewGroup == null) {
        break label310;
      }
      paramViewGroup = (ImageView)paramViewGroup.findViewById(2131373189);
      label104:
      this.jdField_a_of_type_AndroidWidgetImageView = paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      if (paramViewGroup == null) {
        break label315;
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131373199);
      label128:
      this.jdField_a_of_type_AndroidWidgetTextView = paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      if (paramViewGroup == null) {
        break label320;
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131373193);
      label152:
      this.jdField_b_of_type_AndroidWidgetTextView = paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      if (paramViewGroup == null) {
        break label325;
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131365366);
      label176:
      this.c = paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      if (paramViewGroup == null) {
        break label330;
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131373197);
      label200:
      this.d = paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      if (paramViewGroup == null) {
        break label335;
      }
      paramViewGroup = (ImageView)paramViewGroup.findViewById(2131364630);
      label224:
      this.jdField_b_of_type_AndroidWidgetImageView = paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      if (paramViewGroup == null) {
        break label340;
      }
      paramViewGroup = (TextView)paramViewGroup.findViewById(2131373194);
      label248:
      this.e = paramViewGroup;
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      if (paramViewGroup == null) {
        break label345;
      }
    }
    label310:
    label315:
    label320:
    label325:
    label330:
    label335:
    label340:
    label345:
    for (paramViewGroup = (ViewGroup)paramViewGroup.findViewById(2131373192);; paramViewGroup = null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
      this.jdField_a_of_type_Pkt = ((pkt)new qos(this));
      b();
      c();
      a();
      return;
      paramViewGroup = null;
      break;
      paramViewGroup = null;
      break label104;
      paramViewGroup = null;
      break label128;
      paramViewGroup = null;
      break label152;
      paramViewGroup = null;
      break label176;
      paramViewGroup = null;
      break label200;
      paramViewGroup = null;
      break label224;
      paramViewGroup = null;
      break label248;
    }
  }
  
  private final void a()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)new qou(this));
    }
  }
  
  private final void a(boolean paramBoolean, Function0<Unit> paramFunction0)
  {
    TranslateAnimation localTranslateAnimation;
    if (paramBoolean)
    {
      localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, DisplayUtil.dip2px(this.jdField_b_of_type_AndroidViewViewGroup.getContext(), 152.0F), 0.0F);
      localTranslateAnimation.setDuration(300L);
      if (!paramBoolean) {
        break label155;
      }
    }
    label155:
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);; localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F))
    {
      localAlphaAnimation.setDuration(300L);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation((Animation)localAlphaAnimation);
      localAnimationSet.addAnimation((Animation)localTranslateAnimation);
      localAnimationSet.setAnimationListener((Animation.AnimationListener)new qpa(paramFunction0));
      localAnimationSet.setFillAfter(true);
      paramFunction0 = this.jdField_a_of_type_AndroidViewView;
      if (paramFunction0 != null) {
        paramFunction0.startAnimation((Animation)localAnimationSet);
      }
      return;
      localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, DisplayUtil.dip2px(this.jdField_b_of_type_AndroidViewViewGroup.getContext(), 152.0F));
      break;
    }
  }
  
  private final void b()
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)new ColorDrawable(0));
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)new ColorDrawable(0));
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    Object localObject1;
    if (localImageView != null)
    {
      if (((CharSequence)this.jdField_a_of_type_Qop.a()).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label599;
        }
        localObject1 = "https://pub.idqqimg.com/pc/misc/files/20200610/b0f587d6911f4930ae03a1817e90ac00.png";
        label79:
        localImageView.setImageDrawable((Drawable)URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label610;
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      label106:
      localObject2 = localObject1;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        localObject2 = null;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject2;
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.jdField_a_of_type_Qop.b();
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)qoj.a.a().a());
      }
      if (this.jdField_a_of_type_Qop.a() != 1) {
        break label615;
      }
      localObject1 = this.d;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)qoj.a.a().b());
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)qoj.a.a().c());
      }
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(8);
      }
      label266:
      if (!this.jdField_a_of_type_Qop.a()) {
        break label763;
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130849353, 0, 0, 0);
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(Color.parseColor("#FF333333"));
      }
      localObject2 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        if (localObject1 == null) {
          break label748;
        }
        localObject1 = ((Context)localObject1).getResources();
        if (localObject1 == null) {
          break label748;
        }
        localObject1 = ((Resources)localObject1).getDrawable(2130849349);
        label352:
        ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      }
      localObject1 = this.d;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFFFFFFF"));
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFD8D8D8"));
      }
      localObject2 = this.e;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        if (localObject1 == null) {
          break label753;
        }
        localObject1 = ((Context)localObject1).getResources();
        if (localObject1 == null) {
          break label753;
        }
        localObject1 = ((Resources)localObject1).getDrawable(2130849355);
        label433:
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        if (localObject1 == null) {
          break label758;
        }
        localObject1 = ((Context)localObject1).getResources();
        if (localObject1 == null) {
          break label758;
        }
        localObject1 = ((Resources)localObject1).getDrawable(2130849355);
        label476:
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null)
      {
        localObject4 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((Context)localObject4).getResources();
          localObject1 = localObject3;
          if (localObject4 != null) {
            localObject1 = ((Resources)localObject4).getDrawable(2130849351);
          }
        }
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#FFFFFFFF"));
      }
      localObject1 = this.jdField_b_of_type_AndroidViewView;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).findViewById(2131371802);
        if (localObject1 != null) {
          if (!this.jdField_a_of_type_Qop.b()) {
            break label1060;
          }
        }
      }
    }
    label920:
    label1050:
    label1055:
    label1060:
    for (int i = 0;; i = 8)
    {
      ((View)localObject1).setVisibility(i);
      return;
      i = 0;
      break;
      label599:
      localObject1 = this.jdField_a_of_type_Qop.a();
      break label79;
      label610:
      localObject1 = null;
      break label106;
      label615:
      if (this.jdField_a_of_type_Qop.a() != 2) {
        break label266;
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).setVisibility(0);
      }
      localObject1 = this.d;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)qoj.a.a().d());
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)qoj.a.a().e());
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localObject1 == null) {
        break label266;
      }
      ((TextView)localObject1).setText((CharSequence)qoj.a.a().f());
      break label266;
      label748:
      localObject1 = null;
      break label352;
      label753:
      localObject1 = null;
      break label433;
      label758:
      localObject1 = null;
      break label476;
      label763:
      localObject1 = this.c;
      if (localObject1 != null) {
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130849354, 0, 0, 0);
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
      }
      localObject2 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 != null)
          {
            localObject1 = ((Resources)localObject1).getDrawable(2130849350);
            label839:
            ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
          }
        }
      }
      else
      {
        localObject1 = this.d;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#FF000000"));
        }
        localObject1 = this.c;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#FFA8A8A8"));
        }
        localObject2 = this.e;
        if (localObject2 != null)
        {
          localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
          if (localObject1 == null) {
            break label1050;
          }
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 == null) {
            break label1050;
          }
          localObject1 = ((Resources)localObject1).getDrawable(2130849345);
          ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
        }
        localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
        if (localObject2 != null)
        {
          localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
          if (localObject1 == null) {
            break label1055;
          }
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 == null) {
            break label1055;
          }
        }
      }
      for (localObject1 = ((Resources)localObject1).getDrawable(2130849345);; localObject1 = null)
      {
        ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject2 != null)
        {
          localObject3 = this.jdField_b_of_type_AndroidViewViewGroup.getContext();
          localObject1 = localObject4;
          if (localObject3 != null)
          {
            localObject3 = ((Context)localObject3).getResources();
            localObject1 = localObject4;
            if (localObject3 != null) {
              localObject1 = ((Resources)localObject3).getDrawable(2130849346);
            }
          }
          ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject1 == null) {
          break;
        }
        ((TextView)localObject1).setTextColor(Color.parseColor("#FF000000"));
        break;
        localObject1 = null;
        break label839;
        localObject1 = null;
        break label920;
      }
    }
  }
  
  private final void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new qov(this));
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new qow(this));
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new qox(this));
    }
    localObject = this.e;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new qoy(this));
    }
    localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener((View.OnClickListener)new qoz(this));
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    QLog.i("RIJPushNotifyDialog", 1, toString() + " show isShowing: " + this.jdField_a_of_type_Boolean + " needAnimation: " + paramBoolean);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidViewView);
    if (paramBoolean) {
      a(this, true, null, 2, null);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed((Runnable)new RIJPushNotifyDialog.show.1(this), qoj.a.a().a());
  }
  
  public final void b(boolean paramBoolean)
  {
    QLog.i("RIJPushNotifyDialog", 1, toString() + " dismiss isShowing: " + this.jdField_a_of_type_Boolean + " needAnimation: " + paramBoolean);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramBoolean) {
      a(false, (Function0)new RIJPushNotifyDialog.dismiss.1(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
      View localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qor
 * JD-Core Version:    0.7.0.1
 */