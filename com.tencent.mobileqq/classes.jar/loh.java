import android.os.SystemClock;
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

public class loh
  implements log
{
  private volatile int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AEFilterManager jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
  private PendantItem jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem;
  private FilterDesc jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc;
  private VideoMaterial jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial;
  private final List<loo> jdField_a_of_type_JavaUtilList = new ArrayList(11);
  private final lon jdField_a_of_type_Lon = new lon();
  private final lps jdField_a_of_type_Lps;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  private int g = 0;
  
  public loh(lps paramlps, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "AEFilterAVWrapperImpl, mode[" + paramInt + "]");
    }
    this.jdField_a_of_type_Lps = paramlps;
    this.jdField_a_of_type_Int = 0;
    this.g = paramInt;
    if (this.g == 1)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
    }
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
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if (this.g == 1) {}
    label233:
    label236:
    for (;;)
    {
      return;
      if (this.jdField_c_of_type_Boolean != paramBoolean1)
      {
        this.jdField_c_of_type_Boolean = paramBoolean1;
        a(104, paramBoolean1);
        if (QLog.isDevelopLevel()) {
          QLog.i("AEFilterAVWrapperImpl", 4, "updateBeautyFilter, isBeautyActive[" + paramBoolean1 + "]");
        }
      }
      if (this.jdField_d_of_type_Boolean != paramBoolean2)
      {
        this.jdField_d_of_type_Boolean = paramBoolean2;
        a(105, paramBoolean2);
        if (QLog.isDevelopLevel()) {
          QLog.i("AEFilterAVWrapperImpl", 4, "updateBeautyFilter, isTransformActive[" + paramBoolean2 + "]");
        }
      }
      boolean bool1 = bool2;
      if (!paramBoolean1)
      {
        bool1 = bool2;
        if (!paramBoolean2)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem == null)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) {
              if (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {
                break label233;
              }
            }
          }
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        if ((this.jdField_e_of_type_Boolean == bool1) || (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null)) {
          break label236;
        }
        this.jdField_e_of_type_Boolean = bool1;
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.enableAIDetect(bool1);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.i("AEFilterAVWrapperImpl", 4, "updateBeautyFilter, enableAIDetect[" + bool1 + "]");
        return;
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int >= 2) {
      return;
    }
    String str;
    label130:
    boolean bool;
    if (this.jdField_a_of_type_Int < 3)
    {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager = new AEFilterManager();
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.initInGL(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchFilterOn(108, false);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setBeautyNormalAlpha(0.8F);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchFilterOn(104, this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchFilterOn(105, this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.enableAIDetect(this.jdField_e_of_type_Boolean);
      str = a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      if ((!TextUtils.isEmpty(str)) && (!bgmg.a(str))) {
        break label267;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateLutGL(str);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.setForceFaceDetect(this.jdField_a_of_type_Boolean);
      bool = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited();
      if (!bool) {
        break label327;
      }
      this.jdField_a_of_type_Int = 2;
      if (this.g != 0) {
        break label301;
      }
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.defineFiltersAndOrder(new int[] { 101, 108, 106, 102, 104, 105, 103 });
    }
    for (;;)
    {
      lpr.a(bool);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AEFilterAVWrapperImpl", 2, "initAEFilterInGL, state[" + this.jdField_a_of_type_Int + "]");
      return;
      label267:
      QLog.i("AEFilterAVWrapperImpl", 1, "initAEFilterInGL, fail path[" + str + "]");
      break label130;
      label301:
      if (this.g == 1)
      {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.defineFiltersAndOrder(new int[] { 101 });
        continue;
        label327:
        this.jdField_a_of_type_Int = 3;
      }
    }
  }
  
  private void e()
  {
    AEFilterManager localAEFilterManager = this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager;
    if (localAEFilterManager == null) {}
    label116:
    do
    {
      return;
      localAEFilterManager.setSmoothSharpenSize(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      localAEFilterManager.setSmoothSharpenStrength(0.0F);
      this.jdField_a_of_type_Lon.a(0, this.jdField_a_of_type_JavaUtilList);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      boolean bool2 = false;
      boolean bool1 = false;
      while (localIterator.hasNext())
      {
        loo localloo = (loo)localIterator.next();
        if (localloo != null)
        {
          boolean bool3;
          switch (localloo.jdField_a_of_type_Int)
          {
          default: 
            bool3 = bool2;
            bool2 = bool1;
            bool1 = bool3;
          }
          for (;;)
          {
            bool3 = bool2;
            bool2 = bool1;
            bool1 = bool3;
            break;
            localAEFilterManager.setSmoothLevel(localloo.jdField_d_of_type_Int);
            bool3 = bool1;
            bool1 = bool2;
            bool2 = bool3;
            continue;
            localAEFilterManager.setBeautyOrTransformLevel(localloo.jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE, localloo.jdField_d_of_type_Int);
            if (localloo.jdField_d_of_type_Int == localloo.jdField_c_of_type_Int) {
              break label116;
            }
            bool1 = bool2;
            bool2 = true;
            continue;
            localAEFilterManager.setBeautyOrTransformLevel(localloo.jdField_a_of_type_ComTencentTtpicOpenapiConfigBeautyRealConfig$TYPE, localloo.jdField_d_of_type_Int);
            if (localloo.jdField_d_of_type_Int == localloo.jdField_c_of_type_Int) {
              break label116;
            }
            bool3 = true;
            bool2 = bool1;
            bool1 = bool3;
          }
        }
      }
      a(bool1, bool2);
    } while ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem == null) || (!PendantItem.isBeautyMakeup(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getCategory())));
    if ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam instanceof Integer)) {
      this.f = ((Integer)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam).intValue();
    }
    localAEFilterManager.setCosmeticsAlpha(this.f);
  }
  
  public int a(int paramInt, boolean paramBoolean1, lpa paramlpa, boolean paramBoolean2)
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
    } while (paramlpa == null);
    paramlpa.a(a(), (float)a(), paramBoolean2);
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
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = ((int)(paramInt1 * 1.0F));
    this.jdField_e_of_type_Int = ((int)(paramInt2 * 1.0F));
    if (QLog.isColorLevel()) {
      QLog.i("AEFilterAVWrapperImpl", 2, "initInGL");
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
      this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.switchFilterOn(paramInt, paramBoolean);
    }
  }
  
  public void a(long paramLong)
  {
    QLog.w("AEFilterAVWrapperImpl", 1, "clearState, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_Lps != null) {
      this.jdField_a_of_type_Lps.a(paramLong);
    }
  }
  
  public void a(PendantItem paramPendantItem, VideoMaterial paramVideoMaterial)
  {
    boolean bool;
    if ((!lpr.a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramPendantItem)) || (this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != paramVideoMaterial))
    {
      if ((paramPendantItem == null) || (!paramPendantItem.hasGesture())) {
        break label228;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("AEFilterAVWrapperImpl", 2, "setPendant, pendantItem[" + paramPendantItem + "], isPendantHasGesture[" + bool + "]");
      }
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) && (!this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.isInited())) {
        break label250;
      }
      this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem = paramPendantItem;
      this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial = paramVideoMaterial;
      if (this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager != null) {
        this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager.updateMaterialGL(this.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      }
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break label233;
      }
      if (this.jdField_a_of_type_Lps != null) {
        this.jdField_a_of_type_Lps.a(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getGestureType());
      }
      label157:
      if (this.jdField_a_of_type_Lps != null) {
        this.jdField_a_of_type_Lps.a(false);
      }
      this.jdField_a_of_type_Long = 0L;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) && (PendantItem.isBeautyMakeup(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.getCategory())) && ((this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam instanceof Integer))) {
        this.f = ((Integer)this.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.extraParam).intValue();
      }
      return;
      label228:
      bool = false;
      break;
      label233:
      if (this.jdField_a_of_type_Lps == null) {
        break label157;
      }
      this.jdField_a_of_type_Lps.a();
      break label157;
      label250:
      QLog.i("AEFilterAVWrapperImpl", 1, "initAEDetector failed!");
    }
  }
  
  public void a(FilterDesc paramFilterDesc)
  {
    String str;
    StringBuilder localStringBuilder;
    if (!lpr.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramFilterDesc))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc = paramFilterDesc;
      str = a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      if ((this.jdField_a_of_type_ComTencentAekitApiStandardFilterAEFilterManager == null) || ((!TextUtils.isEmpty(str)) && (!bgmg.a(str)))) {
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
  
  public void a(low paramlow, lpa paramlpa)
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
      boolean bool2 = lhi.a().b();
      if ((lhp.a(localVideoMaterial)) && (!bool2)) {
        bool1 = false;
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("AEFilterAVWrapperImpl", 4, "processTip, cnt[" + paramlpa.jdField_a_of_type_Int + "], bIsPendantHasFace[" + bool1 + "], gesture[" + this.jdField_b_of_type_Boolean + "], gestureType[" + str2 + "], gestureWording[" + str1);
        }
        if (this.jdField_a_of_type_Lps != null)
        {
          int i = this.jdField_a_of_type_Lps.a(paramlow, paramlpa.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, bool1, str1, str2);
          if ((this.jdField_b_of_type_Boolean) && (i == 2))
          {
            if (this.jdField_a_of_type_Long != 0L) {
              break label212;
            }
            this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          }
        }
        label212:
        while (Math.abs(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long) <= 3000L) {
          return;
        }
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Lps.a(true);
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
  
  public boolean a(lon paramlon)
  {
    if (paramlon == null) {
      this.jdField_a_of_type_Lon.c();
    }
    for (;;)
    {
      return this.jdField_a_of_type_Lon.b();
      this.jdField_a_of_type_Lon.a(paramlon);
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
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = ((int)(paramInt1 * 1.0F));
    this.jdField_e_of_type_Int = ((int)(paramInt2 * 1.0F));
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
  
  public boolean d()
  {
    return this.jdField_e_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     loh
 * JD-Core Version:    0.7.0.1
 */