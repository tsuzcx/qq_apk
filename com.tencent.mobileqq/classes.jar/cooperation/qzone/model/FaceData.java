package cooperation.qzone.model;

import NS_MOBILE_FEEDS.FaceRecommendInfo;
import NS_MOBILE_FEEDS.stFaceItem;
import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;

public class FaceData
  implements Serializable
{
  public String album_id = "";
  public Bitmap bitmap;
  public String faceUrl;
  public String faceid = "";
  public String groupid = "";
  public long h;
  public boolean isFromSystem = true;
  public boolean isRecommend;
  public long opertime;
  public long owner_uin;
  public String photo_id = "";
  public String quanid = "";
  public int quanstate;
  public ArrayList<FaceRecommendInfo> recommend_infos;
  public String targetGroupid;
  public String targetnick = "";
  public long targetuin;
  public long w;
  public String writernick = "";
  public long writeruin;
  public long x;
  public long y;
  
  public static stFaceItem FaceDataTostFaceItem(FaceData paramFaceData)
  {
    stFaceItem localstFaceItem = new stFaceItem();
    localstFaceItem.photo_id = paramFaceData.photo_id;
    localstFaceItem.x = paramFaceData.x;
    localstFaceItem.y = paramFaceData.y;
    localstFaceItem.w = paramFaceData.w;
    localstFaceItem.h = paramFaceData.h;
    localstFaceItem.quanstate = paramFaceData.quanstate;
    localstFaceItem.opertime = paramFaceData.opertime;
    localstFaceItem.faceid = paramFaceData.faceid;
    localstFaceItem.quanid = paramFaceData.quanid;
    localstFaceItem.targetuin = paramFaceData.targetuin;
    localstFaceItem.targetnick = paramFaceData.targetnick;
    localstFaceItem.writeruin = paramFaceData.writeruin;
    localstFaceItem.writernick = paramFaceData.writernick;
    localstFaceItem.faceUrl = paramFaceData.faceUrl;
    localstFaceItem.FromSys = paramFaceData.isFromSystem;
    localstFaceItem.groupid = paramFaceData.groupid;
    localstFaceItem.recommend_infos = paramFaceData.recommend_infos;
    localstFaceItem.target_groupid = paramFaceData.targetGroupid;
    localstFaceItem.is_recommend = paramFaceData.isRecommend;
    return localstFaceItem;
  }
  
  public static FaceData stFaceItemToFaceData(stFaceItem paramstFaceItem, String paramString, long paramLong)
  {
    FaceData localFaceData = new FaceData();
    localFaceData.album_id = paramString;
    localFaceData.owner_uin = paramLong;
    if (paramstFaceItem != null)
    {
      localFaceData.photo_id = paramstFaceItem.photo_id;
      localFaceData.x = paramstFaceItem.x;
      localFaceData.y = paramstFaceItem.y;
      localFaceData.w = paramstFaceItem.w;
      localFaceData.h = paramstFaceItem.h;
      localFaceData.quanstate = paramstFaceItem.quanstate;
      localFaceData.opertime = paramstFaceItem.opertime;
      localFaceData.faceid = paramstFaceItem.faceid;
      localFaceData.quanid = paramstFaceItem.quanid;
      localFaceData.targetuin = paramstFaceItem.targetuin;
      localFaceData.targetnick = paramstFaceItem.targetnick;
      localFaceData.writeruin = paramstFaceItem.writeruin;
      localFaceData.writernick = paramstFaceItem.writernick;
      localFaceData.faceUrl = paramstFaceItem.faceUrl;
      localFaceData.isFromSystem = paramstFaceItem.FromSys;
      localFaceData.groupid = paramstFaceItem.groupid;
      localFaceData.targetGroupid = paramstFaceItem.target_groupid;
      localFaceData.isRecommend = paramstFaceItem.is_recommend;
      if (QLog.isColorLevel()) {
        QLog.d("FaceFuntion", 2, new Object[] { "[Data come back]人脸信息 quanstate:", Integer.valueOf(localFaceData.quanstate), " targetuin:", Long.valueOf(localFaceData.targetuin), " targetnick:", localFaceData.targetnick, " groupid:", localFaceData.groupid, " targetGroupid:", localFaceData.targetGroupid });
      }
      localFaceData.recommend_infos = new ArrayList();
      long l = -1L;
      paramLong = l;
      if (localFaceData.quanstate == 5)
      {
        paramLong = l;
        if (localFaceData.targetuin != 0L)
        {
          localFaceData.recommend_infos.add(new FaceRecommendInfo(localFaceData.targetuin, localFaceData.targetnick, ""));
          paramLong = localFaceData.targetuin;
          localFaceData.targetuin = 0L;
          localFaceData.targetnick = "";
        }
      }
      int i = 0;
      if (i < paramstFaceItem.recommend_infos.size())
      {
        if ((((FaceRecommendInfo)paramstFaceItem.recommend_infos.get(i)).uin == 0L) || (((FaceRecommendInfo)paramstFaceItem.recommend_infos.get(i)).uin == paramLong)) {}
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.d("FaceFuntion", 2, new Object[] { "[Data come back]推荐人脸 i:", Integer.valueOf(i), " uin:", Long.valueOf(((FaceRecommendInfo)paramstFaceItem.recommend_infos.get(i)).uin), " nick:", ((FaceRecommendInfo)paramstFaceItem.recommend_infos.get(i)).nick, " groupid:", ((FaceRecommendInfo)paramstFaceItem.recommend_infos.get(i)).groupid });
          }
          localFaceData.recommend_infos.add(paramstFaceItem.recommend_infos.get(i));
        }
      }
    }
    return localFaceData;
  }
  
  public static ArrayList<FaceData> toFaceDataList(ArrayList<stFaceItem> paramArrayList, String paramString, long paramLong)
  {
    if (paramArrayList == null)
    {
      QLog.e("FaceFuntion", 2, "[Data come back] toFaceDataList | faceItems is null");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("FaceFuntion", 2, new Object[] { "[Data come back] toFaceDataList | faceItems size:", Integer.valueOf(paramArrayList.size()) });
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      FaceData localFaceData = stFaceItemToFaceData((stFaceItem)paramArrayList.get(i), paramString, paramLong);
      localArrayList.add(localFaceData);
      if (QLog.isColorLevel()) {
        QLog.d("FaceFuntion", 2, new Object[] { "[Data come back] FaceData|toFaceDataList i:", Integer.valueOf(i), " face:", localFaceData.toString() });
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public FaceData clone()
  {
    FaceData localFaceData = new FaceData();
    localFaceData.album_id = this.album_id;
    localFaceData.photo_id = this.photo_id;
    localFaceData.owner_uin = this.owner_uin;
    localFaceData.x = this.x;
    localFaceData.y = this.y;
    localFaceData.w = this.w;
    localFaceData.h = this.h;
    localFaceData.quanstate = this.quanstate;
    localFaceData.opertime = this.opertime;
    localFaceData.faceid = this.faceid;
    localFaceData.quanid = this.quanid;
    localFaceData.targetuin = this.targetuin;
    localFaceData.targetnick = this.targetnick;
    localFaceData.writeruin = this.writeruin;
    localFaceData.writernick = this.writernick;
    localFaceData.bitmap = null;
    localFaceData.faceUrl = this.faceUrl;
    localFaceData.isFromSystem = this.isFromSystem;
    return localFaceData;
  }
  
  public String toString()
  {
    return "FaceData{album_id='" + this.album_id + '\'' + ", photo_id='" + this.photo_id + '\'' + ", owner_uin=" + this.owner_uin + ", x=" + this.x + ", y=" + this.y + ", w=" + this.w + ", h=" + this.h + ", quanstate=" + this.quanstate + ", opertime=" + this.opertime + ", faceid='" + this.faceid + '\'' + ", quanid='" + this.quanid + '\'' + ", targetuin=" + this.targetuin + ", targetnick='" + this.targetnick + '\'' + ", writeruin=" + this.writeruin + ", writernick='" + this.writernick + '\'' + ", bitmap=" + this.bitmap + ", faceUrl='" + this.faceUrl + '\'' + ", isFromSystem=" + this.isFromSystem + ", groupid='" + this.groupid + '\'' + ", recommend_infos=" + this.recommend_infos + ", targetGroupid='" + this.targetGroupid + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.model.FaceData
 * JD-Core Version:    0.7.0.1
 */