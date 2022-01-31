import android.media.MediaPlayer;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class lub
  implements mnu
{
  private int jdField_a_of_type_Int;
  public MediaPlayer a;
  public VideoController a;
  public VideoAppInterface a;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  public luf a;
  public luh a;
  private mnf jdField_a_of_type_Mnf;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public lub(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    QLog.i("AVRedPacketMusicPlayer", 1, "AVRedPacketMusicPlayer usePcm=" + paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.b = paramBoolean;
    if (!min.f())
    {
      QLog.i("AVRedPacketMusicPlayer", 1, "AVRedPacketMusicPlayer system not support, using mp3");
      this.b = false;
    }
  }
  
  private String a(int paramInt)
  {
    moy localmoy = mpv.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    if (!localmoy.c) {
      return null;
    }
    switch (paramInt)
    {
    case 6: 
    default: 
      return null;
    case 1: 
      return a(localmoy.b, "321go");
    case 2: 
      return a(localmoy.b, "cool");
    case 3: 
      return a(localmoy.b, "perfect");
    case 4: 
      return a(localmoy.b, "miss");
    case 5: 
      return a(localmoy.b, "excellent");
    }
    return a(localmoy.b, "background" + this.jdField_a_of_type_Int);
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString2 = new StringBuilder().append(paramString1).append(paramString2);
    if (this.b) {}
    for (paramString1 = ".pcm";; paramString1 = ".mp3") {
      return paramString1;
    }
  }
  
  public void a()
  {
    try
    {
      if (this.b)
      {
        this.jdField_a_of_type_ComTencentAvVideoController.a().E = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a(1, null);
        QLog.i("AVRedPacketMusicPlayer", 1, "release unregisterDAudioDataCallbackAll, mix=" + this.jdField_a_of_type_ComTencentAvVideoController.a().D);
        int i = this.jdField_a_of_type_ComTencentAvVideoController.b(3, this.jdField_a_of_type_ComTencentAvVideoController.a().D);
        QLog.i("AVRedPacketMusicPlayer", 1, "release unregisterDAudioDataCallbackAll, ret3=" + i);
        this.jdField_a_of_type_ComTencentAvVideoController.a().D = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a().C = false;
        if (this.jdField_a_of_type_Mnf != null) {
          this.jdField_a_of_type_Mnf.c();
        }
        this.jdField_a_of_type_Mnf = null;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList = null;
        this.jdField_a_of_type_Boolean = false;
        return;
        if (this.jdField_a_of_type_Luf != null)
        {
          this.jdField_a_of_type_Luf.a();
          this.jdField_a_of_type_Luf = null;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
          this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
          this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AVRedPacketMusicPlayer", 1, "setGameFinish exception", localException);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.b) {
      if (this.jdField_a_of_type_Mnf != null)
      {
        if (paramInt != 7) {
          break label28;
        }
        this.jdField_a_of_type_Mnf.a();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Mnf.b();
        return;
        if (paramInt != 7) {
          break;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AVRedPacketMusicPlayer", 2, "stopMusic, mediaPlayer is null");
      return;
      if (this.jdField_a_of_type_Luf != null)
      {
        String str = a(paramInt);
        this.jdField_a_of_type_Luf.a(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketMusicPlayer", 2, "stopMusic, soundPoolHelper is null");
  }
  
  public void a(int paramInt, moy parammoy)
  {
    if ((parammoy == null) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController == null))
    {
      QLog.i("AVRedPacketMusicPlayer", 1, "init ,configInfo == null || mHasInit || mVideoController == null");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    String str1 = a(parammoy.b, "321go");
    String str2 = a(parammoy.b, "cool");
    String str3 = a(parammoy.b, "perfect");
    String str4 = a(parammoy.b, "miss");
    String str5 = a(parammoy.b, "excellent");
    parammoy = a(parammoy.b, "background" + this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("AVRedPacketMusicPlayer", 2, "init ,bgFilePath = " + parammoy);
    }
    if (this.b)
    {
      this.jdField_a_of_type_Mnf = new mnf(4096);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
      this.jdField_a_of_type_JavaUtilArrayList.add(str1);
      this.jdField_a_of_type_JavaUtilArrayList.add(str2);
      this.jdField_a_of_type_JavaUtilArrayList.add(str3);
      this.jdField_a_of_type_JavaUtilArrayList.add(str4);
      this.jdField_a_of_type_JavaUtilArrayList.add(str5);
      this.jdField_a_of_type_JavaUtilArrayList.add(parammoy);
      this.jdField_a_of_type_ComTencentAvVideoController.a(1, this);
      this.jdField_a_of_type_ComTencentAvVideoController.a().E = true;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().A)
      {
        paramInt = this.jdField_a_of_type_ComTencentAvVideoController.a(3, true);
        i = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
        QLog.d("AVRedPacketMusicPlayer", 1, "init, registerDAudioDataCallback, mix = true, ret3=" + paramInt + ", set3=" + i);
        this.jdField_a_of_type_ComTencentAvVideoController.a().C = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().D = true;
        return;
      }
      paramInt = this.jdField_a_of_type_ComTencentAvVideoController.a(3, false);
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
      QLog.d("AVRedPacketMusicPlayer", 1, "init, registerDAudioDataCallback, mix = false, ret3=" + paramInt + ", set3=" + i);
      this.jdField_a_of_type_ComTencentAvVideoController.a().C = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().D = false;
      return;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(0);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(parammoy);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketMusicPlayer", 2, "init, mediaPlayer.prepare cost = " + (l2 - l1));
      }
      parammoy = new ArrayList();
      parammoy.add(str1);
      parammoy.add(str2);
      parammoy.add(str3);
      parammoy.add(str4);
      parammoy.add(str5);
      this.jdField_a_of_type_Luf = new luf(parammoy, 0);
      return;
    }
    catch (Exception parammoy)
    {
      for (;;)
      {
        QLog.e("AVRedPacketMusicPlayer", 1, "init  exception", parammoy);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketMusicPlayer", 2, "playMusic, musicType = " + paramInt + ",loop = " + paramBoolean);
    }
    String str;
    if (this.b) {
      if (this.jdField_a_of_type_Mnf != null)
      {
        str = a(paramInt);
        if (paramInt != 7) {
          break label75;
        }
        this.jdField_a_of_type_Mnf.a(str);
      }
    }
    label75:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Mnf.b(str);
        return;
        if (paramInt != 7) {
          break;
        }
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
        {
          this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AVRedPacketMusicPlayer", 2, "playMusic, mediaPlayer is null");
      return;
      if (this.jdField_a_of_type_Luf != null)
      {
        str = a(paramInt);
        this.jdField_a_of_type_Luf.a(str, paramBoolean);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketMusicPlayer", 2, "playMusic, soundPoolHelper is null");
  }
  
  public void a(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public void a(luh paramluh)
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.i("AVRedPacketMusicPlayer", 1, "preloadMusic MusicPlayer not init, return");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Luh = paramluh;
        if (!this.b) {
          break;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Mnf != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          paramluh = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramluh.hasNext())
          {
            String str = (String)paramluh.next();
            this.jdField_a_of_type_Mnf.a(str);
          }
        }
      } while (this.jdField_a_of_type_Luh == null);
      this.jdField_a_of_type_Luh.a();
      return;
    } while (this.jdField_a_of_type_Luf == null);
    this.jdField_a_of_type_Luf.a(new luc(this));
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.b) && (this.jdField_a_of_type_Mnf != null)) {
      this.jdField_a_of_type_Mnf.a(paramArrayOfByte, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lub
 * JD-Core Version:    0.7.0.1
 */