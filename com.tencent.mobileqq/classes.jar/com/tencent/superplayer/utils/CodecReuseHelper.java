package com.tencent.superplayer.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.superplayer.config.CacheContent;
import com.tencent.superplayer.config.ConfigManager;
import com.tencent.tmediacodec.reuse.ReusePolicy.EraseType;
import org.json.JSONArray;
import org.json.JSONException;

public class CodecReuseHelper
{
  private static final String TAG = "CodecReuseHelper";
  private static CodecReuseHelper mInstance;
  private boolean hasLoadHardwareList = false;
  private boolean isDeviceSupport = false;
  
  public static CodecReuseHelper get()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new CodecReuseHelper();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public ReusePolicy.EraseType getEraseType()
  {
    int i = Math.max(Math.min(ConfigManager.get().getConfig("codecReuse").getInt("codec_erase_policy", ReusePolicy.EraseType.SAME.ordinal()), ReusePolicy.EraseType.values().length - 1), 0);
    return ReusePolicy.EraseType.values()[i];
  }
  
  public boolean isDeviceSupport()
  {
    if (!this.hasLoadHardwareList)
    {
      Object localObject = ConfigManager.get().getConfig("codecReuse").getString("white_hardware_list", "");
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(str, Build.MODEL)))
          {
            this.isDeviceSupport = true;
            break;
          }
          i += 1;
        }
        this.hasLoadHardwareList = true;
      }
      catch (JSONException localJSONException)
      {
        LogUtil.e("CodecReuseHelper", "isDeviceSupport error,", localJSONException);
      }
    }
    return this.isDeviceSupport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.utils.CodecReuseHelper
 * JD-Core Version:    0.7.0.1
 */