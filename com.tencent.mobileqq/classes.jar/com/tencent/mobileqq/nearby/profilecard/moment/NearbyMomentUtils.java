package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.now.ISmallVideoFragmentUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyMomentUtils
{
  public static <T> T a(View paramView, Class<T> paramClass)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() instanceof AbsListView))
    {
      if (a(paramView.getTag().getClass(), paramClass)) {
        return paramView.getTag();
      }
      return null;
    }
    return a((View)paramView.getParent(), paramClass);
  }
  
  public static String a(long paramLong)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = l1 - paramLong;
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l1);
    int i = ((Calendar)localObject).get(5);
    int j = ((Calendar)localObject).get(1);
    ((Calendar)localObject).setTimeInMillis(paramLong);
    int k = ((Calendar)localObject).get(5);
    int m = ((Calendar)localObject).get(1);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    if (l2 < 600000L) {
      return HardCodeUtil.a(2131905085);
    }
    if (l2 < 3600000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l2 / 60L / 1000L + 1L);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905078));
      return ((StringBuilder)localObject).toString();
    }
    if ((l2 < 21600000L) && (k == i))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l2 / 60L / 60L / 1000L);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905072));
      return ((StringBuilder)localObject).toString();
    }
    if ((l2 < 86400000L) && (k == i))
    {
      localSimpleDateFormat.applyPattern("HH:mm");
      return localSimpleDateFormat.format(((Calendar)localObject).getTime());
    }
    if ((l2 < 86400000L) && (k != i))
    {
      localSimpleDateFormat.applyPattern("HH:mm");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131905083));
      localStringBuilder.append(localSimpleDateFormat.format(((Calendar)localObject).getTime()));
      return localStringBuilder.toString();
    }
    if (m == j)
    {
      localSimpleDateFormat.applyPattern("MM-dd");
      return localSimpleDateFormat.format(((Calendar)localObject).getTime());
    }
    localSimpleDateFormat.applyPattern("yyyy-MM-dd");
    return localSimpleDateFormat.format(((Calendar)localObject).getTime());
  }
  
  public static void a(Context paramContext, PublishVideoEntry paramPublishVideoEntry, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramPublishVideoEntry.mLocalRawVideoDir);
    ((StringBuilder)localObject1).append("");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramPublishVideoEntry.thumbPath);
    ((StringBuilder)localObject2).append("");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramPublishVideoEntry.doodlePath);
    localStringBuilder.append("");
    paramPublishVideoEntry = new File(localStringBuilder.toString());
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject1).toURI());
      localStringBuilder.append("");
      localJSONObject.put("videoUrl", localStringBuilder.toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((File)localObject2).toURI());
      ((StringBuilder)localObject1).append("");
      localJSONObject.put("coverUrl", ((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramPublishVideoEntry.toURI());
      ((StringBuilder)localObject1).append("");
      localJSONObject.put("doodleUrl", ((StringBuilder)localObject1).toString());
      localJSONObject.put("is_local", "1");
    }
    catch (JSONException paramPublishVideoEntry)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getPreviewPage, e=");
        ((StringBuilder)localObject1).append(paramPublishVideoEntry.toString());
        QLog.i("NearbyMomentUtils", 2, ((StringBuilder)localObject1).toString());
      }
    }
    paramPublishVideoEntry = new Bundle();
    paramPublishVideoEntry.putString("preLoadParams", localJSONObject.toString());
    paramPublishVideoEntry.putBoolean("scroll_to_comment", false);
    paramPublishVideoEntry.putString("isLocal", "1");
    paramPublishVideoEntry.putString("_from", "3");
    paramPublishVideoEntry.putString("play_mode", String.valueOf(2));
    paramPublishVideoEntry.putBoolean("is_multi_progress_bar", false);
    paramPublishVideoEntry.putString("feed_type", String.valueOf(paramInt));
    ((ISmallVideoFragmentUtil)QRoute.api(ISmallVideoFragmentUtil.class)).launch(paramContext, paramPublishVideoEntry);
  }
  
  private static boolean a(Class paramClass1, Class paramClass2)
  {
    if ((paramClass1 != Object.class) && (paramClass1 != null))
    {
      if (paramClass1 == paramClass2) {
        return true;
      }
      return a(paramClass1.getSuperclass(), paramClass2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentUtils
 * JD-Core Version:    0.7.0.1
 */