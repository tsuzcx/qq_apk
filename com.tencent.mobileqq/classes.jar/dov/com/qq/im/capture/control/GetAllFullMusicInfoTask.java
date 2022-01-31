package dov.com.qq.im.capture.control;

import android.text.TextUtils;
import awgf;
import awgh;
import blqh;
import blqr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAllFullMusicInfoTask
  extends ParallGroup
{
  private QIMMusicConfigManager jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = (QIMMusicConfigManager)blqr.a(2);
  private List<FlowMusic> jdField_a_of_type_JavaUtilList;
  private List<FlowMusic> b = new ArrayList();
  private String jdField_c_of_type_JavaLangString;
  private List<FlowMusic> jdField_c_of_type_JavaUtilList = new ArrayList();
  
  private void b()
  {
    int k = 0;
    this.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_ArrayOfJavaLangObject[0]);
    Object localObject1 = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a.a(FlowMusic.class);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList((Collection)localObject1);
    }
    Object localObject2;
    for (int i = this.jdField_a_of_type_JavaUtilList.size(); QLog.isColorLevel(); i = 0)
    {
      QLog.d("GetAllFullMusicInfoTask", 2, "load db, has load local, size=" + i);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FlowMusic)((Iterator)localObject1).next();
        QLog.d("GetAllFullMusicInfoTask", 2, "load db, local music=" + localObject2);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(this.jdField_c_of_type_JavaLangString);
        if (((JSONObject)localObject1).optInt("ret", -1) != 0) {
          continue;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("song_list");
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          continue;
        }
        localObject2 = new HashSet();
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label568;
        }
        i = this.jdField_a_of_type_JavaUtilList.size();
      }
      catch (JSONException localJSONException)
      {
        int j;
        long l;
        label271:
        JSONObject localJSONObject;
        FlowMusic localFlowMusic;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("GetAllFullMusicInfoTask", 2, "can not parse json, json = " + this.jdField_c_of_type_JavaLangString, localJSONException);
        return;
      }
      j = i;
      if (((JSONArray)localObject1).length() < i) {
        j = ((JSONArray)localObject1).length();
      }
      l = System.currentTimeMillis();
      i = k;
      if (i < j)
      {
        localJSONObject = ((JSONArray)localObject1).optJSONObject(i);
        if (localJSONObject != null)
        {
          localFlowMusic = new FlowMusic();
          localFlowMusic.albumId = localJSONObject.optInt("album_id");
          localFlowMusic.albumMid = localJSONObject.optString("album_mid");
          localFlowMusic.albumName = localJSONObject.optString("album_name");
          localFlowMusic.singerId = localJSONObject.optInt("singer_id");
          localFlowMusic.singerMid = localJSONObject.optString("singer_mid");
          localFlowMusic.singerName = localJSONObject.optString("singer_name");
          localFlowMusic.songId = localJSONObject.optInt("song_id");
          localFlowMusic.songMid = localJSONObject.optString("song_mid");
          localFlowMusic.songName = localJSONObject.optString("song_name");
          localFlowMusic.songPlayTime = localJSONObject.optInt("song_play_time");
          localFlowMusic.userOwnRule = localJSONObject.optInt("user_own_rule");
          localFlowMusic.sourceType = 1;
          localFlowMusic.storeTimeStamp = (j + l - i);
          if ((!TextUtils.isEmpty(localFlowMusic.songMid)) && ((this.jdField_a_of_type_JavaUtilList == null) || (!this.jdField_a_of_type_JavaUtilList.contains(localFlowMusic)))) {
            ((Set)localObject2).add(localFlowMusic);
          }
        }
      }
      else
      {
        this.jdField_c_of_type_JavaUtilList.addAll((Collection)localObject2);
        return;
      }
      for (;;)
      {
        if (40 - i <= 20) {
          break label573;
        }
        i = 20;
        break;
        i += 1;
        break label271;
        label568:
        i = 0;
      }
      label573:
      i = 40 - i;
    }
  }
  
  private void c()
  {
    if (!this.b.isEmpty())
    {
      localObject1 = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a.a();
      try
      {
        ((awgh)localObject1).a();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          FlowMusic localFlowMusic = (FlowMusic)localIterator.next();
          this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a.b(localFlowMusic);
        }
      }
      finally
      {
        ((awgh)localObject1).b();
      }
      ((awgh)localObject1).b();
      this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(4, true, this.b);
    }
    Object localObject1 = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager;
    QIMMusicConfigManager.b(blqh.a().getCurrentAccountUin());
  }
  
  public int a()
  {
    this.d = this.jdField_c_of_type_JavaUtilList.size();
    if (!this.jdField_c_of_type_JavaUtilList.isEmpty())
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (FlowMusic)localIterator.next();
          if (this.jdField_a_of_type_Int != 8) {}
        }
        else
        {
          return 2;
        }
        Object localObject = new GetSingleFullMusicInfoTask((FlowMusic)localObject, null);
        ((AsyncStep)localObject).a = this;
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b((AsyncStep)localObject);
      }
    }
    c();
    return 7;
  }
  
  public void a()
  {
    b();
  }
  
  /* Error */
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: instanceof 276
    //   6: ifeq +34 -> 40
    //   9: aload_1
    //   10: checkcast 276	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask
    //   13: getfield 298	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask:b	Lcom/tencent/mobileqq/data/FlowMusic;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnonnull +67 -> 85
    //   21: aload_1
    //   22: checkcast 276	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask
    //   25: getfield 300	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask:a	Lcom/tencent/mobileqq/data/FlowMusic;
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 20	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:b	Ljava/util/List;
    //   33: aload_1
    //   34: invokeinterface 301 2 0
    //   39: pop
    //   40: aload_0
    //   41: getfield 272	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:d	I
    //   44: iconst_1
    //   45: isub
    //   46: istore_2
    //   47: aload_0
    //   48: iload_2
    //   49: putfield 272	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:d	I
    //   52: iload_2
    //   53: ifne +18 -> 71
    //   56: aload_0
    //   57: invokespecial 293	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:c	()V
    //   60: aload_0
    //   61: bipush 7
    //   63: invokevirtual 304	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:a	(I)V
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 307	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep	[Lcom/tencent/mobileqq/app/automator/AsyncStep;
    //   71: aload_0
    //   72: getfield 287	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   75: aload_0
    //   76: getfield 307	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep	[Lcom/tencent/mobileqq/app/automator/AsyncStep;
    //   79: invokevirtual 310	com/tencent/mobileqq/app/automator/Automator:a	([Lcom/tencent/mobileqq/app/automator/AsyncStep;)V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_3
    //   86: getfield 195	com/tencent/mobileqq/data/FlowMusic:songMid	Ljava/lang/String;
    //   89: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifeq +17 -> 109
    //   95: aload_3
    //   96: aload_1
    //   97: checkcast 276	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask
    //   100: getfield 300	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask:a	Lcom/tencent/mobileqq/data/FlowMusic;
    //   103: getfield 195	com/tencent/mobileqq/data/FlowMusic:songMid	Ljava/lang/String;
    //   106: putfield 195	com/tencent/mobileqq/data/FlowMusic:songMid	Ljava/lang/String;
    //   109: aload_3
    //   110: aload_1
    //   111: checkcast 276	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask
    //   114: getfield 300	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask:a	Lcom/tencent/mobileqq/data/FlowMusic;
    //   117: getfield 217	com/tencent/mobileqq/data/FlowMusic:storeTimeStamp	J
    //   120: putfield 217	com/tencent/mobileqq/data/FlowMusic:storeTimeStamp	J
    //   123: aload_3
    //   124: iconst_1
    //   125: putfield 213	com/tencent/mobileqq/data/FlowMusic:sourceType	I
    //   128: aload_3
    //   129: astore_1
    //   130: goto -101 -> 29
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	GetAllFullMusicInfoTask
    //   0	138	1	paramAsyncStep	AsyncStep
    //   0	138	2	paramInt	int
    //   16	113	3	localFlowMusic	FlowMusic
    // Exception table:
    //   from	to	target	type
    //   2	17	133	finally
    //   21	29	133	finally
    //   29	40	133	finally
    //   40	52	133	finally
    //   56	71	133	finally
    //   71	82	133	finally
    //   85	109	133	finally
    //   109	128	133	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.control.GetAllFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */