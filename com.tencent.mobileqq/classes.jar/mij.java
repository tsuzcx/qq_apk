import android.content.Context;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mij
  implements lgq<PendantItem>, mhp
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final ArrayList<mii> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private final lhs jdField_a_of_type_Lhs;
  private mhi jdField_a_of_type_Mhi;
  
  public mij(int paramInt, lhs paramlhs)
  {
    this.jdField_a_of_type_JavaLangString = ("QavListItemHelper" + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Lhs = paramlhs;
  }
  
  public static mii a(int paramInt, PendantItem paramPendantItem)
  {
    mii localmii = new mii();
    localmii.jdField_a_of_type_Int = paramInt;
    localmii.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localmii.jdField_c_of_type_JavaLangString = paramPendantItem.getDesc();
    localmii.b = paramPendantItem.getIconurl();
    localmii.jdField_d_of_type_JavaLangString = paramPendantItem.getDesc();
    localmii.jdField_c_of_type_Boolean = false;
    localmii.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localmii.jdField_a_of_type_JavaLangObject = paramPendantItem;
    if (paramInt == 4) {
      localmii.jdField_d_of_type_Boolean = true;
    }
    return localmii;
  }
  
  public ArrayList<mii> a(Context paramContext)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Int == 5)
    {
      localObject = new mii();
      ((mii)localObject).jdField_d_of_type_Boolean = false;
      ((mii)localObject).jdField_a_of_type_JavaLangString = "-1";
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    Object localObject = new mii();
    ((mii)localObject).jdField_a_of_type_JavaLangString = "0";
    ((mii)localObject).b = String.valueOf(2130842169);
    ((mii)localObject).jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int == 4)
    {
      ((mii)localObject).jdField_d_of_type_Boolean = true;
      ((mii)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131694787);
    }
    for (((mii)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131694788);; ((mii)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131694787))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if (this.jdField_a_of_type_Lhs == null) {
        break;
      }
      paramContext = this.jdField_a_of_type_Lhs.a(null);
      localObject = (PendantItem)this.jdField_a_of_type_Lhs.a();
      if ((localObject != null) && (!paramContext.contains(localObject))) {
        this.jdField_a_of_type_Lhs.a(l, null);
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
      ((mii)localObject).jdField_d_of_type_Boolean = false;
      ((mii)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131694787);
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
    if (this.jdField_a_of_type_Mhi != null) {
      this.jdField_a_of_type_Mhi.a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void a(PendantItem paramPendantItem, int paramInt)
  {
    if (this.jdField_a_of_type_Mhi != null) {
      this.jdField_a_of_type_Mhi.a(paramPendantItem.getId(), paramInt);
    }
  }
  
  public void a(mhi parammhi)
  {
    this.jdField_a_of_type_Mhi = parammhi;
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, mii parammii, mih parammih)
  {
    paramAppInterface = null;
    if (this.jdField_a_of_type_Lhs != null) {
      paramAppInterface = (PendantItem)this.jdField_a_of_type_Lhs.a(parammii.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "startDownloadTemplate, seq[" + paramLong + "], item[" + paramAppInterface + "]");
    }
    if (paramAppInterface != null)
    {
      this.jdField_a_of_type_Lhs.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammih.a(paramLong, parammii.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mij
 * JD-Core Version:    0.7.0.1
 */