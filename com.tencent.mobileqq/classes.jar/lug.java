import android.media.MediaPlayer;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class lug
  implements moq
{
  private int jdField_a_of_type_Int;
  public MediaPlayer a;
  public VideoController a;
  public VideoAppInterface a;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  public luk a;
  public lum a;
  private mob jdField_a_of_type_Mob;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public lug(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    QLog.i("AVRedPacketMusicPlayer", 1, "AVRedPacketMusicPlayer usePcm=" + paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.b = paramBoolean;
    if (!mjd.f())
    {
      QLog.i("AVRedPacketMusicPlayer", 1, "AVRedPacketMusicPlayer system not support, using mp3");
      this.b = false;
    }
  }
  
  private String a(int paramInt)
  {
    mpu localmpu = mqr.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
    if (!localmpu.c) {
      return null;
    }
    switch (paramInt)
    {
    case 6: 
    default: 
      return null;
    case 1: 
      return a(localmpu.b, "321go");
    case 2: 
      return a(localmpu.b, "cool");
    case 3: 
      return a(localmpu.b, "perfect");
    case 4: 
      return a(localmpu.b, "miss");
    case 5: 
      return a(localmpu.b, "excellent");
    }
    return a(localmpu.b, "background" + this.jdField_a_of_type_Int);
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
        this.jdField_a_of_type_ComTencentAvVideoController.a().F = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a(1, null);
        QLog.i("AVRedPacketMusicPlayer", 1, "release unregisterAudioDataCallbackAll, mix=" + this.jdField_a_of_type_ComTencentAvVideoController.a().E);
        int i = this.jdField_a_of_type_ComTencentAvVideoController.b(3, this.jdField_a_of_type_ComTencentAvVideoController.a().E);
        QLog.i("AVRedPacketMusicPlayer", 1, "release unregisterAudioDataCallbackAll, ret3=" + i);
        this.jdField_a_of_type_ComTencentAvVideoController.a().E = false;
        this.jdField_a_of_type_ComTencentAvVideoController.a().D = false;
        if (this.jdField_a_of_type_Mob != null) {
          this.jdField_a_of_type_Mob.c();
        }
        this.jdField_a_of_type_Mob = null;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilArrayList = null;
        this.jdField_a_of_type_Boolean = false;
        return;
        if (this.jdField_a_of_type_Luk != null)
        {
          this.jdField_a_of_type_Luk.a();
          this.jdField_a_of_type_Luk = null;
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
      if (this.jdField_a_of_type_Mob != null)
      {
        if (paramInt != 7) {
          break label28;
        }
        this.jdField_a_of_type_Mob.a();
      }
    }
    label28:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Mob.b();
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
      if (this.jdField_a_of_type_Luk != null)
      {
        String str = a(paramInt);
        this.jdField_a_of_type_Luk.a(str);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketMusicPlayer", 2, "stopMusic, soundPoolHelper is null");
  }
  
  public void a(int paramInt, mpu parammpu)
  {
    if ((parammpu == null) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvVideoController == null))
    {
      QLog.i("AVRedPacketMusicPlayer", 1, "init ,configInfo == null || mHasInit || mVideoController == null");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
    String str1 = a(parammpu.b, "321go");
    String str2 = a(parammpu.b, "cool");
    String str3 = a(parammpu.b, "perfect");
    String str4 = a(parammpu.b, "miss");
    String str5 = a(parammpu.b, "excellent");
    parammpu = a(parammpu.b, "background" + this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("AVRedPacketMusicPlayer", 2, "init ,bgFilePath = " + parammpu);
    }
    if (this.b)
    {
      this.jdField_a_of_type_Mob = new mob(4096);
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
      this.jdField_a_of_type_JavaUtilArrayList.add(str1);
      this.jdField_a_of_type_JavaUtilArrayList.add(str2);
      this.jdField_a_of_type_JavaUtilArrayList.add(str3);
      this.jdField_a_of_type_JavaUtilArrayList.add(str4);
      this.jdField_a_of_type_JavaUtilArrayList.add(str5);
      this.jdField_a_of_type_JavaUtilArrayList.add(parammpu);
      this.jdField_a_of_type_ComTencentAvVideoController.a(1, this);
      this.jdField_a_of_type_ComTencentAvVideoController.a().F = true;
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().B)
      {
        paramInt = this.jdField_a_of_type_ComTencentAvVideoController.a(3, true);
        i = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
        QLog.d("AVRedPacketMusicPlayer", 1, "init, registerAudioDataCallback, mix = true, ret3=" + paramInt + ", set3=" + i);
        this.jdField_a_of_type_ComTencentAvVideoController.a().D = true;
        this.jdField_a_of_type_ComTencentAvVideoController.a().E = true;
        return;
      }
      paramInt = this.jdField_a_of_type_ComTencentAvVideoController.a(3, false);
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a(3, 48000, 1, 16);
      QLog.d("AVRedPacketMusicPlayer", 1, "init, registerAudioDataCallback, mix = false, ret3=" + paramInt + ", set3=" + i);
      this.jdField_a_of_type_ComTencentAvVideoController.a().D = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().E = false;
      return;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(0);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(parammpu);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(true);
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketMusicPlayer", 2, "init, mediaPlayer.prepare cost = " + (l2 - l1));
      }
      parammpu = new ArrayList();
      parammpu.add(str1);
      parammpu.add(str2);
      parammpu.add(str3);
      parammpu.add(str4);
      parammpu.add(str5);
      this.jdField_a_of_type_Luk = new luk(parammpu, 0);
      return;
    }
    catch (Exception parammpu)
    {
      for (;;)
      {
        QLog.e("AVRedPacketMusicPlayer", 1, "init  exception", parammpu);
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
      if (this.jdField_a_of_type_Mob != null)
      {
        str = a(paramInt);
        if (paramInt != 7) {
          break label75;
        }
        this.jdField_a_of_type_Mob.a(str);
      }
    }
    label75:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Mob.b(str);
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
      if (this.jdField_a_of_type_Luk != null)
      {
        str = a(paramInt);
        this.jdField_a_of_type_Luk.a(str, paramBoolean);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AVRedPacketMusicPlayer", 2, "playMusic, soundPoolHelper is null");
  }
  
  public void a(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public void a(lum paramlum)
  {
    if (!this.jdField_a_of_type_Boolean) {
      QLog.i("AVRedPacketMusicPlayer", 1, "preloadMusic MusicPlayer not init, return");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Lum = paramlum;
        if (!this.b) {
          break;
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Mob != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          paramlum = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramlum.hasNext())
          {
            String str = (String)paramlum.next();
            this.jdField_a_of_type_Mob.a(str);
          }
        }
      } while (this.jdField_a_of_type_Lum == null);
      this.jdField_a_of_type_Lum.a();
      return;
    } while (this.jdField_a_of_type_Luk == null);
    this.jdField_a_of_type_Luk.a(new luh(this));
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.b) && (this.jdField_a_of_type_Mob != null)) {
      this.jdField_a_of_type_Mob.a(paramArrayOfByte, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lug
 * JD-Core Version:    0.7.0.1
 */