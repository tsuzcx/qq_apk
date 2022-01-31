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

public class qsf
  implements qsa
{
  private int jdField_a_of_type_Int;
  private MediaMetadataRetriever jdField_a_of_type_AndroidMediaMediaMetadataRetriever = new MediaMetadataRetriever();
  private SparseArray<qry> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_a_of_type_JavaLangString;
  private Set<qrv> jdField_a_of_type_JavaUtilSet = new HashSet();
  private volatile boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  private int c;
  
  private int a(int paramInt)
  {
    return Integer.parseInt(this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.extractMetadata(paramInt));
  }
  
  private Bitmap a(MediaMetadataRetriever paramMediaMetadataRetriever, qrw paramqrw)
  {
    try
    {
      paramMediaMetadataRetriever = paramMediaMetadataRetriever.getFrameAtTime(paramqrw.c * 1000, 0);
      return paramMediaMetadataRetriever;
    }
    catch (Throwable paramMediaMetadataRetriever)
    {
      QLog.e("SystemCaptureProxy", 1, "getFrameAtTime failed for captureTask" + paramqrw.c, paramMediaMetadataRetriever);
    }
    return null;
  }
  
  private void d()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaMetadataRetriever.setDataSource(this.jdField_a_of_type_JavaLangString);
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
      qrv localqrv = (qrv)localIterator.next();
      if (localqrv != null) {
        localqrv.a(this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_Int);
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
    ThreadManager.executeOnFileThread(new SystemCaptureProxy.1(this));
  }
  
  public void a(qrv paramqrv)
  {
    this.jdField_a_of_type_JavaUtilSet.add(paramqrv);
  }
  
  public void a(qrw paramqrw, qry paramqry)
  {
    try
    {
      ThreadManager.executeOnFileThread(new SystemCaptureProxy.2(this, paramqrw, paramqry));
      return;
    }
    finally
    {
      paramqrw = finally;
      throw paramqrw;
    }
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qsf
 * JD-Core Version:    0.7.0.1
 */