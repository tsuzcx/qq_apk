import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.pendant.EffectPendantBase.1;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.DecryptListener;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public abstract class lhs
  extends EffectConfigBase<PendantItem>
  implements lgu
{
  private static final DecryptListener a;
  protected final lhu a;
  protected lhw a;
  protected boolean a;
  protected String[] c;
  
  static
  {
    jdField_a_of_type_ComTencentTtpicUtilDecryptListener = new lht();
  }
  
  public lhs(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Lhu = new lhu();
  }
  
  public static VideoMaterial a(String paramString1, String paramString2)
  {
    return VideoTemplateParser.parseVideoMaterial(paramString1, paramString2, false, jdField_a_of_type_ComTencentTtpicUtilDecryptListener);
  }
  
  public VideoMaterial a(String paramString)
  {
    VideoMaterial localVideoMaterial = a(paramString, "params");
    localVideoMaterial.setDataPath(paramString);
    return localVideoMaterial;
  }
  
  public Class<?> a()
  {
    return PendantItem.class;
  }
  
  public String a(PendantItem paramPendantItem)
  {
    String str = null;
    if (paramPendantItem != null) {
      str = lbm.c() + paramPendantItem.getMd5();
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
  
  public lhu a(int paramInt1, int paramInt2)
  {
    if (!lpm.g()) {
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
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Lhu.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Lhu.jdField_a_of_type_JavaLangString = null;
      }
      return null;
    }
    String str1 = c(localPendantItem);
    String str2 = localPendantItem.getId();
    if ((str1.equals(this.jdField_a_of_type_Lhu.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Lhu.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (str2.equals(this.jdField_a_of_type_Lhu.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getId()))) {
      return this.jdField_a_of_type_Lhu;
    }
    long l = System.currentTimeMillis();
    VideoMaterial localVideoMaterial = a(str1);
    this.jdField_a_of_type_Lhu.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = localVideoMaterial;
    this.jdField_a_of_type_Lhu.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = localPendantItem;
    this.jdField_a_of_type_Lhu.jdField_a_of_type_JavaLangString = str1;
    lbj.c(this.jdField_a_of_type_JavaLangString, String.format("getVideoPendant, patternPath[%s], id[%s], material[%s], cost[%s]", new Object[] { str1, str2, localVideoMaterial, Long.valueOf(System.currentTimeMillis() - l) }));
    return this.jdField_a_of_type_Lhu;
  }
  
  public void a()
  {
    super.a();
    lgt locallgt = (lgt)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
    if (locallgt != null) {
      locallgt.a(b(), this);
    }
  }
  
  protected void a(long paramLong, PendantItem paramPendantItem)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      ((lgv)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a(paramLong, paramPendantItem);
    }
  }
  
  public void a(lhw paramlhw)
  {
    this.jdField_a_of_type_Lhw = paramlhw;
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    lff locallff = VideoController.a().a();
    a(paramLong, paramPendantItem);
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      locallff.a.set(1);
      return bool;
    }
    locallff.a.clear(1);
    return bool;
  }
  
  protected boolean a(PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramPendantItem);
    String str1;
    Object localObject;
    int k;
    int i;
    if (bool)
    {
      str1 = c(paramPendantItem);
      if ((this.c == null) || (this.c.length <= 0)) {
        break label284;
      }
      localObject = this.c;
      int m = localObject.length;
      k = 0;
      i = 0;
      j = i;
      if (k < m)
      {
        String str2 = localObject[k];
        File localFile = new File(str1, str2);
        long l = localFile.length();
        if (((!localFile.exists()) || (l >= 1L)) && (localFile.exists())) {
          break label265;
        }
        j = 1;
        label111:
        if ((j == 0) && (i == 0)) {
          break label270;
        }
        i = 1;
        label121:
        if ((j != 0) && (QLog.isColorLevel())) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "isTemplateUsable, fileName[" + str2 + "], item[" + paramPendantItem + "]");
        }
        if (i == 0) {
          break label275;
        }
      }
    }
    label265:
    label270:
    label275:
    label284:
    for (int j = i;; j = 0)
    {
      if (j != 0)
      {
        str1 = a(paramPendantItem);
        localObject = b(paramPendantItem);
        ThreadManager.excute(new EffectPendantBase.1(this, new File(str1), (String)localObject), 16, null, false);
        if (QLog.isDevelopLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 4, "isTemplateUsable, need unzip item[" + paramPendantItem + "]");
        }
      }
      return bool;
      j = 0;
      break label111;
      i = 0;
      break label121;
      k += 1;
      break;
    }
  }
  
  protected boolean a(String paramString)
  {
    return lil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  public abstract int b();
  
  public String b(PendantItem paramPendantItem)
  {
    String str = "";
    if (paramPendantItem != null) {
      str = lbm.d() + paramPendantItem.getMd5() + File.separator;
    }
    return str;
  }
  
  protected String c(PendantItem paramPendantItem)
  {
    Object localObject1 = "";
    Object localObject3 = localObject1;
    Object localObject2;
    String str;
    if (paramPendantItem != null)
    {
      localObject2 = null;
      str = b(paramPendantItem) + paramPendantItem.getName() + File.separator;
      if (!new File(str).exists()) {
        break label142;
      }
      localObject1 = str;
    }
    for (;;)
    {
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = localObject1;
        if (QLog.isDevelopLevel())
        {
          QLog.i(this.jdField_a_of_type_JavaLangString, 4, "getFilterPathForRead, new[" + str + "], old[" + (String)localObject2 + "], item[" + paramPendantItem + "]");
          localObject3 = localObject1;
        }
      }
      return localObject3;
      label142:
      localObject3 = lbm.b() + paramPendantItem.getName() + File.separator;
      localObject2 = localObject3;
      if (new File((String)localObject3).exists())
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Lhu.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    this.jdField_a_of_type_Lhu.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
    this.jdField_a_of_type_Lhu.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lhs
 * JD-Core Version:    0.7.0.1
 */