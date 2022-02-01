package com.tencent.mobileqq.shortvideo.dancemachine;

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
  private static volatile ResourceManager INSTANCE;
  private static final String TAG = "DanceResMgrLog";
  public static String sLittleBoyFilterPath;
  public static String sRootDanceStageQQPath;
  public static String sRootDanceStageTestPath;
  public static String sTestFaceLittleBoyFilterPath;
  public static String sTestGestureDetectLibSoLocPath = null;
  public static String sTestGestureDetectLibSoPath;
  public static String sTestLittleBoyFilterPath;
  public float compressRatio = 1.0F;
  public List<ResourceManager.DancePosture> dancePostures;
  public int durationTime = 0;
  public boolean isCompressed = false;
  public ResourceManager.GameNumberResource mGameNumberResource;
  public ResourceManager.GamingResource mGamingResource;
  public ResourceManager.GeneralResource mGeneralResource;
  public ResourceManager.LBGeneralResource mLBGeneraResource;
  private String mLittleBoyFilterRoot;
  public List<ResourceManager.LyricItem> mLyricsList;
  private Comparator<ResourceManager.LyricItem> mLyricsOrderCompare = new ResourceManager.1(this);
  private int mPostureType = 0;
  public ResourceManager.ReadyResource mReadyResource;
  public ResourceManager.ScanResource mScanResource;
  public ResourceManager.ShareResource mShareResource;
  public ResourceManager.StartResource mStartResource;
  private String postureRecognizePath;
  private Map<String, ResourceManager.Posture> postures;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/tencent/mobileqq/capture_ptv_template/ptv_template_usable/postureRecognizeStage/");
    sRootDanceStageQQPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/postureRecognizeStage/");
    sRootDanceStageTestPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/tencent/mobileqq/capture_ptv_template/ptv_template_usable/video_niania_iOS/");
    sLittleBoyFilterPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/video_niania_iOS/");
    sTestLittleBoyFilterPath = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/face_dance/");
    sTestFaceLittleBoyFilterPath = localStringBuilder.toString();
    sTestGestureDetectLibSoPath = "/sdcard/725_so/";
  }
  
  private boolean checkResExist()
  {
    return new File(this.postureRecognizePath).exists();
  }
  
  private void createDanceStageResource()
  {
    this.mGeneralResource = new ResourceManager.GeneralResource(this);
    this.mScanResource = new ResourceManager.ScanResource(this);
    this.mReadyResource = new ResourceManager.ReadyResource(this);
    this.mStartResource = new ResourceManager.StartResource(this);
    this.mGamingResource = new ResourceManager.GamingResource(this);
    this.mGameNumberResource = new ResourceManager.GameNumberResource(this);
    this.mShareResource = new ResourceManager.ShareResource(this);
  }
  
  public static ResourceManager getInstance()
  {
    if (INSTANCE == null) {
      try
      {
        if (INSTANCE == null) {
          INSTANCE = new ResourceManager();
        }
      }
      finally {}
    }
    return INSTANCE;
  }
  
  private void parseCompressConfig()
  {
    this.compressRatio = 1.0F;
    this.isCompressed = false;
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mLittleBoyFilterRoot);
    localStringBuilder.append("compress.json");
    ((StringBuilder)localObject).append(readFileContent(localStringBuilder.toString()));
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      localObject = new JSONObject((String)localObject);
      this.isCompressed = ((JSONObject)localObject).optBoolean("isCompressed", false);
      if (this.isCompressed)
      {
        this.compressRatio = ((float)((JSONObject)localObject).optDouble("compressRatio", 1.0D));
        if (this.compressRatio > 1.0F) {
          this.compressRatio = 1.0F;
        }
        if (this.compressRatio < 0.2F)
        {
          this.compressRatio = 0.2F;
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void parseLittleBoyConfig()
  {
    Object localObject1 = this.postures;
    if (localObject1 == null) {
      this.postures = new HashMap();
    } else {
      ((Map)localObject1).clear();
    }
    localObject1 = this.dancePostures;
    if (localObject1 == null) {
      this.dancePostures = new ArrayList();
    } else {
      ((List)localObject1).clear();
    }
    localObject1 = new StringBuilder();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mLittleBoyFilterRoot);
    ((StringBuilder)localObject2).append("tConfig.json");
    ((StringBuilder)localObject1).append(readFileContent(((StringBuilder)localObject2).toString()));
    Object localObject5 = "";
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    label1435:
    label1438:
    label1445:
    label1452:
    label1459:
    label1466:
    label1469:
    label1476:
    label1483:
    label1490:
    label1493:
    label1496:
    label1499:
    label1506:
    for (;;)
    {
      int j;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        i = this.mPostureType;
        Object localObject3 = "matchTemplate";
        Object localObject4;
        Object localObject6;
        if (i == 0)
        {
          localObject2 = ((JSONObject)localObject1).getJSONArray("allGestures");
          if (localObject2 == null)
          {
            return;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject4 = ((JSONArray)localObject2).optJSONObject(i);
              if (localObject4 == null) {
                break label1435;
              }
              localObject6 = ((JSONObject)localObject4).optString("id", "");
              ResourceManager.Posture localPosture = new ResourceManager.Posture();
              localPosture.id = ((String)localObject6);
              if (TextUtils.isEmpty(localPosture.id)) {
                break label1435;
              }
              localObject4 = ((JSONObject)localObject4).optJSONArray((String)localObject3);
              localPosture.gestureConfigs = new ArrayList();
              j = 0;
              if (j < ((JSONArray)localObject4).length())
              {
                MatchTemplateConfig localMatchTemplateConfig = MatchTemplateConfig.parseConfig(((JSONArray)localObject4).get(j).toString());
                if (localMatchTemplateConfig == null) {
                  break label1438;
                }
                localPosture.gestureConfigs.add(localMatchTemplateConfig);
                break label1438;
              }
              if (localPosture.gestureConfigs.size() == 0) {
                break label1452;
              }
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(this.mLittleBoyFilterRoot);
              ((StringBuilder)localObject4).append("others/dismiss.png");
              localPosture.blastPicture = ((StringBuilder)localObject4).toString();
              localPosture.danceCartoon = new ArrayList();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(this.mLittleBoyFilterRoot);
              ((StringBuilder)localObject4).append("gestures/");
              ((StringBuilder)localObject4).append((String)localObject6);
              localObject4 = new File(((StringBuilder)localObject4).toString());
              if ((((File)localObject4).exists()) && (((File)localObject4).isDirectory()))
              {
                localObject4 = ((File)localObject4).listFiles();
                j = 0;
                if (j < localObject4.length)
                {
                  if (!localObject4[j].isFile()) {
                    break label1445;
                  }
                  localPosture.danceCartoon.add(localObject4[j].getAbsolutePath());
                  break label1445;
                }
                if (localPosture.danceCartoon.size() == 0)
                {
                  resourceCheck((String)localObject6);
                  break label1452;
                }
                this.postures.put(localObject6, localPosture);
                break label1452;
              }
              resourceCheck((String)localObject6);
              break label1452;
            }
            localObject4 = ((JSONObject)localObject1).optJSONArray("dances");
            localObject2 = localObject1;
            if (localObject4 == null) {
              break label1466;
            }
            i = 0;
            localObject3 = localObject5;
            localObject2 = localObject1;
            if (i >= ((JSONArray)localObject4).length()) {
              break label1466;
            }
            localObject2 = ((JSONArray)localObject4).optJSONObject(i);
            if (localObject2 == null) {
              break label1459;
            }
            localObject5 = new ResourceManager.DancePosture();
            localObject6 = ((JSONObject)localObject2).optString("gestureId", (String)localObject3);
            if (!this.postures.containsKey(localObject6)) {
              break label1459;
            }
            ((ResourceManager.DancePosture)localObject5).id = ((String)localObject6);
            ((ResourceManager.DancePosture)localObject5).postureType = 0;
            ((ResourceManager.DancePosture)localObject5).appearTime = ((JSONObject)localObject2).optDouble("appearTime", 0.0D);
            if (((ResourceManager.DancePosture)localObject5).appearTime < 0.0D) {
              ((ResourceManager.DancePosture)localObject5).appearTime = 0.0D;
            }
            ((ResourceManager.DancePosture)localObject5).appearCol = ((JSONObject)localObject2).optInt("appearCol", 0);
            if ((((ResourceManager.DancePosture)localObject5).appearCol != 1) && (((ResourceManager.DancePosture)localObject5).appearCol != 2)) {
              ((ResourceManager.DancePosture)localObject5).appearCol = 1;
            }
            ((ResourceManager.DancePosture)localObject5).speed = ((JSONObject)localObject2).optDouble("speed", 0.25D);
            if ((((ResourceManager.DancePosture)localObject5).speed <= 0.0D) || (((ResourceManager.DancePosture)localObject5).speed > 1.0D)) {
              ((ResourceManager.DancePosture)localObject5).speed = 0.25D;
            }
            this.dancePostures.add(localObject5);
            break label1459;
          }
        }
        else
        {
          localObject2 = localObject1;
          if (this.mPostureType != 1) {
            break label1506;
          }
          localObject2 = ((JSONObject)localObject1).getJSONArray("expressionList");
          localObject4 = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            localObject3 = ExpressionTemplateConfig.parseConfig(((JSONArray)localObject2).getString(i));
            if (localObject3 == null) {
              break label1469;
            }
            ((ArrayList)localObject4).add(localObject3);
            break label1469;
          }
          localObject2 = ((JSONObject)localObject1).getJSONArray("matchTemplate");
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            localObject5 = FaceDanceTemplateConfig.parseConfig(((JSONArray)localObject2).getString(i), (List)localObject4);
            if (localObject5 == null) {
              break label1483;
            }
            localObject6 = new ResourceManager.Posture();
            ((ResourceManager.Posture)localObject6).id = ((FaceDanceTemplateConfig)localObject5).mTemplateID;
            if (TextUtils.isEmpty(((ResourceManager.Posture)localObject6).id)) {
              break label1483;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(this.mLittleBoyFilterRoot);
            ((StringBuilder)localObject3).append("others/dismiss.png");
            ((ResourceManager.Posture)localObject6).blastPicture = ((StringBuilder)localObject3).toString();
            ((ResourceManager.Posture)localObject6).faceDanceConfig = ((FaceDanceTemplateConfig)localObject5);
            ((ResourceManager.Posture)localObject6).danceCartoon = new ArrayList();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(this.mLittleBoyFilterRoot);
            ((StringBuilder)localObject3).append("gestures/");
            ((StringBuilder)localObject3).append(((FaceDanceTemplateConfig)localObject5).mTemplateID);
            localObject3 = new File(((StringBuilder)localObject3).toString());
            if ((!((File)localObject3).exists()) || (!((File)localObject3).isDirectory())) {
              break label1483;
            }
            localObject3 = ((File)localObject3).listFiles();
            j = 0;
            if (j < localObject3.length)
            {
              if (!localObject3[j].isFile()) {
                break label1476;
              }
              ((ResourceManager.Posture)localObject6).danceCartoon.add(localObject3[j].getAbsolutePath());
              break label1476;
            }
            if (((ResourceManager.Posture)localObject6).danceCartoon.size() == 0) {
              break label1483;
            }
            this.postures.put(((FaceDanceTemplateConfig)localObject5).mTemplateID, localObject6);
            break label1483;
          }
          localObject3 = ((JSONObject)localObject1).getJSONArray("dances");
          i = 0;
          localObject2 = localObject1;
          if (i < ((JSONArray)localObject3).length())
          {
            localObject2 = ((JSONArray)localObject3).getJSONObject(i);
            localObject4 = new ResourceManager.DancePosture();
            localObject5 = ((JSONObject)localObject2).getString("gestureId");
            if (!this.postures.containsKey(localObject5)) {
              break label1499;
            }
            ((ResourceManager.DancePosture)localObject4).id = ((String)localObject5);
            ((ResourceManager.DancePosture)localObject4).postureType = 1;
            ((ResourceManager.DancePosture)localObject4).appearTime = ((JSONObject)localObject2).getDouble("appearTime");
            if (((ResourceManager.DancePosture)localObject4).appearTime < 0.0D) {
              ((ResourceManager.DancePosture)localObject4).appearTime = 0.0D;
            }
            ((ResourceManager.DancePosture)localObject4).appearCol = ((JSONObject)localObject2).getInt("appearCol");
            if (((ResourceManager.DancePosture)localObject4).appearCol == 1) {
              break label1490;
            }
            if (((ResourceManager.DancePosture)localObject4).appearCol != 2) {
              ((ResourceManager.DancePosture)localObject4).appearCol = 1;
            }
            ((ResourceManager.DancePosture)localObject4).speed = ((JSONObject)localObject2).getDouble("speed");
            if (((ResourceManager.DancePosture)localObject4).speed <= 0.0D) {
              break label1496;
            }
            if (((ResourceManager.DancePosture)localObject4).speed <= 1.0D) {
              break label1493;
            }
            ((ResourceManager.DancePosture)localObject4).speed = 0.25D;
            this.dancePostures.add(localObject4);
            break label1499;
          }
          j = 0;
          if (((JSONObject)localObject2).optInt("randomDance", 0) == 1)
          {
            localObject1 = new ArrayList();
            i = 0;
            if (i < this.dancePostures.size())
            {
              ((List)localObject1).add(((ResourceManager.DancePosture)this.dancePostures.get(i)).id);
              i += 1;
              continue;
            }
            Collections.shuffle((List)localObject1);
            i = j;
            if (i < ((List)localObject1).size())
            {
              ((ResourceManager.DancePosture)this.dancePostures.get(i)).id = ((String)((List)localObject1).get(i));
              i += 1;
              continue;
            }
          }
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      int i = 0;
      continue;
      break label1452;
      j += 1;
      continue;
      j += 1;
      continue;
      i += 1;
      continue;
      i += 1;
      continue;
      break label1506;
      i += 1;
      continue;
      j += 1;
      continue;
      i += 1;
      continue;
      continue;
      continue;
      continue;
      i += 1;
    }
  }
  
  private void parseLyricsConfig()
  {
    Object localObject1;
    Object localObject2;
    if ((!QmcfManager.isQQRun) && (this.mPostureType == 0))
    {
      localObject1 = this.mLyricsList;
      if (localObject1 == null) {
        this.mLyricsList = new ArrayList();
      } else {
        ((List)localObject1).clear();
      }
      localObject1 = new StringBuilder();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mLittleBoyFilterRoot);
      ((StringBuilder)localObject2).append("lyrics.json");
      ((StringBuilder)localObject1).append(readFileContent(((StringBuilder)localObject2).toString()));
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        if ("null".equals(localObject1)) {
          return;
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject1).has("lyricsList"))
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("lyricsList");
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
            int j = ((JSONObject)localObject2).optInt("startTime", 0);
            int k = ((JSONObject)localObject2).optInt("endTime", 0);
            if (j > k) {
              break label290;
            }
            ResourceManager.LyricItem localLyricItem = new ResourceManager.LyricItem();
            localLyricItem.text = ((JSONObject)localObject2).optString("text", "");
            localLyricItem.startTime = j;
            localLyricItem.endTime = k;
            localLyricItem.status = 0;
            this.mLyricsList.add(localLyricItem);
            break label290;
          }
          Collections.sort(this.mLyricsList, this.mLyricsOrderCompare);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return;
      label290:
      i += 1;
    }
  }
  
  private void parseParamConfig()
  {
    this.durationTime = 30000;
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mLittleBoyFilterRoot);
    localStringBuilder.append("params.json");
    ((StringBuilder)localObject).append(readFileContent(localStringBuilder.toString()));
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      this.durationTime = ((int)(new JSONObject((String)localObject).getJSONObject("postureParam").optDouble("gameDuration", 30.0D) * 1000.0D));
      if (this.durationTime > 60000) {
        this.durationTime = 60000;
      }
      if (this.durationTime <= 0)
      {
        this.durationTime = 30000;
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  /* Error */
  public static String readFileContent(String paramString)
  {
    // Byte code:
    //   0: new 131	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: new 57	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   16: astore_3
    //   17: aload_2
    //   18: invokevirtual 137	java/io/File:exists	()Z
    //   21: istore_1
    //   22: aconst_null
    //   23: astore_0
    //   24: iload_1
    //   25: ifne +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: new 459	java/io/BufferedReader
    //   33: dup
    //   34: new 461	java/io/FileReader
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 464	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   42: invokespecial 467	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_2
    //   46: aload_2
    //   47: astore_0
    //   48: aload_2
    //   49: invokevirtual 470	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 4
    //   54: aload 4
    //   56: ifnull +15 -> 71
    //   59: aload_2
    //   60: astore_0
    //   61: aload_3
    //   62: aload 4
    //   64: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: goto -22 -> 46
    //   71: aload_2
    //   72: invokevirtual 473	java/io/BufferedReader:close	()V
    //   75: aload_3
    //   76: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: areturn
    //   80: astore_3
    //   81: goto +14 -> 95
    //   84: astore_3
    //   85: aload_0
    //   86: astore_2
    //   87: aload_3
    //   88: astore_0
    //   89: goto +27 -> 116
    //   92: astore_3
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_2
    //   96: astore_0
    //   97: aload_3
    //   98: invokevirtual 474	java/lang/Exception:printStackTrace	()V
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 473	java/io/BufferedReader:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_3
    //   112: aload_0
    //   113: astore_2
    //   114: aload_3
    //   115: astore_0
    //   116: aload_2
    //   117: ifnull +7 -> 124
    //   120: aload_2
    //   121: invokevirtual 473	java/io/BufferedReader:close	()V
    //   124: goto +5 -> 129
    //   127: aload_0
    //   128: athrow
    //   129: goto -2 -> 127
    //   132: astore_0
    //   133: goto -58 -> 75
    //   136: astore_0
    //   137: aconst_null
    //   138: areturn
    //   139: astore_2
    //   140: goto -16 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   21	4	1	bool	boolean
    //   8	113	2	localObject1	Object
    //   139	1	2	localException1	java.lang.Exception
    //   16	60	3	localStringBuilder	StringBuilder
    //   80	1	3	localException2	java.lang.Exception
    //   84	4	3	localObject2	Object
    //   92	6	3	localException3	java.lang.Exception
    //   111	4	3	localObject3	Object
    //   52	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   48	54	80	java/lang/Exception
    //   61	68	80	java/lang/Exception
    //   30	46	84	finally
    //   30	46	92	java/lang/Exception
    //   48	54	111	finally
    //   61	68	111	finally
    //   97	101	111	finally
    //   71	75	132	java/lang/Exception
    //   105	109	136	java/lang/Exception
    //   120	124	139	java/lang/Exception
  }
  
  private void resourceCheck(String paramString)
  {
    if (("C".equals(paramString)) && (!TextUtils.isEmpty(this.mLittleBoyFilterRoot)))
    {
      paramString = new StringBuilder();
      paramString.append(this.mLittleBoyFilterRoot);
      paramString.append("params.json");
      paramString = new File(paramString.toString());
      if (paramString.exists())
      {
        paramString.delete();
        if (SLog.isEnable()) {
          SLog.e("DanceResMgrLog", "ResourceCheck fail, delete params file!");
        }
      }
    }
  }
  
  public Map<String, ResourceManager.Posture> getAllBoyPosture()
  {
    return this.postures;
  }
  
  public List<String> getAllSound()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.mGameNumberResource.scoreSound);
    localArrayList.add(this.mReadyResource.oneSound);
    localArrayList.add(this.mReadyResource.twoSound);
    localArrayList.add(this.mReadyResource.threeSound);
    localArrayList.add(this.mReadyResource.readySound);
    localArrayList.add(this.mStartResource.startSound);
    localArrayList.add(this.mGamingResource.goodSound);
    localArrayList.add(this.mGamingResource.greatSound);
    localArrayList.add(this.mGamingResource.missSound);
    localArrayList.add(this.mGamingResource.perfectSound);
    return localArrayList;
  }
  
  public List<ResourceManager.DancePosture> getDancePostures()
  {
    return this.dancePostures;
  }
  
  public String getLittleBoyFilterRootPath()
  {
    return this.mLittleBoyFilterRoot;
  }
  
  public List<ResourceManager.LyricItem> getLyricsList()
  {
    if (this.mPostureType != 0) {
      return null;
    }
    return this.mLyricsList;
  }
  
  public ResourceManager.Posture getPostureById(String paramString)
  {
    if (this.postures.containsKey(paramString)) {
      return (ResourceManager.Posture)this.postures.get(paramString);
    }
    return null;
  }
  
  public int getPostureType()
  {
    return this.mPostureType;
  }
  
  public void setLittleBoyFilterRootPath(String paramString)
  {
    this.mLittleBoyFilterRoot = paramString;
    paramString = this.mLittleBoyFilterRoot;
    if ((paramString == null) || ("".equals(paramString))) {
      this.mLittleBoyFilterRoot = sLittleBoyFilterPath;
    }
    parseLittleBoyConfig();
    parseParamConfig();
    parseLyricsConfig();
    parseCompressConfig();
    this.mLBGeneraResource = new ResourceManager.LBGeneralResource(this);
  }
  
  public void setPostureType(int paramInt)
  {
    this.mPostureType = paramInt;
  }
  
  public void setRootDanceStagePath(String paramString)
  {
    this.postureRecognizePath = paramString;
    paramString = this.postureRecognizePath;
    if ((paramString == null) || ("".equals(paramString))) {
      this.postureRecognizePath = sRootDanceStageQQPath;
    }
    createDanceStageResource();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager
 * JD-Core Version:    0.7.0.1
 */