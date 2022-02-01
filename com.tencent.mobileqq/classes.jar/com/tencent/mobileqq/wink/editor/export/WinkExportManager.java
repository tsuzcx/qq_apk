package com.tencent.mobileqq.wink.editor.export;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.wink.WinkResManager;
import com.tencent.mobileqq.wink.edit.base.AEEditorPath.EDITOR.CACHE;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataHelper;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.template.RenderModelExKt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tavcut.TavCut;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.config.DynamicSoConfig;
import com.tencent.tavcut.render.exporter.ExportOutput;
import com.tencent.tavcut.render.exporter.IExporter;
import com.tencent.tavcut.render.exporter.IExporter.ExportListener;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.picker.MediaData;
import com.tencent.videocut.render.ComposeRenderLayer;
import com.tencent.videocut.render.ComposeRenderLayer.RenderScene;
import com.tencent.videocut.render.repository.DataBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.ByteString;

public class WinkExportManager
{
  private final long a = 1000L;
  private boolean b = false;
  private ICutSession c;
  private IExporter d;
  private ICutSession e;
  
  public static Pair<Integer, Integer> a(LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    int j;
    int i;
    if ((paramLocalMediaInfo.orientation != 90) && (paramLocalMediaInfo.orientation != 270))
    {
      j = paramLocalMediaInfo.mediaHeight;
      i = paramLocalMediaInfo.mediaWidth;
    }
    else
    {
      j = paramLocalMediaInfo.mediaWidth;
      i = paramLocalMediaInfo.mediaHeight;
    }
    if (i <= j)
    {
      if (i > paramInt)
      {
        j = j * paramInt / i;
        i = paramInt;
        paramInt = j;
        break label84;
      }
    }
    else if (j > paramInt)
    {
      i = i * paramInt / j;
      break label84;
    }
    paramInt = j;
    label84:
    return new Pair(Integer.valueOf(i), Integer.valueOf(paramInt));
  }
  
  public static Pair<Integer, Integer> a(WinkEditDataWrapper paramWinkEditDataWrapper, ArrayList<LocalMediaInfo> paramArrayList)
  {
    int i = 720;
    int k = 1280;
    if (paramWinkEditDataWrapper == null) {
      return new Pair(Integer.valueOf(720), Integer.valueOf(1280));
    }
    int m = i;
    int j = k;
    if (paramArrayList != null)
    {
      m = i;
      j = k;
      if (paramArrayList.size() == 1)
      {
        paramArrayList = (LocalMediaInfo)paramArrayList.get(0);
        m = i;
        j = k;
        if (paramArrayList != null)
        {
          m = i;
          j = k;
          if (TextUtils.isEmpty(paramWinkEditDataWrapper.getTemplateFilePath()))
          {
            m = i;
            j = k;
            if (!b(paramWinkEditDataWrapper))
            {
              if (QAlbumUtil.getMediaType(paramArrayList) == 1)
              {
                a(paramArrayList);
                if ((paramArrayList.rotation != 90) && (paramArrayList.rotation != 270))
                {
                  j = paramArrayList.mediaHeight;
                  i = paramArrayList.mediaWidth;
                }
                else
                {
                  j = paramArrayList.mediaWidth;
                  i = paramArrayList.mediaHeight;
                }
              }
              for (;;)
              {
                break;
                if ((paramArrayList.mediaWidth != 0) && (paramArrayList.mediaHeight != 0))
                {
                  if ((paramArrayList.orientation != 90) && (paramArrayList.orientation != 270))
                  {
                    j = paramArrayList.mediaHeight;
                    i = paramArrayList.mediaWidth;
                  }
                  else
                  {
                    j = paramArrayList.mediaWidth;
                    i = paramArrayList.mediaHeight;
                  }
                }
                else
                {
                  paramWinkEditDataWrapper = new BitmapFactory.Options();
                  paramWinkEditDataWrapper.inJustDecodeBounds = true;
                  BitmapFactory.decodeFile(paramArrayList.path, paramWinkEditDataWrapper);
                  paramArrayList.mediaWidth = paramWinkEditDataWrapper.outWidth;
                  paramArrayList.mediaHeight = paramWinkEditDataWrapper.outHeight;
                  j = k;
                }
              }
              paramWinkEditDataWrapper = new StringBuilder();
              paramWinkEditDataWrapper.append("requestGenerateVideo orginMedia url:");
              paramWinkEditDataWrapper.append(paramArrayList.path);
              AEQLog.d("WinkExportManager", paramWinkEditDataWrapper.toString());
              paramWinkEditDataWrapper = new StringBuilder();
              paramWinkEditDataWrapper.append("requestGenerateVideo orginMedia:orientation");
              paramWinkEditDataWrapper.append(paramArrayList.orientation);
              paramWinkEditDataWrapper.append(" height:");
              paramWinkEditDataWrapper.append(paramArrayList.mediaHeight);
              paramWinkEditDataWrapper.append(" width:");
              paramWinkEditDataWrapper.append(paramArrayList.mediaWidth);
              AEQLog.d("WinkExportManager", paramWinkEditDataWrapper.toString());
              m = i;
            }
          }
        }
      }
    }
    return new Pair(Integer.valueOf(m), Integer.valueOf(j));
  }
  
