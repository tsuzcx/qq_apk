package dov.com.qq.im.aeeditor.manage;

import android.content.res.AssetManager;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.AEPath.Editor.FILES;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

public class AEditorMaterialManager
{
  private static volatile AEditorMaterialManager jdField_a_of_type_DovComQqImAeeditorManageAEditorMaterialManager;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public ArrayList<MetaMaterial> a;
  private WeakReference<AEditorMaterialManager.RecommendListener> jdField_a_of_type_MqqUtilWeakReference;
  public ArrayList<String> b;
  
  public static AEditorMaterialManager a()
  {
    if (jdField_a_of_type_DovComQqImAeeditorManageAEditorMaterialManager == null) {}
    try
    {
      if (jdField_a_of_type_DovComQqImAeeditorManageAEditorMaterialManager == null) {
        jdField_a_of_type_DovComQqImAeeditorManageAEditorMaterialManager = new AEditorMaterialManager();
      }
      return jdField_a_of_type_DovComQqImAeeditorManageAEditorMaterialManager;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = "";
    for (;;)
    {
      try
      {
        localInputStream = BaseApplicationImpl.getContext().getAssets().open(paramString);
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        String str2 = Util.a(localInputStream);
        paramString = str2;
        localObject2 = paramString;
      }
      catch (Throwable localThrowable)
      {
        InputStream localInputStream;
        localObject2 = localIOException1;
        AEQLog.a("AEditorMaterialManager", "readAssetsFileContent---read assets json exception: fileName=" + paramString, localThrowable);
        localObject2 = localIOException1;
        localThrowable.printStackTrace();
        localObject2 = str1;
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
          return "";
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
          return "";
        }
      }
      finally
      {
        if (localObject2 == null) {
          break label118;
        }
      }
      try
      {
        localInputStream.close();
        localObject2 = paramString;
        return localObject2;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return paramString;
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      label118:
      throw paramString;
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        localIOException2.printStackTrace();
      }
    }
  }
  
