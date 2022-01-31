import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class mlm
  implements mlk
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private ArrayList<ldw> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[0];
  private int jdField_b_of_type_Int = -1;
  private ArrayList<mlj> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private final Object[] jdField_b_of_type_ArrayOfJavaLangObject = new Object[0];
  private boolean jdField_c_of_type_Boolean;
  private final Object[] jdField_c_of_type_ArrayOfJavaLangObject = new Object[0];
  
  static
  {
    jdField_a_of_type_JavaLangString = mlm.class.getSimpleName();
  }
  
  public mlm(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public ArrayList<mlj> a()
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
            localObject9 = (los)localIterator.next();
            localObject8 = new mlj();
            ((mlj)localObject8).jdField_a_of_type_Long = ((los)localObject9).jdField_a_of_type_Long;
            ((mlj)localObject8).jdField_b_of_type_Int = ((los)localObject9).jdField_a_of_type_Int;
            ((mlj)localObject8).g = ((los)localObject9).e;
            ((mlj)localObject8).f = ((los)localObject9).jdField_a_of_type_Boolean;
            ((mlj)localObject8).e = true;
            ((mlj)localObject8).jdField_a_of_type_Boolean = true;
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject8);
            localObject9 = (mlj)localHashMap.put(Long.valueOf(((mlj)localObject8).jdField_a_of_type_Long), localObject8);
          } while (localObject9 == null);
          if (((mlj)localObject8).b()) {
            localHashMap.put(Long.valueOf(((mlj)localObject8).jdField_a_of_type_Long), localObject9);
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "getVideoViewList oldInfo:=" + ((mlj)localObject9).toString());
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
        localObject8 = (ldw)localIterator.next();
        localObject9 = (mlj)localObject4.get(Long.valueOf(((ldw)localObject8).jdField_a_of_type_Long));
        if (localObject9 == null) {
          break label480;
        }
        if (((mlj)localObject9).b() != 2)
        {
          ((mlj)localObject9).jdField_b_of_type_Boolean = ((ldw)localObject8).jdField_a_of_type_Boolean;
          ((mlj)localObject9).jdField_a_of_type_Int = ((ldw)localObject8).c;
          ((mlj)localObject9).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((ldw)localObject8).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
          ((mlj)localObject9).jdField_c_of_type_Boolean = ((ldw)localObject8).e;
          ((mlj)localObject9).d = ((ldw)localObject8).f;
        }
      }
      ((mlj)localObject9).jdField_b_of_type_Boolean = false;
      continue;
      label480:
      localObject9 = new mlj();
      ((mlj)localObject9).jdField_a_of_type_Long = ((ldw)localObject8).jdField_a_of_type_Long;
      ((mlj)localObject9).jdField_b_of_type_Int = 0;
      ((mlj)localObject9).e = false;
      ((mlj)localObject9).jdField_a_of_type_Boolean = ((ldw)localObject8).h;
      ((mlj)localObject9).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((ldw)localObject8).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
      ((mlj)localObject9).jdField_b_of_type_Boolean = ((ldw)localObject8).jdField_a_of_type_Boolean;
      ((mlj)localObject9).jdField_a_of_type_Int = ((ldw)localObject8).c;
      ((mlj)localObject9).jdField_c_of_type_Boolean = ((ldw)localObject8).e;
      ((mlj)localObject9).d = ((ldw)localObject8).f;
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
  
  public void a(ArrayList<ldw> paramArrayList)
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
          mlj localmlj = (mlj)localIterator.next();
          if ((localmlj.a() != paramLong) || (localmlj.b() == 2)) {
            continue;
          }
          if (localmlj.jdField_b_of_type_Boolean != paramBoolean)
          {
            localmlj.jdField_b_of_type_Boolean = paramBoolean;
            paramBoolean = true;
            return paramBoolean;
          }
        }
      }
      paramBoolean = false;
    }
  }
  
  public ArrayList<mlj> b()
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
          mlj localmlj = (mlj)localIterator.next();
          if ((localmlj.a() != paramLong) || (localmlj.b() == 2)) {
            continue;
          }
          if (localmlj.jdField_c_of_type_Boolean != paramBoolean)
          {
            localmlj.jdField_c_of_type_Boolean = paramBoolean;
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
 * Qualified Name:     mlm
 * JD-Core Version:    0.7.0.1
 */