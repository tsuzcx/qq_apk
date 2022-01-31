import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ljh
  implements Handler.Callback, ljn
{
  public int a;
  public Handler a;
  public VideoAppInterface a;
  public AVRedPacketManager a;
  public AVActivity a;
  public Handler b = new Handler(ThreadManager.getFileThreadLooper(), this);
  
  public ljh(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = ((AVRedPacketManager)paramVideoAppInterface.a(6));
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this);
  }
  
  private RedPacketGameView a()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131299757);
    Object localObject1 = null;
    Object localObject2;
    View localView;
    if (localViewGroup != null)
    {
      localObject2 = (RedPacketGameView)localViewGroup.findViewById(2131306744);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new RedPacketGameView(localViewGroup.getContext(), this.jdField_a_of_type_ComTencentAvUiAVActivity);
        if (this.jdField_a_of_type_ComTencentAvUiAVActivity.a != null) {
          break label114;
        }
        i = 0;
        ((RedPacketGameView)localObject1).setScoreMarginTop(i);
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        localView = localViewGroup.findViewById(2131306713);
        if (localView == null) {
          break label128;
        }
      }
    }
    label128:
    for (int i = localViewGroup.indexOfChild(localView);; i = -1)
    {
      localViewGroup.addView((View)localObject1, i, (ViewGroup.LayoutParams)localObject2);
      return localObject1;
      label114:
      i = this.jdField_a_of_type_ComTencentAvUiAVActivity.a.e();
      break;
    }
  }
  
  private void c(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    int i = 3;
    paramLocalFrameSyncInfo = paramLocalFrameSyncInfo.localHitInfo;
    if (paramLocalFrameSyncInfo.topWordTipType == 1) {}
    for (;;)
    {
      if (i != -1) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(i, false);
      }
      if (paramLocalFrameSyncInfo.comboCnt > 0) {
        this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(6, false);
      }
      return;
      if (paramLocalFrameSyncInfo.topWordTipType == 2) {
        i = 2;
      } else if (paramLocalFrameSyncInfo.topWordTipType == 3) {
        i = 4;
      } else if (paramLocalFrameSyncInfo.topWordTipType == 4) {
        i = 5;
      } else {
        i = -1;
      }
    }
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_Int != -1;
  }
  
  private void h()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131299757);
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)localViewGroup.findViewById(2131306744);
    if (localRedPacketGameView != null)
    {
      localRedPacketGameView.e();
      localViewGroup.removeView(localRedPacketGameView);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.onGameFinish," + this.jdField_a_of_type_Int);
    }
    if (!c()) {}
    while (this.jdField_a_of_type_Int == 5) {
      return;
    }
    this.jdField_a_of_type_Int = 5;
    c();
    h();
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.showGameRunning, " + this.jdField_a_of_type_Int + "," + paramInt);
    }
    if (!c()) {}
    while (this.jdField_a_of_type_Int == 4) {
      return;
    }
    this.jdField_a_of_type_Int = 4;
    c();
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744);
    localRedPacketGameView.setVisibility(0);
    localRedPacketGameView.b(false);
    if (paramInt == 2) {
      localRedPacketGameView.c();
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(7, true);
  }
  
  public void a(int paramInt, List<AVRedPacketManager.LocalEmojiInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.showGameReady, " + this.jdField_a_of_type_Int + "," + paramInt);
    }
    if (!a()) {}
    while (this.jdField_a_of_type_Int == 3) {
      return;
    }
    this.jdField_a_of_type_Int = 3;
    c();
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744);
    localRedPacketGameView.setVisibility(0);
    localRedPacketGameView.a(paramInt, paramList);
  }
  
  public void a(int paramInt, ljo paramljo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.preLoadRes,mState = " + this.jdField_a_of_type_Int + ",type = " + paramInt + ",manager = " + this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager);
    }
    try
    {
      long l1 = System.currentTimeMillis();
      RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744);
      if (localRedPacketGameView != null) {
        localRedPacketGameView.a(this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager);
      }
      for (boolean bool = true;; bool = false)
      {
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.preLoadRes,suc = " + bool + ",type = " + paramInt + ",cost = " + (l2 - l1));
        }
        if (paramljo == null) {
          break;
        }
        paramljo.a(bool, paramInt);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.preLoadRes  not init");
        }
      }
      return;
    }
    catch (Exception paramljo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.preLoadRes  exception", paramljo);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!a()) {}
    RedPacketGameView localRedPacketGameView;
    do
    {
      return;
      localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744);
      if (paramInt == AVRedPacketManager.jdField_a_of_type_Int)
      {
        localRedPacketGameView.b(paramBoolean);
        return;
      }
      if (paramInt == AVRedPacketManager.b)
      {
        localRedPacketGameView.c(paramBoolean);
        return;
      }
      if (paramInt == AVRedPacketManager.c)
      {
        localRedPacketGameView.d(paramBoolean);
        return;
      }
    } while (paramInt != AVRedPacketManager.d);
    localRedPacketGameView.e(paramBoolean);
  }
  
  public void a(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.onEmojiHit, " + this.jdField_a_of_type_Int + ",localFrameSyncInfo=" + paramLocalFrameSyncInfo);
    }
    if (!c()) {
      return;
    }
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744);
    localRedPacketGameView.setVisibility(0);
    localRedPacketGameView.a(paramLocalFrameSyncInfo);
    c(paramLocalFrameSyncInfo);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    Object localObject = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744);
    if (this.jdField_a_of_type_Int == -1)
    {
      RedPacketGameView localRedPacketGameView = a();
      localObject = localRedPacketGameView;
      if (localRedPacketGameView != null)
      {
        this.jdField_a_of_type_Int = 1;
        localObject = localRedPacketGameView;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "initUI," + this.jdField_a_of_type_Int + "," + localObject);
    }
    return localObject != null;
  }
  
  public void b()
  {
    if (!c()) {
      return;
    }
    ((RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744)).d();
  }
  
  public void b(AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.onUpdateFrameInfo, " + this.jdField_a_of_type_Int + "," + paramLocalFrameSyncInfo);
    }
    if (!c()) {
      return;
    }
    ((RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744)).b(paramLocalFrameSyncInfo);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int != -1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Int == -1) {}
    while ((b()) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.d("AVRedPacketManager", 2, "gameMode");
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.showRedPacketSend, " + this.jdField_a_of_type_Int);
    }
    if (!a()) {}
    while (this.jdField_a_of_type_Int == 2) {
      return;
    }
    this.jdField_a_of_type_Int = 2;
    c();
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744);
    localRedPacketGameView.setVisibility(0);
    localRedPacketGameView.a();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.showRedPacketCome, " + this.jdField_a_of_type_Int);
    }
    if (!a()) {}
    while (this.jdField_a_of_type_Int == 2) {
      return;
    }
    this.jdField_a_of_type_Int = 2;
    c();
    RedPacketGameView localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744);
    localRedPacketGameView.setVisibility(0);
    localRedPacketGameView.b();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketManager", 2, "AVRedPacketGameControl.showReceiverUserGuide, " + this.jdField_a_of_type_Int);
    }
    if (!a()) {}
    RedPacketGameView localRedPacketGameView;
    do
    {
      return;
      localRedPacketGameView = (RedPacketGameView)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131306744);
    } while (localRedPacketGameView == null);
    localRedPacketGameView.f();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager != null) {
      this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ljh
 * JD-Core Version:    0.7.0.1
 */