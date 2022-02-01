import com.tencent.av.VideoController;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class mmj
  implements mmh
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private VideoLayerUI jdField_a_of_type_ComTencentAvUiVideoLayerUI;
  private ArrayList<lcu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[0];
  private int jdField_b_of_type_Int = -1;
  private ArrayList<mmg> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private final Object[] jdField_b_of_type_ArrayOfJavaLangObject = new Object[0];
  private boolean jdField_c_of_type_Boolean;
  private final Object[] jdField_c_of_type_ArrayOfJavaLangObject = new Object[0];
  
  static
  {
    jdField_a_of_type_JavaLangString = mmj.class.getSimpleName();
  }
  
  public mmj(VideoController paramVideoController, VideoLayerUI paramVideoLayerUI)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = paramVideoLayerUI;
  }
  
  private String a(long paramLong, int paramInt)
  {
    return String.valueOf(paramLong) + String.valueOf(paramInt);
  }
  
  public ArrayList<mmg> a()
  {
    synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      return localArrayList;
    }
  }
  
  public ArrayList<mmg> a(boolean paramBoolean)
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
            localObject13 = (lob)localIterator.next();
            ??? = new mmg();
            ((mmg)???).jdField_a_of_type_Long = ((lob)localObject13).jdField_a_of_type_Long;
            ((mmg)???).jdField_b_of_type_Int = ((lob)localObject13).jdField_a_of_type_Int;
            ((mmg)???).g = ((lob)localObject13).e;
            ((mmg)???).f = ((lob)localObject13).jdField_a_of_type_Boolean;
            ((mmg)???).e = true;
            ((mmg)???).jdField_a_of_type_Boolean = true;
            this.jdField_b_of_type_JavaUtilArrayList.add(???);
            localObject13 = a(((mmg)???).jdField_a_of_type_Long, ((mmg)???).jdField_b_of_type_Int);
            localObject14 = (mmg)((HashMap)localObject11).put(localObject13, ???);
          } while (localObject14 == null);
          if (((mmg)???).b()) {
            ((HashMap)localObject11).put(localObject13, localObject14);
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "getVideoViewList oldInfo:=" + ((mmg)localObject14).toString());
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
        localObject14 = (lcu)((Iterator)localObject13).next();
        localObject9 = (mmg)((HashMap)localObject11).get(a(((lcu)localObject14).jdField_a_of_type_Long, 1));
        Object localObject3 = localObject9;
        if (localObject9 == null) {
          localObject3 = (mmg)((HashMap)localObject11).get(a(((lcu)localObject14).jdField_a_of_type_Long, 2));
        }
        if (localObject3 == null) {
          break label519;
        }
        if (((mmg)localObject3).b() != 2)
        {
          ((mmg)localObject3).jdField_b_of_type_Boolean = ((lcu)localObject14).jdField_a_of_type_Boolean;
          ((mmg)localObject3).jdField_a_of_type_Int = ((lcu)localObject14).d;
          ((mmg)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((lcu)localObject14).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
          ((mmg)localObject3).jdField_c_of_type_Boolean = ((lcu)localObject14).e;
          ((mmg)localObject3).d = ((lcu)localObject14).f;
        }
      }
      localObject4.jdField_b_of_type_Boolean = false;
      continue;
      label519:
      ??? = new mmg();
      ((mmg)???).jdField_a_of_type_Long = ((lcu)localObject14).jdField_a_of_type_Long;
      ((mmg)???).jdField_b_of_type_Int = 0;
      ((mmg)???).e = false;
      ((mmg)???).jdField_a_of_type_Boolean = ((lcu)localObject14).h;
      ((mmg)???).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((lcu)localObject14).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
      ((mmg)???).jdField_b_of_type_Boolean = ((lcu)localObject14).jdField_a_of_type_Boolean;
      ((mmg)???).jdField_a_of_type_Int = ((lcu)localObject14).d;
      ((mmg)???).jdField_c_of_type_Boolean = ((lcu)localObject14).e;
      ((mmg)???).d = ((lcu)localObject14).f;
      this.jdField_b_of_type_JavaUtilArrayList.add(???);
    }
    ??? = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject9 = (mmg)((Iterator)???).next();
      localObject11 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(((mmg)localObject9).jdField_a_of_type_Long);
      if (localObject11 != null)
      {
        ((mmg)localObject9).jdField_b_of_type_Boolean = ((mmg)localObject11).jdField_b_of_type_Boolean;
        ((mmg)localObject9).jdField_c_of_type_Boolean = ((mmg)localObject11).jdField_c_of_type_Boolean;
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
  
  public void a(ArrayList<lcu> paramArrayList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mmj
 * JD-Core Version:    0.7.0.1
 */