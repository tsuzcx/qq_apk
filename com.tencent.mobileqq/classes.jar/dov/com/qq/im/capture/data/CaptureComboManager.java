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
import antv;
import antw;
import antx;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.CaptureComboPasterFactory;
import dov.com.qq.im.capture.util.DoodleLayoutConnector;
import dov.com.qq.im.capture.view.ComboProviderView;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import dov.com.qq.im.capture.view.QIMFilterProviderView;
import dov.com.qq.im.capture.view.StaticStickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.DataSet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class CaptureComboManager
  extends IQIMManager
  implements Handler.Callback, IEventReceiver, Runnable
{
  int jdField_a_of_type_Int;
  public Handler a;
  ComboLockManager jdField_a_of_type_DovComQqImCaptureDataComboLockManager;
  public ComboSet a;
  public FilterSet a;
  public VideoFilterTools.ComboFilterData a;
  public ArrayList a;
  public HashMap a;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  public boolean a;
  public CaptureComboManager.CaptureRecord[] a;
  public Handler b;
  public ArrayList b;
  public HashMap b;
  public Handler c;
  ArrayList c;
  public HashMap c;
  public HashMap d = new HashMap();
  
  public CaptureComboManager()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), new antw(this));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord = new CaptureComboManager.CaptureRecord[5];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord.length)
    {
      this.jdField_a_of_type_ArrayOfDovComQqImCaptureDataCaptureComboManager$CaptureRecord[i] = new CaptureComboManager.CaptureRecord(i);
      i += 1;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), new antv(this));
    this.jdField_a_of_type_DovComQqImCaptureDataComboLockManager = new ComboLockManager(this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  public static void c()
  {
    QIMManager.a(3);
    QIMManager.a(4);
    QIMManager.a(5);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      PtvFilterSoLoad.a((QQAppInterface)localAppRuntime, BaseApplicationImpl.getContext());
    }
  }
  
  public CaptureComboFilter a(FilterDesc paramFilterDesc)
  {
    CaptureComboFilter localCaptureComboFilter2 = (CaptureComboFilter)this.jdField_c_of_type_JavaUtilHashMap.get(paramFilterDesc.e);
    CaptureComboFilter localCaptureComboFilter1 = localCaptureComboFilter2;
    if (localCaptureComboFilter2 == null)
    {
      localCaptureComboFilter1 = new CaptureComboFilter(paramFilterDesc);
      this.jdField_c_of_type_JavaUtilHashMap.put(paramFilterDesc.e, localCaptureComboFilter1);
    }
    return localCaptureComboFilter1;
  }
  
  public ComboLockManager a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureDataComboLockManager;
  }
  
  public ComboSet a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    Object localObject2 = (ComboSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    Object localObject1 = localObject2;
    Object localObject4;
    Object localObject5;
    int j;
    int i;
    Object localObject6;
    float f1;
    float f2;
    float f3;
    label370:
    Object localObject3;
    if (localObject2 == null)
    {
      localObject1 = new ComboSet(paramQIMFilterCategoryItem);
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "createCombo filter " + paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList);
      }
      localObject2 = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (String)((Iterator)localObject2).next();
        localObject5 = VideoFilterTools.a().a((String)localObject4);
        if (localObject5 != null) {
          ((ComboSet)localObject1).c(a((FilterDesc)localObject5));
        } else if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo filterNull " + (String)localObject4);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCombo", 2, "createCombo pasters " + paramQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray);
      }
      if (paramQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        j = paramQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray.length();
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label370;
          }
          localObject4 = paramQIMFilterCategoryItem.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(i);
          if (localObject4 != null) {}
          try
          {
            localObject5 = ((JSONObject)localObject4).optString("packet_id");
            localObject6 = ((JSONObject)localObject4).optString("item_id");
            f1 = Float.valueOf(((JSONObject)localObject4).optString("position_x")).floatValue();
            f2 = Float.valueOf(((JSONObject)localObject4).optString("position_y")).floatValue();
            f3 = Float.valueOf(((JSONObject)localObject4).optString("scale")).floatValue();
            localObject2 = new SegmentKeeper();
            ((SegmentKeeper)localObject2).a((JSONObject)localObject4);
            localObject4 = CaptureComboPasterFactory.a((String)localObject5, (String)localObject6, f1, f2, f3);
            if (localObject4 != null)
            {
              ((CaptureComboBase)localObject4).a((SegmentKeeper)localObject2);
              ((ComboSet)localObject1).c((CaptureComboBase)localObject4);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              localException1.printStackTrace();
            }
          }
          i += 1;
        }
      }
      if (paramQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray != null)
      {
        j = paramQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray.length();
        i = 0;
        if (i < j)
        {
          localObject4 = paramQIMFilterCategoryItem.jdField_b_of_type_OrgJsonJSONArray.optJSONObject(i);
          if (localObject4 == null) {
            break label998;
          }
          try
          {
            String str1 = ((JSONObject)localObject4).optString("tagId");
            localObject4 = ((JSONObject)localObject4).optString("itemId");
            localObject5 = CaptureComboPasterFactory.a((String)localObject4);
            if (localObject5 != null) {
              ((ComboSet)localObject1).c((CaptureComboBase)localObject5);
            } else if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "createCombo musicNull " + str1 + ":" + (String)localObject4);
            }
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      if (paramQIMFilterCategoryItem.c != null)
      {
        j = paramQIMFilterCategoryItem.c.length();
        i = 0;
        label530:
        if (i < j)
        {
          localObject4 = paramQIMFilterCategoryItem.c.optJSONObject(i);
          if (localObject4 == null) {
            break label1007;
          }
          try
          {
            String str2 = ((JSONObject)localObject4).optString("tagId");
            localObject4 = ((JSONObject)localObject4).optString("itemId");
            if (StringUtil.a(str2)) {
              break label1007;
            }
            localObject5 = CaptureComboPasterFactory.b((String)localObject4);
            if (localObject5 != null) {
              ((ComboSet)localObject1).c((CaptureComboBase)localObject5);
            } else if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "createCombo ptvNull " + str2 + ":" + (String)localObject4);
            }
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
        }
      }
      if (paramQIMFilterCategoryItem.d != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QCombo", 2, "createCombo texts " + paramQIMFilterCategoryItem.d + " size: " + paramQIMFilterCategoryItem.d.length());
        }
        int k = paramQIMFilterCategoryItem.d.length();
        i = 0;
        label730:
        if (i < k)
        {
          localObject3 = paramQIMFilterCategoryItem.d.optJSONObject(i);
          if (localObject3 == null) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = ((JSONObject)localObject3).optString("text_id");
        localObject6 = ((JSONObject)localObject3).optJSONArray("texts");
        if (localObject6 != null)
        {
          localObject5 = new ArrayList();
          j = 0;
          if (j < ((JSONArray)localObject6).length())
          {
            String str3 = ((JSONArray)localObject6).getString(j);
            if (TextUtils.isEmpty(str3)) {
              break label1016;
            }
            ((List)localObject5).add(str3);
            break label1016;
          }
          f1 = Float.valueOf(((JSONObject)localObject3).optString("position_x")).floatValue();
          f2 = Float.valueOf(((JSONObject)localObject3).optString("position_y")).floatValue();
          f3 = Float.valueOf(((JSONObject)localObject3).optString("scale")).floatValue();
          if (QLog.isColorLevel()) {
            QLog.d("QCombo", 2, "create  TextCombo ID: " + (String)localObject4);
          }
          localObject6 = new SegmentKeeper();
          ((SegmentKeeper)localObject6).a((JSONObject)localObject3);
          localObject3 = CaptureComboPasterFactory.a((String)localObject4, (List)localObject5, f1, f2, f3);
          if (localObject3 != null)
          {
            ((CaptureComboBase)localObject3).a((SegmentKeeper)localObject6);
            ((ComboSet)localObject1).c((CaptureComboBase)localObject3);
          }
        }
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        continue;
      }
      i += 1;
      break label730;
      this.jdField_a_of_type_JavaUtilHashMap.put(paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString, localObject1);
      ((ComboSet)localObject1).jdField_a_of_type_JavaLangObject = paramQIMFilterCategoryItem;
      return localObject1;
      label998:
      i += 1;
      break;
      label1007:
      i += 1;
      break label530;
      label1016:
      j += 1;
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
  
  public FilterSet a(QIMFilterCategoryItem paramQIMFilterCategoryItem, Activity paramActivity, Bundle paramBundle)
  {
    paramQIMFilterCategoryItem = ((CaptureComboManager)QIMManager.a(5)).a(paramQIMFilterCategoryItem);
    paramQIMFilterCategoryItem.b(paramActivity, paramBundle.getInt("capture_scene", -1));
    paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    switch (paramQIMFilterCategoryItem.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "applyFilters state = " + paramQIMFilterCategoryItem.jdField_a_of_type_Int);
      }
      return paramQIMFilterCategoryItem;
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
        paramQIMFilterCategoryItem.b();
      }
    }
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
  
  public QIMFilterCategoryItem a(Activity paramActivity, int paramInt)
  {
    Object localObject = (ComboProviderView)paramActivity.findViewById(2131362420);
    if (localObject != null)
    {
      ((ComboProviderView)localObject).g();
      localObject = DoodleLayoutConnector.a().a(((ComboProviderView)localObject).f);
      if ((localObject != null) && (((DoodleLayout)localObject).a() != null))
      {
        ((DoodleLayout)localObject).a().a();
        ((DoodleLayout)localObject).a().a();
        ((DoodleLayout)localObject).a().a();
      }
    }
    localObject = (StaticStickerProviderView)paramActivity.findViewById(2131362422);
    if (localObject != null) {
      ((StaticStickerProviderView)localObject).g();
    }
    localObject = (QIMFilterProviderView)paramActivity.findViewById(2131362421);
    if (localObject != null) {
      ((QIMFilterProviderView)localObject).g();
    }
    paramActivity = (MusicProviderView)paramActivity.findViewById(2131362423);
    if (paramActivity != null) {
      paramActivity.g();
    }
    return VideoFilterTools.a().a(paramInt);
  }
  
  public QIMFilterCategoryItem a(ComboSet paramComboSet, ArrayList paramArrayList)
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
        if (QQAVImageFilterConstants.a(((FilterDesc)localObject2).b) == 2)
        {
          if (localObject2 == null) {
            break label278;
          }
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            paramComboSet = (QIMFilterCategoryItem)paramArrayList.next();
            if ((paramComboSet.jdField_a_of_type_JavaUtilArrayList.size() == 1) && (paramComboSet.jdField_a_of_type_JavaUtilArrayList.contains(((FilterDesc)localObject2).e)))
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
  
  public VideoFilterTools.DataSet a()
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData != null) {
      return this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData.a;
    }
    return null;
  }
  
  public void a()
  {
    ThreadManager.post(new antx(this), 8, null, true);
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Int & 0x3) == 3) {}
    do
    {
      return;
      this.jdField_a_of_type_Int |= paramInt;
    } while ((this.jdField_a_of_type_Int & 0x3) != 3);
    if (QLog.isColorLevel()) {
      QLog.i("CaptureComboManager", 2, "first random");
    }
    e();
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
  
  public void a(Activity paramActivity, int paramInt, QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("capture_scene", paramInt);
    a(paramQIMFilterCategoryItem, paramActivity, localBundle);
  }
  
  public void a(CaptureComboManager.CaptureComboListener paramCaptureComboListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.add(paramCaptureComboListener);
      return;
    }
  }
  
  public void a(CaptureComboManager.ComboApplyTask paramComboApplyTask)
  {
    synchronized (this.d)
    {
      String str = paramComboApplyTask.jdField_a_of_type_DovComQqImCaptureDataCaptureSet.b();
      ArrayList localArrayList2 = (ArrayList)this.d.get(str);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.d.put(str, localArrayList1);
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
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramCaptureSet.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, 0, 0, paramCaptureSet).sendToTarget();
      return;
    }
  }
  
  public void a(CaptureSet paramCaptureSet, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "downloadComboFailed captureset " + paramCaptureSet);
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramCaptureSet.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      Message.obtain(this.jdField_c_of_type_AndroidOsHandler, 7, paramInt, 0, paramCaptureSet).sendToTarget();
      return;
    }
  }
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("pre_capture_combo_select", 0);
    String str = "";
    if ((paramQIMFilterCategoryItem.d()) || (paramQIMFilterCategoryItem.c())) {
      str = paramQIMFilterCategoryItem.jdField_a_of_type_JavaLangString;
    }
    paramQIMFilterCategoryItem = str;
    if (str == null) {
      paramQIMFilterCategoryItem = "";
    }
    localSharedPreferences.edit().putString("select", paramQIMFilterCategoryItem).apply();
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
  
  public boolean a()
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
        QIMFilterCategoryItem localQIMFilterCategoryItem1 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ??? = a(localQIMFilterCategoryItem1);
        if (((CaptureSet)???).jdField_a_of_type_Int == 1)
        {
          int j = ((CaptureSet)???).a();
          if (j != ((CaptureSet)???).jdField_a_of_type_Int)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QCombo", 2, "buildComboBatch progress: " + localQIMFilterCategoryItem1.jdField_b_of_type_JavaLangString + ", progress: " + ((CaptureSet)???).b);
            }
            ((CaptureSet)???).jdField_a_of_type_Int = j;
          }
          j = (int)(10000.0F * ((CaptureSet)???).a());
          if (j != ((CaptureSet)???).b)
          {
            ((CaptureSet)???).b = j;
            if (QLog.isColorLevel()) {
              QLog.i("QCombo", 2, "buildComboBatch progress: " + j + ", progress: " + ((CaptureSet)???).b);
            }
          }
          bool = true;
          i -= 1;
        }
      }
      QIMFilterCategoryItem localQIMFilterCategoryItem2;
      if (((CaptureSet)???).jdField_a_of_type_Int == 2)
      {
        localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMFilterCategoryItem2.jdField_b_of_type_JavaLangString + ",  STATE_NEED_DOWNLOAD progress: " + ((CaptureSet)???).b);
        }
        bool = true;
      }
      else if (((CaptureSet)???).jdField_a_of_type_Int == 3)
      {
        ((CaptureSet)???).b = 10000;
        localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        QIMCommonLoadingProgress.a(???).b();
        Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, ???).sendToTarget();
        if (QLog.isColorLevel()) {
          QLog.i("QCombo", 2, "removeComboBatch: " + localQIMFilterCategoryItem2.jdField_b_of_type_JavaLangString + ", STATE_DOWNLOADED progress: " + ((CaptureSet)???).b);
        }
        bool = true;
        continue;
        label458:
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
        QLog.d("QCombo", 2, "MSG_APPLY error" + i + paramMessage.obj);
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int j;
      Object localObject6;
      if ((paramMessage.obj instanceof FilterSet))
      {
        paramMessage = (FilterSet)paramMessage.obj;
        localObject1 = paramMessage.b();
        localObject1 = (ArrayList)this.d.get(localObject1);
        if (localObject1 != null)
        {
          localObject2 = (ArrayList)((ArrayList)localObject1).clone();
          ((ArrayList)localObject1).clear();
          localObject1 = (QIMFilterCategoryItem)paramMessage.jdField_a_of_type_JavaLangObject;
          if (i == 0)
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (CaptureComboManager.ComboApplyTask)((Iterator)localObject2).next();
              i = ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle.getInt("capture_scene", -1);
              ??? = VideoFilterTools.a().b(i);
              if ((localObject1 != null) && (??? != null) && (TextUtils.equals(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString, ((QIMFilterCategoryItem)???).jdField_a_of_type_JavaLangString)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QCombo", 2, "MSG_APPLY filter " + i + " " + ???);
                }
                ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
                if (??? != null)
                {
                  paramMessage.a((Activity)???, i);
                  synchronized (this.jdField_c_of_type_JavaUtilArrayList)
                  {
                    ??? = this.jdField_c_of_type_JavaUtilArrayList.iterator();
                    if (((Iterator)???).hasNext()) {
                      ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, true, 0, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                    }
                  }
                }
              }
            }
            this.jdField_a_of_type_DovComQqImCaptureDataFilterSet = paramMessage;
          }
          else
          {
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
                ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
                if (??? != null)
                {
                  synchronized (this.jdField_c_of_type_JavaUtilArrayList)
                  {
                    localObject6 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
                    if (((Iterator)localObject6).hasNext()) {
                      ((CaptureComboManager.CaptureComboListener)((Iterator)localObject6).next()).a(paramMessage, false, i, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                    }
                  }
                  ??? = (CaptureComboManager)QIMManager.a(5);
                  localObject6 = ((CaptureComboManager)???).jdField_a_of_type_DovComQqImCaptureDataFilterSet;
                  if (localObject6 != null) {
                    ((CaptureComboManager)???).a((QIMFilterCategoryItem)((FilterSet)localObject6).jdField_a_of_type_JavaLangObject, (Activity)???, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                  }
                }
                QQToast.a(BaseApplicationImpl.sApplication, "网络出问题了，一会儿再试试。", 0).a();
              }
            }
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
          localObject2 = (ArrayList)this.d.get(localObject2);
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
          label930:
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label936;
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
                if (!CaptureComboFilter.a(paramMessage, i)) {
                  paramMessage.a((Activity)???, i);
                }
                synchronized (this.jdField_c_of_type_JavaUtilArrayList)
                {
                  ??? = this.jdField_c_of_type_JavaUtilArrayList.iterator();
                  if (!((Iterator)???).hasNext()) {
                    break label930;
                  }
                  ((CaptureComboManager.CaptureComboListener)((Iterator)???).next()).a(paramMessage, true, 0, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
                QIMCommonLoadingProgress.a(paramMessage).c();
                break;
              }
            }
          }
          label936:
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
            ??? = (Activity)((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_JavaLangRefWeakReference.get();
            if (??? != null)
            {
              synchronized (this.jdField_c_of_type_JavaUtilArrayList)
              {
                localObject6 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
                if (((Iterator)localObject6).hasNext()) {
                  ((CaptureComboManager.CaptureComboListener)((Iterator)localObject6).next()).a(paramMessage, false, i, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
                }
              }
              ??? = (CaptureComboManager)QIMManager.a(5);
              localObject6 = ((CaptureComboManager)???).jdField_a_of_type_DovComQqImCaptureDataComboSet;
              if (localObject6 != null) {
                ((CaptureComboManager)???).a((QIMFilterCategoryItem)((ComboSet)localObject6).jdField_a_of_type_JavaLangObject, (Activity)???, ((CaptureComboManager.ComboApplyTask)localObject3).jdField_a_of_type_AndroidOsBundle);
              }
            }
            QQToast.a(BaseApplicationImpl.sApplication, "网络出问题了，一会儿再试试。", 0).a();
          }
        }
        paramMessage = (VideoFilterTools.ComboFilterData)paramMessage.obj;
        try
        {
          localObject1 = this.jdField_c_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((CaptureComboManager.CaptureComboListener)((Iterator)localObject1).next()).a(paramMessage);
          }
        }
        finally {}
      }
    }
  }
  
  public boolean a(List paramList)
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
          paramList.b = ((int)(10000.0F * paramList.a()));
          if (!QLog.isColorLevel()) {
            break label239;
          }
          QLog.d("QCombo", 2, "preInitCombo progress: " + localQIMFilterCategoryItem.jdField_b_of_type_JavaLangString + ", progress: " + paramList.b);
          bool = true;
          break;
        }
        label208:
        if ((paramList.jdField_a_of_type_Int != 2) && (paramList.jdField_a_of_type_Int == 3)) {
          paramList.b = 10000;
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
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    this.jdField_a_of_type_DovComQqImCaptureDataComboLockManager.a();
  }
  
  public void b(CaptureComboManager.CaptureComboListener paramCaptureComboListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.remove(paramCaptureComboListener);
      return;
    }
  }
  
  public void b(CaptureSet paramCaptureSet)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "notifyDownloadBegin combo " + paramCaptureSet);
    }
    synchronized (this.jdField_b_of_type_JavaUtilArrayList)
    {
      this.jdField_b_of_type_JavaUtilArrayList.add((QIMFilterCategoryItem)paramCaptureSet.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    VideoFilterTools.a().a(BaseApplicationImpl.getContext(), null);
  }
  
  public void e()
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
  
  public void f()
  {
    VideoFilterTools.ComboFilterData localComboFilterData = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$ComboFilterData;
    if (QLog.isColorLevel()) {
      QLog.d("QCombo", 2, "reloadFilterData " + localComboFilterData);
    }
    if ((localComboFilterData != null) && (!VideoFilterTools.a().a(BaseApplicationImpl.sApplication))) {
      VideoFilterTools.a().a();
    }
  }
  
  public void g()
  {
    a().notifyObservers(CaptureComboObeserver.class, 971, true, null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return a(paramMessage);
  }
  
  public boolean isValidate()
  {
    return false;
  }
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.data.CaptureComboManager
 * JD-Core Version:    0.7.0.1
 */