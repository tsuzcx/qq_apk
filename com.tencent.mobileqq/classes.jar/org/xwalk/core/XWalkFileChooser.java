package org.xwalk.core;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.webkit.ValueCallback;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class XWalkFileChooser
{
  private static final String ALL_AUDIO_TYPES = "audio/*";
  private static final String ALL_IMAGE_TYPES = "image/*";
  private static final String ALL_VIDEO_TYPES = "video/*";
  private static final String ANY_TYPES = "*/*";
  private static final String AUDIO_TYPE = "audio/";
  private static final String IMAGE_TYPE = "image/";
  public static final int INPUT_FILE_REQUEST_CODE = 1;
  private static final String PATH_PREFIX = "file:";
  private static final String SPLIT_EXPRESSION = ",";
  private static final String TAG = "XWalkFileChooser";
  private static final String VIDEO_TYPE = "video/";
  private static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
  private Activity mActivity;
  private String mCameraPhotoPath;
  private ValueCallback<Uri> mFilePathCallback;
  
  public XWalkFileChooser(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private boolean canWriteExternalStorage()
  {
    try
    {
      boolean bool = Arrays.asList(this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 4096).requestedPermissions).contains("android.permission.WRITE_EXTERNAL_STORAGE");
      return bool;
    }
    catch (PackageManager.NameNotFoundException|NullPointerException localNameNotFoundException)
    {
      label36:
      break label36;
    }
    return false;
  }
  
  private File createImageFile()
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      Log.e("XWalkFileChooser", "External storage is not mounted.");
      return null;
    }
    Object localObject1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("JPEG_");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("_");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    try
    {
      localObject1 = File.createTempFile((String)localObject1, ".jpg", (File)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Created image file: ");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      Log.d("XWalkFileChooser", ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    catch (IOException localIOException)
    {
      label135:
      break label135;
    }
    Log.e("XWalkFileChooser", "Unable to create Image File, please make sure permission 'WRITE_EXTERNAL_STORAGE' was added.");
    return null;
  }
  
  private boolean deleteImageFile()
  {
    String str = this.mCameraPhotoPath;
    if ((str != null) && (str.contains("file:")))
    {
      str = this.mCameraPhotoPath.split("file:")[1];
      boolean bool = new File(str).delete();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Delete image file: ");
      localStringBuilder.append(str);
      localStringBuilder.append(" result: ");
      localStringBuilder.append(bool);
      Log.d("XWalkFileChooser", localStringBuilder.toString());
      return bool;
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (this.mFilePathCallback != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Activity result: ");
      localStringBuilder.append(paramInt2);
      Log.d("XWalkFileChooser", localStringBuilder.toString());
      if (-1 == paramInt2)
      {
        if ((paramIntent != null) && ((paramIntent.getAction() != null) || (paramIntent.getData() != null)))
        {
          paramIntent = paramIntent.getDataString();
          if (paramIntent != null) {
            paramIntent = Uri.parse(paramIntent);
          } else {
            paramIntent = null;
          }
          deleteImageFile();
          break label127;
        }
        paramIntent = this.mCameraPhotoPath;
        if (paramIntent != null)
        {
          paramIntent = Uri.parse(paramIntent);
          break label127;
        }
      }
      else if (paramInt2 == 0)
      {
        deleteImageFile();
      }
      paramIntent = null;
      label127:
      if (paramIntent != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Received file: ");
        localStringBuilder.append(paramIntent.toString());
        Log.d("XWalkFileChooser", localStringBuilder.toString());
      }
      this.mFilePathCallback.onReceiveValue(paramIntent);
      this.mFilePathCallback = null;
    }
  }
  
  public boolean showFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
  {
    this.mFilePathCallback = paramValueCallback;
    Intent localIntent1 = new Intent("android.media.action.IMAGE_CAPTURE");
    paramValueCallback = localIntent1;
    if (localIntent1.resolveActivity(this.mActivity.getPackageManager()) != null)
    {
      paramValueCallback = createImageFile();
      if (paramValueCallback != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("file:");
        ((StringBuilder)localObject).append(paramValueCallback.getAbsolutePath());
        this.mCameraPhotoPath = ((StringBuilder)localObject).toString();
        localIntent1.putExtra("PhotoPath", this.mCameraPhotoPath);
        localIntent1.putExtra("output", Uri.fromFile(paramValueCallback));
        paramValueCallback = localIntent1;
      }
      else
      {
        paramValueCallback = null;
      }
    }
    Intent localIntent2 = new Intent("android.media.action.VIDEO_CAPTURE");
    Intent localIntent3 = new Intent("android.provider.MediaStore.RECORD_SOUND");
    localIntent1 = new Intent("android.intent.action.GET_CONTENT");
    localIntent1.addCategory("android.intent.category.OPENABLE");
    Object localObject = new ArrayList();
    if ((!paramString1.contains(",")) && (!paramString1.contains("*/*"))) {
      if (paramString2.equals("true"))
      {
        if (paramString1.startsWith("image/"))
        {
          if (paramValueCallback != null)
          {
            this.mActivity.startActivityForResult(paramValueCallback, 1);
            Log.d("XWalkFileChooser", "Started taking picture");
            return true;
          }
        }
        else
        {
          if (paramString1.startsWith("video/"))
          {
            this.mActivity.startActivityForResult(localIntent2, 1);
            Log.d("XWalkFileChooser", "Started camcorder");
            return true;
          }
          if (paramString1.startsWith("audio/"))
          {
            this.mActivity.startActivityForResult(localIntent3, 1);
            Log.d("XWalkFileChooser", "Started sound recorder");
            return true;
          }
        }
      }
      else if (paramString1.startsWith("image/"))
      {
        if (paramValueCallback != null) {
          ((ArrayList)localObject).add(paramValueCallback);
        }
        localIntent1.setType("image/*");
      }
      else if (paramString1.startsWith("video/"))
      {
        ((ArrayList)localObject).add(localIntent2);
        localIntent1.setType("video/*");
      }
      else if (paramString1.startsWith("audio/"))
      {
        ((ArrayList)localObject).add(localIntent3);
        localIntent1.setType("audio/*");
      }
    }
    if ((((ArrayList)localObject).isEmpty()) && (canWriteExternalStorage()))
    {
      if (paramValueCallback != null) {
        ((ArrayList)localObject).add(paramValueCallback);
      }
      ((ArrayList)localObject).add(localIntent2);
      ((ArrayList)localObject).add(localIntent3);
      localIntent1.setType("*/*");
    }
    paramValueCallback = new Intent("android.intent.action.CHOOSER");
    paramValueCallback.putExtra("android.intent.extra.INTENT", localIntent1);
    if (!((ArrayList)localObject).isEmpty()) {
      paramValueCallback.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])((ArrayList)localObject).toArray(new Intent[0]));
    }
    this.mActivity.startActivityForResult(paramValueCallback, 1);
    Log.d("XWalkFileChooser", "Started chooser");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkFileChooser
 * JD-Core Version:    0.7.0.1
 */