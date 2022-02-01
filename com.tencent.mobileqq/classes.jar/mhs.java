import android.content.Context;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mhs
  implements lgk<PendantItem>, mgy
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final ArrayList<mhr> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private final lhm jdField_a_of_type_Lhm;
  private mgr jdField_a_of_type_Mgr;
  
  public mhs(int paramInt, lhm paramlhm)
  {
    this.jdField_a_of_type_JavaLangString = ("QavListItemHelper" + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Lhm = paramlhm;
  }
  
  public static mhr a(int paramInt, PendantItem paramPendantItem)
  {
    mhr localmhr = new mhr();
    localmhr.jdField_a_of_type_Int = paramInt;
    localmhr.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localmhr.jdField_c_of_type_JavaLangString = paramPendantItem.getDesc();
    localmhr.b = paramPendantItem.getIconurl();
    localmhr.jdField_d_of_type_JavaLangString = paramPendantItem.getDesc();
    localmhr.jdField_c_of_type_Boolean = false;
    localmhr.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localmhr.jdField_a_of_type_JavaLangObject = paramPendantItem;
    if (paramInt == 4) {
      localmhr.jdField_d_of_type_Boolean = true;
    }
    return localmhr;
  }
  
  public ArrayList<mhr> a(Context paramContext)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Int == 5)
    {
      localObject = new mhr();
      ((mhr)localObject).jdField_d_of_type_Boolean = false;
      ((mhr)localObject).jdField_a_of_type_JavaLangString = "-1";
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    Object localObject = new mhr();
    ((mhr)localObject).jdField_a_of_type_JavaLangString = "0";
    ((mhr)localObject).b = String.valueOf(2130842211);
    ((mhr)localObject).jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int == 4)
    {
      ((mhr)localObject).jdField_d_of_type_Boolean = true;
      ((mhr)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131694925);
    }
    for (((mhr)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131694926);; ((mhr)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131694925))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if (this.jdField_a_of_type_Lhm == null) {
        break;
      }
      paramContext = this.jdField_a_of_type_Lhm.a(null);
      localObject = (PendantItem)this.jdField_a_of_type_Lhm.a();
      if ((localObject != null) && (!paramContext.contains(localObject))) {
        this.jdField_a_of_type_Lhm.a(l, null);
      }
      if ((paramContext == null) || (paramContext.size() <= 0)) {
        break;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        localObject = (PendantItem)paramContext.next();
        if (localObject != null)
        {
          localObject = a(this.jdField_a_of_type_Int, (PendantItem)localObject);
          if (localObject != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          }
        }
      }
      ((mhr)localObject).jdField_d_of_type_Boolean = false;
      ((mhr)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131694925);
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(long paramLong, PendantItem paramPendantItem)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onItemSelectedChanged, seq[" + paramLong + "], current[" + paramPendantItem + "]");
    }
  }
  
  public void a(long paramLong, PendantItem paramPendantItem, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "onDownloadFinish, seq[" + paramLong + "], isSuc[" + paramBoolean + "], info[" + paramPendantItem + "]");
    }
    if (this.jdField_a_of_type_Mgr != null) {
      this.jdField_a_of_type_Mgr.a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void a(PendantItem paramPendantItem, int paramInt)
  {
    if (this.jdField_a_of_type_Mgr != null) {
      this.jdField_a_of_type_Mgr.a(paramPendantItem.getId(), paramInt);
    }
  }
  
  public void a(mgr parammgr)
  {
    this.jdField_a_of_type_Mgr = parammgr;
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, mhr parammhr, mhq parammhq)
  {
    paramAppInterface = null;
    if (this.jdField_a_of_type_Lhm != null) {
      paramAppInterface = (PendantItem)this.jdField_a_of_type_Lhm.a(parammhr.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "startDownloadTemplate, seq[" + paramLong + "], item[" + paramAppInterface + "]");
    }
    if (paramAppInterface != null)
    {
      this.jdField_a_of_type_Lhm.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammhq.a(paramLong, parammhr.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhs
 * JD-Core Version:    0.7.0.1
 */