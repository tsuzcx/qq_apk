package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import mqq.os.MqqHandler;

public class UserListItemView
  extends FrameLayout
{
  public static final int TYPE_NORMAL = 0;
  public static final int TYPE_SMALL = 1;
  public static final int TYPE_SMALLER = 2;
  private boolean isNewStyle;
  private RelativeLayout mAvatarCover;
  private ImageView mAvatarView;
  private Context mContext;
  private Handler mUiHandler;
  
  public UserListItemView(@NonNull Context paramContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    this.isNewStyle = paramBoolean2;
    init(paramContext, paramInt, paramBoolean1);
  }
  
  private void init(Context paramContext, int paramInt, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mUiHandler = new Handler(Looper.getMainLooper());
    ViewGroup.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      LayoutInflater.from(paramContext).inflate(2131562573, this);
      this.mAvatarView = ((ImageView)findViewById(2131363215));
      this.mAvatarCover = ((RelativeLayout)findViewById(2131363213));
      if (this.isNewStyle)
      {
        paramContext = (ImageView)findViewById(2131363211);
        localLayoutParams = paramContext.getLayoutParams();
        if (paramInt != 0) {
          break label202;
        }
        localLayoutParams.height = ViewUtils.b(42.0F);
        localLayoutParams.width = ViewUtils.b(42.0F);
      }
    }
    for (;;)
    {
      paramContext.setLayoutParams(localLayoutParams);
      if (paramBoolean)
      {
        if (this.isNewStyle) {
          ((GradientDrawable)getResources().getDrawable(2130848849)).setColor(Color.parseColor("#B2FFFFFF"));
        }
        ((ImageView)findViewById(2131363211)).setImageDrawable(getResources().getDrawable(2130848849));
      }
      return;
      if (paramInt == 1)
      {
        LayoutInflater.from(paramContext).inflate(2131562574, this);
        break;
      }
      LayoutInflater.from(paramContext).inflate(2131562575, this);
      break;
      label202:
      if (paramInt == 1)
      {
        localLayoutParams.height = ViewUtils.b(34.0F);
        localLayoutParams.width = ViewUtils.b(34.0F);
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
      if (this.isNewStyle)
      {
        GradientDrawable localGradientDrawable = (GradientDrawable)getResources().getDrawable(2130848850);
        localGradientDrawable.setColor(Color.parseColor("#B2FFFFFF"));
        this.mAvatarCover.setBackgroundDrawable(localGradientDrawable);
      }
      this.mAvatarCover.setVisibility(0);
      return;
    }
    this.mAvatarCover.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.UserListItemView
 * JD-Core Version:    0.7.0.1
 */