  private static List<AEEditorPagStickerGroup> a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = QIMPtvTemplateManager.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {
      return localArrayList;
    }
    paramFile = (ArrayList)new Gson().fromJson(paramFile, new AEditorMaterialManager.1().getType());
    if ((paramFile == null) || (paramFile.isEmpty())) {
      return localArrayList;
    }
    for (;;)
    {
      AEEditorPagStickerGroup localAEEditorPagStickerGroup;
      try
      {
        paramFile = paramFile.iterator();
        if (paramFile.hasNext())
        {
          Object localObject1 = (MetaCategory)paramFile.next();
          localAEEditorPagStickerGroup = new AEEditorPagStickerGroup();
          localAEEditorPagStickerGroup.stickerGroupId = ((MetaCategory)localObject1).id;
          localAEEditorPagStickerGroup.stickerGroupName = ((MetaCategory)localObject1).name;
          localObject1 = ((MetaCategory)localObject1).materials.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (MetaMaterial)((Iterator)localObject1).next();
            AEEditorPagStickerInfo localAEEditorPagStickerInfo = new AEEditorPagStickerInfo();
            localAEEditorPagStickerInfo.stickerId = ((MetaMaterial)localObject2).id;
            localAEEditorPagStickerInfo.thumbUrl = ((MetaMaterial)localObject2).thumbUrl;
            localAEEditorPagStickerInfo.resourceMd5 = ((MetaMaterial)localObject2).packageMd5;
            localAEEditorPagStickerInfo.resourceUrl = ((MetaMaterial)localObject2).packageUrl;
            String str = (String)((MetaMaterial)localObject2).additionalFields.get("backgroundColorAdjustable");
            if (!TextUtils.isEmpty(str)) {
              localAEEditorPagStickerInfo.backgroundColorAdjustable = Integer.parseInt(str);
            }
            localAEEditorPagStickerInfo.fontId = ((String)((MetaMaterial)localObject2).additionalFields.get("fontId"));
            str = (String)((MetaMaterial)localObject2).additionalFields.get("preDownload");
            if (!TextUtils.isEmpty(str)) {
              localAEEditorPagStickerInfo.preDownload = Integer.parseInt(str);
            }
            str = (String)((MetaMaterial)localObject2).additionalFields.get("interactive");
            if (!TextUtils.isEmpty(str)) {
              localAEEditorPagStickerInfo.interactive = str;
            }
            str = (String)((MetaMaterial)localObject2).additionalFields.get("topic");
            if (!TextUtils.isEmpty(str)) {
              localAEEditorPagStickerInfo.hashTag = str;
            }
            localObject2 = (String)((MetaMaterial)localObject2).additionalFields.get("badgeURL");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              localAEEditorPagStickerInfo.badgeURL = ((String)localObject2);
            }
            localAEEditorPagStickerGroup.stickerInfoList.add(localAEEditorPagStickerInfo);
            continue;
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Exception paramFile)
      {
        AEQLog.d("AEditorMaterialManager", "loadStickerListFromFile error  " + paramFile.toString());
      }
      localArrayList.add(localAEEditorPagStickerGroup);
    }
  }
  
  private static List<MetaCategory> b(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = QIMPtvTemplateManager.a(paramFile);
    if (TextUtils.isEmpty(paramFile)) {
      return localArrayList;
    }
    paramFile = (ArrayList)new Gson().fromJson(paramFile, new AEditorMaterialManager.2().getType());
    if ((paramFile == null) || (paramFile.isEmpty())) {
      return localArrayList;
    }
    localArrayList.clear();
    localArrayList.addAll(paramFile);
    return localArrayList;
  }
  
  private static List<MetaCategory> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = a("camera/ae_camera_editor_auto_template.json");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return localArrayList;
    }
    localObject = (ArrayList)new Gson().fromJson((String)localObject, new AEditorMaterialManager.3().getType());
    if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
      return localArrayList;
    }
    localArrayList.clear();
    localArrayList.addAll((Collection)localObject);
    return localArrayList;
  }
  
  public String a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = new File(AEPath.Editor.FILES.b);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localObject2 = new File(((File)localObject2).getPath(), "editor_text_sticker_update_template.json").getPath();
      return localObject2;
    }
  }
  
  public List<AEEditorPagStickerGroup> a()
  {
    for (;;)
    {
      File localFile2;
      File localFile1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Object localObject1 = new ArrayList();
        localFile2 = new File(AEPath.Editor.FILES.b, "editor_text_sticker_update_template.json");
        localFile1 = new File(AEPath.Editor.FILES.b, "editor_text_stickers_default.json");
        if (!localFile2.exists())
        {
          if (!localFile1.exists())
          {
            AEQLog.a("AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exist, newJson not exist ");
            return localObject1;
          }
          try
          {
            List localList1 = a(localFile1);
            localObject1 = localList1;
            AEQLog.a("AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson exists, newJson not exist, use oldJson");
            localObject1 = localList1;
          }
          catch (Exception localException1)
          {
            FileUtils.e(localFile1.getPath());
            AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor", 4);
            AEQLog.d("AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson exists, newJson not exist, exception:" + localException1.toString());
          }
        }
      }
      try
      {
        List localList2 = a(localFile2);
        Object localObject3 = localList2;
        FileUtils.b(localFile2.getPath(), localFile1.getPath());
        localObject3 = localList2;
        AEQLog.a("AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exist, use newJson ");
        localObject3 = localList2;
      }
      catch (Exception localException2)
      {
        FileUtils.e(localFile2.getPath());
        AEQLog.d("AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exists: exception:" + localException2.toString());
        AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor", 4);
      }
    }
  }
  
  public void a()
  {
    ((AEditorMaterialManager.RecommendListener)this.jdField_a_of_type_MqqUtilWeakReference.get()).b();
  }
  
  public void a(ArrayList<MetaMaterial> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.b = paramArrayList1;
    ((AEditorMaterialManager.RecommendListener)this.jdField_a_of_type_MqqUtilWeakReference.get()).a();
  }
  
  public void a(WeakReference<AEditorMaterialManager.RecommendListener> paramWeakReference)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeakReference;
  }
  
  public boolean a()
  {
    return new File(AEPath.Editor.FILES.b, "editor_text_sticker_update_template.json").exists();
  }
  
  public String b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Object localObject2 = new File(AEPath.Editor.FILES.c);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localObject2 = new File(((File)localObject2).getPath(), "editor_auto_template_update_template.json").getPath();
      return localObject2;
    }
  }
  
  public List<MetaCategory> b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      new ArrayList();
      File localFile = new File(AEPath.Editor.FILES.c, "editor_auto_template_update_template.json");
      Object localObject3 = new File(AEPath.Editor.FILES.c, "editor_auto_template_default.json");
      List localList1;
      if (!localFile.exists()) {
        if (!((File)localObject3).exists())
        {
          AEQLog.a("AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exist, newJson not exist ");
          localList1 = c();
        }
      }
      List localList3;
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break;
        }
        int i = 0;
        while (i < 5)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(new MetaMaterial());
          i += 1;
        }
        List localList2;
        try
        {
          localList1 = b((File)localObject3);
          AEQLog.a("AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson exists, newJson not exist, use oldJson");
        }
        catch (Exception localException1)
        {
          FileUtils.e(((File)localObject3).getPath());
          AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor", 4);
          AEQLog.d("AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson exists, newJson not exist, exception:" + localException1.toString());
          localList2 = c();
        }
        continue;
        try
        {
          localList2 = b(localFile);
          FileUtils.b(localFile.getPath(), ((File)localObject3).getPath());
          AEQLog.a("AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exist, use newJson ");
        }
        catch (Exception localException2)
        {
          FileUtils.e(localFile.getPath());
          AEQLog.d("AEditorMaterialManager", "readAndParseTextStickerConfigFile -> oldJson not exists: exception:" + localException2.toString());
          AECameraPrefsUtil.a().a("ShadowBackendSvc.GetCircleCatMatTreeMqCircleEditor", 4);
          localList3 = c();
        }
      }
      localObject3 = new MetaCategory();
      ((MetaCategory)localObject3).name = "推荐";
      ((MetaCategory)localObject3).id = "recommend";
      localList3.add(0, localObject3);
      return localList3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEditorMaterialManager
 * JD-Core Version:    0.7.0.1
 */