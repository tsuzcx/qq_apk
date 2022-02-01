package cooperation.ilive.group.entity;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.ilive.pb.LiveGroupTips.GetLiveGroupTipsRsp;

public class IliveGroupTipsEntity
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public long c;
  public String c;
  public String d;
  public String e;
  
  public static IliveGroupTipsEntity a(LiveGroupTips.GetLiveGroupTipsRsp paramGetLiveGroupTipsRsp)
  {
    if (paramGetLiveGroupTipsRsp == null) {
      return null;
    }
    IliveGroupTipsEntity localIliveGroupTipsEntity = new IliveGroupTipsEntity();
    if (paramGetLiveGroupTipsRsp.room_id.has())
    {
      localIliveGroupTipsEntity.jdField_a_of_type_Long = paramGetLiveGroupTipsRsp.room_id.get();
      if (paramGetLiveGroupTipsRsp.room_title.has()) {
        localIliveGroupTipsEntity.jdField_a_of_type_JavaLangString = paramGetLiveGroupTipsRsp.room_title.get();
      }
      if (paramGetLiveGroupTipsRsp.room_icon.has()) {
        localIliveGroupTipsEntity.jdField_b_of_type_JavaLangString = paramGetLiveGroupTipsRsp.room_icon.get();
      }
      if (paramGetLiveGroupTipsRsp.room_viewer.has()) {
        localIliveGroupTipsEntity.jdField_b_of_type_Long = paramGetLiveGroupTipsRsp.room_viewer.get();
      }
      if (paramGetLiveGroupTipsRsp.viewer_text.has()) {
        localIliveGroupTipsEntity.jdField_c_of_type_JavaLangString = paramGetLiveGroupTipsRsp.viewer_text.get();
      }
      if (paramGetLiveGroupTipsRsp.puin.has()) {
        localIliveGroupTipsEntity.jdField_c_of_type_Long = paramGetLiveGroupTipsRsp.puin.get();
      }
      if (paramGetLiveGroupTipsRsp.room_schema.has()) {
        localIliveGroupTipsEntity.d = paramGetLiveGroupTipsRsp.room_schema.get();
      }
      if (paramGetLiveGroupTipsRsp.is_living.has())
      {
        int i = paramGetLiveGroupTipsRsp.is_living.get();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        localIliveGroupTipsEntity.jdField_a_of_type_Boolean = bool;
      }
      if (paramGetLiveGroupTipsRsp.interval.has()) {
        localIliveGroupTipsEntity.jdField_a_of_type_Int = paramGetLiveGroupTipsRsp.interval.get();
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
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" mRoomTitle = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mRoomSubTitle = ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" mIsLiving = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" mPollTime = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" mViewNum = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" puin = ");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.group.entity.IliveGroupTipsEntity
 * JD-Core Version:    0.7.0.1
 */