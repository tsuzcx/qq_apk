import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.longconn.hd_video.CmdS2CInviteReqBody;
import tencent.im.cs.longconn.hd_video.InviteTempSessionData;
import tencent.im.cs.longconn.hd_video.MsgBody;
import tencent.im.cs.longconn.hd_video.VideoHead;

public class ldu
{
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int k = 0;
    int j = k;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        j = k;
      }
    }
    else {
      return j;
    }
    k = 0;
    for (;;)
    {
      j = i;
      if (k >= paramInt) {
        break;
      }
      i = (int)(i | (paramArrayOfByte[k] & 0xFF) << (paramInt - k - 1) * 8);
      k += 1;
    }
  }
  
  public static long a(int paramInt)
  {
    return paramInt & 0xFFFFFFFF;
  }
  
  public static long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    String str2;
    do
    {
      for (;;)
      {
        return 0L;
        String str1 = paramString;
        str2 = paramString;
        try
        {
          if (paramString.startsWith("+"))
          {
            str2 = paramString;
            str1 = paramString.substring(1);
          }
          str2 = str1;
          long l = mqu.a(str1);
          if (l >= 10000L) {
            return l;
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoPackageUtils", 2, "uin = " + str2 + " is error");
    return 0L;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    paramInt -= 1;
    for (;;)
    {
      l2 = l1;
      if (paramInt < 0) {
        break;
      }
      l2 = paramArrayOfByte[paramInt];
      int i = paramInt - 1;
      l1 = (l2 & 0xFF) << paramInt * 8 | l1;
      paramInt = i;
    }
  }
  
  public static ldv a(byte[] paramArrayOfByte)
  {
    ldv localldv = new ldv();
    Object localObject = new hd_video.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (hd_video.MsgBody)((hd_video.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte.msg_video_head.has())
        {
          localObject = (hd_video.VideoHead)paramArrayOfByte.msg_video_head.get();
          localldv.jdField_a_of_type_JavaLangString = ((hd_video.VideoHead)localObject).str_from_mobile.get();
          localldv.jdField_b_of_type_JavaLangString = ((hd_video.VideoHead)localObject).str_from_nation.get();
          localldv.jdField_a_of_type_Int = ((hd_video.VideoHead)localObject).enum_body_type.get();
          localldv.jdField_b_of_type_Long = ((hd_video.VideoHead)localObject).uint64_uin.get();
          if (((hd_video.VideoHead)localObject).int32_sub_service_type.has())
          {
            i = ((hd_video.VideoHead)localObject).int32_sub_service_type.get();
            localldv.jdField_b_of_type_Int = i;
            localldv.jdField_c_of_type_Int = ((hd_video.VideoHead)localObject).uint32_seq.get();
            localldv.jdField_a_of_type_Long = ((hd_video.VideoHead)localObject).uint64_room_id.get();
            if (paramArrayOfByte.msg_invite_body.has())
            {
              paramArrayOfByte = (hd_video.CmdS2CInviteReqBody)paramArrayOfByte.msg_invite_body.get();
              localldv.jdField_c_of_type_Long = paramArrayOfByte.uint64_from_uin.get();
              localldv.jdField_d_of_type_Int = paramArrayOfByte.uint32_new_business_flag.get();
              localldv.jdField_a_of_type_Boolean = paramArrayOfByte.bool_terminal_switch_flag.get();
              if (paramArrayOfByte.msg_temp_session.has())
              {
                paramArrayOfByte = paramArrayOfByte.msg_temp_session;
                localldv.jdField_d_of_type_Long = paramArrayOfByte.uint64_group_uin.get();
                localldv.e = paramArrayOfByte.uint32_relationship_type.get();
              }
            }
            QLog.d("VideoPackageUtils", 1, " --- parse video message " + localldv.toString());
            return localldv;
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("nearby.video.multiMsg", 2, " head not exist");
          continue;
        }
        int i = -1;
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.e("VideoPackageUtils", 1, " invalid format:" + paramArrayOfByte.toString());
        return localldv;
      }
    }
  }
  
  public static long b(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 8) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    int j;
    for (int i = 0;; i = j)
    {
      l2 = l1;
      if (i >= paramInt) {
        break;
      }
      l2 = paramArrayOfByte[i];
      j = i + 1;
      l1 = (l2 & 0xFF) << (paramInt - i - 1) * 8 | l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ldu
 * JD-Core Version:    0.7.0.1
 */