package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.launcher.ILauncher;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.webarticle.RIJWebArticleOptimizeUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ReadInJoyLauncher
  implements ILauncher
{
  public static String a = "videofeeds:";
  public static String b = "mainFeeds:";
  
  private void a(Context paramContext, ColorNote paramColorNote)
  {
    Object localObject1 = paramColorNote.getReserve();
    if (localObject1 == null) {
      return;
    }
    if (localObject1.length > 10485760)
    {
      paramContext = new StringBuilder();
      paramContext.append("handleVideoFeedsJump note.getReserve too large. note.getReserve size: ");
      paramContext.append(localObject1.length);
      QLog.d("ReadInJoyLauncher", 1, paramContext.toString());
      return;
    }
    VideoInfo localVideoInfo;
    try
    {
      localObject2 = Parcel.obtain();
      ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
      ((Parcel)localObject2).setDataPosition(0);
      localObject1 = new VideoInfo((Parcel)localObject2);
      ((Parcel)localObject2).recycle();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyLauncher", 2, "handleVideoFeedsJump", localThrowable);
      }
      localVideoInfo = new VideoInfo();
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("FLAG_ACTIVITY_NEW_TASK", true);
    ((Bundle)localObject2).putLong("VIDEO_PLAY_POSITION", paramColorNote.mExtLong);
    ((Bundle)localObject2).putParcelable("VIDEO_OBJ", localVideoInfo);
    ((Bundle)localObject2).putBoolean("force_enter_native_video_feeds", true);
    VideoFeedsHelper.a(paramContext, (Bundle)localObject2, false, 32);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("colorNote handleVideoFeedsJump() videoInfo=");
      paramContext.append(localVideoInfo.q());
      QLog.d("ReadInJoyLauncher", 2, paramContext.toString());
    }
  }
  
  private void b(Context paramContext, ColorNote paramColorNote)
  {
    paramColorNote = paramColorNote.getReserve();
    if (paramColorNote == null) {
      return;
    }
    if (paramColorNote.length > 10485760)
    {
      paramContext = new StringBuilder();
      paramContext.append("handleArticleDetailPageJump note.getReserve too large. note.getReserve size: ");
      paramContext.append(paramColorNote.length);
      QLog.d("ReadInJoyLauncher", 1, paramContext.toString());
      return;
    }
    try
    {
      localObject = Parcel.obtain();
      ((Parcel)localObject).unmarshall(paramColorNote, 0, paramColorNote.length);
      ((Parcel)localObject).setDataPosition(0);
      paramColorNote = new BaseArticleInfo((Parcel)localObject);
    }
    catch (Exception paramColorNote)
    {
      QLog.e("ReadInJoyLauncher", 2, "unmarshall error");
      paramColorNote.printStackTrace();
      paramColorNote = null;
    }
    if (paramColorNote == null)
    {
      QLog.d("ReadInJoyLauncher", 2, "init color error something is null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("articleInfo From ColorNote :\n");
    ((StringBuilder)localObject).append(paramColorNote.toString());
    QLog.d("ReadInJoyLauncher", 2, ((StringBuilder)localObject).toString());
    paramColorNote = ReadinjoyJumpUtils.b(paramContext, paramColorNote);
    paramColorNote.addFlags(268435456);
    paramColorNote.putExtra("from_color_note", true);
    paramColorNote.putExtra("native_article_launch_from", 1004);
    paramContext.startActivity(paramColorNote);
    RIJWebArticleOptimizeUtil.a.a(paramContext);
  }
  
  private void c(Context paramContext, ColorNote paramColorNote)
  {
    if ((paramContext != null) && (paramColorNote != null))
    {
      if (paramColorNote.getReserve() == null) {
        return;
      }
      if (paramColorNote.getReserve().length > 10485760)
      {
        paramContext = new StringBuilder();
        paramContext.append("handleViolaPageJump note.getReserve too large. note.getReserve size: ");
        paramContext.append(paramColorNote.getReserve().length);
        QLog.d("ReadInJoyLauncher", 1, paramContext.toString());
        return;
      }
      try
      {
        paramColorNote = new String(paramColorNote.getReserve());
        Object localObject = new JSONObject(paramColorNote);
        String str1 = ((JSONObject)localObject).optString("url");
        String str2 = ((JSONObject)localObject).optString("param");
        boolean bool = ((JSONObject)localObject).optBoolean("useTransParentFragment");
        localObject = new Bundle();
        ((Bundle)localObject).putString("param", str2);
        ((Bundle)localObject).putString("colorBallData", paramColorNote);
        ((Bundle)localObject).putBoolean("from_color_note", true);
        ((Bundle)localObject).putInt("fling_action_key", 2);
        ((Bundle)localObject).putInt("fling_code_key", new Object().hashCode());
        ViolaAccessHelper.a(paramContext, null, str1, (Bundle)localObject, bool);
        return;
      }
      catch (Exception paramContext)
      {
        paramColorNote = new StringBuilder();
        paramColorNote.append("error: ");
        paramColorNote.append(paramContext.getMessage());
        QLog.e("ReadInJoyLauncher", 1, paramColorNote.toString());
      }
    }
  }
  
  public int getType()
  {
    return 16908290;
  }
  
  public void launch(Context paramContext, ColorNote paramColorNote)
  {
    if (paramColorNote.mSubType.startsWith(a))
    {
      a(paramContext, paramColorNote);
      return;
    }
    if (paramColorNote.mSubType.startsWith("viola:"))
    {
      c(paramContext, paramColorNote);
      return;
    }
    b(paramContext, paramColorNote);
  }
  
  public void onCreate(Context paramContext, ColorNote paramColorNote, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyLauncher
 * JD-Core Version:    0.7.0.1
 */