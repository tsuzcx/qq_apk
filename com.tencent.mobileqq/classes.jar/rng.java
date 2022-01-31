import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import java.util.ArrayList;

public abstract interface rng
{
  @Nullable
  public abstract VideoInfo a();
  
  public abstract VideoFeedsPlayManager a();
  
  public abstract ArrayList<VideoInfo> a();
  
  public abstract rac a();
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(VideoInfo paramVideoInfo, int paramInt1, int paramInt2);
  
  public abstract void a(VideoFeedsRecyclerView paramVideoFeedsRecyclerView, rmn paramrmn, View paramView);
  
  public abstract void a(rne paramrne);
  
  public abstract boolean a(int paramInt, KeyEvent paramKeyEvent);
  
  public abstract boolean a(rmr paramrmr);
  
  public abstract boolean a(rne paramrne);
  
  public abstract boolean a(boolean paramBoolean);
  
  public abstract void b(VideoInfo paramVideoInfo);
  
  public abstract void c();
  
  public abstract void c(VideoInfo paramVideoInfo);
  
  public abstract void d();
  
  public abstract void d(VideoInfo paramVideoInfo);
  
  public abstract void e();
  
  public abstract void e(VideoInfo paramVideoInfo);
  
  public abstract void f(VideoInfo paramVideoInfo);
  
  public abstract void h();
  
  public abstract void i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rng
 * JD-Core Version:    0.7.0.1
 */