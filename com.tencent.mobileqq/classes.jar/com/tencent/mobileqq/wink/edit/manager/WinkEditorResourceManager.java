package com.tencent.mobileqq.wink.edit.manager;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.QQWinkEnvironment;
import com.tencent.mobileqq.wink.edit.base.AEEditorPath.EDITOR.FILES;
import com.tencent.mobileqq.wink.edit.base.AEPath.Editor.FILES;
import com.tencent.mobileqq.wink.edit.bean.AEEditorDownloadResBean;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.edit.util.ParamsUtil;
import com.tencent.mobileqq.wink.editor.filter.FilterMetaMaterialKt;
import com.tencent.open.base.FileUtils;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class WinkEditorResourceManager
  extends WinkEditorResourceDownloader
{
  public static final String j;
  public static final String m;
  private static final String n;
  private static volatile WinkEditorResourceManager o;
  @NonNull
  private final Map<String, AEEditorDownloadResBean> A = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> B = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> C = new LinkedHashMap();
  private final int D = ((Integer)ParamsUtil.a(Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7))).intValue();
  protected volatile boolean k = false;
  protected volatile boolean l = false;
  private final MutableLiveData<List<MetaCategory>> p = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> q = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> r = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> s = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> t = new MutableLiveData();
  private final MutableLiveData<List<MetaCategory>> u = new MutableLiveData();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> v = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> w = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> x = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> y = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> z = new LinkedHashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.FILES.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("delete");
    j = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.FILES.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("text");
    n = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEEditorPath.EDITOR.FILES.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("frame");
    m = localStringBuilder.toString();
  }
  
  private WinkEditorResourceManager()
  {
    super("winkEdit/wink_editor_download_resources.json", AEEditorPath.EDITOR.FILES.b, 4, "[AEEditor2]AEEditorResourceManager");
  }
  
  @WorkerThread
  private void A()
  {
    synchronized (this.v)
    {
      if (this.k) {
        return;
      }
      this.k = true;
      Object localObject1 = a("winkEdit/wink_editor_base_fonts.json");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        WinkQLog.d(this.d, "setupFontListConfig---read assets json content empty");
        return;
      }
      Object localObject3 = (List)GsonUtils.json2Obj((String)localObject1, new WinkEditorResourceManager.1(this).getType());
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupFontListConfig---size = ");
      if (localObject3 == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(((List)localObject3).size());
      }
      localStringBuilder.append(localObject1);
      WinkQLog.b(str, localStringBuilder.toString());
      if (localObject3 != null)
      {
        localObject1 = ((List)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (AEEditorDownloadResBean)((Iterator)localObject1).next();
          this.v.put(((AEEditorDownloadResBean)localObject3).getId(), localObject3);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  @WorkerThread
  private void B()
  {
    synchronized (this.x)
    {
      if (this.l) {
        return;
      }
      this.l = true;
      Iterator localIterator1 = c().v().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((MetaCategory)localIterator1.next()).materials.iterator();
        while (localIterator2.hasNext())
        {
          MetaMaterial localMetaMaterial = (MetaMaterial)localIterator2.next();
          AEEditorDownloadResBean localAEEditorDownloadResBean = new AEEditorDownloadResBean();
          localAEEditorDownloadResBean.setId(localMetaMaterial.id);
          localAEEditorDownloadResBean.setUrl(localMetaMaterial.packageUrl);
          localAEEditorDownloadResBean.setMd5(localMetaMaterial.packageMd5);
          String str = (String)localMetaMaterial.additionalFields.get("preDownload");
          if (!TextUtils.isEmpty(str)) {
            localAEEditorDownloadResBean.setPreDownload(Integer.parseInt(str));
          }
          this.x.put(localMetaMaterial.id, localAEEditorDownloadResBean);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  @WorkerThread
  private void C()
  {
    new File(n);
    FileUtils.a(QQWinkEnvironment.a(), "wink/pag", n);
  }
  
  public static WinkEditorResourceManager c()
  {
    if (o == null) {
      try
      {
        if (o == null) {
          o = new WinkEditorResourceManager();
        }
      }
      finally {}
    }
    return o;
  }
  
  @Nullable
  private String c(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    Object localObject = a(paramAEEditorDownloadResBean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramAEEditorDownloadResBean.getId());
    paramAEEditorDownloadResBean = localStringBuilder.toString();
    if (new File(paramAEEditorDownloadResBean).exists()) {
      return paramAEEditorDownloadResBean;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAEEditorDownloadResBean);
    ((StringBuilder)localObject).append(".ttf");
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramAEEditorDownloadResBean);
    ((StringBuilder)localObject).append(".otf");
    paramAEEditorDownloadResBean = ((StringBuilder)localObject).toString();
    if (new File(paramAEEditorDownloadResBean).exists()) {
      return paramAEEditorDownloadResBean;
    }
    return null;
  }
  
  @WorkerThread
  private void z()
  {
    a(AEPath.Editor.FILES.d, "editor_filter_update_template.json", "winkEdit/wink_editor_display_effects.json", this.y);
    a(AEPath.Editor.FILES.d, "editor_text_sticker_update_template.json", "winkEdit/wink_editor_text_stickers_default.json", this.B);
    a(AEPath.Editor.FILES.g, "editor_text_update_template.json", "winkEdit/wink_editor_text.json", this.x);
    a(AEPath.Editor.FILES.g, "editor_auto_template_update_template.json", "winkEdit/wink_editor_auto_template.json", this.C);
  }
  
  @Nullable
  public String a(String paramString, int paramInt)
  {
    return (String)b(paramString, paramInt).first;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Map<String, AEEditorDownloadResBean> paramMap)
  {
    Object localObject1 = this.d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("checkNeedDownload... json:");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(" defaultJson:");
    ((StringBuilder)localObject2).append(paramString3);
    WinkQLog.a((String)localObject1, ((StringBuilder)localObject2).toString());
    long l1 = System.currentTimeMillis();
    try
    {
      paramString1 = WinkEditorMaterialManager.a().a(paramString1, paramString2, paramString3, true);
      if ((paramString1 != null) && (paramString1.size() != 0))
      {
        paramMap.clear();
        paramString2 = this.d;
        paramString3 = new StringBuilder();
        paramString3.append("checkNeedDownload... groupList size:");
        paramString3.append(paramString1.size());
        WinkQLog.a(paramString2, paramString3.toString());
        paramString1 = paramString1.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = ((MetaCategory)paramString1.next()).materials.iterator();
          while (paramString2.hasNext())
          {
            paramString3 = (MetaMaterial)paramString2.next();
            localObject1 = new AEEditorDownloadResBean();
            ((AEEditorDownloadResBean)localObject1).setId(paramString3.id);
            ((AEEditorDownloadResBean)localObject1).setUrl(paramString3.packageUrl);
            ((AEEditorDownloadResBean)localObject1).setMd5(paramString3.packageMd5);
            if (paramString3.additionalFields != null)
            {
              localObject2 = (String)paramString3.additionalFields.get("preDownload");
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                ((AEEditorDownloadResBean)localObject1).setPreDownload(Integer.parseInt((String)localObject2));
              }
            }
            paramMap.put(paramString3.id, localObject1);
          }
        }
        paramString1 = this.d;
        paramString2 = new StringBuilder();
        paramString2.append("checkNeedDownload... cost:");
        paramString2.append(System.currentTimeMillis() - l1);
        WinkQLog.a(paramString1, paramString2.toString());
        return;
      }
      WinkQLog.d(this.d, "checkNeedDownload... groupList is empty.");
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString1;
    }
  }
  
  protected void a(@NonNull List<AEEditorDownloadResBean> paramList)
  {
    z();
    Iterator localIterator = this.y.values().iterator();
    AEEditorDownloadResBean localAEEditorDownloadResBean;
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    localIterator = this.z.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    localIterator = this.A.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    localIterator = this.C.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
  }
  
  @NonNull
  public Pair<String, String> b(@NonNull String paramString, int paramInt)
  {
    Object localObject = c(paramString);
    if (localObject != null) {
      localObject = c((AEEditorDownloadResBean)localObject);
    } else {
      localObject = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      WinkQLog.d("[AEEditor2]AEEditorResourceManager", "font not find.");
      return new Pair(localObject, "ERROR_CANNOT_FIND_VALID_FONT");
    }
    if (paramInt == 1) {
      return new Pair(localObject, "SUCCESS_GET_VALID_FONT");
    }
    if (e(paramString))
    {
      WinkQLog.d("[AEEditor2]AEEditorResourceManager", "fontExceededLimit.");
      return new Pair(localObject, "ERROR_EXCEEDED_FONT_LIMIT");
    }
    synchronized (this.w)
    {
      AEEditorDownloadResBean localAEEditorDownloadResBean = d(paramString);
      if (localAEEditorDownloadResBean != null) {
        this.w.put(paramString, localAEEditorDownloadResBean);
      }
      paramString = new Pair(localObject, "SUCCESS_GET_VALID_FONT");
      return paramString;
    }
  }
  
  protected void b(@NonNull List<AEEditorDownloadResBean> paramList)
  {
    Iterator localIterator = this.B.values().iterator();
    AEEditorDownloadResBean localAEEditorDownloadResBean;
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    A();
    localIterator = this.v.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
    B();
    localIterator = this.x.values().iterator();
    while (localIterator.hasNext())
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)localIterator.next();
      if ((localAEEditorDownloadResBean != null) && (localAEEditorDownloadResBean.getPreDownload() == 1) && (!b(localAEEditorDownloadResBean))) {
        paramList.add(localAEEditorDownloadResBean);
      }
    }
  }
  
  @Nullable
  public AEEditorDownloadResBean c(@NonNull String paramString)
  {
    A();
    B();
    return d(paramString);
  }
  
  public String c(MetaMaterial paramMetaMaterial)
  {
    paramMetaMaterial = FilterMetaMaterialKt.j(paramMetaMaterial);
    if (paramMetaMaterial.isEmpty()) {
      return null;
    }
    a();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.e.get(paramMetaMaterial);
    if (localAEEditorDownloadResBean == null)
    {
      localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.y.get(paramMetaMaterial);
      if (localAEEditorDownloadResBean == null) {
        return null;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(localAEEditorDownloadResBean));
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramMetaMaterial);
      localStringBuilder.append(".png");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(localAEEditorDownloadResBean));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramMetaMaterial);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public MutableLiveData<List<MetaCategory>> d()
  {
    return this.p;
  }
  
  public AEEditorDownloadResBean d(String paramString)
  {
    Map localMap = this.v;
    if ((localMap != null) && (localMap.get(paramString) != null)) {
      return (AEEditorDownloadResBean)this.v.get(paramString);
    }
    localMap = this.x;
    if ((localMap != null) && (localMap.get(paramString) != null)) {
      return (AEEditorDownloadResBean)this.x.get(paramString);
    }
    return null;
  }
  
  public String d(MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("effectInfo.json");
    return localStringBuilder.toString();
  }
  
  public MutableLiveData<List<MetaCategory>> e()
  {
    return this.q;
  }
  
  public String e(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("params.json");
    return localStringBuilder.toString();
  }
  
  public boolean e(@NonNull String paramString)
  {
    synchronized (this.w)
    {
      paramString = (AEEditorDownloadResBean)this.w.get(paramString);
      boolean bool = false;
      if (paramString != null) {
        return false;
      }
      if (this.w.size() >= this.D) {
        bool = true;
      }
      return bool;
    }
  }
  
  public MutableLiveData<List<MetaCategory>> f()
  {
    return this.r;
  }
  
  public String f(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("main.pag");
    return localStringBuilder.toString();
  }
  
  public MutableLiveData<List<MetaCategory>> g()
  {
    return this.s;
  }
  
  public String g(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("template.json");
    return localStringBuilder.toString();
  }
  
  public MutableLiveData<List<MetaCategory>> h()
  {
    return this.t;
  }
  
  public String h(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("blur_text.png");
    return localStringBuilder.toString();
  }
  
  public MutableLiveData<List<MetaCategory>> i()
  {
    return this.u;
  }
  
  public String i(@NonNull MetaMaterial paramMetaMaterial)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramMetaMaterial));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("blur_texture.png");
    return localStringBuilder.toString();
  }
  
  public void j()
  {
    WinkQLog.b(this.d, "loadAssets");
    ThreadManager.excute(new WinkEditorResourceManager.3(this), 64, null, true);
  }
  
  public void k()
  {
    WinkQLog.b(this.d, "loadDeleteAssets");
    ThreadManager.excute(new WinkEditorResourceManager.4(this), 64, null, true);
  }
  
  public void l()
  {
    WinkQLog.b(this.d, "loadDeleteAssets");
    ThreadManager.excute(new WinkEditorResourceManager.5(this), 64, null, true);
  }
  
  public void m()
  {
    WinkQLog.a("[AEEditor2]AEEditorResourceManager", "loadFilter...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new WinkEditorResourceManager.6(this), 64, null, true);
      return;
    }
    List localList = q();
    d().postValue(localList);
  }
  
  public void n()
  {
    WinkQLog.a("[AEEditor2]AEEditorResourceManager", "loadAutoTemplate...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new WinkEditorResourceManager.9(this), 64, null, true);
      return;
    }
    List localList = t();
    MetaCategory localMetaCategory = WinkEditorMaterialManager.a().b();
    if (localMetaCategory != null) {
      localList.add(0, localMetaCategory);
    }
    g().postValue(localList);
  }
  
  public void o()
  {
    WinkQLog.a("[AEEditor2]AEEditorResourceManager", "loadSticker...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new WinkEditorResourceManager.10(this), 64, null, true);
      return;
    }
    List localList = u();
    h().postValue(localList);
  }
  
  public void p()
  {
    WinkQLog.a("[AEEditor2]AEEditorResourceManager", "loadText...");
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.excute(new WinkEditorResourceManager.11(this), 64, null, true);
      return;
    }
    List localList = v();
    i().postValue(localList);
  }
  
  public List<MetaCategory> q()
  {
    return WinkEditorMaterialManager.a().a(AEPath.Editor.FILES.d, "editor_filter_update_template.json", "winkEdit/wink_editor_display_effects.json", false);
  }
  
  public List<MetaCategory> r()
  {
    return WinkEditorMaterialManager.a().a(AEPath.Editor.FILES.e, "editor_frame_update_template.json", "winkEdit/wink_editor_frame.json", false);
  }
  
  public List<MetaCategory> s()
  {
    return WinkEditorMaterialManager.a().a(AEPath.Editor.FILES.f, "editor_pic_template_update_template.json", "winkEdit/wink_editor_pic_template.json", false);
  }
  
  public List<MetaCategory> t()
  {
    return WinkEditorMaterialManager.a().a(AEPath.Editor.FILES.c, "editor_auto_template_update_template.json", "winkEdit/wink_editor_auto_template.json", false);
  }
  
  public List<MetaCategory> u()
  {
    return WinkEditorMaterialManager.a().a(AEPath.Editor.FILES.b, "editor_text_sticker_update_template.json", "winkEdit/wink_editor_text_stickers_default.json", false);
  }
  
  public List<MetaCategory> v()
  {
    return WinkEditorMaterialManager.a().a(AEPath.Editor.FILES.g, "editor_text_update_template.json", "winkEdit/wink_editor_text.json", false);
  }
  
  public String w()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("main.pag");
    return localStringBuilder.toString();
  }
  
  public String x()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("editor_loading_img_kuaishan.pag");
    return localStringBuilder.toString();
  }
  
  public String y()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(n);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("params.json");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager
 * JD-Core Version:    0.7.0.1
 */