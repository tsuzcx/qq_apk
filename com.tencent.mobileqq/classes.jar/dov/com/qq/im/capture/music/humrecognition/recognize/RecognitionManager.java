package dov.com.qq.im.capture.music.humrecognition.recognize;

import amwk;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.IQIMManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.humrecognition.HumObserver;
import dov.com.qq.im.capture.music.humrecognition.HumSubject;
import dov.com.qq.im.capture.music.humrecognition.HumUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecognitionManager
  extends IQIMManager
  implements INetEngine.INetEngineListener, HumSubject
{
  public static boolean a;
  private float jdField_a_of_type_Float;
  private MusicItemInfo jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private HumObserver jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHumObserver;
  private File jdField_a_of_type_JavaIoFile;
  private Class jdField_a_of_type_JavaLangClass;
  
  private MusicItemInfo a()
  {
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.jdField_a_of_type_JavaLangString = "无匹配";
    localMusicItemInfo.d = 7;
    return localMusicItemInfo;
  }
  
  private MusicItemInfo a(FlowMusic paramFlowMusic, String paramString)
  {
    boolean bool = true;
    String str1 = paramFlowMusic.songName;
    String str2 = paramFlowMusic.url;
    String str3 = paramFlowMusic.singerName;
    int i = paramFlowMusic.songId;
    String str4 = paramFlowMusic.songMid;
    int j = paramFlowMusic.tryBegin;
    int k = paramFlowMusic.tryEnd;
    int m = paramFlowMusic.duration;
    if ((paramFlowMusic.playable == 1) && (!TextUtils.isEmpty(paramFlowMusic.url))) {}
    for (;;)
    {
      paramFlowMusic = new MusicItemInfo(str1, str2, str3, i, str4, j, k, m, bool);
      if ((TextUtils.isEmpty(paramFlowMusic.c)) && (QLog.isColorLevel())) {
        QLog.i("RecognitionManager", 2, "recognitionResultFromFlowMusic: invoked. info: recognitionItem.mUrl = " + paramFlowMusic.c);
      }
      paramFlowMusic.jdField_a_of_type_Float = Float.valueOf(paramString).floatValue();
      paramFlowMusic.e = ((int)(paramFlowMusic.jdField_a_of_type_Float * 1000.0F) + 500);
      paramFlowMusic.f = (paramFlowMusic.e + 10000);
      paramFlowMusic.g = (paramFlowMusic.f + 10000);
      if (QLog.isColorLevel()) {
        QLog.i("RecognitionManager", 2, "recognitionResultFromFlowMusic: invoked. info: recognitionItem = " + paramFlowMusic);
      }
      return paramFlowMusic;
      bool = false;
    }
  }
  
  private String a(JSONObject paramJSONObject)
  {
    String str = "0";
    Object localObject = paramJSONObject.optJSONArray("results");
    paramJSONObject = str;
    if (localObject != null)
    {
      localObject = ((JSONArray)localObject).optJSONObject(0);
      paramJSONObject = str;
      if (localObject != null) {
        paramJSONObject = ((JSONObject)localObject).optString("offset");
      }
    }
    return paramJSONObject;
  }
  
  private List a(JSONObject paramJSONObject)
  {
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("songlist");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if (localJSONObject != null) {
          localArrayList.add(localJSONObject.optString("songmid"));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private JSONObject a(NetResp paramNetResp)
  {
    do
    {
      try
      {
        paramNetResp = new JSONObject(new String(paramNetResp.jdField_a_of_type_ArrayOfByte));
        NetResp localNetResp = paramNetResp;
        localNetResp = paramNetResp;
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.i("RecognitionManager", 2, "fetchResponseJson: invoked. info: responseJson = " + paramNetResp);
            localNetResp = paramNetResp;
          }
          return localNetResp;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        localJSONException1 = localJSONException1;
        paramNetResp = null;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecognitionManager", 2, "fetchResponseJson: Failed. info: exception = ", localJSONException1);
    return paramNetResp;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecognitionManager", 2, "requestRecognition: invoked. info: postBytes = " + paramArrayOfByte);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_JavaLangString = ("http://c.y.qq.com/youtu/humming/search?sessionid=" + System.currentTimeMillis());
    localHttpNetReq.jdField_a_of_type_Int = 1;
    localHttpNetReq.e = 0;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("is_humming").equals("yes");
  }
  
  private void b(NetResp paramNetResp)
  {
    Object localObject = a(paramNetResp);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.e("RecognitionManager", 2, new Object[] { "resolveResponseData: Failed. info: responseJson = ", localObject });
      }
    }
    List localList;
    do
    {
      return;
      paramNetResp = a((JSONObject)localObject);
      localList = a((JSONObject)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("RecognitionManager", 2, "resolveResponseData: invoked. info: songMids = " + localList);
      }
      a((JSONObject)localObject);
      localObject = (QIMMusicConfigManager)QIMManager.a(2);
      if (localList.size() != 0) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = a();
    } while (!this.jdField_a_of_type_JavaLangClass.equals(this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHumObserver.getClass()));
    d();
    return;
    ((QIMMusicConfigManager)localObject).a((String)localList.get(0), new amwk(this, paramNetResp));
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = super.a().getNetEngine(0);
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp != null)
    {
      if (paramNetResp.c != 200) {
        break label55;
      }
      b(paramNetResp);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("RecognitionManager", 2, "onResp: invoked. info: resp.mHttpCode = " + paramNetResp.c);
      }
      return;
      label55:
      ToastUtil.a().a("网络问题。HttpCode = " + paramNetResp.c);
    }
  }
  
  public void a(HumObserver paramHumObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecognitionManager", 2, "registerObserver: invoked. info: observer = " + paramHumObserver);
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHumObserver = paramHumObserver;
  }
  
  public void a(File paramFile)
  {
    if (((paramFile == null) || (!paramFile.exists())) && (QLog.isColorLevel())) {
      QLog.e("RecognitionManager", 2, "setTargetAudioFile: invoked. info: audioFile = " + paramFile);
    }
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  public void b() {}
  
  public void b(HumObserver paramHumObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecognitionManager", 2, "unregisterObserver: invoked. info: observer = " + paramHumObserver);
    }
    this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHumObserver = null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaLangClass = this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHumObserver.getClass();
    try
    {
      byte[] arrayOfByte = HumUtils.a(this.jdField_a_of_type_JavaIoFile);
      return;
    }
    catch (Throwable localThrowable1)
    {
      do
      {
        try
        {
          arrayOfByte = new AcousticFingerprint().a(this.jdField_a_of_type_Float).a(arrayOfByte);
          a(arrayOfByte);
          return;
        }
        catch (Throwable localThrowable2)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("RecognitionManager", 2, "performQQMusicInternalMethod: Failed. info: Failed to generate fingerprint. exception = ", localThrowable2);
        }
        localThrowable1 = localThrowable1;
      } while (!QLog.isColorLevel());
      QLog.e("RecognitionManager", 2, "performQQMusicInternalMethod: Failed. info: Failed to invoke HumUtils.fileToByte. exception = ", localThrowable1);
      return;
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecognitionManager", 2, "notifyObserver: invoked. info: this.mHumObserver = " + this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHumObserver);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHumObserver != null) {
      this.jdField_a_of_type_DovComQqImCaptureMusicHumrecognitionHumObserver.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.recognize.RecognitionManager
 * JD-Core Version:    0.7.0.1
 */