package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class UserListItemView
  extends FrameLayout
{
  public static final int TYPE_NORMAL = 0;
  public static final int TYPE_SMALL = 1;
  public static final int TYPE_SMALLER = 2;
  private RelativeLayout mAvatarCover;
  private ImageView mAvatarView;
  private Context mContext;
  private Handler mUiHandler;
  
  public UserListItemView(@NonNull Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    init(paramContext, paramInt, paramBoolean);
  }
  
  private void init(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mUiHandler = new Handler(Looper.getMainLooper());
    if (paramInt == 0) {
      LayoutInflater.from(paramContext).inflate(2131562430, this);
    }
    for (;;)
    {
      this.mAvatarView = ((ImageView)findViewById(2131363164));
      this.mAvatarCover = ((RelativeLayout)findViewById(2131363162));
      if (paramBoolean) {
        ((ImageView)findViewById(2131363160)).setImageDrawable(getResources().getDrawable(2130848490));
      }
      return;
      if (paramInt == 1) {
        LayoutInflater.from(paramContext).inflate(2131562431, this);
      } else {
        LayoutInflater.from(paramContext).inflate(2131562432, this);
      }
    }
  }
  
  public void setUin(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new UserListItemView.1(this, paramString));
  }
  
  public void showCover(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mAvatarCover.setVisibility(0);
      return;
    }
    this.mAvatarCover.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.UserListItemView
 * JD-Core Version:    0.7.0.1
 */