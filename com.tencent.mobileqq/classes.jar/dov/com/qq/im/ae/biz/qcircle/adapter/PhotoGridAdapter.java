package dov.com.qq.im.ae.biz.qcircle.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaScannerListener;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.ArrayUtils;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleShowPhotoPreviewEvent;
import dov.com.qq.im.ae.util.AEQLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class PhotoGridAdapter
  extends RecyclerView.Adapter<PhotoGridAdapter.PhotoVH>
  implements URLDrawableDownListener, MediaScanner.OnMediaScannerListener
{
  public int a;
  private final Context jdField_a_of_type_AndroidContentContext;
  public ColorDrawable a;
  public Drawable a;
  GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  public LayoutInflater a;
  AECirclePhotoListLogic jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic;
  public ArrayList<LocalMediaInfo> a;
  private boolean jdField_a_of_type_Boolean = true;
  public int b;
  int c;
  public int d = 1;
  
  public PhotoGridAdapter(Context paramContext, RecyclerView paramRecyclerView, AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = ((GridLayoutManager)paramRecyclerView.getLayoutManager());
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic = paramAECirclePhotoListLogic;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    paramContext = paramContext.getResources();
    int i = paramContext.getDisplayMetrics().widthPixels;
    this.c = paramContext.getDimensionPixelSize(2131296712);
    this.jdField_a_of_type_Int = ((i - this.c * 2) / 3);
    this.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.setSpanSizeLookup(new PhotoGridAdapter.1(this));
  }
  
  private int a()
  {
    return this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().maxSelectNum;
  }
  
  private int a(int paramInt)
  {
    return paramInt + 1 + c();
  }
  
  private void a(int paramInt, LocalMediaInfo paramLocalMediaInfo, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    boolean bool = false;
    AEQLog.a("PhotoGridAdapter", "[setSelected], path=" + paramLocalMediaInfo.path);
    paramPhotoVH.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoItemClickListener.onClick(paramPhotoVH.jdField_a_of_type_AndroidViewView);
    paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (c() > 0) {
      bool = true;
    }
    AEReportUtils.a(bool, true, getItemViewType(paramInt), paramInt);
  }
  
  private void a(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH, LocalMediaInfo paramLocalMediaInfo)
  {
    if (AppSetting.d)
    {
      paramLocalMediaInfo = QAlbumUtil.createContentDescriptionWithCheckBox(QAlbumUtil.getMediaType(paramLocalMediaInfo), paramLocalMediaInfo, paramInt, paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription(paramLocalMediaInfo);
    }
  }
  
  private void a(PhotoGridAdapter.PhotoVH paramPhotoVH, LocalMediaInfo paramLocalMediaInfo, int paramInt)
  {
    if (a(paramInt))
    {
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(a(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.indexOf(paramLocalMediaInfo.path)));
      paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    if (paramInt == 3)
    {
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(List<LocalMediaInfo> paramList, int paramInt)
  {
    paramList = new AECircleShowPhotoPreviewEvent(paramList, paramInt);
    SimpleEventBus.getInstance().dispatchEvent(paramList);
  }
  
  private boolean a()
  {
    return b() >= a();
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  private int b()
  {
    return d() + c();
  }
  
  private void b()
  {
    Object localObject;
    if (this.d == 1) {
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = new LocalMediaInfo();
        ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
        this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject);
      }
    }
    for (;;)
    {
      return;
      LocalMediaInfo localLocalMediaInfo;
      if (this.d == 2)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
          if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 1)) {
            ((Iterator)localObject).remove();
          }
        }
      }
      else if (this.d == 3)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localLocalMediaInfo = (LocalMediaInfo)((Iterator)localObject).next();
          if ((localLocalMediaInfo != null) && (QAlbumUtil.getMediaType(localLocalMediaInfo) == 0)) {
            ((Iterator)localObject).remove();
          }
        }
      }
    }
  }
  
  private void b(int paramInt, LocalMediaInfo paramLocalMediaInfo, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    paramPhotoVH.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoItemClickListener.onClick(paramPhotoVH.jdField_a_of_type_AndroidViewView);
    AEQLog.a("PhotoGridAdapter", "cancelSelected path = " + paramLocalMediaInfo.path);
    paramPhotoVH.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    if (c() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      AEReportUtils.a(bool, false, getItemViewType(paramInt), paramInt);
      return;
    }
  }
  
  private void b(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    AEQLog.a("PhotoGridAdapter", "handlePhotoItemClick, position = " + paramInt);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked())
    {
      AEQLog.a("PhotoGridAdapter", "没有选中，点击后变选中, position = " + paramInt);
      a(paramInt, localLocalMediaInfo, paramPhotoVH);
      return;
    }
    AEQLog.a("PhotoGridAdapter", "选中，点击后变未选中, position = " + paramInt);
    b(paramInt, localLocalMediaInfo, paramPhotoVH);
  }
  
  private void b(PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    if ((paramPhotoVH == null) || (paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView == null) || (paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox == null)) {
      return;
    }
    paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(false);
  }
  
  private int c()
  {
    return this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().initialHasPickedNum;
  }
  
  private void c()
  {
    boolean bool = a();
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    if ((j == -1) || (k == -1)) {
      return;
    }
    QLog.d("PhotoGridAdapter", 2, "notifyLimitState,startPosition:" + j + "，endPosition:" + k);
    int i = j;
    label71:
    if (i <= k) {
      if (getItemViewType(i) != 2) {
        break label92;
      }
    }
    for (;;)
    {
      i += 1;
      break label71;
      break;
      label92:
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = a(i);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoGridAdapter", 2, "notifyLimitState view = null at " + i);
        }
      }
      else if (localLocalMediaInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoGridAdapter", 2, "notifyLimitState info = null at " + i);
        }
      }
      else
      {
        localObject = (PhotoGridAdapter.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
        if (((!bool) || (a(localLocalMediaInfo.selectStatus))) && (!a(localLocalMediaInfo)) && (!b(localLocalMediaInfo))) {
          b((PhotoGridAdapter.PhotoVH)localObject);
        } else {
          c((PhotoGridAdapter.PhotoVH)localObject);
        }
      }
    }
  }
  
  private void c(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().canPickVideo)
    {
      LocalMediaInfo localLocalMediaInfo = a(paramInt);
      if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a(this.jdField_a_of_type_AndroidContentContext, localLocalMediaInfo)) {
        a(paramInt, paramPhotoVH);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131689798), 0).a();
  }
  
  private void c(PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    if ((paramPhotoVH == null) || (paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView == null) || (paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox == null)) {
      return;
    }
    paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.3F);
    paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setActivated(true);
  }
  
  private int d()
  {
    return this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.size();
  }
  
  public View a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.b(42.0F)));
    return localFrameLayout;
  }
  
  public TextView a()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setGravity(17);
    localTextView.setTextSize(11.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(ViewUtils.b(26.0F), ViewUtils.b(16.0F));
    int i = ViewUtils.b(4.0F);
    localGradientDrawable.setCornerRadii(new float[] { i, i, i, i, i, i, i, i });
    localGradientDrawable.setColor(1291845632);
    localTextView.setBackgroundDrawable(localGradientDrawable);
    return localTextView;
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    if (ArrayUtils.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) {
      return null;
    }
    return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public PhotoGridAdapter.PhotoVH a(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new PhotoGridAdapter.PhotoVH(this, a());
    case 0: 
      return new PhotoGridAdapter.PhotoVH(this, b());
    case 1: 
      return new PhotoGridAdapter.PhotoVH(this, c());
    }
    return new PhotoGridAdapter.PhotoVH(this, d());
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694869, new Object[] { Integer.valueOf(a()) });
  }
  
  public void a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList;
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    if ((j == -1) || (k == -1)) {
      return;
    }
    QLog.d("PhotoGridAdapter", 2, "notifyCheckBox,startPosition:" + j + "，endPosition:" + k);
    int i = j;
    if (i <= k)
    {
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (PhotoGridAdapter.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
        if ((localObject != null) && (((PhotoGridAdapter.PhotoVH)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null) && (((PhotoGridAdapter.PhotoVH)localObject).jdField_b_of_type_AndroidWidgetImageView != null))
        {
          LocalMediaInfo localLocalMediaInfo = a(i);
          int m = localArrayList.indexOf(localLocalMediaInfo.path);
          if (m >= 0)
          {
            ((PhotoGridAdapter.PhotoVH)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(a(m));
            ((PhotoGridAdapter.PhotoVH)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            a(i, (PhotoGridAdapter.PhotoVH)localObject, localLocalMediaInfo);
          }
          else
          {
            ((PhotoGridAdapter.PhotoVH)localObject).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
            ((PhotoGridAdapter.PhotoVH)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
      }
    }
    c();
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  protected void a(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    AEQLog.a("PhotoGridAdapter", "handleVideoItemClickForMix, position = " + paramInt);
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if (!paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked())
    {
      AEQLog.a("PhotoGridAdapter", "没有选中，点击后变选中, position = " + paramInt);
      a(paramInt, localLocalMediaInfo, paramPhotoVH);
      return;
    }
    AEQLog.a("PhotoGridAdapter", "选中，点击后变未选中, position = " + paramInt);
    b(paramInt, localLocalMediaInfo, paramPhotoVH);
  }
  
  public void a(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH, PhotoGridAdapter.PhotoItemClickListener paramPhotoItemClickListener)
  {
    paramPhotoVH.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoItemClickListener = paramPhotoItemClickListener;
    if (paramPhotoVH.jdField_a_of_type_AndroidViewView != null) {
      paramPhotoVH.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    paramPhotoVH.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoItemClickListener.a(paramInt);
    paramPhotoVH.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoItemClickListener.a(paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    paramPhotoItemClickListener = paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView;
    paramPhotoItemClickListener.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = a(paramInt);
    Object localObject = QAlbumUtil.createContentDescription(0, localLocalMediaInfo, paramInt);
    paramPhotoVH.itemView.setContentDescription((CharSequence)localObject);
    if (localLocalMediaInfo != null)
    {
      if (!a(localLocalMediaInfo)) {
        break label465;
      }
      if (paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView == null)
      {
        paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView = a();
        paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView.setText("GIF");
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(11);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, ViewUtils.b(4.0F), ViewUtils.b(4.0F));
        ((RelativeLayout)paramPhotoVH.itemView).addView(paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      }
      paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      int i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      localObject = paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable;
      StringBuilder localStringBuilder = new StringBuilder("albumthumb");
      localStringBuilder.append("://");
      localStringBuilder.append(localLocalMediaInfo.path);
      if ((localObject == null) || (!((URLDrawable)localObject).getURL().toString().equals(localStringBuilder.toString())))
      {
        localObject = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo);
        if (QLog.isColorLevel()) {
          QLog.d("PhotoGridAdapter", 2, "photoGridAdapter,getView(),image url :" + ((URL)localObject).toString());
        }
        localObject = URLDrawableHelper.getDrawable((URL)localObject, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((URLDrawable)localObject).setTag(localLocalMediaInfo);
        paramPhotoItemClickListener.setImageDrawable((Drawable)localObject);
        ((URLImageView)paramPhotoItemClickListener).setURLDrawableDownListener(this);
        paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
      }
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      i = localLocalMediaInfo.selectStatus;
      a(paramPhotoVH, localLocalMediaInfo, i);
      a(paramInt, paramPhotoVH, localLocalMediaInfo);
      if (((!a()) || (a(i))) && (!a(localLocalMediaInfo))) {
        break label484;
      }
      c(paramPhotoVH);
    }
    for (;;)
    {
      paramPhotoVH.itemView.setOnClickListener(new PhotoGridAdapter.3(this, localLocalMediaInfo, paramInt));
      paramPhotoItemClickListener = new PhotoGridAdapter.4(this, localLocalMediaInfo, paramPhotoVH, paramInt);
      paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnClickListener(paramPhotoItemClickListener);
      paramPhotoVH.jdField_a_of_type_AndroidViewView.setOnClickListener(paramPhotoItemClickListener);
      return;
      label465:
      if (paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView == null) {
        break;
      }
      paramPhotoVH.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label484:
      b(paramPhotoVH);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a.selectedPhotoList;
    int j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
    int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
    int i = j;
    if (i <= k)
    {
      if ((paramBoolean) && (paramInt != i)) {}
      Object localObject1;
      int m;
      label221:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          localObject2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
          localObject1 = a(i);
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhotoGridAdapter", 2, "updateCheckbox view = null at " + i);
            }
          }
          else if (localObject1 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PhotoGridAdapter", 2, "updateCheckbox info = null at " + i);
            }
          }
          else
          {
            if (paramInt == i) {
              break label221;
            }
            m = localArrayList.indexOf(((LocalMediaInfo)localObject1).path);
            if (m >= 0)
            {
              localObject1 = (PhotoGridAdapter.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject2);
              if ((localObject1 != null) && (((PhotoGridAdapter.PhotoVH)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)) {
                ((PhotoGridAdapter.PhotoVH)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(a(m));
              }
            }
          }
        }
        m = QAlbumUtil.getMediaType((LocalMediaInfo)localObject1);
      } while ((m != 0) && (m != 1));
      Object localObject2 = (PhotoGridAdapter.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject2);
      if (a(((LocalMediaInfo)localObject1).selectStatus)) {
        ((PhotoGridAdapter.PhotoVH)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(a(localArrayList.indexOf(((LocalMediaInfo)localObject1).path)));
      }
      for (;;)
      {
        a(i, (PhotoGridAdapter.PhotoVH)localObject2, (LocalMediaInfo)localObject1);
        break;
        ((PhotoGridAdapter.PhotoVH)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
    }
  }
  
  public void a(View paramView, int paramInt, CheckBox paramCheckBox)
  {
    int i = 2;
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoGridAdapter", 2, "current select count:" + d());
    }
    paramView = a(paramInt);
    int j = paramView.selectStatus;
    if ((!a(j)) && (a()))
    {
      long l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().lastTimeShowToast >= 1000L)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, a(paramView), 0).a();
        paramCheckBox.setChecked(false);
        this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().lastTimeShowToast = l;
      }
      return;
    }
    String str;
    if (!a(j))
    {
      bool1 = true;
      if (bool1) {
        i = 1;
      }
      paramView.selectStatus = i;
      str = paramView.path;
      paramCheckBox = PresendPicMgr.a();
      if (!bool1) {
        break label487;
      }
      paramCheckBox = MimeHelper.getMimeType(paramView.mMimeType);
      if ((this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().isSupportVideoCheckbox) && (paramCheckBox != null) && ("video".equals(paramCheckBox[0])))
      {
        paramCheckBox = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a();
        paramCheckBox.videoSelectedCnt += 1;
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().videoSelectedCnt == 1) {
          this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedVideoInfo = paramView;
        }
      }
      if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
      {
        paramCheckBox = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a();
        paramCheckBox.gifSelectedCount += 1;
      }
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.add(str);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedIndex.add(paramView.position);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.put(str, paramView);
      paramCheckBox = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId);
      paramView = paramCheckBox;
      if (paramCheckBox == null)
      {
        paramView = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId, paramView);
      }
      paramView.put(str, Integer.valueOf(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition()));
      paramView = AlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(str)) {
        paramView.put(str, new Pair(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId, this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumName));
      }
      label458:
      a(paramInt, bool1);
      if (bool1) {
        break label734;
      }
    }
    label734:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      b(bool1);
      return;
      bool1 = false;
      break;
      label487:
      Object localObject = MimeHelper.getMimeType(paramView.mMimeType);
      if ((this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().isSupportVideoCheckbox) && (localObject != null) && ("video".equals(localObject[0])))
      {
        localObject = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject).videoSelectedCnt -= 1;
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().videoSelectedCnt == 1) {
          this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedVideoInfo = paramView;
        }
      }
      if ((!TextUtils.isEmpty(paramView.mMimeType)) && ("image/gif".equals(paramView.mMimeType)))
      {
        localObject = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject).gifSelectedCount -= 1;
      }
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.remove(str);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedIndex.remove(paramView.position);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.remove(str);
      if (paramCheckBox != null) {
        paramCheckBox.b(str, 1013);
      }
      paramView = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId);
      if (paramView != null) {
        paramView.remove(str);
      }
      paramView = AlbumUtil.sSelectItemAlbum;
      if (!paramView.containsKey(str)) {
        break label458;
      }
      paramView.remove(str);
      break label458;
    }
  }
  
  public void a(PhotoGridAdapter.PhotoVH paramPhotoVH)
  {
    paramPhotoVH.itemView.setOnClickListener(new PhotoGridAdapter.7(this));
  }
  
  public void a(PhotoGridAdapter.PhotoVH paramPhotoVH, int paramInt)
  {
    PhotoGridAdapter.PhotoItemClickListener localPhotoItemClickListener = new PhotoGridAdapter.PhotoItemClickListener(this);
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramPhotoVH, paramInt, getItemId(paramInt));
      return;
      a(paramInt, paramPhotoVH, localPhotoItemClickListener);
      continue;
      b(paramInt, paramPhotoVH, localPhotoItemClickListener);
      continue;
      a(paramPhotoVH);
    }
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    b();
    ThreadManager.getUIHandler().post(new PhotoGridAdapter.2(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    return (paramLocalMediaInfo != null) && ("image/gif".equals(paramLocalMediaInfo.mMimeType));
  }
  
  public View b()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558494, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.b));
    return localView;
  }
  
  public void b(int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH, PhotoGridAdapter.PhotoItemClickListener paramPhotoItemClickListener)
  {
    if (paramPhotoVH.jdField_a_of_type_AndroidViewView != null) {
      paramPhotoVH.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    paramPhotoVH.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoItemClickListener = paramPhotoItemClickListener;
    paramPhotoItemClickListener = new PhotoGridAdapter.5(this, paramInt, paramPhotoVH);
    paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnClickListener(paramPhotoItemClickListener);
    paramPhotoVH.jdField_a_of_type_AndroidViewView.setOnClickListener(paramPhotoItemClickListener);
    paramPhotoVH.itemView.setOnClickListener(new PhotoGridAdapter.6(this, paramInt));
    paramPhotoVH.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoItemClickListener.a(paramInt);
    paramPhotoVH.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoGridAdapter$PhotoItemClickListener.a(paramPhotoVH.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    ImageView localImageView = paramPhotoVH.jdField_a_of_type_AndroidWidgetImageView;
    localImageView.setAdjustViewBounds(false);
    LocalMediaInfo localLocalMediaInfo = a(paramInt);
    paramPhotoItemClickListener = QAlbumUtil.createContentDescription(1, localLocalMediaInfo, paramInt);
    paramPhotoVH.itemView.setContentDescription(paramPhotoItemClickListener);
    if (localLocalMediaInfo.isSystemMeidaStore)
    {
      paramPhotoItemClickListener = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "VIDEO");
      int i = AlbumThumbDownloader.THUMB_WIDHT;
      localLocalMediaInfo.thumbHeight = i;
      localLocalMediaInfo.thumbWidth = i;
      URLDrawable localURLDrawable = paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(paramPhotoItemClickListener)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListAdapter,getView(),vedio url :" + paramPhotoItemClickListener.toString());
        }
        paramPhotoItemClickListener = URLDrawableHelper.getDrawable(paramPhotoItemClickListener, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        paramPhotoItemClickListener.setTag(localLocalMediaInfo);
        localImageView.setImageDrawable(paramPhotoItemClickListener);
        ((URLImageView)localImageView).setURLDrawableDownListener(this);
        paramPhotoVH.jdField_a_of_type_ComTencentImageURLDrawable = paramPhotoItemClickListener;
      }
      paramPhotoItemClickListener = paramPhotoVH.jdField_a_of_type_AndroidWidgetTextView;
      if ((localLocalMediaInfo.isSystemMeidaStore) || (localLocalMediaInfo.mDuration > 0L)) {
        break label376;
      }
      paramPhotoItemClickListener.setVisibility(8);
      paramPhotoItemClickListener = MediaScanner.getInstance(BaseApplicationImpl.getContext());
      if (paramPhotoItemClickListener != null) {
        paramPhotoItemClickListener.queryMediaInfoDuration(this, localLocalMediaInfo, paramInt);
      }
      label299:
      i = localLocalMediaInfo.selectStatus;
      a(paramPhotoVH, localLocalMediaInfo, i);
      if (((!a()) || (a(i))) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().canPickVideo)) {
        break label416;
      }
      c(paramPhotoVH);
    }
    for (;;)
    {
      localLocalMediaInfo.visableTime = SystemClock.uptimeMillis();
      localLocalMediaInfo.listViewPosition = paramInt;
      return;
      paramPhotoItemClickListener = QAlbumUtil.generateAlbumThumbURL(localLocalMediaInfo, "APP_VIDEO");
      break;
      label376:
      paramPhotoItemClickListener.setVisibility(0);
      if (localLocalMediaInfo.mDuration < 1000L) {
        localLocalMediaInfo.mDuration = 1000L;
      }
      paramPhotoItemClickListener.setText(AbstractPhotoListActivity.formatTimeToString(localLocalMediaInfo.mDuration));
      break label299;
      label416:
      b(paramPhotoVH);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i = b();
    int j;
    if (((i == a()) && (!paramBoolean)) || ((i == a() - 1) && (paramBoolean)))
    {
      i = 1;
      if (i == 0) {
        return;
      }
      j = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findFirstVisibleItemPosition();
      int k = this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.findLastVisibleItemPosition();
      i = j;
      label56:
      if (i > k) {
        return;
      }
      if (getItemViewType(i) != 2) {
        break label83;
      }
    }
    for (;;)
    {
      i += 1;
      break label56;
      i = 0;
      break;
      label83:
      Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(i - j);
      LocalMediaInfo localLocalMediaInfo = a(i);
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoGridAdapter", 2, "updateCheckbox view = null at " + i);
        }
      }
      else if (localLocalMediaInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoGridAdapter", 2, "updateCheckbox info = null at " + i);
        }
      }
      else
      {
        localObject = (PhotoGridAdapter.PhotoVH)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder((View)localObject);
        if (((paramBoolean) || (a(localLocalMediaInfo.selectStatus))) && (!a(localLocalMediaInfo))) {
          b((PhotoGridAdapter.PhotoVH)localObject);
        } else {
          c((PhotoGridAdapter.PhotoVH)localObject);
        }
      }
    }
  }
  
  public boolean b(LocalMediaInfo paramLocalMediaInfo)
  {
    return (QAlbumUtil.getMediaType(paramLocalMediaInfo) == 1) && (!this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().canPickVideo);
  }
  
  public View c()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558497, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(this.jdField_a_of_type_Int, this.b));
    return localView;
  }
  
  public View d()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
    localFrameLayout.setBackgroundColor(-1315856);
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localImageView.setImageResource(2130844196);
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(ViewUtils.b(40.0F), ViewUtils.b(40.0F));
    localLayoutParams.gravity = 17;
    localFrameLayout.addView(localImageView, localLayoutParams);
    return localFrameLayout;
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (ArrayUtils.a(paramInt, this.jdField_a_of_type_JavaUtilArrayList)) {
      return -1;
    }
    return QAlbumUtil.getMediaType((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    new Rect();
    paramView = (LocalMediaInfo)paramURLDrawable.getTag();
    int i = paramView.listViewPosition;
    if ((i == -1) || (paramView.visableTime == 0L)) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      l2 = paramView.visableTime;
    } while (!QLog.isColorLevel());
    QLog.d("PhotoGridAdapter", 2, "onLoadSuccessed,no next ,listViewPositon:" + i + " costTime:" + (l1 - l2) + " imageInfo;" + paramView);
  }
  
  public void onPhotoListDatasetDurationChanged(int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.adapter.PhotoGridAdapter
 * JD-Core Version:    0.7.0.1
 */