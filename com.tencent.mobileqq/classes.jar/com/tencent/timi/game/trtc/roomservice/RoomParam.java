package com.tencent.timi.game.trtc.roomservice;

import com.tencent.timi.game.env.ServerEnv;
import com.tencent.timi.game.tproom_impl.RoomConfig;
import com.tencent.timi.game.trtc.tools.GenerateTestUserSig;
import com.tencent.timi.game.trtc.tools.Printer;
import com.tencent.timi.game.utils.Logger;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import org.json.JSONException;
import org.json.JSONObject;

public class RoomParam
  extends RoomConfig
{
  public String a;
  public String b;
  public int c;
  public int d;
  
  private RoomParam(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public static RoomParam a(String paramString1, String paramString2)
  {
    return new RoomParam(paramString1, paramString2, 21, 3);
  }
  
  public TRTCCloudDef.TRTCParams a()
  {
    Printer.a("createTRTCParam", new Object[0]);
    int i;
    if (ServerEnv.a() != 2)
    {
      i = 1400467382;
      localObject = "7da6b83b1e92619a33ed190927a2c6153c25a24279025a6055a1c8161a607a73";
    }
    else
    {
      i = 1400468649;
      localObject = "ef1104ab51c339581076d5d97f8ecea66b367ae693bea240f7f87c7a28754f09";
    }
    TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams();
    localTRTCParams.sdkAppId = i;
    String str = this.a;
    localTRTCParams.userId = str;
    localTRTCParams.roomId = -1;
    localTRTCParams.userSig = GenerateTestUserSig.a(str, i, (String)localObject);
    localTRTCParams.role = this.c;
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("strGroupId", this.b);
    }
    catch (JSONException localJSONException)
    {
      Logger.a("TRTCRoom", localJSONException.toString(), localJSONException);
      Printer.a("createTRTCParam", new Object[] { localJSONException.toString(), localJSONException });
    }
    localTRTCParams.businessInfo = ((JSONObject)localObject).toString();
    return localTRTCParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.RoomParam
 * JD-Core Version:    0.7.0.1
 */