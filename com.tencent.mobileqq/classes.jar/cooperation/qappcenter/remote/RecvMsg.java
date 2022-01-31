package cooperation.qappcenter.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import biob;
import com.tencent.qphone.base.util.QLog;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<RecvMsg> CREATOR = new biob();
  public int a;
  public Bundle a;
  public String a;
  public int b;
  
  public RecvMsg()
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
  }
  
  public RecvMsg(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_Int = 1001;
    this.b = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    a(paramParcel);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getInt("_ssoSeqKey", -1);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsBundle.putString("error", paramString);
  }
  
  /* Error */
  public void a(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 64	android/os/Parcel:readInt	()I
    //   5: putfield 37	cooperation/qappcenter/remote/RecvMsg:b	I
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 64	android/os/Parcel:readInt	()I
    //   13: putfield 35	cooperation/qappcenter/remote/RecvMsg:jdField_a_of_type_Int	I
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 68	android/os/Parcel:readString	()Ljava/lang/String;
    //   21: putfield 39	cooperation/qappcenter/remote/RecvMsg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   24: aload_0
    //   25: getfield 32	cooperation/qappcenter/remote/RecvMsg:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   28: invokevirtual 71	android/os/Bundle:clear	()V
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual 75	java/lang/Object:getClass	()Ljava/lang/Class;
    //   36: invokevirtual 81	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   39: invokevirtual 85	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic 91	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   47: invokestatic 96	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Context;)Ljava/lang/ClassLoader;
    //   50: invokevirtual 100	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   53: aload_0
    //   54: getfield 32	cooperation/qappcenter/remote/RecvMsg:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   57: aload_1
    //   58: invokevirtual 104	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   61: return
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   67: goto -14 -> 53
    //   70: astore_1
    //   71: ldc 109
    //   73: iconst_1
    //   74: ldc 111
    //   76: aload_1
    //   77: invokestatic 117	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	RecvMsg
    //   0	82	1	paramParcel	Parcel
    //   62	2	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   43	53	62	java/lang/Exception
    //   0	43	70	java/lang/RuntimeException
    //   43	53	70	java/lang/RuntimeException
    //   53	61	70	java/lang/RuntimeException
    //   63	67	70	java/lang/RuntimeException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "RecvMsg ssoseq:" + a() + " resultCode:" + this.jdField_a_of_type_Int + " serviceCmd:" + this.jdField_a_of_type_JavaLangString + " appSeq:" + this.b;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.b);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.w("RecvMsg", 1, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qappcenter.remote.RecvMsg
 * JD-Core Version:    0.7.0.1
 */