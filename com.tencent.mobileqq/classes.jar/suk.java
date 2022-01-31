import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.3;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.9;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

public class suk
{
  public int a;
  private alzr jdField_a_of_type_Alzr = new sum(this);
  public View a;
  ViewStub jdField_a_of_type_AndroidViewViewStub = null;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton = null;
  public QQAppInterface a;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  public WeakReference<Activity> a;
  private stx jdField_a_of_type_Stx = new sul(this);
  sty jdField_a_of_type_Sty;
  sud jdField_a_of_type_Sud;
  public boolean a;
  int b = 0;
  int c = 0;
  private int d;
  
  public suk(Activity paramActivity, QQAppInterface paramQQAppInterface, sty paramsty)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Sty = paramsty;
    this.d = ((int)paramActivity.getResources().getDimension(2131297836));
    i();
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.3(this));
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("subscribe_version" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getString("subscirpt_full_recommend_url", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("subscribe_version" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(str, 0).edit();
    localEditor.putBoolean("is_show_subscribe_red_point" + str, true);
    localEditor.putBoolean("is_show_subscribe_folder_red_dot" + str, true);
    localEditor.putInt("pa_subscribe_config_show" + str, paramInt);
    localEditor.putString("pa_subscribe_config_msg" + str, paramString);
    localEditor.commit();
    paramString = suv.a();
    paramString.a(paramQQAppInterface, false);
    paramString.b(paramQQAppInterface, true);
    paramString.c(paramQQAppInterface, true);
    paramString.d(paramQQAppInterface, true);
    paramString.b(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("subscript_inner_recommend", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static boolean a(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 4).edit();
    paramAppInterface.putBoolean("subscript_full_recommend", paramBoolean);
    paramAppInterface.putString("subscirpt_full_recommend_url", paramString);
    return paramAppInterface.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    boolean bool1 = bool2;
    if (paramQQAppInterface.getBoolean("subscript_inner_recommend", false))
    {
      bool1 = bool2;
      if (!paramQQAppInterface.getBoolean("subscript_full_recommend", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("subscript_full_recommend_version" + paramQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public static String b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getString("pa_subscribe_config_msg" + paramQQAppInterface.getCurrentAccountUin(), "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("subscript_full_recommend_version" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("is_show_subscribe_red_point" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("subscript_full_recommend", false);
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("subscript_inner_recommend_version" + paramQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putInt("subscript_inner_recommend_version" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("is_show_subscribe_folder_red_dot" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return (paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("is_show_subscribe_red_point" + paramQQAppInterface.getCurrentAccountUin(), true)) && (f(paramQQAppInterface));
  }
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("subscribe_discovery_btn", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("pa_subscribe_config_show" + paramQQAppInterface.getCurrentAccountUin(), 1) != 0;
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("is_show_subscribe_folder_red_dot" + paramQQAppInterface.getCurrentAccountUin(), true);
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("subscribe_discovery_btn", true);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Stx);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alzr);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alzr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Stx);
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewViewStub == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772185);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new sur(this));
    a(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewStub == null) {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
      {
        this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131376196));
        if (this.jdField_a_of_type_AndroidViewViewStub != null)
        {
          this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(new sun(this));
          this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
          b();
          h();
        }
      }
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
      return;
      e();
      a(this.d);
    }
  }
  
  void a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    View localView;
    do
    {
      return;
      localView = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131369519);
    } while (localView == null);
    localView.setPadding(0, 0, 0, paramInt);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((stw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(64)).a(paramString);
    }
  }
  
  void a(List<suc> paramList)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    if (this.jdField_a_of_type_Sud == null) {
      this.jdField_a_of_type_Sud = new sud((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Sty);
    }
    this.jdField_a_of_type_Sud.a();
    this.jdField_a_of_type_Sud.a(paramList);
  }
  
  public boolean a()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity == null) {
      return false;
    }
    View localView = localActivity.findViewById(2131365742);
    WindowManager localWindowManager = (WindowManager)localActivity.getSystemService("window");
    int i = localWindowManager.getDefaultDisplay().getWidth();
    int j = localWindowManager.getDefaultDisplay().getHeight();
    int k = (int)localActivity.getResources().getDimension(2131298914);
    int m = (int)localActivity.getResources().getDimension(2131298920);
    int n = this.d;
    int i1 = localView.getHeight();
    int i2 = localView.getWidth();
    int i3 = ImmersiveUtils.getStatusBarHeight(localActivity);
    if ((i < i2) || (j - (k + m + n) - i3 < i1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  @TargetApi(9)
  public void b()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject1 = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources();
    if (bool)
    {
      i = 2131166015;
      i = ((Resources)localObject1).getColor(i);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new suo(this));
      Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377244);
      if (localObject2 != null)
      {
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label263;
        }
        i = 2131167080;
        label93:
        ((ImageView)localObject2).setBackgroundResource(i);
      }
      localObject2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377938);
      if (!bool) {
        break label270;
      }
      i = ((Resources)localObject1).getColor(2131166004);
      label126:
      ((TextView)localObject2).setTextColor(i);
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null)
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376191));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth((int)((Resources)localObject1).getDimension(2131297837));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Sud);
        if (Build.VERSION.SDK_INT >= 9) {
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetImageButton == null)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131364327));
        localObject1 = this.jdField_a_of_type_AndroidWidgetImageButton;
        if (bool) {
          break label281;
        }
      }
    }
    label263:
    label270:
    label281:
    for (int i = 2130842826;; i = 2130842828)
    {
      ((ImageButton)localObject1).setImageResource(i);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new sup(this));
      return;
      i = 2131166005;
      break;
      i = 2131166274;
      break label93;
      i = ((Resources)localObject1).getColor(2131166003);
      break label126;
    }
  }
  
  public void c()
  {
    if (a())
    {
      localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    int i = bdaq.a((Context)localObject, 100.0F);
    Object localObject = (ImageView)((Activity)localObject).findViewById(2131372440);
    this.b = ((ImageView)localObject).getHeight();
    this.c = ((ImageView)localObject).getWidth();
    ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(i, i));
  }
  
  public void d()
  {
    c();
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewViewStub == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772186);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new suq(this));
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
  }
  
  public void f()
  {
    j();
    if (this.jdField_a_of_type_Sud != null) {
      this.jdField_a_of_type_Sud.b();
    }
  }
  
  public void g()
  {
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.9(this));
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Sud != null) {
      this.jdField_a_of_type_Sud.notifyDataSetChanged();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SubscriptRecommendController", 2, "scriptRecommendAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     suk
 * JD-Core Version:    0.7.0.1
 */