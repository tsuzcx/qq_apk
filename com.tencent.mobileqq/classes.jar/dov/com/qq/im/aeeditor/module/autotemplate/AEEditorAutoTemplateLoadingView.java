package dov.com.qq.im.aeeditor.module.autotemplate;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.utils.ApolloLottieAnim;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorPath.AISCENE.FILES;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class AEEditorAutoTemplateLoadingView
  extends FrameLayout
{
  protected static String a;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  protected LinearLayout a;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim;
  private AEEditorAutoTemplateLoadingView.LoadingListener jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView$LoadingListener;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private DiniFlyAnimationView jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ApolloLottieAnim jdField_b_of_type_ComTencentMobileqqUtilsApolloLottieAnim;
  private String jdField_b_of_type_JavaLangString;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private View d;
  
  static
  {
    jdField_a_of_type_JavaLangString = AEEditorPath.AISCENE.FILES.d + File.separator + "AutoTemplateAnimation" + File.separator;
  }
  
  public AEEditorAutoTemplateLoadingView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorAutoTemplateLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorAutoTemplateLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (a())
    {
      LayoutInflater.from(paramContext).inflate(2131558585, this);
      d();
      return;
    }
    LayoutInflater.from(paramContext).inflate(2131558587, this);
    c();
  }
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 * paramFloat2 / paramFloat1 - 1.0F;
    return (paramFloat1 * (paramFloat1 * paramFloat1 * paramFloat1 * paramFloat1) + 1.0F) * (paramFloat4 - paramFloat3) + paramFloat3;
  }
  
  public static boolean a()
  {
    Object localObject = jdField_a_of_type_JavaLangString + "AutoTemplateImageAnimation";
    String str = jdField_a_of_type_JavaLangString + "AutoTemplateTextAnimation";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(str);
    localObject = localArrayList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!a((String)((Iterator)localObject).next())) {
        break label153;
      }
      i += 1;
    }
    label153:
    for (;;)
    {
      break;
      AEQLog.b("AEEditorAutoTemplateLoadingView", "lottie file count: " + i);
      if ((i >= 0) && (i < 2))
      {
        ThreadManager.excute(new AEEditorAutoTemplateLoadingView.13(), 64, null, true);
        return false;
      }
      return true;
    }
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.exists())
    {
      paramString = paramString.listFiles(new AEEditorAutoTemplateLoadingView.14());
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.length > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c()
  {
    f();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370554));
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new AEEditorAutoTemplateLoadingView.3(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorUpdateListener(new AEEditorAutoTemplateLoadingView.4(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131371065);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377167));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131369470));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131369469));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377171));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379092));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379094));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379095));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376987);
    this.d = findViewById(2131381897);
    this.jdField_a_of_type_Int = UIUtils.a(getContext(), 7.0F);
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
    this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim = new ApolloLottieAnim(null, getContext());
    this.jdField_b_of_type_ComTencentMobileqqUtilsApolloLottieAnim = new ApolloLottieAnim(null, getContext());
    this.jdField_b_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, jdField_a_of_type_JavaLangString + "AutoTemplateImageAnimation" + File.separator, true);
    this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(getContext(), this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, a(), true);
    f();
  }
  
  private void f()
  {
    this.jdField_c_of_type_AndroidViewView = findViewById(2131364365);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new AEEditorAutoTemplateLoadingView.5(this));
  }
  
  private void g()
  {
    AEQLog.a("AEEditorAutoTemplateLoadingView", "showResultAnimation start.");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.animate().setDuration(100L).alpha(0.0F).start();
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.animate().setDuration(100L).alpha(0.0F).start();
    int i;
    if (getResources().getString(2131689708).equals(this.jdField_b_of_type_JavaLangString))
    {
      i = 1;
      this.d.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator1.setDuration(1000L);
      localValueAnimator1.addUpdateListener(new AEEditorAutoTemplateLoadingView.6(this));
      localValueAnimator1.addListener(new AEEditorAutoTemplateLoadingView.7(this));
      ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator2.setDuration(1000L);
      localValueAnimator2.addUpdateListener(new AEEditorAutoTemplateLoadingView.8(this));
      ValueAnimator localValueAnimator3 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator3.setDuration(1000L);
      localValueAnimator3.addUpdateListener(new AEEditorAutoTemplateLoadingView.9(this));
      ValueAnimator localValueAnimator4 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator4.setDuration(500L);
      localValueAnimator4.addUpdateListener(new AEEditorAutoTemplateLoadingView.10(this));
      if (i == 0)
      {
        this.jdField_b_of_type_AndroidViewView.setAlpha(0.0F);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setMinimumWidth(this.jdField_a_of_type_AndroidWidgetTextView.getWidth() + Utils.dp2px(20.0D));
        ValueAnimator localValueAnimator5 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localValueAnimator5.setDuration(1000L);
        localValueAnimator5.addUpdateListener(new AEEditorAutoTemplateLoadingView.11(this));
        localAnimatorSet.play(localValueAnimator4).before(localValueAnimator1);
        localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2).with(localValueAnimator5);
        localAnimatorSet.play(localValueAnimator3).after(localValueAnimator1);
      }
      for (;;)
      {
        localAnimatorSet.addListener(new AEEditorAutoTemplateLoadingView.12(this));
        localAnimatorSet.start();
        AEQLog.a("AEEditorAutoTemplateLoadingView", "showResultAnimation end.");
        return;
        localAnimatorSet.play(localValueAnimator4).before(localValueAnimator1);
        localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2);
        localAnimatorSet.play(localValueAnimator3).after(localValueAnimator1);
      }
      i = 0;
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString + "AutoTemplateTextAnimation" + File.separator;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("cancelLoading: ");
    if (getParent() == null) {}
    for (boolean bool = true;; bool = false)
    {
      AEQLog.a("AEEditorAutoTemplateLoadingView", bool);
      if (getParent() != null) {
        break;
      }
      return;
    }
    ((ViewGroup)getParent()).removeAllViews();
  }
  
  public void b()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void setLoadingListener(AEEditorAutoTemplateLoadingView.LoadingListener paramLoadingListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView$LoadingListener = paramLoadingListener;
  }
  
  public void setSceneText(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString3);
    }
  }
  
  public void setShowResult(boolean paramBoolean)
  {
    AEQLog.a("AEEditorAutoTemplateLoadingView", "setShowResult: " + paramBoolean);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new AEEditorAutoTemplateLoadingView.1(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.post(new AEEditorAutoTemplateLoadingView.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateLoadingView
 * JD-Core Version:    0.7.0.1
 */