package dov.com.qq.im.ae.biz.qcircle.part;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.pull2refresh.PagerSnapHelper;
import com.tencent.widget.pull2refresh.PagerSnapHelper.PagerEventListener;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.biz.qcircle.AECircleMultiUnit;
import dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic;
import dov.com.qq.im.ae.biz.qcircle.adapter.PhotoPreviewAdapter;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleChangeBottomTabVisibleEvent;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleSelectChangeEvent;
import dov.com.qq.im.ae.biz.qcircle.event.AECircleShowPhotoPreviewEvent;
import dov.com.qq.im.ae.biz.qcircle.part.base.AECircleBasePart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AECirclePreviewPart
  extends AECircleBasePart
  implements View.OnClickListener, SimpleEventReceiver, PagerSnapHelper.PagerEventListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private NumberCheckBox jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
  private PagerSnapHelper jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
  private RecyclerViewCompat jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat;
  private PhotoPreviewAdapter jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoPreviewAdapter;
  private List<LocalMediaInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private FrameLayout b;
  
  public AECirclePreviewPart(AECirclePhotoListLogic paramAECirclePhotoListLogic)
  {
    super(paramAECirclePhotoListLogic);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a(this);
  }
  
  private RecyclerView.OnItemTouchListener a()
  {
    return new AECirclePreviewPart.1(this);
  }
  
  private boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (QAlbumUtil.getMediaType(paramLocalMediaInfo) == 1)
    {
      if (!this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().canPickVideo)
      {
        QQToast.a(a(), HardCodeUtil.a(2131689798), 0).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return false;
      }
      if (!this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a(a(), paramLocalMediaInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        return false;
      }
    }
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
    AECircleMultiUnit.a(a(), 0, true);
  }
  
  private void c()
  {
    Object localObject1 = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition());
    if (((LocalMediaInfo)localObject1).selectStatus == 1) {}
    do
    {
      long l;
      do
      {
        return;
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.size() + this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().initialHasPickedNum < this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().maxSelectNum) {
          break;
        }
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().lastTimeShowToast < 1000L);
      QQToast.a(a(), a((LocalMediaInfo)localObject1), 0).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().lastTimeShowToast = l;
      return;
    } while (!a((LocalMediaInfo)localObject1));
    ((LocalMediaInfo)localObject1).selectStatus = 1;
    String str = ((LocalMediaInfo)localObject1).path;
    Object localObject2 = MimeHelper.getMimeType(((LocalMediaInfo)localObject1).mMimeType);
    if ((this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
    {
      localObject2 = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a();
      ((PhotoListBaseData)localObject2).videoSelectedCnt += 1;
      if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().videoSelectedCnt == 1) {
        this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedVideoInfo = ((LocalMediaInfo)localObject1);
      }
    }
    if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject1).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject1).mMimeType)))
    {
      localObject2 = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a();
      ((PhotoListBaseData)localObject2).gifSelectedCount += 1;
    }
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.add(str);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedIndex.add(((LocalMediaInfo)localObject1).position);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.put(str, localObject1);
    localObject2 = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new LinkedHashMap();
      AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId, localObject1);
    }
    ((LinkedHashMap)localObject1).put(str, Integer.valueOf(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition()));
    localObject1 = AlbumUtil.sSelectItemAlbum;
    if (!((HashMap)localObject1).containsKey(str)) {
      ((HashMap)localObject1).put(str, new Pair(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId, this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumName));
    }
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
  }
  
  private void d()
  {
    LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition());
    int i = localLocalMediaInfo.selectStatus;
    if ((i != 1) && (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.size() + this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().initialHasPickedNum >= this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().maxSelectNum))
    {
      l = System.currentTimeMillis();
      if (l - this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().lastTimeShowToast >= 1000L)
      {
        QQToast.a(a(), a(localLocalMediaInfo), 0).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
        this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().lastTimeShowToast = l;
      }
    }
    while (!a(localLocalMediaInfo))
    {
      long l;
      return;
    }
    label163:
    String str;
    Object localObject1;
    Object localObject2;
    if (i == 1)
    {
      i = 2;
      localLocalMediaInfo.selectStatus = i;
      if (localLocalMediaInfo.selectStatus != 1) {
        break label558;
      }
      i = 1;
      str = localLocalMediaInfo.path;
      localObject1 = PresendPicMgr.a();
      localObject2 = MimeHelper.getMimeType(localLocalMediaInfo.mMimeType);
      if (i == 0) {
        break label563;
      }
      if ((this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject1 = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject1).videoSelectedCnt += 1;
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().videoSelectedCnt == 1) {
          this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localObject1 = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject1).gifSelectedCount += 1;
      }
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.add(str);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedIndex.add(localLocalMediaInfo.position);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.put(str, localLocalMediaInfo);
      localObject2 = (LinkedHashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedHashMap();
        AlbumUtil.sSelectItemPosMap.put(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId, localObject1);
      }
      ((LinkedHashMap)localObject1).put(str, Integer.valueOf(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.findFirstVisibleItemPosition()));
      localObject1 = AlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject1).containsKey(str)) {
        ((HashMap)localObject1).put(str, new Pair(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId, this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumName));
      }
      label490:
      i = localLocalMediaInfo.selectStatus;
      if (i != 1) {
        break label811;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.indexOf(localLocalMediaInfo.path) + 1 + this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().initialHasPickedNum);
    }
    for (;;)
    {
      SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
      return;
      i = 1;
      break;
      label558:
      i = 0;
      break label163;
      label563:
      if ((this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().isSupportVideoCheckbox) && (localObject2 != null) && ("video".equals(localObject2[0])))
      {
        localObject2 = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject2).videoSelectedCnt -= 1;
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().videoSelectedCnt == 1) {
          this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedVideoInfo = localLocalMediaInfo;
        }
      }
      if ((!TextUtils.isEmpty(localLocalMediaInfo.mMimeType)) && ("image/gif".equals(localLocalMediaInfo.mMimeType)))
      {
        localObject2 = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a();
        ((PhotoListBaseData)localObject2).gifSelectedCount -= 1;
      }
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.remove(str);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedIndex.remove(localLocalMediaInfo.position);
      this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedMediaInfoHashMap.remove(str);
      if (localObject1 != null) {
        ((PresendPicMgr)localObject1).b(str, 1013);
      }
      localObject1 = (HashMap)AlbumUtil.sSelectItemPosMap.get(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().albumId);
      if (localObject1 != null) {
        ((HashMap)localObject1).remove(str);
      }
      localObject1 = AlbumUtil.sSelectItemAlbum;
      if (!((HashMap)localObject1).containsKey(str)) {
        break label490;
      }
      ((HashMap)localObject1).remove(str);
      break label490;
      label811:
      if (i == 3) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
      }
    }
  }
  
  public String a()
  {
    return "AECirclePreviewPart";
  }
  
  protected String a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().maxSelectNum;
    return a().getResources().getString(2131694869, new Object[] { Integer.valueOf(i) });
  }
  
  public void a() {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramViewHolder.getAdapterPosition();
    paramViewHolder = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    if (paramViewHolder.selectStatus == 1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.indexOf(paramViewHolder.path) + 1 + this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().initialHasPickedNum);
    }
    for (;;)
    {
      AEReportUtils.a(QAlbumUtil.getMediaType(paramViewHolder));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat = ((RecyclerViewCompat)paramView.findViewById(2131373019));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131373058));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131373062));
    this.b = ((FrameLayout)paramView.findViewById(2131373057));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131373059));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper = new PagerSnapHelper();
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(this);
    this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoPreviewAdapter = new PhotoPreviewAdapter(a(), this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setAdapter(this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoPreviewAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(a(), 0, false);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.addOnItemTouchListener(a());
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramList = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilList.get(j);
      int i;
      if (QAlbumUtil.getMediaType(paramList) == 2)
      {
        this.jdField_a_of_type_JavaUtilList.remove(j);
        j -= 1;
        i = j;
        if (this.jdField_a_of_type_Int > j)
        {
          this.jdField_a_of_type_Int -= 1;
          i = j;
        }
      }
      for (;;)
      {
        j = i + 1;
        break;
        i = j;
        if (!TextUtils.isEmpty(paramList.mMimeType))
        {
          i = j;
          if ("image/gif".equals(paramList.mMimeType))
          {
            this.jdField_a_of_type_JavaUtilList.remove(paramList);
            j -= 1;
            i = j;
            if (this.jdField_a_of_type_Int > j)
            {
              this.jdField_a_of_type_Int -= 1;
              i = j;
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoPreviewAdapter != null) {
      this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterPhotoPreviewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) || (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0);
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public boolean b()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0)
    {
      b();
      return true;
    }
    return false;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(AECircleShowPhotoPreviewEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131373058) {
      d();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131373059)
      {
        if (this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().selectedPhotoList.size() + this.jdField_a_of_type_DovComQqImAeBizQcircleAECirclePhotoListLogic.a().initialHasPickedNum < 1) {
          c();
        }
        b();
      }
      else if (paramView.getId() == 2131373057)
      {
        b();
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof AECircleShowPhotoPreviewEvent))
    {
      paramSimpleBaseEvent = (AECircleShowPhotoPreviewEvent)paramSimpleBaseEvent;
      this.jdField_a_of_type_Int = paramSimpleBaseEvent.mPosition;
      a(paramSimpleBaseEvent.mPhotoInfoList);
      this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewCompat.scrollToPosition(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      AECircleMultiUnit.a(a(), a().getResources().getColor(2131165435), false);
      SimpleEventBus.getInstance().dispatchEvent(new AECircleChangeBottomTabVisibleEvent());
      AEReportUtils.a(QAlbumUtil.getMediaType((LocalMediaInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECirclePreviewPart
 * JD-Core Version:    0.7.0.1
 */