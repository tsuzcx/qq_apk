import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebview;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ohz
{
  private static volatile ohz jdField_a_of_type_Ohz;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private HashMap<String, EcshopWebview> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static ohz a()
  {
    if (jdField_a_of_type_Ohz == null) {}
    try
    {
      if (jdField_a_of_type_Ohz == null) {
        jdField_a_of_type_Ohz = new ohz();
      }
      return jdField_a_of_type_Ohz;
    }
    finally {}
  }
  
  public EcshopWebview a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        synchronized (this.jdField_a_of_type_ArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Ecshop_EcshopWebviewPool", 2, "【getWebView】= " + this.jdField_a_of_type_JavaUtilHashMap.size() + " preLoadUrl: " + paramString);
          }
          if (this.jdField_a_of_type_JavaUtilHashMap.size() > 0)
          {
            localObject = (EcshopWebview)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
            if (localObject != null)
            {
              paramString = (ViewGroup)((EcshopWebview)localObject).getParent();
              if (paramString != null) {
                paramString.removeView((View)localObject);
              }
              ((MutableContextWrapper)((EcshopWebview)localObject).getContext()).setBaseContext(paramContext);
              return localObject;
            }
          }
          else
          {
            EcshopWebview localEcshopWebview = EcshopWebview.a(paramContext);
            localObject = localEcshopWebview;
            if (StringUtil.isEmpty(paramString)) {
              continue;
            }
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localEcshopWebview);
            localObject = localEcshopWebview;
          }
        }
        Object localObject = EcshopWebview.a(paramContext);
      }
      catch (Throwable paramString)
      {
        QLog.e("Ecshop_EcshopWebviewPool", 1, QLog.getStackTraceString(paramString));
        return EcshopWebview.a(paramContext);
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString)
  {
    QLog.i("Ecshop_EcshopWebviewPool", 2, "ecshop recycleWebView  ");
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public boolean a(String paramString)
  {
    return (!StringUtil.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohz
 * JD-Core Version:    0.7.0.1
 */