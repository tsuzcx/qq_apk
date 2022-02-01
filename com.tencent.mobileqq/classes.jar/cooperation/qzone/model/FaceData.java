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
  public boolean isRecommend = false;
  public long opertime;
  public long owner_uin;
  public String photo_id = "";
  public String quanid = "";
  public int quanstate;
  public ArrayList<FaceRecommendInfo> recommend_infos = null;
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
      if (localFaceData.quanstate == 5)
      {
        paramLong = localFaceData.targetuin;
        if (paramLong != 0L)
        {
          localFaceData.recommend_infos.add(new FaceRecommendInfo(paramLong, localFaceData.targetnick, ""));
          paramLong = localFaceData.targetuin;
          localFaceData.targetuin = 0L;
          localFaceData.targetnick = "";
          break label362;
        }
      }
      paramLong = -1L;
      label362:
      int i = 0;
      while (i < paramstFaceItem.recommend_infos.size())
      {
        if ((((FaceRecommendInfo)paramstFaceItem.recommend_infos.get(i)).uin != 0L) && (((FaceRecommendInfo)paramstFaceItem.recommend_infos.get(i)).uin != paramLong))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FaceFuntion", 2, new Object[] { "[Data come back]推荐人脸 i:", Integer.valueOf(i), " uin:", Long.valueOf(((FaceRecommendInfo)paramstFaceItem.recommend_infos.get(i)).uin), " nick:", ((FaceRecommendInfo)paramstFaceItem.recommend_infos.get(i)).nick, " groupid:", ((FaceRecommendInfo)paramstFaceItem.recommend_infos.get(i)).groupid });
          }
          localFaceData.recommend_infos.add(paramstFaceItem.recommend_infos.get(i));
        }
        i += 1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FaceData{album_id='");
    localStringBuilder.append(this.album_id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", photo_id='");
    localStringBuilder.append(this.photo_id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", owner_uin=");
    localStringBuilder.append(this.owner_uin);
    localStringBuilder.append(", x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", w=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", h=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", quanstate=");
    localStringBuilder.append(this.quanstate);
    localStringBuilder.append(", opertime=");
    localStringBuilder.append(this.opertime);
    localStringBuilder.append(", faceid='");
    localStringBuilder.append(this.faceid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", quanid='");
    localStringBuilder.append(this.quanid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", targetuin=");
    localStringBuilder.append(this.targetuin);
    localStringBuilder.append(", targetnick='");
    localStringBuilder.append(this.targetnick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", writeruin=");
    localStringBuilder.append(this.writeruin);
    localStringBuilder.append(", writernick='");
    localStringBuilder.append(this.writernick);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bitmap=");
    localStringBuilder.append(this.bitmap);
    localStringBuilder.append(", faceUrl='");
    localStringBuilder.append(this.faceUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isFromSystem=");
    localStringBuilder.append(this.isFromSystem);
    localStringBuilder.append(", groupid='");
    localStringBuilder.append(this.groupid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recommend_infos=");
    localStringBuilder.append(this.recommend_infos);
    localStringBuilder.append(", targetGroupid='");
    localStringBuilder.append(this.targetGroupid);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.model.FaceData
 * JD-Core Version:    0.7.0.1
 */