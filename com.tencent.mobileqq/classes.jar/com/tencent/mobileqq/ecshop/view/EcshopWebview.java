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
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static EcshopWebview b;
  public static int c = 0;
  private EcshopWebview jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview;
  public int b;
  private int d = 0;
  
  public EcshopWebview(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.i("parasons333", 2, "---EcshopWebview---");
    }
  }
  
  public static EcshopWebview a(Context paramContext)
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sPool acquire:");
        ((StringBuilder)localObject1).append(jdField_b_of_type_ComTencentMobileqqEcshopViewEcshopWebview);
        QLog.i("EcshopWebview", 1, ((StringBuilder)localObject1).toString());
        if (jdField_b_of_type_ComTencentMobileqqEcshopViewEcshopWebview != null)
        {
          localObject1 = jdField_b_of_type_ComTencentMobileqqEcshopViewEcshopWebview;
          jdField_b_of_type_ComTencentMobileqqEcshopViewEcshopWebview = ((EcshopWebview)localObject1).jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview;
          ((EcshopWebview)localObject1).jdField_a_of_type_ComTencentMobileqqEcshopViewEcshopWebview = null;
          c -= 1;
          if (localObject1 == null) {
            return new EcshopWebview(new MutableContextWrapper(paramContext));
          }
          ((EcshopWebview)localObject1).clearHistory();
          ((EcshopWebview)localObject1).jdField_b_of_type_Int = 1;
          ((EcshopWebview)localObject1).d += 1;
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
    if (1 == this.jdField_b_of_type_Int)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopWebview
 * JD-Core Version:    0.7.0.1
 */