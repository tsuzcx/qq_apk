import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class mav
  implements mat
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private ArrayList<kth> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[0];
  private int jdField_b_of_type_Int = -1;
  private ArrayList<mas> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private final Object[] jdField_b_of_type_ArrayOfJavaLangObject = new Object[0];
  private boolean jdField_c_of_type_Boolean;
  private final Object[] jdField_c_of_type_ArrayOfJavaLangObject = new Object[0];
  
  static
  {
    jdField_a_of_type_JavaLangString = mav.class.getSimpleName();
  }
  
  public mav(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public ArrayList<mas> a()
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
            localObject9 = (leb)localIterator.next();
            localObject8 = new mas();
            ((mas)localObject8).jdField_a_of_type_Long = ((leb)localObject9).jdField_a_of_type_Long;
            ((mas)localObject8).jdField_b_of_type_Int = ((leb)localObject9).jdField_a_of_type_Int;
            ((mas)localObject8).g = ((leb)localObject9).e;
            ((mas)localObject8).f = ((leb)localObject9).jdField_a_of_type_Boolean;
            ((mas)localObject8).e = true;
            ((mas)localObject8).jdField_a_of_type_Boolean = true;
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject8);
            localObject9 = (mas)localHashMap.put(Long.valueOf(((mas)localObject8).jdField_a_of_type_Long), localObject8);
          } while (localObject9 == null);
          if (((mas)localObject8).b()) {
            localHashMap.put(Long.valueOf(((mas)localObject8).jdField_a_of_type_Long), localObject9);
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "getVideoViewList oldInfo:=" + ((mas)localObject9).toString());
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
        localObject8 = (kth)localIterator.next();
        localObject9 = (mas)localObject4.get(Long.valueOf(((kth)localObject8).jdField_a_of_type_Long));
        if (localObject9 == null) {
          break label480;
        }
        if (((mas)localObject9).b() != 2)
        {
          ((mas)localObject9).jdField_b_of_type_Boolean = ((kth)localObject8).jdField_a_of_type_Boolean;
          ((mas)localObject9).jdField_a_of_type_Int = ((kth)localObject8).c;
          ((mas)localObject9).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((kth)localObject8).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
          ((mas)localObject9).jdField_c_of_type_Boolean = ((kth)localObject8).e;
          ((mas)localObject9).d = ((kth)localObject8).f;
        }
      }
      ((mas)localObject9).jdField_b_of_type_Boolean = false;
      continue;
      label480:
      localObject9 = new mas();
      ((mas)localObject9).jdField_a_of_type_Long = ((kth)localObject8).jdField_a_of_type_Long;
      ((mas)localObject9).jdField_b_of_type_Int = 0;
      ((mas)localObject9).e = false;
      ((mas)localObject9).jdField_a_of_type_Boolean = ((kth)localObject8).h;
      ((mas)localObject9).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((kth)localObject8).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
      ((mas)localObject9).jdField_b_of_type_Boolean = ((kth)localObject8).jdField_a_of_type_Boolean;
      ((mas)localObject9).jdField_a_of_type_Int = ((kth)localObject8).c;
      ((mas)localObject9).jdField_c_of_type_Boolean = ((kth)localObject8).e;
      ((mas)localObject9).d = ((kth)localObject8).f;
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
  
  public void a(ArrayList<kth> paramArrayList)
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
          mas localmas = (mas)localIterator.next();
          if ((localmas.a() != paramLong) || (localmas.b() == 2)) {
            continue;
          }
          if (localmas.jdField_b_of_type_Boolean != paramBoolean)
          {
            localmas.jdField_b_of_type_Boolean = paramBoolean;
            paramBoolean = true;
            return paramBoolean;
          }
        }
      }
      paramBoolean = false;
    }
  }
  
  public ArrayList<mas> b()
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
          mas localmas = (mas)localIterator.next();
          if ((localmas.a() != paramLong) || (localmas.b() == 2)) {
            continue;
          }
          if (localmas.jdField_c_of_type_Boolean != paramBoolean)
          {
            localmas.jdField_c_of_type_Boolean = paramBoolean;
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
 * Qualified Name:     mav
 * JD-Core Version:    0.7.0.1
 */