import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class lhm
  extends lhs
{
  public static final String[] b;
  public final ConcurrentHashMap<String, Integer> a;
  public int b;
  private int c;
  public String d;
  
  static
  {
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "params.dat" };
  }
  
  public lhm(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_ArrayOfJavaLangString = jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public int a()
  {
    return 591;
  }
  
  public int a(String paramString)
  {
    Integer localInteger = null;
    if (!TextUtils.isEmpty(paramString)) {
      localInteger = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (localInteger == null) {
      return 50;
    }
    return localInteger.intValue();
  }
  
  public List<PendantItem> a(int paramInt, String paramString)
  {
    Object localObject = super.a(paramInt, paramString);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PendantItem localPendantItem = (PendantItem)((Iterator)localObject).next();
        if (localPendantItem != null) {
          localArrayList.add(localPendantItem);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "parse, cid[" + paramInt + "], config[" + paramString + "], size[" + localArrayList.size() + "]");
    }
    return localArrayList;
  }
  
  public lhu a(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Int == 3002) {
      a(0L, "getVideoPendant");
    }
    lhu locallhu = super.a(paramInt1, paramInt2);
    if ((locallhu != null) && (locallhu.a != null)) {
      locallhu.a.extraParam = Integer.valueOf(this.jdField_b_of_type_Int);
    }
    return locallhu;
  }
  
  public void a(int paramInt, String paramString)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 4, "MuteByOthers, fromMuteKey[" + paramInt + "], seq[" + l + "], data[" + paramString + "]");
    }
    if (paramInt == 3004) {}
    do
    {
      do
      {
        return;
        if (paramInt == 3002)
        {
          if (this.jdField_c_of_type_Int == 3003) {
            a(l, this.d);
          }
          this.jdField_c_of_type_Int = 3002;
          return;
        }
        if (paramInt != 3003) {
          break;
        }
      } while (!"creativecop".equals(paramString));
      this.jdField_c_of_type_Int = 3003;
      a(l, null);
      return;
    } while (paramInt != 3005);
    this.jdField_c_of_type_Int = 3005;
    a(l, null);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "clearMuteFlag, muteFlag[" + this.jdField_c_of_type_Int + "], from[" + paramString + "], cur[" + this.d + "], value[" + this.jdField_b_of_type_Int + "]");
    }
    if ((this.jdField_c_of_type_Int == 3003) || (this.jdField_c_of_type_Int == 3005)) {
      a(paramLong, this.d);
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (a()) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.equals(paramString, this.d)) && (paramInt == this.jdField_b_of_type_Int));
      this.d = paramString;
      this.jdField_b_of_type_Int = paramInt;
    } while (TextUtils.isEmpty(this.d));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.d, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    PendantItem localPendantItem = (PendantItem)a();
    if (localPendantItem == null)
    {
      this.d = null;
      this.jdField_b_of_type_Int = 50;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "onDestroyUI, peerUin[" + paramString + "], quit[" + paramBoolean + "], item[" + a() + "]");
      }
      return;
      this.d = localPendantItem.getId();
    }
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Int == 3002) || (this.jdField_c_of_type_Int == 3003);
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    if ((!a()) && (bool) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      lgt locallgt = (lgt)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
      if (locallgt != null) {
        locallgt.a(3004, paramPendantItem.getId());
      }
    }
    return bool;
  }
  
  public int b()
  {
    return 3004;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhm
 * JD-Core Version:    0.7.0.1
 */