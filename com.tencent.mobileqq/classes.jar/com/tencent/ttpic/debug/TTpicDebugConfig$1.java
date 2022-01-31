package com.tencent.ttpic.debug;

import android.util.Log;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.util.GsonUtils;

final class TTpicDebugConfig$1
  implements Runnable
{
  public void run()
  {
    String str = FileOfflineUtil.readJsonStringFromFile("/sdcard/ttpicconfig.txt");
    if (str == null) {
      return;
    }
    TTpicDebugConfig.access$002(((TTPicDebugConfigBean)GsonUtils.json2Obj(str, new TTpicDebugConfig.1.1(this).getType())).isGenderDetect);
    Log.i("TTpicDebugConfig", "init end." + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.debug.TTpicDebugConfig.1
 * JD-Core Version:    0.7.0.1
 */