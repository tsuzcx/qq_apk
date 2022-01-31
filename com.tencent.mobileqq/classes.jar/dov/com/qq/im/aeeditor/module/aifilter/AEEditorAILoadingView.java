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
import bljn;
import blkb;
import blkp;
import blkq;
import blkr;
import blks;
import blkt;
import blku;
import blkv;
import blkw;
import blkx;
import blky;
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
  protected static String b;
  protected static String c;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  protected LinearLayout a;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private blky jdField_a_of_type_Blky;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ApolloLottieAnim jdField_b_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ApolloLottieAnim jdField_c_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ApolloLottieAnim jdField_d_of_type_ComTencentMobileqqApolloViewApolloLottieAnim;
  private DiniFlyAnimationView jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private String jdField_d_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaLangString = blkb.jdField_d_of_type_JavaLangString + File.separator + "ProcessAnimation" + File.separator;
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
      bljn.b("AEEditorAILoadingView", "lottie file count: " + i);
      if ((i >= 0) && (i < 8))
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
      paramString = paramString.listFiles(new blkq());
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369607));
  }
  
  private void c()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new blkr(this));
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new blks(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375868));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368615));
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368609));
    this.jdField_c_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368614));
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)findViewById(2131368608));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375870));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377607));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377609));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377610));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131375713);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131380208);
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
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363916));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new blkt(this));
  }
  
  private void f()
  {
    bljn.a("AEEditorAILoadingView", "showResultAnimation start.");
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_b_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.animate().setDuration(200L).alpha(0.0F).start();
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.animate().setDuration(200L).alpha(0.0F).start();
    int i;
    if (getResources().getString(2131689789).equals(this.jdField_d_of_type_JavaLangString))
    {
      i = 1;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      ValueAnimator localValueAnimator1 = ValueAnimator.ofInt(new int[] { 22, 0 });
      localValueAnimator1.setDuration(500L);
      localValueAnimator1.addUpdateListener(new blku(this));
      ValueAnimator localValueAnimator2 = ValueAnimator.ofInt(new int[] { -22, 0 });
      localValueAnimator2.setDuration(500L);
      localValueAnimator2.addUpdateListener(new blkv(this));
      ValueAnimator localValueAnimator3 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator3.setDuration(1000L);
      localValueAnimator3.addUpdateListener(new blkw(this));
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setMinimumWidth(this.jdField_a_of_type_AndroidWidgetTextView.getWidth() + Utils.dp2px(20.0D));
        ValueAnimator localValueAnimator4 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
        localValueAnimator4.setDuration(500L);
        localValueAnimator4.addUpdateListener(new blkx(this));
        localAnimatorSet.play(localValueAnimator1).with(localValueAnimator2).with(localValueAnimator4).before(localValueAnimator3);
      }
      for (;;)
      {
        localAnimatorSet.addListener(new blkp(this));
        localAnimatorSet.start();
        bljn.a("AEEditorAILoadingView", "showResultAnimation end.");
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
      bljn.a("AEEditorAILoadingView", bool);
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
  
  public void setLoadingListener(blky paramblky)
  {
    this.jdField_a_of_type_Blky = paramblky;
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
    bljn.a("AEEditorAILoadingView", "setShowResult: " + paramBoolean);
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