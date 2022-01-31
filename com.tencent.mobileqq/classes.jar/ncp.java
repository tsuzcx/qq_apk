import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;

public final class ncp
  implements Parcelable.Creator
{
  public MsgTabNodeInfo a(Parcel paramParcel)
  {
    MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
    localMsgTabNodeInfo.a(paramParcel);
    return localMsgTabNodeInfo;
  }
  
  public MsgTabNodeInfo[] a(int paramInt)
  {
    return new MsgTabNodeInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncp
 * JD-Core Version:    0.7.0.1
 */