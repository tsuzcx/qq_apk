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
  public static String sRootDanceStageQQPath = Environment.getExternalStorageDirectory() + "/tencent/mobileqq/capture_ptv_template/ptv_template_usable/postureRecognizeStage/";
  public static String sRootDanceStageTestPath = Environment.getExternalStorageDirectory() + "/postureRecognizeStage/";
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
    sLittleBoyFilterPath = Environment.getExternalStorageDirectory() + "/tencent/mobileqq/capture_ptv_template/ptv_template_usable/video_niania_iOS/";
    sTestLittleBoyFilterPath = Environment.getExternalStorageDirectory() + "/video_niania_iOS/";
    sTestFaceLittleBoyFilterPath = Environment.getExternalStorageDirectory() + "/face_dance/";
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
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new ResourceManager();
      }
      return INSTANCE;
    }
    finally {}
  }
  
  private void parseCompressConfig()
  {
    this.compressRatio = 1.0F;
    this.isCompressed = false;
    Object localObject = readFileContent(new StringBuilder().append(this.mLittleBoyFilterRoot).append("compress.json").toString()) + "";
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
        if (this.compressRatio < 0.2F) {
          this.compressRatio = 0.2F;
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void parseLittleBoyConfig()
  {
    if (this.postures == null) {
      this.postures = new HashMap();
    }
    label36:
    Object localObject2;
    int i;
    label136:
    Object localObject3;
    Object localObject4;
    label223:
    Object localObject6;
    for (;;)
    {
      Object localObject1;
      if (this.dancePostures == null)
      {
        this.dancePostures = new ArrayList();
        localObject1 = readFileContent(new StringBuilder().append(this.mLittleBoyFilterRoot).append("tConfig.json").toString()) + "";
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (this.mPostureType != 0) {
          break label690;
        }
        localObject2 = ((JSONObject)localObject1).getJSONArray("allGestures");
        if (localObject2 == null)
        {
          return;
          this.postures.clear();
          continue;
          this.dancePostures.clear();
          break label36;
        }
        else
        {
          i = 0;
          if (i >= ((JSONArray)localObject2).length()) {
            break label474;
          }
          localObject5 = ((JSONArray)localObject2).optJSONObject(i);
          if (localObject5 == null) {
            break label1321;
          }
          localObject3 = ((JSONObject)localObject5).optString("id", "");
          localObject4 = new ResourceManager.Posture();
          ((ResourceManager.Posture)localObject4).id = ((String)localObject3);
          if (TextUtils.isEmpty(((ResourceManager.Posture)localObject4).id)) {
            break label1321;
          }
          localObject5 = ((JSONObject)localObject5).optJSONArray("matchTemplate");
          ((ResourceManager.Posture)localObject4).gestureConfigs = new ArrayList();
          j = 0;
          if (j < ((JSONArray)localObject5).length())
          {
            localObject6 = MatchTemplateConfig.parseConfig(((JSONArray)localObject5).get(j).toString());
            if (localObject6 == null) {
              break label1328;
            }
            ((ResourceManager.Posture)localObject4).gestureConfigs.add(localObject6);
            break label1328;
          }
          if (((ResourceManager.Posture)localObject4).gestureConfigs.size() == 0) {
            break label1321;
          }
          ((ResourceManager.Posture)localObject4).blastPicture = (this.mLittleBoyFilterRoot + "others/dismiss.png");
          ((ResourceManager.Posture)localObject4).danceCartoon = new ArrayList();
          localObject5 = new File(this.mLittleBoyFilterRoot + "gestures/" + (String)localObject3);
          if ((!((File)localObject5).exists()) || (!((File)localObject5).isDirectory())) {
            resourceCheck((String)localObject3);
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
    int j = 0;
    label397:
    if (j < localObject5.length)
    {
      if (localObject5[j].isFile()) {
        ((ResourceManager.Posture)localObject4).danceCartoon.add(localObject5[j].getAbsolutePath());
      }
    }
    else {
      label937:
      if (((ResourceManager.Posture)localObject4).danceCartoon.size() == 0)
      {
        resourceCheck((String)localObject3);
      }
      else
      {
        this.postures.put(localObject3, localObject4);
        break label1321;
        label474:
        localObject2 = localJSONException.optJSONArray("dances");
        label690:
        label718:
        if (localObject2 != null)
        {
          i = 0;
          label490:
          if (i < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).optJSONObject(i);
            if (localObject3 == null) {
              break label1342;
            }
            localObject4 = new ResourceManager.DancePosture();
            localObject5 = ((JSONObject)localObject3).optString("gestureId", "");
            if (!this.postures.containsKey(localObject5)) {
              break label1342;
            }
            ((ResourceManager.DancePosture)localObject4).id = ((String)localObject5);
            ((ResourceManager.DancePosture)localObject4).postureType = 0;
            ((ResourceManager.DancePosture)localObject4).appearTime = ((JSONObject)localObject3).optDouble("appearTime", 0.0D);
            if (((ResourceManager.DancePosture)localObject4).appearTime < 0.0D) {
              ((ResourceManager.DancePosture)localObject4).appearTime = 0.0D;
            }
            ((ResourceManager.DancePosture)localObject4).appearCol = ((JSONObject)localObject3).optInt("appearCol", 0);
            if ((((ResourceManager.DancePosture)localObject4).appearCol != 1) && (((ResourceManager.DancePosture)localObject4).appearCol != 2)) {
              ((ResourceManager.DancePosture)localObject4).appearCol = 1;
            }
            ((ResourceManager.DancePosture)localObject4).speed = ((JSONObject)localObject3).optDouble("speed", 0.25D);
            if ((((ResourceManager.DancePosture)localObject4).speed <= 0.0D) || (((ResourceManager.DancePosture)localObject4).speed > 1.0D)) {
              ((ResourceManager.DancePosture)localObject4).speed = 0.25D;
            }
            this.dancePostures.add(localObject4);
            break label1342;
            if (this.mPostureType == 1)
            {
              localObject3 = localJSONException.getJSONArray("expressionList");
              localObject2 = new ArrayList();
              i = 0;
              if (i < ((JSONArray)localObject3).length())
              {
                localObject4 = ExpressionTemplateConfig.parseConfig(((JSONArray)localObject3).getString(i));
                if (localObject4 == null) {
                  break label1349;
                }
                ((ArrayList)localObject2).add(localObject4);
                break label1349;
              }
              localObject3 = localJSONException.getJSONArray("matchTemplate");
              i = 0;
              label765:
              if (i < ((JSONArray)localObject3).length())
              {
                localObject4 = FaceDanceTemplateConfig.parseConfig(((JSONArray)localObject3).getString(i), (List)localObject2);
                if (localObject4 == null) {
                  break label1356;
                }
                localObject5 = new ResourceManager.Posture();
                ((ResourceManager.Posture)localObject5).id = ((FaceDanceTemplateConfig)localObject4).mTemplateID;
                if (TextUtils.isEmpty(((ResourceManager.Posture)localObject5).id)) {
                  break label1356;
                }
                ((ResourceManager.Posture)localObject5).blastPicture = (this.mLittleBoyFilterRoot + "others/dismiss.png");
                ((ResourceManager.Posture)localObject5).faceDanceConfig = ((FaceDanceTemplateConfig)localObject4);
                ((ResourceManager.Posture)localObject5).danceCartoon = new ArrayList();
                localObject6 = new File(this.mLittleBoyFilterRoot + "gestures/" + ((FaceDanceTemplateConfig)localObject4).mTemplateID);
                if ((!((File)localObject6).exists()) || (!((File)localObject6).isDirectory())) {
                  break label1356;
                }
                localObject6 = ((File)localObject6).listFiles();
                j = 0;
                if (j < localObject6.length)
                {
                  if (!localObject6[j].isFile()) {
                    break label1363;
                  }
                  ((ResourceManager.Posture)localObject5).danceCartoon.add(localObject6[j].getAbsolutePath());
                  break label1363;
                }
                if (((ResourceManager.Posture)localObject5).danceCartoon.size() == 0) {
                  break label1356;
                }
                this.postures.put(((FaceDanceTemplateConfig)localObject4).mTemplateID, localObject5);
                break label1356;
              }
              localObject2 = localJSONException.getJSONArray("dances");
              i = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getJSONObject(i);
        localObject4 = new ResourceManager.DancePosture();
        localObject5 = ((JSONObject)localObject3).getString("gestureId");
        if (this.postures.containsKey(localObject5))
        {
          ((ResourceManager.DancePosture)localObject4).id = ((String)localObject5);
          ((ResourceManager.DancePosture)localObject4).postureType = 1;
          ((ResourceManager.DancePosture)localObject4).appearTime = ((JSONObject)localObject3).getDouble("appearTime");
          if (((ResourceManager.DancePosture)localObject4).appearTime < 0.0D) {
            ((ResourceManager.DancePosture)localObject4).appearTime = 0.0D;
          }
          ((ResourceManager.DancePosture)localObject4).appearCol = ((JSONObject)localObject3).getInt("appearCol");
          if ((((ResourceManager.DancePosture)localObject4).appearCol != 1) && (((ResourceManager.DancePosture)localObject4).appearCol != 2)) {
            ((ResourceManager.DancePosture)localObject4).appearCol = 1;
          }
          ((ResourceManager.DancePosture)localObject4).speed = ((JSONObject)localObject3).getDouble("speed");
          if ((((ResourceManager.DancePosture)localObject4).speed <= 0.0D) || (((ResourceManager.DancePosture)localObject4).speed > 1.0D)) {
            ((ResourceManager.DancePosture)localObject4).speed = 0.25D;
          }
          this.dancePostures.add(localObject4);
        }
      }
      else
      {
        if (localJSONException.optInt("randomDance", 0) != 1) {
          break;
        }
        ArrayList localArrayList = new ArrayList();
        i = 0;
        while (i < this.dancePostures.size())
        {
          localArrayList.add(((ResourceManager.DancePosture)this.dancePostures.get(i)).id);
          i += 1;
        }
        Collections.shuffle(localArrayList);
        i = 0;
        while (i < localArrayList.size())
        {
          ((ResourceManager.DancePosture)this.dancePostures.get(i)).id = ((String)localArrayList.get(i));
          i += 1;
        }
        break;
        label1321:
        i += 1;
        break label136;
        label1328:
        j += 1;
        break label223;
        j += 1;
        break label397;
        label1342:
        i += 1;
        break label490;
        label1349:
        i += 1;
        break label718;
        label1356:
        i += 1;
        break label765;
        label1363:
        j += 1;
        break label937;
      }
      i += 1;
    }
  }
  
  private void parseLyricsConfig()
  {
    if ((!QmcfManager.isQQRun) && (this.mPostureType == 0))
    {
      if (this.mLyricsList != null) {
        break label97;
      }
      this.mLyricsList = new ArrayList();
    }
    Object localObject;
    for (;;)
    {
      localObject = readFileContent(new StringBuilder().append(this.mLittleBoyFilterRoot).append("lyrics.json").toString()) + "";
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"null".equals(localObject))) {
        break;
      }
      return;
      label97:
      this.mLyricsList.clear();
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONObject((String)localObject);
        if (!((JSONObject)localObject).has("lyricsList")) {
          break;
        }
        localObject = ((JSONObject)localObject).getJSONArray("lyricsList");
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(i);
          int j = localJSONObject.optInt("startTime", 0);
          int k = localJSONObject.optInt("endTime", 0);
          if (j > k) {
            break label268;
          }
          ResourceManager.LyricItem localLyricItem = new ResourceManager.LyricItem();
          localLyricItem.text = localJSONObject.optString("text", "");
          localLyricItem.startTime = j;
          localLyricItem.endTime = k;
          localLyricItem.status = 0;
          this.mLyricsList.add(localLyricItem);
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      Collections.sort(this.mLyricsList, this.mLyricsOrderCompare);
      return;
      label268:
      i += 1;
    }
  }
  
  private void parseParamConfig()
  {
    this.durationTime = 30000;
    String str = readFileContent(new StringBuilder().append(this.mLittleBoyFilterRoot).append("params.json").toString()) + "";
    try
    {
      this.durationTime = ((int)(new JSONObject(str).getJSONObject("postureParam").optDouble("gameDuration", 30.0D) * 1000.0D));
      if (this.durationTime > 60000) {
        this.durationTime = 60000;
      }
      if (this.durationTime <= 0) {
        this.durationTime = 30000;
      }
      return;
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
    //   8: astore_0
    //   9: new 57	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   16: astore_2
    //   17: aload_0
    //   18: invokevirtual 137	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: new 459	java/io/BufferedReader
    //   29: dup
    //   30: new 461	java/io/FileReader
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 464	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   38: invokespecial 467	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_1
    //   42: aload_1
    //   43: astore_0
    //   44: aload_1
    //   45: invokevirtual 470	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +34 -> 84
    //   53: aload_1
    //   54: astore_0
    //   55: aload_2
    //   56: aload_3
    //   57: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: goto -19 -> 42
    //   64: astore_2
    //   65: aload_1
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual 471	java/lang/Exception:printStackTrace	()V
    //   71: aload_1
    //   72: ifnull -48 -> 24
    //   75: aload_1
    //   76: invokevirtual 474	java/io/BufferedReader:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aconst_null
    //   83: areturn
    //   84: aload_1
    //   85: ifnull +7 -> 92
    //   88: aload_1
    //   89: invokevirtual 474	java/io/BufferedReader:close	()V
    //   92: aload_2
    //   93: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: areturn
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 474	java/io/BufferedReader:close	()V
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
  
  private void resourceCheck(String paramString)
  {
    if (("C".equals(paramString)) && (!TextUtils.isEmpty(this.mLittleBoyFilterRoot)))
    {
      paramString = new File(this.mLittleBoyFilterRoot + "params.json");
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
    if ((this.mLittleBoyFilterRoot == null) || ("".equals(this.mLittleBoyFilterRoot))) {
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
    if ((this.postureRecognizePath == null) || ("".equals(this.postureRecognizePath))) {
      this.postureRecognizePath = sRootDanceStageQQPath;
    }
    createDanceStageResource();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.ResourceManager
 * JD-Core Version:    0.7.0.1
 */