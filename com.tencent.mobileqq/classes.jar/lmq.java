import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.av.chatroom.ChatRoomInfo;

public final class lmq
  implements Parcelable.Creator<ChatRoomInfo>
{
  public ChatRoomInfo a(Parcel paramParcel)
  {
    return new ChatRoomInfo(paramParcel);
  }
  
  public ChatRoomInfo[] a(int paramInt)
  {
    return new ChatRoomInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lmq
 * JD-Core Version:    0.7.0.1
 */