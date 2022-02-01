package com.tencent.weiyun.cmd;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.WeiyunLiteGlobal;
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
import com.tencent.weiyun.utils.Singleton;
import com.tencent.weiyun.utils.WyLog;
import java.lang.reflect.Method;
import java.util.List;

public class CommandManager
  implements Handler.Callback
{
  private static final String TAG = "CommandManager";
  private static Singleton<CommandManager, Void> sInstance = new CommandManager.2();
  private final Context mContext = WeiyunLiteGlobal.getInstance().getContext();
  private final Handler mHandler;
  private final WeiyunSDKContext mSdkContext;
  
  private CommandManager()
  {
    Object localObject = new HandlerThread("CommandManager");
    ((HandlerThread)localObject).start();
    this.mHandler = new Handler(((HandlerThread)localObject).getLooper(), this);
    localObject = new CommandManager.1(this);
    this.mSdkContext = ((WeiyunSDKContext)localObject);
    WeiyunClient.getInstance().init((WeiyunSDKContext)localObject);
  }
  
  public static CommandManager getInstance()
  {
    return (CommandManager)sInstance.get(null);
  }
  
  private void invokeMethod(Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod != null)
    {
      if (paramArrayOfObject == null) {
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
  }
  
  private void sendMessage(Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod != null)
    {
      if (paramArrayOfObject == null) {
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = new Object[] { paramMethod, paramArrayOfObject };
      this.mHandler.sendMessage(localMessage);
    }
  }
  
  public void checkShareFile(List<DirItem> paramList, List<FileItem> paramList1, List<String> paramList2, CheckShareFileCallback paramCheckShareFileCallback)
  {
    try
    {
      localMethod = CommandManager.class.getMethod("checkShareFile", new Class[] { List.class, List.class, List.class, CheckShareFileCallback.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      label36:
      break label36;
    }
    localMethod = null;
    if (localMethod != null)
    {
      sendMessage(localMethod, new Object[] { paramList, paramList1, paramList2, paramCheckShareFileCallback });
      return;
    }
    WyLog.e("CommandManager", "method checkShareFile is null.");
  }
  
  public void deleteDirFile(List<DirItem> paramList, List<FileItem> paramList1, DeleteDirFileCallback paramDeleteDirFileCallback)
  {
    try
    {
      localMethod = CommandManager.class.getMethod("deleteDirFile", new Class[] { List.class, List.class, DeleteDirFileCallback.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      label31:
      break label31;
    }
    localMethod = null;
    if (localMethod != null)
    {
      sendMessage(localMethod, new Object[] { paramList, paramList1, paramDeleteDirFileCallback });
      return;
    }
    WyLog.e("CommandManager", "method deleteDirFile is null.");
  }
  
  public void fetchFileList(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, FetchFileListCallback paramFetchFileListCallback)
  {
    try
    {
      localMethod = CommandManager.class.getMethod("fetchFileList", new Class[] { Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FetchFileListCallback.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      label52:
      break label52;
    }
    localMethod = null;
    if (localMethod != null)
    {
      sendMessage(localMethod, new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramFetchFileListCallback });
      return;
    }
    WyLog.e("CommandManager", "method fetchFileList is null.");
  }
  
  public void fetchFileListRecursively(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FetchFileListCallback paramFetchFileListCallback)
  {
    try
    {
      localMethod = CommandManager.class.getMethod("fetchFileListRecursively", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FetchFileListCallback.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      label45:
      break label45;
    }
    localMethod = null;
    if (localMethod != null)
    {
      sendMessage(localMethod, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramFetchFileListCallback });
      return;
    }
    WyLog.e("CommandManager", "method fetchFileListRecursively is null.");
  }
  
  public void fetchPOI(List<PoiItem> paramList, FetchPOICallback paramFetchPOICallback)
  {
    try
    {
      localMethod = CommandManager.class.getMethod("fetchPOI", new Class[] { List.class, FetchPOICallback.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      label25:
      break label25;
    }
    localMethod = null;
    if (localMethod != null)
    {
      sendMessage(localMethod, new Object[] { paramList, paramFetchPOICallback });
      return;
    }
    WyLog.e("CommandManager", "method fetchPOI is null.");
  }
  
  public void fetchPicVideoInfo(FetchPicVideoInfoCallback paramFetchPicVideoInfoCallback)
  {
    try
    {
      localMethod = CommandManager.class.getMethod("fetchPicVideoInfo", new Class[] { FetchPicVideoInfoCallback.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      label20:
      break label20;
    }
    localMethod = null;
    if (localMethod != null)
    {
      sendMessage(localMethod, new Object[] { paramFetchPicVideoInfoCallback });
      return;
    }
    WyLog.e("CommandManager", "method fetchPicVideoInfo is null.");
  }
  
  public void fetchUserInfo(FetchUserInfoCallback paramFetchUserInfoCallback)
  {
    try
    {
      localMethod = CommandManager.class.getMethod("fetchUserInfo", new Class[] { FetchUserInfoCallback.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      label20:
      break label20;
    }
    localMethod = null;
    if (localMethod != null)
    {
      sendMessage(localMethod, new Object[] { paramFetchUserInfoCallback });
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
    } else if (TextUtils.isEmpty(paramString)) {
      bool = false;
    } else {
      bool = WeiyunClient.loadLibrary(paramString);
    }
    if (bool) {
      WeiyunClient.getInstance().init(this.mSdkContext);
    }
    return bool;
  }
  
  public void modifyFile(FileItem paramFileItem1, FileItem paramFileItem2, ModifyFileCallback paramModifyFileCallback)
  {
    try
    {
      localMethod = CommandManager.class.getMethod("modifyFile", new Class[] { FileItem.class, FileItem.class, ModifyFileCallback.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      label31:
      break label31;
    }
    localMethod = null;
    if (localMethod != null)
    {
      sendMessage(localMethod, new Object[] { paramFileItem1, paramFileItem2, paramModifyFileCallback });
      return;
    }
    WyLog.e("CommandManager", "method modifyFile is null.");
  }
  
  public void resetWeiyunSdk()
  {
    try
    {
      localMethod = CommandManager.class.getMethod("reset", new Class[0]);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Method localMethod;
      label15:
      break label15;
    }
    localMethod = null;
    if (localMethod != null)
    {
      sendMessage(localMethod, new Object[0]);
      return;
    }
    WyLog.e("CommandManager", "method resetWeiyunSdk is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.cmd.CommandManager
 * JD-Core Version:    0.7.0.1
 */