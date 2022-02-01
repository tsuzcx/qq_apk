import com.tencent.av.VideoController;
import com.tencent.av.ui.VideoLayerUI;
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
  private VideoLayerUI jdField_a_of_type_ComTencentAvUiVideoLayerUI;
  private ArrayList<lcp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
  
  public mlm(VideoController paramVideoController, VideoLayerUI paramVideoLayerUI)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = paramVideoLayerUI;
  }
  
  private String a(long paramLong, int paramInt)
  {
    return String.valueOf(paramLong) + String.valueOf(paramInt);
  }
  
  public ArrayList<mlj> a()
  {
    synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      return localArrayList;
    }
  }
  
  public ArrayList<mlj> a(boolean paramBoolean)
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
    Object localObject11;
    Object localObject13;
    Object localObject14;
    synchronized (this.jdField_b_of_type_ArrayOfJavaLangObject)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        i = 1;
      }
      if ((i == 0) && (!paramBoolean)) {
        break label702;
      }
      synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        localObject11 = new HashMap();
        synchronized (this.jdField_a_of_type_ComTencentAvVideoController.a().d)
        {
          Iterator localIterator = this.jdField_a_of_type_ComTencentAvVideoController.a().d.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject13 = (lno)localIterator.next();
            ??? = new mlj();
            ((mlj)???).jdField_a_of_type_Long = ((lno)localObject13).jdField_a_of_type_Long;
            ((mlj)???).jdField_b_of_type_Int = ((lno)localObject13).jdField_a_of_type_Int;
            ((mlj)???).g = ((lno)localObject13).e;
            ((mlj)???).f = ((lno)localObject13).jdField_a_of_type_Boolean;
            ((mlj)???).e = true;
            ((mlj)???).jdField_a_of_type_Boolean = true;
            this.jdField_b_of_type_JavaUtilArrayList.add(???);
            localObject13 = a(((mlj)???).jdField_a_of_type_Long, ((mlj)???).jdField_b_of_type_Int);
            localObject14 = (mlj)((HashMap)localObject11).put(localObject13, ???);
          } while (localObject14 == null);
          if (((mlj)???).b()) {
            ((HashMap)localObject11).put(localObject13, localObject14);
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "getVideoViewList oldInfo:=" + ((mlj)localObject14).toString());
        }
      }
      localObject7 = finally;
      throw localObject7;
    }
    this.jdField_a_of_type_Int = this.jdField_b_of_type_JavaUtilArrayList.size();
    Object localObject9;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
      {
        localObject13 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject13).hasNext()) {
          break;
        }
        localObject14 = (lcp)((Iterator)localObject13).next();
        localObject9 = (mlj)((HashMap)localObject11).get(a(((lcp)localObject14).jdField_a_of_type_Long, 1));
        Object localObject3 = localObject9;
        if (localObject9 == null) {
          localObject3 = (mlj)((HashMap)localObject11).get(a(((lcp)localObject14).jdField_a_of_type_Long, 2));
        }
        if (localObject3 == null) {
          break label519;
        }
        if (((mlj)localObject3).b() != 2)
        {
          ((mlj)localObject3).jdField_b_of_type_Boolean = ((lcp)localObject14).jdField_a_of_type_Boolean;
          ((mlj)localObject3).jdField_a_of_type_Int = ((lcp)localObject14).d;
          ((mlj)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((lcp)localObject14).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
          ((mlj)localObject3).jdField_c_of_type_Boolean = ((lcp)localObject14).e;
          ((mlj)localObject3).d = ((lcp)localObject14).f;
        }
      }
      localObject4.jdField_b_of_type_Boolean = false;
      continue;
      label519:
      ??? = new mlj();
      ((mlj)???).jdField_a_of_type_Long = ((lcp)localObject14).jdField_a_of_type_Long;
      ((mlj)???).jdField_b_of_type_Int = 0;
      ((mlj)???).e = false;
      ((mlj)???).jdField_a_of_type_Boolean = ((lcp)localObject14).h;
      ((mlj)???).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((lcp)localObject14).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
      ((mlj)???).jdField_b_of_type_Boolean = ((lcp)localObject14).jdField_a_of_type_Boolean;
      ((mlj)???).jdField_a_of_type_Int = ((lcp)localObject14).d;
      ((mlj)???).jdField_c_of_type_Boolean = ((lcp)localObject14).e;
      ((mlj)???).d = ((lcp)localObject14).f;
      this.jdField_b_of_type_JavaUtilArrayList.add(???);
    }
    ??? = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject9 = (mlj)((Iterator)???).next();
      localObject11 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(((mlj)localObject9).jdField_a_of_type_Long);
      if (localObject11 != null)
      {
        ((mlj)localObject9).jdField_b_of_type_Boolean = ((mlj)localObject11).jdField_b_of_type_Boolean;
        ((mlj)localObject9).jdField_c_of_type_Boolean = ((mlj)localObject11).jdField_c_of_type_Boolean;
      }
    }
    label702:
    synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
    {
      localObject9 = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "getVideoViewList listSort exceedMaxNumber cost" + (System.currentTimeMillis() - l));
      }
      return localObject9;
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
  
  public void a(ArrayList<lcp> paramArrayList)
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
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
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
    synchronized (this.jdField_a_of_type_ArrayOfJavaLangObject)
    {
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mlm
 * JD-Core Version:    0.7.0.1
 */