package com.tencent.mobileqq.nearby.now.send.capturepart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.AndroidRuntimeException;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.biz.qqstory.takevideo2.StoryPublishParams;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.activity.CaptureSoDownloadActivity;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.app.AppRuntime;

public class StoryPublishLauncher
{
  public static AppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    throw new AndroidRuntimeException("mobile qq main process only");
  }
  
  public static StoryPublishLauncher a()
  {
    return new StoryPublishLauncher();
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (ShortVideoUtils.a()) {
      return true;
    }
    ShortVideoUtils.a(paramAppInterface);
    return ShortVideoUtils.a();
  }
  
  public static boolean b()
  {
    if (ShortVideoUtils.a()) {
      return true;
    }
    ShortVideoUtils.a(a());
    return ShortVideoUtils.a();
  }
  
  public Intent a(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = new Intent(paramActivity, PhotoListActivity.class);
    paramActivity.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    paramActivity.putExtra("from_now", true);
    paramActivity.putExtra("ALBUM_NAME", "最近照片");
    paramActivity.putExtra("ALBUM_ID", "$RecentAlbumId");
    paramActivity.putExtra("video_refer", "qqstory");
    paramActivity.putExtra("PhotoConst.IS_PREVIEW_VIDEO", false);
    paramActivity.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    paramActivity.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramActivity.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", LocalVideoSelectActivity.class.getName());
    paramActivity.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramActivity.putExtra("bundle_extra", paramBundle);
    return paramActivity;
  }
  
  public String a()
  {
    return SmallVideoCameraCaptureFragment.class.getName();
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    boolean bool1 = b();
    boolean bool2 = CaptureUtil.a();
    SLog.a("story.publish.StoryPublishLauncher", "launchForResult, videoSoUsable=%s, supportMediaCodec=%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2));
    if (bool2)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      a(localBundle);
      if (bool1)
      {
        CameraCaptureActivity.a(paramActivity, a(), localBundle, paramInt);
        return;
      }
      CaptureSoDownloadActivity.a(paramActivity, a(), localBundle, paramInt);
      return;
    }
    throw new AndroidRuntimeException("getCaptureIntent supportMediaCodec = false");
  }
  
  public void a(Context paramContext, Bundle paramBundle, AppInterface paramAppInterface)
  {
    boolean bool1 = a(paramAppInterface);
    boolean bool2 = CaptureUtil.a();
    SLog.a("story.publish.StoryPublishLauncher", "launch, videoSoUsable=%s, supportMediaCodec=%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2));
    if (bool2)
    {
      paramAppInterface = paramBundle;
      if (paramBundle == null) {
        paramAppInterface = new Bundle();
      }
      a(paramAppInterface);
      if (bool1)
      {
        CameraCaptureActivity.a(paramContext, a(), paramAppInterface);
        return;
      }
      CaptureSoDownloadActivity.a(paramContext, a(), paramAppInterface);
      return;
    }
    throw new AndroidRuntimeException("getCaptureIntent supportMediaCodec = false");
  }
  
  public void a(@NonNull Bundle paramBundle)
  {
    if (!paramBundle.containsKey("entrance_type")) {
      SLog.b("story.publish.StoryPublishLauncher", "do not has entrance type", new Throwable());
    }
    if (!paramBundle.containsKey("ability_flag")) {
      paramBundle.putInt("ability_flag", 1);
    }
    if (!paramBundle.containsKey("capture_max_duration")) {
      paramBundle.putLong("capture_max_duration", 10000L);
    }
  }
  
  public void a(Fragment paramFragment, Bundle paramBundle, int paramInt)
  {
    SLog.b("story.publish.StoryPublishLauncher", "launchAlbumThenEditThenPublishForResult");
    StoryPublishParams.a("story.publish.StoryPublishLauncher", paramBundle);
    boolean bool = CaptureUtil.a();
    SLog.a("story.publish.StoryPublishLauncher", "videoSoUsable=%s, supportMediaCodec=%s", Boolean.valueOf(true), Boolean.valueOf(bool));
    if (bool)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      paramFragment.startActivityForResult(a(paramFragment.getActivity(), localBundle), paramInt);
      return;
    }
    throw new AndroidRuntimeException("getCaptureIntent supportMediaCodec = false");
  }
  
  public boolean a()
  {
    return CaptureUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.capturepart.StoryPublishLauncher
 * JD-Core Version:    0.7.0.1
 */