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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormalView
  extends RelativeLayout
  implements Handler.Callback
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130845454, 2130845455, 2130845456, 2130845457, 2130845458, 2130845459, 2130845460, 2130845461, 2130845462, 2130845463, 2130845464, 2130845465, 2130845466, 2130845467, 2130845468, 2130845469, 2130845470, 2130845471, 2130845472, 2130845473, 2130845474, 2130845475, 2130845476, 2130845477, 2130845478, 2130845479, 2130845480, 2130845481, 2130845482, 2130845483, 2130845484, 2130845485, 2130845486, 2130845487, 2130845488, 2130845489, 2130845490 };
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
    LayoutInflater.from(paramContext).inflate(2131561267, this, true);
    paramContext = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getAssets(), "fonts/HuNan-CC.ttf");
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131365006));
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(paramContext);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6347776);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(-1);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.a(4.0F, getResources()));
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setShadow(AIOUtils.a(2.0F, getResources()), 0.0F, AIOUtils.a(1.0F, getResources()), 1073741824);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363761));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131368503));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(paramContext);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6347776);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(-1);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.a(4.0F, getResources()));
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_e_of_type_ComTencentMobileqqPortalStrokeTextView.setShadowLayer(AIOUtils.a(2.0F, getResources()), 0.0F, AIOUtils.a(1.0F, getResources()), 1711276032);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131368496));
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6347776);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setShadow(AIOUtils.a(4.0F, getResources()), 0.0F, 0.0F, -135991);
    this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131376648));
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(-6347776);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(false);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setShadow(AIOUtils.a(4.0F, getResources()), 0.0F, 0.0F, -135991);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setText(HardCodeUtil.a(2131704741));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131368501));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(Color.parseColor("#9F2400"));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(Color.parseColor("#FBEACD"));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.a(2.0F, getResources()));
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setTextSize(1, 24.0F);
    this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368493));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368494));
    paramContext = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    paramContext.height = ((int)(ViewUtils.a() * 736.0F / 750.0F));
    paramContext.topMargin = ViewUtils.b(203.0F);
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(paramContext);
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView = ((StrokeTextView)findViewById(2131372253));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setInnerTextColor(Color.parseColor("#9F2400"));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeColor(Color.parseColor("#FBEACD"));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeSize(AIOUtils.a(2.0F, getResources()));
    this.jdField_c_of_type_ComTencentMobileqqPortalStrokeTextView.setStrokeEnable(true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380070));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379349));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131376649);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363884));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379352));
    paramContext = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getAssets(), "fonts/DS-DIGIB.TTF");
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_c_of_type_Int = AIOUtils.a(70.0F, getResources());
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368899));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368900));
    this.jdField_d_of_type_Int = getResources().getDimensionPixelSize(2131298291);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131373561);
    this.jdField_a_of_type_ComTencentMobileqqPortalProgressViewYellow = ((ProgressViewYellow)findViewById(2131373554));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView = ((ImageAlphaSwitchView)findViewById(2131373569));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setGravity(17);
    this.g = ((ImageView)findViewById(2131373570));
    this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = ((ImageSwitchAnimView)findViewById(2131373566));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131373567);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131378263);
    this.h = ((ImageView)findViewById(2131378264));
    this.i = ((ImageView)findViewById(2131378265));
    int j = ViewUtils.a();
    int k = (int)(ViewUtils.a() * 406.0F / 750.0F);
    this.jdField_b_of_type_Int = AIOUtils.a(40.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView = new ImageShakeAnimView(this.jdField_a_of_type_AndroidContentContext, j, k, 0, 0, Integer.valueOf(2130845533), false);
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
    boolean bool = FileUtils.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "doCowJumpAnimation exist = " + bool + ",apngFilePath = " + paramString);
    }
    if (!bool) {
      return;
    }
    VasApngFactory.Options localOptions = new VasApngFactory.Options();
    localOptions.a(URLDrawableHelper.TRANSPARENT);
    localOptions.a(1);
    paramString = VasApngFactory.a("", localOptions, paramString);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = new AnimationDrawable();
      int j = 0;
      try
      {
        while (j < jdField_a_of_type_ArrayOfInt.length)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.addFrame(getResources().getDrawable(jdField_a_of_type_ArrayOfInt[j]), 30);
          j += 1;
        }
        this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
      }
      catch (Throwable localThrowable)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.setOneShot(false);
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
      }
    }
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
    if (l - this.jdField_a_of_type_Long <= 500L) {
      if (QLog.isColorLevel()) {
        QLog.d("FormalView", 2, "combo, no network last time = " + this.jdField_a_of_type_Long);
      }
    }
    do
    {
      return;
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
    } while (System.currentTimeMillis() - this.jdField_c_of_type_Long < 500L);
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
        QLog.d("FormalView", 1, "combo, get CN from map return null, combo=" + paramInt);
      }
    }
    else
    {
      if (this.jdField_c_of_type_Boolean) {
        break label1247;
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      if (paramInt != 1) {
        break label1178;
      }
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setText(HardCodeUtil.a(2131704742));
      label436:
      this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      label454:
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      if (!this.jdField_c_of_type_Boolean) {
        break label1301;
      }
    }
    label1301:
    for (l = 2000L;; l = 800L)
    {
      paramString.sendEmptyMessageDelayed(1, l);
      this.jdField_b_of_type_Boolean = true;
      return;
      if (!TextUtils.isEmpty(((PortalManager.ComboNumber)localObject1).numberImageMD5))
      {
        localObject2 = PortalManager.a(((PortalManager.ComboNumber)localObject1).numberImageMD5, null);
        if (localObject2 == null)
        {
          this.jdField_c_of_type_Boolean = false;
          QLog.d("FormalView", 1, "combo, get bmp from PM return null, combo=" + paramInt);
        }
        for (;;)
        {
          localObject2 = BaseApplicationImpl.getApplication().getFilesDir() + PortalManager.jdField_a_of_type_JavaLangString + ((PortalManager.ComboNumber)localObject1).flowerImageMD5;
          localObject3 = BaseApplicationImpl.getApplication().getFilesDir() + PortalManager.jdField_a_of_type_JavaLangString + ((PortalManager.ComboNumber)localObject1).flowerImage2MD5;
          this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a(30, new String[] { localObject2, localObject3 });
          if (this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.a(new String[] { localObject2, localObject3 });
            this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.setShowFullScreenCaidan(l, 2000L);
          }
          localObject2 = (PortalManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(QQManagerFactory.MGR_PORTAL);
          if (localObject2 != null) {
            ((PortalManager)localObject2).a(3);
          }
          ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc01440", "", "", "0X80078A9", "0X80078A9", 0, 0, ((PortalManager.ComboNumber)localObject1).number + "", "", "", "");
          break;
          this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        }
      }
      localObject2 = (SpringFestivalEntryManager)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      localObject3 = ((SpringFestivalEntryManager)localObject2).a().commonData.comboResUrl;
      Object localObject4 = ((SpringFestivalEntryManager)localObject2).a((String)localObject3, ((PortalManager.ComboNumber)localObject1).getNumberImageFileName(), "");
      if (localObject4 == null)
      {
        this.jdField_c_of_type_Boolean = false;
        QLog.d("FormalView", 1, "combo, get bmp from PM return null, combo=" + paramInt);
      }
      for (;;)
      {
        Bitmap localBitmap1 = ((SpringFestivalEntryManager)localObject2).a((String)localObject3, ((PortalManager.ComboNumber)localObject1).getFlowerImage1FileName(), "");
        Bitmap localBitmap2 = ((SpringFestivalEntryManager)localObject2).a((String)localObject3, ((PortalManager.ComboNumber)localObject1).getFlowerImage2FileName(), "");
        if (QLog.isColorLevel()) {
          QLog.d("FormalView", 2, "combo bitmap = " + localObject4 + ",flower1bitmap = " + localBitmap1 + ",flower2bitmap = " + localBitmap2);
        }
        if ((localBitmap1 != null) && (localBitmap2 != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a(30, new Bitmap[] { localBitmap1, localBitmap2 });
          if (this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.a(new Bitmap[] { localBitmap1, localBitmap2 });
            this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.setShowFullScreenCaidan(l, 2000L);
          }
        }
        if (localObject2 != null) {
          ((SpringFestivalEntryManager)localObject2).a(3);
        }
        localObject4 = ((PortalManager.ComboNumber)localObject1).getCowJumpAnimFileName();
        localObject2 = ((SpringFestivalEntryManager)localObject2).a((String)localObject3);
        b((String)localObject2 + File.separator + (String)localObject4);
        ReportController.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc01440", "", "", "0X80078A9", "0X80078A9", 0, 0, ((PortalManager.ComboNumber)localObject1).number + "", "", "", "");
        break;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject4);
      }
      label1178:
      if (paramInt < 10)
      {
        this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramInt + HardCodeUtil.a(2131704738));
        break label436;
      }
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setText("x" + paramInt);
      break label436;
      label1247:
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_ComTencentMobileqqPortalStrokeTextView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      break label454;
    }
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
    int k = AIOUtils.a(81.0F, getResources());
    paramCharSequence = (ViewGroup.MarginLayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    paramCharSequence.leftMargin = ((int)((j - k) * (paramLong2 - paramLong1) / paramLong2));
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramCharSequence);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    Object localObject1 = paramViewGroup;
    if (((ViewGroup)localObject1).getId() == 2131365297) {
      localObject2 = localObject1;
    }
    label14:
    do
    {
      paramViewGroup = ((ViewGroup)localObject2).findViewById(2131374710);
      if (paramViewGroup != null) {
        ((ViewGroup)localObject2).removeView(paramViewGroup);
      }
      return;
      localObject2 = paramViewGroup;
    } while (((ViewGroup)localObject1).getId() == 16908306);
    if (((ViewGroup)localObject1).getParent() != null) {}
    for (Object localObject2 = (ViewGroup)((ViewGroup)localObject1).getParent();; localObject2 = null)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject2 = paramViewGroup;
      break label14;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "showResult, msg=" + paramString);
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
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      b(false);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqPortalStrokeTextView.setText(paramString);
    }
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
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setId(2131374710);
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.a(getResources().getDisplayMetrics().widthPixels, AIOUtils.a(40.0F, getResources()), 0.5F, 150.0F, AIOUtils.a(250.0F, getResources()), AIOUtils.a(3.0F, getResources()), AIOUtils.a(150.0F, getResources()), getResources().getDisplayMetrics().heightPixels);
    }
    Object localObject1 = paramViewGroup;
    if (((ViewGroup)localObject1).getId() == 2131365297) {
      localObject2 = localObject1;
    }
    label130:
    do
    {
      paramViewGroup = ((ViewGroup)localObject2).findViewById(2131374710);
      if (paramViewGroup != null) {
        ((ViewGroup)localObject2).removeView(paramViewGroup);
      }
      ((ViewGroup)localObject2).addView(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView, new RelativeLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels));
      return;
      localObject2 = paramViewGroup;
    } while (((ViewGroup)localObject1).getId() == 16908306);
    if (((ViewGroup)localObject1).getParent() != null) {}
    for (Object localObject2 = (ViewGroup)((ViewGroup)localObject1).getParent();; localObject2 = null)
    {
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject2 = paramViewGroup;
      break label130;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (QLog.isColorLevel())) {
      QLog.d("FormalView", 2, "readyGo, show=" + paramBoolean);
    }
    View localView = findViewById(2131368503);
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
        localAnimationSet.setAnimationListener(new FormalView.1(this, localView));
        this.jdField_b_of_type_AndroidViewAnimationAnimationSet = localAnimationSet;
      }
      localView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimationSet);
    }
    do
    {
      return;
      localView.clearAnimation();
      localView.setVisibility(8);
    } while (this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView == null);
    this.jdField_f_of_type_ComTencentMobileqqPortalStrokeTextView.setVisibility(8);
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
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) {}
    try
    {
      if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) {
        this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      localThrowable.printStackTrace();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_b_of_type_Boolean) {
        h();
      }
    }
  }
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 != null))
    {
      paramBitmap1 = getBackground();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap2)) {
        return;
      }
      super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap2));
      return;
    }
    super.setBackgroundResource(2130845416);
  }
  
  public void setCloudBmp(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if ((paramBitmap1 == null) || (paramBitmap2 == null))
    {
      QLog.d("PortalManager", 1, "FormalView setCloudBmp, left or right is null");
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845410);
      this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130845411);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap1);
    this.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap2);
  }
  
  public void setComboNumberList(List<PortalManager.ComboNumber> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
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
        if (QLog.isColorLevel()) {
          QLog.d("FormalView", 2, "setComboNumberList, index=" + j + ", p=" + localComboNumber.toString());
        }
      }
      j += 1;
    }
    ThreadManager.postImmediately(new FormalView.4(this, paramList), null, true);
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
        if (localLogoConfig != null) {
          QLog.d("FormalView", 2, "setLogoConfigList, index=" + j + ", p=" + localLogoConfig.toString());
        }
        j += 1;
      }
    }
  }
  
  public void setProgressLogo(Bitmap paramBitmap, boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "setProgressLogo, bmp=" + paramBitmap + ", needSwitch=" + paramBoolean);
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
    if (this.jdField_a_of_type_Int == 1) {
      paramBitmap = getResources().getDrawable(2130845582);
    }
    for (;;)
    {
      if ((paramBitmap instanceof SkinnableBitmapDrawable)) {
        localBitmap = ((SkinnableBitmapDrawable)paramBitmap).getBitmap();
      }
      for (;;)
      {
        if (localBitmap == null) {
          break label189;
        }
        if (this.jdField_a_of_type_Int != 1) {
          break label191;
        }
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(localBitmap);
        return;
        if ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) {
          break label213;
        }
        paramBitmap = getResources().getDrawable(2130845404);
        break;
        if ((paramBitmap instanceof BitmapDrawable)) {
          localBitmap = ((BitmapDrawable)paramBitmap).getBitmap();
        }
      }
      label189:
      break;
      label191:
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.a(localBitmap);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(localBitmap);
      return;
      label213:
      paramBitmap = null;
    }
  }
  
  public void setProgressNameBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "setProgressNameBitmap, name=" + paramBitmap1 + ", bg=" + paramBitmap2 + ", needSwitch=" + paramBoolean);
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
    if (QLog.isColorLevel()) {
      QLog.d("FormalView", 2, "setSmallIcon, icon=" + paramBitmap1 + ", name=" + paramBitmap2 + ", mode=" + this.jdField_a_of_type_Int);
    }
    this.i.setImageBitmap(paramBitmap2);
    this.h.setImageBitmap(paramBitmap1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.FormalView
 * JD-Core Version:    0.7.0.1
 */