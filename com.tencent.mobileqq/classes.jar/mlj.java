import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class mlj
  implements mlh
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private ArrayList<ldr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[0];
  private int jdField_b_of_type_Int = -1;
  private ArrayList<mlg> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private final Object[] jdField_b_of_type_ArrayOfJavaLangObject = new Object[0];
  private boolean jdField_c_of_type_Boolean;
  private final Object[] jdField_c_of_type_ArrayOfJavaLangObject = new Object[0];
  
  static
  {
    jdField_a_of_type_JavaLangString = mlj.class.getSimpleName();
  }
  
  public mlj(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public ArrayList<mlg> a()
  {
    int i = 0;
    long l = System.currentTimeMillis();
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        i = 1;
      }
    }
    Iterator localIterator;
    Object localObject9;
    Object localObject8;
    synchronized (this.jdField_b_of_type_ArrayOfJavaLangObject)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        i = 1;
      }
      if (i == 0) {
        break label590;
      }
      synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        HashMap localHashMap = new HashMap();
        synchronized (this.jdField_a_of_type_ComTencentAvVideoController.a().d)
        {
          localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().d.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject9 = (lon)localIterator.next();
            localObject8 = new mlg();
            ((mlg)localObject8).jdField_a_of_type_Long = ((lon)localObject9).jdField_a_of_type_Long;
            ((mlg)localObject8).jdField_b_of_type_Int = ((lon)localObject9).jdField_a_of_type_Int;
            ((mlg)localObject8).g = ((lon)localObject9).e;
            ((mlg)localObject8).f = ((lon)localObject9).jdField_a_of_type_Boolean;
            ((mlg)localObject8).e = true;
            ((mlg)localObject8).jdField_a_of_type_Boolean = true;
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject8);
            localObject9 = (mlg)localHashMap.put(Long.valueOf(((mlg)localObject8).jdField_a_of_type_Long), localObject8);
          } while (localObject9 == null);
          if (((mlg)localObject8).b()) {
            localHashMap.put(Long.valueOf(((mlg)localObject8).jdField_a_of_type_Long), localObject9);
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "getVideoViewList oldInfo:=" + ((mlg)localObject9).toString());
        }
      }
      localObject3 = finally;
      throw localObject3;
    }
    this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilArrayList.size();
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
      {
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject8 = (ldr)localIterator.next();
        localObject9 = (mlg)localObject4.get(Long.valueOf(((ldr)localObject8).jdField_a_of_type_Long));
        if (localObject9 == null) {
          break label480;
        }
        if (((mlg)localObject9).b() != 2)
        {
          ((mlg)localObject9).jdField_b_of_type_Boolean = ((ldr)localObject8).jdField_a_of_type_Boolean;
          ((mlg)localObject9).jdField_a_of_type_Int = ((ldr)localObject8).c;
          ((mlg)localObject9).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((ldr)localObject8).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
          ((mlg)localObject9).jdField_c_of_type_Boolean = ((ldr)localObject8).e;
          ((mlg)localObject9).d = ((ldr)localObject8).f;
        }
      }
      ((mlg)localObject9).jdField_b_of_type_Boolean = false;
      continue;
      label480:
      localObject9 = new mlg();
      ((mlg)localObject9).jdField_a_of_type_Long = ((ldr)localObject8).jdField_a_of_type_Long;
      ((mlg)localObject9).jdField_b_of_type_Int = 0;
      ((mlg)localObject9).e = false;
      ((mlg)localObject9).jdField_a_of_type_Boolean = ((ldr)localObject8).h;
      ((mlg)localObject9).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((ldr)localObject8).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
      ((mlg)localObject9).jdField_b_of_type_Boolean = ((ldr)localObject8).jdField_a_of_type_Boolean;
      ((mlg)localObject9).jdField_a_of_type_Int = ((ldr)localObject8).c;
      ((mlg)localObject9).jdField_c_of_type_Boolean = ((ldr)localObject8).e;
      ((mlg)localObject9).d = ((ldr)localObject8).f;
      this.jdField_b_of_type_JavaUtilArrayList.add(localObject9);
    }
    label590:
    synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "getVideoViewList listSort exceedMaxNumber cost" + (System.currentTimeMillis() - l));
      }
      return localArrayList;
    }
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onMemmbersInOrOutChange");
    synchronized (this.jdField_b_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(ArrayList<ldr> paramArrayList)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "updateAudioMemberListInfo");
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
      return;
    }
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    for (;;)
    {
      synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          mlg localmlg = (mlg)localIterator.next();
          if ((localmlg.a() != paramLong) || (localmlg.b() == 2)) {
            continue;
          }
          if (localmlg.jdField_b_of_type_Boolean != paramBoolean)
          {
            localmlg.jdField_b_of_type_Boolean = paramBoolean;
            paramBoolean = true;
            return paramBoolean;
          }
        }
      }
      paramBoolean = false;
    }
  }
  
  public ArrayList<mlg> b()
  {
    synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      return localArrayList;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_c_of_type_Boolean = true;
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public boolean b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    for (;;)
    {
      synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          mlg localmlg = (mlg)localIterator.next();
          if ((localmlg.a() != paramLong) || (localmlg.b() == 2)) {
            continue;
          }
          if (localmlg.jdField_c_of_type_Boolean != paramBoolean)
          {
            localmlg.jdField_c_of_type_Boolean = paramBoolean;
            paramBoolean = true;
            return paramBoolean;
          }
        }
      }
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mlj
 * JD-Core Version:    0.7.0.1
 */