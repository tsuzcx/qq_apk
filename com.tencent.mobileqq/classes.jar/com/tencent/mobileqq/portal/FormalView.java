package com.tencent.mobileqq.portal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.model.CommonData;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class FormalView
  extends RelativeLayout
  implements Handler.Callback
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130845327, 2130845328, 2130845329, 2130845330, 2130845331, 2130845332, 2130845333, 2130845334, 2130845335, 2130845336, 2130845337, 2130845338, 2130845339, 2130845340, 2130845341, 2130845342, 2130845343, 2130845344, 2130845345, 2130845346, 2130845347, 2130845348, 2130845349, 2130845350, 2130845351, 2130845352, 2130845353, 2130845354, 2130845355, 2130845356, 2130845357, 2130845358, 2130845359, 2130845360, 2130845361, 2130845362, 2130845363 };
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ValueAnimator jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = null;
  private FlakeView jdField_a_of_type_ComTencentMobileqqPortalFlakeView;
  public HongbaoCaidanRainView a;
  private ImageAlphaSwitchView jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView;
  private ImageShakeAnimView jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView;
  private ImageSwitchAnimView jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView;
  private ProgressViewYellow jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow;
  private StrokeTextView jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView;
  private String jdField_a_of_type_JavaLangString = "";
  public List<PortalManager.LogoConfig> a;
  public Map<Integer, PortalManager.ComboNumber> a;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = 0L;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap = null;
  private View jdField_b_of_type_AndroidViewView;
  private AnimationSet jdField_b_of_type_AndroidViewAnimationAnimationSet;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private StrokeTextView jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView;
  public List<PortalManager.ComboNumber> b;
  public boolean b;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private StrokeTextView jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView;
  public List<Integer> c;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private StrokeTextView jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private StrokeTextView jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private StrokeTextView jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView;
  private ImageView g;
  private ImageView h;
  private ImageView i;
  
  public FormalView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    LayoutInflater.from(paramContext).inflate(2131561110, this, true);
    paramContext = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getAssets(), "fonts/HuNan-CC.ttf");
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131364889));
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(paramContext);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6347776);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(-1);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.b(4.0F, getResources()));
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setShadow(AIOUtils.b(2.0F, getResources()), 0.0F, AIOUtils.b(1.0F, getResources()), 1073741824);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363690));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131368251));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(paramContext);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6347776);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(-1);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.b(4.0F, getResources()));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setShadowLayer(AIOUtils.b(2.0F, getResources()), 0.0F, AIOUtils.b(1.0F, getResources()), 1711276032);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131368244));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6347776);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setShadow(AIOUtils.b(4.0F, getResources()), 0.0F, 0.0F, -135991);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131376152));
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6347776);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(false);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setShadow(AIOUtils.b(4.0F, getResources()), 0.0F, 0.0F, -135991);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setText(HardCodeUtil.a(2131704817));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131368249));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(Color.parseColor("#9F2400"));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(Color.parseColor("#FBEACD"));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.b(2.0F, getResources()));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setTextSize(1, 24.0F);
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368241));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368242));
    paramContext = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    paramContext.height = ((int)(ViewUtils.a() * 736.0F / 750.0F));
    paramContext.topMargin = ViewUtils.b(203.0F);
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(paramContext);
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131371846));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(Color.parseColor("#9F2400"));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(Color.parseColor("#FBEACD"));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.b(2.0F, getResources()));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379399));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378699));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376153);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363812));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378702));
    paramContext = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getAssets(), "fonts/DS-DIGIB.TTF");
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_c_of_type_Int = AIOUtils.b(70.0F, getResources());
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368625));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368626));
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131298286);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131373140);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow = ((ProgressViewYellow)findViewById(2131373132));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView = ((ImageAlphaSwitchView)findViewById(2131373149));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setGravity(17);
    this.g = ((ImageView)findViewById(2131373150));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = ((ImageSwitchAnimView)findViewById(2131373146));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131373147);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131377675);
    this.h = ((ImageView)findViewById(2131377676));
    this.i = ((ImageView)findViewById(2131377677));
    int j = ViewUtils.a();
    int k = (int)(ViewUtils.a() * 406.0F / 750.0F);
    this.jdField_b_of_type_Int = AIOUtils.b(40.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView = new ImageShakeAnimView(this.jdField_a_of_type_AndroidContentContext, j, k, 0, 0, Integer.valueOf(2130845406), false);
    paramContext = new RelativeLayout.LayoutParams(j, k);
    paramContext.addRule(14);
    paramContext.topMargin = (-this.jdField_b_of_type_Int);
    addView(this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView, 0, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView = new FlakeView(this.jdField_a_of_type_AndroidContentContext, false);
    addView(this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView, 0, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
  }
  
  private void b(String paramString)
  {
    boolean bool = FileUtils.fileExists(paramString);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doCowJumpAnimation exist = ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(",apngFilePath = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FormalView", 2, ((StringBuilder)localObject).toString());
    }
    if (!bool) {
      return;
    }
    Object localObject = new ApngOptions();
    ((ApngOptions)localObject).a(URLDrawableHelperConstants.a);
    ((ApngOptions)localObject).a(1);
    paramString = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", (ApngOptions)localObject, paramString);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
  
  private void h()
  {
    int j;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
      j = 0;
    }
    try
    {
      while (j < jdField_a_of_type_ArrayOfInt.length)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(getResources().getDrawable(jdField_a_of_type_ArrayOfInt[j]), 30);
        j += 1;
      }
    }
    catch (Throwable localThrowable)
    {
      label56:
      break label56;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a();
    b(false);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long <= 500L)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("combo, no network last time = ");
        paramString.append(this.jdField_a_of_type_Long);
        QLog.d("FormalView", 2, paramString.toString());
      }
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    b(false);
    if (l - this.jdField_b_of_type_Long > 600L)
    {
      this.jdField_b_of_type_Long = l;
      this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.a();
    }
    if (System.currentTimeMillis() - this.jdField_c_of_type_Long < 500L) {
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
      localObject1 = new AlphaAnimation(0.0F, 1.0F);
      localObject2 = new ScaleAnimation(2.4F, 1.0F, 2.4F, 1.0F, 1, 0.5F, 1, 0.5F);
      localObject3 = new OvershootInterpolator(1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator((Interpolator)localObject3);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject1);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation((Animation)localObject2);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.reset();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_c_of_type_JavaUtilList.contains(Integer.valueOf(paramInt)))
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = (PortalManager.ComboNumber)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localObject1 == null)
      {
        this.jdField_c_of_type_Boolean = false;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("combo, get CN from map return null, combo=");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("FormalView", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        Object localObject4;
        if (!TextUtils.isEmpty(((PortalManager.ComboNumber)localObject1).numberImageMD5))
        {
          localObject2 = PortalManager.a(((PortalManager.ComboNumber)localObject1).numberImageMD5, null);
          if (localObject2 == null)
          {
            this.jdField_c_of_type_Boolean = false;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("combo, get bmp from PM return null, combo=");
            ((StringBuilder)localObject2).append(paramInt);
            QLog.d("FormalView", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getFilesDir());
          ((StringBuilder)localObject2).append(PortalManager.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject2).append(((PortalManager.ComboNumber)localObject1).flowerImageMD5);
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(BaseApplicationImpl.getApplication().getFilesDir());
          ((StringBuilder)localObject3).append(PortalManager.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject3).append(((PortalManager.ComboNumber)localObject1).flowerImage2MD5);
          localObject3 = ((StringBuilder)localObject3).toString();
          this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a(30, new String[] { localObject2, localObject3 });
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView;
          if (localObject4 != null)
          {
            ((HongbaoCaidanRainView)localObject4).a(new String[] { localObject2, localObject3 });
            this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.setShowFullScreenCaidan(l, 2000L);
          }
          localObject2 = (PortalManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(QQManagerFactory.MGR_PORTAL);
          if (localObject2 != null) {
            ((PortalManager)localObject2).a(3);
          }
          localObject2 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((PortalManager.ComboNumber)localObject1).number);
          ((StringBuilder)localObject3).append("");
          ReportController.b((AppRuntime)localObject2, "dc01440", "", "", "0X80078A9", "0X80078A9", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
        }
        else
        {
          localObject2 = (SpringFestivalEntryManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          localObject3 = ((SpringFestivalEntryManager)localObject2).a().commonData.comboResUrl;
          localObject4 = ((SpringFestivalEntryManager)localObject2).a((String)localObject3, ((PortalManager.ComboNumber)localObject1).getNumberImageFileName(), "");
          if (localObject4 == null)
          {
            this.jdField_c_of_type_Boolean = false;
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("combo, get bmp from PM return null, combo=");
            ((StringBuilder)localObject5).append(paramInt);
            QLog.d("FormalView", 1, ((StringBuilder)localObject5).toString());
          }
          else
          {
            this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject4);
          }
          Object localObject5 = ((SpringFestivalEntryManager)localObject2).a((String)localObject3, ((PortalManager.ComboNumber)localObject1).getFlowerImage1FileName(), "");
          Bitmap localBitmap = ((SpringFestivalEntryManager)localObject2).a((String)localObject3, ((PortalManager.ComboNumber)localObject1).getFlowerImage2FileName(), "");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("combo bitmap = ");
            localStringBuilder.append(localObject4);
            localStringBuilder.append(",flower1bitmap = ");
            localStringBuilder.append(localObject5);
            localStringBuilder.append(",flower2bitmap = ");
            localStringBuilder.append(localBitmap);
            QLog.d("FormalView", 2, localStringBuilder.toString());
          }
          if ((localObject5 != null) && (localBitmap != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a(30, new Bitmap[] { localObject5, localBitmap });
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView;
            if (localObject4 != null)
            {
              ((HongbaoCaidanRainView)localObject4).a(new Bitmap[] { localObject5, localBitmap });
              this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.setShowFullScreenCaidan(l, 2000L);
            }
          }
          if (localObject2 != null) {
            ((SpringFestivalEntryManager)localObject2).a(3);
          }
          localObject4 = ((PortalManager.ComboNumber)localObject1).getCowJumpAnimFileName();
          localObject2 = ((SpringFestivalEntryManager)localObject2).a((String)localObject3);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append((String)localObject4);
          b(((StringBuilder)localObject3).toString());
          localObject2 = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((PortalManager.ComboNumber)localObject1).number);
          ((StringBuilder)localObject3).append("");
          ReportController.b((AppRuntime)localObject2, "dc01440", "", "", "0X80078A9", "0X80078A9", 0, 0, ((StringBuilder)localObject3).toString(), "", "", "");
        }
      }
    }
    l = 2000L;
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (paramInt == 1)
      {
        this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setText(HardCodeUtil.a(2131704818));
      }
      else if (paramInt < 10)
      {
        localObject1 = this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131704814));
        ((StrokeTextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject1 = this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("x");
        ((StringBuilder)localObject2).append(paramInt);
        ((StrokeTextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
    }
    else
    {
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    paramString = this.jdField_a_of_type_AndroidOsHandler;
    if (!this.jdField_c_of_type_Boolean) {
      l = 800L;
    }
    paramString.sendEmptyMessageDelayed(1, l);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow.a(paramLong1, paramLong2);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    String str = paramCharSequence.toString();
    if (!this.jdField_a_of_type_JavaLangString.equals(str))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_a_of_type_JavaLangString = str;
    }
    int j = getResources().getDisplayMetrics().widthPixels;
    int k = AIOUtils.b(81.0F, getResources());
    paramCharSequence = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    paramCharSequence.leftMargin = ((int)((j - k) * (paramLong2 - paramLong1) / paramLong2));
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramCharSequence);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    Object localObject = paramViewGroup;
    ViewGroup localViewGroup;
    do
    {
      if (((ViewGroup)localObject).getId() == 2131365172)
      {
        paramViewGroup = (ViewGroup)localObject;
        break;
      }
      if (((ViewGroup)localObject).getId() == 16908306) {
        break;
      }
      if (((ViewGroup)localObject).getParent() != null) {
        localViewGroup = (ViewGroup)((ViewGroup)localObject).getParent();
      } else {
        localViewGroup = null;
      }
      localObject = localViewGroup;
    } while (localViewGroup != null);
    localObject = paramViewGroup.findViewById(2131374248);
    if (localObject != null) {
      paramViewGroup.removeView((View)localObject);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showResult, msg=");
      localStringBuilder.append(paramString);
      QLog.d("FormalView", 2, localStringBuilder.toString());
    }
    if ((!PortalConstants.jdField_a_of_type_JavaLangString.equals(paramString)) && (System.currentTimeMillis() - this.jdField_c_of_type_Long < 500L)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    if (PortalConstants.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setTextSize(1, 21.0F);
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString);
    }
    this.jdField_b_of_type_Boolean = false;
    b(false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    e();
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView = new HongbaoCaidanRainView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setId(2131374248);
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.a(getResources().getDisplayMetrics().widthPixels, AIOUtils.b(40.0F, getResources()), 0.5F, 150.0F, AIOUtils.b(250.0F, getResources()), AIOUtils.b(3.0F, getResources()), AIOUtils.b(150.0F, getResources()), getResources().getDisplayMetrics().heightPixels);
    }
    Object localObject = paramViewGroup;
    ViewGroup localViewGroup;
    do
    {
      if (((ViewGroup)localObject).getId() == 2131365172)
      {
        paramViewGroup = (ViewGroup)localObject;
        break;
      }
      if (((ViewGroup)localObject).getId() == 16908306) {
        break;
      }
      if (((ViewGroup)localObject).getParent() != null) {
        localViewGroup = (ViewGroup)((ViewGroup)localObject).getParent();
      } else {
        localViewGroup = null;
      }
      localObject = localViewGroup;
    } while (localViewGroup != null);
    localObject = paramViewGroup.findViewById(2131374248);
    if (localObject != null) {
      paramViewGroup.removeView((View)localObject);
    }
    paramViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView, new RelativeLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels));
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readyGo, show=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("FormalView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = findViewById(2131368251);
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidViewAnimationAnimationSet == null)
      {
        AnimationSet localAnimationSet = new AnimationSet(true);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        ScaleAnimation localScaleAnimation = new ScaleAnimation(1.8F, 1.0F, 1.85F, 1.0F, 1, 0.5F, 1, 0.5F);
        localAnimationSet.setInterpolator(new OvershootInterpolator(1.0F));
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.setDuration(400L);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setAnimationListener(new FormalView.1(this, (View)localObject));
        this.jdField_b_of_type_AndroidViewAnimationAnimationSet = localAnimationSet;
      }
      ((View)localObject).startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimationSet);
      return;
    }
    ((View)localObject).clearAnimation();
    ((View)localObject).setVisibility(8);
    localObject = this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView;
    if (localObject != null) {
      ((StrokeTextView)localObject).setVisibility(8);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.b();
  }
  
  @TargetApi(11)
  public void d()
  {
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new FormalView.2(this));
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(new FormalView.3(this));
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.getLayoutParams()).topMargin = (-this.jdField_b_of_type_Int);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = this.jdField_d_of_type_Int;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = true;
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.getLayoutParams()).topMargin = 0;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.leftMargin = (-this.jdField_c_of_type_Int);
    this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.rightMargin = (-this.jdField_c_of_type_Int);
    this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = 0;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void g()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator;
    if (localValueAnimator != null) {
      try
      {
        if (localValueAnimator.isRunning()) {
          this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
        }
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = null;
        return;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          localThrowable.printStackTrace();
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.jdField_b_of_type_Boolean)) {
      h();
    }
    return false;
  }
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap2 != null)
    {
      paramBitmap1 = getBackground();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap2)) {
        return;
      }
      super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap2));
      return;
    }
    super.setBackgroundResource(2130845289);
  }
  
  public void setCloudBmp(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 != null) && (paramBitmap2 != null))
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap1);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap2);
      return;
    }
    QLog.d("PortalManager", 1, "FormalView setCloudBmp, left or right is null");
    this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845283);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130845284);
  }
  
  public void setComboNumberList(List<PortalManager.ComboNumber> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Collections.sort(paramList, new FormalView.ComboCompare(null));
      int j = 0;
      while (j < paramList.size())
      {
        PortalManager.ComboNumber localComboNumber = (PortalManager.ComboNumber)paramList.get(j);
        if (localComboNumber != null)
        {
          this.jdField_c_of_type_JavaUtilList.add(Integer.valueOf(localComboNumber.number));
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(localComboNumber.number), localComboNumber);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setComboNumberList, index=");
            localStringBuilder.append(j);
            localStringBuilder.append(", p=");
            localStringBuilder.append(localComboNumber.toString());
            QLog.d("FormalView", 2, localStringBuilder.toString());
          }
        }
        j += 1;
      }
      ThreadManager.postImmediately(new FormalView.4(this, paramList), null, true);
    }
  }
  
  public void setHBSpeed(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.setHonhBaoSpeed(paramInt);
  }
  
  public void setLogoConfigList(List<PortalManager.LogoConfig> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((paramList != null) && (QLog.isColorLevel()))
    {
      int j = 0;
      while (j < paramList.size())
      {
        PortalManager.LogoConfig localLogoConfig = (PortalManager.LogoConfig)paramList.get(j);
        if (localLogoConfig != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setLogoConfigList, index=");
          localStringBuilder.append(j);
          localStringBuilder.append(", p=");
          localStringBuilder.append(localLogoConfig.toString());
          QLog.d("FormalView", 2, localStringBuilder.toString());
        }
        j += 1;
      }
    }
  }
  
  public void setProgressLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setProgressLogo, bmp=");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append(", needSwitch=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("FormalView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBitmap != null)
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(paramBitmap);
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.a(paramBitmap);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(paramBitmap);
      return;
    }
    int j = this.jdField_a_of_type_Int;
    Object localObject = null;
    if (j == 1) {
      paramBitmap = getResources().getDrawable(2130845455);
    } else if ((j != 2) && (j != 3)) {
      paramBitmap = null;
    } else {
      paramBitmap = getResources().getDrawable(2130845277);
    }
    if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
      localObject = ((SkinnableBitmapDrawable)paramBitmap).getBitmap();
    } else if ((paramBitmap instanceof BitmapDrawable)) {
      localObject = ((BitmapDrawable)paramBitmap).getBitmap();
    }
    if (localObject != null)
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo((Bitmap)localObject);
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.a((Bitmap)localObject);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo((Bitmap)localObject);
    }
  }
  
  public void setProgressNameBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setProgressNameBitmap, name=");
      localStringBuilder.append(paramBitmap1);
      localStringBuilder.append(", bg=");
      localStringBuilder.append(paramBitmap2);
      localStringBuilder.append(", needSwitch=");
      localStringBuilder.append(paramBoolean);
      QLog.d("FormalView", 2, localStringBuilder.toString());
    }
    if (paramBitmap1 == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.a(paramBitmap1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setImage(paramBitmap1);
  }
  
  public void setSmallIcon(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSmallIcon, icon=");
      localStringBuilder.append(paramBitmap1);
      localStringBuilder.append(", name=");
      localStringBuilder.append(paramBitmap2);
      localStringBuilder.append(", mode=");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("FormalView", 2, localStringBuilder.toString());
    }
    this.i.setImageBitmap(paramBitmap2);
    this.h.setImageBitmap(paramBitmap1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FormalView
 * JD-Core Version:    0.7.0.1
 */