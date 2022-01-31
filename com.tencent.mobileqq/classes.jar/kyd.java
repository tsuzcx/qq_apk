import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.pendant.EffectPendantTools.1;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.filter.VideoFilterListExtension.CreateExternalFiltersListener;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class kyd
  extends EffectConfigBase<PendantItem>
  implements kxe
{
  private PendantItem jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
  VideoFilterListExtension.CreateExternalFiltersListener jdField_a_of_type_ComTencentTtpicOpenapiFilterVideoFilterListExtension$CreateExternalFiltersListener = new kye(this);
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private kyc jdField_a_of_type_Kyc = null;
  private kyg jdField_a_of_type_Kyg = new kyg();
  private boolean jdField_a_of_type_Boolean = false;
  public String e;
  private String f;
  
  public kyd(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private void a(long paramLong, PendantItem paramPendantItem)
  {
    ((kxf)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a(paramLong, paramPendantItem);
  }
  
  public static boolean a(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial != null)
    {
      if (paramVideoMaterial.getFabbyParts() != null)
      {
        paramVideoMaterial = paramVideoMaterial.getFabbyParts().getParts().iterator();
        FabbyMvPart localFabbyMvPart;
        do
        {
          if (!paramVideoMaterial.hasNext()) {
            break;
          }
          localFabbyMvPart = (FabbyMvPart)paramVideoMaterial.next();
        } while ((localFabbyMvPart.bgItem == null) || (localFabbyMvPart.bgItem.name == null) || (!localFabbyMvPart.bgItem.name.endsWith("_360")));
        return true;
      }
    }
    else {
      return false;
    }
    return false;
  }
  
  public int a()
  {
    return 106;
  }
  
  public Class<?> a()
  {
    return PendantItem.class;
  }
  
  public String a(PendantItem paramPendantItem)
  {
    String str = null;
    if (paramPendantItem != null) {
      str = ajed.aU + "new_ptv_template" + File.separator + paramPendantItem.getMd5();
    }
    return str;
  }
  
  public List<PendantItem> a(String paramString)
  {
    paramString = super.a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (paramString != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  public kyg a(int paramInt1, int paramInt2)
  {
    if (!lfi.e()) {
      return null;
    }
    VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
    PendantItem localPendantItem = (PendantItem)a();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      c();
    }
    if ((paramInt1 == 0) || (paramInt2 == 0) || (localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())))
    {
      if (!TextUtils.isEmpty(this.f)) {
        this.f = null;
      }
      return null;
    }
    String str1 = c(localPendantItem);
    String str2 = localPendantItem.getId();
    if ((str1.equals(this.f)) && (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (str2.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getId()))) {
      return this.jdField_a_of_type_Kyg;
    }
    long l = System.currentTimeMillis();
    VideoMaterial localVideoMaterial = QQTemplateParser.parseVideoMaterial(str1, "params");
    localVideoMaterial.setDataPath(str1);
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, String.format("getVideoPendant, gesture[%s], kind[%s], id[%s], path[%s] .", new Object[] { Boolean.valueOf(localPendantItem.hasGesture()), Integer.valueOf(localPendantItem.getKind()), localPendantItem.getId(), str1 }));
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = localPendantItem;
    this.f = str1;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = localVideoMaterial;
    this.jdField_a_of_type_Kyg.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
    this.jdField_a_of_type_Kyg.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
    this.jdField_a_of_type_Kyg.jdField_a_of_type_JavaLangString = this.f;
    if (this.jdField_a_of_type_Kyc != null)
    {
      boolean bool = kya.a().b();
      if ((!a(localVideoMaterial)) || (bool)) {
        this.jdField_a_of_type_Kyc.a(0);
      }
    }
    krx.c(this.jdField_a_of_type_JavaLangString, String.format("getVideoPendant, patternPath[%s], id[%s], material[%s], cost[%s]", new Object[] { str1, str2, localVideoMaterial, Long.valueOf(System.currentTimeMillis() - l) }));
    return this.jdField_a_of_type_Kyg;
  }
  
  public void a()
  {
    super.a();
    kxd localkxd = (kxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
    if (localkxd != null) {
      localkxd.a(3002, this);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramString1 = (PendantItem)a();
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1.getId())));
    b(paramLong, null);
  }
  
  public void a(kyc paramkyc)
  {
    this.jdField_a_of_type_Kyc = paramkyc;
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    kvq localkvq = VideoController.a().a();
    a(paramLong, paramPendantItem);
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      localkvq.a.set(1);
      if (paramPendantItem != null) {
        break label118;
      }
    }
    label118:
    for (paramPendantItem = null;; paramPendantItem = paramPendantItem.getId())
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCurrentItem, id[" + paramPendantItem + "], seq[" + paramLong + "]");
      kyf.a(this.jdField_a_of_type_JavaLangString, paramPendantItem);
      return bool;
      localkvq.a.clear(1);
      break;
    }
  }
  
  protected boolean a(PendantItem paramPendantItem)
  {
    int j = 1;
    if ((a() <= 0) || (paramPendantItem == null) || (TextUtils.isEmpty(paramPendantItem.getId())))
    {
      krx.e(this.jdField_a_of_type_JavaLangString, "isTemplateUsable:" + a() + "|");
      return false;
    }
    if (TextUtils.isEmpty(paramPendantItem.getResurl())) {
      return true;
    }
    File localFile = new File(a(paramPendantItem));
    boolean bool = localFile.exists();
    Object localObject1;
    long l1;
    Object localObject2;
    if (!bool)
    {
      localObject1 = ajed.aU + "ptv_template" + File.separator + paramPendantItem.getName();
      localFile = new File((String)localObject1);
      if (localFile.exists())
      {
        l1 = System.currentTimeMillis();
        localObject1 = SecUtil.getFileMd5((String)localObject1);
        long l2 = System.currentTimeMillis();
        localObject2 = paramPendantItem.getMd5();
        krx.c(this.jdField_a_of_type_JavaLangString, "isTemplateUsable :" + (String)localObject1 + "|" + (String)localObject2 + "|" + (l2 - l1));
        bool = ((String)localObject2).equalsIgnoreCase((String)localObject1);
      }
    }
    for (;;)
    {
      int i;
      if (bool)
      {
        localObject1 = c(paramPendantItem);
        localObject2 = new File((String)localObject1, "params.json");
        l1 = ((File)localObject2).length();
        if (((((File)localObject2).exists()) && (l1 < 1L)) || (!((File)localObject2).exists()))
        {
          i = 1;
          if (i == 0) {
            break label386;
          }
          localObject1 = new File((String)localObject1, "params.dat");
          l1 = ((File)localObject1).length();
          if (((File)localObject1).exists())
          {
            i = j;
            if (l1 < 1L) {}
          }
          else
          {
            if (((File)localObject1).exists()) {
              break label378;
            }
            i = j;
          }
        }
      }
      label386:
      for (;;)
      {
        if (i != 0)
        {
          ThreadManager.post(new EffectPendantTools.1(this, localFile, paramPendantItem), 5, null, false);
          return false;
          i = 0;
          break;
          label378:
          i = 0;
          continue;
        }
        return bool;
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    return kys.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  public String b(PendantItem paramPendantItem)
  {
    if (paramPendantItem != null) {
      return ausk.c + paramPendantItem.getMd5() + File.separator;
    }
    return "";
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MuteByOthers, seq[" + l + "]");
    }
    a(l, "0");
  }
  
  public boolean b(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    Object localObject = VideoController.a().a();
    a(paramLong, paramPendantItem);
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      ((kvq)localObject).a.set(1);
      if (paramPendantItem != null) {
        break label155;
      }
    }
    label155:
    for (localObject = null;; localObject = paramPendantItem.getId())
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCurrentItem, id[" + (String)localObject + "], seq[" + paramLong + "]");
      kyf.a(this.jdField_a_of_type_JavaLangString, (String)localObject);
      if ((paramPendantItem != null) && (paramPendantItem.getId() != "0")) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(3002) });
      }
      return bool;
      ((kvq)localObject).a.clear(1);
      break;
    }
  }
  
  public String c(PendantItem paramPendantItem)
  {
    String str = "";
    if (paramPendantItem != null)
    {
      str = b(paramPendantItem) + paramPendantItem.getName() + File.separator;
      if (!new File(str).exists()) {}
    }
    else
    {
      return str;
    }
    return ajed.aU + "ptv_template" + File.separator + paramPendantItem.getName() + File.separator;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
    this.jdField_a_of_type_Kyg.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    this.jdField_a_of_type_Kyg.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
    this.jdField_a_of_type_Kyg.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kyd
 * JD-Core Version:    0.7.0.1
 */