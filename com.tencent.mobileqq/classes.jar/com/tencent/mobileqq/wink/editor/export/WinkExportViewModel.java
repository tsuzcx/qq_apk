package com.tencent.mobileqq.wink.editor.export;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkTavCutDelegate;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class WinkExportViewModel
  extends BaseViewModel
{
  private MutableLiveData<WinkExportState> a = new MutableLiveData();
  
  /* Error */
  private LocalMediaInfo a(com.tencent.tavcut.session.ICutSession paramICutSession, com.tencent.videocut.render.ComposeRenderLayer paramComposeRenderLayer, LocalMediaInfo paramLocalMediaInfo, MediaModel paramMediaModel, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 26	java/io/File
    //   3: dup
    //   4: aload_3
    //   5: getfield 32	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   8: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 14
    //   13: new 37	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   20: astore 15
    //   22: aload 15
    //   24: aload 6
    //   26: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 15
    //   32: getstatic 45	java/io/File:separator	Ljava/lang/String;
    //   35: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 15
    //   41: ldc 47
    //   43: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 15
    //   49: aload 5
    //   51: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 15
    //   57: ldc 49
    //   59: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 15
    //   65: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   68: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 15
    //   74: ldc 49
    //   76: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 15
    //   82: aload 14
    //   84: invokevirtual 62	java/io/File:getName	()Ljava/lang/String;
    //   87: invokestatic 65	com/tencent/mobileqq/wink/editor/export/WinkExportViewModel:a	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 15
    //   96: ldc 67
    //   98: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 15
    //   104: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore 5
    //   109: aload_2
    //   110: aload 4
    //   112: invokevirtual 75	com/tencent/videocut/render/ComposeRenderLayer:a	(Lcom/tencent/videocut/model/MediaModel;)V
    //   115: aload_1
    //   116: invokeinterface 81 1 0
    //   121: astore_1
    //   122: aload_1
    //   123: ifnull +440 -> 563
    //   126: iconst_0
    //   127: istore 10
    //   129: iconst_0
    //   130: istore 11
    //   132: iconst_0
    //   133: istore 8
    //   135: iload 10
    //   137: istore 9
    //   139: iload 11
    //   141: istore 7
    //   143: aload_3
    //   144: sipush 1080
    //   147: invokestatic 86	com/tencent/mobileqq/wink/editor/export/WinkExportManager:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;I)Landroid/util/Pair;
    //   150: astore_2
    //   151: iload 10
    //   153: istore 9
    //   155: iload 11
    //   157: istore 7
    //   159: getstatic 91	com/tencent/tavcut/TavCut:a	Lcom/tencent/tavcut/TavCut;
    //   162: aload_1
    //   163: new 93	com/tencent/tavcut/composition/model/component/Size
    //   166: dup
    //   167: aload_2
    //   168: getfield 99	android/util/Pair:first	Ljava/lang/Object;
    //   171: checkcast 101	java/lang/Integer
    //   174: aload_2
    //   175: getfield 104	android/util/Pair:second	Ljava/lang/Object;
    //   178: checkcast 101	java/lang/Integer
    //   181: getstatic 110	okio/ByteString:EMPTY	Lokio/ByteString;
    //   184: invokespecial 113	com/tencent/tavcut/composition/model/component/Size:<init>	(Ljava/lang/Integer;Ljava/lang/Integer;Lokio/ByteString;)V
    //   187: invokevirtual 116	com/tencent/tavcut/TavCut:a	(Lcom/tencent/tavcut/rendermodel/RenderModel;Lcom/tencent/tavcut/composition/model/component/Size;)Lcom/tencent/tavcut/render/cover/ICoverProvider;
    //   190: astore_1
    //   191: iload 10
    //   193: istore 9
    //   195: iload 11
    //   197: istore 7
    //   199: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   202: lstore 12
    //   204: iload 10
    //   206: istore 9
    //   208: iload 11
    //   210: istore 7
    //   212: aload_1
    //   213: lconst_0
    //   214: invokeinterface 121 3 0
    //   219: astore_2
    //   220: iload 10
    //   222: istore 9
    //   224: iload 11
    //   226: istore 7
    //   228: new 37	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   235: astore 4
    //   237: iload 10
    //   239: istore 9
    //   241: iload 11
    //   243: istore 7
    //   245: aload 4
    //   247: ldc 123
    //   249: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: iload 10
    //   255: istore 9
    //   257: iload 11
    //   259: istore 7
    //   261: aload 4
    //   263: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   266: lload 12
    //   268: lsub
    //   269: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: iload 10
    //   275: istore 9
    //   277: iload 11
    //   279: istore 7
    //   281: ldc 125
    //   283: aload 4
    //   285: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 130	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload_2
    //   292: ifnull +131 -> 423
    //   295: iload 10
    //   297: istore 9
    //   299: iload 11
    //   301: istore 7
    //   303: aload_2
    //   304: aload 5
    //   306: invokestatic 136	com/tencent/mobileqq/utils/FileUtils:saveBitmapToFile	(Landroid/graphics/Bitmap;Ljava/lang/String;)Z
    //   309: istore 8
    //   311: iload 8
    //   313: ifeq +98 -> 411
    //   316: iload 8
    //   318: istore 9
    //   320: iload 8
    //   322: istore 7
    //   324: aload_2
    //   325: invokevirtual 141	android/graphics/Bitmap:recycle	()V
    //   328: iload 8
    //   330: istore 9
    //   332: iload 8
    //   334: istore 7
    //   336: aload_1
    //   337: invokeinterface 143 1 0
    //   342: iload 8
    //   344: istore 9
    //   346: iload 8
    //   348: istore 7
    //   350: aload 5
    //   352: aload_3
    //   353: getfield 147	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   356: aload_3
    //   357: getfield 150	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   360: invokestatic 153	com/tencent/mobileqq/wink/editor/export/WinkExportViewModel:a	(Ljava/lang/String;II)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   363: astore_1
    //   364: new 37	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   371: astore_2
    //   372: aload_2
    //   373: ldc 155
    //   375: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_2
    //   380: iload 8
    //   382: invokevirtual 158	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload_2
    //   387: ldc 160
    //   389: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_2
    //   394: aload 5
    //   396: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: ldc 125
    //   402: aload_2
    //   403: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 130	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   409: aload_1
    //   410: areturn
    //   411: iload 8
    //   413: istore 9
    //   415: iload 8
    //   417: istore 7
    //   419: aload_2
    //   420: invokevirtual 141	android/graphics/Bitmap:recycle	()V
    //   423: iload 8
    //   425: istore 9
    //   427: iload 8
    //   429: istore 7
    //   431: aload_1
    //   432: invokeinterface 143 1 0
    //   437: new 37	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   444: astore_1
    //   445: iload 8
    //   447: istore 7
    //   449: goto +28 -> 477
    //   452: astore_1
    //   453: goto +63 -> 516
    //   456: astore_1
    //   457: iload 7
    //   459: istore 9
    //   461: ldc 125
    //   463: ldc 162
    //   465: aload_1
    //   466: invokestatic 165	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   469: new 37	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   476: astore_1
    //   477: aload_1
    //   478: ldc 155
    //   480: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_1
    //   485: iload 7
    //   487: invokevirtual 158	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload_1
    //   492: ldc 160
    //   494: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload_1
    //   499: aload 5
    //   501: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: ldc 125
    //   507: aload_1
    //   508: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 130	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload_3
    //   515: areturn
    //   516: new 37	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   523: astore_2
    //   524: aload_2
    //   525: ldc 155
    //   527: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload_2
    //   532: iload 9
    //   534: invokevirtual 158	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload_2
    //   539: ldc 160
    //   541: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload_2
    //   546: aload 5
    //   548: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: ldc 125
    //   554: aload_2
    //   555: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 130	com/tencent/aelight/camera/log/AEQLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: aload_1
    //   562: athrow
    //   563: aload_3
    //   564: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	this	WinkExportViewModel
    //   0	565	1	paramICutSession	com.tencent.tavcut.session.ICutSession
    //   0	565	2	paramComposeRenderLayer	com.tencent.videocut.render.ComposeRenderLayer
    //   0	565	3	paramLocalMediaInfo	LocalMediaInfo
    //   0	565	4	paramMediaModel	MediaModel
    //   0	565	5	paramString1	String
    //   0	565	6	paramString2	String
    //   141	345	7	bool1	boolean
    //   133	313	8	bool2	boolean
    //   137	396	9	bool3	boolean
    //   127	169	10	bool4	boolean
    //   130	170	11	bool5	boolean
    //   202	65	12	l	long
    //   11	72	14	localFile	File
    //   20	83	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   143	151	452	finally
    //   159	191	452	finally
    //   199	204	452	finally
    //   212	220	452	finally
    //   228	237	452	finally
    //   245	253	452	finally
    //   261	273	452	finally
    //   281	291	452	finally
    //   303	311	452	finally
    //   324	328	452	finally
    //   336	342	452	finally
    //   350	364	452	finally
    //   419	423	452	finally
    //   431	437	452	finally
    //   461	469	452	finally
    //   143	151	456	java/lang/Exception
    //   159	191	456	java/lang/Exception
    //   199	204	456	java/lang/Exception
    //   212	220	456	java/lang/Exception
    //   228	237	456	java/lang/Exception
    //   245	253	456	java/lang/Exception
    //   261	273	456	java/lang/Exception
    //   281	291	456	java/lang/Exception
    //   303	311	456	java/lang/Exception
    //   324	328	456	java/lang/Exception
    //   336	342	456	java/lang/Exception
    //   350	364	456	java/lang/Exception
    //   419	423	456	java/lang/Exception
    //   431	437	456	java/lang/Exception
  }
  
  public static LocalMediaInfo a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.mediaHeight = paramInt1;
    localLocalMediaInfo.mediaWidth = paramInt2;
    localLocalMediaInfo.mMimeType = "image/jpeg";
    localLocalMediaInfo.path = paramString;
    return localLocalMediaInfo;
  }
  
  public static LocalMediaInfo a(ArrayList<String> paramArrayList, @NonNull String paramString1, int paramInt1, int paramInt2, @NonNull String paramString2, @Nullable String paramString3, @NonNull String paramString4)
  {
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    localLocalMediaInfo.thumbHeight = paramInt1;
    localLocalMediaInfo.thumbWidth = paramInt2;
    localLocalMediaInfo.path = paramString2;
    localLocalMediaInfo.mediaHeight = paramInt1;
    localLocalMediaInfo.mediaWidth = paramInt2;
    localLocalMediaInfo.mMimeType = "video/mp4";
    localLocalMediaInfo.addedDate = System.currentTimeMillis();
    localLocalMediaInfo.modifiedDate = System.currentTimeMillis();
    localLocalMediaInfo.thumbnailPath = paramString3;
    localLocalMediaInfo.mDuration = 0L;
    localLocalMediaInfo.isSystemMeidaStore = false;
    localLocalMediaInfo.isMakeVideo = false;
    localLocalMediaInfo.isVideoReady = false;
    localLocalMediaInfo.missionID = paramString4;
    paramString1 = paramArrayList;
    if (paramArrayList == null) {
      paramString1 = new ArrayList();
    }
    localLocalMediaInfo.mOriginPath = paramString1;
    paramArrayList = new StringBuilder();
    paramArrayList.append("buildLocalMediaInfoForNotReady: info = ");
    paramArrayList.append(localLocalMediaInfo.toString());
    AEQLog.a("WinkExportViewModel", paramArrayList.toString());
    return localLocalMediaInfo;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.equals("")) {
        return paramString;
      }
      int i = paramString.lastIndexOf(".");
      int j = paramString.lastIndexOf(File.separator);
      if (j == -1)
      {
        if (i == -1) {
          return paramString;
        }
        return paramString.substring(0, i);
      }
      if (i == -1) {
        return paramString.substring(j + 1);
      }
      if (j < i) {
        return paramString.substring(j + 1, i);
      }
      str = paramString.substring(j + 1);
    }
    return str;
  }
  
  private void a(WinkEditorFragment paramWinkEditorFragment, WinkEditorViewModel paramWinkEditorViewModel, WinkTavCutDelegate paramWinkTavCutDelegate, WinkEditDataWrapper paramWinkEditDataWrapper)
  {
    paramWinkTavCutDelegate = paramWinkTavCutDelegate.d();
    if ((paramWinkTavCutDelegate != null) && (paramWinkTavCutDelegate.size() != 0))
    {
      this.a.postValue(WinkExportState.g);
      ThreadManager.getFileThreadHandler().post(new WinkExportViewModel.2(this, paramWinkEditorViewModel, paramWinkTavCutDelegate, paramWinkEditorFragment, paramWinkEditDataWrapper));
      return;
    }
    AEQLog.d("WinkExportViewModel", "exportImage... error mediaModels == null");
  }
  
  private void b(WinkEditorFragment paramWinkEditorFragment, WinkTavCutDelegate paramWinkTavCutDelegate, WinkEditDataWrapper paramWinkEditDataWrapper)
  {
    Object localObject = paramWinkEditDataWrapper.getEditDatas();
    if ((localObject != null) && (((ArrayList)localObject).size() == 1))
    {
      localObject = (WinkEditData)((ArrayList)localObject).get(0);
      if (localObject == null)
      {
        AEQLog.d("WinkExportViewModel", "exportVideo... error winkEditData == null");
        return;
      }
      localObject = ((WinkEditData)localObject).getMediaModel();
      if (localObject == null)
      {
        AEQLog.d("WinkExportViewModel", "exportVideo... error mediaModel == null");
        return;
      }
      this.a.postValue(WinkExportState.a);
      ThreadManager.getFileThreadHandler().post(new WinkExportViewModel.1(this, paramWinkEditDataWrapper, (MediaModel)localObject, paramWinkTavCutDelegate, paramWinkEditorFragment));
      return;
    }
    AEQLog.d("WinkExportViewModel", "exportVideo... list.size error");
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("multi_video_");
    localStringBuilder.append(System.currentTimeMillis());
    return localStringBuilder.toString();
  }
  
  protected LocalMediaInfo a(List<MediaClip> paramList, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(((MediaClip)paramList.get(i)).resource.path);
      i += 1;
    }
    paramList = new StringBuilder();
    paramList.append("createLocalMediaInfo... originPathList:");
    paramList.append(localArrayList);
    AEQLog.b("WinkExportViewModel", paramList.toString());
    return a(localArrayList, "", paramInt1, paramInt2, paramString1, paramString2, paramString3);
  }
  
  protected WinkExportViewModel.PublishMusicInfo a(BasePartFragment paramBasePartFragment)
  {
    if ((paramBasePartFragment instanceof WinkEditorFragment))
    {
      paramBasePartFragment = ((WinkEditorFragment)paramBasePartFragment).n();
    }
    else
    {
      WinkQLog.a("WinkExportViewModel", "createPublishMusicInfo, invalid fragment class");
      paramBasePartFragment = null;
    }
    if ((paramBasePartFragment != null) && (paramBasePartFragment.h() != null))
    {
      WinkExportViewModel.PublishMusicInfo localPublishMusicInfo = new WinkExportViewModel.PublishMusicInfo(this, null);
      localPublishMusicInfo.mId = paramBasePartFragment.h().c();
      localPublishMusicInfo.id = paramBasePartFragment.h().d();
      localPublishMusicInfo.songName = paramBasePartFragment.h().e();
      localPublishMusicInfo.startTime = paramBasePartFragment.h().g();
      localPublishMusicInfo.localPath = WinkEditorMusicHelper.a(paramBasePartFragment.h());
      return localPublishMusicInfo;
    }
    return null;
  }
  
  public String a()
  {
    return "WinkExportViewModel";
  }
  
  public void a(BasePartFragment paramBasePartFragment, ArrayList<String> paramArrayList, HashMap<String, LocalMediaInfo> paramHashMap, WinkEditDataWrapper paramWinkEditDataWrapper)
  {
    if (paramBasePartFragment != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("PUBLISH_EDIT_DATONG_DATA", WinkDatongCurrentParams.params);
      localIntent.putExtra("PUBLISH_EDIT_PUBLISH_DATA", WinkDatongCurrentParams.paramsForPublish);
      localIntent.putExtras(paramBasePartFragment.getActivity().getIntent().getExtras());
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", paramHashMap);
      localIntent.putExtra("IS_EDIT_TEXT", false);
      localIntent.putExtra("IS_IMAGE_MODEL", false);
      localIntent.putExtra("PUBLISH_ENTRANCE", paramWinkEditDataWrapper.getFrom());
      localIntent.putExtra("MEDIA_DURATION", paramWinkEditDataWrapper.getDuration());
      localIntent.putExtra("key_wink_video_mission_id", paramWinkEditDataWrapper.getMissionId());
      localIntent.putExtra("qcircle_client_traceid", paramBasePartFragment.getActivity().getIntent().getStringExtra("qcircle_client_traceid"));
      paramArrayList = a(paramBasePartFragment);
      if (paramArrayList != null)
      {
        localIntent.putExtra("PUBLISH_MUSIC_MID", paramArrayList.mId);
        localIntent.putExtra("PUBLISH_MUSIC_ID", paramArrayList.id);
        localIntent.putExtra("PUBLISH_MUSIC_NAME", paramArrayList.songName);
        localIntent.putExtra("PUBLISH_MUSIC_START_TIME", paramArrayList.startTime);
        localIntent.putExtra("PUBLISH_MUSIC_LOCAL_PATH", paramArrayList.localPath);
      }
      localIntent.addFlags(603979776);
      ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).launchPublishPage(paramBasePartFragment.getContext(), localIntent);
      SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent());
      return;
    }
    AEQLog.d("WinkExportViewModel", "nextStepToPublishFragment error hostFragment == null");
  }
  
  public void a(WinkEditorFragment paramWinkEditorFragment, WinkTavCutDelegate paramWinkTavCutDelegate, WinkEditDataWrapper paramWinkEditDataWrapper)
  {
    AEQLog.d("WinkExportViewModel", "startExport...");
    WinkEditorViewModel localWinkEditorViewModel = (WinkEditorViewModel)paramWinkEditorFragment.a(WinkEditorViewModel.class);
    if (localWinkEditorViewModel == null)
    {
      AEQLog.d("WinkExportViewModel", "startExport... error winkEditorViewModel == null");
      return;
    }
    if (paramWinkEditDataWrapper == null)
    {
      AEQLog.d("WinkExportViewModel", "startExport... error dataWrapper == null");
      return;
    }
    if (paramWinkEditDataWrapper.getEditMode().intValue() == 0)
    {
      b(paramWinkEditorFragment, paramWinkTavCutDelegate, paramWinkEditDataWrapper);
      return;
    }
    if (paramWinkEditDataWrapper.getEditMode().intValue() == 1) {
      a(paramWinkEditorFragment, localWinkEditorViewModel, paramWinkTavCutDelegate, paramWinkEditDataWrapper);
    }
  }
  
  public MutableLiveData<WinkExportState> b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.export.WinkExportViewModel
 * JD-Core Version:    0.7.0.1
 */