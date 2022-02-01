package com.tencent.mobileqq.hiboom;

import android.content.Context;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class HiBoomManager$HiBoomAuthObserver
  extends MessageObserver
{
  private WeakReference<Context> a;
  
  public HiBoomManager$HiBoomAuthObserver(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  public void onHiBoomAuthResult(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "onHiBoomAuthResult errorCode = " + paramInt);
    }
    Context localContext = (Context)this.a.get();
    if ((paramInt != 0) && (localContext != null)) {
      HiBoomManager.a(localContext, paramArrayOfByte, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomManager.HiBoomAuthObserver
 * JD-Core Version:    0.7.0.1
 */