  public static WinkExportManager a()
  {
    return WinkExportManager.InstanceHolder.a;
  }
  
  private MediaData a(LocalMediaInfo paramLocalMediaInfo, long paramLong)
  {
    if (paramLocalMediaInfo == null) {
      return null;
    }
    if (QAlbumUtil.getMediaType(paramLocalMediaInfo) == 1) {
      return new MediaData(0, paramLocalMediaInfo.mMimeType, 720, 1280, 0L, 0L, 1000L * paramLocalMediaInfo.mDuration, paramLocalMediaInfo.path, paramLocalMediaInfo.path, paramLocalMediaInfo.mAlbumName);
    }
    return new MediaData(1, paramLocalMediaInfo.mMimeType, 720, 1280, 0L, 0L, paramLong, paramLocalMediaInfo.path, paramLocalMediaInfo.path, paramLocalMediaInfo.mAlbumName);
  }
  
  private void a(Context paramContext, @NonNull WinkEditorVideoInfo paramWinkEditorVideoInfo)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramWinkEditorVideoInfo.g);
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("generate_materialid", paramWinkEditorVideoInfo.l);
    localIntent.putExtra("generate_materialname", paramWinkEditorVideoInfo.m);
    localIntent.putExtra("generate_filterid", paramWinkEditorVideoInfo.n);
    localIntent.putExtra("generate_scheme", paramWinkEditorVideoInfo.o);
    localIntent.putExtra("generate_show_circle_take_same", paramWinkEditorVideoInfo.p);
    localIntent.putExtra("generate_path", paramWinkEditorVideoInfo.a);
    localIntent.putExtra("generate_mission", paramWinkEditorVideoInfo.h);
    localIntent.putExtra("generate_progress", paramWinkEditorVideoInfo.e);
    localIntent.putExtra("generate_thumb_ptah", paramWinkEditorVideoInfo.d);
    localIntent.putExtra("generate_errorcode", paramWinkEditorVideoInfo.i);
    localIntent.putExtra("generate_errormessage", paramWinkEditorVideoInfo.j);
    localIntent.putExtra("generate_source_path", paramWinkEditorVideoInfo.b);
    localIntent.putExtra("generate_KuolieId", paramWinkEditorVideoInfo.q);
    localIntent.putExtra("generate_centerX", paramWinkEditorVideoInfo.r);
    localIntent.putExtra("generate_centerY", paramWinkEditorVideoInfo.s);
    localIntent.putExtra("generate_widthScale", paramWinkEditorVideoInfo.u);
    localIntent.putExtra("generate_HeightScale", paramWinkEditorVideoInfo.v);
    localIntent.putExtra("generate_rotate", paramWinkEditorVideoInfo.t);
    paramContext.sendBroadcast(localIntent);
  }
  
  private void a(Context paramContext, ICutSession paramICutSession, ExportOutput paramExportOutput, LocalMediaInfo paramLocalMediaInfo)
  {
    WinkEditorVideoInfo localWinkEditorVideoInfo = new WinkEditorVideoInfo(paramLocalMediaInfo.materialID, paramLocalMediaInfo.materialName, paramLocalMediaInfo.filterID, paramLocalMediaInfo.scheme, paramLocalMediaInfo.showCircleTakeSame, paramLocalMediaInfo.missionID, paramLocalMediaInfo.path, paramLocalMediaInfo.thumbnailPath, paramLocalMediaInfo.mKuolieId, paramLocalMediaInfo.mKuolieCenterX, paramLocalMediaInfo.mKuolieCenterY, paramLocalMediaInfo.mKuolieWidthScale, paramLocalMediaInfo.mKuolieHeightScale, paramLocalMediaInfo.mKuolieRotate);
    RenderModel localRenderModel = RenderModelExKt.a(paramICutSession.d(), 180000000L);
    this.d = TavCut.a.a(localRenderModel);
    this.d.a(new WinkExportManager.2(this, localWinkEditorVideoInfo, paramContext, paramICutSession));
    this.d.a(paramExportOutput, paramLocalMediaInfo.path);
    a(true);
  }
  
  /* Error */
  public static void a(LocalMediaInfo paramLocalMediaInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +95 -> 96
    //   4: aload_0
    //   5: invokestatic 82	com/tencent/mobileqq/activity/photo/album/QAlbumUtil:getMediaType	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)I
    //   8: iconst_1
    //   9: if_icmpeq +4 -> 13
    //   12: return
    //   13: new 369	android/media/MediaMetadataRetriever
    //   16: dup
    //   17: invokespecial 370	android/media/MediaMetadataRetriever:<init>	()V
    //   20: astore_1
    //   21: aload_1
    //   22: aload_0
    //   23: getfield 98	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   26: invokevirtual 374	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: aload_1
    //   31: bipush 19
    //   33: invokevirtual 378	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   36: invokestatic 382	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   39: putfield 34	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   42: aload_0
    //   43: aload_1
    //   44: bipush 18
    //   46: invokevirtual 378	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   49: invokestatic 382	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   52: putfield 37	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   55: aload_0
    //   56: aload_1
    //   57: bipush 24
    //   59: invokevirtual 378	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   62: invokestatic 382	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   65: putfield 88	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   68: goto +17 -> 85
    //   71: astore_0
    //   72: goto +18 -> 90
    //   75: astore_0
    //   76: ldc 121
    //   78: ldc_w 384
    //   81: aload_0
    //   82: invokestatic 387	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   85: aload_1
    //   86: invokevirtual 390	android/media/MediaMetadataRetriever:release	()V
    //   89: return
    //   90: aload_1
    //   91: invokevirtual 390	android/media/MediaMetadataRetriever:release	()V
    //   94: aload_0
    //   95: athrow
    //   96: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramLocalMediaInfo	LocalMediaInfo
    //   20	71	1	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   21	68	71	finally
    //   76	85	71	finally
    //   21	68	75	java/lang/Exception
  }
  
  public static void a(ICutSession paramICutSession, WinkEditDataWrapper paramWinkEditDataWrapper, Pair<Integer, Integer> paramPair)
  {
    if (paramWinkEditDataWrapper == null) {
      return;
    }
    if ((paramWinkEditDataWrapper.getOriginMediaInfos() != null) && (paramWinkEditDataWrapper.getOriginMediaInfos().size() == 1))
    {
      if (((Integer)paramPair.first).intValue() * 1280 > ((Integer)paramPair.second).intValue() * 720)
      {
        paramICutSession.a(new Size().copy((Integer)paramPair.first, (Integer)paramPair.second, ByteString.EMPTY), 0.0F);
        return;
      }
      paramICutSession.a(new Size().copy((Integer)paramPair.first, (Integer)paramPair.second, ByteString.EMPTY), 1.0F);
    }
  }
  
  private void a(ICutSession paramICutSession, ExportOutput paramExportOutput, LocalMediaInfo paramLocalMediaInfo, IExporter.ExportListener paramExportListener)
  {
    this.d = TavCut.a.a(paramICutSession.d());
    this.d.a(new WinkExportManager.1(this, paramExportListener, paramICutSession));
    this.d.a(paramExportOutput, b(paramLocalMediaInfo));
    a(true);
  }
  
  private String b(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject = SecUtil.getFileMd5(paramLocalMediaInfo.path);
    if (!StringUtil.isEmpty((String)localObject))
    {
      paramLocalMediaInfo = new StringBuilder();
      paramLocalMediaInfo.append((String)localObject);
      paramLocalMediaInfo.append(".mp4");
      paramLocalMediaInfo = paramLocalMediaInfo.toString();
    }
    else
    {
      paramLocalMediaInfo = paramLocalMediaInfo.path.split("/");
      if (paramLocalMediaInfo.length > 0) {
        paramLocalMediaInfo = paramLocalMediaInfo[(paramLocalMediaInfo.length - 1)];
      } else {
        paramLocalMediaInfo = "";
      }
    }
    localObject = new File(AEEditorPath.EDITOR.CACHE.b);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AEEditorPath.EDITOR.CACHE.b);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramLocalMediaInfo);
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean b(WinkEditDataWrapper paramWinkEditDataWrapper)
  {
    if (paramWinkEditDataWrapper == null) {
      return false;
    }
    paramWinkEditDataWrapper = paramWinkEditDataWrapper.getEditDatas();
    if (paramWinkEditDataWrapper != null)
    {
      if (paramWinkEditDataWrapper.size() == 0) {
        return false;
      }
      paramWinkEditDataWrapper = paramWinkEditDataWrapper.iterator();
      while (paramWinkEditDataWrapper.hasNext())
      {
        WinkEditData localWinkEditData = (WinkEditData)paramWinkEditDataWrapper.next();
        if ((localWinkEditData != null) && (localWinkEditData.getStickerModelMap() != null) && (localWinkEditData.getStickerModelMap().size() > 0)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private ICutSession c(LocalMediaInfo paramLocalMediaInfo)
  {
    TavCut.a(BaseApplication.getContext());
    ICutSession localICutSession = TavCut.a.b();
    localICutSession.a(TavCut.a.c(null));
    Object localObject = new ArrayList();
    paramLocalMediaInfo = a(paramLocalMediaInfo, 2500000L);
    if (paramLocalMediaInfo != null) {
      ((ArrayList)localObject).add(paramLocalMediaInfo);
    }
    paramLocalMediaInfo = DataBuilder.a.a((List)localObject);
    localObject = new ComposeRenderLayer(localICutSession, new MediaModel(), ComposeRenderLayer.RenderScene.VIDEO);
    if (paramLocalMediaInfo != null) {
      ((ComposeRenderLayer)localObject).a(paramLocalMediaInfo);
    }
    return localICutSession;
  }
  
  private ICutSession c(WinkEditDataWrapper paramWinkEditDataWrapper)
  {
    TavCut.a(BaseApplication.getContext());
    ICutSession localICutSession = TavCut.a.b();
    localICutSession.a(TavCut.a.c(paramWinkEditDataWrapper.getTemplateFilePath()));
    ComposeRenderLayer localComposeRenderLayer = new ComposeRenderLayer(localICutSession, new MediaModel(), ComposeRenderLayer.RenderScene.VIDEO);
    paramWinkEditDataWrapper = paramWinkEditDataWrapper.getEditDatas();
    if ((paramWinkEditDataWrapper != null) && (paramWinkEditDataWrapper.size() == 1))
    {
      paramWinkEditDataWrapper = ((WinkEditData)paramWinkEditDataWrapper.get(0)).getMediaModel();
      if (paramWinkEditDataWrapper != null) {
        localComposeRenderLayer.a(paramWinkEditDataWrapper);
      }
    }
    return localICutSession;
  }
  
  public static void d()
  {
    WinkResManager.a(((IAEResUtil)QRoute.api(IAEResUtil.class)).getFinalUnzipFilePath());
    TavCut.a(((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightAssetsDir());
    TavCut.a(new ArrayList(Collections.singleton(new DynamicSoConfig(((IAEResUtil)QRoute.api(IAEResUtil.class)).getFinalUnzipFilePath(), "liblight-sdk.so", false))));
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo, IExporter.ExportListener paramExportListener)
  {
    this.e = c(paramLocalMediaInfo);
    a(paramLocalMediaInfo);
    int i;
    int j;
    if ((paramLocalMediaInfo.rotation != 90) && (paramLocalMediaInfo.rotation != 270))
    {
      i = paramLocalMediaInfo.mediaHeight;
      j = paramLocalMediaInfo.mediaWidth;
    }
    else
    {
      i = paramLocalMediaInfo.mediaWidth;
      j = paramLocalMediaInfo.mediaHeight;
    }
    this.e.a(new Size().copy(Integer.valueOf(j), Integer.valueOf(i), ByteString.EMPTY), 0.0F);
    ExportOutput localExportOutput = new ExportOutput(j, i);
    localExportOutput.a(300);
    a(this.e, localExportOutput, paramLocalMediaInfo, paramExportListener);
  }
  
  public void a(WinkEditDataWrapper paramWinkEditDataWrapper)
  {
    this.c = c(paramWinkEditDataWrapper);
    Object localObject = a(paramWinkEditDataWrapper, paramWinkEditDataWrapper.getOriginMediaInfos());
    a(this.c, paramWinkEditDataWrapper, (Pair)localObject);
    localObject = new ExportOutput(((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue());
    ((ExportOutput)localObject).a(200);
    ((ExportOutput)localObject).b(30);
    a(BaseApplication.getContext(), this.c, (ExportOutput)localObject, paramWinkEditDataWrapper.getOutMediaInfo());
  }
  
  public void a(String paramString)
  {
    if (this.b) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = WinkEditDataHelper.a(paramString);
    if (paramString == null) {
      return;
    }
    d();
    a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void b()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((IExporter)localObject).a();
    }
    localObject = this.c;
    if (localObject != null) {
      ((ICutSession)localObject).g();
    }
    this.b = false;
  }
  
  public void c()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((IExporter)localObject).a();
    }
    localObject = this.e;
    if (localObject != null) {
      ((ICutSession)localObject).g();
    }
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.export.WinkExportManager
 * JD-Core Version:    0.7.0.1
 */