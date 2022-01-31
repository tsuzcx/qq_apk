import android.media.MediaPlayer.OnCompletionListener;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TipsManager;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.TraeHelper.SoundOutputRes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import com.tencent.sharp.jni.TraeAudioSession.ITraeAudioCallback;
import java.util.Arrays;
import java.util.List;
import mqq.util.WeakReference;

public class khl
  implements TraeAudioSession.ITraeAudioCallback
{
  public khl(TraeHelper paramTraeHelper) {}
  
  public void a(int paramInt)
  {
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().C = paramInt;
    this.a.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a());
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      return;
    }
    this.a.jdField_a_of_type_Int = paramInt2;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().C = paramInt2;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onGetConnectedDeviceRes err is: " + paramInt + " device name is: " + paramString);
    }
    if (TraeHelper.a(this.a) != null) {
      TraeHelper.a(this.a).a(paramString);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDeviceListUpdate onConnectDeviceRes: " + paramString + ", bIsConnected:" + paramBoolean + ",err:" + paramInt);
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c != 3) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().o = paramString;
      }
      this.a.a();
      if (this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) {
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.e();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    if (paramInt != 0) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramInt = 0;
        while (paramInt < paramArrayOfString.length)
        {
          paramString2.append(paramArrayOfString[paramInt]).append(" ");
          paramInt += 1;
        }
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onGetDeviceListRes strDeviceList: " + paramString2.toString());
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().a = paramArrayOfString;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().o = paramString1;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().p = paramString3;
      TraeHelper.a(this.a, paramArrayOfString);
      if (paramArrayOfString != null)
      {
        paramInt = i;
        while (paramInt < paramArrayOfString.length)
        {
          if (paramArrayOfString[paramInt].equals("DEVICE_WIREDHEADSET")) {
            DataReport.l(this.a.jdField_a_of_type_ComTencentAvVideoController);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onBeginConnectDevice connectedDev: " + paramString);
    }
    if (this.a.d != null)
    {
      TipsManager localTipsManager = (TipsManager)this.a.d.get();
      if ((localTipsManager != null) && ("DEVICE_BLUETOOTHHEADSET".equals(paramString)) && (localTipsManager.b != 1002))
      {
        localTipsManager.a(1005);
        localTipsManager.b();
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onAudioRouteSwitchEnd connectedDev: " + paramString + " timsMs: " + paramLong);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onAudioRoteSwitchStart fromDev: " + paramString1 + " toDev: " + paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.a.c)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "ConnectDeviceWhenServiceOn deviceName = " + this.a.c);
      }
      this.a.b(this.a.c);
    }
  }
  
  public void a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      i = 0;
      while (i < paramArrayOfString.length)
      {
        localStringBuilder.append(paramArrayOfString[i]).append(" ");
        i += 1;
      }
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDeviceListUpdate strConnectedDeviceName: " + paramString1 + ", strPrevConnectedDeviceName:" + paramString2 + " bluetoothName : " + paramString3 + " strDeviceList: " + localStringBuilder.toString());
    }
    paramString2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c != 3) {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().o = paramString1;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().a = paramArrayOfString;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().p = paramString3;
    TraeHelper.a(this.a, paramArrayOfString);
    this.a.a();
    if (TraeHelper.a(this.a) != null) {
      TraeHelper.a(this.a).notifyDataSetChanged();
    }
    this.a.a();
    if ((this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) && (paramString2 != null) && (paramArrayOfString != null))
    {
      paramString2 = Arrays.asList(paramString2);
      paramString3 = Arrays.asList(paramArrayOfString);
      if ((paramString3.contains("DEVICE_BLUETOOTHHEADSET")) && (paramString3.contains("DEVICE_WIREDHEADSET")))
      {
        if ((!paramString2.contains("DEVICE_BLUETOOTHHEADSET")) || (paramString2.contains("DEVICE_WIREDHEADSET"))) {
          break label373;
        }
        if ("DEVICE_BLUETOOTHHEADSET".equals(paramString1)) {
          this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a("DEVICE_WIREDHEADSET");
        }
      }
    }
    while (paramArrayOfString != null)
    {
      i = j;
      while (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].equals("DEVICE_WIREDHEADSET")) {
          DataReport.l(this.a.jdField_a_of_type_ComTencentAvVideoController);
        }
        i += 1;
      }
      label373:
      if ((!paramString2.contains("DEVICE_BLUETOOTHHEADSET")) && (paramString2.contains("DEVICE_WIREDHEADSET")) && ("DEVICE_WIREDHEADSET".equals(paramString1))) {
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a("DEVICE_BLUETOOTHHEADSET");
      }
    }
    if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().u.equals("DEVICE_NONE"))
    {
      if (!paramString1.equals(this.a.jdField_a_of_type_ComTencentAvVideoController.a().u)) {
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a().u);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().u = "DEVICE_NONE";
    }
    if (TraeHelper.a(this.a) != null)
    {
      TraeHelper.a(this.a).a(null, new TraeHelper.SoundOutputRes(paramArrayOfString));
      if (this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) {
        this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.e();
      }
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.a.jdField_a_of_type_JavaLangString, 2, "onGetConnectingDeviceRes strDeviceName: " + paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    Button localButton;
    do
    {
      int i;
      do
      {
        return;
        i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().d;
      } while (((i == 1) || (i == 2)) && ((!this.a.jdField_a_of_type_ComTencentAvVideoController.b()) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().f()) || (this.a.b == null)));
      localButton = (Button)this.a.b.get();
    } while ((localButton == null) || (paramBoolean == localButton.isClickable()));
    localButton.setClickable(paramBoolean);
  }
  
  public void c(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener != null)
    {
      paramString = this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
      this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = null;
      paramString.onCompletion(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khl
 * JD-Core Version:    0.7.0.1
 */