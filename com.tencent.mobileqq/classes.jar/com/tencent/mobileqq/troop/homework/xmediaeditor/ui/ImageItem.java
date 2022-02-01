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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.utils.AlbumUtil;
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
  protected ColorDrawable a;
  protected String a;
  protected Map<ImageInfo, Stream<ImageInfo>> a;
  protected boolean a;
  
  public ImageItem(XMediaEditor paramXMediaEditor)
  {
    super(paramXMediaEditor);
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#DEDEDE"));
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      paramInt1 = paramView.getPaddingLeft() + paramView.getPaddingRight() + paramInt1;
      paramInt2 = paramView.getPaddingTop() + paramView.getPaddingBottom() + paramInt2;
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams == null) {
        break label77;
      }
      if ((localLayoutParams.width != paramInt1) || (localLayoutParams.height != paramInt2))
      {
        localLayoutParams.width = paramInt1;
        localLayoutParams.height = paramInt2;
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    return;
    label77:
    paramView.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
  }
  
  private void a(ImageInfo paramImageInfo, boolean paramBoolean)
  {
    paramImageInfo.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getWidth();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() > 0) {
      paramImageInfo.jdField_d_of_type_Int -= this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() * 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemAdded. editor getWidth result: ", Integer.valueOf(paramImageInfo.jdField_d_of_type_Int) });
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyDataSetChanged();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.d() == 0) && (paramImageInfo.b())) {
      a(paramImageInfo);
    }
  }
  
  public static boolean a(XMediaEditor paramXMediaEditor, Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent != null) {}
    for (Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"); (localObject == null) || (((ArrayList)localObject).size() == 0); localObject = null)
    {
      QLog.e("ImageItem", 1, "selected list empty!");
      return paramBoolean;
    }
    HashMap localHashMap = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    int i;
    ArrayList localArrayList;
    label116:
    int j;
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder().append("selected pic or video! size = ");
      if (localHashMap != null)
      {
        i = localHashMap.size();
        QLog.d("ImageItem", 2, i);
      }
    }
    else
    {
      localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label216;
      }
      paramIntent = (String)((Iterator)localObject).next();
      if (localHashMap == null) {
        break label423;
      }
      if (AlbumUtil.getMediaType((LocalMediaInfo)localHashMap.get(paramIntent)) != 1) {
        break label198;
      }
      j = 1;
    }
    for (;;)
    {
      label163:
      if (j != 0)
      {
        paramIntent = new VideoInfo(paramIntent);
        i += 1;
      }
      for (;;)
      {
        localArrayList.add(paramIntent);
        break label116;
        i = 0;
        break;
        label198:
        j = 0;
        break label163;
        paramIntent = new ImageInfo(paramIntent);
      }
      label216:
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "video selected! size = ", Integer.valueOf(i), ". pic selected! size = ", Integer.valueOf(localArrayList.size() - i) });
      }
      paramIntent = paramXMediaEditor.getContext();
      if (!NetworkUtil.d(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, "no network toast from select media");
        }
        QQToast.a(paramIntent, 2131697207, 0).a();
        return paramBoolean;
      }
      if ((i > 0) && (!NetworkUtil.h(paramIntent)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "no wifi. hasShownNetworkTip=", Boolean.valueOf(paramBoolean) });
        }
        if (!paramBoolean)
        {
          DialogUtil.a(paramIntent, 230, paramXMediaEditor.getResources().getString(2131695677), paramXMediaEditor.getResources().getString(2131695673), 2131695411, 2131695423, new ImageItem.3(paramXMediaEditor, localArrayList), new ImageItem.4()).show();
          return true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, "insertEditItemList.");
      }
      paramXMediaEditor.a(localArrayList);
      return paramBoolean;
      label423:
      j = 0;
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt4;
    arrayOfInt[1] = paramInt5;
    if ((paramInt4 > 0) && (paramInt5 > 0)) {
      if (paramInt4 > paramInt3)
      {
        arrayOfInt[0] = paramInt1;
        arrayOfInt[1] = ((int)(paramInt1 * 1.0F * paramInt5 / paramInt4));
      }
    }
    do
    {
      do
      {
        return arrayOfInt;
      } while (Math.min(paramInt4, paramInt5) >= paramInt2);
      if (paramInt4 <= paramInt5)
      {
        arrayOfInt[0] = paramInt2;
        arrayOfInt[1] = ((int)(paramInt2 * 1.0F * paramInt5 / paramInt4));
        return arrayOfInt;
      }
      arrayOfInt[0] = ((int)(paramInt2 * 1.0F * paramInt4 / paramInt5));
      arrayOfInt[1] = paramInt2;
      return arrayOfInt;
      arrayOfInt[0] = paramInt1;
      arrayOfInt[1] = ((int)(paramInt1 * 9 / 16.0F));
    } while (!QLog.isColorLevel());
    QLog.d("ImageItem", 2, new Object[] { "calculateMaxMinImageSize doudi. maxWidth=", Integer.valueOf(arrayOfInt[0]), ", height=", Integer.valueOf(arrayOfInt[1]) });
    return arrayOfInt;
  }
  
  public ImageItem.ImageViewHolder a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new ImageItem.ImageViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560776, paramViewGroup, false));
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "Image onCreateViewHolder. vh hash=", Integer.valueOf(paramViewGroup.hashCode()) });
    }
    b(paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView, paramViewGroup);
    b(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, paramViewGroup);
    b(paramViewGroup.b, paramViewGroup);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a() != 0) {
      paramViewGroup.itemView.setPadding(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(), 0);
    }
    return paramViewGroup;
  }
  
  protected SimpleObserver<ImageInfo> a(ImageInfo paramImageInfo)
  {
    return new ImageItem.2(this, paramImageInfo);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ImageInfo)localIterator.next();
        localObject = (Stream)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if (localObject != null) {
          ((Stream)localObject).cancel();
        }
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "scheduleStream. hasNext=", Boolean.valueOf(((Iterator)localObject).hasNext()) });
    }
    ImageInfo localImageInfo;
    if (paramBoolean) {
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localImageInfo = (ImageInfo)((Iterator)localObject).next();
      } while (localImageInfo.g == 2);
    }
    for (;;)
    {
      if (localImageInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageItem", 2, new Object[] { "scheduleStream. next info position=", Integer.valueOf(localImageInfo.c), ", type=", Integer.valueOf(localImageInfo.b()), ", hash=", Integer.valueOf(localImageInfo.hashCode()) });
        }
        localObject = (Stream)this.jdField_a_of_type_JavaUtilMap.get(localImageInfo);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ImageItem", 2, new Object[] { "scheduleStream. fire stream. info hash=", Integer.valueOf(localImageInfo.hashCode()) });
          }
          this.jdField_a_of_type_JavaLangString = localImageInfo.jdField_d_of_type_JavaLangString;
          this.jdField_a_of_type_Boolean = true;
          localImageInfo.jdField_a_of_type_Long = System.currentTimeMillis();
          ((Stream)localObject).subscribe(a(localImageInfo));
        }
        return;
        if (((Iterator)localObject).hasNext()) {
          localImageInfo = (ImageInfo)((Iterator)localObject).next();
        }
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      localImageInfo = null;
    }
  }
  
  public void a(View paramView, ImageItem.ImageViewHolder paramImageViewHolder)
  {
    ImageInfo localImageInfo = (ImageInfo)paramImageViewHolder.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase;
    switch (paramView.getId())
    {
    case 2131368481: 
    case 2131368482: 
    default: 
    case 2131368479: 
    case 2131368483: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiEditItemBase$OnEditItemListener.a(paramImageViewHolder);
        return;
      } while (localImageInfo.g != 2);
      paramImageViewHolder.b.setVisibility(4);
      a(localImageInfo);
      return;
    }
    InputMethodUtil.a((Activity)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("ImageItem", 2, new Object[] { "onItemViewClick preview. info position=", Integer.valueOf(localImageInfo.c), ", path=", localImageInfo.jdField_a_of_type_JavaLangString });
    }
    TroopNoticeJsHandler.a((BaseActivity)paramView.getContext(), localImageInfo.a());
  }
  
  public void a(EditItemInfoBase paramEditItemInfoBase)
  {
    paramEditItemInfoBase = (ImageInfo)paramEditItemInfoBase;
    if (paramEditItemInfoBase.b()) {
      a(paramEditItemInfoBase);
    }
  }
  
  protected void a(ImageInfo paramImageInfo)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
    }
    Stream localStream = paramImageInfo.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramImageInfo)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramImageInfo, localStream);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = paramImageInfo.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Boolean = true;
      paramImageInfo.jdField_a_of_type_Long = System.currentTimeMillis();
      localStream.subscribe(a(paramImageInfo));
    }
  }
  
  public void a(ImageItem.ImageViewHolder paramImageViewHolder, EditItemInfoBase paramEditItemInfoBase, int paramInt)
  {
    if (QLog.isColorLevel()) {
      if (!(paramEditItemInfoBase instanceof VideoInfo)) {
        break label79;
      }
    }
    ImageInfo localImageInfo;
    label79:
    for (Object localObject = "Video";; localObject = "Image")
    {
      QLog.d("ImageItem", 2, new Object[] { localObject, " onBindViewHolder. vh hash=", Integer.valueOf(paramImageViewHolder.hashCode()) });
      localImageInfo = (ImageInfo)paramEditItemInfoBase;
      if (localImageInfo.jdField_d_of_type_Int > 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, "onBindViewHolder maxWidth fail. return");
      }
      return;
    }
    paramImageViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setTag(localImageInfo.jdField_d_of_type_JavaLangString);
    int i;
    String str;
    int j;
    if (QLog.isColorLevel())
    {
      i = localImageInfo.hashCode();
      str = localImageInfo.jdField_d_of_type_JavaLangString;
      j = localImageInfo.c;
      if (localImageInfo.jdField_a_of_type_JavaNetURL != null) {
        break label499;
      }
      paramEditItemInfoBase = "null";
      label138:
      if (paramImageViewHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        break label508;
      }
    }
    label499:
    label508:
    for (localObject = "null";; localObject = paramImageViewHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL())
    {
      QLog.d("ImageItem", 2, new Object[] { "onBindViewHolder. VHHash=", paramImageViewHolder, ", infoHash=", Integer.valueOf(i), ", progressKey=", str, ", infoPosition=", Integer.valueOf(j), ", info URL=", paramEditItemInfoBase, ", vh URL=", localObject, ", showType=", Integer.valueOf(paramInt) });
      paramEditItemInfoBase = a(localImageInfo.jdField_d_of_type_Int, 200, 300, localImageInfo.jdField_a_of_type_Int, localImageInfo.b);
      if (QLog.isColorLevel()) {
        QLog.d("ImageItem", 2, new Object[] { "onBindViewHolder calculateMaxWidth. infoMaxWidth=", Integer.valueOf(localImageInfo.jdField_d_of_type_Int), ", infoWidth=", Integer.valueOf(localImageInfo.jdField_a_of_type_Int), ", infoHeight=", Integer.valueOf(localImageInfo.b), ", dstWidth=", Integer.valueOf(paramEditItemInfoBase[0]), ", dstHeight=", Integer.valueOf(paramEditItemInfoBase[1]) });
      }
      a(paramImageViewHolder.jdField_a_of_type_AndroidViewView, paramEditItemInfoBase[0], paramEditItemInfoBase[1]);
      a(paramImageViewHolder, localImageInfo, paramInt);
      if ((localImageInfo.jdField_a_of_type_JavaNetURL == null) || (localImageInfo.g == -2147483645)) {
        break label520;
      }
      localObject = paramImageViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getDrawable();
      if (((localObject instanceof URLDrawable)) && (localImageInfo.jdField_a_of_type_JavaNetURL.equals(((URLDrawable)localObject).getURL()))) {
        break;
      }
      paramEditItemInfoBase = URLDrawable.getDrawable(localImageInfo.jdField_a_of_type_JavaNetURL, paramEditItemInfoBase[0], paramEditItemInfoBase[1], this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      paramImageViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramEditItemInfoBase);
      if (paramEditItemInfoBase.getStatus() != 2) {
        break;
      }
      paramEditItemInfoBase.restartDownload();
      return;
      paramEditItemInfoBase = localImageInfo.jdField_a_of_type_JavaNetURL;
      break label138;
    }
    label520:
    paramImageViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
  }
  
  protected <VH extends ImageItem.ImageViewHolder, INFO extends ImageInfo> void a(VH paramVH, INFO paramINFO, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramVH.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      paramVH.b.setVisibility(4);
      paramVH.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
    }
    do
    {
      return;
      paramVH.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (paramINFO.g)
      {
      default: 
        return;
      case 1: 
        paramVH.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
        paramVH.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
        paramVH.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramINFO.e, paramINFO.jdField_d_of_type_JavaLangString);
        paramVH.b.setVisibility(4);
        return;
      case 2: 
        paramVH.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(4);
        paramVH.b.setVisibility(0);
        return;
      }
    } while (paramINFO.e != 100);
    paramVH.a();
  }
  
  public void b(EditItemInfoBase paramEditItemInfoBase)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getWidth();
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
    if ((this.jdField_a_of_type_JavaUtilMap != null) && (!this.jdField_a_of_type_JavaUtilMap.isEmpty()))
    {
      Stream localStream = (Stream)this.jdField_a_of_type_JavaUtilMap.get(paramEditItemInfoBase);
      if (localStream != null) {
        localStream.cancel();
      }
    }
    if (paramEditItemInfoBase.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      paramEditItemInfoBase.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (paramEditItemInfoBase.jdField_a_of_type_JavaNetURL != null) {
      URLDrawable.removeMemoryCacheByUrl(paramEditItemInfoBase.jdField_a_of_type_JavaNetURL.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem
 * JD-Core Version:    0.7.0.1
 */