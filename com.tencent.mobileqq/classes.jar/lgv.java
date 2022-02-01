import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class lgv
  extends EffectConfigBase<FilterItem>
{
  static boolean jdField_a_of_type_Boolean;
  FilterItem jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem = null;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  
  public lgv(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    int i;
    int j;
    do
    {
      return paramString;
      i = paramString.lastIndexOf(".");
      j = paramString.lastIndexOf(File.separator);
      if (j != -1) {
        break;
      }
    } while (i == -1);
    return paramString.substring(0, i);
    if (i == -1) {
      return paramString.substring(j + 1);
    }
    if (j < i) {}
    for (paramString = paramString.substring(j + 1, i);; paramString = paramString.substring(j + 1)) {
      return paramString;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (jdField_a_of_type_Boolean) {
      bool1 = jdField_a_of_type_Boolean;
    }
    do
    {
      do
      {
        return bool1;
        if (!lpm.g())
        {
          lbj.c("EffectFilterTools", "isSupport Error: 1");
          return false;
        }
        bool1 = bool2;
      } while (!lpm.a(4, 1400000L));
      if (paramContext == null) {
        break;
      }
      bool1 = bool2;
    } while (TextUtils.isEmpty(lbx.b(132).a));
    paramContext = lor.a();
    if ((paramContext != null) && (!paramContext.a()))
    {
      lbj.c("EffectFilterTools", "  isSupportFilter false");
      return false;
    }
    jdField_a_of_type_Boolean = true;
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(PendantItem paramPendantItem)
  {
    if (paramPendantItem == null) {
      return false;
    }
    if (!PendantItem.isOnlySupportOldFilter(paramPendantItem.getKind())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EffectFilterTools", 2, String.format("isSupportFilter, support[%s], kind[%s], id[%s]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramPendantItem.getKind()), paramPendantItem.getId() }));
      }
      return bool;
    }
  }
  
  public int a()
  {
    return 132;
  }
  
  public FilterDesc a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  }
  
  public Class<?> a()
  {
    return FilterItem.class;
  }
  
  public String a(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.getResurl())) && (!TextUtils.isEmpty(paramFilterItem.getId())))
    {
      String str = b(paramFilterItem);
      paramFilterItem = a(paramFilterItem.getResurl());
      return str + paramFilterItem;
    }
    return null;
  }
  
  public List<FilterItem> a(String paramString)
  {
    paramString = super.a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramLong, null);
  }
  
  public void a(long paramLong, PendantItem paramPendantItem)
  {
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getFilterName())))
    {
      b(paramLong, (FilterItem)a(paramPendantItem.getFilterName()));
      return;
    }
    b(paramLong, this.jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem);
  }
  
  protected void a(FilterItem paramFilterItem) {}
  
  public boolean a(long paramLong, FilterItem paramFilterItem)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem = paramFilterItem;
    return b(paramLong, paramFilterItem);
  }
  
  protected boolean a(String paramString)
  {
    boolean bool2 = false;
    super.b();
    boolean bool1 = bool2;
    int i;
    int j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramString = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      j = 0;
      if (paramString.hasNext())
      {
        FilterItem localFilterItem = (FilterItem)paramString.next();
        long l = AudioHelper.b();
        if (AudioHelper.f()) {
          QLog.w("EffectFilterTools", 1, "preDownloadResource, seq[" + l + "], res[" + localFilterItem.getResurl() + "], icon[" + localFilterItem.getIconurl() + "]");
        }
        if (localFilterItem.getPredownload() != 1) {
          break label185;
        }
        j += 1;
        if ((!TextUtils.isEmpty(localFilterItem.getResurl())) && (!localFilterItem.isUsable())) {
          a(l, localFilterItem);
        }
      }
    }
    label185:
    for (;;)
    {
      break;
      i += 1;
      continue;
      bool1 = bool2;
      if (i == j) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  boolean b(long paramLong, FilterItem paramFilterItem)
  {
    boolean bool = super.a(paramLong, paramFilterItem);
    lff locallff = VideoController.a().a();
    if (TextUtils.isEmpty(a(paramFilterItem)))
    {
      locallff.a.clear(2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
    }
    for (;;)
    {
      if (paramFilterItem != null) {
        lgw.a((FilterItem)a());
      }
      return bool;
      locallff.a.set(2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = new FilterDesc(Integer.valueOf(paramFilterItem.getFilterId()).intValue(), paramFilterItem.getPredownload(), paramFilterItem.getResurl(), paramFilterItem.getMd5(), paramFilterItem.getIconurl(), paramFilterItem.getIconMd5(), paramFilterItem.getId(), 0, b(paramFilterItem));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.type = paramFilterItem.getFiltertype();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgv
 * JD-Core Version:    0.7.0.1
 */