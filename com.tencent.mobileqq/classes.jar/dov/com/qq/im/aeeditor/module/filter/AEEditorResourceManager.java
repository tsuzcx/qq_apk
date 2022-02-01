package dov.com.qq.im.aeeditor.module.filter;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorPath.EDITOR.FILES;
import dov.com.qq.im.aeeditor.data.AEEditorDownloadResBean;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectUtils;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerConfig;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerGroup;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerGroupWrapper;
import dov.com.qq.im.aeeditor.manage.AEEditorPagStickerInfo;
import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader;
import dov.com.qq.im.aeeditor.manage.AEditorMaterialManager;
import dov.com.qq.im.aeeditor.module.params.ParamsUtil;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public final class AEEditorResourceManager
  extends AEEditorResourceDownloader
{
  private static volatile AEEditorResourceManager jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorResourceManager;
  public static final String d;
  private final MutableLiveData<List<AEEditorFilterBean>> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  @NonNull
  private final List<AEEditorPagStickerGroup> jdField_a_of_type_JavaUtilList = new LinkedList();
  private final int b = ((Integer)ParamsUtil.b(Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7))).intValue();
  protected volatile boolean c;
  @NonNull
  private final Map<String, AEEditorPagStickerInfo> d;
  protected volatile boolean d;
  @NonNull
  private final Map<String, AEEditorDownloadResBean> e = new LinkedHashMap();
  @NonNull
  private final Map<String, AEEditorDownloadResBean> f = new LinkedHashMap();
  
  static
  {
    jdField_d_of_type_JavaLangString = AEEditorPath.EDITOR.FILES.b + File.separator + "frame";
  }
  
  private AEEditorResourceManager()
  {
    super("camera/ae_camera_editor_download_resources.json", AEEditorPath.EDITOR.FILES.b, 4, "AEEditorResourceManager");
    this.jdField_d_of_type_JavaUtilMap = new LinkedHashMap();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public static AEEditorResourceManager a()
  {
    if (jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorResourceManager == null) {}
    try
    {
      if (jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorResourceManager == null) {
        jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorResourceManager = new AEEditorResourceManager();
      }
      return jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorResourceManager;
    }
    finally {}
  }
  
  @Nullable
  private String a(@NonNull String paramString1, @NonNull String paramString2)
  {
    g();
    paramString1 = (AEEditorPagStickerInfo)this.jdField_d_of_type_JavaUtilMap.get(paramString1);
    if (paramString1 == null) {
      return null;
    }
    paramString1 = AEEditorPagStickerInfo.convert2DownloadBean(paramString1);
    return a(paramString1) + File.separator + paramString2;
  }
  
  public static void a(Context paramContext)
  {
    if (new File(jdField_d_of_type_JavaLangString).exists())
    {
      AEQLog.b("AEEditorResourceManager", "setupFrameEnv---pag file is already copied");
      return;
    }
    paramContext = paramContext.getApplicationContext();
    ThreadManager.getFileThreadHandler().post(new AEEditorResourceManager.5(paramContext));
  }
  
  @Nullable
  private String b(@NonNull AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    String str = a(paramAEEditorDownloadResBean);
    paramAEEditorDownloadResBean = str + File.separator + paramAEEditorDownloadResBean.getId();
    if (new File(paramAEEditorDownloadResBean).exists()) {}
    do
    {
      return paramAEEditorDownloadResBean;
      str = paramAEEditorDownloadResBean + ".ttf";
      if (new File(str).exists()) {
        return str;
      }
      str = paramAEEditorDownloadResBean + ".otf";
      paramAEEditorDownloadResBean = str;
    } while (new File(str).exists());
    return null;
  }
  
  @WorkerThread
  private void e()
  {
    AEQLog.b(this.jdField_c_of_type_JavaLangString, "setupDisplayFilterList--BEGIN");
    QIPCClientHelper.getInstance().callServer("AEEditorEffectIpcModule", "action_get_effect_list", new Bundle(), new AEEditorResourceManager.1(this));
  }
  
  @WorkerThread
  private void f()
  {
    synchronized (this.e)
    {
      if (this.jdField_d_of_type_Boolean) {
        return;
      }
      this.jdField_d_of_type_Boolean = true;
      String str1 = a("camera/ae_camera_editor_fonts.json");
      if (TextUtils.isEmpty(str1))
      {
        AEQLog.d(this.jdField_c_of_type_JavaLangString, "setupFontListConfig---read assets json content empty");
        return;
      }
    }
    Object localObject2 = (List)GsonUtils.json2Obj(str2, new AEEditorResourceManager.2(this).getType());
    String str3 = this.jdField_c_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("setupFontListConfig---size = ");
    if (localObject2 == null) {}
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(((List)localObject2).size()))
    {
      AEQLog.b(str3, localObject1);
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AEEditorDownloadResBean)((Iterator)localObject1).next();
        this.e.put(((AEEditorDownloadResBean)localObject2).getId(), localObject2);
      }
    }
  }
  
  @WorkerThread
  private void g()
  {
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaUtilMap)
      {
        if (AEditorMaterialManager.a().a())
        {
          this.jdField_d_of_type_JavaUtilMap.clear();
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_c_of_type_Boolean = false;
        }
        if (this.jdField_c_of_type_Boolean) {
          return;
        }
        this.jdField_c_of_type_Boolean = true;
        Object localObject1 = AEditorMaterialManager.a().a();
        if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
          break label283;
        }
        localObject1 = a("camera/ae_camera_editor_pag_stickers.json");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = new LinkedList();
          AEQLog.d(this.jdField_c_of_type_JavaLangString, "ensureSetupPagStickerConfig---read assets json content empty");
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
          localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
          continue;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject3 = (AEEditorPagStickerGroup)((Iterator)localObject1).next();
          if ((localObject3 == null) || (CollectionUtils.isEmpty(((AEEditorPagStickerGroup)localObject3).stickerInfoList))) {
            continue;
          }
          localObject3 = ((AEEditorPagStickerGroup)localObject3).stickerInfoList.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            continue;
          }
          AEEditorPagStickerInfo localAEEditorPagStickerInfo = (AEEditorPagStickerInfo)((Iterator)localObject3).next();
          if (localAEEditorPagStickerInfo == null) {
            continue;
          }
          this.jdField_d_of_type_JavaUtilMap.put(localAEEditorPagStickerInfo.stickerId, localAEEditorPagStickerInfo);
        }
      }
      Object localObject2 = (AEEditorPagStickerGroupWrapper)GsonUtils.json2Obj(str, new AEEditorResourceManager.3(this).getType());
      if ((localObject2 == null) || (CollectionUtils.isEmpty(((AEEditorPagStickerGroupWrapper)localObject2).stickerGroupList)))
      {
        localObject2 = new LinkedList();
        AEQLog.d(this.jdField_c_of_type_JavaLangString, "ensureSetupPagStickerConfig---parsed result invalid");
      }
      else
      {
        localObject2 = ((AEEditorPagStickerGroupWrapper)localObject2).stickerGroupList;
        continue;
        label283:
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
      }
    }
    AEQLog.b(this.jdField_c_of_type_JavaLangString, "ensureSetupPagStickerConfig---size = " + this.jdField_d_of_type_JavaUtilMap.size());
  }
  
  public MutableLiveData<List<AEEditorFilterBean>> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  @NonNull
  public Pair<String, String> a(@NonNull String paramString, int paramInt)
  {
    Object localObject = a(paramString);
    if (localObject != null) {}
    for (localObject = b((AEEditorDownloadResBean)localObject);; localObject = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        AEQLog.d("AEEditorResourceManager", "font not find.");
        return new Pair(localObject, "ERROR_CANNOT_FIND_VALID_FONT");
      }
      if (paramInt == 1) {
        return new Pair(localObject, "SUCCESS_GET_VALID_FONT");
      }
      if (b(paramString))
      {
        AEQLog.d("AEEditorResourceManager", "fontExceededLimit.");
        return new Pair(localObject, "ERROR_EXCEEDED_FONT_LIMIT");
      }
      synchronized (this.f)
      {
        AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.e.get(paramString);
        if (localAEEditorDownloadResBean != null) {
          this.f.put(paramString, localAEEditorDownloadResBean);
        }
        paramString = new Pair(localObject, "SUCCESS_GET_VALID_FONT");
        return paramString;
      }
    }
  }
  
  @Nullable
  public AEEditorDownloadResBean a(@NonNull String paramString)
  {
    f();
    return (AEEditorDownloadResBean)this.e.get(paramString);
  }
  
  @Nullable
  @WorkerThread
  public AEEditorPagStickerConfig a(@NonNull String paramString)
  {
    return (AEEditorPagStickerConfig)GsonUtils.json2Obj(b(paramString), new AEEditorResourceManager.4(this).getType());
  }
  
  @Nullable
  public AEEditorPagStickerInfo a(@NonNull String paramString)
  {
    g();
    return (AEEditorPagStickerInfo)this.jdField_d_of_type_JavaUtilMap.get(paramString);
  }
  
  public String a()
  {
    c();
    return a((AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get("AIPhotoConfig"));
  }
  
  @Nullable
  public String a(AEEditorFilterBean paramAEEditorFilterBean)
  {
    if ((paramAEEditorFilterBean == null) || (paramAEEditorFilterBean.getEffectExtendBean() == null)) {
      return null;
    }
    c();
    paramAEEditorFilterBean = paramAEEditorFilterBean.getEffectExtendBean().getLutID();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get(paramAEEditorFilterBean);
    if (localAEEditorDownloadResBean == null) {
      return null;
    }
    return a(localAEEditorDownloadResBean) + File.separator + paramAEEditorFilterBean + ".png";
  }
  
  @Nullable
  public String a(String paramString, int paramInt)
  {
    return (String)a(paramString, paramInt).first;
  }
  
  @NonNull
  public List<AEEditorPagStickerGroup> a()
  {
    g();
    return new LinkedList(this.jdField_a_of_type_JavaUtilList);
  }
  
  @NonNull
  public Map<String, AEEditorDownloadResBean> a()
  {
    f();
    return new HashMap(this.e);
  }
  
  public void a()
  {
    e();
    g();
    f();
  }
  
  public void a(@NonNull List<AEEditorDownloadResBean> paramList)
  {
    if (a().getValue() != null)
    {
      Iterator localIterator = ((List)a().getValue()).iterator();
      while (localIterator.hasNext())
      {
        AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)localIterator.next();
        if (localAEEditorFilterBean.getEditorEffectItem().getPreDownload() == 1) {
          paramList.add(AEEditorEffectUtils.a(localAEEditorFilterBean));
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    String str2 = "";
    String str1;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      str1 = "AEEditorFilter";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {
        AEBaseDataReporter.a().a(paramBoolean, 3, str1, paramString, paramInt, paramLong);
      }
      return;
      if (this.e.containsKey(paramString))
      {
        str1 = "AEEditorFont";
      }
      else if (this.jdField_d_of_type_JavaUtilMap.containsKey(paramString))
      {
        str1 = "AEEditorSticker";
      }
      else
      {
        str1 = str2;
        if (paramString != null)
        {
          str1 = str2;
          if (paramString.contains("effect_")) {
            str1 = "AEEditorEffect";
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return new File(a()).exists();
  }
  
  public boolean a(@NonNull String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return false;
    }
    return a(AEEditorPagStickerInfo.convert2DownloadBean(paramString));
  }
  
  public String b()
  {
    c();
    return a((AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get("AIVideoConfig"));
  }
  
  public String b(AEEditorFilterBean paramAEEditorFilterBean)
  {
    return a(AEEditorEffectUtils.a(paramAEEditorFilterBean)) + File.separator + "effectInfo.json";
  }
  
  public void b(@NonNull List<AEEditorDownloadResBean> paramList)
  {
    g();
    Iterator localIterator = this.jdField_d_of_type_JavaUtilMap.values().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (AEEditorPagStickerInfo)localIterator.next();
      if ((localObject != null) && (((AEEditorPagStickerInfo)localObject).preDownload == 1))
      {
        localObject = AEEditorPagStickerInfo.convert2DownloadBean((AEEditorPagStickerInfo)localObject);
        if (!a((AEEditorDownloadResBean)localObject)) {
          paramList.add(localObject);
        }
      }
    }
    f();
    localIterator = this.e.values().iterator();
    while (localIterator.hasNext())
    {
      localObject = (AEEditorDownloadResBean)localIterator.next();
      if ((localObject != null) && (((AEEditorDownloadResBean)localObject).getPreDownload() == 1) && (!a((AEEditorDownloadResBean)localObject))) {
        paramList.add(localObject);
      }
    }
  }
  
  public boolean b()
  {
    return new File(b()).exists();
  }
  
  public boolean b(@NonNull String paramString)
  {
    for (;;)
    {
      synchronized (this.f)
      {
        if ((AEEditorDownloadResBean)this.f.get(paramString) != null) {
          return false;
        }
        if (this.f.size() >= this.b)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public String c(AEEditorFilterBean paramAEEditorFilterBean)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramAEEditorFilterBean.getEffectExtendBean().getMotionID())) {
      str = a(AEEditorEffectUtils.a(paramAEEditorFilterBean)) + File.separator + paramAEEditorFilterBean.getEffectExtendBean().getMotionID();
    }
    return str;
  }
  
  @Nullable
  public String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    c();
    AEEditorDownloadResBean localAEEditorDownloadResBean = (AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localAEEditorDownloadResBean == null) {
      return null;
    }
    return a(localAEEditorDownloadResBean) + File.separator + paramString + ".png";
  }
  
  public boolean c()
  {
    g();
    Iterator localIterator = this.jdField_d_of_type_JavaUtilMap.entrySet().iterator();
    boolean bool2;
    for (boolean bool1 = true; localIterator.hasNext(); bool1 = bool2)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((AEEditorPagStickerInfo)localEntry.getValue()).backgroundColorAdjustable == 1)
      {
        if ((bool1) && (a((String)localEntry.getKey()))) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = bool1;
          if (bool1) {
            break;
          }
          return bool1;
        }
      }
      bool2 = bool1;
    }
    return bool1;
  }
  
  @Nullable
  public String d(@NonNull String paramString)
  {
    return a(paramString, "params.json");
  }
  
  @Nullable
  public String e(@NonNull String paramString)
  {
    return a(paramString, "main.pag");
  }
  
  @Nullable
  public String f(@NonNull String paramString)
  {
    return a(paramString, "blur_text.png");
  }
  
  @Nullable
  public String g(@NonNull String paramString)
  {
    return a(paramString, "blur_texture.png");
  }
  
  @Nullable
  public String h(@NonNull String paramString)
  {
    return a(paramString, "cover.pag");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager
 * JD-Core Version:    0.7.0.1
 */