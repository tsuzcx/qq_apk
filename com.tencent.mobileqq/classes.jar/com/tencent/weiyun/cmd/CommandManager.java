package com.tencent.weiyun.cmd;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.WeiyunLiteGlobal;
import com.tencent.weiyun.WeiyunLiteGlobal.HostInterface;
import com.tencent.weiyun.WeiyunLiteGlobal.IResponseHandler;
import com.tencent.weiyun.callback.CheckShareFileCallback;
import com.tencent.weiyun.callback.DeleteDirFileCallback;
import com.tencent.weiyun.callback.FetchFileListCallback;
import com.tencent.weiyun.callback.FetchPOICallback;
import com.tencent.weiyun.callback.FetchPicVideoInfoCallback;
import com.tencent.weiyun.callback.FetchUserInfoCallback;
import com.tencent.weiyun.callback.ModifyFileCallback;
import com.tencent.weiyun.data.DirItem;
import com.tencent.weiyun.data.FileItem;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import com.tencent.weiyun.utils.UIHelper;
import com.tencent.weiyun.utils.Utils;
import com.tencent.weiyun.utils.WyLog;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

public class CommandManager
  implements Handler.Callback
{
  private static final String TAG = "CommandManager";
  private static Singleton<CommandManager, Void> sInstance = new Singleton()
  {
    protected CommandManager create(Void paramAnonymousVoid)
    {
      return new CommandManager(null);
    }
  };
  private final Context mContext = WeiyunLiteGlobal.getInstance().getContext();
  private final Handler mHandler;
  private final WeiyunSDKContext mSdkContext;
  
  private CommandManager()
  {
    Object localObject = new HandlerThread("CommandManager");
    ((HandlerThread)localObject).start();
    this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
    localObject = new WeiyunSDKContext()
    {
      public String getAccessToken()
      {
        return null;
      }
      
      public String getCachePath()
      {
        return CommandManager.this.mContext.getFilesDir().toString();
      }
      
      public String getDeviceId()
      {
        return Utils.getDeviceId(CommandManager.this.mContext);
      }
      
      public String getDeviceInfo()
      {
        return "";
      }
      
      public String getDeviceName()
      {
        return Build.MODEL;
      }
      
      public int getLoginType()
      {
        return 0;
      }
      
      public int getNetworkType()
      {
        return NetworkUtils.getNetworkTypeDiff4G(CommandManager.this.mContext);
      }
      
      public String getOpenID()
      {
        return null;
      }
      
      public String getOpenKey()
      {
        return null;
      }
      
      public int getPlatform()
      {
        return Build.VERSION.SDK_INT;
      }
      
      public String getRefreshToken()
      {
        return null;
      }
      
      public long[] getScreenSize()
      {
        return new long[] { UIHelper.getWindowScreenWidth(CommandManager.this.mContext), UIHelper.getWindowScreenHeight(CommandManager.this.mContext) };
      }
      
      public long getUin()
      {
        return WeiyunLiteGlobal.getInstance().getHostInterface().getCurrentUin();
      }
      
      public String getWifiBssid()
      {
        String str2 = NetworkUtils.getWifiBSSID(CommandManager.this.mContext);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        return str1;
      }
      
      public void sendRequest(String paramAnonymousString, byte[] paramAnonymousArrayOfByte, final long paramAnonymousLong, int paramAnonymousInt)
      {
        WeiyunLiteGlobal.getInstance().getHostInterface().sendRequest(paramAnonymousString, paramAnonymousArrayOfByte, new WeiyunLiteGlobal.IResponseHandler()
        {
          public void receiveResponse(int paramAnonymous2Int, String paramAnonymous2String, byte[] paramAnonymous2ArrayOfByte)
          {
            CommandManager.1.this.recvResponse(paramAnonymous2Int, paramAnonymous2ArrayOfByte, paramAnonymousLong, this.val$nativeCallback);
          }
        });
      }
    };
    this.mSdkContext = ((WeiyunSDKContext)localObject);
    WeiyunClient.getInstance().init((WeiyunSDKContext)localObject);
  }
  
  public static CommandManager getInstance()
  {
    return (CommandManager)sInstance.get(null);
  }
  
  private void invokeMethod(Method paramMethod, Object[] paramArrayOfObject)
  {
    if ((paramMethod == null) || (paramArrayOfObject == null)) {
      return;
    }
    try
    {
      WeiyunClient.class.getMethod(paramMethod.getName(), paramMethod.getParameterTypes()).invoke(WeiyunClient.getInstance(), paramArrayOfObject);
      return;
    }
    catch (Throwable paramMethod)
    {
      WyLog.e("CommandManager", paramMethod);
    }
  }
  
  private void sendMessage(Method paramMethod, Object[] paramArrayOfObject)
  {
    if ((paramMethod == null) || (paramArrayOfObject == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramMethod, paramArrayOfObject };
    this.mHandler.sendMessage(localMessage);
  }
  
  public void checkShareFile(List<DirItem> paramList, List<FileItem> paramList1, List<String> paramList2, CheckShareFileCallback paramCheckShareFileCallback)
  {
    Object localObject = null;
    try
    {
      Method localMethod = CommandManager.class.getMethod("checkShareFile", new Class[] { List.class, List.class, List.class, CheckShareFileCallback.class });
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label40:
      break label40;
    }
    if (localObject != null)
    {
      sendMessage(localObject, new Object[] { paramList, paramList1, paramList2, paramCheckShareFileCallback });
      return;
    }
    WyLog.e("CommandManager", "method checkShareFile is null.");
  }
  
  public void deleteDirFile(List<DirItem> paramList, List<FileItem> paramList1, DeleteDirFileCallback paramDeleteDirFileCallback)
  {
    Object localObject = null;
    try
    {
      Method localMethod = CommandManager.class.getMethod("deleteDirFile", new Class[] { List.class, List.class, DeleteDirFileCallback.class });
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label35:
      break label35;
    }
    if (localObject != null)
    {
      sendMessage(localObject, new Object[] { paramList, paramList1, paramDeleteDirFileCallback });
      return;
    }
    WyLog.e("CommandManager", "method deleteDirFile is null.");
  }
  
  public void fetchFileList(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, FetchFileListCallback paramFetchFileListCallback)
  {
    Object localObject = null;
    try
    {
      Method localMethod = CommandManager.class.getMethod("fetchFileList", new Class[] { Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FetchFileListCallback.class });
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label56:
      break label56;
    }
    if (localObject != null)
    {
      sendMessage(localObject, new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramFetchFileListCallback });
      return;
    }
    WyLog.e("CommandManager", "method fetchFileList is null.");
  }
  
  public void fetchFileListRecursively(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FetchFileListCallback paramFetchFileListCallback)
  {
    Object localObject = null;
    try
    {
      Method localMethod = CommandManager.class.getMethod("fetchFileListRecursively", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FetchFileListCallback.class });
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label49:
      break label49;
    }
    if (localObject != null)
    {
      sendMessage(localObject, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramFetchFileListCallback });
      return;
    }
    WyLog.e("CommandManager", "method fetchFileListRecursively is null.");
  }
  
  public void fetchPOI(List<PoiItem> paramList, FetchPOICallback paramFetchPOICallback)
  {
    Object localObject = null;
    try
    {
      Method localMethod = CommandManager.class.getMethod("fetchPOI", new Class[] { List.class, FetchPOICallback.class });
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label28:
      break label28;
    }
    if (localObject != null)
    {
      sendMessage(localObject, new Object[] { paramList, paramFetchPOICallback });
      return;
    }
    WyLog.e("CommandManager", "method fetchPOI is null.");
  }
  
  public void fetchPicVideoInfo(FetchPicVideoInfoCallback paramFetchPicVideoInfoCallback)
  {
    Object localObject = null;
    try
    {
      Method localMethod = CommandManager.class.getMethod("fetchPicVideoInfo", new Class[] { FetchPicVideoInfoCallback.class });
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label21:
      break label21;
    }
    if (localObject != null)
    {
      sendMessage(localObject, new Object[] { paramFetchPicVideoInfoCallback });
      return;
    }
    WyLog.e("CommandManager", "method fetchPicVideoInfo is null.");
  }
  
  public void fetchUserInfo(FetchUserInfoCallback paramFetchUserInfoCallback)
  {
    Object localObject = null;
    try
    {
      Method localMethod = CommandManager.class.getMethod("fetchUserInfo", new Class[] { FetchUserInfoCallback.class });
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label21:
      break label21;
    }
    if (localObject != null)
    {
      sendMessage(localObject, new Object[] { paramFetchUserInfoCallback });
      return;
    }
    WyLog.e("CommandManager", "method fetchUserInfo is null.");
  }
  
  public String getWeiyunSdkVersion()
  {
    return WeiyunClient.getInstance().version();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = (Object[])paramMessage.obj;
      invokeMethod((Method)paramMessage[0], (Object[])paramMessage[1]);
    }
    return true;
  }
  
  public boolean isLibLoaded()
  {
    return WeiyunClient.isLoaded();
  }
  
  public boolean loadLibFromPath(String paramString)
  {
    boolean bool;
    if (WeiyunClient.isLoaded()) {
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        WeiyunClient.getInstance().init(this.mSdkContext);
      }
      return bool;
      if (TextUtils.isEmpty(paramString)) {
        bool = false;
      } else {
        bool = WeiyunClient.loadLibrary(paramString);
      }
    }
  }
  
  public void modifyFile(FileItem paramFileItem1, FileItem paramFileItem2, ModifyFileCallback paramModifyFileCallback)
  {
    Object localObject = null;
    try
    {
      Method localMethod = CommandManager.class.getMethod("modifyFile", new Class[] { FileItem.class, FileItem.class, ModifyFileCallback.class });
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label35:
      break label35;
    }
    if (localObject != null)
    {
      sendMessage(localObject, new Object[] { paramFileItem1, paramFileItem2, paramModifyFileCallback });
      return;
    }
    WyLog.e("CommandManager", "method modifyFile is null.");
  }
  
  public void resetWeiyunSdk()
  {
    Object localObject = null;
    try
    {
      Method localMethod = CommandManager.class.getMethod("reset", new Class[0]);
      localObject = localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label16:
      break label16;
    }
    if (localObject != null)
    {
      sendMessage(localObject, new Object[0]);
      return;
    }
    WyLog.e("CommandManager", "method resetWeiyunSdk is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.weiyun.cmd.CommandManager
 * JD-Core Version:    0.7.0.1
 */