import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebview;
import com.tencent.biz.pubaccount.ecshopassit.view.EcshopWebviewPool.1;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class nvk
{
  private static volatile nvk jdField_a_of_type_Nvk;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private HashMap<String, EcshopWebview> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public static nvk a()
  {
    if (jdField_a_of_type_Nvk == null) {}
    try
    {
      if (jdField_a_of_type_Nvk == null) {
        jdField_a_of_type_Nvk = new nvk();
      }
      return jdField_a_of_type_Nvk;
    }
    finally {}
  }
  
  private boolean a()
  {
    if (BaseApplicationImpl.sProcessId == 7) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("parsons111", 2, "[checkToolProcess] isToolProcess: " + bool);
      return bool;
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    if ((!a()) || (!paramBoolean)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new EcshopWebviewPool.1(this, paramString));
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
            QLog.i("parsons111", 2, "【getWebView】= " + this.jdField_a_of_type_JavaUtilHashMap.size() + " preLoadUrl: " + paramString);
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
            if (bdje.a(paramString)) {
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
        QLog.e("parsons111", 1, QLog.getStackTraceString(paramString));
        return EcshopWebview.a(paramContext);
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView, String paramString)
  {
    QLog.i("parsons111", 2, "ecshop recycleWebView  ");
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      bdzt.b(-1);
      if (a()) {
        b(paramString, paramBoolean);
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("parsons111", 1, paramString, new Object[0]);
    }
  }
  
  public boolean a(String paramString)
  {
    return (!bdje.a(paramString)) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nvk
 * JD-Core Version:    0.7.0.1
 */