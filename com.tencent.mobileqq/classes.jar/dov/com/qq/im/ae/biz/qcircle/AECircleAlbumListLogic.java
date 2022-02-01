package dov.com.qq.im.ae.biz.qcircle;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore.Video.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.AlbumListData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import dov.com.qq.im.ae.album.data.AEPhotoCommonDataCreator;
import dov.com.qq.im.ae.album.logic.AEAlbumListLogic.IalbumListAdapterCallBack;
import dov.com.qq.im.ae.biz.qcircle.adapter.AlbumListAdapter;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.CaptureContext;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class AECircleAlbumListLogic
  implements AEAlbumListLogic.IalbumListAdapterCallBack
{
  protected AlbumListData a;
  protected PhotoCommonBaseData a;
  public AEAlbumListLogic.IalbumListAdapterCallBack a;
  protected AlbumListAdapter a;
  public WeakReference<AECircleAlbumListFragment> a;
  
  protected AECircleAlbumListLogic(AECircleAlbumListFragment paramAECircleAlbumListFragment)
  {
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack = null;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAECircleAlbumListFragment);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = AEPhotoCommonDataCreator.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "AlbumListLogic new，activity = " + this.jdField_a_of_type_MqqUtilWeakReference + ",PhotoCommonData = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
    }
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack = this;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData = new AlbumListData();
  }
  
  private AlbumListAdapter a()
  {
    return this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterAlbumListAdapter;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = a();
    View localView = paramView;
    if (paramView == null) {
      localView = ((AECircleAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getLayoutInflater().inflate(2131561096, null);
    }
    ImageView localImageView1 = (ImageView)localView.findViewById(2131362603);
    paramView = (TextView)localView.findViewById(2131362616);
    Object localObject = (TextView)localView.findViewById(2131362657);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362666);
    QQAlbumInfo localQQAlbumInfo = paramViewGroup.a(paramInt);
    localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + "张照片");
    paramView.setText(localQQAlbumInfo.name);
    if (localQQAlbumInfo.mMediaFileCount > 0)
    {
      ((TextView)localObject).setText(String.format("(%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) }));
      if (paramViewGroup.getItemViewType(paramInt) != 1) {
        break label354;
      }
      if (!localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        break label340;
      }
      paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "VIDEO");
      label204:
      paramViewGroup = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
      paramViewGroup.thumbWidth = 200;
      if (!(localImageView1.getDrawable() instanceof URLDrawable)) {
        break label376;
      }
      paramViewGroup = (URLDrawable)localImageView1.getDrawable();
      if (!paramView.equals(paramViewGroup.getURL())) {
        break label376;
      }
    }
    for (;;)
    {
      localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        localObject = URLDrawableHelper.getDrawable(paramView, AlbumListAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, AlbumListAdapter.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        ((URLDrawable)localObject).setTag(localQQAlbumInfo.mCoverInfo);
      }
      localImageView1.setImageDrawable((Drawable)localObject);
      if ((localQQAlbumInfo.id != null) && (localQQAlbumInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)))
      {
        localImageView2.setVisibility(0);
        return localView;
        ((TextView)localObject).setText("");
        break;
        label340:
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
        break label204;
        label354:
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo);
        break label204;
      }
      localImageView2.setVisibility(8);
      return localView;
      label376:
      paramViewGroup = null;
    }
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter;
    boolean bool1 = ((MediaFileFilter)localObject).isSupportHeif();
    boolean bool2 = ((MediaFileFilter)localObject).isSupportWebp();
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("_size>0 and (mime_type='image/jpeg' or mime_type='image/gif' or (mime_type='*/*' and _display_name LIKE'%.jpg%' )  or (mime_type='*/*' and _display_name LIKE'%.jpeg%' )  or (mime_type='*/*' and _display_name LIKE'%.gif%' )  or (mime_type='*/*' and _display_name LIKE'%.bmp%' )  or (mime_type='*/*' and _display_name LIKE'%.png%' )  or mime_type LIKE'%bmp%' or mime_type LIKE'%bitmap%' or mime_type='image/png'");
    if (bool1) {
      ((StringBuffer)localObject).append(" or mime_type='image/heif' or mime_type='image/heic'");
    }
    if (bool2) {
      ((StringBuffer)localObject).append(" or mime_type='image/webp'");
    }
    ((StringBuffer)localObject).append(")) GROUP BY (1");
    return ((StringBuffer)localObject).toString();
  }
  
  public List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return QAlbumUtil.queryRecentImages(paramContext, paramInt3, paramInt2, paramMediaFileFilter, paramBoolean, paramInt1, paramArrayList, false);
  }
  
  public List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (((AECircleAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null)) {
      return null;
    }
    Object localObject;
    if ((paramList1 == null) && (paramList2 == null)) {
      localObject = null;
    }
    int j;
    int i;
    do
    {
      for (;;)
      {
        LogTag.a();
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label559;
        }
        j = ((List)localObject).size();
        i = 0;
        while (i < j)
        {
          paramList1 = (QQAlbumInfo)((List)localObject).get(i);
          if ((i != 0) && (AlbumListAdapter.a(paramList1.name)))
          {
            ((List)localObject).remove(paramList1);
            ((List)localObject).add(0, paramList1);
          }
          i += 1;
        }
        if (paramList1 != null) {
          break;
        }
        localObject = paramList2;
      }
      localObject = paramList1;
    } while (paramList2 == null);
    paramList2 = paramList2.iterator();
    label259:
    label678:
    label684:
    for (;;)
    {
      localObject = paramList1;
      if (!paramList2.hasNext()) {
        break;
      }
      localObject = (QQAlbumInfo)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      QQAlbumInfo localQQAlbumInfo;
      while (localIterator.hasNext())
      {
        localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
        if (localQQAlbumInfo.id.equals(((QQAlbumInfo)localObject).id)) {
          localQQAlbumInfo.mMediaFileCount += ((QQAlbumInfo)localObject).mMediaFileCount;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label684;
        }
        localIterator = paramList1.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
          if (((QQAlbumInfo)localObject).coverDate > localQQAlbumInfo.coverDate)
          {
            j = 1;
            paramList1.add(i, localObject);
          }
        }
        for (i = j;; i = 0)
        {
          if (i != 0) {
            break label678;
          }
          paramList1.add(localObject);
          break;
          i += 1;
          break label259;
          boolean bool;
          if (paramInt == -1)
          {
            paramList1 = a().b(((AECircleAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.recentImagesLimitSize, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.recentImagesMaxCount, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.recentImagesLimitWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.isBothwidthheight, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.recentImagesBlockPaths);
            ((List)localObject).add(0, paramList1);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.showVideo()))
            {
              paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
              paramList1 = ((AECircleAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getContentResolver().query(paramList1, new String[] { "_id" }, "_size>0 ", null, null);
              i = 0;
              if (paramList1 != null)
              {
                i = paramList1.getCount();
                paramList1.close();
              }
              bool = false;
              if (i <= 0) {
                break label607;
              }
              bool = true;
              label510:
              a().jdField_a_of_type_Boolean = bool;
              if (bool)
              {
                if (paramInt != -1) {
                  break label638;
                }
                paramList1 = a().a(((AECircleAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
              }
            }
          }
          for (;;)
          {
            ((List)localObject).add(1, paramList1);
            label559:
            LogTag.a("PEAK", "compact.queryRecentBucket");
            return localObject;
            paramList1 = new QQAlbumInfo();
            paramList1.id = "$RecentAlbumId";
            paramList1.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
            paramList1.mCoverInfo = new LocalMediaInfo();
            break;
            label607:
            paramList1 = MediaScanner.getInstance(BaseApplicationImpl.getContext());
            i = 0;
            if (paramList1 != null) {
              i = paramList1.getMediaScannerInfosCount();
            }
            if (i <= 0) {
              break label510;
            }
            bool = true;
            break label510;
            label638:
            paramList1 = new QQAlbumInfo();
            paramList1.id = "$VideoAlbumId";
            paramList1.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
            paramList1.mCoverInfo = new LocalMediaInfo();
          }
        }
        break;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListActivity", 2, "AlbumListLogic new，fragment = " + this.jdField_a_of_type_MqqUtilWeakReference.get() + ",PhotoCommonData = " + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.releaseCommonData();
  }
  
  public void a(int paramInt)
  {
    int k = 0;
    int j = 1;
    AlbumListAdapter localAlbumListAdapter = a();
    MediaFileFilter localMediaFileFilter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter;
    List localList1;
    int i;
    if ((localMediaFileFilter != null) && (localMediaFileFilter.showImage()))
    {
      LogTag.a();
      localList1 = localAlbumListAdapter.a(((AECircleAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt);
      if ((paramInt != -1) && (localList1 != null) && (localList1.size() == paramInt))
      {
        i = 1;
        LogTag.a("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      List localList2;
      if ((localMediaFileFilter != null) && (localMediaFileFilter.showVideo()))
      {
        LogTag.a();
        localList2 = localAlbumListAdapter.a(((AECircleAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt, localMediaFileFilter);
        if ((paramInt != -1) && (localList2 != null) && (localList2.size() == paramInt))
        {
          i = 1;
          LogTag.a("PEAK", "queryVideoBuckets");
        }
      }
      for (;;)
      {
        LogTag.a();
        localList1 = this.jdField_a_of_type_DovComQqImAeAlbumLogicAEAlbumListLogic$IalbumListAdapterCallBack.a(localList1, localList2, paramInt);
        if (localList1 != null) {
          while (j < localList1.size())
          {
            k += ((QQAlbumInfo)localList1.get(j)).mMediaFileCount;
            j += 1;
          }
        }
        LogTag.a("PEAK", "compact: medias ==null");
        do
        {
          return;
          LogTag.a("PEAK", "compact(" + (localList1.size() - 1) + "," + k + ")");
          localAlbumListAdapter.b(localList1);
        } while (paramInt == -1);
        if (i != 0)
        {
          ThreadManager.getFileThreadHandler().post(new AECircleAlbumListLogic.2(this, localAlbumListAdapter));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new AECircleAlbumListLogic.3(this, localAlbumListAdapter, localMediaFileFilter));
        return;
        break;
        localList2 = null;
      }
      i = 0;
      break;
      localList1 = null;
      i = 0;
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mIsAwlaysShowNumber = true;
    Object localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (localObject != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.isEmpty())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap = ((HashMap)localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = paramIntent.getStringExtra("ALBUM_ID");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId != null) {
        break label343;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = "$RecentAlbumId";
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = MediaFileFilter.getFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filterVideoGif = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filterVideoGif)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.showMediaType = 1;
      }
      this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterAlbumListAdapter = new AlbumListAdapter((AECircleAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get());
      ((AECircleAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_DovComQqImAeBizQcircleAdapterAlbumListAdapter = this.jdField_a_of_type_DovComQqImAeBizQcircleAdapterAlbumListAdapter;
      ThreadManager.getFileThreadHandler().post(new AECircleAlbumListLogic.1(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumListData.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
      String str = paramIntent.getStringExtra("peak.myUin");
      localObject = str;
      if (str == null) {
        localObject = CaptureContext.a().getCurrentAccountUin();
      }
      if (localObject != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.myUin = ((String)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.myUin != null) {
        break label394;
      }
      throw new RuntimeException("must set MY_UIN");
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedMediaInfoHashMap.putAll((Map)localObject);
      break;
      label343:
      AEQLog.b("AECircleAlbumListLogic", "passed in albumId=" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId + ", albumName=" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName);
    }
    label394:
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mIsDisableTroopAlbum = paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.mIsDisableTroopAlbum);
  }
  
  boolean a(Intent paramIntent, QQAlbumInfo paramQQAlbumInfo)
  {
    String str1 = paramIntent.getStringExtra("ALBUM_NAME");
    String str2 = paramIntent.getStringExtra("ALBUM_ID");
    if (((str1 != null) && (!str1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName))) || ((str2 != null) && (!str2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId)))) {}
    for (boolean bool = true; a(bool, paramQQAlbumInfo); bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumName = str1;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.albumId = str2;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.currentQualityType = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      return true;
    }
    return false;
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    paramIntent.putExtra("ALBUM_ID", paramQQAlbumInfo.id);
    paramIntent.putExtra("ALBUM_NAME", paramQQAlbumInfo.name);
    paramIntent.putExtra("album_enter_directly", false);
    XListView localXListView = ((AECircleAlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetXListView;
    paramIntent.putExtra("PhotoConst.photo_selection_index", localXListView.getFirstVisiblePosition());
    View localView = localXListView.getChildAt(0);
    if (localView == null) {}
    for (paramInt = 0;; paramInt = localView.getTop())
    {
      paramIntent.putExtra("PhotoConst.photo_selection_y", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "save Scroll Position,index:" + localXListView.getFirstVisiblePosition() + " top:" + paramInt);
      }
      return a(paramIntent, paramQQAlbumInfo);
    }
  }
  
  boolean a(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECircleAlbumListLogic
 * JD-Core Version:    0.7.0.1
 */