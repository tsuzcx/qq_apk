package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import bhpp;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.minigame.utils.thread.TTHandleThread;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class EngineInstanceManager
{
  public static final int ENG_NOT_LOAD = -1;
  public static final int ERR_ENGINE_NEED_UPDATE = 101;
  public static final int ERR_ENGINE_NULL = 105;
  public static final int ERR_ENGINE_TIMEOUT = 103;
  public static final int ERR_ENGINE_VERSION = 104;
  public static final int ERR_INIT_ENGINE = 109;
  public static final int ERR_INIT_NDK = 108;
  public static final int ERR_INTERNAL = 102;
  public static final int ERR_INVALID_OP = 1;
  public static final int ERR_LOAD_JAR = 106;
  public static final int ERR_LOAD_SO = 107;
  public static final int ERR_UNKNOWN = 100;
  private static final int INSTALL_ENGINE_REQUEST_COUNT_MAX = 2;
  public static final int SUCCEED = 0;
  private static final String TAG = "EngineInstanceManager";
  private static final int UPGRADE_ENGINE_REQUEST_COUNT_MAX = 1;
  private static volatile EngineInstanceManager sInstance;
  private int installEngineRequestCount;
  private AtomicInteger mAckCount = new AtomicInteger(0);
  private EngineChannel mEngineChannel;
  private InstalledEngine mEngineInstance;
  private CopyOnWriteArrayList<EngineInstanceManager.IListener> mListeners = new CopyOnWriteArrayList();
  private EngineChannel.Receiver mReceiver = new EngineInstanceManager.1(this);
  private volatile EngineInstanceManager.States mState = EngineInstanceManager.States.INIT;
  private int upgradeEngineRequestCount;
  
  private String calcMD5(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      QLog.d("EngineInstanceManager", 1, "calcMD5 " + paramString + ", md5:" + str1 + ", cost:" + (System.currentTimeMillis() - l));
      return str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject = new File(paramString);
        if (!((File)localObject).exists()) {
          break;
        }
        try
        {
          String str4 = bhpp.a((File)localObject);
          localObject = str4;
          if (str4 == null) {
            localObject = "";
          }
        }
        catch (IOException localIOException)
        {
          String str2 = "";
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QLog.e("EngineInstanceManager", 1, "calcMD5 " + paramString + ", exception:", localOutOfMemoryError);
        String str3 = "";
      }
    }
  }
  
  private void doOnReceiveData(int paramInt, Bundle paramBundle)
  {
    QLog.i("EngineInstanceManager", 1, "onReceiveData what:" + paramInt);
    if (paramBundle != null) {
      paramBundle.setClassLoader(getClass().getClassLoader());
    }
    if (paramInt == 55) {
      this.mAckCount.getAndIncrement();
    }
    Object localObject;
    if (paramInt == 51) {
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getParcelableArrayList("installedEngineList");
        if (paramBundle != null)
        {
          QLog.i("EngineInstanceManager", 1, "getInstalledEngineList success " + paramBundle.size());
          paramBundle = paramBundle.iterator();
          if (paramBundle.hasNext())
          {
            localObject = (InstalledEngine)paramBundle.next();
            if (verifyEngine((InstalledEngine)localObject))
            {
              this.mEngineInstance = ((InstalledEngine)localObject);
              QLog.i("EngineInstanceManager", 1, "verifyEngine " + localObject + " success, break");
            }
          }
          else
          {
            label174:
            if (this.mEngineInstance == null) {
              break label301;
            }
            QLog.i("EngineInstanceManager", 1, "get InstalledEngine success:" + this.mEngineInstance);
            notifyFinish(0, null);
          }
        }
      }
    }
    label301:
    label443:
    do
    {
      do
      {
        return;
        QLog.w("EngineInstanceManager", 1, "verifyEngine " + localObject + " fail, check next one");
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("invalidEngine", (Parcelable)localObject);
        sendCommand(56, localBundle);
        break;
        QLog.i("EngineInstanceManager", 1, "getInstalledEngineList gameEngineList is null");
        break label174;
        QLog.i("EngineInstanceManager", 1, "getInstalledEngineList data is null");
        break label174;
        if (this.installEngineRequestCount < 2)
        {
          QLog.i("EngineInstanceManager", 1, "no engine installed, send cmd WHAT_INSTALL_LATEST_ENGINE");
          sendCommand(3, new Bundle());
          return;
        }
        QLog.i("EngineInstanceManager", 1, "no engine installed but installEngineRequestCount reaches max 2");
        this.mEngineInstance = generateDefaultEngine();
        notifyFinish(0, null);
        return;
        if (paramInt == 52)
        {
          QLog.i("EngineInstanceManager", 1, "EVENT_INSTALL_LATEST_ENGINE_BEGIN");
          return;
        }
        if (paramInt != 53) {
          break label443;
        }
      } while (paramBundle == null);
      localObject = paramBundle.getString("engineInstallerMessage");
      float f = paramBundle.getFloat("engineInstallerProgress");
      QLog.i("EngineInstanceManager", 1, "EVENT_INSTALL_LATEST_ENGINE_PROCESS, message:" + (String)localObject + ", progress:" + f);
      notifyProgress(f, (String)localObject);
      return;
    } while (paramInt != 54);
    QLog.i("EngineInstanceManager", 1, "EVENT_INSTALL_LATEST_ENGINE_FINISH");
    sendCommand(1, new Bundle());
  }
  
  public static EngineInstanceManager g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new EngineInstanceManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private InstalledEngine generateDefaultEngine()
  {
    InstalledEngine localInstalledEngine = new InstalledEngine();
    localInstalledEngine.engineType = 2;
    localInstalledEngine.engineVersion = EngineVersion.fromFolderName("8.3.5.4555_1.14.0.00225");
    localInstalledEngine.engineDir = "";
    localInstalledEngine.isVerify = true;
    localInstalledEngine.isPersist = true;
    localInstalledEngine.engineName = "MiniGame-Default";
    QLog.i("EngineInstanceManager", 1, "generateDefaultEngine, " + localInstalledEngine);
    return localInstalledEngine;
  }
  
  private void initOutChannel()
  {
    EngineChannel localEngineChannel = new EngineChannel();
    localEngineChannel.setName("GameEngine(" + Process.myPid() + ")");
    localEngineChannel.setReceiver(this.mReceiver);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("engineChannel", localEngineChannel);
    sendCommand(1, localBundle);
  }
  
  private void notifyFinish(int paramInt, String paramString)
  {
    QLog.i("EngineInstanceManager", 1, "notifyFinish listener size:" + this.mListeners.size());
    this.mState = EngineInstanceManager.States.DONE;
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((EngineInstanceManager.IListener)localIterator.next()).onFinish(paramInt, paramString);
    }
    this.mListeners.clear();
  }
  
  private void notifyProgress(float paramFloat, String paramString)
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext()) {
      ((EngineInstanceManager.IListener)localIterator.next()).onProgress(paramFloat, paramString);
    }
  }
  
  private void rebindChannelIfNecessary()
  {
    TTHandleThread.getInstance().postDelayed(new EngineInstanceManager.2(this), 100L);
  }
  
  private void sendCommand(int paramInt, Bundle paramBundle)
  {
    paramBundle.putInt("baseLibType", 2);
    paramBundle.putInt("enginePid", Process.myPid());
    QLog.i("EngineInstanceManager", 1, "installEngineRequestCount, " + this.installEngineRequestCount + " upgradeEngineRequestCount, " + this.upgradeEngineRequestCount + "," + paramInt);
    if (paramInt == 5) {
      this.upgradeEngineRequestCount += 1;
    }
    if (paramInt == 3) {
      this.installEngineRequestCount += 1;
    }
    if (this.mEngineChannel != null)
    {
      this.mEngineChannel.send(paramInt, paramBundle);
      return;
    }
    QLog.w("EngineInstanceManager", 1, "failed sendCommand mEngineChannel is null");
  }
  
  private boolean verifyEngine(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine == null) || (TextUtils.isEmpty(paramInstalledEngine.engineDir))) {
      return false;
    }
    File localFile = new File(paramInstalledEngine.engineDir);
    if ((!localFile.exists()) || (localFile.isFile())) {
      return false;
    }
    boolean bool;
    try
    {
      localObject1 = new File(localFile, "verify.json");
      if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
        break label127;
      }
      QLog.i("EngineInstanceManager", 1, "verifyEngine " + paramInstalledEngine + " has no verify.json, skip!");
      return true;
    }
    catch (Throwable paramInstalledEngine)
    {
      QLog.e("EngineInstanceManager", 1, "verifyEngine exception.", paramInstalledEngine);
      bool = false;
    }
    return bool;
    label127:
    Object localObject1 = FileUtils.readFileToString((File)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.i("EngineInstanceManager", 1, "verifyEngine " + paramInstalledEngine + " verify.json has no content, skip!");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("EngineInstanceManager", 1, "verifyEngine " + paramInstalledEngine + " content:" + (String)localObject1);
    }
    localObject1 = new JSONObject((String)localObject1);
    if (!((JSONObject)localObject1).has("verify_list"))
    {
      QLog.i("EngineInstanceManager", 1, "verifyEngine " + paramInstalledEngine + " verify.json has no verify_list, skip!");
      return true;
    }
    paramInstalledEngine = ((JSONObject)localObject1).getJSONArray("verify_list");
    int i = 0;
    for (;;)
    {
      if (i < paramInstalledEngine.length())
      {
        if (paramInstalledEngine.get(i) == null)
        {
          QLog.e("EngineInstanceManager", 1, "配置文件格式异常！！请使用json工具检测");
          break label596;
        }
        Object localObject3 = (JSONObject)paramInstalledEngine.get(i);
        localObject1 = ((JSONObject)localObject3).optString("name");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label596;
        }
        Object localObject2 = new File(localFile, (String)localObject1);
        if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile()))
        {
          QLog.w("EngineInstanceManager", 1, "verifyEngine file " + (String)localObject1 + " not found");
          bool = false;
          break;
        }
        int j = ((JSONObject)localObject3).optInt("length");
        if ((j > 0) && (((File)localObject2).length() != j))
        {
          QLog.w("EngineInstanceManager", 1, "verifyEngine file " + (String)localObject1 + " length fail, config_length:" + j + ", local_length:" + ((File)localObject2).length());
          bool = false;
          break;
        }
        localObject3 = ((JSONObject)localObject3).optString("md5");
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          break label596;
        }
        localObject2 = calcMD5(((File)localObject2).getAbsolutePath());
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject3).equalsIgnoreCase((String)localObject2))) {
          break label596;
        }
        QLog.w("EngineInstanceManager", 1, "verifyEngine file " + (String)localObject1 + " md5 fail, config_md5:" + (String)localObject3 + ", local_md5:" + (String)localObject2);
        bool = false;
        break;
      }
      bool = true;
      break;
      label596:
      i += 1;
    }
  }
  
  public InstalledEngine getEngineInstance()
  {
    return this.mEngineInstance;
  }
  
  public String getEngineInstancePath()
  {
    InstalledEngine localInstalledEngine = getEngineInstance();
    if (localInstalledEngine != null)
    {
      if (localInstalledEngine.isVerify) {
        return localInstalledEngine.engineDir + "/";
      }
      QLog.e("EngineInstanceManager", 1, new Object[] { "getInstalledEnginePath failed, engine:", localInstalledEngine, DebugUtil.getStackTrace() });
    }
    return null;
  }
  
  public void setEngineChannelIfNeed(EngineChannel paramEngineChannel)
  {
    if (paramEngineChannel == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.mEngineChannel != null) {
          continue;
        }
        QLog.i("EngineInstanceManager", 1, "set channel to:" + paramEngineChannel);
        this.mEngineChannel = paramEngineChannel;
      }
      finally {}
    }
  }
  
  public void tryGetEngineFromMainProcess(EngineInstanceManager.IListener paramIListener)
  {
    for (;;)
    {
      try
      {
        QLog.i("EngineInstanceManager", 1, "tryGetEngineFromMainProcess currentState:" + this.mState);
        if (this.mState == EngineInstanceManager.States.DONE)
        {
          if (paramIListener != null)
          {
            paramIListener.onProgress(1.0F, null);
            paramIListener.onFinish(0, null);
          }
          return;
        }
        if (this.mState == EngineInstanceManager.States.WORKING)
        {
          if (paramIListener == null) {
            continue;
          }
          this.mListeners.add(paramIListener);
          continue;
        }
        this.mState = EngineInstanceManager.States.WORKING;
      }
      finally {}
      if (paramIListener != null) {
        this.mListeners.add(paramIListener);
      }
      if (this.mEngineChannel == null) {
        rebindChannelIfNecessary();
      } else {
        initOutChannel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineInstanceManager
 * JD-Core Version:    0.7.0.1
 */