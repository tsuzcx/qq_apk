import android.text.TextUtils;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import trpc.qq_av_together.common.WTogetherCommon.PlayerStatus;
import trpc.qq_av_together.common.WTogetherCommon.RoomInfo;
import trpc.qq_av_together.common.WTogetherCommon.RoomUserInfo;
import trpc.qq_av_together.common.WTogetherCommon.VideoInfoRsp;

public class myw
{
  public final int a;
  public long a;
  public final String a;
  public List<WTogetherCommon.RoomUserInfo> a;
  public final myt a;
  public myv a;
  private boolean a;
  private int jdField_b_of_type_Int = 0;
  public final long b;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  public long c;
  public String c;
  private long d;
  
  public myw(int paramInt, long paramLong, String paramString)
  {
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Myt = new myt();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    this.d += 1L;
    return this.d;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_b_of_type_Int != paramInt1) || (this.jdField_c_of_type_Int != paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.room", 2, "updateRoomState, cur[" + this.jdField_b_of_type_Int + "," + this.jdField_c_of_type_Int + "], to[" + paramInt1 + "," + paramInt2 + "], from[" + paramString + "]");
      }
      if (this.jdField_b_of_type_Int != paramInt1)
      {
        lfe locallfe = lbz.a().a();
        locallfe.a(paramInt1, paramString);
        if ((locallfe.b() != this.jdField_b_of_type_Long) && (QLog.isColorLevel())) {
          QLog.i("WTogether.room", 2, "updateRoomState error, not same id. [" + locallfe.b() + ", " + this.jdField_b_of_type_Long + "]");
        }
      }
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = paramInt2;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramString)) {
      this.jdField_b_of_type_JavaLangString = paramString;
    }
    if ((!e()) && ((!TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramString)) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))))
    {
      this.jdField_c_of_type_JavaLangString = lbz.a().a().e;
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.room", 2, "setRoomAdmin, uin[" + paramString + "], nick[" + this.jdField_c_of_type_JavaLangString + "]");
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.room", 4, "setUpdateFromAdminFlag, flag[" + paramBoolean + "], from[" + paramString + "]");
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return (this.jdField_a_of_type_Int == paramInt) && (this.jdField_b_of_type_Long == paramLong);
  }
  
  public boolean a(WTogetherCommon.RoomInfo paramRoomInfo, String paramString)
  {
    if ((paramRoomInfo == null) || (this.jdField_b_of_type_Long != paramRoomInfo.roomid.get())) {
      return false;
    }
    long l2 = this.jdField_a_of_type_Long;
    a(String.valueOf(paramRoomInfo.owner_uin.get()));
    long l1;
    Object localObject;
    if (paramRoomInfo.seq.has())
    {
      l1 = paramRoomInfo.seq.get();
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_JavaUtilList = paramRoomInfo.users.get();
      this.jdField_c_of_type_Long = paramRoomInfo.room_create_ts.get();
      if ((!e()) && (l2 != this.jdField_a_of_type_Long)) {
        a(true, paramString);
      }
      localObject = (WTogetherCommon.VideoInfoRsp)paramRoomInfo.video_info_rsp.get();
      if ((this.jdField_a_of_type_Myv != null) && (this.jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.a((WTogetherCommon.VideoInfoRsp)localObject))) {
        break label286;
      }
      if (this.jdField_a_of_type_Myv != null) {
        b(true, paramString);
      }
      this.jdField_a_of_type_Myv = new myv(new WTFileInfo((WTogetherCommon.VideoInfoRsp)localObject));
    }
    label286:
    for (boolean bool = true;; bool = false)
    {
      localObject = null;
      if (paramRoomInfo.player_status.has()) {
        localObject = (WTogetherCommon.PlayerStatus)paramRoomInfo.player_status.get();
      }
      if (localObject != null)
      {
        this.jdField_a_of_type_Myv.a(((WTogetherCommon.PlayerStatus)localObject).video_status.get(), paramString);
        this.jdField_a_of_type_Myv.jdField_a_of_type_Float = (((WTogetherCommon.PlayerStatus)localObject).cur_play_rate.get() / 100.0F);
        this.jdField_a_of_type_Myv.jdField_a_of_type_Long = ((WTogetherCommon.PlayerStatus)localObject).cur_play_time.get();
      }
      this.jdField_a_of_type_Myv.jdField_b_of_type_Long = (paramRoomInfo.last_update_time.get() * 1000L);
      return bool;
      l1 = l2;
      break;
    }
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Long = 0L;
    a(0, 0, paramString);
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Myv = null;
    this.jdField_a_of_type_JavaUtilList = null;
    a(false, "clearRoom");
    b(false, "clearRoom");
    this.jdField_a_of_type_Myt.a();
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.room", 2, "clearRoom, from[" + paramString + "]");
    }
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.room", 4, "setChangePlayFileFlag, isChangePlayFile[" + paramBoolean + "], from[" + paramString + "]");
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean c()
  {
    if (e()) {
      if ((this.jdField_b_of_type_Int != 5) || (this.jdField_c_of_type_Int != 1)) {}
    }
    while ((this.jdField_b_of_type_Int == 6) && (this.jdField_c_of_type_Int == 1))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean d()
  {
    if (e()) {
      switch (this.jdField_b_of_type_Int)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            return false;
          } while (this.jdField_c_of_type_Int == 2);
          return false;
        } while (this.jdField_c_of_type_Int == 1);
        return false;
        switch (this.jdField_b_of_type_Int)
        {
        default: 
          return true;
        case 0: 
          return false;
        }
      } while (this.jdField_c_of_type_Int == 2);
      return false;
    } while (this.jdField_c_of_type_Int == 1);
    return false;
  }
  
  public boolean e()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
  }
  
  public String toString()
  {
    return "WTRoomInfo{type: " + this.jdField_a_of_type_Int + ", roomId: " + this.jdField_b_of_type_Long + ", roomState: " + this.jdField_b_of_type_Int + ", roomSubState: " + this.jdField_c_of_type_Int + ", selfUin: " + this.jdField_a_of_type_JavaLangString + ", roomAdmin: " + this.jdField_b_of_type_JavaLangString + ", roomCreateTime: " + this.jdField_c_of_type_Long + ", playInfo: " + this.jdField_a_of_type_Myv + ", updateFromAdminFlag: " + this.jdField_a_of_type_Boolean + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myw
 * JD-Core Version:    0.7.0.1
 */