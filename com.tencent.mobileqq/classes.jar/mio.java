import android.content.Context;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mio
  implements lgw<PendantItem>, mhu
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final ArrayList<min> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private final lhy jdField_a_of_type_Lhy;
  private mhn jdField_a_of_type_Mhn;
  
  public mio(int paramInt, lhy paramlhy)
  {
    this.jdField_a_of_type_JavaLangString = ("QavListItemHelper" + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Lhy = paramlhy;
  }
  
  public static min a(int paramInt, PendantItem paramPendantItem)
  {
    min localmin = new min();
    localmin.jdField_a_of_type_Int = paramInt;
    localmin.jdField_a_of_type_JavaLangString = paramPendantItem.getId();
    localmin.jdField_c_of_type_JavaLangString = paramPendantItem.getDesc();
    localmin.b = paramPendantItem.getIconurl();
    localmin.jdField_d_of_type_JavaLangString = paramPendantItem.getDesc();
    localmin.jdField_c_of_type_Boolean = false;
    localmin.jdField_a_of_type_Boolean = paramPendantItem.isUsable();
    localmin.jdField_a_of_type_JavaLangObject = paramPendantItem;
    if (paramInt == 4) {
      localmin.jdField_d_of_type_Boolean = true;
    }
    return localmin;
  }
  
  public ArrayList<min> a(Context paramContext)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_Int == 5)
    {
      localObject = new min();
      ((min)localObject).jdField_d_of_type_Boolean = false;
      ((min)localObject).jdField_a_of_type_JavaLangString = "-1";
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    }
    Object localObject = new min();
    ((min)localObject).jdField_a_of_type_JavaLangString = "0";
    ((min)localObject).b = String.valueOf(2130842225);
    ((min)localObject).jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_Int == 4)
    {
      ((min)localObject).jdField_d_of_type_Boolean = true;
      ((min)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131695141);
    }
    for (((min)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131695142);; ((min)localObject).jdField_d_of_type_JavaLangString = paramContext.getString(2131695141))
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if (this.jdField_a_of_type_Lhy == null) {
        break;
      }
      paramContext = this.jdField_a_of_type_Lhy.a(null);
      localObject = (PendantItem)this.jdField_a_of_type_Lhy.a();
      if ((localObject != null) && (!paramContext.contains(localObject))) {
        this.jdField_a_of_type_Lhy.a(l, null);
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
      ((min)localObject).jdField_d_of_type_Boolean = false;
      ((min)localObject).jdField_c_of_type_JavaLangString = paramContext.getString(2131695141);
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
    if (this.jdField_a_of_type_Mhn != null) {
      this.jdField_a_of_type_Mhn.a(paramLong, paramPendantItem.getId(), paramBoolean);
    }
  }
  
  public void a(PendantItem paramPendantItem, int paramInt)
  {
    if (this.jdField_a_of_type_Mhn != null) {
      this.jdField_a_of_type_Mhn.a(paramPendantItem.getId(), paramInt);
    }
  }
  
  public void a(mhn parammhn)
  {
    this.jdField_a_of_type_Mhn = parammhn;
  }
  
  public void startDownloadTemplate(AppInterface paramAppInterface, long paramLong, min parammin, mim parammim)
  {
    paramAppInterface = null;
    if (this.jdField_a_of_type_Lhy != null) {
      paramAppInterface = (PendantItem)this.jdField_a_of_type_Lhy.a(parammin.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isDevelopLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, "startDownloadTemplate, seq[" + paramLong + "], item[" + paramAppInterface + "]");
    }
    if (paramAppInterface != null)
    {
      this.jdField_a_of_type_Lhy.a(paramLong, paramAppInterface);
      return;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "startDownloadTemplate, item为空, seq[" + paramLong + "]");
    parammim.a(paramLong, parammin.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mio
 * JD-Core Version:    0.7.0.1
 */