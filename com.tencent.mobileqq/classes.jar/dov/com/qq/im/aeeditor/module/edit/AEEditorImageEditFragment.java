package dov.com.qq.im.aeeditor.module.edit;

import alpo;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.FrameLayout;
import bdbw;
import blen;
import bler;
import bleu;
import blev;
import blfg;
import blfx;
import blgb;
import blge;
import blgg;
import blgv;
import blgw;
import blhb;
import blhc;
import blhe;
import blhf;
import blih;
import blii;
import blij;
import blik;
import blil;
import blin;
import blio;
import bljf;
import bljg;
import bljh;
import bljn;
import bljs;
import blki;
import blkj;
import blkk;
import blkw;
import blla;
import blld;
import blle;
import blll;
import bncp;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.exporter.ImageExportConfig;
import com.tencent.tavcut.exporter.ImageExporter;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.config.SessionConfig;
import com.tencent.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorApplyAllLoadingView;
import dov.com.qq.im.aeeditor.module.clip.image.EditorPicInfo;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.view.NumberIndicator;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AEEditorImageEditFragment
  extends AEEditorCommonEditFragment
  implements Handler.Callback, ViewPager.OnPageChangeListener, bljg, blle
{
  private static final String jdField_b_of_type_JavaLangString = AEEditorImageEditFragment.class.getSimpleName();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  blgg jdField_a_of_type_Blgg = new blij(this);
  private blgv jdField_a_of_type_Blgv = new blgv();
  private bljs jdField_a_of_type_Bljs = new bljs();
  private blki jdField_a_of_type_Blki = blkj.a();
  private ImageExporter jdField_a_of_type_ComTencentTavcutExporterImageExporter;
  private TAVCutImageSession jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession;
  private AEEditorImagePagerAdapter jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter;
  private AEEditorImageViewPager jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager;
  private NumberIndicator jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  blgg jdField_b_of_type_Blgg = new blik(this);
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList;
  private List<blgb> jdField_b_of_type_JavaUtilList = new ArrayList();
  
  private HashMap<String, LocalMediaInfo> a(ArrayList<String> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      LocalMediaInfo localLocalMediaInfo = blll.a(str);
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        localLocalMediaInfo.aiTextLabel = ((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(str));
      }
      localHashMap.put(str, localLocalMediaInfo);
    }
    return localHashMap;
  }
  
  private void a(View paramView)
  {
    blfg.b(jdField_b_of_type_JavaLangString, "initViews");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager = ((AEEditorImageViewPager)paramView.findViewById(2131379882));
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator = ((NumberIndicator)paramView.findViewById(2131371307));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setOnPageChangeListener(this);
  }
  
  private void b(int paramInt)
  {
    blfg.b(jdField_b_of_type_JavaLangString, "updateImageFilterByIndex: " + paramInt);
    if ((this.jdField_a_of_type_Bljs.b(paramInt) == 0) && (this.jdField_a_of_type_Bljs.a(paramInt) == 0))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.render(paramInt);
      return;
    }
    if (this.jdField_a_of_type_Bljs.b(paramInt))
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setAEKitAIFilter(paramInt, this.jdField_a_of_type_Bljs.a(paramInt).b(), this.jdField_a_of_type_Bljs.a(paramInt).a(), this.jdField_a_of_type_Bljs.a(paramInt).a(), (int)(this.jdField_a_of_type_Bljs.a(paramInt).b() * 100.0F), this.jdField_a_of_type_Bljs.a(paramInt).c());
      return;
    }
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.removeAIFilter(paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutImage(paramInt, this.jdField_a_of_type_Bljs.a(paramInt));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutAlpha(paramInt, this.jdField_a_of_type_Bljs.a(paramInt));
  }
  
  private int c()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  private void c(int paramInt)
  {
    if (paramInt >= 1) {
      b(paramInt - 1);
    }
    if (paramInt < c() - 1) {
      b(paramInt + 1);
    }
  }
  
  private int d()
  {
    return this.jdField_a_of_type_Blki.c();
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (!new File((String)localIterator.next()).exists()) {
        return false;
      }
    }
    return true;
  }
  
  private boolean e()
  {
    return blev.a().a("SP_KEY_HAS_SINGLE_IMAGE_USE_AIFILTER", true, 0);
  }
  
  private void o()
  {
    blfg.b(jdField_b_of_type_JavaLangString, "showImages");
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = new AEEditorImagePagerAdapter(this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, new blih(this));
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setTotalCount(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.getCount());
    NumberIndicator localNumberIndicator = this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.getCount() > 0) {}
    for (int i = 1;; i = 0)
    {
      localNumberIndicator.setCurrentIndex(i);
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter);
      return;
    }
  }
  
  private void p()
  {
    blfg.b(jdField_b_of_type_JavaLangString, "initTAVCutSession");
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = new TAVCutImageSession();
    SessionConfig localSessionConfig = new SessionConfig();
    localSessionConfig.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
    localSessionConfig.setMinIntermediateRenderSize(this.jdField_a_of_type_Blki.a());
    localSessionConfig.setMaxIntermediateRenderSize(this.jdField_a_of_type_Blki.b());
    localSessionConfig.setMaxImageDecodeSize((int)(this.jdField_a_of_type_Blki.b() * 1.3D));
    Object localObject = new StickerEditViewIconConfig();
    ((StickerEditViewIconConfig)localObject).setDeleteIconResId(2130837657);
    ((StickerEditViewIconConfig)localObject).setEditIconResId(2130837658);
    ((StickerEditViewIconConfig)localObject).setZoomIconResId(2130837659);
    localSessionConfig.setStickerEditViewIconConfig((StickerEditViewIconConfig)localObject);
    localObject = new ArrayList();
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      ((List)localObject).add(((blgb)this.jdField_b_of_type_JavaUtilList.get(i)).a);
      i += 1;
    }
    localSessionConfig.setImageInitCropConfigs((List)localObject);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setSessionConfig(localSessionConfig);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setImagePaths(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setStickerOperationCallback(new blii(this));
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.init(getActivity());
  }
  
  private void q()
  {
    AEEditorApplyAllLoadingView localAEEditorApplyAllLoadingView = new AEEditorApplyAllLoadingView(getActivity());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localAEEditorApplyAllLoadingView);
  }
  
  private void r()
  {
    blev.a().a("SP_KEY_HAS_SINGLE_IMAGE_USE_AIFILTER", false, 0);
  }
  
  public int a()
  {
    return 2131558531;
  }
  
  protected bljf a()
  {
    return this;
  }
  
  protected bljn a()
  {
    return new blio(this);
  }
  
  protected blla a()
  {
    return new blil(this);
  }
  
  protected blld a()
  {
    return this;
  }
  
  public String a()
  {
    return "AEEditorImageEdit";
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutAlpha(this.jdField_a_of_type_Int, paramFloat);
    this.jdField_a_of_type_Bljs.a(this.jdField_a_of_type_Int, paramFloat);
    this.jdField_a_of_type_Bljs.a(this.jdField_a_of_type_Int, paramInt, paramFloat);
    bler.a().a().b.put(Integer.valueOf(this.jdField_a_of_type_Int), Float.valueOf(paramFloat));
  }
  
  public void a(int paramInt, String paramString, float paramFloat, AEEditorFilterBean paramAEEditorFilterBean)
  {
    h();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(true);
    float f = this.jdField_a_of_type_Bljs.a(this.jdField_a_of_type_Int, paramInt, paramFloat);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(f);
    this.jdField_a_of_type_Bljs.a(this.jdField_a_of_type_Int, paramString, f, paramInt);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.removeAIFilter(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutImage(this.jdField_a_of_type_Int, paramString);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutAlpha(this.jdField_a_of_type_Int, f);
    bler.a().a().jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_Int), paramAEEditorFilterBean.getSid());
    bler.a().a().b.put(Integer.valueOf(this.jdField_a_of_type_Int), Float.valueOf(paramFloat));
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.mediaChanged()) {
      return false;
    }
    return super.a();
  }
  
  protected int b()
  {
    return 0;
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_JavaUtilList.size() > 1;
  }
  
  public String c()
  {
    return alpo.a(2131689798);
  }
  
  protected void c()
  {
    blfg.b(jdField_b_of_type_JavaLangString, "initImageInfos");
    Object localObject1 = new ArrayList();
    Object localObject2 = getArguments();
    if (((Bundle)localObject2).containsKey("AEEditorConstants_CLIPPED_PIC_INFOS")) {
      localObject1 = (List)((Bundle)localObject2).getSerializable("AEEditorConstants_CLIPPED_PIC_INFOS");
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (EditorPicInfo)((Iterator)localObject1).next();
        CropConfig localCropConfig = new CropConfig((float)((EditorPicInfo)localObject2).x, (float)((EditorPicInfo)localObject2).y, (float)((EditorPicInfo)localObject2).w, (float)((EditorPicInfo)localObject2).h);
        this.jdField_a_of_type_JavaUtilList.add(((EditorPicInfo)localObject2).picPath);
        this.jdField_b_of_type_JavaUtilList.add(new blgb(((EditorPicInfo)localObject2).picPath, (int)((EditorPicInfo)localObject2).originPicWidth, (int)((EditorPicInfo)localObject2).originPicHeight, localCropConfig));
      }
      blfg.d(jdField_b_of_type_JavaLangString, "no image crop infos");
    }
    this.jdField_b_of_type_Int = d();
    this.jdField_a_of_type_Bljs.a(this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_Blgv.a((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
    boolean bool;
    if ((localObject != null) && ((localObject instanceof blhf)))
    {
      blfg.b(jdField_b_of_type_JavaLangString, "onAIFilterRequest: has cache");
      bool = ((blhf)localObject).a;
      blfg.b(jdField_b_of_type_JavaLangString, "onAIFilterRequest: needRequest=" + bool);
      if (!bool) {
        break label155;
      }
      g();
      localObject = new blhe((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int), this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_Int);
      ((blhe)localObject).a(this.jdField_a_of_type_Blgg);
      blge.a().a(getActivity().getAppInterface(), getActivity(), (blgw)localObject);
    }
    for (;;)
    {
      if (bool) {
        break label254;
      }
      return true;
      bool = true;
      break;
      label155:
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
      this.jdField_a_of_type_Bljs.a(this.jdField_a_of_type_Int, (blhb)localObject);
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setAEKitAIFilter(this.jdField_a_of_type_Int, ((blhb)localObject).b(), ((blhb)localObject).a(), ((blhb)localObject).a(), (int)(((blhb)localObject).b() * 100.0F), ((blhb)localObject).c());
      a(new String[] { "智能滤镜label", ((blhb)localObject).a(), "智能滤镜errCode", "0" });
    }
    label254:
    return false;
  }
  
  protected void d()
  {
    blge.a().a();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_a_of_type_Int);
    }
  }
  
  public void f()
  {
    blfg.b(jdField_b_of_type_JavaLangString, "exportImages");
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession == null)
    {
      blfg.d(jdField_b_of_type_JavaLangString, "exportImages error: session is null");
      return;
    }
    if (!d())
    {
      QQToast.a(getActivity(), "图片不存在或被删除", 0).a();
      return;
    }
    ThreadManager.getUIHandler().post(new AEEditorImageEditFragment.6(this));
    Object localObject1 = blfx.c;
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList = null;
    }
    for (this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();; this.jdField_b_of_type_JavaUtilArrayList = new ArrayList())
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject2 = new File((String)this.jdField_a_of_type_JavaUtilList.get(i));
        localObject2 = (String)localObject1 + File.separator + "output_" + i + "_" + System.currentTimeMillis() + "_" + bncp.a(((File)localObject2).getName()) + ".jpg";
        this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
        if (this.jdField_a_of_type_JavaUtilHashMap != null)
        {
          ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(String.valueOf(i));
          if (localArrayList != null)
          {
            this.jdField_a_of_type_JavaUtilHashMap.remove(String.valueOf(i));
            this.jdField_a_of_type_JavaUtilHashMap.put(localObject2, localArrayList);
          }
        }
        i += 1;
      }
    }
    localObject1 = new ImageExportConfig();
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_a_of_type_Int);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = d();
    }
    ((ImageExportConfig)localObject1).setMaxExportSize(d());
    ((ImageExportConfig)localObject1).setMinIntermediateRenderSize(d());
    ((ImageExportConfig)localObject1).setMaxIntermediateRenderSize(d());
    ((ImageExportConfig)localObject1).setQuality(this.jdField_a_of_type_Blki.d());
    ((ImageExportConfig)localObject1).setOutputPath(this.jdField_b_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter = this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.getExporter((ImageExportConfig)localObject1);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentTavcutExporterImageExporter.export(new blin(this));
  }
  
  public void i()
  {
    int j = 0;
    blfg.b(jdField_b_of_type_JavaLangString, "onApplyAll current position = " + this.jdField_a_of_type_Int);
    blen.a().m();
    Object localObject1;
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a())
    {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = this.jdField_a_of_type_Blgv.a((String)localObject2);
          if ((localObject2 != null) && ((localObject2 instanceof blhf)))
          {
            blfg.b(jdField_b_of_type_JavaLangString, "onAIFilterRequest: has cache");
            if (!((blhb)localObject2).a) {
              continue;
            }
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        g();
        localObject1 = new blhc(this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_Int, this.jdField_a_of_type_Blgv.a((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)));
        ((blhc)localObject1).a(this.jdField_b_of_type_Blgg);
        blge.a().a(getActivity().getAppInterface(), getActivity(), (blgw)localObject1);
        return;
        i = 1;
      }
      else
      {
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
        this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(1);
        localObject1 = new StringBuilder();
        i = j;
        while (i < c())
        {
          localObject2 = (blhf)this.jdField_a_of_type_Blgv.a((String)this.jdField_a_of_type_JavaUtilList.get(i));
          this.jdField_a_of_type_Bljs.a(i, (blhb)localObject2);
          ((StringBuilder)localObject1).append(((blhf)localObject2).a() + "|");
          i += 1;
        }
        a("智能滤镜label", ((StringBuilder)localObject1).toString());
        b(this.jdField_a_of_type_Int);
        c(this.jdField_a_of_type_Int);
        q();
        return;
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b())
        {
          this.jdField_a_of_type_Bljs.a();
          c(this.jdField_a_of_type_Int);
          q();
          return;
        }
        this.jdField_a_of_type_Bljs.b(this.jdField_a_of_type_Int);
        c(this.jdField_a_of_type_Int);
        q();
        return;
        i = 0;
      }
    }
  }
  
  public void j()
  {
    h();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.removeAIFilter(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setLutImage(this.jdField_a_of_type_Int, null);
    this.jdField_a_of_type_Bljs.c(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.getVisibility() != 0) {
      this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(4);
  }
  
  public void l()
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setVisibility(0);
  }
  
  public void m() {}
  
  public void n()
  {
    this.jdField_a_of_type_Blkw.a(getActivity(), this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession, this.jdField_a_of_type_Int);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    blfg.b(jdField_b_of_type_JavaLangString, "onCreate");
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    blfg.b(jdField_b_of_type_JavaLangString, "onDestroy");
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    blfg.b(jdField_b_of_type_JavaLangString, "onDestroyView");
    super.onDestroyView();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter.a();
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImagePagerAdapter = null;
    if (this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession != null)
    {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.release();
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession = null;
    }
    this.jdField_a_of_type_Bljs.b();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.applyCurrentSticker(this.jdField_a_of_type_Int);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    blfg.b(jdField_b_of_type_JavaLangString, "onPageSelected: " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentTavcutSessionTAVCutImageSession.setCurrentIndex(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_DovComQqImAeeditorViewNumberIndicator.setCurrentIndex(paramInt + 1);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_a_of_type_Bljs.a(this.jdField_a_of_type_Int));
    if ((this.jdField_a_of_type_Bljs.a(this.jdField_a_of_type_Int)) || (this.jdField_a_of_type_Bljs.b(this.jdField_a_of_type_Int)))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(false);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(true);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setSeekBarValue(this.jdField_a_of_type_Bljs.a(this.jdField_a_of_type_Int));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    blfg.b(jdField_b_of_type_JavaLangString, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    blfg.b(jdField_b_of_type_JavaLangString, "init");
    this.jdField_a_of_type_Bdbw = new bdbw(Looper.getMainLooper(), this);
    p();
    this.jdField_a_of_type_Bljs.b();
    a(paramView);
    o();
    if ((e()) && (c() == 1))
    {
      if (!bljh.a().a()) {
        break label222;
      }
      blfg.b(jdField_b_of_type_JavaLangString, "single image + first time : aifilter auto request");
      c();
      r();
    }
    for (;;)
    {
      a(new String[] { "设备级别", blkk.a(), "图片最小预览尺寸", String.valueOf(this.jdField_a_of_type_Blki.a()), "图片最大预览尺寸", String.valueOf(this.jdField_a_of_type_Blki.b()), "图片导出质量", this.jdField_a_of_type_Blki.d() + "%", "图片最大导出尺寸", String.valueOf(this.jdField_b_of_type_Int) });
      return;
      label222:
      blfg.d(jdField_b_of_type_JavaLangString, "single image + first time : aifilter res not ready, do not request");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment
 * JD-Core Version:    0.7.0.1
 */