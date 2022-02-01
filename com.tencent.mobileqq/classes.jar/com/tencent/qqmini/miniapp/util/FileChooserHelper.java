package com.tencent.qqmini.miniapp.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qqmini.miniapp.R.string;
import com.tencent.qqmini.sdk.core.utils.ShortVideoUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.qqmini.sdk.widget.actionsheet.ActionSheet;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import java.io.File;
import java.util.List;

public class FileChooserHelper
{
  private static final String CAMCORDER = "camcorder";
  private static final String CAMERA = "camera";
  private static final String MICROPHONE = "microphone";
  private static final String PHOTO_PREFIX = "IMG_";
  private static final String PHOTO_SUFFIX = ".jpg";
  private static final String TAG = "FileChooserHelper";
  private static final String TYPE_ANYTHING = "*/*";
  private static final String TYPE_AUDIO = "audio/";
  private static final String TYPE_IMAGE = "image/";
  private static final String TYPE_VIDEO = "video/";
  private static final String VIDEO_PREFIX = "VID_";
  private static final String VIDEO_SUFFIX = ".mp4";
  private Uri mFileGenerationUri;
  private ValueCallback<Uri[]> mFilePathCallBackForLollipop;
  private ValueCallback<Uri> mFilePathCallback;
  private int mRequestCode;
  
