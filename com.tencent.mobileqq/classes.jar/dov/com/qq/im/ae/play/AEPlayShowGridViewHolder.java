package dov.com.qq.im.ae.play;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import bmws;
import bnke;
import bnrh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasApngUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class AEPlayShowGridViewHolder
  extends RecyclerView.ViewHolder
  implements URLDrawable.URLDrawableListener2, IProgressObserver
{
  private static final String APNG_BASE_PATH;
  private static final Map<String, WeakReference<URLDrawable>> APNG_CACHE;
  private static final String APNG_DIR_NAME = "play_show_apng";
  private static final Drawable APNG_LOADING_DRAWABLE = getAppContext().getResources().getDrawable(2130837685);
  private final String TAG = "AEPlayShowGridViewHolder";
  private int layoutType;
  private URLDrawable mApngUrlDrawable;
  private String mId = "";
  private AEPlayShowGridViewHolder.ItemClickCallback mItemClickCallback;
  private String mPlayImageUrl = "";
  bnke mPlayMaterial;
  private View mPlayShowBottomShadow;
  private ImageView mPlayShowImage;
  private View mPlayShowInfoContainer;
  private ProgressBar mPlayShowProgressBar;
  private TextView mPlayShowText;
  private String mPlayText = "";
  private int mPosition = -1;
  
  static
  {
    APNG_CACHE = new HashMap();
    File localFile = new File(bmws.a, "play_show_apng");
    APNG_BASE_PATH = localFile.getPath();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public AEPlayShowGridViewHolder(View paramView, AEPlayShowGridAdapter.SizeInfo paramSizeInfo, AEPlayShowGridViewHolder.ItemClickCallback paramItemClickCallback, int paramInt)
  {
    super(paramView);
    this.layoutType = paramInt;
    if (paramInt == 1) {
      paramView.post(new AEPlayShowGridViewHolder.1(this, paramView));
    }
    this.mItemClickCallback = paramItemClickCallback;
    this.mPlayShowImage = ((ImageView)paramView.findViewById(2131362287));
    this.mPlayShowInfoContainer = paramView.findViewById(2131362288);
    this.mPlayShowText = ((TextView)paramView.findViewById(2131362291));
    this.mPlayShowProgressBar = ((ProgressBar)paramView.findViewById(2131362290));
    this.mPlayShowBottomShadow = paramView.findViewById(2131362289);
    paramItemClickCallback = paramView.getLayoutParams();
    paramItemClickCallback.width = paramSizeInfo.itemWidth;
    paramItemClickCallback.height = paramSizeInfo.itemHeight;
    paramView.setLayoutParams(paramItemClickCallback);
    paramView.setOnClickListener(new AEPlayShowGridViewHolder.2(this));
  }
  
  private void bindContent(@NonNull bnke parambnke)
  {
    this.mId = parambnke.a;
    if (TextUtils.isEmpty(parambnke.m)) {}
    for (String str = "";; str = parambnke.m)
    {
      this.mPlayText = str;
      this.mPlayImageUrl = parambnke.l;
      parambnke = APNG_BASE_PATH + File.separator + this.mPlayImageUrl.hashCode() + "_" + this.mId.hashCode() + ".png";
      showTemplateInfoViews();
      this.mApngUrlDrawable = getApngDrawable(parambnke, this.mPlayImageUrl);
      if (this.mApngUrlDrawable != null)
      {
        this.mApngUrlDrawable.setURLDrawableListener(this);
        this.mPlayShowImage.setImageDrawable(this.mApngUrlDrawable);
      }
      return;
    }
  }
  
  public static void clearApngCache()
  {
    APNG_CACHE.clear();
  }
  
  private URLDrawable getApngDrawable(@NonNull String paramString1, @NonNull String paramString2)
  {
    return VasApngUtil.getApngDrawable(paramString1, paramString2, APNG_LOADING_DRAWABLE, null, "-GY-PLAY-SHOW-", null);
  }
  
  private static Context getAppContext()
  {
    return BaseApplicationImpl.getApplication();
  }
  
  private void showTemplateInfoViews()
  {
    this.mPlayShowInfoContainer.setVisibility(0);
    if (this.layoutType != 1) {
      this.mPlayShowBottomShadow.setVisibility(0);
    }
    this.mPlayShowText.setText(this.mPlayText);
  }
  
  public void bind(@NonNull bnke parambnke, int paramInt)
  {
    this.mPlayMaterial = parambnke;
    this.mPosition = paramInt;
    if (this.mApngUrlDrawable != null) {
      this.mApngUrlDrawable.setURLDrawableListener(null);
    }
    bindContent(parambnke);
    this.mPlayShowProgressBar.setVisibility(8);
  }
  
  public void onDownloadFinish(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!paramString.equals(this.mPlayMaterial.a))) {
      return;
    }
    bnrh.b("AEPlayShowGridViewHolder", "【Play Item】onDownloadFinish id:" + paramString);
    bnrh.b("AEPlayShowGridViewHolder", "【Play Item】onDownloadFinish isSuccess:" + paramBoolean);
    ThreadManager.getUIHandler().post(new AEPlayShowGridViewHolder.4(this, paramBoolean));
  }
  
  public void onDownloadStart()
  {
    this.mPlayShowProgressBar.setVisibility(0);
    this.mPlayShowProgressBar.setProgress(0);
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    showTemplateInfoViews();
  }
  
  public void onProgressUpdate(String paramString, int paramInt)
  {
    if ((paramString == null) || (!paramString.equals(this.mPlayMaterial.a))) {
      return;
    }
    ThreadManager.getUIHandler().post(new AEPlayShowGridViewHolder.3(this, paramInt));
  }
  
  public void resetProgress()
  {
    this.mPlayShowProgressBar.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowGridViewHolder
 * JD-Core Version:    0.7.0.1
 */