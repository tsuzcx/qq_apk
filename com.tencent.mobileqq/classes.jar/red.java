import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.2;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class red
  implements rdy
{
  private int jdField_a_of_type_Int;
  private MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever = new MediaMetadataRetriever();
  private SparseArray<rdw> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_a_of_type_JavaLangString;
  private Set<rdt> jdField_a_of_type_JavaUtilSet = new HashSet();
  private volatile boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  private int c;
  
  private int a(int paramInt)
  {
    return Integer.parseInt(this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.extractMetadata(paramInt));
  }
  
  private Bitmap a(MediaMetadataRetriever paramMediaMetadataRetriever, rdu paramrdu)
  {
    try
    {
      paramMediaMetadataRetriever = paramMediaMetadataRetriever.getFrameAtTime(paramrdu.c * 1000, 0);
      return paramMediaMetadataRetriever;
    }
    catch (Throwable paramMediaMetadataRetriever)
    {
      QLog.e("SystemCaptureProxy", 1, "getFrameAtTime failed for captureTask" + paramrdu.c, paramMediaMetadataRetriever);
    }
    return null;
  }
  
  private void d()
  {
    try
    {
      QLog.d("SystemCaptureProxy", 1, "prepare...");
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.setDataSource(this.jdField_a_of_type_JavaLangString);
      QLog.d("SystemCaptureProxy", 1, "prepare after...");
      this.jdField_a_of_type_Int = a(9);
      this.jdField_b_of_type_Int = a(18);
      this.c = a(19);
      ThreadManager.getUIHandler().post(new SystemCaptureProxy.3(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      rdt localrdt = (rdt)localIterator.next();
      if (localrdt != null) {
        localrdt.a(this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_Int);
      }
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever != null) {
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.release();
    }
  }
  
  public void a(int paramInt, ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    QLog.d("SystemCaptureProxy", 1, "prepare before...");
    ThreadManager.excute(new SystemCaptureProxy.1(this), 16, null, true);
  }
  
  public void a(rdt paramrdt)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramrdt);
  }
  
  public void a(rdu paramrdu, rdw paramrdw)
  {
    try
    {
      ThreadManager.excute(new SystemCaptureProxy.2(this, paramrdu, paramrdw), 16, null, true);
      return;
    }
    finally
    {
      paramrdu = finally;
      throw paramrdu;
    }
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     red
 * JD-Core Version:    0.7.0.1
 */