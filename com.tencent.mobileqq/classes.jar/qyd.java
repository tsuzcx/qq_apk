import cooperation.liveroom.LiveRoomGiftCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "type", "", "args", "", "onCall"}, k=3, mv={1, 1, 16})
final class qyd
  implements LiveRoomGiftCallback
{
  qyd(qyb paramqyb) {}
  
  public final void onCall(int paramInt, @Nullable String paramString)
  {
    if (paramInt == 7)
    {
      qyb.a(this.a);
      qyb.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyd
 * JD-Core Version:    0.7.0.1
 */