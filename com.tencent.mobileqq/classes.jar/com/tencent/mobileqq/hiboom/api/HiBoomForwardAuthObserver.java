package com.tencent.mobileqq.hiboom.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditText;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class HiBoomForwardAuthObserver
  extends SVIPObserver
{
  private WeakReference<Context> a;
  
  public HiBoomForwardAuthObserver(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString)
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).hiboomAuthForward(paramActivity, paramInt, paramString, HiBoomConstants.a(paramInt));
  }
  
  private void a(Context paramContext, byte[] paramArrayOfByte, int paramInt)
  {
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).handleHiBoomTipsInfo(paramContext, paramArrayOfByte, paramInt);
  }
  
  public void onAuthHiBoom(boolean paramBoolean, Object paramObject)
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null)
    {
      QLog.e("HiBoomForwardAuthObserv", 1, "onAuthHiBoom: context == null");
      return;
    }
    Object localObject = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getProgressDialog(localContext);
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      ((QQProgressDialog)localObject).dismiss();
    }
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length >= 5)
      {
        paramBoolean = arrayOfObject[0] instanceof Integer;
        int k = -1;
        int i;
        if (paramBoolean) {
          i = ((Integer)arrayOfObject[0]).intValue();
        } else {
          i = -1;
        }
        paramBoolean = arrayOfObject[1] instanceof byte[];
        localObject = null;
        if (paramBoolean) {
          paramObject = (byte[])arrayOfObject[1];
        } else {
          paramObject = null;
        }
        int j;
        if ((arrayOfObject[2] instanceof Integer)) {
          j = ((Integer)arrayOfObject[2]).intValue();
        } else {
          j = -1;
        }
        if ((arrayOfObject[3] instanceof String)) {
          localObject = (String)arrayOfObject[3];
        }
        if ((arrayOfObject[4] instanceof Integer)) {
          k = ((Integer)arrayOfObject[4]).intValue();
        }
        if (i != 0)
        {
          if (paramObject != null)
          {
            a(localContext, paramObject, j);
            HiBoomConstants.a.set(false);
          }
        }
        else if (k != 1)
        {
          if (k == 2)
          {
            paramObject = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getBaseChatPieAdapter(localContext);
            if (paramObject != null)
            {
              ((IVasService)paramObject.a().getRuntimeService(IVasService.class, "")).getHiBoomManager().sendHiBoomMessage(paramObject, (String)localObject, j, HiBoomConstants.a(j));
              paramObject.a();
              paramObject.a().setText("");
            }
            HiBoomConstants.a.set(false);
          }
        }
        else
        {
          a((Activity)localContext, j, (String)localObject);
          return;
        }
      }
    }
    QQToast.a(localContext, 1, HardCodeUtil.a(2131705570), 0).a();
    HiBoomConstants.a.set(false);
  }
  
  public void onSetHiBoom(boolean paramBoolean, Object paramObject)
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null)
    {
      QLog.e("HiBoomForwardAuthObserv", 1, "onAuthHiBoom: context == null");
      return;
    }
    Object localObject = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getProgressDialog(localContext);
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      ((QQProgressDialog)localObject).dismiss();
    }
    if (paramBoolean)
    {
      if ((paramObject instanceof Object[]))
      {
        Object[] arrayOfObject = (Object[])paramObject;
        if (arrayOfObject.length >= 5)
        {
          paramBoolean = arrayOfObject[0] instanceof Integer;
          int j = -1;
          int i;
          if (paramBoolean) {
            i = ((Integer)arrayOfObject[0]).intValue();
          } else {
            i = -1;
          }
          if ((arrayOfObject[1] instanceof Integer)) {
            j = ((Integer)arrayOfObject[1]).intValue();
          }
          paramBoolean = arrayOfObject[2] instanceof byte[];
          localObject = null;
          if (paramBoolean) {
            paramObject = (byte[])arrayOfObject[2];
          } else {
            paramObject = null;
          }
          if ((arrayOfObject[3] instanceof Boolean)) {
            paramBoolean = ((Boolean)arrayOfObject[3]).booleanValue();
          } else {
            paramBoolean = false;
          }
          if ((arrayOfObject[4] instanceof String)) {
            localObject = (String)arrayOfObject[4];
          }
          if (i != 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onSetHiBoom fail ret = ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(" id = ");
            ((StringBuilder)localObject).append(j);
            QLog.d("HiBoomForwardAuthObserv", 1, ((StringBuilder)localObject).toString());
            if (paramBoolean)
            {
              a(localContext, paramObject, j);
              HiBoomConstants.a.set(false);
            }
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("HiBoomForwardAuthObserv", 2, "onSetHiBoom success");
          }
          if (paramBoolean)
          {
            paramObject = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getBaseChatPieAdapter(localContext);
            if (paramObject != null)
            {
              ((IVasService)paramObject.a().getRuntimeService(IVasService.class, "")).getHiBoomManager().sendHiBoomMessage(paramObject, (String)localObject, j, HiBoomConstants.a(j));
              paramObject.a();
              paramObject.a().setText("");
            }
            HiBoomConstants.a.set(false);
          }
          paramObject = MobileQQ.sMobileQQ.peekAppRuntime();
          if ((paramObject != null) && ((paramObject instanceof AppInterface)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("HiBoomForwardAuthObserv", 2, "onSetHiBoom get hiboom list");
            }
            ((ISVIPHandler)((AppInterface)paramObject).getBusinessHandler(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).b();
          }
          return;
        }
      }
      paramBoolean = false;
    }
    else
    {
      paramBoolean = ((Boolean)paramObject).booleanValue();
    }
    if (paramBoolean)
    {
      QQToast.a(localContext, 1, HardCodeUtil.a(2131705567), 0).a();
      HiBoomConstants.a.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.api.HiBoomForwardAuthObserver
 * JD-Core Version:    0.7.0.1
 */