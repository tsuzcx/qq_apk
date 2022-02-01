import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class msc
{
  private static volatile msc jdField_a_of_type_Msc;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new msd(this);
  Context jdField_a_of_type_AndroidContentContext = null;
  VideoController jdField_a_of_type_ComTencentAvVideoController = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  String jdField_a_of_type_JavaLangString = null;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  mse jdField_a_of_type_Mse = null;
  
  private msc(VideoAppInterface paramVideoAppInterface)
  {
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.getNearByProfile");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp();
    this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
  }
  
  public static msc a(VideoAppInterface paramVideoAppInterface)
  {
    if (jdField_a_of_type_Msc == null) {}
    try
    {
      if (jdField_a_of_type_Msc == null) {
        jdField_a_of_type_Msc = new msc(paramVideoAppInterface);
      }
      return jdField_a_of_type_Msc;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Mse = null;
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    jdField_a_of_type_Msc = null;
  }
  
  /* Error */
  public void a(VideoAppInterface paramVideoAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 89	lbu:a	()Llbu;
    //   5: aload_0
    //   6: getfield 34	msc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: invokevirtual 93	lbu:c	(Ljava/lang/String;)Llez;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnonnull +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 32	msc:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   24: aload_2
    //   25: invokeinterface 97 2 0
    //   30: ifne -13 -> 17
    //   33: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +28 -> 64
    //   39: ldc 105
    //   41: iconst_2
    //   42: new 107	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   49: ldc 110
    //   51: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_2
    //   55: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_1
    //   65: aload_2
    //   66: invokevirtual 126	com/tencent/av/app/VideoAppInterface:b	(Ljava/lang/String;)Z
    //   69: ifeq -52 -> 17
    //   72: aload_0
    //   73: getfield 32	msc:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   76: aload_2
    //   77: invokeinterface 129 2 0
    //   82: pop
    //   83: goto -66 -> 17
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	msc
    //   0	91	1	paramVideoAppInterface	VideoAppInterface
    //   0	91	2	paramString	String
    //   12	2	3	locallez	lez
    // Exception table:
    //   from	to	target	type
    //   2	13	86	finally
    //   20	64	86	finally
    //   64	83	86	finally
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(mse parammse)
  {
    this.jdField_a_of_type_Mse = parammse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msc
 * JD-Core Version:    0.7.0.1
 */