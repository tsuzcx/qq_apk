package com.tencent.mobileqq.wink.pick.album.logic;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.provider.MediaStore.Video.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.wink.pick.URLDrawableHelper;
import com.tencent.mobileqq.wink.pick.album.adapter.WinkAlbumListAdapter;
import com.tencent.mobileqq.wink.pick.album.fragment.WinkAbstractAlbumListFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class WinkAlbumListLogicBase<K extends WinkAbstractAlbumListFragment>
  extends WinkAlbumListLogic<K>
  implements WinkAlbumListLogic.IalbumListAdapterCallBack
{
  protected WinkAlbumListAdapter f;
  
  protected WinkAlbumListLogicBase(K paramK)
  {
    super(paramK);
    this.e = this;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Resources localResources = ((WinkAbstractAlbumListFragment)this.a.get()).getResources();
    WinkAlbumListAdapter localWinkAlbumListAdapter = d();
    View localView;
    TextView localTextView;
    if (paramView == null)
    {
      localView = ((WinkAbstractAlbumListFragment)this.a.get()).getActivity().getLayoutInflater().inflate(2131628233, null);
      localTextView = (TextView)localView;
    }
    else
    {
      localTextView = (TextView)paramView;
      localView = paramView;
    }
    QQAlbumInfo localQQAlbumInfo = localWinkAlbumListAdapter.a(paramInt);
    paramView = new StringBuilder();
    paramView.append(localQQAlbumInfo.name);
    paramView.append("，");
    paramView.append(localQQAlbumInfo.mMediaFileCount);
    paramView.append("张照片");
    localView.setContentDescription(paramView.toString());
    paramView = localQQAlbumInfo.name;
    if (localQQAlbumInfo.mMediaFileCount > 0)
    {
      paramView = new StringBuilder();
      paramView.append(localQQAlbumInfo.name);
      paramView.append(String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) }));
      paramView = paramView.toString();
    }
    localTextView.setText(paramView);
    paramViewGroup = localTextView.getCompoundDrawables()[0];
    if (localWinkAlbumListAdapter.getItemViewType(paramInt) == 1)
    {
      if (localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "VIDEO");
      } else {
        paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
      }
    }
    else {
      paramView = QAlbumUtil.generateAlbumThumbURL(localQQAlbumInfo.mCoverInfo);
    }
    Object localObject = localQQAlbumInfo.mCoverInfo;
    localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
    ((LocalMediaInfo)localObject).thumbWidth = 200;
    if ((paramViewGroup != null) && (URLDrawable.class.isInstance(paramViewGroup)))
    {
      paramViewGroup = (URLDrawable)paramViewGroup;
      if (paramView.equals(paramViewGroup.getURL())) {}
    }
    else
    {
      paramViewGroup = null;
    }
    localObject = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject = URLDrawableHelper.a(paramView, WinkAlbumListAdapter.a, WinkAlbumListAdapter.a);
      ((URLDrawable)localObject).setTag(localQQAlbumInfo.mCoverInfo);
      ((URLDrawable)localObject).setBounds(0, 0, localWinkAlbumListAdapter.d, localWinkAlbumListAdapter.e);
    }
    if ((localQQAlbumInfo.id != null) && (localQQAlbumInfo.id.equals(this.b.albumId)))
    {
      paramView = localWinkAlbumListAdapter.h.newDrawable(localResources);
      paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
    }
    else
    {
      paramView = null;
    }
    localTextView.setCompoundDrawables((Drawable)localObject, null, paramView, null);
    return localView;
  }
  
  public String a()
  {
    Object localObject = this.b.filter;
    boolean bool1 = ((MediaFileFilter)localObject).needHeif;
    boolean bool2 = ((MediaFileFilter)localObject).needWebp;
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
    if (this.a.get() != null)
    {
      if (((WinkAbstractAlbumListFragment)this.a.get()).getActivity() == null) {
        return null;
      }
      boolean bool = false;
      int i;
      if ((paramList1 == null) && (paramList2 == null)) {
        paramList2 = null;
      } else if (paramList1 != null) {
        if (paramList2 == null)
        {
          paramList2 = paramList1;
        }
        else
        {
          Iterator localIterator1 = paramList2.iterator();
          for (;;)
          {
            paramList2 = paramList1;
            if (!localIterator1.hasNext()) {
              break;
            }
            paramList2 = (QQAlbumInfo)localIterator1.next();
            Iterator localIterator2 = paramList1.iterator();
            QQAlbumInfo localQQAlbumInfo;
            while (localIterator2.hasNext())
            {
              localQQAlbumInfo = (QQAlbumInfo)localIterator2.next();
              if (localQQAlbumInfo.id.equals(paramList2.id))
              {
                localQQAlbumInfo.mMediaFileCount += paramList2.mMediaFileCount;
                i = 1;
                break label160;
              }
            }
            i = 0;
            label160:
            if (i == 0)
            {
              localIterator2 = paramList1.iterator();
              i = 0;
              while (localIterator2.hasNext())
              {
                localQQAlbumInfo = (QQAlbumInfo)localIterator2.next();
                if (paramList2.coverDate > localQQAlbumInfo.coverDate)
                {
                  paramList1.add(i, paramList2);
                  i = 1;
                  break label241;
                }
                i += 1;
              }
              i = 0;
              label241:
              if (i == 0) {
                paramList1.add(paramList2);
              }
            }
          }
        }
      }
      LogTag.a();
      if ((paramList2 != null) && (!paramList2.isEmpty()))
      {
        int j = paramList2.size();
        i = 0;
        while (i < j)
        {
          paramList1 = (QQAlbumInfo)paramList2.get(i);
          if ((i != 0) && (WinkAlbumListAdapter.a(paramList1.name)))
          {
            paramList2.remove(paramList1);
            paramList2.add(0, paramList1);
          }
          i += 1;
        }
        if (paramInt == -1)
        {
          paramList1 = d().b(((WinkAbstractAlbumListFragment)this.a.get()).getActivity(), 210, -1, this.b.filter, -1, false, null);
        }
        else
        {
          paramList1 = new QQAlbumInfo();
          paramList1.id = "$RecentAlbumId";
          paramList1.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
          paramList1.mCoverInfo = new LocalMediaInfo();
        }
        paramList2.add(0, paramList1);
        if ((this.b.filter != null) && (this.b.filter.showVideo()))
        {
          paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
          paramList1 = ((WinkAbstractAlbumListFragment)this.a.get()).getActivity().getContentResolver().query(paramList1, new String[] { "_id" }, "_size>0 ", null, null);
          if (paramList1 != null)
          {
            i = paramList1.getCount();
            paramList1.close();
          }
          else
          {
            i = 0;
          }
          if (i > 0) {}
          do
          {
            bool = true;
            break;
            paramList1 = MediaScanner.getInstance(RFApplication.getApplication());
            if (paramList1 != null) {
              i = paramList1.getMediaScannerInfosCount();
            } else {
              i = 0;
            }
          } while (i > 0);
          d().f = bool;
          if (bool)
          {
            if (paramInt == -1)
            {
              paramList1 = d().a(((WinkAbstractAlbumListFragment)this.a.get()).getActivity());
            }
            else
            {
              paramList1 = new QQAlbumInfo();
              paramList1.id = "$VideoAlbumId";
              paramList1.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
              paramList1.mCoverInfo = new LocalMediaInfo();
            }
            paramList2.add(1, paramList1);
          }
        }
      }
      LogTag.a("PEAK", "compact.queryRecentBucket");
      return paramList2;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    WinkAlbumListAdapter localWinkAlbumListAdapter = d();
    MediaFileFilter localMediaFileFilter = this.b.filter;
    Object localObject2 = null;
    int i;
    if ((localMediaFileFilter != null) && (localMediaFileFilter.showImage()))
    {
      LogTag.a();
      localList = localWinkAlbumListAdapter.a(((WinkAbstractAlbumListFragment)this.a.get()).getActivity(), paramInt);
      if ((paramInt != -1) && (localList != null) && (localList.size() == paramInt)) {
        i = 1;
      } else {
        i = 0;
      }
      LogTag.a("PEAK", "queryImageBuckets");
    }
    else
    {
      localList = null;
      i = 0;
    }
    Object localObject1 = localObject2;
    int j = i;
    if (localMediaFileFilter != null)
    {
      localObject1 = localObject2;
      j = i;
      if (localMediaFileFilter.showVideo())
      {
        LogTag.a();
        localObject1 = localWinkAlbumListAdapter.a(((WinkAbstractAlbumListFragment)this.a.get()).getActivity(), paramInt, localMediaFileFilter);
        j = i;
        if (paramInt != -1)
        {
          j = i;
          if (localObject1 != null)
          {
            j = i;
            if (((List)localObject1).size() == paramInt) {
              j = 1;
            }
          }
        }
        LogTag.a("PEAK", "queryVideoBuckets");
      }
    }
    LogTag.a();
    List localList = this.e.a(localList, (List)localObject1, paramInt);
    if (localList != null)
    {
      i = 1;
      int k = 0;
      while (i < localList.size())
      {
        k += ((QQAlbumInfo)localList.get(i)).mMediaFileCount;
        i += 1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("compact(");
      ((StringBuilder)localObject1).append(localList.size() - 1);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(")");
      LogTag.a("PEAK", ((StringBuilder)localObject1).toString());
      localWinkAlbumListAdapter.b(localList);
      if (paramInt != -1)
      {
        if (j != 0)
        {
          ThreadManager.getFileThreadHandler().post(new WinkAlbumListLogicBase.2(this, localWinkAlbumListAdapter));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new WinkAlbumListLogicBase.3(this, localWinkAlbumListAdapter, localMediaFileFilter));
      }
      return;
    }
    LogTag.a("PEAK", "compact: medias ==null");
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (localObject != null) {
      if ((this.b.selectedMediaInfoHashMap != null) && (!this.b.selectedMediaInfoHashMap.isEmpty())) {
        this.b.selectedMediaInfoHashMap.putAll((Map)localObject);
      } else {
        this.b.selectedMediaInfoHashMap = ((HashMap)localObject);
      }
    }
    this.b.albumId = paramIntent.getStringExtra("ALBUM_ID");
    this.b.albumName = paramIntent.getStringExtra("ALBUM_NAME");
    if (this.b.albumId == null)
    {
      this.b.albumId = "$RecentAlbumId";
      this.b.albumName = null;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("passed in albumId=");
      ((StringBuilder)localObject).append(this.b.albumId);
      ((StringBuilder)localObject).append(", albumName=");
      ((StringBuilder)localObject).append(this.b.albumName);
      AEQLog.b("WinkAlbumListLogicBase", ((StringBuilder)localObject).toString());
    }
    this.b.showMediaType = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    this.b.filter = MediaFileFilter.getFilter(this.b.showMediaType);
    this.f = c();
    ((WinkAbstractAlbumListFragment)this.a.get()).e = this.f;
    ThreadManager.getFileThreadHandler().post(new WinkAlbumListLogicBase.1(this));
  }
  
  boolean a(Intent paramIntent, QQAlbumInfo paramQQAlbumInfo)
  {
    String str = paramIntent.getStringExtra("ALBUM_NAME");
    paramIntent = paramIntent.getStringExtra("ALBUM_ID");
    boolean bool;
    if (((str != null) && (!str.equals(this.b.albumName))) || ((paramIntent != null) && (!paramIntent.equals(this.b.albumId)))) {
      bool = true;
    } else {
      bool = false;
    }
    if (a(bool, paramQQAlbumInfo))
    {
      this.b.albumName = str;
      this.b.albumId = paramIntent;
      return true;
    }
    return false;
  }
  
  public boolean a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    paramIntent.putExtra("ALBUM_ID", paramQQAlbumInfo.id);
    paramIntent.putExtra("ALBUM_NAME", paramQQAlbumInfo.name);
    paramInt = 0;
    paramIntent.putExtra("album_enter_directly", false);
    XListView localXListView = ((WinkAbstractAlbumListFragment)this.a.get()).f;
    paramIntent.putExtra("PhotoConst.photo_selection_index", localXListView.getFirstVisiblePosition());
    Object localObject = localXListView.getChildAt(0);
    if (localObject != null) {
      paramInt = ((View)localObject).getTop();
    }
    paramIntent.putExtra("PhotoConst.photo_selection_y", paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("save Scroll Position,index:");
      ((StringBuilder)localObject).append(localXListView.getFirstVisiblePosition());
      ((StringBuilder)localObject).append(" top:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject).toString());
    }
    return a(paramIntent, paramQQAlbumInfo);
  }
  
  boolean a(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return paramBoolean;
  }
  
  public void b() {}
  
  protected WinkAlbumListAdapter c()
  {
    return new WinkAlbumListAdapter((WinkAbstractAlbumListFragment)this.a.get());
  }
  
  protected WinkAlbumListAdapter d()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.album.logic.WinkAlbumListLogicBase
 * JD-Core Version:    0.7.0.1
 */