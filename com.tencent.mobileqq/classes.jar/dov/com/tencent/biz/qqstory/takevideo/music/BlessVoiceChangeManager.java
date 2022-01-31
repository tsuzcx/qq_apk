package dov.com.tencent.biz.qqstory.takevideo.music;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import aolj;
import aolk;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.model.pendant.FileDownloadTask.Input;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.IndividuationConfigInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.voicechange.VoiceChangeBasicParams;
import com.tencent.mobileqq.voicechange.VoiceChangeData;
import com.tencent.mobileqq.voicechange.VoiceChangeData.IconData;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.voicechange.VoiceChangeModeParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class BlessVoiceChangeManager
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  public static final String a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static final String b;
  private static String jdField_c_of_type_JavaLangString;
  private DownloaderImp jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp = new DownloaderImp();
  private EditVideoMusic jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic;
  private EditVideoParams jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
  public final Object a;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  ArrayList b;
  private ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.sApplication.getFilesDir() + File.separator + "blessVoiceChange.json";
    jdField_b_of_type_JavaLangString = AppConstants.aK + "voiceChange/bless/";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    a();
  }
  
  public BlessVoiceChangeManager(EditVideoMusic paramEditVideoMusic, EditVideoParams paramEditVideoParams, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangObject = new Object[0];
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic = paramEditVideoMusic;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    jdField_a_of_type_AndroidOsHandler = paramHandler;
    long l = SystemClock.uptimeMillis();
    c();
    if (QLog.isColorLevel()) {
      QLog.d("BlessVoiceChangeManager", 2, "BlessVoiceChangeManager initCost:" + (SystemClock.uptimeMillis() - l));
    }
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      try
      {
        String str1 = BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/libstlport_shared.so";
        if (str1 != null)
        {
          try
          {
            System.load(str1);
            bool = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
          {
            try
            {
              System.load(jdField_c_of_type_JavaLangString);
              if (!bool) {
                continue;
              }
              jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
              if (!QLog.isColorLevel()) {
                break label198;
              }
              QLog.d("BlessVoiceChangeManager", 2, "so loadSuccess? " + bool + " ,traeSoPath:" + jdField_c_of_type_JavaLangString);
              return;
              localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
              QLog.w("BlessVoiceChangeManager", 1, "stl so load error!", localUnsatisfiedLinkError1);
              bool = false;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
            {
              QLog.w("BlessVoiceChangeManager", 1, "trae so load error!", localUnsatisfiedLinkError2);
              jdField_c_of_type_JavaLangString = null;
              bool = false;
              continue;
            }
          }
          if (VcSystemInfo.f() <= 2) {
            break label199;
          }
          str1 = "/txlib/libtraeimp-armeabi-v7a.so";
          jdField_c_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getParent() + str1;
        }
        boolean bool = true;
      }
      catch (Exception localException)
      {
        QLog.w("BlessVoiceChangeManager", 1, localException.toString(), localException);
        return;
      }
      continue;
      label198:
      return;
      label199:
      String str2 = "/txlib/libtraeimp-armeabi.so";
    }
  }
  
  private boolean a()
  {
    int k;
    Object localObject4;
    Object localObject5;
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      i = 0;
      if (i < ListenChangeVoicePanel.jdField_a_of_type_ArrayOfInt.length)
      {
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
        k = ListenChangeVoicePanel.jdField_a_of_type_ArrayOfInt[i];
        localObject4 = ListenChangeVoicePanel.jdField_a_of_type_ArrayOfJavaLangString[i];
        localObject5 = ListenChangeVoicePanel.jdField_b_of_type_ArrayOfJavaLangString[i];
        if (i >= 6) {}
        for (j = 0;; j = 2)
        {
          ((ArrayList)localObject1).add(new VoiceChangeData(k, (String)localObject4, (String)localObject5, 0, j, 1, new VoiceChangeData.IconData(ListenChangeVoicePanel.jdField_b_of_type_ArrayOfInt[i], null, null, null)));
          i += 1;
          break;
        }
      }
    }
    Object localObject1 = new File(jdField_b_of_type_JavaLangString);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {
      ((File)localObject1).mkdirs();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData start!");
    }
    localObject1 = VasQuickUpdateManager.a(BaseApplicationImpl.getApplication().getRuntime(), "blessVoiceList.json", false, null);
    int[] arrayOfInt = ListenChangeVoicePanel.jdField_a_of_type_ArrayOfInt;
    int i = 6;
    if (localObject1 == null)
    {
      QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData null == xydata");
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (VoiceChangeData)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (localObject1 != null) {
          ((VoiceChangeData)localObject1).jdField_b_of_type_Int = 0;
        }
        i += 1;
      }
      return false;
    }
    ArrayList localArrayList = new ArrayList(16);
    long l1;
    int m;
    Object localObject6;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData blessVoiceList:" + localObject1);
        }
        l1 = ((JSONObject)localObject1).getLong("timestamp");
        long l2 = System.currentTimeMillis() / 1000L;
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("VoiceChangeModels");
        m = 0;
        j = localJSONArray.length();
        if (m >= j) {
          break label1388;
        }
        try
        {
          localObject5 = localJSONArray.getJSONObject(m);
          if ((localObject5 == null) || (((JSONObject)localObject5).getJSONArray("baseInfo") == null) || (((JSONObject)localObject5).getJSONArray("baseInfo").getJSONObject(0) == null) || (((JSONObject)localObject5).getJSONArray("operateInfo") == null))
          {
            QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData JsonErr:i=" + m + ", timestamp:" + l1);
          }
          else
          {
            localObject6 = ((JSONObject)localObject5).getJSONArray("operateInfo");
            localObject4 = null;
            j = 0;
            label431:
            if (j < ((JSONArray)localObject6).length())
            {
              localObject4 = ((JSONObject)localObject5).getJSONArray("operateInfo").getJSONObject(j);
              if ((localObject4 == null) || (!((JSONObject)localObject4).has("platformID"))) {
                break label1653;
              }
              k = ((JSONObject)localObject4).getInt("platformID");
              label479:
              localObject1 = localObject4;
              if (k == 0) {
                break label1642;
              }
              localObject1 = localObject4;
              if (k == 2) {
                break label1642;
              }
              localObject1 = localObject4;
              if (k == 3) {
                break label1642;
              }
              if (!QLog.isColorLevel()) {
                break label1639;
              }
              QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData continue platformId=" + k + ", i=" + m + ", timestamp:" + l1 + ", o=" + j);
              break label1639;
            }
            if (localObject4 == null)
            {
              new JSONObject();
              if (!QLog.isColorLevel()) {
                break label1630;
              }
              QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData continue null == itemJsonOpera, i=" + m + ", timestamp:" + l1);
            }
          }
        }
        catch (Exception localException1)
        {
          QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData jsonEx:" + localException1);
        }
        Iterator localIterator;
        label810:
        localObject4 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      }
      catch (Exception localException2)
      {
        QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData jsonEx:" + localException2.getMessage());
        if (localArrayList.size() <= 0) {
          break label1536;
        }
        localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label1534;
        }
        localObject4 = (VoiceChangeData)localIterator.next();
        if (localArrayList.contains(Integer.valueOf(((VoiceChangeData)localObject4).jdField_a_of_type_Int))) {
          continue;
        }
        ((VoiceChangeData)localObject4).jdField_b_of_type_Int = 0;
        continue;
        localObject6 = ((JSONObject)localObject5).getJSONArray("baseInfo").getJSONObject(0);
        k = ((JSONObject)localObject6).getInt("voiceID");
        localArrayList.add(Integer.valueOf(k));
        j = 0;
        if (j >= arrayOfInt.length) {
          break label1625;
        }
        if (arrayOfInt[j] != k) {
          break label927;
        }
        if (j >= 0) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label1630;
        }
        QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData not in VOICE_TYPES[] out:i=" + m + ", timestamp:" + l1);
      }
      finally
      {
        if (localArrayList.size() <= 0) {
          break label1580;
        }
      }
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (VoiceChangeData)((Iterator)localObject4).next();
        if (!localArrayList.contains(Integer.valueOf(((VoiceChangeData)localObject5).jdField_a_of_type_Int))) {
          ((VoiceChangeData)localObject5).jdField_b_of_type_Int = 0;
        }
      }
      label927:
      j += 1;
    }
    Object localObject3;
    label1026:
    label1202:
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localObject3 = (VoiceChangeData)this.jdField_b_of_type_JavaUtilArrayList.get(j);
      label954:
      if (localObject3 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData null == voiceChangeData out:i=" + m + ", timestamp:" + l1);
        }
      }
      else
      {
        if (!((JSONObject)localObject4).has("isShow")) {
          break label1664;
        }
        k = ((JSONObject)localObject4).getInt("isShow");
        j = k;
        if (k != 0)
        {
          j = k;
          if (((JSONObject)localObject4).has("QQVersion"))
          {
            j = k;
            if (IndividuationConfigInfo.a(((JSONObject)localObject4).getString("QQVersion"), "7.6.8"))
            {
              k = 0;
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData Version out:i=" + m + ", timestamp:" + l1);
                j = k;
              }
            }
          }
        }
        if (j == 0)
        {
          ((VoiceChangeData)localObject3).jdField_b_of_type_Int = j;
        }
        else
        {
          if (!((JSONObject)localObject4).has("isEnable")) {
            break label1674;
          }
          if (((JSONObject)localObject4).getInt("isEnable") != 1) {
            break label1669;
          }
          j = 2;
          localObject5 = ((JSONObject)localObject6).getString("icon");
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData url Error null:");
          }
          for (;;)
          {
            ((VoiceChangeData)localObject3).jdField_b_of_type_Int = j;
            if (1 != j) {
              break;
            }
            ((VoiceChangeData)localObject3).d = 1;
            ((VoiceChangeData)localObject3).c = 0;
            if (!TextUtils.isEmpty(((JSONObject)localObject6).getString("name"))) {
              break label1362;
            }
            localObject4 = ((VoiceChangeData)localObject3).jdField_a_of_type_JavaLangString;
            label1223:
            ((VoiceChangeData)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject4);
            if (!TextUtils.isEmpty(((JSONObject)localObject6).getString("description"))) {
              break label1375;
            }
            localObject4 = ((VoiceChangeData)localObject3).jdField_b_of_type_JavaLangString;
            label1251:
            ((VoiceChangeData)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject4);
            ((VoiceChangeData)localObject3).jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_JavaLangString = ((String)localObject5);
            break label1630;
            localObject5 = ClubContentJsonTask.jdField_a_of_type_JavaLangString + (String)localObject5;
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject5);
          }
          if (!((JSONObject)localObject4).has("feeType")) {
            break label1677;
          }
          j = ((JSONObject)localObject4).getInt("feeType");
          ((VoiceChangeData)localObject3).d = j;
          if (!((JSONObject)localObject4).has("tag")) {
            break label1682;
          }
        }
      }
    }
    label1152:
    label1327:
    for (int j = ((JSONObject)localObject4).getInt("tag");; j = 0)
    {
      ((VoiceChangeData)localObject3).c = j;
      break label1202;
      label1362:
      localObject4 = ((JSONObject)localObject6).getString("name");
      break label1223;
      label1375:
      localObject4 = ((JSONObject)localObject6).getString("description");
      break label1251;
      label1388:
      if (QLog.isColorLevel()) {
        QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData run ok! validNum:" + localArrayList.size());
      }
      if (localArrayList.size() > 0)
      {
        localObject3 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (VoiceChangeData)((Iterator)localObject3).next();
          if (!localArrayList.contains(Integer.valueOf(((VoiceChangeData)localObject4).jdField_a_of_type_Int))) {
            ((VoiceChangeData)localObject4).jdField_b_of_type_Int = 0;
          }
        }
        return true;
      }
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject3 = (VoiceChangeData)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (localObject3 != null) {
          ((VoiceChangeData)localObject3).jdField_b_of_type_Int = 0;
        }
        i += 1;
      }
      return true;
      label1534:
      return true;
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject3 = (VoiceChangeData)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (localObject3 != null) {
          ((VoiceChangeData)localObject3).jdField_b_of_type_Int = 0;
        }
        i += 1;
      }
      return true;
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject4 = (VoiceChangeData)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (localObject4 != null) {
          ((VoiceChangeData)localObject4).jdField_b_of_type_Int = 0;
        }
        i += 1;
      }
      throw ((Throwable)localObject3);
      label1625:
      j = -1;
      break label810;
      label1630:
      m += 1;
      break;
      label1639:
      localObject3 = null;
      label1642:
      j += 1;
      localObject4 = localObject3;
      break label431;
      label1653:
      k = -1;
      break label479;
      localObject3 = null;
      break label954;
      k = 2;
      break label1026;
      j = 1;
      break label1152;
      break label1152;
      j = 1;
      break label1327;
    }
  }
  
  @TargetApi(11)
  private void d()
  {
    long l = SystemClock.uptimeMillis();
    String str1;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("BlessVoiceChangeManager", 1, "startDownloadVCImage url is null");
        d();
      }
    }
    else
    {
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("BlessVoiceChangeManager", 2, "startDownloadVCImage finish!");
      return;
    }
    String str2 = jdField_b_of_type_JavaLangString + str1.substring(str1.lastIndexOf("/") + 1);
    File localFile = new File(str2);
    if ((localFile.isFile()) && (localFile.exists()) && (localFile.length() > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessVoiceChangeManager", 2, "startDownloadVCImage imageFile exits: " + str2 + ",len:" + localFile.length());
      }
      d();
      return;
    }
    new aolj(this, this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp, l).executeOnExecutor(Bosses.get().getExecutor(16), new FileDownloadTask.Input[] { new FileDownloadTask.Input(str1, str2, null) });
  }
  
  protected void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    Object localObject = new Object[3];
    if (a((Object[])localObject))
    {
      String str = (String)localObject[0];
      int i = ((Integer)localObject[1]).intValue();
      ((Integer)localObject[2]).intValue();
      localObject = str.substring(0, str.lastIndexOf(".")).concat(".pcm");
      File localFile = new File((String)localObject);
      if (!localFile.exists()) {
        FileUtils.a(new File(str), localFile);
      }
      localObject = new VoiceChangeBasicParams((String)localObject, i, 64000, 2, paramQQStoryMusicInfo.c);
      VoiceChangeManager.a(BaseApplicationImpl.getContext(), (VoiceChangeBasicParams)localObject, jdField_c_of_type_JavaLangString, new aolk(paramQQStoryMusicInfo, str), new VoiceChangeModeParams(false, false, false, true, true, null));
    }
  }
  
  public boolean a(Object[] paramArrayOfObject)
  {
    String str = "";
    Object localObject = new File(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      String[] arrayOfString = ((File)localObject).list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        boolean bool1 = false;
        for (;;)
        {
          bool2 = bool1;
          localObject = str;
          if (i >= j) {
            break;
          }
          localObject = arrayOfString[i];
          if (((String)localObject).endsWith(".af"))
          {
            str = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() + File.separator + (String)localObject;
            bool1 = true;
          }
          i += 1;
        }
      }
    }
    boolean bool2 = false;
    localObject = str;
    if (paramArrayOfObject != null)
    {
      paramArrayOfObject[0] = localObject;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
      {
        paramArrayOfObject[1] = Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("audio_samplerate", 44100));
        paramArrayOfObject[2] = Integer.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("audio_channel", 1));
      }
    }
    return bool2;
  }
  
  public void b()
  {
    Object localObject = new Object[3];
    if (a((Object[])localObject))
    {
      localObject = (String)localObject[0];
      File localFile = new File(((String)localObject).substring(0, ((String)localObject).lastIndexOf(".")).concat(".pcm"));
      if (localFile.exists()) {
        FileUtils.a(localFile, new File((String)localObject));
      }
    }
  }
  
  public void c()
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("BlessVoiceChangeManager", 2, "initVoiceDatas Json. isChecked=" + bool);
    }
    if (bool) {
      d();
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        VoiceChangeData localVoiceChangeData = (VoiceChangeData)localIterator.next();
        if (localVoiceChangeData.jdField_b_of_type_Int == 2)
        {
          QQStoryMusicInfo localQQStoryMusicInfo = new QQStoryMusicInfo(4, localVoiceChangeData.jdField_a_of_type_JavaLangString, localVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_Int, localVoiceChangeData.jdField_a_of_type_Int);
          if ((localVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(localVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_JavaLangString))) {
            localQQStoryMusicInfo.h = (jdField_b_of_type_JavaLangString + localVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_JavaLangString.substring(localVoiceChangeData.jdField_a_of_type_ComTencentMobileqqVoicechangeVoiceChangeData$IconData.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1));
          }
          this.jdField_c_of_type_JavaUtilArrayList.add(localQQStoryMusicInfo);
        }
      }
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(jdField_a_of_type_AndroidOsHandler, 1, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.music.BlessVoiceChangeManager
 * JD-Core Version:    0.7.0.1
 */