package com.tencent.mobileqq.magicface.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MagicfaceViewController
  implements View.OnClickListener
{
  public static boolean a = false;
  protected Handler a;
  protected View a;
  protected WindowManager a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  protected BaseChatPie a;
  Emoticon jdField_a_of_type_ComTencentMobileqqDataEmoticon;
  protected ActionGlobalData a;
  public MagicfaceActionManager a;
  protected IMagicFaceView a;
  protected MagicfaceContainerView a;
  protected OnMagicPlayEnd a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  protected String a;
  protected View b;
  protected Button b;
  protected TextView b;
  protected IMagicFaceView b;
  protected MagicfaceContainerView b;
  protected boolean b;
  protected Button c;
  protected TextView c;
  protected Button d;
  protected TextView d;
  protected Button e;
  protected Button f;
  
  static
  {
    String str = DeviceInfoUtil.g();
    Object localObject;
    if (str != null)
    {
      localObject = str.toLowerCase();
      if ((!((String)localObject).contains("marvell")) && (!((String)localObject).contains("armv5")) && (!((String)localObject).contains("armv6"))) {
        jdField_a_of_type_Boolean = true;
      } else {
        jdField_a_of_type_Boolean = false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cpuType=");
      ((StringBuilder)localObject).append(str);
      QLog.i("MagicfaceViewController", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public MagicfaceViewController(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
    if (QLog.isColorLevel())
    {
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append("func MagicfaceViewController[Constructor] ends.isUseHardDecode:");
      paramBaseChatPie.append(this.jdField_b_of_type_Boolean);
      QLog.d("MagicfaceViewController", 2, paramBaseChatPie.toString());
    }
  }
  
  public static boolean a()
  {
    if ((((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.magicface_support.name())) && (jdField_a_of_type_Boolean) && (DecoderUtil.IS_LOAD_SUCESS))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "is_support_magic:TRUE");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "is_support_magic:FALSE");
    }
    return false;
  }
  
  public void a()
  {
    if (!DeviceInfoUtil.d())
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if (Math.min(DeviceInfoUtil.g(), DeviceInfoUtil.h()) >= 720L)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (Build.VERSION.SDK_INT < 26) {
      localLayoutParams.type = 2002;
    } else {
      localLayoutParams.type = 2038;
    }
    localLayoutParams.flags = 40;
    localLayoutParams.gravity = 51;
    localLayoutParams.x = 0;
    localLayoutParams.y = paramInt;
    localLayoutParams.width = -1;
    localLayoutParams.height = -2;
    localLayoutParams.format = 1;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window"));
    if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
      }
      catch (Exception localException2)
      {
        QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException2);
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
    }
    catch (Exception localException1)
    {
      QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException1);
    }
  }
  
  public void a(Emoticon paramEmoticon)
  {
    this.jdField_d_of_type_AndroidWidgetButton.setTag(paramEmoticon);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if ((localAIOAnimationControlManager != null) && (localAIOAnimationControlManager.a != 1)) {
      localAIOAnimationControlManager.e();
    }
    a(paramEmoticon, paramInt, paramString, 1);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("func playMaigcface, magicValue:");
      ((StringBuilder)localObject1).append(paramEmoticon.magicValue);
      QLog.d("MagicfaceViewController", 2, ((StringBuilder)localObject1).toString());
    }
    long l = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 1.");
      }
      paramEmoticon = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd;
      if (paramEmoticon != null)
      {
        paramEmoticon.onPlayEnd();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd = null;
      }
      return;
    }
    localObject1 = this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 2.");
      }
      paramEmoticon = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd;
      if (paramEmoticon != null)
      {
        paramEmoticon.onPlayEnd();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd = null;
      }
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
    if ((localObject1 != null) && (((MagicfaceActionManager)localObject1).a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 3.");
      }
      paramEmoticon = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd;
      if (paramEmoticon != null)
      {
        paramEmoticon.onPlayEnd();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd = null;
      }
      return;
    }
    if (paramInt1 == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = MagicfaceActionManager.a(paramEmoticon, paramInt1, paramInt2);
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 4.");
        }
        paramEmoticon = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd;
        if (paramEmoticon != null)
        {
          paramEmoticon.onPlayEnd();
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd = null;
        }
        return;
      }
    }
    this.jdField_a_of_type_JavaLangString = paramEmoticon.epId;
    b();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager = new MagicfaceActionManager(this);
    Object localObject2;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 5.");
      }
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      localObject3 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject3).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject3).addView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 6.");
      }
      localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      a(0);
      ((ViewGroup)localObject1).addView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.updateViewLayout((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceViewController.5(this));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setIsFullScreen(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
      localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    ((View)localObject1).setVisibility(0);
    Object localObject3 = (SurfaceView)localObject1;
    ((SurfaceView)localObject3).setZOrderOnTop(true);
    ((SurfaceView)localObject3).getHolder().setFormat(-2);
    localObject3 = new MagicfacePlayManager();
    ((MagicfacePlayManager)localObject3).a((MagicfaceDecoder.MagicfaceRenderListener)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a((MagicfacePlayManager)localObject3);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(new MagicfaceViewController.6(this, paramInt1, (TextView)localObject2));
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(new MagicfaceViewController.7(this, l, paramInt1));
    if (((IMagicFaceView)localObject1).a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 7.");
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(paramEmoticon, paramInt1, paramString, paramInt2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 8.");
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MagicfaceViewController.8(this), 200L);
    ((IMagicFaceView)localObject1).setSurfaceCreatelistener(new MagicfaceViewController.9(this, paramEmoticon, paramInt1, paramString, paramInt2));
  }
  
  public void a(Emoticon paramEmoticon, OnMagicPlayEnd paramOnMagicPlayEnd)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func magicfaceAutoPlay, magicValue:");
      localStringBuilder.append(paramEmoticon.magicValue);
      QLog.d("MagicfaceViewController", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd = paramOnMagicPlayEnd;
    if (!a())
    {
      paramEmoticon = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd;
      if (paramEmoticon != null)
      {
        paramEmoticon.onPlayEnd();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay ends, not support.");
      }
      return;
    }
    paramOnMagicPlayEnd = new Emoticon();
    paramOnMagicPlayEnd.eId = paramEmoticon.eId;
    paramOnMagicPlayEnd.epId = paramEmoticon.epId;
    paramOnMagicPlayEnd.magicValue = paramEmoticon.magicValue;
    paramOnMagicPlayEnd.jobType = paramEmoticon.jobType;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramOnMagicPlayEnd;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new MagicfaceViewController.3(this);
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "initMagicfaceView begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.N();
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "initMagicfaceView=======qvip_magicface_send");
      }
      if (this.jdField_b_of_type_Boolean) {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131561936, null);
      } else {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131561938, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView = ((IMagicFaceView)localView.findViewById(2131370605));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131370606));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370619));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370607));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131370616));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131370604));
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131370617));
      this.e = ((Button)localView.findViewById(2131370618));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.e.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (this.jdField_b_of_type_Boolean) {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131561935, null);
      } else {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131561937, null);
      }
      this.jdField_a_of_type_AndroidViewView = View.inflate(BaseApplicationImpl.getContext(), 2131561939, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370615);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView = ((IMagicFaceView)localView.findViewById(2131370608));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131370610));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370614));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370612));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131370609));
      this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131370611));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370613));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.f.setOnClickListener(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "initMagicfaceView ends");
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null) && ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8) || (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.getVisibility() != 8)))
    {
      g();
      return true;
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b())
    {
      this.e.setBackgroundResource(2130847416);
      return;
    }
    this.e.setBackgroundResource(2130847415);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c())
    {
      this.f.setBackgroundResource(2130847365);
      return;
    }
    this.f.setBackgroundResource(2130847413);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceViewController.2(this));
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_AndroidWidgetButton.getTag() == null) {
      return;
    }
    Emoticon localEmoticon = (Emoticon)this.jdField_d_of_type_AndroidWidgetButton.getTag();
    if (localEmoticon.jobType == 2)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      if ((localObject != null) && (((MagicfaceActionManager)localObject).a() >= 0)) {
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a() == 0)
        {
          localEmoticon.magicValue = "value=1";
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("value=");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a());
          localEmoticon.magicValue = ((StringBuilder)localObject).toString();
        }
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), localEmoticon);
      g();
      a(localEmoticon, null);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setSurfaceCreatelistener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(null);
      ((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView.setSurfaceCreatelistener(null);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "removeView=======DecorView");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
      ((ViewGroup)localObject).removeView(this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidViewWindowManager != null) {
          this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label160:
      break label160;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      ((MagicfaceActionManager)localObject).a(new MagicfaceViewController.4(this, (MagicfaceActionManager)localObject));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.h();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd;
    if (localObject != null)
    {
      ((OnMagicPlayEnd)localObject).onPlayEnd();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewOnMagicPlayEnd = null;
    }
  }
  
  public void h()
  {
    g();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
      if (localRunnable != null) {
        localHandler.removeCallbacks(localRunnable);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131370618: 
      bool = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(bool ^ true);
      c();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c(bool ^ true);
      if (!bool) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbKaiqiShengxiao", 0, 0, "", "", "", "");
      }
      break;
    case 2131370617: 
      f();
      break;
    case 2131370616: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbChongzuo", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      MagicfaceActionManager localMagicfaceActionManager = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      if (localMagicfaceActionManager != null)
      {
        localMagicfaceActionManager.f();
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MagicfaceViewController.1(this), 300L);
      }
      break;
    case 2131370611: 
      bool = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b(bool ^ true);
      d();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c(bool ^ true);
      if (!bool) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "MbJieshou", "MbKaiqiShengxiao2", 0, 0, "", "", "", "");
      }
      break;
    case 2131370609: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      g();
      break;
    case 2131370604: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController
 * JD-Core Version:    0.7.0.1
 */