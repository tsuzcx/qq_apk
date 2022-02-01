import com.tencent.av.VideoController;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class myx
{
  public final int a;
  private long a;
  public ChooseFileInfo a;
  public final String a;
  public final ArrayList<Long> a;
  public myr a;
  public myw a;
  public boolean a;
  public int b;
  public final String b;
  private boolean b;
  public int c;
  public final String c;
  private int d;
  private int e;
  
  public myx(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.d = a(paramInt);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Myw = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
  }
  
  private static int a(int paramInt)
  {
    int i = 3;
    if (paramInt == 3) {
      i = 2;
    }
    while (paramInt == 1) {
      return i;
    }
    return 0;
  }
  
  private static long a(lfe paramlfe)
  {
    VideoController localVideoController = VideoController.a();
    long l2 = paramlfe.b();
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = l2;
      if (localVideoController != null)
      {
        if (!paramlfe.r()) {
          break label41;
        }
        l1 = localVideoController.b(paramlfe);
      }
    }
    return l1;
    label41:
    return localVideoController.a(paramlfe);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public myw a()
  {
    if ((this.jdField_a_of_type_Myw == null) && (a())) {}
    for (this.jdField_a_of_type_Myw = new myw(this.d, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);; this.jdField_a_of_type_Myw = new myw(this.d, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString))
    {
      do
      {
        return this.jdField_a_of_type_Myw;
      } while ((this.jdField_a_of_type_Myw == null) || (this.jdField_a_of_type_Myw.a(this.d, this.jdField_a_of_type_Long)));
      if (QLog.isColorLevel()) {
        QLog.i("WatchTogetherInfo", 2, "checkAndCreateRoom, not same come[" + this.d + "," + this.jdField_a_of_type_Long + "], cur[" + this.jdField_a_of_type_Myw.jdField_a_of_type_Int + "," + this.jdField_a_of_type_Myw.b + "]");
      }
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WatchTogetherInfo", 2, "update, from[" + this.d + "," + this.jdField_a_of_type_Long + "], to[" + paramInt + "," + paramLong + "]");
    }
    if ((this.d != paramInt) || (this.jdField_a_of_type_Long != paramLong))
    {
      this.d = paramInt;
      this.jdField_a_of_type_Long = paramLong;
    }
    if (this.e == 1) {
      a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.e != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WatchTogetherInfo", 2, "updateFlag, [" + this.e + "-->" + paramInt + "], from[" + paramString + "]");
      }
      this.e = paramInt;
    }
  }
  
  public void a(lfe paramlfe, boolean paramBoolean)
  {
    if (paramlfe == null) {}
    do
    {
      return;
      if ((paramBoolean) || (this.d == 0)) {
        this.d = a(this.jdField_a_of_type_Int);
      }
      if ((paramBoolean) || (this.jdField_a_of_type_Long == 0L)) {
        this.jdField_a_of_type_Long = a(paramlfe);
      }
    } while (this.e != 1);
    a();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WatchTogetherInfo", 4, "updateChangeFileFlag, [" + this.jdField_b_of_type_Boolean + " --> " + paramBoolean + "], from[" + paramString + "");
      }
      this.jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Long != 0L) && (this.d != 0);
  }
  
  public long[] a()
  {
    long[] arrayOfLong = new long[this.jdField_a_of_type_JavaUtilArrayList.size()];
    int i = 0;
    if (i < arrayOfLong.length)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.get(i) != null) {
        arrayOfLong[i] = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue();
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfLong[i] = 0L;
      }
    }
    return arrayOfLong;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String toString()
  {
    return "WatchTogetherInfo{sessionId: " + this.jdField_b_of_type_JavaLangString + ", selfUin: " + this.jdField_a_of_type_JavaLangString + ", flag: " + this.e + ", relationType: " + this.jdField_a_of_type_Int + ", relationId: " + this.jdField_c_of_type_JavaLangString + ", roomType: " + this.d + ", roomId: " + this.jdField_a_of_type_Long + ", quitReason: " + this.jdField_b_of_type_Int + ", isChangingFile: " + this.jdField_b_of_type_Boolean + ", room: " + this.jdField_a_of_type_Myw + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myx
 * JD-Core Version:    0.7.0.1
 */