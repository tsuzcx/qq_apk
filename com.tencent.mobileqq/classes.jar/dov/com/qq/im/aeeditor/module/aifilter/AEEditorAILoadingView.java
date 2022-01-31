package dov.com.qq.im.aeeditor.module.aifilter;

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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import blfg;
import blfu;
import blgi;
import blgj;
import blgk;
import blgl;
import blgm;
import blgn;
import blgo;
import blgp;
import blgq;
import blgr;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class AEEditorAILoadingView
  extends FrameLayout
{
  protected static String a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blgr jdField_a_of_type_Blgr;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ApolloLottieAnim jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ApolloLottieAnim jdField_c_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ApolloLottieAnim jdField_d_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  
  static
  {
    jdField_a_of_type_JavaLangString = blfu.d + File.separator + "ProcessAnimation" + File.separator;
  }
  
  public AEEditorAILoadingView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorAILoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorAILoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (a())
    {
      LayoutInflater.from(paramContext).inflate(2131558535, this);
      c();
      return;
    }
    LayoutInflater.from(paramContext).inflate(2131558536, this);
    b();
  }
  
  public static boolean a()
  {
    Object localObject = jdField_a_of_type_JavaLangString + "ImageAnimation1";
    String str1 = jdField_a_of_type_JavaLangString + "ImageAnimation2";
    String str2 = jdField_a_of_type_JavaLangString + "TextAnimation1";
    String str3 = jdField_a_of_type_JavaLangString + "TextAnimation2";
    String str4 = jdField_a_of_type_JavaLangString + "VideoTextAnimation1";
    String str5 = jdField_a_of_type_JavaLangString + "VideoTextAnimation2";
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(str1);
    localArrayList.add(str2);
    localArrayList.add(str3);
    localArrayList.add(str5);
    localArrayList.add(str4);
    localObject = localArrayList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!a((String)((Iterator)localObject).next())) {
        break label280;
      }
      i += 1;
    }
    label280:
    for (;;)
    {
      break;
      blfg.b("AEEditorAILoadingView", "lottie file count: " + i);
      if ((i >= 0) && (i < 6))
      {
        ThreadManager.excute(new AEEditorAILoadingView.11(), 64, null, true);
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
      paramString = paramString.listFiles(new blgj());
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
  
  private void b()
  {
    e();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369589));
  }
  
  private void c()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new blgk(this));
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new blgl(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368604));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368598));
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368603));
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368597));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375818));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377553));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377555));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377556));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375662);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131380150);
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, getContext());
    this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, getContext());
    this.jdField_c_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, getContext());
    this.jdField_d_of_type_ComTencentMobileqqApolloViewApolloLottieAnim = new ApolloLottieAnim(null, getContext());
    this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, jdField_a_of_type_JavaLangString + "ImageAnimation1" + File.separator, true);
    this.jdField_d_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(getContext(), this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, jdField_a_of_type_JavaLangString + "ImageAnimation2" + File.separator, false);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(getContext(), this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, a(), true);
    this.jdField_c_of_type_ComTencentMobileqqApolloViewApolloLottieAnim.a(getContext(), this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, b(), false);
    e();
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363914));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new blgm(this));
  }
  
  private void f()
  {
    blfg.a("AEEditorAILoadingView", "showResultAnimation start.");
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.animate().setDuration(200L).alpha(0.0F).start();
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.animate().setDuration(200L).alpha(0.0F).start();
    int i;
    if (getResources().getString(2131689789).equals(this.jdField_b_of_type_JavaLangString))
    {
      i = 1;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { 22, 0 });
      localValueAnimator1.setDuration(500L);
      localValueAnimator1.addUpdateListener(new blgn(this));
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { -22, 0 });
      localValueAnimator2.setDuration(500L);
      localValueAnimator2.addUpdateListener(new blgo(this));
      ValueAnimator localValueAnimator3 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator3.setDuration(1000L);
      localValueAnimator3.addUpdateListener(new blgp(this));
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setMinimumWidth(this.jdField_a_of_type_AndroidWidgetTextView.getWidth() + Utils.dp2px(20.0D));
        ValueAnimator localValueAnimator4 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localValueAnimator4.setDuration(500L);
        localValueAnimator4.addUpdateListener(new blgq(this));
        localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2).with(localValueAnimator4).before(localValueAnimator3);
      }
      for (;;)
      {
        localAnimatorSet.addListener(new blgi(this));
        localAnimatorSet.start();
        blfg.a("AEEditorAILoadingView", "showResultAnimation end.");
        return;
        localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2).before(localValueAnimator3);
      }
      i = 0;
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString + "TextAnimation1" + File.separator;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("cancelLoading: ");
    if (getParent() == null) {}
    for (boolean bool = true;; bool = false)
    {
      blfg.a("AEEditorAILoadingView", bool);
      if (getParent() != null) {
        break;
      }
      return;
    }
    ((ViewGroup)getParent()).removeAllViews();
  }
  
  public String b()
  {
    return jdField_a_of_type_JavaLangString + "TextAnimation2" + File.separator;
  }
  
  public void setLoadingListener(blgr paramblgr)
  {
    this.jdField_a_of_type_Blgr = paramblgr;
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
    blfg.a("AEEditorAILoadingView", "setShowResult: " + paramBoolean);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new AEEditorAILoadingView.1(this));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.post(new AEEditorAILoadingView.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView
 * JD-Core Version:    0.7.0.1
 */