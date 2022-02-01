package com.tencent.mobileqq.wink.editor;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorMaterialManager;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataHelper;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportViewModel;
import com.tencent.mobileqq.wink.editor.menu.MenuItem;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.videocut.picker.MediaData;
import com.tencent.videocut.render.repository.DataBuilder;
import common.config.service.QzoneConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.LongRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "()V", "_bottomDashboardMenuLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/wink/editor/menu/MenuItem;", "_curMenuLiveData", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "_tavCutParamsLiveData", "Lcom/tencent/mobileqq/wink/editor/WinkTavCutDelegate$WinkTavCutParams;", "bottomDashboardMenuLiveData", "Landroidx/lifecycle/LiveData;", "getBottomDashboardMenuLiveData", "()Landroidx/lifecycle/LiveData;", "curMenuLiveData", "getCurMenuLiveData", "currentPlayerTimeLiveData", "", "getCurrentPlayerTimeLiveData", "()Landroidx/lifecycle/MutableLiveData;", "draftMusicMid", "", "getDraftMusicMid", "()Ljava/lang/String;", "setDraftMusicMid", "(Ljava/lang/String;)V", "editDataMap", "", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "<set-?>", "editMode", "getEditMode", "()Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "", "isAllImages", "()Z", "isAutoTemplate", "setAutoTemplate", "(Z)V", "isFromCapture", "setFromCapture", "mFrom", "", "getMFrom", "()I", "setMFrom", "(I)V", "mIsDisableOther", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "mediaInfos", "getMediaInfos", "()Ljava/util/ArrayList;", "mediaInfosOutput", "getMediaInfosOutput", "setMediaInfosOutput", "(Ljava/util/ArrayList;)V", "missionId", "getMissionId", "playerHeight", "playerWidth", "tavCutParamsLiveData", "getTavCutParamsLiveData", "templatePath", "getTemplatePath", "setTemplatePath", "genImageMediaData", "Lcom/tencent/videocut/picker/MediaData;", "mediaInfo", "width", "height", "duration", "genImageMediaModels", "mediaInfoList", "genVideoMediaData", "genVideoMediaModels", "genWinkEditDataList", "getEditDataList", "getEditModeCode", "getEntrance", "getIsFromCapture", "getLogTag", "init", "", "intent", "Landroid/content/Intent;", "isDisableOther", "isFromBackEdit", "isFromDraftPage", "isOnlyOneImage", "jumpToPickMedias", "context", "Landroid/content/Context;", "loadMediaDataFromDraft", "onGoBack", "prepareTavCutParams", "setDisableOther", "enable", "showBottomDashboard", "switchMenu", "newMenuType", "updateDashboardMenu", "Companion", "EditMode", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class WinkEditorViewModel
  extends BaseViewModel
{
  public static final WinkEditorViewModel.Companion a = new WinkEditorViewModel.Companion(null);
  private final MutableLiveData<List<MenuItem>> b = new MutableLiveData();
  private final MutableLiveData<MenuType> c = new MutableLiveData();
  private final MutableLiveData<WinkTavCutDelegate.WinkTavCutParams> d = new MutableLiveData();
  private int e;
  private int f;
  @Nullable
  private String g;
  @Nullable
  private ArrayList<LocalMediaInfo> h;
  @Nullable
  private ArrayList<LocalMediaInfo> i;
  @Nullable
  private String j;
  private final Map<WinkEditorViewModel.EditMode, List<WinkEditData>> k = (Map)new LinkedHashMap();
  @NotNull
  private final MutableLiveData<Long> l = new MutableLiveData();
  private boolean m;
  private int n = -1;
  private boolean o;
  private boolean p;
  private boolean q;
  @NotNull
  private WinkEditorViewModel.EditMode r = WinkEditorViewModel.EditMode.Video;
  @Nullable
  private String s = "";
  
  private final MediaData a(LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, long paramLong)
  {
    String str1 = paramLocalMediaInfo.mMimeType;
    Intrinsics.checkExpressionValueIsNotNull(str1, "mediaInfo.mMimeType");
    String str2 = paramLocalMediaInfo.path;
    Intrinsics.checkExpressionValueIsNotNull(str2, "mediaInfo.path");
    return new MediaData(1, str1, paramInt1, paramInt2, 0L, 0L, paramLong, str2, paramLocalMediaInfo.path, paramLocalMediaInfo.mAlbumName);
  }
  
  private final MediaData a(LocalMediaInfo paramLocalMediaInfo, long paramLong)
  {
    String str1 = paramLocalMediaInfo.mMimeType;
    Intrinsics.checkExpressionValueIsNotNull(str1, "mediaInfo.mMimeType");
    String str2 = paramLocalMediaInfo.path;
    Intrinsics.checkExpressionValueIsNotNull(str2, "mediaInfo.path");
    return new MediaData(0, str1, 720, 1280, 0L, 0L, paramLong, str2, paramLocalMediaInfo.path, paramLocalMediaInfo.mAlbumName);
  }
  
  private final ArrayList<WinkEditData> a(List<? extends LocalMediaInfo> paramList)
  {
    Object localObject1 = (Collection)paramList;
    int i1;
    if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      return new ArrayList();
    }
    localObject1 = (Iterable)CollectionsKt.filterNotNull((Iterable)paramList);
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (QAlbumUtil.getMediaType((LocalMediaInfo)localObject2) == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        paramList.add(localObject2);
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
      if ((((LocalMediaInfo)localObject2).mediaWidth == 0) || (((LocalMediaInfo)localObject2).mediaHeight == 0))
      {
        AEQLog.d("WinkEditorViewModel", "[genImageMediaModels] invalid image sizze");
        localObject3 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(((LocalMediaInfo)localObject2).path, (BitmapFactory.Options)localObject3);
        ((LocalMediaInfo)localObject2).mediaWidth = ((BitmapFactory.Options)localObject3).outWidth;
        ((LocalMediaInfo)localObject2).mediaHeight = ((BitmapFactory.Options)localObject3).outHeight;
      }
      i1 = this.e;
      int i2 = ((LocalMediaInfo)localObject2).mediaHeight * i1 / ((LocalMediaInfo)localObject2).mediaWidth;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[genImageMediaModels] ");
      ((StringBuilder)localObject3).append("image size=");
      ((StringBuilder)localObject3).append(((LocalMediaInfo)localObject2).mediaWidth);
      ((StringBuilder)localObject3).append('x');
      ((StringBuilder)localObject3).append(((LocalMediaInfo)localObject2).mediaHeight);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append("media size=");
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append('x');
      ((StringBuilder)localObject3).append(i2);
      AEQLog.a("WinkEditorViewModel", ((StringBuilder)localObject3).toString());
      paramList.add(new WinkEditData(DataBuilder.a.a(CollectionsKt.listOf(a((LocalMediaInfo)localObject2, i1, i2, 10000000L))), 1000000L, null, null, null, null, 60, null));
    }
    return (ArrayList)CollectionsKt.toCollection((Iterable)paramList, (Collection)new ArrayList());
  }
  
  private final List<WinkEditData> a(WinkEditorViewModel.EditMode paramEditMode)
  {
    if (this.k.containsKey(paramEditMode))
    {
      paramEditMode = this.k.get(paramEditMode);
      if (paramEditMode == null) {
        Intrinsics.throwNpe();
      }
      return (List)paramEditMode;
    }
    ArrayList localArrayList = v();
    this.k.put(paramEditMode, localArrayList);
    return (List)localArrayList;
  }
  
  private final ArrayList<WinkEditData> b(List<? extends LocalMediaInfo> paramList)
  {
    long l1;
    if (c(paramList))
    {
      l1 = 10000000L;
      paramList = paramList.get(0);
      if (paramList == null) {
        Intrinsics.throwNpe();
      }
      paramList = (List)CollectionsKt.arrayListOf(new MediaData[] { a((LocalMediaInfo)paramList, 720, 1280, 10000000L) });
    }
    for (;;)
    {
      break;
      Ref.LongRef localLongRef = new Ref.LongRef();
      int i1;
      if ((this.q) && (QzoneConfig.getWinkTransitionSwitch())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        l1 = 3500000L;
      } else {
        l1 = 2500000L;
      }
      Object localObject = (Iterable)CollectionsKt.filterNotNull((Iterable)paramList);
      Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
      Iterator localIterator = ((Iterable)localObject).iterator();
      long l2 = 0L;
      int i2 = 0;
      while (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (i2 < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        localObject = (LocalMediaInfo)localObject;
        if (QAlbumUtil.getMediaType((LocalMediaInfo)localObject) == 1)
        {
          localLongRef.element = (((LocalMediaInfo)localObject).mDuration * 1000);
          l2 += localLongRef.element;
          localObject = a((LocalMediaInfo)localObject, localLongRef.element);
        }
        else
        {
          if ((i1 != 0) && ((i2 == 0) || (i2 == paramList.size() - 1))) {
            l3 = l1 - 500000L;
          } else {
            l3 = l1;
          }
          localLongRef.element = l3;
          long l3 = localLongRef.element;
          localObject = a((LocalMediaInfo)localObject, 720, 1280, localLongRef.element);
          l2 = l3 + l2;
        }
        localCollection.add(localObject);
        i2 += 1;
      }
      paramList = (List)localCollection;
      if (i1 != 0) {
        l1 = paramList.size() * 2500000L;
      } else {
        l1 = l2;
      }
    }
    return CollectionsKt.arrayListOf(new WinkEditData[] { new WinkEditData(DataBuilder.a.a(paramList), l1, null, null, null, null, 60, null) });
  }
  
  private final boolean b(Intent paramIntent)
  {
    this.n = paramIntent.getIntExtra("EDITOR_ENTRANCE", 0);
    int i1 = this.n;
    if ((i1 == 2) || (i1 == 3))
    {
      WinkEditDataWrapper localWinkEditDataWrapper = WinkEditDataHelper.a(paramIntent.getStringExtra("key_wink_video_mission_id"));
      if (localWinkEditDataWrapper != null)
      {
        this.g = localWinkEditDataWrapper.getTemplateFilePath();
        this.i = localWinkEditDataWrapper.getOriginMediaInfos();
        this.h = this.i;
        this.j = localWinkEditDataWrapper.getMissionId();
        this.o = localWinkEditDataWrapper.isFromCapture();
        this.s = localWinkEditDataWrapper.getSelectMusicMid();
        if (this.i == null) {
          return false;
        }
        paramIntent = localWinkEditDataWrapper.getEditMode();
        if ((paramIntent != null) && (paramIntent.intValue() == 0)) {
          paramIntent = WinkEditorViewModel.EditMode.Video;
        } else {
          paramIntent = WinkEditorViewModel.EditMode.Image;
        }
        this.r = paramIntent;
        this.k.put(this.r, localWinkEditDataWrapper.getEditDatas());
        return true;
      }
    }
    return false;
  }
  
  private final boolean c(List<? extends LocalMediaInfo> paramList)
  {
    int i1 = paramList.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 == 1)
    {
      paramList = (LocalMediaInfo)paramList.get(0);
      bool1 = bool2;
      if (paramList != null)
      {
        bool1 = bool2;
        if (QAlbumUtil.getMediaType(paramList) != 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final ArrayList<WinkEditData> v()
  {
    Object localObject = (Collection)this.h;
    if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      return new ArrayList();
    }
    localObject = this.r;
    int i1 = WinkEditorViewModel.WhenMappings.$EnumSwitchMapping$1[localObject.ordinal()];
    if (i1 != 1)
    {
      if (i1 == 2)
      {
        localObject = this.h;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        return b((List)localObject);
      }
      throw new NoWhenBranchMatchedException();
    }
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return a((List)localObject);
  }
  
  private final void w()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.q)
    {
      if (this.r == WinkEditorViewModel.EditMode.Video)
      {
        localArrayList.add(MenuItem.TO_IMAGE);
        localArrayList.add(MenuItem.VIDEO_TEMPLATE);
        localArrayList.add(MenuItem.CLIPPING);
      }
      else
      {
        localArrayList.add(MenuItem.TO_VIDEO);
      }
    }
    else
    {
      localArrayList.add(MenuItem.VIDEO_TEMPLATE);
      localArrayList.add(MenuItem.CLIPPING);
    }
    localArrayList.add(MenuItem.FILTER);
    localArrayList.add(MenuItem.TEXT);
    localArrayList.add(MenuItem.STICKER);
    this.b.postValue(localArrayList);
    if (this.m)
    {
      a(MenuType.VIDEO_TEMPLATE);
      return;
    }
    p();
  }
  
  @Nullable
  public final WinkTavCutDelegate.WinkTavCutParams a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    WinkEditorViewModel.EditMode localEditMode = this.r;
    return new WinkTavCutDelegate.WinkTavCutParams(true, localEditMode, a(localEditMode), this.g, paramInt1, paramInt2);
  }
  
  @NotNull
  public String a()
  {
    return "WinkEditorViewModel";
  }
  
  public final void a(@Nullable Context paramContext)
  {
    if (s())
    {
      b(paramContext);
      return;
    }
    r();
  }
  
  public final void a(@Nullable Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    boolean bool1 = b(paramIntent);
    boolean bool2 = true;
    int i1;
    if (!bool1)
    {
      this.o = paramIntent.getBooleanExtra("IS_FROM_CAPTURE", false);
      this.i = paramIntent.getParcelableArrayListExtra("localMediaInfos");
      ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("localMediaInfos_output");
      if (localArrayList == null) {
        localArrayList = this.i;
      }
      this.h = localArrayList;
      if (this.h == null) {
        return;
      }
      this.m = paramIntent.getBooleanExtra("IS_AUTO_TEMPLATE", false);
      if (this.m) {
        WinkEditorMaterialManager.a().a(false);
      }
      this.j = WinkExportViewModel.c();
      paramIntent = this.h;
      if (paramIntent == null) {
        Intrinsics.throwNpe();
      }
      paramIntent = (Iterable)paramIntent;
      if (((paramIntent instanceof Collection)) && (((Collection)paramIntent).isEmpty())) {}
      do
      {
        while (!paramIntent.hasNext())
        {
          bool1 = true;
          break;
          paramIntent = paramIntent.iterator();
        }
        if (QAlbumUtil.getMediaType((LocalMediaInfo)paramIntent.next()) == 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      } while (i1 != 0);
      bool1 = false;
      this.q = bool1;
      if ((QCircleConfigHelper.bj()) && (this.q)) {
        paramIntent = WinkEditorViewModel.EditMode.Image;
      } else {
        paramIntent = WinkEditorViewModel.EditMode.Video;
      }
      this.r = paramIntent;
    }
    paramIntent = this.h;
    if (paramIntent == null) {
      Intrinsics.throwNpe();
    }
    paramIntent = (Iterable)paramIntent;
    if (((paramIntent instanceof Collection)) && (((Collection)paramIntent).isEmpty()))
    {
      bool1 = bool2;
    }
    else
    {
      paramIntent = paramIntent.iterator();
      do
      {
        bool1 = bool2;
        if (!paramIntent.hasNext()) {
          break;
        }
        if (QAlbumUtil.getMediaType((LocalMediaInfo)paramIntent.next()) == 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
      } while (i1 != 0);
      bool1 = false;
    }
    this.q = bool1;
    w();
  }
  
  public final void a(@NotNull MenuType paramMenuType)
  {
    Intrinsics.checkParameterIsNotNull(paramMenuType, "newMenuType");
    if (QLog.isColorLevel())
    {
      localObject = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchMenu: ");
      localStringBuilder.append(paramMenuType);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if ((MenuType)this.c.getValue() == paramMenuType) {
      return;
    }
    int i1 = WinkEditorViewModel.WhenMappings.$EnumSwitchMapping$0[paramMenuType.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        this.c.postValue(paramMenuType);
        return;
      }
      this.r = WinkEditorViewModel.EditMode.Video;
      w();
      paramMenuType = this.d;
      localObject = this.r;
      paramMenuType.postValue(new WinkTavCutDelegate.WinkTavCutParams(false, (WinkEditorViewModel.EditMode)localObject, a((WinkEditorViewModel.EditMode)localObject), null, this.e, this.f));
      return;
    }
    this.r = WinkEditorViewModel.EditMode.Image;
    w();
    paramMenuType = this.d;
    Object localObject = this.r;
    paramMenuType.postValue(new WinkTavCutDelegate.WinkTavCutParams(false, (WinkEditorViewModel.EditMode)localObject, a((WinkEditorViewModel.EditMode)localObject), null, this.e, this.f));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  @NotNull
  public final LiveData<List<MenuItem>> b()
  {
    return (LiveData)this.b;
  }
  
  public final void b(@Nullable Context paramContext)
  {
    if (this.i == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("IS_BACK_EDIT", true);
    if (!this.o)
    {
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
        if ((localLocalMediaInfo != null) && (!TextUtils.isEmpty((CharSequence)localLocalMediaInfo.path)))
        {
          Map localMap = (Map)localHashMap;
          String str = localLocalMediaInfo.path;
          Intrinsics.checkExpressionValueIsNotNull(str, "localMediaInfo.path");
          localMap.put(str, localLocalMediaInfo);
          localArrayList.add(localLocalMediaInfo.path);
        }
      }
      localBundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", (Serializable)localHashMap);
      localBundle.putSerializable("PhotoConst.PHOTO_PATHS", (Serializable)localArrayList);
    }
    localBundle.putBoolean("IS_FROM_CAPTURE", this.o);
    ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).launchAEMultiCameraFromFlash(paramContext, localBundle);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  @NotNull
  public final LiveData<MenuType> c()
  {
    return (LiveData)this.c;
  }
  
  @NotNull
  public final LiveData<WinkTavCutDelegate.WinkTavCutParams> d()
  {
    return (LiveData)this.d;
  }
  
  @Nullable
  public final String e()
  {
    return this.g;
  }
  
  @Nullable
  public final ArrayList<LocalMediaInfo> f()
  {
    return this.h;
  }
  
  @Nullable
  public final ArrayList<LocalMediaInfo> g()
  {
    return this.i;
  }
  
  @Nullable
  public final String h()
  {
    return this.j;
  }
  
  @NotNull
  public final MutableLiveData<Long> i()
  {
    return this.l;
  }
  
  public final boolean j()
  {
    return this.m;
  }
  
  public final int k()
  {
    return this.n;
  }
  
  public final boolean l()
  {
    return this.o;
  }
  
  public final boolean m()
  {
    return this.q;
  }
  
  @NotNull
  public final WinkEditorViewModel.EditMode n()
  {
    return this.r;
  }
  
  @Nullable
  public final String o()
  {
    return this.s;
  }
  
  public final void p()
  {
    a(MenuType.BOTTOM_DASHBOARD);
  }
  
  public final int q()
  {
    if (this.r == WinkEditorViewModel.EditMode.Video) {
      return 0;
    }
    return 1;
  }
  
  public final boolean r()
  {
    return this.n == 3;
  }
  
  public final boolean s()
  {
    return this.n == 2;
  }
  
  public final int t()
  {
    return this.n;
  }
  
  public final boolean u()
  {
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorViewModel
 * JD-Core Version:    0.7.0.1
 */