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
    boolean bool = true;
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
      if (paramGetLiveGroupTipsRsp.is_living.has()) {
        if (paramGetLiveGroupTipsRsp.is_living.get() != 1) {
          break label214;
        }
      }
    }
    for (;;)
    {
      localIliveGroupTipsEntity.jdField_a_of_type_Boolean = bool;
      if (paramGetLiveGroupTipsRsp.interval.has()) {
        localIliveGroupTipsEntity.jdField_a_of_type_Int = paramGetLiveGroupTipsRsp.interval.get();
      }
      return localIliveGroupTipsEntity;
      return null;
      label214:
      bool = false;
    }
  }
  
  @NonNull
  public String toString()
  {
    return "mRoomId = " + this.jdField_a_of_type_Long + " mRoomTitle = " + this.jdField_a_of_type_JavaLangString + " mRoomSubTitle = " + this.jdField_c_of_type_JavaLangString + " mIsLiving = " + this.jdField_a_of_type_Boolean + " mPollTime = " + this.jdField_a_of_type_Int + " mViewNum = " + this.jdField_b_of_type_Long + " puin = " + this.jdField_c_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.group.entity.IliveGroupTipsEntity
 * JD-Core Version:    0.7.0.1
 */