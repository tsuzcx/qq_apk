import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper.TraeAudioCallback.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioSession;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

public class mui
  implements bjlo
{
  mui(mua parammua) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {}
    while (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    this.a.jdField_a_of_type_Int = paramInt2;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().C = paramInt2;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraeSessionHelper", 2, "onGetConnectedDeviceRes err is: " + paramInt + " device name is: " + paramString);
    }
    if (mua.a(this.a) != null) {
      mua.a(this.a).a(paramString);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("TraeSessionHelper", 1, "onConnectDeviceRes, err[" + paramInt + "], strDeviceName[" + paramString + "], bIsConnected[" + paramBoolean + "], seq[" + l + "]");
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentAvVideoController == null)) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c != 3) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().b("onConnectDeviceRes", paramString);
      }
      this.a.a();
    } while (this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null);
    this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(l);
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
        QLog.d("TraeSessionHelper", 2, "onGetDeviceListRes strDeviceList: " + paramString2.toString());
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        paramString2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().q;
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().a = paramArrayOfString;
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().b("onGetDeviceListRes", paramString1);
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().r = paramString3;
        mua.a(this.a, paramArrayOfString);
        mua.a(this.a, paramString2, paramString1);
        if (paramArrayOfString != null)
        {
          paramInt = i;
          while (paramInt < paramArrayOfString.length)
          {
            if (paramArrayOfString[paramInt].equals("DEVICE_WIREDHEADSET")) {
              mrd.k(this.a.jdField_a_of_type_ComTencentAvVideoController);
            }
            paramInt += 1;
          }
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    this.a.jdField_a_of_type_Int = paramInt;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().C = paramInt;
    if (QLog.isColorLevel()) {
      QLog.w("TraeSessionHelper", 1, "onStreamTypeUpdate, streamType[" + paramInt + "], seq[" + paramLong + "]");
    }
    this.a.a(paramLong, this.a.jdField_a_of_type_ComTencentAvVideoController.a());
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    MediaPlayer.OnCompletionListener localOnCompletionListener = this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
    this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = null;
    QLog.w("TraeSessionHelper", 1, "onRingCompletion, err[" + paramInt + "], userData[" + paramString + "], mRingComListener[" + localOnCompletionListener + "], seq[" + paramLong + "]");
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().a().post(new TraeHelper.TraeAudioCallback.1(this, localOnCompletionListener));
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeSessionHelper", 1, "ConnectDeviceWhenServiceOn, deviceName[" + this.a.jdField_b_of_type_JavaLangString + "], seq[" + paramLong + "]");
      }
      this.a.a(paramLong, this.a.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void a(long paramLong, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    int j = 0;
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      i = 0;
      while (i < paramArrayOfString.length)
      {
        ((StringBuilder)localObject).append(paramArrayOfString[i]).append(" ");
        i += 1;
      }
      QLog.w("TraeSessionHelper", 1, "onDeviceListUpdate, strConnectedDeviceName[" + paramString1 + "], strPrevConnectedDeviceName[" + paramString2 + "], bluetoothName[" + paramString3 + "], strDeviceList[" + ((StringBuilder)localObject).toString() + "], seq[" + paramLong + "]");
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {}
    label393:
    do
    {
      do
      {
        return;
        localObject = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
        paramString2 = "";
        String[] arrayOfString = ((lez)localObject).a;
        if (((lez)localObject).c != 3)
        {
          paramString2 = ((lez)localObject).q;
          ((lez)localObject).b("onDeviceListUpdate", paramString1);
        }
        ((lez)localObject).a = paramArrayOfString;
        ((lez)localObject).r = paramString3;
        mua.a(this.a, paramArrayOfString);
        mua.a(this.a, paramString2, paramString1);
        if (mua.a(this.a) != null) {
          mua.a(this.a).notifyDataSetChanged();
        }
        this.a.a();
        if ((this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession != null) && (arrayOfString != null) && (paramArrayOfString != null))
        {
          paramString2 = Arrays.asList(arrayOfString);
          paramString3 = Arrays.asList(paramArrayOfString);
          if ((paramString3.contains("DEVICE_BLUETOOTHHEADSET")) && (paramString3.contains("DEVICE_WIREDHEADSET")))
          {
            if ((!paramString2.contains("DEVICE_BLUETOOTHHEADSET")) || (paramString2.contains("DEVICE_WIREDHEADSET"))) {
              break label393;
            }
            if ("DEVICE_BLUETOOTHHEADSET".equals(paramString1)) {
              this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramLong, "DEVICE_WIREDHEADSET");
            }
          }
        }
        while (paramArrayOfString != null)
        {
          i = j;
          while (i < paramArrayOfString.length)
          {
            if (paramArrayOfString[i].equals("DEVICE_WIREDHEADSET")) {
              mrd.k(this.a.jdField_a_of_type_ComTencentAvVideoController);
            }
            i += 1;
          }
          if ((!paramString2.contains("DEVICE_BLUETOOTHHEADSET")) && (paramString2.contains("DEVICE_WIREDHEADSET")) && ("DEVICE_WIREDHEADSET".equals(paramString1))) {
            this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramLong, "DEVICE_BLUETOOTHHEADSET");
          }
        }
        if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().t.equals("DEVICE_NONE"))
        {
          if (!paramString1.equals(this.a.jdField_a_of_type_ComTencentAvVideoController.a().t)) {
            this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.a(paramLong, this.a.jdField_a_of_type_ComTencentAvVideoController.a().t);
          }
          this.a.jdField_a_of_type_ComTencentAvVideoController.a().t = "DEVICE_NONE";
        }
      } while (mua.a(this.a) == null);
      mua.a(this.a).a(null, new mug(paramArrayOfString));
    } while (this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession == null);
    this.a.jdField_a_of_type_ComTencentSharpJniTraeAudioSession.b(paramLong);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraeSessionHelper", 2, "onBeginConnectDevice connectedDev: " + paramString);
    }
    if ("DEVICE_BLUETOOTHHEADSET".equals(paramString)) {
      mak.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 3012);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraeSessionHelper", 2, "onAudioRouteSwitchEnd connectedDev: " + paramString + " timsMs: " + paramLong);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraeSessionHelper", 2, "onAudioRoteSwitchStart fromDev: " + paramString1 + " toDev: " + paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
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
      } while (((i == 1) || (i == 2)) && ((!this.a.jdField_a_of_type_ComTencentAvVideoController.e()) || (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().l()) || (this.a.jdField_b_of_type_JavaLangRefWeakReference == null)));
      localButton = (Button)this.a.jdField_b_of_type_JavaLangRefWeakReference.get();
    } while ((localButton == null) || (paramBoolean == localButton.isClickable()));
    localButton.setClickable(paramBoolean);
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TraeSessionHelper", 2, "onGetConnectingDeviceRes strDeviceName: " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mui
 * JD-Core Version:    0.7.0.1
 */