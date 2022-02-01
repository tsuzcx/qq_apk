import android.text.TextUtils;
import com.qq.wx.voice.embed.recognizer.GrammarNative;
import com.tencent.av.so.ResInfo;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class nnj
{
  private static volatile nnj jdField_a_of_type_Nnj;
  private int jdField_a_of_type_Int = -1;
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("[,，。、 ]", "");
  }
  
  public static nnj a()
  {
    if (jdField_a_of_type_Nnj == null) {}
    try
    {
      if (jdField_a_of_type_Nnj == null) {
        jdField_a_of_type_Nnj = new nnj();
      }
      return jdField_a_of_type_Nnj;
    }
    finally {}
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_Int == 1) {}
    try
    {
      paramInt = GrammarNative.recognize(paramArrayOfByte, paramInt);
      i = paramInt;
      if (paramInt < 0) {
        i = -1;
      }
      return i;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1;
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (nqg)aqxe.a().a(642);
        if (localObject1 != null)
        {
          Object localObject3 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject3 != null) && ((localObject3 instanceof AVGameAppInterface)))
          {
            bool = ((nqg)localObject1).a(Long.valueOf(((AVGameAppInterface)localObject3).getCurrentAccountUin()).longValue());
            if (!bool)
            {
              QLog.e("AVGameVoiceRecog", 1, "init failed. isUseLocalVoiceRecog = false.");
              bool = false;
              return bool;
            }
            localObject1 = mal.a().a("AVGameVoiceRecogSo");
            localObject3 = mal.a().a("AVGameVoiceRecogModel");
            QLog.i("AVGameVoiceRecog", 1, "init. soFullFileName = " + (String)localObject1 + ", modelFullFileName = " + (String)localObject3);
            ResInfo localResInfo1 = mal.a().a("AVGameVoiceRecogSo");
            ResInfo localResInfo2 = mal.a().a("AVGameVoiceRecogModel");
            if ((localResInfo1 == null) || (localResInfo2 == null))
            {
              QLog.e("AVGameVoiceRecog", 1, "init failed. soResInfo == null || modelResInfo == null.");
              bool = false;
              continue;
            }
            if (!mal.a().b("AVGameVoiceRecogSo"))
            {
              mal.a().a("AVGameVoiceRecogSo");
              QLog.e("AVGameVoiceRecog", 1, "init failed. so file no exist.");
              bool = false;
              continue;
            }
            if (!mal.a().b("AVGameVoiceRecogModel"))
            {
              mal.a().a("AVGameVoiceRecogModel");
              QLog.e("AVGameVoiceRecog", 1, "init failed. model file no exist.");
              bool = false;
              continue;
            }
            try
            {
              System.load((String)localObject1);
              localObject1 = new File((String)localObject3);
              int i = GrammarNative.init(((File)localObject1).getParent().getBytes(), ((File)localObject1).getName().getBytes(), null);
              if (i >= 0) {
                continue;
              }
              bool = false;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
            {
              QLog.e("AVGameVoiceRecog", 1, "init failed. load so failed." + localUnsatisfiedLinkError);
              bool = false;
            }
            catch (Throwable localThrowable)
            {
              QLog.e("AVGameVoiceRecog", 1, "init failed. load so failed." + localThrowable);
              bool = false;
            }
            continue;
            this.jdField_a_of_type_Int = 0;
            QLog.i("AVGameVoiceRecog", 1, "init successfully.");
            bool = true;
            continue;
          }
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      int i = GrammarNative.update(a(paramString).getBytes("GBK"));
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 1;
      try
      {
        int i = GrammarNative.begin();
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Int = 0;
      try
      {
        int i = GrammarNative.end();
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +31 -> 36
    //   8: ldc 90
    //   10: iconst_2
    //   11: new 111	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   18: ldc 198
    //   20: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: getfield 13	nnj:jdField_a_of_type_Int	I
    //   27: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aload_0
    //   37: getfield 13	nnj:jdField_a_of_type_Int	I
    //   40: istore_1
    //   41: iload_1
    //   42: iconst_m1
    //   43: if_icmpeq +25 -> 68
    //   46: invokestatic 206	com/qq/wx/voice/embed/recognizer/GrammarNative:destroy	()I
    //   49: ifne +19 -> 68
    //   52: aload_0
    //   53: iconst_m1
    //   54: putfield 13	nnj:jdField_a_of_type_Int	I
    //   57: iconst_1
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_2
    //   62: ireturn
    //   63: astore_3
    //   64: aload_3
    //   65: invokevirtual 207	java/lang/Exception:printStackTrace	()V
    //   68: iconst_0
    //   69: istore_2
    //   70: goto -11 -> 59
    //   73: astore_3
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_3
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	nnj
    //   40	4	1	i	int
    //   58	12	2	bool	boolean
    //   63	2	3	localException	java.lang.Exception
    //   73	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   46	57	63	java/lang/Exception
    //   2	36	73	finally
    //   36	41	73	finally
    //   46	57	73	finally
    //   64	68	73	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nnj
 * JD-Core Version:    0.7.0.1
 */