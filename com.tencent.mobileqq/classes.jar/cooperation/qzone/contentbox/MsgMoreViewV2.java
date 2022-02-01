package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MsgOnClickListener;
import java.util.ArrayList;

public class MsgMoreViewV2
  extends FrameLayout
{
  private static final int AVATAR_GAP = ViewUtils.dpToPx(14.0F);
  private QQAppInterface mApp;
  private ImageView mArrow;
  private FrameLayout mAvatarListLayout;
  private Context mContext;
  private TextView mText;
  private MsgOnClickListener msgOnClickListener;
  
  public MsgMoreViewV2(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public MsgMoreViewV2(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public MsgMoreViewV2(@NonNull Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    init(paramContext);
    this.mApp = paramQQAppInterface;
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2080636937, this);
    this.mAvatarListLayout = ((FrameLayout)findViewById(2080571403));
    this.mText = ((TextView)findViewById(2080571467));
    this.mArrow = ((ImageView)findViewById(2080571396));
  }
  
  public void setData(MQMsg paramMQMsg, boolean paramBoolean)
  {
    paramMQMsg = paramMQMsg.bottomCell;
    if (paramMQMsg.userAvatar != null)
    {
      this.mAvatarListLayout.setVisibility(0);
      this.mAvatarListLayout.removeAllViews();
      int i = 5;
      if (5 >= paramMQMsg.userAvatar.size()) {
        i = paramMQMsg.userAvatar.size();
      }
      int j = 0;
      while (j < i)
      {
        UserListItemView localUserListItemView = new UserListItemView(this.mContext, 2, paramBoolean, false);
        localUserListItemView.setUin((String)paramMQMsg.userAvatar.get(j));
        localUserListItemView.setTranslationX(AVATAR_GAP * j);
        this.mAvatarListLayout.addView(localUserListItemView, j);
        j += 1;
      }
    }
    if (paramBoolean)
    {
      this.mText.setTextColor(-1);
      this.mArrow.setImageDrawable(getResources().getDrawable(2130845131));
    }
    if (!TextUtils.isEmpty(paramMQMsg.content)) {
      this.mText.setText(paramMQMsg.content);
    }
    if (!TextUtils.isEmpty(paramMQMsg.jumpUrl)) {
      setOnClickListener(new MsgMoreViewV2.1(this, paramMQMsg));
    }
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    this.msgOnClickListener = paramMsgOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgMoreViewV2
 * JD-Core Version:    0.7.0.1
 */