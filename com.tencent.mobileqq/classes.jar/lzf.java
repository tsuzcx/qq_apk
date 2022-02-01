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

public class lzf
  implements lzl
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
  ljf jdField_a_of_type_Ljf = new lzg(this);
  lzi jdField_a_of_type_Lzi = new lzi(this);
  public lzk a;
  mbm jdField_a_of_type_Mbm = null;
  public mcc a;
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
  
  public lzf(SmallScreenService paramSmallScreenService)
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
    this.jdField_a_of_type_Mcc = new lzh(this);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService = paramSmallScreenService;
    this.jdField_a_of_type_AndroidContentContext = paramSmallScreenService.getApplicationContext();
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.getSystemService("window")).getDefaultDisplay();
  }
  
  public static void a(Context paramContext, VideoController paramVideoController)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "enterVideo start");
    }
    if ((paramContext == null) || (paramVideoController == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "enterVideo context or controller is null.");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoController", 2, "enterVideo end");
      }
      label135:
      lez locallez;
      int i;
      label446:
      long l;
      int j;
      do
      {
        Intent localIntent;
        do
        {
          for (;;)
          {
            return;
            if (!MultiIncomingCallsActivity.jdField_e_of_type_Boolean) {
              break label135;
            }
            paramVideoController = new Intent(paramContext, MultiIncomingCallsActivity.class);
            paramVideoController.addFlags(262144);
            paramVideoController.addFlags(268435456);
            paramVideoController.addFlags(4194304);
            try
            {
              paramContext.startActivity(paramVideoController);
            }
            catch (Exception paramContext) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + paramContext);
          break;
          locallez = paramVideoController.a();
          i = locallez.jdField_d_of_type_Int;
          if (QLog.isColorLevel()) {
            QLog.d("SmallScreenVideoController", 2, "enterVideo sessionType =" + i);
          }
          if (paramVideoController.f) {
            i = 1;
          }
          if ((i != 1) && (i != 2)) {
            break label446;
          }
          localIntent = new Intent(paramContext, AVActivity.class);
        } while ((locallez.jdField_j_of_type_Int == 1011) || (paramVideoController.f));
        localIntent.addFlags(262144);
        localIntent.addFlags(268435456);
        localIntent.addFlags(4194304);
        if (locallez.J)
        {
          locallez.jdField_j_of_type_Int = 0;
          localIntent.putExtra("sessionType", locallez.jdField_d_of_type_Int);
          localIntent.putExtra("GroupId", locallez.jdField_d_of_type_JavaLangString);
          localIntent.putExtra("uin", locallez.jdField_d_of_type_JavaLangString);
          localIntent.putExtra("isDoubleVideoMeeting", true);
          localIntent.putExtra("uinType", locallez.jdField_j_of_type_Int);
        }
        for (;;)
        {
          try
          {
            paramContext.startActivity(localIntent);
            localIntent.putExtra("Fromwhere", "SmallScreen");
          }
          catch (Exception paramContext)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + paramContext);
            continue;
          }
          localIntent.putExtra("sessionType", i);
          localIntent.putExtra("uin", locallez.jdField_d_of_type_JavaLangString);
          try
          {
            paramContext.startActivity(localIntent);
          }
          catch (Exception paramContext) {}
          if (QLog.isColorLevel()) {
            QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + paramContext);
          }
        }
        l = locallez.jdField_g_of_type_Long;
        j = locallez.F;
        if ((l == 0L) && (locallez.a.jdField_b_of_type_Int <= 0)) {
          break label692;
        }
        if (locallez.a.jdField_b_of_type_Int <= 0) {
          break label545;
        }
      } while ((locallez.jdField_d_of_type_Int == 1) || (locallez.a.jdField_a_of_type_Int == 1) || (locallez.jdField_d_of_type_Int == 3) || (locallez.a.jdField_a_of_type_Int == 3) || (!QLog.isColorLevel()));
      QLog.e("SmallScreenVideoController", 2, "enterVideo status error");
      return;
      label545:
      paramVideoController = new Intent(paramContext, AVActivity.class);
      paramVideoController.addFlags(262144);
      paramVideoController.addFlags(268435456);
      paramVideoController.addFlags(4194304);
      paramVideoController.putExtra("GroupId", String.valueOf(l));
      paramVideoController.putExtra("Type", 2);
      paramVideoController.putExtra("sessionType", i);
      paramVideoController.putExtra("uinType", mum.c(j));
      paramVideoController.putExtra("isDoubleVideoMeeting", locallez.J);
      paramVideoController.putExtra("MultiAVType", locallez.D);
      paramVideoController.putExtra("Fromwhere", "SmallScreen");
      try
      {
        paramContext.startActivity(paramVideoController);
      }
      catch (Exception paramContext) {}
      if (QLog.isColorLevel())
      {
        QLog.e("SmallScreenVideoController", 2, "enterVideo e = " + paramContext);
        continue;
        label692:
        if ((paramVideoController.d()) && (locallez.i()))
        {
          paramVideoController = new Intent(paramContext, VideoInviteActivity.class);
          paramVideoController.addFlags(268435456);
          paramVideoController.putExtra("uinType", locallez.jdField_j_of_type_Int);
          paramVideoController.putExtra("peerUin", locallez.jdField_d_of_type_JavaLangString);
          paramVideoController.putExtra("extraUin", locallez.jdField_f_of_type_JavaLangString);
          if (locallez.jdField_f_of_type_Int == 1) {}
          for (;;)
          {
            paramVideoController.putExtra("isAudioMode", bool);
            paramContext.startActivity(paramVideoController);
            break;
            bool = false;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("SmallScreenVideoController", 2, "enterVideo status error");
        }
      }
    }
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    RedPacketGameSmallScreenView localRedPacketGameSmallScreenView = (RedPacketGameSmallScreenView)paramViewGroup.findViewById(2131373494);
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
    if (AudioHelper.f())
    {
      localStringBuilder = new StringBuilder().append("changeVideoLayoutMode, mode[").append(paramInt).append("], mVideoLayerUI[");
      if (this.jdField_a_of_type_Lzk == null) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("SmallScreenVideoController", 1, bool + "], seq[" + l + "]");
      if ((this.jdField_a_of_type_Lzk != null) && (paramInt != this.jdField_a_of_type_Lzk.f())) {
        break;
      }
      return;
    }
    if (paramInt == 1) {
      a(Integer.valueOf(6101), null, Boolean.valueOf(false));
    }
    this.jdField_a_of_type_Lzk.g(paramInt);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(l);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new SmallScreenVideoController.4(this), 50L);
  }
  
  public RedPacketGameSmallScreenView a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    RedPacketGameSmallScreenView localRedPacketGameSmallScreenView = (RedPacketGameSmallScreenView)paramViewGroup.findViewById(2131373494);
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
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null) {}
    for (Object localObject = null;; localObject = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1))
    {
      if (localObject != null)
      {
        View localView = ((SmallScreenRelativeLayout)localObject).findViewById(2131376141);
        if (localView != null) {
          localView.findViewById(2131376145).clearAnimation();
        }
      }
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils != null)
      {
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils.b(this.jdField_a_of_type_Ljf);
        this.jdField_a_of_type_ComTencentAvCameraCameraUtils = null;
      }
      if (this.jdField_a_of_type_Lzk != null)
      {
        this.jdField_a_of_type_Lzk.p();
        this.jdField_a_of_type_Lzk = null;
      }
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null)
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramLong);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = null;
      }
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Lzi);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mcc);
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d("SmallScreen.onDestroy", 0);
      }
      this.jdField_a_of_type_ComTencentAvVideoController = null;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
      this.jdField_a_of_type_Mbm = null;
      this.jdField_a_of_type_Mcc = null;
      this.jdField_a_of_type_Lzi = null;
      if (localObject != null) {
        a((ViewGroup)localObject);
      }
      return;
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    lba.f("SmallScreenVideoController", "notifyEvent :" + paramInteger + "|" + paramObject1 + "|" + paramObject2);
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
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mcc);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lzi);
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Lbt.b();
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
    Object localObject1 = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((localObject1 != null) && (QLog.isColorLevel())) {
      QLog.d("SmallScreenVideoController", 2, "onCreateUI SessionType = " + ((lez)localObject1).jdField_d_of_type_Int);
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = mum.a(this.jdField_a_of_type_AndroidContentContext, 2130841969);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraUtils == null)
    {
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_Ljf);
      this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Lca);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
    if (localObject2 == null)
    {
      QLog.w("SmallScreenVideoController", 2, "onCreateUI videoToastView == null");
      return;
    }
    localObject2 = ((SmallScreenRelativeLayout)localObject2).findViewById(2131363117);
    if (this.jdField_a_of_type_Lzk == null)
    {
      this.jdField_a_of_type_Lzk = new lzk(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, (View)localObject2, this);
      label171:
      switch (this.jdField_c_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvVideoController.f) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null)) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new lyt(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
      }
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI.a(paramBoolean);
      }
      if ((localObject1 == null) || (((lez)localObject1).jdField_g_of_type_Int == 4) || (this.jdField_c_of_type_Int != 1) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      int i = bgqr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount(), 6, true, null);
      if (i <= 0) {
        break;
      }
      int j = bgqr.a();
      localObject1 = bgqr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, i, j, null);
      if (localObject1 == null) {
        break;
      }
      localObject1 = new File((String)localObject1);
      if ((localObject1 == null) || (!((File)localObject1).exists()) || (this.jdField_a_of_type_Lzk == null)) {
        break;
      }
      this.jdField_a_of_type_Lzk.w();
      return;
      this.jdField_a_of_type_Lzk.c();
      break label171;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
          if (localObject1 != null)
          {
            this.jdField_c_of_type_Int = ((lez)localObject1).jdField_d_of_type_Int;
            this.jdField_d_of_type_Int = ((lez)localObject1).jdField_f_of_type_Int;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new lyt(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
          continue;
          if (this.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
            if (localObject1 != null)
            {
              this.jdField_c_of_type_Int = ((lez)localObject1).jdField_d_of_type_Int;
              this.jdField_d_of_type_Int = ((lez)localObject1).jdField_f_of_type_Int;
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new lyt(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
            continue;
            if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) {
              if (this.jdField_d_of_type_Boolean)
              {
                this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
                if (localObject1 != null)
                {
                  this.jdField_c_of_type_Int = ((lez)localObject1).jdField_d_of_type_Int;
                  this.jdField_d_of_type_Int = ((lez)localObject1).jdField_f_of_type_Int;
                }
              }
              else if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
              {
                this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
              }
              else
              {
                this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
                continue;
                if ((localObject1 != null) && (((lez)localObject1).a.jdField_b_of_type_Int > 0))
                {
                  if (((lez)localObject1).a.jdField_a_of_type_Int == 3) {
                    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new SmallScreenMultiVideoControlUI(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
                  } else {
                    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new lyt(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
                  }
                }
                else if ((localObject1 != null) && (((lez)localObject1).jdField_e_of_type_Boolean) && ((((lez)localObject1).jdField_g_of_type_Int == 1) || (((lez)localObject1).jdField_g_of_type_Int == 2))) {
                  this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI = new lyt(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService, this.jdField_a_of_type_Mcc);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().ay) {}
    while ((this.jdField_a_of_type_Int == paramInt) || (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI == null) || (!(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoControlUI instanceof lyt))) {
      return false;
    }
    if (!this.jdField_a_of_type_ComTencentAvVideoController.a().k)
    {
      lba.h("SmallScreenVideoController", "Remote not has video, nOff=" + paramInt);
      return false;
    }
    QLog.d("SmallScreenVideoController", 1, "setGlassSwitch nOff=" + paramInt + ", prior=" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentAvVideoController.a().R = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Lzk.n();
      this.jdField_a_of_type_ComTencentAvVideoController.a(0);
      continue;
      this.jdField_a_of_type_Lzk.m();
      this.jdField_a_of_type_ComTencentAvVideoController.a(0);
      continue;
      this.jdField_a_of_type_Lzk.n();
      this.jdField_a_of_type_ComTencentAvVideoController.a(1);
      continue;
      this.jdField_a_of_type_Lzk.m();
      this.jdField_a_of_type_ComTencentAvVideoController.a(1);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick start");
    }
    a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvVideoController);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoController", 2, "onClick end");
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
    SmallScreenRelativeLayout localSmallScreenRelativeLayout = null;
    lza locallza;
    if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null)
    {
      locallza = null;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService != null) {
        break label66;
      }
      label18:
      if ((!this.jdField_b_of_type_Boolean) || (locallza == null) || (!locallza.b()) || (localSmallScreenRelativeLayout == null) || (localSmallScreenRelativeLayout.getVisibility() == 8)) {
        break label78;
      }
      localSmallScreenRelativeLayout.e();
    }
    label66:
    label78:
    while (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService == null)
    {
      return;
      locallza = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
      break;
      localSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenService.a(1);
      break label18;
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
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().l())
      {
        localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
        bool1 = this.jdField_a_of_type_ComTencentAvVideoController.a().k;
        this.jdField_a_of_type_Lzk.a((String)localObject, 1, bool1, false, this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_JavaLangString));
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c()))
        {
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l2);
          this.jdField_a_of_type_Lzk.a(true, false);
          this.jdField_a_of_type_Lzk.c(l2, this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int != 4) {
      for (;;)
      {
        if (this.jdField_a_of_type_Lzk != null) {
          this.jdField_a_of_type_Lzk.q();
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
        if ((!this.jdField_a_of_type_ComTencentAvVideoController.a().ai) && (!this.jdField_c_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a().a(l2, true);
          this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a(l2);
          this.jdField_a_of_type_Lzk.a(true, false);
          this.jdField_a_of_type_Lzk.c(l2, this.jdField_a_of_type_ComTencentAvCameraCameraUtils.a());
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a().c;
    int i = 0;
    label422:
    String str;
    int j;
    boolean bool2;
    boolean bool3;
    if (i < ((ArrayList)localObject).size())
    {
      lno locallno = (lno)((ArrayList)localObject).get(i);
      str = String.valueOf(locallno.jdField_a_of_type_Long);
      j = locallno.jdField_a_of_type_Int;
      bool2 = locallno.jdField_a_of_type_Boolean;
      bool3 = locallno.jdField_b_of_type_Boolean;
      if ((locallno.jdField_b_of_type_Long != 5L) && (locallno.jdField_b_of_type_Long != 14L)) {
        break label542;
      }
    }
    label542:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!str.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) && (bool3)) {
        this.jdField_a_of_type_Lzk.a(str, j, bool3, bool2, bool1);
      }
      i += 1;
      break label422;
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
    if (this.jdField_a_of_type_Lzk != null) {
      this.jdField_a_of_type_Lzk.x();
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
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().J;
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
    this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentAvVideoController.a().A;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().p;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_f_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_e_of_type_Boolean;
  }
  
  void j()
  {
    if (this.jdField_a_of_type_Mbm == null) {
      this.jdField_a_of_type_Mbm = new lzj(this, this.jdField_a_of_type_AndroidContentContext, 2);
    }
  }
  
  void k()
  {
    if (this.jdField_a_of_type_Mbm != null) {
      this.jdField_a_of_type_Mbm.enable();
    }
  }
  
  void l()
  {
    if (this.jdField_a_of_type_Mbm != null) {
      this.jdField_a_of_type_Mbm.disable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lzf
 * JD-Core Version:    0.7.0.1
 */