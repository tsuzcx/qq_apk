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
  public static boolean a;
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
  protected MagicfaceViewController.OnMagicPlayEnd a;
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
    jdField_a_of_type_Boolean = false;
    String str1 = DeviceInfoUtil.g();
    if (str1 != null)
    {
      String str2 = str1.toLowerCase();
      if ((!str2.contains("marvell")) && (!str2.contains("armv5")) && (!str2.contains("armv6"))) {
        break label80;
      }
    }
    label80:
    for (jdField_a_of_type_Boolean = false;; jdField_a_of_type_Boolean = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "cpuType=" + str1);
      }
      return;
    }
  }
  
  public MagicfaceViewController(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func MagicfaceViewController[Constructor] ends.isUseHardDecode:" + this.jdField_b_of_type_Boolean);
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
    }
    for (;;)
    {
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = paramInt;
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localLayoutParams.format = 1;
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window"));
      if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {}
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        try
        {
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
          return;
        }
        catch (Exception localException1)
        {
          QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException1);
          return;
        }
        localException1.type = 2038;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException2);
        }
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func playMaigcface, magicValue:" + paramEmoticon.magicValue);
    }
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView != null) && (((View)this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 1.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.onPlayEnd();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView == null) || (((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).getVisibility() != 0)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 2.");
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd == null);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.onPlayEnd();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 3.");
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd == null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.onPlayEnd();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      return;
      if (paramInt1 != 1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = MagicfaceActionManager.a(paramEmoticon, paramInt1, paramInt2);
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 4.");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.onPlayEnd();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
    return;
    this.jdField_a_of_type_JavaLangString = paramEmoticon.epId;
    b();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager = new MagicfaceActionManager(this);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 5.");
      }
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(8);
      ((View)this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView).setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setVisibility(0);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      localObject3 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().getWindow().getDecorView();
      ((ViewGroup)localObject3).removeView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
      ((ViewGroup)localObject3).addView(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView);
    }
    for (;;)
    {
      ((View)localObject2).setVisibility(0);
      ((SurfaceView)localObject2).setZOrderOnTop(true);
      ((SurfaceView)localObject2).getHolder().setFormat(-2);
      localObject3 = new MagicfacePlayManager();
      ((MagicfacePlayManager)localObject3).a((MagicfaceDecoder.MagicfaceRenderListener)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a((MagicfacePlayManager)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(new MagicfaceViewController.6(this, paramInt1, (TextView)localObject1));
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(new MagicfaceViewController.7(this, l, paramInt1));
      if (!((IMagicFaceView)localObject2).a()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 7.");
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(paramEmoticon, paramInt1, paramString, paramInt2);
      return;
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
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView;
      localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView.setMagicfaceGestureListener(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 8.");
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MagicfaceViewController.8(this), 200L);
    ((IMagicFaceView)localObject2).setSurfaceCreatelistener(new MagicfaceViewController.9(this, paramEmoticon, paramInt1, paramString, paramInt2));
  }
  
  public void a(Emoticon paramEmoticon, MagicfaceViewController.OnMagicPlayEnd paramOnMagicPlayEnd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay, magicValue:" + paramEmoticon.magicValue);
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = paramOnMagicPlayEnd;
    if (!a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.onPlayEnd();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func magicfaceAutoPlay ends, not support.");
      }
    }
    do
    {
      return;
      paramOnMagicPlayEnd = new Emoticon();
      paramOnMagicPlayEnd.eId = paramEmoticon.eId;
      paramOnMagicPlayEnd.epId = paramEmoticon.epId;
      paramOnMagicPlayEnd.magicValue = paramEmoticon.magicValue;
      paramOnMagicPlayEnd.jobType = paramEmoticon.jobType;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramOnMagicPlayEnd;
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new MagicfaceViewController.3(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "initMagicfaceView begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ai();
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "initMagicfaceView=======qvip_magicface_send");
      }
      if (this.jdField_b_of_type_Boolean)
      {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131562100, null);
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView = ((IMagicFaceView)localView.findViewById(2131370971));
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131370972));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370985));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370973));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131370982));
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131370970));
        this.jdField_d_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131370983));
        this.e = ((Button)localView.findViewById(2131370984));
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.e.setOnClickListener(this);
      }
    }
    else if (this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView == null)
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label415;
      }
    }
    label415:
    for (View localView = View.inflate(BaseApplicationImpl.getContext(), 2131562099, null);; localView = View.inflate(BaseApplicationImpl.getContext(), 2131562101, null))
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(BaseApplicationImpl.getContext(), 2131562103, null);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370981);
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewIMagicFaceView = ((IMagicFaceView)localView.findViewById(2131370974));
      this.jdField_b_of_type_ComTencentMobileqqMagicfaceViewMagicfaceContainerView = ((MagicfaceContainerView)localView.findViewById(2131370976));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370980));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370978));
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131370975));
      this.f = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131370977));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370979));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.f.setOnClickListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "initMagicfaceView ends");
      }
      return;
      localView = View.inflate(BaseApplicationImpl.getContext(), 2131562102, null);
      break;
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
      this.e.setBackgroundResource(2130847548);
      return;
    }
    this.e.setBackgroundResource(2130847547);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c())
    {
      this.f.setBackgroundResource(2130847495);
      return;
    }
    this.f.setBackgroundResource(2130847545);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MagicfaceViewController.2(this));
  }
  
  public void f()
  {
    if (this.jdField_d_of_type_AndroidWidgetButton.getTag() == null) {}
    Emoticon localEmoticon;
    do
    {
      return;
      localEmoticon = (Emoticon)this.jdField_d_of_type_AndroidWidgetButton.getTag();
    } while (localEmoticon.jobType != 2);
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a() >= 0)) {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a() != 0) {
        break label100;
      }
    }
    label100:
    for (localEmoticon.magicValue = "value=1";; localEmoticon.magicValue = ("value=" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a()))
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), localEmoticon);
      g();
      a(localEmoticon, null);
      return;
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
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd.onPlayEnd();
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController$OnMagicPlayEnd = null;
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.h();
    }
  }
  
  public void h()
  {
    g();
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    switch (paramView.getId())
    {
    default: 
    case 2131370970: 
    case 2131370975: 
    case 2131370982: 
    case 2131370983: 
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
        g();
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
        g();
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbChongzuo", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.f();
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MagicfaceViewController.1(this), 300L);
          continue;
          f();
        }
      }
    case 2131370984: 
      bool3 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b();
      localMagicfaceActionManager = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      if (!bool3)
      {
        bool1 = true;
        label275:
        localMagicfaceActionManager.a(bool1);
        c();
        localMagicfaceActionManager = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
        if (bool3) {
          break label356;
        }
      }
      label356:
      for (bool1 = bool2;; bool1 = false)
      {
        localMagicfaceActionManager.c(bool1);
        if (bool3) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "MbFasong", "MbKaiqiShengxiao", 0, 0, "", "", "", "");
        break;
        bool1 = false;
        break label275;
      }
    }
    bool2 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
    MagicfaceActionManager localMagicfaceActionManager = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
    if (!bool2)
    {
      bool1 = true;
      label381:
      localMagicfaceActionManager.b(bool1);
      d();
      localMagicfaceActionManager = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager;
      if (bool2) {
        break label461;
      }
    }
    label461:
    for (boolean bool1 = bool3;; bool1 = false)
    {
      localMagicfaceActionManager.c(bool1);
      if (bool2) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), "CliOper", "", "", "MbJieshou", "MbKaiqiShengxiao2", 0, 0, "", "", "", "");
      break;
      bool1 = false;
      break label381;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController
 * JD-Core Version:    0.7.0.1
 */