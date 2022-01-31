import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class mre
{
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GAudioSoundUtil", 2, "[sound_early] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/qav/sound_early/";
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GAudioSoundUtil", 2, "[sound_early] trigger early download");
    }
    Object localObject2 = a();
    Object localObject1 = new File((String)localObject2, "qav_gaudio_muted.mp3");
    File localFile = new File((String)localObject2, "qav_gaudio_cancel_muted.mp3");
    localObject2 = new File((String)localObject2, "qav_peer_phone_calling.mp3");
    if ((!((File)localObject1).exists()) || (!localFile.exists()) || (!((File)localObject2).exists()))
    {
      localObject1 = new Intent("tencent.video.v2q.downloadGAudioSound");
      ((Intent)localObject1).setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast((Intent)localObject1);
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(a(), paramString).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mre
 * JD-Core Version:    0.7.0.1
 */