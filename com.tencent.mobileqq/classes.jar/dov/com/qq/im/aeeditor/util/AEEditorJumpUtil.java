package dov.com.qq.im.aeeditor.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.tavcut.bean.Size;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorLauncher;
import java.util.ArrayList;
import java.util.HashMap;

public class AEEditorJumpUtil
{
  public static void a(int paramInt, @Nullable Activity paramActivity, @Nullable PhotoCommonBaseData paramPhotoCommonBaseData, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramPhotoCommonBaseData == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramPhotoCommonBaseData.selectedPhotoList);
    if ((Build.VERSION.SDK_INT >= 21) && (paramBoolean))
    {
      a(paramInt, paramPhotoCommonBaseData.albumName, paramPhotoCommonBaseData.albumId, paramActivity, localArrayList, paramPhotoCommonBaseData.selectedMediaInfoHashMap);
      return;
    }
    int i = AECameraEntry.y.a();
    if (AECameraEntry.l(paramActivity.getIntent())) {
      i = AECameraEntry.A.a();
    }
    if (paramInt == 1)
    {
      a(paramActivity, localArrayList, paramPhotoCommonBaseData.selectedMediaInfoHashMap, i);
      return;
    }
    a(paramActivity, localArrayList, paramPhotoCommonBaseData.selectedMediaInfoHashMap, i);
  }
  
  private static void a(int paramInt, @Nullable String paramString1, @Nullable String paramString2, @Nullable Activity paramActivity, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap)
  {
    if ((paramActivity == null) || (paramArrayList == null) || (paramHashMap == null)) {}
    Bundle localBundle;
    int i;
    do
    {
      return;
      localBundle = new Bundle();
      localBundle.putStringArrayList("PhotoConst.SELECTED_PATHS", paramArrayList);
      localBundle.putString("albumName", paramString1);
      localBundle.putString("albumId", paramString2);
      localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
      i = AECameraEntry.y.a();
      if (AECameraEntry.l(paramActivity.getIntent())) {
        i = AECameraEntry.A.a();
      }
      if (paramInt == 0)
      {
        AEEditorLauncher.a(paramActivity, 0, localBundle, i);
        return;
      }
    } while (paramInt != 1);
    AEEditorLauncher.a(paramActivity, 1, localBundle, i);
  }
  
  public static void a(@Nullable Activity paramActivity, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap, int paramInt)
  {
    if ((paramActivity == null) || (paramArrayList == null) || (paramHashMap == null)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
    localIntent.putExtra("video_photo_from", paramInt);
    localIntent.addFlags(268435456);
    paramActivity.setResult(-1, localIntent);
  }
  
  private static void a(@Nullable Context paramContext, @Nullable String paramString, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    if ((paramContext == null) || (paramString == null) || (paramLocalMediaInfo == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramLocalMediaInfo);
    paramString = new Intent();
    paramString.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramString.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    paramString.putExtra("video_photo_from", paramInt);
    paramString.addFlags(268435456);
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).setResult(-1, paramString);
      return;
    }
    AEQLog.d("AEEditorJumpUtil", "jumpToCirclePublishWithNoVideo activity is not Activity");
  }
  
  public static void a(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable Size paramSize, @Nullable ArrayList paramArrayList, @Nullable LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramSize == null)) {
      return;
    }
    if (paramArrayList != null) {
      paramLocalMediaInfo.aiTextLabel = paramArrayList;
    }
    a(paramContext, paramString1, paramLocalMediaInfo, paramInt);
  }
  
  public static void a(@Nullable Context paramContext, @Nullable ArrayList<String> paramArrayList, @Nullable HashMap<String, LocalMediaInfo> paramHashMap, int paramInt)
  {
    if ((paramContext == null) || (paramArrayList == null) || (paramHashMap == null)) {
      return;
    }
    Intent localIntent1 = new Intent();
    if ((paramContext instanceof Activity))
    {
      Intent localIntent2 = ((Activity)paramContext).getIntent();
      if ((localIntent2 != null) && (localIntent2.getExtras() != null)) {
        localIntent1.putExtras(localIntent2.getExtras());
      }
    }
    localIntent1.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    localIntent1.putExtra("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
    localIntent1.putExtra("video_photo_from", paramInt);
    localIntent1.addFlags(268435456);
    if ((paramContext instanceof Activity))
    {
      ((Activity)paramContext).setResult(-1, localIntent1);
      return;
    }
    AEQLog.d("AEEditorJumpUtil", "sendPicToCirclePublish activity is not Activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.util.AEEditorJumpUtil
 * JD-Core Version:    0.7.0.1
 */