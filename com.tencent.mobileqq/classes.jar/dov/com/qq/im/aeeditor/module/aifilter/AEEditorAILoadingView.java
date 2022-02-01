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
import bnzb;
import bnzs;
import bocg;
import boch;
import boci;
import bocj;
import bock;
import bocl;
import bocm;
import bocn;
import boco;
import bocp;
import bocq;
import bocr;
import bocs;
import boct;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.apollo.view.ApolloLottieAnim;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import zlx;

public class AEEditorAILoadingView
  extends FrameLayout
{
  protected static String a;
  protected static String b;
  protected static String c;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  protected LinearLayout a;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boct jdField_a_of_type_Boct;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ApolloLottieAnim jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ApolloLottieAnim jdField_c_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ApolloLottieAnim jdField_d_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private String jdField_d_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = bnzs.jdField_d_of_type_JavaLangString + File.separator + "ProcessAnimation" + File.separator;
    jdField_b_of_type_JavaLangString = "ComicTextAnimation1";
    jdField_c_of_type_JavaLangString = "ComicTextAnimation2";
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
      LayoutInflater.from(paramContext).inflate(2131558551, this);
      c();
      return;
    }
    LayoutInflater.from(paramContext).inflate(2131558552, this);
    b();
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = paramFloat1 * paramFloat2 / paramFloat1 - 1.0F;
    return (paramFloat1 * (paramFloat1 * paramFloat1 * paramFloat1 * paramFloat1) + 1.0F) * (paramFloat4 - paramFloat3) + paramFloat3;
  }
  
  public static boolean a()
  {
    Object localObject = jdField_a_of_type_JavaLangString + "ImageAnimation1";
    String str1 = jdField_a_of_type_JavaLangString + "ImageAnimation2";
    String str2 = jdField_a_of_type_JavaLangString + "TextAnimation1";
    String str3 = jdField_a_of_type_JavaLangString + "TextAnimation2";
    String str4 = jdField_a_of_type_JavaLangString + "VideoTextAnimation1";
    String str5 = jdField_a_of_type_JavaLangString + "VideoTextAnimation2";
    String str6 = jdField_a_of_type_JavaLangString + jdField_b_of_type_JavaLangString;
    String str7 = jdField_a_of_type_JavaLangString + jdField_c_of_type_JavaLangString;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(str1);
    localArrayList.add(str2);
    localArrayList.add(str3);
    localArrayList.add(str5);
    localArrayList.add(str4);
    localArrayList.add(str6);
    localArrayList.add(str7);
    localObject = localArrayList.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      if (!a((String)((Iterator)localObject).next())) {
        break label344;
      }
      i += 1;
    }
    label344:
    for (;;)
    {
      break;
      bnzb.b("AEEditorAILoadingView", "lottie file count: " + i);
      if ((i >= 0) && (i < 8))
      {
        ThreadManager.excute(new AEEditorAILoadingView.15(), 64, null, true);
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
      paramString = paramString.listFiles(new bocl());
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370013));
  }
  
  private void c()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new bocm(this));
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new bocn(this));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new boco(this));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorUpdateListener(new bocp(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370529);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376604));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368939));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368933));
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368938));
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368932));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376607));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378446));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378448));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378449));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131376440);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131381186);
    this.jdField_a_of_type_Int = zlx.a(getContext(), 7.0F);
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
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364119));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bocq(this));
  }
  
  private void f()
  {
    bnzb.a("AEEditorAILoadingView", "showResultAnimation start.");
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.animate().setDuration(100L).alpha(0.0F).start();
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.animate().setDuration(100L).alpha(0.0F).start();
    int i;
    if (getResources().getString(2131689681).equals(this.jdField_d_of_type_JavaLangString))
    {
      i = 1;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator1.setDuration(1000L);
      localValueAnimator1.addUpdateListener(new bocr(this));
      localValueAnimator1.addListener(new bocs(this));
      ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator2.setDuration(1000L);
      localValueAnimator2.addUpdateListener(new bocg(this));
      ValueAnimator localValueAnimator3 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator3.setDuration(1000L);
      localValueAnimator3.addUpdateListener(new boch(this));
      ValueAnimator localValueAnimator4 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator4.setDuration(500L);
      localValueAnimator4.addUpdateListener(new boci(this));
      if (i == 0)
      {
        this.jdField_b_of_type_AndroidViewView.setAlpha(0.0F);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setMinimumWidth(this.jdField_a_of_type_AndroidWidgetTextView.getWidth() + Utils.dp2px(20.0D));
        ValueAnimator localValueAnimator5 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localValueAnimator5.setDuration(1000L);
        localValueAnimator5.addUpdateListener(new bocj(this));
        localAnimatorSet.play(localValueAnimator4).before(localValueAnimator1);
        localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2).with(localValueAnimator5);
        localAnimatorSet.play(localValueAnimator3).after(localValueAnimator1);
      }
      for (;;)
      {
        localAnimatorSet.addListener(new bock(this));
        localAnimatorSet.start();
        bnzb.a("AEEditorAILoadingView", "showResultAnimation end.");
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
    return jdField_a_of_type_JavaLangString + "TextAnimation1" + File.separator;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("cancelLoading: ");
    if (getParent() == null) {}
    for (boolean bool = true;; bool = false)
    {
      bnzb.a("AEEditorAILoadingView", bool);
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
  
  public void setLoadingListener(boct paramboct)
  {
    this.jdField_a_of_type_Boct = paramboct;
  }
  
  public void setSceneText(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_d_of_type_JavaLangString = paramString1;
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
    bnzb.a("AEEditorAILoadingView", "setShowResult: " + paramBoolean);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new AEEditorAILoadingView.1(this));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.post(new AEEditorAILoadingView.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView
 * JD-Core Version:    0.7.0.1
 */