package com.tencent.mobileqq.shortvideo.videotransfer;

import org.json.JSONObject;

public class TransferConfig$ParamRule
{
  private static final String KEY_LEVEL = "level";
  private static final String KEY_MODE = "mode";
  private static final String KEY_STATR_POS = "start_pos";
  public static final int LEVEL_EFFECTS = 0;
  public static final int LEVEL_FRAME = 1;
  public static final int MODE_ALL_REPEAT = 2;
  public static final int MODE_ONCE = 4;
  public static final int MODE_ORDER = 0;
  public static final int MODE_REPEAT_ONCE = 3;
  public static final int MODE_SHUFFLE = 1;
  public int mLevel = 0;
  public int mMode = 0;
  public int mStartPos = 0;
  
  public TransferConfig$ParamRule() {}
  
  public TransferConfig$ParamRule(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mMode = paramInt2;
    this.mLevel = paramInt1;
    this.mStartPos = paramInt3;
  }
  
  public void fromJSONObject(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.mMode = paramString.optInt("mode", 0);
      this.mLevel = paramString.optInt("level", 0);
      this.mStartPos = paramString.optInt("start_pos", 0);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void reset()
  {
    this.mStartPos = 0;
    this.mMode = 0;
    this.mLevel = 0;
  }
  
  public String toJSONObject()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("mode", this.mMode);
      ((JSONObject)localObject).put("level", this.mLevel);
      ((JSONObject)localObject).put("start_pos", this.mStartPos);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ParamRule
 * JD-Core Version:    0.7.0.1
 */