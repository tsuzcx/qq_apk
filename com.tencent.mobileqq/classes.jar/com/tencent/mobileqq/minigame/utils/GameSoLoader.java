package com.tencent.mobileqq.minigame.utils;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.mobileqq.triton.sdk.ITSoLoader;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import lnz;

public class GameSoLoader
  implements ITSoLoader
{
  private static final String TAG = "GameSoLoader";
  private InstalledEngine mEngine;
  private String mEngineDir;
  
  public GameSoLoader(InstalledEngine paramInstalledEngine)
  {
    this.mEngine = paramInstalledEngine;
    this.mEngineDir = getBaseEnginePath(this.mEngine);
  }
  
  private String getBaseEnginePath(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine != null) && (paramInstalledEngine.isVerify)) {
      return paramInstalledEngine.engineDir;
    }
    return null;
  }
  
  public String getSoPath(String paramString)
  {
    String str = this.mEngineDir;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (new File(str, paramString).exists()) {
        bool1 = true;
      }
    }
    GameLog.getInstance().i("GameSoLoader", "[MiniEng] load so [" + paramString + "] from " + this.mEngine + ", isSoFileExits = " + bool1);
    if (!bool1)
    {
      if (paramString.contains("png-armeabi-v7a"))
      {
        if (lnz.f() > 2) {}
        for (paramString = "/txlib/libpng-armeabi-v7a.so";; paramString = "/txlib/libpng-armeabi.so") {
          return BaseApplicationImpl.getContext().getFilesDir().getParent() + paramString;
        }
      }
      return null;
    }
    return str + "/" + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.GameSoLoader
 * JD-Core Version:    0.7.0.1
 */