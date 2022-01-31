import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public abstract class lin
  extends EffectConfigBase<PendantItem>
  implements lho
{
  protected final lio a;
  protected boolean a;
  
  public lin(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_Lio = new lio();
  }
  
  public abstract VideoMaterial a(String paramString);
  
  public Class<?> a()
  {
    return PendantItem.class;
  }
  
  public String a(PendantItem paramPendantItem)
  {
    String str = null;
    if (paramPendantItem != null) {
      str = lcj.c() + paramPendantItem.getMd5();
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
  
  public lio a(int paramInt1, int paramInt2)
  {
    if (!lpu.e()) {
      return null;
    }
    VideoMemoryManager.getInstance().setForceLoadFromSdCard(true);
    PendantItem localPendantItem = (PendantItem)a();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      d();
    }
    if ((paramInt1 == 0) || (paramInt2 == 0) || (localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Lio.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Lio.jdField_a_of_type_JavaLangString = null;
      }
      return null;
    }
    String str1 = c(localPendantItem);
    String str2 = localPendantItem.getId();
    if ((str1.equals(this.jdField_a_of_type_Lio.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Lio.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (str2.equals(this.jdField_a_of_type_Lio.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getId()))) {
      return this.jdField_a_of_type_Lio;
    }
    long l = System.currentTimeMillis();
    VideoMaterial localVideoMaterial = a(str1);
    this.jdField_a_of_type_Lio.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = localVideoMaterial;
    this.jdField_a_of_type_Lio.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = localPendantItem;
    this.jdField_a_of_type_Lio.jdField_a_of_type_JavaLangString = str1;
    lcg.c(this.jdField_a_of_type_JavaLangString, String.format("getVideoPendant, patternPath[%s], id[%s], material[%s], cost[%s]", new Object[] { str1, str2, localVideoMaterial, Long.valueOf(System.currentTimeMillis() - l) }));
    return this.jdField_a_of_type_Lio;
  }
  
  public void a()
  {
    super.a();
    lhn locallhn = (lhn)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
    if (locallhn != null) {
      locallhn.a(b(), this);
    }
  }
  
  protected void a(long paramLong, PendantItem paramPendantItem)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      ((lhp)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1)).a(paramLong, paramPendantItem);
    }
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    lga locallga = VideoController.a().a();
    a(paramLong, paramPendantItem);
    if ((paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      locallga.a.set(1);
      return bool;
    }
    locallga.a.clear(1);
    return bool;
  }
  
  protected boolean a(String paramString)
  {
    return ljd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
  }
  
  public abstract int b();
  
  public String b(PendantItem paramPendantItem)
  {
    String str = "";
    if (paramPendantItem != null) {
      str = lcj.d() + paramPendantItem.getMd5() + File.separator;
    }
    return str;
  }
  
  protected String c(PendantItem paramPendantItem)
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
    return lcj.b() + paramPendantItem.getName() + File.separator;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Lio.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    this.jdField_a_of_type_Lio.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
    this.jdField_a_of_type_Lio.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lin
 * JD-Core Version:    0.7.0.1
 */