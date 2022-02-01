import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class lmm
{
  int jdField_a_of_type_Int = 0;
  ArrayList<lml> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  lmj jdField_a_of_type_Lmj = null;
  
  lmm()
  {
    a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_Lmj = lmj.a();
    this.jdField_a_of_type_Int = lmr.a(this.jdField_a_of_type_Lmj);
    QLog.d("QavGPDownloadManager", 1, String.format("QavGPDownloadObserver, mStatusGameplay[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
  
  boolean a()
  {
    this.jdField_a_of_type_Lmj = lmj.a();
    this.jdField_a_of_type_Int = lmr.a(this.jdField_a_of_type_Lmj);
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("checkResReady, mStatusGameplay[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    return 11 != this.jdField_a_of_type_Int;
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGPDownloadManager", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getQQProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.qavgameplaysomgr.notify");
    return paramBaseApplicationImpl.registerReceiver(new lmn(this), localIntentFilter) != null;
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  boolean c()
  {
    this.jdField_a_of_type_Lmj = lmj.a();
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = lmr.a(this.jdField_a_of_type_Lmj);
    if (this.jdField_a_of_type_Int == 11)
    {
      this.jdField_a_of_type_Int = 12;
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      Intent localIntent = new Intent();
      localIntent.setAction("from_qavgpsomgr_download");
      localIntent.setClass(localBaseApplicationImpl.getApplicationContext(), JumpActivity.class);
      localIntent.addFlags(268435456);
      localBaseApplicationImpl.getBaseContext().startActivity(localIntent);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavGPDownloadManager", 2, String.format("nodifyDownloadRes, lastStatus[%s], mStatusGameplay[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lmm
 * JD-Core Version:    0.7.0.1
 */