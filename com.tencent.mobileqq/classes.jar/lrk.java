import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter;
import com.tencent.mobileqq.shortvideo.filter.QQPtColorFilterInfo;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lrk
  implements lrj
{
  private volatile int jdField_a_of_type_Int;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private PendantItem jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private final List<lrr> jdField_a_of_type_JavaUtilList = new ArrayList(11);
  private final lrq jdField_a_of_type_Lrq = new lrq();
  private final lsq jdField_a_of_type_Lsq;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public lrk(lsq paramlsq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "AEFilterAVWrapperImpl");
    }
    this.jdField_a_of_type_Lsq = paramlsq;
    this.jdField_a_of_type_Int = 0;
    a(1);
  }
  
  private double a()
  {
    double d1 = 0.16666667163372D;
    PTFaceAttr localPTFaceAttr = a();
    if (localPTFaceAttr != null) {
      d1 = localPTFaceAttr.getFaceDetectScale();
    }
    return d1;
  }
  
  private PTFaceAttr a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      AIAttr localAIAttr = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.getAIAttr();
      localObject1 = localObject2;
      if (localAIAttr != null) {
        localObject1 = (PTFaceAttr)localAIAttr.getFaceAttr();
      }
    }
    return localObject1;
  }
  
  private String a(FilterDesc paramFilterDesc)
  {
    Object localObject2;
    if (paramFilterDesc == null) {
      localObject2 = null;
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject1 = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
      if (!TextUtils.isEmpty(paramFilterDesc.resRootPath)) {
        localObject1 = paramFilterDesc.resRootPath;
      }
      localObject2 = paramFilterDesc.getResFold((String)localObject1);
      QQPtColorFilterInfo localQQPtColorFilterInfo = QQPtColorFilter.getColorFilterInfo((String)localObject2);
      localObject1 = localObject2;
      if (localQQPtColorFilterInfo != null) {
        localObject1 = (String)localObject2 + localQQPtColorFilterInfo.getColorPng();
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.i("AEFilterAVWrapperImpl", 2, "getLutPath, name[" + paramFilterDesc.name + "], out[" + (String)localObject1 + "]");
    return localObject1;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int >= 1) {}
    boolean bool;
    do
    {
      return;
      bool = AEFilterSupport.a(paramInt);
      if ((bool) && (this.jdField_a_of_type_Int < 1)) {
        this.jdField_a_of_type_Int = 1;
      }
    } while ((paramInt == 0) || (!QLog.isColorLevel()));
    QLog.i("AEFilterAVWrapperImpl", 2, "prepare ret[" + bool + "], state[" + this.jdField_a_of_type_Int + "], flag[" + paramInt + "]");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int >= 2) {
      return;
    }
    String str;
    label93:
    boolean bool;
    if (this.jdField_a_of_type_Int < 3)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = new AEFilterManager();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(this.b, this.c);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchFilterOn(108, false);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyNormalAlpha(0.8F);
      str = a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      if ((!TextUtils.isEmpty(str)) && (!bdcs.a(str))) {
        break label223;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(str);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setForceFaceDetect(this.jdField_a_of_type_Boolean);
      bool = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited();
      if (!bool) {
        break label256;
      }
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.defineFiltersAndOrder(new int[] { 101, 108, 106, 102, 104, 105, 103 });
    }
    for (;;)
    {
      lsp.a(bool);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AEFilterAVWrapperImpl", 2, "initAEFilterInGL, state[" + this.jdField_a_of_type_Int + "]");
      return;
      label223:
      QLog.i("AEFilterAVWrapperImpl", 1, "initAEFilterInGL, fail path[" + str + "]");
      break label93;
      label256:
      this.jdField_a_of_type_Int = 3;
    }
  }
  
  private void e()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {}
    do
    {
      return;
      localAEFilterManager.setSmoothSharpenSize(this.d, this.e);
      localAEFilterManager.setSmoothSharpenStrength(0.0F);
      this.jdField_a_of_type_Lrq.a(0, this.jdField_a_of_type_JavaUtilList);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        lrr locallrr = (lrr)localIterator.next();
        if (locallrr != null) {
          switch (locallrr.jdField_a_of_type_Int)
          {
          default: 
            break;
          case 1: 
            localAEFilterManager.setSmoothLevel(locallrr.d);
            break;
          case 2: 
          case 3: 
            localAEFilterManager.setBeautyOrTransformLevel(locallrr.jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE, locallrr.d);
          }
        }
      }
    } while ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem == null) || (!PendantItem.isBeautyMakeup(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getCategory())));
    if ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam instanceof Integer)) {
      this.f = ((Integer)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam).intValue();
    }
    localAEFilterManager.setCosmeticsAlpha(this.f);
  }
  
  public int a(int paramInt, boolean paramBoolean1, lsd paramlsd, boolean paramBoolean2)
  {
    int i;
    if (this.jdField_a_of_type_Int < 1)
    {
      a(0);
      i = paramInt;
    }
    do
    {
      do
      {
        do
        {
          return i;
          if (this.jdField_a_of_type_Int < 2) {
            d();
          }
          i = paramInt;
        } while (this.jdField_a_of_type_Int >= 3);
        i = paramInt;
      } while (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null);
      e();
      paramInt = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.drawFrame(paramInt, paramBoolean1, System.currentTimeMillis() * 1000000L);
      i = paramInt;
    } while (paramlsd == null);
    paramlsd.a(a(), (float)a(), paramBoolean2);
    return paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(null);
    }
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "uninitInGL");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = ((int)(paramInt1 * 1.0F));
    this.e = ((int)(paramInt2 * 1.0F));
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "initInGL");
    }
  }
  
  public void a(long paramLong)
  {
    QLog.w("AEFilterAVWrapperImpl", 1, "clearState, seq[" + paramLong + "]");
    this.jdField_a_of_type_Lsq.a(paramLong);
  }
  
  public void a(PendantItem paramPendantItem, VideoMaterial paramVideoMaterial)
  {
    boolean bool;
    if ((!lsp.a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramPendantItem)) || (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != paramVideoMaterial))
    {
      if (QLog.isColorLevel())
      {
        if ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem == null) || (!this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.hasGesture())) {
          break label181;
        }
        bool = true;
        QLog.d("AEFilterAVWrapperImpl", 2, "setPendant, pendantItem[" + paramPendantItem + "], isPendantHasGesture[" + bool + "]");
      }
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (!this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited())) {
        break label186;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = paramPendantItem;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
      if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (PendantItem.isBeautyMakeup(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getCategory())) && ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam instanceof Integer))) {
        this.f = ((Integer)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam).intValue();
      }
      return;
      label181:
      bool = false;
      break;
      label186:
      QLog.i("AEFilterAVWrapperImpl", 1, "initAEDetector failed!");
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    String str;
    StringBuilder localStringBuilder;
    if (!lsp.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramFilterDesc))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      str = a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) || ((!TextUtils.isEmpty(str)) && (!bdcs.a(str)))) {
        break label112;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(str);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("setFilterDesc, name[");
        if (paramFilterDesc != null) {
          break label146;
        }
      }
    }
    label146:
    for (paramFilterDesc = "null";; paramFilterDesc = paramFilterDesc.name)
    {
      QLog.i("AEFilterAVWrapperImpl", 2, paramFilterDesc + "], path[" + str + "]");
      return;
      label112:
      QLog.i("AEFilterAVWrapperImpl", 1, "setFilterDesc, fail path[" + str + "]");
      break;
    }
  }
  
  public void a(lsa paramlsa, lsd paramlsd)
  {
    String str2 = "";
    String str1 = "";
    VideoMaterial localVideoMaterial = this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
    PendantItem localPendantItem = this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
    if (localPendantItem != null)
    {
      str2 = localPendantItem.getGestureType();
      str1 = localPendantItem.getGestureWording();
    }
    for (boolean bool1 = localPendantItem.hasFace();; bool1 = false)
    {
      boolean bool2 = lko.a().b();
      if ((lkt.a(localVideoMaterial)) && (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        this.jdField_a_of_type_Lsq.a(paramlsa, paramlsd.jdField_a_of_type_Int, false, bool1, str1, str2);
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setForceFaceDetect(this.jdField_a_of_type_Boolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.hasGesture());
  }
  
  public boolean a(lrq paramlrq)
  {
    if (paramlrq == null) {
      this.jdField_a_of_type_Lrq.c();
    }
    for (;;)
    {
      return this.jdField_a_of_type_Lrq.b();
      this.jdField_a_of_type_Lrq.a(paramlrq);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(null);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(null);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.destroy();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = null;
    }
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = null;
    this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = null;
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "destroyInGL");
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = ((int)(paramInt1 * 1.0F));
    this.e = ((int)(paramInt2 * 1.0F));
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateWidthHeight(paramInt1, paramInt2);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null);
  }
  
  public void c() {}
  
  public void c(int paramInt1, int paramInt2) {}
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lrk
 * JD-Core Version:    0.7.0.1
 */