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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
    LayoutInflater.from(this.mContext).inflate(2131562566, this);
    this.dateCom = ((TextView)findViewById(2131365571));
    this.backgroundCom = ((RoundCornerImageView)findViewById(2131363428));
    this.leftImageCom = ((RoundCornerImageView)findViewById(2131370286));
    this.singleAvatarCom = ((FrameLayout)findViewById(2131378205));
    this.doubleAvatarCom = ((RelativeLayout)findViewById(2131365978));
    this.firstLineCom = ((RelativeLayout)findViewById(2131367023));
    this.secondLineCom = ((TextView)findViewById(2131377670));
    this.avatarLayoutLeft = ((FrameLayout)findViewById(2131367014));
    this.avatarLayoutRight = ((FrameLayout)findViewById(2131377661));
    this.firstLineIcon = ((FrameLayout)findViewById(2131367024));
    this.firstLineAvatar = ((FrameLayout)findViewById(2131367022));
    this.firstLineText = ((TextView)findViewById(2131367025));
    this.firstAvatarText = ((TextView)findViewById(2131367009));
    this.pubBtnCom = ((RelativeLayout)findViewById(2131373666));
    this.pubBtnText = ((TextView)findViewById(2131373667));
    this.closeBtn = ((ImageView)findViewById(2131364829));
    this.isNightMode = false;
  }
  
  private void initAvatarListArea(List<String> paramList, FrameLayout paramFrameLayout)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramFrameLayout == null)) {
      return;
    }
    paramFrameLayout.removeAllViews();
    int j = paramList.size();
    int k = Math.min(3, j);
    int i = 0;
    label40:
    UserListItemView localUserListItemView;
    if (i < k)
    {
      localUserListItemView = new UserListItemView(this.mContext, 2, this.isNightMode, true);
      localUserListItemView.setUin((String)paramList.get(i));
      localUserListItemView.setTranslationX(AVATAR_GAP * i);
      if ((i != 2) || (j <= 3)) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      localUserListItemView.showCover(bool);
      paramFrameLayout.addView(localUserListItemView, i);
      i += 1;
      break label40;
      break;
    }
  }
  
  private void initBkgRegion(MQMsg paramMQMsg)
  {
    this.backgroundCom.setCorner(CARD_RADIUS, CARD_RADIUS, CARD_RADIUS, CARD_RADIUS);
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
    if ((paramMQMsg == null) || (paramMQMsg.postGuide == null)) {
      return;
    }
    paramMQMsg = paramMQMsg.postGuide;
    UserListItemView localUserListItemView1;
    if ((paramMQMsg.vecImage != null) && (paramMQMsg.vecImage.size() > 0))
    {
      this.leftImageCom.setImageDrawable(getUrlDrawable(((PhotoCell)paramMQMsg.vecImage.get(0)).coverUrl));
      this.leftImageCom.setCorner(CARD_RADIUS, CARD_RADIUS, CARD_RADIUS, CARD_RADIUS);
      this.leftImageCom.setVisibility(0);
      if ((paramMQMsg.userAvatar == null) || (paramMQMsg.userAvatar.size() != 1)) {
        break label301;
      }
      localUserListItemView1 = new UserListItemView(this.mContext, 0, false, true);
      localUserListItemView1.setUin((String)paramMQMsg.userAvatar.get(0));
      localUserListItemView1.showCover(false);
      this.singleAvatarCom.removeAllViews();
      this.singleAvatarCom.addView(localUserListItemView1);
      this.singleAvatarCom.setVisibility(0);
    }
    for (;;)
    {
      if ((paramMQMsg.userAvatar == null) || (paramMQMsg.userAvatar.size() != 2)) {
        break label313;
      }
      localUserListItemView1 = new UserListItemView(this.mContext, 1, false, true);
      localUserListItemView1.setUin((String)paramMQMsg.userAvatar.get(0));
      localUserListItemView1.showCover(false);
      UserListItemView localUserListItemView2 = new UserListItemView(this.mContext, 1, false, true);
      localUserListItemView2.setUin((String)paramMQMsg.userAvatar.get(1));
      localUserListItemView2.showCover(false);
      this.avatarLayoutLeft.removeAllViews();
      this.avatarLayoutRight.removeAllViews();
      this.avatarLayoutLeft.addView(localUserListItemView1);
      this.avatarLayoutRight.addView(localUserListItemView2);
      this.doubleAvatarCom.setVisibility(0);
      return;
      this.leftImageCom.setVisibility(8);
      break;
      label301:
      this.singleAvatarCom.setVisibility(8);
    }
    label313:
    this.doubleAvatarCom.setVisibility(8);
  }
  
  private void initCardRightRegion(MQMsg paramMQMsg)
  {
    int j = 1;
    if ((paramMQMsg == null) || (paramMQMsg.postGuide == null)) {
      return;
    }
    paramMQMsg = paramMQMsg.postGuide;
    int i;
    if (!TextUtils.isEmpty(paramMQMsg.title)) {
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
        if ((i != 0) || (paramMQMsg.userAvatar == null) || (paramMQMsg.userAvatar.size() <= 2)) {
          break label408;
        }
        initAvatarListArea(paramMQMsg.userAvatar, this.firstLineAvatar);
        this.firstLineAvatar.setVisibility(0);
        this.firstAvatarText.setText(paramMQMsg.title);
        setTextColor(this.firstAvatarText);
        this.firstAvatarText.setVisibility(0);
        i = j;
        label209:
        if (i == 0)
        {
          this.firstLineText.setText(paramMQMsg.title);
          setTextColor(this.firstLineText);
          this.firstLineText.setVisibility(0);
        }
        this.firstLineCom.setVisibility(0);
        label248:
        if (TextUtils.isEmpty(paramMQMsg.summary)) {
          break label441;
        }
        this.secondLineCom.setText(paramMQMsg.summary);
        setTextColor(this.secondLineCom);
        this.secondLineCom.setVisibility(0);
        label285:
        if ((paramMQMsg.bottom == null) || (TextUtils.isEmpty(paramMQMsg.bottom.content))) {
          break label466;
        }
        this.pubBtnText.setText(paramMQMsg.bottom.content);
        paramMQMsg = ContextCompat.getDrawable(this.mContext, 2130848871);
        if (paramMQMsg != null)
        {
          if (this.isNightMode) {
            break label453;
          }
          paramMQMsg.setColorFilter(PUBLISH_BUTTON_COLOR, PorterDuff.Mode.SRC_ATOP);
        }
        label351:
        this.pubBtnCom.setBackgroundDrawable(paramMQMsg);
        this.pubBtnCom.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.isNightMode) {
        break label478;
      }
      this.closeBtn.setBackgroundResource(2130848879);
      return;
      this.firstLineIcon.setVisibility(8);
      this.firstLineText.setVisibility(8);
      i = 0;
      break;
      label408:
      this.firstLineAvatar.setVisibility(8);
      this.firstAvatarText.setVisibility(8);
      break label209;
      this.firstLineCom.setVisibility(8);
      break label248;
      label441:
      this.secondLineCom.setVisibility(8);
      break label285;
      label453:
      paramMQMsg.setColorFilter(PUBLISH_BUTTON_COLOR_DARKMODE, PorterDuff.Mode.SRC_ATOP);
      break label351;
      label466:
      this.pubBtnCom.setVisibility(8);
    }
    label478:
    this.closeBtn.setBackgroundResource(2130848880);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MsgNewGuideCardView
 * JD-Core Version:    0.7.0.1
 */