  private void doCallbackWhenChooseFileFailed()
  {
    ValueCallback localValueCallback = this.mFilePathCallback;
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(Uri.EMPTY);
      this.mRequestCode = -2147483648;
      this.mFilePathCallback = null;
      this.mFileGenerationUri = null;
    }
    localValueCallback = this.mFilePathCallBackForLollipop;
    if (localValueCallback != null)
    {
      localValueCallback.onReceiveValue(null);
      this.mFilePathCallBackForLollipop = null;
      this.mFileGenerationUri = null;
      this.mRequestCode = -2147483648;
    }
  }
  
  private void doCaptureCorrect(Activity paramActivity, String paramString1, String paramString2)
  {
    ActionSheet localActionSheet = ActionSheet.create(paramActivity);
    localActionSheet.setOnDismissListener(new FileChooserHelper.1(this));
    localActionSheet.setOnCancelListener(new FileChooserHelper.2(this));
    if (paramString2.equals("camera"))
    {
      localActionSheet.addButton(paramActivity.getString(R.string.mini_sdk_take_a_picture), 0);
      localActionSheet.addButton(paramActivity.getString(R.string.mini_sdk_file_browser_title), 0);
      localActionSheet.setOnButtonClickListener(new FileChooserHelper.3(this, paramActivity, paramString1, localActionSheet));
    }
    else if (paramString2.equals("camcorder"))
    {
      localActionSheet.addButton(paramActivity.getString(R.string.mini_sdk_send_video_by_camera), 0);
      localActionSheet.addButton(paramActivity.getString(R.string.mini_sdk_file_browser_title), 0);
      localActionSheet.setOnButtonClickListener(new FileChooserHelper.4(this, paramActivity, paramString1, localActionSheet));
    }
    else if (paramString2.equals("microphone"))
    {
      localActionSheet.addButton(paramActivity.getString(R.string.mini_sdk_record_sound), 0);
      localActionSheet.addButton(paramActivity.getString(R.string.mini_sdk_file_browser_title), 0);
      localActionSheet.setOnButtonClickListener(new FileChooserHelper.5(this, paramActivity, paramString1, localActionSheet));
    }
    localActionSheet.show();
  }
  
  private String getCapture(String paramString1, String paramString2)
  {
    if (paramString1.contains("image/")) {
      return "camera";
    }
    if (paramString1.contains("video/")) {
      return "camcorder";
    }
    if (paramString1.contains("audio/")) {
      paramString2 = "microphone";
    }
    return paramString2;
  }
  
  private boolean isCaptureCorrect(String paramString)
  {
    return ("camera".equals(paramString)) || ("camcorder".equals(paramString)) || ("microphone".equals(paramString));
  }
  
  private void openCamcorder(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ShortVideoUtil.getCameraPath());
    ((StringBuilder)localObject).append("photo/");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      doCallbackWhenChooseFileFailed();
      MiniToast.makeText(paramActivity, 1, paramActivity.getString(R.string.mini_sdk_cant_create_file), 0).show();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VID_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".mp4");
    this.mFileGenerationUri = Uri.fromFile(new File((File)localObject, localStringBuilder.toString()));
    localObject = new Intent("android.media.action.VIDEO_CAPTURE");
    ((Intent)localObject).putExtra("output", this.mFileGenerationUri);
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 1);
    startActivityForResultInSafe(paramActivity, (Intent)localObject, R.string.mini_sdk_camera_can_not_start);
  }
  
  private void openCamera(Activity paramActivity)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ShortVideoUtil.getCameraPath());
    ((StringBuilder)localObject).append("photo/");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
    {
      doCallbackWhenChooseFileFailed();
      MiniToast.makeText(paramActivity, 1, paramActivity.getString(R.string.mini_sdk_cant_create_file), 0).show();
      return;
    }
    Intent localIntent = new Intent();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IMG_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".jpg");
    this.mFileGenerationUri = FileProviderUtils.setSystemCapture(paramActivity, new File((File)localObject, localStringBuilder.toString()), localIntent);
    startActivityForResultInSafe(paramActivity, localIntent, R.string.mini_sdk_camera_can_not_start);
  }
  
  private void openFileChooser(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "*/*";
    }
    localIntent.setType(str);
    startActivityForResultInSafe(paramActivity, localIntent, R.string.mini_sdk_cant_open_file_chooser);
  }
  
  private void openMicrophone(Activity paramActivity)
  {
    startActivityForResultInSafe(paramActivity, new Intent("android.provider.MediaStore.RECORD_SOUND"), R.string.mini_sdk_cant_open_sound_recorder);
  }
  
  private void startActivityForResultInSafe(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if ((paramActivity != null) && (paramIntent != null) && (paramInt > 0))
    {
      Object localObject = paramActivity.getPackageManager().queryIntentActivities(paramIntent, 0);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        try
        {
          paramActivity.startActivityForResult(paramIntent, this.mRequestCode);
          return;
        }
        catch (Exception paramIntent)
        {
          if (QMLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Caution: activity for intent was queried but can't started because ");
            ((StringBuilder)localObject).append(paramIntent.getMessage());
            QMLog.w("FileChooserHelper", ((StringBuilder)localObject).toString());
          }
        }
      }
      doCallbackWhenChooseFileFailed();
      MiniToast.makeText(paramActivity, 1, paramInt, 0).show();
    }
  }
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.mRequestCode == paramInt1)
    {
      Object localObject2;
      Object localObject1;
      if (this.mFilePathCallback != null)
      {
        if (-1 == paramInt2)
        {
          localObject2 = this.mFileGenerationUri;
          localObject1 = localObject2;
          if (localObject2 == null) {
            if (paramIntent != null) {
              localObject1 = paramIntent.getData();
            } else {
              localObject1 = Uri.EMPTY;
            }
          }
        }
        else
        {
          localObject1 = null;
        }
        this.mFilePathCallback.onReceiveValue(localObject1);
      }
      else if (this.mFilePathCallBackForLollipop != null)
      {
        if (-1 == paramInt2)
        {
          localObject2 = this.mFileGenerationUri;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label116;
          }
          if (paramIntent != null)
          {
            localObject1 = paramIntent.getData();
            break label116;
          }
        }
        localObject1 = null;
        label116:
        localObject2 = this.mFilePathCallBackForLollipop;
        if (localObject1 != null)
        {
          paramIntent = new Uri[1];
          paramIntent[0] = localObject1;
        }
        else
        {
          paramIntent = null;
        }
        ((ValueCallback)localObject2).onReceiveValue(paramIntent);
      }
      else
      {
        QMLog.w("FileChooserHelper", "Caution: mFilePathCallback should not be null!");
      }
      this.mRequestCode = -2147483648;
      this.mFilePathCallback = null;
      this.mFileGenerationUri = null;
      this.mFilePathCallBackForLollipop = null;
      return true;
    }
    return false;
  }
  
  @TargetApi(21)
  public boolean onShowFileChooser(Activity paramActivity, int paramInt, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    if ((paramActivity != null) && (paramValueCallback != null))
    {
      this.mFilePathCallBackForLollipop = paramValueCallback;
      paramValueCallback = paramFileChooserParams.getAcceptTypes();
      String str = "";
      if (paramValueCallback != null) {
        paramValueCallback = paramValueCallback[0];
      } else {
        paramValueCallback = "";
      }
      if (paramFileChooserParams.isCaptureEnabled()) {
        str = "*";
      }
      showFileChooser(paramActivity, paramInt, null, paramValueCallback, str);
      return true;
    }
    return false;
  }
  
  public void showFileChooser(Activity paramActivity, int paramInt, ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    if (paramActivity != null)
    {
      if ((paramValueCallback == null) && (this.mFilePathCallBackForLollipop == null)) {
        return;
      }
      if (this.mFilePathCallback != null) {
        QMLog.w("FileChooserHelper", "Caution: mFilePathCallback not null, Plz call doOnActivityResult in the onActivityResult method of caller");
      }
      this.mRequestCode = paramInt;
      this.mFilePathCallback = paramValueCallback;
      this.mFileGenerationUri = null;
      paramValueCallback = "";
      if (paramString1 != null) {
        paramString1 = paramString1.toLowerCase();
      } else {
        paramString1 = "";
      }
      if (paramString2 != null) {
        paramValueCallback = paramString2.toLowerCase();
      }
      if (TextUtils.isEmpty(paramValueCallback))
      {
        openFileChooser(paramActivity, paramString1);
        return;
      }
      boolean bool2 = isCaptureCorrect(paramValueCallback);
      paramString2 = paramValueCallback;
      boolean bool1 = bool2;
      if (!bool2)
      {
        paramString2 = getCapture(paramString1, paramValueCallback);
        bool1 = true;
      }
      if (bool1)
      {
        doCaptureCorrect(paramActivity, paramString1, paramString2);
        return;
      }
      openFileChooser(paramActivity, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.FileChooserHelper
 * JD-Core Version:    0.7.0.1
 */