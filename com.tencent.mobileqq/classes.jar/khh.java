import android.content.Context;
import android.widget.Button;
import com.tencent.av.utils.TraeHelper;

public class khh
  implements Runnable
{
  public khh(TraeHelper paramTraeHelper, Context paramContext, Button paramButton) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 16	khh:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   7: ldc 27
    //   9: invokevirtual 33	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 35	android/media/AudioManager
    //   15: astore 5
    //   17: aload 5
    //   19: aload_0
    //   20: getfield 14	khh:jdField_a_of_type_ComTencentAvUtilsTraeHelper	Lcom/tencent/av/utils/TraeHelper;
    //   23: getfield 40	com/tencent/av/utils/TraeHelper:jdField_a_of_type_Int	I
    //   26: invokevirtual 44	android/media/AudioManager:getStreamVolume	(I)I
    //   29: istore_1
    //   30: aload 5
    //   32: aload_0
    //   33: getfield 14	khh:jdField_a_of_type_ComTencentAvUtilsTraeHelper	Lcom/tencent/av/utils/TraeHelper;
    //   36: getfield 40	com/tencent/av/utils/TraeHelper:jdField_a_of_type_Int	I
    //   39: invokevirtual 47	android/media/AudioManager:getStreamMaxVolume	(I)I
    //   42: istore_2
    //   43: iload_1
    //   44: istore_3
    //   45: iload_3
    //   46: iload_2
    //   47: iconst_1
    //   48: ishr
    //   49: if_icmpge +91 -> 140
    //   52: aload_0
    //   53: getfield 14	khh:jdField_a_of_type_ComTencentAvUtilsTraeHelper	Lcom/tencent/av/utils/TraeHelper;
    //   56: iconst_1
    //   57: putfield 50	com/tencent/av/utils/TraeHelper:b	I
    //   60: new 52	khi
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 55	khi:<init>	(Lkhh;)V
    //   68: astore 5
    //   70: aload_0
    //   71: getfield 14	khh:jdField_a_of_type_ComTencentAvUtilsTraeHelper	Lcom/tencent/av/utils/TraeHelper;
    //   74: getfield 58	com/tencent/av/utils/TraeHelper:jdField_a_of_type_ComTencentAvVideoController	Lcom/tencent/av/VideoController;
    //   77: invokevirtual 63	com/tencent/av/VideoController:a	()Lcom/tencent/av/app/VideoAppInterface;
    //   80: aload 5
    //   82: invokevirtual 69	com/tencent/av/app/VideoAppInterface:runOnUiThread	(Ljava/lang/Runnable;)V
    //   85: return
    //   86: astore 5
    //   88: iconst_0
    //   89: istore_1
    //   90: iload_1
    //   91: istore_3
    //   92: iload 4
    //   94: istore_2
    //   95: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq -53 -> 45
    //   101: aload_0
    //   102: getfield 14	khh:jdField_a_of_type_ComTencentAvUtilsTraeHelper	Lcom/tencent/av/utils/TraeHelper;
    //   105: getfield 78	com/tencent/av/utils/TraeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: iconst_2
    //   109: new 80	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   116: ldc 83
    //   118: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload 5
    //   123: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: iload_1
    //   133: istore_3
    //   134: iload 4
    //   136: istore_2
    //   137: goto -92 -> 45
    //   140: aload_0
    //   141: getfield 14	khh:jdField_a_of_type_ComTencentAvUtilsTraeHelper	Lcom/tencent/av/utils/TraeHelper;
    //   144: iconst_2
    //   145: putfield 50	com/tencent/av/utils/TraeHelper:b	I
    //   148: goto -88 -> 60
    //   151: astore 5
    //   153: goto -63 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	khh
    //   29	104	1	i	int
    //   42	95	2	j	int
    //   44	90	3	k	int
    //   1	134	4	m	int
    //   15	66	5	localObject	Object
    //   86	36	5	localException1	java.lang.Exception
    //   151	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   17	30	86	java/lang/Exception
    //   30	43	151	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khh
 * JD-Core Version:    0.7.0.1
 */