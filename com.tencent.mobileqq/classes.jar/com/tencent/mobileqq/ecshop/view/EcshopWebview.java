package com.tencent.mobileqq.ecshop.view;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;

public class EcshopWebview
  extends TouchWebView
{
  public static int c = 0;
  private static final Object e = new Object();
  private static EcshopWebview f;
  public int b = 0;
  private EcshopWebview d;
  private int g = 0;
  
  public EcshopWebview(Context paramContext)
  {
    super(paramContext);
    if (QLog.isColorLevel()) {
      QLog.i("parasons333", 2, "---EcshopWebview---");
    }
  }
  
  public static EcshopWebview b(Context paramContext)
  {
    for (;;)
    {
      synchronized (e)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sPool acquire:");
        ((StringBuilder)localObject1).append(f);
        QLog.i("EcshopWebview", 1, ((StringBuilder)localObject1).toString());
        if (f != null)
        {
          localObject1 = f;
          f = ((EcshopWebview)localObject1).d;
          ((EcshopWebview)localObject1).d = null;
          c -= 1;
          if (localObject1 == null) {
            return new EcshopWebview(new MutableContextWrapper(paramContext));
          }
          ((EcshopWebview)localObject1).clearHistory();
          ((EcshopWebview)localObject1).b = 1;
          ((EcshopWebview)localObject1).g += 1;
          ((EcshopWebview)localObject1).onResume();
          ((MutableContextWrapper)((EcshopWebview)localObject1).getContext()).setBaseContext(paramContext);
          return localObject1;
        }
      }
      Object localObject1 = null;
    }
  }
  
  public boolean canGoBack()
  {
    if (1 == this.b)
    {
      Object localObject = copyBackForwardList();
      if ((localObject != null) && (((WebBackForwardList)localObject).getSize() > 0))
      {
        localObject = ((WebBackForwardList)localObject).getItemAtIndex(0);
        if ((localObject != null) && ("about:blank".equals(((WebHistoryItem)localObject).getUrl()))) {
          return super.canGoBackOrForward(-2);
        }
      }
      return super.canGoBack();
    }
    return super.canGoBack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopWebview
 * JD-Core Version:    0.7.0.1
 */