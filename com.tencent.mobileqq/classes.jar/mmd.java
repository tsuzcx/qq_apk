import com.tencent.av.VideoController;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class mmd
  implements mmb
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private VideoLayerUI jdField_a_of_type_ComTencentAvUiVideoLayerUI;
  private ArrayList<lcv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[0];
  private int jdField_b_of_type_Int = -1;
  private ArrayList<mma> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = true;
  private final Object[] jdField_b_of_type_ArrayOfJavaLangObject = new Object[0];
  private boolean jdField_c_of_type_Boolean;
  private final Object[] jdField_c_of_type_ArrayOfJavaLangObject = new Object[0];
  
  static
  {
    jdField_a_of_type_JavaLangString = mmd.class.getSimpleName();
  }
  
  public mmd(VideoController paramVideoController, VideoLayerUI paramVideoLayerUI)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUI = paramVideoLayerUI;
  }
  
  private String a(long paramLong, int paramInt)
  {
    return String.valueOf(paramLong) + String.valueOf(paramInt);
  }
  
  public ArrayList<mma> a()
  {
    synchronized (this.jdField_c_of_type_ArrayOfJavaLangObject)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_JavaUtilArrayList.clone();
      return localArrayList;
    }
  }
  
  public ArrayList<mma> a(boolean paramBoolean)
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
            ??? = new mma();
            ((mma)???).jdField_a_of_type_Long = ((lob)localObject13).jdField_a_of_type_Long;
            ((mma)???).jdField_b_of_type_Int = ((lob)localObject13).jdField_a_of_type_Int;
            ((mma)???).g = ((lob)localObject13).e;
            ((mma)???).f = ((lob)localObject13).jdField_a_of_type_Boolean;
            ((mma)???).e = true;
            ((mma)???).jdField_a_of_type_Boolean = true;
            this.jdField_b_of_type_JavaUtilArrayList.add(???);
            localObject13 = a(((mma)???).jdField_a_of_type_Long, ((mma)???).jdField_b_of_type_Int);
            localObject14 = (mma)((HashMap)localObject11).put(localObject13, ???);
          } while (localObject14 == null);
          if (((mma)???).b()) {
            ((HashMap)localObject11).put(localObject13, localObject14);
          }
          QLog.w(jdField_a_of_type_JavaLangString, 1, "getVideoViewList oldInfo:=" + ((mma)localObject14).toString());
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
        localObject14 = (lcv)((Iterator)localObject13).next();
        localObject9 = (mma)((HashMap)localObject11).get(a(((lcv)localObject14).jdField_a_of_type_Long, 1));
        Object localObject3 = localObject9;
        if (localObject9 == null) {
          localObject3 = (mma)((HashMap)localObject11).get(a(((lcv)localObject14).jdField_a_of_type_Long, 2));
        }
        if (localObject3 == null) {
          break label519;
        }
        if (((mma)localObject3).b() != 2)
        {
          ((mma)localObject3).jdField_b_of_type_Boolean = ((lcv)localObject14).jdField_a_of_type_Boolean;
          ((mma)localObject3).jdField_a_of_type_Int = ((lcv)localObject14).d;
          ((mma)localObject3).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((lcv)localObject14).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
          ((mma)localObject3).jdField_c_of_type_Boolean = ((lcv)localObject14).e;
          ((mma)localObject3).d = ((lcv)localObject14).f;
        }
      }
      localObject4.jdField_b_of_type_Boolean = false;
      continue;
      label519:
      ??? = new mma();
      ((mma)???).jdField_a_of_type_Long = ((lcv)localObject14).jdField_a_of_type_Long;
      ((mma)???).jdField_b_of_type_Int = 0;
      ((mma)???).e = false;
      ((mma)???).jdField_a_of_type_Boolean = ((lcv)localObject14).h;
      ((mma)???).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo = ((lcv)localObject14).jdField_a_of_type_ComTencentAvGaudioAVPhoneUserInfo;
      ((mma)???).jdField_b_of_type_Boolean = ((lcv)localObject14).jdField_a_of_type_Boolean;
      ((mma)???).jdField_a_of_type_Int = ((lcv)localObject14).d;
      ((mma)???).jdField_c_of_type_Boolean = ((lcv)localObject14).e;
      ((mma)???).d = ((lcv)localObject14).f;
      this.jdField_b_of_type_JavaUtilArrayList.add(???);
    }
    ??? = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject9 = (mma)((Iterator)???).next();
      localObject11 = this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(((mma)localObject9).jdField_a_of_type_Long);
      if (localObject11 != null)
      {
        ((mma)localObject9).jdField_b_of_type_Boolean = ((mma)localObject11).jdField_b_of_type_Boolean;
        ((mma)localObject9).jdField_c_of_type_Boolean = ((mma)localObject11).jdField_c_of_type_Boolean;
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
  
  public void a(ArrayList<lcv> paramArrayList)
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
 * Qualified Name:     mmd
 * JD-Core Version:    0.7.0.1
 */