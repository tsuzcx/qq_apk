package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.PhotoCell;
import NS_QZONE_MQMSG.PostBar;
import NS_QZONE_MQMSG.PostBarBottom;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import cooperation.qzone.contentbox.RoundCornerImageView;
import cooperation.qzone.contentbox.UserListItemView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgNewGuideCardView
  extends RelativeLayout
{
  private static final int AVATAR_GAP;
  private static final int BKG_COLOR = Color.parseColor("#FFFFFF");
  private static final int BKG_COLOR_NIGHTMODE = Color.parseColor("#171717");
  private static final int CARD_RADIUS = ViewUtils.b(8.0F);
  private static final int PUBLISH_BUTTON_COLOR = Color.parseColor("#00CAFC");
  private static final int PUBLISH_BUTTON_COLOR_DARKMODE = Color.parseColor("#0071FF");
  private static final String TAG = "MsgNewGuideCardView";
  private static final int TEXT_COLOR;
  private static final int TEXT_COLOR_NIGHTMODE;
  private QQAppInterface app;
  private FrameLayout avatarLayoutLeft;
  private FrameLayout avatarLayoutRight;
  private RoundCornerImageView backgroundCom;
  private ImageView closeBtn;
  private TextView dateCom;
  private RelativeLayout doubleAvatarCom;
  private TextView firstAvatarText;
  private FrameLayout firstLineAvatar;
  private RelativeLayout firstLineCom;
  private FrameLayout firstLineIcon;
  private TextView firstLineText;
  private boolean isNightMode;
  private RoundCornerImageView leftImageCom;
  private Context mContext;
  private MQMsg message;
  private MsgOnClickListener msgOnClickListener;
  private RelativeLayout pubBtnCom;
  private TextView pubBtnText;
  private TextView secondLineCom;
  private FrameLayout singleAvatarCom;
  
  static
  {
    AVATAR_GAP = ViewUtils.b(12.0F);
    TEXT_COLOR = Color.parseColor("#000000");
    TEXT_COLOR_NIGHTMODE = Color.parseColor("#FFFFFF");
  }
  
  public MsgNewGuideCardView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    LayoutInflater.from(this.mContext).inflate(2131562388, this);
    this.dateCom = ((TextView)findViewById(2131365414));
    this.backgroundCom = ((RoundCornerImageView)findViewById(2131363355));
    this.leftImageCom = ((RoundCornerImageView)findViewById(2131369954));
    this.singleAvatarCom = ((FrameLayout)findViewById(2131377620));
    this.doubleAvatarCom = ((RelativeLayout)findViewById(2131365815));
    this.firstLineCom = ((RelativeLayout)findViewById(2131366874));
    this.secondLineCom = ((TextView)findViewById(2131377107));
    this.avatarLayoutLeft = ((FrameLayout)findViewById(2131366867));
    this.avatarLayoutRight = ((FrameLayout)findViewById(2131377101));
    this.firstLineIcon = ((FrameLayout)findViewById(2131366875));
    this.firstLineAvatar = ((FrameLayout)findViewById(2131366873));
    this.firstLineText = ((TextView)findViewById(2131366876));
    this.firstAvatarText = ((TextView)findViewById(2131366862));
    this.pubBtnCom = ((RelativeLayout)findViewById(2131373239));
    this.pubBtnText = ((TextView)findViewById(2131373240));
    this.closeBtn = ((ImageView)findViewById(2131364716));
    this.isNightMode = false;
  }
  
  private void initAvatarListArea(List<String> paramList, FrameLayout paramFrameLayout)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramFrameLayout == null) {
        return;
      }
      paramFrameLayout.removeAllViews();
      int j = paramList.size();
      int k = Math.min(3, j);
      int i = 0;
      while (i < k)
      {
        Object localObject = this.mContext;
        boolean bool2 = this.isNightMode;
        boolean bool1 = true;
        localObject = new UserListItemView((Context)localObject, 2, bool2, true);
        ((UserListItemView)localObject).setUin((String)paramList.get(i));
        ((UserListItemView)localObject).setTranslationX(AVATAR_GAP * i);
        if ((i != 2) || (j <= 3)) {
          bool1 = false;
        }
        ((UserListItemView)localObject).showCover(bool1);
        paramFrameLayout.addView((View)localObject, i);
        i += 1;
      }
    }
  }
  
  private void initBkgRegion(MQMsg paramMQMsg)
  {
    paramMQMsg = this.backgroundCom;
    int i = CARD_RADIUS;
    paramMQMsg.setCorner(i, i, i, i);
    this.backgroundCom.setVisibility(0);
    if (!this.isNightMode)
    {
      this.backgroundCom.setBackgroundColor(BKG_COLOR);
      return;
    }
    this.backgroundCom.setBackgroundColor(BKG_COLOR_NIGHTMODE);
  }
  
  private void initCardLeftRegion(MQMsg paramMQMsg)
  {
    if (paramMQMsg != null)
    {
      if (paramMQMsg.postGuide == null) {
        return;
      }
      paramMQMsg = paramMQMsg.postGuide;
      Object localObject;
      if ((paramMQMsg.vecImage != null) && (paramMQMsg.vecImage.size() > 0))
      {
        this.leftImageCom.setImageDrawable(getUrlDrawable(((PhotoCell)paramMQMsg.vecImage.get(0)).coverUrl));
        localObject = this.leftImageCom;
        int i = CARD_RADIUS;
        ((RoundCornerImageView)localObject).setCorner(i, i, i, i);
        this.leftImageCom.setVisibility(0);
      }
      else
      {
        this.leftImageCom.setVisibility(8);
      }
      if ((paramMQMsg.userAvatar != null) && (paramMQMsg.userAvatar.size() == 1))
      {
        localObject = new UserListItemView(this.mContext, 0, false, true);
        ((UserListItemView)localObject).setUin((String)paramMQMsg.userAvatar.get(0));
        ((UserListItemView)localObject).showCover(false);
        this.singleAvatarCom.removeAllViews();
        this.singleAvatarCom.addView((View)localObject);
        this.singleAvatarCom.setVisibility(0);
      }
      else
      {
        this.singleAvatarCom.setVisibility(8);
      }
      if ((paramMQMsg.userAvatar != null) && (paramMQMsg.userAvatar.size() == 2))
      {
        localObject = new UserListItemView(this.mContext, 1, false, true);
        ((UserListItemView)localObject).setUin((String)paramMQMsg.userAvatar.get(0));
        ((UserListItemView)localObject).showCover(false);
        UserListItemView localUserListItemView = new UserListItemView(this.mContext, 1, false, true);
        localUserListItemView.setUin((String)paramMQMsg.userAvatar.get(1));
        localUserListItemView.showCover(false);
        this.avatarLayoutLeft.removeAllViews();
        this.avatarLayoutRight.removeAllViews();
        this.avatarLayoutLeft.addView((View)localObject);
        this.avatarLayoutRight.addView(localUserListItemView);
        this.doubleAvatarCom.setVisibility(0);
        return;
      }
      this.doubleAvatarCom.setVisibility(8);
    }
  }
  
  private void initCardRightRegion(MQMsg paramMQMsg)
  {
    if (paramMQMsg != null)
    {
      if (paramMQMsg.postGuide == null) {
        return;
      }
      paramMQMsg = paramMQMsg.postGuide;
      if (!TextUtils.isEmpty(paramMQMsg.title))
      {
        int i;
        if (!TextUtils.isEmpty(paramMQMsg.icon))
        {
          i = ViewUtils.b(20.0F);
          URLImageView localURLImageView = new URLImageView(this.mContext);
          localURLImageView.setImageDrawable(getUrlDrawable(paramMQMsg.icon));
          FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
          this.firstLineIcon.removeAllViews();
          this.firstLineIcon.addView(localURLImageView, localLayoutParams);
          this.firstLineIcon.setVisibility(0);
          this.firstLineText.setText(paramMQMsg.title);
          setTextColor(this.firstLineText);
          this.firstLineText.setVisibility(0);
          i = 1;
        }
        else
        {
          this.firstLineIcon.setVisibility(8);
          this.firstLineText.setVisibility(8);
          i = 0;
        }
        if ((i == 0) && (paramMQMsg.userAvatar != null) && (paramMQMsg.userAvatar.size() > 2))
        {
          initAvatarListArea(paramMQMsg.userAvatar, this.firstLineAvatar);
          this.firstLineAvatar.setVisibility(0);
          this.firstAvatarText.setText(paramMQMsg.title);
          setTextColor(this.firstAvatarText);
          this.firstAvatarText.setVisibility(0);
          i = 1;
        }
        else
        {
          this.firstLineAvatar.setVisibility(8);
          this.firstAvatarText.setVisibility(8);
        }
        if (i == 0)
        {
          this.firstLineText.setText(paramMQMsg.title);
          setTextColor(this.firstLineText);
          this.firstLineText.setVisibility(0);
        }
        this.firstLineCom.setVisibility(0);
      }
      else
      {
        this.firstLineCom.setVisibility(8);
      }
      if (!TextUtils.isEmpty(paramMQMsg.summary))
      {
        this.secondLineCom.setText(paramMQMsg.summary);
        setTextColor(this.secondLineCom);
        this.secondLineCom.setVisibility(0);
      }
      else
      {
        this.secondLineCom.setVisibility(8);
      }
      if ((paramMQMsg.bottom != null) && (!TextUtils.isEmpty(paramMQMsg.bottom.content)))
      {
        this.pubBtnText.setText(paramMQMsg.bottom.content);
        paramMQMsg = ContextCompat.getDrawable(this.mContext, 2130848751);
        if (paramMQMsg != null) {
          if (!this.isNightMode) {
            paramMQMsg.setColorFilter(PUBLISH_BUTTON_COLOR, PorterDuff.Mode.SRC_ATOP);
          } else {
            paramMQMsg.setColorFilter(PUBLISH_BUTTON_COLOR_DARKMODE, PorterDuff.Mode.SRC_ATOP);
          }
        }
        this.pubBtnCom.setBackgroundDrawable(paramMQMsg);
        this.pubBtnCom.setVisibility(0);
      }
      else
      {
        this.pubBtnCom.setVisibility(8);
      }
      if (!this.isNightMode)
      {
        this.closeBtn.setBackgroundResource(2130848759);
        return;
      }
      this.closeBtn.setBackgroundResource(2130848760);
    }
  }
  
  private void setTextColor(TextView paramTextView)
  {
    if (paramTextView == null) {
      return;
    }
    if (!this.isNightMode)
    {
      paramTextView.setTextColor(TEXT_COLOR);
      return;
    }
    paramTextView.setTextColor(TEXT_COLOR_NIGHTMODE);
  }
  
  protected URLDrawable getUrlDrawable(String paramString)
  {
    return URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
  }
  
  public void initDateRegion(MQMsg paramMQMsg, int paramInt)
  {
    this.isNightMode = ThemeUtil.isNowThemeIsNight(this.app, false, null);
    if (paramInt == 0)
    {
      String str = new SimpleDateFormat("MM月dd日").format(new Date(paramMQMsg.pushTime * 1000L));
      paramMQMsg = str;
      if (str.startsWith("0")) {
        paramMQMsg = str.substring(1);
      }
      this.dateCom.setText(paramMQMsg);
      setTextColor(this.dateCom);
      this.dateCom.setVisibility(0);
      return;
    }
    this.dateCom.setVisibility(8);
  }
  
  public void setData(MQMsg paramMQMsg)
  {
    this.isNightMode = ThemeUtil.isNowThemeIsNight(this.app, false, null);
    initBkgRegion(paramMQMsg);
    initCardLeftRegion(paramMQMsg);
    initCardRightRegion(paramMQMsg);
    this.message = paramMQMsg;
  }
  
  public void setMsgOnClickListener(MsgOnClickListener paramMsgOnClickListener)
  {
    if (paramMsgOnClickListener == null) {
      return;
    }
    this.msgOnClickListener = paramMsgOnClickListener;
    this.closeBtn.setOnClickListener(new MsgNewGuideCardView.1(this, paramMsgOnClickListener));
    this.pubBtnCom.setOnClickListener(new MsgNewGuideCardView.2(this, paramMsgOnClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MsgNewGuideCardView
 * JD-Core Version:    0.7.0.1
 */