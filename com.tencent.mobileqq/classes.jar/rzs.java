import android.graphics.Bitmap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IEventListener;", "", "onCaptureImageFailed", "", "player", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "id", "", "errCode", "onCaptureImageSucceed", "width", "height", "bitmap", "Landroid/graphics/Bitmap;", "onCompletion", "onDownloadCallback", "downloadedSizeBytes", "", "totalSizeBytes", "info", "", "onError", "", "module", "errorType", "errorCode", "extraInfo", "onInfo", "what", "extra", "onSeekComplete", "onVideoPrepared", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface rzs
{
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(@NotNull rzt paramrzt);
  
  public abstract void a(@NotNull rzt paramrzt, int paramInt1, int paramInt2);
  
  public abstract void a(@NotNull rzt paramrzt, int paramInt1, int paramInt2, int paramInt3, @Nullable Bitmap paramBitmap);
  
  public abstract boolean a(@NotNull rzt paramrzt, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString);
  
  public abstract boolean a(@NotNull rzt paramrzt, int paramInt, @Nullable Object paramObject);
  
  public abstract void b(@NotNull rzt paramrzt);
  
  public abstract void c(@NotNull rzt paramrzt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzs
 * JD-Core Version:    0.7.0.1
 */