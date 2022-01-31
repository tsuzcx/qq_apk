package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.TPEnumUtils;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Arrays;
import java.util.HashSet;

final class TPDrmCapability$1
  implements Runnable
{
  TPDrmCapability$1(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    Object localObject = TPThumbplayerCapabilityHelper.getDRMCapabilities();
    TPLogUtil.i("TPDrmCapability", "TPThumbplayerCapabilityHelper, drm cap:" + Arrays.toString((int[])localObject));
    if (localObject.length == 0) {
      return;
    }
    HashSet localHashSet = new HashSet();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localHashSet.add(String.valueOf(TPEnumUtils.convertDRMType2Outter(localObject[i])));
      i += 1;
    }
    TPDrmCapability.access$000(localHashSet);
    localObject = this.val$sp.edit();
    ((SharedPreferences.Editor)localObject).putStringSet("DRM_CAP_LIST", localHashSet);
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPDrmCapability.1
 * JD-Core Version:    0.7.0.1
 */