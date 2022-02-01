import android.text.TextUtils;
import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.av.chatroom.chatroom_sso.Msg;

public class ljq
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private static long e;
  public final long a;
  public ChatRoomInfo a;
  public final String a;
  public final long b;
  public long c;
  public long d;
  public int e;
  private int f;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
    jdField_d_of_type_Int = 4;
  }
  
  public ljq(ChatRoomInfo paramChatRoomInfo, long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt)
  {
    this.jdField_b_of_type_Long = a();
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo = paramChatRoomInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Long = paramLong2;
    this.jdField_d_of_type_Long = paramLong3;
    this.jdField_e_of_type_Int = paramInt;
    if (this.jdField_e_of_type_Int == jdField_a_of_type_Int)
    {
      paramChatRoomInfo = this.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo;
      paramChatRoomInfo.jdField_b_of_type_Int += 1;
    }
    this.f = 0;
  }
  
  private static long a()
  {
    long l = jdField_e_of_type_Long + 1L;
    jdField_e_of_type_Long = l;
    return l;
  }
  
  public void a()
  {
    this.f += 1;
  }
  
  public void a(int paramInt)
  {
    ChatRoomInfo localChatRoomInfo;
    if (paramInt == jdField_c_of_type_Int)
    {
      localChatRoomInfo = this.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo;
      localChatRoomInfo.jdField_d_of_type_Int += 1;
    }
    for (;;)
    {
      if ((this.jdField_d_of_type_Long == -9223372036854775808L) || (this.jdField_e_of_type_Int != jdField_d_of_type_Int)) {
        this.jdField_e_of_type_Int = paramInt;
      }
      return;
      if (paramInt == jdField_b_of_type_Int)
      {
        localChatRoomInfo = this.jdField_a_of_type_ComTencentAvChatroomChatRoomInfo;
        localChatRoomInfo.jdField_c_of_type_Int += 1;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Long != -9223372036854775808L;
  }
  
  public boolean a(chatroom_sso.Msg paramMsg)
  {
    if (paramMsg == null) {}
    while ((this.jdField_d_of_type_Long != paramMsg.msg_id.get()) || (this.jdField_a_of_type_Long != paramMsg.uin.get()) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramMsg.msg.get()))) {
      return false;
    }
    return true;
  }
  
  public boolean b()
  {
    return (this.jdField_e_of_type_Int == jdField_b_of_type_Int) && (this.f < 3) && (this.jdField_d_of_type_Long == -9223372036854775808L);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(60);
    localStringBuilder.append("ChatRoomMsg{senderUin: ").append(this.jdField_a_of_type_Long).append(", serverSeq: ").append(this.jdField_d_of_type_Long).append(", localSeq: ").append(this.jdField_b_of_type_Long).append(", state: ").append(this.jdField_e_of_type_Int).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljq
 * JD-Core Version:    0.7.0.1
 */