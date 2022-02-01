package dov.com.qq.im.ae.biz.qcircle.part;

import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.biz.qcircle.AECirclePhotoListLogic;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AECircleAlbumListPart$QueryPhotoTask
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public AECircleAlbumListPart$QueryPhotoTask(AECircleAlbumListPart paramAECircleAlbumListPart, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  protected List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    int j = 0;
    PhotoCommonBaseData localPhotoCommonBaseData = AECircleAlbumListPart.a(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData;
    if (localPhotoCommonBaseData.selectedPhotoList == null) {
      localPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    }
    if (localPhotoCommonBaseData.selectedMediaInfoHashMap == null) {
      localPhotoCommonBaseData.selectedMediaInfoHashMap = new HashMap();
    }
    HashMap localHashMap = localPhotoCommonBaseData.selectedMediaInfoHashMap;
    LogTag.a();
    paramVarArgs = AECircleAlbumListPart.b(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).a(this.jdField_a_of_type_Boolean);
    if (paramVarArgs == null) {
      paramVarArgs = new ArrayList();
    }
    for (;;)
    {
      AECircleAlbumListPart.a(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).videoSelectedCnt = 0;
      AECircleAlbumListPart.b(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).gifSelectedCount = 0;
      System.currentTimeMillis();
      long l = QAlbumUtil.sLastAlbumRecordTime;
      if (QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(localPhotoCommonBaseData.albumId)) {
        ((Integer)QAlbumUtil.sLastAlbumPhotoCountMap.get(localPhotoCommonBaseData.albumId)).intValue();
      }
      Object localObject1;
      Object localObject2;
      if ((AECircleAlbumListPart.c(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).isShowCamera) && (localPhotoCommonBaseData.albumId.equals("$RecentAlbumId")))
      {
        localObject1 = paramVarArgs.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)))
          {
            PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject2).path);
            localHashMap.remove(((LocalMediaInfo)localObject2).path);
          }
        }
        paramVarArgs.addAll(0, PhotoListBaseData.newCaptureMediaInfo.values());
      }
      int i;
      if ((AECircleAlbumListPart.d(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).showCameraInVideo) && (localPhotoCommonBaseData.albumId.equals("$VideoAlbumId")))
      {
        localObject1 = paramVarArgs.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)))
          {
            PhotoListBaseData.newCaptureMediaInfo.remove(((LocalMediaInfo)localObject2).path);
            localHashMap.remove(((LocalMediaInfo)localObject2).path);
          }
        }
        localObject1 = PhotoListBaseData.newCaptureMediaInfo.values().iterator();
        i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
          if ((localObject2 == null) || (!"video/mp4".equals(((LocalMediaInfo)localObject2).mMimeType))) {
            break label898;
          }
          paramVarArgs.add(i, localObject2);
          i += 1;
        }
      }
      label898:
      for (;;)
      {
        break;
        localObject1 = new ArrayList(paramVarArgs.size());
        i = j;
        if (i < paramVarArgs.size())
        {
          localObject2 = (LocalMediaInfo)paramVarArgs.get(i);
          if (((LocalMediaInfo)localObject2).path == null) {}
          for (;;)
          {
            i += 1;
            break;
            j = QAlbumUtil.getMediaType((LocalMediaInfo)localObject2);
            ((LocalMediaInfo)localObject2).position = Integer.valueOf(((ArrayList)localObject1).size());
            ((ArrayList)localObject1).add(((LocalMediaInfo)localObject2).path);
            if (localPhotoCommonBaseData.selectedPhotoList.contains(((LocalMediaInfo)localObject2).path))
            {
              ((LocalMediaInfo)localObject2).selectStatus = 1;
              localPhotoCommonBaseData.selectedMediaInfoHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
              if (!localPhotoCommonBaseData.selectedIndex.contains(((LocalMediaInfo)localObject2).position)) {
                localPhotoCommonBaseData.selectedIndex.add(((LocalMediaInfo)localObject2).position);
              }
              if ((AECircleAlbumListPart.e(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).isSupportVideoCheckbox) && (j == 1))
              {
                PhotoListBaseData localPhotoListBaseData = AECircleAlbumListPart.f(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart);
                localPhotoListBaseData.videoSelectedCnt += 1;
                if (AECircleAlbumListPart.g(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).videoSelectedCnt == 1) {
                  AECircleAlbumListPart.h(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).selectedVideoInfo = ((LocalMediaInfo)localObject2);
                }
              }
              if ((AECircleAlbumListPart.i(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).isShowCamera) && (!localHashMap.containsKey(((LocalMediaInfo)localObject2).path))) {
                localHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
              }
              if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject2).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject2).mMimeType)))
              {
                localObject2 = AECircleAlbumListPart.j(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart);
                ((PhotoListBaseData)localObject2).gifSelectedCount += 1;
              }
            }
            else if ((localPhotoCommonBaseData.selectedPhotoList.size() < localPhotoCommonBaseData.maxSelectNum) && (((LocalMediaInfo)localObject2).path.equals(AECircleAlbumListPart.k(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).currentPhotoPath)))
            {
              ((LocalMediaInfo)localObject2).selectStatus = 1;
              localPhotoCommonBaseData.selectedPhotoList.add(((LocalMediaInfo)localObject2).path);
              localPhotoCommonBaseData.selectedIndex.add(((LocalMediaInfo)localObject2).position);
              if (localPhotoCommonBaseData.needMediaInfo) {
                localHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
              }
            }
            else
            {
              ((LocalMediaInfo)localObject2).selectStatus = 2;
            }
          }
        }
        localPhotoCommonBaseData.mediaPathsList = ((ArrayList)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("AECircleAlbumListPart", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + paramVarArgs.size());
        }
        return paramVarArgs;
      }
    }
  }
  
  protected void a(List<LocalMediaInfo> paramList)
  {
    boolean bool = false;
    AECircleAlbumListPart.c(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).a(paramList, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart.a().post(new AECircleAlbumListPart.QueryPhotoTask.1(this));
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart.a(false, false);
      if (AECircleAlbumListPart.d(this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart).jdField_a_of_type_DovComQqImAeAlbumDataAEAlbumLogicData.initialHasPickedNum > 0) {
        bool = true;
      }
      AEReportUtils.a(bool);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    if (this.b) {
      this.jdField_a_of_type_DovComQqImAeBizQcirclePartAECircleAlbumListPart.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.AECircleAlbumListPart.QueryPhotoTask
 * JD-Core Version:    0.7.0.1
 */