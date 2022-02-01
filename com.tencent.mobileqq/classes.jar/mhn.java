import android.content.Context;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mhn
  implements lgi<PendantItem>, mgt
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final ArrayList<mhm> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private final lhk jdField_a_of_type_Lhk;
  private mgm jdField_a_of_type_Mgm;
  
  public mhn(int paramInt, lhk paramlhk)
  {
    this.jdField_a_of_type_JavaLangString = ("QavListItemHelper" + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Lhk = paramlhk;
  }
  
  public static mhm a(int paramInt, PendantItem paramPendantItem)
  {
    mhm localmhm = new mhm();
    localmhm.jdField_a_of_type_Int = paramInt;
    localmhm.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localmhm.jdField_c_of_type_JavaLangString = paramPendantItem.getDesc();
    localmhm.b = paramPendantItem.getIconurl();
    localmhm.jdField_d_of_type_JavaLangString = paramPendantItem.getDesc();
    localmhm.jdField_c_of_type_Boolean = false;
    localmhm.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localmhm.jdField_a_of_type_JavaLangObject = paramPendantItem;
    if (paramInt == 4) {
      localmhm.jdField_d_of_type_Boolean = true;
    }
    return localmhm;
  }
  
  public ArrayList<mhm> a(Context paramContext)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Int == 5)
    {
      localObject = new mhm();
      ((mhm)localObject).jdField_d_of_type_Boolean = false;
      ((mhm)localObject).jdField_a_of_type_JavaLangString = "-1";
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    Object localObject = new mhm();
    ((mhm)localObject).jdField_a_of_type_JavaLangString = "0";
    ((mhm)localObject).b = String.valueOf(2130842157);
    ((mhm)localObject).jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int == 4)
    {
      ((mhm)localObject).jdField_d_of_type_Boolean = true;
      ((mhm)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131694745);
    }
    for (((mhm)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131694746);; ((mhm)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131694745))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if (this.jdField_a_of_type_Lhk == null) {
        break;
      }
      paramContext = this.jdField_a_of_type_Lhk.a(null);
      localObject = (PendantItem)this.jdField_a_of_type_Lhk.a();
      if ((localObject != null) && (!paramContext.contains(localObject))) {
        this.jdField_a_of_type_Lhk.a(l, null);
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
      ((mhm)localObject).jdField_d_of_type_Boolean = false;
      ((mhm)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131694745);
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
    if (this.jdField_a_of_type_Mgm != null) {
      this.jdField_a_of_type_Mgm.a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void a(PendantItem paramPendantItem, int paramInt)
  {
    if (this.jdField_a_of_type_Mgm != null) {
      this.jdField_a_of_type_Mgm.a(paramPendantItem.getId(), paramInt);
    }
  }
  
  public void a(mgm parammgm)
  {
    this.jdField_a_of_type_Mgm = parammgm;
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, mhm parammhm, mhl parammhl)
  {
    paramAppInterface = null;
    if (this.jdField_a_of_type_Lhk != null) {
      paramAppInterface = (PendantItem)this.jdField_a_of_type_Lhk.a(parammhm.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "startDownloadTemplate, seq[" + paramLong + "], item[" + paramAppInterface + "]");
    }
    if (paramAppInterface != null)
    {
      this.jdField_a_of_type_Lhk.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammhl.a(paramLong, parammhm.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhn
 * JD-Core Version:    0.7.0.1
 */