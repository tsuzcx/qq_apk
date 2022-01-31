import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.ui.RedPacketGameSmallScreenView;
import com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenService;
import com.tencent.av.smallscreen.SmallScreenVideoControlUI;
import com.tencent.av.smallscreen.SmallScreenVideoController.1;
import com.tencent.av.smallscreen.SmallScreenVideoController.3;
import com.tencent.av.smallscreen.SmallScreenVideoController.4;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import mqq.app.AppRuntime;

public class lzm
  implements lzs
{
  public int a;
  public Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  Display jdField_a_of_type_AndroidViewDisplay = null;
  public VideoController a;
  public VideoAppInterface a;
  CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  SmallScreenService jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService;
  public SmallScreenVideoControlUI a;
  public String a;
  public Timer a;
  lkg jdField_a_of_type_Lkg = new lzn(this);
  lzp jdField_a_of_type_Lzp = new lzp(this);
  public lzr a;
  mbv jdField_a_of_type_Mbv = null;
  public mck a;
  public boolean a;
  int jdField_b_of_type_Int = 1;
  String jdField_b_of_type_JavaLangString = null;
  public boolean b;
  public int c;
  String jdField_c_of_type_JavaLangString = null;
  boolean jdField_c_of_type_Boolean = false;
  public int d;
  boolean d;
  int jdField_e_of_type_Int = -1;
  boolean jdField_e_of_type_Boolean = false;
  int f;
  int g;
  
  public lzm(SmallScreenService paramSmallScreenService)
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_g_of_type_Int = 0;
    this.jdField_a_of_type_Mck = new lzo(this);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_AndroidContentContext = paramSmallScreenService.getApplicationContext();
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getSystemService("window")).getDefaultDisplay();
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    RedPacketGameSmallScreenView localRedPacketGameSmallScreenView = (RedPacketGameSmallScreenView)paramViewGroup.findViewById(2131372455);
    if (localRedPacketGameSmallScreenView != null)
    {
      localRedPacketGameSmallScreenView.a();
      paramViewGroup.removeView(localRedPacketGameSmallScreenView);
    }
  }
  
  private void b(int paramInt)
  {
    long l = AudioHelper.b();
    StringBuilder localStringBuilder;
    if (AudioHelper.e())
    {
      localStringBuilder = new StringBuilder().append("changeVideoLayoutMode, mode[").append(paramInt).append("], mVideoLayerUI[");
      if (this.jdField_a_of_type_Lzr == null) {
        break label92;
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("SmallScreenVideoController", 1, bool + "], seq[" + l + "]");
      if ((this.jdField_a_of_type_Lzr != null) && (paramInt != this.jdField_a_of_type_Lzr.f())) {
        break;
      }
      return;
    }
    if (paramInt == 1) {
      a(Integer.valueOf(6101), null, Boolean.valueOf(false));
    }
    this.jdField_a_of_type_Lzr.g(paramInt);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(l);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenVideoController.4(this), 50L);
  }
  
  public RedPacketGameSmallScreenView a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    RedPacketGameSmallScreenView localRedPacketGameSmallScreenView = (RedPacketGameSmallScreenView)paramViewGroup.findViewById(2131372455);
    if (localRedPacketGameSmallScreenView == null)
    {
      localRedPacketGameSmallScreenView = new RedPacketGameSmallScreenView(paramViewGroup.getContext());
      paramViewGroup.addView(localRedPacketGameSmallScreenView, new ViewGroup.LayoutParams(-1, -1));
    }
    for (paramViewGroup = localRedPacketGameSmallScreenView;; paramViewGroup = localRedPacketGameSmallScreenView)
    {
      paramViewGroup.setAVRedPacketManager((AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6), paramBoolean);
      return paramViewGroup;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    SmallScreenVideoController.1 local1 = new SmallScreenVideoController.1(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(local1, 1000L);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(paramInt);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onDestroy, mActivityState[" + this.jdField_b_of_type_Int + "->" + 0 + "], seq[" + paramLong + "]");
    }
    this.jdField_b_of_type_Int = 0;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null))
    {
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131374988);
      if (localObject != null) {
        ((View)localObject).findViewById(2131374992).clearAnimation();
      }
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Lkg);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = null;
    }
    if (this.jdField_a_of_type_Lzr != null)
    {
      this.jdField_a_of_type_Lzr.p();
      this.jdField_a_of_type_Lzr = null;
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramLong);
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lzp);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mck);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().b("SmallScreen.onDestroy", 0);
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_Mbv = null;
    this.jdField_a_of_type_Mck = null;
    this.jdField_a_of_type_Lzp = null;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout;
      if (localObject != null) {
        a((ViewGroup)localObject);
      }
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    lcl.c("SmallScreenVideoController", "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject1, paramObject2 });
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof VideoAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "onCreate");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)paramAppRuntime);
      this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mck);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lzp);
      this.jdField_a_of_type_ComTencentAvVideoController.b();
      j();
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().a()) {
        i();
      }
      GraphicRenderMgr.getInstance();
      a(false);
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localObject != null) && (QLog.isColorLevel())) {
      QLog.d("SmallScreenVideoController", 2, "onCreateUI SessionType = " + ((lgf)localObject).jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = muf.a(this.jdField_a_of_type_AndroidContentContext, 2130841453);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Lkg);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController);
    }
    View localView = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.findViewById(2131362930);
    if (this.jdField_a_of_type_Lzr == null)
    {
      this.jdField_a_of_type_Lzr = new lzr(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, localView, this);
      switch (this.jdField_c_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.f) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null)) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new lzd(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mck);
      }
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramBoolean);
      }
      if ((localObject != null) && (((lgf)localObject).jdField_g_of_type_Int != 4) && (this.jdField_c_of_type_Int == 1) && (!this.jdField_a_of_type_Boolean))
      {
        int i = bbyt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 6, true, null);
        if (i > 0)
        {
          int j = bbyt.a();
          localObject = bbyt.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i, j, null);
          if (localObject != null)
          {
            localObject = new File((String)localObject);
            if ((localObject != null) && (((File)localObject).exists()) && (this.jdField_a_of_type_Lzr != null)) {
              this.jdField_a_of_type_Lzr.w();
            }
          }
        }
      }
      return;
      this.jdField_a_of_type_Lzr.c();
      break;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mck);
          if (localObject != null)
          {
            this.jdField_c_of_type_Int = ((lgf)localObject).jdField_d_of_type_Int;
            this.jdField_d_of_type_Int = ((lgf)localObject).jdField_f_of_type_Int;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new lzd(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mck);
          continue;
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new lzd(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mck);
          continue;
          if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
            if (this.jdField_d_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mck);
              if (localObject != null)
              {
                this.jdField_c_of_type_Int = ((lgf)localObject).jdField_d_of_type_Int;
                this.jdField_d_of_type_Int = ((lgf)localObject).jdField_f_of_type_Int;
              }
            }
            else if (this.jdField_a_of_type_ComTencentAvVideoController.a().C == 2)
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mck);
            }
            else
            {
              this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mck);
              continue;
              if ((localObject != null) && (((lgf)localObject).a.jdField_b_of_type_Int > 0))
              {
                if (((lgf)localObject).a.jdField_a_of_type_Int == 3) {
                  this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mck);
                } else {
                  this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new lzd(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mck);
                }
              }
              else if ((localObject != null) && (((lgf)localObject).jdField_e_of_type_Boolean) && ((((lgf)localObject).jdField_g_of_type_Int == 1) || (((lgf)localObject).jdField_g_of_type_Int == 2))) {
                this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new lzd(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mck);
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().aw) {}
    while ((this.jdField_a_of_type_Int == paramInt) || (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) || (!(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI instanceof lzd))) {
      return false;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k)
    {
      lcl.e("SmallScreenVideoController", "Remote not has video, nOff=" + paramInt);
      return false;
    }
    QLog.d("SmallScreenVideoController", 1, "setGlassSwitch nOff=" + paramInt + ", prior=" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvVideoController.a().Q = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Lzr.n();
      this.jdField_a_of_type_ComTencentAvVideoController.a(0);
      continue;
      this.jdField_a_of_type_Lzr.m();
      this.jdField_a_of_type_ComTencentAvVideoController.a(0);
      continue;
      this.jdField_a_of_type_Lzr.n();
      this.jdField_a_of_type_ComTencentAvVideoController.a(1);
      continue;
      this.jdField_a_of_type_Lzr.m();
      this.jdField_a_of_type_ComTencentAvVideoController.a(1);
    }
  }
  
  public void b()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick start");
    }
    Intent localIntent1;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (MultiIncomingCallsActivity.jdField_e_of_type_Boolean))
    {
      localIntent1 = new Intent(this.jdField_a_of_type_AndroidContentContext, MultiIncomingCallsActivity.class);
      localIntent1.addFlags(262144);
      localIntent1.addFlags(268435456);
      localIntent1.addFlags(4194304);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenVideoController", 2, "onClick end");
        }
        return;
      }
      catch (Exception localException1)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SmallScreenVideoController", 2, "onClick e = " + localException1);
        continue;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        lgf locallgf = this.jdField_a_of_type_ComTencentAvVideoController.a();
        int i = locallgf.jdField_d_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("SmallScreenVideoController", 2, "onClick sessionType =" + i);
        }
        if (this.jdField_a_of_type_ComTencentAvVideoController.f) {
          i = 1;
        }
        Intent localIntent2;
        if ((i == 1) || (i == 2))
        {
          localIntent2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          if ((locallgf.i != 1011) && (!this.jdField_a_of_type_ComTencentAvVideoController.f))
          {
            localIntent2.addFlags(262144);
            localIntent2.addFlags(268435456);
            localIntent2.addFlags(4194304);
            if (locallgf.I)
            {
              localIntent2.putExtra("sessionType", 3);
              localIntent2.putExtra("GroupId", locallgf.jdField_d_of_type_JavaLangString);
              localIntent2.putExtra("isDoubleVideoMeeting", true);
            }
            for (;;)
            {
              try
              {
                this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
                localIntent2.putExtra("Fromwhere", "SmallScreen");
              }
              catch (Exception localException2)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("SmallScreenVideoController", 2, "onClick e = " + localException2);
                continue;
              }
              localIntent2.putExtra("sessionType", i);
              localIntent2.putExtra("uin", localException2.jdField_d_of_type_JavaLangString);
              try
              {
                this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
              }
              catch (Exception localException3) {}
              if (QLog.isColorLevel()) {
                QLog.e("SmallScreenVideoController", 2, "onClick e = " + localException3);
              }
            }
          }
        }
        else
        {
          long l = localException3.jdField_g_of_type_Long;
          int j = localException3.E;
          if ((l != 0L) || (localException3.a.jdField_b_of_type_Int > 0))
          {
            if (localException3.a.jdField_b_of_type_Int > 0)
            {
              if ((localException3.jdField_d_of_type_Int != 1) && (localException3.a.jdField_a_of_type_Int != 1) && (localException3.jdField_d_of_type_Int != 3) && (localException3.a.jdField_a_of_type_Int != 3) && (QLog.isColorLevel())) {
                QLog.e("SmallScreenVideoController", 2, "onClick status error");
              }
            }
            else
            {
              localIntent2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
              localIntent2.addFlags(262144);
              localIntent2.addFlags(268435456);
              localIntent2.addFlags(4194304);
              localIntent2.putExtra("GroupId", String.valueOf(l));
              localIntent2.putExtra("Type", 2);
              localIntent2.putExtra("sessionType", i);
              localIntent2.putExtra("uinType", muf.c(j));
              localIntent2.putExtra("isDoubleVideoMeeting", localException3.I);
              localIntent2.putExtra("MultiAVType", localException3.C);
              localIntent2.putExtra("Fromwhere", "SmallScreen");
              try
              {
                this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
              }
              catch (Exception localException4) {}
              if (QLog.isColorLevel()) {
                QLog.e("SmallScreenVideoController", 2, "onClick e = " + localException4);
              }
            }
          }
          else
          {
            if ((this.jdField_a_of_type_ComTencentAvVideoController.c()) && (localException4.g()))
            {
              localIntent2 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteActivity.class);
              localIntent2.addFlags(268435456);
              localIntent2.putExtra("uinType", localException4.i);
              localIntent2.putExtra("peerUin", localException4.jdField_d_of_type_JavaLangString);
              localIntent2.putExtra("extraUin", localException4.jdField_f_of_type_JavaLangString);
              if (localException4.jdField_f_of_type_Int == 1) {}
              for (;;)
              {
                localIntent2.putExtra("isAudioMode", bool);
                this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent2);
                break;
                bool = false;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.e("SmallScreenVideoController", 2, "onClick status error");
            }
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("SmallScreenVideoController", 2, "onClick app is null");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
    }
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_Lzi != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_Lzi.b()) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout != null) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() != 8))
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.jdField_b_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
      return;
    }
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.stopSelf();
  }
  
  public void e()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isDevelopLevel()) {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, ">>>onStart(), ts=" + l1);
    }
    this.jdField_b_of_type_Int = 3;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStart");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.b();
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isDevelopLevel())
    {
      QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onStart(), ts=" + l2);
      QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onStart(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
  }
  
  public void f()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 5;
    long l2 = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoController", 1, "onResume, seq[" + l2 + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenVideoController.3(this, l2), 200L);
    boolean bool2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().j())
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        bool2 = this.jdField_a_of_type_ComTencentAvVideoController.a().k;
        if (this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_JavaLangString) == 5)
        {
          bool1 = true;
          this.jdField_a_of_type_Lzr.a((String)localObject, 1, bool2, false, bool1);
          if ((this.jdField_a_of_type_ComTencentAvVideoController.a().j) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()))
          {
            this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l2);
            this.jdField_a_of_type_Lzr.a(true, false);
            this.jdField_a_of_type_Lzr.c(l2, this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
          }
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) {
      for (;;)
      {
        if (this.jdField_a_of_type_Lzr != null) {
          this.jdField_a_of_type_Lzr.q();
        }
        if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.e();
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(false);
        k();
        l2 = System.currentTimeMillis();
        if (QLog.isDevelopLevel())
        {
          QLog.d("IVR_TS_SmallScreenVideoController", 4, "<<<onResume(), ts=" + l2);
          QLog.d("IVR_TS_SmallScreenVideoController", 4, String.format("onResume(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
        }
        return;
        bool1 = false;
        continue;
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().ag) && (!this.jdField_c_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(l2, true);
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l2);
          this.jdField_a_of_type_Lzr.a(true, false);
          this.jdField_a_of_type_Lzr.c(l2, this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().c;
    int i = 0;
    label436:
    String str;
    int j;
    boolean bool3;
    if (i < ((ArrayList)localObject).size())
    {
      los locallos = (los)((ArrayList)localObject).get(i);
      str = String.valueOf(locallos.jdField_a_of_type_Long);
      j = locallos.jdField_a_of_type_Int;
      bool2 = locallos.jdField_a_of_type_Boolean;
      bool3 = locallos.jdField_b_of_type_Boolean;
      if (locallos.jdField_b_of_type_Long != 5L) {
        break label544;
      }
    }
    label544:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (bool3)) {
        this.jdField_a_of_type_Lzr.a(str, j, bool3, bool2, bool1);
      }
      i += 1;
      break label436;
      break;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onPause");
    }
    l();
    this.jdField_b_of_type_Int = 4;
    if (this.jdField_a_of_type_Lzr != null) {
      this.jdField_a_of_type_Lzr.x();
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.g();
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a(true);
  }
  
  public void h()
  {
    this.jdField_b_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onStop");
    }
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.q();
    }
  }
  
  void i()
  {
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_Int;
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().I;
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().i;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().z;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().p;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean;
  }
  
  void j()
  {
    if (this.jdField_a_of_type_Mbv == null) {
      this.jdField_a_of_type_Mbv = new lzq(this, this.jdField_a_of_type_AndroidContentContext, 2);
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_Mbv != null) {
      this.jdField_a_of_type_Mbv.enable();
    }
  }
  
  void l()
  {
    if (this.jdField_a_of_type_Mbv != null) {
      this.jdField_a_of_type_Mbv.disable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lzm
 * JD-Core Version:    0.7.0.1
 */