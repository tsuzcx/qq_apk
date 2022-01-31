package cooperation.qappcenter.remote;

import amuk;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class SendMsg
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new amuk();
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  public final Bundle a;
  public IActionListener a;
  public String a;
  long b = -1L;
  
  public SendMsg(Parcel paramParcel)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    a(paramParcel);
  }
  
  public SendMsg(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  /* Error */
  private void a(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 53	android/os/Parcel:readInt	()I
    //   5: putfield 55	cooperation/qappcenter/remote/SendMsg:jdField_a_of_type_Int	I
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 59	android/os/Parcel:readString	()Ljava/lang/String;
    //   13: putfield 43	cooperation/qappcenter/remote/SendMsg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 63	android/os/Parcel:readLong	()J
    //   21: putfield 36	cooperation/qappcenter/remote/SendMsg:jdField_a_of_type_Long	J
    //   24: aload_0
    //   25: getfield 32	cooperation/qappcenter/remote/SendMsg:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   28: invokevirtual 66	android/os/Bundle:clear	()V
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual 70	java/lang/Object:getClass	()Ljava/lang/Class;
    //   36: invokevirtual 76	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   39: invokevirtual 80	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   42: astore_2
    //   43: aload_2
    //   44: invokestatic 86	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   47: invokestatic 91	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Context;)Ljava/lang/ClassLoader;
    //   50: invokevirtual 95	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   53: aload_0
    //   54: getfield 32	cooperation/qappcenter/remote/SendMsg:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   57: aload_2
    //   58: invokevirtual 99	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   61: aload_0
    //   62: aload_1
    //   63: invokevirtual 103	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   66: invokestatic 108	cooperation/qappcenter/remote/IActionListener$Stub:a	(Landroid/os/IBinder;)Lcooperation/qappcenter/remote/IActionListener;
    //   69: putfield 110	cooperation/qappcenter/remote/SendMsg:jdField_a_of_type_CooperationQappcenterRemoteIActionListener	Lcooperation/qappcenter/remote/IActionListener;
    //   72: return
    //   73: astore_3
    //   74: aload_3
    //   75: invokevirtual 113	java/lang/Exception:printStackTrace	()V
    //   78: goto -25 -> 53
    //   81: astore_1
    //   82: ldc 115
    //   84: iconst_1
    //   85: ldc 117
    //   87: aload_1
    //   88: invokestatic 123	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	SendMsg
    //   0	93	1	paramParcel	Parcel
    //   42	16	2	localBundle	Bundle
    //   73	2	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   43	53	73	java/lang/Exception
    //   0	43	81	java/lang/RuntimeException
    //   43	53	81	java/lang/RuntimeException
    //   53	72	81	java/lang/RuntimeException
    //   74	78	81	java/lang/RuntimeException
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public IActionListener a()
  {
    return this.jdField_a_of_type_CooperationQappcenterRemoteIActionListener;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "SendMsg appSeq:" + this.jdField_a_of_type_Int + " serviceCmd:" + this.jdField_a_of_type_JavaLangString + " timeout:" + this.jdField_a_of_type_Long;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
      paramParcel.writeStrongInterface(this.jdField_a_of_type_CooperationQappcenterRemoteIActionListener);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.w("SendMsg", 1, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qappcenter.remote.SendMsg
 * JD-Core Version:    0.7.0.1
 */