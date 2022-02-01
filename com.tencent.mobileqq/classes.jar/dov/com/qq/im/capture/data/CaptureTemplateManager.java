package dov.com.qq.im.capture.data;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.utils.UITools;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.PathUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CaptureTemplateManager
  extends IQIMManager
{
  public static final File a;
  public static final String a;
  public static boolean a;
  public static final String b;
  public static boolean b;
  public static final String c;
  private CaptureTemplateManager.CaptureTemplateDataListener jdField_a_of_type_DovComQqImCaptureDataCaptureTemplateManager$CaptureTemplateDataListener;
  public TemplateSet a;
  CopyOnWriteArrayList<TemplateData> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  public TemplateSet[] a;
  public QIMTemplateItem[] a;
  private boolean c;
  String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = PathUtils.d + "capture_template" + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "resource" + File.separator;
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "capture_res" + File.separator;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_JavaIoFile = new File(new File(PathUtils.d), "capture_template");
  }
  
  public CaptureTemplateManager()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem = new QIMTemplateItem[5];
    this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataTemplateSet = new TemplateSet[5];
  }
  
  private static String a(Context paramContext)
  {
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + "template_config.xml");
      UITools.a("CaptureTemplateManager", "getQQShortVideoFilterConfig:" + jdField_a_of_type_JavaLangString + "template_config.xml" + "|" + localFile.exists());
      if (localFile.exists()) {
        return FileUtils.b(localFile);
      }
      SharedPreUtils.ah(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
      return null;
    }
    catch (IOException paramContext)
    {
      SLog.e("CaptureTemplateManager", paramContext.toString());
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    boolean bool = true;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureTemplateManager", 2, "updateTemplateConfig error: " + paramString);
      }
      return;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("showQAEntrance") != 1) {
          continue;
        }
        StoryConfigManager.f(bool);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      FileUtils.a(jdField_a_of_type_JavaLangString, "template_config.xml", paramString);
      return;
      bool = false;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ThreadManager.excute(new CaptureTemplateManager.2(this, paramString2, paramString4, paramString1), 128, null, true);
  }
  
  public static boolean a()
  {
    boolean bool = new File(jdField_a_of_type_JavaLangString + "template_config.xml").exists();
    if (QLog.isColorLevel()) {
      QLog.d("CaptureTemplateManager", 1, "getQQShortVideoFilterConfig:" + jdField_a_of_type_JavaLangString + "template_config.xml" + "|" + bool);
    }
    return bool;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    do
    {
      for (;;)
      {
        return false;
        try
        {
          paramString1 = FileUtils.c(paramString1.getPath());
          if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase(paramString2))) {
            return true;
          }
        }
        catch (UnsatisfiedLinkError paramString1) {}
      }
    } while (!QLog.isColorLevel());
    paramString1.printStackTrace();
    return false;
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureTemplateManager", 2, "deleteTemplateConfig");
    }
    File localFile = new File(jdField_a_of_type_JavaLangString + "template_config.xml");
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  private void d()
  {
    label17:
    Iterator localIterator;
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0)) {
      return;
    } else {
      localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label17;
      }
      Object localObject = (TemplateData)localIterator.next();
      if ((((TemplateData)localObject).jdField_a_of_type_JavaUtilList == null) || (((TemplateData)localObject).jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      String str = ((TemplateData)localObject).jdField_b_of_type_JavaLangString;
      localObject = ((TemplateData)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)((Iterator)localObject).next();
        if ((localQIMTemplateItem.jdField_a_of_type_JavaLangString.equals(str)) && (!a(localQIMTemplateItem.j, localQIMTemplateItem.i)) && (!TextUtils.isEmpty(localQIMTemplateItem.h))) {
          a(localQIMTemplateItem.h, localQIMTemplateItem.j, localQIMTemplateItem.jdField_a_of_type_JavaLangString, localQIMTemplateItem.i);
        }
      }
    }
  }
  
  public final TemplateSet a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureDataTemplateSet;
  }
  
  public QIMTemplateItem a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[paramInt];
  }
  
  public CopyOnWriteArrayList<TemplateData> a(String paramString)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramString = new JSONObject(paramString).getJSONArray("categorys");
    ArrayList localArrayList = new ArrayList(paramString.length());
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(new TemplateData(paramString.getJSONObject(i)));
      i += 1;
    }
    localCopyOnWriteArrayList.clear();
    localCopyOnWriteArrayList.addAll(localArrayList);
    ((CaptureComboManager)QIMManager.a(5)).a();
    a(localArrayList);
    return localCopyOnWriteArrayList;
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    b();
  }
  
  public void a(TemplateSet paramTemplateSet)
  {
    this.jdField_a_of_type_DovComQqImCaptureDataTemplateSet = paramTemplateSet;
  }
  
  public void a(TemplateSet paramTemplateSet, Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[2] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataTemplateSet[2] = paramTemplateSet;
      if (this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataTemplateSet[1] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataTemplateSet[1] = paramTemplateSet;
    }
    while (paramInt == -1)
    {
      return;
      if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt != 4)) {}
    }
    this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataTemplateSet[paramInt] = paramTemplateSet;
  }
  
  public void a(QIMTemplateItem paramQIMTemplateItem, Activity paramActivity, int paramInt)
  {
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[2] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[2] = paramQIMTemplateItem;
      if (this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[1] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[1] = paramQIMTemplateItem;
    }
    while (paramInt == -1)
    {
      return;
      if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt != 4)) {}
    }
    QIMTemplateItem localQIMTemplateItem = this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[paramInt];
    paramActivity = paramQIMTemplateItem;
    if (localQIMTemplateItem != null)
    {
      localCaptureComboManager.a(localQIMTemplateItem);
      if (paramQIMTemplateItem != null) {
        break label176;
      }
      paramActivity = paramQIMTemplateItem;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "setSelectedTemplate last:" + localQIMTemplateItem + " new:" + paramActivity + ", " + paramInt);
      }
      this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[paramInt] = paramActivity;
      if ((paramActivity == null) || (paramActivity.a())) {
        break;
      }
      return;
      label176:
      paramActivity = paramQIMTemplateItem;
      if (TextUtils.equals(localQIMTemplateItem.jdField_a_of_type_JavaLangString, paramQIMTemplateItem.jdField_a_of_type_JavaLangString)) {
        paramActivity = localQIMTemplateItem;
      }
    }
  }
  
  public boolean a(Context paramContext)
  {
    bool2 = false;
    paramContext = a(paramContext);
    bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramContext))
      {
        this.d = paramContext;
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = a(paramContext);
        boolean bool3 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty();
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        SLog.c("CaptureTemplateManager", "initFromCache", paramContext);
        bool1 = bool2;
      }
    }
    SLog.b("CaptureTemplateManager", "initFromCache " + bool1);
    return bool1;
  }
  
  public boolean a(TemplateSet paramTemplateSet, int paramInt)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramTemplateSet != null)
    {
      TemplateSet localTemplateSet = this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataTemplateSet[paramInt];
      boolean bool1 = bool3;
      if (localTemplateSet != null)
      {
        bool1 = bool3;
        if (paramTemplateSet.b().equals(localTemplateSet.b())) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("QCombo", 2, "isApplying :" + paramTemplateSet);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public boolean a(List<TemplateData> paramList)
  {
    SLog.b("CaptureTemplateManager", "preInitCombo: " + paramList.size());
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      TemplateData localTemplateData = (TemplateData)paramList.next();
      if (localTemplateData.jdField_a_of_type_JavaUtilList == null) {
        break label244;
      }
      Iterator localIterator = localTemplateData.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)localIterator.next();
        TemplateSet localTemplateSet;
        if (localTemplateData.jdField_a_of_type_Boolean)
        {
          localTemplateSet = localCaptureComboManager.a(localQIMTemplateItem);
          localTemplateSet.a = localTemplateSet.a();
          if (localTemplateSet.a == 1)
          {
            localTemplateSet.b = ((int)(10000.0F * localTemplateSet.a()));
            SLog.b("CaptureTemplateManager", "preInitCombo progress: " + localQIMTemplateItem.jdField_b_of_type_JavaLangString + ", progress: " + localTemplateSet.b);
            bool = true;
          }
        }
        for (;;)
        {
          break;
          if (localTemplateSet.a != 2) {
            if (localTemplateSet.a == 3) {
              localTemplateSet.b = 10000;
            }
          }
        }
      }
    }
    label244:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0)) {
      a(BaseApplicationImpl.sApplication);
    }
    d();
    if (this.jdField_a_of_type_DovComQqImCaptureDataCaptureTemplateManager$CaptureTemplateDataListener != null) {
      this.jdField_a_of_type_DovComQqImCaptureDataCaptureTemplateManager$CaptureTemplateDataListener.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    }
  }
  
  public void onDestroy() {}
  
  public void onInit()
  {
    ThreadManager.post(new CaptureTemplateManager.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureTemplateManager
 * JD-Core Version:    0.7.0.1
 */