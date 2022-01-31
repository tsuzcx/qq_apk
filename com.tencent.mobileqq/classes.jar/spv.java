import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class spv
  implements sks
{
  private boolean a(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleAlbumEntraConfig data is null!!!");
      }
      return false;
    }
    String str = (String)paramList.get(0);
    if (str == null) {}
    for (paramList = "";; paramList = str)
    {
      urk.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleAlbumEntraConfig type: 日迹主页影集入口配置, content: \n", paramList);
      paramList = (scu)sqg.a(30);
      if ((!TextUtils.isEmpty(str)) && (str.trim().length() != 0)) {
        break;
      }
      paramList.e();
      return true;
    }
    return paramList.a(str);
  }
  
  private boolean a(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return false;
    }
    localObject1 = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      localObject2 = (String)paramList.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.videoConfig", 2, "receiveAllConfigs|type: -128,content: " + (String)localObject2 + ",version: " + paramInt);
      }
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "received TAG_STORY_VIDEO_CONFIG IGNORE THIS ACTION  because of SAME VERSION or empty content");
        i += 1;
      }
      else
      {
        localObject2 = ((String)localObject2).split("\n");
        int k = localObject2.length;
        int j = 0;
        label129:
        if (j < k)
        {
          localObject3 = localObject2[j].split("=");
          if (localObject3.length == 2) {
            break label164;
          }
        }
        for (;;)
        {
          j += 1;
          break label129;
          break;
          label164:
          ((HashMap)localObject1).put(localObject3[0].trim(), localObject3[1].trim());
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqstory.videoConfig", 2, "STORY_VIDEO_CONFIG, name=" + localObject3[0].trim() + ", val=" + localObject3[1].trim());
          }
        }
      }
    }
    paramList = (spz)sqg.a(10);
    localObject2 = (String)((HashMap)localObject1).get("key");
    localObject3 = (String)((HashMap)localObject1).get("Width");
    str1 = (String)((HashMap)localObject1).get("Height");
    str2 = (String)((HashMap)localObject1).get("Maxrate");
    str3 = (String)((HashMap)localObject1).get("Minrate");
    str4 = (String)((HashMap)localObject1).get("crf");
    str5 = (String)((HashMap)localObject1).get("qmax");
    str6 = (String)((HashMap)localObject1).get("qmin");
    str7 = (String)((HashMap)localObject1).get("qdiff");
    str8 = (String)((HashMap)localObject1).get("newWidth");
    str9 = (String)((HashMap)localObject1).get("newHeight");
    str10 = (String)((HashMap)localObject1).get("newBitRate");
    str11 = (String)((HashMap)localObject1).get("cq");
    try
    {
      if (Integer.valueOf(str11).intValue() != 0) {
        break label986;
      }
      bool = true;
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      try
      {
        paramList.b("int_high_bitrate", Integer.valueOf(Integer.valueOf(str11).intValue()));
        str11 = (String)((HashMap)localObject1).get("hprf");
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        try
        {
          if (Integer.valueOf(str11).intValue() != 1) {
            break label1073;
          }
          bool = true;
          paramList.b("boolean_need_high_profile", Boolean.valueOf(bool));
          str11 = (String)((HashMap)localObject1).get("mvs");
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          try
          {
            for (;;)
            {
              paramList.b("int_upload_video_size_limit", Integer.valueOf(Integer.valueOf(str11).intValue()));
              if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory.videoConfig", 2, "key = " + (String)localObject2 + " Width = " + (String)localObject3 + "Height = " + str1 + "Maxrate = " + str2 + "Minrate = " + str3 + " newWidth=" + str8 + " newHeight=" + str9 + " newBitRate=" + str10);
              }
              if (str8 != null) {}
              try
              {
                paramList.b("NewStoryVideoWidth", Integer.valueOf(str8));
                if (str9 != null) {
                  paramList.b("NewStoryVideoHeight", Integer.valueOf(str9));
                }
                if (str10 != null) {
                  paramList.b("NewStoryBitRate", Integer.valueOf(str10));
                }
                if (localObject2 != null) {
                  paramList.b("StoryVideoKey", localObject2);
                }
                if (localObject3 != null) {
                  paramList.b("StoryVideoWidth", Integer.valueOf((String)localObject3));
                }
                if (str1 != null) {
                  paramList.b("StoryVideoHeight", Integer.valueOf(str1));
                }
                if (str2 != null) {
                  paramList.b("StoryVideoMaxrate", Integer.valueOf(str2));
                }
                if (str3 != null) {
                  paramList.b("StoryVideoMinrate", Integer.valueOf(str3));
                }
                if (str4 != null) {
                  paramList.b("key_encode_crf", Integer.valueOf(str4));
                }
                if (str5 != null) {
                  paramList.b("key_encode_qmax", Integer.valueOf(str5));
                }
                if (str6 != null) {
                  paramList.b("key_encode_qmin", Integer.valueOf(str6));
                }
                if (str7 != null) {
                  paramList.b("key_encode_qdiff", Integer.valueOf(str7));
                }
                localObject2 = (String)((HashMap)localObject1).get("localUploadVideoSizeLimit");
                if (localObject2 != null) {
                  paramList.b("localUploadVideoSizeLimit", Integer.valueOf((String)localObject2));
                }
                localObject2 = (String)((HashMap)localObject1).get("localUploadVideoMinResolutionLimit");
                if (localObject2 != null) {
                  paramList.b("localUploadVideoMinResolutionLimit", Integer.valueOf((String)localObject2));
                }
                localObject2 = (String)((HashMap)localObject1).get("localUploadVideoDurationLimit");
                if (localObject2 != null) {
                  paramList.b("localUploadVideoDurationLimit", Integer.valueOf((String)localObject2));
                }
                localObject2 = (String)((HashMap)localObject1).get("localUploadVideoRatioLimit");
                if (localObject2 != null) {
                  paramList.b("localUploadVideoRatioLimit", Integer.valueOf((String)localObject2));
                }
                localObject2 = (String)((HashMap)localObject1).get("localUploadImageSizeLimit");
                if (localObject2 != null) {
                  paramList.b("localUploadImageSizeLimit", Integer.valueOf((String)localObject2));
                }
                localObject1 = (String)((HashMap)localObject1).get("localUploadImageMinResolutionLimit");
                if (localObject1 != null) {
                  paramList.b("localUploadImageMinResolutionLimit", Integer.valueOf((String)localObject1));
                }
              }
              catch (Exception paramList)
              {
                for (;;)
                {
                  QLog.w("Q.qqstory.videoConfig", 2, "save sp error", paramList);
                }
              }
              return true;
              boolean bool = false;
              continue;
              localNumberFormatException1 = localNumberFormatException1;
              urk.e("Q.qqstory.config.QQStoryConfigServletHandler", "get enableCqMode= " + str11 + " from json error:" + localNumberFormatException1);
              continue;
              localNumberFormatException2 = localNumberFormatException2;
              urk.e("Q.qqstory.config.QQStoryConfigServletHandler", "get highBitrate= " + str11 + " from json error:" + localNumberFormatException2);
              continue;
              bool = false;
            }
            localNumberFormatException3 = localNumberFormatException3;
            urk.e("Q.qqstory.config.QQStoryConfigServletHandler", "get codecProfile= " + str11 + " from json error:" + localNumberFormatException3);
          }
          catch (NumberFormatException localNumberFormatException4)
          {
            for (;;)
            {
              urk.e("Q.qqstory.config.QQStoryConfigServletHandler", "get maxVideoSize= " + str11 + " from json error:" + localNumberFormatException4);
            }
          }
        }
      }
    }
    paramList.b("boolean_enable_cq_mode", Boolean.valueOf(bool));
    str11 = (String)((HashMap)localObject1).get("hbr");
  }
  
  private boolean a(List<String> paramList, String paramString)
  {
    if ((paramList.isEmpty()) || (TextUtils.isEmpty(paramString))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleQzoneSync2QQStory data is null!!!");
      }
    }
    do
    {
      return false;
      urk.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleQzoneSync2QQStory config=%s", paramList);
      paramList = (String)paramList.get(0);
    } while (TextUtils.isEmpty(paramList));
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        urk.e("Q.qqstory.config.QQStoryConfigServletHandler", "handleQzoneSync2QQStory  parseLong error");
      }
    }
    LocalMultiProcConfig.putString4Uin("key_qzone_sync_to_qqstory_config", paramList, l1);
    return false;
  }
  
  private boolean b(List<String> paramList)
  {
    scu localscu = (scu)sqg.a(30);
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleAlbumConfig data is null!!! clear config");
      }
      localscu.f();
      return true;
    }
    String str = (String)paramList.get(0);
    if (str == null) {}
    for (paramList = "";; paramList = str)
    {
      urk.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleAlbumConfig type: 影集配置, content: \n", paramList);
      if ((!TextUtils.isEmpty(str)) && (str.trim().length() != 0)) {
        break;
      }
      localscu.f();
      return true;
    }
    return localscu.b(str);
  }
  
  private boolean b(List<String> paramList, int paramInt)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.videoCache", 2, "handleStoryCacheConfigCmd, configList is empty");
      }
      return false;
    }
    paramList = (String)paramList.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.videoCache", 2, "handleStoryCacheConfigCmd, version = " + paramInt + ", json = " + paramList);
    }
    return ((sqd)sqg.a(5)).a(paramList);
  }
  
  private boolean c(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleMsgTabTakeVideoNodeConfig data is null!!!");
      }
      return false;
    }
    stg localstg = (stg)QQStoryContext.a().getManager(252);
    String str = (String)paramList.get(0);
    if (str == null) {}
    for (paramList = "";; paramList = str)
    {
      urk.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleMsgTabTakeVideoNodeConfig type: 日迹拍摄配置, content: \n", paramList);
      if ((!TextUtils.isEmpty(str)) && (str.trim().length() != 0)) {
        break;
      }
      localstg.a();
      return true;
    }
    return localstg.a(str);
  }
  
  private boolean d(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handledAIOSyncToStory data is null!!!");
      }
      return false;
    }
    paramList = (String)paramList.get(0);
    urk.a("Q.qqstory.config.QQStoryConfigServletHandler", "handledAIOSyncToStory config=%s", paramList);
    if (TextUtils.isEmpty(paramList))
    {
      urk.d("Q.qqstory.config.QQStoryConfigServletHandler", "handledAIOSyncToStory content is null!!");
      bibc.b();
      return true;
    }
    try
    {
      bibc.a(paramList);
      return false;
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
      vkw.a("handledAIOSyncToStory error:" + paramList.toString(), new Object[0]);
    }
    return false;
  }
  
  private boolean e(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleStoryEditVideoConfig data is null!!!");
      }
      return false;
    }
    urk.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleStorySync2QzoneConfig config=%s", paramList);
    paramList = (String)paramList.get(0);
    if (TextUtils.isEmpty(paramList))
    {
      urk.d("Q.qqstory.config.QQStoryConfigServletHandler", "handleStorySync2QzoneConfig clear config");
      spz.c(false);
      spz.e(false);
      return true;
    }
    try
    {
      paramList = new JSONObject(paramList);
      int i = paramList.optInt("show_sync_btn");
      int j = paramList.optInt("default_status");
      urk.a("Q.qqstory.config.QQStoryConfigServletHandler", "handleStorySync2QzoneConfig showSyncBtn = %d,defaultStatus=%d", Integer.valueOf(i), Integer.valueOf(j));
      if (i == 1)
      {
        bool = true;
        spz.c(bool);
        if (j != 1) {
          break label146;
        }
      }
      label146:
      for (boolean bool = true;; bool = false)
      {
        spz.e(bool);
        return true;
        bool = false;
        break;
      }
      return false;
    }
    catch (JSONException paramList)
    {
      vkw.a("handleStorySync2QzoneConfig:" + paramList.toString(), new Object[0]);
      paramList.printStackTrace();
    }
  }
  
  private boolean f(List<String> paramList)
  {
    int j = 4;
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleStoryEditVideoConfig data is null!!!");
      }
      return false;
    }
    paramList = (String)paramList.get(0);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.editVideoConfig", 2, "handleStoryEditVideoConfig config content: " + paramList);
    }
    for (;;)
    {
      int i;
      try
      {
        paramList = (sqb)JsonORM.a(new JSONObject(paramList), sqb.class);
        localspz = (spz)sqg.a(10);
        localspz.b("boolean_enable_revert_play_mode", Boolean.valueOf(true));
        localspz.b("boolean_enable_fast_play_mode", Boolean.valueOf(true));
        localspz.b("boolean_enable_slow_play_mode", Boolean.valueOf(true));
        localspz.b("boolean_enable_hw_encode_pic_to_video", Boolean.valueOf(true));
        localspz.b("boolean_enable_flow_decode", Boolean.valueOf(true));
        localspz.b("boolean_use_flow_decode_first", Boolean.valueOf(false));
        localspz.b("key_story_home_preload_count", Integer.valueOf(4));
        localspz.b("key_story_video_preload_duration", Integer.valueOf(2));
        sqc[] arrayOfsqc;
        int k;
        if (paramList.f != null)
        {
          arrayOfsqc = paramList.f;
          k = arrayOfsqc.length;
          i = 0;
          if (i < k)
          {
            if (!arrayOfsqc[i].a()) {
              break label728;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "use flow decode first");
            localspz.b("boolean_use_flow_decode_first", Boolean.valueOf(true));
          }
        }
        if (paramList.jdField_a_of_type_ArrayOfSqc != null)
        {
          arrayOfsqc = paramList.jdField_a_of_type_ArrayOfSqc;
          k = arrayOfsqc.length;
          i = 0;
          if (i < k)
          {
            if (!arrayOfsqc[i].a()) {
              break label735;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "disable revert play mode");
            localspz.b("boolean_enable_revert_play_mode", Boolean.valueOf(false));
          }
        }
        if (paramList.jdField_b_of_type_ArrayOfSqc != null)
        {
          arrayOfsqc = paramList.jdField_b_of_type_ArrayOfSqc;
          k = arrayOfsqc.length;
          i = 0;
          if (i < k)
          {
            if (!arrayOfsqc[i].a()) {
              break label742;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "disable fast play mode");
            localspz.b("boolean_enable_fast_play_mode", Boolean.valueOf(false));
          }
        }
        if (paramList.c != null)
        {
          arrayOfsqc = paramList.c;
          k = arrayOfsqc.length;
          i = 0;
          if (i < k)
          {
            if (!arrayOfsqc[i].a()) {
              break label749;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "disable slow play mode");
            localspz.b("boolean_enable_slow_play_mode", Boolean.valueOf(false));
          }
        }
        if (paramList.d != null)
        {
          arrayOfsqc = paramList.d;
          k = arrayOfsqc.length;
          i = 0;
          if (i < k)
          {
            if (!arrayOfsqc[i].a()) {
              break label756;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "disable hw encode picToVideo");
            localspz.b("boolean_enable_hw_encode_pic_to_video", Boolean.valueOf(false));
          }
        }
        if (paramList.e != null)
        {
          arrayOfsqc = paramList.e;
          k = arrayOfsqc.length;
          i = 0;
          if (i < k)
          {
            if (!arrayOfsqc[i].a()) {
              break label763;
            }
            QLog.i("Q.qqstory.editVideoConfig", 2, "disable flow decode");
            localspz.b("boolean_enable_flow_decode", Boolean.valueOf(false));
          }
        }
        if (paramList.jdField_a_of_type_JavaLangString == null) {
          continue;
        }
        if (!"DEBUG".contains(paramList.jdField_a_of_type_JavaLangString)) {
          continue;
        }
        i = 3;
      }
      catch (JSONException paramList)
      {
        spz localspz;
        boolean bool;
        QLog.w("Q.qqstory.editVideoConfig", 2, paramList.getMessage());
        return false;
      }
      catch (JsonORM.JsonParseException paramList)
      {
        QLog.w("Q.qqstory.editVideoConfig", 2, paramList.getMessage());
        continue;
        i = -1;
        continue;
      }
      localspz.b("string_story_global_log_level", Integer.valueOf(i));
      localspz.b("string_auto_play_report_control", paramList.jdField_b_of_type_JavaLangString);
      if ((paramList.jdField_a_of_type_Int > 0) && (paramList.jdField_a_of_type_Int < 20)) {
        localspz.b("key_story_home_preload_count", Integer.valueOf(paramList.jdField_a_of_type_Int));
      }
      if ((paramList.jdField_b_of_type_Int > 0) && (paramList.jdField_b_of_type_Int < 10))
      {
        localspz.b("key_story_video_preload_duration", Integer.valueOf(paramList.jdField_b_of_type_Int));
        break label726;
        i = j;
        if ("INFO".contains(paramList.jdField_a_of_type_JavaLangString)) {
          continue;
        }
        bool = "WARN".contains(paramList.jdField_a_of_type_JavaLangString);
        if (bool)
        {
          i = 5;
          continue;
        }
      }
      label726:
      return true;
      label728:
      i += 1;
      continue;
      label735:
      i += 1;
      continue;
      label742:
      i += 1;
      continue;
      label749:
      i += 1;
      continue;
      label756:
      i += 1;
      continue;
      label763:
      i += 1;
    }
  }
  
  private boolean g(List<String> paramList)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleStoryPlayerProxyConfigCmd data is null!!!");
      }
      return false;
    }
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    paramList = (String)paramList.get(0);
    if (!TextUtils.isEmpty(paramList)) {
      baig.i(localQQAppInterface.getApp(), localQQAppInterface.c(), paramList);
    }
    for (;;)
    {
      ((sga)localQQAppInterface.getManager(181)).b(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.config.QQStoryConfigServletHandler", 2, "handleStoryPlayerProxyConfigCmd configContent = " + paramList);
      }
      return true;
      baig.i(localQQAppInterface.getApp(), localQQAppInterface.c(), null);
    }
  }
  
  private boolean h(List<String> paramList)
  {
    if (paramList.isEmpty()) {
      return false;
    }
    paramList = (String)paramList.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.config", 2, "config content: " + paramList);
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramList);
      paramList = (spz)sqg.a(10);
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("mainHallConfig");
      if (localJSONObject2 != null) {
        paramList.b("mainHallConfig", localJSONObject2.toString());
      }
      for (;;)
      {
        localJSONObject1 = localJSONObject1.optJSONObject("troopStoryHallConfig");
        if (localJSONObject1 == null) {
          break;
        }
        paramList.b("troopStoryHallConfig", localJSONObject1.toString());
        break label163;
        paramList.b("mainHallConfig", "");
      }
      paramList.b("troopStoryHallConfig", "");
    }
    catch (JSONException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.config", 2, paramList.getMessage());
      }
      return false;
    }
    label163:
    return true;
  }
  
  private boolean i(List<String> paramList)
  {
    if (paramList.isEmpty()) {
      return false;
    }
    paramList = (String)paramList.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.commonConfig", 2, "config content: " + paramList);
    }
    for (;;)
    {
      spz localspz;
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramList);
        Object localObject2 = localJSONObject.optJSONObject("certificationLink");
        localspz = (spz)sqg.a(10);
        if (localObject2 != null)
        {
          Object localObject1 = ((JSONObject)localObject2).optString("text");
          localObject2 = ((JSONObject)localObject2).optString("url");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (mpl.a((String)localObject2)))
          {
            localspz.b("CertificationLinkText", localObject1);
            localspz.b("CertificationLinkUrl", localObject2);
            localObject1 = localJSONObject.optJSONObject("localVideo");
            if (localObject1 == null) {
              break label540;
            }
            int j = ((JSONObject)localObject1).getInt("scanInterval");
            i = j;
            if (j == 0) {
              i = 1439;
            }
            localspz.b("localVideoScanInterval", String.valueOf(i));
            localObject1 = localJSONObject.optJSONObject("mainHallConfig");
            if (localObject1 == null) {
              break label554;
            }
            localspz.b("mainHallConfig", ((JSONObject)localObject1).toString());
            localObject1 = localJSONObject.optJSONObject("troopStoryHallConfig");
            if (localObject1 == null) {
              break label567;
            }
            localspz.b("troopStoryHallConfig", ((JSONObject)localObject1).toString());
            localObject1 = localJSONObject.optJSONObject("storyShareTokenConfig");
            if (localObject1 == null) {
              break label580;
            }
            if (((JSONObject)localObject1).optInt("encry", 0) == 0) {
              break label625;
            }
            bool = true;
            localspz.b("key_share_encrypt_flag", Boolean.valueOf(bool));
            localObject1 = localJSONObject.optJSONObject("createShareGroup");
            if (localObject1 == null) {
              break label595;
            }
            if (((JSONObject)localObject1).optInt("show", 1) == 0) {
              break label631;
            }
            bool = true;
            localspz.b("key_show_in_friend_story_main_page", Boolean.valueOf(bool));
            localObject1 = localJSONObject.optJSONArray("multiFragmentBlackModelList");
            if (localObject1 == null) {
              break label610;
            }
            localObject2 = Build.MODEL.toLowerCase();
            j = ((JSONArray)localObject1).length();
            localspz.b("boolean_enable_multi_video_fragment", Boolean.valueOf(true));
            i = 0;
            if (i < j)
            {
              String str = ((JSONArray)localObject1).optString(i);
              if ((!((String)localObject2).equalsIgnoreCase(str)) && (!"all".equalsIgnoreCase(str))) {
                break label637;
              }
              localspz.b("boolean_enable_multi_video_fragment", Boolean.valueOf(false));
            }
            i = localJSONObject.optInt("qim_sync_to_qq", 0);
            QLog.d("Q.qqstory.commonConfig", 2, "qim_sync_to_qq: " + paramList);
            localspz.b("key_qim_int_qim_sync_to_qq_default", Integer.valueOf(i));
            return true;
          }
          localspz.b("CertificationLinkText", "");
          localspz.b("CertificationLinkUrl", "");
          continue;
        }
        localspz.b("CertificationLinkText", "");
      }
      catch (JSONException paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.commonConfig", 2, paramList.getMessage());
        }
        return false;
      }
      localspz.b("CertificationLinkUrl", "");
      continue;
      label540:
      localspz.b("localVideoScanInterval", "1441");
      continue;
      label554:
      localspz.b("mainHallConfig", "");
      continue;
      label567:
      localspz.b("troopStoryHallConfig", "");
      continue;
      label580:
      localspz.b("key_share_encrypt_flag", Boolean.valueOf(false));
      continue;
      label595:
      localspz.b("key_show_in_friend_story_main_page", Boolean.valueOf(true));
      continue;
      label610:
      localspz.b("boolean_enable_multi_video_fragment", Boolean.valueOf(true));
      continue;
      label625:
      boolean bool = false;
      continue;
      label631:
      bool = false;
      continue;
      label637:
      i += 1;
    }
  }
  
  private boolean j(List<String> paramList)
  {
    if (paramList.isEmpty()) {
      return false;
    }
    Object localObject = (String)paramList.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.shareConfig", 2, "config content: " + (String)localObject);
    }
    paramList = (spz)sqg.a(10);
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject).optJSONObject("shareToDiscoverConfig");
        if (localObject != null)
        {
          if (((JSONObject)localObject).optInt("show") == 0) {
            break label156;
          }
          bool = true;
          paramList.b("share_to_discover_show", Boolean.valueOf(bool));
        }
        else
        {
          paramList.b("share_to_discover_show", Boolean.valueOf(false));
        }
      }
      catch (JSONException localJSONException)
      {
        paramList.b("share_to_discover_show", Boolean.valueOf(false));
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.shareConfig", 2, localJSONException.getMessage());
        }
        return false;
      }
      return true;
      label156:
      boolean bool = false;
    }
  }
  
  public boolean a(int paramInt, Intent paramIntent, ConfigurationService.Config paramConfig)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    String str = paramIntent.getStringExtra("key_uin");
    Object localObject = spz.a(paramInt);
    int i = baig.a(QQStoryContext.a().getApp(), (String)localObject, str);
    int j = paramConfig.version.get();
    localObject = amnh.a(paramConfig, i, paramInt);
    if (localObject == null) {
      return bool2;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      return a(paramInt, paramIntent, paramConfig, (List)localObject);
      bool1 = g((List)localObject);
      continue;
      bool1 = a((List)localObject, j);
      continue;
      bool1 = b((List)localObject, j);
      continue;
      bool1 = i((List)localObject);
      continue;
      bool1 = h((List)localObject);
      continue;
      bool1 = j((List)localObject);
      continue;
      bool1 = f((List)localObject);
      continue;
      bool1 = e((List)localObject);
      continue;
      bool1 = a((List)localObject, str);
      continue;
      bool1 = d((List)localObject);
      continue;
      bool1 = c((List)localObject);
      continue;
      bool1 = b((List)localObject);
      continue;
      bool1 = a((List)localObject);
    }
  }
  
  public abstract boolean a(int paramInt, Intent paramIntent, ConfigurationService.Config paramConfig, List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spv
 * JD-Core Version:    0.7.0.1
 */