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
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MagicfaceViewController
  implements View.OnClickListener
{
  public static boolean a = false;
  protected OnMagicPlayEnd A;
  Emoticon B;
  protected BaseChatPie b;
  protected String c;
  protected MagicfaceContainerView d;
  protected MagicfaceContainerView e;
  protected IMagicFaceView f;
  protected IMagicFaceView g;
  protected TextView h;
  protected TextView i;
  protected TextView j;
  protected TextView k;
  protected Button l;
  protected Button m;
  protected Button n;
  protected Button o;
  protected ImageView p;
  public MagicfaceActionManager q;
  protected Button r;
  protected Button s;
  protected View t;
  protected View u;
  protected boolean v;
  protected WindowManager w;
  protected Handler x;
  protected ActionGlobalData y;
  Runnable z = null;
  
  static
  {
    String str = DeviceInfoUtil.m();
    Object localObject;
    if (str != null)
    {
      localObject = str.toLowerCase();
      if ((!((String)localObject).contains("marvell")) && (!((String)localObject).contains("armv5")) && (!((String)localObject).contains("armv6"))) {
        a = true;
      } else {
        a = false;
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
    this.b = paramBaseChatPie;
    this.x = new Handler(Looper.getMainLooper());
    a();
    if (QLog.isColorLevel())
    {
      paramBaseChatPie = new StringBuilder();
      paramBaseChatPie.append("func MagicfaceViewController[Constructor] ends.isUseHardDecode:");
      paramBaseChatPie.append(this.v);
      QLog.d("MagicfaceViewController", 2, paramBaseChatPie.toString());
    }
  }
  
  public static boolean b()
  {
    if ((((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.magicface_support.name())) && (a) && (DecoderUtil.IS_LOAD_SUCESS))
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
    if (!DeviceInfoUtil.L())
    {
      this.v = false;
      return;
    }
    if (Math.min(DeviceInfoUtil.B(), DeviceInfoUtil.C()) >= 720L)
    {
      this.v = true;
      return;
    }
    this.v = false;
  }
  
  public void a(int paramInt)
  {
    if (this.t == null) {
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
    this.w = ((WindowManager)BaseApplicationImpl.getContext().getSystemService("window"));
    if (this.t.getParent() != null) {
      try
      {
        this.w.removeView(this.t);
      }
      catch (Exception localException2)
      {
        QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException2);
      }
    }
    try
    {
      this.w.addView(this.t, localLayoutParams);
      return;
    }
    catch (Exception localException1)
    {
      QLog.e("MagicfaceViewController", 1, "initTopbar: ", localException1);
    }
  }
  
  public void a(Emoticon paramEmoticon)
  {
    this.o.setTag(paramEmoticon);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.b.d.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    if ((localAIOAnimationControlManager != null) && (localAIOAnimationControlManager.a != 1)) {
      localAIOAnimationControlManager.h();
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
    long l1 = System.currentTimeMillis();
    Object localObject1 = this.f;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 1.");
      }
      paramEmoticon = this.A;
      if (paramEmoticon != null)
      {
        paramEmoticon.onPlayEnd();
        this.A = null;
      }
      return;
    }
    localObject1 = this.g;
    if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 2.");
      }
      paramEmoticon = this.A;
      if (paramEmoticon != null)
      {
        paramEmoticon.onPlayEnd();
        this.A = null;
      }
      return;
    }
    localObject1 = this.q;
    if ((localObject1 != null) && (((MagicfaceActionManager)localObject1).h()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 3.");
      }
      paramEmoticon = this.A;
      if (paramEmoticon != null)
      {
        paramEmoticon.onPlayEnd();
        this.A = null;
      }
      return;
    }
    if (paramInt1 == 1)
    {
      this.y = MagicfaceActionManager.a(paramEmoticon, paramInt1, paramInt2);
      if (this.y == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 4.");
        }
        paramEmoticon = this.A;
        if (paramEmoticon != null)
        {
          paramEmoticon.onPlayEnd();
          this.A = null;
        }
        return;
      }
    }
    this.c = paramEmoticon.epId;
    c();
    this.q = new MagicfaceActionManager(this);
    Object localObject2;
    if (paramInt1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 5.");
      }
      this.e.setVisibility(8);
      ((View)this.g).setVisibility(8);
      this.d.setVisibility(0);
      localObject1 = this.f;
      localObject2 = this.h;
      this.d.setMagicfaceGestureListener(this.q);
      localObject3 = (ViewGroup)this.b.aX().getWindow().getDecorView();
      ((ViewGroup)localObject3).removeView(this.d);
      ((ViewGroup)localObject3).addView(this.d);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 6.");
      }
      localObject1 = (ViewGroup)this.b.aX().getWindow().getDecorView();
      ((ViewGroup)localObject1).removeView(this.e);
      localObject2 = new Rect();
      ((ViewGroup)localObject1).getWindowVisibleDisplayFrame((Rect)localObject2);
      int i1 = ((Rect)localObject2).top;
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      this.u.setBackgroundColor(0);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i1;
      a(0);
      ((ViewGroup)localObject1).addView(this.e);
      this.e.updateViewLayout((View)this.g, (ViewGroup.LayoutParams)localObject2);
      this.x.post(new MagicfaceViewController.5(this));
      this.e.setVisibility(8);
      ((View)this.g).setVisibility(8);
      this.e.setVisibility(0);
      this.g.setIsFullScreen(this.y.d);
      this.t.setVisibility(0);
      localObject1 = this.g;
      localObject2 = this.j;
      this.e.setMagicfaceGestureListener(this.q);
      this.p.setVisibility(8);
      this.k.setVisibility(8);
    }
    ((View)localObject1).setVisibility(0);
    Object localObject3 = (SurfaceView)localObject1;
    ((SurfaceView)localObject3).setZOrderOnTop(true);
    ((SurfaceView)localObject3).getHolder().setFormat(-2);
    localObject3 = new MagicfacePlayManager();
    ((MagicfacePlayManager)localObject3).a((MagicfaceDecoder.MagicfaceRenderListener)localObject1);
    this.q.a((MagicfacePlayManager)localObject3);
    this.q.a(new MagicfaceViewController.6(this, paramInt1, (TextView)localObject2));
    this.q.a(new MagicfaceViewController.7(this, l1, paramInt1));
    if (((IMagicFaceView)localObject1).a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 7.");
      }
      this.q.a(paramEmoticon, paramInt1, paramString, paramInt2);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "func playMaigcface ends, step 8.");
    }
    this.x.postDelayed(new MagicfaceViewController.8(this), 200L);
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
    this.A = paramOnMagicPlayEnd;
    if (!b())
    {
      paramEmoticon = this.A;
      if (paramEmoticon != null)
      {
        paramEmoticon.onPlayEnd();
        this.A = null;
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
    this.B = paramOnMagicPlayEnd;
    if (this.x != null)
    {
      if (this.z == null) {
        this.z = new MagicfaceViewController.3(this);
      }
      this.x.postDelayed(this.z, 400L);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "initMagicfaceView begins");
    }
    this.b.as();
    View localView;
    if (this.d == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "initMagicfaceView=======qvip_magicface_send");
      }
      if (this.v) {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131628360, null);
      } else {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131628362, null);
      }
      this.f = ((IMagicFaceView)localView.findViewById(2131437879));
      this.d = ((MagicfaceContainerView)localView.findViewById(2131437880));
      this.h = ((TextView)localView.findViewById(2131437893));
      this.i = ((TextView)localView.findViewById(2131437881));
      this.m = ((Button)localView.findViewById(2131437890));
      this.l = ((Button)localView.findViewById(2131437878));
      this.o = ((Button)localView.findViewById(2131437891));
      this.r = ((Button)localView.findViewById(2131437892));
      this.l.setOnClickListener(this);
      this.m.setOnClickListener(this);
      this.o.setOnClickListener(this);
      this.r.setOnClickListener(this);
    }
    if (this.e == null)
    {
      if (this.v) {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131628359, null);
      } else {
        localView = View.inflate(BaseApplicationImpl.getContext(), 2131628361, null);
      }
      this.t = View.inflate(BaseApplicationImpl.getContext(), 2131628363, null);
      this.u = this.t.findViewById(2131437889);
      this.g = ((IMagicFaceView)localView.findViewById(2131437882));
      this.e = ((MagicfaceContainerView)localView.findViewById(2131437884));
      this.j = ((TextView)this.t.findViewById(2131437888));
      this.k = ((TextView)localView.findViewById(2131437886));
      this.n = ((Button)this.t.findViewById(2131437883));
      this.s = ((Button)this.t.findViewById(2131437885));
      this.p = ((ImageView)this.t.findViewById(2131437887));
      this.n.setOnClickListener(this);
      this.s.setOnClickListener(this);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "initMagicfaceView ends");
    }
  }
  
  public void d()
  {
    if (this.q.k())
    {
      this.r.setBackgroundResource(2130849070);
      return;
    }
    this.r.setBackgroundResource(2130849069);
  }
  
  public void e()
  {
    if (this.q.l())
    {
      this.s.setBackgroundResource(2130849016);
      return;
    }
    this.s.setBackgroundResource(2130849067);
  }
  
  public void f()
  {
    this.x.post(new MagicfaceViewController.2(this));
  }
  
  public void g()
  {
    if (this.o.getTag() == null) {
      return;
    }
    Emoticon localEmoticon = (Emoticon)this.o.getTag();
    if (localEmoticon.jobType == 2)
    {
      Object localObject = this.q;
      if ((localObject != null) && (((MagicfaceActionManager)localObject).j() >= 0)) {
        if (this.q.j() == 0)
        {
          localEmoticon.magicValue = "value=1";
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("value=");
          ((StringBuilder)localObject).append(this.q.j());
          localEmoticon.magicValue = ((StringBuilder)localObject).toString();
        }
      }
      ChatActivityFacade.a(this.b.i(), this.b.e, this.b.aE(), localEmoticon);
      h();
      a(localEmoticon, null);
    }
  }
  
  public void h()
  {
    if (this.q != null)
    {
      this.d.setVisibility(8);
      ((View)this.f).setVisibility(8);
      this.f.setSurfaceCreatelistener(null);
      this.e.setVisibility(8);
      this.d.setMagicfaceGestureListener(null);
      this.e.setMagicfaceGestureListener(null);
      ((View)this.g).setVisibility(8);
      this.g.setSurfaceCreatelistener(null);
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("MagicfaceViewController", 2, "removeView=======DecorView");
      }
      localObject = this.b.aW();
      ((ViewGroup)localObject).removeView(this.e);
      ((ViewGroup)localObject).removeView(this.d);
      if (this.t != null)
      {
        this.t.setVisibility(8);
        if (this.w != null) {
          this.w.removeView(this.t);
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label160:
      break label160;
    }
    if (this.q.h())
    {
      localObject = this.q;
      ((MagicfaceActionManager)localObject).a(new MagicfaceViewController.4(this, (MagicfaceActionManager)localObject));
    }
    else
    {
      this.q.i();
    }
    localObject = this.A;
    if (localObject != null)
    {
      ((OnMagicPlayEnd)localObject).onPlayEnd();
      this.A = null;
    }
  }
  
  public boolean i()
  {
    if ((this.q != null) && ((this.d.getVisibility() != 8) || (this.e.getVisibility() != 8)))
    {
      h();
      return true;
    }
    return false;
  }
  
  public void j()
  {
    h();
    Handler localHandler = this.x;
    if (localHandler != null)
    {
      Runnable localRunnable = this.z;
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
    case 2131437892: 
      bool = this.q.k();
      this.q.b(bool ^ true);
      d();
      this.q.d(bool ^ true);
      if (!bool) {
        ReportController.b(this.b.i(), "CliOper", "", "", "MbFasong", "MbKaiqiShengxiao", 0, 0, "", "", "", "");
      }
      break;
    case 2131437891: 
      g();
      break;
    case 2131437890: 
      ReportController.b(this.b.i(), "CliOper", "", "", "MbFasong", "MbChongzuo", 0, 0, this.c, "", "", "");
      MagicfaceActionManager localMagicfaceActionManager = this.q;
      if (localMagicfaceActionManager != null)
      {
        localMagicfaceActionManager.f();
        this.x.postDelayed(new MagicfaceViewController.1(this), 300L);
      }
      break;
    case 2131437885: 
      bool = this.q.l();
      this.q.c(bool ^ true);
      e();
      this.q.d(bool ^ true);
      if (!bool) {
        ReportController.b(this.b.i(), "CliOper", "", "", "MbJieshou", "MbKaiqiShengxiao2", 0, 0, "", "", "", "");
      }
      break;
    case 2131437883: 
      ReportController.b(this.b.i(), "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.c, "", "", "");
      h();
      break;
    case 2131437878: 
      ReportController.b(this.b.i(), "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.c, "", "", "");
      h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController
 * JD-Core Version:    0.7.0.1
 */