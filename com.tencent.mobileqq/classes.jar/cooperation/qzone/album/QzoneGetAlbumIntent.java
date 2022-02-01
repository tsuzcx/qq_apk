package cooperation.qzone.album;

import android.content.Context;
import java.lang.ref.WeakReference;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class QzoneGetAlbumIntent
  extends NewIntent
{
  public String albumId;
  public WeakReference<QzoneGetAlbumIntent.OnResultListener> listenerRef;
  public long ownerUin;
  public int type;
  
  public QzoneGetAlbumIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.album.QzoneGetAlbumIntent
 * JD-Core Version:    0.7.0.1
 */