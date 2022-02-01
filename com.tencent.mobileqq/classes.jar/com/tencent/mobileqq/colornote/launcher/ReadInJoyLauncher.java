package com.tencent.mobileqq.colornote.launcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ReadinjoyJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleOptimizeUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
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
    if (localObject1 == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject2 = Parcel.obtain();
        ((Parcel)localObject2).unmarshall((byte[])localObject1, 0, localObject1.length);
        ((Parcel)localObject2).setDataPosition(0);
        localObject1 = new VideoInfo((Parcel)localObject2);
        ((Parcel)localObject2).recycle();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putBoolean("FLAG_ACTIVITY_NEW_TASK", true);
        ((Bundle)localObject2).putLong("VIDEO_PLAY_POSITION", paramColorNote.mExtLong);
        ((Bundle)localObject2).putParcelable("VIDEO_OBJ", (Parcelable)localObject1);
        VideoFeedsHelper.a(paramContext, (Bundle)localObject2, false, 32);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyLauncher", 2, "colorNote handleVideoFeedsJump() videoInfo=" + ((VideoInfo)localObject1).b());
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ReadInJoyLauncher", 2, "handleVideoFeedsJump", localThrowable);
          }
          VideoInfo localVideoInfo = new VideoInfo();
        }
      }
    }
  }
  
  private void b(Context paramContext, ColorNote paramColorNote)
  {
    paramColorNote = paramColorNote.getReserve();
    if (paramColorNote == null) {
      return;
    }
    try
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramColorNote, 0, paramColorNote.length);
      localParcel.setDataPosition(0);
      paramColorNote = new ArticleInfo(localParcel);
      if (paramColorNote == null)
      {
        QLog.d("ReadInJoyLauncher", 2, "init color error something is null");
        return;
      }
    }
    catch (Exception paramColorNote)
    {
      for (;;)
      {
        QLog.e("ReadInJoyLauncher", 2, "unmarshall error");
        paramColorNote.printStackTrace();
        paramColorNote = null;
      }
      QLog.d("ReadInJoyLauncher", 2, "articleInfo From ColorNote :\n" + paramColorNote.toString());
      paramColorNote = ReadinjoyJumpUtils.b(paramContext, paramColorNote);
      paramColorNote.addFlags(268435456);
      paramColorNote.putExtra("from_color_note", true);
      paramColorNote.putExtra("native_article_launch_from", 1004);
      paramContext.startActivity(paramColorNote);
      RIJWebArticleOptimizeUtil.a.a(paramContext);
    }
  }
  
  private void c(Context paramContext, ColorNote paramColorNote)
  {
    if ((paramContext == null) || (paramColorNote == null) || (paramColorNote.getReserve() == null)) {
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
      QLog.e("ReadInJoyLauncher", 1, "error: " + paramContext.getMessage());
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.launcher.ReadInJoyLauncher
 * JD-Core Version:    0.7.0.1
 */