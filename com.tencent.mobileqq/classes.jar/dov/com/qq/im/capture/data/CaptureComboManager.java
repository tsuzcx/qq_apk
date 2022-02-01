package dov.com.qq.im.capture.data;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.biz.qqstory.config.TextFilterConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.QIMCaptureVarManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.control.QIMAsyncManager;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import dov.com.qq.im.capture.paster.CaptureComboPasterFactory;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class CaptureComboManager
  extends QIMAsyncManager
  implements Handler.Callback, IEventReceiver
{
  public static int a;
  public Handler a;
  public TextFilterConfig a;
  private ComboLockManager jdField_a_of_type_DovComQqImCaptureDataComboLockManager;
  public ComboSet a;
  public FilterSet a;
  public VideoFilterTools.ComboFilterData a;
  public ArrayList<QIMTemplateItem> a;
  public HashMap<String, ComboSet> a;
  private boolean jdField_a_of_type_Boolean;
  public CaptureComboManager.CaptureRecord[] a;
  int b;
  public Handler b;
  public ArrayList<QIMTemplateItem> b;
  public HashMap<String, FilterSet> b;
  public Handler c;
  public ArrayList<QIMFilterCategoryItem> c;
  public HashMap<String, CaptureComboFilter> c;
  public ArrayList<QIMFilterCategoryItem> d;
  public HashMap<String, TemplateSet> d;
  ArrayList<CaptureComboManager.CaptureComboListener> e;
  public HashMap<String, ArrayList<CaptureComboManager.ComboApplyTask>> e;
  
  static
  {
    jdField_a_of_type_Int = 4;
  }
  
  public CaptureComboManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new CaptureComboManager.2(this));
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_e_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData = null;
    this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord = new CaptureComboManager.CaptureRecord[5];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord.length)
    {
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[i] = new CaptureComboManager.CaptureRecord(i);
      i += 1;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), new CaptureComboManager.1(this));
    this.jdField_a_of_type_DovComQqImCaptureDataComboLockManager = new ComboLockManager();
  }
  
  private void a(Activity paramActivity, int paramInt)
  {
    ComboSet localComboSet = VideoFilterTools.a().a[paramInt];
    if (localComboSet != null) {
      localComboSet.a(paramActivity, paramInt);
    }
    VideoFilterTools.a().a(null, paramActivity, paramInt);
  }
  
  private static boolean a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if ((paramQIMFilterCategoryItem != null) && (paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramQIMFilterCategoryItem.hasNext()) {
        if ("EMPTY".equals((String)paramQIMFilterCategoryItem.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(Activity paramActivity, int paramInt)
  {
    CaptureTemplateManager localCaptureTemplateManager = (CaptureTemplateManager)QIMManager.a(15);
    TemplateSet localTemplateSet = localCaptureTemplateManager.a();
    if (localTemplateSet != null)
    {
      localTemplateSet.a(paramActivity, paramInt);
      if (paramInt == 0) {
        localCaptureTemplateManager.a(null);
      }
    }
  }
  
  public CaptureComboFilter a(FilterDesc paramFilterDesc)
  {
    CaptureComboFilter localCaptureComboFilter2 = (CaptureComboFilter)this.jdField_c_of_type_JavaUtilHashMap.get(paramFilterDesc.name);
    CaptureComboFilter localCaptureComboFilter1 = localCaptureComboFilter2;
    if (localCaptureComboFilter2 == null)
    {
      localCaptureComboFilter1 = new CaptureComboFilter(paramFilterDesc);
      this.jdField_c_of_type_JavaUtilHashMap.put(paramFilterDesc.name, localCaptureComboFilter1);
    }
    return localCaptureComboFilter1;
  }
  
  public CaptureComboManager.CaptureRecord a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[paramInt];
  }
  
  public ComboLockManager a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureDataComboLockManager;
  }
  
  public ComboSet a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    ComboSet localComboSet2 = (ComboSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    Object localObject1 = localComboSet2;
    Object localObject2;
    Object localObject3;
    int j;
    int i;
    int n;
    int k;
    int m;
    if (localComboSet2 == null)
    {
      localComboSet2 = new ComboSet(paramQIMFilterCategoryItem);
      localObject1 = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = VideoFilterTools.a().a((String)localObject2);
        if (localObject3 != null) {
          localComboSet2.c(a((FilterDesc)localObject3));
        } else if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo filter Null " + (String)localObject2);
        }
      }
      j = 0;
      i = 0;
      if (paramQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        n = paramQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray.length();
        k = 0;
        j = i;
        if (k < n)
        {
          localObject3 = paramQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(k);
          if (localObject3 == null) {
            break label1283;
          }
          for (;;)
          {
            try
            {
              localObject4 = ((JSONObject)localObject3).optString("packet_id");
              localObject1 = ((JSONObject)localObject3).optString("item_id");
              f1 = Float.valueOf(((JSONObject)localObject3).optString("position_x")).floatValue();
              f2 = Float.valueOf(((JSONObject)localObject3).optString("position_y")).floatValue();
              f3 = Float.valueOf(((JSONObject)localObject3).optString("scale")).floatValue();
              localObject2 = new SegmentKeeper();
              ((SegmentKeeper)localObject2).fromJSONObject((JSONObject)localObject3);
              localObject3 = CaptureComboPasterFactory.a(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, (String)localObject4, (String)localObject1, f1, f2, f3);
              if (localObject3 != null)
              {
                ((CaptureComboBase)localObject3).a((SegmentKeeper)localObject2);
                localComboSet2.c((CaptureComboBase)localObject3);
                k += 1;
                break;
              }
              m = 1;
              j = 1;
              i = j;
              try
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("QCombo", 2, "createCombo pasters Null item_id= " + (String)localObject1);
                i = j;
              }
              catch (Exception localException1)
              {
                i = m;
              }
            }
            catch (Exception localException5)
            {
              Object localObject4;
              float f1;
              float f2;
              float f3;
              int i1;
              String str1;
              String str2;
              continue;
            }
            localException1.printStackTrace();
          }
        }
      }
      if (paramQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray != null)
      {
        i1 = paramQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray.length();
        m = 0;
        i = j;
        label395:
        j = i;
        if (m < i1)
        {
          localObject2 = paramQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray.optJSONObject(m);
          j = i;
          if (localObject2 == null) {
            break label1286;
          }
          k = i;
          try
          {
            str1 = ((JSONObject)localObject2).optString("tagId");
            k = i;
            localObject2 = ((JSONObject)localObject2).optString("itemId");
            k = i;
            localObject3 = CaptureComboPasterFactory.a((String)localObject2);
            if (localObject3 != null)
            {
              k = i;
              localComboSet2.c((CaptureComboBase)localObject3);
              j = i;
            }
            else
            {
              n = 1;
              i = 1;
              k = i;
              j = n;
              if (QLog.isColorLevel())
              {
                k = i;
                QLog.d("QCombo", 2, "createCombo musicNull " + str1 + ":" + (String)localObject2);
                j = n;
              }
            }
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            j = k;
          }
        }
      }
      i = j;
      if (paramQIMFilterCategoryItem.c != null)
      {
        i1 = paramQIMFilterCategoryItem.c.length();
        m = 0;
        label594:
        i = j;
        if (m < i1)
        {
          localObject2 = paramQIMFilterCategoryItem.c.optJSONObject(m);
          i = j;
          if (localObject2 == null) {
            break label1299;
          }
          k = j;
          try
          {
            str2 = ((JSONObject)localObject2).optString("tagId");
            k = j;
            localObject2 = ((JSONObject)localObject2).optString("itemId");
            k = j;
            i = j;
            if (StringUtil.a(str2)) {
              break label1299;
            }
            k = j;
            localObject3 = CaptureComboPasterFactory.b((String)localObject2);
            if (localObject3 != null)
            {
              k = j;
              localComboSet2.c((CaptureComboBase)localObject3);
              i = j;
            }
            else
            {
              n = 1;
              j = 1;
              k = j;
              i = n;
              if (QLog.isColorLevel())
              {
                k = j;
                QLog.d("QCombo", 2, "createCombo ptvNull " + str2 + ":" + (String)localObject2);
                i = n;
              }
            }
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            i = k;
          }
        }
      }
      j = i;
      if (paramQIMFilterCategoryItem.d != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo texts " + paramQIMFilterCategoryItem.d + " size: " + paramQIMFilterCategoryItem.d.length());
        }
        i1 = paramQIMFilterCategoryItem.d.length();
        m = 0;
      }
    }
    for (;;)
    {
      j = i;
      if (m < i1)
      {
        localObject2 = paramQIMFilterCategoryItem.d.optJSONObject(m);
        k = i;
        if (localObject2 != null) {
          j = i;
        }
      }
      else
      {
        for (;;)
        {
          try
          {
            String str3 = ((JSONObject)localObject2).optString("text_id");
            j = i;
            localObject4 = ((JSONObject)localObject2).optJSONArray("texts");
            k = i;
            if (localObject4 == null) {
              break label1321;
            }
            j = i;
            localObject3 = new ArrayList();
            k = 0;
            j = i;
            if (k < ((JSONArray)localObject4).length())
            {
              j = i;
              String str4 = ((JSONArray)localObject4).getString(k);
              j = i;
              if (TextUtils.isEmpty(str4)) {
                break label1312;
              }
              j = i;
              ((List)localObject3).add(str4);
              break label1312;
            }
            j = i;
            f1 = Float.valueOf(((JSONObject)localObject2).optString("position_x")).floatValue();
            j = i;
            f2 = Float.valueOf(((JSONObject)localObject2).optString("position_y")).floatValue();
            j = i;
            f3 = Float.valueOf(((JSONObject)localObject2).optString("scale")).floatValue();
            j = i;
            if (QLog.isColorLevel())
            {
              j = i;
              QLog.d("QCombo", 2, "create  TextCombo ID: " + str3);
            }
            j = i;
            localObject4 = new SegmentKeeper();
            j = i;
            ((SegmentKeeper)localObject4).fromJSONObject((JSONObject)localObject2);
            j = i;
            localObject2 = CaptureComboPasterFactory.a(str3, (List)localObject3, f1, f2, f3);
            if (localObject2 != null)
            {
              j = i;
              ((CaptureComboBase)localObject2).a((SegmentKeeper)localObject4);
              j = i;
              localComboSet2.c((CaptureComboBase)localObject2);
              k = i;
            }
            else
            {
              n = 1;
              i = 1;
              j = i;
              k = n;
              if (QLog.isColorLevel())
              {
                j = i;
                QLog.d("QCombo", 2, "createCombo texts Null id=" + str3);
                k = n;
              }
            }
          }
          catch (Exception localException4)
          {
            localException4.printStackTrace();
            k = j;
          }
          if (j == 0) {
            this.jdField_a_of_type_JavaUtilHashMap.put(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, localComboSet2);
          }
          ComboSet localComboSet1 = localComboSet2;
          localComboSet1.jdField_a_of_type_JavaLangObject = paramQIMFilterCategoryItem;
          return localComboSet1;
          label1283:
          break;
          label1286:
          m += 1;
          i = j;
          break label395;
          label1299:
          m += 1;
          j = i;
          break label594;
          label1312:
          k += 1;
        }
      }
      label1321:
      m += 1;
      i = k;
    }
  }
  
  public ComboSet a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    ComboSet localComboSet = localCaptureComboManager.a(paramQIMFilterCategoryItem);
    localComboSet.b(paramActivity, paramBundle.getInt("capture_scene", -1));
    localComboSet.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localCaptureComboManager.a(paramQIMFilterCategoryItem);
    switch (localComboSet.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "applyCombo state = " + localComboSet.jdField_a_of_type_Int);
      }
      return localComboSet;
      a(new CaptureComboManager.ComboApplyTask(localComboSet, paramBundle, paramActivity));
      paramQIMFilterCategoryItem = Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, localComboSet);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        a(paramQIMFilterCategoryItem);
      }
      else
      {
        paramQIMFilterCategoryItem.sendToTarget();
        continue;
        a(new CaptureComboManager.ComboApplyTask(localComboSet, paramBundle, paramActivity));
        continue;
        a(new CaptureComboManager.ComboApplyTask(localComboSet, paramBundle, paramActivity));
        localComboSet.b();
      }
    }
  }
  
  public ComboSet a(String paramString)
  {
    Object localObject1 = null;
    ComboSet localComboSet = null;
    Object localObject2 = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
    if (localObject2 != null)
    {
      localObject2 = ((VideoFilterTools.ComboFilterData)localObject2).a.jdField_a_of_type_JavaUtilArrayList.iterator();
      localObject1 = localComboSet;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((FilterCategory)((Iterator)localObject2).next()).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject1).next();
          if (TextUtils.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, paramString)) {
            localComboSet = a(localQIMFilterCategoryItem);
          }
        }
      }
    }
    for (;;)
    {
      break;
      return localObject1;
    }
  }
  
  public FilterSet a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = VideoFilterTools.a().a((String)localObject2);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
    }
    Object localObject2 = (FilterSet)this.jdField_b_of_type_JavaUtilHashMap.get(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new FilterSet(paramQIMFilterCategoryItem);
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((FilterSet)localObject1).c(a((FilterDesc)((Iterator)localObject2).next()));
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, localObject1);
    }
    return localObject1;
  }
  
  public FilterSet a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
    if (localObject != null)
    {
      localObject = ((VideoFilterTools.ComboFilterData)localObject).a.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)((Iterator)localObject).next();
        if (TextUtils.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, paramString)) {
          return a(localQIMFilterCategoryItem);
        }
      }
    }
    return null;
  }
  
  public QIMFilterCategoryItem a(ComboSet paramComboSet, ArrayList<QIMFilterCategoryItem> paramArrayList)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramComboSet != null)
    {
      localObject1 = localObject3;
      if ((paramComboSet.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem))
      {
        localObject3 = (QIMFilterCategoryItem)paramComboSet.jdField_a_of_type_JavaLangObject;
        if (!((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break label176;
        }
      }
    }
    label278:
    label280:
    label283:
    for (localObject1 = null;; localObject1 = paramComboSet)
    {
      if (localObject1 == null)
      {
        localObject3 = ((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
        paramComboSet = (ComboSet)localObject2;
        do
        {
          localObject2 = paramComboSet;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          localObject2 = VideoFilterTools.a().a((String)localObject2);
        } while (localObject2 == null);
        if (QQAVImageFilterConstants.getFilterType(((FilterDesc)localObject2).id) == 2)
        {
          if (localObject2 == null) {
            break label278;
          }
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            paramComboSet = (QIMFilterCategoryItem)paramArrayList.next();
            if ((paramComboSet.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (paramComboSet.jdField_a_of_type_JavaUtilArrayList.contains(((FilterDesc)localObject2).name)))
            {
              localObject1 = paramComboSet;
              return localObject1;
              label176:
              Iterator localIterator1 = paramArrayList.iterator();
              paramComboSet = null;
              label184:
              if (!localIterator1.hasNext()) {
                break label283;
              }
              localObject1 = (QIMFilterCategoryItem)localIterator1.next();
              if (((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.size() != ((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.size()) {
                break label280;
              }
              Iterator localIterator2 = ((QIMFilterCategoryItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (localIterator2.hasNext())
              {
                String str = (String)localIterator2.next();
                if (((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.contains(str)) {
                  paramComboSet = (ComboSet)localObject1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        break label184;
        paramComboSet = (ComboSet)localObject2;
        break;
        return localObject1;
      }
    }
  }
  
  public QIMFilterCategoryItem a(TemplateSet paramTemplateSet, ArrayList<QIMFilterCategoryItem> paramArrayList)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramTemplateSet != null)
    {
      localObject1 = localObject3;
      if ((paramTemplateSet.jdField_a_of_type_JavaLangObject instanceof QIMTemplateItem))
      {
        localObject3 = (QIMTemplateItem)paramTemplateSet.jdField_a_of_type_JavaLangObject;
        if (!((QIMTemplateItem)localObject3).jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          break label176;
        }
      }
    }
    label278:
    label280:
    label283:
    for (localObject1 = null;; localObject1 = paramTemplateSet)
    {
      if (localObject1 == null)
      {
        localObject3 = ((QIMTemplateItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
        paramTemplateSet = (TemplateSet)localObject2;
        do
        {
          localObject2 = paramTemplateSet;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          localObject2 = VideoFilterTools.a().a((String)localObject2);
        } while (localObject2 == null);
        if (QQAVImageFilterConstants.getFilterType(((FilterDesc)localObject2).id) == 2)
        {
          if (localObject2 == null) {
            break label278;
          }
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            paramTemplateSet = (QIMFilterCategoryItem)paramArrayList.next();
            if ((paramTemplateSet.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (paramTemplateSet.jdField_a_of_type_JavaUtilArrayList.contains(((FilterDesc)localObject2).name)))
            {
              localObject1 = paramTemplateSet;
              return localObject1;
              label176:
              Iterator localIterator1 = paramArrayList.iterator();
              paramTemplateSet = null;
              label184:
              if (!localIterator1.hasNext()) {
                break label283;
              }
              localObject1 = (QIMFilterCategoryItem)localIterator1.next();
              if (((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.size() != ((QIMTemplateItem)localObject3).jdField_a_of_type_JavaUtilArrayList.size()) {
                break label280;
              }
              Iterator localIterator2 = ((QIMTemplateItem)localObject3).jdField_a_of_type_JavaUtilArrayList.iterator();
              while (localIterator2.hasNext())
              {
                String str = (String)localIterator2.next();
                if (((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaUtilArrayList.contains(str)) {
                  paramTemplateSet = (TemplateSet)localObject1;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        break label184;
        paramTemplateSet = (TemplateSet)localObject2;
        break;
        return localObject1;
      }
    }
  }
  
  public TemplateSet a(QIMTemplateItem paramQIMTemplateItem)
  {
    Object localObject2 = (TemplateSet)this.jdField_d_of_type_JavaUtilHashMap.get(paramQIMTemplateItem.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    Object localObject3;
    Object localObject4;
    int j;
    int i;
    Object localObject5;
    float f1;
    float f2;
    float f3;
    label439:
    label588:
    int k;
    if (localObject2 == null)
    {
      localObject1 = new TemplateSet(paramQIMTemplateItem);
      if (QLog.isColorLevel()) {
        QLog.d("QTemplate", 2, "createTemplate filter " + paramQIMTemplateItem.jdField_a_of_type_JavaUtilArrayList);
      }
      localObject2 = paramQIMTemplateItem.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject4 = VideoFilterTools.a().a((String)localObject3);
        if (localObject4 != null) {
          ((TemplateSet)localObject1).d(a((FilterDesc)localObject4));
        } else if (QLog.isColorLevel()) {
          QLog.d("QTemplate", 2, "createTemplate filterNull " + (String)localObject3);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QTemplate", 2, "createTemplate pasters " + paramQIMTemplateItem.jdField_a_of_type_OrgJsonJSONArray);
      }
      if (paramQIMTemplateItem.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        j = paramQIMTemplateItem.jdField_a_of_type_OrgJsonJSONArray.length();
        i = 0;
        if (i < j)
        {
          localObject4 = paramQIMTemplateItem.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(i);
          if (localObject4 == null) {
            break label1089;
          }
          try
          {
            localObject5 = ((JSONObject)localObject4).optString("packet_id");
            localObject2 = ((JSONObject)localObject4).optString("item_id");
            f1 = Float.valueOf(((JSONObject)localObject4).optString("position_x")).floatValue();
            f2 = Float.valueOf(((JSONObject)localObject4).optString("position_y")).floatValue();
            f3 = Float.valueOf(((JSONObject)localObject4).optString("scale")).floatValue();
            localObject3 = new SegmentKeeper();
            ((SegmentKeeper)localObject3).fromJSONObject((JSONObject)localObject4);
            localObject4 = CaptureComboPasterFactory.a(paramQIMTemplateItem.jdField_a_of_type_JavaLangString, (String)localObject5, (String)localObject2, f1, f2, f3);
            if (localObject4 != null)
            {
              ((CaptureComboBase)localObject4).a((SegmentKeeper)localObject3);
              ((TemplateSet)localObject1).d((CaptureComboBase)localObject4);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("QTemplate", 2, "createTemplate pasters Null item_id= " + (String)localObject2);
            }
          }
          catch (Exception localException1)
          {
            QLog.d("CaptureComboManager", 1, "createTemplate exception", localException1);
          }
        }
      }
      if (paramQIMTemplateItem.jdField_b_of_type_OrgJsonJSONArray != null)
      {
        j = paramQIMTemplateItem.jdField_b_of_type_OrgJsonJSONArray.length();
        i = 0;
        if (i < j)
        {
          localObject3 = paramQIMTemplateItem.jdField_b_of_type_OrgJsonJSONArray.optJSONObject(i);
          if (localObject3 == null) {
            break label1098;
          }
          try
          {
            String str1 = ((JSONObject)localObject3).optString("tagId");
            localObject3 = ((JSONObject)localObject3).optString("itemId");
            localObject4 = CaptureComboPasterFactory.a((String)localObject3);
            if (localObject4 != null) {
              ((TemplateSet)localObject1).d((CaptureComboBase)localObject4);
            } else if (QLog.isColorLevel()) {
              QLog.d("QTemplate", 2, "createTemplate musicNull " + str1 + ":" + (String)localObject3);
            }
          }
          catch (Exception localException2)
          {
            QLog.d("CaptureComboManager", 1, "createTemplateSet exception", localException2);
          }
        }
      }
      if (paramQIMTemplateItem.c != null)
      {
        j = paramQIMTemplateItem.c.length();
        i = 0;
        if (i < j)
        {
          localObject3 = paramQIMTemplateItem.c.optJSONObject(i);
          if (localObject3 == null) {
            break label1107;
          }
          try
          {
            String str2 = ((JSONObject)localObject3).optString("tagId");
            localObject3 = ((JSONObject)localObject3).optString("itemId");
            if (StringUtil.a(str2)) {
              break label1107;
            }
            localObject4 = CaptureComboPasterFactory.b((String)localObject3);
            if (localObject4 != null) {
              ((TemplateSet)localObject1).d((CaptureComboBase)localObject4);
            } else if (QLog.isColorLevel()) {
              QLog.d("QTemplate", 2, "createTemplateSet ptvNull " + str2 + ":" + (String)localObject3);
            }
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
        }
      }
      if (paramQIMTemplateItem.d != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo texts " + paramQIMTemplateItem.d + " size: " + paramQIMTemplateItem.d.length());
        }
        k = paramQIMTemplateItem.d.length();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < k)
      {
        localObject3 = paramQIMTemplateItem.d.optJSONObject(i);
        if (localObject3 == null) {}
      }
      else
      {
        for (;;)
        {
          try
          {
            String str3 = ((JSONObject)localObject3).optString("text_id");
            localObject5 = ((JSONObject)localObject3).optJSONArray("texts");
            if (localObject5 == null) {
              break label1125;
            }
            localObject4 = new ArrayList();
            j = 0;
            if (j < ((JSONArray)localObject5).length())
            {
              String str4 = ((JSONArray)localObject5).getString(j);
              if (TextUtils.isEmpty(str4)) {
                break label1116;
              }
              ((List)localObject4).add(str4);
              break label1116;
            }
            f1 = Float.valueOf(((JSONObject)localObject3).optString("position_x")).floatValue();
            f2 = Float.valueOf(((JSONObject)localObject3).optString("position_y")).floatValue();
            f3 = Float.valueOf(((JSONObject)localObject3).optString("scale")).floatValue();
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "create  TextCombo ID: " + str3);
            }
            localObject5 = new SegmentKeeper();
            ((SegmentKeeper)localObject5).fromJSONObject((JSONObject)localObject3);
            localObject3 = CaptureComboPasterFactory.a(str3, (List)localObject4, f1, f2, f3);
            if (localObject3 != null)
            {
              ((CaptureComboBase)localObject3).a((SegmentKeeper)localObject5);
              ((TemplateSet)localObject1).d((CaptureComboBase)localObject3);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("QTemplate", 2, "createCombo texts Null id=" + str3);
            }
          }
          catch (Exception localException4)
          {
            localException4.printStackTrace();
          }
          this.jdField_d_of_type_JavaUtilHashMap.put(paramQIMTemplateItem.jdField_a_of_type_JavaLangString, localObject1);
          ((TemplateSet)localObject1).jdField_a_of_type_JavaLangObject = paramQIMTemplateItem;
          return localObject1;
          label1089:
          i += 1;
          break;
          label1098:
          i += 1;
          break label439;
          label1107:
          i += 1;
          break label588;
          label1116:
          j += 1;
        }
      }
      label1125:
      i += 1;
    }
  }
  
  public TemplateSet a(QIMTemplateItem paramQIMTemplateItem, Activity paramActivity, Bundle paramBundle)
  {
    paramQIMTemplateItem = ((CaptureComboManager)QIMManager.a(5)).a(paramQIMTemplateItem);
    paramQIMTemplateItem.b(paramActivity, paramBundle.getInt("capture_scene", -1));
    paramQIMTemplateItem.b = new WeakReference(paramActivity);
    switch (paramQIMTemplateItem.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "applyTemplate state = " + paramQIMTemplateItem.jdField_a_of_type_Int);
      }
      return paramQIMTemplateItem;
      a(new CaptureComboManager.ComboApplyTask(paramQIMTemplateItem, paramBundle, paramActivity));
      paramActivity = Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, paramQIMTemplateItem);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        a(paramActivity);
      }
      else
      {
        paramActivity.sendToTarget();
        continue;
        a(new CaptureComboManager.ComboApplyTask(paramQIMTemplateItem, paramBundle, paramActivity));
        continue;
        a(new CaptureComboManager.ComboApplyTask(paramQIMTemplateItem, paramBundle, paramActivity));
        paramQIMTemplateItem.b();
      }
    }
  }
  
  public VideoFilterTools.DataSet a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData != null) {
      return this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData.a;
    }
    return null;
  }
  
  public void a()
  {
    if ((this.jdField_d_of_type_JavaUtilHashMap != null) && (this.jdField_d_of_type_JavaUtilHashMap.size() > 0)) {
      this.jdField_d_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_Int & 0x3) == 3) {}
    do
    {
      return;
      this.jdField_b_of_type_Int |= paramInt;
    } while ((this.jdField_b_of_type_Int & 0x3) != 3);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureComboManager", 2, "first random");
    }
    b();
  }
  
  public void a(int paramInt, Activity paramActivity)
  {
    Object localObject = VideoFilterTools.a().a(paramInt);
    if (localObject != null)
    {
      localObject = a((QIMFilterCategoryItem)localObject);
      if ((localObject != null) && (((ComboSet)localObject).jdField_a_of_type_Int == 1))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("capture_scene", paramInt);
        ComboSet localComboSet = VideoFilterTools.a().a[paramInt];
        if (localComboSet != null) {
          a((QIMFilterCategoryItem)localComboSet.jdField_a_of_type_JavaLangObject, paramActivity, (Bundle)localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "stopApplyDownload scene " + paramInt);
        }
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    CaptureComboManager.CaptureRecord[] arrayOfCaptureRecord = this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord;
    int j = arrayOfCaptureRecord.length;
    int i = 0;
    while (i < j)
    {
      arrayOfCaptureRecord[i].c(paramActivity);
      i += 1;
    }
  }
  
  public void a(CaptureComboManager.CaptureComboListener paramCaptureComboListener)
  {
    synchronized (this.jdField_e_of_type_JavaUtilArrayList)
    {
      if (!this.jdField_e_of_type_JavaUtilArrayList.contains(paramCaptureComboListener)) {
        this.jdField_e_of_type_JavaUtilArrayList.add(paramCaptureComboListener);
      }
      return;
    }
  }
  
  public void a(CaptureComboManager.ComboApplyTask paramComboApplyTask)
  {
    synchronized (this.jdField_e_of_type_JavaUtilHashMap)
    {
      String str = paramComboApplyTask.jdField_a_of_type_DovComQqImCaptureDataCaptureSet.b();
      ArrayList localArrayList2 = (ArrayList)this.jdField_e_of_type_JavaUtilHashMap.get(str);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.jdField_e_of_type_JavaUtilHashMap.put(str, localArrayList1);
      }
      localArrayList1.add(paramComboApplyTask);
      return;
    }
  }
  
  public void a(CaptureSet paramCaptureSet)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadComboSuccess captureSet " + paramCaptureSet);
    }
    if ((paramCaptureSet.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) {}
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramCaptureSet.jdField_a_of_type_JavaLangObject);
      Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1, 0, 7, paramCaptureSet).sendToTarget();
      return;
    }
  }
  
  public void a(CaptureSet paramCaptureSet, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadComboFailed captureset " + paramCaptureSet);
    }
    if ((paramCaptureSet.jdField_a_of_type_JavaLangObject instanceof QIMFilterCategoryItem)) {}
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramCaptureSet.jdField_a_of_type_JavaLangObject);
      Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 1, paramInt, 7, paramCaptureSet).sendToTarget();
      return;
    }
  }
  
  public void a(ComboSet paramComboSet)
  {
    Iterator localIterator = this.jdField_e_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((CaptureComboManager.CaptureComboListener)localIterator.next()).a(paramComboSet);
    }
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pre_capture_combo_select", 0);
    String str = "";
    if ((paramQIMFilterCategoryItem.e()) || (paramQIMFilterCategoryItem.c())) {
      str = paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString;
    }
    paramQIMFilterCategoryItem = str;
    if (str == null) {
      paramQIMFilterCategoryItem = "";
    }
    localSharedPreferences.edit().putString("select", paramQIMFilterCategoryItem).apply();
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    int i = paramBundle.getInt("capture_scene", -1);
    QIMFilterCategoryItem localQIMFilterCategoryItem = VideoFilterTools.a().b(i);
    boolean bool1;
    boolean bool2;
    if ((localQIMFilterCategoryItem != null) && (TextUtils.equals(localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString)))
    {
      bool1 = true;
      if ((localQIMFilterCategoryItem != null) || (!a(paramQIMFilterCategoryItem))) {
        break label165;
      }
      bool2 = true;
      label58:
      boolean bool3 = paramBundle.getBoolean("capture_force_enable", false);
      if (((!bool1) && (!bool2)) || (bool3)) {
        break label171;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CaptureComboManager", 2, new Object[] { "applyFilters repeat, sameItem: ", Boolean.valueOf(bool1), " emptyItem:", Boolean.valueOf(bool2), " filterItem:", paramQIMFilterCategoryItem.jdField_b_of_type_JavaLangString, " isForceEnable:", Boolean.valueOf(bool3) });
      }
    }
    for (;;)
    {
      return;
      bool1 = false;
      break;
      label165:
      bool2 = false;
      break label58;
      label171:
      paramQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).a(paramQIMFilterCategoryItem);
      paramQIMFilterCategoryItem.b(paramActivity, i);
      paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      switch (paramQIMFilterCategoryItem.jdField_a_of_type_Int)
      {
      }
      while (QLog.isColorLevel())
      {
        QLog.i("QCombo", 2, "applyFilters state = " + paramQIMFilterCategoryItem.jdField_a_of_type_Int);
        return;
        a(new CaptureComboManager.ComboApplyTask(paramQIMFilterCategoryItem, paramBundle, paramActivity));
        paramActivity = Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, paramQIMFilterCategoryItem);
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          a(paramActivity);
        }
        else
        {
          paramActivity.sendToTarget();
          continue;
          a(new CaptureComboManager.ComboApplyTask(paramQIMFilterCategoryItem, paramBundle, paramActivity));
          continue;
          a(new CaptureComboManager.ComboApplyTask(paramQIMFilterCategoryItem, paramBundle, paramActivity));
          QIMCommonLoadingProgress.a(paramQIMFilterCategoryItem).a();
          paramQIMFilterCategoryItem.b();
        }
      }
    }
  }
  
  public void a(TemplateSet paramTemplateSet)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadTemplateSuccess templateSet " + paramTemplateSet);
    }
    if ((paramTemplateSet.jdField_a_of_type_JavaLangObject instanceof QIMTemplateItem)) {}
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add((QIMTemplateItem)paramTemplateSet.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, paramTemplateSet).sendToTarget();
      return;
    }
  }
  
  public void a(TemplateSet paramTemplateSet, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadTemplateFailed templateSet " + paramTemplateSet + ", error " + paramInt);
    }
    if ((paramTemplateSet.jdField_a_of_type_JavaLangObject instanceof QIMTemplateItem)) {}
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add((QIMTemplateItem)paramTemplateSet.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, paramInt, 0, paramTemplateSet).sendToTarget();
      return;
    }
  }
  
  public void a(VideoFilterTools.ComboFilterData paramComboFilterData)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("updateData data is null?");
      if (paramComboFilterData != null) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCombo", 2, bool);
      if (paramComboFilterData != null)
      {
        this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData = paramComboFilterData;
        this.jdField_a_of_type_DovComQqImCaptureDataComboLockManager.a(paramComboFilterData);
        Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 9, paramComboFilterData).sendToTarget();
      }
      a(1);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureComboManager", 2, "yes to do setBeRecording" + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    for (;;)
    {
      boolean bool;
      int i;
      synchronized (this.jdField_d_of_type_JavaUtilArrayList)
      {
        this.jdField_c_of_type_JavaUtilArrayList.addAll(this.jdField_d_of_type_JavaUtilArrayList);
        this.jdField_d_of_type_JavaUtilArrayList.clear();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "syncStateAndProgress " + this.jdField_c_of_type_JavaUtilArrayList.size());
        }
        bool = false;
        i = this.jdField_c_of_type_JavaUtilArrayList.size() - 1;
        if (i < 0) {
          break label470;
        }
        QIMFilterCategoryItem localQIMFilterCategoryItem1 = (QIMFilterCategoryItem)this.jdField_c_of_type_JavaUtilArrayList.get(i);
        ??? = a(localQIMFilterCategoryItem1);
        if (((CaptureSet)???).jdField_a_of_type_Int == 1)
        {
          int j = ((CaptureSet)???).a();
          if (j != ((CaptureSet)???).jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "buildComboBatch progress: " + localQIMFilterCategoryItem1.jdField_b_of_type_JavaLangString + ", progress: " + ((CaptureSet)???).jdField_b_of_type_Int);
            }
            ((CaptureSet)???).jdField_a_of_type_Int = j;
          }
          j = (int)(10000.0F * ((CaptureSet)???).a());
          if (j != ((CaptureSet)???).jdField_b_of_type_Int)
          {
            ((CaptureSet)???).jdField_b_of_type_Int = j;
            if (QLog.isColorLevel()) {
              QLog.i("QCombo", 2, "buildComboBatch progress: " + j + ", progress: " + ((CaptureSet)???).jdField_b_of_type_Int);
            }
          }
          bool = true;
          i -= 1;
        }
      }
      QIMFilterCategoryItem localQIMFilterCategoryItem2;
      if (((CaptureSet)???).jdField_a_of_type_Int == 2)
      {
        ((CaptureSet)???).a();
        localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)this.jdField_c_of_type_JavaUtilArrayList.remove(i);
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMFilterCategoryItem2.jdField_b_of_type_JavaLangString + ",  STATE_NEED_DOWNLOAD progress: " + ((CaptureSet)???).jdField_b_of_type_Int);
        }
        bool = true;
      }
      else if (((CaptureSet)???).jdField_a_of_type_Int == 3)
      {
        ((CaptureSet)???).a();
        ((CaptureSet)???).jdField_b_of_type_Int = 10000;
        localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)this.jdField_c_of_type_JavaUtilArrayList.remove(i);
        QIMCommonLoadingProgress.a(???).b();
        Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, ???).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMFilterCategoryItem2.jdField_b_of_type_JavaLangString + ", STATE_DOWNLOADED progress: " + ((CaptureSet)???).jdField_b_of_type_Int);
        }
        bool = true;
        continue;
        label470:
        return bool;
      }
    }
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      int i = paramMessage.arg1;
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "MSG_APPLY error " + i + " " + paramMessage.obj);
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      label405:
      label411:
      int j;
      if ((paramMessage.obj instanceof FilterSet))
      {
        paramMessage = (FilterSet)paramMessage.obj;
        if (i == 0)
        {
          QIMCommonLoadingProgress.a(paramMessage).b();
          localObject1 = paramMessage.b();
          localObject1 = (ArrayList)this.jdField_e_of_type_JavaUtilHashMap.get(localObject1);
          if (localObject1 == null) {
            continue;
          }
          localObject2 = (ArrayList)((ArrayList)localObject1).clone();
          ((ArrayList)localObject1).clear();
          localObject1 = (QIMFilterCategoryItem)paramMessage.jdField_a_of_type_JavaLangObject;
          if (i == 0) {
            localObject2 = ((ArrayList)localObject2).iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label411;
            }
            localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
            i = ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
            ??? = VideoFilterTools.a().b(i);
            if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Boolean))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QCombo", 2, "MSG_APPLY filter " + i + " " + ???);
              }
              ((QIMCaptureVarManager)QIMManager.a(13)).a(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString);
              ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
              if (??? != null)
              {
                paramMessage.a((Activity)???, i);
                synchronized (this.jdField_e_of_type_JavaUtilArrayList)
                {
                  ??? = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                  if (!((Iterator)???).hasNext()) {
                    break label405;
                  }
                  ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, true, 0, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
                QIMCommonLoadingProgress.a(paramMessage).c();
                break;
              }
            }
          }
          this.jdField_a_of_type_DovComQqImCaptureDataFilterSet = paramMessage;
          continue;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
          j = ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
          ??? = VideoFilterTools.a().b(j);
          if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "MSG_APPLY filter " + j + " " + ???);
            }
            ((QIMCaptureVarManager)QIMManager.a(13)).a(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString);
            if ((Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
              synchronized (this.jdField_e_of_type_JavaUtilArrayList)
              {
                ??? = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                if (((Iterator)???).hasNext()) {
                  ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, false, i, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131701427), 0).a();
          }
        }
      }
      else if ((paramMessage.obj instanceof ComboSet))
      {
        paramMessage = (ComboSet)paramMessage.obj;
        if (i == 0)
        {
          QIMCommonLoadingProgress.a(paramMessage).b();
          localObject1 = (QIMFilterCategoryItem)paramMessage.jdField_a_of_type_JavaLangObject;
          localObject2 = paramMessage.b();
          localObject2 = (ArrayList)this.jdField_e_of_type_JavaUtilHashMap.get(localObject2);
          if (localObject2 == null) {
            continue;
          }
          localObject3 = (ArrayList)((ArrayList)localObject2).clone();
          ((ArrayList)localObject2).clear();
          if (i == 0) {
            localObject2 = ((ArrayList)localObject3).iterator();
          }
        }
        else
        {
          label976:
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label982;
            }
            localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
            ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null)
            {
              i = ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
              ??? = VideoFilterTools.a().a(i);
              if ((??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QCombo", 2, "MSG_APPLY success " + i + " " + localObject1);
                }
                ((QIMCaptureVarManager)QIMManager.a(13)).b(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString);
                b((Activity)???, i);
                if (!CaptureComboFilter.a(paramMessage, i)) {
                  paramMessage.a((Activity)???, i);
                }
                synchronized (this.jdField_e_of_type_JavaUtilArrayList)
                {
                  ??? = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                  if (!((Iterator)???).hasNext()) {
                    break label976;
                  }
                  ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, true, 0, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
                QIMCommonLoadingProgress.a(paramMessage).c();
                break;
              }
            }
          }
          label982:
          this.jdField_a_of_type_DovComQqImCaptureDataComboSet = paramMessage;
          continue;
        }
        localObject2 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
          j = ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
          ??? = VideoFilterTools.a().a(j);
          if ((??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "MSG_APPLY fail " + j + " " + localObject1);
            }
            ((QIMCaptureVarManager)QIMManager.a(13)).b(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString);
            ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null)
            {
              synchronized (this.jdField_e_of_type_JavaUtilArrayList)
              {
                ??? = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                if (((Iterator)???).hasNext()) {
                  ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, false, i, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
              }
              ??? = (CaptureComboManager)QIMManager.a(5);
              ??? = ((CaptureComboManager)???).jdField_a_of_type_DovComQqImCaptureDataComboSet;
              if (??? != null) {
                ((CaptureComboManager)???).a((QIMFilterCategoryItem)((ComboSet)???).jdField_a_of_type_JavaLangObject, (Activity)???, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131701429), 0).a();
          }
        }
      }
      else if ((paramMessage.obj instanceof TemplateSet))
      {
        localObject1 = (CaptureTemplateManager)QIMManager.a(15);
        paramMessage = (TemplateSet)paramMessage.obj;
        if (i == 0)
        {
          QIMCommonLoadingProgress.a(paramMessage).b();
          localObject2 = (QIMTemplateItem)paramMessage.jdField_a_of_type_JavaLangObject;
          localObject3 = paramMessage.b();
          localObject3 = (ArrayList)this.jdField_e_of_type_JavaUtilHashMap.get(localObject3);
          if (localObject3 == null) {
            continue;
          }
          ??? = (ArrayList)((ArrayList)localObject3).clone();
          ((ArrayList)localObject3).clear();
          if (i == 0) {
            localObject3 = ((ArrayList)???).iterator();
          }
        }
        else
        {
          label1584:
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label1590;
            }
            ??? = (CaptureComboManager.ComboApplyTask)((Iterator)localObject3).next();
            ??? = (Activity)((CaptureComboManager.ComboApplyTask)???).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null)
            {
              i = ((CaptureComboManager.ComboApplyTask)???).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
              ??? = ((CaptureTemplateManager)localObject1).a(i);
              if ((??? != null) && (TextUtils.equals(((QIMTemplateItem)???).jdField_a_of_type_JavaLangString, ((QIMTemplateItem)localObject2).jdField_a_of_type_JavaLangString)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QTemplate", 2, "MSG_APPLY template success:" + i + ", item:" + localObject2);
                }
                a((Activity)???, i);
                if (!((CaptureTemplateManager)localObject1).a(paramMessage, i)) {
                  paramMessage.a((Activity)???, i);
                }
                synchronized (this.jdField_e_of_type_JavaUtilArrayList)
                {
                  ??? = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                  if (!((Iterator)???).hasNext()) {
                    break label1584;
                  }
                  ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, true, 0, ((CaptureComboManager.ComboApplyTask)???).jdField_a_of_type_AndroidOsBundle);
                }
                QIMCommonLoadingProgress.a(paramMessage).c();
                break;
              }
            }
          }
          label1590:
          ((CaptureTemplateManager)localObject1).a(paramMessage);
          continue;
        }
        localObject3 = ((ArrayList)???).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ??? = (CaptureComboManager.ComboApplyTask)((Iterator)localObject3).next();
          j = ((CaptureComboManager.ComboApplyTask)???).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
          ??? = ((CaptureTemplateManager)localObject1).a(j);
          if ((??? != null) && (TextUtils.equals(((QIMTemplateItem)???).jdField_a_of_type_JavaLangString, ((QIMTemplateItem)localObject2).jdField_a_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QTemplate", 2, "MSG_APPLY template fail " + j + " " + localObject2);
            }
            ??? = (Activity)((CaptureComboManager.ComboApplyTask)???).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null)
            {
              synchronized (this.jdField_e_of_type_JavaUtilArrayList)
              {
                localObject7 = this.jdField_e_of_type_JavaUtilArrayList.iterator();
                if (((Iterator)localObject7).hasNext()) {
                  ((CaptureComboManager.CaptureComboListener)((Iterator)localObject7).next()).a(paramMessage, false, i, ((CaptureComboManager.ComboApplyTask)???).jdField_a_of_type_AndroidOsBundle);
                }
              }
              ??? = ((CaptureTemplateManager)localObject1).a();
              Object localObject7 = (CaptureComboManager)QIMManager.a(5);
              if (??? != null) {
                ((CaptureComboManager)localObject7).a((QIMTemplateItem)((TemplateSet)???).jdField_a_of_type_JavaLangObject, (Activity)???, ((CaptureComboManager.ComboApplyTask)???).jdField_a_of_type_AndroidOsBundle);
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, HardCodeUtil.a(2131701428), 0).a();
          }
        }
        paramMessage = (VideoFilterTools.ComboFilterData)paramMessage.obj;
        try
        {
          localObject1 = this.jdField_e_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((CaptureComboManager.CaptureComboListener)((Iterator)localObject1).next()).a(paramMessage);
          }
        }
        finally {}
      }
    }
  }
  
  public boolean a(List<FilterCategory> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "preInitCombo: " + paramList.size());
    }
    Iterator localIterator1 = paramList.iterator();
    boolean bool = false;
    FilterCategory localFilterCategory;
    Iterator localIterator2;
    if (localIterator1.hasNext())
    {
      localFilterCategory = (FilterCategory)localIterator1.next();
      localIterator2 = localFilterCategory.jdField_a_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (localIterator2.hasNext())
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)localIterator2.next();
        if (localFilterCategory.jdField_a_of_type_Boolean) {}
        for (paramList = a(localQIMFilterCategoryItem);; paramList = a(localQIMFilterCategoryItem))
        {
          paramList.jdField_a_of_type_Int = paramList.a();
          if (paramList.jdField_a_of_type_Int != 1) {
            break label208;
          }
          paramList.jdField_b_of_type_Int = ((int)(10000.0F * paramList.a()));
          if (!QLog.isColorLevel()) {
            break label239;
          }
          QLog.d("QCombo", 2, "preInitCombo progress: " + localQIMFilterCategoryItem.jdField_b_of_type_JavaLangString + ", progress: " + paramList.jdField_b_of_type_Int);
          bool = true;
          break;
        }
        label208:
        if ((paramList.jdField_a_of_type_Int != 2) && (paramList.jdField_a_of_type_Int == 3)) {
          paramList.jdField_b_of_type_Int = 10000;
        }
      }
      else
      {
        break;
        return bool;
        label239:
        bool = true;
      }
    }
  }
  
  public void b()
  {
    VideoFilterTools.ComboFilterData localComboFilterData = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "randomliseData " + localComboFilterData);
    }
    if (localComboFilterData != null)
    {
      localComboFilterData.a();
      a(localComboFilterData);
    }
  }
  
  public void b(CaptureComboManager.CaptureComboListener paramCaptureComboListener)
  {
    synchronized (this.jdField_e_of_type_JavaUtilArrayList)
    {
      this.jdField_e_of_type_JavaUtilArrayList.remove(paramCaptureComboListener);
      return;
    }
  }
  
  public void b(CaptureSet paramCaptureSet)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "notifyDownloadBegin combo " + paramCaptureSet);
    }
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramCaptureSet.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
  }
  
  public void b(TemplateSet paramTemplateSet)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "notifyDownloadTemplateBegin templateSet " + paramTemplateSet);
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add((QIMTemplateItem)paramTemplateSet.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      return;
    }
  }
  
  public boolean b()
  {
    for (;;)
    {
      boolean bool;
      int i;
      synchronized (this.jdField_b_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "syncStateAndProgress " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        bool = false;
        i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i < 0) {
          break label458;
        }
        QIMTemplateItem localQIMTemplateItem1 = (QIMTemplateItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ??? = a(localQIMTemplateItem1);
        if (((CaptureSet)???).jdField_a_of_type_Int == 1)
        {
          int j = ((CaptureSet)???).a();
          if (j != ((CaptureSet)???).jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "buildComboBatch progress: " + localQIMTemplateItem1.jdField_b_of_type_JavaLangString + ", progress: " + ((CaptureSet)???).jdField_b_of_type_Int);
            }
            ((CaptureSet)???).jdField_a_of_type_Int = j;
          }
          j = (int)(10000.0F * ((CaptureSet)???).a());
          if (j != ((CaptureSet)???).jdField_b_of_type_Int)
          {
            ((CaptureSet)???).jdField_b_of_type_Int = j;
            if (QLog.isColorLevel()) {
              QLog.i("QCombo", 2, "buildComboBatch progress: " + j + ", progress: " + ((CaptureSet)???).jdField_b_of_type_Int);
            }
          }
          bool = true;
          i -= 1;
        }
      }
      QIMTemplateItem localQIMTemplateItem2;
      if (((CaptureSet)???).jdField_a_of_type_Int == 2)
      {
        localQIMTemplateItem2 = (QIMTemplateItem)this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMTemplateItem2.jdField_b_of_type_JavaLangString + ",  STATE_NEED_DOWNLOAD progress: " + ((CaptureSet)???).jdField_b_of_type_Int);
        }
        bool = true;
      }
      else if (((CaptureSet)???).jdField_a_of_type_Int == 3)
      {
        ((CaptureSet)???).jdField_b_of_type_Int = 10000;
        localQIMTemplateItem2 = (QIMTemplateItem)this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        QIMCommonLoadingProgress.a(???).b();
        Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, ???).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMTemplateItem2.jdField_b_of_type_JavaLangString + ", STATE_DOWNLOADED progress: " + ((CaptureSet)???).jdField_b_of_type_Int);
        }
        bool = true;
        continue;
        label458:
        return bool;
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return a(paramMessage);
  }
  
  public void initIndeed()
  {
    VideoFilterTools.a().a(BaseApplicationImpl.getContext(), null, false);
    if (QLog.isDevelopLevel()) {
      QLog.d("CaptureComboManager", 4, "initComboConfig");
    }
  }
  
  public boolean isValidate()
  {
    return false;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_DovComQqImCaptureDataComboLockManager.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureComboManager
 * JD-Core Version:    0.7.0.1
 */