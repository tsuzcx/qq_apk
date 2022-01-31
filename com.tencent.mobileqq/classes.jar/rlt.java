import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.Nullable;

public class rlt
  implements Handler.Callback
{
  private static rlt jdField_a_of_type_Rlt;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private final ArrayList<rlz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 600000L;
  private final ArrayList<rma> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private long c = SystemClock.elapsedRealtime();
  private long d;
  private long e;
  
  private rlt()
  {
    float f = Aladdin.getConfig(230).getFloatFromString("exo_weight_factor", 5.0F);
    this.jdField_a_of_type_JavaUtilArrayList.add(new rlx());
    this.jdField_b_of_type_JavaUtilArrayList.add(new rly(f));
    a();
  }
  
  public static rlt a()
  {
    if (jdField_a_of_type_Rlt == null) {}
    try
    {
      if (jdField_a_of_type_Rlt == null) {
        jdField_a_of_type_Rlt = new rlt();
      }
      return jdField_a_of_type_Rlt;
    }
    finally {}
  }
  
  private void a()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      ((ConnectivityManager)BaseApplicationImpl.getApplication().getSystemService("connectivity")).registerNetworkCallback(new NetworkRequest.Builder().build(), new rlv(this, null));
      return;
    }
    BaseApplicationImpl.getApplication().registerReceiver(new rlw(this, null), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  private long b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      long l2 = ((rlz)localIterator.next()).a();
      l1 = l2;
      if (l2 > 0L) {
        l1 = l2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BandwidthPredictor", 2, "getCurrentBandwidth: bandwidth=" + l1);
    }
    return l1;
  }
  
  private void b()
  {
    long l = b();
    Iterator localIterator;
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Int = 0;
      if (this.e > this.jdField_a_of_type_Long)
      {
        localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((rma)localIterator.next()).a(this.e);
        }
      }
      this.e = l;
    }
    for (;;)
    {
      return;
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        rma localrma = (rma)localIterator.next();
        if (this.e > localrma.jdField_a_of_type_Long) {
          localrma.a(this.e);
        }
      }
      this.e = 0L;
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int >= 5)
      {
        localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          ((rma)localIterator.next()).a();
        }
        if (SystemClock.elapsedRealtime() - this.c > this.jdField_b_of_type_Long) {}
        for (int i = 1; i != 0; i = 0)
        {
          d();
          return;
        }
      }
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      rma localrma = (rma)localIterator.next();
      long l2 = Math.max(localrma.jdField_a_of_type_Long, l1);
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("BandwidthPredictor", 2, "predict: predictor=" + localrma + ", currentPrediction=" + localrma.jdField_b_of_type_Long + ", prediction=" + localrma.jdField_a_of_type_Long);
        l1 = l2;
      }
    }
    this.jdField_a_of_type_Long = (((float)l1 / 10.0F));
    this.d = l1;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BandwidthPredictor", 2, "reset: ");
    }
    this.c = SystemClock.elapsedRealtime();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((rma)localIterator.next()).b();
    }
    if (bdin.h(BaseApplicationImpl.getContext()))
    {
      this.jdField_b_of_type_Long = (Aladdin.getConfig(230).getIntegerFromString("reset_time_threshold_wifi", 3600) * 1000L);
      return;
    }
    this.jdField_b_of_type_Long = (Aladdin.getConfig(230).getIntegerFromString("reset_time_threshold_xg", 600) * 1000L);
  }
  
  public final long a()
  {
    return this.d;
  }
  
  public void a(Context paramContext)
  {
    if ((Aladdin.getConfig(230).getIntegerFromString("bandwidth_enable", 1) == 1) && (this.jdField_b_of_type_Int <= 0))
    {
      this.jdField_b_of_type_Int = paramContext.hashCode();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
  
  public void b(Context paramContext)
  {
    if (paramContext.hashCode() == this.jdField_b_of_type_Int)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  public boolean handleMessage(@Nullable Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessage != null)
    {
      bool1 = bool2;
      if (paramMessage.what == 0)
      {
        b();
        c();
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 1000L);
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rlt
 * JD-Core Version:    0.7.0.1
 */