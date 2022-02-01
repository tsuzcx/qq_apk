package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapDrmType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.core.common.TPNativeLibraryException;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

final class TPDrmCapability$1
  implements Runnable
{
  TPDrmCapability$1(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    int i = 0;
    Object localObject1 = new int[0];
    try
    {
      int[] arrayOfInt = TPThumbplayerCapabilityHelper.getDRMCapabilities();
      localObject1 = arrayOfInt;
    }
    catch (TPNativeLibraryException localTPNativeLibraryException)
    {
      TPLogUtil.e("TPDrmCapability", localTPNativeLibraryException);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TPThumbplayerCapabilityHelper, drm cap:");
    ((StringBuilder)localObject2).append(Arrays.toString((int[])localObject1));
    TPLogUtil.i("TPDrmCapability", ((StringBuilder)localObject2).toString());
    if (localObject1.length == 0) {
      return;
    }
    localObject2 = new HashSet();
    int j = localObject1.length;
    while (i < j)
    {
      ((HashSet)localObject2).add(String.valueOf(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapDrmType.class, localObject1[i])));
      i += 1;
    }
    TPDrmCapability.access$000((HashSet)localObject2);
    localObject1 = this.val$sp.edit();
    ((SharedPreferences.Editor)localObject1).putStringSet("DRM_CAP_LIST", (Set)localObject2);
    ((SharedPreferences.Editor)localObject1).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPDrmCapability.1
 * JD-Core Version:    0.7.0.1
 */