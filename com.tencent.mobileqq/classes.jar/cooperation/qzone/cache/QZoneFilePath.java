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
  public static final String CACHE_DIR_FEEDS;
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
  public static final String ROOT_PATH = VFSRegisterProxy.a().b();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DCIMDir);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Camera");
    DCIM_CAMERA_PATH = localStringBuilder.toString();
    VGIF_SAVE = VFSAssistantUtils.getSDKPrivatePath("Tencent/Qzone/AlbumAutoVConvGif/");
    AUDIO_SAVE_PATH = VFSAssistantUtils.getSDKPrivatePath("Tencent/Qzone/VoiceMoodAudio/");
    JCE_DATA_DIR = VFSAssistantUtils.getSDKPrivatePath("jcedata/businessdata/");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("qzone");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    THUMB_BASE_PATH = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ROOT_QZONE_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("MaxVideo");
    VIDEO_COVER_TMP_CACHE_DIR = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ROOT_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ix.jpg");
    BEAUTY_IMG_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ROOT_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("MobileQQ");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("trace");
    TRACE_FILE_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/testEnv");
    SERVER_DIR = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(SERVER_DIR);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("testserver");
    TESTSERVER_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ROOT_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("qzonebackup");
    BACKUP_DIR = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ROOT_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("wns");
    WNS_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(ROOT_PATH);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Tencent/Qzone/qzonedynamicalbum/");
    CACHE_DYNAMIC_ALBUM = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("imageV2");
    CACHE_DIR_IMAGE = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("video");
    CACHE_DIR_VIDEO = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("video_cache");
    CACHE_DIR_VIDEO_PLAY = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("image_sr");
    CACHE_DIR_IMAGE_SR = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("file");
    CACHE_DIR_FILE = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("qzone");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("feeds");
    CACHE_DIR_FEEDS = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.cache.QZoneFilePath
 * JD-Core Version:    0.7.0.1
 */