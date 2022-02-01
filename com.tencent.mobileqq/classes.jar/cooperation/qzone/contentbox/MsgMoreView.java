package cooperation.qzone.contentbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import java.util.ArrayList;

public class MsgMoreView
  extends FrameLayout
{
  private static final int AVATAR_GAP = ViewUtils.dpToPx(24.0F);
  private FrameLayout mAvatarListLayout;
  private Context mContext;
  private MQMsg mData;
  private MsgOnClickListener msgOnClickListener;
  
  public MsgMoreView(@NonNull Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public MsgMoreView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MsgMoreView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131562352, this);
    this.mAvatarListLayout = ((FrameLayout)findViewById(2131363151));
    setOnClickListener(new MsgMoreView.1(this));
  }
  
  public void setData(MQMsg paramMQMsg, boolean paramBoolean)
  {
    int j = 0;
    this.mData = paramMQMsg;
    paramMQMsg = paramMQMsg.bottomCell;
    if (paramMQMsg.userAvatar != null)
    {
      this.mAvatarListLayout.setVisibility(0);
      this.mAvatarListLayout.removeAllViews();
      int i;
      if (5 < paramMQMsg.userAvatar.size()) {
        i = 5;
      }
      while (j < i)
      {
        UserListItemView localUserListItemView = new UserListItemView(this.mContext, 1);
        localUserListItemView.setUin((String)paramMQMsg.userAvatar.get(j));
        localUserListItemView.setTranslationX(AVATAR_GAP * j);
        if ((j == i - 1) && (paramMQMsg.total - i > 0)) {
          localUserListItemView.showCover(true);
        }
        this.mAvatarListLayout.addView(localUserListItemView, j);
        j += 1;
        continue;
        i = paramMQMsg.userAvatar.size();
      }
    }
    if (paramBoolean) {
      ((TextView)findViewById(2131371396)).setTextColor(-7500397);
    }
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    this.msgOnClickListener = paramMsgOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgMoreView
 * JD-Core Version:    0.7.0.1
 */