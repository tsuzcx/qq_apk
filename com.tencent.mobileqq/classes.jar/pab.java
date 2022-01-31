import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.TimerTask;

public class pab
  extends TimerTask
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public pab(TribeVideoPlugin paramTribeVideoPlugin, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTribeVideoPlugin);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    TribeVideoPlugin localTribeVideoPlugin = (TribeVideoPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localTribeVideoPlugin == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("plugin == null ");
        if (localTribeVideoPlugin != null) {
          break label77;
        }
        bool = true;
        QLog.d("TribeVideoPlugin", 2, bool + " playerID = " + this.jdField_a_of_type_JavaLangString);
      }
    }
    label77:
    while (TribeVideoPlugin.a(localTribeVideoPlugin) == null) {
      for (;;)
      {
        return;
        boolean bool = false;
      }
    }
    Object localObject = TribeVideoPlugin.a(localTribeVideoPlugin).obtainMessage();
    ((Message)localObject).obj = this.jdField_a_of_type_JavaLangString;
    ((Message)localObject).what = 8;
    TribeVideoPlugin.a(localTribeVideoPlugin).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pab
 * JD-Core Version:    0.7.0.1
 */