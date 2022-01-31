package com.tencent.mobileqq.shortvideo.ptvfilter;

import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AESticker;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.ptvfilter.material.QQTemplateParser;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.ChildPendant;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class GroupVideoFilterList
{
  public static final int CLICK_EVENT = 3;
  public static final int HEAD_NOD = 5;
  public static final int OPEN_MOUTH = 4;
  public static final int SHAKE_HEAD = 6;
  private Map<String, VideoMaterial> activeChildrenMaterialMap;
  private Set<String> activeChildrenSet;
  private List<AESticker> activeList;
  private Map<String, VideoMaterial.ChildPendant> childrenPendantMap;
  private VideoMaterial.ChildPendant currentChild;
  private long currentChildStartTime;
  private Map<String, AESticker> filterListMap;
  private GLGestureListener gestureListener = new GroupVideoFilterList.1(this);
  private boolean mHasClicked;
  private boolean mHasHeadNodEvent;
  private boolean mHasOpenMouthEvent;
  private boolean mHasPointDownEvent;
  private boolean mHasShakeHeadEvent;
  private QQFilterRenderManager mManager = null;
  private VideoMaterial material;
  private GroupVideoFilterList.RandomHistory randomHistory;
  private List<AESticker> renderList;
  private Date today;
  
  public GroupVideoFilterList(VideoMaterial paramVideoMaterial, VideoPreviewFaceOutlineDetector paramVideoPreviewFaceOutlineDetector)
  {
    this.material = paramVideoMaterial;
    this.childrenPendantMap = new HashMap();
    this.activeList = new ArrayList();
    this.filterListMap = new HashMap();
    this.activeChildrenMaterialMap = new HashMap();
    this.activeChildrenSet = new HashSet();
    if (!new File(this.material.getDataPath() + File.separator + ".randomhistory").exists()) {
      recreateRandomHistoryFile();
    }
    this.randomHistory = readRandomHistory();
    if (paramVideoMaterial != null)
    {
      Object localObject2 = paramVideoMaterial.getChildrenPendants();
      if (localObject2 != null)
      {
        Object localObject1 = ((List)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (VideoMaterial.ChildPendant)((Iterator)localObject1).next();
          this.childrenPendantMap.put(((VideoMaterial.ChildPendant)localObject3).name, localObject3);
        }
        if (((List)localObject2).size() > 0) {
          for (localObject1 = ((VideoMaterial.ChildPendant)((List)localObject2).get(0)).name; !TextUtils.isEmpty((CharSequence)localObject1); localObject1 = getRandomNext((VideoMaterial.ChildPendant)localObject1))
          {
            this.activeChildrenSet.add(localObject1);
            localObject1 = (VideoMaterial.ChildPendant)this.childrenPendantMap.get(localObject1);
            if (((VideoMaterial.ChildPendant)localObject1).depends != null)
            {
              localObject3 = ((VideoMaterial.ChildPendant)localObject1).depends.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                String str = (String)((Iterator)localObject3).next();
                this.activeChildrenSet.add(str);
              }
            }
          }
        }
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (VideoMaterial.ChildPendant)((Iterator)localObject1).next();
          if (this.activeChildrenSet.contains(((VideoMaterial.ChildPendant)localObject2).name))
          {
            localObject3 = QQTemplateParser.parseVideoMaterial(paramVideoMaterial.getDataPath() + File.separator + ((VideoMaterial.ChildPendant)localObject2).name, "params");
            this.activeChildrenMaterialMap.put(((VideoMaterial.ChildPendant)localObject2).name, localObject3);
            localObject3 = new AESticker((VideoMaterial)localObject3, paramVideoPreviewFaceOutlineDetector);
            if (localObject3 != null)
            {
              this.filterListMap.put(((VideoMaterial.ChildPendant)localObject2).name, localObject3);
              this.activeList.add(localObject3);
            }
            if (this.currentChild == null)
            {
              this.currentChild = ((VideoMaterial.ChildPendant)localObject2);
              this.currentChildStartTime = -1L;
            }
          }
        }
      }
    }
    updateFilterList();
    GLGestureProxy.getInstance().addListener(this.gestureListener);
  }
  
  private String getRandomNext(VideoMaterial.ChildPendant paramChildPendant)
  {
    if ((paramChildPendant.next != null) && (paramChildPendant.next.size() > 0))
    {
      int i = 0;
      switch (paramChildPendant.randomType)
      {
      default: 
        i = new Random().nextInt(paramChildPendant.next.size());
        return (String)paramChildPendant.next.get(i);
      }
      Long localLong = (Long)this.randomHistory.createTime.get(paramChildPendant.name);
      if (this.today == null) {
        this.today = new Date();
      }
      long l = this.today.getTime();
      if (l - localLong.longValue() < 0L) {
        recreateRandomHistoryFile();
      }
      for (;;)
      {
        paramChildPendant = (List)this.randomHistory.randomOrder.get(paramChildPendant.name);
        if ((paramChildPendant == null) || (i >= paramChildPendant.size())) {
          break;
        }
        return (String)paramChildPendant.get(i);
        l = (l - localLong.longValue()) / 86400000L;
        if (l >= paramChildPendant.next.size()) {
          recreateRandomHistoryFile();
        } else {
          i = (int)l;
        }
      }
      return null;
    }
    return null;
  }
  
  /* Error */
  private GroupVideoFilterList.RandomHistory readRandomHistory()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 84	java/io/File
    //   5: dup
    //   6: new 86	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: getfield 63	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList:material	Lcom/tencent/ttpic/openapi/model/VideoMaterial;
    //   17: invokevirtual 93	com/tencent/ttpic/openapi/model/VideoMaterial:getDataPath	()Ljava/lang/String;
    //   20: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 101	java/io/File:separator	Ljava/lang/String;
    //   26: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 103
    //   31: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_2
    //   41: new 275	java/io/ObjectInputStream
    //   44: dup
    //   45: new 277	java/io/BufferedInputStream
    //   48: dup
    //   49: new 279	java/io/FileInputStream
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 282	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 285	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: invokespecial 286	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: aload_2
    //   67: invokevirtual 289	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   70: checkcast 243	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory
    //   73: astore_3
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 292	java/io/ObjectInputStream:close	()V
    //   82: aload_3
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   89: aload_3
    //   90: areturn
    //   91: astore_3
    //   92: aconst_null
    //   93: astore_2
    //   94: aload_2
    //   95: astore_1
    //   96: aload_3
    //   97: invokevirtual 296	java/io/FileNotFoundException:printStackTrace	()V
    //   100: aload_2
    //   101: ifnull +111 -> 212
    //   104: aload_2
    //   105: invokevirtual 292	java/io/ObjectInputStream:close	()V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_3
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_2
    //   121: astore_1
    //   122: aload_3
    //   123: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   126: aload_2
    //   127: ifnull +85 -> 212
    //   130: aload_2
    //   131: invokevirtual 292	java/io/ObjectInputStream:close	()V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_1
    //   137: aload_1
    //   138: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_3
    //   144: aconst_null
    //   145: astore_2
    //   146: aload_2
    //   147: astore_1
    //   148: aload_3
    //   149: invokevirtual 297	java/lang/ClassNotFoundException:printStackTrace	()V
    //   152: aload_2
    //   153: ifnull +59 -> 212
    //   156: aload_2
    //   157: invokevirtual 292	java/io/ObjectInputStream:close	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   167: aconst_null
    //   168: areturn
    //   169: astore_3
    //   170: aload_1
    //   171: astore_2
    //   172: aload_3
    //   173: astore_1
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 292	java/io/ObjectInputStream:close	()V
    //   182: aload_1
    //   183: athrow
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   189: goto -7 -> 182
    //   192: astore_3
    //   193: aload_1
    //   194: astore_2
    //   195: aload_3
    //   196: astore_1
    //   197: goto -23 -> 174
    //   200: astore_3
    //   201: goto -55 -> 146
    //   204: astore_3
    //   205: goto -85 -> 120
    //   208: astore_3
    //   209: goto -115 -> 94
    //   212: aconst_null
    //   213: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	GroupVideoFilterList
    //   1	65	1	localObject1	Object
    //   84	2	1	localIOException1	java.io.IOException
    //   95	1	1	localObject2	Object
    //   110	2	1	localIOException2	java.io.IOException
    //   121	1	1	localObject3	Object
    //   136	2	1	localIOException3	java.io.IOException
    //   147	1	1	localObject4	Object
    //   162	9	1	localIOException4	java.io.IOException
    //   173	24	1	localObject5	Object
    //   40	139	2	localObject6	Object
    //   184	2	2	localIOException5	java.io.IOException
    //   194	1	2	localObject7	Object
    //   73	17	3	localRandomHistory	GroupVideoFilterList.RandomHistory
    //   91	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   117	6	3	localIOException6	java.io.IOException
    //   143	6	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   169	4	3	localObject8	Object
    //   192	4	3	localObject9	Object
    //   200	1	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   204	1	3	localIOException7	java.io.IOException
    //   208	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   78	82	84	java/io/IOException
    //   41	64	91	java/io/FileNotFoundException
    //   104	108	110	java/io/IOException
    //   41	64	117	java/io/IOException
    //   130	134	136	java/io/IOException
    //   41	64	143	java/lang/ClassNotFoundException
    //   156	160	162	java/io/IOException
    //   41	64	169	finally
    //   178	182	184	java/io/IOException
    //   66	74	192	finally
    //   96	100	192	finally
    //   122	126	192	finally
    //   148	152	192	finally
    //   66	74	200	java/lang/ClassNotFoundException
    //   66	74	204	java/io/IOException
    //   66	74	208	java/io/FileNotFoundException
  }
  
  /* Error */
  private void recreateRandomHistoryFile()
  {
    // Byte code:
    //   0: new 84	java/io/File
    //   3: dup
    //   4: new 86	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: getfield 63	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList:material	Lcom/tencent/ttpic/openapi/model/VideoMaterial;
    //   15: invokevirtual 93	com/tencent/ttpic/openapi/model/VideoMaterial:getDataPath	()Ljava/lang/String;
    //   18: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: getstatic 101	java/io/File:separator	Ljava/lang/String;
    //   24: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 103
    //   29: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokespecial 109	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 300	java/io/File:deleteOnExit	()V
    //   43: aload_1
    //   44: invokevirtual 303	java/io/File:createNewFile	()Z
    //   47: pop
    //   48: aload_0
    //   49: new 243	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory
    //   52: dup
    //   53: invokespecial 304	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory:<init>	()V
    //   56: putfield 122	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList:randomHistory	Lcom/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory;
    //   59: aload_0
    //   60: getfield 122	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList:randomHistory	Lcom/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory;
    //   63: new 65	java/util/HashMap
    //   66: dup
    //   67: invokespecial 66	java/util/HashMap:<init>	()V
    //   70: putfield 265	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory:randomOrder	Ljava/util/HashMap;
    //   73: aload_0
    //   74: getfield 122	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList:randomHistory	Lcom/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory;
    //   77: new 65	java/util/HashMap
    //   80: dup
    //   81: invokespecial 66	java/util/HashMap:<init>	()V
    //   84: putfield 247	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory:createTime	Ljava/util/HashMap;
    //   87: aload_0
    //   88: getfield 63	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList:material	Lcom/tencent/ttpic/openapi/model/VideoMaterial;
    //   91: ifnull +104 -> 195
    //   94: aload_0
    //   95: getfield 63	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList:material	Lcom/tencent/ttpic/openapi/model/VideoMaterial;
    //   98: invokevirtual 126	com/tencent/ttpic/openapi/model/VideoMaterial:getChildrenPendants	()Ljava/util/List;
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +92 -> 195
    //   106: aload_2
    //   107: invokeinterface 132 1 0
    //   112: astore_2
    //   113: aload_2
    //   114: invokeinterface 137 1 0
    //   119: ifeq +158 -> 277
    //   122: aload_2
    //   123: invokeinterface 141 1 0
    //   128: checkcast 143	com/tencent/ttpic/openapi/model/VideoMaterial$ChildPendant
    //   131: astore_3
    //   132: new 70	java/util/ArrayList
    //   135: dup
    //   136: invokespecial 71	java/util/ArrayList:<init>	()V
    //   139: astore 4
    //   141: aload_3
    //   142: getfield 231	com/tencent/ttpic/openapi/model/VideoMaterial$ChildPendant:next	Ljava/util/List;
    //   145: ifnull +51 -> 196
    //   148: aload_3
    //   149: getfield 231	com/tencent/ttpic/openapi/model/VideoMaterial$ChildPendant:next	Ljava/util/List;
    //   152: invokeinterface 132 1 0
    //   157: astore 5
    //   159: aload 5
    //   161: invokeinterface 137 1 0
    //   166: ifeq +30 -> 196
    //   169: aload 4
    //   171: aload 5
    //   173: invokeinterface 141 1 0
    //   178: checkcast 180	java/lang/String
    //   181: invokeinterface 200 2 0
    //   186: pop
    //   187: goto -28 -> 159
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   195: return
    //   196: aload 4
    //   198: invokestatic 310	java/util/Collections:shuffle	(Ljava/util/List;)V
    //   201: aload_0
    //   202: getfield 122	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList:randomHistory	Lcom/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory;
    //   205: getfield 265	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory:randomOrder	Ljava/util/HashMap;
    //   208: aload_3
    //   209: getfield 146	com/tencent/ttpic/openapi/model/VideoMaterial$ChildPendant:name	Ljava/lang/String;
    //   212: aload 4
    //   214: invokevirtual 311	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   217: pop
    //   218: new 254	java/util/Date
    //   221: dup
    //   222: invokespecial 255	java/util/Date:<init>	()V
    //   225: astore 4
    //   227: new 254	java/util/Date
    //   230: dup
    //   231: aload 4
    //   233: invokevirtual 314	java/util/Date:getYear	()I
    //   236: aload 4
    //   238: invokevirtual 317	java/util/Date:getMonth	()I
    //   241: aload 4
    //   243: invokevirtual 320	java/util/Date:getDate	()I
    //   246: invokespecial 323	java/util/Date:<init>	(III)V
    //   249: astore 4
    //   251: aload_0
    //   252: getfield 122	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList:randomHistory	Lcom/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory;
    //   255: getfield 247	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory:createTime	Ljava/util/HashMap;
    //   258: aload_3
    //   259: getfield 146	com/tencent/ttpic/openapi/model/VideoMaterial$ChildPendant:name	Ljava/lang/String;
    //   262: aload 4
    //   264: invokevirtual 259	java/util/Date:getTime	()J
    //   267: invokestatic 327	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   270: invokevirtual 311	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   273: pop
    //   274: goto -161 -> 113
    //   277: aconst_null
    //   278: astore_2
    //   279: aconst_null
    //   280: astore_3
    //   281: new 329	java/io/ObjectOutputStream
    //   284: dup
    //   285: new 331	java/io/BufferedOutputStream
    //   288: dup
    //   289: new 333	java/io/FileOutputStream
    //   292: dup
    //   293: aload_1
    //   294: invokespecial 334	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   297: invokespecial 337	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   300: invokespecial 338	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   303: astore_1
    //   304: aload_1
    //   305: astore_2
    //   306: aload_1
    //   307: aload_0
    //   308: getfield 122	com/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList:randomHistory	Lcom/tencent/mobileqq/shortvideo/ptvfilter/GroupVideoFilterList$RandomHistory;
    //   311: invokevirtual 342	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   314: aload_1
    //   315: ifnull -120 -> 195
    //   318: aload_1
    //   319: invokevirtual 343	java/io/ObjectOutputStream:close	()V
    //   322: return
    //   323: astore_1
    //   324: aload_1
    //   325: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   328: return
    //   329: astore_3
    //   330: aconst_null
    //   331: astore_1
    //   332: aload_1
    //   333: astore_2
    //   334: aload_3
    //   335: invokevirtual 296	java/io/FileNotFoundException:printStackTrace	()V
    //   338: aload_1
    //   339: ifnull -144 -> 195
    //   342: aload_1
    //   343: invokevirtual 343	java/io/ObjectOutputStream:close	()V
    //   346: return
    //   347: astore_1
    //   348: aload_1
    //   349: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   352: return
    //   353: astore_2
    //   354: aload_3
    //   355: astore_1
    //   356: aload_2
    //   357: astore_3
    //   358: aload_1
    //   359: astore_2
    //   360: aload_3
    //   361: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   364: aload_1
    //   365: ifnull -170 -> 195
    //   368: aload_1
    //   369: invokevirtual 343	java/io/ObjectOutputStream:close	()V
    //   372: return
    //   373: astore_1
    //   374: aload_1
    //   375: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   378: return
    //   379: astore_1
    //   380: aload_2
    //   381: ifnull +7 -> 388
    //   384: aload_2
    //   385: invokevirtual 343	java/io/ObjectOutputStream:close	()V
    //   388: aload_1
    //   389: athrow
    //   390: astore_2
    //   391: aload_2
    //   392: invokevirtual 295	java/io/IOException:printStackTrace	()V
    //   395: goto -7 -> 388
    //   398: astore_1
    //   399: goto -19 -> 380
    //   402: astore_3
    //   403: goto -45 -> 358
    //   406: astore_3
    //   407: goto -75 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	GroupVideoFilterList
    //   38	6	1	localFile	File
    //   190	104	1	localIOException1	java.io.IOException
    //   303	16	1	localObjectOutputStream	java.io.ObjectOutputStream
    //   323	2	1	localIOException2	java.io.IOException
    //   331	12	1	localObject1	Object
    //   347	2	1	localIOException3	java.io.IOException
    //   355	14	1	localObject2	Object
    //   373	2	1	localIOException4	java.io.IOException
    //   379	10	1	localObject3	Object
    //   398	1	1	localObject4	Object
    //   101	233	2	localObject5	Object
    //   353	4	2	localIOException5	java.io.IOException
    //   359	26	2	localObject6	Object
    //   390	2	2	localIOException6	java.io.IOException
    //   131	150	3	localChildPendant	VideoMaterial.ChildPendant
    //   329	26	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   357	4	3	localIOException7	java.io.IOException
    //   402	1	3	localIOException8	java.io.IOException
    //   406	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   139	124	4	localObject7	Object
    //   157	15	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   43	48	190	java/io/IOException
    //   318	322	323	java/io/IOException
    //   281	304	329	java/io/FileNotFoundException
    //   342	346	347	java/io/IOException
    //   281	304	353	java/io/IOException
    //   368	372	373	java/io/IOException
    //   281	304	379	finally
    //   360	364	379	finally
    //   384	388	390	java/io/IOException
    //   306	314	398	finally
    //   334	338	398	finally
    //   306	314	402	java/io/IOException
    //   306	314	406	java/io/FileNotFoundException
  }
  
  private void updateFilterList()
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject2;
    if (this.currentChild != null)
    {
      localObject1 = (AESticker)this.filterListMap.get(this.currentChild.name);
      if (localObject1 != null) {
        localArrayList.add(localObject1);
      }
      if (this.currentChild.depends != null)
      {
        localObject1 = this.currentChild.depends.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = (AESticker)this.filterListMap.get(localObject2);
          if (localObject2 != null) {
            localArrayList.add(localObject2);
          }
        }
      }
    }
    Object localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      localHashSet.add((AESticker)((Iterator)localObject1).next());
    }
    if (this.renderList != null)
    {
      localObject1 = this.renderList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AESticker)((Iterator)localObject1).next();
        if (!localHashSet.contains(localObject2)) {
          ((AESticker)localObject2).destroyAudio();
        }
      }
    }
    this.renderList = new ArrayList();
    this.renderList.addAll(localArrayList);
  }
  
  public void checkAutoJump(long paramLong)
  {
    if ((this.currentChild != null) && (this.currentChild.jumpType == 2))
    {
      if ((this.currentChildStartTime != -1L) && (this.currentChild.maxPlayTime > 0L) && (paramLong - this.currentChildStartTime > this.currentChild.maxPlayTime)) {
        next(2);
      }
      if (this.currentChildStartTime == -1L) {
        this.currentChildStartTime = paramLong;
      }
    }
    for (;;)
    {
      this.mHasHeadNodEvent = false;
      this.mHasOpenMouthEvent = false;
      this.mHasShakeHeadEvent = false;
      return;
      if ((this.currentChild != null) && (this.currentChild.jumpType == 3))
      {
        if (this.mHasClicked)
        {
          next(3);
          this.mHasClicked = false;
        }
      }
      else if ((this.currentChild != null) && (this.currentChild.jumpType == 6))
      {
        if (this.mHasShakeHeadEvent)
        {
          next(6);
          this.mHasShakeHeadEvent = false;
        }
      }
      else if ((this.currentChild != null) && (this.currentChild.jumpType == 4))
      {
        if (this.mHasOpenMouthEvent)
        {
          next(4);
          this.mHasOpenMouthEvent = false;
        }
      }
      else if ((this.currentChild != null) && (this.currentChild.jumpType == 5) && (this.mHasHeadNodEvent))
      {
        next(5);
        this.mHasHeadNodEvent = false;
      }
    }
  }
  
  public void detectFaceEvent(QQFilterRenderManager paramQQFilterRenderManager)
  {
    if ((paramQQFilterRenderManager != null) && (isFaceEventDetectedNeed())) {}
    try
    {
      this.mHasOpenMouthEvent = paramQQFilterRenderManager.detectedOpenMouth();
      this.mHasShakeHeadEvent = paramQQFilterRenderManager.detectedShakeHead();
      this.mHasHeadNodEvent = paramQQFilterRenderManager.detectedHeadNod();
      this.mManager = paramQQFilterRenderManager;
      return;
    }
    catch (Exception paramQQFilterRenderManager) {}
  }
  
  protected void finalize()
  {
    super.finalize();
    try
    {
      GLGestureProxy.getInstance().removeListener(this.gestureListener);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public List<AESticker> getActiveList()
  {
    return this.activeList;
  }
  
  public List<AESticker> getRenderList()
  {
    return this.renderList;
  }
  
  public String getTriggerTips()
  {
    if (this.currentChild != null) {
      if (TextUtils.isEmpty(this.currentChild.tips))
      {
        VideoMaterial localVideoMaterial = (VideoMaterial)this.activeChildrenMaterialMap.get(this.currentChild.name);
        if (localVideoMaterial != null) {
          return localVideoMaterial.getTipsText();
        }
      }
      else
      {
        return this.currentChild.tips;
      }
    }
    return "";
  }
  
  public boolean isFaceEventDetectedNeed()
  {
    return (this.currentChild != null) && ((this.currentChild.jumpType == 6) || (this.currentChild.jumpType == 4) || (this.currentChild.jumpType == 5));
  }
  
  public void next(int paramInt)
  {
    if ((this.material != null) && (this.currentChild != null) && (this.currentChild.jumpType == paramInt))
    {
      String str = getRandomNext(this.currentChild);
      if (str != null)
      {
        Object localObject = this.material.getChildrenPendants();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            VideoMaterial.ChildPendant localChildPendant = (VideoMaterial.ChildPendant)((Iterator)localObject).next();
            if (str.equals(localChildPendant.name))
            {
              this.currentChild = localChildPendant;
              this.currentChildStartTime = -1L;
            }
          }
          updateFilterList();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.GroupVideoFilterList
 * JD-Core Version:    0.7.0.1
 */