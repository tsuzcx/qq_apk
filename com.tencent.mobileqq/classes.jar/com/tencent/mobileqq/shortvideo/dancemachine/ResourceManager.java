package com.tencent.mobileqq.shortvideo.dancemachine;

import aiao;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.facedancegame.ExpressionTemplateConfig;
import com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceTemplateConfig;
import com.tencent.sveffects.SLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResourceManager
{
  private static volatile ResourceManager jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager;
  public static String a;
  public static String b;
  public static String c = Environment.getExternalStorageDirectory() + "/tencent/mobileqq/capture_ptv_template/ptv_template_usable/video_niania_iOS/";
  public static String d = Environment.getExternalStorageDirectory() + "/video_niania_iOS/";
  public static String e = Environment.getExternalStorageDirectory() + "/face_dance/";
  public static String f = "/sdcard/725_so/";
  public static String g = null;
  public float a;
  public int a;
  public ResourceManager.GameNumberResource a;
  public ResourceManager.GamingResource a;
  public ResourceManager.GeneralResource a;
  public ResourceManager.LBGeneralResource a;
  public ResourceManager.ReadyResource a;
  public ResourceManager.ScanResource a;
  public ResourceManager.ShareResource a;
  public ResourceManager.StartResource a;
  private Comparator jdField_a_of_type_JavaUtilComparator = new aiao(this);
  public List a;
  private Map jdField_a_of_type_JavaUtilMap;
  public boolean a;
  private int b;
  public List b;
  private String h;
  private String i;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + "/tencent/mobileqq/capture_ptv_template/ptv_template_usable/postureRecognizeStage/";
    jdField_b_of_type_JavaLangString = Environment.getExternalStorageDirectory() + "/postureRecognizeStage/";
  }
  
  private ResourceManager()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
  }
  
  public static ResourceManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager = new ResourceManager();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager;
    }
    finally {}
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 108	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 33	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 115	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 117	java/io/BufferedReader
    //   29: dup
    //   30: new 119	java/io/FileReader
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 122	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   38: invokespecial 125	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_1
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: invokevirtual 128	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +34 -> 84
    //   53: aload_1
    //   54: astore_0
    //   55: aload_2
    //   56: aload_3
    //   57: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: goto -19 -> 42
    //   64: astore_2
    //   65: aload_1
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual 131	java/lang/Exception:printStackTrace	()V
    //   71: aload_1
    //   72: ifnull -48 -> 24
    //   75: aload_1
    //   76: invokevirtual 134	java/io/BufferedReader:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aconst_null
    //   83: areturn
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 134	java/io/BufferedReader:close	()V
    //   92: aload_2
    //   93: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: areturn
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 134	java/io/BufferedReader:close	()V
    //   108: aload_1
    //   109: athrow
    //   110: astore_0
    //   111: goto -19 -> 92
    //   114: astore_0
    //   115: goto -7 -> 108
    //   118: astore_1
    //   119: goto -19 -> 100
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -60 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   41	48	1	localBufferedReader	java.io.BufferedReader
    //   97	12	1	localObject1	Object
    //   118	1	1	localObject2	Object
    //   124	1	1	localObject3	Object
    //   16	40	2	localStringBuilder	StringBuilder
    //   64	29	2	localException1	java.lang.Exception
    //   122	1	2	localException2	java.lang.Exception
    //   48	9	3	str	String
    // Exception table:
    //   from	to	target	type
    //   44	49	64	java/lang/Exception
    //   55	61	64	java/lang/Exception
    //   75	79	81	java/lang/Exception
    //   26	42	97	finally
    //   88	92	110	java/lang/Exception
    //   104	108	114	java/lang/Exception
    //   44	49	118	finally
    //   55	61	118	finally
    //   67	71	118	finally
    //   26	42	122	java/lang/Exception
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GeneralResource = new ResourceManager.GeneralResource(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ScanResource = new ResourceManager.ScanResource(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ReadyResource = new ResourceManager.ReadyResource(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$StartResource = new ResourceManager.StartResource(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GamingResource = new ResourceManager.GamingResource(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GameNumberResource = new ResourceManager.GameNumberResource(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ShareResource = new ResourceManager.ShareResource(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = 30000;
    String str = a(new StringBuilder().append(this.i).append("params.json").toString()) + "";
    try
    {
      this.jdField_a_of_type_Int = ((int)(new JSONObject(str).getJSONObject("postureParam").optDouble("gameDuration", 30.0D) * 1000.0D));
      if (this.jdField_a_of_type_Int > 60000) {
        this.jdField_a_of_type_Int = 60000;
      }
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = 30000;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Boolean = false;
    Object localObject = a(new StringBuilder().append(this.i).append("compress.json").toString()) + "";
    try
    {
      localObject = new JSONObject((String)localObject);
      this.jdField_a_of_type_Boolean = ((JSONObject)localObject).optBoolean("isCompressed", false);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Float = ((float)((JSONObject)localObject).optDouble("compressRatio", 1.0D));
        if (this.jdField_a_of_type_Float > 1.0F) {
          this.jdField_a_of_type_Float = 1.0F;
        }
        if (this.jdField_a_of_type_Float < 0.2F) {
          this.jdField_a_of_type_Float = 0.2F;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void c(String paramString)
  {
    if (("C".equals(paramString)) && (!TextUtils.isEmpty(this.i)))
    {
      paramString = new File(this.i + "params.json");
      if (paramString.exists())
      {
        paramString.delete();
        if (SLog.a()) {
          SLog.a("DanceResMgrLog", "ResourceCheck fail, delete params file!");
        }
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    label36:
    Object localObject2;
    int j;
    label136:
    Object localObject3;
    Object localObject4;
    label224:
    Object localObject6;
    for (;;)
    {
      Object localObject1;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject1 = a(new StringBuilder().append(this.i).append("tConfig.json").toString()) + "";
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (this.jdField_b_of_type_Int != 0) {
          break label691;
        }
        localObject2 = ((JSONObject)localObject1).getJSONArray("allGestures");
        if (localObject2 == null)
        {
          return;
          this.jdField_a_of_type_JavaUtilMap.clear();
          continue;
          this.jdField_a_of_type_JavaUtilList.clear();
          break label36;
        }
        else
        {
          j = 0;
          if (j >= ((JSONArray)localObject2).length()) {
            break label475;
          }
          localObject5 = ((JSONArray)localObject2).optJSONObject(j);
          if (localObject5 == null) {
            break label1322;
          }
          localObject3 = ((JSONObject)localObject5).optString("id", "");
          localObject4 = new ResourceManager.Posture();
          ((ResourceManager.Posture)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject3);
          if (TextUtils.isEmpty(((ResourceManager.Posture)localObject4).jdField_a_of_type_JavaLangString)) {
            break label1322;
          }
          localObject5 = ((JSONObject)localObject5).optJSONArray("matchTemplate");
          ((ResourceManager.Posture)localObject4).jdField_b_of_type_JavaUtilList = new ArrayList();
          k = 0;
          if (k < ((JSONArray)localObject5).length())
          {
            localObject6 = MatchTemplateConfig.a(((JSONArray)localObject5).get(k).toString());
            if (localObject6 == null) {
              break label1329;
            }
            ((ResourceManager.Posture)localObject4).jdField_b_of_type_JavaUtilList.add(localObject6);
            break label1329;
          }
          if (((ResourceManager.Posture)localObject4).jdField_b_of_type_JavaUtilList.size() == 0) {
            break label1322;
          }
          ((ResourceManager.Posture)localObject4).jdField_b_of_type_JavaLangString = (this.i + "others/dismiss.png");
          ((ResourceManager.Posture)localObject4).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject5 = new File(this.i + "gestures/" + (String)localObject3);
          if ((!((File)localObject5).exists()) || (!((File)localObject5).isDirectory())) {
            c((String)localObject3);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
    Object localObject5 = ((File)localObject5).listFiles();
    int k = 0;
    label398:
    if (k < localObject5.length)
    {
      if (localObject5[k].isFile()) {
        ((ResourceManager.Posture)localObject4).jdField_a_of_type_JavaUtilList.add(localObject5[k].getAbsolutePath());
      }
    }
    else {
      label938:
      if (((ResourceManager.Posture)localObject4).jdField_a_of_type_JavaUtilList.size() == 0)
      {
        c((String)localObject3);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject3, localObject4);
        break label1322;
        label475:
        localObject2 = localJSONException.optJSONArray("dances");
        label691:
        label719:
        if (localObject2 != null)
        {
          j = 0;
          label491:
          if (j < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).optJSONObject(j);
            if (localObject3 == null) {
              break label1343;
            }
            localObject4 = new ResourceManager.DancePosture();
            localObject5 = ((JSONObject)localObject3).optString("gestureId", "");
            if (!this.jdField_a_of_type_JavaUtilMap.containsKey(localObject5)) {
              break label1343;
            }
            ((ResourceManager.DancePosture)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject5);
            ((ResourceManager.DancePosture)localObject4).jdField_a_of_type_Int = 0;
            ((ResourceManager.DancePosture)localObject4).jdField_a_of_type_Double = ((JSONObject)localObject3).optDouble("appearTime", 0.0D);
            if (((ResourceManager.DancePosture)localObject4).jdField_a_of_type_Double < 0.0D) {
              ((ResourceManager.DancePosture)localObject4).jdField_a_of_type_Double = 0.0D;
            }
            ((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Int = ((JSONObject)localObject3).optInt("appearCol", 0);
            if ((((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Int != 1) && (((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Int != 2)) {
              ((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Int = 1;
            }
            ((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Double = ((JSONObject)localObject3).optDouble("speed", 0.25D);
            if ((((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Double <= 0.0D) || (((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Double > 1.0D)) {
              ((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Double = 0.25D;
            }
            this.jdField_a_of_type_JavaUtilList.add(localObject4);
            break label1343;
            if (this.jdField_b_of_type_Int == 1)
            {
              localObject3 = localJSONException.getJSONArray("expressionList");
              localObject2 = new ArrayList();
              j = 0;
              if (j < ((JSONArray)localObject3).length())
              {
                localObject4 = ExpressionTemplateConfig.a(((JSONArray)localObject3).getString(j));
                if (localObject4 == null) {
                  break label1350;
                }
                ((ArrayList)localObject2).add(localObject4);
                break label1350;
              }
              localObject3 = localJSONException.getJSONArray("matchTemplate");
              j = 0;
              label766:
              if (j < ((JSONArray)localObject3).length())
              {
                localObject4 = FaceDanceTemplateConfig.a(((JSONArray)localObject3).getString(j), (List)localObject2);
                if (localObject4 == null) {
                  break label1357;
                }
                localObject5 = new ResourceManager.Posture();
                ((ResourceManager.Posture)localObject5).jdField_a_of_type_JavaLangString = ((FaceDanceTemplateConfig)localObject4).jdField_a_of_type_JavaLangString;
                if (TextUtils.isEmpty(((ResourceManager.Posture)localObject5).jdField_a_of_type_JavaLangString)) {
                  break label1357;
                }
                ((ResourceManager.Posture)localObject5).jdField_b_of_type_JavaLangString = (this.i + "others/dismiss.png");
                ((ResourceManager.Posture)localObject5).jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameFaceDanceTemplateConfig = ((FaceDanceTemplateConfig)localObject4);
                ((ResourceManager.Posture)localObject5).jdField_a_of_type_JavaUtilList = new ArrayList();
                localObject6 = new File(this.i + "gestures/" + ((FaceDanceTemplateConfig)localObject4).jdField_a_of_type_JavaLangString);
                if ((!((File)localObject6).exists()) || (!((File)localObject6).isDirectory())) {
                  break label1357;
                }
                localObject6 = ((File)localObject6).listFiles();
                k = 0;
                if (k < localObject6.length)
                {
                  if (!localObject6[k].isFile()) {
                    break label1364;
                  }
                  ((ResourceManager.Posture)localObject5).jdField_a_of_type_JavaUtilList.add(localObject6[k].getAbsolutePath());
                  break label1364;
                }
                if (((ResourceManager.Posture)localObject5).jdField_a_of_type_JavaUtilList.size() == 0) {
                  break label1357;
                }
                this.jdField_a_of_type_JavaUtilMap.put(((FaceDanceTemplateConfig)localObject4).jdField_a_of_type_JavaLangString, localObject5);
                break label1357;
              }
              localObject2 = localJSONException.getJSONArray("dances");
              j = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (j < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getJSONObject(j);
        localObject4 = new ResourceManager.DancePosture();
        localObject5 = ((JSONObject)localObject3).getString("gestureId");
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject5))
        {
          ((ResourceManager.DancePosture)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject5);
          ((ResourceManager.DancePosture)localObject4).jdField_a_of_type_Int = 1;
          ((ResourceManager.DancePosture)localObject4).jdField_a_of_type_Double = ((JSONObject)localObject3).getDouble("appearTime");
          if (((ResourceManager.DancePosture)localObject4).jdField_a_of_type_Double < 0.0D) {
            ((ResourceManager.DancePosture)localObject4).jdField_a_of_type_Double = 0.0D;
          }
          ((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Int = ((JSONObject)localObject3).getInt("appearCol");
          if ((((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Int != 1) && (((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Int != 2)) {
            ((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Int = 1;
          }
          ((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Double = ((JSONObject)localObject3).getDouble("speed");
          if ((((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Double <= 0.0D) || (((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Double > 1.0D)) {
            ((ResourceManager.DancePosture)localObject4).jdField_b_of_type_Double = 0.25D;
          }
          this.jdField_a_of_type_JavaUtilList.add(localObject4);
        }
      }
      else
      {
        if (localJSONException.optInt("randomDance", 0) != 1) {
          break;
        }
        ArrayList localArrayList = new ArrayList();
        j = 0;
        while (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          localArrayList.add(((ResourceManager.DancePosture)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_JavaLangString);
          j += 1;
        }
        Collections.shuffle(localArrayList);
        j = 0;
        while (j < localArrayList.size())
        {
          ((ResourceManager.DancePosture)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_JavaLangString = ((String)localArrayList.get(j));
          j += 1;
        }
        break;
        label1322:
        j += 1;
        break label136;
        label1329:
        k += 1;
        break label224;
        k += 1;
        break label398;
        label1343:
        j += 1;
        break label491;
        label1350:
        j += 1;
        break label719;
        label1357:
        j += 1;
        break label766;
        label1364:
        k += 1;
        break label938;
      }
      j += 1;
    }
  }
  
  private void e()
  {
    if ((!QmcfManager.e) && (this.jdField_b_of_type_Int == 0))
    {
      if (this.jdField_b_of_type_JavaUtilList != null) {
        break label97;
      }
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    Object localObject;
    for (;;)
    {
      localObject = a(new StringBuilder().append(this.i).append("lyrics.json").toString()) + "";
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"null".equals(localObject))) {
        break;
      }
      return;
      label97:
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    for (;;)
    {
      int j;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (!((JSONObject)localObject).has("lyricsList")) {
          break;
        }
        localObject = ((JSONObject)localObject).getJSONArray("lyricsList");
        j = 0;
        if (j < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(j);
          int k = localJSONObject.optInt("startTime", 0);
          int m = localJSONObject.optInt("endTime", 0);
          if (k > m) {
            break label268;
          }
          ResourceManager.LyricItem localLyricItem = new ResourceManager.LyricItem();
          localLyricItem.jdField_a_of_type_JavaLangString = localJSONObject.optString("text", "");
          localLyricItem.jdField_b_of_type_Int = k;
          localLyricItem.c = m;
          localLyricItem.jdField_a_of_type_Int = 0;
          this.jdField_b_of_type_JavaUtilList.add(localLyricItem);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      Collections.sort(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilComparator);
      return;
      label268:
      j += 1;
    }
  }
  
  public ResourceManager.Posture a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (ResourceManager.Posture)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  public String a()
  {
    return this.i;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public Map a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
    if ((this.h == null) || ("".equals(this.h))) {
      this.h = jdField_a_of_type_JavaLangString;
    }
    a();
  }
  
  public List b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GameNumberResource.jdField_a_of_type_JavaLangString);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ReadyResource.c);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ReadyResource.d);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ReadyResource.e);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$ReadyResource.jdField_b_of_type_JavaLangString);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$StartResource.jdField_b_of_type_JavaLangString);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GamingResource.p);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GamingResource.q);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GamingResource.r);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$GamingResource.s);
    return localArrayList;
  }
  
  public void b(String paramString)
  {
    this.i = paramString;
    if ((this.i == null) || ("".equals(this.i))) {
      this.i = c;
    }
    d();
    b();
    e();
    c();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$LBGeneralResource = new ResourceManager.LBGeneralResource(this);
  }
  
  public List c()
  {
    if (this.jdField_b_of_type_Int != 0) {
      return null;
    }
    return this.jdField_b_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager
 * JD-Core Version:    0.7.0.1
 */