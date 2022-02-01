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
import android.os.Looper;
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
import com.tencent.biz.pubaccount.PublicAccountMenuBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class npm
  extends BaseAdapter
  implements View.OnClickListener, nqz
{
  private static int r = 10;
  private static int s = 20;
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
  private bkhe jdField_a_of_type_Bkhe = new npv(this);
  private AccountDetailTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout;
  AccountDetailXListView jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView;
  private URLDrawableDownListener.Adapter jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new npq(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  EqqDetail jdField_a_of_type_ComTencentMobileqqDataEqqDetail;
  String jdField_a_of_type_JavaLangString;
  private ArrayList<nqh> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
  npz jdField_a_of_type_Npz = null;
  private nqd jdField_a_of_type_Nqd;
  nql jdField_a_of_type_Nql;
  nqt jdField_a_of_type_Nqt;
  nre jdField_a_of_type_Nre;
  boolean jdField_a_of_type_Boolean = false;
  final int jdField_b_of_type_Int = 0;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_b_of_type_AndroidViewView;
  protected TranslateAnimation b;
  public Button b;
  public ImageView b;
  String jdField_b_of_type_JavaLangString;
  private ArrayList<nqh> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  final int jdField_c_of_type_Int = 1;
  Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  public ImageView c;
  private ArrayList<nyk> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_c_of_type_Boolean = false;
  final int jdField_d_of_type_Int = 2;
  private ArrayList<nyk> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
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
  final int n = 13;
  int o;
  int p = 0;
  int q = 0;
  private int t = AccountDetailActivity.jdField_i_of_type_Int;
  private int u = 1;
  
  public npm(QQAppInterface paramQQAppInterface, Context paramContext, AccountDetail paramAccountDetail, String paramString, boolean paramBoolean, AccountDetailXListView paramAccountDetailXListView, AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      this.u = oat.a(paramQQAppInterface, paramString, paramAccountDetail);
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.c();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView = paramAccountDetailXListView;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.getResources().getDisplayMetrics().density;
    this.q = ((AccountDetailActivity)this.jdField_a_of_type_AndroidAppActivity).a()[1];
    this.o = ((AccountDetailActivity)this.jdField_a_of_type_AndroidAppActivity).a()[0];
    b();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Nql = new nql(paramQQAppInterface, paramContext, paramAccountDetail);
      paramQQAppInterface = nqq.a(paramQQAppInterface).a(paramString);
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
        break label489;
      }
    }
    label489:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramQQAppInterface.a(paramBoolean);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout = paramAccountDetailTopGestureLayout;
      return;
    }
  }
  
  public npm(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, AccountDetailXListView paramAccountDetailXListView, ImageView paramImageView1, ImageView paramImageView2, RelativeLayout paramRelativeLayout, ImageView paramImageView3, AccountDetailTopGestureLayout paramAccountDetailTopGestureLayout)
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
    if (!bgnt.h(this.jdField_a_of_type_AndroidContentContext)) {
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
    while (tzo.a(paramAccountDetail.accountFlag) != -2) {
      return false;
    }
    return true;
  }
  
  private boolean a(nyk paramnyk)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramnyk != null) && (paramnyk.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = paramnyk.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        nyl localnyl = (nyl)localIterator.next();
        switch (paramnyk.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 5: 
        case 6: 
          if (!TextUtils.isEmpty(localnyl.e)) {
            localArrayList.add(localnyl);
          }
          break;
        case 7: 
          if ((!TextUtils.isEmpty(localnyl.e)) && (!TextUtils.isEmpty(localnyl.j))) {
            localArrayList.add(localnyl);
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
  
  private boolean b(nyk paramnyk)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {}
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType;; i1 = -1)
    {
      if ((paramnyk != null) && (paramnyk.jdField_a_of_type_JavaUtilList != null))
      {
        Iterator localIterator = paramnyk.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          nyl localnyl = (nyl)localIterator.next();
          if ((localnyl.jdField_b_of_type_Int == 0) || ((localnyl.jdField_b_of_type_Int == 1) && (i1 == 1))) {}
          for (int i2 = 1; i2 != 0; i2 = 0) {
            switch (paramnyk.jdField_a_of_type_Int)
            {
            default: 
              break;
            case 2: 
              if (localnyl.jdField_c_of_type_Int != 23) {
                break label179;
              }
              if ((TextUtils.isEmpty(localnyl.e)) || (TextUtils.isEmpty(localnyl.jdField_b_of_type_JavaLangString))) {
                break;
              }
              localArrayList.add(localnyl);
              break;
            }
          }
          label179:
          if (!TextUtils.isEmpty(localnyl.e))
          {
            localArrayList.add(localnyl);
            continue;
            if (localnyl.jdField_c_of_type_Int == 23)
            {
              if ((!TextUtils.isEmpty(localnyl.e)) && (!TextUtils.isEmpty(localnyl.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(localnyl.jdField_b_of_type_JavaLangString))) {
                localArrayList.add(localnyl);
              }
            }
            else if ((!TextUtils.isEmpty(localnyl.e)) && (!TextUtils.isEmpty(localnyl.jdField_a_of_type_JavaLangString))) {
              localArrayList.add(localnyl);
            }
          }
        }
      }
      if ((paramnyk != null) && (paramnyk.jdField_a_of_type_Int == 4) && (localArrayList.size() % 2 != 0)) {
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
        nyk localnyk = (nyk)localIterator.next();
        switch (localnyk.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 2: 
        case 3: 
        case 4: 
          if (b(localnyk)) {
            this.jdField_c_of_type_JavaUtilArrayList.add(localnyk);
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
        nyk localnyk = (nyk)localIterator.next();
        switch (localnyk.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 5: 
        case 6: 
        case 7: 
          if (a(localnyk)) {
            this.jdField_d_of_type_JavaUtilArrayList.add(localnyk);
          }
          break;
        }
      }
    }
  }
  
  @TargetApi(11)
  private void o()
  {
    if ((this.jdField_a_of_type_Npz == null) || (this.jdField_a_of_type_Npz.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
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
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new npo(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new npp(this));
    this.jdField_a_of_type_Npz.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
  }
  
  @TargetApi(11)
  private void p()
  {
    if (this.jdField_a_of_type_Npz == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Npz.jdField_a_of_type_AndroidViewView.getAnimation() != null)
      {
        this.jdField_a_of_type_Npz.jdField_a_of_type_AndroidViewView.getAnimation().setAnimationListener(null);
        this.jdField_a_of_type_Npz.jdField_a_of_type_AndroidViewView.getAnimation().cancel();
        this.jdField_a_of_type_Npz.jdField_a_of_type_AndroidViewView.clearAnimation();
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
    if (this.jdField_a_of_type_Nqd != null) {
      this.jdField_a_of_type_Nqd.a();
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
  
  public nqt a()
  {
    if (this.jdField_a_of_type_Nqt != null) {
      return this.jdField_a_of_type_Nqt;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Nre != null) {
      this.jdField_a_of_type_Nre.b();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    p();
    i();
    tdv.a().a();
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
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
    paramView = (nqc)paramView.getTag();
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
      localLayoutParams3 = (RelativeLayout.LayoutParams)paramView.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
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
      paramView.findViewById(2131373019).setVisibility(8);
    }
    do
    {
      return;
      paramView = (TextView)paramView.findViewById(2131373018);
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
      this.jdField_a_of_type_Nql = new nql(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramAccountDetail);
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
  
  public void a(ArrayList<nqh> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      this.jdField_b_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
  }
  
  public void a(ArrayList<nqh> paramArrayList, boolean paramBoolean)
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
      nqh localnqh = (nqh)localIterator.next();
      if ((localnqh.jdField_a_of_type_Nqk != null) && (localnqh.jdField_a_of_type_Nqk.jdField_a_of_type_Int != 1) && (localnqh.jdField_a_of_type_Nqk.jdField_a_of_type_Int != 2)) {
        paramArrayList.add(localnqh);
      } else if ((localnqh.jdField_a_of_type_Nqi != null) && (localnqh.jdField_a_of_type_Nqi.jdField_a_of_type_Int != 1) && (localnqh.jdField_a_of_type_Nqi.jdField_a_of_type_Int != 2)) {
        paramArrayList.add(localnqh);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(paramArrayList);
  }
  
  void a(npx paramnpx, View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramnpx == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg: dynamic holder is null");
      }
    }
    for (;;)
    {
      return;
      nqh localnqh = (nqh)getItem(paramInt);
      if (localnqh == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.jdField_a_of_type_JavaLangString + "动态消息为空");
        return;
      }
      if (localnqh.jdField_a_of_type_Nqi == null)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + this.jdField_a_of_type_JavaLangString + "动态消息的消息属性为空");
        return;
      }
      Object localObject2;
      if (!localnqh.jdField_a_of_type_Boolean)
      {
        localnqh.jdField_a_of_type_Boolean = true;
        localObject2 = new JSONObject();
        if (this.jdField_a_of_type_Boolean) {}
      }
      try
      {
        ((JSONObject)localObject2).put("cha_1", localnqh.jdField_a_of_type_Nqi.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject2).put("cha_2", this.u);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        str2 = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType == 1) {}
        for (String str1 = "02";; str1 = "01")
        {
          bcst.b((QQAppInterface)localObject3, "dc01160", "Pb_account_lifeservice", str2, "0X8007CA2", "0X8007CA2", 0, 0, str1, String.valueOf(localnqh.jdField_a_of_type_Nqi.jdField_a_of_type_Int), String.valueOf(localnqh.jdField_a_of_type_Nqi.jdField_a_of_type_Long), ((JSONObject)localObject2).toString());
          if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg: item:= " + paramInt + "report msg: artical id=" + localnqh.jdField_a_of_type_Nqi.jdField_a_of_type_Long + "   artical name=" + localnqh.jdField_a_of_type_JavaLangString + " json=" + ((JSONObject)localObject2).toString());
          }
          paramInt = localnqh.jdField_a_of_type_Nqi.jdField_a_of_type_Int;
          if (paramInt != 2) {
            break label895;
          }
          bool = true;
          localObject2 = localnqh.jdField_a_of_type_JavaLangString;
          localObject3 = Long.valueOf(localnqh.jdField_a_of_type_Nqi.c);
          str2 = localnqh.jdField_a_of_type_Nqi.jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:title =" + (String)localObject2 + "--coverUrl=" + "" + "--jumpUrl=" + str2 + "--isVideoMsg =" + bool);
          }
          if (!bool) {
            break label666;
          }
          paramnpx.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          paramnpx.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramnpx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (localnqh.jdField_a_of_type_Nqk == null) {
            break label887;
          }
          if (!paramBoolean) {
            break label653;
          }
          str1 = localnqh.jdField_a_of_type_Nqk.d;
          paramnpx.jdField_c_of_type_AndroidWidgetTextView.setText(mue.a(localnqh.jdField_a_of_type_Nqk.jdField_b_of_type_Int));
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
          Object localObject1 = localnqh.jdField_a_of_type_Nqk.jdField_a_of_type_JavaLangString;
          continue;
          label666:
          paramnpx.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
          paramnpx.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          paramnpx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          if (localnqh.jdField_a_of_type_Nqj != null)
          {
            if (paramBoolean)
            {
              localObject1 = localnqh.jdField_a_of_type_Nqj.jdField_b_of_type_JavaLangString;
              continue;
            }
            localObject1 = localnqh.jdField_a_of_type_Nqj.jdField_a_of_type_JavaLangString;
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
                paramnpx.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
                paramnpx.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
                paramnpx.jdField_b_of_type_AndroidWidgetTextView.setText(pgz.a(((Long)localObject3).longValue()));
                paramView.setOnClickListener(new npu(this, paramInt, str2, localnqh));
                return;
              }
              catch (Exception paramnpx) {}
              localObject1 = URLDrawable.getDrawable((String)localObject1, afur.a(124.0F, localResources), afur.a(95.0F, localResources), localColorDrawable, localColorDrawable, true);
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("AccountDetailBaseAdapter", 2, "setDataForDynamicMsg:" + paramnpx);
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
  
  void a(npy paramnpy, View paramView)
  {
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    paramView.setClickable(false);
    paramView.setOnClickListener(null);
    if (this.jdField_h_of_type_Boolean)
    {
      if (this.t != AccountDetailActivity.jdField_i_of_type_Int) {
        break label92;
      }
      paramnpy.jdField_a_of_type_AndroidWidgetTextView.setText(2131689503);
      paramnpy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramnpy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      paramnpy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    for (;;)
    {
      paramnpy.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new npt(this, paramnpy));
      return;
      label92:
      if (this.t == AccountDetailActivity.j)
      {
        paramnpy.jdField_a_of_type_AndroidWidgetTextView.setText(2131694617);
        paramnpy.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, (int)(5.0F * f1), 0, (int)(f1 * 5.0F));
        paramnpy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839277);
        paramnpy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else if (this.t == AccountDetailActivity.k)
      {
        paramnpy.jdField_a_of_type_AndroidWidgetTextView.setText(2131689506);
        paramnpy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841665);
        paramnpy.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, (int)(5.0F * f1), 0, (int)(f1 * 5.0F));
        paramnpy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      }
    }
  }
  
  void a(npz paramnpz)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    label79:
    nyk localnyk;
    label166:
    label176:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Npz = paramnpz;
        int i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name.length();
        if ((i1 > 8) && (i1 < 13)) {
          paramnpz.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
        }
        paramnpz.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
        if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
          break;
        }
        paramnpz.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_c_of_type_Boolean)
        {
          paramnpz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramnpz.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary.trim());
        }
        paramnpz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
        if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1) {
          break label419;
        }
        if (!this.jdField_g_of_type_Boolean) {
          break label407;
        }
        paramnpz.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramnpz.jdField_a_of_type_AndroidWidgetButton.setText(null);
        paramnpz.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837513);
        this.jdField_b_of_type_AndroidWidgetButton.setText(2131694658);
        localnyk = (nyk)getItem(0);
      } while ((localnyk == null) || (localnyk.jdField_a_of_type_JavaUtilList == null) || (localnyk.jdField_a_of_type_JavaUtilList.size() == 0));
      localObject = ((nyl)localnyk.jdField_a_of_type_JavaUtilList.get(0)).e;
    } while (TextUtils.isEmpty((CharSequence)localObject));
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#f7f9fe"));
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    if (localnyk.jdField_a_of_type_Int == 6) {
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
      paramnpz.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      o();
      if (localnyk.jdField_a_of_type_Int != 7) {
        break;
      }
      if (this.jdField_a_of_type_Nqt == null) {
        this.jdField_a_of_type_Nqt = new nqt(this.jdField_a_of_type_AndroidAppActivity, this);
      }
      paramnpz.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_Nqt.a(localnyk, paramnpz.jdField_a_of_type_AndroidWidgetFrameLayout);
      return;
      paramnpz.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label79;
      label407:
      paramnpz.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break label166;
      label419:
      paramnpz.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramnpz.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694595));
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131694659);
      break label176;
      paramnpz.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      if ((this.jdField_a_of_type_Nqt == null) || (!this.jdField_f_of_type_Boolean)) {
        j();
      }
    }
  }
  
  void a(nqb paramnqb, View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getButtonInfo();
    if (paramView != null)
    {
      paramnqb.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqOsMqqHandler);
      paramnqb.a.setData(paramView);
    }
  }
  
  void a(nqc paramnqc)
  {
    int i1;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null) {
        return;
      }
      paramnqc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(Color.parseColor("#3d7fe3"));
      i1 = this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name.length();
      if ((i1 > 8) && (i1 < 13)) {
        paramnqc.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
      }
      paramnqc.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.name);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.displayNumber))
      {
        paramnqc.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.displayNumber);
        label103:
        if (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail.certifiedGrade == 0) {
          break label145;
        }
        paramnqc.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      paramnqc.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
      return;
      paramnqc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label103;
      label145:
      paramnqc.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion == 0)
      {
        paramnqc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramnqc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        paramnqc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramnqc.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramnqc.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        paramnqc.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
        paramnqc.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramnqc.jdField_c_of_type_AndroidViewView.setVisibility(8);
        label248:
        i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name.length();
        if ((i1 > 8) && (i1 < 13)) {
          paramnqc.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
        }
        paramnqc.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription)) {
          break label496;
        }
        paramnqc.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
          break label508;
        }
        paramnqc.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
        paramnqc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramnqc.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramnqc.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
        paramnqc.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth((int)(this.o - this.jdField_a_of_type_Float * 105.0F));
        paramnqc.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        paramnqc.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.sharedFollowerCount + "位好友关注");
        paramnqc.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
        if (tzo.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail) != null)
        {
          paramnqc.jdField_d_of_type_AndroidViewView.setVisibility(0);
          paramnqc.jdField_c_of_type_AndroidViewView.setVisibility(0);
          break label248;
        }
        paramnqc.jdField_d_of_type_AndroidViewView.setVisibility(8);
        paramnqc.jdField_c_of_type_AndroidViewView.setVisibility(8);
        break label248;
        label496:
        paramnqc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      label508:
      paramnqc.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(nqd paramnqd)
  {
    this.jdField_a_of_type_Nqd = paramnqd;
  }
  
  void a(nqf paramnqf)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    paramnqf.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    paramnqf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name.length();
    if ((i1 > 8) && (i1 < 13)) {
      paramnqf.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 20.0F);
    }
    paramnqf.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade != 0)
    {
      paramnqf.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      if ((!a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription))) {
        break label231;
      }
      paramnqf.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription);
      label133:
      String str = a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary);
      paramnqf.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      paramnqf.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1) {
        break label255;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break label243;
      }
      paramnqf.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      paramnqf.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837513);
      paramnqf.jdField_a_of_type_AndroidWidgetButton.setText(null);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setText(2131694658);
      return;
      paramnqf.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label231:
      paramnqf.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label133;
      label243:
      paramnqf.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    label255:
    paramnqf.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramnqf.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839283);
    paramnqf.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694595));
    paramnqf.jdField_a_of_type_AndroidWidgetButton.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131694659);
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
      if ((!this.jdField_h_of_type_Boolean) || ((this.t != AccountDetailActivity.jdField_i_of_type_Int) && (this.t != AccountDetailActivity.j) && (this.t != AccountDetailActivity.k))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    nqh localnqh = (nqh)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - this.jdField_c_of_type_JavaUtilArrayList.size() - 2);
    if (localnqh != null)
    {
      if ((localnqh.jdField_a_of_type_Nqj != null) && (localnqh.jdField_a_of_type_Nqj.jdField_a_of_type_Int == 1)) {
        return true;
      }
      if ((localnqh.jdField_a_of_type_Nqk != null) && (localnqh.jdField_a_of_type_Nqk.jdField_e_of_type_Int == 1)) {
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
                do
                {
                  return bool1;
                  if (paramInt1 == 1)
                  {
                    bool1 = a(paramInt2);
                    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof npx)) && (bool1 == ((npx)paramView.getTag()).jdField_a_of_type_Boolean)) {}
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
                } while ((paramView.getTag() instanceof npy));
                return false;
                if (paramInt1 != 0) {
                  break label124;
                }
                if (paramView.getTag() == null) {
                  break;
                }
                bool1 = bool2;
              } while ((paramView.getTag() instanceof nqc));
              return false;
              if (paramInt1 != 8) {
                break label153;
              }
              if (paramView.getTag() == null) {
                break;
              }
              bool1 = bool2;
            } while ((paramView.getTag() instanceof nqf));
            return false;
            if (paramInt1 != 9) {
              break label182;
            }
            if (paramView.getTag() == null) {
              break;
            }
            bool1 = bool2;
          } while ((paramView.getTag() instanceof nqa));
          return false;
          if (paramInt1 != 10) {
            break label211;
          }
          if (paramView.getTag() == null) {
            break;
          }
          bool1 = bool2;
        } while ((paramView.getTag() instanceof npz));
        return false;
        bool1 = bool2;
      } while (paramInt1 != 11);
      if (paramView.getTag() == null) {
        break;
      }
      bool1 = bool2;
    } while ((paramView.getTag() instanceof nqb));
    label153:
    label182:
    label211:
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
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOnScrollListener(this.jdField_a_of_type_Bkhe);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.setOnEndScrollListener(new npw(this));
  }
  
  public void b(int paramInt)
  {
    this.t = paramInt;
  }
  
  void b(int paramInt, View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView = (npz)paramView.getTag();
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
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_JavaLangString));
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
    paramView = (nqf)paramView.getTag();
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
      localLayoutParams3 = (RelativeLayout.LayoutParams)paramView.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramInt >= f1) {
        break label357;
      }
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedGrade == 0) {
        break label302;
      }
      paramView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
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
      paramView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      break label106;
      label314:
      i1 = (int)(0.72D * localLayoutParams1.height) + (int)(paramInt * 2 / f1 * this.jdField_a_of_type_Float);
      localLayoutParams3.leftMargin = i1;
      localLayoutParams3.topMargin = i1;
      break label260;
      label357:
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      paramView.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
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
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailXListView.smoothScrollBy(this.q - paramInt - this.jdField_a_of_type_AndroidViewView.getHeight(), 500);
    c();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType != 1)) {
      c(paramInt);
    }
  }
  
  void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Npz != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_Npz.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Npz.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {}
    do
    {
      return 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) || (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion != 1)) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getButtonInfo() == null);
    return 2;
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
        } while (((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion == 1)) || (!this.jdField_c_of_type_Boolean));
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
    int i1 = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) && (this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail == null)) {
      i1 = 9;
    }
    do
    {
      return i1;
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      if (paramInt == 0)
      {
        if (this.jdField_b_of_type_Boolean) {
          return 10;
        }
        return 8;
      }
      if (paramInt <= this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        switch (((nyk)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt - 1)).jdField_a_of_type_Int)
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
    } while (paramInt != this.jdField_c_of_type_JavaUtilArrayList.size() + 1);
    return 6;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.protocolVersion == 1))
    {
      switch (paramInt)
      {
      default: 
        return -1;
      case 0: 
        return 0;
      }
      return 11;
    }
    if (paramInt == 0) {
      return 0;
    }
    return 7;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject13 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    boolean bool2 = false;
    Object localObject1 = null;
    int i1 = getItemViewType(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "getView->pos:" + paramInt + ", type:" + i1);
    }
    Object localObject7;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    if (a(i1, paramView, paramInt)) {
      switch (i1)
      {
      case 3: 
      case 4: 
      case 5: 
      default: 
        localObject7 = null;
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
      }
    }
    for (;;)
    {
      localObject8 = localObject7;
      localObject7 = localObject6;
      localObject6 = localObject5;
      localObject5 = localObject4;
      localObject4 = localObject3;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject8;
      if (i1 == 0) {
        a((nqc)localObject4);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject3 = (nqc)paramView.getTag();
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject4 = null;
        localObject7 = null;
        localObject6 = null;
        localObject5 = null;
        break;
        localObject4 = (nqf)paramView.getTag();
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject7 = null;
        localObject6 = null;
        localObject5 = null;
        break;
        localObject7 = (npz)paramView.getTag();
        if (this.jdField_a_of_type_Nqt == null) {
          break label2639;
        }
        this.jdField_a_of_type_Nqt.jdField_c_of_type_Boolean = false;
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
        break;
        localObject6 = (npx)paramView.getTag();
        bool1 = a(paramInt);
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject7 = null;
        localObject5 = null;
        break;
        localObject5 = (npy)paramView.getTag();
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject6 = null;
        localObject7 = null;
        break;
        localObject7 = null;
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
        break;
        localObject7 = null;
        bool1 = false;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject5 = null;
        localObject6 = null;
        break;
        localObject2 = (nqa)paramView.getTag();
        bool1 = false;
        localObject1 = null;
        localObject3 = null;
        localObject4 = null;
        localObject7 = null;
        localObject6 = null;
        localObject5 = null;
        break;
        localObject1 = (nqb)paramView.getTag();
        bool1 = false;
        localObject2 = null;
        localObject3 = null;
        localObject4 = null;
        localObject7 = null;
        localObject6 = null;
        localObject5 = null;
        break;
        float f1;
        switch (i1)
        {
        case 3: 
        case 4: 
        case 5: 
        default: 
          bool1 = bool2;
          localObject2 = localObject12;
          localObject3 = localObject11;
          localObject4 = localObject10;
          localObject5 = localObject9;
          localObject6 = localObject8;
          localObject7 = localObject13;
          break;
        case 0: 
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558407, paramViewGroup, false);
          paramView.setOnClickListener(null);
          localObject4 = new nqc(this);
          ((nqc)localObject4).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131378997);
          ((nqc)localObject4).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370473));
          ((nqc)localObject4).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131378088);
          ((nqc)localObject4).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368138));
          ((nqc)localObject4).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368150));
          ((nqc)localObject4).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364290));
          ((nqc)localObject4).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361883));
          ((nqc)localObject4).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361882));
          ((nqc)localObject4).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361885));
          ((nqc)localObject4).e = ((ImageView)paramView.findViewById(2131361886));
          ((nqc)localObject4).jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377384));
          ((nqc)localObject4).jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          ((nqc)localObject4).jdField_c_of_type_AndroidViewView = paramView.findViewById(2131365590);
          ((nqc)localObject4).jdField_d_of_type_AndroidViewView = paramView.findViewById(2131367985);
          ((nqc)localObject4).jdField_d_of_type_AndroidViewView.setOnClickListener(this);
          paramView.setTag(localObject4);
          bool1 = bool2;
          localObject2 = localObject12;
          localObject3 = localObject11;
          localObject5 = localObject9;
          localObject6 = localObject8;
          localObject7 = localObject13;
          break;
        case 8: 
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558409, paramViewGroup, false);
          paramView.setOnClickListener(null);
          localObject5 = new nqf(this);
          ((nqf)localObject5).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370473));
          ((nqf)localObject5).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368138));
          ((nqf)localObject5).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368150));
          ((nqf)localObject5).jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364290));
          ((nqf)localObject5).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361883));
          ((nqf)localObject5).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361885));
          ((nqf)localObject5).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361882));
          ((nqf)localObject5).jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361881));
          this.jdField_a_of_type_AndroidWidgetButton = ((nqf)localObject5).jdField_a_of_type_AndroidWidgetButton;
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
          paramView.findViewById(2131361887).setOnClickListener(new npn(this));
          f1 = anll.a() / 16.0F;
          if (f1 > 1.0F) {
            ((nqf)localObject5).jdField_b_of_type_AndroidWidgetTextView.setTextSize(14 / f1);
          }
          for (;;)
          {
            paramView.setTag(localObject5);
            bool1 = bool2;
            localObject2 = localObject12;
            localObject3 = localObject11;
            localObject4 = localObject10;
            localObject6 = localObject8;
            localObject7 = localObject13;
            break;
            ((nqf)localObject5).jdField_b_of_type_AndroidWidgetTextView.setTextSize(14);
          }
        case 10: 
          View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558408, paramViewGroup, false);
          paramView = localView.getLayoutParams();
          paramView.height = this.q;
          if (b()) {
            paramView.height -= f();
          }
          localView.setLayoutParams(paramView);
          localView.setOnClickListener(null);
          npz localnpz = new npz(this);
          localnpz.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131380607));
          localnpz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368138));
          localnpz.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364290));
          localnpz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361883));
          localnpz.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361885));
          localnpz.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131380733));
          localnpz.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131361881));
          localnpz.jdField_a_of_type_AndroidViewView = localView.findViewById(2131361879);
          localnpz.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361877));
          localnpz.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361878));
          localnpz.e = ((ImageView)localView.findViewById(2131370198));
          localnpz.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378737));
          f1 = anll.a() / 16.0F;
          if (f1 > 1.0F) {
            localnpz.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14 / f1);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetButton = localnpz.jdField_a_of_type_AndroidWidgetButton;
            this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
            localnpz.jdField_a_of_type_AndroidViewView.setOnClickListener(new npr(this));
            localView.findViewById(2131361887).setOnClickListener(new nps(this));
            localView.setTag(localnpz);
            paramView = localView;
            localObject1 = localnpz;
            bool1 = bool2;
            localObject2 = localObject12;
            localObject3 = localObject11;
            localObject4 = localObject10;
            localObject5 = localObject9;
            localObject6 = localObject8;
            localObject7 = localObject13;
            if (this.jdField_a_of_type_Nqt == null) {
              break;
            }
            this.jdField_a_of_type_Nqt.jdField_c_of_type_Boolean = true;
            paramView = localView;
            localObject1 = localnpz;
            bool1 = bool2;
            localObject2 = localObject12;
            localObject3 = localObject11;
            localObject4 = localObject10;
            localObject5 = localObject9;
            localObject6 = localObject8;
            localObject7 = localObject13;
            break;
            localnpz.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14);
          }
        case 1: 
          bool1 = a(paramInt);
          if (bool1) {}
          for (paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559617, paramViewGroup, false);; paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559608, paramViewGroup, false))
          {
            localObject7 = new npx(this);
            ((npx)localObject7).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131365750));
            ((npx)localObject7).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365753));
            ((npx)localObject7).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365752));
            ((npx)localObject7).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365764));
            ((npx)localObject7).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365763));
            ((npx)localObject7).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365751));
            ((npx)localObject7).jdField_a_of_type_Boolean = bool1;
            paramView.setTag(localObject7);
            localObject2 = localObject12;
            localObject3 = localObject11;
            localObject4 = localObject10;
            localObject5 = localObject9;
            localObject6 = localObject8;
            break;
          }
        case 6: 
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558403, paramViewGroup, false);
          paramView.setOnClickListener(null);
          bool1 = bool2;
          localObject2 = localObject12;
          localObject3 = localObject11;
          localObject4 = localObject10;
          localObject5 = localObject9;
          localObject6 = localObject8;
          localObject7 = localObject13;
          break;
        case 7: 
          if (this.jdField_a_of_type_Boolean) {}
          for (paramView = this.jdField_b_of_type_AndroidViewView;; paramView = this.jdField_a_of_type_Nre.a())
          {
            paramView.setPadding(0, afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
            paramView.setMinimumHeight(this.p);
            bool1 = bool2;
            localObject2 = localObject12;
            localObject3 = localObject11;
            localObject4 = localObject10;
            localObject5 = localObject9;
            localObject6 = localObject8;
            localObject7 = localObject13;
            break;
            if (this.jdField_a_of_type_Nre == null) {
              this.jdField_a_of_type_Nre = new nre(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, false);
            }
          }
        case 2: 
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559607, paramViewGroup, false);
          localObject6 = new npy(this);
          ((npy)localObject6).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131361880));
          ((npy)localObject6).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373017));
          ((npy)localObject6).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373033));
          paramView.setTag(localObject6);
          paramView.setMinimumHeight(this.q);
          bool1 = bool2;
          localObject2 = localObject12;
          localObject3 = localObject11;
          localObject4 = localObject10;
          localObject5 = localObject9;
          localObject7 = localObject13;
          break;
        case 9: 
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558404, paramViewGroup, false);
          paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels));
          paramView.setOnClickListener(null);
          localObject3 = new nqa(this);
          ((nqa)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370226));
          ((nqa)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370215));
          ((nqa)localObject3).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376457));
          paramView.setTag(localObject3);
          bool1 = bool2;
          localObject2 = localObject12;
          localObject4 = localObject10;
          localObject5 = localObject9;
          localObject6 = localObject8;
          localObject7 = localObject13;
          break;
        case 11: 
          paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558405, paramViewGroup, false);
          localObject2 = new nqb(this);
          ((nqb)localObject2).a = ((PublicAccountMenuBar)paramView.findViewById(2131370664));
          paramView.setTag(localObject2);
          bool1 = bool2;
          localObject3 = localObject11;
          localObject4 = localObject10;
          localObject5 = localObject9;
          localObject6 = localObject8;
          localObject7 = localObject13;
          break;
          if (i1 == 8)
          {
            a((nqf)localObject5);
          }
          else if (i1 == 10)
          {
            a((npz)localObject1);
          }
          else if (i1 == 1)
          {
            a((npx)localObject7, paramView, paramInt, bool1);
          }
          else if (i1 == 6)
          {
            a(paramView);
          }
          else if (i1 == 2)
          {
            a((npy)localObject6, paramView);
          }
          else if (i1 == 9)
          {
            if (this.jdField_i_of_type_Boolean)
            {
              ((nqa)localObject3).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
              ((nqa)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              ((nqa)localObject3).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            }
            else
            {
              ((nqa)localObject3).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              ((nqa)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              ((nqa)localObject3).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            }
          }
          else if (i1 == 11)
          {
            a((nqb)localObject2, paramView);
          }
          else
          {
            localObject1 = (nyk)getItem(paramInt);
            switch (i1)
            {
            default: 
            case 3: 
            case 4: 
              do
              {
                do
                {
                  break;
                  localObject1 = AccountDetailBannerViewWrapper.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, (nyk)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType, this.jdField_a_of_type_Nql, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
                  paramView = (View)localObject1;
                } while (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout == null);
                this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.a((View)localObject1);
                paramView = (View)localObject1;
                break;
                localObject1 = nsl.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, (nyk)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType, this.jdField_a_of_type_Nql, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
                paramView = (View)localObject1;
              } while (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout == null);
              this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.a((View)localObject1);
              paramView = (View)localObject1;
              break;
            case 5: 
              paramView = nsk.a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup, (nyk)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.followType, this.jdField_a_of_type_Nql, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
            }
          }
          break;
        }
      }
      label2639:
      bool1 = false;
      localObject1 = null;
      localObject2 = null;
      localObject3 = null;
      localObject4 = null;
      localObject5 = null;
      localObject6 = null;
    }
  }
  
  public int getViewTypeCount()
  {
    return 13;
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
    if (this.jdField_a_of_type_Npz == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "showLoadingView");
    }
    this.jdField_a_of_type_Npz.e.setVisibility(0);
    this.jdField_a_of_type_Npz.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843176));
    this.jdField_a_of_type_Npz.e.clearAnimation();
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(500L);
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setRepeatMode(1);
    localRotateAnimation.setStartTime(-1L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_Npz.e.startAnimation(localRotateAnimation);
    this.jdField_a_of_type_Npz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void k()
  {
    if (this.jdField_a_of_type_Npz == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseAdapter", 2, "hideLoadingView");
    }
    this.jdField_a_of_type_Npz.e.clearAnimation();
    this.jdField_a_of_type_Npz.e.setVisibility(8);
    this.jdField_a_of_type_Npz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  void l()
  {
    if (this.jdField_a_of_type_Npz == null) {
      return;
    }
    this.jdField_a_of_type_Npz.e.clearAnimation();
    this.jdField_a_of_type_Npz.e.setVisibility(0);
    this.jdField_a_of_type_Npz.e.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837517));
    this.jdField_a_of_type_Npz.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
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
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npm
 * JD-Core Version:    0.7.0.1
 */