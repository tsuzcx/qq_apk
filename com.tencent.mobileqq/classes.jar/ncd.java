import android.content.Intent;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class ncd
  implements nbs
{
  ncd(WeakReference paramWeakReference, String paramString1, int paramInt, String paramString2) {}
  
  public void loaded(String paramString, int paramInt)
  {
    paramString = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject;
    if (paramString != null)
    {
      paramString = (bbaa)paramString.getManager(193);
      localObject = this.jdField_a_of_type_JavaLangString;
      if (!BidDownloader.a(paramInt)) {
        break label172;
      }
    }
    label172:
    for (long l = this.jdField_a_of_type_Int;; l = -1L)
    {
      paramString.a((String)localObject, l);
      QLog.i(ncc.jdField_a_of_type_JavaLangString, 1, "finish predown bid=" + this.b + ", code=" + paramInt);
      ncc.a();
      if (ncc.b() == 0)
      {
        paramString = new Intent("com.tencent.process.tmdownloader.exit");
        localObject = new ArrayList();
        ((ArrayList)localObject).add("com.tencent.mobileqq:TMAssistantDownloadSDKService");
        paramString.putStringArrayListExtra("procNameList", (ArrayList)localObject);
        paramString.putExtra("verify", ncc.a((ArrayList)localObject, false));
        if (QLog.isColorLevel()) {
          QLog.d(ncc.jdField_a_of_type_JavaLangString, 2, "sendBroadcast to close TMAssistant sdk process");
        }
        BaseApplicationImpl.getContext().sendBroadcast(paramString);
      }
      return;
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ncd
 * JD-Core Version:    0.7.0.1
 */