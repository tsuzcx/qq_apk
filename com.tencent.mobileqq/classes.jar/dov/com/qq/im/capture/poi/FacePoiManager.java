package dov.com.qq.im.capture.poi;

import android.os.Bundle;
import anne;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestCallback;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.LocationUtils;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPoiPickerCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FacePoiManager
  implements LbsManager.POIListRequestCallback, HttpWebCgiAsyncTask.Callback
{
  public double a;
  LbsManager.POIListRequestSession jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = null;
  SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  TroopBarPOI jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = null;
  public FacePoiManager.FacePoiListener a;
  EditVideoParams jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  WeakReference jdField_a_of_type_MqqUtilWeakReference;
  public double b;
  ArrayList b;
  
  public FacePoiManager(FacePoiManager.FacePoiListener paramFacePoiListener)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager$FacePoiListener = paramFacePoiListener;
  }
  
  private TroopBarPOI a(List paramList, String paramString)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopBarPOI localTroopBarPOI = (TroopBarPOI)paramList.next();
      if (localTroopBarPOI.c.equals(paramString)) {
        return localTroopBarPOI;
      }
    }
    return null;
  }
  
  public TroopBarPOI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI;
  }
  
  public EditVideoPoiPickerCallback a()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      return (EditVideoPoiPickerCallback)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    SLog.b("FacePoiManager", "requestPoiList");
    LbsManager localLbsManager = (LbsManager)SuperManager.a(9);
    BasicLocation localBasicLocation = LbsManager.a();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) {
      localBasicLocation = LocationUtils.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    }
    if (localBasicLocation != null) {
      localLbsManager.a(localBasicLocation, this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession, this);
    }
  }
  
  public void a(int paramInt, LbsManager.POIListRequestSession paramPOIListRequestSession, List paramList)
  {
    SLog.b("FacePoiManager", "onPOIListRequestResult.");
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession = paramPOIListRequestSession;
    boolean bool;
    if ((paramInt == 0) && (paramPOIListRequestSession != null)) {
      if (!paramPOIListRequestSession.a())
      {
        bool = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) && (paramList.size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramList.get(0));
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession != null) && (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.b())) {
          this.jdField_b_of_type_JavaUtilArrayList.clear();
        }
        this.jdField_b_of_type_JavaUtilArrayList.addAll(paramList);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
          a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.a());
        }
        SLog.a("FacePoiManager", "onPOIListRequestResult, CurrentPOIList : %s , CurrentPOI : %s .", this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager$FacePoiListener.a(true, bool, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      }
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      StoryReportor.b("edit_video", "poi_list_success", 0, i, new String[0]);
      return;
      bool = false;
      break;
      this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager$FacePoiListener.a(false, false, null, null);
    }
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramTroopBarPOI;
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void a(EditVideoPoiPickerCallback paramEditVideoPoiPickerCallback, String paramString)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramEditVideoPoiPickerCallback);
    a(this.jdField_b_of_type_JavaUtilArrayList, paramString);
  }
  
  public void a(List paramList, String paramString)
  {
    String str = TroopBarPOI.a(paramString);
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      paramString = a(this.jdField_a_of_type_JavaUtilArrayList, str);
      paramList = paramString;
      if (paramString == null)
      {
        paramList = new TroopBarPOI("-1", "", str, 0, "", 0, "");
        this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramList;
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
      this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if ((3 != paramInt) || (paramJSONObject != null)) {}
    for (;;)
    {
      int i;
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("result");
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "poiList = " + paramJSONObject);
        }
        if (paramJSONObject == null) {
          continue;
        }
        if (paramJSONObject.optInt("isend", -1) != 1) {
          break label244;
        }
        bool = true;
        paramJSONObject = paramJSONObject.getJSONArray("poilist");
        if (this.jdField_a_of_type_JavaUtilArrayList == null) {
          this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
        if ((paramBundle == null) || (!paramBundle.getBoolean("refresh_all_poi"))) {
          break label250;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label229;
        }
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FacePoiManager", 2, paramJSONObject.toString());
        return;
      }
      if (i < paramJSONObject.length())
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarPOI(paramJSONObject.getJSONObject(i)));
        if ((paramInt != 0) && (i == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        }
      }
      else
      {
        this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager$FacePoiListener.a(true, bool, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI);
        return;
        this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager$FacePoiListener.a(false, false, null, null);
        return;
        label229:
        i = 0;
        continue;
      }
      i += 1;
      continue;
      label244:
      boolean bool = false;
      continue;
      label250:
      paramInt = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b("FacePoiManager", "requestSosoPoi");
    this.jdField_a_of_type_DovComQqImCapturePoiFacePoiManager$FacePoiListener.a(2, new String[0]);
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new anne(this, "NewStoryTakeVideoActivity", paramBoolean);
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null)
    {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      EditVideoPoiPickerCallback localEditVideoPoiPickerCallback = (EditVideoPoiPickerCallback)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localEditVideoPoiPickerCallback != null) {
        localEditVideoPoiPickerCallback.a();
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.poi.FacePoiManager
 * JD-Core Version:    0.7.0.1
 */