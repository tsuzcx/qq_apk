import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.so.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class mai
  extends BroadcastReceiver
{
  mai(mah parammah) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    for (;;)
    {
      return;
      if (!"tencent.video.somgr.notify".equals(paramIntent.getAction())) {
        continue;
      }
      int i = paramIntent.getIntExtra("Event_Progress", 0);
      if ((i == 100) || (i < 0))
      {
        this.a.jdField_a_of_type_ComTencentAvSoDownloadInfo = DownloadInfo.get();
        int j = this.a.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_Int = maj.a(this.a.jdField_a_of_type_ComTencentAvSoDownloadInfo);
        boolean bool;
        if ((i == 100) && (this.a.jdField_a_of_type_Int != 11))
        {
          bool = true;
          QLog.i("QavSo", 1, String.format("receive notify, lastStatus[%s], progress[%s], mStatusSo[%s], data[%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(this.a.jdField_a_of_type_Int), this.a.jdField_a_of_type_ComTencentAvSoDownloadInfo }));
          paramIntent = new ArrayList();
        }
        synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
        {
          paramIntent.addAll(this.a.jdField_a_of_type_JavaUtilArrayList);
          ??? = paramIntent.iterator();
          while (???.hasNext()) {
            ((mad)???.next()).a(bool, this.a.b(), this.a.jdField_a_of_type_Int);
          }
          bool = false;
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QavSo", 4, String.format("receive notify, progress[%s]", new Object[] { Integer.valueOf(i) }));
      }
      paramIntent = new ArrayList();
      synchronized (this.a.jdField_a_of_type_JavaUtilArrayList)
      {
        paramIntent.addAll(this.a.jdField_a_of_type_JavaUtilArrayList);
        ??? = paramIntent.iterator();
        if (!???.hasNext()) {
          continue;
        }
        ((mad)???.next()).a(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mai
 * JD-Core Version:    0.7.0.1
 */