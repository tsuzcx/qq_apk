package cooperation.qqfav.ipc;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class FavoritesRemoteCommand
  extends RemoteCommand
{
  private SparseArray<List<FavoritesRemoteCommand.IRemoteCommandHandler>> a = new SparseArray();
  
  public FavoritesRemoteCommand(AppRuntime paramAppRuntime)
  {
    super("com.tencent.qqfav.favoritesremotecommand");
    a(0, new FavoritesRemoteCommandHandler());
  }
  
  public boolean a(int paramInt, FavoritesRemoteCommand.IRemoteCommandHandler paramIRemoteCommandHandler)
  {
    List localList = (List)this.a.get(paramInt);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.a.put(paramInt, localObject);
    }
    if (!((List)localObject).contains(paramIRemoteCommandHandler)) {
      return ((List)localObject).add(paramIRemoteCommandHandler);
    }
    return false;
  }
  
  public boolean b(int paramInt, FavoritesRemoteCommand.IRemoteCommandHandler paramIRemoteCommandHandler)
  {
    List localList = (List)this.a.get(paramInt);
    if ((localList != null) && (localList.contains(paramIRemoteCommandHandler))) {
      return localList.remove(paramIRemoteCommandHandler);
    }
    return false;
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    int i = paramBundle.getInt("com.tencent.qqfav.favoritesremotecommand.id", -1);
    if (-1 != i)
    {
      if (QLog.isDevelopLevel())
      {
        paramOnInvokeFinishLinstener = new StringBuilder();
        paramOnInvokeFinishLinstener.append("invoke: dataInvoke=");
        paramOnInvokeFinishLinstener.append(paramBundle.toString());
        QLog.i("FavoritesRemoteCommand", 4, paramOnInvokeFinishLinstener.toString());
      }
      paramOnInvokeFinishLinstener = (List)this.a.get(i);
      if (paramOnInvokeFinishLinstener != null)
      {
        paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.iterator();
        while (paramOnInvokeFinishLinstener.hasNext()) {
          if (((FavoritesRemoteCommand.IRemoteCommandHandler)paramOnInvokeFinishLinstener.next()).a(i, paramBundle)) {
            return paramBundle;
          }
        }
      }
      paramOnInvokeFinishLinstener = (List)this.a.get(0);
      if (paramOnInvokeFinishLinstener != null)
      {
        paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.iterator();
        while ((paramOnInvokeFinishLinstener.hasNext()) && (!((FavoritesRemoteCommand.IRemoteCommandHandler)paramOnInvokeFinishLinstener.next()).a(i, paramBundle))) {}
      }
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqfav.ipc.FavoritesRemoteCommand
 * JD-Core Version:    0.7.0.1
 */