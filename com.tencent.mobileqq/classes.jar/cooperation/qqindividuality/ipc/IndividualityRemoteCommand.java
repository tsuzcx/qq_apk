package cooperation.qqindividuality.ipc;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class IndividualityRemoteCommand
  extends RemoteCommand
{
  private SparseArray<List<IndividualityRemoteCommand.IRemoteCommandHandler>> a = new SparseArray();
  
  public IndividualityRemoteCommand(AppRuntime paramAppRuntime)
  {
    super("com.tencent.individuality.individualityremotecommand");
    a(0, new IndividualityRemoteCommandHandler());
  }
  
  public boolean a(int paramInt, IndividualityRemoteCommand.IRemoteCommandHandler paramIRemoteCommandHandler)
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
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    int i = paramBundle.getInt("com.tencent.individuality.individualityremotecommand.id", -1);
    if (-1 != i)
    {
      if (QLog.isDevelopLevel())
      {
        paramOnInvokeFinishLinstener = new StringBuilder();
        paramOnInvokeFinishLinstener.append("invoke: dataInvoke=");
        paramOnInvokeFinishLinstener.append(paramBundle.toString());
        QLog.i("IndividualityRemoteCommand", 4, paramOnInvokeFinishLinstener.toString());
      }
      paramOnInvokeFinishLinstener = (List)this.a.get(i);
      if (paramOnInvokeFinishLinstener != null)
      {
        paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.iterator();
        while (paramOnInvokeFinishLinstener.hasNext()) {
          if (((IndividualityRemoteCommand.IRemoteCommandHandler)paramOnInvokeFinishLinstener.next()).a(i, paramBundle)) {
            return paramBundle;
          }
        }
      }
      paramOnInvokeFinishLinstener = (List)this.a.get(0);
      if (paramOnInvokeFinishLinstener != null)
      {
        paramOnInvokeFinishLinstener = paramOnInvokeFinishLinstener.iterator();
        while ((paramOnInvokeFinishLinstener.hasNext()) && (!((IndividualityRemoteCommand.IRemoteCommandHandler)paramOnInvokeFinishLinstener.next()).a(i, paramBundle))) {}
      }
    }
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.IndividualityRemoteCommand
 * JD-Core Version:    0.7.0.1
 */