package cooperation.qzone.cache;

import android.os.Environment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vfs.VFSRegisterProxy;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class QZoneFilePath
{
  public static final String AUDIO_SAVE_PATH;
  public static final String BACKUP_DIR;
  public static final String BEAUTY_IMG_PATH;
  public static final String CACHE_DIR_FEEDS = VFSAssistantUtils.getSDKPrivatePath("qzone" + File.separator + "feeds");
  public static final String CACHE_DIR_FILE;
  public static final String CACHE_DIR_IMAGE;
  public static final String CACHE_DIR_IMAGE_SR;
  public static final String CACHE_DIR_VIDEO;
  public static final String CACHE_DIR_VIDEO_PLAY;
  public static final String CACHE_DYNAMIC_ALBUM;
  public static final String CACHE_STEP_ON_WIZARD = VFSAssistantUtils.getSDKPrivatePath("Tencent/Qzone/cache");
  public static final String DCIMDir;
  public static final String DCIM_CAMERA_PATH;
  public static final String JCE_DATA_DIR;
  public static final String QQ_EMOTICON_DIR = VFSAssistantUtils.getSDKPrivatePath("Tencent/mobileqq/.emotionsm/");
  public static final String ROOT_PATH = VFSRegisterProxy.a().a();
  public static final String ROOT_QZONE_PATH = VFSAssistantUtils.getSDKPrivatePath("qzone");
  public static final String SERVER_DIR;
  public static final String TESTSERVER_PATH;
  public static final String THUMB_BASE_PATH;
  public static final String TRACE_FILE_PATH;
  public static final String VGIF_SAVE;
  public static final String VIDEO_CONFIG = VFSAssistantUtils.getSDKPrivatePath("Tencent/qzone_video_local_config.json");
  public static final String VIDEO_COVER_TMP_CACHE_DIR;
  public static final String WNS_PATH;
  
  static
  {
    DCIMDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath();
    DCIM_CAMERA_PATH = DCIMDir + File.separator + "Camera";
    VGIF_SAVE = VFSAssistantUtils.getSDKPrivatePath("Tencent/Qzone/AlbumAutoVConvGif/");
    AUDIO_SAVE_PATH = VFSAssistantUtils.getSDKPrivatePath("Tencent/Qzone/VoiceMoodAudio/");
    JCE_DATA_DIR = VFSAssistantUtils.getSDKPrivatePath("jcedata/businessdata/");
    THUMB_BASE_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "qzone" + File.separator + "thumbs" + File.separator);
    VIDEO_COVER_TMP_CACHE_DIR = ROOT_QZONE_PATH + File.separator + "MaxVideo";
    BEAUTY_IMG_PATH = ROOT_PATH + File.separator + "ix.jpg";
    TRACE_FILE_PATH = ROOT_PATH + File.separator + "Tencent" + File.separator + "MobileQQ" + File.separator + "trace";
    SERVER_DIR = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv";
    TESTSERVER_PATH = SERVER_DIR + File.separator + "testserver";
    BACKUP_DIR = ROOT_PATH + File.separator + "Tencent" + File.separator + "qzonebackup";
    WNS_PATH = ROOT_PATH + File.separator + "Tencent" + File.separator + "wns";
    CACHE_DYNAMIC_ALBUM = ROOT_PATH + File.separator + "Tencent/Qzone/qzonedynamicalbum/";
    CACHE_DIR_IMAGE = VFSAssistantUtils.getSDKPrivatePath("qzone" + File.separator + "imageV2");
    CACHE_DIR_VIDEO = VFSAssistantUtils.getSDKPrivatePath("qzone" + File.separator + "video");
    CACHE_DIR_VIDEO_PLAY = VFSAssistantUtils.getSDKPrivatePath("qzone" + File.separator + "video_cache");
    CACHE_DIR_IMAGE_SR = VFSAssistantUtils.getSDKPrivatePath("qzone" + File.separator + "image_sr");
    CACHE_DIR_FILE = VFSAssistantUtils.getSDKPrivatePath("qzone" + File.separator + "file");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.cache.QZoneFilePath
 * JD-Core Version:    0.7.0.1
 */