package com.tencent.mobileqq.voicechange.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.temp.api.IVoiceChangeTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.voicechange.IVoiceChangeHelper.IOnCompressFinish;
import com.tencent.mobileqq.voicechange.IVoiceChangeListener;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.mobileqq.voicechange.QQVoiceChangerThread;
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.mobileqq.voicechange.VoiceChangeModeParams;
import com.tencent.mobileqq.voicechange.VoiceChangeParams;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class VoiceChangeManagerImpl
  implements IVoiceChangeManager
{
  public static final String TAG = "VoiceChangeManager";
  public static String[] TagIconURLs = { null, null, null };
  public String VOICECHANGE_ROOT_DIR;
  ArrayList<String> mUrlList = new ArrayList();
  DownloadListener picDownloadListener;
  public HashMap<String, VoiceChangeParams> taskStateRecord = new HashMap();
  
  public VoiceChangeManagerImpl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("voiceChange/");
    this.VOICECHANGE_ROOT_DIR = localStringBuilder.toString();
    this.picDownloadListener = new VoiceChangeManagerImpl.1(this);
  }
  
  public String getTagIconURL(int paramInt)
  {
    if (paramInt >= 0)
    {
      String[] arrayOfString = TagIconURLs;
      if (paramInt < arrayOfString.length) {
        return arrayOfString[paramInt];
      }
    }
    return null;
  }
  
  public String getVoiceChangeRootDir()
  {
    return this.VOICECHANGE_ROOT_DIR;
  }
  
  public boolean preCheckData(ArrayList<VoiceChangeData> paramArrayList, JSONObject paramJSONObject, AppRuntime paramAppRuntime)
  {
    Object localObject4 = this;
    Object localObject3 = "name";
    Object localObject2 = "feeType";
    Object localObject1 = "platformId";
    String str = "operationInfo";
    if (paramAppRuntime == null) {
      return false;
    }
    boolean bool = ((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).isExternalStorageReady(paramAppRuntime.getApplication());
    if (!bool)
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramAppRuntime.getApplication().getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject5).append(File.separator);
      ((StringBuilder)localObject5).append("voiceChange");
      ((StringBuilder)localObject5).append(File.separator);
      ((VoiceChangeManagerImpl)localObject4).VOICECHANGE_ROOT_DIR = ((StringBuilder)localObject5).toString();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("preCheckData start haveSDCard:");
      ((StringBuilder)localObject5).append(bool);
      ((StringBuilder)localObject5).append(", path=");
      ((StringBuilder)localObject5).append(((VoiceChangeManagerImpl)localObject4).VOICECHANGE_ROOT_DIR);
      QLog.d("VoiceChangeManager", 2, ((StringBuilder)localObject5).toString());
    }
    Object localObject5 = new File(((VoiceChangeManagerImpl)localObject4).VOICECHANGE_ROOT_DIR);
    if ((!((File)localObject5).exists()) || (!((File)localObject5).isDirectory())) {
      ((File)localObject5).mkdirs();
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceChangeManager", 2, "preCheckData start");
    }
    JSONObject localJSONObject1;
    if (paramJSONObject == null) {
      localJSONObject1 = VasUpdateUtil.a(paramAppRuntime, "changeVoice_json", false, null);
    } else {
      localJSONObject1 = paramJSONObject;
    }
    paramAppRuntime = IVoiceTuneUtil.VOICE_TYPES;
    if (localJSONObject1 == null)
    {
      QLog.e("VoiceChangeManager", 1, "preCheckData null == xydata");
      return false;
    }
    localObject5 = localObject4;
    int j;
    int i;
    label396:
    int k;
    label443:
    label970:
    try
    {
      l1 = localJSONObject1.optLong("timestamp", 0L);
      localObject5 = localObject4;
      long l2 = System.currentTimeMillis() / 1000L;
      localObject5 = localObject4;
      JSONArray localJSONArray = localJSONObject1.getJSONArray("VoiceChangeModels");
      j = 0;
      paramJSONObject = (JSONObject)localObject4;
      localObject7 = paramArrayList;
      localObject5 = paramJSONObject;
      if (j < localJSONArray.length())
      {
        localObject5 = paramJSONObject;
        localObject8 = localJSONArray.getJSONObject(j);
        if (localObject8 == null) {
          break label1854;
        }
        localObject5 = paramJSONObject;
        if (((JSONObject)localObject8).getJSONArray("baseInfo") == null) {
          break label1854;
        }
        localObject5 = paramJSONObject;
        if (((JSONObject)localObject8).getJSONArray("baseInfo").getJSONObject(0) == null) {
          break label1851;
        }
        localObject5 = paramJSONObject;
        if (((JSONObject)localObject8).getJSONArray(str) == null) {
          break label1851;
        }
        localObject5 = paramJSONObject;
        localObject4 = ((JSONObject)localObject8).getJSONArray(str);
        i = 0;
        paramJSONObject = null;
      }
    }
    catch (Exception paramArrayList)
    {
      long l1;
      Object localObject7;
      Object localObject8;
      Object localObject6;
      JSONObject localJSONObject2;
      label741:
      label1141:
      paramJSONObject = (JSONObject)localObject5;
    }
    label642:
    label1795:
    label1801:
    label1806:
    label1812:
    try
    {
      if (i < ((JSONArray)localObject4).length())
      {
        paramJSONObject = ((JSONObject)localObject8).getJSONArray(str).getJSONObject(i);
        if ((paramJSONObject == null) || (!paramJSONObject.has((String)localObject1))) {
          break label1766;
        }
        k = paramJSONObject.getInt((String)localObject1);
        if ((k == 0) || (k == 2)) {
          break label1777;
        }
        if (!QLog.isColorLevel()) {
          break label1772;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("preCheckData continue platformId=");
        paramJSONObject.append(k);
        paramJSONObject.append(", i=");
        paramJSONObject.append(j);
        paramJSONObject.append(", timestamp:");
        paramJSONObject.append(l1);
        paramJSONObject.append(", o=");
        paramJSONObject.append(i);
        QLog.d("VoiceChangeManager", 2, paramJSONObject.toString());
        break label1772;
      }
      localObject6 = paramJSONObject;
      if (paramJSONObject == null)
      {
        paramJSONObject = new JSONObject();
        localObject6 = paramJSONObject;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("preCheckData continue null == itemJsonOpera, i=");
          ((StringBuilder)localObject4).append(j);
          ((StringBuilder)localObject4).append(", timestamp:");
          ((StringBuilder)localObject4).append(l1);
          QLog.d("VoiceChangeManager", 2, ((StringBuilder)localObject4).toString());
          localObject6 = paramJSONObject;
        }
      }
      localJSONObject2 = ((JSONObject)localObject8).getJSONArray("baseInfo").getJSONObject(0);
      k = localJSONObject2.getInt("voiceID");
      i = 6;
      if (i >= paramAppRuntime.length) {
        break label1795;
      }
      if (paramAppRuntime[i] != k) {
        break label1786;
      }
      label661:
      if (i < 0)
      {
        if (!QLog.isColorLevel()) {
          break label1801;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("preCheckData not in VOICE_TYPES[] out:i=");
        paramJSONObject.append(j);
        paramJSONObject.append(", timestamp:");
        paramJSONObject.append(l1);
        QLog.d("VoiceChangeManager", 2, paramJSONObject.toString());
        break label1801;
      }
      if (localObject7 == null) {
        break label1806;
      }
      localObject5 = (VoiceChangeData)((ArrayList)localObject7).get(i);
      if (localObject5 == null)
      {
        if (!QLog.isColorLevel()) {
          break label1801;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("preCheckData null == voiceChangeData out:i=");
        paramJSONObject.append(j);
        paramJSONObject.append(", timestamp:");
        paramJSONObject.append(l1);
        QLog.d("VoiceChangeManager", 2, paramJSONObject.toString());
        break label1801;
      }
      if (!((JSONObject)localObject6).has("isShow")) {
        break label1812;
      }
      i = ((JSONObject)localObject6).getInt("isShow");
      label823:
      if ((i == 0) || (!((JSONObject)localObject6).has("QQVersion"))) {
        break label1824;
      }
      if (((IVoiceChangeTempApi)QRoute.api(IVoiceChangeTempApi.class)).isLaterVersion(((JSONObject)localObject6).getString("QQVersion"), "8.7.0"))
      {
        if (!QLog.isColorLevel()) {
          break label1818;
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("preCheckData Version out:i=");
        paramJSONObject.append(j);
        paramJSONObject.append(", timestamp:");
        paramJSONObject.append(l1);
        QLog.d("VoiceChangeManager", 2, paramJSONObject.toString());
        break label1818;
      }
      label918:
      localObject4 = paramAppRuntime;
      if (i == 0)
      {
        ((VoiceChangeData)localObject5).jdField_b_of_type_Int = i;
        paramJSONObject = this;
        paramAppRuntime = (AppRuntime)localObject4;
      }
      else
      {
        if (((JSONObject)localObject6).has("isEnable"))
        {
          if (((JSONObject)localObject6).getInt("isEnable") != 1) {
            break label1827;
          }
          i = 2;
        }
        localObject7 = localJSONObject2.getString("icon");
        if (TextUtils.isEmpty((CharSequence)localObject7))
        {
          QLog.e("VoiceChangeManager", 1, "preCheckData url Error null:");
        }
        else
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append(((IVoiceChangeTempApi)QRoute.api(IVoiceChangeTempApi.class)).getContentPicHost());
          paramJSONObject.append((String)localObject7);
          localObject8 = paramJSONObject.toString();
          paramAppRuntime = this;
          localObject7 = localObject8;
          paramJSONObject = paramAppRuntime;
        }
        try
        {
          if (!paramAppRuntime.mUrlList.contains(localObject8))
          {
            paramJSONObject = paramAppRuntime;
            paramAppRuntime.mUrlList.add(localObject8);
            localObject7 = localObject8;
          }
          paramAppRuntime = this;
          paramJSONObject = paramAppRuntime;
          ((VoiceChangeData)localObject5).jdField_b_of_type_Int = i;
          if (1 == i)
          {
            paramJSONObject = paramAppRuntime;
            ((VoiceChangeData)localObject5).d = 1;
            paramJSONObject = paramAppRuntime;
            ((VoiceChangeData)localObject5).c = 0;
          }
          else
          {
            localObject8 = localObject2;
            paramJSONObject = paramAppRuntime;
            if (!((JSONObject)localObject6).has((String)localObject8)) {
              break label1833;
            }
            paramJSONObject = paramAppRuntime;
            i = ((JSONObject)localObject6).getInt((String)localObject8);
            paramJSONObject = paramAppRuntime;
            ((VoiceChangeData)localObject5).d = i;
            paramJSONObject = paramAppRuntime;
            if (!((JSONObject)localObject6).has("tag")) {
              break label1839;
            }
            paramJSONObject = paramAppRuntime;
            i = ((JSONObject)localObject6).getInt("tag");
            label1178:
            paramJSONObject = paramAppRuntime;
            ((VoiceChangeData)localObject5).c = i;
          }
          localObject6 = localObject3;
          paramJSONObject = paramAppRuntime;
          if (TextUtils.isEmpty(localJSONObject2.getString((String)localObject6)))
          {
            paramJSONObject = paramAppRuntime;
            localObject6 = ((VoiceChangeData)localObject5).jdField_a_of_type_JavaLangString;
          }
          else
          {
            paramJSONObject = paramAppRuntime;
            localObject6 = localJSONObject2.getString((String)localObject6);
          }
          paramJSONObject = paramAppRuntime;
          ((VoiceChangeData)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject6);
          paramJSONObject = paramAppRuntime;
          if (TextUtils.isEmpty(localJSONObject2.getString("description")))
          {
            paramJSONObject = paramAppRuntime;
            localObject6 = ((VoiceChangeData)localObject5).jdField_b_of_type_JavaLangString;
          }
          else
          {
            paramJSONObject = paramAppRuntime;
            localObject6 = localJSONObject2.getString("description");
          }
          paramJSONObject = paramAppRuntime;
          ((VoiceChangeData)localObject5).jdField_b_of_type_JavaLangString = ((String)localObject6);
          paramJSONObject = paramAppRuntime;
          ((VoiceChangeData)localObject5).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_JavaLangString = ((String)localObject7);
          paramJSONObject = paramAppRuntime;
          paramAppRuntime = (AppRuntime)localObject4;
        }
        catch (Exception paramArrayList)
        {
          label1307:
          break label1719;
        }
        localObject4 = localObject1;
        localObject1 = paramJSONObject;
        paramJSONObject = (JSONObject)localObject1;
        localObject5 = new StringBuilder();
        paramJSONObject = (JSONObject)localObject1;
        ((StringBuilder)localObject5).append("preCheckData JsonErr:i=");
        paramJSONObject = (JSONObject)localObject1;
        ((StringBuilder)localObject5).append(j);
        paramJSONObject = (JSONObject)localObject1;
        ((StringBuilder)localObject5).append(", timestamp:");
        paramJSONObject = (JSONObject)localObject1;
        ((StringBuilder)localObject5).append(l1);
        paramJSONObject = (JSONObject)localObject1;
        QLog.e("VoiceChangeManager", 1, ((StringBuilder)localObject5).toString());
        paramJSONObject = (JSONObject)localObject1;
        localObject1 = localObject4;
      }
    }
    catch (Exception paramArrayList)
    {
      label1689:
      label1818:
      label1824:
      label1827:
      label1833:
      label1839:
      for (;;)
      {
        label1462:
        label1719:
        label1756:
        label1766:
        label1772:
        label1777:
        label1786:
        paramJSONObject = this;
      }
    }
    paramArrayList = paramJSONObject;
    paramJSONObject = paramArrayList;
    if (!TextUtils.isEmpty(TagIconURLs[0]))
    {
      paramJSONObject = paramArrayList;
      if (!TextUtils.isEmpty(TagIconURLs[1]))
      {
        paramJSONObject = paramArrayList;
        if (!TextUtils.isEmpty(TagIconURLs[2])) {
          break label1689;
        }
      }
    }
    paramJSONObject = paramArrayList;
    paramAppRuntime = localJSONObject1.getJSONArray("commmonData");
    if (paramAppRuntime != null)
    {
      paramJSONObject = paramArrayList;
      paramAppRuntime = paramAppRuntime.getJSONObject(0);
      if (paramAppRuntime != null)
      {
        paramJSONObject = paramArrayList;
        localObject1 = new String[3];
        i = 0;
        localObject1[0] = "vipIcon";
        localObject1[1] = "svipIcon";
        localObject1[2] = "activityIcon";
      }
    }
    for (;;)
    {
      paramJSONObject = paramArrayList;
      if (i < localObject1.length)
      {
        paramJSONObject = paramArrayList;
        localObject2 = paramAppRuntime.getJSONObject(localObject1[i]);
        if (localObject2 != null)
        {
          paramJSONObject = paramArrayList;
          localObject2 = ((JSONObject)localObject2).getString("src");
          paramJSONObject = paramArrayList;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            paramJSONObject = paramArrayList;
            localObject2 = new StringBuilder();
            paramJSONObject = paramArrayList;
            ((StringBuilder)localObject2).append("preCheckData common url Error null:");
            paramJSONObject = paramArrayList;
            ((StringBuilder)localObject2).append(localObject1[i]);
            paramJSONObject = paramArrayList;
            QLog.e("VoiceChangeManager", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            paramJSONObject = paramArrayList;
            localObject3 = new StringBuilder();
            paramJSONObject = paramArrayList;
            ((StringBuilder)localObject3).append(((IVoiceChangeTempApi)QRoute.api(IVoiceChangeTempApi.class)).getContentPicHost());
            paramJSONObject = paramArrayList;
            ((StringBuilder)localObject3).append((String)localObject2);
            paramJSONObject = paramArrayList;
            localObject2 = ((StringBuilder)localObject3).toString();
            paramJSONObject = paramArrayList;
            if (!paramArrayList.mUrlList.contains(localObject2))
            {
              paramJSONObject = paramArrayList;
              paramArrayList.mUrlList.add(localObject2);
            }
            paramJSONObject = paramArrayList;
            TagIconURLs[i] = localObject2;
          }
        }
      }
      else
      {
        paramJSONObject = paramArrayList;
        if (QLog.isColorLevel())
        {
          paramJSONObject = paramArrayList;
          QLog.d("VoiceChangeManager", 2, "preCheckData run ok");
        }
        break label1756;
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("preCheckData jsonEx:");
        paramAppRuntime.append(paramArrayList.getMessage());
        QLog.e("VoiceChangeManager", 1, paramAppRuntime.toString());
        paramArrayList = paramJSONObject;
        paramArrayList.picDownloadListener.onDone(null);
        return true;
        k = -1;
        break label443;
        paramJSONObject = null;
        i += 1;
        break label396;
        i += 1;
        break label642;
        i = -1;
        break label661;
        paramJSONObject = this;
        break label1857;
        localObject5 = null;
        break label741;
        i = 2;
        break label823;
        i = 0;
        break label918;
        break label918;
        i = 1;
        break label970;
        i = 1;
        break label1141;
        i = 0;
        break label1178;
        label1851:
        break label1307;
        label1854:
        break label1307;
        label1857:
        j += 1;
        break;
        paramAppRuntime = null;
        break label1462;
      }
      i += 1;
    }
  }
  
  public boolean queryStateByPath(String paramString, IVoiceChangeHelper.IOnCompressFinish paramIOnCompressFinish)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("queryStateByPath called path=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("VoiceChangeManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (VoiceChangeParams)this.taskStateRecord.get(paramString);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          paramIOnCompressFinish = new StringBuilder();
          paramIOnCompressFinish.append("no task path=");
          paramIOnCompressFinish.append(paramString);
          QLog.d("VoiceChangeManager", 2, paramIOnCompressFinish.toString());
        }
        return false;
      }
      if (((VoiceChangeParams)localObject).jdField_a_of_type_Boolean)
      {
        ((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).deleteOtherTmpFiles(paramString, ((VoiceChangeParams)localObject).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, ((VoiceChangeParams)localObject).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.f);
        this.taskStateRecord.remove(paramString);
        paramIOnCompressFinish.onCompressFinished(paramString, ((VoiceChangeParams)localObject).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e, ((VoiceChangeParams)localObject).jdField_a_of_type_Int);
        if (QLog.isColorLevel())
        {
          paramIOnCompressFinish = new StringBuilder();
          paramIOnCompressFinish.append("queryStateByPath onCompressFinished filePath=");
          paramIOnCompressFinish.append(paramString);
          paramIOnCompressFinish.append(" time=");
          paramIOnCompressFinish.append(((VoiceChangeParams)localObject).jdField_a_of_type_Int);
          paramIOnCompressFinish.append(" voiceType=");
          paramIOnCompressFinish.append(((VoiceChangeParams)localObject).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams.e);
          QLog.d("VoiceChangeManager", 2, paramIOnCompressFinish.toString());
        }
      }
      else
      {
        ((VoiceChangeParams)localObject).jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeHelper$IOnCompressFinish = paramIOnCompressFinish;
      }
      return true;
    }
    finally {}
  }
  
  public void requestToCancel(VoiceChangeBasicParams paramVoiceChangeBasicParams)
  {
    VoiceChangeParams localVoiceChangeParams = (VoiceChangeParams)this.taskStateRecord.get(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    if (localVoiceChangeParams != null)
    {
      localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.d();
      this.taskStateRecord.remove(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void requestToPause(VoiceChangeBasicParams paramVoiceChangeBasicParams)
  {
    VoiceChangeParams localVoiceChangeParams = (VoiceChangeParams)this.taskStateRecord.get(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    if (localVoiceChangeParams != null)
    {
      localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.jdField_a_of_type_Boolean = false;
      this.taskStateRecord.remove(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void requestToSend(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener)
  {
    if ((VoiceChangeParams)this.taskStateRecord.get(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString) == null) {
      requestToStart(paramContext, paramVoiceChangeBasicParams, paramString, paramIVoiceChangeListener);
    }
    ((VoiceChangeParams)this.taskStateRecord.get(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString)).jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.c();
  }
  
  public void requestToStart(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener)
  {
    requestToStart(paramContext, paramVoiceChangeBasicParams, paramString, paramIVoiceChangeListener, VoiceChangeModeParams.a());
  }
  
  public void requestToStart(Context paramContext, VoiceChangeBasicParams paramVoiceChangeBasicParams, String paramString, IVoiceChangeListener paramIVoiceChangeListener, VoiceChangeModeParams paramVoiceChangeModeParams)
  {
    VoiceChangeParams localVoiceChangeParams = (VoiceChangeParams)this.taskStateRecord.get(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString);
    if (localVoiceChangeParams != null) {
      localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.jdField_a_of_type_Boolean = false;
    }
    localVoiceChangeParams = new VoiceChangeParams();
    localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeBasicParams = paramVoiceChangeBasicParams;
    localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeModeParams = paramVoiceChangeModeParams;
    localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = new QQVoiceChangerThread(paramContext, paramVoiceChangeBasicParams, paramVoiceChangeModeParams, paramString, paramIVoiceChangeListener);
    this.taskStateRecord.put(paramVoiceChangeBasicParams.jdField_a_of_type_JavaLangString, localVoiceChangeParams);
    localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.start();
  }
  
  public void voiceChangeEnd(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramInt1 = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(paramInt1);
    VoiceChangeParams localVoiceChangeParams = (VoiceChangeParams)this.taskStateRecord.get(paramString1);
    if (localVoiceChangeParams != null)
    {
      if (localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeHelper$IOnCompressFinish != null)
      {
        ((IVoiceTuneUtil)QRoute.api(IVoiceTuneUtil.class)).deleteOtherTmpFiles(paramString1, paramString2, paramInt2);
        localVoiceChangeParams.jdField_a_of_type_ComTencentMobileqqVoicechangeIVoiceChangeHelper$IOnCompressFinish.onCompressFinished(paramString1, paramInt3, paramInt1);
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("finishedCompress onCompressFinished filePath=");
          paramString2.append(paramString1);
          paramString2.append(" time=");
          paramString2.append(paramInt1);
          paramString2.append(" changeType=");
          paramString2.append(paramInt2);
          QLog.d("VoiceChangeManager", 2, paramString2.toString());
        }
        this.taskStateRecord.remove(paramString1);
        return;
      }
      localVoiceChangeParams.jdField_a_of_type_Boolean = true;
      localVoiceChangeParams.jdField_a_of_type_Int = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.impl.VoiceChangeManagerImpl
 * JD-Core Version:    0.7.0.1
 */