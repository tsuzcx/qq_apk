package cooperation.ilive.group;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.group.entity.IliveGroupTipsEntity;
import java.lang.ref.WeakReference;

class IliveGroupTipsBarHelper$IliveHandler
  extends Handler
{
  private WeakReference<QQAppInterface> a;
  
  public IliveGroupTipsBarHelper$IliveHandler(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  private void a(Message paramMessage)
  {
    if (this.a == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      QLog.i("IliveGroupTipsBarHelper", 1, "getGroupTipsData");
      localQQAppInterface = (QQAppInterface)this.a.get();
    } while ((localQQAppInterface == null) || ((paramMessage.obj == null) && (!(paramMessage.obj instanceof IliveGroupTipsEntity))));
    paramMessage = (IliveGroupTipsEntity)paramMessage.obj;
    ((IliveGroupTipsManager)localQQAppInterface.getManager(QQManagerFactory.ILIVE_GROUP_TIPS_MANAGER)).a(String.valueOf(paramMessage.c), paramMessage.e, IliveGroupTipsManager.c);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.group.IliveGroupTipsBarHelper.IliveHandler
 * JD-Core Version:    0.7.0.1
 */