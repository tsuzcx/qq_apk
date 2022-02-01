package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class ImageItem
  extends UploadEditItem<ImageItem.ImageViewHolder, EditItemInfoBase>
{
  protected ColorDrawable a = new ColorDrawable(Color.parseColor("#DEDEDE"));
  protected Map<ImageInfo, Stream<ImageInfo>> d;
  protected String e;
  protected boolean f;
  
  public ImageItem(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      paramInt1 = paramView.getPaddingLeft() + paramView.getPaddingRight() + paramInt1;
      paramInt2 = paramView.getPaddingTop() + paramView.getPaddingBottom() + paramInt2;
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams != null)
      {
        if ((localLayoutParams.width != paramInt1) || (localLayoutParams.height != paramInt2))
        {
          localLayoutParams.width = paramInt1;
          localLayoutParams.height = paramInt2;
          paramView.setLayoutParams(localLayoutParams);
        }
      }
      else {
        paramView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
      }
    }
  }
  
  private void a(ImageInfo paramImageInfo, boolean paramBoolean)
  {
    paramImageInfo.k = this.b.getWidth();
    if (this.b.getLeftRightPadding() > 0) {
      paramImageInfo.k -= this.b.getLeftRightPadding() * 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth result: ", Integer.valueOf(paramImageInfo.k) });
    }
    if (paramBoolean) {
      this.b.getAdapter().notifyDataSetChanged();
    }
    if ((this.b.getShowType() == 0) && (paramImageInfo.g())) {
      a(paramImageInfo);
    }
  }
  
  public static boolean a(XMediaEditor paramXMediaEditor, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject;
    if (paramIntent != null) {
      localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((ArrayList)localObject).size() != 0))
    {
      HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("selected pic or video! size = ");
        if (localHashMap != null) {
          i = localHashMap.size();
        } else {
          i = 0;
        }
        paramIntent.append(i);
        QLog.d("ImageItem", 2, paramIntent.toString());
      }
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        paramIntent = (String)((Iterator)localObject).next();
        int j;
        if ((localHashMap != null) && (QAlbumUtil.getMediaType((LocalMediaInfo)localHashMap.get(paramIntent)) == 1)) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0)
        {
          i += 1;
          paramIntent = new VideoInfo(paramIntent);
        }
        else
        {
          paramIntent = new ImageInfo(paramIntent);
        }
        localArrayList.add(paramIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "video selected! size = ", Integer.valueOf(i), ". pic selected! size = ", Integer.valueOf(localArrayList.size() - i) });
      }
      paramIntent = paramXMediaEditor.getContext();
      if (!NetworkUtil.isNetSupport(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, "no network toast from select media");
        }
        QQToast.makeText(paramIntent, 2131894999, 0).show();
        return paramBoolean;
      }
      if ((i > 0) && (!NetworkUtil.isWifiConnected(paramIntent)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "no wifi. hasShownNetworkTip=", Boolean.valueOf(paramBoolean) });
        }
        if (!paramBoolean)
        {
          DialogUtil.a(paramIntent, 230, paramXMediaEditor.getResources().getString(2131893450), paramXMediaEditor.getResources().getString(2131893446), 2131893167, 2131893180, new ImageItem.3(paramXMediaEditor, localArrayList), new ImageItem.4()).show();
          return true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, "insertEditItemList.");
      }
      paramXMediaEditor.a(localArrayList);
      return paramBoolean;
    }
    QLog.e("ImageItem", 1, "selected list empty!");
    return paramBoolean;
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt4;
    arrayOfInt[1] = paramInt5;
    if ((paramInt4 > 0) && (paramInt5 > 0))
    {
      if (paramInt4 > paramInt3)
      {
        arrayOfInt[0] = paramInt1;
        arrayOfInt[1] = ((int)(paramInt1 * 1.0F * paramInt5 / paramInt4));
        return arrayOfInt;
      }
      if (Math.min(paramInt4, paramInt5) < paramInt2)
      {
        if (paramInt4 <= paramInt5)
        {
          arrayOfInt[0] = paramInt2;
          arrayOfInt[1] = ((int)(paramInt2 * 1.0F * paramInt5 / paramInt4));
          return arrayOfInt;
        }
        arrayOfInt[0] = ((int)(paramInt2 * 1.0F * paramInt4 / paramInt5));
        arrayOfInt[1] = paramInt2;
        return arrayOfInt;
      }
    }
    else
    {
      arrayOfInt[0] = paramInt1;
      arrayOfInt[1] = ((int)(paramInt1 * 9 / 16.0F));
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "calculateMaxMinImageSize doudi. maxWidth=", Integer.valueOf(arrayOfInt[0]), ", height=", Integer.valueOf(arrayOfInt[1]) });
      }
    }
    return arrayOfInt;
  }
  
  public ImageItem.ImageViewHolder a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new ImageItem.ImageViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626707, paramViewGroup, false));
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "Image onCreateViewHolder. vh hash=", Integer.valueOf(paramViewGroup.hashCode()) });
    }
    b(paramViewGroup.b, paramViewGroup);
    b(paramViewGroup.c, paramViewGroup);
    b(paramViewGroup.d, paramViewGroup);
    if (this.b.getLeftRightPadding() != 0) {
      paramViewGroup.itemView.setPadding(this.b.getLeftRightPadding(), 0, this.b.getLeftRightPadding(), 0);
    }
    return paramViewGroup;
  }
  
  public void a()
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
    {
      localObject1 = this.d.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ImageInfo)((Iterator)localObject1).next();
        localObject2 = (Stream)this.d.get(localObject2);
        if (localObject2 != null) {
          ((Stream)localObject2).cancel();
        }
      }
      this.d.clear();
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.d.keySet().iterator();
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "scheduleStream. hasNext=", Boolean.valueOf(((Iterator)localObject).hasNext()) });
    }
    if (paramBoolean) {
      while (((Iterator)localObject).hasNext())
      {
        localImageInfo = (ImageInfo)((Iterator)localObject).next();
        if (localImageInfo.o != 2) {
          break label113;
        }
      }
    }
    while (!((Iterator)localObject).hasNext())
    {
      localImageInfo = null;
      break;
    }
    ImageInfo localImageInfo = (ImageInfo)((Iterator)localObject).next();
    label113:
    if (localImageInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "scheduleStream. next info position=", Integer.valueOf(localImageInfo.g), ", type=", Integer.valueOf(localImageInfo.b()), ", hash=", Integer.valueOf(localImageInfo.hashCode()) });
      }
      localObject = (Stream)this.d.get(localImageInfo);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "scheduleStream. fire stream. info hash=", Integer.valueOf(localImageInfo.hashCode()) });
        }
        this.e = localImageInfo.e;
        this.f = true;
        localImageInfo.n = System.currentTimeMillis();
        ((Stream)localObject).subscribe(b(localImageInfo));
      }
    }
    else
    {
      this.e = null;
      this.f = false;
    }
  }
  
  public void a(View paramView, ImageItem.ImageViewHolder paramImageViewHolder)
  {
    ImageInfo localImageInfo = (ImageInfo)paramImageViewHolder.f;
    int i = paramView.getId();
    if (i == 2131435095)
    {
      this.c.a(paramImageViewHolder);
      return;
    }
    if (i == 2131435099)
    {
      if (localImageInfo.o == 2)
      {
        paramImageViewHolder.d.setVisibility(4);
        a(localImageInfo);
      }
    }
    else if (i == 2131435096)
    {
      InputMethodUtil.a((Activity)this.b.getContext());
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localImageInfo.g), ", path=", localImageInfo.a });
      }
      ((ITroopHWApi)QRoute.api(ITroopHWApi.class)).showOnePicture((Activity)paramView.getContext(), localImageInfo.e());
    }
  }
  
  public void a(EditItemInfoBase paramEditItemInfoBase)
  {
    paramEditItemInfoBase = (ImageInfo)paramEditItemInfoBase;
    if (paramEditItemInfoBase.g()) {
      a(paramEditItemInfoBase);
    }
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    if (this.d == null) {
      this.d = new LinkedHashMap();
    }
    Stream localStream = paramImageInfo.a(this.b);
    if (!this.d.containsKey(paramImageInfo)) {
      this.d.put(paramImageInfo, localStream);
    }
    if (TextUtils.isEmpty(this.e))
    {
      this.e = paramImageInfo.e;
      this.f = true;
      paramImageInfo.n = System.currentTimeMillis();
      localStream.subscribe(b(paramImageInfo));
    }
  }
  
  public void a(ImageItem.ImageViewHolder paramImageViewHolder, EditItemInfoBase paramEditItemInfoBase, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if ((paramEditItemInfoBase instanceof VideoInfo)) {
        localObject = "Video";
      } else {
        localObject = "Image";
      }
      QLog.d("ImageItem", 2, new Object[] { localObject, " onBindViewHolder. vh hash=", Integer.valueOf(paramImageViewHolder.hashCode()) });
    }
    ImageInfo localImageInfo = (ImageInfo)paramEditItemInfoBase;
    if (localImageInfo.k <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, "onBindViewHolder maxWidth fail. return");
      }
      return;
    }
    paramImageViewHolder.g.setTag(localImageInfo.e);
    int i;
    if (QLog.isColorLevel())
    {
      i = localImageInfo.hashCode();
      String str = localImageInfo.e;
      int j = localImageInfo.g;
      paramEditItemInfoBase = localImageInfo.d;
      localObject = "null";
      if (paramEditItemInfoBase == null) {
        paramEditItemInfoBase = "null";
      } else {
        paramEditItemInfoBase = localImageInfo.d;
      }
      if (paramImageViewHolder.a != null) {
        localObject = paramImageViewHolder.a.getURL();
      }
      QLog.d("ImageItem", 2, new Object[] { "onBindViewHolder. VHHash=", paramImageViewHolder, ", infoHash=", Integer.valueOf(i), ", progressKey=", str, ", infoPosition=", Integer.valueOf(j), ", info URL=", paramEditItemInfoBase, ", vh URL=", localObject, ", showType=", Integer.valueOf(paramInt) });
    }
    paramEditItemInfoBase = a(localImageInfo.k, 200, 300, localImageInfo.f, localImageInfo.j);
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onBindViewHolder calculateMaxWidth. infoMaxWidth=", Integer.valueOf(localImageInfo.k), ", infoWidth=", Integer.valueOf(localImageInfo.f), ", infoHeight=", Integer.valueOf(localImageInfo.j), ", dstWidth=", Integer.valueOf(paramEditItemInfoBase[0]), ", dstHeight=", Integer.valueOf(paramEditItemInfoBase[1]) });
    }
    a(paramImageViewHolder.h, paramEditItemInfoBase[0], paramEditItemInfoBase[1]);
    a(paramImageViewHolder, localImageInfo, paramInt);
    if ((localImageInfo.d != null) && (localImageInfo.o != -2147483645))
    {
      localObject = paramImageViewHolder.b.getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!localImageInfo.d.equals(((URLDrawable)localObject).getURL())))
      {
        localObject = localImageInfo.d;
        paramInt = paramEditItemInfoBase[0];
        i = paramEditItemInfoBase[1];
        paramEditItemInfoBase = this.a;
        paramEditItemInfoBase = URLDrawable.getDrawable((URL)localObject, paramInt, i, paramEditItemInfoBase, paramEditItemInfoBase);
        paramImageViewHolder.b.setImageDrawable(paramEditItemInfoBase);
        if (paramEditItemInfoBase.getStatus() == 2) {
          paramEditItemInfoBase.restartDownload();
        }
      }
    }
    else
    {
      paramImageViewHolder.b.setImageDrawable(this.a);
    }
  }
  
  protected <VH extends ImageItem.ImageViewHolder, INFO extends ImageInfo> void a(VH paramVH, INFO paramINFO, int paramInt)
  {
    if (paramInt != 0)
    {
      paramVH.c.setVisibility(4);
      paramVH.d.setVisibility(4);
      paramVH.g.setVisibility(4);
      return;
    }
    paramVH.c.setVisibility(0);
    paramInt = paramINFO.o;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        if (paramINFO.l == 100) {
          paramVH.a();
        }
      }
      else
      {
        paramVH.g.setVisibility(4);
        paramVH.d.setVisibility(0);
      }
    }
    else
    {
      paramVH.g.setVisibility(0);
      paramVH.g.setDrawStatus(1);
      paramVH.g.setAnimProgress(paramINFO.l, paramINFO.e);
      paramVH.d.setVisibility(4);
    }
  }
  
  protected SimpleObserver<ImageInfo> b(ImageInfo paramImageInfo)
  {
    return new ImageItem.2(this, paramImageInfo);
  }
  
  public void b(EditItemInfoBase paramEditItemInfoBase)
  {
    int i = this.b.getWidth();
    if (i <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth fail result: ", Integer.valueOf(i) });
      }
      ThreadManager.getUIHandler().postDelayed(new ImageItem.1(this, paramEditItemInfoBase), 50L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth result without post: ", Integer.valueOf(i) });
    }
    a((ImageInfo)paramEditItemInfoBase, false);
  }
  
  public void d(EditItemInfoBase paramEditItemInfoBase)
  {
    paramEditItemInfoBase = (ImageInfo)paramEditItemInfoBase;
    Object localObject = this.d;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localObject = (Stream)this.d.get(paramEditItemInfoBase);
      if (localObject != null) {
        ((Stream)localObject).cancel();
      }
    }
    if (paramEditItemInfoBase.m != null) {
      paramEditItemInfoBase.m.clear();
    }
    if (paramEditItemInfoBase.d != null) {
      URLDrawable.removeMemoryCacheByUrl(paramEditItemInfoBase.d.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem
 * JD-Core Version:    0.7.0.1
 */