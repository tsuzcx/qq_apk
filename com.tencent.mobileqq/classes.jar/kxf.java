import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class kxf
  extends EffectConfigBase<FilterItem>
{
  static boolean jdField_a_of_type_Boolean;
  static boolean b;
  FilterItem jdField_a_of_type_ComTencentAvBusinessManagerFilterFilterItem = null;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  
  public kxf(VideoAppInterface paramVideoAppInterface)
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
  
  public static boolean a()
  {
    if (b) {
      return true;
    }
    if ((!lfi.a(8, 1400000L)) && (!lfi.a(4, 2150000L))) {
      return false;
    }
    les localles = les.a();
    if ((localles != null) && (!localles.b()))
    {
      krx.c("EffectFilterTools", "isSupportGesture false");
      return false;
    }
    b = true;
    return b;
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
        if (!lfi.e())
        {
          krx.c("EffectFilterTools", "isSupport Error: 1");
          return false;
        }
        bool1 = bool2;
      } while (!lfi.a(4, 1400000L));
      if (paramContext == null) {
        break;
      }
      bool1 = bool2;
    } while (TextUtils.isEmpty(ksj.b(132).jdField_a_of_type_JavaLangString));
    paramContext = les.a();
    if ((paramContext != null) && (!paramContext.a()))
    {
      krx.c("EffectFilterTools", "  isSupportFilter false");
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
    boolean bool;
    if (AEFilterSupport.a()) {
      if (!PendantItem.isOnlySupportOldFilter(paramPendantItem.getKind())) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EffectFilterTools", 2, String.format("isSupportFilter, ptu[%s], support[%s], kind[%s], id[%s]", new Object[] { Boolean.valueOf(AEFilterSupport.a()), Boolean.valueOf(bool), Integer.valueOf(paramPendantItem.getKind()), paramPendantItem.getId() }));
      }
      return bool;
      bool = false;
      continue;
      if (!PendantItem.isOnlySupportNewFilter(paramPendantItem.getKind())) {
        bool = true;
      } else {
        bool = false;
      }
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
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.getIconurl())) && (!TextUtils.isEmpty(paramFilterItem.getId())))
    {
      String str = a(a());
      return str + paramFilterItem.getId() + ".png";
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
    super.t_();
    boolean bool1 = bool2;
    int j;
    int k;
    int i;
    int m;
    label302:
    int n;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramString = this.jdField_a_of_type_JavaUtilList.iterator();
      j = 0;
      k = 0;
      i = 0;
      if (paramString.hasNext())
      {
        FilterItem localFilterItem = (FilterItem)paramString.next();
        long l = AudioHelper.b();
        if (AudioHelper.e()) {
          QLog.w("EffectFilterTools", 1, "preDownloadResource, seq[" + l + "], res[" + localFilterItem.getResurl() + "], icon[" + localFilterItem.getIconurl() + "]");
        }
        if (localFilterItem.getPredownload() != 1) {
          break label414;
        }
        m = i + 1;
        if ((!TextUtils.isEmpty(localFilterItem.getIconurl())) && (!TextUtils.isEmpty(localFilterItem.getIconMd5())))
        {
          String str = a(localFilterItem);
          i = k;
          if (!TextUtils.isEmpty(str))
          {
            Object localObject = new File(str);
            krx.c("EffectFilterTools", "preDownloadResource 22:" + str + "|" + ((File)localObject).exists());
            if (!((File)localObject).exists())
            {
              localObject = new axro();
              ((axro)localObject).jdField_a_of_type_Axrt = new kxh(this);
              ((axro)localObject).jdField_a_of_type_JavaLangString = localFilterItem.getIconurl();
              ((axro)localObject).jdField_a_of_type_Int = 0;
              ((axro)localObject).c = str;
              ((axro)localObject).a(localFilterItem);
              kry.a().a((axsp)localObject);
              i = k;
            }
          }
          else
          {
            if ((TextUtils.isEmpty(localFilterItem.getResurl())) || (localFilterItem.isUsable())) {
              break label372;
            }
            a(l, localFilterItem);
            n = j;
            k = m;
            j = i;
            i = n;
          }
        }
      }
    }
    for (;;)
    {
      m = k;
      k = j;
      j = i;
      i = m;
      break;
      i = k + 1;
      break label302;
      i = k + 1;
      break label302;
      label372:
      n = j + 1;
      j = i;
      k = m;
      i = n;
      continue;
      bool1 = bool2;
      if (k == i)
      {
        bool1 = bool2;
        if (j == i) {
          bool1 = true;
        }
      }
      return bool1;
      label414:
      m = i;
      i = j;
      j = k;
      k = m;
    }
  }
  
  public String b(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.getResurl())) && (!TextUtils.isEmpty(paramFilterItem.getId())))
    {
      String str = b(paramFilterItem);
      paramFilterItem = a(paramFilterItem.getResurl());
      return str + paramFilterItem;
    }
    return null;
  }
  
  boolean b(long paramLong, FilterItem paramFilterItem)
  {
    boolean bool = super.a(paramLong, paramFilterItem);
    kvq localkvq = VideoController.a().a();
    if (TextUtils.isEmpty(b(paramFilterItem)))
    {
      localkvq.a.clear(2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
    }
    for (;;)
    {
      if (paramFilterItem != null) {
        kxg.a((FilterItem)a());
      }
      return bool;
      localkvq.a.set(2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = new FilterDesc(Integer.valueOf(paramFilterItem.getFilterId()).intValue(), paramFilterItem.getPredownload(), paramFilterItem.getResurl(), paramFilterItem.getMd5(), paramFilterItem.getIconurl(), paramFilterItem.getIconMd5(), paramFilterItem.getId(), 0, b(paramFilterItem));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc.type = paramFilterItem.getFiltertype();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kxf
 * JD-Core Version:    0.7.0.1
 */