package cooperation.ilive.group.entity;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.ilive.pb.LiveGroupTips.GetLiveGroupTipsRsp;

public class IliveGroupTipsEntity
{
  public long a;
  public String b;
  public String c;
  public String d;
  public String e;
  public boolean f;
  public int g;
  public long h;
  public long i;
  public String j;
  
  public static IliveGroupTipsEntity a(LiveGroupTips.GetLiveGroupTipsRsp paramGetLiveGroupTipsRsp)
  {
    if (paramGetLiveGroupTipsRsp == null) {
      return null;
    }
    IliveGroupTipsEntity localIliveGroupTipsEntity = new IliveGroupTipsEntity();
    if (paramGetLiveGroupTipsRsp.room_id.has())
    {
      localIliveGroupTipsEntity.a = paramGetLiveGroupTipsRsp.room_id.get();
      if (paramGetLiveGroupTipsRsp.room_title.has()) {
        localIliveGroupTipsEntity.b = paramGetLiveGroupTipsRsp.room_title.get();
      }
      if (paramGetLiveGroupTipsRsp.room_icon.has()) {
        localIliveGroupTipsEntity.c = paramGetLiveGroupTipsRsp.room_icon.get();
      }
      if (paramGetLiveGroupTipsRsp.room_viewer.has()) {
        localIliveGroupTipsEntity.h = paramGetLiveGroupTipsRsp.room_viewer.get();
      }
      if (paramGetLiveGroupTipsRsp.viewer_text.has()) {
        localIliveGroupTipsEntity.d = paramGetLiveGroupTipsRsp.viewer_text.get();
      }
      if (paramGetLiveGroupTipsRsp.puin.has()) {
        localIliveGroupTipsEntity.i = paramGetLiveGroupTipsRsp.puin.get();
      }
      if (paramGetLiveGroupTipsRsp.room_schema.has()) {
        localIliveGroupTipsEntity.e = paramGetLiveGroupTipsRsp.room_schema.get();
      }
      if (paramGetLiveGroupTipsRsp.is_living.has())
      {
        int k = paramGetLiveGroupTipsRsp.is_living.get();
        boolean bool = true;
        if (k != 1) {
          bool = false;
        }
        localIliveGroupTipsEntity.f = bool;
      }
      if (paramGetLiveGroupTipsRsp.interval.has()) {
        localIliveGroupTipsEntity.g = paramGetLiveGroupTipsRsp.interval.get();
      }
      return localIliveGroupTipsEntity;
    }
    return null;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mRoomId = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mRoomTitle = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mRoomSubTitle = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mIsLiving = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" mPollTime = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" mViewNum = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" puin = ");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.group.entity.IliveGroupTipsEntity
 * JD-Core Version:    0.7.0.1
 */