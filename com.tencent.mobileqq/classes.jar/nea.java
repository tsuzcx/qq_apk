import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.10;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.14;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.8;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.9;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailBannerViewWrapper;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class nea
  extends BaseAdapter
  implements View.OnClickListener, nfm
{
  private static int p = 10;
  private static int q = 20;
  float jdField_a_of_type_Float;
  final int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  protected AnimatorSet a;
  Activity jdField_a_of_type_AndroidAppActivity;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  protected TranslateAnimation a;
  public Button a;
  public ImageView a;
  private bfos jdField_a_of_type_Bfos = new nej(this);
  private AccountDetailTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout;
  AccountDetailXListView jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView;
  private URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new nee(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  EqqDetail jdField_a_of_type_ComTencentMobileqqDataEqqDetail;
  String jdField_a_of_type_JavaLangString;
  private ArrayList<neu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  nen jdField_a_of_type_Nen = null;
  private neq jdField_a_of_type_Neq;
  ney jdField_a_of_type_Ney;
  nfg jdField_a_of_type_Nfg;
  nfr jdField_a_of_type_Nfr;
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 0;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  protected TranslateAnimation b;
  public Button b;
  public ImageView b;
  String jdField_b_of_type_JavaLangString;
  private ArrayList<neu> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  final int jdField_c_of_type_Int = 1;
  Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  public ImageView c;
  private ArrayList<nmr> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_c_of_type_Boolean = false;
  final int jdField_d_of_type_Int = 2;
  private ArrayList<nmr> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  public boolean d;
  final int jdField_e_of_type_Int = 3;
  boolean jdField_e_of_type_Boolean = false;
  final int jdField_f_of_type_Int = 4;
  boolean jdField_f_of_type_Boolean = false;
  final int jdField_g_of_type_Int = 5;
  boolean jdField_g_of_type_Boolean = false;
  final int jdField_h_of_type_Int = 6;
  private boolean jdField_h_of_type_Boolean = true;
  final int jdField_i_of_type_Int = 7;
  private boolean jdField_i_of_type_Boolean = true;
  final int j = 8;
  final int k = 9;
  final int l = 10;
  final int m = 11;
  int n = 0;
  int o = 0;
  private int r = AccountDetailActivity.jdField_i_of_type_Int;
  private int s = 1;
  
  public nea(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail, String paramString, boolean paramBoolean, AccountDetailXListView paramAccountDetailXListView, AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.s = nol.a(paramQQAppInterface, paramString, paramAccountDetail);
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.c();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView = paramAccountDetailXListView;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getResources().getDisplayMetrics().density;
    this.o = ((AccountDetailActivity)this.jdField_a_of_type_AndroidAppActivity).a()[1];
    b();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Ney = new ney(paramQQAppInterface, paramContext, paramAccountDetail);
      paramQQAppInterface = nfd.a(paramQQAppInterface).a(paramString);
      if (paramQQAppInterface != null)
      {
        a(paramQQAppInterface.a(), paramQQAppInterface.jdField_a_of_type_Boolean);
        a(paramQQAppInterface.b());
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.cardStyle == 1))
      {
        this.jdField_b_of_type_Boolean = true;
        n();
      }
      m();
      this.jdField_d_of_type_Boolean = a();
      paramQQAppInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView;
      if (this.jdField_d_of_type_Boolean) {
        break label453;
      }
    }
    label453:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramQQAppInterface.a(paramBoolean);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = paramAccountDetailTopGestureLayout;
      return;
    }
  }
  
  public nea(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, AccountDetailXListView paramAccountDetailXListView, ImageView paramImageView1, ImageView paramImageView2, RelativeLayout paramRelativeLayout, ImageView paramImageView3, AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView = paramAccountDetailXListView;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView1;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView2;
    this.jdField_a_of_type_AndroidViewView = paramRelativeLayout;
    this.jdField_c_of_type_AndroidWidgetImageView = paramImageView3;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getResources().getDisplayMetrics().density;
    b();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = paramAccountDetailTopGestureLayout;
  }
  
  private String a(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
      return str;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "preloadImg start:" + paramInt1 + " count:" + paramInt2);
    }
    long l1 = System.currentTimeMillis();
    if (!bbfj.h(this.jdField_a_of_type_AndroidContentContext)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    ThreadManager.post(new AccountDetailBaseAdapter.14(this, this.jdField_a_of_type_Long, localArrayList, paramInt1, paramInt2, l1), 5, null, true);
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "runShowAnimation");
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView1.setAlpha(0.0F);
      paramView1.setVisibility(0);
      paramView2.setAlpha(0.0F);
      paramView2.setVisibility(0);
      paramView1 = ObjectAnimator.ofFloat(paramView1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView2 = ObjectAnimator.ofFloat(paramView2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      paramView1.setDuration(1800L);
      paramView1.setRepeatCount(-1);
      paramView1.setRepeatMode(1);
      paramView1.setStartDelay(paramLong1);
      paramView2.setDuration(1800L);
      paramView2.setRepeatCount(-1);
      paramView2.setRepeatMode(1);
      paramView2.setStartDelay(paramLong2);
      if (this.jdField_a_of_type_AndroidAnimationAnimatorSet == null) {
        this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { paramView1, paramView2 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
      return;
    }
    paramView1.setVisibility(0);
    paramView2.setVisibility(0);
  }
  
  protected static boolean a(AccountDetail paramAccountDetail)
  {
    if (paramAccountDetail == null) {}
    while (sgg.a(paramAccountDetail.accountFlag) != -2) {
      return false;
    }
    return true;
  }
  
  private boolean a(nmr paramnmr)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramnmr != null) && (paramnmr.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramnmr.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        nms localnms = (nms)localIterator.next();
        switch (paramnmr.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 5: 
        case 6: 
          if (!TextUtils.isEmpty(localnms.e)) {
            localArrayList.add(localnms);
          }
          break;
        case 7: 
          if ((!TextUtils.isEmpty(localnms.e)) && (!TextUtils.isEmpty(localnms.j))) {
            localArrayList.add(localnms);
          }
          break;
        }
      }
    }
    return localArrayList.size() != 0;
  }
  
  private boolean b()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  private boolean b(nmr paramnmr)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {}
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType;; i1 = -1)
    {
      if ((paramnmr != null) && (paramnmr.jdField_a_of_type_JavaUtilList != null))
      {
        Iterator localIterator = paramnmr.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          nms localnms = (nms)localIterator.next();
          if ((localnms.jdField_b_of_type_Int == 0) || ((localnms.jdField_b_of_type_Int == 1) && (i1 == 1))) {}
          for (int i2 = 1; i2 != 0; i2 = 0) {
            switch (paramnmr.jdField_a_of_type_Int)
            {
            default: 
              break;
            case 2: 
              if (localnms.jdField_c_of_type_Int != 23) {
                break label179;
              }
              if ((TextUtils.isEmpty(localnms.e)) || (TextUtils.isEmpty(localnms.jdField_b_of_type_JavaLangString))) {
                break;
              }
              localArrayList.add(localnms);
              break;
            }
          }
          label179:
          if (!TextUtils.isEmpty(localnms.e))
          {
            localArrayList.add(localnms);
            continue;
            if (localnms.jdField_c_of_type_Int == 23)
            {
              if ((!TextUtils.isEmpty(localnms.e)) && (!TextUtils.isEmpty(localnms.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnms.jdField_b_of_type_JavaLangString))) {
                localArrayList.add(localnms);
              }
            }
            else if ((!TextUtils.isEmpty(localnms.e)) && (!TextUtils.isEmpty(localnms.jdField_a_of_type_JavaLangString))) {
              localArrayList.add(localnms);
            }
          }
        }
      }
      if ((paramnmr != null) && (paramnmr.jdField_a_of_type_Int == 4) && (localArrayList.size() % 2 != 0)) {
        localArrayList.remove(localArrayList.size() - 1);
      }
      return localArrayList.size() != 0;
    }
  }
  
  private int f()
  {
    Resources localResources = this.jdField_a_of_type_AndroidAppActivity.getResources();
    return localResources.getDimensionPixelSize(localResources.getIdentifier("status_bar_height", "dimen", "android"));
  }
  
  private void m()
  {
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.customConfigAttrs != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.customConfigAttrs.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.customConfigAttrs.iterator();
      while (localIterator.hasNext())
      {
        nmr localnmr = (nmr)localIterator.next();
        switch (localnmr.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 2: 
        case 3: 
        case 4: 
          if (b(localnmr)) {
            this.jdField_c_of_type_JavaUtilArrayList.add(localnmr);
          }
          break;
        }
      }
    }
  }
  
  private void n()
  {
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.fullscreenConfigAttrs != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.fullscreenConfigAttrs.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.fullscreenConfigAttrs.iterator();
      while (localIterator.hasNext())
      {
        nmr localnmr = (nmr)localIterator.next();
        switch (localnmr.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 5: 
        case 6: 
        case 7: 
          if (a(localnmr)) {
            this.jdField_d_of_type_JavaUtilArrayList.add(localnmr);
          }
          break;
        }
      }
    }
  }
  
  @TargetApi(11)
  private void o()
  {
    if ((this.jdField_a_of_type_Nen == null) || (this.jdField_a_of_type_Nen.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "startShowArrowAnimation");
    }
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null) {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, -0.2F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -0.2F, 1, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new nec(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ned(this));
    this.jdField_a_of_type_Nen.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  @TargetApi(11)
  private void p()
  {
    if (this.jdField_a_of_type_Nen == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Nen.jdField_a_of_type_AndroidViewView.getAnimation() != null)
      {
        this.jdField_a_of_type_Nen.jdField_a_of_type_AndroidViewView.getAnimation().setAnimationListener(null);
        this.jdField_a_of_type_Nen.jdField_a_of_type_AndroidViewView.getAnimation().cancel();
        this.jdField_a_of_type_Nen.jdField_a_of_type_AndroidViewView.clearAnimation();
      }
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(null);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
      }
      if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null)
      {
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(null);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
      }
    } while (Build.VERSION.SDK_INT < 11);
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      Iterator localIterator = this.jdField_a_of_type_AndroidAnimationAnimatorSet.getChildAnimations().iterator();
      while (localIterator.hasNext())
      {
        Animator localAnimator = (Animator)localIterator.next();
        localAnimator.end();
        localAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "prefetch data");
    }
    if (this.jdField_a_of_type_Neq != null) {
      this.jdField_a_of_type_Neq.a();
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public AccountDetail a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  }
  
  public EqqDetail a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail;
  }
  
  public nfg a()
  {
    if (this.jdField_a_of_type_Nfg != null) {
      return this.jdField_a_of_type_Nfg;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Nfr != null) {
      this.jdField_a_of_type_Nfr.b();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    p();
    i();
    rpg.a().a();
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  void a(int paramInt, float paramFloat)
  {
    if (paramInt >= paramFloat)
    {
      c();
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
        c(paramInt);
      }
      return;
    }
    d();
  }
  
  void a(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (nep)paramView.getTag();
    float f1;
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    int i1;
    if (b())
    {
      f1 = 76.0F * this.jdField_a_of_type_Float;
      localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)paramView.d.getLayoutParams();
      if (paramInt >= f1) {
        break label342;
      }
      i1 = (int)((100.0F - paramInt * 70 / f1) * this.jdField_a_of_type_Float);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      localLayoutParams1.topMargin = ((int)(90.0F * this.jdField_a_of_type_Float));
      i1 = localLayoutParams1.height + (int)(4.0F * this.jdField_a_of_type_Float);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      localLayoutParams1.topMargin -= (int)(2.0F * this.jdField_a_of_type_Float);
      i1 = (int)((20.0F - paramInt * 20 / f1) * this.jdField_a_of_type_Float);
      localLayoutParams3.width = i1;
      localLayoutParams3.height = i1;
      if (paramInt != 0) {
        break label275;
      }
      localLayoutParams3.topMargin = ((int)(165.0F * this.jdField_a_of_type_Float));
      localLayoutParams3.leftMargin = ((int)(72.0F * this.jdField_a_of_type_Float));
    }
    for (;;)
    {
      paramView.jdField_b_of_type_AndroidWidgetImageView.post(new AccountDetailBaseAdapter.8(this, paramView, localLayoutParams1, localLayoutParams2, localLayoutParams3));
      a(paramInt, f1);
      return;
      f1 = 65.0F * this.jdField_a_of_type_Float;
      break;
      label275:
      localLayoutParams3.topMargin = (localLayoutParams1.topMargin + (int)(localLayoutParams1.height * 0.72D) + (int)(paramInt * 2 / f1 * this.jdField_a_of_type_Float));
      localLayoutParams3.leftMargin = ((int)(localLayoutParams1.height * 0.72D) + (int)(paramInt * 2 / f1 * this.jdField_a_of_type_Float));
      continue;
      label342:
      i1 = (int)(30.0F * this.jdField_a_of_type_Float);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      localLayoutParams1.topMargin = ((int)(22.0F * this.jdField_a_of_type_Float));
      i1 = (int)(32.0F * this.jdField_a_of_type_Float);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      localLayoutParams2.topMargin = ((int)(this.jdField_a_of_type_Float * 20.0F));
      i1 = (int)(8.0F * this.jdField_a_of_type_Float);
      localLayoutParams3.height = i1;
      localLayoutParams3.width = i1;
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  void a(View paramView)
  {
    if (this.jdField_b_of_type_Boolean) {
      paramView.findViewById(2131372092).setVisibility(8);
    }
    do
    {
      return;
      paramView = (TextView)paramView.findViewById(2131372091);
    } while (paramView == null);
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, ImageView paramImageView3, Button paramButton)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView1;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView2;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_c_of_type_AndroidWidgetImageView = paramImageView3;
    this.jdField_b_of_type_AndroidWidgetButton = paramButton;
  }
  
  public void a(AccountDetail paramAccountDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_Ney = new ney(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramAccountDetail);
      m();
      if (paramAccountDetail.cardStyle == 1) {
        c(true);
      }
    }
    else
    {
      return;
    }
    c(false);
  }
  
  public void a(EqqDetail paramEqqDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail = paramEqqDetail;
  }
  
  public void a(ArrayList<neu> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public void a(ArrayList<neu> paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      this.jdField_a_of_type_Long = System.nanoTime();
    }
    paramArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      neu localneu = (neu)localIterator.next();
      if ((localneu.jdField_a_of_type_Nex != null) && (localneu.jdField_a_of_type_Nex.jdField_a_of_type_Int != 1) && (localneu.jdField_a_of_type_Nex.jdField_a_of_type_Int != 2)) {
        paramArrayList.add(localneu);
      } else if ((localneu.jdField_a_of_type_Nev != null) && (localneu.jdField_a_of_type_Nev.jdField_a_of_type_Int != 1) && (localneu.jdField_a_of_type_Nev.jdField_a_of_type_Int != 2)) {
        paramArrayList.add(localneu);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(paramArrayList);
  }
  
  void a(nel paramnel, View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramnel == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg: dynamic holder is null");
      }
    }
    for (;;)
    {
      return;
      neu localneu = (neu)getItem(paramInt);
      if (localneu == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.jdField_a_of_type_JavaLangString + "动态消息为空");
        return;
      }
      if (localneu.jdField_a_of_type_Nev == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.jdField_a_of_type_JavaLangString + "动态消息的消息属性为空");
        return;
      }
      Object localObject2;
      if (!localneu.jdField_a_of_type_Boolean)
      {
        localneu.jdField_a_of_type_Boolean = true;
        localObject2 = new JSONObject();
        if (this.jdField_a_of_type_Boolean) {}
      }
      try
      {
        ((JSONObject)localObject2).put("cha_1", localneu.jdField_a_of_type_Nev.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject2).put("cha_2", this.s);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str2 = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {}
        for (String str1 = "02";; str1 = "01")
        {
          axqy.b((QQAppInterface)localObject3, "dc01160", "Pb_account_lifeservice", str2, "0X8007CA2", "0X8007CA2", 0, 0, str1, String.valueOf(localneu.jdField_a_of_type_Nev.jdField_a_of_type_Int), String.valueOf(localneu.jdField_a_of_type_Nev.jdField_a_of_type_Long), ((JSONObject)localObject2).toString());
          if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg: item:= " + paramInt + "report msg: artical id=" + localneu.jdField_a_of_type_Nev.jdField_a_of_type_Long + "   artical name=" + localneu.jdField_a_of_type_JavaLangString + " json=" + ((JSONObject)localObject2).toString());
          }
          paramInt = localneu.jdField_a_of_type_Nev.jdField_a_of_type_Int;
          if (paramInt != 2) {
            break label895;
          }
          bool = true;
          localObject2 = localneu.jdField_a_of_type_JavaLangString;
          localObject3 = Long.valueOf(localneu.jdField_a_of_type_Nev.c);
          str2 = localneu.jdField_a_of_type_Nev.jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:title =" + (String)localObject2 + "--coverUrl=" + "" + "--jumpUrl=" + str2 + "--isVideoMsg =" + bool);
          }
          if (!bool) {
            break label666;
          }
          paramnel.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramnel.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramnel.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (localneu.jdField_a_of_type_Nex == null) {
            break label887;
          }
          if (!paramBoolean) {
            break label653;
          }
          str1 = localneu.jdField_a_of_type_Nex.d;
          paramnel.jdField_c_of_type_AndroidWidgetTextView.setText(muc.a(localneu.jdField_a_of_type_Nex.jdField_b_of_type_Int));
          if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "当前的url是" + str1);
          }
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((Long)localObject3).longValue() > 0L)) {
            break label729;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.jdField_a_of_type_JavaLangString + "动态消息内容不合法");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject3;
          String str2;
          localJSONException.printStackTrace();
          continue;
          label653:
          Object localObject1 = localneu.jdField_a_of_type_Nex.jdField_a_of_type_JavaLangString;
          continue;
          label666:
          paramnel.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
          paramnel.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          paramnel.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          if (localneu.jdField_a_of_type_New != null)
          {
            if (paramBoolean)
            {
              localObject1 = localneu.jdField_a_of_type_New.jdField_b_of_type_JavaLangString;
              continue;
            }
            localObject1 = localneu.jdField_a_of_type_New.jdField_a_of_type_JavaLangString;
            continue;
            label729:
            Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
            ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#dddfe2"));
            if (paramBoolean) {}
            for (;;)
            {
              try
              {
                localObject1 = URLDrawable.getDrawable((String)localObject1, localColorDrawable, localColorDrawable, true);
                paramnel.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
                paramnel.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
                paramnel.jdField_b_of_type_AndroidWidgetTextView.setText(ong.a(((Long)localObject3).longValue()));
                paramView.setOnClickListener(new nei(this, paramInt, str2, localneu));
                return;
              }
              catch (Exception paramnel) {}
              localObject1 = URLDrawable.getDrawable((String)localObject1, actj.a(124.0F, localResources), actj.a(95.0F, localResources), localColorDrawable, localColorDrawable, true);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + paramnel);
            return;
          }
          label887:
          localObject1 = "";
          continue;
          label895:
          boolean bool = false;
        }
      }
    }
  }
  
  void a(nem paramnem, View paramView)
  {
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    paramView.setClickable(false);
    paramView.setOnClickListener(null);
    if (this.jdField_h_of_type_Boolean)
    {
      if (this.r != AccountDetailActivity.jdField_i_of_type_Int) {
        break label92;
      }
      paramnem.jdField_a_of_type_AndroidWidgetTextView.setText(2131689557);
      paramnem.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramnem.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      paramnem.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    for (;;)
    {
      paramnem.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new neh(this, paramnem));
      return;
      label92:
      if (this.r == AccountDetailActivity.j)
      {
        paramnem.jdField_a_of_type_AndroidWidgetTextView.setText(2131695569);
        paramnem.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, (int)(5.0F * f1), 0, (int)(f1 * 5.0F));
        paramnem.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839020);
        paramnem.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else if (this.r == AccountDetailActivity.k)
      {
        paramnem.jdField_a_of_type_AndroidWidgetTextView.setText(2131689560);
        paramnem.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841240);
        paramnem.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, (int)(5.0F * f1), 0, (int)(f1 * 5.0F));
        paramnem.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
  }
  
  void a(nen paramnen)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    label79:
    nmr localnmr;
    label166:
    label176:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Nen = paramnen;
        int i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name.length();
        if ((i1 > 8) && (i1 < 13)) {
          paramnen.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
        }
        paramnen.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
        if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
          break;
        }
        paramnen.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_c_of_type_Boolean)
        {
          paramnen.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramnen.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary.trim());
        }
        paramnen.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
        if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1) {
          break label419;
        }
        if (!this.jdField_g_of_type_Boolean) {
          break label407;
        }
        paramnen.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramnen.jdField_a_of_type_AndroidWidgetButton.setText(null);
        paramnen.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837511);
        this.jdField_b_of_type_AndroidWidgetButton.setText(2131695615);
        localnmr = (nmr)getItem(0);
      } while ((localnmr == null) || (localnmr.jdField_a_of_type_JavaUtilList == null) || (localnmr.jdField_a_of_type_JavaUtilList.size() == 0));
      localObject = ((nms)localnmr.jdField_a_of_type_JavaUtilList.get(0)).e;
    } while (TextUtils.isEmpty((CharSequence)localObject));
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#f7f9fe"));
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    if (localnmr.jdField_a_of_type_Int == 6) {
      localURLDrawableOptions.mPlayGifImage = true;
    }
    Object localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
    if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
      ((URLDrawable)localObject).restartDownload();
    }
    if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1)) {
      k();
    }
    for (;;)
    {
      paramnen.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      o();
      if (localnmr.jdField_a_of_type_Int != 7) {
        break;
      }
      if (this.jdField_a_of_type_Nfg == null) {
        this.jdField_a_of_type_Nfg = new nfg(this.jdField_a_of_type_AndroidAppActivity, this);
      }
      paramnen.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_Nfg.a(localnmr, paramnen.jdField_a_of_type_AndroidWidgetFrameLayout);
      return;
      paramnen.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label79;
      label407:
      paramnen.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break label166;
      label419:
      paramnen.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramnen.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695543));
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131695616);
      break label176;
      paramnen.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      if ((this.jdField_a_of_type_Nfg == null) || (!this.jdField_f_of_type_Boolean)) {
        j();
      }
    }
  }
  
  void a(nep paramnep)
  {
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
        return;
      }
      paramnep.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(Color.parseColor("#3d7fe3"));
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name.length();
      if ((i1 > 8) && (i1 < 13)) {
        paramnep.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
      }
      paramnep.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.displayNumber))
      {
        paramnep.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.displayNumber);
        label103:
        if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.certifiedGrade == 0) {
          break label145;
        }
        paramnep.d.setVisibility(0);
      }
    }
    for (;;)
    {
      paramnep.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
      return;
      paramnep.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label103;
      label145:
      paramnep.d.setVisibility(8);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
        break;
      }
      paramnep.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramnep.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name.length();
      if ((i1 > 8) && (i1 < 13)) {
        paramnep.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
      }
      paramnep.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription)) {
        paramnep.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
          break label294;
        }
        paramnep.d.setVisibility(0);
        break;
        paramnep.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label294:
      paramnep.d.setVisibility(8);
    }
  }
  
  public void a(neq paramneq)
  {
    this.jdField_a_of_type_Neq = paramneq;
  }
  
  void a(nes paramnes)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    paramnes.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    paramnes.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name.length();
    if ((i1 > 8) && (i1 < 13)) {
      paramnes.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
    }
    paramnes.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade != 0)
    {
      paramnes.d.setVisibility(0);
      if ((!a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription))) {
        break label231;
      }
      paramnes.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription);
      label133:
      String str = a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
      paramnes.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      paramnes.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1) {
        break label255;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break label243;
      }
      paramnes.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramnes.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837511);
      paramnes.jdField_a_of_type_AndroidWidgetButton.setText(null);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131695615);
      return;
      paramnes.d.setVisibility(8);
      break;
      label231:
      paramnes.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label133;
      label243:
      paramnes.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    label255:
    paramnes.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramnes.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839026);
    paramnes.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131695543));
    paramnes.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131695616);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_h_of_type_Boolean = bool;
      if ((!this.jdField_h_of_type_Boolean) || ((this.r != AccountDetailActivity.jdField_i_of_type_Int) && (this.r != AccountDetailActivity.j) && (this.r != AccountDetailActivity.k))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    neu localneu = (neu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - this.jdField_c_of_type_JavaUtilArrayList.size() - 2);
    if (localneu != null)
    {
      if ((localneu.jdField_a_of_type_New != null) && (localneu.jdField_a_of_type_New.jdField_a_of_type_Int == 1)) {
        return true;
      }
      if ((localneu.jdField_a_of_type_Nex != null) && (localneu.jdField_a_of_type_Nex.jdField_e_of_type_Int == 1)) {
        return true;
      }
    }
    return false;
  }
  
  boolean a(int paramInt1, View paramView, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramView == null) {
      bool1 = false;
    }
    label97:
    label124:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                if (paramInt1 == 1)
                {
                  bool1 = a(paramInt2);
                  if ((paramView.getTag() != null) && ((paramView.getTag() instanceof nel)) && (bool1 == ((nel)paramView.getTag()).jdField_a_of_type_Boolean)) {}
                  for (bool1 = true;; bool1 = false) {
                    return bool1;
                  }
                }
                if (paramInt1 != 2) {
                  break label97;
                }
                if (paramView.getTag() == null) {
                  break;
                }
                bool1 = bool2;
              } while ((paramView.getTag() instanceof nem));
              return false;
              if (paramInt1 != 0) {
                break label124;
              }
              if (paramView.getTag() == null) {
                break;
              }
              bool1 = bool2;
            } while ((paramView.getTag() instanceof nep));
            return false;
            if (paramInt1 != 8) {
              break label153;
            }
            if (paramView.getTag() == null) {
              break;
            }
            bool1 = bool2;
          } while ((paramView.getTag() instanceof nes));
          return false;
          if (paramInt1 != 9) {
            break label182;
          }
          if (paramView.getTag() == null) {
            break;
          }
          bool1 = bool2;
        } while ((paramView.getTag() instanceof neo));
        return false;
        bool1 = bool2;
      } while (paramInt1 != 10);
      if (paramView.getTag() == null) {
        break;
      }
      bool1 = bool2;
    } while ((paramView.getTag() instanceof nen));
    label153:
    label182:
    return false;
  }
  
  public int b()
  {
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    return localView.getTop();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOnScrollListener(this.jdField_a_of_type_Bfos);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOnEndScrollListener(new nek(this));
  }
  
  public void b(int paramInt)
  {
    this.r = paramInt;
  }
  
  void b(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (nen)paramView.getTag();
    float f1 = 170.0F * this.jdField_a_of_type_Float;
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    label99:
    int i1;
    if (b())
    {
      f1 -= 64.0F * this.jdField_a_of_type_Float / 2.0F;
      localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramInt >= f1) {
        break label364;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
        break label225;
      }
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramInt > 0) {
        break label237;
      }
      i1 = (int)(this.jdField_a_of_type_Float * 90.0F);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      i1 = (int)(this.jdField_a_of_type_Float * 20.0F);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      localLayoutParams2.topMargin = ((int)(this.jdField_a_of_type_Float * 58.0F));
      localLayoutParams2.leftMargin = ((int)(this.jdField_a_of_type_Float * 58.0F));
      label181:
      paramView.jdField_a_of_type_AndroidWidgetImageView.post(new AccountDetailBaseAdapter.9(this, paramView, localLayoutParams1, localLayoutParams2));
    }
    for (;;)
    {
      a(paramInt, f1);
      return;
      f1 -= 75.0F * this.jdField_a_of_type_Float / 2.0F;
      break;
      label225:
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label99;
      label237:
      i1 = (int)((90.0F - paramInt * 50 / f1) * this.jdField_a_of_type_Float);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      i1 = (int)((20.0F - paramInt * 20 / f1) * this.jdField_a_of_type_Float);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      localLayoutParams2.topMargin = ((int)(localLayoutParams1.height * 0.64D) + (int)(paramInt * 2 / f1 * this.jdField_a_of_type_Float));
      localLayoutParams2.leftMargin = ((int)(localLayoutParams1.height * 0.64D) + (int)(paramInt * 2 / f1 * this.jdField_a_of_type_Float));
      break label181;
      label364:
      if (paramInt >= f1)
      {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void b(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  protected int c()
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null)) {
      return Color.parseColor("#3d7fe3");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor == null) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.equals(""))) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor = "3d7fe3";
    }
    return Color.parseColor("#" + this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.configBackgroundColor.substring(0, 6));
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(c());
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(bayh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_JavaLangString));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void c(int paramInt)
  {
    int i1;
    if (this.jdField_b_of_type_Boolean) {
      if (a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail))
      {
        i1 = (int)(258.0F * this.jdField_a_of_type_Float);
        if ((this.jdField_b_of_type_AndroidWidgetButton.getVisibility() != 8) || (paramInt < i1)) {
          break label132;
        }
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(100L);
        localAlphaAnimation.setFillBefore(true);
        this.jdField_b_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation);
      }
    }
    label132:
    while ((paramInt >= i1) || (this.jdField_b_of_type_AndroidWidgetButton.getVisibility() != 0))
    {
      return;
      i1 = (int)(234.0F * this.jdField_a_of_type_Float);
      break;
      if (a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail))
      {
        i1 = (int)(217.0F * this.jdField_a_of_type_Float);
        break;
      }
      i1 = (int)(173.0F * this.jdField_a_of_type_Float);
      break;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(100L);
    this.jdField_b_of_type_AndroidWidgetButton.startAnimation(localAlphaAnimation);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  void c(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (nes)paramView.getTag();
    float f1;
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams3;
    label106:
    int i1;
    if (b())
    {
      f1 = 41.0F * this.jdField_a_of_type_Float;
      localLayoutParams1 = (RelativeLayout.LayoutParams)paramView.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)paramView.d.getLayoutParams();
      if (paramInt >= f1) {
        break label357;
      }
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
        break label302;
      }
      paramView.d.setVisibility(0);
      i1 = (int)((90.0F - paramInt * 50 / f1) * this.jdField_a_of_type_Float);
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i1;
      localLayoutParams1.topMargin = ((int)(60.0F * this.jdField_a_of_type_Float));
      i1 = localLayoutParams1.height + (int)(4.0F * this.jdField_a_of_type_Float);
      localLayoutParams2.width = i1;
      localLayoutParams2.height = i1;
      localLayoutParams2.topMargin = ((int)(58.0F * this.jdField_a_of_type_Float));
      i1 = (int)((20.0F - paramInt * 20 / f1) * this.jdField_a_of_type_Float);
      localLayoutParams3.width = i1;
      localLayoutParams3.height = i1;
      if (paramInt != 0) {
        break label314;
      }
      i1 = (int)(65.0F * this.jdField_a_of_type_Float);
      localLayoutParams3.leftMargin = i1;
      localLayoutParams3.topMargin = i1;
      label260:
      paramView.jdField_b_of_type_AndroidWidgetImageView.post(new AccountDetailBaseAdapter.10(this, paramView, localLayoutParams1, localLayoutParams2, localLayoutParams3));
    }
    for (;;)
    {
      a(paramInt, f1);
      return;
      f1 = 30.0F * this.jdField_a_of_type_Float;
      break;
      label302:
      paramView.d.setVisibility(8);
      break label106;
      label314:
      i1 = (int)(0.72D * localLayoutParams1.height) + (int)(paramInt * 2 / f1 * this.jdField_a_of_type_Float);
      localLayoutParams3.leftMargin = i1;
      localLayoutParams3.topMargin = i1;
      break label260;
      label357:
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      paramView.d.setVisibility(4);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      n();
      return;
    }
    this.jdField_d_of_type_JavaUtilArrayList.clear();
  }
  
  void d()
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.smoothScrollBy(this.o - paramInt - this.jdField_a_of_type_AndroidViewView.getHeight(), 500);
    c();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
      c(paramInt);
    }
  }
  
  void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Nen != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Nen.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Nen.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    k();
  }
  
  void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.smoothScrollToPosition(0);
    d();
  }
  
  public void f()
  {
    this.jdField_f_of_type_Boolean = true;
    d(false);
  }
  
  public void g()
  {
    d(true);
  }
  
  public int getCount()
  {
    int i1 = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
      return 1;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      int i2 = this.jdField_c_of_type_JavaUtilArrayList.size();
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        i1 = this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
      }
      for (;;)
      {
        return i1 + (i2 + 1);
        if (!this.jdField_d_of_type_Boolean) {
          i1 = 0;
        }
      }
    }
    return 2;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {}
    do
    {
      do
      {
        do
        {
          return null;
        } while (!this.jdField_c_of_type_Boolean);
        if (paramInt != 0) {
          break;
        }
      } while ((!this.jdField_b_of_type_Boolean) || (this.jdField_d_of_type_JavaUtilArrayList == null) || (this.jdField_d_of_type_JavaUtilArrayList.size() == 0));
      return this.jdField_d_of_type_JavaUtilArrayList.get(paramInt);
      if (paramInt <= this.jdField_c_of_type_JavaUtilArrayList.size()) {
        return this.jdField_c_of_type_JavaUtilArrayList.get(paramInt - 1);
      }
    } while ((this.jdField_d_of_type_Boolean) || (paramInt == this.jdField_c_of_type_JavaUtilArrayList.size() + 1));
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - this.jdField_c_of_type_JavaUtilArrayList.size() - 2);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
      return 9;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      if (paramInt == 0)
      {
        if (this.jdField_b_of_type_Boolean) {
          return 10;
        }
        return 8;
      }
      if (paramInt <= this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        switch (((nmr)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt - 1)).jdField_a_of_type_Int)
        {
        default: 
          return -1;
        case 2: 
          return 3;
        case 3: 
          return 4;
        }
        return 5;
      }
      if (this.jdField_d_of_type_Boolean) {
        return 2;
      }
      if (paramInt == this.jdField_c_of_type_JavaUtilArrayList.size() + 1) {
        return 6;
      }
      return 1;
    }
    if (paramInt == 0) {
      return 0;
    }
    return 7;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject6 = null;
    Object localObject7 = null;
    int i1 = getItemViewType(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "getView->pos:" + paramInt + ", type:" + i1);
    }
    Object localObject5;
    boolean bool;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (a(i1, paramView, paramInt)) {
      switch (i1)
      {
      case 3: 
      case 4: 
      case 5: 
      default: 
        localObject5 = null;
        bool = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject6 = localObject7;
      }
    }
    for (;;)
    {
      localObject7 = localObject6;
      localObject6 = localObject5;
      localObject5 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject7;
      for (;;)
      {
        if (i1 == 0) {
          a((nep)localObject2);
        }
        do
        {
          do
          {
            return paramView;
            localObject1 = (nep)paramView.getTag();
            bool = false;
            localObject2 = null;
            localObject3 = null;
            localObject4 = null;
            localObject5 = null;
            localObject6 = localObject7;
            break;
            localObject2 = (nes)paramView.getTag();
            bool = false;
            localObject1 = null;
            localObject3 = null;
            localObject4 = null;
            localObject5 = null;
            localObject6 = localObject7;
            break;
            localObject5 = (nen)paramView.getTag();
            if (this.jdField_a_of_type_Nfg == null) {
              break label2226;
            }
            this.jdField_a_of_type_Nfg.jdField_c_of_type_Boolean = false;
            bool = false;
            localObject1 = null;
            localObject2 = null;
            localObject3 = null;
            localObject4 = null;
            localObject6 = localObject7;
            break;
            localObject4 = (nel)paramView.getTag();
            bool = a(paramInt);
            localObject1 = null;
            localObject2 = null;
            localObject3 = null;
            localObject5 = null;
            localObject6 = localObject7;
            break;
            localObject3 = (nem)paramView.getTag();
            bool = false;
            localObject1 = null;
            localObject2 = null;
            localObject4 = null;
            localObject5 = null;
            localObject6 = localObject7;
            break;
            localObject5 = null;
            bool = false;
            localObject1 = null;
            localObject2 = null;
            localObject3 = null;
            localObject4 = null;
            localObject6 = localObject7;
            break;
            localObject5 = null;
            bool = false;
            localObject1 = null;
            localObject2 = null;
            localObject3 = null;
            localObject4 = null;
            localObject6 = localObject7;
            break;
            localObject6 = (neo)paramView.getTag();
            bool = false;
            localObject1 = null;
            localObject2 = null;
            localObject3 = null;
            localObject4 = null;
            localObject5 = null;
            break;
            float f1;
            switch (i1)
            {
            case 3: 
            case 4: 
            case 5: 
            default: 
              bool = false;
              localObject1 = null;
              localObject2 = null;
              localObject3 = null;
              localObject4 = null;
              localObject5 = null;
              break;
            case 0: 
              paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558407, paramViewGroup, false);
              paramView.setOnClickListener(null);
              localObject2 = new nep(this);
              ((nep)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369748));
              ((nep)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
              ((nep)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367687));
              ((nep)localObject2).d = ((ImageView)paramView.findViewById(2131364022));
              ((nep)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361850));
              ((nep)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361849));
              ((nep)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361852));
              paramView.setTag(localObject2);
              bool = false;
              localObject3 = null;
              localObject4 = null;
              localObject5 = null;
              localObject1 = null;
              break;
            case 8: 
              paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558409, paramViewGroup, false);
              paramView.setOnClickListener(null);
              localObject3 = new nes(this);
              ((nes)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369748));
              ((nes)localObject3).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
              ((nes)localObject3).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367687));
              ((nes)localObject3).d = ((ImageView)paramView.findViewById(2131364022));
              ((nes)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361850));
              ((nes)localObject3).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361852));
              ((nes)localObject3).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361849));
              ((nes)localObject3).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361848));
              this.jdField_a_of_type_AndroidWidgetButton = ((nes)localObject3).jdField_a_of_type_AndroidWidgetButton;
              this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
              paramView.findViewById(2131361853).setOnClickListener(new neb(this));
              f1 = ajwc.a() / 16.0F;
              if (f1 > 1.0F) {
                ((nes)localObject3).jdField_b_of_type_AndroidWidgetTextView.setTextSize(14 / f1);
              }
              for (;;)
              {
                paramView.setTag(localObject3);
                bool = false;
                localObject1 = null;
                localObject4 = null;
                localObject5 = null;
                localObject2 = null;
                break;
                ((nes)localObject3).jdField_b_of_type_AndroidWidgetTextView.setTextSize(14);
              }
            case 10: 
              paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558408, paramViewGroup, false);
              localObject1 = paramView.getLayoutParams();
              ((ViewGroup.LayoutParams)localObject1).height = this.o;
              if (b()) {
                ((ViewGroup.LayoutParams)localObject1).height -= f();
              }
              paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
              paramView.setOnClickListener(null);
              localObject1 = new nen(this);
              ((nen)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131378948));
              ((nen)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
              ((nen)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364022));
              ((nen)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361850));
              ((nen)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361852));
              ((nen)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131379042));
              ((nen)localObject1).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361848));
              ((nen)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131361846);
              ((nen)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361844));
              ((nen)localObject1).d = ((ImageView)paramView.findViewById(2131361845));
              ((nen)localObject1).e = ((ImageView)paramView.findViewById(2131369486));
              ((nen)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377315));
              f1 = ajwc.a() / 16.0F;
              if (f1 > 1.0F) {
                ((nen)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextSize(14 / f1);
              }
              for (;;)
              {
                this.jdField_a_of_type_AndroidWidgetButton = ((nen)localObject1).jdField_a_of_type_AndroidWidgetButton;
                this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
                ((nen)localObject1).jdField_a_of_type_AndroidViewView.setOnClickListener(new nef(this));
                paramView.findViewById(2131361853).setOnClickListener(new neg(this));
                paramView.setTag(localObject1);
                if (this.jdField_a_of_type_Nfg == null) {
                  break label2197;
                }
                this.jdField_a_of_type_Nfg.jdField_c_of_type_Boolean = true;
                bool = false;
                localObject7 = null;
                localObject2 = null;
                localObject3 = null;
                localObject4 = null;
                localObject5 = null;
                localObject6 = localObject1;
                localObject1 = localObject7;
                break;
                ((nen)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTextSize(14);
              }
            case 1: 
              bool = a(paramInt);
              if (bool) {}
              for (paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559434, paramViewGroup, false);; paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559425, paramViewGroup, false))
              {
                localObject5 = new nel(this);
                ((nel)localObject5).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131365429));
                ((nel)localObject5).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365432));
                ((nel)localObject5).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365431));
                ((nel)localObject5).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365443));
                ((nel)localObject5).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365442));
                ((nel)localObject5).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365430));
                ((nel)localObject5).jdField_a_of_type_Boolean = bool;
                paramView.setTag(localObject5);
                localObject2 = null;
                localObject3 = null;
                localObject4 = null;
                localObject1 = null;
                break;
              }
            case 6: 
              paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558403, paramViewGroup, false);
              paramView.setOnClickListener(null);
              bool = false;
              localObject1 = null;
              localObject2 = null;
              localObject3 = null;
              localObject4 = null;
              localObject5 = null;
              break;
            case 7: 
              if (this.jdField_a_of_type_Boolean) {}
              for (paramView = this.jdField_b_of_type_AndroidViewView;; paramView = this.jdField_a_of_type_Nfr.a())
              {
                paramView.setPadding(0, actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
                paramView.setMinimumHeight(this.n);
                localObject1 = null;
                localObject2 = null;
                localObject3 = null;
                localObject4 = null;
                localObject5 = null;
                bool = false;
                break;
                if (this.jdField_a_of_type_Nfr == null) {
                  this.jdField_a_of_type_Nfr = new nfr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, false);
                }
              }
            case 2: 
              paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559424, paramViewGroup, false);
              localObject4 = new nem(this);
              ((nem)localObject4).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361847));
              ((nem)localObject4).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372090));
              ((nem)localObject4).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372106));
              paramView.setTag(localObject4);
              paramView.setMinimumHeight(this.o);
              bool = false;
              localObject1 = null;
              localObject2 = null;
              localObject5 = null;
              localObject3 = null;
              break;
            case 9: 
              paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558404, paramViewGroup, false);
              paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels));
              paramView.setOnClickListener(null);
              localObject1 = new neo(this);
              ((neo)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369508));
              ((neo)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369498));
              ((neo)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375197));
              paramView.setTag(localObject1);
              bool = false;
              localObject2 = null;
              localObject3 = null;
              localObject4 = null;
              localObject5 = null;
              break;
              if (i1 == 8)
              {
                a((nes)localObject3);
                return paramView;
              }
              if (i1 == 10)
              {
                a((nen)localObject6);
                return paramView;
              }
              if (i1 == 1)
              {
                a((nel)localObject5, paramView, paramInt, bool);
                return paramView;
              }
              if (i1 == 6)
              {
                a(paramView);
                return paramView;
              }
              if (i1 == 2)
              {
                a((nem)localObject4, paramView);
                return paramView;
              }
              if (i1 == 9)
              {
                if (this.jdField_i_of_type_Boolean)
                {
                  ((neo)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                  ((neo)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
                  ((neo)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                  return paramView;
                }
                ((neo)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
                ((neo)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                ((neo)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                return paramView;
              }
              localObject1 = (nmr)getItem(paramInt);
              switch (i1)
              {
              default: 
                return paramView;
              case 3: 
                paramViewGroup = AccountDetailBannerViewWrapper.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, (nmr)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType, this.jdField_a_of_type_Ney, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
                paramView = paramViewGroup;
              }
              break;
            }
          } while (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout == null);
          this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.a(paramViewGroup);
          return paramViewGroup;
          paramViewGroup = ngy.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, (nmr)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType, this.jdField_a_of_type_Ney, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          paramView = paramViewGroup;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout == null);
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.a(paramViewGroup);
        return paramViewGroup;
        return ngx.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, (nmr)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType, this.jdField_a_of_type_Ney, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        label2197:
        bool = false;
        localObject7 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = localObject1;
        localObject1 = localObject7;
      }
      label2226:
      bool = false;
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      localObject4 = null;
      localObject6 = localObject7;
    }
  }
  
  public int getViewTypeCount()
  {
    return 11;
  }
  
  public void h()
  {
    this.jdField_f_of_type_Boolean = false;
    d(true);
  }
  
  void i()
  {
    if ((this.jdField_b_of_type_AndroidWidgetButton != null) && (this.jdField_b_of_type_AndroidWidgetButton.getAnimation() != null))
    {
      this.jdField_b_of_type_AndroidWidgetButton.getAnimation().cancel();
      this.jdField_b_of_type_AndroidWidgetButton.clearAnimation();
    }
  }
  
  void j()
  {
    if (this.jdField_a_of_type_Nen == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "showLoadingView");
    }
    this.jdField_a_of_type_Nen.e.setVisibility(0);
    this.jdField_a_of_type_Nen.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842638));
    this.jdField_a_of_type_Nen.e.clearAnimation();
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(500L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setRepeatMode(1);
    localRotateAnimation.setStartTime(-1L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_Nen.e.startAnimation(localRotateAnimation);
    this.jdField_a_of_type_Nen.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void k()
  {
    if (this.jdField_a_of_type_Nen == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "hideLoadingView");
    }
    this.jdField_a_of_type_Nen.e.clearAnimation();
    this.jdField_a_of_type_Nen.e.setVisibility(8);
    this.jdField_a_of_type_Nen.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_Nen == null) {
      return;
    }
    this.jdField_a_of_type_Nen.e.clearAnimation();
    this.jdField_a_of_type_Nen.e.setVisibility(0);
    this.jdField_a_of_type_Nen.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837515));
    this.jdField_a_of_type_Nen.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void notifyDataSetChanged()
  {
    if ((this.jdField_d_of_type_Boolean) && (!a()))
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setAdapter(this);
    }
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && ((this.jdField_a_of_type_AndroidAppActivity instanceof View.OnClickListener)))
    {
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
        this.jdField_g_of_type_Boolean = true;
      }
      ((View.OnClickListener)this.jdField_a_of_type_AndroidAppActivity).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nea
 * JD-Core Version:    0.7.0.1
 */